package com.shawn.ss.gen;

import com.shawn.ss.gen.api.interfaces.SqlMultipleResp;
import com.shawn.ss.gen.api.interfaces.SqlResp;
import com.shawn.ss.gen.api.interfaces.base_resp.DefaultResp;
import com.shawn.ss.gen.api.interfaces.doc.EntryPoint;
import com.shawn.ss.gen.clz_analyze_handlers.TypeAnalyzer;
import com.shawn.ss.gen.code_build_handlers.common_respository.CommonRespositoryHandler;
//import com.shawn.ss.gen.code_build_handlers.mul_dao_conf.SqlMultiDaoHandler;
import com.shawn.ss.gen.code_build_handlers.sql_dao.SqlDaoHandler;
import com.shawn.ss.lib.tools.CollectionHelper;
import com.shawn.ss.lib.tools.StringHelper;
import com.shawn.ss.lib.tools.structure.LoopStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Completion;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import java.io.*;
import java.util.*;

public class GenProcessor extends AbstractProcessor {


    public static final Logger L = LoggerFactory.getLogger(GenProcessor.class);

    final static Map<String, ClassHandler> handlers = CollectionHelper.<String, ClassHandler>mapBuilder()
            .put(DefaultResp.class.getName(), new CommonRespositoryHandler(DefaultResp.class))
            .put(SqlResp.class.getName(), new SqlDaoHandler(SqlResp.class))
//            .put(SqlMultipleResp.class.getName(), new SqlMultiDaoHandler(SqlMultipleResp.class))
            .put(EntryPoint.class.getName(), new TypeAnalyzer(EntryPoint.class))
//            .put(RestController.class.getName(), new CommonControllerHandler(RestController.class))
//            .put(ClzElAnalyzeTest.class.getName(),new TypeAnalyzer(ClzElAnalyzeTest.class))
//            .put(RequestMapping.class.getName(), new TypeAnalyzer(RequestMapping.class))
//            .put(GetMapping.class.getName(), new TypeAnalyzer(GetMapping.class))
//            .put(PostMapping.class.getName(), new TypeAnalyzer(PostMapping.class))
//            .put(PutMapping.class.getName(), new TypeAnalyzer(PutMapping.class))
//            .put(DeleteMapping.class.getName(), new TypeAnalyzer(DeleteMapping.class))
//            .put(SqlRespositoryConfig.class.getName(), new SqlRespHandler(SqlRespositoryConfig.class))
//            .put(ControllerStub.class.getName(), new ControllerStubHandler(ControllerStub.class))
            .getMap();
    final List<String> handlerSequence = CollectionHelper.<String>listBuilder()
            .add(EntryPoint.class.getName())
            .add(DefaultResp.class.getName())
//            .add(ClzElAnalyzeTest.class.getName())
            .add(SqlMultipleResp.class.getName())
            .add(SqlResp.class.getName())
            .getList();

    private static Helpers helper;

    public static Helpers getHelper() {
        return helper;
    }

//    public static void setHelper(Helpers helper) {
//        AuthGenProcessor.helper = helper;
//    }

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        Map<String, String> options = processingEnv.getOptions();
        Map<String, Properties> ps = CollectionHelper.newMap();
        L.info("conf :" + options);

        try {
            String file = options.get("conf.file");
            File base = new File(file);
            System.out.println("load properties from " + base);
            if (base.exists() && base.canRead() && base.isDirectory()) {

                File[] files = base.listFiles(new FileFilter() {
                    @Override
                    public boolean accept(File f) {
                        return f.getName().endsWith(".properties") && f.canRead();
                    }
                });
                System.out.println("load properties:" + Arrays.toString(files));
                for (File f : files) {
                    String fname = f.getName();
//                    helper.println("load properties:", fname);
                    String name = fname.replace(".properties", "");
                    Properties p = new Properties();
                    InputStream in = new FileInputStream(f);
                    p.load(in);
                    System.out.println("conf.file:" + p);
                    ps.put(name, p);
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new IllegalArgumentException("can't load properties file ");
        }
        helper = new Helpers(processingEnv.getTypeUtils(), processingEnv.getElementUtils(), processingEnv.getFiler(), processingEnv.getMessager(), options, ps);
//        helper.setConn(new DBConnection(helper.p));
        helper.initConn();
//        helper.println(options);
//        DbHandler bean = helper.getContext().getBean(DbHandler.class);
//        helper.println(bean);
//        helper.typeUtils = processingEnv.getTypeUtils();
//        helper.elementUtils = processingEnv.getElementUtils();
//        helper.filer = processingEnv.getFiler();
//        helper.messager = processingEnv.getMessager();
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
//        L.w(roundEnv.processingOver();
        Element current = null;
        if (nothingToDo(annotations, roundEnv)) {
            return false;
        }
        try {
            final RoundEnvironment evn = roundEnv;
            int n = handlerSequence.size();
            HandlerLoopStatus loopStatus = new HandlerLoopStatus(n);
            for (int i = 0; i < n; ++i) {
                loopStatus.setIndex(i);
                String handlerName = handlerSequence.get(i);
                ClassHandler classHandler = handlers.get(handlerName);
                L.debug("before handle : {}->{},{}",i,handlerName,classHandler);
                classHandler.beforeHandle(evn, helper, loopStatus);
            }
            L.debug("will handle {} elements with {} handler", annotations.size() ,handlerSequence.size());
            for (int i = 0; i < n; ++i) {
                loopStatus.setIndex(i);
                String handlerName = handlerSequence.get(i);
                helper.println("this round handler:" + handlerName);
                for (TypeElement el : annotations) {
                    String fullTypeName = el.getQualifiedName().toString();
                    L.warn("annotation handle {} with annotationHandler:{}", fullTypeName, handlerName);
                    if (handlerName.equals(fullTypeName)) {
                        helper.println("infos:" + el.getClass().getName() + " " + el.getSimpleName().toString());
                        helper.println("called at ", System.currentTimeMillis());
                        Set<? extends Element> elements = roundEnv.getElementsAnnotatedWith(el);
                        helper.println("get element:" + elements.size());
                        ClassHandler handler = handlers.get(fullTypeName);
                        for (Element e : elements) {
//                ElementKind eKind = e.getKind();
//                if (eKind.isClass()) {
                            current = e;
                            helper.println(StringHelper.concat("element find:", e.getSimpleName().toString()));
                            if (handler != null) {
                                processElements(e, roundEnv, handler, loopStatus);
                            }
//                }
                        }
                        if (handler != null) {
                            handler.afterHandleAllElement(roundEnv, helper, loopStatus);
                        }
                    }
                }
            }
            L.debug("will after handle {} elements with {} handler", annotations.size() ,handlerSequence.size());
            for (int i = 0; i < n; ++i) {

                loopStatus.setIndex(i);
                String handlerName = handlerSequence.get(i);
                ClassHandler classHandler = handlers.get(handlerName);
                L.debug("after handle : {}->{},{}",i,handlerName,classHandler);
                classHandler.finishHandle(evn, helper, loopStatus);
            }
//            CollectionHelper.travelMap(handlers, new CollectionHelper.Traveler<String, ClassHandler>() {
//                @Override
//                public boolean travel(String s, ClassHandler classHandler, int i) {
//
//                    return true;
//                }
//            });
        } catch (Exception ex) {
            ex.printStackTrace();
            helper.error(current, "build exception occurred with msg:%s", ex.getMessage());
        }
        return false;
    }

    private void processElements(Element e, RoundEnvironment roundEnvironment, ClassHandler handler, HandlerLoopStatus loopStatus) {
        handler.handleClass(roundEnvironment, helper, e, loopStatus);
    }

    private boolean nothingToDo(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        return roundEnv.processingOver() || annotations.size() == 0;
    }

    public Set<String> getSupportedOptions() {
        return CollectionHelper.<String>setBuilder().add("conf.file").add("output.file").getSet();
    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        Set<String> keySet = handlers.keySet();
        L.info("support types:{}", keySet);
        return keySet;
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latest();
    }

    @Override
    public Iterable<? extends Completion> getCompletions(Element element, AnnotationMirror annotation, ExecutableElement member, String userText) {
        return super.getCompletions(element, annotation, member, userText);
    }

    private static class HandlerLoopStatus implements LoopStatus {

        volatile int index;
        final int size;

        public HandlerLoopStatus(int n) {
            size = n;
            index = 0;
        }

        public synchronized HandlerLoopStatus setIndex(int index) {
            this.index = index;
            return this;
        }

        @Override
        public int getIndex() {
            return index;
        }

        @Override
        public boolean isFirst() {
            return index == 0;
        }

        @Override
        public boolean isLast() {
            return index == size - 1;
        }
    }
}
