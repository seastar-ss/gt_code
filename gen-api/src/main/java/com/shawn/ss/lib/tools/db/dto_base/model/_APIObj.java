package com.shawn.ss.lib.tools.db.dto_base.model;

public interface _APIObj {
    /**
     * factory method
     * @param clazz
     * @param <T>
     * @return
     */
    <T extends _APIObj> T buildFeatureInstance(Class<T> clazz);

}
