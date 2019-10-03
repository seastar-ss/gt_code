package com.shawn.ss.lib.code_gen.model.def_model.dao_def;

import com.shawn.ss.lib.code_gen.model.def_model._BaseConf;
import com.shawn.ss.lib.code_gen.model.def_model._BaseConfImpl;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model.EnumTypeDef;

/**
 * Created by ss on 2016/4/20.
 */
public class EnumTypeConf extends _BaseConfImpl implements _BaseConf {
    EnumTypeDef def;
    String table;

    public EnumTypeDef getDef() {
        return def;
    }

    public EnumTypeConf setDef(EnumTypeDef def) {
        this.def = def;
        return this;
    }

    public String getTable() {
        return table;
    }

    public EnumTypeConf setTable(String table) {
        this.table = table;
        return this;
    }
}
