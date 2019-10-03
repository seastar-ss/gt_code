package com.shawn.ss.lib.tools.db.api.interfaces.mappers.db;

import com.shawn.ss.lib.tools.db.api.interfaces.mappers._ObjMapper;
import com.shawn.ss.lib.tools.db.api.interfaces.mappers.dao_mapper.ResultSetRowToModelMapper;
import com.shawn.ss.lib.tools.db.dto_base.model.AbstractBaseModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

public interface DbResultSetMapper<T extends AbstractBaseModel> extends ResultSetRowToModelMapper<T> {
    T mapRow(ResultSet rs, int rowNum, Set<String> columnNames) throws SQLException;

    T mapRow(T instance, ResultSet rs, int rowNum, Set<String> columnNames) throws SQLException;

    T getInstance();

    void setInstance(T instance);
}
