package com.shawn.ss.lib.code_gen;

import com.shawn.ss.lib.code_gen.base.helper.DBConnectionHelper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

public class Configuration {
    public static final String CLASS_PATH_PREFIX = "classpath:";
    String configPos = "conf.properties";
    private Properties p;
    private static volatile Configuration instance;
    DBConnectionHelper conn;

    public static Configuration buildConfiguration(String configPos) {
        if (instance == null) {
            synchronized (Configuration.class) {
                if (instance == null)
                    instance = new Configuration(configPos);
            }
        }
        return instance;
    }

    private Configuration(String configPos) {
        try {
            setConfigPos(configPos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void init() throws IOException {
        p=new Properties();
        if (configPos.startsWith(CLASS_PATH_PREFIX)) {
            configPos = configPos.replace(CLASS_PATH_PREFIX, "");
            InputStream stream = Configuration.class.getResourceAsStream(configPos);
            p.load(stream);
        } else {
            p.load(new FileReader(new File(configPos)));
        }
        conn = new DBConnectionHelper(p);
    }

    public String getConfigPos() {
        return configPos;
    }

    public synchronized void setConfigPos(String configPos) throws IOException {
        this.configPos = configPos;
        init();
    }

    public String getProperty(String key) {
        return p.getProperty(key);
    }

    public NamedParameterJdbcTemplate getJdbcTemplate() {
        return conn.getJdbcTemplate();
    }

    public Connection getConnection() {
        return conn.getConnection();
    }
}
