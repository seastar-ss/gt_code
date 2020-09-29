package com.shawn.ss.lib.tools.service_assemble;

import com.shawn.ss.lib.tools.CollectionHelper;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * Created by ss on 2018/10/5.
 */
public class BaseSQLLoopStatus implements SQLLoopStatus {

    volatile int index;
    volatile Map<String, Object> params;

    public BaseSQLLoopStatus() {
        this(0);
    }

    public BaseSQLLoopStatus(int index) {
        this.index = index;
    }

    @Override
    public int getIndex() {
        return index;
    }

    public BaseSQLLoopStatus setIndex(int index) {
        this.index = index;
        return this;
    }

    public int paramSize() {
        if (params == null) return 0;
        return params.size();
    }

    public boolean isParamEmpty() {
        if (params == null) return true;
        return params.isEmpty();
    }

    public Object getParam(Object key) {
        if (params == null) return null;
        return params.get(key);
    }

    public Object putParam(String key, Object value) {
        testAndBuildParams();
        return params.put(key, value);
    }

    public void putAllParam(Map<? extends String, ?> m) {
        testAndBuildParams();
        params.putAll(m);
    }

    private void testAndBuildParams() {
        if (params == null) {
            synchronized (this) {
                params = CollectionHelper.newMap();
            }
        }
    }

    public void clearParam() {
        if (params != null)
            params.clear();
    }

    public Set<String> paramKeySet() {
        if (params == null) return Collections.emptySet();
        return params.keySet();
    }

    public void increaseIndex() {
        index++;
    }

    @Override
    public Map<String, Object> getAdditionalParams() {
        return params;
    }
}
