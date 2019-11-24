package com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model;

public interface FieldDataTypeInterface {
    Class gettClass();

    String getTClassName();

    boolean isCollection();

    boolean isMap();

    boolean isArray();

    String getKeyClassName();

    Class getKeyClass();

    String[] getDataType();

    String getObtainMethod();

    String name();

    Object getDefaultValue();
}
