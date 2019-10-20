package com.shangde.ent_portal.logical.dao.basedao;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map;
import java.util.Set;
import com.shangde.ent_portal.logical.dto.basepo.ModelTWechatInfo.ResultSetMapperModelTWechatInfo;
import com.shawn.ss.lib.tools.CollectionHelper;
import com.shawn.ss.lib.tools.TypeConstantHelper;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.SimpleDbInterface;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model.ColumnDataType;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model.LogicalOpType;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model.LogicalRelationshipType;
import com.shawn.ss.lib.tools.db.dto_base.model.AbstractBaseModel;
import com.shawn.ss.lib.tools.db.impl.dao.AbstractDao;
import com.shawn.ss.lib.tools.db.impl.dao.DaoInterface;
import com.shawn.ss.lib.tools.service_assemble.AbstractMultipleDaoAssembler;
import com.shawn.ss.lib.tools.service_assemble.BaseMultipleDaoAssembler;
import com.shawn.ss.lib.tools.service_assemble.DaoAssembler;
import com.shawn.ss.lib.tools.sql_code_gen.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.shangde.ent_portal.logical.dto.basepo.ModelTWechatInfo;

@Repository("DAOTWechatInfo")
@SuppressWarnings("unchecked")
public class DAOTWechatInfo
    extends AbstractDao<com.shangde.ent_portal.logical.dto.basepo.ModelTWechatInfo, Integer>
    implements DaoInterface<com.shangde.ent_portal.logical.dto.basepo.ModelTWechatInfo, Integer> , InitializingBean
{
    public final static Logger logger = LoggerFactory.getLogger(DAOTWechatInfo.class);
    @Autowired(required = true)
    @Qualifier("ent_portal_slave")
    protected SimpleDbInterface data_store;
    protected final static Map<String, SimpleDbInterface> dbMap = CollectionHelper.newMap();
    public final static String dbOfEntPortalSlave = "ent_portal_slave";
    @Autowired(required = true)
    @Qualifier("ent_portal_slave")
    protected SimpleDbInterface data_storeEntPortalSlave;

    public DAOTWechatInfo() {
        super(com.shangde.ent_portal.logical.dto.basepo.ModelTWechatInfo.class);
    }

    @Override
    public void afterPropertiesSet()
        throws Exception
    {
        if (data_storeEntPortalSlave!= null) {
            dbMap.put(dbOfEntPortalSlave, data_storeEntPortalSlave);
        }
    }

    protected<TT> TT getSingleResult(DaoAssembler assembler, SQL<SQLSelect> sqlBuilder, Map<String, Object> param, Class<TT> tClass) {
        SimpleDbInterface dbInstance = data_store;
        String dbToUse = super.selectDb(assembler, sqlBuilder, param);
        if ((dbToUse!= null)&&dbMap.containsKey(dbToUse)) {
            dbInstance = dbMap.get(dbToUse);
        }
        return super.getSingleResult(dbInstance, assembler, sqlBuilder, param, tClass);
    }

    protected<TT> List<TT> getSingleResults(DaoAssembler assembler, SQL<SQLSelect> sqlBuilder, Map<String, Object> param, Class<TT> tClass) {
        SimpleDbInterface dbInstance = data_store;
        String dbToUse = super.selectDb(assembler, sqlBuilder, param);
        if ((dbToUse!= null)&&dbMap.containsKey(dbToUse)) {
            dbInstance = dbMap.get(dbToUse);
        }
        return super.getSingleResults(dbInstance, assembler, sqlBuilder, param, tClass);
    }

    protected List<ModelTWechatInfo> getResults(DaoAssembler assembler, SQL<SQLSelect> sqlBuilder, Map<String, Object> param) {
        int status = 0;
        if (assembler!= null) {
            status = assembler.assembleSql(sqlBuilder, param, ModelTWechatInfo.class);
        }
        SimpleDbInterface dbInstance = data_store;
        String dbToUse = super.selectDb(assembler, sqlBuilder, param);
        if ((dbToUse!= null)&&dbMap.containsKey(dbToUse)) {
            dbInstance = dbMap.get(dbToUse);
        }
        if (status == 0) {
            ResultSetMapperModelTWechatInfo<ModelTWechatInfo> rsMapper = ModelTWechatInfo.RESULT_SET_OBJ_MAPPER;
            if (assembler!= null) {
                ResultSetMapperModelTWechatInfo<ModelTWechatInfo> rsMapperTmp = ((ResultSetMapperModelTWechatInfo<ModelTWechatInfo> ) assembler.<ModelTWechatInfo> assembleResultSetMapper(param, ModelTWechatInfo.class));
                if (rsMapperTmp!= null) {
                    rsMapper = rsMapperTmp;
                }
            }
            try {
                return super.getResults(dbInstance, assembler, sqlBuilder, param, rsMapper);
            } catch (final Exception ex) {
                logger.error("sql execption", ex);
                return null;
            }
        } else {
            return null;
        }
    }

    protected ModelTWechatInfo getResult(DaoAssembler assembler, SQL<SQLSelect> sqlBuilder, Map<String, Object> param) {
        int status = 0;
        if (assembler!= null) {
            status = assembler.assembleSql(sqlBuilder, param, ModelTWechatInfo.class);
        }
        SimpleDbInterface dbInstance = data_store;
        String dbToUse = super.selectDb(assembler, sqlBuilder, param);
        if ((dbToUse!= null)&&dbMap.containsKey(dbToUse)) {
            dbInstance = dbMap.get(dbToUse);
        }
        if (status == 0) {
            ResultSetMapperModelTWechatInfo<ModelTWechatInfo> rsMapper = ModelTWechatInfo.RESULT_SET_OBJ_MAPPER;
            if (assembler!= null) {
                ResultSetMapperModelTWechatInfo<ModelTWechatInfo> rsMapperTmp = ((ResultSetMapperModelTWechatInfo<ModelTWechatInfo> ) assembler.<ModelTWechatInfo> assembleResultSetMapper(param, ModelTWechatInfo.class));
                if (rsMapperTmp!= null) {
                    rsMapper = rsMapperTmp;
                }
            }
            try {
                return super.getResult(dbInstance, assembler, sqlBuilder, param, rsMapper);
            } catch (final Exception ex) {
                logger.error("sql execption", ex);
                return null;
            }
        } else {
            return null;
        }
    }

    protected void buildInClause(SQLSelect sqlBuilder, String inField, Map<String, Object> param, List indexes) {
        if (ModelTWechatInfo.FIELD_CLASS.containsKey(inField)) {
            Object fieldClassObj = ModelTWechatInfo.FIELD_CLASS.get(inField);
            super.buildRawInCluase(sqlBuilder, param, inField, fieldClassObj, indexes);
        } else {
            logger.error("field parameter error");
            throw new IllegalArgumentException(((("there is mistake with infield parameter, column "+ inField)+" not found in table ")+ com.shangde.ent_portal.logical.dto.basepo.ModelTWechatInfo.DTO_TABLE_NAME));
        }
    }

    protected void buildConditionCluase(SQLSelect sqlBuilder, ModelTWechatInfo instance, Map<String, Object> param) {
        Integer dId = instance.getId();
        if (dId!= null) {
            sqlBuilder.itemWhere(ModelTWechatInfo.FI_ID, ColumnDataType.intData);
            param.put(ModelTWechatInfo.FI_ID, dId);
        }
        String dWechat_name = instance.getWechatName();
        if (dWechat_name!= null) {
            sqlBuilder.itemWhere(ModelTWechatInfo.FI_WECHAT_NAME, ColumnDataType.stringData);
            param.put(ModelTWechatInfo.FI_WECHAT_NAME, dWechat_name);
        }
        String dApp_id = instance.getAppId();
        if (dApp_id!= null) {
            sqlBuilder.itemWhere(ModelTWechatInfo.FI_APP_ID, ColumnDataType.stringData);
            param.put(ModelTWechatInfo.FI_APP_ID, dApp_id);
        }
        String dApp_secret = instance.getAppSecret();
        if (dApp_secret!= null) {
            sqlBuilder.itemWhere(ModelTWechatInfo.FI_APP_SECRET, ColumnDataType.stringData);
            param.put(ModelTWechatInfo.FI_APP_SECRET, dApp_secret);
        }
        String dCreat_name = instance.getCreatName();
        if (dCreat_name!= null) {
            sqlBuilder.itemWhere(ModelTWechatInfo.FI_CREAT_NAME, ColumnDataType.stringData);
            param.put(ModelTWechatInfo.FI_CREAT_NAME, dCreat_name);
        }
        Date dCreat_time = instance.getCreatTime();
        if (dCreat_time!= null) {
            sqlBuilder.itemWhere(ModelTWechatInfo.FI_CREAT_TIME, ColumnDataType.timeStampData);
            param.put(ModelTWechatInfo.FI_CREAT_TIME, dCreat_time);
        }
        Date dUpdate_time = instance.getUpdateTime();
        if (dUpdate_time!= null) {
            sqlBuilder.itemWhere(ModelTWechatInfo.FI_UPDATE_TIME, ColumnDataType.timeStampData);
            param.put(ModelTWechatInfo.FI_UPDATE_TIME, dUpdate_time);
        }
        String dSchool_name = instance.getSchoolName();
        if (dSchool_name!= null) {
            sqlBuilder.itemWhere(ModelTWechatInfo.FI_SCHOOL_NAME, ColumnDataType.stringData);
            param.put(ModelTWechatInfo.FI_SCHOOL_NAME, dSchool_name);
        }
        String dSource_id = instance.getSourceId();
        if (dSource_id!= null) {
            sqlBuilder.itemWhere(ModelTWechatInfo.FI_SOURCE_ID, ColumnDataType.stringData);
            param.put(ModelTWechatInfo.FI_SOURCE_ID, dSource_id);
        }
        String dAttention_reply = instance.getAttentionReply();
        if (dAttention_reply!= null) {
            sqlBuilder.itemWhere(ModelTWechatInfo.FI_ATTENTION_REPLY, ColumnDataType.stringData);
            param.put(ModelTWechatInfo.FI_ATTENTION_REPLY, dAttention_reply);
        }
        String dAuto_reply = instance.getAutoReply();
        if (dAuto_reply!= null) {
            sqlBuilder.itemWhere(ModelTWechatInfo.FI_AUTO_REPLY, ColumnDataType.stringData);
            param.put(ModelTWechatInfo.FI_AUTO_REPLY, dAuto_reply);
        }
    }

    protected void buildSelectFieldCluase(SQLSelect sqlBuilder, Set<String> selectFields) {
        if (selectFields.contains(ModelTWechatInfo.FI_ID)) {
            sqlBuilder.itemCol(ModelTWechatInfo.FI_ID);
        }
        if (selectFields.contains(ModelTWechatInfo.FI_WECHAT_NAME)) {
            sqlBuilder.itemCol(ModelTWechatInfo.FI_WECHAT_NAME);
        }
        if (selectFields.contains(ModelTWechatInfo.FI_APP_ID)) {
            sqlBuilder.itemCol(ModelTWechatInfo.FI_APP_ID);
        }
        if (selectFields.contains(ModelTWechatInfo.FI_APP_SECRET)) {
            sqlBuilder.itemCol(ModelTWechatInfo.FI_APP_SECRET);
        }
        if (selectFields.contains(ModelTWechatInfo.FI_CREAT_NAME)) {
            sqlBuilder.itemCol(ModelTWechatInfo.FI_CREAT_NAME);
        }
        if (selectFields.contains(ModelTWechatInfo.FI_CREAT_TIME)) {
            sqlBuilder.itemCol(ModelTWechatInfo.FI_CREAT_TIME);
        }
        if (selectFields.contains(ModelTWechatInfo.FI_UPDATE_TIME)) {
            sqlBuilder.itemCol(ModelTWechatInfo.FI_UPDATE_TIME);
        }
        if (selectFields.contains(ModelTWechatInfo.FI_SCHOOL_NAME)) {
            sqlBuilder.itemCol(ModelTWechatInfo.FI_SCHOOL_NAME);
        }
        if (selectFields.contains(ModelTWechatInfo.FI_SOURCE_ID)) {
            sqlBuilder.itemCol(ModelTWechatInfo.FI_SOURCE_ID);
        }
        if (selectFields.contains(ModelTWechatInfo.FI_ATTENTION_REPLY)) {
            sqlBuilder.itemCol(ModelTWechatInfo.FI_ATTENTION_REPLY);
        }
        if (selectFields.contains(ModelTWechatInfo.FI_AUTO_REPLY)) {
            sqlBuilder.itemCol(ModelTWechatInfo.FI_AUTO_REPLY);
        }
    }

    public List<ModelTWechatInfo> get(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count) {
        if (selectFields == null) {
            selectFields = ModelTWechatInfo.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();;
        if (start == null) {
            start = AbstractBaseModel.DEFAULT_START;
        }
        if (count == null) {
            count = AbstractBaseModel.DEFUALT_COUNT;
        }
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        buildSelectFieldCluase(sqlBuilder, selectFields);
        sqlBuilder.limit();
        return getResults(assembler, sqlBuilder, param);
    }

    public List<ModelTWechatInfo> get(Set<String> selectFields, Integer start, Integer count) {
        return get(selectFields, null, start, count);
    }

    public List<ModelTWechatInfo> get(Integer start, Integer count) {
        return get(null, start, count);
    }

    public List<ModelTWechatInfo> get() {
        return get(null, null);
    }

    public List<ModelTWechatInfo> getById(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, List<Integer> id) {
        if (selectFields == null) {
            selectFields = ModelTWechatInfo.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();;
        if (start == null) {
            start = AbstractBaseModel.DEFAULT_START;
        }
        if (count == null) {
            count = AbstractBaseModel.DEFUALT_COUNT;
        }
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        buildSelectFieldCluase(sqlBuilder, selectFields);
        if (id!= null) {
            sqlBuilder.itemWhere(LogicalRelationshipType.and, LogicalOpType.in, null, ModelTWechatInfo.FI_ID, ModelTWechatInfo.FI_ID, ColumnDataType.intData);
        }
        sqlBuilder.limit();
        return getResults(assembler, sqlBuilder, param);
    }

    public List<ModelTWechatInfo> getById(Set<String> selectFields, Integer start, Integer count, List<Integer> id) {
        return getById(selectFields, null, start, count, id);
    }

    public List<ModelTWechatInfo> getById(Integer start, Integer count, List<Integer> id) {
        return getById(null, start, count, id);
    }

    public List<ModelTWechatInfo> getById(List<Integer> id) {
        return getById(null, null, id);
    }

    public List<ModelTWechatInfo> getByIndex(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, String inField, List indexes) {
        if (selectFields == null) {
            selectFields = ModelTWechatInfo.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();;
        if (start == null) {
            start = AbstractBaseModel.DEFAULT_START;
        }
        if (count == null) {
            count = AbstractBaseModel.DEFUALT_COUNT;
        }
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        buildSelectFieldCluase(sqlBuilder, selectFields);
        buildInClause(sqlBuilder, inField, param, indexes);
        sqlBuilder.limit();
        return getResults(assembler, sqlBuilder, param);
    }

    public List<ModelTWechatInfo> getByIndex(Set<String> selectFields, Integer start, Integer count, String inField, List indexes) {
        return getByIndex(selectFields, null, start, count, inField, indexes);
    }

    public List<ModelTWechatInfo> getByIndex(Integer start, Integer count, String inField, List indexes) {
        return getByIndex(null, start, count, inField, indexes);
    }

    public List<ModelTWechatInfo> getByIndex(String inField, List indexes) {
        return getByIndex(null, null, inField, indexes);
    }

    public List<ModelTWechatInfo> getByCond(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, ModelTWechatInfo instance) {
        if (selectFields == null) {
            selectFields = ModelTWechatInfo.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        if (start == null) {
            start = AbstractBaseModel.DEFAULT_START;
        }
        if (count == null) {
            count = AbstractBaseModel.DEFUALT_COUNT;
        }
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        buildConditionCluase(sqlBuilder, instance, param);
        buildSelectFieldCluase(sqlBuilder, selectFields);
        sqlBuilder.limit();
        return getResults(assembler, sqlBuilder, param);
    }

    public List<ModelTWechatInfo> getByCond(Set<String> selectFields, Integer start, Integer count, ModelTWechatInfo instance) {
        return getByCond(selectFields, null, start, count, instance);
    }

    public List<ModelTWechatInfo> getByCond(Integer start, Integer count, ModelTWechatInfo instance) {
        return getByCond(null, start, count, instance);
    }

    public List<ModelTWechatInfo> getByCond(ModelTWechatInfo instance) {
        return getByCond(null, null, instance);
    }

    public List<ModelTWechatInfo> getByWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelTWechatInfo.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();;
        if (start == null) {
            start = AbstractBaseModel.DEFAULT_START;
        }
        if (count == null) {
            count = AbstractBaseModel.DEFUALT_COUNT;
        }
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        super.buildRawWhere(sqlBuilder, param, extParam, extCondition);
        buildSelectFieldCluase(sqlBuilder, selectFields);
        sqlBuilder.limit();
        return getResults(assembler, sqlBuilder, param);
    }

    public List<ModelTWechatInfo> getByWhere(Set<String> selectFields, Integer start, Integer count, Map<String, Object> extParam, Set<String> extCondition) {
        return getByWhere(selectFields, null, start, count, extParam, extCondition);
    }

    public List<ModelTWechatInfo> getByWhere(Integer start, Integer count, Map<String, Object> extParam, Set<String> extCondition) {
        return getByWhere(null, start, count, extParam, extCondition);
    }

    public List<ModelTWechatInfo> getByWhere(Map<String, Object> extParam, Set<String> extCondition) {
        return getByWhere(null, null, extParam, extCondition);
    }

    public List<ModelTWechatInfo> getByCondAndIndex(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, ModelTWechatInfo instance, String inField, List indexes) {
        if (selectFields == null) {
            selectFields = ModelTWechatInfo.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();;
        if (start == null) {
            start = AbstractBaseModel.DEFAULT_START;
        }
        if (count == null) {
            count = AbstractBaseModel.DEFUALT_COUNT;
        }
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        buildConditionCluase(sqlBuilder, instance, param);
        buildSelectFieldCluase(sqlBuilder, selectFields);
        buildInClause(sqlBuilder, inField, param, indexes);
        sqlBuilder.limit();
        return getResults(assembler, sqlBuilder, param);
    }

    public List<ModelTWechatInfo> getByCondAndIndex(Set<String> selectFields, Integer start, Integer count, ModelTWechatInfo instance, String inField, List indexes) {
        return getByCondAndIndex(selectFields, null, start, count, instance, inField, indexes);
    }

    public List<ModelTWechatInfo> getByCondAndIndex(Integer start, Integer count, ModelTWechatInfo instance, String inField, List indexes) {
        return getByCondAndIndex(null, start, count, instance, inField, indexes);
    }

    public List<ModelTWechatInfo> getByCondAndIndex(ModelTWechatInfo instance, String inField, List indexes) {
        return getByCondAndIndex(null, null, instance, inField, indexes);
    }

    public List<ModelTWechatInfo> getByIdAndWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, Integer id, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelTWechatInfo.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();;
        if (start == null) {
            start = AbstractBaseModel.DEFAULT_START;
        }
        if (count == null) {
            count = AbstractBaseModel.DEFUALT_COUNT;
        }
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        super.buildRawWhere(sqlBuilder, param, extParam, extCondition);
        buildSelectFieldCluase(sqlBuilder, selectFields);
        if (id!= null) {
            sqlBuilder.itemWhere(LogicalRelationshipType.and, LogicalOpType.in, null, ModelTWechatInfo.FI_ID, ModelTWechatInfo.FI_ID, ColumnDataType.intData);
        }
        sqlBuilder.limit();
        return getResults(assembler, sqlBuilder, param);
    }

    public List<ModelTWechatInfo> getByIdAndWhere(Set<String> selectFields, Integer start, Integer count, Integer id, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIdAndWhere(selectFields, null, start, count, id, extParam, extCondition);
    }

    public List<ModelTWechatInfo> getByIdAndWhere(Integer start, Integer count, Integer id, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIdAndWhere(null, start, count, id, extParam, extCondition);
    }

    public List<ModelTWechatInfo> getByIdAndWhere(Integer id, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIdAndWhere(null, null, id, extParam, extCondition);
    }

    public List<ModelTWechatInfo> getByIdAndCondAndWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, ModelTWechatInfo instance, List<Integer> id, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelTWechatInfo.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();;
        if (start == null) {
            start = AbstractBaseModel.DEFAULT_START;
        }
        if (count == null) {
            count = AbstractBaseModel.DEFUALT_COUNT;
        }
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        super.buildRawWhere(sqlBuilder, param, extParam, extCondition);
        buildConditionCluase(sqlBuilder, instance, param);
        buildSelectFieldCluase(sqlBuilder, selectFields);
        if (id!= null) {
            sqlBuilder.itemWhere(LogicalRelationshipType.and, LogicalOpType.in, null, ModelTWechatInfo.FI_ID, ModelTWechatInfo.FI_ID, ColumnDataType.intData);
        }
        sqlBuilder.limit();
        return getResults(assembler, sqlBuilder, param);
    }

    public List<ModelTWechatInfo> getByIdAndCondAndWhere(Set<String> selectFields, Integer start, Integer count, ModelTWechatInfo instance, List<Integer> id, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIdAndCondAndWhere(selectFields, null, start, count, instance, id, extParam, extCondition);
    }

    public List<ModelTWechatInfo> getByIdAndCondAndWhere(Integer start, Integer count, ModelTWechatInfo instance, List<Integer> id, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIdAndCondAndWhere(null, start, count, instance, id, extParam, extCondition);
    }

    public List<ModelTWechatInfo> getByIdAndCondAndWhere(ModelTWechatInfo instance, List<Integer> id, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIdAndCondAndWhere(null, null, instance, id, extParam, extCondition);
    }

    public List<ModelTWechatInfo> getByIndexAndWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelTWechatInfo.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();;
        if (start == null) {
            start = AbstractBaseModel.DEFAULT_START;
        }
        if (count == null) {
            count = AbstractBaseModel.DEFUALT_COUNT;
        }
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        super.buildRawWhere(sqlBuilder, param, extParam, extCondition);
        buildSelectFieldCluase(sqlBuilder, selectFields);
        buildInClause(sqlBuilder, inField, param, indexes);
        sqlBuilder.limit();
        return getResults(assembler, sqlBuilder, param);
    }

    public List<ModelTWechatInfo> getByIndexAndWhere(Set<String> selectFields, Integer start, Integer count, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIndexAndWhere(selectFields, null, start, count, inField, indexes, extParam, extCondition);
    }

    public List<ModelTWechatInfo> getByIndexAndWhere(Integer start, Integer count, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIndexAndWhere(null, start, count, inField, indexes, extParam, extCondition);
    }

    public List<ModelTWechatInfo> getByIndexAndWhere(String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIndexAndWhere(null, null, inField, indexes, extParam, extCondition);
    }

    public List<ModelTWechatInfo> getByCondAndWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, ModelTWechatInfo instance, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelTWechatInfo.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();;
        if (start == null) {
            start = AbstractBaseModel.DEFAULT_START;
        }
        if (count == null) {
            count = AbstractBaseModel.DEFUALT_COUNT;
        }
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        super.buildRawWhere(sqlBuilder, param, extParam, extCondition);
        buildConditionCluase(sqlBuilder, instance, param);
        buildSelectFieldCluase(sqlBuilder, selectFields);
        sqlBuilder.limit();
        return getResults(assembler, sqlBuilder, param);
    }

    public List<ModelTWechatInfo> getByCondAndWhere(Set<String> selectFields, Integer start, Integer count, ModelTWechatInfo instance, Map<String, Object> extParam, Set<String> extCondition) {
        return getByCondAndWhere(selectFields, null, start, count, instance, extParam, extCondition);
    }

    public List<ModelTWechatInfo> getByCondAndWhere(Integer start, Integer count, ModelTWechatInfo instance, Map<String, Object> extParam, Set<String> extCondition) {
        return getByCondAndWhere(null, start, count, instance, extParam, extCondition);
    }

    public List<ModelTWechatInfo> getByCondAndWhere(ModelTWechatInfo instance, Map<String, Object> extParam, Set<String> extCondition) {
        return getByCondAndWhere(null, null, instance, extParam, extCondition);
    }

    public List<ModelTWechatInfo> getByCondAndIndexAndWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, ModelTWechatInfo instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelTWechatInfo.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();;
        if (start == null) {
            start = AbstractBaseModel.DEFAULT_START;
        }
        if (count == null) {
            count = AbstractBaseModel.DEFUALT_COUNT;
        }
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        super.buildRawWhere(sqlBuilder, param, extParam, extCondition);
        buildConditionCluase(sqlBuilder, instance, param);
        buildSelectFieldCluase(sqlBuilder, selectFields);
        buildInClause(sqlBuilder, inField, param, indexes);
        sqlBuilder.limit();
        return getResults(assembler, sqlBuilder, param);
    }

    public List<ModelTWechatInfo> getByCondAndIndexAndWhere(Set<String> selectFields, Integer start, Integer count, ModelTWechatInfo instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        return getByCondAndIndexAndWhere(selectFields, null, start, count, instance, inField, indexes, extParam, extCondition);
    }

    public List<ModelTWechatInfo> getByCondAndIndexAndWhere(Integer start, Integer count, ModelTWechatInfo instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        return getByCondAndIndexAndWhere(null, start, count, instance, inField, indexes, extParam, extCondition);
    }

    public List<ModelTWechatInfo> getByCondAndIndexAndWhere(ModelTWechatInfo instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        return getByCondAndIndexAndWhere(null, null, instance, inField, indexes, extParam, extCondition);
    }

    public ModelTWechatInfo getOneById(Set<String> selectFields, DaoAssembler assembler, Integer id) {
        if (selectFields == null) {
            selectFields = ModelTWechatInfo.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();;
        Integer start = 0;
        Integer count = 1;
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        buildSelectFieldCluase(sqlBuilder, selectFields);
        if (id!= null) {
            sqlBuilder.itemWhere(ModelTWechatInfo.FI_ID, ColumnDataType.intData);
        }
        sqlBuilder.limit();
        return getResult(assembler, sqlBuilder, param);
    }

    public ModelTWechatInfo getOneById(Set<String> selectFields, Integer id) {
        return getOneById(selectFields, null, id);
    }

    public ModelTWechatInfo getOneById(Integer id) {
        return getOneById(null, id);
    }

    public ModelTWechatInfo getOneByCond(Set<String> selectFields, DaoAssembler assembler, ModelTWechatInfo instance) {
        if (selectFields == null) {
            selectFields = ModelTWechatInfo.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();;
        Integer start = 0;
        Integer count = 1;
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        buildConditionCluase(sqlBuilder, instance, param);
        buildSelectFieldCluase(sqlBuilder, selectFields);
        sqlBuilder.limit();
        return getResult(assembler, sqlBuilder, param);
    }

    public ModelTWechatInfo getOneByCond(Set<String> selectFields, ModelTWechatInfo instance) {
        return getOneByCond(selectFields, null, instance);
    }

    public ModelTWechatInfo getOneByCond(ModelTWechatInfo instance) {
        return getOneByCond(null, instance);
    }

    public ModelTWechatInfo getOneByWhere(Set<String> selectFields, DaoAssembler assembler, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelTWechatInfo.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();;
        Integer start = 0;
        Integer count = 1;
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        super.buildRawWhere(sqlBuilder, param, extParam, extCondition);
        buildSelectFieldCluase(sqlBuilder, selectFields);
        sqlBuilder.limit();
        return getResult(assembler, sqlBuilder, param);
    }

    public ModelTWechatInfo getOneByWhere(Set<String> selectFields, Map<String, Object> extParam, Set<String> extCondition) {
        return getOneByWhere(selectFields, null, extParam, extCondition);
    }

    public ModelTWechatInfo getOneByWhere(Map<String, Object> extParam, Set<String> extCondition) {
        return getOneByWhere(null, extParam, extCondition);
    }

    public ModelTWechatInfo getOneByCondAndWhere(Set<String> selectFields, DaoAssembler assembler, ModelTWechatInfo instance, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelTWechatInfo.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();;
        Integer start = 0;
        Integer count = 1;
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        super.buildRawWhere(sqlBuilder, param, extParam, extCondition);
        buildConditionCluase(sqlBuilder, instance, param);
        buildSelectFieldCluase(sqlBuilder, selectFields);
        sqlBuilder.limit();
        return getResult(assembler, sqlBuilder, param);
    }

    public ModelTWechatInfo getOneByCondAndWhere(Set<String> selectFields, ModelTWechatInfo instance, Map<String, Object> extParam, Set<String> extCondition) {
        return getOneByCondAndWhere(selectFields, null, instance, extParam, extCondition);
    }

    public ModelTWechatInfo getOneByCondAndWhere(ModelTWechatInfo instance, Map<String, Object> extParam, Set<String> extCondition) {
        return getOneByCondAndWhere(null, instance, extParam, extCondition);
    }

    public ModelTWechatInfo getOneByIdAndCondAndWhere(Set<String> selectFields, DaoAssembler assembler, ModelTWechatInfo instance, Integer id, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelTWechatInfo.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();;
        Integer start = 0;
        Integer count = 1;
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        super.buildRawWhere(sqlBuilder, param, extParam, extCondition);
        buildConditionCluase(sqlBuilder, instance, param);
        buildSelectFieldCluase(sqlBuilder, selectFields);
        if (id!= null) {
            sqlBuilder.itemWhere(ModelTWechatInfo.FI_ID, ColumnDataType.intData);
        }
        sqlBuilder.limit();
        return getResult(assembler, sqlBuilder, param);
    }

    public ModelTWechatInfo getOneByIdAndCondAndWhere(Set<String> selectFields, ModelTWechatInfo instance, Integer id, Map<String, Object> extParam, Set<String> extCondition) {
        return getOneByIdAndCondAndWhere(selectFields, null, instance, id, extParam, extCondition);
    }

    public ModelTWechatInfo getOneByIdAndCondAndWhere(ModelTWechatInfo instance, Integer id, Map<String, Object> extParam, Set<String> extCondition) {
        return getOneByIdAndCondAndWhere(null, instance, id, extParam, extCondition);
    }

    public Long getCountByCond(DaoAssembler assembler, ModelTWechatInfo instance) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();;
        Integer start = 0;
        Integer count = 1;
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        sqlBuilder.rawSelectItem("count(*)", "count");
        buildConditionCluase(sqlBuilder, instance, param);
        sqlBuilder.limit();
        return getSingleResult(assembler, sqlBuilder, param, Long.class);
    }

    public Long getCountByCond(ModelTWechatInfo instance) {
        return getCountByCond(null, instance);
    }

    public Long getCountByCondAndIndex(DaoAssembler assembler, ModelTWechatInfo instance, String inField, List indexes) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();;
        Integer start = 0;
        Integer count = 1;
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
//        sqlBuilder.rawSelectItem("count(*)", "count");
        sqlBuilder.rawSelectItem("count(*)", "count");
        buildConditionCluase(sqlBuilder, instance, param);
        buildInClause(sqlBuilder, inField, param, indexes);
        sqlBuilder.limit();
        return getSingleResult(assembler, sqlBuilder, param, Long.class);
    }

    public Long getCountByCondAndIndex(ModelTWechatInfo instance, String inField, List indexes) {
        return getCountByCondAndIndex(null, instance, inField, indexes);
    }

    public Long getCountByCondAndIndexAndWhere(DaoAssembler assembler, ModelTWechatInfo instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();;
        Integer start = 0;
        Integer count = 1;
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        super.buildRawWhere(sqlBuilder, param, extParam, extCondition);
        sqlBuilder.rawSelectItem("count(*)", "count");
        buildConditionCluase(sqlBuilder, instance, param);
        buildInClause(sqlBuilder, inField, param, indexes);
        sqlBuilder.limit();
        return getSingleResult(assembler, sqlBuilder, param, Long.class);
    }

    public Long getCountByCondAndIndexAndWhere(ModelTWechatInfo instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        return getCountByCondAndIndexAndWhere(null, instance, inField, indexes, extParam, extCondition);
    }

    public<TT> TT getItemByIndex(DaoAssembler assembler, String inField, List indexes, Class<TT> tClass, String rawSelectItem) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();;
        Integer start = 0;
        Integer count = 1;
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        assert((tClass!= null));
        assert(((rawSelectItem!= null)&&(rawSelectItem.length()> 0)));
        sqlBuilder.rawSelectItem(rawSelectItem);
        buildInClause(sqlBuilder, inField, param, indexes);
        sqlBuilder.limit();
        return ((TT) getSingleResult(assembler, sqlBuilder, param, tClass));
    }

    public<TT extends Object> TT getItemByIndex(String inField, List indexes, Class<TT> tClass, String rawSelectItem) {
        return getItemByIndex(null, inField, indexes, tClass, rawSelectItem);
    }

    public<TT> TT getItemByWhere(DaoAssembler assembler, Class<TT> tClass, String rawSelectItem, Map<String, Object> extParam, Set<String> extCondition) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();;
        Integer start = 0;
        Integer count = 1;
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        super.buildRawWhere(sqlBuilder, param, extParam, extCondition);
        assert((tClass!= null));
        assert(((rawSelectItem!= null)&&(rawSelectItem.length()> 0)));
        sqlBuilder.rawSelectItem(rawSelectItem);
        sqlBuilder.limit();
        return ((TT) getSingleResult(assembler, sqlBuilder, param, tClass));
    }

    public<TT extends Object> TT getItemByWhere(Class<TT> tClass, String rawSelectItem, Map<String, Object> extParam, Set<String> extCondition) {
        return getItemByWhere(null, tClass, rawSelectItem, extParam, extCondition);
    }

    public<TT> TT getItemByCond(DaoAssembler assembler, ModelTWechatInfo instance, Class<TT> tClass, String rawSelectItem) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();;
        Integer start = 0;
        Integer count = 1;
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        assert((tClass!= null));
        assert(((rawSelectItem!= null)&&(rawSelectItem.length()> 0)));
        sqlBuilder.rawSelectItem(rawSelectItem);
        buildConditionCluase(sqlBuilder, instance, param);
        sqlBuilder.limit();
        return ((TT) getSingleResult(assembler, sqlBuilder, param, tClass));
    }

    public<TT extends Object> TT getItemByCond(ModelTWechatInfo instance, Class<TT> tClass, String rawSelectItem) {
        return getItemByCond(null, instance, tClass, rawSelectItem);
    }

    public<TT> TT getItemByCondAndIndex(DaoAssembler assembler, ModelTWechatInfo instance, String inField, List indexes, Class<TT> tClass, String rawSelectItem) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();;
        Integer start = 0;
        Integer count = 1;
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        assert((tClass!= null));
        assert(((rawSelectItem!= null)&&(rawSelectItem.length()> 0)));
        sqlBuilder.rawSelectItem(rawSelectItem);
        buildConditionCluase(sqlBuilder, instance, param);
        buildInClause(sqlBuilder, inField, param, indexes);
        sqlBuilder.limit();
        return ((TT) getSingleResult(assembler, sqlBuilder, param, tClass));
    }

    public<TT extends Object> TT getItemByCondAndIndex(ModelTWechatInfo instance, String inField, List indexes, Class<TT> tClass, String rawSelectItem) {
        return getItemByCondAndIndex(null, instance, inField, indexes, tClass, rawSelectItem);
    }

    public<TT> TT getItemByCondAndIndexAndWhere(DaoAssembler assembler, ModelTWechatInfo instance, String inField, List indexes, Class<TT> tClass, String rawSelectItem, Map<String, Object> extParam, Set<String> extCondition) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();;
        Integer start = 0;
        Integer count = 1;
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        super.buildRawWhere(sqlBuilder, param, extParam, extCondition);
        assert((tClass!= null));
        assert(((rawSelectItem!= null)&&(rawSelectItem.length()> 0)));
        sqlBuilder.rawSelectItem(rawSelectItem);
        buildConditionCluase(sqlBuilder, instance, param);
        buildInClause(sqlBuilder, inField, param, indexes);
        sqlBuilder.limit();
        return ((TT) getSingleResult(assembler, sqlBuilder, param, tClass));
    }

    public<TT extends Object> TT getItemByCondAndIndexAndWhere(ModelTWechatInfo instance, String inField, List indexes, Class<TT> tClass, String rawSelectItem, Map<String, Object> extParam, Set<String> extCondition) {
        return getItemByCondAndIndexAndWhere(null, instance, inField, indexes, tClass, rawSelectItem, extParam, extCondition);
    }

    public<TT> List<TT> getItemListByIndex(DaoAssembler assembler, Integer start, Integer count, String inField, List indexes, Class<TT> tClass, String rawSelectItem) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();;
        if (start == null) {
            start = AbstractBaseModel.DEFAULT_START;
        }
        if (count == null) {
            count = AbstractBaseModel.DEFUALT_COUNT;
        }
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        assert((tClass!= null));
        assert(((rawSelectItem!= null)&&(rawSelectItem.length()> 0)));
        sqlBuilder.rawSelectItem(rawSelectItem);
        buildInClause(sqlBuilder, inField, param, indexes);
        sqlBuilder.limit();
        return ((List<TT> ) getSingleResults(assembler, sqlBuilder, param, tClass));
    }

    public<TT extends Object> List<TT> getItemListByIndex(Integer start, Integer count, String inField, List indexes, Class<TT> tClass, String rawSelectItem) {
        return getItemListByIndex(null, start, count, inField, indexes, tClass, rawSelectItem);
    }

    public<TT extends Object> List<TT> getItemListByIndex(String inField, List indexes, Class<TT> tClass, String rawSelectItem) {
        return getItemListByIndex(null, null, inField, indexes, tClass, rawSelectItem);
    }

    public<TT> List<TT> getItemListByCond(DaoAssembler assembler, Integer start, Integer count, ModelTWechatInfo instance, Class<TT> tClass, String rawSelectItem) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();;
        if (start == null) {
            start = AbstractBaseModel.DEFAULT_START;
        }
        if (count == null) {
            count = AbstractBaseModel.DEFUALT_COUNT;
        }
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        assert((tClass!= null));
        assert(((rawSelectItem!= null)&&(rawSelectItem.length()> 0)));
        sqlBuilder.rawSelectItem(rawSelectItem);
        buildConditionCluase(sqlBuilder, instance, param);
        sqlBuilder.limit();
        return ((List<TT> ) getSingleResults(assembler, sqlBuilder, param, tClass));
    }

    public<TT extends Object> List<TT> getItemListByCond(Integer start, Integer count, ModelTWechatInfo instance, Class<TT> tClass, String rawSelectItem) {
        return getItemListByCond(null, start, count, instance, tClass, rawSelectItem);
    }

    public<TT extends Object> List<TT> getItemListByCond(ModelTWechatInfo instance, Class<TT> tClass, String rawSelectItem) {
        return getItemListByCond(null, null, instance, tClass, rawSelectItem);
    }

    public<TT> List<TT> getItemListById(DaoAssembler assembler, Integer start, Integer count, Integer id, Class<TT> tClass, String rawSelectItem) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();;
        if (start == null) {
            start = AbstractBaseModel.DEFAULT_START;
        }
        if (count == null) {
            count = AbstractBaseModel.DEFUALT_COUNT;
        }
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        assert((tClass!= null));
        assert(((rawSelectItem!= null)&&(rawSelectItem.length()> 0)));
        sqlBuilder.rawSelectItem(rawSelectItem);
        if (id!= null) {
            sqlBuilder.itemWhere(LogicalRelationshipType.and, LogicalOpType.in, null, ModelTWechatInfo.FI_ID, ModelTWechatInfo.FI_ID, ColumnDataType.intData);
        }
        sqlBuilder.limit();
        return ((List<TT> ) getSingleResults(assembler, sqlBuilder, param, tClass));
    }

    public<TT extends Object> List<TT> getItemListById(Integer start, Integer count, Integer id, Class<TT> tClass, String rawSelectItem) {
        return getItemListById(null, start, count, id, tClass, rawSelectItem);
    }

    public<TT extends Object> List<TT> getItemListById(Integer id, Class<TT> tClass, String rawSelectItem) {
        return getItemListById(null, null, id, tClass, rawSelectItem);
    }

    public<TT> List<TT> getItemListByWhere(DaoAssembler assembler, Integer start, Integer count, Class<TT> tClass, String rawSelectItem, Map<String, Object> extParam, Set<String> extCondition) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();;
        if (start == null) {
            start = AbstractBaseModel.DEFAULT_START;
        }
        if (count == null) {
            count = AbstractBaseModel.DEFUALT_COUNT;
        }
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        super.buildRawWhere(sqlBuilder, param, extParam, extCondition);
        assert((tClass!= null));
        assert(((rawSelectItem!= null)&&(rawSelectItem.length()> 0)));
        sqlBuilder.rawSelectItem(rawSelectItem);
        sqlBuilder.limit();
        return ((List<TT> ) getSingleResults(assembler, sqlBuilder, param, tClass));
    }

    public<TT extends Object> List<TT> getItemListByWhere(Integer start, Integer count, Class<TT> tClass, String rawSelectItem, Map<String, Object> extParam, Set<String> extCondition) {
        return getItemListByWhere(null, start, count, tClass, rawSelectItem, extParam, extCondition);
    }

    public<TT extends Object> List<TT> getItemListByWhere(Class<TT> tClass, String rawSelectItem, Map<String, Object> extParam, Set<String> extCondition) {
        return getItemListByWhere(null, null, tClass, rawSelectItem, extParam, extCondition);
    }

    public<TT> List<TT> getItemListByIndexAndWhere(DaoAssembler assembler, Integer start, Integer count, String inField, List indexes, Class<TT> tClass, String rawSelectItem, Map<String, Object> extParam, Set<String> extCondition) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();;
        if (start == null) {
            start = AbstractBaseModel.DEFAULT_START;
        }
        if (count == null) {
            count = AbstractBaseModel.DEFUALT_COUNT;
        }
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        super.buildRawWhere(sqlBuilder, param, extParam, extCondition);
        assert((tClass!= null));
        assert(((rawSelectItem!= null)&&(rawSelectItem.length()> 0)));
        sqlBuilder.rawSelectItem(rawSelectItem);
        buildInClause(sqlBuilder, inField, param, indexes);
        sqlBuilder.limit();
        return ((List<TT> ) getSingleResults(assembler, sqlBuilder, param, tClass));
    }

    public<TT extends Object> List<TT> getItemListByIndexAndWhere(Integer start, Integer count, String inField, List indexes, Class<TT> tClass, String rawSelectItem, Map<String, Object> extParam, Set<String> extCondition) {
        return getItemListByIndexAndWhere(null, start, count, inField, indexes, tClass, rawSelectItem, extParam, extCondition);
    }

    public<TT extends Object> List<TT> getItemListByIndexAndWhere(String inField, List indexes, Class<TT> tClass, String rawSelectItem, Map<String, Object> extParam, Set<String> extCondition) {
        return getItemListByIndexAndWhere(null, null, inField, indexes, tClass, rawSelectItem, extParam, extCondition);
    }

    public<TT> List<TT> getItemListByCondAndWhere(DaoAssembler assembler, Integer start, Integer count, ModelTWechatInfo instance, Class<TT> tClass, String rawSelectItem, Map<String, Object> extParam, Set<String> extCondition) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();;
        if (start == null) {
            start = AbstractBaseModel.DEFAULT_START;
        }
        if (count == null) {
            count = AbstractBaseModel.DEFUALT_COUNT;
        }
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        super.buildRawWhere(sqlBuilder, param, extParam, extCondition);
        assert((tClass!= null));
        assert(((rawSelectItem!= null)&&(rawSelectItem.length()> 0)));
        sqlBuilder.rawSelectItem(rawSelectItem);
        buildConditionCluase(sqlBuilder, instance, param);
        sqlBuilder.limit();
        return ((List<TT> ) getSingleResults(assembler, sqlBuilder, param, tClass));
    }

    public<TT extends Object> List<TT> getItemListByCondAndWhere(Integer start, Integer count, ModelTWechatInfo instance, Class<TT> tClass, String rawSelectItem, Map<String, Object> extParam, Set<String> extCondition) {
        return getItemListByCondAndWhere(null, start, count, instance, tClass, rawSelectItem, extParam, extCondition);
    }

    public<TT extends Object> List<TT> getItemListByCondAndWhere(ModelTWechatInfo instance, Class<TT> tClass, String rawSelectItem, Map<String, Object> extParam, Set<String> extCondition) {
        return getItemListByCondAndWhere(null, null, instance, tClass, rawSelectItem, extParam, extCondition);
    }

    public<TT> List<TT> getItemListByCondAndIndex(DaoAssembler assembler, Integer start, Integer count, ModelTWechatInfo instance, String inField, List indexes, Class<TT> tClass, String rawSelectItem) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();;
        if (start == null) {
            start = AbstractBaseModel.DEFAULT_START;
        }
        if (count == null) {
            count = AbstractBaseModel.DEFUALT_COUNT;
        }
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        assert((tClass!= null));
        assert(((rawSelectItem!= null)&&(rawSelectItem.length()> 0)));
        sqlBuilder.rawSelectItem(rawSelectItem);
        buildConditionCluase(sqlBuilder, instance, param);
        buildInClause(sqlBuilder, inField, param, indexes);
        sqlBuilder.limit();
        return ((List<TT> ) getSingleResults(assembler, sqlBuilder, param, tClass));
    }

    public<TT extends Object> List<TT> getItemListByCondAndIndex(Integer start, Integer count, ModelTWechatInfo instance, String inField, List indexes, Class<TT> tClass, String rawSelectItem) {
        return getItemListByCondAndIndex(null, start, count, instance, inField, indexes, tClass, rawSelectItem);
    }

    public<TT extends Object> List<TT> getItemListByCondAndIndex(ModelTWechatInfo instance, String inField, List indexes, Class<TT> tClass, String rawSelectItem) {
        return getItemListByCondAndIndex(null, null, instance, inField, indexes, tClass, rawSelectItem);
    }

    public<TT> List<TT> getItemListByIdAndCondAndWhere(DaoAssembler assembler, Integer start, Integer count, ModelTWechatInfo instance, List<Integer> id, Class<TT> tClass, String rawSelectItem, Map<String, Object> extParam, Set<String> extCondition) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();;
        if (start == null) {
            start = AbstractBaseModel.DEFAULT_START;
        }
        if (count == null) {
            count = AbstractBaseModel.DEFUALT_COUNT;
        }
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        super.buildRawWhere(sqlBuilder, param, extParam, extCondition);
        assert((tClass!= null));
        assert(((rawSelectItem!= null)&&(rawSelectItem.length()> 0)));
        sqlBuilder.rawSelectItem(rawSelectItem);
        buildConditionCluase(sqlBuilder, instance, param);
        if (id!= null) {
            sqlBuilder.itemWhere(LogicalRelationshipType.and, LogicalOpType.in, null, ModelTWechatInfo.FI_ID, ModelTWechatInfo.FI_ID, ColumnDataType.intData);
        }
        sqlBuilder.limit();
        return ((List<TT> ) getSingleResults(assembler, sqlBuilder, param, tClass));
    }

    public<TT extends Object> List<TT> getItemListByIdAndCondAndWhere(Integer start, Integer count, ModelTWechatInfo instance, List<Integer> id, Class<TT> tClass, String rawSelectItem, Map<String, Object> extParam, Set<String> extCondition) {
        return getItemListByIdAndCondAndWhere(null, start, count, instance, id, tClass, rawSelectItem, extParam, extCondition);
    }

    public<TT extends Object> List<TT> getItemListByIdAndCondAndWhere(ModelTWechatInfo instance, List<Integer> id, Class<TT> tClass, String rawSelectItem, Map<String, Object> extParam, Set<String> extCondition) {
        return getItemListByIdAndCondAndWhere(null, null, instance, id, tClass, rawSelectItem, extParam, extCondition);
    }

    public ModelTWechatInfo insert(ModelTWechatInfo instance, DaoAssembler assembler) {
        SQLInsert sqlBuilder = SQLBuilder.buildInsertSql();
        Integer dId = instance.getId();
        if (dId!= null) {
            sqlBuilder.itemCol(ModelTWechatInfo.FI_ID);
        }
        String dWechat_name = instance.getWechatName();
        if (dWechat_name!= null) {
            sqlBuilder.itemCol(ModelTWechatInfo.FI_WECHAT_NAME);
        }
        String dApp_id = instance.getAppId();
        if (dApp_id!= null) {
            sqlBuilder.itemCol(ModelTWechatInfo.FI_APP_ID);
        }
        String dApp_secret = instance.getAppSecret();
        if (dApp_secret!= null) {
            sqlBuilder.itemCol(ModelTWechatInfo.FI_APP_SECRET);
        }
        String dCreat_name = instance.getCreatName();
        if (dCreat_name!= null) {
            sqlBuilder.itemCol(ModelTWechatInfo.FI_CREAT_NAME);
        }
        Date dCreat_time = instance.getCreatTime();
        if (dCreat_time!= null) {
            sqlBuilder.itemCol(ModelTWechatInfo.FI_CREAT_TIME);
        }
        Date dUpdate_time = instance.getUpdateTime();
        if (dUpdate_time!= null) {
            sqlBuilder.itemCol(ModelTWechatInfo.FI_UPDATE_TIME);
        }
        String dSchool_name = instance.getSchoolName();
        if (dSchool_name!= null) {
            sqlBuilder.itemCol(ModelTWechatInfo.FI_SCHOOL_NAME);
        }
        String dSource_id = instance.getSourceId();
        if (dSource_id!= null) {
            sqlBuilder.itemCol(ModelTWechatInfo.FI_SOURCE_ID);
        }
        String dAttention_reply = instance.getAttentionReply();
        if (dAttention_reply!= null) {
            sqlBuilder.itemCol(ModelTWechatInfo.FI_ATTENTION_REPLY);
        }
        String dAuto_reply = instance.getAutoReply();
        if (dAuto_reply!= null) {
            sqlBuilder.itemCol(ModelTWechatInfo.FI_AUTO_REPLY);
        }
        Map<String, Object> param = ModelTWechatInfo.MAP_OBJ_MAPPER.toCommonMap(instance);
        SimpleDbInterface dbInstance = data_store;
        String dbToUse = super.selectDb(assembler, sqlBuilder, param);
        if ((dbToUse!= null)&&dbMap.containsKey(dbToUse)) {
            dbInstance = dbMap.get(dbToUse);
        }
        Long ret = super.insert(dbInstance, assembler, sqlBuilder, param);
        if (ret!= null) {
            if (ret >Long.MIN_VALUE) {
                instance.setId(((Integer) TypeConstantHelper.testPackPrType(ret, Integer.class)));
                return instance;
            } else {
                return instance;
            }
        } else {
            return null;
        }
    }

    public ModelTWechatInfo insert(ModelTWechatInfo instance) {
        return insert(instance, null);
    }

    public Integer insert(List<ModelTWechatInfo> instances, Set<String> fields, DaoAssembler assembler) {
        if (fields == null) {
            fields = ModelTWechatInfo.FIELD_CLASS.keySet();
        }
        SQLInsert sqlBuilder = SQLBuilder.buildInsertSql();
        if (fields.contains(ModelTWechatInfo.FI_ID)) {
            sqlBuilder.itemCol(ModelTWechatInfo.FI_ID);
        }
        if (fields.contains(ModelTWechatInfo.FI_WECHAT_NAME)) {
            sqlBuilder.itemCol(ModelTWechatInfo.FI_WECHAT_NAME);
        }
        if (fields.contains(ModelTWechatInfo.FI_APP_ID)) {
            sqlBuilder.itemCol(ModelTWechatInfo.FI_APP_ID);
        }
        if (fields.contains(ModelTWechatInfo.FI_APP_SECRET)) {
            sqlBuilder.itemCol(ModelTWechatInfo.FI_APP_SECRET);
        }
        if (fields.contains(ModelTWechatInfo.FI_CREAT_NAME)) {
            sqlBuilder.itemCol(ModelTWechatInfo.FI_CREAT_NAME);
        }
        if (fields.contains(ModelTWechatInfo.FI_CREAT_TIME)) {
            sqlBuilder.itemCol(ModelTWechatInfo.FI_CREAT_TIME);
        }
        if (fields.contains(ModelTWechatInfo.FI_UPDATE_TIME)) {
            sqlBuilder.itemCol(ModelTWechatInfo.FI_UPDATE_TIME);
        }
        if (fields.contains(ModelTWechatInfo.FI_SCHOOL_NAME)) {
            sqlBuilder.itemCol(ModelTWechatInfo.FI_SCHOOL_NAME);
        }
        if (fields.contains(ModelTWechatInfo.FI_SOURCE_ID)) {
            sqlBuilder.itemCol(ModelTWechatInfo.FI_SOURCE_ID);
        }
        if (fields.contains(ModelTWechatInfo.FI_ATTENTION_REPLY)) {
            sqlBuilder.itemCol(ModelTWechatInfo.FI_ATTENTION_REPLY);
        }
        if (fields.contains(ModelTWechatInfo.FI_AUTO_REPLY)) {
            sqlBuilder.itemCol(ModelTWechatInfo.FI_AUTO_REPLY);
        }
        List<Map<String, Object>> param = CollectionHelper.<Map<String,Object>> newList();
        for (ModelTWechatInfo instance: instances) {
            Map<String, Object> paramMap = ModelTWechatInfo.MAP_OBJ_MAPPER.toCommonMap(instance);
            param.add(paramMap);
        }
        SimpleDbInterface dbInstance = data_store;
        String dbToUse = super.selectDb(assembler, sqlBuilder, param);
        if ((dbToUse!= null)&&dbMap.containsKey(dbToUse)) {
            dbInstance = dbMap.get(dbToUse);
        }
        return super.batchInsert(dbInstance, assembler, sqlBuilder, param);
    }

    public Integer insert(List<ModelTWechatInfo> instances, Set<String> fields) {
        return insert(instances, fields, null);
    }

    public Integer insert(List<ModelTWechatInfo> instances) {
        return insert(instances, null, null);
    }

    public Integer update(ModelTWechatInfo instance, Set<String> conditionField, DaoAssembler assembler) {
        SQLUpdate sqlBuilder = SQLBuilder.buildUpdateSql();
        Integer dId = instance.getId();
        if (conditionField.contains(ModelTWechatInfo.FI_ID)) {
            assert((dId!= null));
            sqlBuilder.itemWhere(ModelTWechatInfo.FI_ID, ColumnDataType.intData);
        } else {
            if (dId!= null) {
                sqlBuilder.itemCol(ModelTWechatInfo.FI_ID);
            }
        }
        String dWechat_name = instance.getWechatName();
        if (conditionField.contains(ModelTWechatInfo.FI_WECHAT_NAME)) {
            assert((dWechat_name!= null));
            sqlBuilder.itemWhere(ModelTWechatInfo.FI_WECHAT_NAME, ColumnDataType.stringData);
        } else {
            if (dWechat_name!= null) {
                sqlBuilder.itemCol(ModelTWechatInfo.FI_WECHAT_NAME);
            }
        }
        String dApp_id = instance.getAppId();
        if (conditionField.contains(ModelTWechatInfo.FI_APP_ID)) {
            assert((dApp_id!= null));
            sqlBuilder.itemWhere(ModelTWechatInfo.FI_APP_ID, ColumnDataType.stringData);
        } else {
            if (dApp_id!= null) {
                sqlBuilder.itemCol(ModelTWechatInfo.FI_APP_ID);
            }
        }
        String dApp_secret = instance.getAppSecret();
        if (conditionField.contains(ModelTWechatInfo.FI_APP_SECRET)) {
            assert((dApp_secret!= null));
            sqlBuilder.itemWhere(ModelTWechatInfo.FI_APP_SECRET, ColumnDataType.stringData);
        } else {
            if (dApp_secret!= null) {
                sqlBuilder.itemCol(ModelTWechatInfo.FI_APP_SECRET);
            }
        }
        String dCreat_name = instance.getCreatName();
        if (conditionField.contains(ModelTWechatInfo.FI_CREAT_NAME)) {
            assert((dCreat_name!= null));
            sqlBuilder.itemWhere(ModelTWechatInfo.FI_CREAT_NAME, ColumnDataType.stringData);
        } else {
            if (dCreat_name!= null) {
                sqlBuilder.itemCol(ModelTWechatInfo.FI_CREAT_NAME);
            }
        }
        Date dCreat_time = instance.getCreatTime();
        if (conditionField.contains(ModelTWechatInfo.FI_CREAT_TIME)) {
            assert((dCreat_time!= null));
            sqlBuilder.itemWhere(ModelTWechatInfo.FI_CREAT_TIME, ColumnDataType.timeStampData);
        } else {
            if (dCreat_time!= null) {
                sqlBuilder.itemCol(ModelTWechatInfo.FI_CREAT_TIME);
            }
        }
        Date dUpdate_time = instance.getUpdateTime();
        if (conditionField.contains(ModelTWechatInfo.FI_UPDATE_TIME)) {
            assert((dUpdate_time!= null));
            sqlBuilder.itemWhere(ModelTWechatInfo.FI_UPDATE_TIME, ColumnDataType.timeStampData);
        } else {
            if (dUpdate_time!= null) {
                sqlBuilder.itemCol(ModelTWechatInfo.FI_UPDATE_TIME);
            }
        }
        String dSchool_name = instance.getSchoolName();
        if (conditionField.contains(ModelTWechatInfo.FI_SCHOOL_NAME)) {
            assert((dSchool_name!= null));
            sqlBuilder.itemWhere(ModelTWechatInfo.FI_SCHOOL_NAME, ColumnDataType.stringData);
        } else {
            if (dSchool_name!= null) {
                sqlBuilder.itemCol(ModelTWechatInfo.FI_SCHOOL_NAME);
            }
        }
        String dSource_id = instance.getSourceId();
        if (conditionField.contains(ModelTWechatInfo.FI_SOURCE_ID)) {
            assert((dSource_id!= null));
            sqlBuilder.itemWhere(ModelTWechatInfo.FI_SOURCE_ID, ColumnDataType.stringData);
        } else {
            if (dSource_id!= null) {
                sqlBuilder.itemCol(ModelTWechatInfo.FI_SOURCE_ID);
            }
        }
        String dAttention_reply = instance.getAttentionReply();
        if (conditionField.contains(ModelTWechatInfo.FI_ATTENTION_REPLY)) {
            assert((dAttention_reply!= null));
            sqlBuilder.itemWhere(ModelTWechatInfo.FI_ATTENTION_REPLY, ColumnDataType.stringData);
        } else {
            if (dAttention_reply!= null) {
                sqlBuilder.itemCol(ModelTWechatInfo.FI_ATTENTION_REPLY);
            }
        }
        String dAuto_reply = instance.getAutoReply();
        if (conditionField.contains(ModelTWechatInfo.FI_AUTO_REPLY)) {
            assert((dAuto_reply!= null));
            sqlBuilder.itemWhere(ModelTWechatInfo.FI_AUTO_REPLY, ColumnDataType.stringData);
        } else {
            if (dAuto_reply!= null) {
                sqlBuilder.itemCol(ModelTWechatInfo.FI_AUTO_REPLY);
            }
        }
        Map<String, Object> param = ModelTWechatInfo.MAP_OBJ_MAPPER.toCommonMap(instance);
        SimpleDbInterface dbInstance = data_store;
        String dbToUse = super.selectDb(assembler, sqlBuilder, param);
        if ((dbToUse!= null)&&dbMap.containsKey(dbToUse)) {
            dbInstance = dbMap.get(dbToUse);
        }
        return super.update(dbInstance, assembler, sqlBuilder, param);
    }

    public Integer update(ModelTWechatInfo instance, Set<String> conditionField) {
        return update(instance, conditionField, null);
    }

    public Integer updateById(ModelTWechatInfo instance, DaoAssembler assembler) {
        SQLUpdate sqlBuilder = SQLBuilder.buildUpdateSql();
        assert((instance.getId()!= null));
        Integer dId = instance.getId();
        if (dId!= null) {
            sqlBuilder.itemWhere(ModelTWechatInfo.FI_ID, ColumnDataType.intData);
        }
        String dWechat_name = instance.getWechatName();
        if (dWechat_name!= null) {
            sqlBuilder.itemCol(ModelTWechatInfo.FI_WECHAT_NAME);
        }
        String dApp_id = instance.getAppId();
        if (dApp_id!= null) {
            sqlBuilder.itemCol(ModelTWechatInfo.FI_APP_ID);
        }
        String dApp_secret = instance.getAppSecret();
        if (dApp_secret!= null) {
            sqlBuilder.itemCol(ModelTWechatInfo.FI_APP_SECRET);
        }
        String dCreat_name = instance.getCreatName();
        if (dCreat_name!= null) {
            sqlBuilder.itemCol(ModelTWechatInfo.FI_CREAT_NAME);
        }
        Date dCreat_time = instance.getCreatTime();
        if (dCreat_time!= null) {
            sqlBuilder.itemCol(ModelTWechatInfo.FI_CREAT_TIME);
        }
        Date dUpdate_time = instance.getUpdateTime();
        if (dUpdate_time!= null) {
            sqlBuilder.itemCol(ModelTWechatInfo.FI_UPDATE_TIME);
        }
        String dSchool_name = instance.getSchoolName();
        if (dSchool_name!= null) {
            sqlBuilder.itemCol(ModelTWechatInfo.FI_SCHOOL_NAME);
        }
        String dSource_id = instance.getSourceId();
        if (dSource_id!= null) {
            sqlBuilder.itemCol(ModelTWechatInfo.FI_SOURCE_ID);
        }
        String dAttention_reply = instance.getAttentionReply();
        if (dAttention_reply!= null) {
            sqlBuilder.itemCol(ModelTWechatInfo.FI_ATTENTION_REPLY);
        }
        String dAuto_reply = instance.getAutoReply();
        if (dAuto_reply!= null) {
            sqlBuilder.itemCol(ModelTWechatInfo.FI_AUTO_REPLY);
        }
        Map<String, Object> param = ModelTWechatInfo.MAP_OBJ_MAPPER.toCommonMap(instance);
        SimpleDbInterface dbInstance = data_store;
        String dbToUse = super.selectDb(assembler, sqlBuilder, param);
        if ((dbToUse!= null)&&dbMap.containsKey(dbToUse)) {
            dbInstance = dbMap.get(dbToUse);
        }
        return super.update(dbInstance, assembler, sqlBuilder, param);
    }

    public Integer updateById(ModelTWechatInfo instance) {
        return updateById(instance, null);
    }

    public Integer updateByIds(ModelTWechatInfo instance, Set<Integer> ids, DaoAssembler assembler) {
        SQLUpdate sqlBuilder = SQLBuilder.buildUpdateSql();
        assert(((ids!= null)&&(ids.size()> 0)));
        sqlBuilder.itemWhere(LogicalOpType.in, ModelTWechatInfo.FI_ID, "ids", ColumnDataType.intData);
        instance.setId(null);
        String dWechat_name = instance.getWechatName();
        if (dWechat_name!= null) {
            sqlBuilder.itemCol(ModelTWechatInfo.FI_WECHAT_NAME);
        }
        String dApp_id = instance.getAppId();
        if (dApp_id!= null) {
            sqlBuilder.itemCol(ModelTWechatInfo.FI_APP_ID);
        }
        String dApp_secret = instance.getAppSecret();
        if (dApp_secret!= null) {
            sqlBuilder.itemCol(ModelTWechatInfo.FI_APP_SECRET);
        }
        String dCreat_name = instance.getCreatName();
        if (dCreat_name!= null) {
            sqlBuilder.itemCol(ModelTWechatInfo.FI_CREAT_NAME);
        }
        Date dCreat_time = instance.getCreatTime();
        if (dCreat_time!= null) {
            sqlBuilder.itemCol(ModelTWechatInfo.FI_CREAT_TIME);
        }
        Date dUpdate_time = instance.getUpdateTime();
        if (dUpdate_time!= null) {
            sqlBuilder.itemCol(ModelTWechatInfo.FI_UPDATE_TIME);
        }
        String dSchool_name = instance.getSchoolName();
        if (dSchool_name!= null) {
            sqlBuilder.itemCol(ModelTWechatInfo.FI_SCHOOL_NAME);
        }
        String dSource_id = instance.getSourceId();
        if (dSource_id!= null) {
            sqlBuilder.itemCol(ModelTWechatInfo.FI_SOURCE_ID);
        }
        String dAttention_reply = instance.getAttentionReply();
        if (dAttention_reply!= null) {
            sqlBuilder.itemCol(ModelTWechatInfo.FI_ATTENTION_REPLY);
        }
        String dAuto_reply = instance.getAutoReply();
        if (dAuto_reply!= null) {
            sqlBuilder.itemCol(ModelTWechatInfo.FI_AUTO_REPLY);
        }
        Map<String, Object> param = ModelTWechatInfo.MAP_OBJ_MAPPER.toCommonMap(instance);
        param.put("ids", ids);
        SimpleDbInterface dbInstance = data_store;
        String dbToUse = super.selectDb(assembler, sqlBuilder, param);
        if ((dbToUse!= null)&&dbMap.containsKey(dbToUse)) {
            dbInstance = dbMap.get(dbToUse);
        }
        return super.update(dbInstance, assembler, sqlBuilder, param);
    }

    public Integer updateByIds(ModelTWechatInfo instance, Set<Integer> ids) {
        return updateByIds(instance, ids, null);
    }

    public Integer delete(ModelTWechatInfo instance, Set<String> conditionField, DaoAssembler assembler) {
        SQLDelete sqlBuilder = SQLBuilder.buildDeleteSql();
        Integer dId = instance.getId();
        if (conditionField.contains(ModelTWechatInfo.FI_ID)) {
            assert((dId!= null));
            sqlBuilder.itemWhere(ModelTWechatInfo.FI_ID, ColumnDataType.intData);
        }
        String dWechat_name = instance.getWechatName();
        if (conditionField.contains(ModelTWechatInfo.FI_WECHAT_NAME)) {
            assert((dWechat_name!= null));
            sqlBuilder.itemWhere(ModelTWechatInfo.FI_WECHAT_NAME, ColumnDataType.stringData);
        }
        String dApp_id = instance.getAppId();
        if (conditionField.contains(ModelTWechatInfo.FI_APP_ID)) {
            assert((dApp_id!= null));
            sqlBuilder.itemWhere(ModelTWechatInfo.FI_APP_ID, ColumnDataType.stringData);
        }
        String dApp_secret = instance.getAppSecret();
        if (conditionField.contains(ModelTWechatInfo.FI_APP_SECRET)) {
            assert((dApp_secret!= null));
            sqlBuilder.itemWhere(ModelTWechatInfo.FI_APP_SECRET, ColumnDataType.stringData);
        }
        String dCreat_name = instance.getCreatName();
        if (conditionField.contains(ModelTWechatInfo.FI_CREAT_NAME)) {
            assert((dCreat_name!= null));
            sqlBuilder.itemWhere(ModelTWechatInfo.FI_CREAT_NAME, ColumnDataType.stringData);
        }
        Date dCreat_time = instance.getCreatTime();
        if (conditionField.contains(ModelTWechatInfo.FI_CREAT_TIME)) {
            assert((dCreat_time!= null));
            sqlBuilder.itemWhere(ModelTWechatInfo.FI_CREAT_TIME, ColumnDataType.timeStampData);
        }
        Date dUpdate_time = instance.getUpdateTime();
        if (conditionField.contains(ModelTWechatInfo.FI_UPDATE_TIME)) {
            assert((dUpdate_time!= null));
            sqlBuilder.itemWhere(ModelTWechatInfo.FI_UPDATE_TIME, ColumnDataType.timeStampData);
        }
        String dSchool_name = instance.getSchoolName();
        if (conditionField.contains(ModelTWechatInfo.FI_SCHOOL_NAME)) {
            assert((dSchool_name!= null));
            sqlBuilder.itemWhere(ModelTWechatInfo.FI_SCHOOL_NAME, ColumnDataType.stringData);
        }
        String dSource_id = instance.getSourceId();
        if (conditionField.contains(ModelTWechatInfo.FI_SOURCE_ID)) {
            assert((dSource_id!= null));
            sqlBuilder.itemWhere(ModelTWechatInfo.FI_SOURCE_ID, ColumnDataType.stringData);
        }
        String dAttention_reply = instance.getAttentionReply();
        if (conditionField.contains(ModelTWechatInfo.FI_ATTENTION_REPLY)) {
            assert((dAttention_reply!= null));
            sqlBuilder.itemWhere(ModelTWechatInfo.FI_ATTENTION_REPLY, ColumnDataType.stringData);
        }
        String dAuto_reply = instance.getAutoReply();
        if (conditionField.contains(ModelTWechatInfo.FI_AUTO_REPLY)) {
            assert((dAuto_reply!= null));
            sqlBuilder.itemWhere(ModelTWechatInfo.FI_AUTO_REPLY, ColumnDataType.stringData);
        }
        Map<String, Object> param = ModelTWechatInfo.MAP_OBJ_MAPPER.toCommonMap(instance);
        SimpleDbInterface dbInstance = data_store;
        String dbToUse = super.selectDb(assembler, sqlBuilder, param);
        if ((dbToUse!= null)&&dbMap.containsKey(dbToUse)) {
            dbInstance = dbMap.get(dbToUse);
        }
        return super.update(dbInstance, assembler, sqlBuilder, param);
    }

    public Integer delete(ModelTWechatInfo instance, Set<String> conditionField) {
        return delete(instance, conditionField, null);
    }

    public Integer deleteById(Integer id, DaoAssembler assembler) {
        SQLDelete sqlBuilder = SQLBuilder.buildDeleteSql();
        assert((id!= null));
        Map<String, Object> param = Collections.singletonMap("id", id);
        SimpleDbInterface dbInstance = data_store;
        String dbToUse = super.selectDb(assembler, sqlBuilder, param);
        if ((dbToUse!= null)&&dbMap.containsKey(dbToUse)) {
            dbInstance = dbMap.get(dbToUse);
        }
        return super.update(dbInstance, assembler, sqlBuilder, param);
    }

    public Integer deleteById(Integer id) {
        return deleteById(id, null);
    }

    public Integer deleteByIds(Set<Integer> ids, DaoAssembler assembler) {
        SQLDelete sqlBuilder = SQLBuilder.buildDeleteSql();
        assert(((ids!= null)&&(ids.size()> 0)));
        Map<String, Object> param = Collections.singletonMap("ids", ids);
        SimpleDbInterface dbInstance = data_store;
        String dbToUse = super.selectDb(assembler, sqlBuilder, param);
        if ((dbToUse!= null)&&dbMap.containsKey(dbToUse)) {
            dbInstance = dbMap.get(dbToUse);
        }
        return super.update(dbInstance, assembler, sqlBuilder, param);
    }

    public Integer deleteByIds(Set<Integer> ids) {
        return deleteByIds(ids, null);
    }

    @Transactional
    public ModelTWechatInfo updateOrInsert(ModelTWechatInfo instance, Set<String> conditionField, AbstractMultipleDaoAssembler assembler) {
        if (assembler == null) {
            assembler = new BaseMultipleDaoAssembler();
        }
        ModelTWechatInfo checkInstance = new ModelTWechatInfo();
        if (conditionField.contains(ModelTWechatInfo.FI_ID)) {
            checkInstance.setId(instance.getId());
        }
        if (conditionField.contains(ModelTWechatInfo.FI_WECHAT_NAME)) {
            checkInstance.setWechatName(instance.getWechatName());
        }
        if (conditionField.contains(ModelTWechatInfo.FI_APP_ID)) {
            checkInstance.setAppId(instance.getAppId());
        }
        if (conditionField.contains(ModelTWechatInfo.FI_APP_SECRET)) {
            checkInstance.setAppSecret(instance.getAppSecret());
        }
        if (conditionField.contains(ModelTWechatInfo.FI_CREAT_NAME)) {
            checkInstance.setCreatName(instance.getCreatName());
        }
        if (conditionField.contains(ModelTWechatInfo.FI_CREAT_TIME)) {
            checkInstance.setCreatTime(instance.getCreatTime());
        }
        if (conditionField.contains(ModelTWechatInfo.FI_UPDATE_TIME)) {
            checkInstance.setUpdateTime(instance.getUpdateTime());
        }
        if (conditionField.contains(ModelTWechatInfo.FI_SCHOOL_NAME)) {
            checkInstance.setSchoolName(instance.getSchoolName());
        }
        if (conditionField.contains(ModelTWechatInfo.FI_SOURCE_ID)) {
            checkInstance.setSourceId(instance.getSourceId());
        }
        if (conditionField.contains(ModelTWechatInfo.FI_ATTENTION_REPLY)) {
            checkInstance.setAttentionReply(instance.getAttentionReply());
        }
        if (conditionField.contains(ModelTWechatInfo.FI_AUTO_REPLY)) {
            checkInstance.setAutoReply(instance.getAutoReply());
        }
        ModelTWechatInfo selected = getOneByCond(Collections.singleton(ModelTWechatInfo.FI_ID), assembler, checkInstance);
        assembler.increaseIndex();
        if (selected == null) {
            return insert(instance, assembler);
        } else {
            instance.setId(selected.getId());
            update(instance, Collections.singleton(ModelTWechatInfo.FI_ID), assembler);
            return instance;
        }
    }

    public ModelTWechatInfo updateOrInsert(ModelTWechatInfo instance, Set<String> conditionField) {
        return updateOrInsert(instance, conditionField, null);
    }

    @Transactional
    public ModelTWechatInfo insertIfNoExist(ModelTWechatInfo instance, Set<String> conditionField, AbstractMultipleDaoAssembler assembler) {
        if (assembler == null) {
            assembler = new BaseMultipleDaoAssembler();
        }
        ModelTWechatInfo checkInstance = new ModelTWechatInfo();
        if (conditionField.contains(ModelTWechatInfo.FI_ID)) {
            checkInstance.setId(instance.getId());
        }
        if (conditionField.contains(ModelTWechatInfo.FI_WECHAT_NAME)) {
            checkInstance.setWechatName(instance.getWechatName());
        }
        if (conditionField.contains(ModelTWechatInfo.FI_APP_ID)) {
            checkInstance.setAppId(instance.getAppId());
        }
        if (conditionField.contains(ModelTWechatInfo.FI_APP_SECRET)) {
            checkInstance.setAppSecret(instance.getAppSecret());
        }
        if (conditionField.contains(ModelTWechatInfo.FI_CREAT_NAME)) {
            checkInstance.setCreatName(instance.getCreatName());
        }
        if (conditionField.contains(ModelTWechatInfo.FI_CREAT_TIME)) {
            checkInstance.setCreatTime(instance.getCreatTime());
        }
        if (conditionField.contains(ModelTWechatInfo.FI_UPDATE_TIME)) {
            checkInstance.setUpdateTime(instance.getUpdateTime());
        }
        if (conditionField.contains(ModelTWechatInfo.FI_SCHOOL_NAME)) {
            checkInstance.setSchoolName(instance.getSchoolName());
        }
        if (conditionField.contains(ModelTWechatInfo.FI_SOURCE_ID)) {
            checkInstance.setSourceId(instance.getSourceId());
        }
        if (conditionField.contains(ModelTWechatInfo.FI_ATTENTION_REPLY)) {
            checkInstance.setAttentionReply(instance.getAttentionReply());
        }
        if (conditionField.contains(ModelTWechatInfo.FI_AUTO_REPLY)) {
            checkInstance.setAutoReply(instance.getAutoReply());
        }
        ModelTWechatInfo selected = getOneByCond(Collections.singleton(ModelTWechatInfo.FI_ID), assembler, checkInstance);
        assembler.increaseIndex();
        if (selected == null) {
            return insert(instance, assembler);
        } else {
            instance.setId(selected.getId());
            return instance;
        }
    }

    public ModelTWechatInfo insertIfNoExist(ModelTWechatInfo instance, Set<String> conditionField) {
        return insertIfNoExist(instance, conditionField, null);
    }

    public<TT> Map<TT, ModelTWechatInfo> buildMap(List<ModelTWechatInfo> list, String field) {
        Map<TT, ModelTWechatInfo> ret = CollectionHelper.newMap();
        if (list == null) {
            return ret;
        }
        for (ModelTWechatInfo item: list) {
            ret.put(ModelTWechatInfo.MAP_OBJ_MAPPER.<TT> getField(field, item), item);
        }
        return ret;
    }

    public<TT> Map<TT, List<ModelTWechatInfo>> buildListMap(List<ModelTWechatInfo> list, String field) {
        Map<TT, List<ModelTWechatInfo>> ret = CollectionHelper.newMap();
        if (list == null) {
            return ret;
        }
        for (ModelTWechatInfo item: list) {
            List<ModelTWechatInfo> itemList = ret.get(ModelTWechatInfo.MAP_OBJ_MAPPER.<TT> getField(field, item));
            if (itemList == null) {
                itemList = CollectionHelper.newList();
            }
            itemList.add(item);
            ret.put(ModelTWechatInfo.MAP_OBJ_MAPPER.<TT> getField(field, item), itemList);
        }
        return ret;
    }

    public<TT> List<TT> extractItemAsList(List<ModelTWechatInfo> list, String field) {
        List<TT> ret = CollectionHelper.newList();
        if ((list == null)||(list.size() == 0)) {
            return ret;
        }
        if (ModelTWechatInfo.FIELD_CLASS.containsKey(field)) {
            for (ModelTWechatInfo item: list) {
                ret.add(ModelTWechatInfo.MAP_OBJ_MAPPER.<TT> getField(field, item));
            }
        }
        return ret;
    }
}
