package com.shawn.ss.lib.code_gen.base.helper.data_store;

import com.shawn.ss.gen.model.class_structure.ModelClazzStructureEntry;
import com.shawn.ss.lib.tools.CollectionHelper;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

public class AnalyzedClzDataTable {
    private static final Map<String,ModelClazzStructureEntry> ALL_ANALYZED_CLASS=
            Collections.synchronizedMap(CollectionHelper.<String,ModelClazzStructureEntry>newSortedMap());

    public static int size() {
        return ALL_ANALYZED_CLASS.size();
    }

    public static boolean isEmpty() {
        return ALL_ANALYZED_CLASS.isEmpty();
    }

    public static boolean containsKey(Object key) {
        return ALL_ANALYZED_CLASS.containsKey(key);
    }

    public static boolean containsValue(Object value) {
        return ALL_ANALYZED_CLASS.containsValue(value);
    }

    public static ModelClazzStructureEntry get(Object key) {
        return ALL_ANALYZED_CLASS.get(key);
    }

    public static ModelClazzStructureEntry put(String key, ModelClazzStructureEntry value) {
        return ALL_ANALYZED_CLASS.put(key, value);
    }

    public static Set<String> keySet() {
        return ALL_ANALYZED_CLASS.keySet();
    }

    public static Collection<ModelClazzStructureEntry> values() {
        return ALL_ANALYZED_CLASS.values();
    }


}
