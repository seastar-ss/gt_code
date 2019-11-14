package com.shawn.ss.lib.code_gen.model.def_model.dao_def;

import com.shawn.ss.lib.code_gen.base.helper.ModelBuilderContext;
import com.shawn.ss.lib.code_gen.model.def_model._BaseDef;

/**
 * Created by ss on 2016/4/20.
 */
public class EnumTypeDef implements _BaseDef {
    final com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model.EnumTypeDef def;
    protected transient ModelBuilderContext builderContext;
    String table;

    public EnumTypeDef(com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model.EnumTypeDef def) {

        this.def = def;
    }

    public com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model.EnumTypeDef getDef() {
        return def;
    }

//    public EnumTypeDef setDef(EnumTypeDef def) {
//
//        this.def = def;
//        return this;
//    }

    public String getTable() {
        return table;
    }

    public EnumTypeDef setTable(String table) {
        this.table = table;
        return this;
    }

    public ModelBuilderContext getBuilderContext() {
        return builderContext;
    }

    public EnumTypeDef setBuilderContext(ModelBuilderContext builderContext) {
        this.builderContext = builderContext;
        return this;
    }
}
