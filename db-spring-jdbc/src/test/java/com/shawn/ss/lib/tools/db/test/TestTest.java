package com.shawn.ss.lib.tools.db.test;

import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.factory.SqlHelperFactory;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.factory.SqlHelperFactoryBuilder;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

public class TestTest {

    static final Logger L = LoggerFactory.getLogger(TestTest.class.getSimpleName());
    @Test
    public void testDeclaringClass(){
        SqlHelperFactory f;
        Method[] methods = SqlHelperFactoryBuilder.class.getMethods();
        for(Method m:methods){
            L.info("method {} is declare in {}",m.getName(),m.getDeclaringClass().getName());
//            L.info("method is default : {}",m.isDefault());
        }
    }
}
