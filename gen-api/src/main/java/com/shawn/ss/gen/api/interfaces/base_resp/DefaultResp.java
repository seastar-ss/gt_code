package com.shawn.ss.gen.api.interfaces.base_resp;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.CLASS)
@Target({ElementType.PACKAGE,ElementType.TYPE})
public @interface DefaultResp {
    DefaultRespConf[] confs() default {} ;
}
