package com.shawn.ss.lib.code_gen.base.common;

import com.helger.jcodemodel.JClassAlreadyExistsException;
import com.helger.jcodemodel.JCodeModel;
import com.helger.jcodemodel.JDefinedClass;
import com.shawn.ss.lib.code_gen.CodeBuilderInterface;
import com.shawn.ss.lib.code_gen.base.helper.CodeConstants;
import com.shawn.ss.lib.code_gen.base.helper.ModelBuilderContext;
//import com.shawn.ss.lib.code_gen.model.def_model.interfaces._BaseConstantConf;
import com.shawn.ss.lib.code_gen.model.def_model.interfaces._BaseConstantDef;
import com.shawn.ss.lib.code_gen.model.def_model.interfaces._BaseContextConf;

public class ConstantsBuilder implements CodeBuilderInterface {

    private final _BaseContextConf conf;
    private final ModelBuilderContext builderContext;
    private final JCodeModel cm;

    public ConstantsBuilder(_BaseContextConf conf) {
        this.conf = conf;
        builderContext = conf.getBuilderContext();
        cm = builderContext.getCm();
    }

    @Override
    public void buildModel() {
        _BaseConstantDef constant = conf.getConstant();
        String constantClzName = constant.getConstantClzName();
        try {
            JDefinedClass definedClass = cm._class(constantClzName);
            CodeConstants.buildStaticFieldFromMap(cm,definedClass,constant.getStaticFields());
            constant.setConstantClz(definedClass);
        } catch (JClassAlreadyExistsException e) {
            e.printStackTrace();
        }
    }
}
