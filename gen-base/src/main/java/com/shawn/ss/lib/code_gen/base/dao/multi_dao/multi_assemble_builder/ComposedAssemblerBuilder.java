package com.shawn.ss.lib.code_gen.base.dao.multi_dao.multi_assemble_builder;

import com.helger.jcodemodel.*;
import com.shawn.ss.lib.code_gen.CodeBuilderInterface;
import com.shawn.ss.lib.code_gen.base.helper.CodeConstants;
import com.shawn.ss.lib.code_gen.base.helper.ModelBuilderContext;
//import com.shawn.ss.lib.code_gen.model.def_model.interfaces._BaseDaoCombineConf;
import com.shawn.ss.lib.code_gen.model.def_model.interfaces._BaseDaoConf;
//import com.shawn.ss.lib.code_gen.model.def_model.interfaces._BaseSubDaoConf;
import com.shawn.ss.lib.tools.CollectionHelper;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.FieldInfoInterface;
import com.shawn.ss.lib.tools.db.dto_base.model.AbstractBaseModel;
import com.shawn.ss.lib.tools.service_assemble.AbstractMultipleDaoAssembler;
import com.shawn.ss.lib.tools.sql_code_gen.api.SQL;

import java.util.List;
import java.util.Map;

/**
 * Created by ss on 2018/2/13.
 */
public class ComposedAssemblerBuilder implements CodeBuilderInterface {

    private final ModelBuilderContext modelBuilderContext;
    private final AbstractJClass wrapperCls;
    //    private AbstractJClass multiAsemmblerClz;

    private final JCodeModel cm;
    private final _BaseDaoConf modelMulDaoConf;
    private String assemblerName;
    private JDefinedClass definedClass;
    boolean isList;
    private JFieldVar[] staticRoundFieldVar;
    private final FieldInfoInterface mainField;

    public ComposedAssemblerBuilder(_BaseDaoConf modelMulDaoConf) {
        this.modelMulDaoConf = modelMulDaoConf;
        this.modelBuilderContext = modelMulDaoConf.getBuilderContext();

        this.cm = modelBuilderContext.getCm();
        assemblerName = modelMulDaoConf.getAssemblerClzName();//modelBuilderContext.getServiceAssemblerClassName(modelMulDaoConf.getTable());
        this.wrapperCls = cm.ref(modelMulDaoConf.getPojoClzName());
        mainField = modelMulDaoConf.getField(0);
        //        isList=modelMulDaoConf.
    }

    @Override
    public void buildModel() {
        try {
            definedClass = cm._class(JMod.PUBLIC + JMod.ABSTRACT, assemblerName);
            definedClass._extends(cm.ref(AbstractMultipleDaoAssembler.class));
            JFieldVar ret = definedClass.field(JMod.PROTECTED, wrapperCls, "ret");
            CodeConstants.buildGetterAndSetter(definedClass, "ret", wrapperCls, ret);
            AbstractJClass wrapperListCls = CodeConstants.buildNarrowedClass(cm, List.class, wrapperCls);
            JFieldVar rets = definedClass.field(JMod.PROTECTED, wrapperListCls, "rets", cm.ref(CollectionHelper.class).staticInvoke("newList"));
            CodeConstants.buildGetterAndSetter(definedClass, "rets", wrapperListCls, rets);
            buildClearMethod();
            buildMainMethod();

        } catch (JClassAlreadyExistsException e) {
            e.printStackTrace();
        }
    }

    private void buildMainMethod() {
        String mainFieldName = mainField.getFieldName();

        JMethod method = definedClass.method(JMod.PUBLIC, cm.INT, CodeConstants.LIB_SQL_ASSEMBLE_SQL);

        JMethod assembleMain = definedClass.method(JMod.PROTECTED, cm.INT, CodeConstants.getMethodNameOfMultiDaoAssemble(mainFieldName));

        List<JVar> jVars = addAssembleParam(method, true);
        addAssembleParam(assembleMain, true);
        assembleMain.body()._return(JExpr.lit(0));
        JBlock body = method.body();

        List<_BaseDaoConf> relatedTables = modelMulDaoConf.getRelation();
        staticRoundFieldVar = new JFieldVar[relatedTables.size()];
        JBlock jBlock = null;
        int findex = 0;
        //        staticRoundFieldVar[findex] = definedClass.field(
        //                CodeConstants.MODE_PUBLIC_STATIC_FINAL, cm.INT,
        //                CodeConstants.getFieldNameOfMulDaoRNDName(mainFieldName),
        //                JExpr.lit(findex)
        //        );
        //        JBlock jBlock = body._if(JExpr.invoke(CodeConstants.METHOD_ASSEMBLER_GET_INDEX).eq(staticRoundFieldVar[0]))._then();
        //        jBlock._return(CodeConstants.invokeMethodWithParam(assembleMain, jVars));
        for (_BaseDaoConf def : relatedTables) {
            String fieldName = def.getRelatedDef(modelMulDaoConf.getName()).getFieldName();
            //String s = CodeStyleTransformHelper.humpStyleToUnderlineSplittedStyle(fieldName).toUpperCase();
            JFieldVar fieldVar = definedClass.field(
                    CodeConstants.MODE_PUBLIC_STATIC_FINAL,
                    cm.INT,
                    CodeConstants.getFieldNameOfMulDaoRNDName(fieldName),
                    JExpr.lit(findex)
            );
            staticRoundFieldVar[findex] = fieldVar;
            JMethod subMethod = definedClass.method(JMod.PROTECTED, cm.INT, CodeConstants.getMethodNameOfMultiDaoAssemble(fieldName));
            addAssembleParam(subMethod, false);
            subMethod.body()._return(JExpr.lit(0));
            String fieldVarName = CodeConstants.getFieldNameOfMulDaoRNDName(fieldName);
            jBlock = body._if(JExpr.invoke(CodeConstants.METHOD_ASSEMBLER_GET_INDEX).eq(fieldVar))._then();
            jBlock._return(CodeConstants.invokeMethodWithParam(subMethod, jVars));
            ++findex;
        }
        body._return(JExpr.lit(1));
    }

    private void buildClearMethod() {
        JMethod clearData = definedClass.method(JMod.PUBLIC, cm.VOID, "clearData");
        JBlock body = clearData.body();
        body.assign(JExpr.ref("ret"), JExpr._null());
        body.invoke(JExpr.ref("rets"), "clear");
    }

    private List<JVar> addAssembleParam(JMethod method, boolean main) {
        //        List<JFieldVar> allVars= CollectionHelper.newList(3);
        JVar sqlVar = method.param(cm.ref(SQL.class), "sql");
        JVar paramVar = method.param(CodeConstants.buildNarrowedClass(cm, Map.class, String.class, Object.class), "param");
        JVar tClassVar = method.param(CodeConstants.buildNarrowedClass(cm, Class.class, cm.ref(AbstractBaseModel.class).wildcard(EWildcardBoundMode.EXTENDS)), "tClass");

        List<JVar> vars = CollectionHelper.<JVar>listBuilder()
                .add(sqlVar)
                .add(paramVar)
                .add(tClassVar)
                .getList();
        if (!main) {
        }
        return vars;
    }

    public JDefinedClass getMultiAsemmblerClz() {
        return definedClass;
    }

    public JFieldVar[] getStaticRoundFieldVar() {
        return staticRoundFieldVar;
    }
}
