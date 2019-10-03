//package com.shawn.ss.lib.tools.db.impl;
//
//import com.shawn.ss.lib.tools.CollectionHelper;
//import com.shawn.ss.lib.tools.data_store.api.exceptions.DataAccessException;
//import com.shawn.ss.lib.tools.data_store.api.interfaces.db_operation.SqlDbHelperInterface;
//import com.shawn.ss.lib.tools.data_store.api.interfaces.mappers.dao_mapper.ModelToModelMapper;
//import com.shawn.ss.lib.tools.data_store.api.interfaces.mappers.dao_mapper.ResultSetRowToModelMapper;
//import com.shawn.ss.lib.tools.data_store.api.interfaces.mappers.dao_mapper.ResultSetToModelMapper;
//import com.shawn.ss.lib.tools.data_store.api.interfaces.mappers.model_mapper.ModelToMapMapper;
//import com.shawn.ss.lib.tools.data_store.dto_base.model.AbstractBaseModel;
////import com.shawn.ss.lib.tools.data_store.dto_base.model.AbstractModelListWrapper;
//import com.shawn.ss.lib.tools.data_store.impl.jdbc_template.JdbcTemplateExt;
//import com.shawn.ss.lib.tools.sql_code_gen.api.SQL;
//import com.shawn.ss.lib.tools.sql_code_gen.api.SQLSelect;
//import org.springframework.jdbc.core.PreparedStatementCallback;
//
//import javax.sql.DataSource;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//import java.util.*;
//
//class SqlDbHelperSpringImpl implements SqlDbHelperInterface {
//    private DataSource dts;
//    private final Properties p;
//    private final boolean debug;
//    private JdbcTemplateExt template;
//
//    static Map<String,Object> getMapFromModel(AbstractBaseModel param) {
//        Map<String,Object> map;
//        ModelToMapMapper feature = param.getFeature(ModelToMapMapper.class);
//        if(feature!=null){
//            map = feature.toMap(param);
//        }else {
//            throw new IllegalArgumentException("对象" + param.getClass().toString() + "无法使用此方法");
//        }
//        return map;
//    }
//
//    public SqlDbHelperSpringImpl(DataSource dts, Properties p, boolean debug) {
//        this.dts = dts;
//        this.p = p;
//        this.debug = debug;
//        this.template = new JdbcTemplateExt(dts);
//    }
//
//    @Override
//    public int getCount(String table, Map<String, Object> param) {
////        if(param==null){
////            throw  new IllegalArgumentException("");
////    }
//        SQLSelect sqlSelect = SQL.buildSelectSql(table);
//        Set<Map.Entry<String, Object>> entries = param.entrySet();
//        sqlSelect.funcItems("count", "count");
//        for (Map.Entry<String, Object> entry : entries) {
//            sqlSelect.where(entry.getKey(), null);
//        }
//        String sql = sqlSelect.getSql(null);
//        Integer integer = template.queryForObject(sql, param, Integer.class);
//        return integer == null ? 0 : integer;
//    }
//
//    @Override
//    public int getCount(String table, AbstractBaseModel param) {
//        Map<String,Object> map=getMapFromModel(param);
//        return getCount(table,map);
//    }
//
//
//
//    @Override
//    public int getApproximateTableRowCount(String table) {
//        return 0;
//    }
//
//    @Override
//    public boolean isExist(String table, AbstractBaseModel param) {
//        Map<String,Object> map=getMapFromModel(param);
//        return isExist(table,map);
//    }
//
//    @Override
//    public boolean isExist(String table, Map<String, Object> param) {
//        if(param==null || param.size()==0){
//            throw  new IllegalArgumentException("查询条件不应为空");
//        }
//        SQLSelect sqlSelect = SQL.buildSelectSql(table);
//        Set<Map.Entry<String, Object>> entries = param.entrySet();
//        boolean first = true;
//        for (Map.Entry<String, Object> entry : entries) {
//            if (first) {
//                sqlSelect.items(entry.getKey());
//                first = false;
//            }
//            sqlSelect.where(entry.getKey(), null);
//        }
//        String sql = sqlSelect.getSql(null);
//        String res = template.queryForObject(sql, param, String.class);
//        return res!=null;
//    }
//
//    @Override
//    public <K, T extends AbstractBaseModel> Map<K, T> selectMap(String sql, String keyField, Map<String, ?> paramMap, ResultSetRowToModelMapper<T> ResultSetRowToModelMapper) {
//        return null;
//    }
//
//    @Override
//    public <K, T extends AbstractBaseModel> Map<K, T> selectMap(String sql, String keyField, AbstractBaseModel param, ResultSetRowToModelMapper<T> ResultSetRowToModelMapper) {
//        return null;
//    }
//
//    @Override
//    public <K, T extends AbstractBaseModel> Map<K, List<T>> selectMapAndGroup(String sql, String keyField, Map<String, ?> paramMap, ResultSetRowToModelMapper<T> ResultSetRowToModelMapper) {
//        return null;
//    }
//
//    @Override
//    public <K, T extends AbstractBaseModel> Map<K, List<T>> selectMapAndGroup(String sql, String keyField, AbstractBaseModel param, ResultSetRowToModelMapper<T> ResultSetRowToModelMapper) {
//        return null;
//    }
//
//    @Override
//    public int insertOrUpdate(String table, AbstractBaseModel param, Set<String> keyField) {
//        return 0;
//    }
//
//    @Override
//    public int insertOrUpdate(String table, Map<String, ?> paramMap, Set<String> keyField) {
//        return 0;
//    }
//
//    @Override
//    public int copyData(String srcTable, String distTable, Map<String, ?> copyCondition) {
//        return 0;
//    }
//
//    @Override
//    public <T1 extends AbstractBaseModel, T2 extends AbstractBaseModel> int copyData(String srcTable, String distTable, Map<String, ?> copyCondition, ModelToModelMapper<T1, T2> mapper) {
//        return 0;
//    }
//
//    @Override
//    public int update(String table, Set<String> conditionField, Map<String, ?> param) {
//        return 0;
//    }
//
//    @Override
//    public int update(String table, Set<String> conditionField, AbstractBaseModel param) {
//        return 0;
//    }
//
//    @Override
//    public int createTableLike(String tableName, String originalTableName) {
//        return 0;
//    }
//
////    @Override
////    public <T extends AbstractBaseModel> AbstractModelListWrapper<T> queryListAndTotal(String sql, Map<String, ?> paramMap, ResultSetRowToModelMapper<T> ResultSetRowToModelMapper) throws DataAccessException {
////        return null;
////    }
//
//    @Override
//    public int execute(String sql) {
//        return execute(sql,Collections.<String,Object>emptyMap());
//    }
//
//    @Override
//    public int execute(String sql,final Map<String,Object> param) {
//
//        return template.execute(sql, param, new PreparedStatementCallback<Integer>() {
//            @Override
//            public Integer doInPreparedStatement(PreparedStatement ps) throws SQLException, org.springframework.dao.DataAccessException {
//                boolean execute = ps.execute();
//                return null;
//            }
//        });
//    }
//
//    @Override
//    public int createTable(String sql) {
//        return 0;
//    }
//
//    @Override
//    public int update(String sql, Map<String, ?> param) {
//        return 0;
//    }
//
//    @Override
//    public int update(String sql, AbstractBaseModel param) {
//        return 0;
//    }
//
//    @Override
//    public int insert(String sql, AbstractBaseModel param) {
//        return 0;
//    }
//
//    @Override
//    public int insert(String sql, Map<String, Object> param) {
//        return 0;
//    }
//
//    @Override
//    public List<Integer> insertAll(String sql, List<Map<String, Object>> params) {
//        return null;
//    }
//
//    @Override
//    public List<Integer> insertAllModel(String sql, List<AbstractBaseModel> params) {
//        return null;
//    }
//
//    @Override
//    public <T> T querySingle(String sql, Map<String, ?> paramMap, Class<T> requiredType) {
//        return null;
//    }
//
//    @Override
//    public <T> T querySingle(String sql, AbstractBaseModel param, Class<T> requiredType) throws DataAccessException {
//        return null;
//    }
//
//    @Override
//    public <T extends AbstractBaseModel> T queryObj(String sql, Map<String, ?> paramMap, ResultSetRowToModelMapper<T> ResultSetRowToModelMapper) throws DataAccessException {
//        return null;
//    }
//
//    @Override
//    public <T extends AbstractBaseModel> T queryObj(String sql, AbstractBaseModel param, ResultSetRowToModelMapper<T> ResultSetRowToModelMapper) throws DataAccessException {
//        return null;
//    }
//
//    @Override
//    public <T extends AbstractBaseModel> Collection<T> queryList(String sql, Map<String, ?> paramMap, ResultSetRowToModelMapper<T> ResultSetRowToModelMapper) throws DataAccessException {
//        return null;
//    }
//
//    @Override
//    public <T extends AbstractBaseModel> T queryComplex(String sql, Map<String, ?> paramMap, ResultSetToModelMapper<T> rse) throws DataAccessException {
//        return null;
//    }
//}
