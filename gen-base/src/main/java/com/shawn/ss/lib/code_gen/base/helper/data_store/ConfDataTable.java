package com.shawn.ss.lib.code_gen.base.helper.data_store;

import com.shawn.ss.lib.code_gen.model.def_model.dao_def._BaseDaoConfImpl;
import com.shawn.ss.lib.tools.CollectionHelper;

import java.util.Map;
import java.util.Set;

public class ConfDataTable {
    public static final Map<String,_BaseDaoConfImpl> ALL_CONF= CollectionHelper.newMap();

    public static int size() {
        return ALL_CONF.size();
    }

    public static _BaseDaoConfImpl get(Object key) {
        return ALL_CONF.get(key);
    }

    public static _BaseDaoConfImpl put(String key, _BaseDaoConfImpl value) {
        return ALL_CONF.put(key, value);
    }

    public static Set<String> keySet() {
        return ALL_CONF.keySet();
    }
}
