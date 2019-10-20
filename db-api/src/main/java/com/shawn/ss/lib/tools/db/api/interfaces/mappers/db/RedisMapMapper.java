package com.shawn.ss.lib.tools.db.api.interfaces.mappers.db;


import com.shawn.ss.lib.tools.db.dto_base.model.AbstractBaseModel;

import java.util.Map;

/**
 * Created by ss on 2017/12/16.
 */
public interface RedisMapMapper<T extends AbstractBaseModel>  {
    T fromMap(Map<byte[], byte[]> map);
    Map<byte[], byte[]> toMap(T obj);

    Map<String,Object> toCommonMap(T obj);
    T fromCommonMap(Map<String,Object> obj);

//    <TT> TT mapField(String field, byte[] bs);
    void setField(String field,T dto, byte[] bs);
    <TT> TT getField(String field, T dto);
    public<TT> void setField(String field, T instance, TT value);
}
