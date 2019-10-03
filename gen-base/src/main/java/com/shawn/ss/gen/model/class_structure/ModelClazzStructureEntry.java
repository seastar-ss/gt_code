package com.shawn.ss.gen.model.class_structure;

import com.shawn.ss.lib.tools.CollectionHelper;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by ss on 2017/2/9.
 */
public class ModelClazzStructureEntry {

    //    public static final Queue<ParamElement> builtEntry = new ArrayDeque<>();
    public static enum DataType{
        enumType,interfaceType,classType,objectClassType,commonDataType,annotationType
    }

//    String paramName;
//    Object defaultValue;
    boolean isSimple;
    boolean isSimpleClz;
    String desp;
    String type;
    DataType dataType;
    String clzName;
    List<String> enumConstant;


    Map<String,ModelParamEntry> subEntries;

    public ModelClazzStructureEntry() {
        subEntries= CollectionHelper.newMap(64);
        enumConstant=CollectionHelper.newList();
    }

//    public String getParamName() {
//        return paramName;
//    }
//
//    public ModelClazzStructureEntry setParamName(String paramName) {
//        this.paramName = paramName;
//        return this;
//    }
//
//    public Object getDefaultValue() {
//        return defaultValue;
//    }
//
//    public ModelClazzStructureEntry setDefaultValue(Object defaultValue) {
//        this.defaultValue = defaultValue;
//        return this;
//    }

    public String getDesp() {
        return desp;
    }

    public ModelClazzStructureEntry setDesp(String desp) {
        this.desp = desp;
        return this;
    }

    public String getType() {
        return type;
    }

    public ModelClazzStructureEntry setType(String type) {
        this.type = type;
        return this;
    }

    public DataType getDataType() {
        return dataType;
    }

    public ModelClazzStructureEntry setDataType(DataType dataType) {
        this.dataType = dataType;
        return this;
    }

//    public String isArray() {
//        return arrayType;
//    }
//
//    public ModelClazzStructureEntry setArray(String array) {
//        arrayType = array;
//        return this;
//    }

    public boolean isSimple() {
        return isSimple;
    }

    public ModelClazzStructureEntry setSimple(boolean simple) {
        isSimple = simple;
        return this;
    }

    public int sizeOfChildren() {
        return subEntries.size();
    }

    public boolean isChildrenEmpty() {
        return subEntries.isEmpty();
    }

    public boolean containsCKey(Object key) {
        return subEntries.containsKey(key);
    }

    public boolean containsCValue(Object value) {
        return subEntries.containsValue(value);
    }

    public ModelParamEntry getChildren(Object key) {
        return subEntries.get(key);
    }

    public ModelParamEntry putChildren(String key, ModelParamEntry value) {
        return subEntries.put(key, value);
    }

    public Set<String> keySetOfChildren() {
        return subEntries.keySet();
    }

    public Collection<ModelParamEntry> valuesOfChildren() {
        return subEntries.values();
    }

    public String getClzName() {
        return clzName;
    }

    public ModelClazzStructureEntry setClzName(String clzName) {
        this.clzName = clzName;
        return this;
    }

    public boolean isSimpleClz() {
        return isSimpleClz;
    }

    public ModelClazzStructureEntry setSimpleClz(boolean simpleClz) {
        isSimpleClz = simpleClz;
        return this;
    }

    public List<String> getEnumConstant() {
        return enumConstant;
    }

    public int sizeOfEnumConstant() {
        return enumConstant.size();
    }

    public boolean addEnumConstant(String s) {
        return enumConstant.add(s);
    }

    public String getEnumConstant(int index) {
        return enumConstant.get(index);
    }

    public void judgeSimpleClz() {
        if(!isSimple){

            Collection<ModelParamEntry> values = subEntries.values();
            for(ModelParamEntry entry:values){
                if(!entry.isSimple()){
                    this.setSimpleClz(false);
                    return;
                }
            }
        }
        this.setSimpleClz(true);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ModelClazzStructureEntry{");
        sb.append("isSimple=").append(isSimple);
        sb.append(", isSimpleClz=").append(isSimpleClz);
        sb.append(", desp='").append(desp).append('\'');
        sb.append(", type='").append(type).append('\'');
        sb.append(", dataType=").append(dataType);
        sb.append(", clzName='").append(clzName).append('\'');
        sb.append(", subEntries=").append(subEntries);
        sb.append('}');
        return sb.toString();
    }
}
