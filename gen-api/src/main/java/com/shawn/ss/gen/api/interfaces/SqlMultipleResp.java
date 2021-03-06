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
public @interface SqlMultipleResp {

    SqlMultipleConf[] confs();
//    boolean isList();
//    String[] condition();
}
