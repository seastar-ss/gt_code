package com.shawn.ss.lib.code_gen.base.dao.common_dao.common_model_builder;

import com.helger.jcodemodel.*;
import com.shawn.ss.lib.code_gen.CodeBuilderInterface;
import com.shawn.ss.lib.code_gen.base.helper.CodeHelper;
import com.shawn.ss.lib.code_gen.base.helper.ModelBuilderContext;
import com.shawn.ss.lib.code_gen.model.def_model.dao_def.CommonModelDef;
//import com.shawn.ss.lib.code_gen.model.def_model.dao_def.EnumTypeConf;
import com.shawn.ss.lib.code_gen.model.def_model.dao_def.SpecialModelConf;
import com.shawn.ss.lib.tools.CodeStyleTransformHelper;
import com.shawn.ss.lib.tools.CollectionHelper;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.ColumnInfoInterface;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.TableInfoInterface;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model.EnumTypeDef;
//import com.shawn.ss.lib.tools.db.api.interfaces.mappers._ObjMapper;
import com.shawn.ss.lib.tools.db.api.interfaces.mappers.db.DbResultSetMapper;
import com.shawn.ss.lib.tools.db.api.interfaces.mappers.db.RedisMapMapper;
import com.shawn.ss.lib.tools.db.dto_base.model.AbstractBaseModel;
import com.shawn.ss.lib.tools.db.dto_base.model._ObjMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

public class ModelBuilder implements CodeBuilderInterface {

    public static final Logger L= LoggerFactory.getLogger(ModelBuilder.class);
    final static Pattern PATTERN_NUMBER_START=Pattern.compile("^\\d+.*");

    TableInfoInterface info;
    private final ModelBuilderContext builderContext;
    private final String baseTable;
    final Set<String> ignoreField;
    final String table;
    final String db;
    final List<ColumnInfoInterface> columns;
    final String modelClassName;
    final JCodeModel cm;
    final AbstractJClass extendedClazz;
    JDefinedClass definedClass;
    Map<String, JFieldVar> allModelFields;
    Map<String, JMethod> allGetFields;
    Map<String, JMethod> allSetFields;

//    Map<String,JDefinedClass> enumClzz;

    final boolean selectModel;
    private CommonModelDef modelDef;


//    public ModelBuilder(TableInfoInterface info,  ModelBuilderContext builderContext) {
//        this(info,builderContext,null,null);
//
//    }

    public ModelBuilder(CommonModelDef def) {
        this.modelDef = def;
        this.info = def.getDef();
        this.builderContext = def.getBuilderContext();
        this.baseTable = def.getBaseTable();
        Set<String> ignore = def.getIgnoreField();
        this.ignoreField = (ignore ==null? Collections.emptySet(): ignore);
        db = info.getDb();
        table = info.getTable();
        columns = info.getColumns();

        if (builderContext == null)
            throw new IllegalArgumentException("code build context is null");
//        else
        this.cm = builderContext.getCm();

        this.modelClassName =builderContext.getReallyModelClassName(table,baseTable);
        this.allModelFields = CollectionHelper.newMap();
        this.allGetFields = CollectionHelper.newMap();
        this.allSetFields = CollectionHelper.newMap();
        if(baseTable==null) {
            extendedClazz = cm.ref(AbstractBaseModel.class);
        }else{
//            this.selectModel = true;
            extendedClazz =cm.ref(builderContext.getReallyModelClassName(baseTable, null));
        }
        this.selectModel = (info.getTableType()==2);
//        enumClzz=CollectionHelper.newMap();
    }




    @Override
    public void buildModel() {
        try {
            L.info("build model:"+modelClassName);
            checkTableInfoForEnums();
            definedClass = cm._class(modelClassName);
            definedClass._extends(extendedClazz);

            definedClass.constructor(JMod.PUBLIC);
            buildComments();
//            if(!selectModel) {
            buildStaticFields();
//            }
            buildColFields();
            buildFieldTypeMap();
            buildIsEmptyMethod();
            buildFeatureMethod();
            buildToStringMethod();
            if(modelDef instanceof SpecialModelConf){
                SpecialModelConf sdef=(SpecialModelConf) modelDef;
                String sql = sdef.getSql();
                if(sql!=null){
                    buildSQLField(sql);
                }
            }
        } catch (JClassAlreadyExistsException e) {
            e.printStackTrace();
            throw new IllegalStateException("model state abnormal for "+modelClassName);
        }
    }

    private void buildToStringMethod() {
        CodeHelper.genToStringMethod(cm,definedClass,false);
    }

    private void checkTableInfoForEnums() {
        if (columns != null && columns.size() > 0) {
            for (ColumnInfoInterface item : columns) {
                EnumTypeDef enumTypeDef = item.getEnumTypeDef();
                if(enumTypeDef!=null && enumTypeDef.sizeOfItems()>0){
                    com.shawn.ss.lib.code_gen.model.def_model.dao_def.EnumTypeDef   conf=new com.shawn.ss.lib.code_gen.model.def_model.dao_def.EnumTypeDef(enumTypeDef).setTable(table);
                    conf.setBuilderContext(builderContext);
                    EnumBuilder builder=new EnumBuilder(conf);
                    builder.buildModel();
                    modelDef.putEnumClz(item.getFieldName(),builder.getDefinedClass());
                }
            }
        }
    }

    public void buildSQLField(String sql){
        definedClass.field(CodeHelper.MODE_PUBLIC_STATIC_FINAL, String.class, CodeHelper.FIELD_MODEL_RELATED_SQL, JExpr.lit(sql));
    }

    private void buildComments() {
        JDocComment jDocComment = definedClass.headerComment();
        jDocComment.addAuthor().append("shawn-ss's auto writer");
        jDocComment.append("don't modify , it is generate automatically, any modification will be lost after regeneration next time");
        JDocComment javadoc = definedClass.javadoc();
        javadoc.append("base DTO").append(",represent for table :").append(table);
        String tableComment = info.getTableComment();
        if(tableComment!=null){
            javadoc.append("\n\t").append(tableComment);
        }
    }

    private void buildColFields() {
        if (columns != null && columns.size() > 0) {
            for (ColumnInfoInterface item : columns) {
                buildFields(item);
            }
        }
    }

    private void buildFields(ColumnInfoInterface item) {
        String colName = item.getFieldName();
        if(!ignoreField.contains(colName) && colName.length()>0) {
            String comment = item.getComment();
//            FieldDataTypeInterface type = item.getType();
            AbstractJClass type = CodeHelper.getFieldDefType(cm, modelDef, item,builderContext);
//            final EnumTypeDef enumTypeDef = item.getEnumTypeDef();

            AbstractJClass jClass=type;

            String humpStyleColName = CodeStyleTransformHelper.underlineSplittedStyleToHumpStyle(colName);
            String fname;
            if(PATTERN_NUMBER_START.matcher(humpStyleColName).matches()) {
                fname = CodeHelper.FIELD_MODEL_FIELD_PREFIX + CodeStyleTransformHelper.upperFirstCase(humpStyleColName);
            }else{
                fname=humpStyleColName;
            }
            JFieldVar field = definedClass.field(JMod.NONE, jClass, fname);
            allModelFields.put(colName, field);
            field.javadoc().append("对应数据库").append(db).append(".")
                    .append(table).append(".").append(colName).append("字段")
                    .append("\n").append(comment);
            JMethod[] methods = CodeHelper.buildGetterAndSetter(definedClass, humpStyleColName, jClass, field);
            allGetFields.put(colName, methods[0]);
            allSetFields.put(colName, methods[1]);
            definedClass.field(CodeHelper.MODE_PUBLIC_STATIC_FINAL, String.class, CodeHelper.FIELD_CONST_NAME_PREFIX + colName.toUpperCase(), JExpr.lit(colName));
        }
    }



    private void buildStaticFields() {
        String priKey = info.getPriKey();
        if (priKey != null) {
            definedClass.field(CodeHelper.MODE_PUBLIC_STATIC_FINAL, String.class, CodeHelper.FIELD_PRIMARY_KEY_NAME, JExpr.lit(priKey));
        }
        definedClass.field(CodeHelper.MODE_PUBLIC_STATIC_FINAL, String.class, CodeHelper.FIELD_TABLE_NAME, table == null ? JExpr._null() : JExpr.lit(table));
        definedClass.field(CodeHelper.MODE_PUBLIC_STATIC_FINAL, String.class, CodeHelper.FIELD_DB_NAME, db == null ? JExpr._null() : JExpr.lit(db));
        definedClass.field(CodeHelper.MODE_PUBLIC_STATIC_FINAL, Integer.class, CodeHelper.FIELD_MODEL_TYPE, JExpr.lit(info.getTableType()));
    }


    private void buildFeatureMethod() {
        AbstractJType ft = cm.directClass("FT");//._(cm.ref(_ObjMapper.class));
//        JTypeWildcard ft = cm.ref(_ObjMapper.class).(EWildcardBoundMode.EXTENDS);
//        wildcard.narrow(cm.ref(_ObjMapper.class));
        JMethod method = definedClass.method(JMod.PUBLIC, ft, CodeHelper.METHOD_METHOD_GET_FEATURE);
        method.generify("FT",cm.ref(_ObjMapper.class));
        JVar clazz = method.param(cm.ref(Class.class).narrow(ft), "clazz");
        JBlock body = method.body();
        body._if(JExpr.dotclass(cm.ref(RedisMapMapper.class)).invoke("isAssignableFrom").arg(clazz))._then()._return(JExpr.cast(ft,definedClass.staticRef(CodeHelper.FIELD_REDIS_MAP_MAPPER_INSTANCE)));
        body._if(JExpr.dotclass(cm.ref(DbResultSetMapper.class)).invoke("isAssignableFrom").arg(clazz))._then()._return(JExpr.cast(ft,definedClass.staticRef(CodeHelper.FIELD_RESULT_SET_MAPPER_INSTANCE)));
        body._return(JExpr._null());
    }

    private void buildIsEmptyMethod() {
        if (columns != null && columns.size() > 0) {
            JMethod method = definedClass.method(JMod.PUBLIC, cm.BOOLEAN, CodeHelper.METHOD_MODEL_IS_EMPTY);
            JBlock body = method.body();
            body._if(JExpr._super().invoke(CodeHelper.METHOD_MODEL_IS_EMPTY).not())._then()._return(JExpr.FALSE);
            for (ColumnInfoInterface item : columns) {

                String colName = item.getFieldName();
                if(!ignoreField.contains(colName)) {
                    JMethod getterMethod = getGetterMethod(colName);
                    body._if(JExpr.invoke(getterMethod).ne(JExpr._null()))._then()._return(JExpr.FALSE);
                }
            }
            body._return(JExpr.TRUE);
        }
    }

    public JFieldRef referStaticField(String fieldName) {
        return CodeHelper.getBaseModelColumnStaticRef(definedClass,fieldName);
    }

    private void buildFieldTypeMap() {
        if (columns != null && columns.size() > 0) {
            JInvocation invocation = cm.ref(CollectionHelper.class).staticInvoke("mapBuilder").narrow(String.class).narrow(Object.class);
            for (ColumnInfoInterface item : columns) {
                String colName = item.getFieldName();
                if(!ignoreField.contains(colName)) {
                    final AbstractJClass type = CodeHelper.getFieldDefType(cm, modelDef, item,builderContext);
                    invocation = invocation.invoke("put").arg(referStaticField(colName)).arg(JExpr.dotclass(type));
                }
            }
            invocation = invocation.invoke("getMap");
            JFieldVar field = definedClass.field(CodeHelper.MODE_PUBLIC_STATIC_FINAL, CodeHelper.buildNarrowedClass(cm, Map.class, String.class, Object.class),
                    CodeHelper.FIELD_FIELDS_CLASS_CONSTANT_MAP, invocation);
            JMethod method = definedClass.method(JMod.PUBLIC, CodeHelper.buildNarrowedClass(cm, Map.class, String.class, Object.class), CodeHelper.METHOD_MODEL_GET_FIELD_CONFIG);
            method.annotate(Override.class);

            method.body()._return(field);
            definedClass.field(CodeHelper.MODE_PUBLIC_STATIC_FINAL, Integer.class, CodeHelper.FIELD_MODEL_FIELD_COUNT, JExpr.lit(columns.size()));
        }

    }



    public JDefinedClass getDefinedClass() {
        return definedClass;
    }

    public TableInfoInterface getInfo() {
        return info;
    }

    public String getTable() {
        return table;
    }

    public String getDb() {
        return db;
    }

    public List<ColumnInfoInterface> getColumns() {
        return columns;
    }

    public String getModelClassName() {
        return modelClassName;
    }

    public JCodeModel getCm() {
        return cm;
    }

    public boolean isSelectModel() {
        return selectModel;
    }

//    public void setSelectModel(boolean selectModel) {
//        this.selectModel = selectModel;
//    }

    public Map<String, JFieldVar> getAllModelFields() {
        return allModelFields;
    }

    public void setAllModelFields(Map<String, JFieldVar> allModelFields) {
        this.allModelFields = allModelFields;
    }

    public boolean containsField(Object key) {
        return allModelFields.containsKey(key);
    }

    public JFieldVar getField(Object key) {
        return allModelFields.get(key);
    }

    public Map<String, JMethod> getAllGetFields() {
        return allGetFields;
    }

    public void setAllGetFields(Map<String, JMethod> allGetFields) {
        this.allGetFields = allGetFields;
    }

    public Map<String, JMethod> getAllSetFields() {
        return allSetFields;
    }

    public void setAllSetFields(Map<String, JMethod> allSetFields) {
        this.allSetFields = allSetFields;
    }

    public JMethod getGetterMethod(Object key) {
        return allGetFields.get(key);
    }

    public JMethod getSetterMethod(Object key) {
        return allSetFields.get(key);
    }

    public Set<String> getIgnoreField() {
        return ignoreField;
    }

    public AbstractJClass getExtendedClazz() {
        return extendedClazz;
    }

    public String getBaseTable() {
        return baseTable;
    }

    public ModelBuilderContext getBuilderContext() {
        return builderContext;
    }

    public CommonModelDef getModelDef() {
        return modelDef;
    }
}
