package com.shawn.ss.gen.clz_analyze_handlers;

import com.shawn.ss.gen.Helpers;
import com.shawn.ss.gen.model.class_structure.ModelClazzStructureEntry;
import com.shawn.ss.gen.model.class_structure.ModelParamEntry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.lang.model.element.*;

public class ElementBuilder {

    static final Logger L= LoggerFactory.getLogger(ElementBuilder.class);

    public static <T extends ElementData> T createElement(Element el, Helpers helper) {
        ElRet keyAndType = getKeyAndType(el);
        ElementData ret = null;
        if (ElementData.containsElement(keyAndType.key)) {
            ret = ElementData.getElement(keyAndType.key);
        } else {
            keyAndType.comment = helper.elementUtils.getDocComment(el);
            keyAndType.name=el.getSimpleName().toString();
            L.debug("handle el:{},{},{}",keyAndType.name,keyAndType.kind,keyAndType.key);
            String key=null;
            ModelClzData clzData;
            ModelParamEntry retType;
            switch (keyAndType.kind) {
                case PACKAGE:
                    ret = new ModelPackageData(keyAndType);
                    key = ret.getKey();
                    if (!ElementData.containsElement(key))
                        ElementData.putElement(key, ret);
                    break;
                case CLASS:
                case INTERFACE:
                    ModelPackageData pelData = ElementBuilder.<ModelPackageData>createElement(keyAndType.pEl, helper);
                    key = pelData.getKey();
                    if (!ElementData.containsElement(key))
                        ElementData.putElement(key, pelData);
                    ModelClazzStructureEntry entry = new ModelClazzStructureEntry();
                    helper.analyzer.assembleClazzStructure(entry, keyAndType.clzEl);
                    ret = new ModelClzData(keyAndType, pelData, entry);
                    key = ret.getKey();
                    if (!ElementData.containsElement(key))
                        ElementData.putElement(key, ret);
                    break;
                case METHOD:
                    clzData =ElementBuilder.<ModelClzData>createElement(keyAndType.clzEl,helper);
                    key=clzData.getKey();
                    if (!ElementData.containsElement(key))
                        ElementData.putElement(key, clzData);

                    retType = new ModelParamEntry();
                    helper.analyzer.assembleParamStructure(retType,keyAndType.methodEl);
                    ret=new ModelMethodData(keyAndType,clzData,retType);
                    key = ret.getKey();
                    if (!ElementData.containsElement(key))
                        ElementData.putElement(key, ret);
                    break;
                case FIELD:
                    clzData=ElementBuilder.<ModelClzData>createElement(keyAndType.clzEl,helper);
                    key=clzData.getKey();
                    if (!ElementData.containsElement(key))
                        ElementData.putElement(key, clzData);
                    retType=new ModelParamEntry();
                    helper.analyzer.assembleParamStructure(retType,keyAndType.varEl);
                    ret=new ModelFieldData(keyAndType,retType,clzData);
                    key = ret.getKey();
                    if (!ElementData.containsElement(key))
                        ElementData.putElement(key, ret);
                    break;
                case PARAMETER:
                    ModelMethodData mdata=ElementBuilder.<ModelMethodData>createElement(keyAndType.methodEl,helper);
                    key=mdata.getKey();
                    if (!ElementData.containsElement(key))
                        ElementData.putElement(key, mdata);
                    retType=new ModelParamEntry();
                    helper.analyzer.assembleParamStructure(retType,keyAndType.varEl);
                    ret=new ModelParamData(keyAndType,retType,mdata);
                    key = ret.getKey();
                    if (!ElementData.containsElement(key))
                        ElementData.putElement(key, ret);
                    break;
            }
        }
        return (T) ret;
    }

//    static class ElRet {
//        String key;
//        ElementKind kind;
//        TypeElement clzEl;
//        ExecutableElement methodEl;
//        VariableElement varEl;
//        PackageElement pEl;
//        String name;
//        String comment;
//    }

    private static ElRet getKeyAndType(Element el) {
        ElRet ret = new ElRet();
        ret.kind = el.getKind();

//        String key=null;
        switch (ret.kind) {
            case PACKAGE:
                ret.pEl = (PackageElement) el;
                ret.key = ret.pEl.getQualifiedName().toString();
                break;
            case CLASS:
            case INTERFACE:

                ret.clzEl = (TypeElement) el;
                ret.pEl = (PackageElement) ret.clzEl.getEnclosingElement();
                ret.key = ret.clzEl.getQualifiedName().toString();
                break;
            case METHOD: {
                Element enclosingElement = el.getEnclosingElement();
                ret.clzEl = (TypeElement) enclosingElement;
                ret.pEl = (PackageElement) ret.clzEl.getEnclosingElement();
                ret.methodEl = (ExecutableElement) el;
                ret.key = ret.clzEl.getQualifiedName().toString() + "#" + ret.methodEl.getSimpleName().toString();
            }
            break;
            case FIELD: {
                Element enclosingElement = el.getEnclosingElement();
                ret.clzEl = (TypeElement) enclosingElement;
                ret.pEl = (PackageElement) ret.clzEl.getEnclosingElement();

                ret.varEl = (VariableElement) el;

                ret.key = ret.clzEl.getQualifiedName().toString() + "-" + ret.varEl.getSimpleName().toString();
            }
            break;
            case PARAMETER: {
                ret.varEl = (VariableElement) el;
                ret.methodEl = (ExecutableElement) ret.varEl.getEnclosingElement();
                ret.clzEl = (TypeElement) ret.methodEl.getEnclosingElement();
                ret.pEl = (PackageElement) ret.clzEl.getEnclosingElement();
                ret.key = ret.clzEl.getQualifiedName().toString() + "#" + ret.methodEl + "-" + ret.varEl.getSimpleName().toString();
            }
            break;
        }
        return ret;
    }
}
