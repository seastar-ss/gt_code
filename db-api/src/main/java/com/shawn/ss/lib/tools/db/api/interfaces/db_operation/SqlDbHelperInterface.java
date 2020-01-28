package com.shawn.ss.lib.tools.db.api.interfaces.db_operation;

import com.shawn.ss.lib.tools.db.api.exceptions.DataAccessException;
//import com.shawn.ss.lib.tools.db.api.interfaces.mappers.dao_mapper.ModelToModelMapper;
//import com.shawn.ss.lib.tools.db.api.interfaces.mappers.dao_mapper.ResultSetRowToModelMapper;
//import com.shawn.ss.lib.tools.data_store.api.interfaces.mappers.model_mapper.ModelToMapMapper;
import com.shawn.ss.lib.tools.db.api.interfaces.mappers.dao_mapper.ModelToModelMapper;
import com.shawn.ss.lib.tools.db.api.interfaces.mappers.db.DbResultSetMapper;
import com.shawn.ss.lib.tools.db.dto_base.model.AbstractBaseModel;
//import com.shawn.ss.lib.tools.data_store.dto_base.model.AbstractModelListWrapper;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface SqlDbHelperInterface extends SqlDbInterface {



    int getCount(String table, Map<String, Object> param);

    int getCount(String table, AbstractBaseModel param);

    int getApproximateTableRowCount(String table);

    boolean isExist(String table,AbstractBaseModel param);

    boolean isExist(String table, Map<String, Object> param);

    <K,T extends AbstractBaseModel> Map<K,T> selectMap(String sql, String keyField, Map<String, ?> paramMap, DbResultSetMapper<T> ResultSetRowToModelMapper);

    <K,T extends AbstractBaseModel> Map<K,T> selectMap(String sql, String keyField, AbstractBaseModel param, DbResultSetMapper<T> ResultSetRowToModelMapper);

    <K,T extends AbstractBaseModel> Map<K,List<T>> selectMapAndGroup(String sql, String keyField, Map<String, ?> paramMap, DbResultSetMapper<T> ResultSetRowToModelMapper);

    <K,T extends AbstractBaseModel> Map<K,List<T>> selectMapAndGroup(String sql, String keyField, AbstractBaseModel param, DbResultSetMapper<T> ResultSetRowToModelMapper);

    /**
     * @param table 更新或插入数据的数据表
     * @param param 数据，操作成功后会将数据的数据更新到model中（如果对应字段为null）
     * @param keyField 用于判断是否存在数据的字段
     * @return -1 失败，0 更新，>0 为插入的id
     */
    int insertOrUpdate(String table, AbstractBaseModel param, Set<String> keyField);

    /**
     * @param table 更新或插入数据的数据表
     * @param paramMap 数据，操作成功后会将数据的数据更新到map中（如果对应字段为null）
     * @param keyField 用于判断是否存在数据的字段
     * @return -1 失败，0 更新，>0 为插入的id
     */
    int insertOrUpdate(String table, Map<String, ?> paramMap,Set<String> keyField);

    int copyData(String srcTable,String distTable,Map<String,?> copyCondition);

    <T1 extends AbstractBaseModel,T2 extends AbstractBaseModel> int copyData(String srcTable, String distTable, Map<String,?> copyCondition, ModelToModelMapper<T1 ,T2 > mapper);

    int update(String table, Set<String> conditionField, Map<String, ?> param);

    int update(String table,Set<String> conditionField,AbstractBaseModel param);

    int createTableLike(String tableName,String originalTableName);

//    <T extends AbstractBaseModel> AbstractModelListWrapper<T> queryListAndTotal(String sql, Map<String, ?> paramMap, ResultSetRowToModelMapper<T> ResultSetRowToModelMapper) throws DataAccessException;

}
