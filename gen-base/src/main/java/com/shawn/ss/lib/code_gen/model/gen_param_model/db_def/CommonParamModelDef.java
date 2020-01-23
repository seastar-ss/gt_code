package com.shawn.ss.lib.code_gen.model.gen_param_model.db_def;

/**
 * Created by ss on 2018/7/29.
 */
public class CommonParamModelDef {
//    boolean isList;
    boolean isCollection;
    boolean isMap;
    boolean isArray;
    String clzName;
    String paramName;
    Integer index;
    String keyClzName;
//    public boolean isList() {
//        return isList;
//    }
//
//    public CommonParamModelDef setList(boolean list) {
//        isList = list;
//        return this;
//    }


    public boolean isMap() {
        return isMap;
    }

    public CommonParamModelDef setMap(boolean map) {
        isMap = map;
        return this;
    }

    public boolean isCollection() {
        return isCollection;
    }

    public CommonParamModelDef setCollection(boolean collection) {
        isCollection = collection;
        return this;
    }

    public String getClzName() {
        return clzName;
    }

    public CommonParamModelDef setClzName(String clzName) {
        this.clzName = clzName;
        return this;
    }

    public String getParamName() {
        return paramName;
    }

    public CommonParamModelDef setParamName(String paramName) {
        this.paramName = paramName;
        return this;
    }

    public Integer getIndex() {
        return index;
    }

    public CommonParamModelDef setIndex(Integer index) {
        this.index = index;
        return this;
    }

    public boolean isArray() {
        return isArray;
    }

    public CommonParamModelDef setArray(boolean array) {
        isArray = array;
        return this;
    }

    public String getKeyClzName() {
        return keyClzName;
    }

    public CommonParamModelDef setKeyClzName(String keyClzName) {
        this.keyClzName = keyClzName;
        return this;
    }

    @Override
    public String toString() {
        return "CommonParamModelDef{" +
                "isCollection=" + isCollection +
                ", isMap=" + isMap +
                ", isArray=" + isArray +
                ", clzName='" + clzName + '\'' +
                ", paramName='" + paramName + '\'' +
                ", index=" + index +
                ", keyClzName='" + keyClzName + '\'' +
                '}';
    }
}
