package com.shawn.ss.lib.tools.db.api.interfaces.mappers.db;


import com.shawn.ss.lib.tools.db.dto_base.model.AbstractBaseModel;
import com.shawn.ss.lib.tools.db.dto_base.model._APIObj;

import java.util.Map;

/**
 * Created by ss on 2017/12/16.
 */
public interface CommonMapMapper<T extends AbstractBaseModel> extends _APIObj {
    T fromMap(Map<byte[], byte[]> map);

    T fromCommonMap(Map<String, Object> obj);

    Map<byte[], byte[]> toMap(T obj);

    Map<String, Object> toCommonMap(T obj);

    <TT> TT getField(String field, T dto);

    void setField(String field, T dto, byte[] bs);

    <TT> void setField(String field, T instance, TT value);

    @Override
    default <T extends _APIObj> T buildFeatureInstance(Class<T> clazz) {
        return (T) this;
    }
}
