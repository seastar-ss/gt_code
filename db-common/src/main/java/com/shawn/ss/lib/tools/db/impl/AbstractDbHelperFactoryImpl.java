package com.shawn.ss.lib.tools.db.impl;

import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.SqlDbHelperInterface;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.factory.SqlHelperFactory;
import org.springframework.beans.factory.FactoryBean;

import javax.sql.DataSource;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Properties;

public abstract class AbstractDbHelperFactoryImpl implements SqlHelperFactory,InvocationHandler {

    public static final String[] METHODS={"setDebug","getHelper","setDataSource","setProperties"};

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (Object.class.equals(method.getDeclaringClass())) {
            return method.invoke(this, args);
        }else if(isDefaultMethod(method)){
            return method.invoke(proxy,args);
        }else{
            String methodName = method.getName();
            if(methodName.equals(METHODS[0]) && args!=null && args.length==1 && args[0]!=null){
                setDebug(Boolean.parseBoolean(args[0].toString()));
                return null;
            }else if(methodName.equals(METHODS[1])){
                return getHelper();
            }else if(methodName.equals(METHODS[2]) && args!=null && args.length==1 && args[0]!=null && DataSource.class.isInstance(args[0])){
                setDataSource((DataSource) args[0]);
                return null;
            }else if(methodName.equals(METHODS[3]) && args!=null && args.length==1 && args[0]!=null && Properties.class.isInstance(args[0])){
                setProperties((Properties) args[0]);
                return null;
            }
        }
        return method.invoke(this,args);
    }

    /**
     * Backport of java.lang.reflect.Method#isDefault()
     */
    protected boolean isDefaultMethod(Method method) {
        return ((method.getModifiers()
                & (Modifier.ABSTRACT | Modifier.PUBLIC | Modifier.STATIC)) == Modifier.PUBLIC)
                && method.getDeclaringClass().isInterface();
    }

//    @Override
//    public Class<?> getObjectType() {
//        return null;
//    }
//
//    @Override
//    public boolean isSingleton() {
//        return true;
//    }
}
