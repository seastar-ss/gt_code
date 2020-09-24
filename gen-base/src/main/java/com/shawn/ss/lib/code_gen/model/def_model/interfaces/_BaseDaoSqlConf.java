package com.shawn.ss.lib.code_gen.model.def_model.interfaces;

import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.FieldInfoInterface;

import java.util.List;

public interface _BaseDaoSqlConf extends _BaseDaoConf {
    public static enum DataAttrType {
        SINGLE, OBJ, LIST, LIST_OBJ
    }

    String getSql();

    List<FieldInfoInterface> getParams();

    DataAttrType getSqlType();

}
