package com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model;

import com.shawn.ss.lib.tools.CollectionHelper;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

/**
 * Created by ss on 2017/10/11.
 */
public enum ColumnDataType implements FieldDataTypeInterface {
    intData(Integer.class,"getInt",new String[]{"INT","MEDIUMINT"}),
    longData(Long.class,"getLong",new String[]{"BIGINT"}),
    byteData(Byte.class,"getByte",new String[]{"TINYINT"}),
    shortData(Short.class,"getShort",new String[]{"SMALLINT"}),
    dateData(Date.class,"getDate",new String[]{"DATE","YEAR"}),
    timeData(Date.class,"getTime",new String[]{"TIME"}),
    timeStampData(Date.class,"getTimestamp",new String[]{"DATETIME","TIMESTAMP"}),
    stringData(String.class,"getString",new String[]{"VARCHAR","CHAR","TEXT","MEDIUMTEXT","LONGTEXT","TINYTEXT"}),
    doubleData(Double.class,"getDouble",new String[]{"DOUBLE"}),
    decimalData(BigDecimal.class,"getBigDecimal",new String[]{"DECIMAL"}),
    floatData(Float.class,"getFloat",new String[]{"FLOAT"}),
    bytesData(byte[].class,"getBlob",new String[]{"MEDIUMBLOB","LONGBLOB","TINYBLOB","BLOB"}),
    booleanData(Boolean.class,"getBoolean",new String[]{"BIT"}),
    enumData(Enum.class,"",new String[]{}),
    constValue(String.class,"",new String[]{});
    public static String SPECIAL_BLOB_METHOD="getBlob";
    private Class tClass;
    private String obtainMethod;
    private String[] dataType;

    private static volatile Map<String,FieldDataTypeInterface> typeMap;
    private static volatile Map<Class,FieldDataTypeInterface> clsTypeMap;

    private ColumnDataType(Class tClass, String obtainMethod, String[] dataType){
        this.tClass = tClass;
        this.obtainMethod = obtainMethod;
        this.dataType = dataType;
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
