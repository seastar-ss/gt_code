package com.shawn.ss.gen.api.model.data_source_conf;


import java.util.List;


public class ModelDbConfig {
    ModelCommonDbConfig config;
    List<ModelCommonDbConnectionConfig> dbs;

    public ModelCommonDbConfig getConfig() {
        return config;
    }

    public void setConfig(ModelCommonDbConfig config) {
        this.config = config;
//        return this;
    }

    public List<ModelCommonDbConnectionConfig> getDbs() {
        return dbs;
    }

    public void setDbs(List<ModelCommonDbConnectionConfig> dbs) {
        this.dbs = dbs;
//        return this;
    }
}
