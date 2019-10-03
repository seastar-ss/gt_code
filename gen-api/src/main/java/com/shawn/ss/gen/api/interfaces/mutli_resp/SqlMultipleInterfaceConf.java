package com.shawn.ss.gen.api.interfaces.mutli_resp;

import com.shawn.ss.gen.api.conf.SelectMethodEnum;
import com.shawn.ss.gen.api.interfaces.SqlMultipleRelatedResp;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by ss on 2018/9/1.
 */

@Retention(RetentionPolicy.CLASS)
@Target({ElementType.TYPE})
public @interface SqlMultipleInterfaceConf {
    String fieldName();
    String tableName();
    String dbName();
    SelectMethodEnum[] methodType() default {};
    String daoClazzName() default "";
    String dtoClazzName() default "";
    SqlMultipleRelatedConf[] related();

//    boolean isList();
//    String[] condition();
}
