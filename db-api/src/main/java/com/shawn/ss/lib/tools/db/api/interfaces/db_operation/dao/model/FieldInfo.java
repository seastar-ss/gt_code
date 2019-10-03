package com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model;

import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.FieldInfoInterface;

public class FieldInfo implements FieldInfoInterface{
    String fieldName;
    FieldDataTypeInterface type;
    String comment;
    String defaultValue;
    EnumTypeDef enumTypeDef;

    public String getFieldName() {
        return fieldName;
    }

    public FieldInfo setFieldName(String fieldName) {
        this.fieldName = fieldName;
        return this;
    }

    public FieldDataTypeInterface getType() {
        return type;
    }

    public FieldInfo setType(FieldDataTypeInterface type) {
        this.type = type;
        return this;
    }

    public String getComment() {
        return comment;
    }

    public FieldInfo setComment(String comment) {
        this.comment = comment;
        return this;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public FieldInfo setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
        return this;
    }

    public EnumTypeDef getEnumTypeDef() {
        return enumTypeDef;
    }

    public FieldInfo setEnumTypeDef(EnumTypeDef enumTypeDef) {
        this.enumTypeDef = enumTypeDef;
        return this;
    }
}
