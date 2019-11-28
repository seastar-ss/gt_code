package com.shawn.ss.lib.code_gen.base.helper.data_store;

import com.helger.jcodemodel.JDefinedClass;
import com.helger.jcodemodel.JMethod;
import com.shawn.ss.lib.code_gen.model.MethodTypeEnum;
import com.shawn.ss.lib.tools.CollectionHelper;
import jdk.nashorn.internal.scripts.JD;

import java.util.EnumMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by ss on 2018/2/10.
 */
public class ClassDataTable {
    public static final EnumMap<MethodTypeEnum,Map<String,Map<String,JMethod>>> ALL_METHODS= new EnumMap<MethodTypeEnum,Map<String,Map<String,JMethod>>>(MethodTypeEnum.class);
    public static final Map<String,JDefinedClass> ALL_MODELS= CollectionHelper.newMap();
    public static final Map<String,JDefinedClass> ALL_DAOS= CollectionHelper.newMap();

    public static int sizeOfDaoClz() {
        return ALL_DAOS.size();
    }

    public static JDefinedClass getDaoClz(Object key) {
        return ALL_DAOS.get(key);
    }

    public static JDefinedClass putDaoClz(String key, JDefinedClass value) {
        return ALL_DAOS.put(key, value);
    }

    public static Set<String> keySetOfDaoClz() {
        return ALL_DAOS.keySet();
    }

    public static int sizeOfModelClz() {
        return ALL_MODELS.size();
    }

    public static JDefinedClass getModelClz(Object key) {
        return ALL_MODELS.get(key);
    }

    public static JDefinedClass putModelClz(String key, JDefinedClass value) {
        return ALL_MODELS.put(key, value);
    }

    public static Set<String> keySetOfModelClz() {
        return ALL_MODELS.keySet();
    }

    public static Map<String,Map<String,JMethod>> getMethods(Object key) {
        return ALL_METHODS.get(key);
    }

    public static Map<String,Map<String,JMethod>> putMethods(MethodTypeEnum key, Map<String,Map<String,JMethod>> value) {
        return ALL_METHODS.put(key, value);
    }

    public static JMethod getMethod(MethodTypeEnum key,String clz, String method) {
        Map<String,Map<String,JMethod>> defMap = ALL_METHODS.get(key);
        Map<String,JMethod> mMap=defMap==null?null:defMap.get(clz);
        return mMap==null?null:mMap.get(method);
    }

    public static void putMethod(MethodTypeEnum key,String clz, String method,  JMethod value) {
        Map<String,Map<String,JMethod>> defMap = ALL_METHODS.get(key);
        if(defMap==null){
            defMap= CollectionHelper.newMap();
        }
        Map<String,JMethod> mMap=defMap.get(clz);
        if(mMap==null){
            mMap=CollectionHelper.newMap();
        }
        mMap.put(method,value);
        defMap.put(clz,mMap);
        ALL_METHODS.put(key,defMap);
    }

}
