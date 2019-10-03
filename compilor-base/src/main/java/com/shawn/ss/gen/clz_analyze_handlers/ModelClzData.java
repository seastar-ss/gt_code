package com.shawn.ss.gen.clz_analyze_handlers;

import com.shawn.ss.gen.model.class_structure.ModelClazzStructureEntry;
import com.shawn.ss.lib.tools.CollectionHelper;

import java.util.Map;

public class ModelClzData extends  ElementData{


    transient ModelPackageData belogTo;
//    Integer packageId;
//    String packageName;
//    Integer id;
    ModelClazzStructureEntry classInfo;
//    String clzKey;
    Map<String,ModelFieldData> fields;
    Map<String,ModelMethodData> methods;

//    ModelClzData(ElRet el) {
//        super(el);
//        fields=CollectionHelper.newMap();
//        methods=CollectionHelper.newMap();
//    }

   ModelClzData(ElRet el, ModelPackageData belogTo, ModelClazzStructureEntry classInfo) {
        super(el);
        this.belogTo = belogTo;
        this.classInfo = classInfo;
       fields=CollectionHelper.newMap();
        methods=CollectionHelper.newMap();
    }


//    public Integer getId() {
//        return id;
//    }
//
//    public ModelClzData setId(Integer id) {
//        this.id = id;
//        return this;
//    }

    public ModelClazzStructureEntry getClassInfo() {
        return classInfo;
    }

    public ModelClzData setClassInfo(ModelClazzStructureEntry classInfo) {
        this.classInfo = classInfo;
        return this;
    }

    public Map<String, ModelFieldData> getFields() {
        return fields;
    }

    public ModelClzData setFields(Map<String, ModelFieldData> fields) {
        this.fields = fields;
        return this;
    }

    public Map<String, ModelMethodData> getMethods() {
        return methods;
    }

    public ModelClzData setMethods(Map<String, ModelMethodData> methods) {
        this.methods = methods;
        return this;
    }

//    public Integer getPackageId() {
//        return packageId;
//    }
//
//    public ModelClzData setPackageId(Integer packageId) {
//        this.packageId = packageId;
//        return this;
//    }
//
//    public String getPackageName() {
//        return packageName;
//    }
//
//    public ModelClzData setPackageName(String packageName) {
//        this.packageName = packageName;
//        return this;
//    }



    public ModelPackageData getBelogTo() {
        return belogTo;
    }

    public void putMethod(String key,ModelMethodData data) {
       methods.put(key,data);
    }

    public void putField(String name, ModelFieldData data) {
       fields.put(name,data);
    }
}
