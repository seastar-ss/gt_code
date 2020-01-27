package com.shawn.ss.lib.code_gen.model.def_model;

/**
 * Created by ss on 2018/2/13.
 */
public interface _BaseSubDaoConf<T extends _BaseSubDaoConf> extends _BaseDaoConf<T> {

    enum EnumFieldDataSrcType {
        commonDao, specialDao, mulDao
    }

    _BaseRelationDef getRelation();

    EnumFieldDataSrcType getType();

}
