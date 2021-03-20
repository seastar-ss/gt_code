package com.shawn.ss.lib.tools.db.impl.utils;

import com.shawn.ss.gen.api.model.data_source_conf.ModelCommonDbConfig;
import com.shawn.ss.gen.api.model.data_source_conf.ModelCommonDbConnectionConfig;
import com.shawn.ss.gen.api.model.data_source_conf.ModelDbConfig;
import com.shawn.ss.lib.tools.CollectionHelper;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.SimpleDbInterface;
import com.shawn.ss.lib.tools.db.api.utils.ResultSetHelper;
import com.shawn.ss.lib.tools.db.api.utils.TableCreateHelper;
import com.shawn.ss.lib.tools.db.impl.DbManager;
import com.shawn.ss.lib.tools.db.impl.dao.AbstractDao;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class HelperFactory {
    static ResultSetHelper rsHelper = new ResultSetHelperImpl();
//    static TableCreateHelper tbHelper=new TableCreateHelperImpl();

    public static ResultSetHelper getResultSetHeper() {
        return rsHelper;
    }

    public static TableCreateHelper getTbHelper(SimpleDbInterface dbInterface) {
        return new TableCreateHelperImpl(dbInterface);
    }

    public static void buildDataSourceBean(String beanPrefix, ModelDbConfig config, ConfigurableListableBeanFactory beanFactory) {
        registeBean(beanPrefix, getDbHandler(beanPrefix, config), beanFactory);
    }

    private static void hikariConfigSetting(ModelCommonDbConnectionConfig cc, HikariConfig conf) {
        conf.setAutoCommit(true);
//        final ModelCommonDbConfig cc = config.getConfig();
        final String connectionTestQuery = cc.getConnectionTestQuery();
        if (connectionTestQuery != null)
            conf.setConnectionTestQuery(connectionTestQuery);
        final String dataSourceClassname = cc.getDataSourceClassname();
        if (dataSourceClassname != null)
            conf.setDataSourceClassName(dataSourceClassname);
        final long idleTimeout = cc.getIdleTimeout();
        conf.setIdleTimeout(idleTimeout);
        final long timeout = cc.getTimeout();
        conf.setConnectionTimeout(timeout);
        final int maximumPoolSize = cc.getMaximumPoolSize();
        conf.setMaximumPoolSize(maximumPoolSize);
        final long maxLifetime = cc.getMaxLifetime();
        conf.setMaxLifetime(maxLifetime);

        conf.setPoolName(cc.getName());

        final String diverClassName = cc.getDiverClassName();
        if (diverClassName != null)
            conf.setDriverClassName(diverClassName);
//        conf.setDataSourceProperties(cc.toConnectionProperties());
        conf.setUsername(cc.getUser());
        conf.setJdbcUrl(cc.getUrl());
        conf.setPassword(cc.getPassword());
    }


    private static void mergeCommonConfig(ModelCommonDbConnectionConfig db, ModelDbConfig config) {
        final ModelCommonDbConfig commonDbConfig = config.getConfig();
        if (commonDbConfig != null) {
            final String driverClass = db.getDriverClass();
            final String diverClassName = commonDbConfig.getDiverClassName();
            if (driverClass == null && diverClassName != null) {
                db.setDriverClass(diverClassName);
            }

            final String testQuery = db.getConnectionTestQuery();
            final String cTestQuery = commonDbConfig.getConnectionTestQuery();
            if (testQuery == null && cTestQuery != null) {
                db.setConnectionTestQuery(cTestQuery);
            }

            final String sourceClassname = db.getDataSourceClassname();
            final String cSourceClassname = commonDbConfig.getDataSourceClassname();
            if (sourceClassname == null && cSourceClassname != null) {
                db.setDataSourceClassname(cSourceClassname);
            }

            final long idle = db.getIdleTimeout();
            final long cidle = commonDbConfig.getIdleTimeout();
            if (idle <= 0) {
                db.setIdleTimeout(cidle);
            }

            final int max = db.getMaximumPoolSize();
            final int cmax = commonDbConfig.getMaximumPoolSize();
            if (max <= 0) {
                db.setMaximumPoolSize(cmax);
            }

            final long timeout = db.getTimeout();
            final long ctimeout = commonDbConfig.getTimeout();
            if (timeout <= 0) {
                db.setTimeout(ctimeout);
            }

            final long lifetime = db.getMaxLifetime();
            final long cLifetime = commonDbConfig.getMaxLifetime();
            if (lifetime <= 0) {
                db.setMaxLifetime(cLifetime);
            }

        }
    }

    public static Map<String, SimpleDbInterface> getDbHandler(String baseName, ModelDbConfig config) {
        Map<String, SimpleDbInterface> ret = CollectionHelper.newMap();
        final List<ModelCommonDbConnectionConfig> dbs = config.getDbs();
        for (ModelCommonDbConnectionConfig db : dbs) {
            String name = baseName + db.getName();
            mergeCommonConfig(db, config);
            HikariConfig conf = new HikariConfig();
            hikariConfigSetting(db, conf);

            HikariDataSource dataSource = new HikariDataSource(conf);
            DbManager dbManager = new DbManager(dataSource);
            AbstractDao.registerDb(name, dbManager);
            ret.put(name, dbManager);
        }
        return ret;
    }


    public static void registeBean(String baseName, Map<String, SimpleDbInterface> beans, ConfigurableListableBeanFactory beanFactory) {
        Set<Map.Entry<String, SimpleDbInterface>> entries = beans.entrySet();
        for (Map.Entry<String, SimpleDbInterface> entry : entries) {
            String key = entry.getKey();
            SimpleDbInterface value = entry.getValue();
            beanFactory.registerSingleton(baseName + key, value);
        }
    }
}
