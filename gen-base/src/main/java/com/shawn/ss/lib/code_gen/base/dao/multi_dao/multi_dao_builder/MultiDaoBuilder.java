package com.shawn.ss.lib.code_gen.base.dao.multi_dao.multi_dao_builder;

import com.helger.jcodemodel.*;
import com.shawn.ss.gen.api.conf.SelectMethod;
import com.shawn.ss.gen.api.conf.SelectMethodEnum;
import com.shawn.ss.lib.code_gen.CodeBuilderInterface;
import com.shawn.ss.lib.code_gen.base.dao.AbstractDaoBuilder;
import com.shawn.ss.lib.code_gen.base.helper.CodeConstants;
import com.shawn.ss.lib.code_gen.base.helper.ModelBuilderContext;
import com.shawn.ss.lib.code_gen.base.helper.data_store.ClassDataTable;
import com.shawn.ss.lib.code_gen.model.MethodTypeEnum;
import com.shawn.ss.lib.code_gen.model.def_model.interfaces._BaseDaoConf;
import com.shawn.ss.lib.code_gen.model.def_model.interfaces._BaseRelationDef;
import com.shawn.ss.lib.tools.CodeStyleTransformHelper;
import com.shawn.ss.lib.tools.CollectionHelper;
import com.shawn.ss.lib.tools.StringHelper;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model.FieldDataTypeInterface;
import com.shawn.ss.lib.tools.db.impl.dao.AbstractDao;
import com.shawn.ss.lib.tools.db.impl.dao.DaoInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

public class MultiDaoBuilder extends AbstractDaoBuilder implements CodeBuilderInterface {

    public static final Logger L = LoggerFactory.getLogger(MultiDaoBuilder.class);

    private static final String FIELD_ASSEMBLE_NAME = "assembler";
    private static final String FIELD_SELECTED_FIELDS_NAME = "selectFields";
    private final JCodeModel cm;
    private final String serviceClassName;
    //    private final SelectMethodEnum modelSelectMethod;
    private final String mainTable;
    private final List<_BaseDaoConf> relatedTables;
    private final boolean buildNotAbstract;
    //    private final ModelBuilderContext builderContext;
    //    private final Map<String, TableInfoInterface> tbMap;
    //    private final Map<String, AbstractJClass> daos;
    //    private final Map<String, AbstractJClass> models;
    //    private final Map<String, ModelRelatedTableDef> defs;
    //    private final boolean listResult;
    private final _BaseDaoConf modelMulDaoConf;
    private final String mainModelFieldName;

    //    private final String PARAM_DAO_START = "start";
    //    private final String PARAM_DAO_COUNT = "count";
    JVar loggerField;
    JMethod afterPropertiesSet;
    JDefinedClass definedClass;
    AbstractJClass mainDaoClass;
    AbstractJClass mainModelClass;
    //    ComposedModelBuilder modelBuilder;

    Map<String, JFieldVar> daoFields;
    //
    JFieldVar mainDaoField;
    private AbstractJClass multiAsemmblerClz;
    private final _BaseDaoConf mainConf;

    private class BuildMethodParamHodler {
        SelectMethod modelSelectMethod;
        List<JVar> allVar;
        Map<String, JVar> mapVars;
        JVar otherTableAssembler, selectFields;
        JMethod mainSelectDaoMethod;
        AbstractJClass mainTableRetCls;
        AbstractJClass assemblerCls;
        boolean listResult;
        AbstractJType listRetType, listMainType;
        AbstractJType retType, mainType;
        String[] staticRoundFieldVar;
        JMethod assembleMainList, assembleMain;
        JVar mainDataVar;
        volatile int subIndex;
        String db;
        String table;


        public AbstractJType getRetType(boolean listResult) {
            AbstractJType retClass;
            if (listResult) {
                retClass = listRetType;
            } else {
                retClass = retType;
            }
            return retClass;
        }

        public AbstractJType getMainType(boolean listResult) {
            AbstractJType retClass;
            if (listResult) {
                retClass = listMainType;
            } else {
                retClass = mainType;
            }
            return retClass;
        }

        public void initClz(JCodeModel cm, AbstractJClass wrapperCls, AbstractJClass mainModelClass) {
            this.listRetType = CodeConstants.buildNarrowedClass(cm, List.class, wrapperCls);
            this.retType = wrapperCls;
            this.listMainType = CodeConstants.buildNarrowedClass(cm, List.class, mainModelClass);
            this.mainType = mainModelClass;
        }
    }

    private AbstractJClass wrapperCls;
    //    final boolean multiFieldFromSameTable;
    final String mainDb;
    //    private ComposedAssemblerBuilder assemblerBuilder;
    private final Collection<SelectMethod> mainModelSelectMethods;


    //    MultiDaoSelectServiceBuilder(
    ////            JCodeModel cm,
    //            String serviceClassName,
    //            String modelSelectMethod,
    //            String mainTable,
    //            List<ModelRelatedTableDef> relatedTables, boolean buildNotAbstract, ModelBuilderContext builderContext) {
    ////        this.cm = cm;
    //
    //    }

    public MultiDaoBuilder(_BaseDaoConf modelMulDaoConf) {
        super(modelMulDaoConf);
        this.modelMulDaoConf = modelMulDaoConf;
        //        modelMulDaoConf.init();
        //        multiFieldFromSameTable = modelMulDaoConf.isMultiFieldFromSameTable();
        mainModelSelectMethods = modelMulDaoConf.getMainModelSelectMethod();
        if (mainModelSelectMethods == null) {
            SelectMethodEnum[] values = SelectMethodEnum.values();
            for (SelectMethodEnum val : values) {
                if (!val.isSingleResult() && !val.isCount()) {
                    mainModelSelectMethods.add(val);
                }
            }
        }
        //        this.modelSelectMethod = modelMulDaoConf.getMainModelSelectMethod();
        this.mainDb = modelMulDaoConf.getDb();
        this.mainTable = modelMulDaoConf.getTable();
        this.relatedTables = modelMulDaoConf.getRelation();
        this.buildNotAbstract = modelMulDaoConf.buildAbstractDao();
        //                this.builderContext = modelMulDaoConf.getBuilderContext();
        String daoClzName = modelMulDaoConf.getDaoClzName();
        if (daoClzName == null)
            this.serviceClassName = CodeConstants.getMulSelectDaoClassName(
                    builderContext.getBasePackage(),
                    modelMulDaoConf.getTable()
            );
        else
            this.serviceClassName = daoClzName;
        //        this.tbMap = this.builderContext.getTbMap();
        //        this.listResult = modelMulDaoConf.isListResult();

        //        this.daos = CollectionHelper.newMap();
        //        this.models = CollectionHelper.newMap();
        //        this.defs = modelMulDaoConf.getDefs();

        this.cm = builderContext.getCm();
        this.multiAsemmblerClz = modelMulDaoConf.getDeclaredAssembler();
        this.wrapperCls = modelMulDaoConf.getDeclaredModel();
        this.mainModelFieldName = modelMulDaoConf.getField(0).getFieldName();
        this.mainConf = relatedTables.get(0);
        initAllDependentBuild();
        //        modelBuilder = new ComposedModelBuilder(modelMulDaoConf);

    }

    private void initAllDependentBuild() {
        int size = relatedTables.size();
        if (size == 0) {
            return;
        }
        for (int i = 0; i < size; ++i) {
            _BaseDaoConf baseSubDaoConf = relatedTables.get(i);
            if (baseSubDaoConf.getDeclaredDao() == null) {
                _BaseDaoConf.EnumFieldDataSrcType daoType = baseSubDaoConf.getDaoType();
                if (daoType == _BaseDaoConf.EnumFieldDataSrcType.commonDao)
                    builderContext.buildBaseModel(baseSubDaoConf);
                else if (daoType == _BaseDaoConf.EnumFieldDataSrcType.mulDao) {
                    builderContext.buildMultiSelectDao(baseSubDaoConf);
                } else if (daoType == _BaseDaoConf.EnumFieldDataSrcType.specialDao) {
                    builderContext.buildSpecialSelectDao(baseSubDaoConf);
                }
            }

        }
    }

    @Override
    public void buildModel() {
        if (modelMulDaoConf.getDeclaredDao() != null) {
            return;
        }
        L.info("build multidao : {} conf:{}", this.serviceClassName, modelMulDaoConf);
        int size = relatedTables.size();
        if (size == 0) {
            return;
        }
        //        modelBuilder.buildModel();
        //        assemblerBuilder = new ComposedAssemblerBuilder(modelMulDaoConf);
        //        assemblerBuilder.buildModel();
        buildClass();
        BuildMethodParamHodler holder = new BuildMethodParamHodler();

        holder.initClz(cm, wrapperCls, mainModelClass);

        String[] staticRoundFieldVar = new String[size];//assemblerBuilder.getStaticRoundFieldVar();
        //        staticRoundFieldVar[0] = CodeConstants.getFieldNameOfMulDaoRNDName(mainModelFieldName);
        for (int i = 0; i < size; ++i) {
            _BaseDaoConf baseSubDaoConf = relatedTables.get(i);
            _BaseRelationDef relation = baseSubDaoConf.getRelatedDef(name);
            staticRoundFieldVar[i] = CodeConstants.getFieldNameOfMulDaoRNDName(relation.getFieldName());
        }
        holder.staticRoundFieldVar = staticRoundFieldVar;
        //        int findex = 0;
        //        staticRoundFieldVar[findex] =multiAsemmblerClz.staticRef("");
        //                = definedClass.field(
        //                CodeHelper.MODE_PUBLIC_STATIC_FINAL, cm.INT,
        //                CodeHelper.getFieldNameOfMulDaoRNDName(modelMulDaoConf.getMainField()),
        //                JExpr.lit(findex)
        //        );
        //        for (ModelRelatedTableDef def : relatedTables) {
        //            ++findex;
        //            String fieldName = def.getFieldName();
        //            String s = CodeStyleTransformHelper.humpStyleToUnderlineSplittedStyle(fieldName).toUpperCase();
        //            JFieldVar fieldVar = multiAsemmblerClz.field(
        //                    CodeHelper.MODE_PUBLIC_STATIC_FINAL,
        //                    cm.INT,
        //                    CodeHelper.getFieldNameOfMulDaoRNDName(fieldName),
        //                    JExpr.lit(findex)
        //            );
        //            staticRoundFieldVar[findex] = fieldVar;
        //        }
        JMethod assembleMainList = buildAssembleMainToRet(true, holder);
        JMethod assembleMain = buildAssembleMainToRet(false, holder);
        for (SelectMethod modelSelectMethod : mainModelSelectMethods) {
            if (!modelSelectMethod.isCount() && !modelSelectMethod.isSingleResult()) {
                holder.modelSelectMethod = modelSelectMethod;
                holder.listResult = modelSelectMethod.isMultipleResult();
                holder.assemblerCls = multiAsemmblerClz;
                holder.assembleMain = assembleMain;
                holder.assembleMainList = assembleMainList;
                int index = 0;
                JMethod method = buildMethod(holder);
                if (method != null) {
                    ModelBuilderContext.registerMethod(method);
                    JMethod methodWithoutSelectFields = CodeConstants.buildReloadMethodWithoutCertainName(method, definedClass, CodeConstants.PARAM_DAO_SELECTED_FIELDS);
                    if (modelSelectMethod.isMultipleResult()) {
                        CodeConstants.buildReloadMethodWithoutCertainName(methodWithoutSelectFields, definedClass, CodeConstants.PARAM_DAO_START, CodeConstants.PARAM_DAO_COUNT);
                    }
                }
            }
            //        for(ModelBuilderContext.ParamDef pDef:methodDef){
            //            Class[] narrow = pDef.getNarrow();
            //            JVar param;
            //            if(narrow !=null){
            //
            //                param = method.param(CodeHelper.buildNarrowedClass(cm, pDef.getClz(), narrow), pDef.getName());
            //                allVar.add(param);
            //            }else{
            //                param = method.param(pDef.getClz(), pDef.getName());
            //                allVar.add(param);
            //            }
            //            if(pDef.getName().equals(FIELD_ASSEMBLE_NAME)){
            //                otherTableAssembler=param;
            //            }
            //        }

        }
        buildInsertOrUpdate(holder);
        buildListify();
        buildMapify(false);
        buildMapify(true);
        modelMulDaoConf.setDeclaredDao(definedClass);
    }

    private JMethod buildInsertOrUpdate(BuildMethodParamHodler holder) {

        List<String> tableOrderedList = sortTables(modelMulDaoConf);
        return null;
    }

    private List<String> sortTables(_BaseDaoConf modelMulDaoConf) {
        List<String> ret = CollectionHelper.newLinkedList();
        //        List<ModelRelatedTableDef> relatedTables = modelMulDaoConf.getRelatedTables();
        //        ret.add(mainTable);
        //        String idFieldNameInMainTable = builderContext.getIdFieldName(modelMulDaoConf.getDb(), modelMulDaoConf.getTable());
        //        for(ModelRelatedTableDef item:relatedTables){
        //            String table = item.getTable();
        //            String fieldInMainTable = item.getFieldInMainTable();
        //            String idFieldNameInThisTable = builderContext.getIdFieldName(item.getDb(), table);
        //            String fieldInThisTable = item.getFieldInThisTable();
        //            if(idFieldNameInThisTable!=null){
        //                boolean fieldOfMainIsId = fieldInMainTable.equals(idFieldNameInMainTable);
        //                boolean fieldInThidIsId = fieldInThisTable.equals(idFieldNameInThisTable);
        //                if(fieldOfMainIsId && !fieldInThidIsId){
        //                    ret.add(table);
        //                }
        //                if(!fieldOfMainIsId && fieldInThidIsId){
        //                    ret.add(0,table);
        //                }
        //                if(!fieldOfMainIsId && !fieldInThidIsId){
        //
        //                }
        //                if(fieldOfMainIsId && fieldInThidIsId){
        //
        //                }
        //            }
        //        }
        return ret;
    }

    private JMethod buildAssembleMainToRet(boolean listResult, BuildMethodParamHodler holder) {
        JMethod retMethod = definedClass.method(
                JMod.PROTECTED,
                cm.VOID,
                listResult ? CodeConstants.METHOD_SERVICE_ASSEMBLE_MAIN_DATA_LIST : CodeConstants.METHOD_SERVICE_ASSEMBLE_MAIN_DATA
        );
        JVar dataVar = retMethod.param(holder.getMainType(listResult), "mainModel");
        JVar retVar = retMethod.param(holder.getRetType(listResult), "ret");
        JBlock body = retMethod.body();
        buildIfMainModelEmptyTest(body, dataVar, listResult);

        if (listResult) {
            JForEach forEach = body.forEach(mainModelClass, "model", dataVar);
            JVar model = forEach.var();
            JBlock forEachBody = forEach.body();
            JVar wrapper = forEachBody.decl(wrapperCls, "wrapper", JExpr._new(wrapperCls));
            forEachBody.invoke(wrapper, CodeConstants.getMethodNameOfModelSet(mainModelFieldName)).arg(model);
            forEachBody.invoke(retVar, "add").arg(wrapper);
        } else {
            body.invoke(retVar, CodeConstants.getMethodNameOfModelSet(mainModelFieldName)).arg(dataVar);
        }
        return retMethod;
    }

    private JMethod buildGetSubModelUseInSelect(_BaseDaoConf conf, BuildMethodParamHodler holder) {
        final String db = conf.getDb();
        String table = conf.getTable();
        _BaseRelationDef def = conf.getRelatedDef(name);
        String fieldInMainTable = def.getFieldInRelatedTable();
        String fieldInThisTable = def.getFieldInThisTable();
        JVar listVar = null;
        JVar instanceVar = null;
        //        boolean isId = def.isFieldInThisTableIsId();
        boolean single = def.isSingle();
        AbstractJClass subModelClass = conf.getDeclaredModel();
        SelectMethodEnum subDaoSelectMethod = getSubSelectMethod(def, holder);
        String subDaoSelectMethodName = subDaoSelectMethod.getMethodName();
        String mName;

        mName = StringHelper.concat(
                CodeConstants.METHOD_SERVICE_GET_SUB_DATA_PREFIX,
                CodeStyleTransformHelper.upperFirstCase(def.getFieldName()), (single ? "" : "s"), "Via",
                CodeStyleTransformHelper.upperFirstCase(subDaoSelectMethodName)
        );

        JMethod method;
        AbstractJType retType = holder.getRetType(holder.listResult);
        method = definedClass.getMethod(
                mName,
                new AbstractJType[]{
                        holder.mainTableRetCls,
                        retType,
                        holder.selectFields.type(),
                        holder.otherTableAssembler.type()
                });
        if (method != null) {
            return method;
        }
        method = definedClass.method(JMod.PROTECTED, cm.VOID, mName);
        JVar dataVar = method.param(holder.mainTableRetCls, "mainData");
        JVar retVar = method.param(retType, "ret");
        JVar selectedFieldVar = method.param(holder.selectFields.type(), holder.selectFields.name());
        JVar assemberVar = method.param(holder.otherTableAssembler.type(), holder.otherTableAssembler.name());
        JFieldVar daoField = daoFields.get(table);
        JFieldRef mainBaseModelColumnStaticRef = getModelColumnStaticRef(fieldInMainTable, mainConf);
        JFieldRef subBaseModelColumnStaticRef = getModelColumnStaticRef(fieldInThisTable, conf);
        FieldDataTypeInterface fieldType = CodeConstants.getFieldType(db, table, fieldInThisTable);
        if (fieldType == null) {
            L.warn("not get type of {}.{}.{}", db, table, fieldInMainTable);
            L.warn("config is {}", modelMulDaoConf);
            throw new IllegalArgumentException(table + "数据表中字段" + fieldInThisTable + "不存在");
        }
        FieldDataTypeInterface mainFieldType = CodeConstants.getFieldType(mainDb, mainTable, fieldInMainTable);
        Class fieldTClass = fieldType.gettClass();
        if (!fieldTClass.equals(mainFieldType.gettClass())) {
            throw new IllegalArgumentException(mainTable + "数据表字段" + fieldInMainTable + "与" + table + "数据表中字段" + fieldInThisTable + "类型不匹配");
        }
        JBlock subBody = method.body();

        AbstractJClass fieldClzRef = cm.ref(fieldTClass);

        buildIfMainModelEmptyTest(subBody, dataVar, holder.listResult);
        /**
         * 生成必要参数
         *
         */


        if (subDaoSelectMethod.isCondition()) {
            instanceVar = subBody.decl(subModelClass, "instance", JExpr._new(subModelClass));
            if (single) {
                JVar mainId = subBody.decl(fieldClzRef, "mainAttr",
                        JExpr.invoke(dataVar, CodeConstants.getMethodNameOfModelGet(fieldInMainTable)));
                subBody.invoke(instanceVar, CodeConstants.getMethodNameOfModelSet(fieldInThisTable)).arg(mainId);
            }
            Map<String, String> additionalCondition = def.getAdditionalCondition();
            if (!CollectionHelper.isCollectionEmpty(additionalCondition)) {
                JVar otherDataVar = dataVar;
                if (holder.listResult) {
                    otherDataVar = subBody.decl(
                            mainModelClass,
                            dataVar.name() + "First",
                            JExpr.invoke(dataVar, "get").arg(JExpr.lit(0))
                    );
                }
                Set<Map.Entry<String, String>> entries = additionalCondition.entrySet();
                for (Map.Entry<String, String> cond : entries) {
                    final String condKey = cond.getKey();
                    final String value = cond.getValue();
                    final AbstractJType typeOfField = CodeConstants.getTypeOfField(cm, builderContext, db, mainTable, condKey);
                    if (typeOfField != null) {
                        JVar mainId = subBody.decl(
                                typeOfField, "mainAttr" + CodeStyleTransformHelper.upperFirstCase(condKey),
                                JExpr.invoke(otherDataVar, CodeConstants.getMethodNameOfModelGet(condKey))
                        );
                        subBody.invoke(instanceVar, CodeConstants.getMethodNameOfModelSet(value)).arg(mainId);
                    }
                }
            }
        }

        if (subDaoSelectMethod.isIndex()) {
            JInvocation mainInvoke;
            if (holder.listResult) {
                mainInvoke = JExpr.invoke(mainDaoField, CodeConstants.METHOD_DAO_BUILD_LIST).narrow(fieldClzRef)
                        .arg(dataVar).arg(mainBaseModelColumnStaticRef);
            } else {
                mainInvoke = JExpr.invoke(mainDaoField, CodeConstants.METHOD_DAO_BUILD_LIST).narrow(fieldClzRef)
                        .arg(cm.ref(Collections.class).staticInvoke("singletonList").arg(dataVar))
                        .arg(mainBaseModelColumnStaticRef);
            }
            // tricks : replace the subbody
            AbstractJClass listType = CodeConstants.buildNarrowedClass(cm, List.class, fieldTClass);
            Integer batchSize = def.getBatchSize();
            if (batchSize > 0) {
                JVar allList = subBody.decl(listType, "list", mainInvoke);
                JVar sizeVar = subBody.decl(cm.ref(Integer.class), "size", JExpr.invoke(allList, "size"));
                JVar startIdx = subBody.decl(cm.ref(Integer.class), "startIdx", JExpr.lit(0));
                JWhileLoop jWhileLoop = subBody._while(startIdx.lt(sizeVar));
                subBody = jWhileLoop.body();
                JVar endIdx = subBody.decl(
                        cm.ref(Integer.class),
                        "endIdx",
                        cm.ref(Math.class).staticInvoke("min").arg(startIdx.plus(JExpr.lit(batchSize))).arg(sizeVar.minus(1))
                );
                JInvocation expr = JExpr.invoke(allList, "subList").arg(startIdx).arg(endIdx);
                listVar = subBody.decl(listType, "subList", expr);
                subBody.assign(startIdx, endIdx.plus(1));
            } else {
                listVar = subBody.decl(listType, "list", mainInvoke);
            }
        }

        /**
         * 处理批次
         */


        /**
         * 生成调用
         */
        JInvocation invoke = null;
        MethodTypeEnum methodType = getSubSelectMethodType(conf);
        JMethod subDaoMethod = ClassDataTable.getMethod(
                methodType,
                daoField.type().name(),
                subDaoSelectMethodName
        );
        JVar[] jVars = subDaoMethod.listParams();
        invoke = JExpr.invoke(daoField, subDaoSelectMethodName);
        for (JVar var : jVars) {
            AbstractJType type = var.type();
            String name = var.name();
            if (type.isAssignableFrom(assemberVar.type())) {
                invoke.arg(assemberVar);
            } else if (type.isAssignableFrom(selectedFieldVar.type()) && name.equals(CodeConstants.PARAM_DAO_SELECTED_FIELDS)) {
                invoke.arg(selectedFieldVar);
            } else if (type.isAssignableFrom(CodeConstants.buildNarrowedClass(cm, List.class, fieldClzRef))) {
                invoke.arg(listVar);
            } else if (type.name().equals(subModelClass.name()) && name.equals(CodeConstants.PARAM_DAO_INSTANCE)) {
                invoke.arg(instanceVar);
            } else if (type.isAssignableFrom(cm.ref(String.class)) && name.equals(CodeConstants.PARAM_DAO_INDEX_IN_FIELD)) {
                invoke.arg(subBaseModelColumnStaticRef);
            } else if (
                    type.isAssignableFrom(CodeConstants.buildNarrowedClass(cm, Set.class, String.class))
                            && name.equals(CodeConstants.PARAM_DAO_EXT_CONDITION)
                            && def.getAdditionalWhere() != null
            ) {
                invoke.arg(cm.ref(Collections.class).staticInvoke("singleton").arg(JExpr.lit(def.getAdditionalWhere())));
            } else {
                invoke.arg(JExpr._null());
            }
        }


        /**
         * 组装结果
         */
        if (holder.listResult) {

            JVar subModels = subBody.decl(CodeConstants.buildNarrowedClass(cm, List.class, subModelClass), "subModels", invoke);
            JMethod jMethod = buildAssembleSubResultToRets(conf, holder);
            subBody.invoke(jMethod).arg(subModels).arg(retVar);
        } else {
            AbstractJClass subClz = null;
            if (single) {
                subClz = subModelClass;
                JVar subModel = subBody.decl(subClz, "subModel", invoke);
                JMethod jMethod = buildAssembleSubResultToRet(conf, holder);
                subBody.invoke(jMethod).arg(subModel).arg(retVar);
            } else {
                subClz = CodeConstants.buildNarrowedClass(cm, List.class, subModelClass);
                JVar subModel = subBody.decl(subClz, "subModel", invoke);
                JMethod jMethod = buildAssembleSubResultToRet(conf, holder);
                subBody.invoke(jMethod).arg(subModel).arg(retVar);
            }

            //            subBody.invoke(retVar, modelSet).arg(subModel);
        }
        /**
         * end build method
         */
        return method;

    }

    private JFieldRef getModelColumnStaticRef(String fieldInThisTable, _BaseDaoConf conf) {
        AbstractJClass mclz = null;
        _BaseDaoConf.EnumFieldDataSrcType daoType = conf.getDaoType();
        if (daoType == _BaseDaoConf.EnumFieldDataSrcType.commonDao) {
            mclz = conf.getDeclaredModel();
            return CodeConstants.getBaseModelColumnStaticRef(mclz, fieldInThisTable);
        } else {
            if (daoType == _BaseDaoConf.EnumFieldDataSrcType.mulDao) {
                _BaseDaoConf relation = conf.getRelation(0);
                if (relation == null) {
                    throw new IllegalStateException("muldao not contain main table?" + conf.getName());
                }
                return getModelColumnStaticRef(fieldInThisTable, relation);
            }
        }
        throw new IllegalStateException("conf " + conf.getName() + " has no available info , error occured");
    }

    private MethodTypeEnum getSubSelectMethodType(_BaseDaoConf conf) {
        return conf.getDaoType() == _BaseDaoConf.EnumFieldDataSrcType.mulDao ? MethodTypeEnum.MUL_DAO_METHOD : MethodTypeEnum.DAO_METHOD;
    }

    private JMethod buildAssembleSubResultToRet(_BaseDaoConf conf, BuildMethodParamHodler holder) {
        _BaseRelationDef def = conf.getRelatedDef(name);
        boolean single = def.isSingle();
        String mName;
        AbstractJClass subClz = null;
        String table = conf.getTable();
        AbstractJClass subModelClass = conf.getDeclaredModel();
        if (single) {
            subClz = subModelClass;
        } else {
            subClz = CodeConstants.buildNarrowedClass(cm, List.class, subModelClass);
        }
        AbstractJType retType = holder.getRetType(holder.listResult);
        mName = StringHelper.concat(
                CodeConstants.METHOD_SERVICE_ASSEMBLE_SUB_DATA_PREFIX,
                CodeStyleTransformHelper.upperFirstCase(def.getFieldName()), (single ? "" : "s"),
                "ToRet"
        );
        String modelSet = CodeConstants.getMethodNameOfModelSet(def.getFieldName());
        JMethod method = definedClass.getMethod(mName, new AbstractJType[]{subClz, retType});
        if (method == null) {
            method = definedClass.method(JMod.PROTECTED, cm.VOID, mName);
            JVar subDataVar = method.param(subClz, "subData");
            JVar retVar = method.param(retType, "ret");
            method.body().invoke(retVar, modelSet).arg(subDataVar);
        }
        return method;
    }

    private JMethod buildAssembleSubResultToRets(_BaseDaoConf conf, BuildMethodParamHodler holder) {
        _BaseRelationDef def = conf.getRelatedDef(name);
        final String db = conf.getDb();
        final String table = conf.getTable();
        String fieldInMainTable = def.getFieldInRelatedTable();
        String fieldInThisTable = def.getFieldInThisTable();
        //        String table = def.getRelatedDaoConf().getTable();
        //        boolean isId = def.isFieldInThisTableIsId();
        boolean single = def.isSingle();
        AbstractJType retType = holder.getRetType(holder.listResult);
        JFieldVar daoField = daoFields.get(table);
        AbstractJClass subModelClass = conf.getDeclaredModel();
        FieldDataTypeInterface mainFieldType = CodeConstants.getFieldType(mainDb, mainTable, fieldInMainTable);
        JFieldRef mainBaseModelColumnStaticRef = getModelColumnStaticRef(fieldInMainTable, mainConf);
        JFieldRef subBaseModelColumnStaticRef = getModelColumnStaticRef(fieldInThisTable, conf);

        FieldDataTypeInterface fieldType = CodeConstants.getFieldType(db, table, fieldInThisTable);
        String modelSet = CodeConstants.getMethodNameOfModelSet(def.getFieldName());
        if (fieldType == null) {
            L.warn("not get type of {}.{}.{}", db, table, fieldInMainTable);
            L.warn("config is {}", modelMulDaoConf);
            throw new IllegalArgumentException(table + "数据表中字段" + fieldInThisTable + "不存在");
        }
        Class fieldTClass = fieldType.gettClass();
        if (!fieldTClass.equals(mainFieldType.gettClass())) {
            throw new IllegalArgumentException(mainTable + "数据表字段" + fieldInMainTable + "与" + table + "数据表中字段" + fieldInThisTable + "类型不匹配");
        }

        AbstractJClass fieldClzRef = cm.ref(fieldTClass);

        AbstractJType subClz = CodeConstants.buildNarrowedClass(cm, List.class, subModelClass);
        String mName;

        mName = StringHelper.concat(
                CodeConstants.METHOD_SERVICE_ASSEMBLE_SUB_DATA_PREFIX,
                CodeStyleTransformHelper.upperFirstCase(def.getFieldName()), (single ? "" : "s"), "ToRets"
        );
        JMethod method = definedClass.getMethod(mName, new AbstractJType[]{subClz, retType});
        if (method == null) {
            method = definedClass.method(JMod.PROTECTED, cm.VOID, mName);
            JVar subDataVar = method.param(CodeConstants.buildNarrowedClass(cm, List.class, subModelClass), "subData");
            JVar retVar = method.param(retType, "ret");

            JBlock subBody = method.body();
            AbstractJClass subMapClz = null;
            String subAssembleMethod = null;
            if (single) {
                subMapClz = CodeConstants.buildNarrowedClass(cm, Map.class, fieldClzRef, subModelClass);
                subAssembleMethod = CodeConstants.METHOD_DAO_BUILD_MAP;
            } else {
                subMapClz = CodeConstants.buildNarrowedClass(cm, Map.class, fieldTClass, CodeConstants.buildNarrowedClass(cm, List.class, subModelClass));
                subAssembleMethod = CodeConstants.METHOD_DAO_BUILD_LIST_MAP;
            }
            JInvocation subInvocation = JExpr.invoke(daoField, subAssembleMethod).arg(subDataVar).arg(subBaseModelColumnStaticRef);
            JVar subModelMap = subBody.decl(subMapClz, "subModelMap", subInvocation);
            JForEach forEach = subBody.forEach(wrapperCls, "wrapper", retVar);
            JVar loopVar = forEach.var();
            JBlock forBody = forEach.body();
            JVar mainId = forBody.decl(fieldClzRef, "mainId",
                    JExpr.invoke(loopVar, CodeConstants.getMethodNameOfModelGet(mainModelFieldName))
                            .invoke(CodeConstants.getMethodNameOfModelGet(fieldInMainTable)));
            forBody.invoke(loopVar, modelSet)
                    .arg(JExpr.invoke(subModelMap, "get").arg(mainId));
        }
        return method;
    }

    private void buildIfMainModelEmptyTest(JBlock subBody, JVar dataVar, boolean listResult) {
        if (listResult)
            subBody._if(dataVar.eq(JExpr._null()).cor(JExpr.invoke(dataVar, "size").eq(JExpr.lit(0))))._then()._return();
        else
            subBody._if(dataVar.eq(JExpr._null()))._then()._return();
    }

    private SelectMethodEnum getSubSelectMethod(
            _BaseRelationDef def, BuildMethodParamHodler hodler
    ) {
        boolean single = def.isSingle();
        //        boolean isId=def.isFieldInThisTableIsId();
        boolean listResult = hodler.listResult;
        //        return (single && !listResult) ? CodeHelper.METHOD_DAO_COMMON_SELECT_ONE : CodeHelper.METHOD_DAO_COMMON_SELECT_LIST;
        boolean hasWhere = def.getAdditionalWhere() != null;
        boolean hasCondition = !CollectionHelper.isCollectionEmpty(def.getAdditionalCondition());
        if (single) {
            if (listResult) {
                if (hasCondition && hasWhere) {
                    return SelectMethodEnum.getByIndexAndConditionAndRawCondition;
                } else if (hasCondition) {
                    return SelectMethodEnum.getByIndexAndCondition;
                } else if (hasWhere) {
                    return SelectMethodEnum.getByIndexAndRawCondition;
                } else {
                    return SelectMethodEnum.getByIndex;
                }
            } else {
                if (hasWhere) {
                    return SelectMethodEnum.getOneByConditionAndRawCondition;
                } else {
                    return SelectMethodEnum.getOneByCondtion;
                }
            }
        } else {
            if (listResult) {
                if (hasCondition && hasWhere) {
                    return SelectMethodEnum.getByIndexAndConditionAndRawCondition;
                } else if (hasCondition) {
                    return SelectMethodEnum.getByIndexAndCondition;
                } else if (hasWhere) {
                    return SelectMethodEnum.getByIndexAndRawCondition;
                } else {
                    return SelectMethodEnum.getByIndex;
                }
            } else {
                if (hasCondition && hasWhere) {
                    return SelectMethodEnum.getByIndexAndConditionAndRawCondition;
                } else if (hasCondition) {
                    return SelectMethodEnum.getByIndexAndCondition;
                } else if (hasWhere) {
                    return SelectMethodEnum.getByIndexAndRawCondition;
                } else {
                    return SelectMethodEnum.getByIndex;
                }
            }
        }
        //        if (def.is && !list) {
        //            return SelectMethod.makeUpMethodName(SelectMethodEnum.getOneById);
        //        } else if (isId && list) {
        //            return SelectMethod.makeUpMethodName(SelectMethodEnum.getByIds);
        //        } else if (!isId && !list) {
        //            if (single)
        //                return SelectMethod.makeUpMethodName(SelectMethodEnum.getOneByCondtion);
        //            else
        //                return SelectMethod.makeUpMethodName(SelectMethodEnum.getByCondition);
        //        } else {
        //            return SelectMethod.makeUpMethodName(SelectMethodEnum.getByIndex);
        //        }
        //        return null;
    }


    private JMethod buildMethod(BuildMethodParamHodler holder) {
        definedClass.addImport(mainModelClass.fullName());
        boolean listResult = holder.listResult;

        //        Set<Map.Entry<String, AbstractJClass>> entries = models.entrySet();
        for (_BaseDaoConf entry : relatedTables) {
            definedClass.addImport(entry.getPojoClzName());
            definedClass.addImport(entry.getDaoClzName());
        }

        JMethod method = definedClass.method(
                JMod.PUBLIC,
                listResult ? holder.listRetType : holder.retType,
                holder.modelSelectMethod.getMethodName()
                //                CodeHelper.METHOD_SERVICE_GET_DATA
        );
        //        List<ModelBuilderContext.ParamDef> methodDef = ModelBuilderContext.getMethodDef(modelSelectMethod);
        holder.allVar = CollectionHelper.newList();
        holder.otherTableAssembler = null;
        holder.mainSelectDaoMethod = ClassDataTable.getMethod(
                MethodTypeEnum.DAO_METHOD,
                mainDaoClass.name(),
                holder.modelSelectMethod.getMethodName()
        );
        if (holder.mainSelectDaoMethod == null) {
            //            return null;
            throw new IllegalStateException("无法找到对应方法，请检查是否生成了基本类型");
        }

        CodeConstants.copyMethodParam(holder.mainSelectDaoMethod, method, holder.allVar, new CodeConstants.StringParamFilter() {
            @Override
            public boolean accept(JVar var, int i) {
                boolean b = !var.name().equals(FIELD_ASSEMBLE_NAME);
                if (!b) {
                    JVar assemblerVar = method.param(holder.assemblerCls, FIELD_ASSEMBLE_NAME);
                    holder.allVar.add(assemblerVar);
                }
                return b;
            }
        });

        for (JVar var : holder.allVar) {
            String name = var.name();
            if (name.equals(FIELD_ASSEMBLE_NAME)) {
                holder.otherTableAssembler = var;
            } else if (name.equals(FIELD_SELECTED_FIELDS_NAME)) {
                holder.selectFields = var;
            }
        }
        JBlock body = method.body();
        JInvocation initInvocation = null;
        //            boolean listResult = modelSelectMethod.isMultipleResult();
        if (holder.listResult)
            initInvocation = cm.ref(CollectionHelper.class).staticInvoke("newList");
        else
            initInvocation = JExpr._new(wrapperCls);

        JVar ret = body.decl(method.type(), "ret", initInvocation);
        body.invoke(holder.otherTableAssembler, "clearData");
        if (listResult) {
            body.invoke(holder.otherTableAssembler, CodeConstants.KEY_WORD_SET + CodeStyleTransformHelper.upperFirstCase("rets")).arg(ret);
        } else {
            body.invoke(holder.otherTableAssembler, CodeConstants.KEY_WORD_SET + CodeStyleTransformHelper.upperFirstCase("ret")).arg(ret);
        }
        JMethod getMain = buildGetMainModel(holder);
        JInvocation invoke = JExpr.invoke(getMain);
        int index = 0;
        body.invoke(holder.otherTableAssembler, CodeConstants.METHOD_ASSEMBLER_SET_INDEX).arg(holder.assemblerCls.staticRef(holder.staticRoundFieldVar[index]));
        for (JVar var : holder.allVar) {
            invoke.arg(var);
        }
        JVar allMainList = body.decl(getMain.type(), "mainModel", invoke);

        body.invoke(holder.listResult ? holder.assembleMainList : holder.assembleMain).arg(allMainList).arg(ret);
        holder.mainDataVar = allMainList;

        for (_BaseDaoConf def : relatedTables) {
            _BaseRelationDef relatedDef = def.getRelatedDef(name);
            if (!relatedDef.isMain()) {
                body.invoke(holder.otherTableAssembler, CodeConstants.METHOD_ASSEMBLER_SET_INDEX)
                        .arg(holder.assemblerCls.staticRef(holder.staticRoundFieldVar[index]));
                holder.subIndex = index;
                JMethod subMethod = buildGetSubModelUseInSelect(def, holder);
                body.invoke(subMethod).arg(allMainList).arg(ret).arg(holder.selectFields).arg(holder.otherTableAssembler);
            }
            ++index;
        }
        body._return(ret);
        return method;
    }

    //    private JMethod buildGetRelatedModel(ModelRelatedTableDef modelDef, JBlock body, JVar allMainList, JVar mainIdList, JVar otherTableAssembler) {
    //        String fieldInThisTable = modelDef.getFieldInThisTable();
    //        String table = modelDef.getTable();
    //        AbstractJClass dao = daos.get(table);
    //        AbstractJClass model = models.get(table);
    //        JFieldVar daoField = daoFields.get(table);
    //        TableInfoInterface tableInfo = tbMap.get(table);
    //        JFieldRef staticRef = CodeHelper.getBaseModelColumnStaticRef(model, fieldInThisTable);
    //        JInvocation arg = JExpr.invoke(daoField, CodeHelper.METHOD_DAO_GET_BY_INDEXES).arg(JExpr._null()).arg(JExpr._null())
    //                .arg(JExpr._null()).arg(otherTableAssembler).arg(staticRef).arg(mainIdList);
    //        JVar list = body.decl(CodeHelper.buildNarrowedClass(cm, List.class, model), "rt" + CodeStyleTransformHelper.upperFirstCase(table) + "List", arg);
    //        ColumnInfoInterface type = findColumnType(tableInfo, fieldInThisTable);
    //        Class fieldClz = type.getDataType().gettClass();
    //        JVar mapVar = body.decl(CodeHelper.buildNarrowedClass(cm, Map.class, fieldClz, CodeHelper.buildNarrowedClass(cm, List.class, model)),
    //                "rt" + CodeStyleTransformHelper.upperFirstCase(table) + "Map",
    //                daoField.invoke(CodeHelper.METHOD_DAO_BUILD_LIST_MAP).narrow(cm.ref(fieldClz)).arg(list).arg(staticRef));
    //        if (mapVars == null) {
    //            mapVars = CollectionHelper.newMap();
    //        }
    //        mapVars.put(table, mapVar);
    //        return null;
    //    }

    //    private ColumnInfoInterface findColumnType(TableInfoInterface tableInfo, String fieldInThisTable) {
    //        List<ColumnInfoInterface> columns = tableInfo.getColumns();
    //        for (ColumnInfoInterface col : columns) {
    //            if (col.getFieldName().equals(fieldInThisTable)) {
    //                return col;
    //            }
    //        }
    //        return null;
    //    }

    private JMethod buildGetMainModel(BuildMethodParamHodler holder) {
        boolean listResult = holder.modelSelectMethod.isMultipleResult();
        //        AbstractJClass mainTableRetCls;
        if (listResult) {
            holder.mainTableRetCls = CodeConstants.buildNarrowedClass(cm, List.class, mainModelClass);
        } else {
            holder.mainTableRetCls = mainModelClass;
        }
        String methodName = CodeConstants.METHOD_SERVICE_GET_MAIN_DATA_PREFIX
                + CodeStyleTransformHelper.upperFirstCase(holder.modelSelectMethod.getMethodName());
        List<JVar> jVars = holder.mainSelectDaoMethod.params();
        int size = jVars.size();
        AbstractJType[] types = new AbstractJType[size];
        for (int i = 0; i < size; i++) {
            JVar var = jVars.get(i);
            types[i] = var.type();
        }
        JMethod method;
        method = definedClass.getMethod(methodName, types);
        if (method == null) {
            method = definedClass.method(
                    JMod.PROTECTED,
                    holder.mainTableRetCls,
                    methodName
            );
            JBlock body = method.body();
            CodeConstants.copyMethodParam(holder.mainSelectDaoMethod, method, null);
            //        mainSelectDaoMethod.param(cm.ref(AbstractMultipleDaoAssembler.class),"assembler");
            JInvocation invoke = mainDaoField.invoke(holder.modelSelectMethod.getMethodName());
            for (JVar var : holder.allVar) {
                invoke.arg(var);
            }
            JVar allMainList = body.decl(holder.mainTableRetCls, "allMainList", invoke);
            body._return(allMainList);
        }
        return method;
    }

    private void buildClass() {
        try {
            if (buildNotAbstract) definedClass = cm._class(serviceClassName);
            else definedClass = cm._class(JMod.PUBLIC + JMod.ABSTRACT, serviceClassName);
            loggerField = definedClass.field(CodeConstants.MODE_PUBLIC_STATIC_FINAL, cm.ref(Logger.class), CodeConstants.FIELD_DAO_LOGGER,
                    cm.ref(LoggerFactory.class).staticInvoke("getLogger").arg(JExpr.dotclass(definedClass)));

            definedClass._implements(InitializingBean.class);
            FieldDataTypeInterface idFieldType = CodeConstants.getIdFieldType(mainDb, mainTable);
            AbstractJType idType = cm.ref(idFieldType.gettClass());
            definedClass._implements(CodeConstants.buildNarrowedClass(cm, DaoInterface.class, wrapperCls, idType));
            if (modelMulDaoConf.getAssemblerExtendClzName() != null && !buildNotAbstract) {
                //                definedClass._implements(cm.ref(modelMulDaoConf.getImplInterface()));
                definedClass._extends(CodeConstants.buildNarrowedClass(cm, cm.ref(modelMulDaoConf.getAssemblerExtendClzName()), wrapperCls, idType));
            } else {
                definedClass._extends(CodeConstants.buildNarrowedClass(cm, AbstractDao.class, wrapperCls, idType));
            }
            definedClass.annotate(cm.ref(SuppressWarnings.class)).param("value", "unchecked");//.annotationParam(cm.ref(String.class),JExpr.lit("unchecked"))
            afterPropertiesSet = definedClass.method(JMod.PUBLIC, cm.VOID, CodeConstants.METHOD_SPRING_BEAN_AFTER_PROPERTIES_SET);
            afterPropertiesSet.annotate(Override.class);
            afterPropertiesSet._throws(Exception.class);
            JMethod constructor = definedClass.constructor(JMod.PUBLIC);
            constructor.annotate(Autowired.class);
            JBlock constructorBody = constructor.body();
            constructorBody.invoke("super").arg(JExpr.dotclass(wrapperCls)).arg(JExpr._null());
            if (buildNotAbstract) {
                //                definedClass.annotate(Repository.class);
                JAnnotationUse annotate = definedClass.annotate(Repository.class);
                annotate.param("value", CodeConstants.getClassNameFromFullName(serviceClassName));
            }
            //            mainDaoClass = cm.ref(CodeConstants.getDaoClassName(builderContext.getBasePackage(), mainTable));
            //            mainModelClass = cm.ref(CodeConstants.getModelClassName(builderContext.getBasePackage(), mainTable, null));
            //            String tbMName = CodeConstants.getClazzNameFromTableName(mainTable);
            //
            //            mainDaoField = definedClass.field(JMod.PROTECTED+JMod.FINAL, mainDaoClass, "dao" + tbMName);
            //            mainDaoField.annotate(Autowired.class);

            daoFields = CollectionHelper.newMap();
            for (_BaseDaoConf def : relatedTables) {
                String table = def.getTable();
                String tbName = CodeConstants.getClazzNameFromTableName(table);
                //                defs.put(table,modelDef);
                //                AbstractJClass daoClass = cm.ref(builderContext.getDaoClassName(table));
                //                daos.put(table, daoClass);
                //                AbstractJClass modelClass = cm.ref(builderContext.getModelClassName(table));
                //                models.put(table, modelClass);
                AbstractJClass daoClass = def.getDeclaredDao();
                Map<String, JFieldVar> fields = definedClass.fields();
                String daoName = "dao" + tbName;

                JFieldVar fieldVar;
                if (fields.containsKey(daoName)) {
                    fieldVar = fields.get(daoName);
                } else {
                    fieldVar = definedClass.field(JMod.PROTECTED, daoClass, daoName);
                    //                    fieldVar.annotate(Autowired.class);
                }
                JVar param = constructor.param(daoClass, "l" + daoName);
                constructorBody.assign(fieldVar, param);
                daoFields.put(table, fieldVar);
                if (table.equals(mainTable)) {
                    mainDaoClass = daoClass;
                    mainModelClass = def.getDeclaredModel();
                    mainDaoField = fieldVar;
                }
            }
        } catch (JClassAlreadyExistsException e) {
            e.printStackTrace();
        }
    }

    private void buildListify() {
        JDirectClass genericType = cm.directClass("TT");
        AbstractJClass retClass = CodeConstants.buildNarrowedClass(cm, List.class, genericType);
        AbstractJClass paramListCls = CodeConstants.buildNarrowedClass(cm, List.class, wrapperCls);
        JMethod method = definedClass.method(JMod.PUBLIC, retClass, CodeConstants.METHOD_DAO_BUILD_LIST);
        JTypeVar tt = method.generify("TT");
        JVar list = method.param(paramListCls, "list");
        JVar field = method.param(cm.ref(String.class), "field");
        JBlock body = method.body();
        JVar ret = body.decl(retClass, "ret", cm.ref(CollectionHelper.class).staticInvoke("newList"));
        body._if(list.eq(JExpr._null()).cor(list.invoke("size").eq(JExpr.lit(0))))._then()._return(ret);
        JBlock then = body._if(mainModelClass.staticRef(CodeConstants.FIELD_FIELDS_CLASS_CONSTANT_MAP).invoke("containsKey").arg(field))._then();
        JForEach forEach = then.forEach(wrapperCls, "item", list);
        JVar var = forEach.var();
        JBlock block = forEach.body();
        JVar mainVar = block.decl(mainModelClass, "mainVar",
                JExpr.invoke(var, CodeConstants.getMethodNameOfModelGet(mainModelFieldName))
        );
        JInvocation fieldCommonMapper = CodeConstants.getCommonFieldMapper(mainConf.getName(), constantClz);
        block.invoke(ret, "add").arg(
                //                constantClz.staticRef(CodeConstants.getFieldNameOfCommonMapperForModel(name))
                fieldCommonMapper
                        .invoke(CodeConstants.METHOD_JEDIS_MAPPER_GET_FIELD).narrow(genericType).arg(field).arg(mainVar)
        );
        body._return(ret);
    }


    /**
     * <T> Map<T,ModelStrategy> buildMap(String field,List<ModelStrategy> list){
     * Map<T,ModelStrategy> ret=CollectionHelper.newMap();
     * for(ModelStrategy item:list){
     * ret.put(ModelStrategy.MAP_OBJ_MAPPER.<T>getField(field,item),item);
     * }
     * return ret;
     * }
     *
     * @param isItemList
     */
    private void buildMapify(boolean isItemList) {
        JDirectClass genericType = cm.directClass("TT");
        AbstractJClass retClass;
        AbstractJClass retListType = CodeConstants.buildNarrowedClass(cm, List.class, wrapperCls);
        if (!isItemList) {
            retClass = CodeConstants.buildNarrowedClass(cm, Map.class, genericType, wrapperCls);
        } else {
            retClass = CodeConstants.buildNarrowedClass(cm, Map.class, genericType, retListType);
        }
        JMethod method = definedClass.method(JMod.PUBLIC, retClass, isItemList ? CodeConstants.METHOD_DAO_BUILD_LIST_MAP : CodeConstants.METHOD_DAO_BUILD_MAP);
        JTypeVar tType = method.generify("TT");
        JVar list = method.param(retListType, "list");
        JVar field = method.param(cm.ref(String.class), "field");
        JBlock body = method.body();

        JVar ret = body.decl(retClass, "ret", cm.ref(CollectionHelper.class).staticInvoke("newMap"));
        body._if(list.eq(JExpr._null()))._then()._return(ret);
        JBlock then = body._if(mainModelClass.staticRef(CodeConstants.FIELD_FIELDS_CLASS_CONSTANT_MAP).invoke("containsKey").arg(field))._then();

        JForEach forEach = then.forEach(wrapperCls, "item", list);
        JVar var = forEach.var();

        JBlock block = forEach.body();
        JVar mainVar = block.decl(mainModelClass, "mainVar", JExpr.invoke(var, CodeConstants.getMethodNameOfModelGet(mainModelFieldName)));
        JInvocation fieldCommonMapper = CodeConstants.getCommonFieldMapper(mainConf.getName(), constantClz);
        JInvocation arg = /*constantClz.staticRef(CodeConstants.getFieldNameOfCommonMapperForModel(name))*/
                JExpr.invoke(fieldCommonMapper, CodeConstants.METHOD_JEDIS_MAPPER_GET_FIELD).narrow(genericType).arg(field).arg(mainVar);
        JVar jVar = block.decl(tType, "fd", arg);
        if (!isItemList) {
            block.invoke(ret, "put")
                    .arg(jVar)
                    .arg(var);
        } else {
            JVar itemList = block.decl(retListType, "itemList", JExpr.invoke(ret, "get").arg(jVar));
            block._if(itemList.eq(JExpr._null()))._then().assign(itemList, cm.ref(CollectionHelper.class).staticInvoke("newList"));
            block.invoke(itemList, "add").arg(var);
            block.invoke(ret, "put")
                    .arg(jVar)
                    .arg(itemList);
        }
        body._return(ret);
    }

}
