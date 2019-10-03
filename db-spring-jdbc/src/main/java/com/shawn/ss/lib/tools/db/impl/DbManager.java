package com.shawn.ss.lib.tools.db.impl;


import com.shawn.ss.lib.tools.CollectionHelper;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.SimpleDbInterface;
import com.shawn.ss.lib.tools.sql_code_gen.api.SQL;
import com.shawn.ss.lib.tools.sql_code_gen.api.SQLBuilder;
import com.shawn.ss.lib.tools.sql_code_gen.api.SQLUpdate;
import com.shawn.ss.lib.tools.sql_code_gen.api.expressions.Expr;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SingleColumnRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.ParsedSql;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.JdbcUtils;
import org.springframework.jdbc.support.KeyHolder;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DbManager extends NamedParameterJdbcTemplate implements SimpleDbInterface {
    Logger logger = LoggerFactory.getLogger("SQL-LOGS");

    final static String[] END_CHAR = {";", "\\G", "\\g"};
    final static String KEY_WORD_VALUES = " values ";
    final static String KEY_WORD_INSERT = "insert";
    final static String KEY_WORD_UPDATE = "update";
    final static String KEY_WORD_DELETE = "delete";
    final static String KEY_WORD_WHERE = " where ";

    public DbManager(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public Long insert(String sql, Map<String, Object> param) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        MapSqlParameterSource arg = new MapSqlParameterSource(param);

        int update = this.update(sql, arg, keyHolder);
        if(update==0){
            throw new IllegalStateException("insert failed for "+sql+" with param:"+param.toString());
        }
        Number key = keyHolder.getKey();
        if (key != null) {
            return key.longValue();
        } else {
            return null;
        }
    }

    @Override
    public int batchInsert(String sql, List<Map<String, Object>> params) {
        if (sql == null || params == null) {
            throw new IllegalArgumentException("wrong param ,sql and params should not be not null");
        }
        final int size = params.size();
        if (size == 0) {
            throw new IllegalArgumentException("wrong param ,params should not be empty");
        }
        if (size > 5000) {
            throw new IllegalArgumentException("wrong param ,params should not contain more than 5000 elements");
        }
        String tmpSql = sql.toLowerCase();


        if (!tmpSql.startsWith(KEY_WORD_INSERT) || !tmpSql.contains(KEY_WORD_VALUES)) {
            throw new IllegalArgumentException("wrong param ,sql is not stander insert sql");
        }
        int valuesPos = tmpSql.indexOf(KEY_WORD_VALUES);
        String insertSql = sql.substring(0, valuesPos+KEY_WORD_VALUES.length());
        final Map<String, Object> firstEntry = params.get(0);
        if (firstEntry == null) {
            throw new IllegalArgumentException("wrong param ,params should not contains null element");
        }
        final int entrySize = firstEntry.size();
        if (entrySize > 100) {
            throw new IllegalArgumentException("wrong param ,params should not contains entry more than 100 column");
        }

        Map<String, Object> rawParam = CollectionHelper.newMap(entrySize * size);
        String rawSql = buildRawParam(insertSql, rawParam, params, firstEntry);
        int ret = 0;
//        buildRawSql(sql,size);
        logger.info("raw sql executed:{}\n with param: {} " , rawSql,rawParam);
        ret = this.update(rawSql, rawParam);
        return ret;
    }

    private String buildRawParam(String sql, Map<String, Object> rawParam, List<Map<String, Object>> params, Map<String, Object> firstEntry) {
//        if(sql.endsWith(";") || sql.endsWith("\\G") || sql.endsWith("\\g")){
//            for(String stub:END_CHAR){
//                int pos;
//                pos=sql.indexOf(stub);
//                if(pos>1){
//                    sql=sql.substring(0,pos);
//                }
//            }
//        }
        final Set<String> keySet = firstEntry.keySet();
        int entrySize=keySet.size();
        int i = 0,j=0;
        StringBuilder builder = new StringBuilder(sql);
        boolean first=true;
        for (Map<String, Object> values : params) {
            final Set<String> vKeySet = values.keySet();
            if(keySet.equals(vKeySet)) {
                if(first){
                    first=false;
                }else{
                    builder.append(" , ");
                }
                j=0;
                builder.append(" (");
                for (String entrykey : vKeySet) {
                    final Object entryValue = values.get(entrykey);
//                final String key = entry.getKey();
                    rawParam.put(entrykey + i, entryValue);
                    builder.append(":").append(entrykey+i).append(j<entrySize-1?",":" ");
                    ++j;
                }
                builder.append(" )");
                i++;
            }
        }
        return builder.toString();
    }

//    private String buildRawSql(String sql, int size) {
//
//    }

    @Override
    public boolean execute(String sql) {
        final Boolean execute = this.execute(sql, new PreparedStatementCallback<Boolean>() {
            @Override
            public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException {
//                ResultSet rs = null;
                try {
                    boolean rs = ps.execute();
                    return rs;
                } finally {

                }
            }
        });
        return execute;
    }

    @Override
    public <T> T queryForObject(String sql, SqlParameterSource paramSource, RowMapper<T> rowMapper)
            throws DataAccessException {

        List<T> results = getJdbcOperations().query(getPreparedStatementCreator(sql, paramSource), rowMapper);
//        return DataAccessUtils.requiredSingleResult(results);
        int size = results != null ? results.size() : 0;
        if (size == 0) {
            return null;
        } else if (results.size() > 1) {
            throw new IncorrectResultSizeDataAccessException(1, size);
        } else {
            return results.iterator().next();
        }
    }

    @Override
    public <T> T queryForObject(String sql, Map<String, ?> paramMap, RowMapper<T>rowMapper)
            throws DataAccessException {

        return queryForObject(sql, new MapSqlParameterSource(paramMap), rowMapper);
    }

    @Override
    public <T> T queryForObject(String sql, SqlParameterSource paramSource, Class<T> requiredType)
            throws DataAccessException {

        return queryForObject(sql, paramSource, new SingleColumnRowMapper<T>(requiredType));
    }

    @Override
    public <T> T queryForObject(String sql, Map<String, ?> paramMap, Class<T> requiredType)
            throws DataAccessException {

        return queryForObject(sql, paramMap, new SingleColumnRowMapper<T>(requiredType));
    }

    @Override
    public int update(String sql, SqlParameterSource paramSource) throws DataAccessException {
        checkNoCondition(sql);
        return super.update(sql, paramSource);
    }



    @Override
    public int update(String sql, Map<String, ?> paramMap) throws DataAccessException {
        checkNoCondition(sql);
        return super.update(sql, paramMap);
    }

    @Override
    public int update(String sql, SqlParameterSource paramSource, KeyHolder generatedKeyHolder) throws DataAccessException {
        checkNoCondition(sql);
        return super.update(sql, paramSource, generatedKeyHolder);
    }

    @Override
    public int update(String sql, SqlParameterSource paramSource, KeyHolder generatedKeyHolder, String[] keyColumnNames) throws DataAccessException {
        checkNoCondition(sql);
        return super.update(sql, paramSource, generatedKeyHolder, keyColumnNames);
    }

    @Override
    protected ParsedSql getParsedSql(String sql) {
        String checkSql = sql.toLowerCase();
        if (!checkSql.startsWith("select ") && !checkSql.startsWith(KEY_WORD_UPDATE) && !checkSql.startsWith(KEY_WORD_DELETE) && !checkSql.startsWith(KEY_WORD_INSERT))
            logger.info("sql executed:" + sql);
        return super.getParsedSql(sql);
    }

    private void checkNoCondition(String sql) {
        final String lowerCase = sql.toLowerCase();
        SQL base=null;
        if(lowerCase.startsWith(KEY_WORD_DELETE) || lowerCase.startsWith(KEY_WORD_UPDATE) ){

            base = SQLBuilder.parseSql(sql);
            Expr wheres = base.wheres();
            if(wheres!=null && !wheres.isEmpty() ){
                return;
            }
            throw new IllegalArgumentException("全表更新不被允许："+sql);
        }
    }
}
