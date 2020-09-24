package com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model;

import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.FieldInfoInterface;

public class FieldInfo<T extends FieldInfo> implements FieldInfoInterface {
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

    public T setFieldName(String fieldName) {
        this.fieldName = fieldName;
        return (T)this;
    }

    public FieldDataTypeInterface getType() {
        return type;
    }

    public T setType(FieldDataTypeInterface type) {
        this.type = type;
        return (T)this;
    }

    public String getComment() {
        return comment;
    }

    public T setComment(String comment) {
        this.comment = comment;
        return (T)this;
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

    public T setDefaultValue(Object defaultValue) {
        this.defaultValue = defaultValue;
        return (T)this;
    }

    public EnumTypeDef getEnumTypeDef() {
        return enumTypeDef;
    }

    public T setEnumTypeDef(EnumTypeDef enumTypeDef) {
        this.enumTypeDef = enumTypeDef;
        return (T)this;
    }

    public T setStatic(boolean aStatic) {
        isStatic = aStatic;
        return (T)this;
    }

//    public String getAliasFieldName() {
//        return aliasFieldName;
//    }

    public T setAliasFieldName(String aliasFieldName) {
        this.aliasFieldName = aliasFieldName;
        return (T)this;
    }
}
