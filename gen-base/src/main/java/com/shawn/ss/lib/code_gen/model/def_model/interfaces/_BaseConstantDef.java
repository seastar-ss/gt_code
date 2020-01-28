package com.shawn.ss.lib.code_gen.model.def_model.interfaces;

import com.helger.jcodemodel.JDefinedClass;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.FieldInfoInterface;

import java.util.Map;

public interface _BaseConstantDef extends _BaseDef  {
    Map<String,FieldInfoInterface> getStaticFields();
    String getConstantClzName();

    void setConstantClz(JDefinedClass definedClass);
    JDefinedClass getConstantClz();
}
