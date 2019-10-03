package com.shawn.ss.lib.tools.sql_code_gen.api;

public interface SQLInsert extends SQL<SQLInsert> {
    SQLInsert onDuplicateUpdateItem(String column,String expression);
    SQLInsert modifyItem(String column,String expression);
    SQLInsert modifyItem(String column);
    SQLInsert batchInsert(int batch);
    SQLInsert removeAllModifyItem();
    SQLInsert setIgnore(boolean ignore);
}
