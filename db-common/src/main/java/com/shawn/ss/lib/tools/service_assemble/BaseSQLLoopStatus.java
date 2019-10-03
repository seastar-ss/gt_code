package com.shawn.ss.lib.tools.service_assemble;

import com.shawn.ss.lib.tools.CollectionHelper;

import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * Created by ss on 2018/10/5.
 */
public class BaseSQLLoopStatus implements SQLLoopStatus {

    int index;
    Map<String,Object> params;

    public BaseSQLLoopStatus() {
        this(0);
    }

    public BaseSQLLoopStatus(int index) {
        this.index = index;
        this.params= CollectionHelper.newMap();
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
        return params.size();
    }

    public boolean isParamEmpty() {
        return params.isEmpty();
    }

    public Object getParam(Object key) {
        return params.get(key);
    }

    public Object putParam(String key, Object value) {
        return params.put(key, value);
    }

    public void putAllParam(Map<? extends String, ?> m) {
        params.putAll(m);
    }

    public void clearParam() {
        params.clear();
    }

    public Set<String> paramKeySet() {
        return params.keySet();
    }

    public void increaseIndex(){
        index++;
    }

    @Override
    public Map<String, Object> getAdditionalParams() {
        return params;
    }
}
