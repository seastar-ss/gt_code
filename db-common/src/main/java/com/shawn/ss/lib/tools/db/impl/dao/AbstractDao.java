package com.shawn.ss.lib.tools.db.impl.dao;

import com.shawn.ss.lib.tools.CollectionHelper;
import com.shawn.ss.lib.tools.StringHelper;
import com.shawn.ss.lib.tools.TypeConstantHelper;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.SimpleDbInterface;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model.ColumnDataType;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model.LogicalOpType;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model.LogicalRelationshipType;
import com.shawn.ss.lib.tools.db.api.interfaces.mappers.db.DbResultSetMapper;
import com.shawn.ss.lib.tools.db.dto_base.model.AbstractBaseModel;
import com.shawn.ss.lib.tools.service_assemble.AbstractMultipleDaoAssembler;
import com.shawn.ss.lib.tools.service_assemble.DaoAssembler;
import com.shawn.ss.lib.tools.sql_code_gen.api.SQL;
import com.shawn.ss.lib.tools.sql_code_gen.api.SQLSelect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.NamedThreadLocal;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class AbstractDao<Ty extends AbstractBaseModel, Tt> implements DaoInterface<Ty, Tt> {


    static final Logger logger = LoggerFactory.getLogger(AbstractDao.class);

    final NamedThreadLocal<String> currentQueryTable=new NamedThreadLocal<>("current_operated_table");
    final NamedThreadLocal<String> currentQueryDb=new NamedThreadLocal<>("current_operated_db");

    private final Class<Ty> type;

    protected AbstractDao(Class<Ty> type) {
        this.type = type;
    }

    public AbstractDao setCurrentQueryTable(String table) {
        this.currentQueryTable.set(table);
        return this;
    }

    public AbstractDao setCurrentQueryDB(String db) {
        this.currentQueryDb.set(db);
        return this;
    }

    public String getCurrentQueryTable() {
        return currentQueryTable.get();
    }

    public String getCurrentQueryDb() {
        return currentQueryDb.get();
    }



    protected List<Ty> getResults(SimpleDbInterface db, DaoAssembler assembler, SQL<SQLSelect> sqlBuilder, Map<String, Object> param, DbResultSetMapper<Ty> mapper) {
        setTableName(sqlBuilder,param,assembler);
        final String sql = sqlBuilder.getSql(null);
        logger.info("execute sql:\n{}\nwith param:{}", sql, param);
        return db.query(sql, param, (RowMapper<Ty>) mapper);
    }

    protected Ty getResult(SimpleDbInterface db, DaoAssembler assembler, SQL<SQLSelect> sqlBuilder, Map<String, Object> param, DbResultSetMapper<Ty> mapper) {
        setTableName(sqlBuilder,param,assembler);
        final String sql = sqlBuilder.getSql(null);
        logger.info("execute sql:\n{}\nwith param:{}", sql, param);
        return db.queryForObject(sql, param, (RowMapper<Ty>) mapper);
    }

    protected void setTableName(SQL sqlBuilder, Map<String, Object> param, DaoAssembler assembler) {
        if (param.containsKey(KEY_WORD_TABLE_NAME_IN_PARAM)) {
            final String tableName = CollectionHelper.getString(param, KEY_WORD_TABLE_NAME_IN_PARAM);
            if (!StringHelper.isEmpty(tableName))
                sqlBuilder.table(tableName);
        }else {
            final String tname = currentQueryTable.get();
            if(!StringHelper.isEmpty(tname)){
                sqlBuilder.table(tname);
                currentQueryTable.set(null);
            }
        }
    }

    protected String selectDb(DaoAssembler assembler, SQL sqlBuilder, Map<String, Object> param){
        SimpleDbInterface dbInstance = null;
        String dbToUse = null;
        if (assembler!= null) {
            dbToUse = assembler.selectDb(sqlBuilder, param, type);
        }
        if(dbToUse==null ){
            final String currentQueryDb = getCurrentQueryDb();
            if(currentQueryDb!=null){
                dbToUse=currentQueryDb;
                setCurrentQueryDB(null);
            }
        }
        return dbToUse;
    }

    protected String selectDb(DaoAssembler assembler, SQL sqlBuilder, List<Map<String, Object>> param){
        SimpleDbInterface dbInstance = null;
        String dbToUse = null;
        if (assembler!= null) {
            dbToUse = assembler.selectDb(sqlBuilder, param, type);
        }
        if(dbToUse==null ){
            final String currentQueryDb = getCurrentQueryDb();
            if(currentQueryDb!=null){
                dbToUse=currentQueryDb;
                setCurrentQueryDB(null);
            }
        }
        return dbToUse;
    }

    protected <Tx> Tx getSingleResult(SimpleDbInterface db, DaoAssembler assembler, SQL<SQLSelect> sqlBuilder, Map<String, Object> param, Class<Tx> tClass) {
        setTableName(sqlBuilder,param,assembler);
        if (!TypeConstantHelper.BASIC_DATA_CLASS.contains(tClass)) {
            throw new IllegalStateException("only can be use with primitive classes");
        }
        int status = 0;
        if (assembler != null) {
            status = assembler.assembleSql(sqlBuilder, param, type);
        }
        String sql;
        if (status == 0) {
            sql = sqlBuilder.getSql(null);
            logger.info("execute sql:\n{}\nwith param:{}", sql, param);
            try {
                return db.queryForObject(sql, param, tClass);
            } catch (final Exception ex) {
                logger.error("sql execption", ex);
                return null;
            }
        } else {
            return null;
        }
    }

    protected <Tx> List<Tx> getSingleResults(SimpleDbInterface db, DaoAssembler assembler, SQL<SQLSelect> sqlBuilder, Map<String, Object> param, Class<Tx> tClass) {
        setTableName(sqlBuilder,param,assembler);
        if (!TypeConstantHelper.BASIC_DATA_CLASS.contains(tClass)) {
            throw new IllegalStateException("only can be use with primitive classes");
        }
        int status = 0;
        if (assembler != null) {
            status = assembler.assembleSql(sqlBuilder, param, type);
        }
        String sql;
        if (status == 0) {
            sql = sqlBuilder.getSql(null);
            logger.info("execute sql:\n{}\nwith param:{}", sql, param);
            try {
                return db.queryForList(sql, param, tClass);
            } catch (final Exception ex) {
                logger.error("sql execption", ex);
                return null;
            }
        } else {
            return null;
        }
    }

    protected void buildRawInCluase(SQLSelect sqlBuilder, Map<String, Object> param, String inField, Object fieldClassObj, List indexes) {
        if (fieldClassObj instanceof Class) {
            Class fieldClass = ((Class) fieldClassObj);
            param.put("fields", indexes);
            sqlBuilder.rawWhereItem(LogicalRelationshipType.and,  inField+ " in (:fields)");
            return;
        } else {
            logger.warn("unknown error occured");
            throw new IllegalStateException("unknown error occured about inField ");
        }
    }

    protected void buildRawWhere(SQL sql, Map<String, Object> param, Map<String, Object> extParam, Set<String> extCondition) {
        if (sql == null || param == null || CollectionHelper.isCollectionEmpty(extCondition)) {
            return;
        }
        if (sql instanceof SQLSelect) {
            SQLSelect sqlBuilder = (SQLSelect) sql;
            if (!CollectionHelper.isCollectionEmpty(extParam)) {
                param.putAll(extParam);
            }
            if (!CollectionHelper.isCollectionEmpty(extCondition)) {
                for (String var : extCondition) {
                    sqlBuilder.rawWhere(var);
                }
            }
        }
    }

    protected Integer update(SimpleDbInterface db, DaoAssembler assembler, SQL sqlBuilder, Map<String, Object> param) {
        int status = 0;
        if (assembler != null)
            status = assembler.assembleSql(sqlBuilder, param, type);
        setTableName(sqlBuilder,param,assembler);
        String sql = sqlBuilder.getSql(null);
        if (status == 0) {
            logger.info("execute sql:\n{}\nwith param:{}", sql, param);
            Integer ret = db.update(sql, param);
            return ret;
        } else {
            return null;
        }
    }

    protected Integer batchInsert(SimpleDbInterface db, DaoAssembler assembler, SQL sqlBuilder, List<Map<String, Object>> param) {
        int status = 0;
        if (assembler != null)
            status = assembler.assembleSql(sqlBuilder, param, type);
        if(param.size()>0) {
            final Map<String, Object> map = param.get(0);
            if(map!=null) {
                setTableName(sqlBuilder,map,assembler);
                if (status == 0) {
                    String sql = sqlBuilder.getSql(null);
                    logger.info("execute sql:\n{}\nwith param:{}", sql, param);
                    Integer ret = db.batchInsert(sql, param);
                    if (ret < 0) {
                        logger.warn("batch insert has some error");
                    }
                    return ret;
                } else {

                }
            }
        }
        return null;
    }

    protected Long insert(SimpleDbInterface db, DaoAssembler assembler, SQL sqlBuilder, Map<String, Object> param) {
        int status = 0;
        if (assembler != null)
            status = assembler.assembleSql(sqlBuilder, param, type);
        setTableName(sqlBuilder,param,assembler);
        if (status == 0) {
            String sql = sqlBuilder.getSql(null);
            logger.info("execute sql:\n{}\nwith param:{}", sql, param);
            Long ret = db.insert(sql, param);
            return ret == null ? Long.MIN_VALUE : ret;
        } else {
            return null;
        }
    }


//    public <Tx> TT getItemByDef(final String item, SimpleDbInterface data_store, final DaoAssembler assembler, SQL<SQLSelect> sqlBuilder, Map<String, Object> param, Class<Tx> tClass){
//        return getSingleResult(data_store,new BaseDaoAssembler(){
//            @Override
//            public int assembleSql(SQL statement,Map<String, Object> params,Class<? extends AbstractBaseModel> tClazz) {
//                SQLSelect select = (SQLSelect) statement;
//                select.rawItem(item);
//                return assembler.assembleSql(statement,params,tClazz);
//            }
//        },sqlBuilder,param,tClass);
//    }
//    protected List<Ty> getListByDef(Map<String,String> fields,Set<String> condition,DaoAssembler assembler,){
//
//    }
//
//    protected Ty getOneByDef(Map<String,String> fields,Set<String> condition,DaoAssembler assembler,){
//
//    }


    @Override
    public List<Ty> select(SelectParamHolder<Ty, Tt> holder) {
        if (holder.ids != null) {
            if (holder.instance == null) {
                return getById(
                        holder.selectFields,
                        holder.assembler,
                        holder.start, holder.count,
                        holder.ids
                );
            } else {
                return getByIdAndCondAndWhere(
                        holder.selectFields,
                        holder.assembler,
                        holder.start, holder.count,
                        holder.instance,
                        holder.ids,
                        holder.extParam,
                        holder.extCondition

                );
            }
        } else {
            if (holder.instance != null && holder.indexes != null && holder.extCondition != null) {
                return getByCondAndIndexAndWhere(
                        holder.selectFields,
                        holder.assembler,
                        holder.start, holder.count,
                        holder.instance,
                        holder.inField, holder.indexes,
                        holder.extParam, holder.extCondition);
            } else if (holder.instance != null && holder.indexes != null) {
                return getByCondAndIndex(
                        holder.selectFields,
                        holder.assembler,
                        holder.start, holder.count,
                        holder.instance,
                        holder.inField, holder.indexes
                );
            } else if (holder.instance != null && holder.extCondition != null) {
                return getByCondAndWhere(
                        holder.selectFields,
                        holder.assembler,
                        holder.start, holder.count,
                        holder.instance,
                        holder.extParam, holder.extCondition
                );
            } else if (holder.indexes != null && holder.extCondition != null) {
                return getByIndexAndWhere(
                        holder.selectFields,
                        holder.assembler,
                        holder.start, holder.count,
                        holder.inField, holder.indexes,
                        holder.extParam, holder.extCondition
                );
            } else if (holder.indexes != null) {
                return getByIndex(
                        holder.selectFields,
                        holder.assembler,
                        holder.start, holder.count,
                        holder.inField, holder.indexes
                );
            } else if (holder.extCondition != null) {
                return getByWhere(
                        holder.selectFields,
                        holder.assembler,
                        holder.start, holder.count,
                        holder.extParam, holder.extCondition
                );
            } else if (holder.instance != null) {
                return getByCond(
                        holder.selectFields,
                        holder.assembler,
                        holder.start, holder.count,
                        holder.instance
                );
            }
        }
        return get(
                holder.selectFields,
                holder.assembler,
                holder.start,
                holder.count
        );
    }

    @Override
    public Ty selectOne(SelectParamHolder<Ty, Tt> holder) {
        if (holder.id != null) {
            if (holder.instance != null) {
                return getOneByIdAndCondAndWhere(
                        holder.selectFields,
                        holder.assembler,
                        holder.instance,
                        holder.id,
                        holder.extParam,
                        holder.extCondition
                );
            } else {
                return getOneById(holder.selectFields, holder.assembler, holder.id);
            }
        } else {
            if (holder.instance != null && holder.extCondition != null) {
                return getOneByCondAndWhere(
                        holder.selectFields,
                        holder.assembler,
                        holder.instance,
                        holder.extParam,
                        holder.extCondition
                );
            } else if (holder.instance != null) {
                return getOneByCond(
                        holder.selectFields,
                        holder.assembler,
                        holder.instance
                );
            } else if (holder.extCondition != null) {
                return getOneByWhere(
                        holder.selectFields,
                        holder.assembler,
                        holder.extParam,
                        holder.extCondition
                );
            }
        }
        return null;
    }

    @Override
    public <Tx, Tc> Tc selectItem(SelectParamHolder<Ty, Tt> holder, Class<Tc> tcClass) {
        return getItemByCondAndIndexAndWhere(
                holder.assembler,
                holder.instance,
                holder.inField,
                holder.indexes,
                tcClass,
                holder.rawItem,
                holder.extParam,
                holder.extCondition
        );
//        throw new UnsupportedOperationException("no implements");
    }

    public <TT extends Object, Tc> List<Tc> selectItemList(SelectParamHolder<Ty, Tt> holder, Class<Tc> tcClass) {
        return getItemListByIdAndCondAndWhere(
                holder.assembler,
                holder.start,
                holder.count,
                holder.instance,
                holder.ids,
                tcClass,
                holder.rawItem,
                holder.extParam,
                holder.extCondition

        );
//        throw new UnsupportedOperationException("no implements");
    }

    public List<Ty> get(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count) {
        throw new UnsupportedOperationException("no implements");
    }

    public List<Ty> get(Set<String> selectFields, Integer start, Integer count) {
        throw new UnsupportedOperationException("no implements");
    }

    public List<Ty> get(Integer start, Integer count) {
        throw new UnsupportedOperationException("no implements");
    }

    public List<Ty> get() {
        throw new UnsupportedOperationException("no implements");
    }

    public List<Ty> getById(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, List<Tt> id) {
        throw new UnsupportedOperationException("no implements");
    }

    public List<Ty> getById(Set<String> selectFields, Integer start, Integer count, List<Tt> id) {
        throw new UnsupportedOperationException("no implements");
    }

    public List<Ty> getById(Integer start, Integer count, List<Tt> id) {
        throw new UnsupportedOperationException("no implements");
    }

    public List<Ty> getById(List<Tt> id) {
        throw new UnsupportedOperationException("no implements");
    }

    public List<Ty> getByIndex(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, String inField, List indexes) {
        throw new UnsupportedOperationException("no implements");
    }

    public List<Ty> getByIndex(Set<String> selectFields, Integer start, Integer count, String inField, List indexes) {
        throw new UnsupportedOperationException("no implements");
    }

    public List<Ty> getByIndex(Integer start, Integer count, String inField, List indexes) {
        throw new UnsupportedOperationException("no implements");
    }

    public List<Ty> getByIndex(String inField, List indexes) {
        throw new UnsupportedOperationException("no implements");
    }

    public List<Ty> getByCond(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, Ty instance) {
        throw new UnsupportedOperationException("no implements");
    }

    public List<Ty> getByCond(Set<String> selectFields, Integer start, Integer count, Ty instance) {
        throw new UnsupportedOperationException("no implements");
    }

    public List<Ty> getByCond(Integer start, Integer count, Ty instance) {
        throw new UnsupportedOperationException("no implements");
    }

    public List<Ty> getByCond(Ty instance) {
        throw new UnsupportedOperationException("no implements");
    }

    public List<Ty> getByWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, Map<String, Object> extParam, Set<String> extCondition) {
        throw new UnsupportedOperationException("no implements");
    }

    public List<Ty> getByWhere(Set<String> selectFields, Integer start, Integer count, Map<String, Object> extParam, Set<String> extCondition) {
        throw new UnsupportedOperationException("no implements");
    }

    public List<Ty> getByWhere(Integer start, Integer count, Map<String, Object> extParam, Set<String> extCondition) {
        throw new UnsupportedOperationException("no implements");
    }

    public List<Ty> getByWhere(Map<String, Object> extParam, Set<String> extCondition) {
        throw new UnsupportedOperationException("no implements");
    }

    public List<Ty> getByCondAndIndex(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, Ty instance, String inField, List indexes) {
        throw new UnsupportedOperationException("no implements");
    }

    public List<Ty> getByCondAndIndex(Set<String> selectFields, Integer start, Integer count, Ty instance, String inField, List indexes) {
        throw new UnsupportedOperationException("no implements");
    }

    public List<Ty> getByCondAndIndex(Integer start, Integer count, Ty instance, String inField, List indexes) {
        throw new UnsupportedOperationException("no implements");
    }

    public List<Ty> getByCondAndIndex(Ty instance, String inField, List indexes) {
        throw new UnsupportedOperationException("no implements");
    }

    public List<Ty> getByIdAndWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, Tt id, Map<String, Object> extParam, Set<String> extCondition) {
        throw new UnsupportedOperationException("no implements");
    }

    public List<Ty> getByIdAndWhere(Set<String> selectFields, Integer start, Integer count, Tt id, Map<String, Object> extParam, Set<String> extCondition) {
        throw new UnsupportedOperationException("no implements");
    }

    public List<Ty> getByIdAndWhere(Integer start, Integer count, Tt id, Map<String, Object> extParam, Set<String> extCondition) {
        throw new UnsupportedOperationException("no implements");
    }

    public List<Ty> getByIdAndWhere(Tt id, Map<String, Object> extParam, Set<String> extCondition) {
        throw new UnsupportedOperationException("no implements");
    }

    public List<Ty> getByIdAndCondAndWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, Ty instance, List<Tt> id, Map<String, Object> extParam, Set<String> extCondition) {
        throw new UnsupportedOperationException("no implements");
    }

    public List<Ty> getByIdAndCondAndWhere(Set<String> selectFields, Integer start, Integer count, Ty instance, List<Tt> id, Map<String, Object> extParam, Set<String> extCondition) {
        throw new UnsupportedOperationException("no implements");
    }

    public List<Ty> getByIdAndCondAndWhere(Integer start, Integer count, Ty instance, List<Tt> id, Map<String, Object> extParam, Set<String> extCondition) {
        throw new UnsupportedOperationException("no implements");
    }

    public List<Ty> getByIdAndCondAndWhere(Ty instance, List<Tt> id, Map<String, Object> extParam, Set<String> extCondition) {
        throw new UnsupportedOperationException("no implements");
    }

    public List<Ty> getByIndexAndWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        throw new UnsupportedOperationException("no implements");
    }

    public List<Ty> getByIndexAndWhere(Set<String> selectFields, Integer start, Integer count, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        throw new UnsupportedOperationException("no implements");
    }

    public List<Ty> getByIndexAndWhere(Integer start, Integer count, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        throw new UnsupportedOperationException("no implements");
    }

    public List<Ty> getByIndexAndWhere(String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        throw new UnsupportedOperationException("no implements");
    }

    public List<Ty> getByCondAndWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, Ty instance, Map<String, Object> extParam, Set<String> extCondition) {
        throw new UnsupportedOperationException("no implements");
    }

    public List<Ty> getByCondAndWhere(Set<String> selectFields, Integer start, Integer count, Ty instance, Map<String, Object> extParam, Set<String> extCondition) {
        throw new UnsupportedOperationException("no implements");
    }

    public List<Ty> getByCondAndWhere(Integer start, Integer count, Ty instance, Map<String, Object> extParam, Set<String> extCondition) {
        throw new UnsupportedOperationException("no implements");
    }

    public List<Ty> getByCondAndWhere(Ty instance, Map<String, Object> extParam, Set<String> extCondition) {
        throw new UnsupportedOperationException("no implements");
    }

    public List<Ty> getByCondAndIndexAndWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, Ty instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        throw new UnsupportedOperationException("no implements");
    }

    public List<Ty> getByCondAndIndexAndWhere(Set<String> selectFields, Integer start, Integer count, Ty instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        throw new UnsupportedOperationException("no implements");
    }

    public List<Ty> getByCondAndIndexAndWhere(Integer start, Integer count, Ty instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        throw new UnsupportedOperationException("no implements");
    }

    public List<Ty> getByCondAndIndexAndWhere(Ty instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        throw new UnsupportedOperationException("no implements");
    }

    public Ty getOneById(Set<String> selectFields, DaoAssembler assembler, Tt id) {
        throw new UnsupportedOperationException("no implements");
    }

    public Ty getOneById(Set<String> selectFields, Tt id) {
        throw new UnsupportedOperationException("no implements");
    }

    public Ty getOneById(Tt id) {
        throw new UnsupportedOperationException("no implements");
    }

    public Ty getOneByCond(Set<String> selectFields, DaoAssembler assembler, Ty instance) {
        throw new UnsupportedOperationException("no implements");
    }

    public Ty getOneByCond(Set<String> selectFields, Ty instance) {
        throw new UnsupportedOperationException("no implements");
    }

    public Ty getOneByCond(Ty instance) {
        throw new UnsupportedOperationException("no implements");
    }

    public Ty getOneByWhere(Set<String> selectFields, DaoAssembler assembler, Map<String, Object> extParam, Set<String> extCondition) {
        throw new UnsupportedOperationException("no implements");
    }

    public Ty getOneByWhere(Set<String> selectFields, Map<String, Object> extParam, Set<String> extCondition) {
        throw new UnsupportedOperationException("no implements");
    }

    public Ty getOneByWhere(Map<String, Object> extParam, Set<String> extCondition) {
        throw new UnsupportedOperationException("no implements");
    }

    public Ty getOneByCondAndWhere(Set<String> selectFields, DaoAssembler assembler, Ty instance, Map<String, Object> extParam, Set<String> extCondition) {
        throw new UnsupportedOperationException("no implements");
    }

    public Ty getOneByCondAndWhere(Set<String> selectFields, Ty instance, Map<String, Object> extParam, Set<String> extCondition) {
        throw new UnsupportedOperationException("no implements");
    }

    public Ty getOneByCondAndWhere(Ty instance, Map<String, Object> extParam, Set<String> extCondition) {
        throw new UnsupportedOperationException("no implements");
    }

    public Ty getOneByIdAndCondAndWhere(Set<String> selectFields, DaoAssembler assembler, Ty instance, Tt id, Map<String, Object> extParam, Set<String> extCondition) {
        throw new UnsupportedOperationException("no implements");
    }

    public Ty getOneByIdAndCondAndWhere(Set<String> selectFields, Ty instance, Tt id, Map<String, Object> extParam, Set<String> extCondition) {
        throw new UnsupportedOperationException("no implements");
    }

    public Ty getOneByIdAndCondAndWhere(Ty instance, Tt id, Map<String, Object> extParam, Set<String> extCondition) {
        throw new UnsupportedOperationException("no implements");
    }

    public Long getCountByCond(DaoAssembler assembler, Ty instance) {
        throw new UnsupportedOperationException("no implements");
    }

    public Long getCountByCond(Ty instance) {
        throw new UnsupportedOperationException("no implements");
    }

    public Long getCountByCondAndIndex(DaoAssembler assembler, Ty instance, String inField, List indexes) {
        throw new UnsupportedOperationException("no implements");
    }

    public Long getCountByCondAndIndex(Ty instance, String inField, List indexes) {
        throw new UnsupportedOperationException("no implements");
    }

    public Long getCountByCondAndIndexAndWhere(DaoAssembler assembler, Ty instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        throw new UnsupportedOperationException("no implements");
    }

    public Long getCountByCondAndIndexAndWhere(Ty instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        throw new UnsupportedOperationException("no implements");
    }

    public <TT> TT getItemByIndex(DaoAssembler assembler, String inField, List indexes, Class<TT> tClass, String rawItem) {
        throw new UnsupportedOperationException("no implements");
    }

    public <TT extends Object> TT getItemByIndex(String inField, List indexes, Class<TT> tClass, String rawItem) {
        throw new UnsupportedOperationException("no implements");
    }

    public <TT> TT getItemByWhere(DaoAssembler assembler, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        throw new UnsupportedOperationException("no implements");
    }

    public <TT extends Object> TT getItemByWhere(Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        throw new UnsupportedOperationException("no implements");
    }

    public <TT> TT getItemByCond(DaoAssembler assembler, Ty instance, Class<TT> tClass, String rawItem) {
        throw new UnsupportedOperationException("no implements");
    }

    public <TT extends Object> TT getItemByCond(Ty instance, Class<TT> tClass, String rawItem) {
        throw new UnsupportedOperationException("no implements");
    }

    public <TT> TT getItemByCondAndIndex(DaoAssembler assembler, Ty instance, String inField, List indexes, Class<TT> tClass, String rawItem) {
        throw new UnsupportedOperationException("no implements");
    }

    public <TT extends Object> TT getItemByCondAndIndex(Ty instance, String inField, List indexes, Class<TT> tClass, String rawItem) {
        throw new UnsupportedOperationException("no implements");
    }

    public <TT> TT getItemByCondAndIndexAndWhere(DaoAssembler assembler, Ty instance, String inField, List indexes, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        throw new UnsupportedOperationException("no implements");
    }

    public <TT extends Object> TT getItemByCondAndIndexAndWhere(Ty instance, String inField, List indexes, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        throw new UnsupportedOperationException("no implements");
    }

    public <TT> List<TT> getItemListByIndex(DaoAssembler assembler, Integer start, Integer count, String inField, List indexes, Class<TT> tClass, String rawItem) {
        throw new UnsupportedOperationException("no implements");
    }

    public <TT extends Object> List<TT> getItemListByIndex(Integer start, Integer count, String inField, List indexes, Class<TT> tClass, String rawItem) {
        throw new UnsupportedOperationException("no implements");
    }

    public <TT extends Object> List<TT> getItemListByIndex(String inField, List indexes, Class<TT> tClass, String rawItem) {
        throw new UnsupportedOperationException("no implements");
    }

    public <TT> List<TT> getItemListByCond(DaoAssembler assembler, Integer start, Integer count, Ty instance, Class<TT> tClass, String rawItem) {
        throw new UnsupportedOperationException("no implements");
    }

    public <TT extends Object> List<TT> getItemListByCond(Integer start, Integer count, Ty instance, Class<TT> tClass, String rawItem) {
        throw new UnsupportedOperationException("no implements");
    }

    public <TT extends Object> List<TT> getItemListByCond(Ty instance, Class<TT> tClass, String rawItem) {
        throw new UnsupportedOperationException("no implements");
    }

    public <TT> List<TT> getItemListById(DaoAssembler assembler, Integer start, Integer count, Tt id, Class<TT> tClass, String rawItem) {
        throw new UnsupportedOperationException("no implements");
    }

    public <TT extends Object> List<TT> getItemListById(Integer start, Integer count, Tt id, Class<TT> tClass, String rawItem) {
        throw new UnsupportedOperationException("no implements");
    }

    public <TT extends Object> List<TT> getItemListById(Tt id, Class<TT> tClass, String rawItem) {
        throw new UnsupportedOperationException("no implements");
    }

    public <TT> List<TT> getItemListByWhere(DaoAssembler assembler, Integer start, Integer count, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        throw new UnsupportedOperationException("no implements");
    }

    public <TT extends Object> List<TT> getItemListByWhere(Integer start, Integer count, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        throw new UnsupportedOperationException("no implements");
    }

    public <TT extends Object> List<TT> getItemListByWhere(Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        throw new UnsupportedOperationException("no implements");
    }

    public Ty insert(Ty instance, DaoAssembler assembler) {
        throw new UnsupportedOperationException("no implements");
    }

    public Ty insert(Ty instance) {
        throw new UnsupportedOperationException("no implements");
    }

    public Integer insert(List<Ty> instances, Set<String> fields, DaoAssembler assembler) {
        throw new UnsupportedOperationException("no implements");
    }

    public Integer insert(List<Ty> instances, Set<String> fields) {
        throw new UnsupportedOperationException("no implements");
    }

    public Integer insert(List<Ty> instances) {
        throw new UnsupportedOperationException("no implements");
    }

    public Integer update(Ty instance, Set<String> conditionField, DaoAssembler assembler) {
        throw new UnsupportedOperationException("no implements");
    }

    public Integer update(Ty instance, Set<String> conditionField) {
        throw new UnsupportedOperationException("no implements");
    }

    public Integer updateById(Ty instance, DaoAssembler assembler) {
        throw new UnsupportedOperationException("no implements");
    }

    public Integer updateById(Ty instance) {
        throw new UnsupportedOperationException("no implements");
    }

    public Integer updateByIds(Ty instance, Set<Integer> ids, DaoAssembler assembler) {
        throw new UnsupportedOperationException("no implements");
    }

    public Integer updateByIds(Ty instance, Set<Integer> ids) {
        throw new UnsupportedOperationException("no implements");
    }

    public Integer delete(Ty instance, Set<String> conditionField, DaoAssembler assembler) {
        throw new UnsupportedOperationException("no implements");
    }

    public Integer delete(Ty instance, Set<String> conditionField) {
        throw new UnsupportedOperationException("no implements");
    }

    public Integer deleteById(Tt id, DaoAssembler assembler) {
        throw new UnsupportedOperationException("no implements");
    }

    public Integer deleteById(Tt id) {
        throw new UnsupportedOperationException("no implements");
    }

    public Integer deleteByIds(Set<Integer> ids, DaoAssembler assembler) {
        throw new UnsupportedOperationException("no implements");
    }

    public Integer deleteByIds(Set<Integer> ids) {
        throw new UnsupportedOperationException("no implements");
    }

    @Transactional
    public Ty updateOrInsert(Ty instance, Set<String> conditionField, AbstractMultipleDaoAssembler assembler) {
        throw new UnsupportedOperationException("no implements");
    }

    public Ty updateOrInsert(Ty instance, Set<String> conditionField) {
        throw new UnsupportedOperationException("no implements");
    }

    @Transactional
    public Ty insertIfNoExist(Ty instance, Set<String> conditionField, AbstractMultipleDaoAssembler assembler) {
        throw new UnsupportedOperationException("no implements");
    }

    public Ty insertIfNoExist(Ty instance, Set<String> conditionField) {
        throw new UnsupportedOperationException("no implements");
    }

    public <TT> Map<TT, Ty> buildMap(List<Ty> list, String field) {
        throw new UnsupportedOperationException("no implements");
    }

    public <TT> Map<TT, List<Ty>> buildListMap(List<Ty> list, String field) {
        throw new UnsupportedOperationException("no implements");
    }

    public <TT> List<TT> extractItemAsList(List<Ty> list, String field) {
        throw new UnsupportedOperationException("no implements");
    }

    @Override
    public <TT> List<TT> getItemListByIndexAndWhere(DaoAssembler assembler, Integer start, Integer count, String inField, List indexes, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        throw new UnsupportedOperationException("no implements");
    }

    @Override
    public <TT> List<TT> getItemListByIndexAndWhere(Integer start, Integer count, String inField, List indexes, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        throw new UnsupportedOperationException("no implements");
    }

    @Override
    public <TT> List<TT> getItemListByIndexAndWhere(String inField, List indexes, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        throw new UnsupportedOperationException("no implements");
    }

    @Override
    public <TT> List<TT> getItemListByCondAndWhere(DaoAssembler assembler, Integer start, Integer count, Ty instance, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        throw new UnsupportedOperationException("no implements");
    }

    @Override
    public <TT> List<TT> getItemListByCondAndWhere(Integer start, Integer count, Ty instance, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        throw new UnsupportedOperationException("no implements");
    }

    @Override
    public <TT> List<TT> getItemListByCondAndWhere(Ty instance, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        throw new UnsupportedOperationException("no implements");
    }

    @Override
    public <TT> List<TT> getItemListByCondAndIndex(DaoAssembler assembler, Integer start, Integer count, Ty instance, String inField, List indexes, Class<TT> tClass, String rawItem) {
        throw new UnsupportedOperationException("no implements");
    }

    @Override
    public <TT> List<TT> getItemListByCondAndIndex(Integer start, Integer count, Ty instance, String inField, List indexes, Class<TT> tClass, String rawItem) {
        throw new UnsupportedOperationException("no implements");
    }

    @Override
    public <TT> List<TT> getItemListByCondAndIndex(Ty instance, String inField, List indexes, Class<TT> tClass, String rawItem) {
        throw new UnsupportedOperationException("no implements");
    }

    @Override
    public <TT> List<TT> getItemListByIdAndCondAndWhere(DaoAssembler assembler, Integer start, Integer count, Ty instance, List<Tt> id, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        throw new UnsupportedOperationException("no implements");
    }

    @Override
    public <TT> List<TT> getItemListByIdAndCondAndWhere(Integer start, Integer count, Ty instance, List<Tt> id, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        throw new UnsupportedOperationException("no implements");
    }

    @Override
    public <TT> List<TT> getItemListByIdAndCondAndWhere(Ty instance, List<Tt> id, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        throw new UnsupportedOperationException("no implements");
    }
    
    /*@Override
    public List<Ty> get(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count) {
        throw new UnsupportedOperationException("no implements");
//        return null;
    }

    @Override
    public List<Ty> get() {
        throw new UnsupportedOperationException("no implements");
    }

    @Override
    public List<Ty> get(Set<String> selectFields, Integer start, Integer count) {
        throw new UnsupportedOperationException("no implements");
    }

    @Override
    public List<Ty> get(Set<String> selectFields) {
        throw new UnsupportedOperationException("no implements");
    }

//    @Override
//    public List<Ty> getById(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, List<Integer> id){throw new UnsupportedOperationException("no implements"); }
//
//    @Override
//    public List<Ty> getById(Set<String> selectFields, Integer start, Integer count, List<Integer> id){throw new UnsupportedOperationException("no implements"); }
//
//    @Override
//    public List<Ty> getById(Set<String> selectFields, List<Integer> id){throw new UnsupportedOperationException("no implements"); }

    @Override
    public List<Ty> getByIndex(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, String inField, List indexes) {
        throw new UnsupportedOperationException("no implements");
    }

    @Override
    public List<Ty> getByIndex(Set<String> selectFields, Integer start, Integer count, String inField, List indexes) {
        throw new UnsupportedOperationException("no implements");
    }

    @Override
    public List<Ty> getByIndex(Set<String> selectFields, String inField, List indexes) {
        throw new UnsupportedOperationException("no implements");
    }

    @Override
    public List<Ty> getByCond(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, Ty instance) {
        throw new UnsupportedOperationException("no implements");
    }

    @Override
    public List<Ty> getByCond(Set<String> selectFields, Integer start, Integer count, Ty instance) {
        throw new UnsupportedOperationException("no implements");
    }

    @Override
    public List<Ty> getByCond(Set<String> selectFields, Ty instance) {
        throw new UnsupportedOperationException("no implements");
    }

    @Override
    public List<Ty> getByWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, Map<String, Object> extParam, Set<String> extCondition) {
        throw new UnsupportedOperationException("no implements");
    }

    @Override
    public List<Ty> getByWhere(Set<String> selectFields, Integer start, Integer count, Map<String, Object> extParam, Set<String> extCondition) {
        throw new UnsupportedOperationException("no implements");
    }

    @Override
    public List<Ty> getByWhere(Set<String> selectFields, Map<String, Object> extParam, Set<String> extCondition) {
        throw new UnsupportedOperationException("no implements");
    }

    @Override
    public List<Ty> getByCondAndIndex(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, Ty instance, String inField, List indexes) {
        throw new UnsupportedOperationException("no implements");
    }

    @Override
    public List<Ty> getByCondAndIndex(Set<String> selectFields, Integer start, Integer count, Ty instance, String inField, List indexes) {
        throw new UnsupportedOperationException("no implements");
    }

    @Override
    public List<Ty> getByCondAndIndex(Set<String> selectFields, Ty instance, String inField, List indexes) {
        throw new UnsupportedOperationException("no implements");
    }

    @Override
    public List<Ty> getByIdAndIndexAndWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, List<Integer> id, Map<String, Object> extParam, Set<String> extCondition) {
        throw new UnsupportedOperationException("no implements");
    }

    @Override
    public List<Ty> getByIdAndIndexAndWhere(Set<String> selectFields, Integer start, Integer count, List<Integer> id, Map<String, Object> extParam, Set<String> extCondition) {
        throw new UnsupportedOperationException("no implements");
    }

    @Override
    public List<Ty> getByIdAndIndexAndWhere(Set<String> selectFields, List<Integer> id, Map<String, Object> extParam, Set<String> extCondition) {
        throw new UnsupportedOperationException("no implements");
    }

    @Override
    public List<Ty> getByIndexAndWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        throw new UnsupportedOperationException("no implements");
    }

    @Override
    public List<Ty> getByIndexAndWhere(Set<String> selectFields, Integer start, Integer count, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        throw new UnsupportedOperationException("no implements");
    }

    @Override
    public List<Ty> getByIndexAndWhere(Set<String> selectFields, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        throw new UnsupportedOperationException("no implements");
    }

    @Override
    public List<Ty> getByCondAndWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, Ty instance, Map<String, Object> extParam, Set<String> extCondition) {
        throw new UnsupportedOperationException("no implements");
    }

    @Override
    public List<Ty> getByCondAndWhere(Set<String> selectFields, Integer start, Integer count, Ty instance, Map<String, Object> extParam, Set<String> extCondition) {
        throw new UnsupportedOperationException("no implements");
    }

    @Override
    public List<Ty> getByCondAndWhere(Set<String> selectFields, Ty instance, Map<String, Object> extParam, Set<String> extCondition) {
        throw new UnsupportedOperationException("no implements");
    }

    @Override
    public List<Ty> getByCondAndIndexAndWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, Ty instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        throw new UnsupportedOperationException("no implements");
    }

    @Override
    public List<Ty> getByCondAndIndexAndWhere(Set<String> selectFields, Integer start, Integer count, Ty instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        throw new UnsupportedOperationException("no implements");
    }

    @Override
    public List<Ty> getByCondAndIndexAndWhere(Set<String> selectFields, Ty instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        throw new UnsupportedOperationException("no implements");
    }

//    @Override
//    public Ty getOneById(Set<String> selectFields, DaoAssembler assembler, Integer id){throw new UnsupportedOperationException("no implements"); }
//
//    @Override
//    public Ty getOneById(Set<String> selectFields, Integer id){throw new UnsupportedOperationException("no implements"); }

    @Override
    public Ty getOneByCond(Set<String> selectFields, DaoAssembler assembler, Ty instance) {
        throw new UnsupportedOperationException("no implements");
    }

    @Override
    public Ty getOneByCond(Set<String> selectFields, Ty instance) {
        throw new UnsupportedOperationException("no implements");
    }

    @Override
    public Ty getOneByWhere(Set<String> selectFields, DaoAssembler assembler, Map<String, Object> extParam, Set<String> extCondition) {
        throw new UnsupportedOperationException("no implements");
    }

    @Override
    public Ty getOneByWhere(Set<String> selectFields, Map<String, Object> extParam, Set<String> extCondition) {
        throw new UnsupportedOperationException("no implements");
    }

    @Override
    public Ty getOneByCondAndWhere(Set<String> selectFields, DaoAssembler assembler, Ty instance, Map<String, Object> extParam, Set<String> extCondition) {
        throw new UnsupportedOperationException("no implements");
    }

    @Override
    public Ty getOneByCondAndWhere(Set<String> selectFields, Ty instance, Map<String, Object> extParam, Set<String> extCondition) {
        throw new UnsupportedOperationException("no implements");
    }

    @Override
    public Long getCountByCond(DaoAssembler assembler, Ty instance) {
        throw new UnsupportedOperationException("no implements");
    }

    @Override
    public Long getCountByCond(Ty instance) {
        throw new UnsupportedOperationException("no implements");
    }

    @Override
    public Long getCountByCondAndIndex(DaoAssembler assembler, Ty instance, String inField, List indexes) {
        throw new UnsupportedOperationException("no implements");
    }

    @Override
    public Long getCountByCondAndIndex(Ty instance, String inField, List indexes) {
        throw new UnsupportedOperationException("no implements");
    }

    @Override
    public Long getCountByCondAndIndexAndWhere(DaoAssembler assembler, Ty instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        throw new UnsupportedOperationException("no implements");
    }

    @Override
    public Long getCountByCondAndIndexAndWhere(Ty instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        throw new UnsupportedOperationException("no implements");
    }

    @Override
    public <Tx> Tx getItemByIndex(DaoAssembler assembler, String inField, List indexes, Class<Tx> tClass, String rawItem) {
        throw new UnsupportedOperationException("no implements");
    }

    @Override
    public <Tx> Tx getItemByIndex(String inField, List indexes, Class<Tx> tClass, String rawItem) {
        throw new UnsupportedOperationException("no implements");
    }

    @Override
    public <Tx> Tx getItemByCond(DaoAssembler assembler, Ty instance, Class<Tx> tClass, String rawItem) {
        throw new UnsupportedOperationException("no implements");
    }

    @Override
    public <Tx> Tx getItemByCond(Ty instance, Class<Tx> tClass, String rawItem) {
        throw new UnsupportedOperationException("no implements");
    }

    @Override
    public <Tx> Tx getItemByCondAndIndex(DaoAssembler assembler, Ty instance, String inField, List indexes, Class<Tx> tClass, String rawItem) {
        throw new UnsupportedOperationException("no implements");
    }

    @Override
    public <Tx> Tx getItemByCondAndIndex(Ty instance, String inField, List indexes, Class<Tx> tClass, String rawItem) {
        throw new UnsupportedOperationException("no implements");
    }

    @Override
    public <Tx> Tx getItemByCondAndIndexAndWhere(DaoAssembler assembler, Ty instance, String inField, List indexes, Class<Tx> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        throw new UnsupportedOperationException("no implements");
    }

    @Override
    public <Tx> Tx getItemByCondAndIndexAndWhere(Ty instance, String inField, List indexes, Class<Tx> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        throw new UnsupportedOperationException("no implements");
    }

    @Override
    public Ty insert(Ty instance, DaoAssembler assembler) {
        throw new UnsupportedOperationException("no implements");
    }

    @Override
    public Ty insert(Ty instance) {
        throw new UnsupportedOperationException("no implements");
    }

    @Override
    public Integer insert(List<Ty> instances, Set<String> fields, DaoAssembler assembler) {
        throw new UnsupportedOperationException("no implements");
    }

    @Override
    public Integer insert(List<Ty> instances, Set<String> fields) {
        throw new UnsupportedOperationException("no implements");
    }

    @Override
    public Integer insert(List<Ty> instances) {
        throw new UnsupportedOperationException("no implements");
    }

    @Override
    public Integer update(Ty instance, Set<String> conditionField, DaoAssembler assembler) {
        throw new UnsupportedOperationException("no implements");
    }

    @Override
    public Integer update(Ty instance, Set<String> conditionField) {
        throw new UnsupportedOperationException("no implements");
    }

    @Override
    public Integer updateById(Ty instance, DaoAssembler assembler) {
        throw new UnsupportedOperationException("no implements");
    }

    @Override
    public Integer updateById(Ty instance) {
        throw new UnsupportedOperationException("no implements");
    }

    @Override
    public Integer updateByIds(Ty instance, Set<Integer> ids, DaoAssembler assembler) {
        throw new UnsupportedOperationException("no implements");
    }

    @Override
    public Integer updateByIds(Ty instance, Set<Integer> ids) {
        throw new UnsupportedOperationException("no implements");
    }

    @Override
    public Integer delete(Ty instance, Set<String> conditionField, DaoAssembler assembler) {
        throw new UnsupportedOperationException("no implements");
    }

    @Override
    public Integer delete(Ty instance, Set<String> conditionField) {
        throw new UnsupportedOperationException("no implements");
    }

    @Override
    public Integer deleteById(Integer id, DaoAssembler assembler) {
        throw new UnsupportedOperationException("no implements");
    }

    @Override
    public Integer deleteById(Integer id) {
        throw new UnsupportedOperationException("no implements");
    }

    @Override
    public Integer deleteByIds(Set<Integer> ids, DaoAssembler assembler) {
        throw new UnsupportedOperationException("no implements");
    }

    @Override
    public Integer deleteByIds(Set<Integer> ids) {
        throw new UnsupportedOperationException("no implements");
    }

    @Override
    public Ty updateOrInsert(Ty instance, Set<String> conditionField, AbstractMultipleDaoAssembler assembler) {
        throw new UnsupportedOperationException("no implements");
    }

    @Override
    public Ty updateOrInsert(Ty instance, Set<String> conditionField) {
        throw new UnsupportedOperationException("no implements");
    }

    @Override
    public Ty insertIfNoExist(Ty instance, Set<String> conditionField, AbstractMultipleDaoAssembler assembler) {
        throw new UnsupportedOperationException("no implements");
    }

    @Override
    public Ty insertIfNoExist(Ty instance, Set<String> conditionField) {
        throw new UnsupportedOperationException("no implements");
    }

    @Override
    public <Tx> Map<Tx, Ty> buildMap(List<Ty> list, String field) {
        throw new UnsupportedOperationException("no implements");
    }

    @Override
    public <Tx> Map<Tx, List<Ty>> buildListMap(List<Ty> list, String field) {
        throw new UnsupportedOperationException("no implements");
    }

    @Override
    public <Tx> List<Tx> extractItemAsList(List<Ty> list, String field) {
        throw new UnsupportedOperationException("no implements");
    }


    @Override
    public Ty getOneById(Set<String> selectFields, DaoAssembler assembler, TT id) {
        throw new UnsupportedOperationException("no implements");
    }

    @Override
    public Ty getOneById(Set<String> selectFields, TT id) {
        throw new UnsupportedOperationException("no implements");
    }

    @Override
    public Ty getOneById(TT id) {
        throw new UnsupportedOperationException("no implements");
    }

    @Override
    public List<Ty> getById(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, List<TT> id) {
        throw new UnsupportedOperationException("no implements");
    }

    @Override
    public List<Ty> getById(Set<String> selectFields, Integer start, Integer count, List<TT> id) {
        throw new UnsupportedOperationException("no implements");
    }

    @Override
    public List<Ty> getById(Set<String> selectFields, List<TT> id) {
        throw new UnsupportedOperationException("no implements");
    }

    @Override
    public List<Ty> getById(List<TT> id) {
        throw new UnsupportedOperationException("no implements");
    }

    @Override
    public List<Ty> getByCond(Ty instance) { throw new UnsupportedOperationException("no implements"); }

    @Override
    public List<Ty> getByIndex(String inField, List indexes) {
        throw new UnsupportedOperationException("no implements");
    }

    @Override
    public <Tx> Tx getItemByWhere(DaoAssembler assembler, Class<Tx> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        throw new UnsupportedOperationException("no implements");
    }

    @Override
    public <Tx> Tx getItemByWhere(Class<Tx> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        throw new UnsupportedOperationException("no implements");
    }*/
}
