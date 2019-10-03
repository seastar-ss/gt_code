package com.shawn.ss.lib.tools.service_assemble.api.bak.api;

/**
 * Created by ss on 2017/10/15.
 */
public class SQLBuilderException extends RuntimeException {
    public SQLBuilderException(String message) {
        super(message);
    }

    public SQLBuilderException(String message, Throwable cause) {
        super(message, cause);
    }

    public SQLBuilderException(Throwable cause) {
        super(cause);
    }

    public static SQLBuilderException newNotImplementException(){
        return new SQLBuilderException("此功能尚未实现");
    }

    public static SQLBuilderException unsupportException(){
        return new SQLBuilderException("无法支持此功能");
    }

    public static SQLBuilderException newIllegalBuildPartException(){
        return new SQLBuilderException("此类SQL语句无此部分子句");
    }

    public static SQLBuilderException newIllegalBuildParamException(){
        return new SQLBuilderException("构建参数错误");
    }
}
