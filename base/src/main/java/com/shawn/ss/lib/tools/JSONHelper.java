package com.shawn.ss.lib.tools;

import java.util.Collection;
import java.util.Map;

/**
 * Created by ss on 2017/11/27.
 */
public class JSONHelper  {

    public static <T> T fromJson(String json, Class<T> tClass) {
        return jsonHelper.fromJson(json,tClass);
    }


    public static <T> Collection<T> fromJson(String json, Class<T> tClass, boolean distinct) {
        return jsonHelper.fromJson(json,tClass,distinct);
    }

    public static Map<String,String> mapFromJson(String json){
        return jsonHelper.mapFromJson(json);
    }

    public static String toJson(Object obj) {
        return jsonHelper.toJson(obj);
    }

    public static interface JsonInterface{
        <T> T fromJson(String json,Class<T> tClass);
        <T> Collection<T> fromJson(String json, Class<T> tClass,boolean distinct);
        String toJson(Object obj);
        Map<String,String> mapFromJson(String json);
    }

    static final String JSON_IMPL_CLASS;

    static JsonInterface jsonHelper;
    static {
        String jsonImplClass = System.getProperty("jsonImplClass");
        if(jsonImplClass!=null){
            JSON_IMPL_CLASS=jsonImplClass;
        }else {
            JSON_IMPL_CLASS="com.shawn.ss.lib.tools.GsonJsonHelperImpl";
        }
        try {
            jsonHelper= (JsonInterface) Class.forName(JSON_IMPL_CLASS).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
