package com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao;

import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model.FieldDataTypeInterface;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model.EnumTypeDef;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model.TableInfo;

import java.util.Properties;

public interface ColumnInfoInterface extends FieldInfoInterface {



    String getExtra();

    boolean isNullable();

    boolean isPrime();

    boolean isUnique();

    boolean isReferer();

    boolean isIndexed();

    boolean isAutoIncreament();

    String getCharSet();

    long getCharLength();

    int getPrecision();

    Properties getExtraInfo();

    TableInfo getInfo();

}
