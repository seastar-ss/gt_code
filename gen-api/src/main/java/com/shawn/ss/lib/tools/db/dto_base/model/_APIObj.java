package com.shawn.ss.lib.tools.db.dto_base.model;

public interface _APIObj {

    <T extends _APIObj> T getFeature(Class<T> clazz);

}
