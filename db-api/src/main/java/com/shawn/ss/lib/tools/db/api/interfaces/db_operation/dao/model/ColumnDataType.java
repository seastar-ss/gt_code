package com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model;

import com.shawn.ss.lib.tools.CollectionHelper;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

/**
 * Created by ss on 2017/10/11.
 */
public enum ColumnDataType implements FieldDataTypeInterface {
    intData(Integer.class,"getInt",new String[]{"INT","MEDIUMINT"},0),
    longData(Long.class,"getLong",new String[]{"BIGINT"},0L),
    byteData(Byte.class,"getByte",new String[]{"TINYINT"},(byte)0),
    shortData(Short.class,"getShort",new String[]{"SMALLINT"},(short)0),
    dateData(Date.class,"getDate",new String[]{"DATE","YEAR"},new Date()),
    timeData(Date.class,"getTime",new String[]{"TIME"},new Date()),
    timeStampData(Date.class,"getTimestamp",new String[]{"DATETIME","TIMESTAMP"},new Date()),
    stringData(String.class,"getString",new String[]{"VARCHAR","CHAR","TEXT","MEDIUMTEXT","LONGTEXT","TINYTEXT"},""),
    doubleData(Double.class,"getDouble",new String[]{"DOUBLE"},0.0),
    decimalData(BigDecimal.class,"getBigDecimal",new String[]{"DECIMAL"},new BigDecimal(0)),
    floatData(Float.class,"getFloat",new String[]{"FLOAT"},0.0f),
    bytesData(byte[].class,"getBlob",new String[]{"MEDIUMBLOB","LONGBLOB","TINYBLOB","BLOB"},new byte[]{}),
    booleanData(Boolean.class,"getBoolean",new String[]{"BIT"},false),
    enumData(Enum.class,"",new String[]{},null),
    constValue(String.class,"",new String[]{},null);
    public static String SPECIAL_BLOB_METHOD="getBlob";
    private final Class tClass;
    private final String obtainMethod;
    private final String[] dataType;
    private final Object defaultValue;

    private static volatile Map<String,FieldDataTypeInterface> typeMap;
    private static volatile Map<Class,FieldDataTypeInterface> clsTypeMap;

    private ColumnDataType(Class tClass, String obtainMethod, String[] dataType,Object defaultValue){
        this.tClass = tClass;
        this.obtainMethod = obtainMethod;
        this.dataType = dataType;
        this.defaultValue=defaultValue;
//        ResultSet res=null;
//        res.getFloat()
    }

    @Override
    public Class gettClass() {
        return tClass;
    }

    @Override
    public String getTClassName() {
        return tClass.getName();
    }

    @Override
    public boolean isCollection() {
        return false;
    }

    @Override
    public boolean isMap() {
        return false;
    }

    @Override
    public boolean isArray() {
        return false;
    }

    @Override
    public String getKeyClassName() {
        return null;
    }

    @Override
    public Class getKeyClass() {
        return null;
    }

    @Override
    public String[] getDataType() {
        return dataType;
    }

    @Override
    public String getObtainMethod() {
        return obtainMethod;
    }

    @Override
    public Object getDefaultValue() {
        return defaultValue;
    }

//    public ColumnDataType setDefaultValue(Object defaultValue) {
//        this.defaultValue = defaultValue;
//        return this;
//    }

    public static FieldDataTypeInterface getType(String type){
        if(typeMap==null){
            synchronized (ColumnDataType.class){
                typeMap= CollectionHelper.newMap();
                FieldDataTypeInterface[] values = ColumnDataType.values();
                for(FieldDataTypeInterface dataType:values){
                    String[] typeDataType = dataType.getDataType();
                    for(String typeStr:typeDataType){
                        typeMap.put(typeStr,dataType);
                    }
                }
            }
        }
        return typeMap.get(type);
    }

    public static FieldDataTypeInterface getType(Class type){
        if(clsTypeMap==null){
            synchronized (ColumnDataType.class){
                clsTypeMap= CollectionHelper.newMap();
                FieldDataTypeInterface[] values = ColumnDataType.values();
                for(FieldDataTypeInterface dataType:values){
                    Class aClass = dataType.gettClass();
                    clsTypeMap.put(aClass,dataType);
                }
            }
        }

        return clsTypeMap.get(type);
    }
}
