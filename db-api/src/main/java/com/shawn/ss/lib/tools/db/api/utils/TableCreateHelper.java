package com.shawn.ss.lib.tools.db.api.utils;

public interface TableCreateHelper {
    String createTable(String originTable,String appendix);
    boolean checkTableExist(String tableName);
}
