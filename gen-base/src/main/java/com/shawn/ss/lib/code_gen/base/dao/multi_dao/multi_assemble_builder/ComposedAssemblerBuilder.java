package com.shawn.ss.lib.code_gen.base.dao.multi_dao.multi_assemble_builder;

import com.helger.jcodemodel.*;
import com.shawn.ss.lib.code_gen.CodeBuilderInterface;
import com.shawn.ss.lib.code_gen.base.helper.CodeConstants;
import com.shawn.ss.lib.code_gen.base.helper.ModelBuilderContext;
//import com.shawn.ss.lib.code_gen.model.def_model.interfaces._BaseDaoCombineConf;
import com.shawn.ss.lib.code_gen.model.def_model.interfaces._BaseDaoConf;
//import com.shawn.ss.lib.code_gen.model.def_model.interfaces._BaseSubDaoConf;
import com.shawn.ss.lib.code_gen.model.def_model.interfaces._BaseRelationDef;
import com.shawn.ss.lib.tools.CodeStyleTransformHelper;
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
        if (modelMulDaoConf.getDeclaredAssembler() != null) {
            return;
        }
        try {
            definedClass = cm._class(JMod.PUBLIC + JMod.ABSTRACT, assemblerName);
            definedClass._extends(cm.ref(AbstractMultipleDaoAssembler.class));
            JFieldVar ret = definedClass.field(JMod.PROTECTED, wrapperCls, "ret");
            CodeConstants.buildGetterAndSetter(definedClass, "ret", wrapperCls, ret);
            AbstractJClass wrapperListCls = CodeConstants.buildNarrowedClass(cm, List.class, wrapperCls);
            JFieldVar rets = definedClass.field(JMod.PROTECTED, wrapperListCls, "rets", cm.ref(CollectionHelper.class).staticInvoke("newList"));
            CodeConstants.buildGetterAndSetter(definedClass, "rets", wrapperListCls, rets);
            buildClearMethod();
            buildMainLogic();
            modelMulDaoConf.setDeclaredAssembler(definedClass);
        } catch (JClassAlreadyExistsException e) {
            e.printStackTrace();
        }
    }

    private void buildMainLogic() {

        String mainFieldName = mainField.getFieldName();
        //        JMethod assembleMain = definedClass.method(JMod.PROTECTED, cm.INT, CodeConstants.getMethodNameOfMultiDaoAssemble(mainFieldName));

        //        List<JVar> jVars = addAssembleParam(method, true);
        //        addAssembleParam(assembleMain, true);
        //        assembleMain.body()._return(JExpr.lit(0));

        List<_BaseDaoConf> relatedTables = modelMulDaoConf.getRelation();

        /**
         * 构建round index
         */
        staticRoundFieldVar = new JFieldVar[relatedTables.size()];
        List<JVar> jVars = CollectionHelper.newList();
        //        int findex = 0;
        //        staticRoundFieldVar[findex] = definedClass.field(
        //                CodeConstants.MODE_PUBLIC_STATIC_FINAL, cm.INT,
        //                CodeConstants.getFieldNameOfMulDaoRNDName(mainFieldName),
        //                JExpr.lit(findex)
        //        );
        //        JBlock jBlock = body._if(JExpr.invoke(CodeConstants.METHOD_ASSEMBLER_GET_INDEX).eq(staticRoundFieldVar[0]))._then();
        //        jBlock._return(CodeConstants.invokeMethodWithParam(assembleMain, jVars));
        for (int findex = 0, n = relatedTables.size(); findex < n; ++findex) {
            _BaseDaoConf def = relatedTables.get(findex);
            _BaseRelationDef relatedDef = def.getRelatedDef(modelMulDaoConf.getName());
            String fieldName = relatedDef.getFieldName();
            JFieldVar fieldVar = definedClass.field(
                    CodeConstants.MODE_PUBLIC_STATIC_FINAL,
                    cm.INT,
                    CodeConstants.getFieldNameOfMulDaoRNDName(fieldName),
                    JExpr.lit(findex)
            );
            staticRoundFieldVar[findex] = fieldVar;
            //            ++findex;
        }
        /**
         * 构建assembleSql方法
         */
        JMethod method = definedClass.method(JMod.PUBLIC, cm.INT, CodeConstants.LIB_SQL_ASSEMBLE_SQL);
        addAssembleParam(method, true);
        JBlock body = method.body();
        //        findex = 0;
        //        JBlock jBlock = null;
        for (int findex = 0, n = relatedTables.size(); findex < n; ++findex) {
            _BaseDaoConf def = relatedTables.get(findex);
            _BaseRelationDef relatedDef = def.getRelatedDef(modelMulDaoConf.getName());
            String fieldName = relatedDef.getFieldName();
            //String s = CodeStyleTransformHelper.humpStyleToUnderlineSplittedStyle(fieldName).toUpperCase();
            //            JFieldVar fieldVar = definedClass.field(
            //                    CodeConstants.MODE_PUBLIC_STATIC_FINAL,
            //                    cm.INT,
            //                    CodeConstants.getFieldNameOfMulDaoRNDName(fieldName),
            //                    JExpr.lit(findex)
            //            );
            //            staticRoundFieldVar[findex] = fieldVar;
            if (def.getDaoType() == _BaseDaoConf.EnumFieldDataSrcType.commonDao) {
                JMethod subMethod = buildSubAssembleMethod(jVars, fieldName);
                //            String fieldVarName = CodeConstants.getFieldNameOfMulDaoRNDName(fieldName);
                JBlock jBlock = body._if(JExpr.invoke(CodeConstants.METHOD_ASSEMBLER_GET_INDEX).eq(staticRoundFieldVar[findex]))._then();
                jBlock._return(CodeConstants.invokeMethodWithParam(subMethod, jVars));
                jVars.clear();
            }
            //            ++findex;
        }
        body._return(JExpr.lit(1));
        /**
         * 构建muldao assembler 组合逻辑
         */
        //        findex = 0;
        for (int findex = 0, n = relatedTables.size(); findex < n; ++findex) {
            _BaseDaoConf def = relatedTables.get(findex);
            _BaseRelationDef relatedDef = def.getRelatedDef(modelMulDaoConf.getName());
            buildRegisterAssemblerMethod(def, relatedDef, staticRoundFieldVar[findex]);
            buildGetAssemblerMethod(def, relatedDef, staticRoundFieldVar[findex]);
            //            ++findex;
        }
    }

    private void buildRegisterAssemblerMethod(_BaseDaoConf def, _BaseRelationDef relatedDef, JFieldVar jFieldVar) {
        String name = relatedDef.getFieldName();
        AbstractJClass assemblerClz = CodeConstants.getAssemblerClzByConf(cm,def);
        JMethod method = definedClass.method(
                JMod.PUBLIC + JMod.FINAL,
                void.class,
                CodeConstants.METHOD_ASSEMBLER_REGISTER_ASSEMBLER_PREFIX + CodeStyleTransformHelper.upperFirstCase(name)
        );
        JVar assembler = method.param(assemblerClz, "assembler");
        method.body().invoke(JExpr._super(), CodeConstants.METHOD_ASSEMBLER_REGISTER_ASSEMBLER_PREFIX).arg(jFieldVar).arg(assembler);
    }

    private void buildGetAssemblerMethod(_BaseDaoConf def, _BaseRelationDef relatedDef, JFieldVar jFieldVar) {
        String name = relatedDef.getFieldName();
        AbstractJClass assemblerClz = CodeConstants.getAssemblerClzByConf(cm,def);
        JMethod method = definedClass.method(
                JMod.PUBLIC + JMod.FINAL,
                assemblerClz,
                CodeConstants.getAssemblerInstanceMethodName(name)
        );
        JInvocation arg = JExpr.invoke(JExpr._super(), CodeConstants.METHOD_ASSEMBLER_OBTAIN_ASSEMBLER_PREFIX).arg(jFieldVar);
        JBlock body = method.body();
        if (def.getAssemblerClzName() != null)
            body._return(JExpr.cast(assemblerClz, arg));
        else
            body._return(arg);
    }

    private JMethod buildSubAssembleMethod(List<JVar> jVars, String fieldName) {
        JMethod subMethod = definedClass.method(JMod.PROTECTED, cm.INT, CodeConstants.getMethodNameOfMultiDaoAssemble(fieldName));
        jVars.addAll(addAssembleParam(subMethod, false));
        subMethod.body()._return(JExpr.lit(0));
        return subMethod;
    }

    private void buildClearMethod() {
        JMethod clearData = definedClass.method(JMod.PUBLIC, cm.VOID, CodeConstants.METHOD_ASSEMBLER_CLEAR_DATA);
        JBlock body = clearData.body();
        body.assign(JExpr.ref("ret"), JExpr._null());
        body.invoke(JExpr.ref("rets"), "clear");
        body.invoke(JExpr._super(), CodeConstants.METHOD_ASSEMBLER_CLEAR_DATA);
    }

    private List<JVar> addAssembleParam(JMethod method, boolean main) {
        //        List<JFieldVar> allVars= CollectionHelper.newList(3);
        JVar sqlVar = method.param(cm.ref(SQL.class), "sql");
        JVar paramVar = method.param(CodeConstants.buildNarrowedClass(cm, Map.class, String.class, Object.class), "param");
        JVar tClassVar = method.param(
                CodeConstants.buildNarrowedClass(cm, Class.class, cm.ref(AbstractBaseModel.class).wildcard(EWildcardBoundMode.EXTENDS)),
                "tClass"
        );

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
