package com.shawn.ss.lib.code_gen.base.helper.data_store;

import com.shawn.ss.lib.code_gen.model.def_model._BaseConfImpl;
import com.shawn.ss.lib.tools.CollectionHelper;

import java.util.Map;
import java.util.Set;

public class ConfDataTable {
    public static final Map<String,_BaseConfImpl> ALL_CONF= CollectionHelper.newMap();

    public static int size() {
        return ALL_CONF.size();
    }

    public static _BaseConfImpl get(Object key) {
        return ALL_CONF.get(key);
    }

    public static _BaseConfImpl put(String key, _BaseConfImpl value) {
        return ALL_CONF.put(key, value);
    }

    public static Set<String> keySet() {
        return ALL_CONF.keySet();
    }
}
