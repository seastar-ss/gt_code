package com.shawn.ss.gen.code_build_handlers;


import com.helger.jcodemodel.JCodeModel;
import com.shawn.ss.lib.code_gen.base.helper.ModelBuilderContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by ss on 2016/10/4.
 */
public abstract class AbstractCodeGenerator {

    static final Logger L= LoggerFactory.getLogger(AbstractCodeGenerator.class);

    static final Map<String, ModelBuilderContext> allContext;

    //    private final ModelBuilderContext context;

    static  volatile  boolean inited=false;

    static String basePos;
    static JCodeModel cm;


    public static void setBasePos(String basePos) {
        AbstractCodeGenerator.basePos = basePos;
    }

    public static void setCm(JCodeModel cm) {
        AbstractCodeGenerator.cm = cm;
    }

    static {
        allContext = new ConcurrentHashMap<String, ModelBuilderContext>();
    }
//    protected String basePackPosition;
//
//
//    protected static final class GeneratedResult {
//        JDefinedClass clazz;
//        Element topElement;
//
//        public GeneratedResult(JDefinedClass clazz, Element topElement) {
//            this.clazz = clazz;
//            this.topElement = topElement;
//        }
//    }


    public AbstractCodeGenerator() {

    }

//    public AbstractCodeGenerator(String basePos, JCodeModel cm) {
//        this.basePos = basePos;
//        this.cm = cm;
//    }

    public static ModelBuilderContext getContextByPack(String pack) {
        return allContext.get(pack);
    }

    public static void setContext(ModelBuilderContext context, String pack) {
        allContext.put(pack, context);
    }

    public abstract void genCode();

    public abstract void beforeWriteCode() throws IOException;

//    public ModelBuilderContext getContext() {
//        return context;
//    }

//    public void register(JDefinedClass clazz, Element el) {
//        CodeModelHolder.register(clazz, el);
//    }
//
//    public AbstractCodeGenerator(String basePackPosition) {
//        this.basePackPosition = basePackPosition;
//        cm = CodeModelHolder.getCm();
//    }

    public void writeCode() throws IOException {
        L.info("base pos:{}",basePos);
        File file = new File(basePos==null?"./":basePos);
        if (file.exists() || file.mkdirs()) {
//                L.info("code will in folder:{}", file.getAbsolutePath());
            cm.build(file);
        } else {
//                L.info("can't buildBaseModelAndDao folder:{}", file.getAbsolutePath());
            throw new FileNotFoundException("找不到代码文件夹，或无法建立代码文件夹");
        }

    }
}
