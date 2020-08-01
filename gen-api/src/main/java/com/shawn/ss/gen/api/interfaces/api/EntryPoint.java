package com.shawn.ss.gen.api.interfaces.api;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by ss on 2018/7/8.
 */

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.TYPE,ElementType.PACKAGE})
public @interface EntryPoint  {
    /**
     * 备用信息，不关注
     * @return
     */
    String key() default "";

    /**
     * 如设置为true，则标注对象不会被处理
     * @return
     */
    boolean ignore() default false;

    /**
     * 暂无此支持，后期版本可用于定制是否需要递归生成关联元素文档
     * @return
     */
    boolean buildDoc() default true;

    /**
     * 是否可扩展，如将此属性设置为true，则对应方法（或类或包中方法）可使用切面生成可扩展功能
     * @return
     */
    boolean scriptable() default false;

    /**
     * 是否基础API，
     * @return
     */
    boolean foundation() default false;

    /**
     * 保留字段，用于扩展后续需求
     * @return
     */
    String[] config() default {};

    /**
     * 保留字段，暂无用，版本维护使用注释实现
     * @return
     */
    int versionCode() default 20190930;

    /**
     * 保留字段，暂无用，版本维护使用注释实现
     * @return
     */
    String version() default "";

    /**
     * 保留字段，暂无用，依赖维护使用注释实现
     * @return
     */
    String[] dependOnExternalUrl() default {};
    /**
     * 保留字段，暂无用，依赖维护使用注释实现
     * @return
     */
    String[] dependOnDB() default {};

}
