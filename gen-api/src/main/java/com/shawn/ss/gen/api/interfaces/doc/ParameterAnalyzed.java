package com.shawn.ss.gen.api.interfaces.doc;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by ss on 2018/7/8.
 */

@Retention(RetentionPolicy.CLASS)
@Target({ElementType.PARAMETER,ElementType.FIELD})
public @interface ParameterAnalyzed {
    String key();
    boolean ignore() default false;
}
