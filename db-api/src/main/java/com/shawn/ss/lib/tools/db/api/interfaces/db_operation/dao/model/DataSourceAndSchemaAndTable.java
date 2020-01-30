package com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model;

public class DataSourceAndSchemaAndTable {
    String dataSourceName;
    String dbName;
    String tableName;

    public DataSourceAndSchemaAndTable() {
    }

    public DataSourceAndSchemaAndTable(String dataSourceName, String dbName, String tableName) {
        this.dataSourceName = dataSourceName;
        this.dbName = dbName;
        this.tableName = tableName;
    }

    public String getDataSourceName() {
        return dataSourceName;
    }

    public DataSourceAndSchemaAndTable setDataSourceName(String dataSourceName) {
        this.dataSourceName = dataSourceName;
        return this;
    }

    public String getDbName() {
        return dbName;
    }

    public DataSourceAndSchemaAndTable setDbName(String dbName) {
        this.dbName = dbName;
        return this;
    }

    public String getTableName() {
        return tableName;
    }

    public DataSourceAndSchemaAndTable setTableName(String tableName) {
        this.tableName = tableName;
        return this;
    }
}
