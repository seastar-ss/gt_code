package com.shawn.ss.gen.api.interfaces;

import com.shawn.ss.gen.api.conf.SelectMethodEnum;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by ss on 2018/9/1.
 */

@Retention(RetentionPolicy.CLASS)
@Target({ElementType.TYPE,ElementType.PACKAGE})
public @interface SqlMultipleConf {
    String fieldName();
    String tableName();
    String dbName();
    SelectMethodEnum[] methodTypes();
    String daoClazzName();
    String dtoClazzName();
    SqlMultipleRelatedResp[] relatedResp();
//    boolean isList();
//    String[] condition();
}
