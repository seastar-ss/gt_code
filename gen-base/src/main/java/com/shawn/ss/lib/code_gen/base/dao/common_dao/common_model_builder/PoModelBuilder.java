package com.shawn.ss.lib.code_gen.base.dao.common_dao.common_model_builder;

import com.helger.jcodemodel.*;
import com.shawn.ss.lib.code_gen.CodeBuilderInterface;
import com.shawn.ss.lib.code_gen.base.common.POJOModelBuilder;
import com.shawn.ss.lib.code_gen.base.helper.CodeConstants;
import com.shawn.ss.lib.code_gen.base.helper.ModelBuilderContext;
import com.shawn.ss.lib.code_gen.model.def_model.interfaces._BaseDaoConf;
import com.shawn.ss.lib.code_gen.model.def_model.interfaces._BaseModelConf;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.FieldInfoInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//import com.shawn.ss.lib.code_gen.model.def_model.dao_def.EnumTypeConf;
//import com.shawn.ss.lib.tools.db.api.interfaces.mappers._ObjMapper;

public class PoModelBuilder implements CodeBuilderInterface {

    public static final Logger L = LoggerFactory.getLogger(PoModelBuilder.class);

    //    TableInfoInterface info;
    private final ModelBuilderContext builderContext;
    //    private final String baseTable;
//    final Set<String> ignoreField;
    //    final String table;
//    final String db;
//    final List<ColumnInfoInterface> columns;
//    final String modelClassName;
    final JCodeModel cm;
//    final AbstractJClass extendedClazz;
    JDefinedClass definedClass;
//    Map<String, JFieldVar> allModelFields;
//    Map<String, JMethod> allGetFields;
//    Map<String, JMethod> allSetFields;
//    Map<String,JDefinedClass> enumClzz;
//    final boolean selectModel;
    private _BaseDaoConf modelDef;
    POJOModelBuilder builder;

    //    public ModelBuilder(TableInfoInterface info,  ModelBuilderContext builderContext) {
//        this(info,builderContext,null,null);
//
//    }
    public PoModelBuilder(_BaseDaoConf def) {
        this.modelDef = def;
        builder=new POJOModelBuilder(def);
//        this.info = def.get();
        this.builderContext = def.getBuilderContext();
//        this.baseTable = def.getBaseTable();
//        ignoreField = def.ignoreField();
//        this.ignoreField = (ignore == null ? Collections.emptySet() : ignore);
//        db = info.getDb();
//        table = info.getTable();
//        columns = info.getColumns();

        if (builderContext == null)
            throw new IllegalArgumentException("code build context is null");
//        else
        this.cm = builderContext.getCm();

//        this.modelClassName = def.getPojoClzName();
//        extendedClazz = cm.ref(def.getPojoExtendsClzName());
//        fields = modelDef.getFields();
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
        try {
            builder.buildModel();
            definedClass=builder.getDefinedClass();
            buildStaticFields();
//            ClassDataTable.putModelClz(modelClassName,definedClass);
        } catch (Exception e) {
            e.printStackTrace();
//            throw new IllegalStateException("model state abnormal for " + modelClassName);
        }
    }



    public void buildSQLField(String sql) {
        definedClass.field(CodeConstants.MODE_PUBLIC_STATIC_FINAL, String.class, CodeConstants.FIELD_MODEL_RELATED_SQL, JExpr.lit(sql));
    }



    private void buildStaticFields() {
        FieldInfoInterface priField = modelDef.getPriField();
        String priKey = priField.getAliasField();
        if (priKey != null) {
            definedClass.field(CodeConstants.MODE_PUBLIC_STATIC_FINAL, String.class, CodeConstants.FIELD_PRIMARY_KEY_NAME, JExpr.lit(priKey));
        }
        String db=modelDef.getDb();
        String table=modelDef.getTable();
        definedClass.field(CodeConstants.MODE_PUBLIC_STATIC_FINAL, String.class, CodeConstants.FIELD_TABLE_NAME, table == null ? JExpr._null() : JExpr.lit(table));
        definedClass.field(CodeConstants.MODE_PUBLIC_STATIC_FINAL, String.class, CodeConstants.FIELD_DB_NAME, db == null ? JExpr._null() : JExpr.lit(db));
//        definedClass.field(CodeConstants.MODE_PUBLIC_STATIC_FINAL, Integer.class, CodeConstants.FIELD_MODEL_TYPE, JExpr.lit(info.getTableType()));
    }




    public JDefinedClass getDefinedClass() {
        return definedClass;
    }


    public String getModelClassName() {
        return builder.getModelClassName();
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
