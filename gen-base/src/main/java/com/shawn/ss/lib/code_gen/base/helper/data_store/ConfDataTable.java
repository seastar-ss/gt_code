package com.shawn.ss.lib.code_gen.base.helper.data_store;

import com.shawn.ss.lib.code_gen.model.def_model.dao_def._BaseDaoConfImpl;
import com.shawn.ss.lib.code_gen.model.def_model.interfaces._BaseContextConf;
import com.shawn.ss.lib.tools.CollectionHelper;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ConfDataTable {
    public static final Map<String,_BaseContextConf> ALL_CONF= new ConcurrentHashMap<>();

    public static int size() {
        return ALL_CONF.size();
    }

    public static _BaseContextConf get(Object key) {
        return ALL_CONF.get(key);
    }

    public static _BaseContextConf put(String key, _BaseContextConf value) {
        return ALL_CONF.put(key, value);
    }

    public static Set<String> keySet() {
        return ALL_CONF.keySet();
    }
}
