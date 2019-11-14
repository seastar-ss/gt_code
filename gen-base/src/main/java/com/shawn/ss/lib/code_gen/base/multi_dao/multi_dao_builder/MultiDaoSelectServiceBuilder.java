package com.shawn.ss.lib.code_gen.base.multi_dao.multi_dao_builder;

import com.helger.jcodemodel.*;
import com.shawn.ss.gen.api.conf.SelectMethodEnum;
import com.shawn.ss.lib.code_gen.CodeBuilderInterface;

import com.shawn.ss.lib.code_gen.base.helper.CodeHelper;
import com.shawn.ss.lib.code_gen.base.helper.data_store.ClassDataTable;
import com.shawn.ss.lib.code_gen.base.helper.ModelBuilderContext;
import com.shawn.ss.lib.code_gen.model.MethodTypeEnum;
import com.shawn.ss.lib.code_gen.base.multi_dao.composed_model_builder.ComposedModelBuilder;
import com.shawn.ss.lib.code_gen.base.multi_dao.multi_assemble_builder.ComposedAssemblerBuilder;
import com.shawn.ss.lib.code_gen.model.def_model.dao_def.ModelRelatedTableDef;
import com.shawn.ss.lib.code_gen.model.def_model.dao_def.ModelMulDaoConf;
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

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MultiDaoSelectServiceBuilder implements CodeBuilderInterface {

    public static final Logger L = LoggerFactory.getLogger(MultiDaoSelectServiceBuilder.class);

    private static final String FIELD_ASSEMBLE_NAME = "assembler";
    private static final String FIELD_SELECTED_FIELDS_NAME = "selectFields";
    private final JCodeModel cm;
    private final String serviceClassName;
    //    private final SelectMethodEnum modelSelectMethod;
    private final String mainTable;
    private final List<ModelRelatedTableDef> relatedTables;
    private final boolean buildNotAbstract;
    private final ModelBuilderContext modelBuilderContext;
    //    private final Map<String, TableInfoInterface> tbMap;
    private final Map<String, AbstractJClass> daos;
    private final Map<String, AbstractJClass> models;
    private final Map<String, ModelRelatedTableDef> defs;
    //    private final boolean listResult;
    private final ModelMulDaoConf modelMulDaoConf;


//    private final String PARAM_DAO_START = "start";
//    private final String PARAM_DAO_COUNT = "count";
    JVar loggerField;
    JMethod afterPropertiesSet;
    JDefinedClass definedClass;
    AbstractJClass mainDaoClass;
    AbstractJClass mainModelClass;
    ComposedModelBuilder modelBuilder;

    Map<String, JFieldVar> daoFields;
    //
    JFieldVar mainDaoField;

    public class BuildMethodParamHodler {
        SelectMethodEnum modelSelectMethod;
        List<JVar> allVar;
        Map<String, JVar> mapVars;
        private JVar otherTableAssembler, selectFields;
        private JMethod mainSelectDaoMethod;
        AbstractJClass mainTableRetCls;
        JDefinedClass assemblerCls;
        boolean listResult;
        AbstractJType listRetType, listMainType;
        AbstractJType retType, mainType;
        JFieldVar[] staticRoundFieldVar;
        JMethod assembleMainList, assembleMain;
        public JVar mainDataVar;


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
            this.listRetType = CodeHelper.buildNarrowedClass(cm, List.class, wrapperCls);
            this.retType = wrapperCls;
            this.listMainType = CodeHelper.buildNarrowedClass(cm, List.class, mainModelClass);
            this.mainType = mainModelClass;
        }
    }

    private AbstractJClass wrapperCls;
    final boolean multiFieldFromSameTable;
    final String mainDb;
    private ComposedAssemblerBuilder assemblerBuilder;
    private final List<SelectMethodEnum> mainModelSelectMethods;


//    MultiDaoSelectServiceBuilder(
////            JCodeModel cm,
//            String serviceClassName,
//            String modelSelectMethod,
//            String mainTable,
//            List<ModelRelatedTableDef> relatedTables, boolean buildNotAbstract, ModelBuilderContext modelBuilderContext) {
////        this.cm = cm;
//
//    }

    public MultiDaoSelectServiceBuilder(ModelMulDaoConf modelMulDaoConf) {
        this.modelMulDaoConf = modelMulDaoConf;
        modelMulDaoConf.init();
        multiFieldFromSameTable = modelMulDaoConf.isMultiFieldFromSameTable();
        mainModelSelectMethods = modelMulDaoConf.getMainModelSelectMethod();
        if(mainModelSelectMethods==null){
            SelectMethodEnum[] values = SelectMethodEnum.values();
            for(SelectMethodEnum val:values){
                if(!val.isSingleResult()&&!val.isCount()){
                    mainModelSelectMethods.add(val);
                }
            }
        }
//        this.modelSelectMethod = modelMulDaoConf.getMainModelSelectMethod();
        this.mainTable = modelMulDaoConf.getMainTable();
        this.relatedTables = modelMulDaoConf.getRelatedTables();
        this.buildNotAbstract = modelMulDaoConf.isBuildNotAbstract();
        this.modelBuilderContext = modelMulDaoConf.getBuilderContext();
        this.serviceClassName = modelBuilderContext.getServiceClassName(modelMulDaoConf.getMainTable());
//        this.tbMap = this.modelBuilderContext.getTbMap();
//        this.listResult = modelMulDaoConf.isListResult();

        this.daos = modelMulDaoConf.getDaos();
        this.models = modelMulDaoConf.getModels();
        this.defs = modelMulDaoConf.getDefs();
        mainDb = modelMulDaoConf.getMainDb();
        this.cm = modelBuilderContext.getCm();
        modelBuilder = new ComposedModelBuilder(modelMulDaoConf);

    }

    @Override
    public void buildModel() {
        L.info("build multidao : {} conf:{}", this.serviceClassName, modelMulDaoConf);
        int size = relatedTables.size();
        if (size == 0) {
            return;
        }
        modelBuilder.buildModel();
        wrapperCls = modelBuilder.getWrapperClz();
        assemblerBuilder = new ComposedAssemblerBuilder(modelMulDaoConf,wrapperCls);
        assemblerBuilder.buildModel();
        JDefinedClass multiAsemmblerClz = assemblerBuilder.getMultiAsemmblerClz();

        buildClass();
        BuildMethodParamHodler holder = new BuildMethodParamHodler();

        holder.initClz(cm, wrapperCls, mainModelClass);

        JFieldVar[] staticRoundFieldVar = assemblerBuilder.getStaticRoundFieldVar();//new JFieldVar[size + 1];
        holder.staticRoundFieldVar = staticRoundFieldVar;
//        int findex = 0;
//        staticRoundFieldVar[findex] =multiAsemmblerClz.staticRef("");
//                = definedClass.field(
//                CodeConstants.MODE_PUBLIC_STATIC_FINAL, cm.INT,
//                CodeConstants.getFieldNameOfMulDaoRNDName(modelMulDaoConf.getMainField()),
//                JExpr.lit(findex)
//        );
//        for (ModelRelatedTableDef def : relatedTables) {
//            ++findex;
//            String fieldName = def.getFieldName();
//            String s = CodeStyleTransformHelper.humpStyleToUnderlineSplittedStyle(fieldName).toUpperCase();
//            JFieldVar fieldVar = multiAsemmblerClz.field(
//                    CodeConstants.MODE_PUBLIC_STATIC_FINAL,
//                    cm.INT,
//                    CodeConstants.getFieldNameOfMulDaoRNDName(fieldName),
//                    JExpr.lit(findex)
//            );
//            staticRoundFieldVar[findex] = fieldVar;
//        }

        JMethod assembleMainList = buildAssembleMainToRet(true, holder);
        JMethod assembleMain = buildAssembleMainToRet(false, holder);
        for (SelectMethodEnum modelSelectMethod : mainModelSelectMethods) {
            if(!modelSelectMethod.isCount()&& !modelSelectMethod.isSingleResult()) {
                holder.modelSelectMethod = modelSelectMethod;
                holder.listResult = modelSelectMethod.isMultipleResult();
                holder.assemblerCls = multiAsemmblerClz;
                holder.assembleMain = assembleMain;
                holder.assembleMainList = assembleMainList;
                int index = 0;
                JMethod method = buildMethod(holder);
                if (method != null) {
                    ModelBuilderContext.registerMethod(method);
                    JMethod methodWithoutSelectFields = CodeHelper.buildReloadMethodWithoutCertainName(method, definedClass, CodeHelper.PARAM_DAO_SELECTED_FIELDS);
                    if(modelSelectMethod.isMultipleResult()){
                        CodeHelper.buildReloadMethodWithoutCertainName(methodWithoutSelectFields, definedClass, CodeHelper.PARAM_DAO_START, CodeHelper.PARAM_DAO_COUNT);
                    }
                }
            }
//        for(ModelBuilderContext.ParamDef pDef:methodDef){
//            Class[] narrow = pDef.getNarrow();
//            JVar param;
//            if(narrow !=null){
//
//                param = method.param(CodeConstants.buildNarrowedClass(cm, pDef.getClz(), narrow), pDef.getName());
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
        buildListify();
        buildMapify(false);
        buildMapify(true);
//
//        JFieldRef staticRef = mainModelClass.staticRef(CodeConstants.FIELD_CONST_NAME_PREFIX + tableInfo.getPriKey().toUpperCase());
//        JInvocation mainMapInvoke = JExpr.invoke(mainDaoField, CodeConstants.METHOD_DAO_BUILD_MAP).arg(allMainList).arg(staticRef);
//        FieldDataTypeInterface priKeyType = tableInfo.getPriKeyType();
//        Class priKeyTypeClass = priKeyType.gettClass();
//        JVar mainMap = body.decl(CodeConstants.buildNarrowedClass(cm, Map.class, priKeyTypeClass, mainModelClass), "mainMap", mainMapInvoke);
//        JVar mainIdList = body.decl(cm.ref(List.class), "mainIdList", cm.ref(CollectionHelper.class).staticInvoke("newList"));
//        body.invoke(mainIdList,"addAll").arg(mainMap.invoke("keySet"));
//        AbstractJClass entryClass = CodeConstants.buildNarrowedClass(cm, Map.Entry.class, priKeyTypeClass, mainModelClass);
//        JVar entries = body.decl(CodeConstants.buildNarrowedClass(cm, Set.class, entryClass),
//                "entries", JExpr.invoke(mainMap, "entrySet")
//        );
//        for(ModelRelatedTableDef modelDef:relatedTables){
//            buildGetRelatedModel(modelDef,body,mainMap,mainIdList,otherTableAssembler);
//        }
//        JForEach forEach = body.forEach(entryClass, "entry", entries);
//        JVar var = forEach.var();
//        JBlock forBlock = forEach.body();
//        JVar wrapper = forBlock.decl(wrapperCls, "wrapper", JExpr._new(wrapperCls));
//        JVar key = forBlock.decl(cm.ref(priKeyTypeClass), "key", var.invoke("getKey"));
//        JVar value = forBlock.decl(mainModelClass, "value", var.invoke("getValue"));
//        forBlock.invoke(wrapper,"setData"+CodeStyleTransformHelper.upperFirstCase(mainTable)).arg(value);
//        for(ModelRelatedTableDef modelDef:relatedTables){
//            String table = modelDef.getTable();
//            JVar jVar = mapVars.get(table);
//            forBlock.invoke(wrapper,"setData"+CodeStyleTransformHelper.upperFirstCase(table)).arg(jVar.invoke("get").arg(key));
//        }
//        forBlock.invoke(ret, "add").arg(wrapper);

    }

    private JMethod buildAssembleMainToRet(boolean listResult, BuildMethodParamHodler holder) {
        JMethod retMethod = definedClass.method(
                JMod.PROTECTED,
                cm.VOID,
                listResult ? CodeHelper.METHOD_SERVICE_ASSEMBLE_MAIN_DATA_LIST : CodeHelper.METHOD_SERVICE_ASSEMBLE_MAIN_DATA
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
            forEachBody.invoke(wrapper, CodeHelper.getMethodNameOfModelSet(modelBuilder.getMainModelFieldName())).arg(model);
            //retVar.invoke("add").arg(wrapper);
            forEachBody.invoke(retVar, "add").arg(wrapper);
        } else {
            body.invoke(retVar, CodeHelper.getMethodNameOfModelSet(modelBuilder.getMainModelFieldName())).arg(dataVar);
        }
        return retMethod;
    }

    private JMethod buildGetSubModel(ModelRelatedTableDef def, BuildMethodParamHodler holder) {
        final String db = def.getDb();
        String fieldInMainTable = def.getFieldInMainTable();
        String fieldInThisTable = def.getFieldInThisTable();
        String table = def.getTable();
        boolean isId = def.isFieldInThisTableIsId();
        boolean single = def.isSingle();
        AbstractJClass subModelClass = models.get(table);
        SelectMethodEnum subDaoSelectMethod = getSubSelectMethod(def, holder);
        String subDaoSelectMethodName = subDaoSelectMethod.getMethodName();
        String mName;
//        if(multiFieldFromSameTable) {
//            mName = CodeConstants.METHOD_SERVICE_GET_SUB_DATA_PREFIX
//                    + CodeStyleTransformHelper.upperFirstCase(modelBuilder.getSubModelFieldName(table)
//                    + CodeStyleTransformHelper.upperFirstCase(fieldInMainTable) + CodeStyleTransformHelper.upperFirstCase(fieldInThisTable));
//        }else{
        mName = StringHelper.concat(
                CodeHelper.METHOD_SERVICE_GET_SUB_DATA_PREFIX,
                CodeStyleTransformHelper.upperFirstCase(def.getFieldName()), (single ? "" : "s"), "Via",
                CodeStyleTransformHelper.upperFirstCase(subDaoSelectMethodName)
        );
//        }
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
        JFieldRef mainBaseModelColumnStaticRef = CodeHelper.getBaseModelColumnStaticRef(mainModelClass, fieldInMainTable);
        JFieldRef subBaseModelColumnStaticRef = CodeHelper.getBaseModelColumnStaticRef(subModelClass, fieldInThisTable);
        FieldDataTypeInterface fieldType = modelBuilderContext.getFieldType(db, table, fieldInThisTable);
        if (fieldType == null) {
            L.warn("not get type of {}.{}.{}", db, table, fieldInMainTable);
            L.warn("config is {}", modelMulDaoConf);
            throw new IllegalArgumentException(table + "数据表中字段" + fieldInThisTable + "不存在");
        }
//        System.out.println("get ");
        FieldDataTypeInterface mainFieldType = modelBuilderContext.getFieldType(mainDb, mainTable, fieldInMainTable);
        Class fieldTClass = fieldType.gettClass();
        if (!fieldTClass.equals(mainFieldType.gettClass())) {
            throw new IllegalArgumentException(mainTable + "数据表字段" + fieldInMainTable + "与" + table + "数据表中字段" + fieldInThisTable + "类型不匹配");
        }
        JBlock subBody = method.body();

        AbstractJClass fieldClzRef = cm.ref(fieldTClass);
        /**
         * start build method
         */
        String modelSet;
//            if(multiFieldFromSameTable){
        modelSet = CodeHelper.getMethodNameOfModelSet(def.getFieldName());
//            }else {
//                modelSet = CodeConstants.getMethodNameOfModelSet(modelBuilder.getSubModelFieldName(table));
//            }
        buildIfMainModelEmptyTest(subBody, dataVar, holder.listResult);
        /**
         * 生成调用
         */
        JInvocation invoke = null;
        JMethod subDaoMethod = ClassDataTable.getMethod(
                MethodTypeEnum.DAO_METHOD,
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
            } else if (type.isAssignableFrom(selectedFieldVar.type()) && name.equals(CodeHelper.PARAM_DAO_SELECTED_FIELDS)) {
                invoke.arg(selectedFieldVar);
            } else if (type.isAssignableFrom(CodeHelper.buildNarrowedClass(cm,List.class,fieldClzRef))) {
                JInvocation mainInvoke;
                if (holder.listResult) {
                    mainInvoke = JExpr.invoke(mainDaoField, CodeHelper.METHOD_DAO_BUILD_LIST).narrow(fieldClzRef)
                            .arg(dataVar).arg(mainBaseModelColumnStaticRef);
                } else {
                    mainInvoke = JExpr.invoke(mainDaoField, CodeHelper.METHOD_DAO_BUILD_LIST).narrow(fieldClzRef)
                            .arg(cm.ref(Collections.class).staticInvoke("singletonList").arg(dataVar)).arg(mainBaseModelColumnStaticRef);
                }
                JVar list = subBody.decl(CodeHelper.buildNarrowedClass(cm, List.class, fieldTClass), "list", mainInvoke);
                invoke.arg(list);
            } else if (type.name().equals(subModelClass.name()) && name.equals(CodeHelper.PARAM_DAO_INSTANCE)) {
                JVar instance = subBody.decl(subModelClass, "instance", JExpr._new(subModelClass));
                if (single) {
                    JVar mainId = subBody.decl(fieldClzRef, "mainId",
                            JExpr.invoke(dataVar, CodeHelper.getMethodNameOfModelGet(fieldInMainTable)));
                    subBody.invoke(instance, CodeHelper.getMethodNameOfModelSet(fieldInThisTable)).arg(mainId);
                }
                Map<String, String> additionalCondition = def.getAdditionalCondition();
                if (!CollectionHelper.isCollectionEmpty(additionalCondition)) {
                    JVar otherDataVar = dataVar;
                    if (holder.listResult) {
                        otherDataVar = subBody.decl(mainModelClass, dataVar.name() + "First", JExpr.invoke(dataVar, "get").arg(JExpr.lit(0)));
                    }
                    Set<Map.Entry<String, String>> entries = additionalCondition.entrySet();
                    for (Map.Entry<String, String> cond : entries) {
                        final String condKey = cond.getKey();
                        final AbstractJType typeOfField = CodeHelper.getTypeOfField(cm, modelBuilderContext, db, mainTable, condKey);
                        if(typeOfField!=null) {
                            JVar mainId = subBody.decl(typeOfField, "mainId" + CodeStyleTransformHelper.upperFirstCase(condKey),
                                    JExpr.invoke(otherDataVar, CodeHelper.getMethodNameOfModelGet(condKey)));
                            subBody.invoke(instance, CodeHelper.getMethodNameOfModelSet(cond.getValue())).arg(mainId);
                        }
                    }
                }
                invoke.arg(instance);
            } else if (type.isAssignableFrom(cm.ref(String.class)) && name.equals(CodeHelper.PARAM_DAO_INDEX_IN_FIELD)) {
                invoke.arg(subBaseModelColumnStaticRef);
            }else if (
                    type.isAssignableFrom(CodeHelper.buildNarrowedClass(cm,Set.class,String.class))
                    && name.equals(CodeHelper.PARAM_DAO_EXT_CONDITION)
                    && def.getAdditionalWhere()!=null
                    ) {
//                Collections.singleton()
                invoke.arg(cm.ref(Collections.class).staticInvoke("singleton").arg(JExpr.lit(def.getAdditionalWhere())));
            } else {
                invoke.arg(JExpr._null());
            }
        }
//        if (holder.listResult) {
//
//            JInvocation mainInvoke = JExpr.invoke(mainDaoField, CodeConstants.METHOD_DAO_BUILD_LIST).narrow(fileClzRef)
//                    .arg(dataVar).arg(mainBaseModelColumnStaticRef);
//            JVar list = subBody.decl(CodeConstants.buildNarrowedClass(cm, List.class, fieldTClass), "list", mainInvoke);
//            JVar condition = null;
//            if (subDaoSelectMethodName.isCondition()) {
//
//            }
//
////            invoke = JExpr.invoke(daoField, subDaoSelectMethodName.getMethodName());
//            invoke.arg(selectedFieldVar);
//            invoke.arg(assemberVar);
//            invoke.arg(JExpr._null()).arg(JExpr._null());
////                if (isId) {
////                    invoke.arg(list);
////                } else {
//            invoke.arg(subBaseModelColumnStaticRef).arg(list);
////                }
//
//        } else {
//
//            JVar mainId = subBody.decl(fileClzRef, "mainId",
//                    JExpr.invoke(dataVar, CodeConstants.getMethodNameOfModelGet(fieldInMainTable)));
//            JVar instance = subBody.decl(subModelClass, "instance", JExpr._new(subModelClass));
//            subBody.invoke(instance, CodeConstants.getMethodNameOfModelSet(fieldInThisTable)).arg(mainId);
////            invoke = JExpr.invoke(daoField, subDaoSelectMethodName.getMethodName())
////                    .arg(selectedFieldVar).arg(assemberVar);
////                if (isId) {
////                    invoke.arg(mainId);
////                } else {
//
//            subBody.invoke(instance, CodeConstants.getMethodNameOfModelSet(fieldInThisTable)).arg(mainId);
//            if (!single) {
//                invoke.arg(JExpr._null()).arg(JExpr._null());
//            }
//            invoke.arg(instance);
////                }
//        }

        /**
         * 组装结果
         */
        if (holder.listResult) {
            JVar subModels = subBody.decl(CodeHelper.buildNarrowedClass(cm, List.class, subModelClass), "subModels", invoke);
            AbstractJClass subMapClz = null;
            String subAssembleMethod = null;
            if (single) {
                subMapClz = CodeHelper.buildNarrowedClass(cm, Map.class, fieldClzRef, subModelClass);
                subAssembleMethod = CodeHelper.METHOD_DAO_BUILD_MAP;
            } else {
                subMapClz = CodeHelper.buildNarrowedClass(cm, Map.class, fieldTClass, CodeHelper.buildNarrowedClass(cm, List.class, subModelClass));
                subAssembleMethod = CodeHelper.METHOD_DAO_BUILD_LIST_MAP;
            }
            JInvocation subInvocation = JExpr.invoke(daoField, subAssembleMethod).arg(subModels).arg(subBaseModelColumnStaticRef);
            JVar subModelMap = subBody.decl(subMapClz, "subModelMap", subInvocation);
            JForEach forEach = subBody.forEach(wrapperCls, "wrapper", retVar);
            JVar loopVar = forEach.var();
            JBlock forBody = forEach.body();
            JVar mainId = forBody.decl(fieldClzRef, "mainId",
                    JExpr.invoke(loopVar, CodeHelper.getMethodNameOfModelGet(modelBuilder.getMainModelFieldName()))
                            .invoke(CodeHelper.getMethodNameOfModelGet(fieldInMainTable)));
            forBody.invoke(loopVar, modelSet)
                    .arg(JExpr.invoke(subModelMap, "get").arg(mainId));
        } else {
            AbstractJClass subClz = null;
            if (single) {
                subClz = subModelClass;
            } else {
                subClz = CodeHelper.buildNarrowedClass(cm, List.class, subModelClass);
            }
            JVar subModel = subBody.decl(subClz, "subModel", invoke);
            subBody.invoke(retVar, modelSet).arg(subModel);
        }
        /**
         * end build method
         */
        return method;
//        } else {
//            throw new IllegalArgumentException(mainTable + "数据表字段" + fieldInMainTable + "与" + table + "数据表中字段" + fieldInThisTable + "类型不匹配");
//        }
    }

    private void buildIfMainModelEmptyTest(JBlock subBody, JVar dataVar, boolean listResult) {
        if (listResult)
            subBody._if(dataVar.eq(JExpr._null()).cor(JExpr.invoke(dataVar, "size").eq(JExpr.lit(0))))._then()._return();
        else
            subBody._if(dataVar.eq(JExpr._null()))._then()._return();
    }

    private SelectMethodEnum getSubSelectMethod(
            ModelRelatedTableDef def, BuildMethodParamHodler hodler
    ) {
        boolean single = def.isSingle();
//        boolean isId=def.isFieldInThisTableIsId();
        boolean listResult = hodler.listResult;
//        return (single && !listResult) ? CodeConstants.METHOD_DAO_COMMON_SELECT_ONE : CodeConstants.METHOD_DAO_COMMON_SELECT_LIST;
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
        Set<Map.Entry<String, AbstractJClass>> entries = models.entrySet();
        for (Map.Entry<String, AbstractJClass> entry : entries) {
            definedClass.addImport(entry.getValue().fullName());
        }

        JMethod method = definedClass.method(
                JMod.PUBLIC,
                listResult ? holder.listRetType : holder.retType,
                holder.modelSelectMethod.getMethodName()
//                CodeConstants.METHOD_SERVICE_GET_DATA
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

        CodeHelper.copyMethodParam(holder.mainSelectDaoMethod, method, holder.allVar, new CodeHelper.StringParamFilter() {
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
        body.invoke(holder.otherTableAssembler,"clearData");
        if(listResult){
            body.invoke(holder.otherTableAssembler, CodeHelper.KEY_WORD_SET + CodeStyleTransformHelper.upperFirstCase("rets")).arg(ret);
        }else {
            body.invoke(holder.otherTableAssembler, CodeHelper.KEY_WORD_SET + CodeStyleTransformHelper.upperFirstCase("ret")).arg(ret);
        }
        JMethod getMain = buildGetMainModel(holder);
        JInvocation invoke = JExpr.invoke(getMain);
        int index = 0;
        body.invoke(holder.otherTableAssembler, CodeHelper.METHOD_ASSEMBLER_SET_INDEX).arg(holder.assemblerCls.staticRef(holder.staticRoundFieldVar[index]));
        for (JVar var : holder.allVar) {
            invoke.arg(var);
        }
        JVar allMainList = body.decl(getMain.type(), "mainModel", invoke);

        body.invoke(holder.listResult ? holder.assembleMainList : holder.assembleMain).arg(allMainList).arg(ret);
        holder.mainDataVar = allMainList;

        for (ModelRelatedTableDef def : relatedTables) {
            ++index;
//                String fieldName = def.getFieldName();
//            String s = CodeStyleTransformHelper.humpStyleToUnderlineSplittedStyle(fieldName).toUpperCase();
//                JFieldVar fieldVar = definedClass.field(
//                        CodeConstants.MODE_PUBLIC_STATIC_FINAL,
//                        cm.INT,
//                        CodeConstants.getFieldNameOfMulDaoRNDName(fieldName),
//                        JExpr.lit(index)
//                );
            body.invoke(holder.otherTableAssembler, CodeHelper.METHOD_ASSEMBLER_SET_INDEX).arg(holder.assemblerCls.staticRef(holder.staticRoundFieldVar[index]));
            JMethod subMethod = buildGetSubModel(def, holder);
            body.invoke(subMethod).arg(allMainList).arg(ret).arg(holder.selectFields).arg(holder.otherTableAssembler);
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
//        JFieldRef staticRef = CodeConstants.getBaseModelColumnStaticRef(model, fieldInThisTable);
//        JInvocation arg = JExpr.invoke(daoField, CodeConstants.METHOD_DAO_GET_BY_INDEXES).arg(JExpr._null()).arg(JExpr._null())
//                .arg(JExpr._null()).arg(otherTableAssembler).arg(staticRef).arg(mainIdList);
//        JVar list = body.decl(CodeConstants.buildNarrowedClass(cm, List.class, model), "rt" + CodeStyleTransformHelper.upperFirstCase(table) + "List", arg);
//        ColumnInfoInterface type = findColumnType(tableInfo, fieldInThisTable);
//        Class fieldClz = type.getDataType().gettClass();
//        JVar mapVar = body.decl(CodeConstants.buildNarrowedClass(cm, Map.class, fieldClz, CodeConstants.buildNarrowedClass(cm, List.class, model)),
//                "rt" + CodeStyleTransformHelper.upperFirstCase(table) + "Map",
//                daoField.invoke(CodeConstants.METHOD_DAO_BUILD_LIST_MAP).narrow(cm.ref(fieldClz)).arg(list).arg(staticRef));
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
            holder.mainTableRetCls = CodeHelper.buildNarrowedClass(cm, List.class, mainModelClass);
        } else {
            holder.mainTableRetCls = mainModelClass;
        }
        String methodName = CodeHelper.METHOD_SERVICE_GET_MAIN_DATA_PREFIX
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
            CodeHelper.copyMethodParam(holder.mainSelectDaoMethod, method, null);
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

//    private AbstractJClass buildWapperClass() {
//        String wrapperClzName=buildWrapperClzName();
//
//        try {
//            JDefinedClass clz = cm._class(wrapperClzName);
//            String fname = "data" + CodeConstants.getClazzNameFromTableName(mainTable);
//            JFieldVar var = clz.field(JMod.PROTECTED, mainModelClass, fname);
//            CodeConstants.buildGetterAndSetter(clz,fname,mainModelClass,var);
//            for(ModelRelatedTableDef modelDef:relatedTables){
//                String table = modelDef.getTable();
//                boolean single = modelDef.isSingle();
//                AbstractJClass jClass;
//                AbstractJClass modelClz = models.get(table);
//                if(single){
//                    jClass= modelClz;
//                }else {
//                    jClass = CodeConstants.buildNarrowedClass(cm, List.class, modelClz);
//                }
//                fname="data"+CodeConstants.getClazzNameFromTableName(table)+(single?"":"List");
//                JFieldVar field = clz.field(JMod.PROTECTED, jClass,fname);
//                CodeConstants.buildGetterAndSetter(clz,fname,jClass,field);
//            }
//            return clz;
//        } catch (JClassAlreadyExistsException e) {
//            e.printStackTrace();
//            AbstractJClass ref = cm.ref(wrapperClzName);
//            return ref;
//        }
//    }
//
//    private String buildWrapperClzName() {
//        StringBuilder ret=new StringBuilder(modelBuilderContext.getModelClassPrefix(false));
//        ret.append(CodeConstants.getClazzNameFromTableName(mainTable));
//        Set<String> relatedTb=CollectionHelper.newSortedSet();
//        for(ModelRelatedTableDef modelDef:relatedTables){
//            String table = modelDef.getTable();
//            String tbName = CodeConstants.getClazzNameFromTableName(table)+(modelDef.isSingle()?"":"s");
//            relatedTb.add(tbName);
//        }
//        for(String s:relatedTb) ret.append(s);
//        return ret.toString();
//    }

    private void buildClass() {
        try {
            definedClass = buildNotAbstract ? cm._class(serviceClassName) : cm._class(JMod.PUBLIC + JMod.ABSTRACT, serviceClassName);
            loggerField = definedClass.field(CodeHelper.MODE_PUBLIC_STATIC_FINAL, cm.ref(Logger.class), CodeHelper.FIELD_DAO_LOGGER,
                    cm.ref(LoggerFactory.class).staticInvoke("getLogger").arg(JExpr.dotclass(definedClass)));

            definedClass._implements(InitializingBean.class);
            FieldDataTypeInterface idFieldType = modelBuilderContext.getIdFieldType(mainDb, mainTable);
            AbstractJType idType=cm.ref(idFieldType.gettClass());
            definedClass._implements(CodeHelper.buildNarrowedClass(cm,DaoInterface.class,wrapperCls,idType));
            if(modelMulDaoConf.getImplInterface()!=null && !buildNotAbstract){
                definedClass._implements(cm.ref(modelMulDaoConf.getImplInterface()));
            }
            definedClass._extends(CodeHelper.buildNarrowedClass(cm,AbstractDao.class,wrapperCls,idType));
            definedClass.annotate(cm.ref(SuppressWarnings.class)).param("value","unchecked");//.annotationParam(cm.ref(String.class),JExpr.lit("unchecked"))
            afterPropertiesSet=definedClass.method(JMod.PUBLIC,cm.VOID, CodeHelper.METHOD_SPRING_BEAN_AFTER_PROPERTIES_SET);
            afterPropertiesSet.annotate(Override.class);
            afterPropertiesSet._throws(Exception.class);
            definedClass.constructor(JMod.PUBLIC).body().invoke("super").arg(JExpr.dotclass(wrapperCls));
            if (buildNotAbstract) {
//                definedClass.annotate(Repository.class);
                JAnnotationUse annotate = definedClass.annotate(Repository.class);
                annotate.param("value", CodeHelper.getClassNameFromFullName(serviceClassName));
            }
            mainDaoClass = cm.ref(modelBuilderContext.getDaoClassName(mainTable));
            mainModelClass = cm.ref(modelBuilderContext.getReallyModelClassName(mainTable, null));
            String tbMName = CodeHelper.getClazzNameFromTableName(mainTable);

            mainDaoField = definedClass.field(JMod.PROTECTED, mainDaoClass, "dao" + tbMName);
            mainDaoField.annotate(Autowired.class);

            daoFields = CollectionHelper.newMap();
            for (ModelRelatedTableDef def : relatedTables) {
                String table = def.getTable();
                String tbName = CodeHelper.getClazzNameFromTableName(table);
//                defs.put(table,modelDef);
//                AbstractJClass daoClass = cm.ref(modelBuilderContext.getDaoClassName(table));
//                daos.put(table, daoClass);
//                AbstractJClass modelClass = cm.ref(modelBuilderContext.getModelClassName(table));
//                models.put(table, modelClass);
                AbstractJClass daoClass = daos.get(table);
                Map<String, JFieldVar> fields = definedClass.fields();
                String daoName = "dao" + tbName;
                JFieldVar fieldVar;
                if (fields.containsKey(daoName)) {
                    fieldVar = fields.get(daoName);
                } else {
                    fieldVar = definedClass.field(JMod.PROTECTED, daoClass, daoName);
                    fieldVar.annotate(Autowired.class);
                }
                daoFields.put(table, fieldVar);
            }
        } catch (JClassAlreadyExistsException e) {
            e.printStackTrace();
        }
    }

    private void buildListify() {
        JDirectClass genericType = cm.directClass("TT");
        AbstractJClass retClass = CodeHelper.buildNarrowedClass(cm, List.class, genericType);
        AbstractJClass paramListCls = CodeHelper.buildNarrowedClass(cm, List.class, wrapperCls);
        JMethod method = definedClass.method(JMod.PUBLIC, retClass, CodeHelper.METHOD_DAO_BUILD_LIST);
        JTypeVar tt = method.generify("TT");
        JVar list = method.param(paramListCls, "list");
        JVar field = method.param(cm.ref(String.class), "field");
        JBlock body = method.body();
        JVar ret = body.decl(retClass, "ret", cm.ref(CollectionHelper.class).staticInvoke("newList"));
        body._if(list.eq(JExpr._null()).cor(list.invoke("size").eq(JExpr.lit(0))))._then()._return(ret);
        JBlock then = body._if(mainModelClass.staticRef(CodeHelper.FIELD_FIELDS_CLASS_CONSTANT_MAP).invoke("containsKey").arg(field))._then();
        JForEach forEach = then.forEach(wrapperCls, "item", list);
        JVar var = forEach.var();
        JBlock block = forEach.body();
        JVar mainVar = block.decl(mainModelClass, "mainVar", JExpr.invoke(var, CodeHelper.getMethodNameOfModelGet(modelMulDaoConf.getMainField())));
        block.invoke(ret, "add").arg(
                mainModelClass.staticRef(CodeHelper.FIELD_REDIS_MAP_MAPPER_INSTANCE)
                .invoke(CodeHelper.METHOD_JEDIS_MAPPER_GET_FIELD).narrow(genericType).arg(field).arg(mainVar)
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
        AbstractJClass retListType = CodeHelper.buildNarrowedClass(cm, List.class, wrapperCls);
        if (!isItemList) {
            retClass = CodeHelper.buildNarrowedClass(cm, Map.class, genericType, wrapperCls);
        } else {
            retClass = CodeHelper.buildNarrowedClass(cm, Map.class, genericType, retListType);
        }
        JMethod method = definedClass.method(JMod.PUBLIC, retClass, isItemList ? CodeHelper.METHOD_DAO_BUILD_LIST_MAP : CodeHelper.METHOD_DAO_BUILD_MAP);
        method.generify("TT");
        JVar list = method.param(retListType, "list");
        JVar field = method.param(cm.ref(String.class), "field");
        JBlock body = method.body();

        JVar ret = body.decl(retClass, "ret", cm.ref(CollectionHelper.class).staticInvoke("newMap"));
        body._if(list.eq(JExpr._null()))._then()._return(ret);
        JBlock then = body._if(mainModelClass.staticRef(CodeHelper.FIELD_FIELDS_CLASS_CONSTANT_MAP).invoke("containsKey").arg(field))._then();

        JForEach forEach = then.forEach(wrapperCls, "item", list);
        JVar var = forEach.var();

        JBlock block = forEach.body();
        JVar mainVar = block.decl(mainModelClass, "mainVar", JExpr.invoke(var, CodeHelper.getMethodNameOfModelGet(modelMulDaoConf.getMainField())));
        JInvocation arg = mainModelClass.staticRef(CodeHelper.FIELD_REDIS_MAP_MAPPER_INSTANCE)
                .invoke(CodeHelper.METHOD_JEDIS_MAPPER_GET_FIELD).narrow(genericType).arg(field).arg(mainVar);
        if (!isItemList) {
            block.invoke(ret, "put")
                    .arg(arg)
                    .arg(var);
        } else {
            JVar itemList = block.decl(retListType, "itemList", JExpr.invoke(ret, "get").arg(arg));
            block._if(itemList.eq(JExpr._null()))._then().assign(itemList, cm.ref(CollectionHelper.class).staticInvoke("newList"));
            block.invoke(itemList, "add").arg(var);
            block.invoke(ret, "put")
                    .arg(arg)
                    .arg(itemList);
        }
        body._return(ret);
    }

}
