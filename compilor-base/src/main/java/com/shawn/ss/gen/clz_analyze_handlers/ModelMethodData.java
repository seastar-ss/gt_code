package com.shawn.ss.gen.clz_analyze_handlers;

import com.shawn.ss.gen.model.class_structure.ModelParamEntry;
import com.shawn.ss.lib.tools.CollectionHelper;

import java.util.Map;

public class ModelMethodData extends ElementData{
//    static Map<String,ModelClzData> analyzedMethod= CollectionHelper.newMap();

//    String methodKey;
//    String name;
    transient ModelClzData belongTo;
    Map<String,ModelParamData> params;
    ModelParamEntry ret;
//    String comment;

//    ModelMethodData(ElRet el) {
//        super(el);
//
//        params=CollectionHelper.newMap();
//    }

    ModelMethodData(ElRet el,  ModelClzData belongTo, ModelParamEntry ret) {
        super(el);
//        this.name = name;
        this.belongTo = belongTo;
        this.ret = ret;
//        this.comment = comment;
        params=CollectionHelper.newMap();
    }

    //    public static Map<String, ModelClzData> getAnalyzedMethod() {
//        return analyzedMethod;
//    }
//
//    public static void setAnalyzedMethod(Map<String, ModelClzData> analyzedMethod) {
//        ModelMethodData.analyzedMethod = analyzedMethod;
//    }

//    public String getMethodKey() {
//        return methodKey;
//    }
//
//    public ModelMethodData setMethodKey(String methodKey) {
//        this.methodKey = methodKey;
//        return this;
//    }

//    public String getName() {
//        return name;
//    }

//    public ModelMethodData setName(String name) {
//        this.name = name;
//        return this;
//    }

    public Map<String, ModelParamData> getParams() {
        return params;
    }

    public ModelMethodData setParams(Map<String, ModelParamData> params) {
        this.params = params;
        return this;
    }

    public ModelParamEntry getRet() {
        return ret;
    }

    public ModelMethodData setRet(ModelParamEntry ret) {
        this.ret = ret;
        return this;
    }

//    public String getComment() {
//        return comment;
//    }
//
//    public ModelMethodData setComment(String comment) {
//        this.comment = comment;
//        return this;
//    }

    public ModelClzData getBelongTo() {
        return belongTo;
    }

    public ModelMethodData setBelongTo(ModelClzData belongTo) {
        this.belongTo = belongTo;
        return this;
    }

    public void putParam(String name, ModelParamData data) {
        params.put(name,data);
    }
}
