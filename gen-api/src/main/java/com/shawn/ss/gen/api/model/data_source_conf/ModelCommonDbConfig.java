package com.shawn.ss.gen.api.model.data_source_conf;

public class ModelCommonDbConfig {
    long timeout;
    long idleTimeout;
    long maxLifetime;
    String connectionTestQuery;
    int maximumPoolSize;
    String dataSouceClassName;

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

    public String getDataSouceClassName() {
        return dataSouceClassName;
    }

    public void setDataSouceClassName(String dataSouceClassName) {
        this.dataSouceClassName = dataSouceClassName;
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
