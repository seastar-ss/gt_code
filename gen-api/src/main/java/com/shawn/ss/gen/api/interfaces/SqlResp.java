package com.shawn.ss.gen.api.interfaces;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Map;

/**
 * Created by ss on 2018/6/15.
 */
@Retention(RetentionPolicy.CLASS)
@Target(ElementType.METHOD)
public @interface SqlResp {
//    String clazzName() default "";
    String methodName() default "";
    String sql();
    String dataSourceId();

//     defaultParam();
}
