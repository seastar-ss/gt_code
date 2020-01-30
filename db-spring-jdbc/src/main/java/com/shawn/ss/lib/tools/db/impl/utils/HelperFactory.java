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

import java.util.List;
import java.util.Map;

public class HelperFactory {
    static ResultSetHelper rsHelper=new ResultSetHelperImpl();
//    static TableCreateHelper tbHelper=new TableCreateHelperImpl();

    public static ResultSetHelper getResultSetHeper(){
        return rsHelper;
    }

    public static TableCreateHelper getTbHelper(SimpleDbInterface dbInterface) {
        return new TableCreateHelperImpl(dbInterface);
    }

    private static void dataSourceCommonSetting(ModelDbConfig config,HikariConfig conf) {
        conf.setAutoCommit(true);
        final ModelCommonDbConfig cc = config.getConfig();
        conf.setConnectionTestQuery(cc.getConnectionTestQuery());
        conf.setDataSourceClassName(cc.getDataSouceClassName());
        conf.setIdleTimeout(cc.getIdleTimeout());
        conf.setConnectionTimeout(cc.getTimeout());
        conf.setMaximumPoolSize(cc.getMaximumPoolSize());
        conf.setMaxLifetime(cc.getMaxLifetime());
//        conf.setPoolName(cc.get);
    }

    //    @PostConstruct
    public static void build(ModelDbConfig config) {

//        Gson gson= new GsonBuilder()
//                .setDateFormat(DateTimeHelper.DEFUALT_FORMAT.getFormat())
//                .disableHtmlEscaping().create();
//        config=gson.fromJson(new InputStreamReader(this.getClass().getResourceAsStream("/dbConfig.json")), ModelDbConfig.class);
    }

    public static Map<String,SimpleDbInterface> getDbHandler(ModelDbConfig config){
        Map<String,SimpleDbInterface> ret= CollectionHelper.newMap();
        final List<ModelCommonDbConnectionConfig> dbs = config.getDbs();
        for (ModelCommonDbConnectionConfig db : dbs) {
            String name = db.getName();
            HikariConfig conf = new HikariConfig();
            dataSourceCommonSetting(config,conf);
            conf.setDataSourceProperties(db.toProperties());
            conf.setPoolName(name);
            HikariDataSource dataSource = new HikariDataSource(conf);
//            beanFactory.createBean()
            DbManager dbManager = new DbManager(dataSource);
            AbstractDao.registerDb(name, dbManager);
            ret.put(name,dbManager);
//            final BeanFactory parentBeanFactory = context.getParentBeanFactory();
//            parentBeanFactory
        }
        return ret;
    }
}
