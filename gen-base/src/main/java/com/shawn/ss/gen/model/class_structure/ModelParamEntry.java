package com.shawn.ss.gen.model.class_structure;

import com.shawn.ss.lib.code_gen.base.helper.data_store.AnalyzedClzDataTable;
import com.shawn.ss.lib.tools.CollectionHelper;

import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * Created by ss on 2017/2/9.
 */
public class ModelParamEntry {
    //    public static final Queue<ParamElement> builtEntry = new ArrayDeque<>();

    public static enum ArrayType {
        array, list, set, collection, stringMap, intMap, longMap, doubleMap, dateMap, otherMap;

        public boolean isMap() {
            return this.equals(ArrayType.longMap)
                    || this.equals(ArrayType.stringMap)
                    || this.equals(ArrayType.intMap)
                    || this.equals(ArrayType.doubleMap)
                    || this.equals(ArrayType.otherMap)
                    || this.equals(ArrayType.dateMap)
                    || this.equals(ArrayType.dateMap)
                    ;
        }

        public boolean isCollection() {
            return this.equals(ArrayType.list)
                    || this.equals(ArrayType.set)
                    || this.equals(ArrayType.collection)
                    ;
        }

        public boolean isArray() {
            return this.equals(ArrayType.array);
        }
    }

    public static class ArrayInfo {
        ArrayType type;
        ModelClazzStructureEntry keyType;

        public ArrayType getType() {
            return type;
        }

        public ArrayInfo setType(ArrayType type) {
            this.type = type;
            return this;
        }

        public ModelClazzStructureEntry getKeyType() {
            return keyType;
        }

        public ArrayInfo setKeyType(ModelClazzStructureEntry keyType) {
            this.keyType = keyType;
            return this;
        }

        @Override
        public String toString() {
            return "ArrayInfo{" +
                    "type=" + type +
                    ", keyType=" + keyType +
                    '}';
        }
    }

    String paramName;
    Object defaultValue;
    List<ArrayInfo> arrayType;
//    Integer arrayDemension;
    Object contantValue;
    //    List<ModelClazzStructureEntry> keyClz;
    ModelClazzStructureEntry clz;

    public ModelParamEntry() {
        clz = new ModelClazzStructureEntry();
        arrayType = CollectionHelper.newList();
//        keyClz=CollectionHelper.newList();
//        arrayDemension = 0;
    }

    public String getParamName() {
        return paramName;
    }

    public ModelParamEntry setParamName(String paramName) {
        this.paramName = paramName;
        return this;
    }

    public Object getDefaultValue() {
        return defaultValue;
    }

    public ModelParamEntry setDefaultValue(Object defaultValue) {
        this.defaultValue = defaultValue;
        return this;
    }


    public List<ArrayInfo> getArrayType() {
        return arrayType;
    }

    public ModelParamEntry setArrayType(List<ArrayInfo> arrayType) {
        this.arrayType = arrayType;
        return this;
    }

    public ModelClazzStructureEntry getClz() {
        return clz;
    }

    public ModelParamEntry setClz(ModelClazzStructureEntry clz) {
        this.clz = clz;
        return this;
    }

    public ModelParamEntry setClz(String clz) {
        this.clz = AnalyzedClzDataTable.get(clz);
        return this;
    }

    public String getDesp() {
        return clz.getDesp();
    }

    public ModelClazzStructureEntry setDesp(String desp) {
        return clz.setDesp(desp);
    }

    public String getType() {
        return clz.getType();
    }

    public ModelClazzStructureEntry setType(String type) {
        return clz.setType(type);
    }

    public ModelClazzStructureEntry.DataType getDataType() {
        return clz.getDataType();
    }

    public ModelClazzStructureEntry setDataType(ModelClazzStructureEntry.DataType dataType) {
        return clz.setDataType(dataType);
    }

    public boolean isSimple() {
        return clz.isSimple();
    }

    public ModelClazzStructureEntry setSimple(boolean simple) {
        return clz.setSimple(simple);
    }

    public int sizeOfChildren() {
        return clz.sizeOfChildren();
    }

    public boolean isChildrenEmpty() {
        return clz.isChildrenEmpty();
    }

    public boolean containsCKey(Object key) {
        return clz.containsCKey(key);
    }

    public boolean containsCValue(Object value) {
        return clz.containsCValue(value);
    }

    public ModelParamEntry getChildren(Object key) {
        return clz.getChildren(key);
    }

    public ModelParamEntry putChildren(String key, ModelParamEntry value) {
        return clz.putChildren(key, value);
    }

    public Set<String> keySetOfChildren() {
        return clz.keySetOfChildren();
    }

    public Collection<ModelParamEntry> valuesOfChildren() {
        return clz.valuesOfChildren();
    }

    public String getClzName() {
        return clz.getClzName();
    }

    public ModelClazzStructureEntry setClzName(String clzName) {
        return clz.setClzName(clzName);
    }


//    public List<ModelClazzStructureEntry> getKeyClz() {
//        return keyClz;
//    }
//
//    public ModelParamEntry setKeyClz(List<ModelClazzStructureEntry> keyClz) {
//        this.keyClz = keyClz;
//        return this;
//    }


    public int sizeOfArray() {
        return arrayType.size();
    }

    public ArrayInfo getArrayInfo(int index) {
        return arrayType.get(index);
    }

    public ArrayInfo setArrayInfo(int index, ArrayInfo element) {
        return arrayType.set(index, element);
    }

    public void addArrayInfo(ArrayInfo element) {
        arrayType.add(element);
    }

    public Object getContantValue() {
        return contantValue;
    }

    public ModelParamEntry setContantValue(Object contantValue) {
        this.contantValue = contantValue;
        return this;
    }

    public Integer getArrayDemension() {
        return arrayType.size();
    }

//    public ModelParamEntry setArrayDemension(Integer arrayDemension) {
//        this.arrayDemension = arrayDemension;
//        return this;
//    }

//    public ModelParamEntry incrArrayDemension() {
//        if (this.arrayDemension == null) {
//            this.arrayDemension = 1;
//        } else {
//            this.arrayDemension++;
//        }
//        return this;
//    }

    @Override
    public String toString() {
        return "ModelParamEntry{" +
                "paramName='" + paramName + '\'' +
                ", defaultValue=" + defaultValue +
                ", arrayType=" + arrayType +
                ", arrayDemension=" + getArrayDemension() +
                ", contantValue=" + contantValue +
//                ", keyClz=" + keyClz +
                ", clz=" + clz +
                '}';
    }
}
