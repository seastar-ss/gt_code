package com.shawn.ss.lib.code_gen.base.common;

import com.helger.jcodemodel.*;
import com.shawn.ss.lib.code_gen.CodeBuilderInterface;
import com.shawn.ss.lib.code_gen.base.helper.CodeConstants;
import com.shawn.ss.lib.code_gen.base.helper.ModelBuilderContext;
import com.shawn.ss.lib.code_gen.base.helper.data_store.ClassDataTable;
import com.shawn.ss.lib.code_gen.model.def_model.interfaces._BaseDaoConf;
import com.shawn.ss.lib.code_gen.model.def_model.interfaces._BaseModelConf;
import com.shawn.ss.lib.code_gen.model.def_model.dao_def.EnumTypeConf;
import com.shawn.ss.lib.tools.CodeStyleTransformHelper;
import com.shawn.ss.lib.tools.CollectionHelper;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.FieldInfoInterface;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model.EnumTypeDef;
import com.shawn.ss.lib.tools.db.api.interfaces.mappers.db.CommonMapMapper;
import com.shawn.ss.lib.tools.db.api.interfaces.mappers.db.DbResultSetMapper;
import com.shawn.ss.lib.tools.db.dto_base.model.AbstractBaseModel;
import com.shawn.ss.lib.tools.db.dto_base.model._APIObj;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * Created by ss on 2018/10/27.
 */
public class POJOModelBuilder implements CodeBuilderInterface {

    public static final Logger L = LoggerFactory.getLogger(POJOModelBuilder.class);

    //    TableInfoInterface info;
    private final ModelBuilderContext builderContext;
    //    private final String baseTable;
    final Set<String> ignoreField;
    //    final String table;
    //    final String db;
    //    final List<ColumnInfoInterface> columns;
    final String modelClassName;
    final JCodeModel cm;
    final AbstractJClass extendedClazz;
    JDefinedClass definedClass;
    //    Map<String, JFieldVar> allModelFields;
    //    Map<String, JMethod> allGetFields;
    //    Map<String, JMethod> allSetFields;
    //    Map<String,JDefinedClass> enumClzz;
    //    final boolean selectModel;
    private _BaseModelConf modelDef;
    private final List<FieldInfoInterface> fields;

    //    public ModelBuilder(TableInfoInterface info,  ModelBuilderContext builderContext) {
    //        this(info,builderContext,null,null);
    //
    //    }
    public POJOModelBuilder(_BaseModelConf def) {
        this.modelDef = def;
        //        this.info = def.get();
        this.builderContext = def.getBuilderContext();
        //        this.baseTable = def.getBaseTable();
        ignoreField = CollectionHelper.isCollectionEmpty(def.getIgnoreField()) ? Collections.emptySet() : def.getIgnoreField();
        //        this.ignoreField = (ignore == null ? Collections.emptySet() : ignore);
        //        db = info.getDb();
        //        table = info.getTable();
        //        columns = info.getColumns();
        if (builderContext == null)
            throw new IllegalArgumentException("code build context is null");
        //        else
        this.cm = builderContext.getCm();

        this.modelClassName = def.getPojoClzName();
        if (def.getPojoExtendsClzName() != null)
            extendedClazz = cm.ref(def.getPojoExtendsClzName());
        else
            extendedClazz = cm.ref(AbstractBaseModel.class);
        fields = modelDef.getFields();
        //        this.allModelFields = CollectionHelper.newMap();
        //        this.allGetFields = CollectionHelper.newMap();
        //        this.allSetFields = CollectionHelper.newMap();
        //        if (baseTable == null) {
        //            extendedClazz = cm.ref(AbstractBaseModel.class);
        //        } else {
        ////            this.selectModel = true;
        //            extendedClazz = cm.ref(builderContext.getReallyModelClassName(baseTable, null));
        //        }
        //        this.selectModel = (info.getTableType() == 2);
        //        enumClzz=CollectionHelper.newMap();
    }


    @Override
    public void buildModel() {
        if (modelDef.getDeclaredModel() != null) {
            return;
        }
        try {
            L.info("build model:" + modelClassName);
            checkTableInfoForEnums();
            definedClass = cm._class(modelClassName);
            if (extendedClazz != null)
                definedClass._extends(extendedClazz);

            buildConstructor();
            buildComments();
            //            if(!selectModel) {
            //            buildStaticFields();
            //            }
            buildColFields();
            buildFieldTypeMap();
            buildIsEmptyMethod();
            buildFeatureMethod();
            buildToStringMethod();
            buildStaticFields();
            //            if (modelDef instanceof SpecialModelDaoConf) {
            //                SpecialModelDaoConf sdef = (SpecialModelDaoConf) modelDef;
            //                String sql = sdef.getSql();
            //                if (sql != null) {
            //                    buildSQLField(sql);
            //                }
            //            }
            ClassDataTable.putModelClz(modelClassName, definedClass);
            modelDef.setDeclaredModel(definedClass);
            registerClzToConstants();
            //            ClassDataTable.putModelClz(modelClassName,definedClass);
        } catch (JClassAlreadyExistsException e) {
            e.printStackTrace();
            throw new IllegalStateException("model state abnormal for " + modelClassName);
        }
    }

    private void buildConstructor() {
        definedClass.constructor(JMod.PUBLIC);
        if (fields != null && fields.size() > 0) {
            JMethod constructorCopyModel = definedClass.constructor(JMod.PUBLIC);
            JVar instance = constructorCopyModel.param(definedClass, "instance");
            JBlock body = constructorCopyModel.body();
            for (FieldInfoInterface item : fields) {
                String fieldName = item.getFieldName();
                body.invoke(CodeConstants.getMethodNameOfModelSet(fieldName))
                        .arg(instance.invoke(CodeConstants.getMethodNameOfModelGet(fieldName)));
            }
        }
    }

    private void registerClzToConstants() {
        JDefinedClass constantClz = modelDef.getConstant().getConstantClz();
        JFieldRef confClazzClz = constantClz.staticRef(CodeConstants.FIELD_COMMON_CONF_CLAZZ);
        constantClz.init()
                .invoke(confClazzClz, "put")
                .arg(modelClassName)
                .arg(JExpr.dotclass(this.definedClass));
    }

    private void buildStaticFields() {
        Map<String, FieldInfoInterface> staticConstFields = modelDef.getStaticConstFields();
        CodeConstants.buildStaticFieldFromMap(cm, definedClass, staticConstFields);
    }

    private void buildToStringMethod() {
        CodeConstants.genToStringMethod(cm, definedClass, false);
    }

    private void checkTableInfoForEnums() {
        if (fields != null && fields.size() > 0) {
            for (FieldInfoInterface item : fields) {
                EnumTypeDef enumTypeDef = item.getEnumTypeDef();
                if (enumTypeDef != null && enumTypeDef.sizeOfItems() > 0) {
                    EnumTypeConf conf =
                            new EnumTypeConf(enumTypeDef, builderContext);
                    //                    conf.setBuilderContext(builderContext);
                    EnumBuilder builder = new EnumBuilder(conf);
                    builder.buildModel();
                    //                    modelDef.putEnumClz(item.getFieldName(), builder.getDefinedClass());
                }
            }
        }
    }

    //    public void buildSQLField(String sql) {
    //        definedClass.field(CodeConstants.MODE_PUBLIC_STATIC_FINAL, String.class, CodeConstants.FIELD_MODEL_RELATED_SQL, JExpr.lit(sql));
    //    }

    private void buildComments() {
        JDocComment jDocComment = definedClass.headerComment();
        jDocComment.addAuthor().append("shawn-ss's auto writer");
        jDocComment.append("don't modify , it is generate automatically, any modification will be lost after regeneration next time");
        JDocComment javadoc = definedClass.javadoc();
        javadoc.append("base DTO").append(",represent for  :").append(modelDef.getName());
        String tableComment = modelDef.getComment();
        if (tableComment != null) {
            javadoc.append("\n\t").append(tableComment);
        }
    }

    private void buildColFields() {

        if (fields != null && fields.size() > 0) {
            for (FieldInfoInterface item : fields) {
                buildFields(item);
            }
        }
        //        if (columns != null && columns.size() > 0) {
        //            for (ColumnInfoInterface item : columns) {
        //                buildFields(item);
        //            }
        //        }
    }

    private void buildFields(FieldInfoInterface item) {
        String colName = item.getAliasField();
        if (!ignoreField.contains(colName) && colName.length() > 0) {
            String comment = item.getComment();
            //            FieldDataTypeInterface type = item.getType();
            AbstractJClass type = CodeConstants.getFieldDefType(cm, modelDef, item, builderContext);
            //            final EnumTypeDef enumTypeDef = item.getEnumTypeDef();
            AbstractJClass jClass = type;

            String itemFieldName = item.getFieldName();
            //            String fname = CodeConstants.getFieldNameFromTbColumn(colName);
            ;
            //            if(PATTERN_NUMBER_START.matcher(humpStyleColName).matches()) {
            //                fname = CodeConstants.FIELD_MODEL_FIELD_PREFIX + CodeStyleTransformHelper.upperFirstCase(humpStyleColName);
            //            }else{
            //                fname=humpStyleColName;
            //            }
            JFieldVar field = definedClass.field(JMod.NONE, jClass, itemFieldName);

            field.javadoc().append(comment);
            JMethod[] methods = CodeConstants.buildGetterAndSetter(definedClass, itemFieldName, jClass, field);

            definedClass.field(
                    CodeConstants.MODE_PUBLIC_STATIC_FINAL,
                    String.class,
                    CodeConstants.FIELD_CONST_NAME_PREFIX + colName.toUpperCase(),
                    JExpr.lit(colName)
            );
        }
    }


   /*     private void buildStaticFields() {
            String priKey = info.getPriKey();
            if (priKey != null) {
                definedClass.field(CodeConstants.MODE_PUBLIC_STATIC_FINAL, String.class, CodeConstants.FIELD_PRIMARY_KEY_NAME, JExpr.lit(priKey));
            }
            definedClass.field(CodeConstants.MODE_PUBLIC_STATIC_FINAL, String.class, CodeConstants.FIELD_TABLE_NAME, table == null ? JExpr._null() : JExpr.lit(table));
            definedClass.field(CodeConstants.MODE_PUBLIC_STATIC_FINAL, String.class, CodeConstants.FIELD_DB_NAME, db == null ? JExpr._null() : JExpr.lit(db));
            definedClass.field(CodeConstants.MODE_PUBLIC_STATIC_FINAL, Integer.class, CodeConstants.FIELD_MODEL_TYPE, JExpr.lit(info.getTableType()));
        }*/


    private void buildFeatureMethod() {

        AbstractJType ft = cm.directClass("FT");//._(cm.ref(_ObjMapper.class));
        //        JTypeWildcard ft = cm.ref(_ObjMapper.class).(EWildcardBoundMode.EXTENDS);
        //        wildcard.narrow(cm.ref(_ObjMapper.class));
        JMethod method = definedClass.method(JMod.PUBLIC, ft, CodeConstants.METHOD_METHOD_GET_FEATURE);
        method.generify("FT", cm.ref(_APIObj.class));
        JVar clazz = method.param(cm.ref(Class.class).narrow(ft), "clazz");
        JBlock body = method.body();
        JDefinedClass constantClz = modelDef.getConstant().getConstantClz();
        if (modelDef.getModelType() == CodeConstants.TYPE_MODEL_COMMON_TYPE) {
            body._if(JExpr.dotclass(cm.ref(CommonMapMapper.class)).invoke("isAssignableFrom").arg(clazz))
                    ._then()._return(JExpr.cast(ft, CodeConstants.getCommonFieldMapper(modelDef.getName(), constantClz)));
        }
        if (modelDef instanceof _BaseDaoConf) {
            _BaseDaoConf modelDef1 = (_BaseDaoConf) this.modelDef;
            if (modelDef1.getDaoType() != _BaseDaoConf.EnumFieldDataSrcType.mulDao) {
                body._if(JExpr.dotclass(cm.ref(DbResultSetMapper.class)).invoke("isAssignableFrom").arg(clazz))
                        ._then()._return(JExpr.cast(ft, CodeConstants.getCommonFieldMapper(modelDef1.getName(), constantClz)));
            }
        }
        body._return(JExpr._null());
    }

    private void buildIsEmptyMethod() {
        if (fields != null && fields.size() > 0) {
            JMethod method = definedClass.method(JMod.PUBLIC, cm.BOOLEAN, CodeConstants.METHOD_MODEL_IS_EMPTY);
            JBlock body = method.body();
            body._if(JExpr._super().invoke(CodeConstants.METHOD_MODEL_IS_EMPTY).not())._then()._return(JExpr.FALSE);
            for (FieldInfoInterface item : fields) {

                String colName = item.getFieldName();
                if (!ignoreField.contains(colName)) {
                    String getterMethod = CodeConstants.getModelGetMethodName(colName);
                    body._if(JExpr.invoke(getterMethod).ne(JExpr._null()))._then()._return(JExpr.FALSE);
                }
            }
            body._return(JExpr.TRUE);
        }
    }

    public JFieldRef referStaticField(String fieldName) {
        return CodeConstants.getBaseModelColumnStaticRef(definedClass, fieldName);
    }

    private void buildFieldTypeMap() {
        if (fields != null && fields.size() > 0) {
            JInvocation invocation = cm.ref(CollectionHelper.class).staticInvoke("mapBuilder").narrow(String.class).narrow(Object.class);
            for (FieldInfoInterface item : fields) {
                String colName = item.getAliasField();
                if (!ignoreField.contains(colName)) {
                    final AbstractJClass type = CodeConstants.getFieldDefType(cm, modelDef, item, builderContext);
                    invocation = invocation.invoke("put").arg(referStaticField(colName)).arg(JExpr.dotclass(type.erasure()));
                }
            }
            invocation = invocation.invoke("getMap");
            JFieldVar field = definedClass.field(CodeConstants.MODE_PUBLIC_STATIC_FINAL, CodeConstants.buildNarrowedClass(cm, Map.class, String.class, Object.class),
                    CodeConstants.FIELD_FIELDS_CLASS_CONSTANT_MAP, invocation);
            JMethod method = definedClass.method(JMod.PUBLIC, CodeConstants.buildNarrowedClass(cm, Map.class, String.class, Object.class), CodeConstants.METHOD_MODEL_GET_FIELD_CONFIG);
            method.annotate(Override.class);

            method.body()._return(field);
            definedClass.field(CodeConstants.MODE_PUBLIC_STATIC_FINAL, Integer.class, CodeConstants.FIELD_MODEL_FIELD_COUNT, JExpr.lit(fields.size()));
        }

    }

    public JDefinedClass getDefinedClass() {
        return definedClass;
    }

    public String getModelClassName() {
        return modelClassName;
    }

    public JCodeModel getCm() {
        return cm;
    }

    //    public TableInfoInterface getInfo() {
    //        return info;
    //    }
    //
    //    public String getTable() {
    //        return table;
    //    }
    //
    //    public String getDb() {
    //        return db;
    //    }
    //
    //    public List<ColumnInfoInterface> getColumns() {
    //        return columns;
    //    }

    //    public boolean isSelectModel() {
    //        return selectModel;
    //    }

    //    public void setSelectModel(boolean selectModel) {
    //        this.selectModel = selectModel;
    //    }

    //    public Map<String, JFieldVar> getAllModelFields() {
    //        return allModelFields;
    //    }
    //
    //    public void setAllModelFields(Map<String, JFieldVar> allModelFields) {
    //        this.allModelFields = allModelFields;
    //    }
    //
    //    public boolean containsField(Object key) {
    //        return allModelFields.containsKey(key);
    //    }
    //
    //    public JFieldVar getField(Object key) {
    //        return allModelFields.get(key);
    //    }
    //
    //    public Map<String, JMethod> getAllGetFields() {
    //        return allGetFields;
    //    }
    //
    //    public void setAllGetFields(Map<String, JMethod> allGetFields) {
    //        this.allGetFields = allGetFields;
    //    }
    //
    //    public Map<String, JMethod> getAllSetFields() {
    //        return allSetFields;
    //    }
    //
    //    public void setAllSetFields(Map<String, JMethod> allSetFields) {
    //        this.allSetFields = allSetFields;
    //    }
    //
    //    public JMethod getGetterMethod(Object key) {
    //        return allGetFields.get(key);
    //    }
    //
    //    public JMethod getSetterMethod(Object key) {
    //        return allSetFields.get(key);
    //    }
    //
    //    public Set<String> getIgnoreField() {
    //        return ignoreField;
    //    }
    //
    //    public AbstractJClass getExtendedClazz() {
    //        return extendedClazz;
    //    }
    //
    //    public String getBaseTable() {
    //        return baseTable;
    //    }

    public ModelBuilderContext getBuilderContext() {
        return builderContext;
    }

    public _BaseModelConf getModelDef() {
        return modelDef;
    }
}
