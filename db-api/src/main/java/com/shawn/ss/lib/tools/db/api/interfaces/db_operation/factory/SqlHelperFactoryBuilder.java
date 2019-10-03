package com.shawn.ss.lib.tools.db.api.interfaces.db_operation.factory;

import com.shawn.ss.lib.tools.db.api.exceptions.FactoryBuildException;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.SqlDbHelperInterface;
import com.shawn.ss.lib.tools.db.constants.DbConstant;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

import javax.sql.DataSource;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Properties;

public class SqlHelperFactoryBuilder implements InitializingBean, FactoryBean<SqlDbHelperInterface> {


    private volatile SqlHelperFactory helperFactory;

    public static SqlHelperFactoryBuilder getInstance() {
        return InstanceHolder.instance;
    }

    Config c;

    private SqlHelperFactoryBuilder() {

    }

    public Config getConfig() {
        return c;
    }

    public void setConfig(Config c) {
        this.c = c;
    }

    public SqlHelperFactory buildFactory() {
        Config.LibType type = c.getType();
        boolean debug = c.isDebug();
        DataSource dataSource = c.getDataSource();
        Properties properties = c.getProperties();

        try {
            if(helperFactory==null) {
                synchronized (SqlHelperFactoryBuilder.class) {
                    helperFactory = (SqlHelperFactory) Proxy.newProxyInstance(
                            this.getClass().getClassLoader(),
                            new Class[]{SqlHelperFactory.class},
                            (InvocationHandler) Class.forName(type.getFactoryClassName()).newInstance());

                    helperFactory.setDebug(debug);
                    helperFactory.setDataSource(dataSource);
                    helperFactory.setProperties(properties);
                }
            }
            return helperFactory;
        } catch (InstantiationException e) {
            e.printStackTrace();
            FactoryBuildException.throwNewException("can't build factory", e);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            FactoryBuildException.throwNewException("can't build factory", e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            FactoryBuildException.throwNewException("can't build factory", e);
        }
        return null;
    }

    @Override
    public SqlDbHelperInterface getObject() throws Exception {
        return helperFactory.getHelper();
    }

    @Override
    public Class<?> getObjectType() {
        return SqlDbHelperInterface.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        buildFactory();
    }


    private static class InstanceHolder {
        static SqlHelperFactoryBuilder instance = new SqlHelperFactoryBuilder();
    }

}
