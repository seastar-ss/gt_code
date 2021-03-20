package com.shawn.ss.lib.tools.db.conf_model.datasource.util;

import com.shawn.ss.gen.api.model.data_source_conf.ModelCommonDbConfig;
import com.shawn.ss.gen.api.model.data_source_conf.ModelCommonDbConnectionConfig;
import com.shawn.ss.gen.api.model.data_source_conf.ModelDbConfig;
import com.shawn.ss.lib.tools.CollectionHelper;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.SimpleDbInterface;
import com.shawn.ss.lib.tools.db.impl.DbManager;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class HelperFactory {

    private static final Map<String, DataSource> DATA_SOURCE_MAP = new ConcurrentHashMap<>();
    private static final String KEY_PREFIX_DS_BEAN = "dbBean-";
    private static final String KEY_PREFIX_TM_BEAN = "dbTrBean-";

    private static void dataSourceCommonSetting(ModelDbConfig config, HikariConfig conf) {
        conf.setAutoCommit(true);
        final ModelCommonDbConfig cc = config.getConfig();
        conf.setConnectionTestQuery(cc.getConnectionTestQuery());
        if (cc.getDataSourceClassname() != null)
            conf.setDataSourceClassName(cc.getDataSourceClassname());
        conf.setDriverClassName(cc.getDiverClassName());
        conf.setIdleTimeout(cc.getIdleTimeout());
        conf.setConnectionTimeout(cc.getTimeout());
        conf.setMaximumPoolSize(cc.getMaximumPoolSize());
        conf.setMaxLifetime(cc.getMaxLifetime());
    }

    public static Map<String, DataSource> getDbDataSource(ModelDbConfig config, boolean buildRet) {
        Map<String, DataSource> ret = buildRet ? CollectionHelper.newMap() : Collections.emptyMap();
        final List<ModelCommonDbConnectionConfig> dbs = config.getDbs();
        for (ModelCommonDbConnectionConfig db : dbs) {
            String name = db.getName();
            final DataSource source = DATA_SOURCE_MAP.computeIfAbsent(name, e -> {
                HikariConfig conf = new HikariConfig();
                dataSourceCommonSetting(config, conf);
                conf.setDataSourceProperties(db.toConnectionProperties());
                conf.setPoolName(name);
                if (db.getDiverClassName() != null) {
                    conf.setDriverClassName(db.getDiverClassName());
                }
                conf.setJdbcUrl(db.getUrl());
                HikariDataSource dataSource = new HikariDataSource(conf);
                return dataSource;
            });
            //            DbManager dbManager = new DbManager(dataSource);
            //            DATA_SOURCE_MAP.put( name, dataSource);
            if (buildRet)
                ret.put(KEY_PREFIX_DS_BEAN + name, source);
        }
        return ret;
    }


    public static Map<String, SimpleDbInterface> getDbHandler(ModelDbConfig config) {

        getDbDataSource(config, false);
        final Map<String, SimpleDbInterface> ret = CollectionHelper.newMap(DATA_SOURCE_MAP.size());
        DATA_SOURCE_MAP.forEach((k, v) -> {
            DbManager dbManager = new DbManager(v);
            ret.put(k, dbManager);
        });
        return ret;
    }

    public static Map<String, PlatformTransactionManager> getTransactionManager(ModelDbConfig config) {

        getDbDataSource(config, false);
        final Map<String, PlatformTransactionManager> ret = CollectionHelper.newMap(DATA_SOURCE_MAP.size());
        DATA_SOURCE_MAP.forEach((k, v) -> {
            final DataSourceTransactionManager manager = new DataSourceTransactionManager(v);
            ret.put(KEY_PREFIX_TM_BEAN + k, manager);
        });
        return ret;
    }

    public static Map<String, DataSource> getDataSourceMap() {
        return Collections.unmodifiableMap(DATA_SOURCE_MAP);
    }
}
