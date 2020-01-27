package com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao;

public interface ShadingPolicy {
    String getTableName(String selectedDs,String baseDb,String baseTable, String sql);

    String getDbName(String selectedDs,String baseDb,String baseTable, String sql);

    String getDataSourceName(String selectedDs,String baseDb,String baseTable, String sql);
}
