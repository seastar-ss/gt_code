package com.shawn.ss.gen.model;

import javax.lang.model.element.Element;

/**
 * Created by ss on 2016/9/19.
 */
public abstract class AnnotatedElements {


    protected final Element annotatedClassElement;

//    private String[] urls;

    public AnnotatedElements(Element classElement) throws IllegalArgumentException {
        this.annotatedClassElement = classElement;

    }

    public Element getAnnotatedClassElement() {
        return annotatedClassElement;
    }


}
