package com.shawn.ss.lib.tools;

import junit.framework.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.annotation.Target;
import java.util.Date;

import static junit.framework.TestCase.*;

/**
 * Created by ss on 2017/12/16.
 */
public class TypeConstantHelperTest {
    static final Logger L = LoggerFactory.getLogger(TypeConstantHelperTest.class.getSimpleName());
    @Test
    public void testTypeCast(){
        int o=0;
        Object test=o;
        Integer i=(int)test;
    }

    @Test
    public void testPackAndUnpack(){
        Date d=DateTimeHelper.getDate("2017-01-01 12:00:00");
        long a=0xcafebabeL;
        long a2=0xcafebabecafebabeL;
        int b=0xaceb;
        double c=1.234;
        String e="abcdefg我是测试";

        byte[] bytes = TypeConstantHelper.fromObjectBin(d);
        L.info(StringHelper.concat(bytes));
        Date date = TypeConstantHelper.toObject(bytes, Date.class);
        L.info("result:"+d.equals(date));
        assertTrue("",d.equals(date));

        bytes = TypeConstantHelper.fromObjectBin(a);
        L.info(StringHelper.concat(bytes));
        Long l = TypeConstantHelper.toObject(bytes, Long.class);
        L.info("result:"+l.equals(a));
        assertTrue("",l.equals(a));

        bytes = TypeConstantHelper.fromObjectBin(a2);
        L.info(StringHelper.concat(bytes));
        Long l2 = TypeConstantHelper.toObject(bytes, Long.class);
        L.info("result:"+l.equals(a2));
        assertTrue("",l2.equals(a2));

        bytes = TypeConstantHelper.fromObjectBin(b);
        L.info(StringHelper.concat(bytes));
        int i = TypeConstantHelper.toObject(bytes, Integer.class);
        L.info("result:"+(i==b));
        assertTrue("",i==b);


        bytes = TypeConstantHelper.fromObjectBin(c);
        L.info(StringHelper.concat(bytes));
        double db = TypeConstantHelper.toObject(bytes, Double.class);
        L.info("result:"+(db-c));
        assertTrue("",(db-c<=0.001));

        bytes = TypeConstantHelper.fromObjectBin(e);
        L.info(StringHelper.concat(bytes));
        String str = TypeConstantHelper.toObject(bytes, String.class);
        L.info("result:"+str);
        assertTrue("",str.equals(e));
    }

}
