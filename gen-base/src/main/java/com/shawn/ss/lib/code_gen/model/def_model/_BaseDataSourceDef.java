package com.shawn.ss.lib.code_gen.model.def_model;

//import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.ShadingPolicy;

import java.util.List;

public interface _BaseDataSourceDef extends _BaseDef {
    String getMasterDataSourceName();

    List<String> getSlaveDataSourceName();

    boolean hasShardingPolicy();

    String getShadingPolicyClzName();
}
