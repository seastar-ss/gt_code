package com.shawn.ss.lib.code_gen.model.def_model._base;

import com.shawn.ss.lib.code_gen.base.helper.ModelBuilderContext;
import com.shawn.ss.lib.code_gen.base.helper.data_store.ConfDataTable;
import com.shawn.ss.lib.code_gen.model.def_model.interfaces._BaseConstantDef;
import com.shawn.ss.lib.code_gen.model.def_model.interfaces._BaseContextConf;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.FieldInfoInterface;

/**
 * Created by ss on 2018/10/27.
 */
public abstract class AbstractConf implements _BaseContextConf {


    protected final String name;

    protected transient final ModelBuilderContext builderContext;

    protected final static ConstantConf constantConf;

    static {
        constantConf = new ConstantConf();
    }

    public static void addGlobalStaticField(FieldInfoInterface info) {
        constantConf.fields.put(info.getFieldName(), info);
    }

    public static void setConstantClzName(String clzName) {
        constantConf.setClzName(clzName);
    }

    protected AbstractConf(String name, ModelBuilderContext builderContext) {
        this.name = name;
        this.builderContext = builderContext;
        init();
    }

    protected final void init() {
        ConfDataTable.put(this.getName(), this);
    }

    @Override
    public _BaseConstantDef getConstant() {
        return constantConf;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public ModelBuilderContext getBuilderContext() {
        return builderContext;
    }

    public static ConstantConf getConstantConf() {
        return constantConf;
    }

    //    public _BaseConstantConf getConstantConf() {
    //        return constantConf;
    //    }
}
