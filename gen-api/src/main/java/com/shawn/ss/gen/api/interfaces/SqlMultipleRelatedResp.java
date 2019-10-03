package com.shawn.ss.gen.api.interfaces;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by ss on 2018/9/1.
 */

@Retention(RetentionPolicy.CLASS)
@Target({ElementType.TYPE,ElementType.PACKAGE})
public @interface SqlMultipleRelatedResp {
    String fieldName();
    String tableName();
    String dbName();
    boolean isList();
    boolean isIdInThisTable() default false;
    String condition();
    String relatedMainTableField();
}
