package com.shawn.ss.lib.code_gen.model.def_model.interfaces;

import com.helger.jcodemodel.JDefinedClass;

import java.util.List;

/**
 * Created by ss on 2018/2/13.
 */
public interface _BaseDataSourceConf extends _BaseContextConf {
    public static enum SourceAttrType {
        DB, REDIS, FIXED
    }

    List<_BaseDataSourceDef> getDsDef();

    SourceAttrType getDataSourceType();

    JDefinedClass getDataSourceConfigClass();

    void setDataSourceConfigClass(JDefinedClass clz);
}
