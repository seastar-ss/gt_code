package com.shawn.ss.lib.code_gen.model.def_model.interfaces;

import com.shawn.ss.lib.code_gen.base.helper.ModelBuilderContext;

/**
 * Created by ss on 2018/2/13.
 */
public interface _BaseContextConf {
    ModelBuilderContext getBuilderContext();
    String getName();
    _BaseConstantDef getConstant();
}
