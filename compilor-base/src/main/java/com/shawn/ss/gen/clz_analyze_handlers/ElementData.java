package com.shawn.ss.gen.clz_analyze_handlers;

import com.shawn.ss.gen.Helpers;
import com.shawn.ss.gen.model.class_structure.ModelClazzStructureEntry;
import com.shawn.ss.gen.model.class_structure.ModelParamEntry;
import com.shawn.ss.lib.tools.CollectionHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.lang.model.element.*;
import java.util.Map;
import java.util.Set;

public abstract class ElementData<T extends ElementData> {

    static final Logger L= LoggerFactory.getLogger(ElementData.class);

    static Map<String, ElementData> analyzedElement = CollectionHelper.newMap();

    public static Set<ModelPackageData> getAllPackage(){
        final Set<ModelPackageData> ret=CollectionHelper.newSet();
        analyzedElement.forEach((key,value)->{
            if(value.kind==ElementKind.PACKAGE && value instanceof ModelPackageData){
                ret.add((ModelPackageData)value);
            }
        });
        return  ret;
    }

    public static Set<ModelClzData> getAllClz(){
        final Set<ModelClzData> ret=CollectionHelper.newSet();
        analyzedElement.forEach((key,value)->{
            if((value.kind==ElementKind.CLASS || value.kind==ElementKind.INTERFACE) && value instanceof ModelClzData){
                ret.add((ModelClzData)value);
            }
        });
        return  ret;
    }

    public static Set<ModelMethodData> getAllMethod(){
        final Set<ModelMethodData> ret=CollectionHelper.newSet();
        analyzedElement.forEach((key,value)->{
            if(value.kind==ElementKind.METHOD && value instanceof ModelMethodData){
                ret.add((ModelMethodData)value);
            }
        });
        return  ret;
    }

    public static boolean containsElement(Object key) {
        return analyzedElement.containsKey(key);
    }

    public static ElementData getElement(Object key) {
        return analyzedElement.get(key);
    }

    public static ElementData putElement(String key, ElementData value) {
        return analyzedElement.put(key, value);
    }

//    public static <T extends ElementData> T createElement(Element el, Helpers helper) {
//        ElRet keyAndType = getKeyAndType(el);
//        ElementData ret = null;
//        if (containsElement(keyAndType.key)) {
//            ret = getElement(keyAndType.key);
//        } else {
//            keyAndType.comment = helper.elementUtils.getDocComment(el);
//            keyAndType.name=el.getSimpleName().toString();
//            L.debug("handle el:{},{},{}",keyAndType.name,keyAndType.kind,keyAndType.key);
//            String key=null;
//            ModelClzData clzData;
//            ModelParamEntry retType;
//            switch (keyAndType.kind) {
//                case PACKAGE:
//                    ret = new ModelPackageData(keyAndType);
//                    key = ret.getKey();
//                    if (!containsElement(key))
//                        putElement(key, ret);
//                    break;
//                case CLASS:
//                case INTERFACE:
//                    ModelPackageData pelData = ElementData.<ModelPackageData>createElement(keyAndType.pEl, helper);
//                    key = pelData.getKey();
//                    if (!containsElement(key))
//                        putElement(key, pelData);
//                    ModelClazzStructureEntry entry = new ModelClazzStructureEntry();
//                    helper.analyzer.assembleClazzStructure(entry, keyAndType.clzEl);
//                    ret = new ModelClzData(keyAndType, pelData, entry);
//                    key = ret.getKey();
//                    if (!containsElement(key))
//                        putElement(key, ret);
//                    break;
//                case METHOD:
//                    clzData = ElementData.<ModelClzData>createElement(keyAndType.clzEl,helper);
//                    key=clzData.getKey();
//                    if (!containsElement(key))
//                        putElement(key, clzData);
//
//                    retType = new ModelParamEntry();
//                    helper.analyzer.assembleParamStructure(retType,keyAndType.methodEl);
//                    ret=new ModelMethodData(keyAndType,clzData,retType);
//                    key = ret.getKey();
//                    if (!containsElement(key))
//                        putElement(key, ret);
//                    break;
//                case FIELD:
//                    clzData=ElementData.<ModelClzData>createElement(keyAndType.clzEl,helper);
//                    key=clzData.getKey();
//                    if (!containsElement(key))
//                        putElement(key, clzData);
//                    retType=new ModelParamEntry();
//                    helper.analyzer.assembleParamStructure(retType,keyAndType.varEl);
//                    ret=new ModelFieldData(keyAndType,retType,clzData);
//                    key = ret.getKey();
//                    if (!containsElement(key))
//                        putElement(key, ret);
//                    break;
//                case PARAMETER:
//                    ModelMethodData mdata=ElementData.<ModelMethodData>createElement(keyAndType.methodEl,helper);
//                    key=mdata.getKey();
//                    if (!containsElement(key))
//                        putElement(key, mdata);
//                    retType=new ModelParamEntry();
//                    helper.analyzer.assembleParamStructure(retType,keyAndType.varEl);
//                    ret=new ModelParamData(keyAndType,retType,mdata);
//                    key = ret.getKey();
//                    if (!containsElement(key))
//                        putElement(key, ret);
//                    break;
//            }
//        }
//        return (T) ret;
//    }
//
//    private static ElRet getKeyAndType(Element el) {
//        ElRet ret = new ElRet();
//        ret.kind = el.getKind();
//
////        String key=null;
//        switch (ret.kind) {
//            case PACKAGE:
//                ret.pEl = (PackageElement) el;
//                ret.key = ret.pEl.getQualifiedName().toString();
//                break;
//            case CLASS:
//            case INTERFACE:
//
//                ret.clzEl = (TypeElement) el;
//                ret.pEl = (PackageElement) ret.clzEl.getEnclosingElement();
//                ret.key = ret.clzEl.getQualifiedName().toString();
//                break;
//            case METHOD: {
//                Element enclosingElement = el.getEnclosingElement();
//                ret.clzEl = (TypeElement) enclosingElement;
//                ret.pEl = (PackageElement) ret.clzEl.getEnclosingElement();
//                ret.methodEl = (ExecutableElement) el;
//                ret.key = ret.clzEl.getQualifiedName().toString() + "#" + ret.methodEl.getSimpleName().toString();
//            }
//            break;
//            case FIELD: {
//                Element enclosingElement = el.getEnclosingElement();
//                ret.clzEl = (TypeElement) enclosingElement;
//                ret.pEl = (PackageElement) ret.clzEl.getEnclosingElement();
//
//                ret.varEl = (VariableElement) el;
//
//                ret.key = ret.clzEl.getQualifiedName().toString() + "-" + ret.varEl.getSimpleName().toString();
//            }
//            break;
//            case PARAMETER: {
//                ret.varEl = (VariableElement) el;
//                ret.methodEl = (ExecutableElement) ret.varEl.getEnclosingElement();
//                ret.clzEl = (TypeElement) ret.methodEl.getEnclosingElement();
//                ret.pEl = (PackageElement) ret.clzEl.getEnclosingElement();
//                ret.key = ret.clzEl.getQualifiedName().toString() + "#" + ret.methodEl + "-" + ret.varEl.getSimpleName().toString();
//            }
//            break;
//        }
//        return ret;
//    }

    //    Element el;
    final transient String key;
    final transient ElementKind kind;
    final transient TypeElement clzEl;
    final transient ExecutableElement methodEl;
    final transient VariableElement varEl;
    final transient PackageElement pEl;
    final transient String name;
    final transient String comment;

    Integer id;


    protected ElementData(ElRet el) {
        key = el.key;
        kind = el.kind;
        clzEl = el.clzEl;
        methodEl = el.methodEl;
        varEl = el.varEl;
        pEl = el.pEl;
        name=el.name;
        comment=el.comment;
//        ElementKind kind = el.getKind();
//        TypeElement clzEl;
//        ExecutableElement methodEl;
//        VariableElement varEl;
//        String key=null;
//        switch (kind) {
//            case CLASS:
//            case INTERFACE:
//                clzEl = (TypeElement) el;
//                key = clzEl.getQualifiedName().toString();
//                break;
//            case METHOD: {
//                Element enclosingElement = el.getEnclosingElement();
//                clzEl = (TypeElement) enclosingElement;
//                methodEl = (ExecutableElement) el;
//                key = clzEl.getQualifiedName().toString() + "#" + methodEl.getSimpleName().toString();
//            }
//            break;
//            case FIELD: {
//                Element enclosingElement = el.getEnclosingElement();
//                clzEl=(TypeElement)enclosingElement;
//                varEl = (VariableElement) el;
//                key=clzEl.getQualifiedName().toString()+"-"+varEl.getSimpleName().toString();
//            }
//            break;
//            case PARAMETER: {
//                varEl = (VariableElement) el;
//                methodEl=(ExecutableElement) varEl.getEnclosingElement();
//                clzEl=(TypeElement) methodEl.getEnclosedElements();
//                key = clzEl.getQualifiedName().toString()+"#"+methodEl+"-"+varEl.getSimpleName().toString();
//            }
//            break;
//        }
//        this.comment = comment;
    }

    public String getKey() {
        return key;
    }


    public ElementKind getKind() {
        return kind;
    }


    public TypeElement getClzEl() {
        return clzEl;
    }


    public ExecutableElement getMethodEl() {
        return methodEl;
    }


    public VariableElement getVarEl() {
        return varEl;
    }


    public Integer getId() {
        return id;
    }

    public T setId(Integer id) {
        this.id = id;
        return (T) this;
    }

    public String getComment() {
        return comment;
    }

    public String getName() {
        return name;
    }

    //    public T setComment(String comment) {
//        this.comment = comment;
//        return (T) this;
//    }
}
