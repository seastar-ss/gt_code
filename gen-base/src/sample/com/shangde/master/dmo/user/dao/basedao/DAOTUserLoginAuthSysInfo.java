package com.shangde.master.dmo.user.dao.basedao;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import com.shangde.master.dmo.user.dto.basedto.ModelTUserLoginAuthSysInfo.ResultSetMapperModelTUserLoginAuthSysInfo;
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
import com.shangde.master.dmo.user.dto.basedto.ModelTUserLoginAuthSysInfo;

@Repository("DAOTUserLoginAuthSysInfo")
public class DAOTUserLoginAuthSysInfo {
    public final static Logger logger = LoggerFactory.getLogger(DAOTUserLoginAuthSysInfo.class);
    @Autowired(required = true)
    protected SimpleDbInterface db;

    public List<ModelTUserLoginAuthSysInfo> getByIds(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, List<Integer> id) {
        if (assembler == null) {
            assembler = new BaseDaoAssembler();
        }
        if (selectFields == null) {
            selectFields = ModelTUserLoginAuthSysInfo.FIELD_CLASS.keySet();
        }
        String sql;
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelTUserLoginAuthSysInfo.DTO_TABLE_NAME);
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
        if (selectFields.contains(ModelTUserLoginAuthSysInfo.FI_ID)) {
            sqlBuilder.items(ModelTUserLoginAuthSysInfo.FI_ID);
        }
        if (selectFields.contains(ModelTUserLoginAuthSysInfo.FI_CHANNEL)) {
            sqlBuilder.items(ModelTUserLoginAuthSysInfo.FI_CHANNEL);
        }
        if (selectFields.contains(ModelTUserLoginAuthSysInfo.FI_CHECK_LOGIN)) {
            sqlBuilder.items(ModelTUserLoginAuthSysInfo.FI_CHECK_LOGIN);
        }
        if (selectFields.contains(ModelTUserLoginAuthSysInfo.FI_CHECK_LOGIN_GRAY_LIST)) {
            sqlBuilder.items(ModelTUserLoginAuthSysInfo.FI_CHECK_LOGIN_GRAY_LIST);
        }
        if (selectFields.contains(ModelTUserLoginAuthSysInfo.FI_CHECK_LOGIN_WHITE_LIST)) {
            sqlBuilder.items(ModelTUserLoginAuthSysInfo.FI_CHECK_LOGIN_WHITE_LIST);
        }
        if (selectFields.contains(ModelTUserLoginAuthSysInfo.FI_CHECK_PAY)) {
            sqlBuilder.items(ModelTUserLoginAuthSysInfo.FI_CHECK_PAY);
        }
        if (selectFields.contains(ModelTUserLoginAuthSysInfo.FI_LOGIN_EXPIRE_TIME)) {
            sqlBuilder.items(ModelTUserLoginAuthSysInfo.FI_LOGIN_EXPIRE_TIME);
        }
        if (selectFields.contains(ModelTUserLoginAuthSysInfo.FI_EXTEND_EXPIRE_TIME)) {
            sqlBuilder.items(ModelTUserLoginAuthSysInfo.FI_EXTEND_EXPIRE_TIME);
        }
        if (selectFields.contains(ModelTUserLoginAuthSysInfo.FI_LAST_LOGIN_REMAIN_TIME)) {
            sqlBuilder.items(ModelTUserLoginAuthSysInfo.FI_LAST_LOGIN_REMAIN_TIME);
        }
        if (selectFields.contains(ModelTUserLoginAuthSysInfo.FI_LAST_EXTEND_REMAIN_TIME)) {
            sqlBuilder.items(ModelTUserLoginAuthSysInfo.FI_LAST_EXTEND_REMAIN_TIME);
        }
        if (selectFields.contains(ModelTUserLoginAuthSysInfo.FI_CREATE_TIME)) {
            sqlBuilder.items(ModelTUserLoginAuthSysInfo.FI_CREATE_TIME);
        }
        if (selectFields.contains(ModelTUserLoginAuthSysInfo.FI_DELETE_FLAG)) {
            sqlBuilder.items(ModelTUserLoginAuthSysInfo.FI_DELETE_FLAG);
        }
        sqlBuilder.where(LogicalRelationshipType.and, LogicalOpType.in, null, ModelTUserLoginAuthSysInfo.FI_ID, ModelTUserLoginAuthSysInfo.FI_ID, ColumnDataType.intData);
        sqlBuilder.setLimit();
        assembler.assembleSql(sqlBuilder, param, ModelTUserLoginAuthSysInfo.class);
        sql = sqlBuilder.getSql(null);
        logger.info("execute sql:{}\nwith param:{}", sql, param);
        ResultSetMapperModelTUserLoginAuthSysInfo<ModelTUserLoginAuthSysInfo> rsMapper = ((ResultSetMapperModelTUserLoginAuthSysInfo<ModelTUserLoginAuthSysInfo> ) assembler.<ModelTUserLoginAuthSysInfo> assembleResultSetMapper(param, ModelTUserLoginAuthSysInfo.class));
        if (rsMapper == null) {
            rsMapper = ModelTUserLoginAuthSysInfo.RESULT_SET_OBJ_MAPPER;
        }
        try {
            return db.query(sql, param, rsMapper);
        } catch (final Exception ex) {
            logger.error("sql execption", ex);
            return null;
        }
    }

    public List<ModelTUserLoginAuthSysInfo> getByIds(Set<String> selectFields, Integer start, Integer count, List<Integer> id) {
        return getByIds(selectFields, null, start, count, id);
    }

    public List<ModelTUserLoginAuthSysInfo> getByIds(Integer start, Integer count, List<Integer> id) {
        return getByIds(null, start, count, id);
    }

    public List<ModelTUserLoginAuthSysInfo> getByIds(List<Integer> id) {
        return getByIds(null, null, id);
    }

    public List<ModelTUserLoginAuthSysInfo> getAll(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count) {
        if (assembler == null) {
            assembler = new BaseDaoAssembler();
        }
        if (selectFields == null) {
            selectFields = ModelTUserLoginAuthSysInfo.FIELD_CLASS.keySet();
        }
        String sql;
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelTUserLoginAuthSysInfo.DTO_TABLE_NAME);
        if (start == null) {
            start = AbstractBaseModel.DEFAULT_START;
        }
        if (count == null) {
            count = AbstractBaseModel.DEFUALT_COUNT;
        }
        Map<String, Object> param = CollectionHelper.newMap();
        param.put("start", start);
        param.put("count", count);
        if (selectFields.contains(ModelTUserLoginAuthSysInfo.FI_ID)) {
            sqlBuilder.items(ModelTUserLoginAuthSysInfo.FI_ID);
        }
        if (selectFields.contains(ModelTUserLoginAuthSysInfo.FI_CHANNEL)) {
            sqlBuilder.items(ModelTUserLoginAuthSysInfo.FI_CHANNEL);
        }
        if (selectFields.contains(ModelTUserLoginAuthSysInfo.FI_CHECK_LOGIN)) {
            sqlBuilder.items(ModelTUserLoginAuthSysInfo.FI_CHECK_LOGIN);
        }
        if (selectFields.contains(ModelTUserLoginAuthSysInfo.FI_CHECK_LOGIN_GRAY_LIST)) {
            sqlBuilder.items(ModelTUserLoginAuthSysInfo.FI_CHECK_LOGIN_GRAY_LIST);
        }
        if (selectFields.contains(ModelTUserLoginAuthSysInfo.FI_CHECK_LOGIN_WHITE_LIST)) {
            sqlBuilder.items(ModelTUserLoginAuthSysInfo.FI_CHECK_LOGIN_WHITE_LIST);
        }
        if (selectFields.contains(ModelTUserLoginAuthSysInfo.FI_CHECK_PAY)) {
            sqlBuilder.items(ModelTUserLoginAuthSysInfo.FI_CHECK_PAY);
        }
        if (selectFields.contains(ModelTUserLoginAuthSysInfo.FI_LOGIN_EXPIRE_TIME)) {
            sqlBuilder.items(ModelTUserLoginAuthSysInfo.FI_LOGIN_EXPIRE_TIME);
        }
        if (selectFields.contains(ModelTUserLoginAuthSysInfo.FI_EXTEND_EXPIRE_TIME)) {
            sqlBuilder.items(ModelTUserLoginAuthSysInfo.FI_EXTEND_EXPIRE_TIME);
        }
        if (selectFields.contains(ModelTUserLoginAuthSysInfo.FI_LAST_LOGIN_REMAIN_TIME)) {
            sqlBuilder.items(ModelTUserLoginAuthSysInfo.FI_LAST_LOGIN_REMAIN_TIME);
        }
        if (selectFields.contains(ModelTUserLoginAuthSysInfo.FI_LAST_EXTEND_REMAIN_TIME)) {
            sqlBuilder.items(ModelTUserLoginAuthSysInfo.FI_LAST_EXTEND_REMAIN_TIME);
        }
        if (selectFields.contains(ModelTUserLoginAuthSysInfo.FI_CREATE_TIME)) {
            sqlBuilder.items(ModelTUserLoginAuthSysInfo.FI_CREATE_TIME);
        }
        if (selectFields.contains(ModelTUserLoginAuthSysInfo.FI_DELETE_FLAG)) {
            sqlBuilder.items(ModelTUserLoginAuthSysInfo.FI_DELETE_FLAG);
        }
        sqlBuilder.setLimit();
        assembler.assembleSql(sqlBuilder, param, ModelTUserLoginAuthSysInfo.class);
        sql = sqlBuilder.getSql(null);
        logger.info("execute sql:{}\nwith param:{}", sql, param);
        ResultSetMapperModelTUserLoginAuthSysInfo<ModelTUserLoginAuthSysInfo> rsMapper = ((ResultSetMapperModelTUserLoginAuthSysInfo<ModelTUserLoginAuthSysInfo> ) assembler.<ModelTUserLoginAuthSysInfo> assembleResultSetMapper(param, ModelTUserLoginAuthSysInfo.class));
        if (rsMapper == null) {
            rsMapper = ModelTUserLoginAuthSysInfo.RESULT_SET_OBJ_MAPPER;
        }
        try {
            return db.query(sql, param, rsMapper);
        } catch (final Exception ex) {
            logger.error("sql execption", ex);
            return null;
        }
    }

    public List<ModelTUserLoginAuthSysInfo> getAll(Set<String> selectFields, Integer start, Integer count) {
        return getAll(selectFields, null, start, count);
    }

    public List<ModelTUserLoginAuthSysInfo> getAll(Integer start, Integer count) {
        return getAll(null, start, count);
    }

    public List<ModelTUserLoginAuthSysInfo> getAll() {
        return getAll(null, null);
    }

    public ModelTUserLoginAuthSysInfo getById(Set<String> selectFields, DaoAssembler assembler, Integer id) {
        if (assembler == null) {
            assembler = new BaseDaoAssembler();
        }
        if (selectFields == null) {
            selectFields = ModelTUserLoginAuthSysInfo.FIELD_CLASS.keySet();
        }
        String sql;
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelTUserLoginAuthSysInfo.DTO_TABLE_NAME);
        Integer start = 0;
        Integer count = 1;
        Map<String, Object> param = CollectionHelper.newMap();
        param.put("id", id);
        param.put("start", start);
        param.put("count", count);
        if (selectFields.contains(ModelTUserLoginAuthSysInfo.FI_ID)) {
            sqlBuilder.items(ModelTUserLoginAuthSysInfo.FI_ID);
        }
        if (selectFields.contains(ModelTUserLoginAuthSysInfo.FI_CHANNEL)) {
            sqlBuilder.items(ModelTUserLoginAuthSysInfo.FI_CHANNEL);
        }
        if (selectFields.contains(ModelTUserLoginAuthSysInfo.FI_CHECK_LOGIN)) {
            sqlBuilder.items(ModelTUserLoginAuthSysInfo.FI_CHECK_LOGIN);
        }
        if (selectFields.contains(ModelTUserLoginAuthSysInfo.FI_CHECK_LOGIN_GRAY_LIST)) {
            sqlBuilder.items(ModelTUserLoginAuthSysInfo.FI_CHECK_LOGIN_GRAY_LIST);
        }
        if (selectFields.contains(ModelTUserLoginAuthSysInfo.FI_CHECK_LOGIN_WHITE_LIST)) {
            sqlBuilder.items(ModelTUserLoginAuthSysInfo.FI_CHECK_LOGIN_WHITE_LIST);
        }
        if (selectFields.contains(ModelTUserLoginAuthSysInfo.FI_CHECK_PAY)) {
            sqlBuilder.items(ModelTUserLoginAuthSysInfo.FI_CHECK_PAY);
        }
        if (selectFields.contains(ModelTUserLoginAuthSysInfo.FI_LOGIN_EXPIRE_TIME)) {
            sqlBuilder.items(ModelTUserLoginAuthSysInfo.FI_LOGIN_EXPIRE_TIME);
        }
        if (selectFields.contains(ModelTUserLoginAuthSysInfo.FI_EXTEND_EXPIRE_TIME)) {
            sqlBuilder.items(ModelTUserLoginAuthSysInfo.FI_EXTEND_EXPIRE_TIME);
        }
        if (selectFields.contains(ModelTUserLoginAuthSysInfo.FI_LAST_LOGIN_REMAIN_TIME)) {
            sqlBuilder.items(ModelTUserLoginAuthSysInfo.FI_LAST_LOGIN_REMAIN_TIME);
        }
        if (selectFields.contains(ModelTUserLoginAuthSysInfo.FI_LAST_EXTEND_REMAIN_TIME)) {
            sqlBuilder.items(ModelTUserLoginAuthSysInfo.FI_LAST_EXTEND_REMAIN_TIME);
        }
        if (selectFields.contains(ModelTUserLoginAuthSysInfo.FI_CREATE_TIME)) {
            sqlBuilder.items(ModelTUserLoginAuthSysInfo.FI_CREATE_TIME);
        }
        if (selectFields.contains(ModelTUserLoginAuthSysInfo.FI_DELETE_FLAG)) {
            sqlBuilder.items(ModelTUserLoginAuthSysInfo.FI_DELETE_FLAG);
        }
        sqlBuilder.where(ModelTUserLoginAuthSysInfo.FI_ID, ColumnDataType.intData);
        sqlBuilder.setLimit();
        assembler.assembleSql(sqlBuilder, param, ModelTUserLoginAuthSysInfo.class);
        sql = sqlBuilder.getSql(null);
        logger.info("execute sql:{}\nwith param:{}", sql, param);
        ResultSetMapperModelTUserLoginAuthSysInfo<ModelTUserLoginAuthSysInfo> rsMapper = ((ResultSetMapperModelTUserLoginAuthSysInfo<ModelTUserLoginAuthSysInfo> ) assembler.<ModelTUserLoginAuthSysInfo> assembleResultSetMapper(param, ModelTUserLoginAuthSysInfo.class));
        if (rsMapper == null) {
            rsMapper = ModelTUserLoginAuthSysInfo.RESULT_SET_OBJ_MAPPER;
        }
        try {
            return db.queryForObject(sql, param, rsMapper);
        } catch (final Exception ex) {
            logger.error("sql execption", ex);
            return null;
        }
    }

    public ModelTUserLoginAuthSysInfo getById(Set<String> selectFields, Integer id) {
        return getById(selectFields, null, id);
    }

    public ModelTUserLoginAuthSysInfo getById(Integer id) {
        return getById(null, id);
    }

    public List<ModelTUserLoginAuthSysInfo> getByIndexes(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, String inField, List indexes) {
        if (assembler == null) {
            assembler = new BaseDaoAssembler();
        }
        if (selectFields == null) {
            selectFields = ModelTUserLoginAuthSysInfo.FIELD_CLASS.keySet();
        }
        String sql;
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelTUserLoginAuthSysInfo.DTO_TABLE_NAME);
        if (start == null) {
            start = AbstractBaseModel.DEFAULT_START;
        }
        if (count == null) {
            count = AbstractBaseModel.DEFUALT_COUNT;
        }
        Map<String, Object> param = CollectionHelper.newMap();
        param.put("start", start);
        param.put("count", count);
        if (selectFields.contains(ModelTUserLoginAuthSysInfo.FI_ID)) {
            sqlBuilder.items(ModelTUserLoginAuthSysInfo.FI_ID);
        }
        if (selectFields.contains(ModelTUserLoginAuthSysInfo.FI_CHANNEL)) {
            sqlBuilder.items(ModelTUserLoginAuthSysInfo.FI_CHANNEL);
        }
        if (selectFields.contains(ModelTUserLoginAuthSysInfo.FI_CHECK_LOGIN)) {
            sqlBuilder.items(ModelTUserLoginAuthSysInfo.FI_CHECK_LOGIN);
        }
        if (selectFields.contains(ModelTUserLoginAuthSysInfo.FI_CHECK_LOGIN_GRAY_LIST)) {
            sqlBuilder.items(ModelTUserLoginAuthSysInfo.FI_CHECK_LOGIN_GRAY_LIST);
        }
        if (selectFields.contains(ModelTUserLoginAuthSysInfo.FI_CHECK_LOGIN_WHITE_LIST)) {
            sqlBuilder.items(ModelTUserLoginAuthSysInfo.FI_CHECK_LOGIN_WHITE_LIST);
        }
        if (selectFields.contains(ModelTUserLoginAuthSysInfo.FI_CHECK_PAY)) {
            sqlBuilder.items(ModelTUserLoginAuthSysInfo.FI_CHECK_PAY);
        }
        if (selectFields.contains(ModelTUserLoginAuthSysInfo.FI_LOGIN_EXPIRE_TIME)) {
            sqlBuilder.items(ModelTUserLoginAuthSysInfo.FI_LOGIN_EXPIRE_TIME);
        }
        if (selectFields.contains(ModelTUserLoginAuthSysInfo.FI_EXTEND_EXPIRE_TIME)) {
            sqlBuilder.items(ModelTUserLoginAuthSysInfo.FI_EXTEND_EXPIRE_TIME);
        }
        if (selectFields.contains(ModelTUserLoginAuthSysInfo.FI_LAST_LOGIN_REMAIN_TIME)) {
            sqlBuilder.items(ModelTUserLoginAuthSysInfo.FI_LAST_LOGIN_REMAIN_TIME);
        }
        if (selectFields.contains(ModelTUserLoginAuthSysInfo.FI_LAST_EXTEND_REMAIN_TIME)) {
            sqlBuilder.items(ModelTUserLoginAuthSysInfo.FI_LAST_EXTEND_REMAIN_TIME);
        }
        if (selectFields.contains(ModelTUserLoginAuthSysInfo.FI_CREATE_TIME)) {
            sqlBuilder.items(ModelTUserLoginAuthSysInfo.FI_CREATE_TIME);
        }
        if (selectFields.contains(ModelTUserLoginAuthSysInfo.FI_DELETE_FLAG)) {
            sqlBuilder.items(ModelTUserLoginAuthSysInfo.FI_DELETE_FLAG);
        }
        if (ModelTUserLoginAuthSysInfo.FIELD_CLASS.containsKey(inField)) {
            Object fieldClassObj = ModelTUserLoginAuthSysInfo.FIELD_CLASS.get(inField);
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
        assembler.assembleSql(sqlBuilder, param, ModelTUserLoginAuthSysInfo.class);
        sql = sqlBuilder.getSql(null);
        logger.info("execute sql:{}\nwith param:{}", sql, param);
        ResultSetMapperModelTUserLoginAuthSysInfo<ModelTUserLoginAuthSysInfo> rsMapper = ((ResultSetMapperModelTUserLoginAuthSysInfo<ModelTUserLoginAuthSysInfo> ) assembler.<ModelTUserLoginAuthSysInfo> assembleResultSetMapper(param, ModelTUserLoginAuthSysInfo.class));
        if (rsMapper == null) {
            rsMapper = ModelTUserLoginAuthSysInfo.RESULT_SET_OBJ_MAPPER;
        }
        try {
            return db.query(sql, param, rsMapper);
        } catch (final Exception ex) {
            logger.error("sql execption", ex);
            return null;
        }
    }

    public List<ModelTUserLoginAuthSysInfo> getByIndexes(Set<String> selectFields, Integer start, Integer count, String inField, List indexes) {
        return getByIndexes(selectFields, null, start, count, inField, indexes);
    }

    public List<ModelTUserLoginAuthSysInfo> getByIndexes(Integer start, Integer count, String inField, List indexes) {
        return getByIndexes(null, start, count, inField, indexes);
    }

    public List<ModelTUserLoginAuthSysInfo> getByIndexes(String inField, List indexes) {
        return getByIndexes(null, null, inField, indexes);
    }

    public ModelTUserLoginAuthSysInfo getOneByCondition(Set<String> selectFields, DaoAssembler assembler, ModelTUserLoginAuthSysInfo instance) {
        if (assembler == null) {
            assembler = new BaseDaoAssembler();
        }
        if (selectFields == null) {
            selectFields = ModelTUserLoginAuthSysInfo.FIELD_CLASS.keySet();
        }
        String sql;
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelTUserLoginAuthSysInfo.DTO_TABLE_NAME);
        Integer start = 0;
        Integer count = 1;
        Map<String, Object> param = CollectionHelper.newMap();
        param.put("start", start);
        param.put("count", count);
        if (selectFields.contains(ModelTUserLoginAuthSysInfo.FI_ID)) {
            sqlBuilder.items(ModelTUserLoginAuthSysInfo.FI_ID);
        }
        Integer dId = instance.getId();
        if (dId!= null) {
            sqlBuilder.where(ModelTUserLoginAuthSysInfo.FI_ID, ColumnDataType.intData);
            param.put(ModelTUserLoginAuthSysInfo.FI_ID, dId);
        }
        if (selectFields.contains(ModelTUserLoginAuthSysInfo.FI_CHANNEL)) {
            sqlBuilder.items(ModelTUserLoginAuthSysInfo.FI_CHANNEL);
        }
        String dChannel = instance.getChannel();
        if (dChannel!= null) {
            sqlBuilder.where(ModelTUserLoginAuthSysInfo.FI_CHANNEL, ColumnDataType.stringData);
            param.put(ModelTUserLoginAuthSysInfo.FI_CHANNEL, dChannel);
        }
        if (selectFields.contains(ModelTUserLoginAuthSysInfo.FI_CHECK_LOGIN)) {
            sqlBuilder.items(ModelTUserLoginAuthSysInfo.FI_CHECK_LOGIN);
        }
        String dCheck_login = instance.getCheckLogin();
        if (dCheck_login!= null) {
            sqlBuilder.where(ModelTUserLoginAuthSysInfo.FI_CHECK_LOGIN, ColumnDataType.stringData);
            param.put(ModelTUserLoginAuthSysInfo.FI_CHECK_LOGIN, dCheck_login);
        }
        if (selectFields.contains(ModelTUserLoginAuthSysInfo.FI_CHECK_LOGIN_GRAY_LIST)) {
            sqlBuilder.items(ModelTUserLoginAuthSysInfo.FI_CHECK_LOGIN_GRAY_LIST);
        }
        String dCheck_login_gray_list = instance.getCheckLoginGrayList();
        if (dCheck_login_gray_list!= null) {
            sqlBuilder.where(ModelTUserLoginAuthSysInfo.FI_CHECK_LOGIN_GRAY_LIST, ColumnDataType.stringData);
            param.put(ModelTUserLoginAuthSysInfo.FI_CHECK_LOGIN_GRAY_LIST, dCheck_login_gray_list);
        }
        if (selectFields.contains(ModelTUserLoginAuthSysInfo.FI_CHECK_LOGIN_WHITE_LIST)) {
            sqlBuilder.items(ModelTUserLoginAuthSysInfo.FI_CHECK_LOGIN_WHITE_LIST);
        }
        String dCheck_login_white_list = instance.getCheckLoginWhiteList();
        if (dCheck_login_white_list!= null) {
            sqlBuilder.where(ModelTUserLoginAuthSysInfo.FI_CHECK_LOGIN_WHITE_LIST, ColumnDataType.stringData);
            param.put(ModelTUserLoginAuthSysInfo.FI_CHECK_LOGIN_WHITE_LIST, dCheck_login_white_list);
        }
        if (selectFields.contains(ModelTUserLoginAuthSysInfo.FI_CHECK_PAY)) {
            sqlBuilder.items(ModelTUserLoginAuthSysInfo.FI_CHECK_PAY);
        }
        String dCheck_pay = instance.getCheckPay();
        if (dCheck_pay!= null) {
            sqlBuilder.where(ModelTUserLoginAuthSysInfo.FI_CHECK_PAY, ColumnDataType.stringData);
            param.put(ModelTUserLoginAuthSysInfo.FI_CHECK_PAY, dCheck_pay);
        }
        if (selectFields.contains(ModelTUserLoginAuthSysInfo.FI_LOGIN_EXPIRE_TIME)) {
            sqlBuilder.items(ModelTUserLoginAuthSysInfo.FI_LOGIN_EXPIRE_TIME);
        }
        Long dLogin_expire_time = instance.getLoginExpireTime();
        if (dLogin_expire_time!= null) {
            sqlBuilder.where(ModelTUserLoginAuthSysInfo.FI_LOGIN_EXPIRE_TIME, ColumnDataType.longData);
            param.put(ModelTUserLoginAuthSysInfo.FI_LOGIN_EXPIRE_TIME, dLogin_expire_time);
        }
        if (selectFields.contains(ModelTUserLoginAuthSysInfo.FI_EXTEND_EXPIRE_TIME)) {
            sqlBuilder.items(ModelTUserLoginAuthSysInfo.FI_EXTEND_EXPIRE_TIME);
        }
        Long dExtend_expire_time = instance.getExtendExpireTime();
        if (dExtend_expire_time!= null) {
            sqlBuilder.where(ModelTUserLoginAuthSysInfo.FI_EXTEND_EXPIRE_TIME, ColumnDataType.longData);
            param.put(ModelTUserLoginAuthSysInfo.FI_EXTEND_EXPIRE_TIME, dExtend_expire_time);
        }
        if (selectFields.contains(ModelTUserLoginAuthSysInfo.FI_LAST_LOGIN_REMAIN_TIME)) {
            sqlBuilder.items(ModelTUserLoginAuthSysInfo.FI_LAST_LOGIN_REMAIN_TIME);
        }
        Long dLast_login_remain_time = instance.getLastLoginRemainTime();
        if (dLast_login_remain_time!= null) {
            sqlBuilder.where(ModelTUserLoginAuthSysInfo.FI_LAST_LOGIN_REMAIN_TIME, ColumnDataType.longData);
            param.put(ModelTUserLoginAuthSysInfo.FI_LAST_LOGIN_REMAIN_TIME, dLast_login_remain_time);
        }
        if (selectFields.contains(ModelTUserLoginAuthSysInfo.FI_LAST_EXTEND_REMAIN_TIME)) {
            sqlBuilder.items(ModelTUserLoginAuthSysInfo.FI_LAST_EXTEND_REMAIN_TIME);
        }
        Long dLast_extend_remain_time = instance.getLastExtendRemainTime();
        if (dLast_extend_remain_time!= null) {
            sqlBuilder.where(ModelTUserLoginAuthSysInfo.FI_LAST_EXTEND_REMAIN_TIME, ColumnDataType.longData);
            param.put(ModelTUserLoginAuthSysInfo.FI_LAST_EXTEND_REMAIN_TIME, dLast_extend_remain_time);
        }
        if (selectFields.contains(ModelTUserLoginAuthSysInfo.FI_CREATE_TIME)) {
            sqlBuilder.items(ModelTUserLoginAuthSysInfo.FI_CREATE_TIME);
        }
        Date dCreate_time = instance.getCreateTime();
        if (dCreate_time!= null) {
            sqlBuilder.where(ModelTUserLoginAuthSysInfo.FI_CREATE_TIME, ColumnDataType.timeStampData);
            param.put(ModelTUserLoginAuthSysInfo.FI_CREATE_TIME, dCreate_time);
        }
        if (selectFields.contains(ModelTUserLoginAuthSysInfo.FI_DELETE_FLAG)) {
            sqlBuilder.items(ModelTUserLoginAuthSysInfo.FI_DELETE_FLAG);
        }
        Integer dDelete_flag = instance.getDeleteFlag();
        if (dDelete_flag!= null) {
            sqlBuilder.where(ModelTUserLoginAuthSysInfo.FI_DELETE_FLAG, ColumnDataType.intData);
            param.put(ModelTUserLoginAuthSysInfo.FI_DELETE_FLAG, dDelete_flag);
        }
        sqlBuilder.setLimit();
        assembler.assembleSql(sqlBuilder, param, ModelTUserLoginAuthSysInfo.class);
        sql = sqlBuilder.getSql(null);
        logger.info("execute sql:{}\nwith param:{}", sql, param);
        ResultSetMapperModelTUserLoginAuthSysInfo<ModelTUserLoginAuthSysInfo> rsMapper = ((ResultSetMapperModelTUserLoginAuthSysInfo<ModelTUserLoginAuthSysInfo> ) assembler.<ModelTUserLoginAuthSysInfo> assembleResultSetMapper(param, ModelTUserLoginAuthSysInfo.class));
        if (rsMapper == null) {
            rsMapper = ModelTUserLoginAuthSysInfo.RESULT_SET_OBJ_MAPPER;
        }
        try {
            return db.queryForObject(sql, param, rsMapper);
        } catch (final Exception ex) {
            logger.error("sql execption", ex);
            return null;
        }
    }

    public ModelTUserLoginAuthSysInfo getOneByCondition(Set<String> selectFields, ModelTUserLoginAuthSysInfo instance) {
        return getOneByCondition(selectFields, null, instance);
    }

    public ModelTUserLoginAuthSysInfo getOneByCondition(ModelTUserLoginAuthSysInfo instance) {
        return getOneByCondition(null, instance);
    }

    public List<ModelTUserLoginAuthSysInfo> getByCondition(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, ModelTUserLoginAuthSysInfo instance) {
        if (assembler == null) {
            assembler = new BaseDaoAssembler();
        }
        if (selectFields == null) {
            selectFields = ModelTUserLoginAuthSysInfo.FIELD_CLASS.keySet();
        }
        String sql;
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelTUserLoginAuthSysInfo.DTO_TABLE_NAME);
        if (start == null) {
            start = AbstractBaseModel.DEFAULT_START;
        }
        if (count == null) {
            count = AbstractBaseModel.DEFUALT_COUNT;
        }
        Map<String, Object> param = CollectionHelper.newMap();
        param.put("start", start);
        param.put("count", count);
        if (selectFields.contains(ModelTUserLoginAuthSysInfo.FI_ID)) {
            sqlBuilder.items(ModelTUserLoginAuthSysInfo.FI_ID);
        }
        Integer dId = instance.getId();
        if (dId!= null) {
            sqlBuilder.where(ModelTUserLoginAuthSysInfo.FI_ID, ColumnDataType.intData);
            param.put(ModelTUserLoginAuthSysInfo.FI_ID, dId);
        }
        if (selectFields.contains(ModelTUserLoginAuthSysInfo.FI_CHANNEL)) {
            sqlBuilder.items(ModelTUserLoginAuthSysInfo.FI_CHANNEL);
        }
        String dChannel = instance.getChannel();
        if (dChannel!= null) {
            sqlBuilder.where(ModelTUserLoginAuthSysInfo.FI_CHANNEL, ColumnDataType.stringData);
            param.put(ModelTUserLoginAuthSysInfo.FI_CHANNEL, dChannel);
        }
        if (selectFields.contains(ModelTUserLoginAuthSysInfo.FI_CHECK_LOGIN)) {
            sqlBuilder.items(ModelTUserLoginAuthSysInfo.FI_CHECK_LOGIN);
        }
        String dCheck_login = instance.getCheckLogin();
        if (dCheck_login!= null) {
            sqlBuilder.where(ModelTUserLoginAuthSysInfo.FI_CHECK_LOGIN, ColumnDataType.stringData);
            param.put(ModelTUserLoginAuthSysInfo.FI_CHECK_LOGIN, dCheck_login);
        }
        if (selectFields.contains(ModelTUserLoginAuthSysInfo.FI_CHECK_LOGIN_GRAY_LIST)) {
            sqlBuilder.items(ModelTUserLoginAuthSysInfo.FI_CHECK_LOGIN_GRAY_LIST);
        }
        String dCheck_login_gray_list = instance.getCheckLoginGrayList();
        if (dCheck_login_gray_list!= null) {
            sqlBuilder.where(ModelTUserLoginAuthSysInfo.FI_CHECK_LOGIN_GRAY_LIST, ColumnDataType.stringData);
            param.put(ModelTUserLoginAuthSysInfo.FI_CHECK_LOGIN_GRAY_LIST, dCheck_login_gray_list);
        }
        if (selectFields.contains(ModelTUserLoginAuthSysInfo.FI_CHECK_LOGIN_WHITE_LIST)) {
            sqlBuilder.items(ModelTUserLoginAuthSysInfo.FI_CHECK_LOGIN_WHITE_LIST);
        }
        String dCheck_login_white_list = instance.getCheckLoginWhiteList();
        if (dCheck_login_white_list!= null) {
            sqlBuilder.where(ModelTUserLoginAuthSysInfo.FI_CHECK_LOGIN_WHITE_LIST, ColumnDataType.stringData);
            param.put(ModelTUserLoginAuthSysInfo.FI_CHECK_LOGIN_WHITE_LIST, dCheck_login_white_list);
        }
        if (selectFields.contains(ModelTUserLoginAuthSysInfo.FI_CHECK_PAY)) {
            sqlBuilder.items(ModelTUserLoginAuthSysInfo.FI_CHECK_PAY);
        }
        String dCheck_pay = instance.getCheckPay();
        if (dCheck_pay!= null) {
            sqlBuilder.where(ModelTUserLoginAuthSysInfo.FI_CHECK_PAY, ColumnDataType.stringData);
            param.put(ModelTUserLoginAuthSysInfo.FI_CHECK_PAY, dCheck_pay);
        }
        if (selectFields.contains(ModelTUserLoginAuthSysInfo.FI_LOGIN_EXPIRE_TIME)) {
            sqlBuilder.items(ModelTUserLoginAuthSysInfo.FI_LOGIN_EXPIRE_TIME);
        }
        Long dLogin_expire_time = instance.getLoginExpireTime();
        if (dLogin_expire_time!= null) {
            sqlBuilder.where(ModelTUserLoginAuthSysInfo.FI_LOGIN_EXPIRE_TIME, ColumnDataType.longData);
            param.put(ModelTUserLoginAuthSysInfo.FI_LOGIN_EXPIRE_TIME, dLogin_expire_time);
        }
        if (selectFields.contains(ModelTUserLoginAuthSysInfo.FI_EXTEND_EXPIRE_TIME)) {
            sqlBuilder.items(ModelTUserLoginAuthSysInfo.FI_EXTEND_EXPIRE_TIME);
        }
        Long dExtend_expire_time = instance.getExtendExpireTime();
        if (dExtend_expire_time!= null) {
            sqlBuilder.where(ModelTUserLoginAuthSysInfo.FI_EXTEND_EXPIRE_TIME, ColumnDataType.longData);
            param.put(ModelTUserLoginAuthSysInfo.FI_EXTEND_EXPIRE_TIME, dExtend_expire_time);
        }
        if (selectFields.contains(ModelTUserLoginAuthSysInfo.FI_LAST_LOGIN_REMAIN_TIME)) {
            sqlBuilder.items(ModelTUserLoginAuthSysInfo.FI_LAST_LOGIN_REMAIN_TIME);
        }
        Long dLast_login_remain_time = instance.getLastLoginRemainTime();
        if (dLast_login_remain_time!= null) {
            sqlBuilder.where(ModelTUserLoginAuthSysInfo.FI_LAST_LOGIN_REMAIN_TIME, ColumnDataType.longData);
            param.put(ModelTUserLoginAuthSysInfo.FI_LAST_LOGIN_REMAIN_TIME, dLast_login_remain_time);
        }
        if (selectFields.contains(ModelTUserLoginAuthSysInfo.FI_LAST_EXTEND_REMAIN_TIME)) {
            sqlBuilder.items(ModelTUserLoginAuthSysInfo.FI_LAST_EXTEND_REMAIN_TIME);
        }
        Long dLast_extend_remain_time = instance.getLastExtendRemainTime();
        if (dLast_extend_remain_time!= null) {
            sqlBuilder.where(ModelTUserLoginAuthSysInfo.FI_LAST_EXTEND_REMAIN_TIME, ColumnDataType.longData);
            param.put(ModelTUserLoginAuthSysInfo.FI_LAST_EXTEND_REMAIN_TIME, dLast_extend_remain_time);
        }
        if (selectFields.contains(ModelTUserLoginAuthSysInfo.FI_CREATE_TIME)) {
            sqlBuilder.items(ModelTUserLoginAuthSysInfo.FI_CREATE_TIME);
        }
        Date dCreate_time = instance.getCreateTime();
        if (dCreate_time!= null) {
            sqlBuilder.where(ModelTUserLoginAuthSysInfo.FI_CREATE_TIME, ColumnDataType.timeStampData);
            param.put(ModelTUserLoginAuthSysInfo.FI_CREATE_TIME, dCreate_time);
        }
        if (selectFields.contains(ModelTUserLoginAuthSysInfo.FI_DELETE_FLAG)) {
            sqlBuilder.items(ModelTUserLoginAuthSysInfo.FI_DELETE_FLAG);
        }
        Integer dDelete_flag = instance.getDeleteFlag();
        if (dDelete_flag!= null) {
            sqlBuilder.where(ModelTUserLoginAuthSysInfo.FI_DELETE_FLAG, ColumnDataType.intData);
            param.put(ModelTUserLoginAuthSysInfo.FI_DELETE_FLAG, dDelete_flag);
        }
        sqlBuilder.setLimit();
        assembler.assembleSql(sqlBuilder, param, ModelTUserLoginAuthSysInfo.class);
        sql = sqlBuilder.getSql(null);
        logger.info("execute sql:{}\nwith param:{}", sql, param);
        ResultSetMapperModelTUserLoginAuthSysInfo<ModelTUserLoginAuthSysInfo> rsMapper = ((ResultSetMapperModelTUserLoginAuthSysInfo<ModelTUserLoginAuthSysInfo> ) assembler.<ModelTUserLoginAuthSysInfo> assembleResultSetMapper(param, ModelTUserLoginAuthSysInfo.class));
        if (rsMapper == null) {
            rsMapper = ModelTUserLoginAuthSysInfo.RESULT_SET_OBJ_MAPPER;
        }
        try {
            return db.query(sql, param, rsMapper);
        } catch (final Exception ex) {
            logger.error("sql execption", ex);
            return null;
        }
    }

    public List<ModelTUserLoginAuthSysInfo> getByCondition(Set<String> selectFields, Integer start, Integer count, ModelTUserLoginAuthSysInfo instance) {
        return getByCondition(selectFields, null, start, count, instance);
    }

    public List<ModelTUserLoginAuthSysInfo> getByCondition(Integer start, Integer count, ModelTUserLoginAuthSysInfo instance) {
        return getByCondition(null, start, count, instance);
    }

    public List<ModelTUserLoginAuthSysInfo> getByCondition(ModelTUserLoginAuthSysInfo instance) {
        return getByCondition(null, null, instance);
    }

    public Long getCountByCondition(Set<String> selectFields, DaoAssembler assembler, ModelTUserLoginAuthSysInfo instance) {
        if (assembler == null) {
            assembler = new BaseDaoAssembler();
        }
        if (selectFields == null) {
            selectFields = ModelTUserLoginAuthSysInfo.FIELD_CLASS.keySet();
        }
        String sql;
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelTUserLoginAuthSysInfo.DTO_TABLE_NAME);
        Integer start = 0;
        Integer count = 1;
        Map<String, Object> param = CollectionHelper.newMap();
        param.put("start", start);
        param.put("count", count);
        sqlBuilder.funcItems("count", "count");
        Integer dId = instance.getId();
        if (dId!= null) {
            sqlBuilder.where(ModelTUserLoginAuthSysInfo.FI_ID, ColumnDataType.intData);
            param.put(ModelTUserLoginAuthSysInfo.FI_ID, dId);
        }
        String dChannel = instance.getChannel();
        if (dChannel!= null) {
            sqlBuilder.where(ModelTUserLoginAuthSysInfo.FI_CHANNEL, ColumnDataType.stringData);
            param.put(ModelTUserLoginAuthSysInfo.FI_CHANNEL, dChannel);
        }
        String dCheck_login = instance.getCheckLogin();
        if (dCheck_login!= null) {
            sqlBuilder.where(ModelTUserLoginAuthSysInfo.FI_CHECK_LOGIN, ColumnDataType.stringData);
            param.put(ModelTUserLoginAuthSysInfo.FI_CHECK_LOGIN, dCheck_login);
        }
        String dCheck_login_gray_list = instance.getCheckLoginGrayList();
        if (dCheck_login_gray_list!= null) {
            sqlBuilder.where(ModelTUserLoginAuthSysInfo.FI_CHECK_LOGIN_GRAY_LIST, ColumnDataType.stringData);
            param.put(ModelTUserLoginAuthSysInfo.FI_CHECK_LOGIN_GRAY_LIST, dCheck_login_gray_list);
        }
        String dCheck_login_white_list = instance.getCheckLoginWhiteList();
        if (dCheck_login_white_list!= null) {
            sqlBuilder.where(ModelTUserLoginAuthSysInfo.FI_CHECK_LOGIN_WHITE_LIST, ColumnDataType.stringData);
            param.put(ModelTUserLoginAuthSysInfo.FI_CHECK_LOGIN_WHITE_LIST, dCheck_login_white_list);
        }
        String dCheck_pay = instance.getCheckPay();
        if (dCheck_pay!= null) {
            sqlBuilder.where(ModelTUserLoginAuthSysInfo.FI_CHECK_PAY, ColumnDataType.stringData);
            param.put(ModelTUserLoginAuthSysInfo.FI_CHECK_PAY, dCheck_pay);
        }
        Long dLogin_expire_time = instance.getLoginExpireTime();
        if (dLogin_expire_time!= null) {
            sqlBuilder.where(ModelTUserLoginAuthSysInfo.FI_LOGIN_EXPIRE_TIME, ColumnDataType.longData);
            param.put(ModelTUserLoginAuthSysInfo.FI_LOGIN_EXPIRE_TIME, dLogin_expire_time);
        }
        Long dExtend_expire_time = instance.getExtendExpireTime();
        if (dExtend_expire_time!= null) {
            sqlBuilder.where(ModelTUserLoginAuthSysInfo.FI_EXTEND_EXPIRE_TIME, ColumnDataType.longData);
            param.put(ModelTUserLoginAuthSysInfo.FI_EXTEND_EXPIRE_TIME, dExtend_expire_time);
        }
        Long dLast_login_remain_time = instance.getLastLoginRemainTime();
        if (dLast_login_remain_time!= null) {
            sqlBuilder.where(ModelTUserLoginAuthSysInfo.FI_LAST_LOGIN_REMAIN_TIME, ColumnDataType.longData);
            param.put(ModelTUserLoginAuthSysInfo.FI_LAST_LOGIN_REMAIN_TIME, dLast_login_remain_time);
        }
        Long dLast_extend_remain_time = instance.getLastExtendRemainTime();
        if (dLast_extend_remain_time!= null) {
            sqlBuilder.where(ModelTUserLoginAuthSysInfo.FI_LAST_EXTEND_REMAIN_TIME, ColumnDataType.longData);
            param.put(ModelTUserLoginAuthSysInfo.FI_LAST_EXTEND_REMAIN_TIME, dLast_extend_remain_time);
        }
        Date dCreate_time = instance.getCreateTime();
        if (dCreate_time!= null) {
            sqlBuilder.where(ModelTUserLoginAuthSysInfo.FI_CREATE_TIME, ColumnDataType.timeStampData);
            param.put(ModelTUserLoginAuthSysInfo.FI_CREATE_TIME, dCreate_time);
        }
        Integer dDelete_flag = instance.getDeleteFlag();
        if (dDelete_flag!= null) {
            sqlBuilder.where(ModelTUserLoginAuthSysInfo.FI_DELETE_FLAG, ColumnDataType.intData);
            param.put(ModelTUserLoginAuthSysInfo.FI_DELETE_FLAG, dDelete_flag);
        }
        sqlBuilder.setLimit();
        assembler.assembleSql(sqlBuilder, param, ModelTUserLoginAuthSysInfo.class);
        sql = sqlBuilder.getSql(null);
        logger.info("execute sql:{}\nwith param:{}", sql, param);
        try {
            return db.queryForObject(sql, param, Long.class);
        } catch (final Exception ex) {
            logger.error("sql execption", ex);
            return null;
        }
    }

    public Long getCountByCondition(Set<String> selectFields, ModelTUserLoginAuthSysInfo instance) {
        return getCountByCondition(selectFields, null, instance);
    }

    public Long getCountByCondition(ModelTUserLoginAuthSysInfo instance) {
        return getCountByCondition(null, instance);
    }

    public ModelTUserLoginAuthSysInfo insert(ModelTUserLoginAuthSysInfo instance, DaoAssembler assembler) {
        if (assembler == null) {
            assembler = new BaseDaoAssembler();
        }
        String sql;
        SQLInsert sqlBuilder = SQL.buildInsertSql(ModelTUserLoginAuthSysInfo.DTO_TABLE_NAME);
        Integer dId = instance.getId();
        if (dId!= null) {
            sqlBuilder.items(ModelTUserLoginAuthSysInfo.FI_ID);
        }
        String dChannel = instance.getChannel();
        if (dChannel!= null) {
            sqlBuilder.items(ModelTUserLoginAuthSysInfo.FI_CHANNEL);
        }
        String dCheck_login = instance.getCheckLogin();
        if (dCheck_login!= null) {
            sqlBuilder.items(ModelTUserLoginAuthSysInfo.FI_CHECK_LOGIN);
        }
        String dCheck_login_gray_list = instance.getCheckLoginGrayList();
        if (dCheck_login_gray_list!= null) {
            sqlBuilder.items(ModelTUserLoginAuthSysInfo.FI_CHECK_LOGIN_GRAY_LIST);
        }
        String dCheck_login_white_list = instance.getCheckLoginWhiteList();
        if (dCheck_login_white_list!= null) {
            sqlBuilder.items(ModelTUserLoginAuthSysInfo.FI_CHECK_LOGIN_WHITE_LIST);
        }
        String dCheck_pay = instance.getCheckPay();
        if (dCheck_pay!= null) {
            sqlBuilder.items(ModelTUserLoginAuthSysInfo.FI_CHECK_PAY);
        }
        Long dLogin_expire_time = instance.getLoginExpireTime();
        if (dLogin_expire_time!= null) {
            sqlBuilder.items(ModelTUserLoginAuthSysInfo.FI_LOGIN_EXPIRE_TIME);
        }
        Long dExtend_expire_time = instance.getExtendExpireTime();
        if (dExtend_expire_time!= null) {
            sqlBuilder.items(ModelTUserLoginAuthSysInfo.FI_EXTEND_EXPIRE_TIME);
        }
        Long dLast_login_remain_time = instance.getLastLoginRemainTime();
        if (dLast_login_remain_time!= null) {
            sqlBuilder.items(ModelTUserLoginAuthSysInfo.FI_LAST_LOGIN_REMAIN_TIME);
        }
        Long dLast_extend_remain_time = instance.getLastExtendRemainTime();
        if (dLast_extend_remain_time!= null) {
            sqlBuilder.items(ModelTUserLoginAuthSysInfo.FI_LAST_EXTEND_REMAIN_TIME);
        }
        Date dCreate_time = instance.getCreateTime();
        if (dCreate_time!= null) {
            sqlBuilder.items(ModelTUserLoginAuthSysInfo.FI_CREATE_TIME);
        }
        Integer dDelete_flag = instance.getDeleteFlag();
        if (dDelete_flag!= null) {
            sqlBuilder.items(ModelTUserLoginAuthSysInfo.FI_DELETE_FLAG);
        }
        Map<String, Object> param = ModelTUserLoginAuthSysInfo.MAP_OBJ_MAPPER.toCommonMap(instance);
        assembler.assembleSql(sqlBuilder, param, ModelTUserLoginAuthSysInfo.class);
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

    public ModelTUserLoginAuthSysInfo insert(ModelTUserLoginAuthSysInfo instance) {
        return insert(instance, null);
    }

    public Integer update(ModelTUserLoginAuthSysInfo instance, Set<String> conditionField, DaoAssembler assembler) {
        if (assembler == null) {
            assembler = new BaseDaoAssembler();
        }
        String sql;
        SQLUpdate sqlBuilder = SQL.buildUpdateSql(ModelTUserLoginAuthSysInfo.DTO_TABLE_NAME);
        Integer dId = instance.getId();
        if (dId!= null) {
            if (conditionField.contains(ModelTUserLoginAuthSysInfo.FI_ID)) {
                sqlBuilder.where(ModelTUserLoginAuthSysInfo.FI_ID, ColumnDataType.intData);
            } else {
                sqlBuilder.items(ModelTUserLoginAuthSysInfo.FI_ID);
            }
        }
        String dChannel = instance.getChannel();
        if (dChannel!= null) {
            if (conditionField.contains(ModelTUserLoginAuthSysInfo.FI_CHANNEL)) {
                sqlBuilder.where(ModelTUserLoginAuthSysInfo.FI_CHANNEL, ColumnDataType.stringData);
            } else {
                sqlBuilder.items(ModelTUserLoginAuthSysInfo.FI_CHANNEL);
            }
        }
        String dCheck_login = instance.getCheckLogin();
        if (dCheck_login!= null) {
            if (conditionField.contains(ModelTUserLoginAuthSysInfo.FI_CHECK_LOGIN)) {
                sqlBuilder.where(ModelTUserLoginAuthSysInfo.FI_CHECK_LOGIN, ColumnDataType.stringData);
            } else {
                sqlBuilder.items(ModelTUserLoginAuthSysInfo.FI_CHECK_LOGIN);
            }
        }
        String dCheck_login_gray_list = instance.getCheckLoginGrayList();
        if (dCheck_login_gray_list!= null) {
            if (conditionField.contains(ModelTUserLoginAuthSysInfo.FI_CHECK_LOGIN_GRAY_LIST)) {
                sqlBuilder.where(ModelTUserLoginAuthSysInfo.FI_CHECK_LOGIN_GRAY_LIST, ColumnDataType.stringData);
            } else {
                sqlBuilder.items(ModelTUserLoginAuthSysInfo.FI_CHECK_LOGIN_GRAY_LIST);
            }
        }
        String dCheck_login_white_list = instance.getCheckLoginWhiteList();
        if (dCheck_login_white_list!= null) {
            if (conditionField.contains(ModelTUserLoginAuthSysInfo.FI_CHECK_LOGIN_WHITE_LIST)) {
                sqlBuilder.where(ModelTUserLoginAuthSysInfo.FI_CHECK_LOGIN_WHITE_LIST, ColumnDataType.stringData);
            } else {
                sqlBuilder.items(ModelTUserLoginAuthSysInfo.FI_CHECK_LOGIN_WHITE_LIST);
            }
        }
        String dCheck_pay = instance.getCheckPay();
        if (dCheck_pay!= null) {
            if (conditionField.contains(ModelTUserLoginAuthSysInfo.FI_CHECK_PAY)) {
                sqlBuilder.where(ModelTUserLoginAuthSysInfo.FI_CHECK_PAY, ColumnDataType.stringData);
            } else {
                sqlBuilder.items(ModelTUserLoginAuthSysInfo.FI_CHECK_PAY);
            }
        }
        Long dLogin_expire_time = instance.getLoginExpireTime();
        if (dLogin_expire_time!= null) {
            if (conditionField.contains(ModelTUserLoginAuthSysInfo.FI_LOGIN_EXPIRE_TIME)) {
                sqlBuilder.where(ModelTUserLoginAuthSysInfo.FI_LOGIN_EXPIRE_TIME, ColumnDataType.longData);
            } else {
                sqlBuilder.items(ModelTUserLoginAuthSysInfo.FI_LOGIN_EXPIRE_TIME);
            }
        }
        Long dExtend_expire_time = instance.getExtendExpireTime();
        if (dExtend_expire_time!= null) {
            if (conditionField.contains(ModelTUserLoginAuthSysInfo.FI_EXTEND_EXPIRE_TIME)) {
                sqlBuilder.where(ModelTUserLoginAuthSysInfo.FI_EXTEND_EXPIRE_TIME, ColumnDataType.longData);
            } else {
                sqlBuilder.items(ModelTUserLoginAuthSysInfo.FI_EXTEND_EXPIRE_TIME);
            }
        }
        Long dLast_login_remain_time = instance.getLastLoginRemainTime();
        if (dLast_login_remain_time!= null) {
            if (conditionField.contains(ModelTUserLoginAuthSysInfo.FI_LAST_LOGIN_REMAIN_TIME)) {
                sqlBuilder.where(ModelTUserLoginAuthSysInfo.FI_LAST_LOGIN_REMAIN_TIME, ColumnDataType.longData);
            } else {
                sqlBuilder.items(ModelTUserLoginAuthSysInfo.FI_LAST_LOGIN_REMAIN_TIME);
            }
        }
        Long dLast_extend_remain_time = instance.getLastExtendRemainTime();
        if (dLast_extend_remain_time!= null) {
            if (conditionField.contains(ModelTUserLoginAuthSysInfo.FI_LAST_EXTEND_REMAIN_TIME)) {
                sqlBuilder.where(ModelTUserLoginAuthSysInfo.FI_LAST_EXTEND_REMAIN_TIME, ColumnDataType.longData);
            } else {
                sqlBuilder.items(ModelTUserLoginAuthSysInfo.FI_LAST_EXTEND_REMAIN_TIME);
            }
        }
        Date dCreate_time = instance.getCreateTime();
        if (dCreate_time!= null) {
            if (conditionField.contains(ModelTUserLoginAuthSysInfo.FI_CREATE_TIME)) {
                sqlBuilder.where(ModelTUserLoginAuthSysInfo.FI_CREATE_TIME, ColumnDataType.timeStampData);
            } else {
                sqlBuilder.items(ModelTUserLoginAuthSysInfo.FI_CREATE_TIME);
            }
        }
        Integer dDelete_flag = instance.getDeleteFlag();
        if (dDelete_flag!= null) {
            if (conditionField.contains(ModelTUserLoginAuthSysInfo.FI_DELETE_FLAG)) {
                sqlBuilder.where(ModelTUserLoginAuthSysInfo.FI_DELETE_FLAG, ColumnDataType.intData);
            } else {
                sqlBuilder.items(ModelTUserLoginAuthSysInfo.FI_DELETE_FLAG);
            }
        }
        sql = sqlBuilder.getSql(null);
        Map<String, Object> param = ModelTUserLoginAuthSysInfo.MAP_OBJ_MAPPER.toCommonMap(instance);
        assembler.assembleSql(sqlBuilder, param, ModelTUserLoginAuthSysInfo.class);
        logger.info("execute sql:{}\nwith param:{}", sql, param);
        Integer ret = db.update(sql, param);
        return ret;
    }

    public Integer update(ModelTUserLoginAuthSysInfo instance, Set<String> conditionField) {
        return update(instance, conditionField, null);
    }

    public Integer updateById(ModelTUserLoginAuthSysInfo instance, DaoAssembler assembler) {
        if (assembler == null) {
            assembler = new BaseDaoAssembler();
        }
        String sql;
        SQLUpdate sqlBuilder = SQL.buildUpdateSql(ModelTUserLoginAuthSysInfo.DTO_TABLE_NAME);
        assert((instance.getId()!= null));
        Integer dId = instance.getId();
        if (dId!= null) {
            sqlBuilder.where(ModelTUserLoginAuthSysInfo.FI_ID, ColumnDataType.intData);
        }
        String dChannel = instance.getChannel();
        if (dChannel!= null) {
            sqlBuilder.items(ModelTUserLoginAuthSysInfo.FI_CHANNEL);
        }
        String dCheck_login = instance.getCheckLogin();
        if (dCheck_login!= null) {
            sqlBuilder.items(ModelTUserLoginAuthSysInfo.FI_CHECK_LOGIN);
        }
        String dCheck_login_gray_list = instance.getCheckLoginGrayList();
        if (dCheck_login_gray_list!= null) {
            sqlBuilder.items(ModelTUserLoginAuthSysInfo.FI_CHECK_LOGIN_GRAY_LIST);
        }
        String dCheck_login_white_list = instance.getCheckLoginWhiteList();
        if (dCheck_login_white_list!= null) {
            sqlBuilder.items(ModelTUserLoginAuthSysInfo.FI_CHECK_LOGIN_WHITE_LIST);
        }
        String dCheck_pay = instance.getCheckPay();
        if (dCheck_pay!= null) {
            sqlBuilder.items(ModelTUserLoginAuthSysInfo.FI_CHECK_PAY);
        }
        Long dLogin_expire_time = instance.getLoginExpireTime();
        if (dLogin_expire_time!= null) {
            sqlBuilder.items(ModelTUserLoginAuthSysInfo.FI_LOGIN_EXPIRE_TIME);
        }
        Long dExtend_expire_time = instance.getExtendExpireTime();
        if (dExtend_expire_time!= null) {
            sqlBuilder.items(ModelTUserLoginAuthSysInfo.FI_EXTEND_EXPIRE_TIME);
        }
        Long dLast_login_remain_time = instance.getLastLoginRemainTime();
        if (dLast_login_remain_time!= null) {
            sqlBuilder.items(ModelTUserLoginAuthSysInfo.FI_LAST_LOGIN_REMAIN_TIME);
        }
        Long dLast_extend_remain_time = instance.getLastExtendRemainTime();
        if (dLast_extend_remain_time!= null) {
            sqlBuilder.items(ModelTUserLoginAuthSysInfo.FI_LAST_EXTEND_REMAIN_TIME);
        }
        Date dCreate_time = instance.getCreateTime();
        if (dCreate_time!= null) {
            sqlBuilder.items(ModelTUserLoginAuthSysInfo.FI_CREATE_TIME);
        }
        Integer dDelete_flag = instance.getDeleteFlag();
        if (dDelete_flag!= null) {
            sqlBuilder.items(ModelTUserLoginAuthSysInfo.FI_DELETE_FLAG);
        }
        sql = sqlBuilder.getSql(null);
        Map<String, Object> param = ModelTUserLoginAuthSysInfo.MAP_OBJ_MAPPER.toCommonMap(instance);
        assembler.assembleSql(sqlBuilder, param, ModelTUserLoginAuthSysInfo.class);
        logger.info("execute sql:{}\nwith param:{}", sql, param);
        Integer ret = db.update(sql, param);
        return ret;
    }

    public Integer updateById(ModelTUserLoginAuthSysInfo instance) {
        return updateById(instance, null);
    }

    @Transactional
    public ModelTUserLoginAuthSysInfo updateOrInsert(ModelTUserLoginAuthSysInfo instance, Set<String> conditionField, DaoAssembler assembler) {
        ModelTUserLoginAuthSysInfo checkInstance = new ModelTUserLoginAuthSysInfo();
        if (conditionField.contains(ModelTUserLoginAuthSysInfo.FI_ID)) {
            checkInstance.setId(instance.getId());
        }
        if (conditionField.contains(ModelTUserLoginAuthSysInfo.FI_CHANNEL)) {
            checkInstance.setChannel(instance.getChannel());
        }
        if (conditionField.contains(ModelTUserLoginAuthSysInfo.FI_CHECK_LOGIN)) {
            checkInstance.setCheckLogin(instance.getCheckLogin());
        }
        if (conditionField.contains(ModelTUserLoginAuthSysInfo.FI_CHECK_LOGIN_GRAY_LIST)) {
            checkInstance.setCheckLoginGrayList(instance.getCheckLoginGrayList());
        }
        if (conditionField.contains(ModelTUserLoginAuthSysInfo.FI_CHECK_LOGIN_WHITE_LIST)) {
            checkInstance.setCheckLoginWhiteList(instance.getCheckLoginWhiteList());
        }
        if (conditionField.contains(ModelTUserLoginAuthSysInfo.FI_CHECK_PAY)) {
            checkInstance.setCheckPay(instance.getCheckPay());
        }
        if (conditionField.contains(ModelTUserLoginAuthSysInfo.FI_LOGIN_EXPIRE_TIME)) {
            checkInstance.setLoginExpireTime(instance.getLoginExpireTime());
        }
        if (conditionField.contains(ModelTUserLoginAuthSysInfo.FI_EXTEND_EXPIRE_TIME)) {
            checkInstance.setExtendExpireTime(instance.getExtendExpireTime());
        }
        if (conditionField.contains(ModelTUserLoginAuthSysInfo.FI_LAST_LOGIN_REMAIN_TIME)) {
            checkInstance.setLastLoginRemainTime(instance.getLastLoginRemainTime());
        }
        if (conditionField.contains(ModelTUserLoginAuthSysInfo.FI_LAST_EXTEND_REMAIN_TIME)) {
            checkInstance.setLastExtendRemainTime(instance.getLastExtendRemainTime());
        }
        if (conditionField.contains(ModelTUserLoginAuthSysInfo.FI_CREATE_TIME)) {
            checkInstance.setCreateTime(instance.getCreateTime());
        }
        if (conditionField.contains(ModelTUserLoginAuthSysInfo.FI_DELETE_FLAG)) {
            checkInstance.setDeleteFlag(instance.getDeleteFlag());
        }
        ModelTUserLoginAuthSysInfo selected = getOneByCondition(Collections.singleton(ModelTUserLoginAuthSysInfo.FI_ID), new BaseDaoAssembler(), checkInstance);
        if (selected == null) {
            return insert(instance, assembler);
        } else {
            update(instance, conditionField, assembler);
            return instance;
        }
    }

    public ModelTUserLoginAuthSysInfo updateOrInsert(ModelTUserLoginAuthSysInfo instance, Set<String> conditionField) {
        return updateOrInsert(instance, conditionField, null);
    }

    @Transactional
    public ModelTUserLoginAuthSysInfo insertIfNoExist(ModelTUserLoginAuthSysInfo instance, Set<String> conditionField, DaoAssembler assembler) {
        ModelTUserLoginAuthSysInfo checkInstance = new ModelTUserLoginAuthSysInfo();
        if (conditionField.contains(ModelTUserLoginAuthSysInfo.FI_ID)) {
            checkInstance.setId(instance.getId());
        }
        if (conditionField.contains(ModelTUserLoginAuthSysInfo.FI_CHANNEL)) {
            checkInstance.setChannel(instance.getChannel());
        }
        if (conditionField.contains(ModelTUserLoginAuthSysInfo.FI_CHECK_LOGIN)) {
            checkInstance.setCheckLogin(instance.getCheckLogin());
        }
        if (conditionField.contains(ModelTUserLoginAuthSysInfo.FI_CHECK_LOGIN_GRAY_LIST)) {
            checkInstance.setCheckLoginGrayList(instance.getCheckLoginGrayList());
        }
        if (conditionField.contains(ModelTUserLoginAuthSysInfo.FI_CHECK_LOGIN_WHITE_LIST)) {
            checkInstance.setCheckLoginWhiteList(instance.getCheckLoginWhiteList());
        }
        if (conditionField.contains(ModelTUserLoginAuthSysInfo.FI_CHECK_PAY)) {
            checkInstance.setCheckPay(instance.getCheckPay());
        }
        if (conditionField.contains(ModelTUserLoginAuthSysInfo.FI_LOGIN_EXPIRE_TIME)) {
            checkInstance.setLoginExpireTime(instance.getLoginExpireTime());
        }
        if (conditionField.contains(ModelTUserLoginAuthSysInfo.FI_EXTEND_EXPIRE_TIME)) {
            checkInstance.setExtendExpireTime(instance.getExtendExpireTime());
        }
        if (conditionField.contains(ModelTUserLoginAuthSysInfo.FI_LAST_LOGIN_REMAIN_TIME)) {
            checkInstance.setLastLoginRemainTime(instance.getLastLoginRemainTime());
        }
        if (conditionField.contains(ModelTUserLoginAuthSysInfo.FI_LAST_EXTEND_REMAIN_TIME)) {
            checkInstance.setLastExtendRemainTime(instance.getLastExtendRemainTime());
        }
        if (conditionField.contains(ModelTUserLoginAuthSysInfo.FI_CREATE_TIME)) {
            checkInstance.setCreateTime(instance.getCreateTime());
        }
        if (conditionField.contains(ModelTUserLoginAuthSysInfo.FI_DELETE_FLAG)) {
            checkInstance.setDeleteFlag(instance.getDeleteFlag());
        }
        ModelTUserLoginAuthSysInfo selected = getOneByCondition(Collections.singleton(ModelTUserLoginAuthSysInfo.FI_ID), new BaseDaoAssembler(), checkInstance);
        if (selected == null) {
            return insert(instance, assembler);
        } else {
            instance.setId(selected.getId());
            return instance;
        }
    }

    public ModelTUserLoginAuthSysInfo insertIfNoExist(ModelTUserLoginAuthSysInfo instance, Set<String> conditionField) {
        return insertIfNoExist(instance, conditionField, null);
    }

    public<TT> Map<TT, ModelTUserLoginAuthSysInfo> buildMap(List<ModelTUserLoginAuthSysInfo> list, String field) {
        Map<TT, ModelTUserLoginAuthSysInfo> ret = CollectionHelper.newMap();
        if (list == null) {
            return ret;
        }
        for (ModelTUserLoginAuthSysInfo item: list) {
            ret.put(ModelTUserLoginAuthSysInfo.MAP_OBJ_MAPPER.<TT> getField(field, item), item);
        }
        return ret;
    }

    public<TT> Map<TT, List<ModelTUserLoginAuthSysInfo>> buildListMap(List<ModelTUserLoginAuthSysInfo> list, String field) {
        Map<TT, List<ModelTUserLoginAuthSysInfo>> ret = CollectionHelper.newMap();
        if (list == null) {
            return ret;
        }
        for (ModelTUserLoginAuthSysInfo item: list) {
            List<ModelTUserLoginAuthSysInfo> itemList = ret.get(ModelTUserLoginAuthSysInfo.MAP_OBJ_MAPPER.<TT> getField(field, item));
            if (itemList == null) {
                itemList = CollectionHelper.newList();
            }
            itemList.add(item);
            ret.put(ModelTUserLoginAuthSysInfo.MAP_OBJ_MAPPER.<TT> getField(field, item), itemList);
        }
        return ret;
    }

    public<TT> List<TT> extractItemAsList(List<ModelTUserLoginAuthSysInfo> list, String field) {
        List<TT> ret = CollectionHelper.newList();
        if (list == null) {
            return ret;
        }
        for (ModelTUserLoginAuthSysInfo item: list) {
            ret.add(ModelTUserLoginAuthSysInfo.MAP_OBJ_MAPPER.<TT> getField(field, item));
        }
        return ret;
    }
}
