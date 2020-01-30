package com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao;

import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model.DataSourceAndSchemaAndTable;

public interface ShadingPolicy {
    DataSourceAndSchemaAndTable getConfig(String selectedDs, String baseDb, String baseTable, String sql);

//    String getDbName(String selectedDs,String baseDb,String baseTable, String sql);
//
//    String getDataSourceName(String selectedDs,String baseDb,String baseTable, String sql);
}
