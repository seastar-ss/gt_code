package com.shawn.ss.lib.tools.db.api.interfaces.db_operation.factory;

import javax.sql.DataSource;
import java.util.Properties;

public interface Config {

    enum LibType {
        mybitas(""), springJdbcTemplate("com.shawn.ss.lib.tools.data_store.impl.DbHelperFactorySpringImpl");
        private final String factoryClassName;

        LibType(String factoryClassName) {
            this.factoryClassName = factoryClassName;
        }

        public String getFactoryClassName() {
            return factoryClassName;
        }
    }

    LibType getType();

    boolean isDebug();

    DataSource getDataSource();

    Properties getProperties();

}
