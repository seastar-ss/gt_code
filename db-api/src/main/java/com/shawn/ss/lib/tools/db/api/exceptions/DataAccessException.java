package com.shawn.ss.lib.tools.db.api.exceptions;

public class DataAccessException extends RuntimeException{
    public DataAccessException(String message) {
        super(message);
    }

    public DataAccessException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataAccessException(Throwable cause) {
        super(cause);
    }

    public static void throwNewException(String msg){
        throw new DataAccessException(msg);
    }
    public static void throwNewException(String msg,Throwable cause){
        throw new DataAccessException(msg,cause);
    }
}
