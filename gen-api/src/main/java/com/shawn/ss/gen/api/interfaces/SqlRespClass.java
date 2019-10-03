package com.shawn.ss.gen.api.interfaces;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by ss on 2018/6/17.
 */

@Retention(RetentionPolicy.CLASS)
@Target(ElementType.TYPE)
public @interface SqlRespClass {
    String clazzName() default "";
}
