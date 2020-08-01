/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shawn.ss.lib.tools.http;

import java.util.Map;

/**
 *
 * @author ss
 * @param <T>
 */
public abstract class GenericRequest<T> {

    public static final int DEFAULT_TIME_OUT = 30000, DEFAULT_READ_TIME_OUT = 15000;
    public static final String PROTOCOL_CHARSET = "utf-8";

    public static final String PROTOCOL_CONTENT_TYPE = String.format(
            "application/x-www-form-urlencoded; charset=%s", PROTOCOL_CHARSET);
    public static final String USER_AGENT = "app-seastar-api-puller-v1.0";

    public static enum Method {

        GET, POST, PUT, DELETE;
    }

    final Method method;

    NetResponseCode resCode;
    String exceptionMsg;
    protected byte[] result;
    protected String url;

    protected GenericRequest(Method m) {
//        this.url = url;
        this.method = m;
    }

    public Method getMethod() {
        return method;
    }

    public abstract String getUrl() ;

    public int getTimeout() {
        return DEFAULT_TIME_OUT;
    }

    public int getReadTimeout() {
        return DEFAULT_READ_TIME_OUT;
    }

    public String getContentType() {
        return PROTOCOL_CONTENT_TYPE;
    }

    public String getUserAgent() {
        return USER_AGENT;
    }

    public abstract byte[] getBody();

    public Map<String, String> getHeaders() {
        return null;
    }

//    public Map<String, String> getParams();
    public NetResponseCode getStatus() {
        return resCode == null ? NetResponseCode.undefined : resCode;
    }

    public abstract T getResult();

    public String getExceptionMsg() {
        return this.exceptionMsg;
    }

    public void setResult(byte[] re){
        this.result=re;
    }

//    public byte[] getErrResult() {
//        return this.errResult;
//    }
}
