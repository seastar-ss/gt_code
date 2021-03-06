package com.shawn.ss.build_test.common.config;

import com.shawn.ss.gen.api.model.data_source_conf.ModelDbConfig;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.SimpleDbInterface;
import com.shawn.ss.lib.tools.db.impl.utils.HelperFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.GenericApplicationContext;

import java.util.Map;
import java.util.Set;

/**

 */
@Configuration
@EnableConfigurationProperties(DataSourceConfig.ModelDbConfigImpl.class)
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class})
public class DataSourceConfig {

    @ConfigurationProperties(prefix = "db")
    @PropertySource("classpath:dbConfig.yml")
    public class ModelDbConfigImpl extends ModelDbConfig {

    }

    final ModelDbConfig config;
    final GenericApplicationContext context;
    final ConfigurableListableBeanFactory beanFactory;

    public DataSourceConfig(ModelDbConfigImpl config, GenericApplicationContext context) {
        this.config = config;
        this.context = context;
        beanFactory = context.getBeanFactory();
        init();
    }

    public void init() {
        Map<String, SimpleDbInterface> dbHandlers = HelperFactory.getDbHandler("",config);
        Set<Map.Entry<String, SimpleDbInterface>> entries = dbHandlers.entrySet();
        for(Map.Entry<String, SimpleDbInterface> entry:entries){
            String key = entry.getKey();
            SimpleDbInterface value = entry.getValue();
            beanFactory.registerSingleton(key, value);
        }
    }

    public ModelDbConfig getConfig() {
        return config;
    }

}
