package com.shawn.ss.gen.api.interfaces.doc;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by ss on 2018/7/8.
 */

@Retention(RetentionPolicy.CLASS)
@Target({ElementType.METHOD,ElementType.TYPE,ElementType.PACKAGE})
public @interface EntryScriptSupport {
    String key() default "";
    boolean ignore() default false;
    boolean buildDoc() default true;
    boolean scriptable() default false;
}
