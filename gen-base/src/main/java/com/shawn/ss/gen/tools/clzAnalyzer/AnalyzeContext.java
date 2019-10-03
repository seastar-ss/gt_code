package com.shawn.ss.gen.tools.clzAnalyzer;

import com.shawn.ss.gen.model.class_structure.ModelClazzStructureEntry;
import com.shawn.ss.gen.model.class_structure.ModelParamEntry;
import com.shawn.ss.lib.tools.CollectionHelper;

import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.TypeMirror;
import java.util.Map;

public class AnalyzeContext {
    ModelParamEntry root;
    ModelClazzStructureEntry rootClz;
    Element rootEl;
//    TypeElement rootEnclosingClz;
//    ExecutableElement rootEnclosingMethod;

    ModelParamEntry currentParamModel;
    TypeMirror currentTypeMirror;
    ModelClazzStructureEntry currentClzModel;
    Element currentEl;
    TypeElement currentClzEl;
    TypeElement currentEnclosingClz;
    ExecutableElement currentEnclosingMethod;
    Map<String,TypeMirror> parentTypeVars;
    Map<String,TypeMirror> enclosingWTypes;

    public AnalyzeContext() {
        parentTypeVars = CollectionHelper.newMap();
        enclosingWTypes = CollectionHelper.newMap();
    }

    public boolean containsWKey(Object key) {
        return enclosingWTypes.containsKey(key);
    }

    public TypeMirror getWType(Object key) {
        return enclosingWTypes.get(key);
    }

    public TypeMirror putWType(String key, TypeMirror value) {
        return enclosingWTypes.put(key, value);
    }


    public boolean containsTVKey(Object key) {
        return parentTypeVars.containsKey(key);
    }

    public TypeMirror getTVType(Object key) {
        return parentTypeVars.get(key);
    }

    public TypeMirror putTVType(String key, TypeMirror value) {
        return parentTypeVars.put(key, value);
    }



    public AnalyzeContext setRoot(ModelParamEntry root) {
        this.root = root;
        return this;
    }

    public AnalyzeContext setRootEl(Element rootEl) {
        this.rootEl = rootEl;
        return this;
    }

//    public AnalyzeContext setRootEnclosingClz(TypeElement rootEnclosingClz) {
//        this.rootEnclosingClz = rootEnclosingClz;
//        return this;
//    }
//
//    public AnalyzeContext setRootEnclosingMethod(ExecutableElement rootEnclosingMethod) {
//        this.rootEnclosingMethod = rootEnclosingMethod;
//        return this;
//    }

    public AnalyzeContext setCurrentParamModel(ModelParamEntry currentParamModel) {
        this.currentParamModel = currentParamModel;
        return this;
    }

    public AnalyzeContext setCurrentEl(Element currentEl) {
        this.currentEl = currentEl;
        return this;
    }

    public AnalyzeContext setCurrentEnclosingClz(TypeElement currentEnclosingClz) {
        this.currentEnclosingClz = currentEnclosingClz;
        return this;
    }

    public AnalyzeContext setCurrentEnclosingMethod(ExecutableElement currentEnclosingMethod) {
        this.currentEnclosingMethod = currentEnclosingMethod;
        return this;
    }

//    public ModelClazzStructureEntry getRootClz() {
//        return rootClz;
//    }

    public AnalyzeContext setRootClz(ModelClazzStructureEntry rootClz) {
        this.rootClz = rootClz;
        return this;
    }

//    public ModelClazzStructureEntry getCurrentClz() {
//        return currentClzModel;
//    }

    public AnalyzeContext setCurrentClzModel(ModelClazzStructureEntry currentClzModel) {
        this.currentClzModel = currentClzModel;
        return this;
    }

    public Element getCurrentElement() {
        Element el=this.currentEl;
        if (el == null) {
            el=this.rootEl;
            this.setCurrentEl(el);
        }

        return el;
    }

    public ModelParamEntry getCurrentParamModel(){
        ModelParamEntry ret = this.currentParamModel;
        if(ret==null){
            ret=this.root;
            this.setCurrentParamModel(ret);
        }
        return ret;
    }

    public AnalyzeContext setCurrentTypeMirror(TypeMirror currentTypeMirror) {
        this.currentTypeMirror = currentTypeMirror;
        return this;
    }

    public ModelClazzStructureEntry getCurrentClzStructure(){
        ModelClazzStructureEntry ret=this.currentClzModel;
        if(ret==null){
            ret=this.rootClz;
            this.setCurrentClzModel(ret);
        }
        return ret;

    }

    public AnalyzeContext setCurrentClzEl(TypeElement currentClzEl) {
        this.currentClzEl = currentClzEl;
        return this;
    }
}
