package com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao;

import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model.TableInfo;

import java.util.List;

public interface DbInfoInterface {
    String getDbName();

    List<TableInfoInterface> getTables();

    TableInfoInterface getTable(String tableName);
}
