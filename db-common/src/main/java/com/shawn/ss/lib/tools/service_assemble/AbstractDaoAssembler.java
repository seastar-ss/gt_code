package com.shawn.ss.lib.tools.service_assemble;

import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model.DataSourceAndSchemaAndTable;
import com.shawn.ss.lib.tools.db.api.interfaces.mappers.db.DbResultSetMapper;
import com.shawn.ss.lib.tools.db.dto_base.model.AbstractBaseModel;
import com.shawn.ss.lib.tools.sql_code_gen.api.SQL;

import java.util.List;
import java.util.Map;

/**
 * Created by ss on 2018/10/5.
 */
public abstract class AbstractDaoAssembler implements DaoAssembler {

    protected final boolean isMultiple;

    protected AbstractDaoAssembler(boolean isMultiple){
        this.isMultiple = isMultiple;
    }

    @Override
    public int assembleSql(SQL sql, Map<String, Object> params, Class<? extends AbstractBaseModel> tClazz) {
        return 0;
    }

    @Override
    public int assembleSql(SQL sql, List<Map<String, Object>> params, Class<? extends AbstractBaseModel> tClazz) {
        return 0;
    }

    @Override
    public <T extends AbstractBaseModel> DbResultSetMapper<T> assembleResultSetMapper(Map<String, Object> params, Class<T> tClazz) {
        return null;
    }

    @Override
    public DataSourceAndSchemaAndTable selectDb(SQL sql, Map<String, Object> params, Class<? extends AbstractBaseModel> tClazz) {
        return null;
    }

    @Override
    public DataSourceAndSchemaAndTable selectDb(SQL sql, List<Map<String, Object>> params, Class<? extends AbstractBaseModel> tClazz) {
        return null;
    }

    @Override
    public boolean isMultiple() {
        return isMultiple;
    }
}
