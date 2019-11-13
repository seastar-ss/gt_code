package com.shawn.ss.lib.tools.db.impl.utils;

import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.SimpleDbInterface;
import com.shawn.ss.lib.tools.db.api.utils.TableCreateHelper;

import java.util.Collections;
import java.util.regex.Pattern;

public class TableCreateHelperImpl implements TableCreateHelper {
    private final SimpleDbInterface dbInterface;

    final static Pattern tablePattern = Pattern.compile("[a-z_0-9\\.]+");

    public TableCreateHelperImpl(SimpleDbInterface dbInterface) {
        this.dbInterface = dbInterface;
    }

    @Override
    public String createTable(String originTable, String appendix) {
        if (tablePattern.matcher(originTable).matches() && tablePattern.matcher(appendix).matches()) {
            String tableName = originTable + appendix;
            SimpleDbInterface.SQLExecuteStatus execute = dbInterface.execute(
                    "create table if not exists " + tableName + " like " + originTable,
                    Collections.emptyMap()
            );
            if (execute.isException()) {
                throw new IllegalStateException("sql not execute properly");
            }
            return tableName;
        } else {
            throw new IllegalArgumentException("table name " + originTable + appendix + " is illegal");
        }
//        return null;
    }

    @Override
    public boolean checkTableExist(String tableName) {
        if (tablePattern.matcher(tableName).matches()) {
            SimpleDbInterface.SQLExecuteStatus check = dbInterface.execute("show tables like :table;", Collections.singletonMap("table", tableName));
            if (check.isException()) {
                throw new IllegalStateException("sql not execute properly");
            }
            return (check == SimpleDbInterface.SQLExecuteStatus.RET_HAS_RESULT);
        } else {
            throw new IllegalArgumentException("table name " + tableName + " is illegal");
        }
    }
}
