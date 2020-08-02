package com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model;

import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.FieldInfoInterface;

public class FieldInfo implements FieldInfoInterface {
    String fieldName;
    FieldDataTypeInterface type;
    String comment;
    Object defaultValue;
    EnumTypeDef enumTypeDef;
    String aliasFieldName;
    boolean isStatic = false;

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

    public Object getDefaultValue() {
        return defaultValue;
    }

    @Override
    public String getAliasField() {
        return aliasFieldName == null ? fieldName : aliasFieldName;
    }

    @Override
    public boolean isStatic() {
        return isStatic;
    }

    public FieldInfo setDefaultValue(Object defaultValue) {
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

    public FieldInfo setStatic(boolean aStatic) {
        isStatic = aStatic;
        return this;
    }

//    public String getAliasFieldName() {
//        return aliasFieldName;
//    }

    public FieldInfo setAliasFieldName(String aliasFieldName) {
        this.aliasFieldName = aliasFieldName;
        return this;
    }
}
