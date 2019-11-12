package com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;

import java.util.List;
import java.util.Map;

public interface SimpleDbInterface extends NamedParameterJdbcOperations {

    public static enum SQLExecuteStatus{
        INIT,
        RET_EXCEPTION,RET_TIMEOUT,RET_SQL_ERR,
        RET_HAS_RESULT,RET_HAS_NO_RESULT,
        RET_UPDATE_EFFECTIVE,RET_UPDATE_NO_EFFECT,
        RET_NO_RETURN,
    }

    Long insert(String sql, Map<String, Object> param);
    int batchInsert(String sql, List<Map<String, Object>> params);

    SQLExecuteStatus execute(String sql, Map<String,Object> param);
}
