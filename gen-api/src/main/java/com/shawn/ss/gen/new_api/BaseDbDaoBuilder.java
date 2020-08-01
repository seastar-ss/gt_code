package com.shawn.ss.gen.new_api;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.CLASS)
@Target({ElementType.METHOD})
public @interface BaseDbDaoBuilder {

    String db();
    String dataSourceId();
    boolean isSlave() default false;
    String[] exceptedTables() default {};
    String[] includeTables() default {};
    String defaultDaoClass() default "";
    String defaultAssembleClass() default "";
    String daoClassConf() default "";
    String assembleClassConf() default "";
}
