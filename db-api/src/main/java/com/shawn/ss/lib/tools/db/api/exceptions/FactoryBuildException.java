package com.shawn.ss.lib.tools.db.api.exceptions;

public class FactoryBuildException extends RuntimeException{
    public FactoryBuildException(String message) {
        super(message);
    }

    public FactoryBuildException(String message, Throwable cause) {
        super(message, cause);
    }

    public FactoryBuildException(Throwable cause) {
        super(cause);
    }

    public static void throwNewException(String msg){
        throw new FactoryBuildException(msg);
    }
    public static void throwNewException(String msg,Throwable cause){
        throw new FactoryBuildException(msg,cause);
    }
}
