package com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface SimpleDbInterface extends NamedParameterJdbcOperations {

    public static enum SQLExecuteStatus{
        INIT(false,false),
        RET_EXCEPTION(true,false),RET_TIMEOUT(true,false),RET_SQL_ERR(true,false),
        RET_HAS_RESULT(false,true),RET_HAS_NO_RESULT(false,true),
        RET_UPDATE_EFFECTIVE(false,false),RET_UPDATE_NO_EFFECT(false,false),
        RET_NO_RETURN(false,false);
        private final boolean exception;
        private final boolean query;

        private SQLExecuteStatus(boolean exception, boolean isQuery){
            this.exception = exception;
            query = isQuery;
        }

        public boolean isException() {
            return exception;
        }

        public boolean isQuery() {
            return query;
        }
    }
    Long insert(String sql, Map<String, Object> param);
    int batchInsert(String sql, List<Map<String, Object>> params);

    SQLExecuteStatus execute(String sql, Map<String,Object> param);
}
