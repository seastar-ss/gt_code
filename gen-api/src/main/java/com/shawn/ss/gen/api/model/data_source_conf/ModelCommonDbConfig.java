package com.shawn.ss.gen.api.model.data_source_conf;

public class ModelCommonDbConfig {
    long timeout = 120000;
    long idleTimeout = 120000;
    long maxLifetime = 12000;
    String connectionTestQuery;
    int maximumPoolSize = Runtime.getRuntime().availableProcessors();
    String dataSourceClassname;
    String diverClassName;

    public String getDiverClassName() {
        return diverClassName;
    }

    public ModelCommonDbConfig setDiverClassName(String diverClassName) {
        this.diverClassName = diverClassName;
        return this;
    }

    public String getConnectionTestQuery() {
        return connectionTestQuery;
    }

    public void setConnectionTestQuery(String connectionTestQuery) {
        this.connectionTestQuery = connectionTestQuery;
//        return this;
    }

    public int getMaximumPoolSize() {
        return maximumPoolSize;
    }

    public void setMaximumPoolSize(int maximumPoolSize) {
        this.maximumPoolSize = maximumPoolSize;
//        return this;
    }

    public String getDataSourceClassname() {
        return dataSourceClassname;
    }

    public void setDataSourceClassname(String dataSourceClassname) {
        this.dataSourceClassname = dataSourceClassname;
//        return this;
    }

    public long getTimeout() {
        return timeout;
    }

    public void setTimeout(long timeout) {
        this.timeout = timeout;
    }

    public long getIdleTimeout() {
        return idleTimeout;
    }

    public void setIdleTimeout(long idleTimeout) {
        this.idleTimeout = idleTimeout;
    }

    public long getMaxLifetime() {
        return maxLifetime;
    }

    public void setMaxLifetime(long maxLifetime) {
        this.maxLifetime = maxLifetime;
//        return this;
    }
}
