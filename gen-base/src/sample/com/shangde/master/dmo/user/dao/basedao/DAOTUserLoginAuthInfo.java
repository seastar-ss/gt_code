package com.shangde.master.dmo.user.dao.basedao;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import com.shangde.master.dmo.user.dto.basedto.ModelTUserLoginAuthInfo.ResultSetMapperModelTUserLoginAuthInfo;
import com.shawn.ss.lib.tools.CollectionHelper;
import com.shawn.ss.lib.tools.TypeConstantHelper;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.SimpleDbInterface;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model.ColumnDataType;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model.LogicalOpType;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model.LogicalRelationshipType;
import com.shawn.ss.lib.tools.db.dto_base.model.AbstractBaseModel;
import com.shawn.ss.lib.tools.service_assemble.BaseDaoAssembler;
import com.shawn.ss.lib.tools.service_assemble.DaoAssembler;
import com.shawn.ss.lib.tools.sql_code_gen.api.SQL;
import com.shawn.ss.lib.tools.sql_code_gen.api.SQLInsert;
import com.shawn.ss.lib.tools.sql_code_gen.api.SQLSelect;
import com.shawn.ss.lib.tools.sql_code_gen.api.SQLUpdate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.shangde.master.dmo.user.dto.basedto.ModelTUserLoginAuthInfo;

@Repository("DAOTUserLoginAuthInfo")
public class DAOTUserLoginAuthInfo {
    public final static Logger logger = LoggerFactory.getLogger(DAOTUserLoginAuthInfo.class);
    @Autowired(required = true)
    protected SimpleDbInterface db;

    public List<ModelTUserLoginAuthInfo> getByIds(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, List<Integer> id) {
        if (assembler == null) {
            assembler = new BaseDaoAssembler();
        }
        if (selectFields == null) {
            selectFields = ModelTUserLoginAuthInfo.FIELD_CLASS.keySet();
        }
        String sql;
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelTUserLoginAuthInfo.DTO_TABLE_NAME);
        if (start == null) {
            start = AbstractBaseModel.DEFAULT_START;
        }
        if (count == null) {
            count = AbstractBaseModel.DEFUALT_COUNT;
        }
        Map<String, Object> param = CollectionHelper.newMap();
        param.put("id", id);
        param.put("start", start);
        param.put("count", count);
        if (selectFields.contains(ModelTUserLoginAuthInfo.FI_ID)) {
            sqlBuilder.items(ModelTUserLoginAuthInfo.FI_ID);
        }
        if (selectFields.contains(ModelTUserLoginAuthInfo.FI_USER_ID)) {
            sqlBuilder.items(ModelTUserLoginAuthInfo.FI_USER_ID);
        }
        if (selectFields.contains(ModelTUserLoginAuthInfo.FI_TYPE)) {
            sqlBuilder.items(ModelTUserLoginAuthInfo.FI_TYPE);
        }
        if (selectFields.contains(ModelTUserLoginAuthInfo.FI_CREATE_TIME)) {
            sqlBuilder.items(ModelTUserLoginAuthInfo.FI_CREATE_TIME);
        }
        if (selectFields.contains(ModelTUserLoginAuthInfo.FI_DELETE_FLAG)) {
            sqlBuilder.items(ModelTUserLoginAuthInfo.FI_DELETE_FLAG);
        }
        sqlBuilder.where(LogicalRelationshipType.and, LogicalOpType.in, null, ModelTUserLoginAuthInfo.FI_ID, ModelTUserLoginAuthInfo.FI_ID, ColumnDataType.intData);
        sqlBuilder.setLimit();
        assembler.assembleSql(sqlBuilder, param, ModelTUserLoginAuthInfo.class);
        sql = sqlBuilder.getSql(null);
        logger.info("execute sql:{}\nwith param:{}", sql, param);
        ResultSetMapperModelTUserLoginAuthInfo<ModelTUserLoginAuthInfo> rsMapper = ((ResultSetMapperModelTUserLoginAuthInfo<ModelTUserLoginAuthInfo> ) assembler.<ModelTUserLoginAuthInfo> assembleResultSetMapper(param, ModelTUserLoginAuthInfo.class));
        if (rsMapper == null) {
            rsMapper = ModelTUserLoginAuthInfo.RESULT_SET_OBJ_MAPPER;
        }
        try {
            return db.query(sql, param, rsMapper);
        } catch (final Exception ex) {
            logger.error("sql execption", ex);
            return null;
        }
    }

    public List<ModelTUserLoginAuthInfo> getByIds(Set<String> selectFields, Integer start, Integer count, List<Integer> id) {
        return getByIds(selectFields, null, start, count, id);
    }

    public List<ModelTUserLoginAuthInfo> getByIds(Integer start, Integer count, List<Integer> id) {
        return getByIds(null, start, count, id);
    }

    public List<ModelTUserLoginAuthInfo> getByIds(List<Integer> id) {
        return getByIds(null, null, id);
    }

    public List<ModelTUserLoginAuthInfo> getAll(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count) {
        if (assembler == null) {
            assembler = new BaseDaoAssembler();
        }
        if (selectFields == null) {
            selectFields = ModelTUserLoginAuthInfo.FIELD_CLASS.keySet();
        }
        String sql;
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelTUserLoginAuthInfo.DTO_TABLE_NAME);
        if (start == null) {
            start = AbstractBaseModel.DEFAULT_START;
        }
        if (count == null) {
            count = AbstractBaseModel.DEFUALT_COUNT;
        }
        Map<String, Object> param = CollectionHelper.newMap();
        param.put("start", start);
        param.put("count", count);
        if (selectFields.contains(ModelTUserLoginAuthInfo.FI_ID)) {
            sqlBuilder.items(ModelTUserLoginAuthInfo.FI_ID);
        }
        if (selectFields.contains(ModelTUserLoginAuthInfo.FI_USER_ID)) {
            sqlBuilder.items(ModelTUserLoginAuthInfo.FI_USER_ID);
        }
        if (selectFields.contains(ModelTUserLoginAuthInfo.FI_TYPE)) {
            sqlBuilder.items(ModelTUserLoginAuthInfo.FI_TYPE);
        }
        if (selectFields.contains(ModelTUserLoginAuthInfo.FI_CREATE_TIME)) {
            sqlBuilder.items(ModelTUserLoginAuthInfo.FI_CREATE_TIME);
        }
        if (selectFields.contains(ModelTUserLoginAuthInfo.FI_DELETE_FLAG)) {
            sqlBuilder.items(ModelTUserLoginAuthInfo.FI_DELETE_FLAG);
        }
        sqlBuilder.setLimit();
        assembler.assembleSql(sqlBuilder, param, ModelTUserLoginAuthInfo.class);
        sql = sqlBuilder.getSql(null);
        logger.info("execute sql:{}\nwith param:{}", sql, param);
        ResultSetMapperModelTUserLoginAuthInfo<ModelTUserLoginAuthInfo> rsMapper = ((ResultSetMapperModelTUserLoginAuthInfo<ModelTUserLoginAuthInfo> ) assembler.<ModelTUserLoginAuthInfo> assembleResultSetMapper(param, ModelTUserLoginAuthInfo.class));
        if (rsMapper == null) {
            rsMapper = ModelTUserLoginAuthInfo.RESULT_SET_OBJ_MAPPER;
        }
        try {
            return db.query(sql, param, rsMapper);
        } catch (final Exception ex) {
            logger.error("sql execption", ex);
            return null;
        }
    }

    public List<ModelTUserLoginAuthInfo> getAll(Set<String> selectFields, Integer start, Integer count) {
        return getAll(selectFields, null, start, count);
    }

    public List<ModelTUserLoginAuthInfo> getAll(Integer start, Integer count) {
        return getAll(null, start, count);
    }

    public List<ModelTUserLoginAuthInfo> getAll() {
        return getAll(null, null);
    }

    public ModelTUserLoginAuthInfo getById(Set<String> selectFields, DaoAssembler assembler, Integer id) {
        if (assembler == null) {
            assembler = new BaseDaoAssembler();
        }
        if (selectFields == null) {
            selectFields = ModelTUserLoginAuthInfo.FIELD_CLASS.keySet();
        }
        String sql;
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelTUserLoginAuthInfo.DTO_TABLE_NAME);
        Integer start = 0;
        Integer count = 1;
        Map<String, Object> param = CollectionHelper.newMap();
        param.put("id", id);
        param.put("start", start);
        param.put("count", count);
        if (selectFields.contains(ModelTUserLoginAuthInfo.FI_ID)) {
            sqlBuilder.items(ModelTUserLoginAuthInfo.FI_ID);
        }
        if (selectFields.contains(ModelTUserLoginAuthInfo.FI_USER_ID)) {
            sqlBuilder.items(ModelTUserLoginAuthInfo.FI_USER_ID);
        }
        if (selectFields.contains(ModelTUserLoginAuthInfo.FI_TYPE)) {
            sqlBuilder.items(ModelTUserLoginAuthInfo.FI_TYPE);
        }
        if (selectFields.contains(ModelTUserLoginAuthInfo.FI_CREATE_TIME)) {
            sqlBuilder.items(ModelTUserLoginAuthInfo.FI_CREATE_TIME);
        }
        if (selectFields.contains(ModelTUserLoginAuthInfo.FI_DELETE_FLAG)) {
            sqlBuilder.items(ModelTUserLoginAuthInfo.FI_DELETE_FLAG);
        }
        sqlBuilder.where(ModelTUserLoginAuthInfo.FI_ID, ColumnDataType.intData);
        sqlBuilder.setLimit();
        assembler.assembleSql(sqlBuilder, param, ModelTUserLoginAuthInfo.class);
        sql = sqlBuilder.getSql(null);
        logger.info("execute sql:{}\nwith param:{}", sql, param);
        ResultSetMapperModelTUserLoginAuthInfo<ModelTUserLoginAuthInfo> rsMapper = ((ResultSetMapperModelTUserLoginAuthInfo<ModelTUserLoginAuthInfo> ) assembler.<ModelTUserLoginAuthInfo> assembleResultSetMapper(param, ModelTUserLoginAuthInfo.class));
        if (rsMapper == null) {
            rsMapper = ModelTUserLoginAuthInfo.RESULT_SET_OBJ_MAPPER;
        }
        try {
            return db.queryForObject(sql, param, rsMapper);
        } catch (final Exception ex) {
            logger.error("sql execption", ex);
            return null;
        }
    }

    public ModelTUserLoginAuthInfo getById(Set<String> selectFields, Integer id) {
        return getById(selectFields, null, id);
    }

    public ModelTUserLoginAuthInfo getById(Integer id) {
        return getById(null, id);
    }

    public List<ModelTUserLoginAuthInfo> getByIndexes(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, String inField, List indexes) {
        if (assembler == null) {
            assembler = new BaseDaoAssembler();
        }
        if (selectFields == null) {
            selectFields = ModelTUserLoginAuthInfo.FIELD_CLASS.keySet();
        }
        String sql;
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelTUserLoginAuthInfo.DTO_TABLE_NAME);
        if (start == null) {
            start = AbstractBaseModel.DEFAULT_START;
        }
        if (count == null) {
            count = AbstractBaseModel.DEFUALT_COUNT;
        }
        Map<String, Object> param = CollectionHelper.newMap();
        param.put("start", start);
        param.put("count", count);
        if (selectFields.contains(ModelTUserLoginAuthInfo.FI_ID)) {
            sqlBuilder.items(ModelTUserLoginAuthInfo.FI_ID);
        }
        if (selectFields.contains(ModelTUserLoginAuthInfo.FI_USER_ID)) {
            sqlBuilder.items(ModelTUserLoginAuthInfo.FI_USER_ID);
        }
        if (selectFields.contains(ModelTUserLoginAuthInfo.FI_TYPE)) {
            sqlBuilder.items(ModelTUserLoginAuthInfo.FI_TYPE);
        }
        if (selectFields.contains(ModelTUserLoginAuthInfo.FI_CREATE_TIME)) {
            sqlBuilder.items(ModelTUserLoginAuthInfo.FI_CREATE_TIME);
        }
        if (selectFields.contains(ModelTUserLoginAuthInfo.FI_DELETE_FLAG)) {
            sqlBuilder.items(ModelTUserLoginAuthInfo.FI_DELETE_FLAG);
        }
        if (ModelTUserLoginAuthInfo.FIELD_CLASS.containsKey(inField)) {
            Object fieldClassObj = ModelTUserLoginAuthInfo.FIELD_CLASS.get(inField);
            if (fieldClassObj instanceof Class) {
                Class fieldClass = ((Class) fieldClassObj);
                param.put("fields", indexes);
                sqlBuilder.where(LogicalRelationshipType.and, LogicalOpType.in, null, inField, "fields", ColumnDataType.getType(fieldClass));
            } else {
                return null;
            }
        } else {
            return null;
        }
        sqlBuilder.setLimit();
        assembler.assembleSql(sqlBuilder, param, ModelTUserLoginAuthInfo.class);
        sql = sqlBuilder.getSql(null);
        logger.info("execute sql:{}\nwith param:{}", sql, param);
        ResultSetMapperModelTUserLoginAuthInfo<ModelTUserLoginAuthInfo> rsMapper = ((ResultSetMapperModelTUserLoginAuthInfo<ModelTUserLoginAuthInfo> ) assembler.<ModelTUserLoginAuthInfo> assembleResultSetMapper(param, ModelTUserLoginAuthInfo.class));
        if (rsMapper == null) {
            rsMapper = ModelTUserLoginAuthInfo.RESULT_SET_OBJ_MAPPER;
        }
        try {
            return db.query(sql, param, rsMapper);
        } catch (final Exception ex) {
            logger.error("sql execption", ex);
            return null;
        }
    }

    public List<ModelTUserLoginAuthInfo> getByIndexes(Set<String> selectFields, Integer start, Integer count, String inField, List indexes) {
        return getByIndexes(selectFields, null, start, count, inField, indexes);
    }

    public List<ModelTUserLoginAuthInfo> getByIndexes(Integer start, Integer count, String inField, List indexes) {
        return getByIndexes(null, start, count, inField, indexes);
    }

    public List<ModelTUserLoginAuthInfo> getByIndexes(String inField, List indexes) {
        return getByIndexes(null, null, inField, indexes);
    }

    public ModelTUserLoginAuthInfo getOneByCondition(Set<String> selectFields, DaoAssembler assembler, ModelTUserLoginAuthInfo instance) {
        if (assembler == null) {
            assembler = new BaseDaoAssembler();
        }
        if (selectFields == null) {
            selectFields = ModelTUserLoginAuthInfo.FIELD_CLASS.keySet();
        }
        String sql;
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelTUserLoginAuthInfo.DTO_TABLE_NAME);
        Integer start = 0;
        Integer count = 1;
        Map<String, Object> param = CollectionHelper.newMap();
        param.put("start", start);
        param.put("count", count);
        if (selectFields.contains(ModelTUserLoginAuthInfo.FI_ID)) {
            sqlBuilder.items(ModelTUserLoginAuthInfo.FI_ID);
        }
        Integer dId = instance.getId();
        if (dId!= null) {
            sqlBuilder.where(ModelTUserLoginAuthInfo.FI_ID, ColumnDataType.intData);
            param.put(ModelTUserLoginAuthInfo.FI_ID, dId);
        }
        if (selectFields.contains(ModelTUserLoginAuthInfo.FI_USER_ID)) {
            sqlBuilder.items(ModelTUserLoginAuthInfo.FI_USER_ID);
        }
        Integer dUser_id = instance.getUserId();
        if (dUser_id!= null) {
            sqlBuilder.where(ModelTUserLoginAuthInfo.FI_USER_ID, ColumnDataType.intData);
            param.put(ModelTUserLoginAuthInfo.FI_USER_ID, dUser_id);
        }
        if (selectFields.contains(ModelTUserLoginAuthInfo.FI_TYPE)) {
            sqlBuilder.items(ModelTUserLoginAuthInfo.FI_TYPE);
        }
        Byte dType = instance.getType();
        if (dType!= null) {
            sqlBuilder.where(ModelTUserLoginAuthInfo.FI_TYPE, ColumnDataType.byteData);
            param.put(ModelTUserLoginAuthInfo.FI_TYPE, dType);
        }
        if (selectFields.contains(ModelTUserLoginAuthInfo.FI_CREATE_TIME)) {
            sqlBuilder.items(ModelTUserLoginAuthInfo.FI_CREATE_TIME);
        }
        Date dCreate_time = instance.getCreateTime();
        if (dCreate_time!= null) {
            sqlBuilder.where(ModelTUserLoginAuthInfo.FI_CREATE_TIME, ColumnDataType.timeStampData);
            param.put(ModelTUserLoginAuthInfo.FI_CREATE_TIME, dCreate_time);
        }
        if (selectFields.contains(ModelTUserLoginAuthInfo.FI_DELETE_FLAG)) {
            sqlBuilder.items(ModelTUserLoginAuthInfo.FI_DELETE_FLAG);
        }
        Byte dDelete_flag = instance.getDeleteFlag();
        if (dDelete_flag!= null) {
            sqlBuilder.where(ModelTUserLoginAuthInfo.FI_DELETE_FLAG, ColumnDataType.byteData);
            param.put(ModelTUserLoginAuthInfo.FI_DELETE_FLAG, dDelete_flag);
        }
        sqlBuilder.setLimit();
        assembler.assembleSql(sqlBuilder, param, ModelTUserLoginAuthInfo.class);
        sql = sqlBuilder.getSql(null);
        logger.info("execute sql:{}\nwith param:{}", sql, param);
        ResultSetMapperModelTUserLoginAuthInfo<ModelTUserLoginAuthInfo> rsMapper = ((ResultSetMapperModelTUserLoginAuthInfo<ModelTUserLoginAuthInfo> ) assembler.<ModelTUserLoginAuthInfo> assembleResultSetMapper(param, ModelTUserLoginAuthInfo.class));
        if (rsMapper == null) {
            rsMapper = ModelTUserLoginAuthInfo.RESULT_SET_OBJ_MAPPER;
        }
        try {
            return db.queryForObject(sql, param, rsMapper);
        } catch (final Exception ex) {
            logger.error("sql execption", ex);
            return null;
        }
    }

    public ModelTUserLoginAuthInfo getOneByCondition(Set<String> selectFields, ModelTUserLoginAuthInfo instance) {
        return getOneByCondition(selectFields, null, instance);
    }

    public ModelTUserLoginAuthInfo getOneByCondition(ModelTUserLoginAuthInfo instance) {
        return getOneByCondition(null, instance);
    }

    public List<ModelTUserLoginAuthInfo> getByCondition(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, ModelTUserLoginAuthInfo instance) {
        if (assembler == null) {
            assembler = new BaseDaoAssembler();
        }
        if (selectFields == null) {
            selectFields = ModelTUserLoginAuthInfo.FIELD_CLASS.keySet();
        }
        String sql;
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelTUserLoginAuthInfo.DTO_TABLE_NAME);
        if (start == null) {
            start = AbstractBaseModel.DEFAULT_START;
        }
        if (count == null) {
            count = AbstractBaseModel.DEFUALT_COUNT;
        }
        Map<String, Object> param = CollectionHelper.newMap();
        param.put("start", start);
        param.put("count", count);
        if (selectFields.contains(ModelTUserLoginAuthInfo.FI_ID)) {
            sqlBuilder.items(ModelTUserLoginAuthInfo.FI_ID);
        }
        Integer dId = instance.getId();
        if (dId!= null) {
            sqlBuilder.where(ModelTUserLoginAuthInfo.FI_ID, ColumnDataType.intData);
            param.put(ModelTUserLoginAuthInfo.FI_ID, dId);
        }
        if (selectFields.contains(ModelTUserLoginAuthInfo.FI_USER_ID)) {
            sqlBuilder.items(ModelTUserLoginAuthInfo.FI_USER_ID);
        }
        Integer dUser_id = instance.getUserId();
        if (dUser_id!= null) {
            sqlBuilder.where(ModelTUserLoginAuthInfo.FI_USER_ID, ColumnDataType.intData);
            param.put(ModelTUserLoginAuthInfo.FI_USER_ID, dUser_id);
        }
        if (selectFields.contains(ModelTUserLoginAuthInfo.FI_TYPE)) {
            sqlBuilder.items(ModelTUserLoginAuthInfo.FI_TYPE);
        }
        Byte dType = instance.getType();
        if (dType!= null) {
            sqlBuilder.where(ModelTUserLoginAuthInfo.FI_TYPE, ColumnDataType.byteData);
            param.put(ModelTUserLoginAuthInfo.FI_TYPE, dType);
        }
        if (selectFields.contains(ModelTUserLoginAuthInfo.FI_CREATE_TIME)) {
            sqlBuilder.items(ModelTUserLoginAuthInfo.FI_CREATE_TIME);
        }
        Date dCreate_time = instance.getCreateTime();
        if (dCreate_time!= null) {
            sqlBuilder.where(ModelTUserLoginAuthInfo.FI_CREATE_TIME, ColumnDataType.timeStampData);
            param.put(ModelTUserLoginAuthInfo.FI_CREATE_TIME, dCreate_time);
        }
        if (selectFields.contains(ModelTUserLoginAuthInfo.FI_DELETE_FLAG)) {
            sqlBuilder.items(ModelTUserLoginAuthInfo.FI_DELETE_FLAG);
        }
        Byte dDelete_flag = instance.getDeleteFlag();
        if (dDelete_flag!= null) {
            sqlBuilder.where(ModelTUserLoginAuthInfo.FI_DELETE_FLAG, ColumnDataType.byteData);
            param.put(ModelTUserLoginAuthInfo.FI_DELETE_FLAG, dDelete_flag);
        }
        sqlBuilder.setLimit();
        assembler.assembleSql(sqlBuilder, param, ModelTUserLoginAuthInfo.class);
        sql = sqlBuilder.getSql(null);
        logger.info("execute sql:{}\nwith param:{}", sql, param);
        ResultSetMapperModelTUserLoginAuthInfo<ModelTUserLoginAuthInfo> rsMapper = ((ResultSetMapperModelTUserLoginAuthInfo<ModelTUserLoginAuthInfo> ) assembler.<ModelTUserLoginAuthInfo> assembleResultSetMapper(param, ModelTUserLoginAuthInfo.class));
        if (rsMapper == null) {
            rsMapper = ModelTUserLoginAuthInfo.RESULT_SET_OBJ_MAPPER;
        }
        try {
            return db.query(sql, param, rsMapper);
        } catch (final Exception ex) {
            logger.error("sql execption", ex);
            return null;
        }
    }

    public List<ModelTUserLoginAuthInfo> getByCondition(Set<String> selectFields, Integer start, Integer count, ModelTUserLoginAuthInfo instance) {
        return getByCondition(selectFields, null, start, count, instance);
    }

    public List<ModelTUserLoginAuthInfo> getByCondition(Integer start, Integer count, ModelTUserLoginAuthInfo instance) {
        return getByCondition(null, start, count, instance);
    }

    public List<ModelTUserLoginAuthInfo> getByCondition(ModelTUserLoginAuthInfo instance) {
        return getByCondition(null, null, instance);
    }

    public Long getCountByCondition(Set<String> selectFields, DaoAssembler assembler, ModelTUserLoginAuthInfo instance) {
        if (assembler == null) {
            assembler = new BaseDaoAssembler();
        }
        if (selectFields == null) {
            selectFields = ModelTUserLoginAuthInfo.FIELD_CLASS.keySet();
        }
        String sql;
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelTUserLoginAuthInfo.DTO_TABLE_NAME);
        Integer start = 0;
        Integer count = 1;
        Map<String, Object> param = CollectionHelper.newMap();
        param.put("start", start);
        param.put("count", count);
        sqlBuilder.funcItems("count", "count");
        Integer dId = instance.getId();
        if (dId!= null) {
            sqlBuilder.where(ModelTUserLoginAuthInfo.FI_ID, ColumnDataType.intData);
            param.put(ModelTUserLoginAuthInfo.FI_ID, dId);
        }
        Integer dUser_id = instance.getUserId();
        if (dUser_id!= null) {
            sqlBuilder.where(ModelTUserLoginAuthInfo.FI_USER_ID, ColumnDataType.intData);
            param.put(ModelTUserLoginAuthInfo.FI_USER_ID, dUser_id);
        }
        Byte dType = instance.getType();
        if (dType!= null) {
            sqlBuilder.where(ModelTUserLoginAuthInfo.FI_TYPE, ColumnDataType.byteData);
            param.put(ModelTUserLoginAuthInfo.FI_TYPE, dType);
        }
        Date dCreate_time = instance.getCreateTime();
        if (dCreate_time!= null) {
            sqlBuilder.where(ModelTUserLoginAuthInfo.FI_CREATE_TIME, ColumnDataType.timeStampData);
            param.put(ModelTUserLoginAuthInfo.FI_CREATE_TIME, dCreate_time);
        }
        Byte dDelete_flag = instance.getDeleteFlag();
        if (dDelete_flag!= null) {
            sqlBuilder.where(ModelTUserLoginAuthInfo.FI_DELETE_FLAG, ColumnDataType.byteData);
            param.put(ModelTUserLoginAuthInfo.FI_DELETE_FLAG, dDelete_flag);
        }
        sqlBuilder.setLimit();
        assembler.assembleSql(sqlBuilder, param, ModelTUserLoginAuthInfo.class);
        sql = sqlBuilder.getSql(null);
        logger.info("execute sql:{}\nwith param:{}", sql, param);
        try {
            return db.queryForObject(sql, param, Long.class);
        } catch (final Exception ex) {
            logger.error("sql execption", ex);
            return null;
        }
    }

    public Long getCountByCondition(Set<String> selectFields, ModelTUserLoginAuthInfo instance) {
        return getCountByCondition(selectFields, null, instance);
    }

    public Long getCountByCondition(ModelTUserLoginAuthInfo instance) {
        return getCountByCondition(null, instance);
    }

    public ModelTUserLoginAuthInfo insert(ModelTUserLoginAuthInfo instance, DaoAssembler assembler) {
        if (assembler == null) {
            assembler = new BaseDaoAssembler();
        }
        String sql;
        SQLInsert sqlBuilder = SQL.buildInsertSql(ModelTUserLoginAuthInfo.DTO_TABLE_NAME);
        Integer dId = instance.getId();
        if (dId!= null) {
            sqlBuilder.items(ModelTUserLoginAuthInfo.FI_ID);
        }
        Integer dUser_id = instance.getUserId();
        if (dUser_id!= null) {
            sqlBuilder.items(ModelTUserLoginAuthInfo.FI_USER_ID);
        }
        Byte dType = instance.getType();
        if (dType!= null) {
            sqlBuilder.items(ModelTUserLoginAuthInfo.FI_TYPE);
        }
        Date dCreate_time = instance.getCreateTime();
        if (dCreate_time!= null) {
            sqlBuilder.items(ModelTUserLoginAuthInfo.FI_CREATE_TIME);
        }
        Byte dDelete_flag = instance.getDeleteFlag();
        if (dDelete_flag!= null) {
            sqlBuilder.items(ModelTUserLoginAuthInfo.FI_DELETE_FLAG);
        }
        Map<String, Object> param = ModelTUserLoginAuthInfo.MAP_OBJ_MAPPER.toCommonMap(instance);
        assembler.assembleSql(sqlBuilder, param, ModelTUserLoginAuthInfo.class);
        sql = sqlBuilder.getSql(null);
        logger.info("execute sql:{}\nwith param:{}", sql, param);
        Long ret = db.insert(sql, param);
        if (ret!= null) {
            instance.setId(((Integer) TypeConstantHelper.testPackPrType(ret, Integer.class)));
            return instance;
        } else {
            return null;
        }
    }

    public ModelTUserLoginAuthInfo insert(ModelTUserLoginAuthInfo instance) {
        return insert(instance, null);
    }

    public Integer update(ModelTUserLoginAuthInfo instance, Set<String> conditionField, DaoAssembler assembler) {
        if (assembler == null) {
            assembler = new BaseDaoAssembler();
        }
        String sql;
        SQLUpdate sqlBuilder = SQL.buildUpdateSql(ModelTUserLoginAuthInfo.DTO_TABLE_NAME);
        Integer dId = instance.getId();
        if (dId!= null) {
            if (conditionField.contains(ModelTUserLoginAuthInfo.FI_ID)) {
                sqlBuilder.where(ModelTUserLoginAuthInfo.FI_ID, ColumnDataType.intData);
            } else {
                sqlBuilder.items(ModelTUserLoginAuthInfo.FI_ID);
            }
        }
        Integer dUser_id = instance.getUserId();
        if (dUser_id!= null) {
            if (conditionField.contains(ModelTUserLoginAuthInfo.FI_USER_ID)) {
                sqlBuilder.where(ModelTUserLoginAuthInfo.FI_USER_ID, ColumnDataType.intData);
            } else {
                sqlBuilder.items(ModelTUserLoginAuthInfo.FI_USER_ID);
            }
        }
        Byte dType = instance.getType();
        if (dType!= null) {
            if (conditionField.contains(ModelTUserLoginAuthInfo.FI_TYPE)) {
                sqlBuilder.where(ModelTUserLoginAuthInfo.FI_TYPE, ColumnDataType.byteData);
            } else {
                sqlBuilder.items(ModelTUserLoginAuthInfo.FI_TYPE);
            }
        }
        Date dCreate_time = instance.getCreateTime();
        if (dCreate_time!= null) {
            if (conditionField.contains(ModelTUserLoginAuthInfo.FI_CREATE_TIME)) {
                sqlBuilder.where(ModelTUserLoginAuthInfo.FI_CREATE_TIME, ColumnDataType.timeStampData);
            } else {
                sqlBuilder.items(ModelTUserLoginAuthInfo.FI_CREATE_TIME);
            }
        }
        Byte dDelete_flag = instance.getDeleteFlag();
        if (dDelete_flag!= null) {
            if (conditionField.contains(ModelTUserLoginAuthInfo.FI_DELETE_FLAG)) {
                sqlBuilder.where(ModelTUserLoginAuthInfo.FI_DELETE_FLAG, ColumnDataType.byteData);
            } else {
                sqlBuilder.items(ModelTUserLoginAuthInfo.FI_DELETE_FLAG);
            }
        }
        sql = sqlBuilder.getSql(null);
        Map<String, Object> param = ModelTUserLoginAuthInfo.MAP_OBJ_MAPPER.toCommonMap(instance);
        assembler.assembleSql(sqlBuilder, param, ModelTUserLoginAuthInfo.class);
        logger.info("execute sql:{}\nwith param:{}", sql, param);
        Integer ret = db.update(sql, param);
        return ret;
    }

    public Integer update(ModelTUserLoginAuthInfo instance, Set<String> conditionField) {
        return update(instance, conditionField, null);
    }

    public Integer updateById(ModelTUserLoginAuthInfo instance, DaoAssembler assembler) {
        if (assembler == null) {
            assembler = new BaseDaoAssembler();
        }
        String sql;
        SQLUpdate sqlBuilder = SQL.buildUpdateSql(ModelTUserLoginAuthInfo.DTO_TABLE_NAME);
        assert((instance.getId()!= null));
        Integer dId = instance.getId();
        if (dId!= null) {
            sqlBuilder.where(ModelTUserLoginAuthInfo.FI_ID, ColumnDataType.intData);
        }
        Integer dUser_id = instance.getUserId();
        if (dUser_id!= null) {
            sqlBuilder.items(ModelTUserLoginAuthInfo.FI_USER_ID);
        }
        Byte dType = instance.getType();
        if (dType!= null) {
            sqlBuilder.items(ModelTUserLoginAuthInfo.FI_TYPE);
        }
        Date dCreate_time = instance.getCreateTime();
        if (dCreate_time!= null) {
            sqlBuilder.items(ModelTUserLoginAuthInfo.FI_CREATE_TIME);
        }
        Byte dDelete_flag = instance.getDeleteFlag();
        if (dDelete_flag!= null) {
            sqlBuilder.items(ModelTUserLoginAuthInfo.FI_DELETE_FLAG);
        }
        sql = sqlBuilder.getSql(null);
        Map<String, Object> param = ModelTUserLoginAuthInfo.MAP_OBJ_MAPPER.toCommonMap(instance);
        assembler.assembleSql(sqlBuilder, param, ModelTUserLoginAuthInfo.class);
        logger.info("execute sql:{}\nwith param:{}", sql, param);
        Integer ret = db.update(sql, param);
        return ret;
    }

    public Integer updateById(ModelTUserLoginAuthInfo instance) {
        return updateById(instance, null);
    }

    @Transactional
    public ModelTUserLoginAuthInfo updateOrInsert(ModelTUserLoginAuthInfo instance, Set<String> conditionField, DaoAssembler assembler) {
        ModelTUserLoginAuthInfo checkInstance = new ModelTUserLoginAuthInfo();
        if (conditionField.contains(ModelTUserLoginAuthInfo.FI_ID)) {
            checkInstance.setId(instance.getId());
        }
        if (conditionField.contains(ModelTUserLoginAuthInfo.FI_USER_ID)) {
            checkInstance.setUserId(instance.getUserId());
        }
        if (conditionField.contains(ModelTUserLoginAuthInfo.FI_TYPE)) {
            checkInstance.setType(instance.getType());
        }
        if (conditionField.contains(ModelTUserLoginAuthInfo.FI_CREATE_TIME)) {
            checkInstance.setCreateTime(instance.getCreateTime());
        }
        if (conditionField.contains(ModelTUserLoginAuthInfo.FI_DELETE_FLAG)) {
            checkInstance.setDeleteFlag(instance.getDeleteFlag());
        }
        ModelTUserLoginAuthInfo selected = getOneByCondition(Collections.singleton(ModelTUserLoginAuthInfo.FI_ID), new BaseDaoAssembler(), checkInstance);
        if (selected == null) {
            return insert(instance, assembler);
        } else {
            update(instance, conditionField, assembler);
            return instance;
        }
    }

    public ModelTUserLoginAuthInfo updateOrInsert(ModelTUserLoginAuthInfo instance, Set<String> conditionField) {
        return updateOrInsert(instance, conditionField, null);
    }

    @Transactional
    public ModelTUserLoginAuthInfo insertIfNoExist(ModelTUserLoginAuthInfo instance, Set<String> conditionField, DaoAssembler assembler) {
        ModelTUserLoginAuthInfo checkInstance = new ModelTUserLoginAuthInfo();
        if (conditionField.contains(ModelTUserLoginAuthInfo.FI_ID)) {
            checkInstance.setId(instance.getId());
        }
        if (conditionField.contains(ModelTUserLoginAuthInfo.FI_USER_ID)) {
            checkInstance.setUserId(instance.getUserId());
        }
        if (conditionField.contains(ModelTUserLoginAuthInfo.FI_TYPE)) {
            checkInstance.setType(instance.getType());
        }
        if (conditionField.contains(ModelTUserLoginAuthInfo.FI_CREATE_TIME)) {
            checkInstance.setCreateTime(instance.getCreateTime());
        }
        if (conditionField.contains(ModelTUserLoginAuthInfo.FI_DELETE_FLAG)) {
            checkInstance.setDeleteFlag(instance.getDeleteFlag());
        }
        ModelTUserLoginAuthInfo selected = getOneByCondition(Collections.singleton(ModelTUserLoginAuthInfo.FI_ID), new BaseDaoAssembler(), checkInstance);
        if (selected == null) {
            return insert(instance, assembler);
        } else {
            instance.setId(selected.getId());
            return instance;
        }
    }

    public ModelTUserLoginAuthInfo insertIfNoExist(ModelTUserLoginAuthInfo instance, Set<String> conditionField) {
        return insertIfNoExist(instance, conditionField, null);
    }

    public<TT> Map<TT, ModelTUserLoginAuthInfo> buildMap(List<ModelTUserLoginAuthInfo> list, String field) {
        Map<TT, ModelTUserLoginAuthInfo> ret = CollectionHelper.newMap();
        if (list == null) {
            return ret;
        }
        for (ModelTUserLoginAuthInfo item: list) {
            ret.put(ModelTUserLoginAuthInfo.MAP_OBJ_MAPPER.<TT> getField(field, item), item);
        }
        return ret;
    }

    public<TT> Map<TT, List<ModelTUserLoginAuthInfo>> buildListMap(List<ModelTUserLoginAuthInfo> list, String field) {
        Map<TT, List<ModelTUserLoginAuthInfo>> ret = CollectionHelper.newMap();
        if (list == null) {
            return ret;
        }
        for (ModelTUserLoginAuthInfo item: list) {
            List<ModelTUserLoginAuthInfo> itemList = ret.get(ModelTUserLoginAuthInfo.MAP_OBJ_MAPPER.<TT> getField(field, item));
            if (itemList == null) {
                itemList = CollectionHelper.newList();
            }
            itemList.add(item);
            ret.put(ModelTUserLoginAuthInfo.MAP_OBJ_MAPPER.<TT> getField(field, item), itemList);
        }
        return ret;
    }

    public<TT> List<TT> extractItemAsList(List<ModelTUserLoginAuthInfo> list, String field) {
        List<TT> ret = CollectionHelper.newList();
        if (list == null) {
            return ret;
        }
        for (ModelTUserLoginAuthInfo item: list) {
            ret.add(ModelTUserLoginAuthInfo.MAP_OBJ_MAPPER.<TT> getField(field, item));
        }
        return ret;
    }
}
