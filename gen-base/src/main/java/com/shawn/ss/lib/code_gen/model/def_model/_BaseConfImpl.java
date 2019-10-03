package com.shawn.ss.lib.code_gen.model.def_model;

import com.shawn.ss.lib.code_gen.base.helper.ModelBuilderContext;

/**
 * Created by ss on 2018/3/3.
 */
public abstract class _BaseConfImpl {
    protected transient ModelBuilderContext builderContext;

    public ModelBuilderContext getBuilderContext() {
        return builderContext;
    }

    public _BaseConfImpl setBuilderContext(ModelBuilderContext builderContext) {
        this.builderContext = builderContext;
        return this;
    }
}
