package com.shawn.ss.lib.code_gen.model;

import com.helger.jcodemodel.AbstractJClass;

import java.util.List;

/**
 * Created by ss on 2018/2/12.
 */
public class MethodDef {
    String name;
    AbstractJClass returnType;
    List<ParamDef> params;
}
