package com.shawn.ss.lib.code_gen.base.dao.common_dao.common_model_builder;

import com.helger.jcodemodel.*;
import com.shawn.ss.lib.code_gen.CodeBuilderInterface;
import com.shawn.ss.lib.code_gen.base.helper.CodeConstants;
import com.shawn.ss.lib.code_gen.base.helper.ModelBuilderContext;

import com.shawn.ss.lib.code_gen.model.def_model.interfaces._BaseConstantDef;
import com.shawn.ss.lib.code_gen.model.def_model.interfaces._BaseDaoConf;
import com.shawn.ss.lib.tools.NumberHelper;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.ColumnInfoInterface;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model.FieldDataTypeInterface;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model.EnumTypeDef;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model.ColumnDataType;
import com.shawn.ss.lib.tools.db.api.interfaces.mappers.db.DbResultSetMapper;
import com.shawn.ss.lib.tools.db.impl.mapper.BaseDbMapper;

import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

public class MapperOfResultSetBuilder implements CodeBuilderInterface {
//    final ModelBuilder parentBuilder;
    final JCodeModel cm;
    final String mapperClassName;
    JDefinedClass definedClass;
    AbstractJClass modelClass;
    AbstractJType modelType;
    private JTypeVar typeVar;
//    private final boolean selectModel;
    private final Set<String> ignoreField;
    private final String baseTable;
    private final ModelBuilderContext builderContext;
    private final _BaseDaoConf model;

    public MapperOfResultSetBuilder(_BaseDaoConf model) {
//        this.parentBuilder = parentBuilder;
        this.model=model;
        this.builderContext = model.getBuilderContext();
        cm = builderContext.getCm();
        String modelClassName = model.getPojoClzName();
        mapperClassName= model.getMapperClzName();
//        selectModel = parentBuilder.isSelectModel();
        this.ignoreField= model.getIgnoreField();
//        this.ignoreField = (ignoreField==null? Collections.emptySet():ignoreField);
        baseTable = model.getBaseTable();
        modelClass =cm.ref(modelClassName);
    }


    @Override
    public void buildModel() {
        try {

//            modelType = cm.directClass("T");
            this.definedClass = cm._class(mapperClassName);
            typeVar = definedClass.generify("T", modelClass);
            JNarrowedClass interfaceClass = cm.ref(DbResultSetMapper.class).narrow(typeVar);
            definedClass._implements(interfaceClass);
            AbstractJClass ref=null;
            if(baseTable==null) {
                ref = cm.ref(BaseDbMapper.class);
            }else {
                ref =cm.ref(builderContext.getRSMapperClassName(baseTable));
            }
            JNarrowedClass baseClass = ref.narrow(typeVar);
            definedClass._extends(baseClass);

            buildMapRowMethodWithoutInstanceParam();
            buildMapRowMethod();
            buildNewInstance();
        } catch (JClassAlreadyExistsException e) {
            e.printStackTrace();
        }
    }

    private void buildNewInstance() {
        _BaseConstantDef constant = model.getConstant();

        constant.getConstantClz().field(
                CodeConstants.MODE_PUBLIC_STATIC_FINAL,
                definedClass.narrow(modelClass),
                CodeConstants.getFieldNameOfDbRsMapperForModel(model.getName()),
                JExpr._new(definedClass).narrow(modelClass)
        );
    }

    private void buildMapRowMethod() {
        List<ColumnInfoInterface> columns = model.getTableDef().getColumns();
        JMethod mapperRowSimple = definedClass.method(JMod.PUBLIC, typeVar, CodeConstants.METHOD_MAPPER_MAP_ROW);
        mapperRowSimple.annotate(Override.class);
        mapperRowSimple._throws(SQLException.class);
        JVar instance=mapperRowSimple.param(typeVar, "instance");
        JVar rs = mapperRowSimple.param(ResultSet.class, "rs");
        JVar rowNum = mapperRowSimple.param(int.class, "rowNum");
        JVar columnNames = mapperRowSimple.param(cm.ref(Set.class).narrow(String.class), "columnNames");
        JBlock body = mapperRowSimple.body();
        if(baseTable!=null){
            body.invoke(JExpr._super(), CodeConstants.METHOD_MAPPER_MAP_ROW).arg(instance).arg(rs).arg(rowNum).arg(columnNames);
        }
        for(ColumnInfoInterface column:columns){
            if(!ignoreField.contains(column.getFieldName())) {
                buildFields(column, instance, rs, rowNum, columnNames, body);
            }
        }
        body.invoke(instance,"setIndex").arg(rowNum);
        body._return(instance);
    }

    private void buildMapRowMethodWithoutInstanceParam() {
        JMethod mapperRowSimple = definedClass.method(JMod.PUBLIC, typeVar, CodeConstants.METHOD_MAPPER_MAP_ROW);
        mapperRowSimple._throws(SQLException.class);
        mapperRowSimple.annotate(Override.class);
        JVar rs = mapperRowSimple.param(ResultSet.class, "rs");
        JVar rowNum = mapperRowSimple.param(int.class, "rowNum");
        JVar columnNames = mapperRowSimple.param(cm.ref(Set.class).narrow(String.class), "columnNames");
        JBlock body = mapperRowSimple.body();
        JMethod buildInstanceMethod = definedClass.method(JMod.PROTECTED, typeVar, "buildInstance");
        buildInstanceMethod.body()._return(JExpr.cast(typeVar,JExpr._new(modelClass)));
        JVar instance = body.decl(typeVar, "instance", JExpr.invoke(buildInstanceMethod));
        body._return(JExpr.invoke(CodeConstants.METHOD_MAPPER_MAP_ROW).arg(instance).arg(rs).arg(rowNum).arg(columnNames));
    }

    private void buildFields(ColumnInfoInterface item, JVar instance, JVar rs, JVar rowNum, JVar columnNames, JBlock body) {
        String colName = item.getFieldName();
//        String comment = item.getComment();
//        FieldDataTypeInterface type = item.getType();
        JMethod mapFieldMethod = definedClass.method(JMod.PROTECTED, void.class,
                CodeConstants.getMethodNameOfResultSetMapField(colName));
        mapFieldMethod._throws(SQLException.class);
        JVar mRs = mapFieldMethod.param(ResultSet.class, "rs");
        JVar mCols = mapFieldMethod.param(cm.ref(Set.class).narrow(String.class), "columnNames");
        JVar mInst = mapFieldMethod.param(typeVar, "instance");
        JBlock mBody = mapFieldMethod.body();
        JFieldRef colRef = CodeConstants.getBaseModelColumnStaticRef(modelClass,colName);
        JConditional conditional = mBody._if(mCols.invoke(CodeConstants.LIB_METHOD_SET_CONTAINS).arg(colRef));
        JBlock thenBlock = conditional._then();
        buildDbObtain(rs,item,colRef,thenBlock,colName,instance);
        body.invoke(mapFieldMethod).arg(rs).arg(columnNames).arg(instance);

    }

    private void buildDbObtain(JVar rs, ColumnInfoInterface item, JFieldRef colRef, JBlock thenBlock, String colName, JVar instance) {
        JInvocation arg;
        FieldDataTypeInterface type = item.getType();
        String obtainMethod = type.getObtainMethod();
        if(obtainMethod.equals(ColumnDataType.SPECIAL_BLOB_METHOD)){
            JVar blob = thenBlock.decl(cm.ref(Blob.class), "blob", JExpr.invoke(rs, obtainMethod).arg(colRef));
            arg = JExpr.invoke(blob, "getBytes").arg(0).arg(cm.ref(NumberHelper.class).staticInvoke("longToInt").arg(JExpr.invoke(blob, "length")));
        }else {
            arg = JExpr.invoke(rs, obtainMethod).arg(colRef);
        }
        EnumTypeDef typeDef = item.getEnumTypeDef();
        if(typeDef !=null){
            arg= CodeConstants.getFieldDefType(cm, model, item,builderContext).staticInvoke(CodeConstants.METHOD_ENUM_FROM_VALUE).arg(arg);
        }
        thenBlock.invoke(instance, CodeConstants.getMethodNameOfModelSet(colName)).arg(arg);


    }


}
