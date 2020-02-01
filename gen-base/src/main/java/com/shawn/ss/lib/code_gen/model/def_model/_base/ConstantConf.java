package com.shawn.ss.lib.code_gen.model.def_model._base;

import com.helger.jcodemodel.JDefinedClass;
import com.shawn.ss.lib.code_gen.model.def_model.interfaces._BaseConstantDef;
import com.shawn.ss.lib.tools.CollectionHelper;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.FieldInfoInterface;

import java.util.Collections;
import java.util.Map;

public class ConstantConf implements _BaseConstantDef {

    JDefinedClass definedClass;
    final Map<String,FieldInfoInterface> fields;
    String clzName;

    ConstantConf() {
        this.fields = CollectionHelper.newMap();
    }

    @Override
    public Map<String, FieldInfoInterface> getStaticFields() {
        return Collections.unmodifiableMap(fields);
    }

    @Override
    public String getConstantClzName() {
        return clzName;
    }

    public ConstantConf setClzName(String clzName) {
        this.clzName = clzName;
        return this;
    }

    @Override
    public void setConstantClz(JDefinedClass definedClass) {
        this.definedClass=definedClass;
    }

    @Override
    public JDefinedClass getConstantClz() {
        return definedClass;
    }
}
