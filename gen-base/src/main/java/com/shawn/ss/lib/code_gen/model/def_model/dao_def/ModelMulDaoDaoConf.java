package com.shawn.ss.lib.code_gen.model.def_model.dao_def;

import com.helger.jcodemodel.AbstractJClass;
import com.helger.jcodemodel.JCodeModel;
import com.shawn.ss.lib.code_gen.base.helper.CodeConstants;
import com.shawn.ss.lib.code_gen.base.helper.ModelBuilderContext;
import com.shawn.ss.lib.tools.CollectionHelper;

import java.util.List;
import java.util.Map;

public class ModelMulDaoDaoConf extends _BaseDaoConfImpl<ModelMulDaoDaoConf>  {
    String serviceClassName;
    String serviceMethodName;
//    String mainDb;
//    String mainTable;
//    String mainField;
    ModelRelatedTableDef mainTableDef;

//    String dtoClazzName;
    //    SpecialModelConf relatedMainAttr;
    List<ModelRelatedTableDef> relatedTables;
//    List<SpecialModelConf> relatedAttrs;

    String implInterface;

    boolean buildNotAbstract;

    transient Map<String, AbstractJClass> daos;
    transient Map<String, AbstractJClass> models;
    transient Map<String, ModelRelatedTableDef> defs;
//    transient Map<String,SpecialModelConf> attrs;
    //    transient boolean listResult;
    transient boolean isMultiFieldFromSameTable;

//    transient ModelBuilderContext builderContext;
//    DbInfoInterface dbInfo;

//    public Map<String, TableInfoInterface> getTbMap() {
//        return builderContext ==null?null: builderContext.getTbMap();
//    }

    public ModelMulDaoDaoConf(String name, ModelBuilderContext builderContext) {
        super(name, builderContext);
        defs = CollectionHelper.newMap();
        models = CollectionHelper.newMap();
        daos = CollectionHelper.newMap();
//        attrs=CollectionHelper.newMap();
    }

    public String getImplInterface() {
        return implInterface;
    }

    public ModelMulDaoDaoConf setImplInterface(String implInterface) {
        this.implInterface = implInterface;
        return this;
    }

    public String getServiceClassName() {
        return serviceClassName;
    }

    public ModelMulDaoDaoConf setServiceClassName(String serviceClassName) {
        this.serviceClassName = serviceClassName;
        return this;
    }

    public String getServiceMethodName() {
        return serviceMethodName;
    }

    public ModelMulDaoDaoConf setServiceMethodName(String serviceMethodName) {
        this.serviceMethodName = serviceMethodName;
        return this;
    }

    public String getTable() {
        return mainTableDef.getTable();
    }

//    public ModelMulDaoConf setMainTable(String mainTable) {
//        this.mainTable = mainTable;
//        return this;
//    }

    public String getDb() {
        return mainTableDef.getDb();
    }

//    public ModelMulDaoConf setMainDb(String mainDb) {
//        this.mainDb = mainDb;
//        return this;
//    }

    public List<ModelRelatedTableDef> getRelatedTables() {
        return relatedTables;
    }

    public ModelMulDaoDaoConf setRelatedTables(List<ModelRelatedTableDef> relatedTables) {
        this.relatedTables = relatedTables;
        return this;
    }

    public boolean isBuildNotAbstract() {
        return buildNotAbstract;
    }

    public ModelMulDaoDaoConf setBuildNotAbstract(boolean buildNotAbstract) {
        this.buildNotAbstract = buildNotAbstract;
        return this;
    }

    public ModelRelatedTableDef getMainTableDef() {
        return mainTableDef;
    }

    public ModelMulDaoDaoConf setMainTableDef(ModelRelatedTableDef mainTableDef) {
        this.mainTableDef = mainTableDef;
        return this;
    }

    //    public ModelBuilderContext getBuilderContext() {
//        return builderContext;
//    }
//
//    public ModelMulDaoConf setBuilderContext(ModelBuilderContext builderContext) {
//        this.builderContext = builderContext;
//        return this;
//    }

//    public SpecialModelConf getRelatedMainAttr() {
//        return relatedMainAttr;
//    }
//
//    public ModelMulDaoConf setRelatedMainAttr(SpecialModelConf relatedMainAttr) {
//        this.relatedMainAttr = relatedMainAttr;
////        String baseModelTable = relatedMainAttr.getBaseModelTable();
////        if(baseModelTable!=null && !baseModelTable.equals(mainTable)){
////            throw new IllegalArgumentException("attr table "+baseModelTable+" not match "+mainTable);
////        }
//        return this;
//    }

//    public DbInfoInterface getDbInfo() {
//        return builderContext ==null?null: builderContext.getDbInfo();
//    }

    public final void init() {
        JCodeModel cm = builderContext.getCm();
//        if(relatedMainAttr!=null)
//            attrs.put(relatedMainAttr.getMethodName(), relatedMainAttr);
        for (ModelRelatedTableDef def : relatedTables) {
            if (def.type == ModelRelatedTableDef.EnumFieldDataSrcType.commonDao) {
                String table = def.getTable();
//            SpecialModelConf attr = modelDef.getAttr();
//            attrs.put(attr.getName(),attr);
                String tbName = CodeConstants.getClazzNameFromTableName(table);
                defs.put(table, def);
                AbstractJClass daoClass = cm.ref(builderContext.getDaoClassName(table));
                daos.put(table, daoClass);
                AbstractJClass modelClass = cm.ref(builderContext.getReallyModelClassName(table, null));
                models.put(table, modelClass);

            }else if(def.type== ModelRelatedTableDef.EnumFieldDataSrcType.mulDao){
                //TODO:
            }else if(def.type == ModelRelatedTableDef.EnumFieldDataSrcType.specialDao){
                //TODO:
            }
        }
//        this.multiFieldFromSameTable = modelServiceConf.isMultiFieldFromSameTable();
//        mainModelSelectMethods = modelServiceConf.getMainModelSelectMethod();
////        this.modelSelectMethod = modelServiceConf.getMainModelSelectMethod();
//        this.mainTable = modelServiceConf.getTable();
//        this.relatedTables = modelServiceConf.getRelatedTables();
//        this.buildNotAbstract = modelServiceConf.isBuildNotAbstract();
//        this.modelBuilderContext = modelServiceConf.getBuilderContext();
//        this.serviceClassName = modelBuilderContext.getServiceClassName(modelServiceConf.getServiceClassName());
////        this.tbMap = this.modelBuilderContext.getTbMap();
////        this.listResult = modelServiceConf.isListResult();
//
//        this.daos = modelServiceConf.getDaos();
//        this.models = modelServiceConf.getModels();
//        this.defs = modelServiceConf.getDefs();
//        mainDb = modelServiceConf.getDb();
    }

    public Map<String, AbstractJClass> getDaos() {
        return daos;
    }

    public Map<String, AbstractJClass> getModels() {
        return models;
    }

    public Map<String, ModelRelatedTableDef> getDefs() {
        return defs;
    }

//    public boolean isListResult() {
//        return listResult;
//    }

    public String getMainField() {
        return mainTableDef.getFieldName();
    }

//    public ModelMulDaoConf setMainField(String mainField) {
//        this.mainField = mainField;
//        return this;
//    }

//    public String getDtoClazzName() {
//        return dtoClazzName;
//    }
//
//    public ModelMulDaoDaoConf setDtoClazzName(String dtoClazzName) {
//        this.dtoClazzName = dtoClazzName;
//        return this;
//    }

    public boolean isMultiFieldFromSameTable() {
        return isMultiFieldFromSameTable;
    }

    public ModelMulDaoDaoConf setMultiFieldFromSameTable(boolean multiFieldFromSameTable) {
        isMultiFieldFromSameTable = multiFieldFromSameTable;
        return this;
    }

    @Override
    public String toString() {
        return "ModelMulDaoConf{" +
                "serviceClassName='" + serviceClassName + '\'' +
                ", serviceMethodName='" + serviceMethodName + '\'' +
                ", mainModelSelectMethod=" + getMainModelSelectMethod() +
//                ", mainDb='" + mainDb + '\'' +
//                ", mainTable='" + mainTable + '\'' +
//                ", mainField='" + mainField + '\'' +
                ", dtoClazzName='" + super.getPojoClzName() + '\'' +
//                ", relatedMainAttr=" + relatedMainAttr +
                ", relatedTables=" + relatedTables +
//                ", relatedAttrs=" + relatedAttrs +
                ", implInterface='" + implInterface + '\'' +
                ", buildNotAbstract=" + buildNotAbstract +
                ", daos=" + daos +
                ", models=" + models +
                ", defs=" + defs +
//                ", attrs=" + attrs +
                ", isMultiFieldFromSameTable=" + isMultiFieldFromSameTable +
                '}';
    }

//    @Override
//    public List<FieldInfoInterface> getFields() {
//        return null;
//    }
//
//    @Override
//    public int sizeOfField() {
//        return 0;
//    }
//
//    @Override
//    public boolean addField(FieldInfoInterface fieldDef) {
//        return false;
//    }
//
//    @Override
//    public FieldInfoInterface getField(int index) {
//        return null;
//    }
//
//    @Override
//    public String getPojoClzName() {
//        return null;
//    }
//
//    @Override
//    public ModelMulDaoDaoConf setPojoClzName(String pojoClzName) {
//        return null;
//    }
//
//    @Override
//    public String getPojoExtendsClzName() {
//        return null;
//    }
//
//    @Override
//    public ModelMulDaoDaoConf setPojoExtendsClzName(String pojoExtendsClzName) {
//        return null;
//    }
}
