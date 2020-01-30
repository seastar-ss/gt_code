//package com.shawn.ss.lib.code_gen.base.dao.special_dao.special_dao_builder;
//
//import com.helger.jcodemodel.*;
//import com.shawn.ss.lib.code_gen.base.dao.AbstractDaoBuilder;
//import com.shawn.ss.lib.code_gen.base.helper.CodeConstants;
//import com.shawn.ss.lib.code_gen.base.helper.ModelBuilderContext;
//import com.shawn.ss.lib.code_gen.model.def_model.dao_def.SpecialModelDaoConf;
//import com.shawn.ss.lib.tools.CodeStyleTransformHelper;
//import com.shawn.ss.lib.tools.CollectionHelper;
//import com.shawn.ss.lib.tools.StringHelper;
//import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.ColumnInfoInterface;
//import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.FieldInfoInterface;
//import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model.FieldDataTypeInterface;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.util.List;
//import java.util.Map;
//
///**
// * Created by ss on 2018/1/17.
// */
//public class SpecialDaoBuilder extends AbstractDaoBuilder {
//
//    private final SpecialModelDaoConf def;
//    private final String name;
//    private String handleSqlMethod;
//
//
//    public SpecialDaoBuilder(SpecialModelDaoConf def, ModelBuilderContext builderContext) {
//        super(def);
//        this.def = def;
//        name = CodeStyleTransformHelper.underlineSplittedStyleToHumpStyle(def.getMethodName());
//        String clzName = def.getClzName();
//        if (!StringHelper.isEmpty(clzName)) {
//            daoClassName = builderContext.getDaoClassName(clzName, def.getBaseTable(), 2);
//        }
//        handleSqlMethod = "handle" + name + "SqlStr";
//    }
//
//    @Override
//    public void buildModel() {
//
//        definedClass = cm._getClass(daoClassName);
//        try {
//            if (definedClass == null) {
//                super.buildModel();
//            } else {
//                if (loggerField == null) {
//                    Map<String, JFieldVar> fields = definedClass.fields();
//                    if (fields.containsKey(CodeConstants.FIELD_DAO_LOGGER)) {
//                        loggerField = fields.get("logger");
//                    } else {
//                        loggerField = definedClass.field(CodeConstants.MODE_PUBLIC_STATIC_FINAL, cm.ref(Logger.class), CodeConstants.FIELD_DAO_LOGGER,
//                                cm.ref(LoggerFactory.class).staticInvoke("getLogger").arg(JExpr.dotclass(definedClass)));
//                    }
//                }
//            }
//
//            JMethod method = buildSelectMethod();
//            ModelBuilderContext.registerMethod(method);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    private JMethod buildSelectMethod() {
//        SpecialModelDaoConf.DataAttrType type = def.getDataType();
//        AbstractJClass abstractJClass = null;
//        Class aClass = null;
//        ColumnInfoInterface columnInfoInterface;
//        if (type.equals(SpecialModelDaoConf.DataAttrType.LIST_OBJ)) {
//            abstractJClass = CodeConstants.buildNarrowedClass(cm, List.class, modelClass);
//        } else if (type.equals(SpecialModelDaoConf.DataAttrType.OBJ)) {
//            abstractJClass = modelClass;
//        } else {
//            columnInfoInterface = info.getColumns().get(0);
//
//            aClass = columnInfoInterface.getType().gettClass();
//            if (type.equals(SpecialModelDaoConf.DataAttrType.SINGLE)) {
//                abstractJClass = cm.ref(aClass);
//            } else if (type.equals(SpecialModelDaoConf.DataAttrType.LIST)) {
//                abstractJClass = CodeConstants.buildNarrowedClass(cm, List.class, aClass);
//            }
//        }
//        JMethod method = definedClass.method(JMod.PUBLIC, abstractJClass, CodeStyleTransformHelper.lowerFirstCase(name));
//        Map<String, Object> defualtParam = def.getDefualtParam();
////        Set<Map.Entry<String, Object>> entries = defualtParam.entrySet();
//        List<FieldInfoInterface> params = def.getParams();
//        Map<String, JVar> allVars = CollectionHelper.newMap();
//        JBlock body = method.body();
//
//        for (FieldInfoInterface entry : params) {
//            AbstractJClass classFromDef = CodeConstants.getClassFromDef(cm, entry);
//            String paramName = entry.getFieldName();
//            JVar param = method.param(classFromDef, paramName);
//
//            JMethod paramMethod = buildHandleParam(param, defualtParam, entry);
//            body.assign(param, JExpr.invoke(paramMethod).arg(param));
//            allVars.put(paramName, param);
//        }
//        JVar mapVar = CodeConstants.buildStringObjectMapParam(cm, body, allVars);
//        String methodName = null;
//        if (type.equals(SpecialModelDaoConf.DataAttrType.LIST_OBJ)) {
//            methodName = CodeConstants.LIB_DB_QUERY;
//        } else if (type.equals(SpecialModelDaoConf.DataAttrType.OBJ)) {
//            methodName = CodeConstants.LIB_DB_QUERY_ONE;
//        } else if (type.equals(SpecialModelDaoConf.DataAttrType.SINGLE)) {
//            methodName = CodeConstants.LIB_DB_QUERY_ONE;
//        } else if (type.equals(SpecialModelDaoConf.DataAttrType.LIST)) {
//            methodName = CodeConstants.LIB_DB_QUERY_LIST;
//        }
//        JFieldRef ref = null;
//        if (dbField == null) {
//            ref = JExpr.ref(JExpr._this(), CodeConstants.FIELD_DAO_DB_FIELD);
//        }
//        JInvocation invocation = JExpr.invoke(dbField == null ? ref : dbField, methodName);
////        JFieldVar field=null;
//        JFieldRef fieldRef = null;
////        if (type.equals(SpecialModelDef.DataAttrType.LIST_OBJ) || type.equals(SpecialModelDef.DataAttrType.OBJ)) {
////
////            fieldRef = buildSqlConstantsString(def, modelClass.staticRef(CodeConstants.FIELD_MODEL_RELATED_SQL));
////
////            String sqlConstantClzName = builderContext.getClzName(CodeConstants.CLASS_NAME_ALL_SQL_CONTANT_CLASS);
////
////
////        } else if (type.equals(SpecialModelDef.DataAttrType.SINGLE) || type.equals(SpecialModelDef.DataAttrType.LIST)) {
//////            field = definedClass.field(CodeConstants.MODE_PUBLIC_STATIC_FINAL, String.class, CodeConstants.FIELD_DAO_RELATED_SQL_PREFIX + name.toUpperCase(), JExpr.lit(def.getSql()));
////            fieldRef = buildSqlConstantsString(def, null);
////            invocation.arg(fieldRef);
////        }
//        fieldRef = buildSqlConstantsString(def, null);
//        buildSqlHandleMethod( mapVar);
//        JVar sqlStr = body.decl(cm.ref(String.class), "sqlStr", JExpr.invoke(handleSqlMethod).arg(fieldRef).arg(mapVar));
//        invocation.arg(sqlStr);
//        invocation.arg(mapVar);
////        IJExpression expr=null;
////        if(field!=null){
////            expr=field;
////        }else if(fieldRef!=null){
////            expr=fieldRef;
////        }
//        addLogs(body, fieldRef, mapVar);
//        if (type.equals(SpecialModelDaoConf.DataAttrType.LIST_OBJ) || type.equals(SpecialModelDaoConf.DataAttrType.OBJ)) {
//            invocation.arg(modelClass.staticRef(CodeConstants.FIELD_RESULT_SET_MAPPER_INSTANCE_APPENDIX));
//        } else if (type.equals(SpecialModelDaoConf.DataAttrType.SINGLE) || type.equals(SpecialModelDaoConf.DataAttrType.LIST)) {
//            invocation.arg(JExpr.dotclass(cm.ref(aClass)));
//        }
//        JVar ret = body.decl(method.type(), "ret", invocation);
//        body._return(ret);
//        return method;
//    }
//
//    private void buildSqlHandleMethod( JVar mapVar) {
//        JMethod method = definedClass.method(JMod.PROTECTED, String.class, handleSqlMethod);
//        JVar sql = method.param(String.class, "sql");
//        method.param(mapVar.type(), "param");
//        method.body()._return(sql);
//        return;
//    }
//
//    private JFieldRef buildSqlConstantsString(SpecialModelDaoConf def, JFieldRef ref) {
//        String clzName = builderContext.getClzName(CodeConstants.CLASS_NAME_ALL_SQL_CONTANT_CLASS);
//        JDefinedClass contantsClazz = cm._getClass(clzName);
//        if (contantsClazz == null) {
//            try {
//                contantsClazz = cm._class(JMod.PUBLIC + JMod.FINAL, clzName);
//            } catch (JClassAlreadyExistsException e) {
//                e.printStackTrace();
//            }
//        }
//        String lstName = null;
//        String defClzName = def.getClzName();
//        if (defClzName.contains(".")) {
//            String[] split = defClzName.split("\\.");
//            lstName = split[split.length - 1];
//        }else{
//            lstName=defClzName;
//        }
//        if(contantsClazz!=null) {
//            JFieldVar field = contantsClazz.field(CodeConstants.MODE_PUBLIC_STATIC_FINAL, String.class, CodeConstants.FIELD_DAO_RELATED_SQL_PREFIX + lstName.toUpperCase() + "_" + name.toUpperCase(),
//                    ref == null ? JExpr.lit(def.getSql()) : ref);
//            return field.fieldRef();
//        }
//
//        throw new IllegalStateException("something wrong for class creation:"+clzName);
//    }
//
//    private JMethod buildHandleParam(JVar param, Map<String, Object> key, FieldInfoInterface entry) {
//        String paramName = entry.getFieldName();
//        FieldDataTypeInterface type = entry.getType();
//        JMethod method = definedClass.method(JMod.PROTECTED, param.type(), "handle" + name + CodeStyleTransformHelper.upperFirstCase(paramName));
//        JVar mparam = method.param(param.type(), "param");
//        JBlock mbody = method.body();
//        JBlock jBlock = null;
//        if (type.isArray()) {
//            jBlock = mbody._if(mparam.eq(JExpr._null()).cor(mparam.ref("length").eq(JExpr.lit(0))))._then();
//            jBlock._throw(JExpr._new(cm.ref(IllegalArgumentException.class)).arg("empty array find for query param " + paramName));
//        } else if (type.isCollection()) {
//            jBlock = mbody._if(mparam.eq(JExpr._null()).cor(JExpr.invoke(mparam, "size").eq(JExpr.lit(0))))._then();
//            jBlock._throw(JExpr._new(cm.ref(IllegalArgumentException.class)).arg("empty list find for query param " + paramName));
//        } else {
//            Object o = key.get(paramName);
//            if (o != null) {
//                jBlock = mbody._if(mparam.eq(JExpr._null()))._then();
//                jBlock.assign(mparam, CodeConstants.litObject(o));
//            }
//        }
//        mbody._return(mparam);
//        return method;
//    }
//}
