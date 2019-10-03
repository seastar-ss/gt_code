package com.shawn.ss.gen.clz_analyze_handlers;

import com.google.gson.Gson;
import com.shawn.ss.gen.ClassHandler;
import com.shawn.ss.gen.Helpers;
import com.shawn.ss.gen.api.interfaces.doc.EntryPoint;
import com.shawn.ss.gen.model.class_structure.ModelParamEntry;
import com.shawn.ss.lib.tools.CollectionHelper;
import com.shawn.ss.lib.tools.StringHelper;
import com.shawn.ss.lib.tools.TypeConstantHelper;
import com.shawn.ss.lib.tools.http.OHttpHelper;
import com.shawn.ss.lib.tools.structure.LoopStatus;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.VariableElement;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * Created by ss on 2018/7/8.
 */
public class TypeAnalyzer implements ClassHandler {

    static final Logger L = LoggerFactory.getLogger(TypeAnalyzer.class);

    public TypeAnalyzer(Class<EntryPoint> clzElAnalyzeTestClass) {

    }

    static Set<String> ignoreMethod = CollectionHelper.<String>setBuilder()
            .add("<init>")
            .add("<clinit>")
            .addAll(TypeConstantHelper.IGNORE_METHOD_NAME)
            .getSet();

    DataReporterInterface reporter=new DataReporter();


    @Override
    public void handleClass(RoundEnvironment env, Helpers helpers, Element element, LoopStatus loopStatus) {

        handle(element, helpers);
    }

    private ElementData handle(Element element, Helpers helpers) {

        ElementKind kind = element.getKind();
        ElementData elementData = null;
        if (kind == ElementKind.PACKAGE) {
            final ModelPackageData p = ElementBuilder.createElement(element, helpers);
            List<? extends Element> list = element.getEnclosedElements();
            L.info("get package list:{}", list.size());
            if (!CollectionHelper.isCollectionEmpty(list)) {
                list.forEach(it -> {
//                    ModelClzData item = ElementData.createElement(it, helpers);
                    final ModelClzData handle = (ModelClzData) handle(it, helpers);
                    p.putClz(handle.key, handle);
                });
            }
            elementData = p;
        } else if (kind == ElementKind.CLASS || kind == ElementKind.INTERFACE) {
            ModelClzData item = ElementBuilder.createElement(element, helpers);
            List<? extends Element> list = element.getEnclosedElements();
            if (!CollectionHelper.isCollectionEmpty(list)) {
                for (Element el : list) {
                    String name = el.getSimpleName().toString();
                    if (el.getKind() == ElementKind.METHOD && !ignoreMethod.contains(name)) {
                        ModelMethodData m = (ModelMethodData) handle(el, helpers);
                        item.putMethod(name, m);
                    } else if (el.getKind() == ElementKind.FIELD) {
                        ModelFieldData data = ElementBuilder.createElement(el, helpers);
                        item.putField(name, data);
                    }
                }
            }
            elementData = item;
        } else if (kind == ElementKind.METHOD) {
            ModelMethodData m = ElementBuilder.createElement(element, helpers);
            ExecutableElement el = (ExecutableElement) element;
            List<? extends VariableElement> list = el.getParameters();
            if (!CollectionHelper.isCollectionEmpty(list)) {
                for (Element e : list) {
                    String name = e.getSimpleName().toString();
                    ModelParamData data = ElementBuilder.createElement(e, helpers);
                    m.putParam(name, data);
                }
            }
            elementData = m;
        }
        return elementData;
    }

    @Override
    public void afterHandleAllElement(RoundEnvironment env, Helpers helpers, LoopStatus loopStatus) {

    }

    @Override
    public void finishHandle(RoundEnvironment env, Helpers helpers, LoopStatus status) {
//        final Set<ModelClzData> allClz = ElementData.getAllClz();
        L.info("all keys analyzed:{}", ElementData.analyzedElement.keySet());
//        for (ModelClzData item : allClz) {
//            L.info("clz:{}", item);
//        }
//        final Set<ModelMethodData> allMethod = ElementData.getAllMethod();
//        for (ModelMethodData item : allMethod) {
//            L.info("method:{}", item);
//        }

        Set<ModelPackageData> allPackage = ElementData.getAllPackage();
        for (ModelPackageData dt : allPackage) {
            reportDt(dt,helpers);
        }


    }

    private void reportDt(ModelPackageData dt, Helpers helpers) {
        final String reportUrl = helpers.options.get("report.url");
        if(reportUrl==null){
            throw new IllegalStateException("not report url is set");
        }
        reporter.reportData(reportUrl,dt);
    }

    @Override
    public void beforeHandle(RoundEnvironment env, Helpers helpers, LoopStatus status) {

    }
}
