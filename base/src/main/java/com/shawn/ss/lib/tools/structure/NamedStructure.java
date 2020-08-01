package com.shawn.ss.lib.tools.structure;

public interface NamedStructure {
    boolean isSameType(NamedStructure str);
    String getName();

    String getDescription();
}
