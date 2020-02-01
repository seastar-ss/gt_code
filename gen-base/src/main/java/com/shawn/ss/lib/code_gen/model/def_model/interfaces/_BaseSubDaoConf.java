package com.shawn.ss.lib.code_gen.model.def_model.interfaces;

import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.FieldInfoInterface;

/**
 * Created by ss on 2018/2/13.
 */
public interface _BaseSubDaoConf extends _BaseDaoConf {

    enum EnumFieldDataSrcType {
        commonDao, specialDao, mulDao
    }

    _BaseRelationDef getRelation();



    EnumFieldDataSrcType getType();

}
