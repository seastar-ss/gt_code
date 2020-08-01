package com.shawn.ss.lib.tools.structure;

import com.shawn.ss.lib.tools.StringHelper;

public class NamedThreadLocal<T> extends ThreadLocal<T> implements NamedStructure {
    private final String name;

    public NamedThreadLocal(String name) {
//        Assert.hasText(name, "Name must not be empty");
        if(StringHelper.isEmpty(name)){
            throw new IllegalArgumentException("Name must not be empty");
        }
        this.name = name;
    }

    public String toString() {
        return this.name;
    }

    @Override
    public boolean isSameType(NamedStructure str) {
        return false;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return "this class work for name the thread local";
    }


}