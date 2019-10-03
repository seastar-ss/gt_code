package com.shawn.ss.lib.tools.service_assemble;

import com.shawn.ss.lib.tools.db.api.interfaces.mappers.db.DbResultSetMapper;
import com.shawn.ss.lib.tools.db.dto_base.model.AbstractBaseModel;
import com.shawn.ss.lib.tools.sql_code_gen.api.*;

import java.util.List;
import java.util.Map;

public class BaseDaoAssembler extends AbstractDaoAssembler implements DaoAssembler {
    public BaseDaoAssembler() {
        super(false);
    }

    @Override
    public int assembleSql(SQL statement,Map<String, Object> params,Class<? extends AbstractBaseModel> tClazz) {
        SQL.SqlType type = statement.getType();
        switch(type) {
            case delete:
                assembleDeleteSql((SQLDelete)statement,params,tClazz);
                break;
            case insert:
                assembleInsertSql((SQLInsert)statement,params,tClazz);
                break;
            case update:
                assembleUpdateSql((SQLUpdate)statement,params,tClazz);
                break;
            case select:
                assembleSelectSql((SQLSelect)statement,params,tClazz);
                break;
            default:
                break;
        }
        return 0;
    }

    @Override
    public int assembleSql(SQL statement, List<Map<String, Object>> params, Class<? extends AbstractBaseModel> tClazz) {
        SQL.SqlType type = statement.getType();
        switch(type) {

            case insert:
                assembleBatchInsertSql((SQLInsert)statement,params,tClazz);
                break;
            case update:
                assembleBatchUpdateSql((SQLUpdate)statement,params,tClazz);
                break;
            default:
                break;
        }
        return 0;
    }

//    @Override
//    public void assembleSqlParam(Map<String, Object> params, Class<? extends AbstractBaseModel> tClazz) {
//
//    }

    protected void assembleDeleteSql(SQLDelete statement,Map<String, Object> params,Class<? extends AbstractBaseModel> tClazz) {

    }

    protected void assembleInsertSql(SQLInsert statement, Map<String, Object> params, Class<? extends AbstractBaseModel> tClazz) {

    }

    protected void assembleUpdateSql(SQLUpdate statement,Map<String, Object> params,Class<? extends AbstractBaseModel> tClazz) {

    }

    protected void assembleSelectSql(SQLSelect statement,Map<String, Object> params,Class<? extends AbstractBaseModel> tClazz) {

    }

    protected void assembleBatchInsertSql(SQLInsert statement, List<Map<String, Object>> params, Class<? extends AbstractBaseModel> tClazz) {

    }

    protected void assembleBatchUpdateSql(SQLUpdate statement,List<Map<String, Object>> params,Class<? extends AbstractBaseModel> tClazz) {

    }


    @Override
    public <T extends AbstractBaseModel> DbResultSetMapper<T> assembleResultSetMapper(Map<String, Object> params,Class<T> tClazz) {
        return null;
    }

    @Override
    public String selectDb(SQL sql, Map<String, Object> params, Class<? extends AbstractBaseModel> tClazz) {
        return super.selectDb(sql, params, tClazz);
    }

    @Override
    public String selectDb(SQL sql, List<Map<String, Object>> params, Class<? extends AbstractBaseModel> tClazz) {
        return super.selectDb(sql, params, tClazz);
    }
}
