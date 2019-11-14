package com.shawn.ss.lib.code_gen.base.multi_dao.composed_model_builder;

import com.helger.jcodemodel.*;
import com.shawn.ss.lib.code_gen.CodeBuilderInterface;
import com.shawn.ss.lib.code_gen.base.helper.CodeHelper;
import com.shawn.ss.lib.code_gen.base.helper.ModelBuilderContext;
import com.shawn.ss.lib.code_gen.model.def_model.dao_def.ModelMulDaoConf;
import com.shawn.ss.lib.code_gen.model.def_model.dao_def.ModelRelatedTableDef;
import com.shawn.ss.lib.tools.CollectionHelper;
import com.shawn.ss.lib.tools.db.dto_base.model.AbstractBaseModel;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by ss on 2018/2/13.
 */
public class ComposedModelBuilder implements CodeBuilderInterface {

    private AbstractJClass wrapperClz;

    private final JCodeModel cm;
//    private final String serviceClassName;
//    private final String modelSelectMethod;
    private final String mainTable;
    private final List<ModelRelatedTableDef> relatedTables;
//    private final boolean buildController;
    private final ModelBuilderContext modelBuilderContext;
//    private final Map<String, TableInfoInterface> tbMap;
//    private final Map<String, AbstractJClass> daos;
    private final Map<String, AbstractJClass> models;
    private String mainModelFieldName;
    private Map<String,String> subModelFieldNames;
    final String dtoClazzName;
    //    private final Map<String, ModelRelatedTableDef> defs;

    public ComposedModelBuilder(ModelMulDaoConf modelMulDaoConf) {
//        this.serviceClassName = modelMulDaoConf.getServiceClassName();
//        this.modelSelectMethod = modelMulDaoConf.getMainModelSelectMethod();
        this.mainTable = modelMulDaoConf.getTable();
        this.relatedTables = modelMulDaoConf.getRelatedTables();
//        this.buildController = modelMulDaoConf.isBuildNotAbstract();
        this.modelBuilderContext = modelMulDaoConf.getBuilderContext();
//        this.tbMap = this.modelBuilderContext.getTbMap();
        this.cm=modelBuilderContext.getCm();
//        this.daos=modelMulDaoConf.getDaos();
        this.models= modelMulDaoConf.getModels();
        subModelFieldNames=CollectionHelper.newMap();
        mainModelFieldName = modelMulDaoConf.getMainField();
        dtoClazzName = modelMulDaoConf.getDtoClazzName();
//        this.defs=modelMulDaoConf.getDefs();
    }

    @Override
    public void buildModel() {
        String wrapperClzName=buildWrapperClzName();

        try {
            JDefinedClass clz = cm._class(wrapperClzName);
            clz._extends(cm.ref(AbstractBaseModel.class));
            if(mainModelFieldName==null) {
                mainModelFieldName = "data" + CodeHelper.getClazzNameFromTableName(mainTable);
            }
            AbstractJClass mainModelClass = cm.ref(modelBuilderContext.getReallyModelClassName(mainTable,null));
            List<JFieldVar> allVars=CollectionHelper.newList();
            JFieldVar var = clz.field(JMod.PROTECTED, mainModelClass, mainModelFieldName);
            CodeHelper.buildGetterAndSetter(clz, mainModelFieldName,mainModelClass,var);
            allVars.add(var);
            for(ModelRelatedTableDef def:relatedTables){
                String table = def.getTable();
                boolean single = def.isSingle();
                AbstractJClass jClass;
                AbstractJClass modelClz = models.get(table);
                if(single){
                    jClass= modelClz;
                }else {
                    jClass = CodeHelper.buildNarrowedClass(cm, List.class, modelClz);
                }
                String subModelFieldName=def.getFieldName();
                if(subModelFieldName==null) {
                    subModelFieldName = "data" + CodeHelper.getClazzNameFromTableName(table) + (single ? "" : "List");
                }
                JFieldVar field = clz.field(JMod.PROTECTED, jClass, subModelFieldName);
                CodeHelper.buildGetterAndSetter(clz, subModelFieldName,jClass,field);
                allVars.add(field);
                subModelFieldNames.put(table,subModelFieldName);
            }
            wrapperClz=clz;
            buildIsEmptyMethod(clz,allVars);
            buildFieldTypeMap(clz, mainModelFieldName,mainModelClass);
//            return clz;
        } catch (JClassAlreadyExistsException e) {
            e.printStackTrace();
            AbstractJClass ref = cm.ref(wrapperClzName);
            wrapperClz=ref;
//            return ref;
        }
    }

    private void buildIsEmptyMethod(JDefinedClass definedClass, List<JFieldVar> allVars) {
        if (allVars != null && allVars.size() > 0) {
            JMethod method = definedClass.method(JMod.PUBLIC, cm.BOOLEAN, CodeHelper.METHOD_MODEL_IS_EMPTY);
            JBlock body = method.body();

            for (JFieldVar item : allVars) {
                body._if(item.ne(JExpr._null()))._then()._return(JExpr.FALSE);
            }
            body._return(JExpr.TRUE);
        }
    }

    private void buildFieldTypeMap(JDefinedClass definedClass, String mainTable,AbstractJClass mainClz) {
//        if (allVars != null && allVars.size() > 0) {
            JInvocation invocation = cm.ref(CollectionHelper.class).staticInvoke("mapBuilder").narrow(String.class).narrow(Object.class);
            invocation = invocation.invoke("put").arg(mainTable).arg(JExpr.dotclass(mainClz));
            for (ModelRelatedTableDef item : relatedTables) {
                String table = item.getTable();
                AbstractJClass abstractJClass = models.get(table);
                invocation = invocation.invoke("put").arg(table).arg(JExpr.dotclass(abstractJClass));
            }
            invocation = invocation.invoke("getMap");
            JFieldVar field = definedClass.field(CodeHelper.MODE_PUBLIC_STATIC_FINAL, CodeHelper.buildNarrowedClass(cm, Map.class, String.class, Object.class),
                    CodeHelper.FIELD_FIELDS_CLASS_CONSTANT_MAP, invocation);
            JMethod method = definedClass.method(JMod.PUBLIC, CodeHelper.buildNarrowedClass(cm, Map.class, String.class, Object.class), CodeHelper.METHOD_MODEL_GET_FIELD_CONFIG);
            method.annotate(Override.class);
            method.body()._return(field);

//        }

    }

//    public AbstractJClass buildWapperClass() {
//
//    }

    private String buildWrapperClzName() {
        if(dtoClazzName!=null){
            return modelBuilderContext.getModelClassPrefix(false)+dtoClazzName;
        }
        StringBuilder ret=new StringBuilder(modelBuilderContext.getModelClassPrefix(false));
        ret.append(CodeHelper.getClazzNameFromTableName(mainTable));
        Set<String> relatedTb= CollectionHelper.newSortedSet();
        for(ModelRelatedTableDef def:relatedTables){
            String table = def.getTable();
            String tbName = CodeHelper.getClazzNameFromTableName(table)+(def.isSingle()?"":"s");
            relatedTb.add(tbName);
        }
        for(String s:relatedTb) {
            ret.append(s);
        }
        return ret.toString();
    }

    public AbstractJClass getWrapperClz() {
        return wrapperClz;
    }

    public String getMainModelFieldName() {
        return mainModelFieldName;
    }

    public String getSubModelFieldName(String table) {
        return subModelFieldNames.get(table);
    }
}
