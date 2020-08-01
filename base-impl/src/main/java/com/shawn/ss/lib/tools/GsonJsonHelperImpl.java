package com.shawn.ss.lib.tools;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Created by ss on 2017/11/27.
 */
public class GsonJsonHelperImpl implements JSONHelper.JsonInterface {
    static Type type = new TypeToken<Map<String, String>>() {
    }.getType();

    private final static Gson gson;//=new Gson();

    static {
        GsonBuilder builder = new GsonBuilder()
                .setDateFormat(DateTimeHelper.DEFUALT_FORMAT.getFormat())
                .disableHtmlEscaping().excludeFieldsWithModifiers(Modifier.TRANSIENT, Modifier.STATIC);
        gson=builder.create();
    }

    @Override
    public <T> T fromJson(String json, Class<T> tClass) {
        return gson.fromJson(json,tClass);
    }

    @Override
    public <T> Collection<T> fromJson(String json, Class<T> tClass, boolean distinct) {
        TypeToken type = TypeToken.<List<T>>get(tClass);
//        TypeToken realType=TypeToken.get(type);
//        res = gson.fromJson(valuePrev, type);
        return gson.fromJson(json,type.getType());
    }

    @Override
    public String toJson(Object obj) {
        return gson.toJson(obj);
    }

    @Override
    public Map<String, String> mapFromJson(String json) {
        return gson.fromJson(json,type);
    }

    public static Gson getGson() {
        return gson;
    }
}
