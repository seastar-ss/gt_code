package com.shawn.ss.lib.code_gen.model.def_model.dao_def;

import com.shawn.ss.lib.code_gen.base.helper.ModelBuilderContext;
import com.shawn.ss.lib.code_gen.model.def_model._BaseEnumTypeConf;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model.EnumTypeDef;

/**
 * Created by ss on 2016/4/20.
 */
public class EnumTypeConf implements _BaseEnumTypeConf {
    final EnumTypeDef def;
    protected transient ModelBuilderContext builderContext;
    String name;

    public EnumTypeConf(EnumTypeDef def) {

        this.def = def;
    }

    @Override
    public EnumTypeDef getDef() {
        return def;
    }

//    public EnumTypeDef setDef(EnumTypeDef def) {
//
//        this.def = def;
//        return this;
//    }

    public String getName() {
        return name;
    }

    public EnumTypeConf setName(String name) {
        this.name = name;
        return this;
    }

    public ModelBuilderContext getBuilderContext() {
        return builderContext;
    }

//    @Override
//    public String getName() {
//        return null;
//    }

    public EnumTypeConf setBuilderContext(ModelBuilderContext builderContext) {
        this.builderContext = builderContext;
        return this;
    }
}
