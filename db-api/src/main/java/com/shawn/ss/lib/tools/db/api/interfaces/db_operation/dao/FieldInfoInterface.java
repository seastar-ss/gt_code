package com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao;

import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model.EnumTypeDef;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model.FieldDataTypeInterface;

public interface FieldInfoInterface {
    String getFieldName();

    FieldDataTypeInterface getType();

    String getComment();

    EnumTypeDef getEnumTypeDef();

    String getDefaultValue();
}
