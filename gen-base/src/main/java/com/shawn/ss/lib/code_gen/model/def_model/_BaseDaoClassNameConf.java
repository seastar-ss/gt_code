package com.shawn.ss.lib.code_gen.model.def_model;

public interface _BaseDaoClassNameConf<T extends _BaseDaoClassNameConf>  extends _BaseContextConf  {
    String getDaoClzName();

    T setDaoClzName(String clzName);

    String getDaoExtendsClzName();

    T setDaoExtendsClzName(String clzName);

    String getAssemblerClzName();

    T setAssemblerClzName(String clzName);

    String getAssemblerExtendClzName();

    T setAssemblerExtendClzName(String clzName);

    String getMapperClzName();

    T setMapperClzName(String clzName);

    String getShadingClzName();

    T setShadingClzName(String clzName);

}
