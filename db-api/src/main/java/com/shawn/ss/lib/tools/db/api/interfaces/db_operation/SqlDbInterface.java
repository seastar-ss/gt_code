package com.shawn.ss.lib.tools.db.api.interfaces.db_operation;

import com.shawn.ss.lib.tools.db.api.exceptions.DataAccessException;
import com.shawn.ss.lib.tools.db.api.interfaces.mappers.dao_mapper.ResultSetRowToModelMapper;
import com.shawn.ss.lib.tools.db.api.interfaces.mappers.dao_mapper.ResultSetToModelMapper;
import com.shawn.ss.lib.tools.db.dto_base.model.AbstractBaseModel;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface SqlDbInterface {

    int execute(String sql);

    int execute(String sql,Map<String,Object> param);

    int createTable(String sql);

    int update(String sql, Map<String, ?> param);

    int update(String sql, AbstractBaseModel param);

    int insert(String sql, AbstractBaseModel param);

    int insert(String sql, Map<String, Object> param);

    List<Integer> insertAll(String sql,List<Map<String,Object>> params);

    List<Integer> insertAllModel(String sql,List<AbstractBaseModel> params);

    <T> T querySingle(String sql, Map<String, ?> paramMap, Class<T> requiredType);

    <T> T querySingle(String sql, AbstractBaseModel param, Class<T> requiredType) throws DataAccessException;

    <T extends AbstractBaseModel> T queryObj(String sql, Map<String, ?> paramMap, ResultSetRowToModelMapper<T> ResultSetRowToModelMapper) throws DataAccessException;

    <T extends AbstractBaseModel> T queryObj(String sql, AbstractBaseModel param, ResultSetRowToModelMapper<T> ResultSetRowToModelMapper) throws DataAccessException;

//    <T extends AbstractBaseModel> Collection<T> queryList(String sql, AbstractBaseModel param, AbstractBaseModel.BaseMapping<T> mapper) throws DataAccessException;

    <T extends AbstractBaseModel> Collection<T> queryList(String sql, Map<String, ?> paramMap, ResultSetRowToModelMapper<T> ResultSetRowToModelMapper) throws DataAccessException;

    <T extends AbstractBaseModel> T queryComplex(String sql, Map<String, ?> paramMap, ResultSetToModelMapper<T> rse) throws DataAccessException;
}
