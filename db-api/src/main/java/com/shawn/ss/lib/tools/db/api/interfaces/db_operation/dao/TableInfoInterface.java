package com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao;

import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model.*;

import java.util.List;

/**
 * Created by ss on 2017/10/10.
 */
public interface TableInfoInterface {

    String getTable();

    String getDb();

    String[] getTableColumnNames();

    String getPriKey();

    FieldDataTypeInterface getPriKeyType();

    FieldInfoInterface getPriKeyInfo();

    List<ColumnInfoInterface> getColumns();

    TableInfo getTableInfo();

    List<IndexInfo> getIndexes();

    List<TableReferInfo> getReferFromTable();

    List<TableReferInfo> getReferToTable();

    FieldDataTypeInterface getColumnDataType(String colName);

    ColumnInfoInterface getColumnData(String colName);

    int getTableType();

    String getTableComment();

    String getCharset();

    int getColumnCount();



//    TableInfoInterface setTableType(int tableType);
}
