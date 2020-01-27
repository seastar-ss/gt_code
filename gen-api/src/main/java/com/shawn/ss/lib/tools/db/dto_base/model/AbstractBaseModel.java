/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shawn.ss.lib.tools.db.dto_base.model;

import java.io.Serializable;
import java.util.Map;

/**
 * @author ss
 */
public abstract class AbstractBaseModel implements Serializable,_APIObj {
//    protected static int modelFieldCount;


//    public final static long serialVersionUID ;

    public static final int DEFAULT_START=0,DEFUALT_COUNT=1000;
    static {

    }

    protected transient int index;

    protected transient String currentTableName;

    public void setIndex(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public String getCurrentTableName() {
        return currentTableName;
    }

    public AbstractBaseModel setCurrentTableName(String currentTableName) {
        this.currentTableName = currentTableName;
        return this;
    }

    @Override
    public <T extends _APIObj> T getFeature(Class<T> clazz) {
        return null;
    }

    public static String compressStr(int length, String str){
        if(str==null){
            return null;
        }
        String compressString = "";
        if(str==null || str.length()==0){
            return str;
        }
        if(length > str.length() || length < 1){
            return str;
        }else {
            compressString  = str.substring(0, length);
        }
        return compressString;
    }

    public Map<String,Object> getFieldConfig(){
        return null;
    }

    public boolean isEmpty(){
        return true;
    }

    //    @Override
//    public String toString() {
//        final StringBuilder sb = new StringBuilder("AbstractBaseModel{");
////        sb.append(L.p(this,this.getClass()));
//        sb.append('}');
//        return sb.toString();
//    }
}
