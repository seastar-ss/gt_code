package com.shawn.ss.lib.tools.db.api.interfaces.mappers;

public interface _ObjMapper {

    <T extends _ObjMapper> T getFeature(Class<T> clazz);

}
