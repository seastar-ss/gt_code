package com.shawn.ss.gen.api.interfaces;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by ss on 2018/6/15.
 */
@Retention(RetentionPolicy.CLASS)
@Target(ElementType.PARAMETER)
public @interface SqlRespParam {
    String name() default "";
    String defaultValue() default "";
    String[] defaultValues() default {};
    Class type() default Void.class;

//     defaultParam();
}
