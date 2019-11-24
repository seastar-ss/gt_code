package com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model;

/**
 * Created by ss on 2018/7/29.
 */
public class CommonFieldTypeInfo implements FieldDataTypeInterface{
//    boolean isList;
    boolean isCollection;
    boolean isMap;
    boolean isArray;
    String tClassName;
    Class tClass;

//    String paramName;
    Integer index;
    String keyClassName;
    Class keyClass;
    String[] dataType;
    Object defaultValue;
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

    public CommonFieldTypeInfo setMap(boolean map) {
        isMap = map;
        return this;
    }

    @Override
    public Class gettClass() {
        return tClass;
    }

    @Override
    public String getTClassName() {
        return tClassName;
    }

    public boolean isCollection() {
        return isCollection;
    }

    public CommonFieldTypeInfo setCollection(boolean collection) {
        isCollection = collection;
        return this;
    }

//    public String getClzName() {
//        return clzName;
//    }

    public CommonFieldTypeInfo settClassName(String tClassName) {
        this.tClassName = tClassName;
        return this;
    }

    public Integer getIndex() {
        return index;
    }

    public CommonFieldTypeInfo setIndex(Integer index) {
        this.index = index;
        return this;
    }

    public boolean isArray() {
        return isArray;
    }



    @Override
    public Class getKeyClass() {
        return keyClass;
    }

    public String gettClassName() {
        return tClassName;
    }

    public CommonFieldTypeInfo settClass(Class tClass) {
        this.tClass = tClass;
        return this;
    }

    public CommonFieldTypeInfo setKeyClass(Class keyClass) {
        this.keyClass = keyClass;
        return this;
    }

    @Override
    public String[] getDataType() {
        return dataType;
    }

    public CommonFieldTypeInfo setDataType(String[] dataType) {
        this.dataType = dataType;
        return this;
    }

    @Override
    public String getObtainMethod() {
        return null;
    }

    @Override
    public String name() {
        return null;
    }

    public CommonFieldTypeInfo setArray(boolean array) {
        isArray = array;
        return this;
    }

    public String getKeyClassName() {
        return keyClassName;
    }

    public CommonFieldTypeInfo setKeyClassName(String keyClassName) {
        this.keyClassName = keyClassName;
        return this;
    }

    @Override
    public Object getDefaultValue() {
        return defaultValue;
    }

    public CommonFieldTypeInfo setDefaultValue(Object defaultValue) {
        this.defaultValue = defaultValue;
        return this;
    }

    @Override
    public String toString() {
        return "CommonParamModelDef{" +
                "isCollection=" + isCollection +
                ", isMap=" + isMap +
                ", isArray=" + isArray +
                ", clzName='" + tClassName + '\'' +
//                ", paramName='" + paramName + '\'' +
                ", index=" + index +
                ", keyClzName='" + keyClassName + '\'' +
                '}';
    }
}
