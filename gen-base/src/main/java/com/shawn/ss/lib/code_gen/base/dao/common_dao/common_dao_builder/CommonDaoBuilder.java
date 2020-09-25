package com.shawn.ss.lib.code_gen.base.dao.common_dao.common_dao_builder;

import com.helger.jcodemodel.*;
import com.shawn.ss.gen.api.conf.SelectMethod;
import com.shawn.ss.gen.api.conf.SelectMethodEnum;
import com.shawn.ss.lib.code_gen.base.dao.AbstractDaoBuilder;
import com.shawn.ss.lib.code_gen.base.helper.CodeConstants;
import com.shawn.ss.lib.code_gen.base.helper.ModelBuilderContext;
import com.shawn.ss.lib.code_gen.model.def_model.interfaces._BaseDaoConf;
import com.shawn.ss.lib.tools.CodeStyleTransformHelper;
import com.shawn.ss.lib.tools.CollectionHelper;
import com.shawn.ss.lib.tools.StringHelper;
import com.shawn.ss.lib.tools.TypeConstantHelper;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.ColumnInfoInterface;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model.*;
import com.shawn.ss.lib.tools.db.impl.dao.DaoInterface;
import com.shawn.ss.lib.tools.service_assemble.AbstractMultipleDaoAssembler;
import com.shawn.ss.lib.tools.service_assemble.BaseMultipleDaoAssembler;
import com.shawn.ss.lib.tools.service_assemble.DaoAssembler;
import com.shawn.ss.lib.tools.sql_code_gen.api.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by ss on 2018/1/17.
 */
public class CommonDaoBuilder extends AbstractDaoBuilder {

    //
    //    final String idStr = "id";
    //    final String indexStr = "fields";


    private FieldDataTypeInterface priKeyType;
    private String priKey;
    //    private AbstractJClass modelClass;

    //    static Set<String> allSelectMethod = CollectionHelper.<String>setBuilder()
    //            .add(CodeConstants.METHOD_DAO_GET_ALL)
    //            .add(CodeConstants.METHOD_DAO_GET_BY_ID)
    //            .add(CodeConstants.METHOD_DAO_GET_BY_IDS)
    //            .add(CodeConstants.METHOD_DAO_GET_BY_INDEXES)
    //            .add(CodeConstants.METHOD_DAO_GET_BY_CONDITION)
    //            .add(CodeConstants.METHOD_DAO_GET_COUNT_BY_CONDITION)
    //            .add(CodeConstants.METHOD_DAO_GET_ONE_BY_CONDITION)
    //            .add(CodeConstants.METHOD_DAO_GET_BY_INDEXES_AND_CONDITION)
    //            .add(CodeConstants.METHOD_DAO_GET_COUNT_BY_INDEX_AND_CONDITION)
    //            .add(CodeConstants.METHOD_DAO_CUSTOMER_GET_ITEM_BY_CONDITION)
    //            .add(CodeConstants.METHOD_DAO_CUSTOMER_GET_ITEM_BY_INDEXES)
    //            .add(CodeConstants.METHOD_DAO_CUSTOMER_GET_ITEM_BY_INDEX_AND_CONDITION)
    //            .add(CodeConstants.METHOD_DAO_CUSTOMER_GET_ITEM_BY_CUSTOMER_CONDITION)
    //            .add(CodeConstants.METHOD_DAO_CUSTOMER_GET_BY_INDEXES_AND_CONDITION_AND_CUSTOMER_CONDITION)
    //            .add(CodeConstants.METHOD_DAO_CUSTOMER_GET_ONE_BY_CUSTOMER_CONDITION)
    //            .add(CodeConstants.METHOD_DAO_CUSTOMER_GET_LIST_BY_CUSTOMER_CONDITION)
    //            .getSet();

    public CommonDaoBuilder(_BaseDaoConf commonModelDaoDef) {
        super(commonModelDaoDef);
    }

    @Override
    public void buildModel() {
        if (modelDef.getDeclaredDao() != null) {
            return;
        }
        super.buildModel();
        priKey = info.getPriKey();
        priKeyType = info.getPriKeyType();

        try {
            //            definedClass.direct("import "+modelClass.fullName());
            definedClass.addImport(modelClass.fullName());
            //            modelClass = modelClass;
            //            modelClazzRef._package();
            //            buildGetResultMethod(false);
            //            buildGetResultMethod(true);
            //            buildGetResultsMethod(true);
            //            buildGetResultsMethod(false);
            buildAssembleInCluaseMethod();
            buildCondSelectCluase();
            buildSelectFieldCluase();
            for (SelectMethod methodName : CodeConstants.allSelectMethod) {
                //                if (
                //                        info.getPriKey() != null
                //                                || (!methodName.equals(CodeConstants.METHOD_DAO_GET_BY_ID) && !methodName.equals(CodeConstants.METHOD_DAO_GET_BY_IDS))
                //                        ) {
                JMethod jMethod = buildSelectSQL(methodName);
                if (jMethod != null) {
                    ModelBuilderContext.registerMethod(jMethod);
                    JMethod methodWithoutAssembler = CodeConstants.buildReloadMethodWithoutCertainName(jMethod, definedClass, CodeConstants.PARAM_DAO_ASSEMBLER);
                    JMethod methodWithoutFields;
                    if (!methodName.isSingleResult() && !methodName.isCount()) {
                        methodWithoutFields = CodeConstants.buildReloadMethodWithoutCertainName(methodWithoutAssembler, definedClass, CodeConstants.PARAM_DAO_SELECTED_FIELDS);
                    } else {
                        methodWithoutFields = methodWithoutAssembler;
                    }
                    //                    JMethod methodWithoutAssembler = CodeConstants.buildReloadMethodWithoutCertainName(jMethod,definedClass,PARAM_DAO_ASSEMBLER);
                    if (methodName.isMultipleResult()) {
                        CodeConstants.buildReloadMethodWithoutCertainName(methodWithoutFields, definedClass, CodeConstants.PARAM_DAO_START, CodeConstants.PARAM_DAO_COUNT);
                    }
                }
                //                }
            }
            if (info.getPriKey() != null) {
                JMethod insert = buildInsert();
                ModelBuilderContext.registerMethod(insert);
                CodeConstants.buildReloadMethodWithoutCertainName(insert, definedClass, CodeConstants.PARAM_DAO_ASSEMBLER);
                JMethod batchInsert = buildBatchInsert();
                ModelBuilderContext.registerMethod(batchInsert);
                CodeConstants.buildReloadMethodWithoutCertainName(batchInsert, definedClass, CodeConstants.PARAM_DAO_ASSEMBLER);
                CodeConstants.buildReloadMethodWithoutCertainName(batchInsert, definedClass, CodeConstants.PARAM_DAO_ASSEMBLER, CodeConstants.PARAM_DAO_FIELDS);

                JMethod update = buildUpdate(false, false, false);
                ModelBuilderContext.registerMethod(update);
                CodeConstants.buildReloadMethodWithoutCertainName(update, definedClass, CodeConstants.PARAM_DAO_ASSEMBLER);
                JMethod updateById = buildUpdate(false, false, true);
                ModelBuilderContext.registerMethod(updateById);
                CodeConstants.buildReloadMethodWithoutCertainName(updateById, definedClass, CodeConstants.PARAM_DAO_ASSEMBLER);
                //                CodeConstants.buildReloadMethodWithoutCertainName(updateById, definedClass, CodeConstants.PARAM_DAO_ASSEMBLER, "id");
                JMethod updateByIds = buildUpdate(true, false, true);
                ModelBuilderContext.registerMethod(updateByIds);
                CodeConstants.buildReloadMethodWithoutCertainName(updateByIds, definedClass, CodeConstants.PARAM_DAO_ASSEMBLER);

                //                JMethod delete = buildUpdate(false, true, false);
                //                ModelBuilderContext.registerMethod(delete);
                //                CodeConstants.buildReloadMethodWithoutCertainName(delete, definedClass, CodeConstants.PARAM_DAO_ASSEMBLER);
                JMethod deleteById = buildUpdate(false, true, true);
                ModelBuilderContext.registerMethod(deleteById);
                CodeConstants.buildReloadMethodWithoutCertainName(deleteById, definedClass, CodeConstants.PARAM_DAO_ASSEMBLER);
                JMethod deleteByIds = buildUpdate(true, true, true);
                ModelBuilderContext.registerMethod(deleteByIds);
                CodeConstants.buildReloadMethodWithoutCertainName(deleteByIds, definedClass, CodeConstants.PARAM_DAO_ASSEMBLER);

                JMethod updateOrInsert = buildUpdateOrInsert();
                ModelBuilderContext.registerMethod(updateOrInsert);
                CodeConstants.buildReloadMethodWithoutCertainName(updateOrInsert, definedClass, CodeConstants.PARAM_DAO_ASSEMBLER);
                JMethod insertIfNoExist = buildInsertIfNoExist();
                ModelBuilderContext.registerMethod(insertIfNoExist);
                CodeConstants.buildReloadMethodWithoutCertainName(insertIfNoExist, definedClass, CodeConstants.PARAM_DAO_ASSEMBLER);
            }
            buildMapify(false);
            buildMapify(true);
            buildListify();
            //            buildSelectByIdSQL();
            //            buildSelectByIndexSQL();
            //            buildSelectByModelSQL();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void buildAssembleInCluaseMethod() {
        JMethod method = definedClass.method(JMod.PROTECTED, cm.VOID, CodeConstants.METHOD_DAO_BUILD_IN_CLUASE);
        JVar sqlBuilderVar = method.param(cm.ref(SQLSelect.class), "sqlBuilder");
        JVar fieldVar = method.param(cm.ref(String.class), CodeConstants.PARAM_DAO_INDEX_IN_FIELD);
        JVar paramVar = method.param(CodeConstants.buildNarrowedClass(cm, Map.class, String.class, Object.class), "param");
        JVar indexesVar = method.param(cm.ref(List.class), CodeConstants.PARAM_DAO_INDEXES);
        JBlock body = method.body();
        JFieldRef fieldMapStaticRefer = modelClass.staticRef(CodeConstants.FIELD_FIELDS_CLASS_CONSTANT_MAP);
        JConditional containsKeyIf = body._if(fieldMapStaticRefer.invoke("containsKey").arg(fieldVar));
        JBlock fblock = containsKeyIf._then();
        JVar fieldClassObj = fblock.decl(cm.ref(Object.class), "fieldClassObj", fieldMapStaticRefer.invoke("get").arg(fieldVar));
        fblock.invoke(JExpr._super(), CodeConstants.METHOD_DAO_BUILD_RAW_IN_CLUASE)
                .arg(sqlBuilderVar)
                .arg(paramVar)
                .arg(fieldVar)
                .arg(fieldClassObj)
                .arg(indexesVar);

        JBlock jBlock = containsKeyIf._else();
        jBlock.invoke(loggerField, "error").arg("field parameter error");
        jBlock._throw(JExpr._new(cm.ref(IllegalArgumentException.class))
                .arg(
                        JExpr.lit("there is mistake with infield parameter, column ")
                                .plus(fieldVar)
                                .plus(JExpr.lit(" not found in table "))
                                .plus(modelClass.staticRef(CodeConstants.FIELD_TABLE_NAME))
                )
        );
    }

    private JVar buildDbSelectClause(JBlock body, JVar assemblerVar, JVar sqlBuilderVar, JVar paramVar, JVar dbToUseVar) {

        return null;
    }


    private void buildReloadSelectMethod(JMethod method) {

    }

    private void buildListify() {
        JDirectClass genericType = cm.directClass("TT");
        AbstractJClass retClass = CodeConstants.buildNarrowedClass(cm, List.class, genericType);
        AbstractJClass paramListCls = CodeConstants.buildNarrowedClass(cm, List.class, typeVar);
        JMethod method = definedClass.method(JMod.PUBLIC, retClass, CodeConstants.METHOD_DAO_BUILD_LIST);
        JTypeVar tt = method.generify("TT");
        JVar list = method.param(paramListCls, "list");
        JVar field = method.param(cm.ref(String.class), "field");
        JBlock body = method.body();
        JVar ret = body.decl(retClass, "ret", cm.ref(CollectionHelper.class).staticInvoke("newList"));
        body._if(list.eq(JExpr._null()).cor(list.invoke("size").eq(JExpr.lit(0))))._then()._return(ret);
        JBlock then = body._if(modelClass.staticRef(CodeConstants.FIELD_FIELDS_CLASS_CONSTANT_MAP).invoke("containsKey").arg(field))._then();
        JForEach forEach = then.forEach(typeVar, "item", list);
        JVar var = forEach.var();
        JInvocation fieldCommonMapper = CodeConstants.getCommonFieldMapper(name, constantClz);
        //        CodeConstants.buildGetter()
        forEach.body().invoke(ret, "add").arg(
                fieldCommonMapper
                        .invoke(CodeConstants.METHOD_JEDIS_MAPPER_GET_FIELD).narrow(genericType).arg(field).arg(var)
        );
        body._return(ret);
    }


    private void buildMapify(boolean isItemList) {
        JDirectClass genericType = cm.directClass("TT");
        AbstractJClass retClass;
        AbstractJClass retListType = CodeConstants.buildNarrowedClass(cm, List.class, typeVar);
        if (!isItemList) {
            retClass = CodeConstants.buildNarrowedClass(cm, Map.class, genericType, typeVar);
        } else {
            retClass = CodeConstants.buildNarrowedClass(cm, Map.class, genericType, retListType);
        }
        JMethod method = definedClass.method(
                JMod.PUBLIC,
                retClass,
                isItemList ? CodeConstants.METHOD_DAO_BUILD_LIST_MAP : CodeConstants.METHOD_DAO_BUILD_MAP
        );
        method.generify("TT");
        JVar list = method.param(retListType, "list");
        JVar field = method.param(cm.ref(String.class), "field");
        JBlock body = method.body();

        JVar ret = body.decl(retClass, "ret", cm.ref(CollectionHelper.class).staticInvoke("newMap"));
        body._if(list.eq(JExpr._null()))._then()._return(ret);
        JForEach forEach = body.forEach(typeVar, "item", list);
        JVar var = forEach.var();
        JBlock block = forEach.body();
        JInvocation fieldCommonMapper = CodeConstants.getCommonFieldMapper(name, constantClz);
        JInvocation arg = fieldCommonMapper.invoke(CodeConstants.METHOD_JEDIS_MAPPER_GET_FIELD).narrow(genericType).arg(field).arg(var);
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

    private JMethod buildInsertIfNoExist() {
        String priKey = info.getPriKey();
        if (priKey != null) {
            JMethod method = definedClass.method(JMod.PUBLIC, modelClass, CodeConstants.METHOD_DAO_INSERT_IF_NO_EXIST);
            method.annotate(Transactional.class);
            JVar instance = method.param(modelClass, CodeConstants.PARAM_DAO_INSTANCE);
            JVar fields = method.param(CodeConstants.buildNarrowedClass(cm, Set.class, String.class), "conditionField");
            JVar assemblerVar = null;
            assemblerVar = method.param(cm.ref(AbstractMultipleDaoAssembler.class), CodeConstants.PARAM_DAO_ASSEMBLER);
            JBlock body = method.body();
            body._if(assemblerVar.eq(JExpr._null()))._then().assign(assemblerVar, JExpr._new(cm.ref(BaseMultipleDaoAssembler.class)));
            JFieldRef staticRef = CodeConstants.getBaseModelColumnStaticRef(modelClass, priKey);
            JVar checkInstance = body.decl(modelClass, "checkInstance", JExpr._new(modelClass));
            //            IJExpression checkInstance = JExpr.cast(modelClass, body.decl(typeVar, "checkInstance", JExpr._new(modelClass)));
            List<ColumnInfoInterface> columns = info.getColumns();
            for (ColumnInfoInterface col : columns) {
                String colName = col.getAliasField();
                FieldDataTypeInterface type = col.getType();
                JFieldRef staticColRef = CodeConstants.getBaseModelColumnStaticRef(modelClass, colName);
                body._if(fields.invoke("contains").arg(staticColRef))._then()
                        .invoke(checkInstance, CodeConstants.getMethodNameOfModelSet(colName))
                        .arg(JExpr.invoke(instance, CodeConstants.getMethodNameOfModelGet(colName)));
            }
            JInvocation arg = cm.ref(Collections.class).staticInvoke("singleton").arg(staticRef);
            JInvocation selectInstance = JExpr.invoke(SelectMethodEnum.makeUpMethodName(SelectMethodEnum.getOneByCondtion)).arg(arg).arg(assemblerVar)
                    .arg(checkInstance);
            JVar selected = body.decl(typeVar, "selected",
                    selectInstance);
            body.invoke(assemblerVar, CodeConstants.METHOD_ASSEMBLER_INCREASE_INDEX);
            JConditional anIf = body._if(selected.eq(JExpr._null()));
            final JBlock block = anIf._then();
            final JVar jVar = block.decl(modelClass, "newInstance", JExpr.invoke(CodeConstants.METHOD_DAO_INSERT).arg(instance).arg(assemblerVar));
            block.invoke(jVar, "setInserted").arg(JExpr.lit(true));
            block._return(
                    jVar
            );
            //            anIf._else()._return(JExpr._null());
            JBlock jBlock = anIf._else();
            jBlock.invoke(selected, "setInserted").arg(JExpr.lit(false));
            jBlock._return(selected);
            return method;
        }
        return null;
    }

    private JMethod buildUpdateOrInsert() {
        String priKey = info.getPriKey();
        if (priKey != null) {
            JMethod method = definedClass.method(JMod.PUBLIC, modelClass, CodeConstants.METHOD_DAO_UPDATE_OR_INSERT);
            method.annotate(Transactional.class);
            JVar instance = method.param(modelClass, CodeConstants.PARAM_DAO_INSTANCE);
            JVar fields = method.param(CodeConstants.buildNarrowedClass(cm, Set.class, String.class), "conditionField");
            JVar assemblerVar = null;
            assemblerVar = method.param(cm.ref(AbstractMultipleDaoAssembler.class), CodeConstants.PARAM_DAO_ASSEMBLER);
            JBlock body = method.body();
            body._if(assemblerVar.eq(JExpr._null()))._then().assign(assemblerVar, JExpr._new(cm.ref(BaseMultipleDaoAssembler.class)));
            JFieldRef staticRef = CodeConstants.getBaseModelColumnStaticRef(modelClass, priKey);
            JVar checkInstance = body.decl(modelClass, "checkInstance", JExpr._new(modelClass));
            //            IJExpression checkInstance = JExpr.cast(modelClass, body.decl(typeVar, "checkInstance", JExpr._new(modelClass)));
            List<ColumnInfoInterface> columns = info.getColumns();

            for (ColumnInfoInterface col : columns) {
                String colName = col.getAliasField();
                FieldDataTypeInterface type = col.getType();
                JFieldRef staticColRef = CodeConstants.getBaseModelColumnStaticRef(modelClass, colName);
                body._if(fields.invoke("contains").arg(staticColRef))._then()
                        .invoke(checkInstance, CodeConstants.getMethodNameOfModelSet(colName)).arg(JExpr.invoke(instance, CodeConstants.getMethodNameOfModelGet(colName)));
            }
            JInvocation arg = cm.ref(Collections.class).staticInvoke("singleton").arg(staticRef);
            JVar selected = body.decl(typeVar, "selected",
                    JExpr.invoke(SelectMethodEnum.makeUpMethodName(SelectMethodEnum.getOneByCondtion)).arg(arg).arg(assemblerVar).arg(checkInstance));
            body.invoke(assemblerVar, CodeConstants.METHOD_ASSEMBLER_INCREASE_INDEX);
            JConditional anIf = body._if(selected.eq(JExpr._null()));

            //            JBlock block = anIf._then();
            //
            //            block._return(JExpr.invoke(CodeConstants.METHOD_DAO_INSERT).arg(instance).arg(assemblerVar));
            final JBlock block = anIf._then();
            final JVar jVar = block.decl(
                    modelClass,
                    "newInstance",
                    JExpr.invoke(CodeConstants.METHOD_DAO_INSERT).arg(instance).arg(assemblerVar)
            );
            block.invoke(jVar, "setInserted").arg(JExpr.lit(true));
            block._return(
                    jVar
            );
            JBlock jBlock = anIf._else();
            jBlock.invoke(instance, CodeConstants.getMethodNameOfModelSet(priKey)).arg(JExpr.invoke(selected, CodeConstants.getMethodNameOfModelGet(priKey)));
            JInvocation invocation = JExpr.invoke(CodeConstants.METHOD_DAO_UPDATE_BY_ID).arg(instance).arg(assemblerVar);
            jBlock.invoke(instance, "setInserted").arg(JExpr.lit(false));
            jBlock.invoke(instance, "setUpdateCount").arg(invocation);
            jBlock._return(instance);
            return method;
        }
        return null;
    }

    private JMethod buildUpdate(boolean multiple, boolean delete, boolean useId) {
        String priKey = info.getPriKey();
        FieldDataTypeInterface priKeyType = info.getPriKeyType();
        String mName;
        if (useId) {
            if (delete) {
                if (multiple)
                    mName = CodeConstants.METHOD_DAO_DELETE_BY_IDS;
                else
                    mName = CodeConstants.METHOD_DAO_DELETE_BY_ID;
            } else {
                if (multiple)
                    mName = CodeConstants.METHOD_DAO_UPDATE_BY_IDS;
                else
                    mName = CodeConstants.METHOD_DAO_UPDATE_BY_ID;
            }
        } else {
            if (delete)
                mName = CodeConstants.METHOD_DAO_DELETE;
            else
                mName = CodeConstants.METHOD_DAO_UPDATE;
        }
        JMethod method = definedClass.method(JMod.PUBLIC, Integer.class, mName);
        JVar instanceVar = null;
        JVar idsVar = null;
        JVar idVar = null;
        JVar fieldVar = null;
        if (!delete) {
            instanceVar = method.param(modelClass, CodeConstants.PARAM_DAO_INSTANCE);
            if (useId) {
                if (multiple) {
                    idsVar = method.param(CodeConstants.buildNarrowedClass(cm, Set.class, cm.ref(priKeyType.getTClassName())), "ids");
                } else {
                    //                    idVar = method.param(cm.ref(priKeyType.getTClassName()), "id");
                }
            } else {
                //            JVar instance=null;
                //            instanceVar = method.param(modelClazzRef, CodeConstants.PARAM_DAO_INSTANCE);
                fieldVar = method.param(CodeConstants.buildNarrowedClass(cm, Set.class, String.class), "conditionField");
            }
        } else {
            if (useId) {
                if (multiple) {
                    idsVar = method.param(CodeConstants.buildNarrowedClass(cm, Set.class, cm.ref(priKeyType.getTClassName())), "ids");
                } else {
                    idVar = method.param(cm.ref(priKeyType.getTClassName()), "id");
                }
            } else {
                instanceVar = method.param(modelClass, CodeConstants.PARAM_DAO_INSTANCE);
                fieldVar = method.param(CodeConstants.buildNarrowedClass(cm, Set.class, String.class), "conditionField");
            }
        }


        JVar assemblerVar = null;
        assemblerVar = method.param(cm.ref(DaoAssembler.class), CodeConstants.PARAM_DAO_ASSEMBLER);
        JBlock body = method.body();

        JVar sqlBuilderVar = body.decl(
                delete ? cm.ref(SQLDelete.class) : cm.ref(SQLUpdate.class),
                "sqlBuilder",
                cm.ref(SQLBuilder.class).staticInvoke(delete ? CodeConstants.LIB_SQL_BUILD_DELETE : CodeConstants.LIB_SQL_BUILD_UPDATE)

        );
        body.invoke(sqlBuilderVar, CodeConstants.LIB_SQL_BUILD_SET_TABLE).arg(modelClass.staticRef(CodeConstants.FIELD_TABLE_NAME));
        List<ColumnInfoInterface> columns = info.getColumns();


        if (delete) {
            if (multiple) {
                body.invoke(CodeConstants.LIB_ASSERT_METHOD).arg(idsVar.ne(JExpr._null()).cand(idsVar.invoke("size").gt(JExpr.lit(0))));
            } else {
                body.invoke(CodeConstants.LIB_ASSERT_METHOD).arg(idVar.ne(JExpr._null()));
            }
        } else if (useId) {
            if (multiple) {
                body.invoke(CodeConstants.LIB_ASSERT_METHOD).arg(idsVar.ne(JExpr._null()).cand(idsVar.invoke("size").gt(JExpr.lit(0))));
            } else {
                body.invoke(CodeConstants.LIB_ASSERT_METHOD).arg(instanceVar.invoke(CodeConstants.getMethodNameOfModelGet(priKey)).ne(JExpr._null()));
            }
        }
        if (useId) {
            if (multiple) {
                body.invoke(sqlBuilderVar, CodeConstants.LIB_SQL_SET_WHERE)
                        .arg(cm.ref(LogicalOpType.class).staticRef("in"))
                        .arg("__ids")
                        .arg("__ids")
                        .arg(cm.ref(ColumnDataType.class).staticRef("intData"))
                ;
            } else {
                body.invoke(
                        sqlBuilderVar,
                        CodeConstants.LIB_SQL_SET_WHERE)
                        .arg("__id")
                        .arg(cm.ref(ColumnDataType.class).staticRef(priKeyType.name()));
            }
        }
        if (delete) {

        } else {
            for (ColumnInfoInterface col : columns) {
                String colName = col.getAliasField();
                FieldDataTypeInterface type = col.getType();
                JFieldRef staticRef = CodeConstants.getBaseModelColumnStaticRef(modelClass, colName);
                JVar jVar = null;
                //            JConditional anIf = fiBlock._if(fields.invoke("contains").arg(staticRef));
                //            JBlock jBlock = anIf._else();
                jVar = body.decl(
                        CodeConstants.getFieldDefType(cm, modelDef, col, builderContext),
                        "d" + CodeStyleTransformHelper.upperFirstCase(colName),
                        instanceVar.invoke(CodeConstants.getMethodNameOfModelGet(colName))
                );
                if (useId) {
                    if (multiple) {
                        if (!colName.equals(priKey)) {

                            JBlock fiBlock = body._if(jVar.ne(JExpr._null()))._then();
                            fiBlock.invoke(sqlBuilderVar, CodeConstants.LIB_SQL_ADD_ITEM).arg(staticRef);
                        } else {

                            //sqlBuilder.where(LogicalOpType.in,ModelTUserInfo.FI_ID,"ids",FieldDataTypeInterface.intData);

                            body.invoke(instanceVar, CodeConstants.getMethodNameOfModelSet(colName)).arg(JExpr._null());
                            //.arg(staticRef).arg(cm.ref(FieldDataTypeInterface.class).staticRef(type.name()));
                        }
                    } else {
                        JBlock fiBlock = body._if(jVar.ne(JExpr._null()))._then();
                        //                    if (colName.equals(priKey)) {

                        //                    } else {
                        fiBlock.invoke(sqlBuilderVar, CodeConstants.LIB_SQL_ADD_ITEM).arg(staticRef);
                        //                    }
                    }
                } else {
                    JConditional anIf = body._if(fieldVar.invoke("contains").arg(staticRef));
                    JBlock anIfBlock = anIf._then();
                    anIfBlock.invoke(CodeConstants.LIB_ASSERT_METHOD).arg(jVar.ne(JExpr._null()));
                    anIfBlock.invoke(sqlBuilderVar, CodeConstants.LIB_SQL_SET_WHERE).arg(staticRef).arg(cm.ref(ColumnDataType.class).staticRef(type.name()));
                    if (!delete) {
                        //                JConditional anIf = fiBlock._if(fields.invoke("contains").arg(staticRef));
                        JBlock jBlock = anIf._else();
                        JBlock fiBlock = jBlock._if(jVar.ne(JExpr._null()))._then();
                        fiBlock.invoke(sqlBuilderVar, CodeConstants.LIB_SQL_ADD_ITEM).arg(staticRef);

                    } else {

                    }
                }
            }
        }
        //        body.assign(sql, sqlBuilder.invoke(CodeConstants.LIB_SQL_GET_SQL).arg(JExpr._null()));
        JVar paramVar = null;
        JInvocation fieldCommonMapper = CodeConstants.getCommonFieldMapper(name, constantClz);
        if (useId) {
            paramVar = body.decl(CodeConstants.buildNarrowedClass(cm, Map.class, String.class, Object.class), "param");

            if (delete) {
                body.assign(
                        paramVar,
                        cm.ref(Collections.class).staticInvoke("singletonMap")
                                .arg(multiple ? "__ids" : "__id")
                                .arg(multiple ? idsVar : idVar)
                );
            } else {
                body.assign(
                        paramVar,
                        fieldCommonMapper
                                .invoke(CodeConstants.METHOD_JEDIS_MAPPER_TO_COMMON_MAP).arg(instanceVar)
                );
                if (multiple) {
                    body.invoke(paramVar, "put").arg("__ids").arg(idsVar);
                } else {
                    body.invoke(paramVar, "put").arg("__id").arg(instanceVar.invoke(CodeConstants.getMethodNameOfModelGet(priKey)));
                }
            }
        } else {
            paramVar = body.decl(
                    CodeConstants.buildNarrowedClass(cm, Map.class, String.class, Object.class),
                    "param",
                    /*constantClz.staticRef(CodeConstants.getFieldNameOfCommonMapperForModel(name))*/
                    fieldCommonMapper
                            .invoke(CodeConstants.METHOD_JEDIS_MAPPER_TO_COMMON_MAP)
                            .arg(instanceVar)
            );

        }

        body._return(
                JExpr.invoke(JExpr._super(), CodeConstants.METHOD_DAO_PARENT_UPDATE)
                        //                        .arg(dbToUseVar)
                        .arg(assemblerVar)
                        .arg(sqlBuilderVar)
                        .arg(paramVar)
        );
        return method;
    }

    private JMethod buildBatchInsert() {
        JMethod method = definedClass.method(JMod.PUBLIC, cm.ref(Integer.class), CodeConstants.METHOD_DAO_INSERT);
        final AbstractJClass instancesClz = CodeConstants.buildNarrowedClass(cm, List.class, typeVar);
        JVar instances = method.param(instancesClz, "instances");
        JVar fieldsVar = method.param(CodeConstants.buildNarrowedClass(cm, Set.class, String.class), CodeConstants.PARAM_DAO_FIELDS);

        //        cm.ref(modelClazzRef);
        JBlock body = method.body();
        JVar assemblerVar = null;
        assemblerVar = method.param(cm.ref(DaoAssembler.class), CodeConstants.PARAM_DAO_ASSEMBLER);
        String assemblerExtendClzName = modelDef.getAssemblerExtendClzName();
        if (!StringHelper.isEmpty(assemblerExtendClzName)) {
            body._if(assemblerVar.eq(JExpr._null()))
                    ._then()
                    .assign(assemblerVar, JExpr._new(cm.ref(assemblerExtendClzName)));
        }
        //        body._if(assemblerVar.eq(JExpr._null()))._then().assign(assemblerVar, JExpr._new(cm.ref(BaseDaoAssembler.class)));
        JFieldRef fieldMapStaticRefer = modelClass.staticRef(CodeConstants.FIELD_FIELDS_CLASS_CONSTANT_MAP);
        body._if(fieldsVar.eq(JExpr._null()))._then()
                .assign(fieldsVar, fieldMapStaticRefer.invoke("keySet"));
        //        JVar sql = body.decl(cm.ref(String.class), "sql");
        JVar sqlBuilderVar = body.decl(cm.ref(SQLInsert.class), "sqlBuilder", cm.ref(SQLBuilder.class).staticInvoke(CodeConstants.LIB_SQL_BUILD_INSERT));
        body.invoke(sqlBuilderVar, CodeConstants.LIB_SQL_BUILD_SET_TABLE).arg(modelClass.staticRef(CodeConstants.FIELD_TABLE_NAME));
        List<ColumnInfoInterface> columns = info.getColumns();
        for (ColumnInfoInterface col : columns) {
            String colName = col.getAliasField();
            FieldDataTypeInterface type = col.getType();
            JFieldRef staticRef = CodeConstants.getBaseModelColumnStaticRef(modelClass, colName);
            //            JVar jVar = body.decl(parentBuilder.getFieldDefType(col), "d" + CodeStyleTransformHelper.upperFirstCase(colName)
            //                    , instances.invoke(CodeConstants.getMethodNameOfModelGet(colName)));
            JBlock jBlock = body._if(fieldsVar.invoke("contains").arg(staticRef))._then();
            jBlock.invoke(sqlBuilderVar, CodeConstants.LIB_SQL_ADD_ITEM)
                    .arg(staticRef);
        }
        final AbstractJClass narrowedMapClass = CodeConstants.buildNarrowedClass(cm, Map.class, String.class, Object.class);
        JVar paramVar = body.decl(CodeConstants.buildNarrowedClass(cm, List.class, narrowedMapClass),
                "param",
                cm.ref(CollectionHelper.class).staticInvoke("newList").narrow(narrowedMapClass));
        final JForEach forEach = body.forEach(modelClass, CodeConstants.PARAM_DAO_INSTANCE, instances);
        final JVar instance = forEach.var();
        final JBlock foreachInstancesLoop = forEach.body();
        JInvocation fieldCommonMapper = CodeConstants.getCommonFieldMapper(name, constantClz);
        final JVar instanceMap = foreachInstancesLoop.decl(narrowedMapClass, "paramMap",
                fieldCommonMapper.invoke(CodeConstants.METHOD_JEDIS_MAPPER_TO_COMMON_MAP).arg(instance));
        foreachInstancesLoop.invoke(paramVar, "add").arg(instanceMap);

        body._return(
                JExpr.invoke(JExpr._super(), CodeConstants.METHOD_DAO_PARENT_BATCH_INSERT)
                        //                        .arg(dbToUseVar)
                        .arg(assemblerVar)
                        .arg(sqlBuilderVar)
                        .arg(paramVar)
        );

        return method;
    }

    private JMethod buildInsert() {
        JMethod method = definedClass.method(JMod.PUBLIC, modelClass, CodeConstants.METHOD_DAO_INSERT);
        JVar instance = method.param(modelClass, CodeConstants.PARAM_DAO_INSTANCE);
        //        cm.ref(modelClazzRef);
        JBlock body = method.body();
        JVar assemblerVar = null;
        assemblerVar = method.param(cm.ref(DaoAssembler.class), CodeConstants.PARAM_DAO_ASSEMBLER);
        String assemblerExtendClzName = modelDef.getAssemblerExtendClzName();
        if (!StringHelper.isEmpty(assemblerExtendClzName)) {
            body._if(assemblerVar.eq(JExpr._null()))
                    ._then()
                    .assign(assemblerVar, JExpr._new(cm.ref(assemblerExtendClzName)));
        }
        //        body._if(assemblerVar.eq(JExpr._null()))._then().assign(assemblerVar, JExpr._new(cm.ref(BaseDaoAssembler.class)));
        //        JVar sql = body.decl(cm.ref(String.class), "sql");
        JVar sqlBuilderVar = body.decl(cm.ref(SQLInsert.class), "sqlBuilder", cm.ref(SQLBuilder.class).staticInvoke(CodeConstants.LIB_SQL_BUILD_INSERT));

        body.invoke(sqlBuilderVar, CodeConstants.LIB_SQL_BUILD_SET_TABLE).arg(modelClass.staticRef(CodeConstants.FIELD_TABLE_NAME));
        List<ColumnInfoInterface> columns = info.getColumns();
        for (ColumnInfoInterface col : columns) {
            String colName = col.getAliasField();
            FieldDataTypeInterface type = col.getType();
            JFieldRef staticRef = CodeConstants.getBaseModelColumnStaticRef(modelClass, colName);
            JVar jVar = body.decl(CodeConstants.getFieldDefType(cm, modelDef, col, builderContext), "d" + CodeStyleTransformHelper.upperFirstCase(colName)
                    , instance.invoke(CodeConstants.getMethodNameOfModelGet(colName)));
            JBlock jBlock = body._if(jVar.ne(JExpr._null()))._then();
            jBlock.invoke(sqlBuilderVar, CodeConstants.LIB_SQL_ADD_ITEM)
                    .arg(staticRef);
        }
        JInvocation fieldCommonMapper = CodeConstants.getCommonFieldMapper(name, constantClz);
        JVar paramVar = body.decl(CodeConstants.buildNarrowedClass(cm, Map.class, String.class, Object.class), "param",
                //                constantClz.staticRef(CodeConstants.getFieldNameOfCommonMapperForModel(name))
                fieldCommonMapper
                        .invoke(CodeConstants.METHOD_JEDIS_MAPPER_TO_COMMON_MAP).arg(instance));

        JVar ret = body.decl(cm.ref(Long.class), "ret",
                JExpr.invoke(JExpr._super(), CodeConstants.METHOD_DAO_PARENT_INSERT)
                        //                        .arg(dbToUseVar)
                        .arg(assemblerVar)
                        .arg(sqlBuilderVar)
                        .arg(paramVar)
        );
        JConditional anIf = body._if(ret.ne(JExpr._null()));
        FieldDataTypeInterface keyType = info.getPriKeyType();
        String priKey = info.getPriKey();
        JBlock then = anIf._then();
        if (keyType == null || priKey == null) {
            then._return(instance);
        } else {
            JConditional retCondition = then._if(ret.gt(cm.ref(Long.class).staticRef("MIN_VALUE")));
            AbstractJClass ref = cm.ref(keyType.gettClass());
            JInvocation testPackPrType = cm.ref(TypeConstantHelper.class).staticInvoke("testPackPrType").arg(ret).arg(JExpr.dotclass(ref));
            JBlock then1 = retCondition._then();
            then1.invoke(instance, CodeConstants.getMethodNameOfModelSet(priKey))
                    .arg(JExpr.cast(ref, testPackPrType));
            then1._return(instance);
            retCondition._else()._return(instance);
        }
        anIf._else()._return(JExpr._null());
        //        retCondition._else()._return(JExpr._null());
        return method;
    }


    private void buildSelectByModelSQL() {

    }

    private JMethod buildCondSelectCluase() {
        JMethod method = definedClass.method(JMod.PROTECTED, cm.VOID, CodeConstants.METHOD_DAO_BUILD_CONDITION_CLUASE);
        //        JVar fieldsVar = method.param(CodeConstants.buildNarrowedClass(cm, Set.class, String.class), PARAM_DAO_SELECTED_FIELDS);
        JVar sqlBuilder = method.param(SQLSelect.class, "sqlBuilder");//body.decl(cm.ref(SQLSelect.class).narrow(SQLSelect.class), "sqlBuilder", cm.ref(SQL.class).staticInvoke(CodeConstants.LIB_SQL_BUILD_SELECT).arg(modelClazzRef.staticRef(CodeConstants.FIELD_TABLE_NAME)));
        JVar instanceVar = method.param(modelClass, CodeConstants.PARAM_DAO_INSTANCE);
        JVar paramVar = method.param(CodeConstants.buildNarrowedClass(cm, Map.class, String.class, Object.class), "param");
        JBlock body = method.body();
        List<ColumnInfoInterface> columns = info.getColumns();
        for (ColumnInfoInterface col : columns) {
            String colName = col.getAliasField();
            FieldDataTypeInterface type = col.getType();
            JFieldRef staticRef = CodeConstants.getBaseModelColumnStaticRef(modelClass, colName);
            //            if (!isCount && !isSingle) {
            IJExpression invoke = instanceVar.invoke(CodeConstants.getMethodNameOfModelGet(colName));
            EnumTypeDef enumTypeDef = col.getEnumTypeDef();
            AbstractJClass jvarType = CodeConstants.getFieldDefType(cm, modelDef, col, builderContext);
            JVar jVar = body.decl(jvarType, "d" + CodeStyleTransformHelper.upperFirstCase(colName)
                    , invoke);
            JBlock jBlock = body._if(jVar.ne(JExpr._null()))._then();
            jBlock.invoke(sqlBuilder, CodeConstants.LIB_SQL_SET_WHERE).arg(staticRef).arg(cm.ref(ColumnDataType.class).staticRef(type.name()));
            jBlock.invoke(paramVar, "put").arg(staticRef).arg(enumTypeDef == null ? jVar : jVar.ref(CodeConstants.FIELD_ENUM_VAL_FIELD));

        }
        return method;
    }

    private JMethod buildSelectFieldCluase() {
        JMethod method = definedClass.method(JMod.PROTECTED, cm.VOID, CodeConstants.METHOD_DAO_BUILD_SELECT_FIELD_CLUASE);
        JVar sqlBuilder = method.param(cm.ref(SQLSelect.class), "sqlBuilder");
        JVar fieldsVar = method.param(CodeConstants.buildNarrowedClass(cm, Set.class, String.class), CodeConstants.PARAM_DAO_SELECTED_FIELDS);
        //body.decl(cm.ref(SQLSelect.class).narrow(SQLSelect.class), "sqlBuilder", cm.ref(SQL.class).staticInvoke(CodeConstants.LIB_SQL_BUILD_SELECT).arg(modelClazzRef.staticRef(CodeConstants.FIELD_TABLE_NAME)));

        JBlock body = method.body();
        List<ColumnInfoInterface> columns = info.getColumns();
        for (ColumnInfoInterface col : columns) {
            String colName = col.getAliasField();
            FieldDataTypeInterface type = col.getType();
            JFieldRef staticRef = CodeConstants.getBaseModelColumnStaticRef(modelClass, colName);
            //            if (!isCount && !isSingle) {
            body._if(fieldsVar.invoke("contains").arg(staticRef))._then().invoke(sqlBuilder, CodeConstants.LIB_SQL_ADD_ITEM)
                    .arg(staticRef);
            //            }
        }
        return method;
    }


    private JMethod buildSelectSQL(SelectMethod methodDef) {
        //SQLSelect select = SQL.buildSelectSql("table")
        // .items(UserDTO.FIELD_CLASS.keySet().toArray(new String[UserDTO.FIELD_CLASS.size()])).setLimit();
        //        SelectMethod methodDef=SelectMethod.valueOf(methodName);
        if (info.getPriKey() == null && methodDef.isHasIdCondition()) {
            return null;
        }
        String methodName = methodDef.getMethodName();
        boolean multiSelect = methodDef.isMultipleResult();
        boolean conditionSet = methodDef.isCondition();
        boolean useIn = methodDef.isIndex();
        boolean isCount = methodDef.isCount();
        boolean useId = methodDef.isHasIdCondition();
        boolean hasRawItem = methodDef.isHasRawItem();
        boolean hasRawCondition = methodDef.isHasRawConditon();
        boolean isSingle = methodDef.isSingleResult();

        JDirectClass genericType = null;
        AbstractJClass jClass;
        if (isCount) {
            jClass = cm.ref(Long.class);
        } else if (multiSelect) {
            if (isSingle) {

                genericType = cm.directClass("TT");
                //                JMethod method = definedClass.method(JMod.PROTECTED, genericType, CodeConstants.METHOD_DAO_GET_RESULT_SCALAR);
                jClass = CodeConstants.buildNarrowedClass(cm, List.class, genericType);
            } else {
                jClass = CodeConstants.buildNarrowedClass(cm, List.class, typeVar);
            }
        } else {
            if (isSingle) {
                genericType = cm.directClass("TT");
                //                JMethod method = definedClass.method(JMod.PROTECTED, genericType, CodeConstants.METHOD_DAO_GET_RESULT_SCALAR);
                jClass = genericType;

            } else {
                jClass = typeVar;
            }
        }

        Map<String, JVar> jVarMap = CollectionHelper.newMap();
        JMethod method = definedClass.method(JMod.PUBLIC, jClass, methodName);
        if (isSingle) {
            method.generify("TT");


        }
        JVar startVar = null;
        JVar countVar = null;
        JVar indexesVar = null;
        JVar fieldVar = null;
        JVar instanceVar = null;
        JVar tClassVar = null;
        JVar rawItemVar = null;
        JVar fieldsVar = null;
        JVar paramVar = null;
        JVar additionParamVar = null;
        JVar additionConditionVar = null;
        JVar assemblerVar = null;
        JVar idVar = null;
        JBlock body = method.body();
        /**
         * declare method parameters start
         */
        if (!isCount && !isSingle) {
            fieldsVar = method.param(CodeConstants.buildNarrowedClass(cm, Set.class, String.class), CodeConstants.PARAM_DAO_SELECTED_FIELDS);
        }
        assemblerVar = method.param(cm.ref(DaoAssembler.class), CodeConstants.PARAM_DAO_ASSEMBLER);
        if (multiSelect) {
            startVar = method.param(Integer.class, CodeConstants.PARAM_DAO_START);
            countVar = method.param(Integer.class, CodeConstants.PARAM_DAO_COUNT);
        }
        if (conditionSet) {
            instanceVar = method.param(modelClass, CodeConstants.PARAM_DAO_INSTANCE);
        }
        if (useId) {
            if (priKey != null && priKeyType != null) {
                AbstractJClass ref;
                if (useIn) {
                    ref = CodeConstants.buildNarrowedClass(cm, List.class, priKeyType.gettClass());
                } else {
                    ref = cm.ref(priKeyType.gettClass());
                }
                idVar = method.param(ref, priKey);
                jVarMap.put(priKey, idVar);
            }
        }
        if (useIn && !useId) {
            fieldVar = method.param(cm.ref(String.class), CodeConstants.PARAM_DAO_INDEX_IN_FIELD);
            indexesVar = method.param(cm.ref(List.class), CodeConstants.PARAM_DAO_INDEXES);
        }
        if (isSingle) {
            tClassVar = method.param(CodeConstants.buildNarrowedClass(cm, Class.class, genericType), CodeConstants.PARAM_DAO_T_CLASS);

        }
        if (hasRawItem) {
            rawItemVar = method.param(cm.ref(String.class), CodeConstants.PARAM_DAO_RAW_ITEM);
        }
        if (hasRawCondition) {
            additionParamVar = method.param(CodeConstants.buildNarrowedClass(cm, Map.class, String.class, Object.class), CodeConstants.PARAM_DAO_EXT_PARAME);
            additionConditionVar = method.param(CodeConstants.buildNarrowedClass(cm, Set.class, String.class), CodeConstants.PARAM_DAO_EXT_CONDITION);
        }
        /**
         * declare method parameters end
         */
        String assemblerExtendClzName = modelDef.getAssemblerExtendClzName();
        if (!StringHelper.isEmpty(assemblerExtendClzName)) {
            body._if(assemblerVar.eq(JExpr._null()))
                    ._then()
                    .assign(assemblerVar, JExpr._new(cm.ref(assemblerExtendClzName)));
        }
        JFieldRef fieldMapStaticRefer = modelClass.staticRef(CodeConstants.FIELD_FIELDS_CLASS_CONSTANT_MAP);
        if (!isCount && !isSingle) {
            body._if(fieldsVar.eq(JExpr._null()))._then()
                    .assign(fieldsVar, fieldMapStaticRefer.invoke("keySet"));
        }

        //FIXME: JVar sqlBuilder = body.decl(cm.ref(SQLSelect.class).narrow(SQLSelect.class), "sqlBuilder", cm.ref(SQL.class).staticInvoke(CodeConstants.LIB_SQL_BUILD_SELECT).arg(modelClazzRef.staticRef(CodeConstants.FIELD_TABLE_NAME)));
        JVar sqlBuilder = body.decl(
                cm.ref(SQLSelect.class),
                "sqlBuilder",
                cm.ref(SQLBuilder.class).staticInvoke(CodeConstants.LIB_SQL_BUILD_SELECT)//.arg(modelClazzRef.staticRef(CodeConstants.FIELD_TABLE_NAME))
        );
        body.invoke(sqlBuilder, CodeConstants.LIB_SQL_BUILD_SET_TABLE).arg(modelClass.staticRef(CodeConstants.FIELD_TABLE_NAME));
        if (multiSelect) {
            CodeConstants.setDefaultLimit(cm, body, startVar, countVar);
        } else {
            startVar = body.decl(cm.ref(Integer.class), CodeConstants.PARAM_DAO_START, JExpr.lit(0));
            countVar = body.decl(cm.ref(Integer.class), CodeConstants.PARAM_DAO_COUNT, JExpr.lit(1));
        }
        jVarMap.put(CodeConstants.PARAM_DAO_START, startVar);
        jVarMap.put(CodeConstants.PARAM_DAO_COUNT, countVar);

        //paramVar = CodeConstants.buildStringObjectMapParam(cm, body, jVarMap);
        paramVar = body.decl(
                CodeConstants.buildNarrowedClass(cm, Map.class, String.class, Object.class),
                "param",
                cm.ref(CollectionHelper.class).staticInvoke("newMap")
        );
        body.invoke(paramVar, "put").arg(cm.ref(DaoInterface.class).staticRef("KEY_WORD_LIMIT_START")).arg(startVar);
        body.invoke(paramVar, "put").arg(cm.ref(DaoInterface.class).staticRef("KEY_WORD_LIMIT_COUNT")).arg(countVar);
        //        body.decl(String.class,"cTableName",)
        if (hasRawCondition) {

            body.invoke(JExpr._super(), CodeConstants.METHOD_DAO_BUILD_RAW_WHERE)
                    .arg(sqlBuilder)
                    .arg(paramVar)
                    .arg(additionParamVar)
                    .arg(additionConditionVar);
        }

        List<ColumnInfoInterface> columns = info.getColumns();
        if (isCount) {
            body.invoke(sqlBuilder, CodeConstants.LIB_SQL_ADD_RAW_ITEM).arg(JExpr.lit("count(*)")).arg(JExpr.lit("count"));
        }
        if (isSingle) {
            body.invoke(CodeConstants.LIB_ASSERT_METHOD).arg(tClassVar.ne(JExpr._null()));
        }

        if (hasRawItem) {
            body.invoke(CodeConstants.LIB_ASSERT_METHOD)
                    .arg(
                            (rawItemVar.ne(JExpr._null()))
                                    .cand(rawItemVar.invoke("length").gt(JExpr.lit(0)))
                    );
            body.invoke(sqlBuilder, CodeConstants.LIB_SQL_ADD_RAW_ITEM).arg(rawItemVar);
        }
        if (conditionSet) {
            body.invoke(CodeConstants.METHOD_DAO_BUILD_CONDITION_CLUASE).arg(sqlBuilder).arg(instanceVar).arg(paramVar);
        }
        if (!isCount && !isSingle) {
            body.invoke(CodeConstants.METHOD_DAO_BUILD_SELECT_FIELD_CLUASE).arg(sqlBuilder).arg(fieldsVar);
        }

        if (useIn && !useId) {
            body.invoke(CodeConstants.METHOD_DAO_BUILD_IN_CLUASE)
                    .arg(sqlBuilder)
                    .arg(fieldVar)
                    .arg(paramVar)
                    .arg(indexesVar)
            ;

        }
        JFieldRef priStaticRef = null;
        if (useId && priKey != null) {
            priStaticRef = CodeConstants.getBaseModelColumnStaticRef(modelClass, priKey);

            final JBlock idThenBlock = body._if(idVar.ne(JExpr._null()))._then();
            if (!multiSelect) {
                idThenBlock.invoke(sqlBuilder, CodeConstants.LIB_SQL_SET_WHERE)
                        .arg(priStaticRef)
                        .arg(cm.ref(ColumnDataType.class).staticRef(priKeyType.name()));
            } else {
                //(LogicalRelationshipType type, LogicalOpType logicalOpType, String tableAlis, String item, String paramName, FieldDataTypeInterface dataType)
                idThenBlock.invoke(sqlBuilder, CodeConstants.LIB_SQL_SET_WHERE)
                        .arg(cm.ref(LogicalRelationshipType.class).staticRef("and"))
                        .arg(cm.ref(LogicalOpType.class).staticRef("in"))
                        .arg(JExpr._null())
                        .arg(priStaticRef)
                        .arg(priStaticRef)
                        .arg(cm.ref(ColumnDataType.class).staticRef(priKeyType.name()))
                ;

            }
            idThenBlock.invoke(paramVar, "put").arg(priStaticRef).arg(idVar);
        }
        body.invoke(sqlBuilder, CodeConstants.LIB_SQL_SET_LIMIT);

        //        body.invoke(assemblerVar,CodeConstants.LIB_SQL_ASSEMBLE_PARAM).arg(param).arg(JExpr.dotclass(modelClazzRef));
        if (isCount) {
            body._return(
                    JExpr.invoke(CodeConstants.METHOD_DAO_GET_RESULT_SCALAR)
                            .arg(assemblerVar).arg(sqlBuilder).arg(paramVar).arg(JExpr.dotclass(cm.ref(Long.class)))
            );
        } else if (isSingle) {
            //            if(multiSelect){
            //
            //            }else {
            body._return(
                    JExpr.cast(jClass, JExpr.invoke(multiSelect ? CodeConstants.METHOD_DAO_GET_RESULT_SINGLE_LIST : CodeConstants.METHOD_DAO_GET_RESULT_SCALAR)
                            .arg(assemblerVar).arg(sqlBuilder).arg(paramVar).arg(tClassVar))
            );
            //            }
        } else {
            body._return(
                    JExpr.invoke(multiSelect ? CodeConstants.METHOD_DAO_GET_RESULT_LIST : CodeConstants.METHOD_DAO_GET_RESULT)
                            .arg(assemblerVar).arg(sqlBuilder).arg(paramVar)
            );
        }
        return method;
    }

}
