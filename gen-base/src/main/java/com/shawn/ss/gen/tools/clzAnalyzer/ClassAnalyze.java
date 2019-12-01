package com.shawn.ss.gen.tools.clzAnalyzer;

import com.shawn.ss.gen.Helpers;
import com.shawn.ss.gen.base.data_store.AnalyzedClzDataTable;
import com.shawn.ss.gen.model.class_structure.ModelClazzStructureEntry;
import com.shawn.ss.gen.model.class_structure.ModelParamEntry;
import com.shawn.ss.lib.tools.CodeStyleTransformHelper;
import com.shawn.ss.lib.tools.CollectionHelper;
import com.shawn.ss.lib.tools.TypeConstantHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.lang.model.element.*;
import javax.lang.model.type.*;
import javax.lang.model.util.Types;
import java.util.*;

public class ClassAnalyze {

    public static final Logger L = LoggerFactory.getLogger(ClassAnalyze.class);

    Helpers helpers;

    final TypeMirror ROOT_TYPE, COLLECTION_TYPE, MAP_TYPE, SET_TYPE, LIST_TYPE, INT_TYPE, LONG_TYPE, DOUBLE_TYPE,
            STRING_TYPE, DATE_TYPE;
    final String ROOT_CLZ_NAME;

    static {

    }

    public ClassAnalyze(Helpers helpers) {
        this.helpers = helpers;
        ROOT_TYPE = helpers.elementUtils.getTypeElement(Object.class.getName()).asType();
        COLLECTION_TYPE = helpers.elementUtils.getTypeElement(Collection.class.getName()).asType();
        MAP_TYPE = helpers.elementUtils.getTypeElement(Map.class.getName()).asType();
        SET_TYPE = helpers.elementUtils.getTypeElement(Set.class.getName()).asType();
        LIST_TYPE = helpers.elementUtils.getTypeElement(List.class.getName()).asType();
        INT_TYPE = helpers.elementUtils.getTypeElement(Integer.class.getName()).asType();
        LONG_TYPE = helpers.elementUtils.getTypeElement(Long.class.getName()).asType();
        DOUBLE_TYPE = helpers.elementUtils.getTypeElement(Double.class.getName()).asType();
        STRING_TYPE = helpers.elementUtils.getTypeElement(String.class.getName()).asType();
        DATE_TYPE = helpers.elementUtils.getTypeElement(Date.class.getName()).asType();
        ROOT_CLZ_NAME = Object.class.getName();
        helpers.println(TypeConstantHelper.BASIC_DATA_CLASS_NAMES);
    }

    public void assembleParamStructure(ModelParamEntry ret, Element el) {
        AnalyzeContext context = new AnalyzeContext();
        context.setRoot(ret).setCurrentParamModel(ret);
        context.setRootEl(el).setCurrentEl(el);
        anaylyzeParam(context);
    }

    public void assembleClazzStructure(ModelClazzStructureEntry clzStructure, Element el) {
        AnalyzeContext context = new AnalyzeContext();
        if (el instanceof TypeElement) {
            context.setRootEl(el).setCurrentEl(el).setCurrentClzEl((TypeElement) el);
            context.setRootClz(clzStructure).setCurrentClzModel(clzStructure);
            analyzeClz(context);
        }
    }

    protected void anaylyzeParam(AnalyzeContext context) {
        Element el = context.getCurrentElement();
        ModelParamEntry ret = context.getCurrentParamModel();
        String name = null;
//        Object dValue = null;
        Object constantValue = null;
        VariableElement varEl = null;
        boolean isMethod = false;
//        ModelParamEntry.ArrayType arrayType = null;
//        ModelClazzStructureEntry retClz=new ModelClazzStructureEntry();
        switch (el.getKind()) {
            case FIELD:
            case LOCAL_VARIABLE:
            case PARAMETER:
                varEl = (VariableElement) el;
                name = varEl.getSimpleName().toString();
                constantValue = varEl.getConstantValue();
                break;
            case METHOD:
                isMethod = true;
                break;
            default:
                throw new IllegalStateException("此类型的元素无法获取类结构");
        }
        final String docComment = helpers.elementUtils.getDocComment(el);
        ret.setParamName(name).setContantValue(constantValue).setDesp(docComment);
        ModelClazzStructureEntry clzStructure = ret.getClz();
        context.setRootClz(clzStructure).setCurrentClzModel(clzStructure);
        TypeMirror type = isMethod ? ((ExecutableElement) el).getReturnType() : el.asType();
        context.setCurrentTypeMirror(type);
        analyzeParamEnclosingElement(context);
        analyzeType(context);

//        ret.setArrayType(arrayType);
//        assembleClazzStructure(retClz,defaultValue,el);
//        ret.setClz(retClz);
//        ret.setDefaultValue(dValue);
//        ret.setDataType();

//        return ret;
//        if (AnalyzedClzDataTable.containsKey(clazzName)) {
//            ret.setClz(clazzName);
//        } else {
//            ModelClazzStructureEntry clzStructure = ret.getClz();
//            assembleClazzStructure(clzStructure, realType);
//            ret.setClz(clzStructure);
//        }
    }

    protected void analyzeParamEnclosingElement(AnalyzeContext context) {
        Element el = context.getCurrentElement();
        ElementKind kind = el.getKind();

        TypeElement clzElement = null;
        if (kind.equals(ElementKind.PARAMETER)) {
            Element enclosingElement = el.getEnclosingElement();
            if (enclosingElement instanceof ExecutableElement) {
                ExecutableElement element = (ExecutableElement) enclosingElement;
                context.setCurrentEnclosingMethod(element);
                List<? extends TypeParameterElement> typeParameters = element.getTypeParameters();
                for (TypeParameterElement item : typeParameters) {
                    context.putWType(item.getSimpleName().toString(), item.asType());
                }
            }
            Element clzEl = enclosingElement.getEnclosingElement();
            if (clzEl instanceof TypeElement) {
                clzElement = (TypeElement) clzEl;
            }
        } else if (kind.equals(ElementKind.FIELD)) {
            Element clzEl = el.getEnclosingElement();
            if (clzEl instanceof TypeElement) {
                clzElement = (TypeElement) clzEl;
            }
        } else if (kind.equals(ElementKind.METHOD)) {
            Element clzEl = el.getEnclosingElement();
            if (clzEl instanceof TypeElement) {
                clzElement = (TypeElement) clzEl;
            }
            ExecutableElement element = (ExecutableElement) el;
            context.setCurrentEnclosingMethod(element);
            List<? extends TypeParameterElement> typeParameters = element.getTypeParameters();
            for (TypeParameterElement item : typeParameters) {
                context.putWType(item.getSimpleName().toString(), item.asType());
            }
        }
        if (clzElement != null) {
            List<? extends TypeParameterElement> typeParameters = clzElement.getTypeParameters();
            for (TypeParameterElement item : typeParameters) {
                context.putWType(item.getSimpleName().toString(), item.asType());
            }
        }
    }

    protected void analyzeClz(AnalyzeContext context) {
        TypeElement el = context.currentClzEl;
        if (el == null) {
            return;
        }
        ModelClazzStructureEntry ret = context.getCurrentClzStructure();
//        TypeElement typeEl=null;
        String clzName = el.getQualifiedName().toString();
        if (clzName.equals(ROOT_CLZ_NAME)) {
            helpers.println("find root element of type analyze:" + clzName + "  of " + context.getCurrentParamModel());
            ret.setClzName(ROOT_CLZ_NAME)
                    .setDataType(ModelClazzStructureEntry.DataType.objectClassType)
                    .setSimple(false).setSimpleClz(false);
            return;
        } else if (TypeConstantHelper.BASIC_DATA_CLASS_NAMES.contains(clzName)) {
            helpers.println("find terminate element of type analyze:" + clzName + "  of " + context.getCurrentParamModel());
            ret.setClzName(clzName)
                    .setDataType(ModelClazzStructureEntry.DataType.commonDataType)
                    .setSimple(true).setSimpleClz(true);
            return;
        }//else
        helpers.println("find composed element of type analyze:" + clzName + "  of " + context.getCurrentParamModel());

        ElementKind kind = el.getKind();
        ModelClazzStructureEntry.DataType dtType = null;
        switch (kind) {
            case INTERFACE:
                dtType = ModelClazzStructureEntry.DataType.interfaceType;
                break;
            case CLASS:
                dtType = ModelClazzStructureEntry.DataType.classType;
                break;
            case ENUM:
                dtType = ModelClazzStructureEntry.DataType.enumType;
                break;
            case ANNOTATION_TYPE:
                dtType = ModelClazzStructureEntry.DataType.annotationType;
                break;
            default:
                throw new IllegalStateException("此类型的元素无法获取类结构");
        }
        final String docComment = helpers.elementUtils.getDocComment(el);
        ret.setClzName(clzName).setDataType(dtType).setDesp(docComment);
        if (kind.equals(ElementKind.CLASS) || kind.equals(ElementKind.INTERFACE)) {
            List<Element> elements = helpers.getAllElemtsOfType(el);
//            Set<? extends Map.Entry<String, ? extends Element>> entries = elements.entrySet();
            Map<String, TypeMirror> availableFields = CollectionHelper.newSortedMap();
            for (Element entry : elements) {
                Element e = entry;
                String nameStr = entry.getSimpleName().toString();
                ElementKind elkind = e.getKind();
                if (elkind == ElementKind.METHOD) {
                    ExecutableElement member = (ExecutableElement) e;

                    if (!TypeConstantHelper.IGNORE_METHOD_NAME.contains(nameStr)) {
                        helpers.println("inspect el:", nameStr);
                        Set<Modifier> modifiers = member.getModifiers();
                        if (
                                !modifiers.contains(Modifier.ABSTRACT)
                                        && !modifiers.contains(Modifier.STATIC)
                                        && modifiers.contains(Modifier.PUBLIC)
                                        && nameStr.startsWith("set")
                                ) {
                            List<? extends VariableElement> parameters = member.getParameters();
                            if (parameters != null && parameters.size() == 1) {
                                availableFields.put(
                                        CodeStyleTransformHelper.lowerFirstCase(nameStr.replace("set", "")),
                                        parameters.get(0).asType());
                            }
                        } else if (
                                !modifiers.contains(Modifier.ABSTRACT)
                                        && !modifiers.contains(Modifier.STATIC)
                                        && modifiers.contains(Modifier.PUBLIC)
                                        && nameStr.startsWith("get")
                                ) {
                            List<? extends VariableElement> parameters = member.getParameters();
                            if (parameters != null && parameters.size() == 0) {
                                availableFields.put(
                                        CodeStyleTransformHelper.lowerFirstCase(nameStr.replace("get", "")),
                                        member.getReturnType()
                                );
                            }
                        }
                    }
                } else if (elkind == ElementKind.FIELD) {

                }
            }

            for (Element entry : elements) {
                Element e = entry;
                String nameStr = entry.getSimpleName().toString();
                ElementKind elkind = e.getKind();
                if (elkind == ElementKind.FIELD) {
                    VariableElement member = (VariableElement) e;
                    if (availableFields.containsKey(nameStr)) {
                        TypeMirror typeOfSet = availableFields.get(nameStr);
                        TypeMirror typeOfField = member.asType();
                        if (helpers.typeUtils.isSameType(typeOfSet, typeOfField)) {

                            AnalyzeContext newContext = new AnalyzeContext();
                            ModelParamEntry sub = new ModelParamEntry();
                            newContext.setRoot(context.root).setCurrentParamModel(sub);
                            newContext.setRootEl(context.rootEl).setCurrentEl(member);
                            newContext.parentTypeVars.putAll(context.parentTypeVars);
                            anaylyzeParam(newContext);
                            ret.putChildren(nameStr, sub);
                        }
                    }
                }
            }

        } else if (kind.equals(ElementKind.ENUM)) {
            List<? extends Element> elements = el.getEnclosedElements();
            for (Element e : elements) {
                ElementKind elkind = e.getKind();
                if (elkind.equals(ElementKind.ENUM_CONSTANT)) {
                    ret.addEnumConstant(e.getSimpleName().toString());
                }
            }
            ret.setSimple(true);
        }
        ret.judgeSimpleClz();
        AnalyzedClzDataTable.put(clzName, ret);
        return;
    }

    protected void analyzeType(AnalyzeContext context) {

        ModelClazzStructureEntry clz = context.getCurrentClzStructure();
        ModelParamEntry model = context.getCurrentParamModel();

        TypeMirror type = context.currentTypeMirror;
        Element currentElement = context.getCurrentElement();

        TypeMirror realType = null;
        ModelParamEntry.ArrayType arrayType = null;
        TypeElement typeEl = null;

        TypeKind kind = type.getKind();

        List<ModelParamEntry.ArrayInfo> arrays = model.getArrayType();
//        List<ModelClazzStructureEntry> keyClz = model.getKeyClz();
        if (ROOT_TYPE.equals(type)) {
//            model.setSimple(false);
            clz.setClzName(ROOT_CLZ_NAME).setDataType(ModelClazzStructureEntry.DataType.objectClassType).setSimple(false).setSimpleClz(false);
            return;
        }

        switch (kind) {
            case INT:
            case BYTE:
            case CHAR:
            case LONG:
            case FLOAT:
            case DOUBLE:
            case BOOLEAN:
            case SHORT:
                TypeElement tEl = helpers.typeUtils.boxedClass((PrimitiveType) type);
                clz.setSimple(true).setSimpleClz(true);
                clz.setClzName(tEl.getQualifiedName().toString());
                clz.setDataType(ModelClazzStructureEntry.DataType.commonDataType);
                break;

            case DECLARED:
                DeclaredType dtype = (DeclaredType) type;
                typeEl = (TypeElement) helpers.typeUtils.asElement(type);
//                String clzName = typeEl.getQualifiedName().toString();

//                final ElementKind elKind = typeEl.getKind();

                List<? extends TypeMirror> typeArguments = dtype.getTypeArguments();
//                if(Object.class.toString().equals(clzName)) {
//                    model.setSimple(false);
//                    clz.setClzName(clzName);
//                    clz.setDataType(ModelClazzStructureEntry.DataType.objectClassType);
//                }else
                final TypeMirror typeErasure = helpers.typeUtils.erasure(type);
                final boolean collectionAssignable = helpers.typeUtils.isAssignable(typeErasure, COLLECTION_TYPE);
                final boolean mapAssignable = helpers.typeUtils.isAssignable(typeErasure, MAP_TYPE);
                final int typeParamSize = typeArguments.size();
                helpers.println(" ****** el is  ", mapAssignable, " & ", collectionAssignable, " & ", typeParamSize);
                helpers.println(" ****** typeVar is  ", typeArguments);
                if (collectionAssignable) {
                    ModelClazzStructureEntry keyEntry;
                    keyEntry = new ModelClazzStructureEntry()
                            .setClzName(Integer.class.getName()).setDataType(ModelClazzStructureEntry.DataType.classType);
                    if (typeParamSize == 1) {

                        if (helpers.typeUtils.isAssignable(typeErasure, LIST_TYPE)) {
                            arrayType = ModelParamEntry.ArrayType.list;

                        } else if (helpers.typeUtils.isAssignable(typeErasure, SET_TYPE)
                                ) {
                            arrayType = ModelParamEntry.ArrayType.set;
                        } else {
                            arrayType = ModelParamEntry.ArrayType.collection;
                        }
                        realType = typeArguments.get(0);

                    } else {
                        helpers.warn(currentElement, "错误，%s 元素未设定模板参数类型", currentElement.getSimpleName().toString());
                        realType = ROOT_TYPE;
//                        throw new IllegalStateException("Collection类型元素需要设置模板类型");
                    }
//                    keyClz.add(keyEntry);
                    arrays.add(new ModelParamEntry.ArrayInfo().setKeyType(keyEntry).setType(arrayType));
                    model.setArrayType(arrays);
                    context.setCurrentTypeMirror(realType);
                    analyzeType(context);
                } else if (mapAssignable) {
                    if (typeParamSize == 2) {

                        TypeMirror typeMirror = typeArguments.get(0);
                        Element element = asElement(typeMirror);
                        TypeKind mapKeyKind = null;//typeMirror.getKind();
                        ModelClazzStructureEntry keyEntry = new ModelClazzStructureEntry();
                        if (typeMirror.getKind().equals(TypeKind.TYPEVAR)) {
                            String typeVarName = element.getSimpleName().toString();
                            if (context.containsTVKey(typeVarName)) {
                                typeMirror = context.getTVType(typeVarName);
                            }
                        }
                        mapKeyKind = typeMirror.getKind();
                        if (mapKeyKind.equals(TypeKind.DECLARED)) {
                            element = helpers.typeUtils.asElement(typeMirror);
                            arrayType = getMapArrayType((DeclaredType) typeMirror);

                            TypeElement ttEl = (TypeElement) element;
                            final String keyClzName = ttEl.getQualifiedName().toString();
                            keyEntry.setClzName(keyClzName)
                                    .setDataType(ModelClazzStructureEntry.DataType.classType);
                            arrays.add(new ModelParamEntry.ArrayInfo().setKeyType(keyEntry).setType(arrayType));
//                            keyClz.add(keyEntry);
//                            model.setKeyClz(keyClz);

                        } else {
                            arrays.add(
                                    new ModelParamEntry.ArrayInfo()
                                            .setKeyType(null)
                                            .setType(ModelParamEntry.ArrayType.otherMap)
                            );
//                            throw new IllegalStateException("未知的map key类型 ");
                        }

//                        model.set
                        realType = typeArguments.get(1);

                    } else {
                        helpers.warn(currentElement, "错误，%s 元素未设定模板参数类型", currentElement.getSimpleName().toString());
                        arrays.add(
                                new ModelParamEntry.ArrayInfo()
                                        .setKeyType(null)
                                        .setType(ModelParamEntry.ArrayType.otherMap)
                        );
                        realType = ROOT_TYPE;
//                        throw new IllegalStateException("Map类型元素需要设置模板类型");
                    }
                    model.setArrayType(arrays);
                    context.setCurrentTypeMirror(realType);
                    analyzeType(context);
                } else {
                    String clzName = typeEl.getQualifiedName().toString();
                    if (AnalyzedClzDataTable.containsKey(clzName)) {
                        model.setClz(clzName);
                    } else {
                        context.setCurrentClzEl(typeEl);
                        if (typeParamSize > 0) {
                            analyzeTypeParam(context);
                        }
                        analyzeClz(context);
                    }
                }
                break;
            case TYPEVAR:
                TypeVariable tType = (TypeVariable) type;
                Element element = tType.asElement();
                String typeVarName = element.getSimpleName().toString();
                if (context.containsTVKey(typeVarName)) {
                    realType = context.getTVType(typeVarName);
                } else if (context.containsWKey(typeVarName)) {
                    realType = context.getWType(typeVarName);
                } else {
                    realType = ROOT_TYPE;
                }
                context.setCurrentTypeMirror(realType);
                analyzeType(context);
                break;
            case WILDCARD:
                WildcardType wType = (WildcardType) type;
                realType = wType.getExtendsBound();
                if (realType == null) {
                    realType = ROOT_TYPE;
                }
                context.setCurrentTypeMirror(realType);
                analyzeType(context);
                break;
            case ARRAY:
                ArrayType asArrayType = (ArrayType) type;
                realType = asArrayType.getComponentType();
                arrayType = ModelParamEntry.ArrayType.array;
                ModelClazzStructureEntry keyEntry = new ModelClazzStructureEntry()
                        .setClzName(Integer.class.getName()).setDataType(ModelClazzStructureEntry.DataType.classType);
//                keyClz.add(keyEntry);
                arrays.add(new ModelParamEntry.ArrayInfo().setKeyType(keyEntry).setType(arrayType));
                model.setArrayType(arrays);
                context.setCurrentTypeMirror(realType);
                analyzeType(context);
                break;
            default:
//                realType = type;
                break;
        }
//        if(typeEl!=null) {
////        TypeElement typeEl = (TypeElement) helpers.typeUtils.asElement(realType);
//            context.setCurrentEl(typeEl).setCurrentTypeMirror(type);
//            analyzeClz(context);
//        }
//        return new TypePair().setArrayType(arrayType).setType(realType);
    }

    private Element asElement(TypeMirror asType) {
        Element element = null;
        Types typeUtils = helpers.typeUtils;
        if (asType != null) {
            TypeKind kind = asType.getKind();
            if (kind.isPrimitive()) {
                element = typeUtils.boxedClass((PrimitiveType) asType);
//                element = typeUtils.asElement(element1);
            } else if (kind.equals(TypeKind.WILDCARD)
//                    || kind.equals(TypeKind.INTERSECTION)
                    ) {
                WildcardType asWildcardType = (WildcardType) asType;
                Element tEl = typeUtils.asElement(asWildcardType);
                L.info("typed element", tEl.getKind());
            } else if (kind.equals(TypeKind.ARRAY)) {
//                isArray = true;
                ArrayType asArrayType = (ArrayType) asType;
                element = typeUtils.asElement(asArrayType.getComponentType());
            } else if (kind.equals(TypeKind.DECLARED)) {
                DeclaredType dtype = (DeclaredType) asType;
                List<? extends TypeMirror> typeArguments = dtype.getTypeArguments();
                Element els = typeUtils.asElement(dtype);
                TypeElement cel = (TypeElement) els;
                String paramClass = cel.getQualifiedName().toString();
                if (TypeConstantHelper.COLLECTION_CLASS_NAMES.contains(paramClass)) {
//                    paramElement.setSimple(false);
                    if (typeArguments.size() == 1) {
                        TypeMirror mirror = typeArguments.get(0);
                        if (mirror != null) {
                            element = typeUtils.asElement(mirror);
                        }
//                        else
//                            element = elementUtils.getTypeElement(Object.class.getName());
                    }
//                    else {
//                        element = elementUtils.getTypeElement(Object.class.getName());
//                    }
                }
//                TypeElement collectionType = helpers.elementUtils.getTypeElement(ArrayList.class.getName());
//                if (helpers.typeUtils.isAssignable(asType, collectionType.asType())) {
//                helpers.println("collection based param:", helpers.typeUtils.isAssignable(collectionType.asType(), asType), " ", element.getSimpleName().toString());
//                }
//                helpers.typeUtils.
            }
        }
        return element;
    }

    private ModelParamEntry.ArrayType getMapArrayType(DeclaredType type) {
        if (helpers.typeUtils.isAssignable(type, INT_TYPE)) {
            return ModelParamEntry.ArrayType.intMap;
        } else if (helpers.typeUtils.isAssignable(type, LONG_TYPE)) {
            return ModelParamEntry.ArrayType.longMap;
        } else if (helpers.typeUtils.isAssignable(type, DOUBLE_TYPE)) {
            return ModelParamEntry.ArrayType.doubleMap;
        } else if (helpers.typeUtils.isAssignable(type, STRING_TYPE)) {
            return ModelParamEntry.ArrayType.stringMap;
        } else if (helpers.typeUtils.isAssignable(type, DATE_TYPE)) {
            return ModelParamEntry.ArrayType.dateMap;
        }

        return ModelParamEntry.ArrayType.otherMap;
    }

    protected void analyzeTypeParam(AnalyzeContext context) {
        TypeMirror type = context.currentTypeMirror;
        DeclaredType dtype = (DeclaredType) type;
        TypeElement clzEl = context.currentClzEl;
        List<? extends TypeParameterElement> varParameters = clzEl.getTypeParameters();
        List<? extends TypeMirror> typeVariable = dtype.getTypeArguments();
//        Map<String, TypeMirror> types = CollectionHelper.newMap();
        if (varParameters != null && typeVariable != null) {
            int n = varParameters.size();
            int m = typeVariable.size();
            helpers.println("type variables count:", n, m);
            if (n == m) {
                for (int i = 0; i < n; ++i) {
                    TypeParameterElement el = varParameters.get(i);
                    TypeMirror mi = typeVariable.get(i);
                    String name = el.getSimpleName().toString();
                    context.putTVType(name, mi);
                    helpers.println("put map:", name, " ", mi.toString());
                }
            }
        }
    }
}
