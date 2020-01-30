package com.shawn.ss.lib.code_gen.model.def_model.dao_def;

import com.shawn.ss.lib.code_gen.base.helper.CodeConstants;
import com.shawn.ss.lib.code_gen.base.helper.ModelBuilderContext;
import com.shawn.ss.lib.code_gen.model.def_model._base.AbstractConf;
import com.shawn.ss.lib.code_gen.model.def_model.interfaces._BaseEnumTypeConf;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model.EnumTypeDef;

/**
 * Created by ss on 2016/4/20.
 */
public class EnumTypeConf extends AbstractConf implements _BaseEnumTypeConf {
    final EnumTypeDef def;
    protected transient ModelBuilderContext builderContext;
    String name;
    String clzName;

    public EnumTypeConf(EnumTypeDef def,ModelBuilderContext context) {
        super(CodeConstants.getConfNameOfEnum(def),context);
        this.def = def;
    }

    @Override
    public EnumTypeDef getDef() {
        return def;
    }

    @Override
    public String getEnumClzName() {
        return clzName;
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

//    public EnumTypeConf setBuilderContext(ModelBuilderContext builderContext) {
//        this.builderContext = builderContext;
//        return this;
//    }
}
