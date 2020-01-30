package com.shawn.ss.lib.code_gen.base.dao.dao_constants;

import com.helger.jcodemodel.JClassAlreadyExistsException;
import com.helger.jcodemodel.JCodeModel;
import com.helger.jcodemodel.JDefinedClass;
import com.shawn.ss.gen.Constants;
import com.shawn.ss.lib.code_gen.CodeBuilderInterface;
import com.shawn.ss.lib.code_gen.base.helper.CodeConstants;
import com.shawn.ss.lib.code_gen.base.helper.ModelBuilderContext;
import com.shawn.ss.lib.code_gen.model.def_model.interfaces._BaseConstantDef;
import com.shawn.ss.lib.code_gen.model.def_model.interfaces._BaseContextConf;
import com.shawn.ss.lib.code_gen.model.def_model.interfaces._BaseDataSourceConf;
import com.shawn.ss.lib.code_gen.model.def_model.interfaces._BaseDataSourceDef;

import java.util.List;

//import com.shawn.ss.lib.code_gen.model.def_model.interfaces._BaseConstantConf;

public class DaoConstantsBuilder implements CodeBuilderInterface {

    private final _BaseDataSourceConf conf;
    private final ModelBuilderContext builderContext;
    private final JCodeModel cm;
    private final JDefinedClass constantClz;

    public DaoConstantsBuilder(_BaseDataSourceConf conf) {
        this.conf = conf;
        builderContext = conf.getBuilderContext();
        cm = builderContext.getCm();
        _BaseConstantDef constant = conf.getConstant();
        constantClz = constant.getConstantClz();

    }

    @Override
    public void buildModel() {
        List<_BaseDataSourceDef> defs = conf.getDef();
        for(_BaseDataSourceDef def:defs){
            
        }
        try {

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
