package com.shawn.ss.gen.clz_analyze_handlers;

import com.shawn.ss.lib.tools.CollectionHelper;

import java.util.Map;

public class ModelPackageData extends ElementData{

//    String comment;

    Map<String,ModelClzData> clz;

     ModelPackageData(ElRet el) {
        super(el);
        clz=CollectionHelper.newMap();
//        this.comment=comment;
    }

    public boolean containsClz(Object value) {
        return clz.containsKey(value);
    }

    public ModelClzData getClz(Object key) {
        return clz.get(key);
    }

    public ModelClzData putClz(String key, ModelClzData value) {
        return clz.put(key, value);
    }

    public Map<String, ModelClzData> getClz() {
        return clz;
    }

    public ModelPackageData setClz(Map<String, ModelClzData> clz) {
        this.clz = clz;
        return this;
    }

    //    public String getComment() {
//        return comment;
//    }
//
//    public ModelPackageData setComment(String comment) {
//        this.comment = comment;
//        return this;
//    }


}
