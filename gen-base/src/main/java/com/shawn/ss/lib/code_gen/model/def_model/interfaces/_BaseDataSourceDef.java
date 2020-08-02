package com.shawn.ss.lib.code_gen.model.def_model.interfaces;

//import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.ShadingPolicy;

import com.shawn.ss.gen.api.model.data_source_conf.ModelDbConfig;

import java.util.List;

public interface _BaseDataSourceDef  {
    String getDataSourceBaseName();

//    List<String> getSlaveDataSourceName();

    boolean hasShardingPolicy();

    String getShadingPolicyClzName();

    String getConfigFilePath();

    String getConfigPrefix();

//    ModelDbConfig getConfig();
}
