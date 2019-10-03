package com.shawn.ss.gen;


import com.shawn.ss.lib.tools.structure.LoopStatus;

import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.Element;

/**
 * Created by ss on 2016/9/21.
 */ //    private static final Logger logger = Logger.getLogger(AuthGenProcessor.class.getName());
//    private static final TimeStats timeStats = new TimeStats();
public interface ClassHandler {
    void handleClass(RoundEnvironment env, Helpers helpers, Element element, LoopStatus loopStatus);
    void afterHandleAllElement(RoundEnvironment env, Helpers helpers, LoopStatus loopStatus);
    void finishHandle(RoundEnvironment env, Helpers helpers, LoopStatus status);
    void beforeHandle(RoundEnvironment env, Helpers helpers,LoopStatus status);


}
