package com.shawn.ss.gen.api.interfaces;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.CLASS)
@Target(ElementType.PACKAGE)
public @interface DefaultRespConf {
    String db();
    String dataSourceId();
    boolean isSlave() default false;
    String[] exceptedTables() default {};
    String[] includeTables() default {};


}
