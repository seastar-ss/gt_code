package com.shawn.ss.lib.code_gen.base.common;

import com.helger.jcodemodel.*;
import com.shawn.ss.lib.code_gen.CodeBuilderInterface;
import com.shawn.ss.lib.code_gen.base.helper.CodeConstants;
import com.shawn.ss.lib.code_gen.base.helper.ModelBuilderContext;
import com.shawn.ss.lib.code_gen.model.def_model.interfaces._BaseConstantDef;
import com.shawn.ss.lib.code_gen.model.def_model.interfaces._BaseModelConf;
import com.shawn.ss.lib.code_gen.model.def_model.common.CommonPOJOConf;
import com.shawn.ss.lib.code_gen.model.def_model.dao_def.CommonModelDaoDef;
import com.shawn.ss.lib.tools.CodeStyleTransformHelper;
import com.shawn.ss.lib.tools.CollectionHelper;
import com.shawn.ss.lib.tools.TypeConstantHelper;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.FieldInfoInterface;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model.EnumTypeDef;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model.FieldDataTypeInterface;
import com.shawn.ss.lib.tools.db.api.interfaces.mappers.db.RedisMapMapper;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class MapperOfPojoBuilder implements CodeBuilderInterface {

//    final PoModelBuilder poModelBuilder;
//    final POJOModelBuilder parentModelBuilder;
    final JCodeModel cm;
    final String mapperClassName;
    JDefinedClass definedClass;
    JDefinedClass modelClass;
    final _BaseModelConf modelDef;
//    final CommonModelDef poModelDef;
    ModelBuilderContext builderContext;
//    Map<String,FieldInfoInterface> fieldsBothHave;


//    public MapperOfPojoBuilder(POJOModelBuilder parentModelBuilder) {
//        this(null, parentModelBuilder);
//    }

    public MapperOfPojoBuilder(_BaseModelConf modelDef){
//        this.parentModelBuilder = parentModelBuilder;
        String modelClassName = modelDef.getPojoClzName();
        mapperClassName = CodeConstants.CLASS_NAME_POJO_MAPPER_PREFIX + CodeConstants.getClassNameFromFullName(modelClassName);
        builderContext = modelDef.getBuilderContext();
        cm=builderContext.getCm();
        modelClass=modelDef.getDeclaredModel();
        this.modelDef=modelDef;
       // buildInterception(poModelDef,modelDef);
//        this.poModelBuilder = poModelBuilder;
//        if (poModelBuilder != null)
//            poModelDef = poModelBuilder.getModelDef();
//        else
//            poModelDef = null;
    }

    private void buildInterception(CommonModelDaoDef poModelDef, CommonPOJOConf modelDef) {
        if(poModelDef!=null){

        }
    }

    @Override
    public void buildModel() {
        //modelClass = parentModelBuilder.getDefinedClass();
        try {
            this.definedClass = modelClass._class(CodeConstants.MODE_PUBLIC_STATIC, mapperClassName);
            JNarrowedClass interfaceClass = cm.ref(RedisMapMapper.class).narrow(modelClass);
            definedClass._implements(interfaceClass);

            buildMethodFromMapByte();
            buildMethodToMapByte();
            buildMethodToCommonMap();
            buildMethodFromCommonMap();
            buildMethodGetField();
            buildMethodSetField();
            buildMethodSetFieldByte();
//            modelClass.field(CodeConstants.MODE_PUBLIC_STATIC_FINAL, definedClass, CodeConstants.FIELD_REDIS_MAP_MAPPER_INSTANCE, JExpr._new(definedClass));
//            JNarrowedClass baseClass = cm.ref(BaseDbMapper.class).narrow(modelClass);
//            definedClass._extends(baseClass);
            buildNewInstance();
        } catch (JClassAlreadyExistsException e) {
            e.printStackTrace();
        }
    }

    private void buildNewInstance() {
        _BaseConstantDef constant = modelDef.getConstant();

        constant.getConstantClz().field(CodeConstants.MODE_PUBLIC_STATIC_FINAL,definedClass.narrow(modelClass), CodeConstants.getFieldNameOfCommonMapperForModel(modelDef.getName()),JExpr._new(definedClass).narrow(modelClass));
    }

    private void buildToPo() {

    }

    private void buildFromPo() {

    }

    private void buildMethodSetFieldByte() {
        JMethod method = definedClass.method(JMod.PUBLIC, void.class, CodeConstants.METHOD_JEDIS_MAPPER_SET_FIELD);
        JBlock body = method.body();
        JVar field = method.param(String.class, "field");
        JVar instance = method.param(modelClass, "instance");
        JVar value = method.param(byte[].class, "value");
        List<FieldInfoInterface> columns = modelDef.getFields();
        JConditional equals = null;
        for (FieldInfoInterface col : columns) {
            String colName = col.getFieldName();
            FieldDataTypeInterface type = col.getType();
            JInvocation invocation = field.invoke("equals")
                    .arg(CodeConstants.getBaseModelColumnStaticRef(modelClass, colName));
            if (equals == null) {
                equals = body._if(invocation);
            } else {
                equals = equals._elseif(invocation);
            }

            equals._then().invoke(instance, CodeConstants.getMethodNameOfModelSet(colName))
                    .arg(JExpr.invoke(CodeConstants.getMethodNameOfRedisMapperMapToField(colName))
                            .arg(value)
                    );
        }
    }

    private void buildMethodSetField() {
        JDirectClass genericType = cm.directClass("TT");
        JMethod method = definedClass.method(JMod.PUBLIC, void.class, CodeConstants.METHOD_JEDIS_MAPPER_SET_FIELD);
        method.generify("TT");
        JBlock body = method.body();
        JVar field = method.param(String.class, "field");
        JVar instance = method.param(modelClass, "instance");
        JVar value = method.param(genericType, "value");
        List<FieldInfoInterface> columns = modelDef.getFields();
        JConditional equals = null;
        for (FieldInfoInterface col : columns) {
            String colName = col.getFieldName();
            FieldDataTypeInterface type = col.getType();
            JInvocation invocation = field.invoke("equals")
                    .arg(CodeConstants.getBaseModelColumnStaticRef(modelClass, colName));
            if (equals == null) {
                equals = body._if(invocation);
            } else {
                equals = equals._elseif(invocation);
            }
            JTryBlock jTryBlock = equals._then()._try();
            jTryBlock.body().invoke(instance, CodeConstants.getMethodNameOfModelSet(colName))
                    .arg(JExpr.invoke(CodeConstants.getMethodNameOfRedisMapperMapToField(colName))
                            .arg(value));
            CodeConstants.buildCatchPrintStatement(cm, jTryBlock, Exception.class);

        }
    }

    private void buildMethodGetField() {
        JDirectClass genericType = cm.directClass("TT");
//        AbstractJType declarable =
        JMethod method = definedClass.method(JMod.PUBLIC, genericType, CodeConstants.METHOD_JEDIS_MAPPER_GET_FIELD);
        method.generify("TT");
        JVar field = method.param(String.class, "field");
        JVar instance = method.param(modelClass, "instance");
        JBlock body = method.body();
        JTryBlock aTry = body._try();
        JBlock trybody = aTry.body();
        List<FieldInfoInterface> columns = modelDef.getFields();
        JConditional equals = null;
        for (FieldInfoInterface col : columns) {
            String colName = col.getFieldName();
            FieldDataTypeInterface type = col.getType();
            JInvocation invocation = field.invoke("equals")
                    .arg(CodeConstants.getBaseModelColumnStaticRef(modelClass, colName));
            if (equals == null) {
                equals = trybody._if(invocation);
            } else {
                equals = equals._elseif(invocation);
            }
            JBlock then = equals._then();
            then._return(JExpr.cast(genericType, instance.invoke(CodeConstants.getMethodNameOfModelGet(colName))));
        }
        CodeConstants.buildCatchPrintStatement(cm, aTry, Exception.class);
        body._return(JExpr._null());
    }

    private void buildMethodFromCommonMap() {
        AbstractJClass retClass = CodeConstants.buildNarrowedClass(cm, Map.class, String.class, Object.class);
        JMethod method = definedClass.method(JMod.PUBLIC, modelClass, CodeConstants.METHOD_JEDIS_MAPPER_FROM_COMMON_MAP);
        method.annotate(Override.class);
        JVar param = method.param(retClass, "param");
        JBlock body = method.body();
        JVar ret = body.decl(modelClass, "ret", JExpr._new(modelClass));
        body._if(param.eq(JExpr._null()))._then()._return(ret);
        List<FieldInfoInterface> columns = modelDef.getFields();
        JConditional equals = null;
        for (FieldInfoInterface col : columns) {
            String colName = col.getFieldName();
            FieldDataTypeInterface type = col.getType();
            JFieldRef ref = CodeConstants.getBaseModelColumnStaticRef(modelClass, colName);
            final JVar objVar = body.decl(cm.ref(Object.class), "d" + CodeStyleTransformHelper.upperFirstCase(colName), JExpr.invoke(param, "get").arg(ref));
            final JBlock thenBlock = body._if(objVar.ne(JExpr._null()))._then();
//            EnumTypeDef enumTypeDef = col.getEnumTypeDef();
            buildMapObjToField(col);
            thenBlock.invoke(JExpr._this(), CodeConstants.METHOD_JEDIS_MAPPER_SET_FIELD)
                    .arg(ref).arg(ret).arg(objVar);
//            if(enumTypeDef!=null){
//                invoke=invoke.ref(CodeConstants.FIELD_ENUM_VAL_FIELD);
//            }


//            body._if(jVar.ne(JExpr._null()))._then().invoke(ret,"put").arg(ref)
//                    .arg(enumTypeDef==null?jVar:jVar.ref(CodeConstants.FIELD_ENUM_VAL_FIELD));
        }
        body._return(ret);
    }

    private void buildMethodToCommonMap() {
        AbstractJClass retClass = CodeConstants.buildNarrowedClass(cm, Map.class, String.class, Object.class);
        JMethod method = definedClass.method(JMod.PUBLIC, retClass, CodeConstants.METHOD_JEDIS_MAPPER_TO_COMMON_MAP);
        method.annotate(Override.class);
        JVar instance = method.param(modelClass, "instance");
        JBlock body = method.body();
        JVar ret = body.decl(retClass, "ret", cm.ref(CollectionHelper.class).staticInvoke("newMap"));
        body._if(instance.eq(JExpr._null()))._then()._return(ret);
        List<FieldInfoInterface> columns = modelDef.getFields();
        JConditional equals = null;
        for (FieldInfoInterface col : columns) {
            String colName = col.getFieldName();
            FieldDataTypeInterface type = col.getType();
            JFieldRef ref = CodeConstants.getBaseModelColumnStaticRef(modelClass, colName);
            IJExpression invoke = instance.invoke(CodeConstants.getMethodNameOfModelGet(colName));
            EnumTypeDef enumTypeDef = col.getEnumTypeDef();
//            if(enumTypeDef!=null){
//                invoke=invoke.ref(CodeConstants.FIELD_ENUM_VAL_FIELD);
//            }

            JVar jVar = body.decl(CodeConstants.getFieldDefType(cm, modelDef, col, builderContext), "d" + CodeStyleTransformHelper.upperFirstCase(colName)
                    , invoke);
            body._if(jVar.ne(JExpr._null()))._then().invoke(ret, "put").arg(ref).arg(enumTypeDef == null ? jVar : jVar.ref(CodeConstants.FIELD_ENUM_VAL_FIELD));
        }
        body._return(ret);
    }

    private void buildMethodToMapByte() {
        AbstractJClass retClass = CodeConstants.buildNarrowedClass(cm, Map.class, byte[].class, byte[].class);
        JMethod method = definedClass.method(JMod.PUBLIC, retClass, CodeConstants.METHOD_JEDIS_MAPPER_TO_MAP);
        method.annotate(Override.class);
        JVar instance = method.param(modelClass, "instance");
        JBlock body = method.body();
        JVar ret = body.decl(retClass, "ret", cm.ref(CollectionHelper.class).staticInvoke("newMap"));
        body._if(instance.eq(JExpr._null()))._then()._return(ret);
        List<FieldInfoInterface> columns = modelDef.getFields();
        JConditional equals = null;
        for (FieldInfoInterface col : columns) {
            String colName = col.getFieldName();
            FieldDataTypeInterface type = col.getType();
            JMethod m = buildMapFieldToBin(col);
            JVar value = body.decl(cm.ref(byte[].class), "value" + CodeStyleTransformHelper.upperFirstCase(colName),
                    JExpr.invoke(m).arg(instance.invoke(CodeConstants.getMethodNameOfModelGet(colName))));
            JFieldRef ref = CodeConstants.getBaseModelColumnStaticRef(modelClass, colName);
            body.invoke(ret, "put").arg(ref.invoke("getBytes")).arg(value);
        }
        body._return(ret);
    }


    private void buildMethodFromMapByte() {
        JMethod method = definedClass.method(JMod.PUBLIC, modelClass, CodeConstants.METHOD_JEDIS_MAPPER_FROM_MAP);
        method.annotate(Override.class);
        JVar map = method.param(CodeConstants.buildNarrowedClass(cm, Map.class, byte[].class, byte[].class), "map");
        JBlock body = method.body();
        JVar instance = body.decl(modelClass, "instance", JExpr._new(modelClass));
        AbstractJClass mapEntryClz = CodeConstants.buildNarrowedClass(cm, Map.Entry.class, byte[].class, byte[].class);
        JVar entries = body.decl(CodeConstants.buildNarrowedClass(cm, Set.class, mapEntryClz), "entries", map.invoke("entrySet"));
        JForEach forEach = body.forEach(mapEntryClz, "entry", entries);
        JVar var = forEach.var();
        JBlock forBody = forEach.body();
        JVar varField = forBody.decl(cm.ref(String.class), "field", JExpr._new(cm.ref(String.class)).arg(var.invoke("getKey")));

        List<FieldInfoInterface> columns = modelDef.getFields();
        JConditional equals = null;
        for (FieldInfoInterface col : columns) {
            JMethod fieldMapMethod = buildMapBinToField(col);
            String colName = col.getFieldName();
            JInvocation condition = varField.invoke("equals").arg(CodeConstants.getBaseModelColumnStaticRef(modelClass, colName));
            if (equals == null)
                equals = forBody._if(condition);
            else
                equals = equals._elseif(condition);
            equals._then().invoke(instance, CodeConstants.getMethodNameOfModelSet(colName)).arg(JExpr.invoke(fieldMapMethod).arg(var.invoke("getValue")));
        }
        body._return(instance);
    }

    private JMethod buildMapBinToField(FieldInfoInterface col) {
        String colName = col.getFieldName();
        FieldDataTypeInterface type = col.getType();
        AbstractJClass retClz = CodeConstants.getFieldDefType(cm, modelDef, col, builderContext);
        JMethod method = definedClass.method(JMod.PROTECTED, retClz, CodeConstants.getMethodNameOfRedisMapperMapToField(colName));
        JVar bytes = method.param(cm.ref(byte[].class), "bytes");
        JInvocation invocation = cm.ref(TypeConstantHelper.class).staticInvoke("toObject").arg(bytes).arg(cm.ref(type.gettClass()).dotclass());
        EnumTypeDef enumTypeDef = col.getEnumTypeDef();
        if (enumTypeDef != null) {
            invocation = retClz.staticInvoke(CodeConstants.METHOD_ENUM_FROM_VALUE).arg(invocation);
        }
        method.body()._return(invocation);
        return method;
    }

    private JMethod buildMapObjToField(FieldInfoInterface col) {
        String colName = col.getFieldName();
        FieldDataTypeInterface type = col.getType();
        AbstractJClass retClz = CodeConstants.getFieldDefType(cm, modelDef, col, builderContext);
        if (retClz.isArray() && retClz.equals(cm.ref(byte[].class))) {
            return null;
        }
        JMethod method = definedClass.method(JMod.PROTECTED, retClz,
                CodeConstants.getMethodNameOfRedisMapperMapToField(colName));
        JVar bytes = method.param(cm.ref(Object.class), "obj");
        IJExpression invocation =
                JExpr.cast(cm.ref(type.gettClass()), bytes);
        //cm.ref(TypeConstantHelper.class).staticInvoke("toObject").arg(bytes).arg(cm.ref(type.gettClass()).dotclass());
        EnumTypeDef enumTypeDef = col.getEnumTypeDef();
        if (enumTypeDef != null) {
            invocation = retClz.staticInvoke(CodeConstants.METHOD_ENUM_FROM_VALUE).arg(invocation);
        }
        method.body()._return(invocation);
        return method;
    }

    private JMethod buildMapFieldToBin(FieldInfoInterface col) {
        String colName = col.getFieldName();
        FieldDataTypeInterface type = col.getType();
        JMethod method = definedClass.method(JMod.PROTECTED, cm.ref(byte[].class), CodeConstants.getMethodNameOfRedisMapperMapFromField(colName));
        JVar field = method.param(CodeConstants.getFieldDefType(cm, modelDef, col, builderContext), "field");
        JBlock body = method.body();
        JInvocation invocation;
        EnumTypeDef enumTypeDef = col.getEnumTypeDef();
        invocation = cm.ref(TypeConstantHelper.class).staticInvoke("fromObjectBin").arg(enumTypeDef == null ? field : field.ref(CodeConstants.FIELD_ENUM_VAL_FIELD));
        JVar decl = body.decl(method.type(), "ret", invocation);
        body._return(decl);
        return method;
    }
}
