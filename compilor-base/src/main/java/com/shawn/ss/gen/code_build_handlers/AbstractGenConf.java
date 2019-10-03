package com.shawn.ss.gen.code_build_handlers;

import com.shawn.ss.gen.Helpers;
import com.shawn.ss.gen.model.AnnotatedElements;
import com.shawn.ss.lib.code_gen.base.helper.DBConnectionHelper;
import com.shawn.ss.lib.code_gen.base.helper.ModelBuilderContext;
import com.shawn.ss.lib.tools.StringHelper;

import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by ss on 2018/6/17.
 */
public abstract class AbstractGenConf extends AnnotatedElements {


//    private static volatile ModelBuilderContext contextInstance;


    public AbstractGenConf(Element classElement) throws IllegalArgumentException {
        super(classElement);

    }

    protected ModelBuilderContext findContextByPos(TypeElement typeElement, Helpers helpers) {
        final Element el = typeElement.getEnclosingElement();
        if (el != null && el.getKind() == ElementKind.PACKAGE) {
            PackageElement packEl = (PackageElement) el;
            final String s = packEl.getQualifiedName().toString();
            return findContext(s, helpers);
        } else {
            throw new IllegalArgumentException("不能再此处上增加@SqlResp，找不到外围的package元素");
        }
//        return null;
    }

    protected ModelBuilderContext findContext(String packName, Helpers helpers) {
        if (!StringHelper.isEmpty(packName)) {
            helpers.println("find context in pack:" + packName);
            final ModelBuilderContext contextByPack = AbstractCodeGenerator.getContextByPack(packName);
            if (contextByPack != null) {
                return contextByPack;
            } else {
                final int pos = packName.lastIndexOf(".");
                if(pos>0) {
                    String pPackName = packName.substring(0,pos);
                    return findContext(pPackName, helpers);
                }
            }
        }
        return null;
    }


//    public static synchronized boolean isContextInited(){
//        return contextInstance!=null;
//    }

//    public long addDb(String data_store, DBConnectionHelper conn, Set<String> including, Set<String> excluding) {
//        return context.addDb(data_store, conn, including, excluding);
//    }

    //
//    public static synchronized void setContextInstance(ModelBuilderContext contextInstance) {
//        AbstractGenConf.contextInstance = contextInstance;
//    }


//    public  AbstractGenConf setContext(ModelBuilderContext context) {
//        if(contextInstance==null) {
//            this.context = context;
//            synchronized (AbstractGenConf.class) {
//                contextInstance = context;
//            }
//        }else{
//            this.context=contextInstance;
//        }
//        return this;
//    }

//    public AbstractGenConf setContext() {
//
//        return this;
//    }

//    public static boolean isContextInited() {
//        return contextInstance!=null;
//    }
}
