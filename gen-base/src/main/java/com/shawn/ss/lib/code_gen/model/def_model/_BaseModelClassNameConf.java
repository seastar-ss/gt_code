package com.shawn.ss.lib.code_gen.model.def_model;

public interface _BaseModelClassNameConf<T extends _BaseModelClassNameConf> extends _BaseContextConf {
    String getPojoClzName();

    T setPojoClzName(String pojoClzName);

    String getPojoExtendsClzName();

    T setPojoExtendsClzName(String pojoExtendsClzName);
}
