package com.shawn.ss.gen;


import com.helger.jcodemodel.JCodeModel;
import com.shawn.ss.gen.tools.clzAnalyzer.ClassAnalyze;
import com.shawn.ss.lib.code_gen.base.helper.CodeConstants;
import com.shawn.ss.lib.code_gen.base.helper.DBConnectionHelper;
import com.shawn.ss.lib.tools.CollectionHelper;
import com.shawn.ss.lib.tools.StringHelper;
import com.shawn.ss.lib.tools.TypeConstantHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.lang.model.element.*;
import javax.lang.model.type.*;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;
import javax.tools.Diagnostic;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * Created by ss on 2016/10/1.
 */
public class Helpers {
    public static final Logger L= LoggerFactory.getLogger("codeBuilder");

    public static final String DB_PROPERTIES = "app";
    public static final String DOC_PROPERTIES = "doc";
    public static final String DB_PROPERTY_OF_ALL_DATA_SOURCE = "all.datasources";
    //    public static final String APP_PROPERTIES = "app";
    public final Types typeUtils;
    public final Elements elementUtils;
    public final Filer filer;
    public final Messager messager;
    public final ClassAnalyze analyzer;
    public final Map<String, String> options;
    public final Map<String, Properties> p;
    final String OBJECT_NAME = Object.class.getName();
    public Properties doc;
    //        public ApplicationContext context;
    private Map<String, DBConnectionHelper> conns;


    public Helpers(Types typeUtils, Elements elementUtils, Filer filer, Messager messager, Map<String, String> options, Map<String, Properties> p) {
        this.typeUtils = typeUtils;
        this.elementUtils = elementUtils;
        this.filer = filer;
        this.messager = messager;
        this.options = options;
        this.p = p;
        conns = CollectionHelper.newMap(32);
//            String contextConfig = options.get("context.xml");
//            context = new FileSystemXmlApplicationContext(contextConfig);
        analyzer = new ClassAnalyze(this);
    }

    public void error(Element e, String msg, Object... args) {
        messager.printMessage(
                Diagnostic.Kind.ERROR,
                String.format(msg, args),
                e);
    }

    public void warn(Element e, String msg, Object... args) {
        messager.printMessage(
                Diagnostic.Kind.WARNING,
                String.format(msg, args),
                e);
    }

    public void info(Element e, String msg, Object... args) {
        messager.printMessage(
                Diagnostic.Kind.NOTE,
                String.format(msg, args),
                e);
    }

    public final void println(Object... args) {
        String msg = StringHelper.concat(args);
       L.info(msg);
    }

    public final void println(Object args) {
//        String msg = StringHelper.concat(args);
        L.info(args == null ? "" : args.toString());
    }

//        public ApplicationContext getContext() {
//            return context;
//        }

//        public Helpers setContext(ApplicationContext context) {
//            this.context = context;
//            return this;
//        }

//        public void initContext() {
//            AnnotationConfigApplicationContext ctx =
//                    new AnnotationConfigApplicationContext();
//            ctx.register(CompilorContextConfiguration.class);
//            ctx.refresh();
////            ctx.scan("com.cs.ss.gen");
//            context = ctx;
//        }

    public DBConnectionHelper getConn() {
        return getConn(CodeConstants.KEY_WORD_DEFAULT_DATA_SOURCE_ID);
    }

    public DBConnectionHelper getConn(String dsName) {
        final DBConnectionHelper conn = conns.get(dsName);
        if (conn == null) {
            throw new IllegalStateException("数据库未配置:" + dsName);
        }
        return conn;
    }

    //
    Helpers initConn() {
        if (!containsProperties(DB_PROPERTIES)) {
//            throw new IllegalArgumentException("未配置数据库参数");
            println("\n****************\n未配置数据库参数\n*************");
        } else {
            final Properties dbProperties = p.get(DB_PROPERTIES);
            final String allDataSource = dbProperties.getProperty(Constants.DB_PROPERTY_OF_ALL_DATA_SOURCE);
            if (!StringHelper.isEmpty(allDataSource)) {
                final String[] split = allDataSource.split(",");
                for (String ds : split) {
                    if (StringHelper.isEmpty(ds)) {
                        ds = CodeConstants.KEY_WORD_DEFAULT_DATA_SOURCE_ID;
                    }
                    conns.put(ds, new DBConnectionHelper(ds, dbProperties));
                }
            } else {
                this.conns.put(CodeConstants.KEY_WORD_DEFAULT_DATA_SOURCE_ID, new DBConnectionHelper(dbProperties));
            }
        }
        return this;
    }


    public Element asElement(TypeMirror asType) {
        Element element = null;
        if (asType != null) {
            TypeKind kind = asType.getKind();
            if (kind.isPrimitive()) {
                element = typeUtils.boxedClass((PrimitiveType) asType);
//                element = typeUtils.asElement(element1);
            } else if (kind.equals(TypeKind.WILDCARD) || kind.equals(TypeKind.INTERSECTION)) {
                WildcardType asWildcardType = (WildcardType) asType;
                Element tEl = typeUtils.asElement(asWildcardType);
                println("typed element", tEl.getKind());
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

    public Object asObject(String defaultValue, TypeMirror type) {
        if (type != null) {
            TypeKind kind = type.getKind();
            String clz = type.toString();
            Element el = asElement(type);
            TypeMirror cType = null;
            TypeKind cTypeKind = null;
            String cClz = null;

            if (el != null) {
                cType = el.asType();
                cTypeKind = cType.getKind();
            }

            if (kind.isPrimitive() || TypeConstantHelper.BASIC_DATA_CLASS_NAMES.contains(clz)) {
                return TypeConstantHelper.testAndUppackPrimitiveType(defaultValue, clz);
            } else if (el != null && cTypeKind.isPrimitive()) {

            }
        }
        return null;
    }



    public boolean containsProperties(Object key) {
        return p.containsKey(key);
    }

    public Properties getProperties(Object key) {
        return p.get(key);
    }

    protected volatile JCodeModel cm;

    public List<Element> getAllElemtsOfType(TypeElement el) {
//        Map<String,Element> ret=CollectionHelper.newMap();
        List<Element> list = CollectionHelper.newList(100);
        while(el!=null){
            List<? extends Element> elements = el.getEnclosedElements();
            list.addAll(elements);
            TypeMirror typeMirror = el.getSuperclass();
            if(typeMirror!=null){
                TypeElement sel = (TypeElement)typeUtils.asElement(typeMirror);
                if(sel!=null && !sel.getQualifiedName().toString().equals(OBJECT_NAME)){
                    el=sel;
                }else{
                    break;
                }
            }else{
                break;
            }
        }
//        for(Element e:list){
//            ret.put(e.getSimpleName().toString(),e);
//        }
        return list;
    }


    protected static final class CodeModelHolder {
        static final JCodeModel cm = new JCodeModel();
//        static volatile List<GeneratedResult> list;
//
//        static void register(JDefinedClass clazz, Element el) {
//            if (list == null) {
//                synchronized (CodeModelHolder.class) {
//                    if (list == null) {
//                        list = CollectionHelper.newList();
//                    }
//                }
//            }
//            list.add(new GeneratedResult(clazz, el));
//        }

        public static JCodeModel getCm() {
            return cm;
        }

    }

    public JCodeModel getCm() {
        if (cm == null) {
            cm = CodeModelHolder.getCm();
        }
        return cm;
    }
}
