package com.shawn.ss.lib.tools.service_assemble;

import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model.DataSourceAndSchemaAndTable;
import com.shawn.ss.lib.tools.db.api.interfaces.mappers.db.DbResultSetMapper;
import com.shawn.ss.lib.tools.db.dto_base.model.AbstractBaseModel;
import com.shawn.ss.lib.tools.sql_code_gen.api.SQL;


import java.util.List;
import java.util.Map;

public interface DaoAssembler {

    int assembleSql(SQL sql, Map<String, Object> params, Class<? extends AbstractBaseModel> tClazz);

    int assembleSql(SQL sql, List<Map<String, Object>> params, Class<? extends AbstractBaseModel> tClazz);
//    void assembleSqlParam(Map<String,Object> params,Class<? extends AbstractBaseModel> tClazz);
    <T extends AbstractBaseModel> DbResultSetMapper<T> assembleResultSetMapper(Map<String, Object> params,Class<T> tClazz);

    boolean isMultiple();

    DataSourceAndSchemaAndTable selectDb(SQL sql, Map<String, Object> params, Class<? extends AbstractBaseModel> tClazz);

    DataSourceAndSchemaAndTable selectDb(SQL sql, List<Map<String, Object>> params, Class<? extends AbstractBaseModel> tClazz);
}
