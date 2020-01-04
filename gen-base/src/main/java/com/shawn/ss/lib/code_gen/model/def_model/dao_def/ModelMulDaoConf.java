package com.shawn.ss.lib.code_gen.model.def_model.dao_def;

import com.helger.jcodemodel.AbstractJClass;
import com.helger.jcodemodel.JCodeModel;

import com.shawn.ss.gen.api.conf.SelectMethodEnum;
import com.shawn.ss.lib.code_gen.base.helper.CodeConstants;
import com.shawn.ss.lib.code_gen.base.helper.data_store.DbDataTable;
import com.shawn.ss.lib.code_gen.model.def_model._BaseConf;
import com.shawn.ss.lib.code_gen.model.def_model._BaseConfImpl;
import com.shawn.ss.lib.code_gen.model.def_model.common.CommonPOJOConf;
import com.shawn.ss.lib.tools.CollectionHelper;

import java.util.List;
import java.util.Map;

public class ModelMulDaoConf extends CommonPOJOConf implements _BaseConf {
    String serviceClassName;
    String serviceMethodName;
    List<SelectMethodEnum> mainModelSelectMethod;
    String mainDb;
    String mainTable;
    String mainField;
    String dtoClazzName;
    SpecialModelDef relatedMainAttr;
    List<ModelRelatedTableDef> relatedTables;
    List<SpecialModelDef> relatedAttrs;

    String implInterface;

    boolean buildNotAbstract;

    transient Map<String, AbstractJClass> daos;
    transient Map<String, AbstractJClass> models;
    transient Map<String, ModelRelatedTableDef> defs;
    transient Map<String,SpecialModelDef> attrs;

//    transient boolean listResult;
    transient boolean isMultiFieldFromSameTable;

//    transient ModelBuilderContext builderContext;
//    DbInfoInterface dbInfo;

//    public Map<String, TableInfoInterface> getTbMap() {
//        return builderContext ==null?null: builderContext.getTbMap();
//    }

    public ModelMulDaoConf() {
        defs= CollectionHelper.newMap();
        models=CollectionHelper.newMap();
        daos=CollectionHelper.newMap();
        attrs=CollectionHelper.newMap();
    }

    public String getImplInterface() {
        return implInterface;
    }

    public ModelMulDaoConf setImplInterface(String implInterface) {
        this.implInterface = implInterface;
        return this;
    }

    public String getServiceClassName() {
        return serviceClassName;
    }

    public ModelMulDaoConf setServiceClassName(String serviceClassName) {
        this.serviceClassName = serviceClassName;
        return this;
    }

    public String getServiceMethodName() {
        return serviceMethodName;
    }

    public ModelMulDaoConf setServiceMethodName(String serviceMethodName) {
        this.serviceMethodName = serviceMethodName;
        return this;
    }

    public List<SelectMethodEnum> getMainModelSelectMethod() {
        return mainModelSelectMethod;
    }

    public ModelMulDaoConf setMainModelSelectMethod(List<SelectMethodEnum> mainModelSelectMethod) {
        this.mainModelSelectMethod = mainModelSelectMethod;
//        this.listResult= mainModelSelectMethod.isMultipleResult();
        return this;
    }

    public String getMainTable() {
        return mainTable;
    }

    public ModelMulDaoConf setMainTable(String mainTable) {
        this.mainTable = mainTable;
        return this;
    }

    public String getMainDb() {
        return mainDb==null? DbDataTable.getCurrentDb():mainDb;
    }

    public ModelMulDaoConf setMainDb(String mainDb) {
        this.mainDb = mainDb;
        return this;
    }

    public List<ModelRelatedTableDef> getRelatedTables() {
        return relatedTables;
    }

    public ModelMulDaoConf setRelatedTables(List<ModelRelatedTableDef> relatedTables) {
        this.relatedTables = relatedTables;
        return this;
    }

    public boolean isBuildNotAbstract() {
        return buildNotAbstract;
    }

    public ModelMulDaoConf setBuildNotAbstract(boolean buildNotAbstract) {
        this.buildNotAbstract = buildNotAbstract;
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

    public SpecialModelDef getRelatedMainAttr() {
        return relatedMainAttr;
    }

    public ModelMulDaoConf setRelatedMainAttr(SpecialModelDef relatedMainAttr) {
        this.relatedMainAttr = relatedMainAttr;
//        String baseModelTable = relatedMainAttr.getBaseModelTable();
//        if(baseModelTable!=null && !baseModelTable.equals(mainTable)){
//            throw new IllegalArgumentException("attr table "+baseModelTable+" not match "+mainTable);
//        }
        return this;
    }

//    public DbInfoInterface getDbInfo() {
//        return builderContext ==null?null: builderContext.getDbInfo();
//    }

    public final void init(){
        JCodeModel cm=builderContext.getCm();
        if(relatedMainAttr!=null)
            attrs.put(relatedMainAttr.getMethodName(), relatedMainAttr);
        for(ModelRelatedTableDef def:relatedTables){
            String table = def.getTable();
//            SpecialModelDef attr = modelDef.getAttr();
//            attrs.put(attr.getName(),attr);
            String tbName = CodeConstants.getClazzNameFromTableName(table);
            defs.put(table,def);

            AbstractJClass daoClass = cm.ref(builderContext.getDaoClassName(table));
            daos.put(table, daoClass);
            AbstractJClass modelClass = cm.ref(builderContext.getReallyModelClassName(table,null));
            models.put(table, modelClass);
        }
//        this.multiFieldFromSameTable = modelServiceConf.isMultiFieldFromSameTable();
//        mainModelSelectMethods = modelServiceConf.getMainModelSelectMethod();
////        this.modelSelectMethod = modelServiceConf.getMainModelSelectMethod();
//        this.mainTable = modelServiceConf.getMainTable();
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
//        mainDb = modelServiceConf.getMainDb();
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
        return mainField;
    }

    public ModelMulDaoConf setMainField(String mainField) {
        this.mainField = mainField;
        return this;
    }

    public String getDtoClazzName() {
        return dtoClazzName;
    }

    public ModelMulDaoConf setDtoClazzName(String dtoClazzName) {
        this.dtoClazzName = dtoClazzName;
        return this;
    }

    public boolean isMultiFieldFromSameTable() {
        return isMultiFieldFromSameTable;
    }

    public ModelMulDaoConf setMultiFieldFromSameTable(boolean multiFieldFromSameTable) {
        isMultiFieldFromSameTable = multiFieldFromSameTable;
        return this;
    }

    @Override
    public String toString() {
        return "ModelMulDaoConf{" +
                "serviceClassName='" + serviceClassName + '\'' +
                ", serviceMethodName='" + serviceMethodName + '\'' +
                ", mainModelSelectMethod=" + mainModelSelectMethod +
                ", mainDb='" + mainDb + '\'' +
                ", mainTable='" + mainTable + '\'' +
                ", mainField='" + mainField + '\'' +
                ", dtoClazzName='" + dtoClazzName + '\'' +
                ", relatedMainAttr=" + relatedMainAttr +
                ", relatedTables=" + relatedTables +
                ", relatedAttrs=" + relatedAttrs +
                ", implInterface='" + implInterface + '\'' +
                ", buildNotAbstract=" + buildNotAbstract +
                ", daos=" + daos +
                ", models=" + models +
                ", defs=" + defs +
                ", attrs=" + attrs +
                ", isMultiFieldFromSameTable=" + isMultiFieldFromSameTable +
                '}';
    }
}
