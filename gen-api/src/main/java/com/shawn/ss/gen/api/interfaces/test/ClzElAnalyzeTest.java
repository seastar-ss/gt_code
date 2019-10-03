package com.shawn.ss.gen.api.interfaces.test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by ss on 2018/7/8.
 */

@Retention(RetentionPolicy.CLASS)
@Target({ElementType.PARAMETER,ElementType.TYPE})
public @interface ClzElAnalyzeTest {
}
