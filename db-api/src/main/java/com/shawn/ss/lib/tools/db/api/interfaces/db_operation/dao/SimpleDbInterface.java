package com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;

import java.util.List;
import java.util.Map;

public interface SimpleDbInterface extends NamedParameterJdbcOperations {
    Long insert(String sql, Map<String, Object> param);
    int batchInsert(String sql, List<Map<String, Object>> params);

    boolean execute(String sql);
}
