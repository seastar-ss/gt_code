package com.shawn.ss.lib.tools.sql_code_gen.api;

public interface SQLUpdate extends SQL<SQLUpdate> {
    SQLUpdate modifyItem(String column,String expression);
    SQLUpdate modifyItem(String column);
    SQLUpdate removeAllModifyItem();
}
