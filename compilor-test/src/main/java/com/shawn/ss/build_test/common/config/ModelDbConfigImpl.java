package com.shawn.ss.build_test.common.config;

import com.shawn.ss.gen.api.model.data_source_conf.ModelDbConfig;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

@ConfigurationProperties(prefix = "db")
@PropertySource("classpath:dbConfig.yml")
public class ModelDbConfigImpl extends ModelDbConfig {

}
