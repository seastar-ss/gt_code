package com.shawn.ss.gen.api.interfaces.mutli_resp;

import com.shawn.ss.gen.api.interfaces.SqlMultipleConf;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by ss on 2018/9/1.
 */

@Retention(RetentionPolicy.CLASS)
@Target({ElementType.TYPE,ElementType.PACKAGE})
public @interface SqlMultipleExtResp {

    SqlMultipleInterfaceConf[] confs();
//    boolean isList();
//    String[] condition();
}
