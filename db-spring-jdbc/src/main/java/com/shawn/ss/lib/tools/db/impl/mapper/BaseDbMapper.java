package com.shawn.ss.lib.tools.db.impl.mapper;

import com.shawn.ss.lib.tools.db.api.interfaces.mappers.db.DbResultSetMapper;
import com.shawn.ss.lib.tools.db.api.utils.ResultSetHelper;
import com.shawn.ss.lib.tools.db.dto_base.model.AbstractBaseModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

public abstract class BaseDbMapper<T extends AbstractBaseModel> implements org.springframework.jdbc.core.RowMapper<T>, DbResultSetMapper<T> {

    T instance;

    @Override
    public T mapRow(ResultSet rs, int rowNum) throws SQLException {
        Set<String> allColumns = ResultSetHelper.getAllColumns(rs);
        if(instance==null) {
            return mapRow(rs, rowNum, allColumns);
        }else{
            return mapRow(instance,rs,rowNum,allColumns);
        }
    }

    @Override
    public T getInstance() {
        return instance;
    }

    @Override
    public void setInstance(T instance) {
        this.instance = instance;
    }
}
