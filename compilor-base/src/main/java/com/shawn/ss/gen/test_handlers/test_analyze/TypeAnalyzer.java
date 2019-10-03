package com.shawn.ss.gen.test_handlers.test_analyze;

import com.google.gson.Gson;
import com.shawn.ss.gen.ClassHandler;
import com.shawn.ss.gen.Helpers;
import com.shawn.ss.gen.api.interfaces.test.ClzElAnalyzeTest;
import com.shawn.ss.gen.model.class_structure.ModelParamEntry;
import com.shawn.ss.lib.tools.StringHelper;
import com.shawn.ss.lib.tools.structure.LoopStatus;

import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;

/**
 * Created by ss on 2018/7/8.
 */
public class TypeAnalyzer implements ClassHandler {
    public TypeAnalyzer(Class<ClzElAnalyzeTest> clzElAnalyzeTestClass) {
    }

    Gson gson=new Gson();

    @Override
    public void handleClass(RoundEnvironment env, Helpers helpers, Element element, LoopStatus loopStatus) {
        if(element.getKind().equals(ElementKind.PARAMETER)) {
            ModelParamEntry entry=new ModelParamEntry();
            helpers.analyzer.assembleParamStructure(entry,element);
            helpers.println(gson.toJson(entry));
        }
    }

    @Override
    public void afterHandleAllElement(RoundEnvironment env, Helpers helpers, LoopStatus loopStatus) {

    }

    @Override
    public void finishHandle(RoundEnvironment env, Helpers helpers, LoopStatus status) {

    }

    @Override
    public void beforeHandle(RoundEnvironment env, Helpers helpers, LoopStatus status) {

    }
}
