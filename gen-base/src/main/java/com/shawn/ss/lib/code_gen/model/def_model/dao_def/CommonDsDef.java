package com.shawn.ss.lib.code_gen.model.def_model.dao_def;

import com.helger.jcodemodel.JDefinedClass;
import com.shawn.ss.lib.code_gen.base.helper.ModelBuilderContext;
import com.shawn.ss.lib.code_gen.model.def_model._base.AbstractConf;
import com.shawn.ss.lib.code_gen.model.def_model._base.ConstantConf;
import com.shawn.ss.lib.code_gen.model.def_model.interfaces._BaseDataSourceDef;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.FieldInfoInterface;

import java.util.Map;

public class CommonDsDef implements _BaseDataSourceDef {

    private final ConstantConf conf;

    protected String configFilePath, configPrefix;

    final String name;

    public CommonDsDef(String name, ConstantConf conf) {
        this.name=name;
        this.conf = conf;
    }

    @Override
    public Map<String, FieldInfoInterface> getStaticFields() {
        return conf.getStaticFields();
    }

    @Override
    public String getConstantClzName() {
        return conf.getConstantClzName();
    }

    public ConstantConf setClzName(String clzName) {
        return conf.setClzName(clzName);
    }

    @Override
    public void setConstantClz(JDefinedClass definedClass) {
        conf.setConstantClz(definedClass);
    }

    @Override
    public JDefinedClass getConstantClz() {
        return conf.getConstantClz();
    }

    @Override
    public String getDataSourceBaseName() {
        return name;
    }

    @Override
    public boolean hasShardingPolicy() {
        return false;
    }

    @Override
    public String getShadingPolicyClzName() {
        return null;
    }

    @Override
    public String getConfigFilePath() {
        return configFilePath;
    }

    public CommonDsDef setConfigFilePath(String configFilePath) {
        this.configFilePath = configFilePath;
        return this;
    }

    @Override
    public String getConfigPrefix() {
        return configPrefix;
    }

    public CommonDsDef setConfigPrefix(String configPrefix) {
        this.configPrefix = configPrefix;
        return this;
    }
}
