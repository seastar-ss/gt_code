package com.shawn.ss.lib.code_gen.model.def_model;

public interface _BaseDaoClassNameConf<T extends _BaseDaoClassNameConf>  extends _BaseContextConf  {
    String getDaoClzName();

    T setDaoClzName(String pojoClzName);

    String getDaoExtendsClzName();

    T setDaoExtendsClzName(String pojoExtendsClzName);

    String getAssemblerClzName();

    T setAssemblerClzName(String pojoClzName);

    String getBaseAssemblerClzName();

    T setBaseAssemblerClzName(String pojoClzName);
}
