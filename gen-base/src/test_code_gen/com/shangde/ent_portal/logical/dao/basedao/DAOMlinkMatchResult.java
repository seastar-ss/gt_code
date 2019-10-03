package com.shangde.ent_portal.logical.dao.basedao;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map;
import java.util.Set;
import com.shangde.ent_portal.logical.dto.basepo.ModelMlinkMatchResult.ResultSetMapperModelMlinkMatchResult;
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
import com.shawn.ss.lib.tools.sql_code_gen.api.SQL;
import com.shawn.ss.lib.tools.sql_code_gen.api.SQLDelete;
import com.shawn.ss.lib.tools.sql_code_gen.api.SQLInsert;
import com.shawn.ss.lib.tools.sql_code_gen.api.SQLSelect;
import com.shawn.ss.lib.tools.sql_code_gen.api.SQLUpdate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.shangde.ent_portal.logical.dto.basepo.ModelMlinkMatchResult;

@Repository("DAOMlinkMatchResult")
@SuppressWarnings("unchecked")
public class DAOMlinkMatchResult
    extends AbstractDao<com.shangde.ent_portal.logical.dto.basepo.ModelMlinkMatchResult, Integer>
    implements DaoInterface<com.shangde.ent_portal.logical.dto.basepo.ModelMlinkMatchResult, Integer> , InitializingBean
{
    public final static Logger logger = LoggerFactory.getLogger(DAOMlinkMatchResult.class);
    @Autowired(required = true)
    @Qualifier("ent_portal_slave")
    protected SimpleDbInterface data_store;
    protected final static Map<String, SimpleDbInterface> dbMap = CollectionHelper.newMap();
    public final static String dbOfEntPortalSlave = "ent_portal_slave";
    @Autowired(required = true)
    @Qualifier("ent_portal_slave")
    protected SimpleDbInterface data_storeEntPortalSlave;

    public DAOMlinkMatchResult() {
        super(com.shangde.ent_portal.logical.dto.basepo.ModelMlinkMatchResult.class);
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

    protected List<ModelMlinkMatchResult> getResults(DaoAssembler assembler, SQL<SQLSelect> sqlBuilder, Map<String, Object> param) {
        int status = 0;
        if (assembler!= null) {
            status = assembler.assembleSql(sqlBuilder, param, ModelMlinkMatchResult.class);
        }
        SimpleDbInterface dbInstance = data_store;
        String dbToUse = super.selectDb(assembler, sqlBuilder, param);
        if ((dbToUse!= null)&&dbMap.containsKey(dbToUse)) {
            dbInstance = dbMap.get(dbToUse);
        }
        if (status == 0) {
            ResultSetMapperModelMlinkMatchResult<ModelMlinkMatchResult> rsMapper = ModelMlinkMatchResult.RESULT_SET_OBJ_MAPPER;
            if (assembler!= null) {
                ResultSetMapperModelMlinkMatchResult<ModelMlinkMatchResult> rsMapperTmp = ((ResultSetMapperModelMlinkMatchResult<ModelMlinkMatchResult> ) assembler.<ModelMlinkMatchResult> assembleResultSetMapper(param, ModelMlinkMatchResult.class));
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

    protected ModelMlinkMatchResult getResult(DaoAssembler assembler, SQL<SQLSelect> sqlBuilder, Map<String, Object> param) {
        int status = 0;
        if (assembler!= null) {
            status = assembler.assembleSql(sqlBuilder, param, ModelMlinkMatchResult.class);
        }
        SimpleDbInterface dbInstance = data_store;
        String dbToUse = super.selectDb(assembler, sqlBuilder, param);
        if ((dbToUse!= null)&&dbMap.containsKey(dbToUse)) {
            dbInstance = dbMap.get(dbToUse);
        }
        if (status == 0) {
            ResultSetMapperModelMlinkMatchResult<ModelMlinkMatchResult> rsMapper = ModelMlinkMatchResult.RESULT_SET_OBJ_MAPPER;
            if (assembler!= null) {
                ResultSetMapperModelMlinkMatchResult<ModelMlinkMatchResult> rsMapperTmp = ((ResultSetMapperModelMlinkMatchResult<ModelMlinkMatchResult> ) assembler.<ModelMlinkMatchResult> assembleResultSetMapper(param, ModelMlinkMatchResult.class));
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
        if (ModelMlinkMatchResult.FIELD_CLASS.containsKey(inField)) {
            Object fieldClassObj = ModelMlinkMatchResult.FIELD_CLASS.get(inField);
            super.buildRawInCluase(sqlBuilder, param, inField, fieldClassObj, indexes);
        } else {
            logger.error("field parameter error");
            throw new IllegalArgumentException(((("there is mistake with infield parameter, column "+ inField)+" not found in table ")+ com.shangde.ent_portal.logical.dto.basepo.ModelMlinkMatchResult.DTO_TABLE_NAME));
        }
    }

    protected void buildConditionCluase(SQLSelect<SQLSelect> sqlBuilder, ModelMlinkMatchResult instance, Map<String, Object> param) {
        Integer dId = instance.getId();
        if (dId!= null) {
            sqlBuilder.where(ModelMlinkMatchResult.FI_ID, ColumnDataType.intData);
            param.put(ModelMlinkMatchResult.FI_ID, dId);
        }
        Integer dUser_id = instance.getUserId();
        if (dUser_id!= null) {
            sqlBuilder.where(ModelMlinkMatchResult.FI_USER_ID, ColumnDataType.intData);
            param.put(ModelMlinkMatchResult.FI_USER_ID, dUser_id);
        }
        Integer dMlink_id = instance.getMlinkId();
        if (dMlink_id!= null) {
            sqlBuilder.where(ModelMlinkMatchResult.FI_MLINK_ID, ColumnDataType.intData);
            param.put(ModelMlinkMatchResult.FI_MLINK_ID, dMlink_id);
        }
        String dMobile = instance.getMobile();
        if (dMobile!= null) {
            sqlBuilder.where(ModelMlinkMatchResult.FI_MOBILE, ColumnDataType.stringData);
            param.put(ModelMlinkMatchResult.FI_MOBILE, dMobile);
        }
        Integer dIs_related = instance.getIsRelated();
        if (dIs_related!= null) {
            sqlBuilder.where(ModelMlinkMatchResult.FI_IS_RELATED, ColumnDataType.intData);
            param.put(ModelMlinkMatchResult.FI_IS_RELATED, dIs_related);
        }
        Integer dStu_id = instance.getStuId();
        if (dStu_id!= null) {
            sqlBuilder.where(ModelMlinkMatchResult.FI_STU_ID, ColumnDataType.intData);
            param.put(ModelMlinkMatchResult.FI_STU_ID, dStu_id);
        }
        String dSystem = instance.getSystem();
        if (dSystem!= null) {
            sqlBuilder.where(ModelMlinkMatchResult.FI_SYSTEM, ColumnDataType.stringData);
            param.put(ModelMlinkMatchResult.FI_SYSTEM, dSystem);
        }
        String dBind_state = instance.getBindState();
        if (dBind_state!= null) {
            sqlBuilder.where(ModelMlinkMatchResult.FI_BIND_STATE, ColumnDataType.stringData);
            param.put(ModelMlinkMatchResult.FI_BIND_STATE, dBind_state);
        }
        Integer dCall_result = instance.getCallResult();
        if (dCall_result!= null) {
            sqlBuilder.where(ModelMlinkMatchResult.FI_CALL_RESULT, ColumnDataType.intData);
            param.put(ModelMlinkMatchResult.FI_CALL_RESULT, dCall_result);
        }
        String dReturn_message = instance.getReturnMessage();
        if (dReturn_message!= null) {
            sqlBuilder.where(ModelMlinkMatchResult.FI_RETURN_MESSAGE, ColumnDataType.stringData);
            param.put(ModelMlinkMatchResult.FI_RETURN_MESSAGE, dReturn_message);
        }
        Integer dIs_bind = instance.getIsBind();
        if (dIs_bind!= null) {
            sqlBuilder.where(ModelMlinkMatchResult.FI_IS_BIND, ColumnDataType.intData);
            param.put(ModelMlinkMatchResult.FI_IS_BIND, dIs_bind);
        }
        Date dCreate_time = instance.getCreateTime();
        if (dCreate_time!= null) {
            sqlBuilder.where(ModelMlinkMatchResult.FI_CREATE_TIME, ColumnDataType.timeStampData);
            param.put(ModelMlinkMatchResult.FI_CREATE_TIME, dCreate_time);
        }
        Integer dDelete_flag = instance.getDeleteFlag();
        if (dDelete_flag!= null) {
            sqlBuilder.where(ModelMlinkMatchResult.FI_DELETE_FLAG, ColumnDataType.intData);
            param.put(ModelMlinkMatchResult.FI_DELETE_FLAG, dDelete_flag);
        }
        Date dUpdate_time = instance.getUpdateTime();
        if (dUpdate_time!= null) {
            sqlBuilder.where(ModelMlinkMatchResult.FI_UPDATE_TIME, ColumnDataType.timeStampData);
            param.put(ModelMlinkMatchResult.FI_UPDATE_TIME, dUpdate_time);
        }
    }

    protected void buildSelectFieldCluase(SQLSelect<SQLSelect> sqlBuilder, Set<String> selectFields) {
        if (selectFields.contains(ModelMlinkMatchResult.FI_ID)) {
            sqlBuilder.items(ModelMlinkMatchResult.FI_ID);
        }
        if (selectFields.contains(ModelMlinkMatchResult.FI_USER_ID)) {
            sqlBuilder.items(ModelMlinkMatchResult.FI_USER_ID);
        }
        if (selectFields.contains(ModelMlinkMatchResult.FI_MLINK_ID)) {
            sqlBuilder.items(ModelMlinkMatchResult.FI_MLINK_ID);
        }
        if (selectFields.contains(ModelMlinkMatchResult.FI_MOBILE)) {
            sqlBuilder.items(ModelMlinkMatchResult.FI_MOBILE);
        }
        if (selectFields.contains(ModelMlinkMatchResult.FI_IS_RELATED)) {
            sqlBuilder.items(ModelMlinkMatchResult.FI_IS_RELATED);
        }
        if (selectFields.contains(ModelMlinkMatchResult.FI_STU_ID)) {
            sqlBuilder.items(ModelMlinkMatchResult.FI_STU_ID);
        }
        if (selectFields.contains(ModelMlinkMatchResult.FI_SYSTEM)) {
            sqlBuilder.items(ModelMlinkMatchResult.FI_SYSTEM);
        }
        if (selectFields.contains(ModelMlinkMatchResult.FI_BIND_STATE)) {
            sqlBuilder.items(ModelMlinkMatchResult.FI_BIND_STATE);
        }
        if (selectFields.contains(ModelMlinkMatchResult.FI_CALL_RESULT)) {
            sqlBuilder.items(ModelMlinkMatchResult.FI_CALL_RESULT);
        }
        if (selectFields.contains(ModelMlinkMatchResult.FI_RETURN_MESSAGE)) {
            sqlBuilder.items(ModelMlinkMatchResult.FI_RETURN_MESSAGE);
        }
        if (selectFields.contains(ModelMlinkMatchResult.FI_IS_BIND)) {
            sqlBuilder.items(ModelMlinkMatchResult.FI_IS_BIND);
        }
        if (selectFields.contains(ModelMlinkMatchResult.FI_CREATE_TIME)) {
            sqlBuilder.items(ModelMlinkMatchResult.FI_CREATE_TIME);
        }
        if (selectFields.contains(ModelMlinkMatchResult.FI_DELETE_FLAG)) {
            sqlBuilder.items(ModelMlinkMatchResult.FI_DELETE_FLAG);
        }
        if (selectFields.contains(ModelMlinkMatchResult.FI_UPDATE_TIME)) {
            sqlBuilder.items(ModelMlinkMatchResult.FI_UPDATE_TIME);
        }
    }

    public List<ModelMlinkMatchResult> get(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count) {
        if (selectFields == null) {
            selectFields = ModelMlinkMatchResult.FIELD_CLASS.keySet();
        }
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelMlinkMatchResult.DTO_TABLE_NAME);
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
        sqlBuilder.setLimit();
        return getResults(assembler, sqlBuilder, param);
    }

    public List<ModelMlinkMatchResult> get(Set<String> selectFields, Integer start, Integer count) {
        return get(selectFields, null, start, count);
    }

    public List<ModelMlinkMatchResult> get(Integer start, Integer count) {
        return get(null, start, count);
    }

    public List<ModelMlinkMatchResult> get() {
        return get(null, null);
    }

    public List<ModelMlinkMatchResult> getById(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, List<Integer> id) {
        if (selectFields == null) {
            selectFields = ModelMlinkMatchResult.FIELD_CLASS.keySet();
        }
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelMlinkMatchResult.DTO_TABLE_NAME);
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
            sqlBuilder.where(LogicalRelationshipType.and, LogicalOpType.in, null, ModelMlinkMatchResult.FI_ID, ModelMlinkMatchResult.FI_ID, ColumnDataType.intData);
        }
        sqlBuilder.setLimit();
        return getResults(assembler, sqlBuilder, param);
    }

    public List<ModelMlinkMatchResult> getById(Set<String> selectFields, Integer start, Integer count, List<Integer> id) {
        return getById(selectFields, null, start, count, id);
    }

    public List<ModelMlinkMatchResult> getById(Integer start, Integer count, List<Integer> id) {
        return getById(null, start, count, id);
    }

    public List<ModelMlinkMatchResult> getById(List<Integer> id) {
        return getById(null, null, id);
    }

    public List<ModelMlinkMatchResult> getByIndex(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, String inField, List indexes) {
        if (selectFields == null) {
            selectFields = ModelMlinkMatchResult.FIELD_CLASS.keySet();
        }
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelMlinkMatchResult.DTO_TABLE_NAME);
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
        sqlBuilder.setLimit();
        return getResults(assembler, sqlBuilder, param);
    }

    public List<ModelMlinkMatchResult> getByIndex(Set<String> selectFields, Integer start, Integer count, String inField, List indexes) {
        return getByIndex(selectFields, null, start, count, inField, indexes);
    }

    public List<ModelMlinkMatchResult> getByIndex(Integer start, Integer count, String inField, List indexes) {
        return getByIndex(null, start, count, inField, indexes);
    }

    public List<ModelMlinkMatchResult> getByIndex(String inField, List indexes) {
        return getByIndex(null, null, inField, indexes);
    }

    public List<ModelMlinkMatchResult> getByCond(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, ModelMlinkMatchResult instance) {
        if (selectFields == null) {
            selectFields = ModelMlinkMatchResult.FIELD_CLASS.keySet();
        }
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelMlinkMatchResult.DTO_TABLE_NAME);
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
        sqlBuilder.setLimit();
        return getResults(assembler, sqlBuilder, param);
    }

    public List<ModelMlinkMatchResult> getByCond(Set<String> selectFields, Integer start, Integer count, ModelMlinkMatchResult instance) {
        return getByCond(selectFields, null, start, count, instance);
    }

    public List<ModelMlinkMatchResult> getByCond(Integer start, Integer count, ModelMlinkMatchResult instance) {
        return getByCond(null, start, count, instance);
    }

    public List<ModelMlinkMatchResult> getByCond(ModelMlinkMatchResult instance) {
        return getByCond(null, null, instance);
    }

    public List<ModelMlinkMatchResult> getByWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelMlinkMatchResult.FIELD_CLASS.keySet();
        }
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelMlinkMatchResult.DTO_TABLE_NAME);
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
        sqlBuilder.setLimit();
        return getResults(assembler, sqlBuilder, param);
    }

    public List<ModelMlinkMatchResult> getByWhere(Set<String> selectFields, Integer start, Integer count, Map<String, Object> extParam, Set<String> extCondition) {
        return getByWhere(selectFields, null, start, count, extParam, extCondition);
    }

    public List<ModelMlinkMatchResult> getByWhere(Integer start, Integer count, Map<String, Object> extParam, Set<String> extCondition) {
        return getByWhere(null, start, count, extParam, extCondition);
    }

    public List<ModelMlinkMatchResult> getByWhere(Map<String, Object> extParam, Set<String> extCondition) {
        return getByWhere(null, null, extParam, extCondition);
    }

    public List<ModelMlinkMatchResult> getByCondAndIndex(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, ModelMlinkMatchResult instance, String inField, List indexes) {
        if (selectFields == null) {
            selectFields = ModelMlinkMatchResult.FIELD_CLASS.keySet();
        }
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelMlinkMatchResult.DTO_TABLE_NAME);
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
        sqlBuilder.setLimit();
        return getResults(assembler, sqlBuilder, param);
    }

    public List<ModelMlinkMatchResult> getByCondAndIndex(Set<String> selectFields, Integer start, Integer count, ModelMlinkMatchResult instance, String inField, List indexes) {
        return getByCondAndIndex(selectFields, null, start, count, instance, inField, indexes);
    }

    public List<ModelMlinkMatchResult> getByCondAndIndex(Integer start, Integer count, ModelMlinkMatchResult instance, String inField, List indexes) {
        return getByCondAndIndex(null, start, count, instance, inField, indexes);
    }

    public List<ModelMlinkMatchResult> getByCondAndIndex(ModelMlinkMatchResult instance, String inField, List indexes) {
        return getByCondAndIndex(null, null, instance, inField, indexes);
    }

    public List<ModelMlinkMatchResult> getByIdAndWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, Integer id, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelMlinkMatchResult.FIELD_CLASS.keySet();
        }
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelMlinkMatchResult.DTO_TABLE_NAME);
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
            sqlBuilder.where(LogicalRelationshipType.and, LogicalOpType.in, null, ModelMlinkMatchResult.FI_ID, ModelMlinkMatchResult.FI_ID, ColumnDataType.intData);
        }
        sqlBuilder.setLimit();
        return getResults(assembler, sqlBuilder, param);
    }

    public List<ModelMlinkMatchResult> getByIdAndWhere(Set<String> selectFields, Integer start, Integer count, Integer id, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIdAndWhere(selectFields, null, start, count, id, extParam, extCondition);
    }

    public List<ModelMlinkMatchResult> getByIdAndWhere(Integer start, Integer count, Integer id, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIdAndWhere(null, start, count, id, extParam, extCondition);
    }

    public List<ModelMlinkMatchResult> getByIdAndWhere(Integer id, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIdAndWhere(null, null, id, extParam, extCondition);
    }

    public List<ModelMlinkMatchResult> getByIdAndCondAndWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, ModelMlinkMatchResult instance, List<Integer> id, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelMlinkMatchResult.FIELD_CLASS.keySet();
        }
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelMlinkMatchResult.DTO_TABLE_NAME);
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
            sqlBuilder.where(LogicalRelationshipType.and, LogicalOpType.in, null, ModelMlinkMatchResult.FI_ID, ModelMlinkMatchResult.FI_ID, ColumnDataType.intData);
        }
        sqlBuilder.setLimit();
        return getResults(assembler, sqlBuilder, param);
    }

    public List<ModelMlinkMatchResult> getByIdAndCondAndWhere(Set<String> selectFields, Integer start, Integer count, ModelMlinkMatchResult instance, List<Integer> id, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIdAndCondAndWhere(selectFields, null, start, count, instance, id, extParam, extCondition);
    }

    public List<ModelMlinkMatchResult> getByIdAndCondAndWhere(Integer start, Integer count, ModelMlinkMatchResult instance, List<Integer> id, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIdAndCondAndWhere(null, start, count, instance, id, extParam, extCondition);
    }

    public List<ModelMlinkMatchResult> getByIdAndCondAndWhere(ModelMlinkMatchResult instance, List<Integer> id, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIdAndCondAndWhere(null, null, instance, id, extParam, extCondition);
    }

    public List<ModelMlinkMatchResult> getByIndexAndWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelMlinkMatchResult.FIELD_CLASS.keySet();
        }
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelMlinkMatchResult.DTO_TABLE_NAME);
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
        sqlBuilder.setLimit();
        return getResults(assembler, sqlBuilder, param);
    }

    public List<ModelMlinkMatchResult> getByIndexAndWhere(Set<String> selectFields, Integer start, Integer count, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIndexAndWhere(selectFields, null, start, count, inField, indexes, extParam, extCondition);
    }

    public List<ModelMlinkMatchResult> getByIndexAndWhere(Integer start, Integer count, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIndexAndWhere(null, start, count, inField, indexes, extParam, extCondition);
    }

    public List<ModelMlinkMatchResult> getByIndexAndWhere(String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIndexAndWhere(null, null, inField, indexes, extParam, extCondition);
    }

    public List<ModelMlinkMatchResult> getByCondAndWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, ModelMlinkMatchResult instance, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelMlinkMatchResult.FIELD_CLASS.keySet();
        }
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelMlinkMatchResult.DTO_TABLE_NAME);
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
        sqlBuilder.setLimit();
        return getResults(assembler, sqlBuilder, param);
    }

    public List<ModelMlinkMatchResult> getByCondAndWhere(Set<String> selectFields, Integer start, Integer count, ModelMlinkMatchResult instance, Map<String, Object> extParam, Set<String> extCondition) {
        return getByCondAndWhere(selectFields, null, start, count, instance, extParam, extCondition);
    }

    public List<ModelMlinkMatchResult> getByCondAndWhere(Integer start, Integer count, ModelMlinkMatchResult instance, Map<String, Object> extParam, Set<String> extCondition) {
        return getByCondAndWhere(null, start, count, instance, extParam, extCondition);
    }

    public List<ModelMlinkMatchResult> getByCondAndWhere(ModelMlinkMatchResult instance, Map<String, Object> extParam, Set<String> extCondition) {
        return getByCondAndWhere(null, null, instance, extParam, extCondition);
    }

    public List<ModelMlinkMatchResult> getByCondAndIndexAndWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, ModelMlinkMatchResult instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelMlinkMatchResult.FIELD_CLASS.keySet();
        }
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelMlinkMatchResult.DTO_TABLE_NAME);
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
        sqlBuilder.setLimit();
        return getResults(assembler, sqlBuilder, param);
    }

    public List<ModelMlinkMatchResult> getByCondAndIndexAndWhere(Set<String> selectFields, Integer start, Integer count, ModelMlinkMatchResult instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        return getByCondAndIndexAndWhere(selectFields, null, start, count, instance, inField, indexes, extParam, extCondition);
    }

    public List<ModelMlinkMatchResult> getByCondAndIndexAndWhere(Integer start, Integer count, ModelMlinkMatchResult instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        return getByCondAndIndexAndWhere(null, start, count, instance, inField, indexes, extParam, extCondition);
    }

    public List<ModelMlinkMatchResult> getByCondAndIndexAndWhere(ModelMlinkMatchResult instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        return getByCondAndIndexAndWhere(null, null, instance, inField, indexes, extParam, extCondition);
    }

    public ModelMlinkMatchResult getOneById(Set<String> selectFields, DaoAssembler assembler, Integer id) {
        if (selectFields == null) {
            selectFields = ModelMlinkMatchResult.FIELD_CLASS.keySet();
        }
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelMlinkMatchResult.DTO_TABLE_NAME);
        Integer start = 0;
        Integer count = 1;
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        buildSelectFieldCluase(sqlBuilder, selectFields);
        if (id!= null) {
            sqlBuilder.where(ModelMlinkMatchResult.FI_ID, ColumnDataType.intData);
        }
        sqlBuilder.setLimit();
        return getResult(assembler, sqlBuilder, param);
    }

    public ModelMlinkMatchResult getOneById(Set<String> selectFields, Integer id) {
        return getOneById(selectFields, null, id);
    }

    public ModelMlinkMatchResult getOneById(Integer id) {
        return getOneById(null, id);
    }

    public ModelMlinkMatchResult getOneByCond(Set<String> selectFields, DaoAssembler assembler, ModelMlinkMatchResult instance) {
        if (selectFields == null) {
            selectFields = ModelMlinkMatchResult.FIELD_CLASS.keySet();
        }
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelMlinkMatchResult.DTO_TABLE_NAME);
        Integer start = 0;
        Integer count = 1;
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        buildConditionCluase(sqlBuilder, instance, param);
        buildSelectFieldCluase(sqlBuilder, selectFields);
        sqlBuilder.setLimit();
        return getResult(assembler, sqlBuilder, param);
    }

    public ModelMlinkMatchResult getOneByCond(Set<String> selectFields, ModelMlinkMatchResult instance) {
        return getOneByCond(selectFields, null, instance);
    }

    public ModelMlinkMatchResult getOneByCond(ModelMlinkMatchResult instance) {
        return getOneByCond(null, instance);
    }

    public ModelMlinkMatchResult getOneByWhere(Set<String> selectFields, DaoAssembler assembler, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelMlinkMatchResult.FIELD_CLASS.keySet();
        }
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelMlinkMatchResult.DTO_TABLE_NAME);
        Integer start = 0;
        Integer count = 1;
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        super.buildRawWhere(sqlBuilder, param, extParam, extCondition);
        buildSelectFieldCluase(sqlBuilder, selectFields);
        sqlBuilder.setLimit();
        return getResult(assembler, sqlBuilder, param);
    }

    public ModelMlinkMatchResult getOneByWhere(Set<String> selectFields, Map<String, Object> extParam, Set<String> extCondition) {
        return getOneByWhere(selectFields, null, extParam, extCondition);
    }

    public ModelMlinkMatchResult getOneByWhere(Map<String, Object> extParam, Set<String> extCondition) {
        return getOneByWhere(null, extParam, extCondition);
    }

    public ModelMlinkMatchResult getOneByCondAndWhere(Set<String> selectFields, DaoAssembler assembler, ModelMlinkMatchResult instance, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelMlinkMatchResult.FIELD_CLASS.keySet();
        }
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelMlinkMatchResult.DTO_TABLE_NAME);
        Integer start = 0;
        Integer count = 1;
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        super.buildRawWhere(sqlBuilder, param, extParam, extCondition);
        buildConditionCluase(sqlBuilder, instance, param);
        buildSelectFieldCluase(sqlBuilder, selectFields);
        sqlBuilder.setLimit();
        return getResult(assembler, sqlBuilder, param);
    }

    public ModelMlinkMatchResult getOneByCondAndWhere(Set<String> selectFields, ModelMlinkMatchResult instance, Map<String, Object> extParam, Set<String> extCondition) {
        return getOneByCondAndWhere(selectFields, null, instance, extParam, extCondition);
    }

    public ModelMlinkMatchResult getOneByCondAndWhere(ModelMlinkMatchResult instance, Map<String, Object> extParam, Set<String> extCondition) {
        return getOneByCondAndWhere(null, instance, extParam, extCondition);
    }

    public ModelMlinkMatchResult getOneByIdAndCondAndWhere(Set<String> selectFields, DaoAssembler assembler, ModelMlinkMatchResult instance, Integer id, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelMlinkMatchResult.FIELD_CLASS.keySet();
        }
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelMlinkMatchResult.DTO_TABLE_NAME);
        Integer start = 0;
        Integer count = 1;
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        super.buildRawWhere(sqlBuilder, param, extParam, extCondition);
        buildConditionCluase(sqlBuilder, instance, param);
        buildSelectFieldCluase(sqlBuilder, selectFields);
        if (id!= null) {
            sqlBuilder.where(ModelMlinkMatchResult.FI_ID, ColumnDataType.intData);
        }
        sqlBuilder.setLimit();
        return getResult(assembler, sqlBuilder, param);
    }

    public ModelMlinkMatchResult getOneByIdAndCondAndWhere(Set<String> selectFields, ModelMlinkMatchResult instance, Integer id, Map<String, Object> extParam, Set<String> extCondition) {
        return getOneByIdAndCondAndWhere(selectFields, null, instance, id, extParam, extCondition);
    }

    public ModelMlinkMatchResult getOneByIdAndCondAndWhere(ModelMlinkMatchResult instance, Integer id, Map<String, Object> extParam, Set<String> extCondition) {
        return getOneByIdAndCondAndWhere(null, instance, id, extParam, extCondition);
    }

    public Long getCountByCond(DaoAssembler assembler, ModelMlinkMatchResult instance) {
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelMlinkMatchResult.DTO_TABLE_NAME);
        Integer start = 0;
        Integer count = 1;
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        sqlBuilder.funcItems("count", "count");
        buildConditionCluase(sqlBuilder, instance, param);
        sqlBuilder.setLimit();
        return getSingleResult(assembler, sqlBuilder, param, Long.class);
    }

    public Long getCountByCond(ModelMlinkMatchResult instance) {
        return getCountByCond(null, instance);
    }

    public Long getCountByCondAndIndex(DaoAssembler assembler, ModelMlinkMatchResult instance, String inField, List indexes) {
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelMlinkMatchResult.DTO_TABLE_NAME);
        Integer start = 0;
        Integer count = 1;
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        sqlBuilder.funcItems("count", "count");
        buildConditionCluase(sqlBuilder, instance, param);
        buildInClause(sqlBuilder, inField, param, indexes);
        sqlBuilder.setLimit();
        return getSingleResult(assembler, sqlBuilder, param, Long.class);
    }

    public Long getCountByCondAndIndex(ModelMlinkMatchResult instance, String inField, List indexes) {
        return getCountByCondAndIndex(null, instance, inField, indexes);
    }

    public Long getCountByCondAndIndexAndWhere(DaoAssembler assembler, ModelMlinkMatchResult instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelMlinkMatchResult.DTO_TABLE_NAME);
        Integer start = 0;
        Integer count = 1;
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        super.buildRawWhere(sqlBuilder, param, extParam, extCondition);
        sqlBuilder.funcItems("count", "count");
        buildConditionCluase(sqlBuilder, instance, param);
        buildInClause(sqlBuilder, inField, param, indexes);
        sqlBuilder.setLimit();
        return getSingleResult(assembler, sqlBuilder, param, Long.class);
    }

    public Long getCountByCondAndIndexAndWhere(ModelMlinkMatchResult instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        return getCountByCondAndIndexAndWhere(null, instance, inField, indexes, extParam, extCondition);
    }

    public<TT> TT getItemByIndex(DaoAssembler assembler, String inField, List indexes, Class<TT> tClass, String rawItem) {
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelMlinkMatchResult.DTO_TABLE_NAME);
        Integer start = 0;
        Integer count = 1;
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        assert((tClass!= null));
        assert(((rawItem!= null)&&(rawItem.length()> 0)));
        sqlBuilder.rawItem(rawItem);
        buildInClause(sqlBuilder, inField, param, indexes);
        sqlBuilder.setLimit();
        return ((TT) getSingleResult(assembler, sqlBuilder, param, tClass));
    }

    public<TT extends Object> TT getItemByIndex(String inField, List indexes, Class<TT> tClass, String rawItem) {
        return getItemByIndex(null, inField, indexes, tClass, rawItem);
    }

    public<TT> TT getItemByWhere(DaoAssembler assembler, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelMlinkMatchResult.DTO_TABLE_NAME);
        Integer start = 0;
        Integer count = 1;
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        super.buildRawWhere(sqlBuilder, param, extParam, extCondition);
        assert((tClass!= null));
        assert(((rawItem!= null)&&(rawItem.length()> 0)));
        sqlBuilder.rawItem(rawItem);
        sqlBuilder.setLimit();
        return ((TT) getSingleResult(assembler, sqlBuilder, param, tClass));
    }

    public<TT extends Object> TT getItemByWhere(Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        return getItemByWhere(null, tClass, rawItem, extParam, extCondition);
    }

    public<TT> TT getItemByCond(DaoAssembler assembler, ModelMlinkMatchResult instance, Class<TT> tClass, String rawItem) {
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelMlinkMatchResult.DTO_TABLE_NAME);
        Integer start = 0;
        Integer count = 1;
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        assert((tClass!= null));
        assert(((rawItem!= null)&&(rawItem.length()> 0)));
        sqlBuilder.rawItem(rawItem);
        buildConditionCluase(sqlBuilder, instance, param);
        sqlBuilder.setLimit();
        return ((TT) getSingleResult(assembler, sqlBuilder, param, tClass));
    }

    public<TT extends Object> TT getItemByCond(ModelMlinkMatchResult instance, Class<TT> tClass, String rawItem) {
        return getItemByCond(null, instance, tClass, rawItem);
    }

    public<TT> TT getItemByCondAndIndex(DaoAssembler assembler, ModelMlinkMatchResult instance, String inField, List indexes, Class<TT> tClass, String rawItem) {
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelMlinkMatchResult.DTO_TABLE_NAME);
        Integer start = 0;
        Integer count = 1;
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        assert((tClass!= null));
        assert(((rawItem!= null)&&(rawItem.length()> 0)));
        sqlBuilder.rawItem(rawItem);
        buildConditionCluase(sqlBuilder, instance, param);
        buildInClause(sqlBuilder, inField, param, indexes);
        sqlBuilder.setLimit();
        return ((TT) getSingleResult(assembler, sqlBuilder, param, tClass));
    }

    public<TT extends Object> TT getItemByCondAndIndex(ModelMlinkMatchResult instance, String inField, List indexes, Class<TT> tClass, String rawItem) {
        return getItemByCondAndIndex(null, instance, inField, indexes, tClass, rawItem);
    }

    public<TT> TT getItemByCondAndIndexAndWhere(DaoAssembler assembler, ModelMlinkMatchResult instance, String inField, List indexes, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelMlinkMatchResult.DTO_TABLE_NAME);
        Integer start = 0;
        Integer count = 1;
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        super.buildRawWhere(sqlBuilder, param, extParam, extCondition);
        assert((tClass!= null));
        assert(((rawItem!= null)&&(rawItem.length()> 0)));
        sqlBuilder.rawItem(rawItem);
        buildConditionCluase(sqlBuilder, instance, param);
        buildInClause(sqlBuilder, inField, param, indexes);
        sqlBuilder.setLimit();
        return ((TT) getSingleResult(assembler, sqlBuilder, param, tClass));
    }

    public<TT extends Object> TT getItemByCondAndIndexAndWhere(ModelMlinkMatchResult instance, String inField, List indexes, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        return getItemByCondAndIndexAndWhere(null, instance, inField, indexes, tClass, rawItem, extParam, extCondition);
    }

    public<TT> List<TT> getItemListByIndex(DaoAssembler assembler, Integer start, Integer count, String inField, List indexes, Class<TT> tClass, String rawItem) {
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelMlinkMatchResult.DTO_TABLE_NAME);
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
        assert(((rawItem!= null)&&(rawItem.length()> 0)));
        sqlBuilder.rawItem(rawItem);
        buildInClause(sqlBuilder, inField, param, indexes);
        sqlBuilder.setLimit();
        return ((List<TT> ) getSingleResults(assembler, sqlBuilder, param, tClass));
    }

    public<TT extends Object> List<TT> getItemListByIndex(Integer start, Integer count, String inField, List indexes, Class<TT> tClass, String rawItem) {
        return getItemListByIndex(null, start, count, inField, indexes, tClass, rawItem);
    }

    public<TT extends Object> List<TT> getItemListByIndex(String inField, List indexes, Class<TT> tClass, String rawItem) {
        return getItemListByIndex(null, null, inField, indexes, tClass, rawItem);
    }

    public<TT> List<TT> getItemListByCond(DaoAssembler assembler, Integer start, Integer count, ModelMlinkMatchResult instance, Class<TT> tClass, String rawItem) {
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelMlinkMatchResult.DTO_TABLE_NAME);
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
        assert(((rawItem!= null)&&(rawItem.length()> 0)));
        sqlBuilder.rawItem(rawItem);
        buildConditionCluase(sqlBuilder, instance, param);
        sqlBuilder.setLimit();
        return ((List<TT> ) getSingleResults(assembler, sqlBuilder, param, tClass));
    }

    public<TT extends Object> List<TT> getItemListByCond(Integer start, Integer count, ModelMlinkMatchResult instance, Class<TT> tClass, String rawItem) {
        return getItemListByCond(null, start, count, instance, tClass, rawItem);
    }

    public<TT extends Object> List<TT> getItemListByCond(ModelMlinkMatchResult instance, Class<TT> tClass, String rawItem) {
        return getItemListByCond(null, null, instance, tClass, rawItem);
    }

    public<TT> List<TT> getItemListById(DaoAssembler assembler, Integer start, Integer count, Integer id, Class<TT> tClass, String rawItem) {
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelMlinkMatchResult.DTO_TABLE_NAME);
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
        assert(((rawItem!= null)&&(rawItem.length()> 0)));
        sqlBuilder.rawItem(rawItem);
        if (id!= null) {
            sqlBuilder.where(LogicalRelationshipType.and, LogicalOpType.in, null, ModelMlinkMatchResult.FI_ID, ModelMlinkMatchResult.FI_ID, ColumnDataType.intData);
        }
        sqlBuilder.setLimit();
        return ((List<TT> ) getSingleResults(assembler, sqlBuilder, param, tClass));
    }

    public<TT extends Object> List<TT> getItemListById(Integer start, Integer count, Integer id, Class<TT> tClass, String rawItem) {
        return getItemListById(null, start, count, id, tClass, rawItem);
    }

    public<TT extends Object> List<TT> getItemListById(Integer id, Class<TT> tClass, String rawItem) {
        return getItemListById(null, null, id, tClass, rawItem);
    }

    public<TT> List<TT> getItemListByWhere(DaoAssembler assembler, Integer start, Integer count, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelMlinkMatchResult.DTO_TABLE_NAME);
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
        assert(((rawItem!= null)&&(rawItem.length()> 0)));
        sqlBuilder.rawItem(rawItem);
        sqlBuilder.setLimit();
        return ((List<TT> ) getSingleResults(assembler, sqlBuilder, param, tClass));
    }

    public<TT extends Object> List<TT> getItemListByWhere(Integer start, Integer count, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        return getItemListByWhere(null, start, count, tClass, rawItem, extParam, extCondition);
    }

    public<TT extends Object> List<TT> getItemListByWhere(Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        return getItemListByWhere(null, null, tClass, rawItem, extParam, extCondition);
    }

    public<TT> List<TT> getItemListByIndexAndWhere(DaoAssembler assembler, Integer start, Integer count, String inField, List indexes, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelMlinkMatchResult.DTO_TABLE_NAME);
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
        assert(((rawItem!= null)&&(rawItem.length()> 0)));
        sqlBuilder.rawItem(rawItem);
        buildInClause(sqlBuilder, inField, param, indexes);
        sqlBuilder.setLimit();
        return ((List<TT> ) getSingleResults(assembler, sqlBuilder, param, tClass));
    }

    public<TT extends Object> List<TT> getItemListByIndexAndWhere(Integer start, Integer count, String inField, List indexes, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        return getItemListByIndexAndWhere(null, start, count, inField, indexes, tClass, rawItem, extParam, extCondition);
    }

    public<TT extends Object> List<TT> getItemListByIndexAndWhere(String inField, List indexes, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        return getItemListByIndexAndWhere(null, null, inField, indexes, tClass, rawItem, extParam, extCondition);
    }

    public<TT> List<TT> getItemListByCondAndWhere(DaoAssembler assembler, Integer start, Integer count, ModelMlinkMatchResult instance, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelMlinkMatchResult.DTO_TABLE_NAME);
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
        assert(((rawItem!= null)&&(rawItem.length()> 0)));
        sqlBuilder.rawItem(rawItem);
        buildConditionCluase(sqlBuilder, instance, param);
        sqlBuilder.setLimit();
        return ((List<TT> ) getSingleResults(assembler, sqlBuilder, param, tClass));
    }

    public<TT extends Object> List<TT> getItemListByCondAndWhere(Integer start, Integer count, ModelMlinkMatchResult instance, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        return getItemListByCondAndWhere(null, start, count, instance, tClass, rawItem, extParam, extCondition);
    }

    public<TT extends Object> List<TT> getItemListByCondAndWhere(ModelMlinkMatchResult instance, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        return getItemListByCondAndWhere(null, null, instance, tClass, rawItem, extParam, extCondition);
    }

    public<TT> List<TT> getItemListByCondAndIndex(DaoAssembler assembler, Integer start, Integer count, ModelMlinkMatchResult instance, String inField, List indexes, Class<TT> tClass, String rawItem) {
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelMlinkMatchResult.DTO_TABLE_NAME);
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
        assert(((rawItem!= null)&&(rawItem.length()> 0)));
        sqlBuilder.rawItem(rawItem);
        buildConditionCluase(sqlBuilder, instance, param);
        buildInClause(sqlBuilder, inField, param, indexes);
        sqlBuilder.setLimit();
        return ((List<TT> ) getSingleResults(assembler, sqlBuilder, param, tClass));
    }

    public<TT extends Object> List<TT> getItemListByCondAndIndex(Integer start, Integer count, ModelMlinkMatchResult instance, String inField, List indexes, Class<TT> tClass, String rawItem) {
        return getItemListByCondAndIndex(null, start, count, instance, inField, indexes, tClass, rawItem);
    }

    public<TT extends Object> List<TT> getItemListByCondAndIndex(ModelMlinkMatchResult instance, String inField, List indexes, Class<TT> tClass, String rawItem) {
        return getItemListByCondAndIndex(null, null, instance, inField, indexes, tClass, rawItem);
    }

    public<TT> List<TT> getItemListByIdAndCondAndWhere(DaoAssembler assembler, Integer start, Integer count, ModelMlinkMatchResult instance, List<Integer> id, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelMlinkMatchResult.DTO_TABLE_NAME);
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
        assert(((rawItem!= null)&&(rawItem.length()> 0)));
        sqlBuilder.rawItem(rawItem);
        buildConditionCluase(sqlBuilder, instance, param);
        if (id!= null) {
            sqlBuilder.where(LogicalRelationshipType.and, LogicalOpType.in, null, ModelMlinkMatchResult.FI_ID, ModelMlinkMatchResult.FI_ID, ColumnDataType.intData);
        }
        sqlBuilder.setLimit();
        return ((List<TT> ) getSingleResults(assembler, sqlBuilder, param, tClass));
    }

    public<TT extends Object> List<TT> getItemListByIdAndCondAndWhere(Integer start, Integer count, ModelMlinkMatchResult instance, List<Integer> id, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        return getItemListByIdAndCondAndWhere(null, start, count, instance, id, tClass, rawItem, extParam, extCondition);
    }

    public<TT extends Object> List<TT> getItemListByIdAndCondAndWhere(ModelMlinkMatchResult instance, List<Integer> id, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        return getItemListByIdAndCondAndWhere(null, null, instance, id, tClass, rawItem, extParam, extCondition);
    }

    public ModelMlinkMatchResult insert(ModelMlinkMatchResult instance, DaoAssembler assembler) {
        SQLInsert sqlBuilder = SQL.buildInsertSql(ModelMlinkMatchResult.DTO_TABLE_NAME);
        Integer dId = instance.getId();
        if (dId!= null) {
            sqlBuilder.items(ModelMlinkMatchResult.FI_ID);
        }
        Integer dUser_id = instance.getUserId();
        if (dUser_id!= null) {
            sqlBuilder.items(ModelMlinkMatchResult.FI_USER_ID);
        }
        Integer dMlink_id = instance.getMlinkId();
        if (dMlink_id!= null) {
            sqlBuilder.items(ModelMlinkMatchResult.FI_MLINK_ID);
        }
        String dMobile = instance.getMobile();
        if (dMobile!= null) {
            sqlBuilder.items(ModelMlinkMatchResult.FI_MOBILE);
        }
        Integer dIs_related = instance.getIsRelated();
        if (dIs_related!= null) {
            sqlBuilder.items(ModelMlinkMatchResult.FI_IS_RELATED);
        }
        Integer dStu_id = instance.getStuId();
        if (dStu_id!= null) {
            sqlBuilder.items(ModelMlinkMatchResult.FI_STU_ID);
        }
        String dSystem = instance.getSystem();
        if (dSystem!= null) {
            sqlBuilder.items(ModelMlinkMatchResult.FI_SYSTEM);
        }
        String dBind_state = instance.getBindState();
        if (dBind_state!= null) {
            sqlBuilder.items(ModelMlinkMatchResult.FI_BIND_STATE);
        }
        Integer dCall_result = instance.getCallResult();
        if (dCall_result!= null) {
            sqlBuilder.items(ModelMlinkMatchResult.FI_CALL_RESULT);
        }
        String dReturn_message = instance.getReturnMessage();
        if (dReturn_message!= null) {
            sqlBuilder.items(ModelMlinkMatchResult.FI_RETURN_MESSAGE);
        }
        Integer dIs_bind = instance.getIsBind();
        if (dIs_bind!= null) {
            sqlBuilder.items(ModelMlinkMatchResult.FI_IS_BIND);
        }
        Date dCreate_time = instance.getCreateTime();
        if (dCreate_time!= null) {
            sqlBuilder.items(ModelMlinkMatchResult.FI_CREATE_TIME);
        }
        Integer dDelete_flag = instance.getDeleteFlag();
        if (dDelete_flag!= null) {
            sqlBuilder.items(ModelMlinkMatchResult.FI_DELETE_FLAG);
        }
        Date dUpdate_time = instance.getUpdateTime();
        if (dUpdate_time!= null) {
            sqlBuilder.items(ModelMlinkMatchResult.FI_UPDATE_TIME);
        }
        Map<String, Object> param = ModelMlinkMatchResult.MAP_OBJ_MAPPER.toCommonMap(instance);
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

    public ModelMlinkMatchResult insert(ModelMlinkMatchResult instance) {
        return insert(instance, null);
    }

    public Integer insert(List<ModelMlinkMatchResult> instances, Set<String> fields, DaoAssembler assembler) {
        if (fields == null) {
            fields = ModelMlinkMatchResult.FIELD_CLASS.keySet();
        }
        SQLInsert sqlBuilder = SQL.buildInsertSql(ModelMlinkMatchResult.DTO_TABLE_NAME);
        if (fields.contains(ModelMlinkMatchResult.FI_ID)) {
            sqlBuilder.items(ModelMlinkMatchResult.FI_ID);
        }
        if (fields.contains(ModelMlinkMatchResult.FI_USER_ID)) {
            sqlBuilder.items(ModelMlinkMatchResult.FI_USER_ID);
        }
        if (fields.contains(ModelMlinkMatchResult.FI_MLINK_ID)) {
            sqlBuilder.items(ModelMlinkMatchResult.FI_MLINK_ID);
        }
        if (fields.contains(ModelMlinkMatchResult.FI_MOBILE)) {
            sqlBuilder.items(ModelMlinkMatchResult.FI_MOBILE);
        }
        if (fields.contains(ModelMlinkMatchResult.FI_IS_RELATED)) {
            sqlBuilder.items(ModelMlinkMatchResult.FI_IS_RELATED);
        }
        if (fields.contains(ModelMlinkMatchResult.FI_STU_ID)) {
            sqlBuilder.items(ModelMlinkMatchResult.FI_STU_ID);
        }
        if (fields.contains(ModelMlinkMatchResult.FI_SYSTEM)) {
            sqlBuilder.items(ModelMlinkMatchResult.FI_SYSTEM);
        }
        if (fields.contains(ModelMlinkMatchResult.FI_BIND_STATE)) {
            sqlBuilder.items(ModelMlinkMatchResult.FI_BIND_STATE);
        }
        if (fields.contains(ModelMlinkMatchResult.FI_CALL_RESULT)) {
            sqlBuilder.items(ModelMlinkMatchResult.FI_CALL_RESULT);
        }
        if (fields.contains(ModelMlinkMatchResult.FI_RETURN_MESSAGE)) {
            sqlBuilder.items(ModelMlinkMatchResult.FI_RETURN_MESSAGE);
        }
        if (fields.contains(ModelMlinkMatchResult.FI_IS_BIND)) {
            sqlBuilder.items(ModelMlinkMatchResult.FI_IS_BIND);
        }
        if (fields.contains(ModelMlinkMatchResult.FI_CREATE_TIME)) {
            sqlBuilder.items(ModelMlinkMatchResult.FI_CREATE_TIME);
        }
        if (fields.contains(ModelMlinkMatchResult.FI_DELETE_FLAG)) {
            sqlBuilder.items(ModelMlinkMatchResult.FI_DELETE_FLAG);
        }
        if (fields.contains(ModelMlinkMatchResult.FI_UPDATE_TIME)) {
            sqlBuilder.items(ModelMlinkMatchResult.FI_UPDATE_TIME);
        }
        List<Map<String, Object>> param = CollectionHelper.<Map<String,Object>> newList();
        for (ModelMlinkMatchResult instance: instances) {
            Map<String, Object> paramMap = ModelMlinkMatchResult.MAP_OBJ_MAPPER.toCommonMap(instance);
            param.add(paramMap);
        }
        SimpleDbInterface dbInstance = data_store;
        String dbToUse = super.selectDb(assembler, sqlBuilder, param);
        if ((dbToUse!= null)&&dbMap.containsKey(dbToUse)) {
            dbInstance = dbMap.get(dbToUse);
        }
        return super.batchInsert(dbInstance, assembler, sqlBuilder, param);
    }

    public Integer insert(List<ModelMlinkMatchResult> instances, Set<String> fields) {
        return insert(instances, fields, null);
    }

    public Integer insert(List<ModelMlinkMatchResult> instances) {
        return insert(instances, null, null);
    }

    public Integer update(ModelMlinkMatchResult instance, Set<String> conditionField, DaoAssembler assembler) {
        SQLUpdate sqlBuilder = SQL.buildUpdateSql(ModelMlinkMatchResult.DTO_TABLE_NAME);
        Integer dId = instance.getId();
        if (conditionField.contains(ModelMlinkMatchResult.FI_ID)) {
            assert((dId!= null));
            sqlBuilder.where(ModelMlinkMatchResult.FI_ID, ColumnDataType.intData);
        } else {
            if (dId!= null) {
                sqlBuilder.items(ModelMlinkMatchResult.FI_ID);
            }
        }
        Integer dUser_id = instance.getUserId();
        if (conditionField.contains(ModelMlinkMatchResult.FI_USER_ID)) {
            assert((dUser_id!= null));
            sqlBuilder.where(ModelMlinkMatchResult.FI_USER_ID, ColumnDataType.intData);
        } else {
            if (dUser_id!= null) {
                sqlBuilder.items(ModelMlinkMatchResult.FI_USER_ID);
            }
        }
        Integer dMlink_id = instance.getMlinkId();
        if (conditionField.contains(ModelMlinkMatchResult.FI_MLINK_ID)) {
            assert((dMlink_id!= null));
            sqlBuilder.where(ModelMlinkMatchResult.FI_MLINK_ID, ColumnDataType.intData);
        } else {
            if (dMlink_id!= null) {
                sqlBuilder.items(ModelMlinkMatchResult.FI_MLINK_ID);
            }
        }
        String dMobile = instance.getMobile();
        if (conditionField.contains(ModelMlinkMatchResult.FI_MOBILE)) {
            assert((dMobile!= null));
            sqlBuilder.where(ModelMlinkMatchResult.FI_MOBILE, ColumnDataType.stringData);
        } else {
            if (dMobile!= null) {
                sqlBuilder.items(ModelMlinkMatchResult.FI_MOBILE);
            }
        }
        Integer dIs_related = instance.getIsRelated();
        if (conditionField.contains(ModelMlinkMatchResult.FI_IS_RELATED)) {
            assert((dIs_related!= null));
            sqlBuilder.where(ModelMlinkMatchResult.FI_IS_RELATED, ColumnDataType.intData);
        } else {
            if (dIs_related!= null) {
                sqlBuilder.items(ModelMlinkMatchResult.FI_IS_RELATED);
            }
        }
        Integer dStu_id = instance.getStuId();
        if (conditionField.contains(ModelMlinkMatchResult.FI_STU_ID)) {
            assert((dStu_id!= null));
            sqlBuilder.where(ModelMlinkMatchResult.FI_STU_ID, ColumnDataType.intData);
        } else {
            if (dStu_id!= null) {
                sqlBuilder.items(ModelMlinkMatchResult.FI_STU_ID);
            }
        }
        String dSystem = instance.getSystem();
        if (conditionField.contains(ModelMlinkMatchResult.FI_SYSTEM)) {
            assert((dSystem!= null));
            sqlBuilder.where(ModelMlinkMatchResult.FI_SYSTEM, ColumnDataType.stringData);
        } else {
            if (dSystem!= null) {
                sqlBuilder.items(ModelMlinkMatchResult.FI_SYSTEM);
            }
        }
        String dBind_state = instance.getBindState();
        if (conditionField.contains(ModelMlinkMatchResult.FI_BIND_STATE)) {
            assert((dBind_state!= null));
            sqlBuilder.where(ModelMlinkMatchResult.FI_BIND_STATE, ColumnDataType.stringData);
        } else {
            if (dBind_state!= null) {
                sqlBuilder.items(ModelMlinkMatchResult.FI_BIND_STATE);
            }
        }
        Integer dCall_result = instance.getCallResult();
        if (conditionField.contains(ModelMlinkMatchResult.FI_CALL_RESULT)) {
            assert((dCall_result!= null));
            sqlBuilder.where(ModelMlinkMatchResult.FI_CALL_RESULT, ColumnDataType.intData);
        } else {
            if (dCall_result!= null) {
                sqlBuilder.items(ModelMlinkMatchResult.FI_CALL_RESULT);
            }
        }
        String dReturn_message = instance.getReturnMessage();
        if (conditionField.contains(ModelMlinkMatchResult.FI_RETURN_MESSAGE)) {
            assert((dReturn_message!= null));
            sqlBuilder.where(ModelMlinkMatchResult.FI_RETURN_MESSAGE, ColumnDataType.stringData);
        } else {
            if (dReturn_message!= null) {
                sqlBuilder.items(ModelMlinkMatchResult.FI_RETURN_MESSAGE);
            }
        }
        Integer dIs_bind = instance.getIsBind();
        if (conditionField.contains(ModelMlinkMatchResult.FI_IS_BIND)) {
            assert((dIs_bind!= null));
            sqlBuilder.where(ModelMlinkMatchResult.FI_IS_BIND, ColumnDataType.intData);
        } else {
            if (dIs_bind!= null) {
                sqlBuilder.items(ModelMlinkMatchResult.FI_IS_BIND);
            }
        }
        Date dCreate_time = instance.getCreateTime();
        if (conditionField.contains(ModelMlinkMatchResult.FI_CREATE_TIME)) {
            assert((dCreate_time!= null));
            sqlBuilder.where(ModelMlinkMatchResult.FI_CREATE_TIME, ColumnDataType.timeStampData);
        } else {
            if (dCreate_time!= null) {
                sqlBuilder.items(ModelMlinkMatchResult.FI_CREATE_TIME);
            }
        }
        Integer dDelete_flag = instance.getDeleteFlag();
        if (conditionField.contains(ModelMlinkMatchResult.FI_DELETE_FLAG)) {
            assert((dDelete_flag!= null));
            sqlBuilder.where(ModelMlinkMatchResult.FI_DELETE_FLAG, ColumnDataType.intData);
        } else {
            if (dDelete_flag!= null) {
                sqlBuilder.items(ModelMlinkMatchResult.FI_DELETE_FLAG);
            }
        }
        Date dUpdate_time = instance.getUpdateTime();
        if (conditionField.contains(ModelMlinkMatchResult.FI_UPDATE_TIME)) {
            assert((dUpdate_time!= null));
            sqlBuilder.where(ModelMlinkMatchResult.FI_UPDATE_TIME, ColumnDataType.timeStampData);
        } else {
            if (dUpdate_time!= null) {
                sqlBuilder.items(ModelMlinkMatchResult.FI_UPDATE_TIME);
            }
        }
        Map<String, Object> param = ModelMlinkMatchResult.MAP_OBJ_MAPPER.toCommonMap(instance);
        SimpleDbInterface dbInstance = data_store;
        String dbToUse = super.selectDb(assembler, sqlBuilder, param);
        if ((dbToUse!= null)&&dbMap.containsKey(dbToUse)) {
            dbInstance = dbMap.get(dbToUse);
        }
        return super.update(dbInstance, assembler, sqlBuilder, param);
    }

    public Integer update(ModelMlinkMatchResult instance, Set<String> conditionField) {
        return update(instance, conditionField, null);
    }

    public Integer updateById(ModelMlinkMatchResult instance, DaoAssembler assembler) {
        SQLUpdate sqlBuilder = SQL.buildUpdateSql(ModelMlinkMatchResult.DTO_TABLE_NAME);
        assert((instance.getId()!= null));
        Integer dId = instance.getId();
        if (dId!= null) {
            sqlBuilder.where(ModelMlinkMatchResult.FI_ID, ColumnDataType.intData);
        }
        Integer dUser_id = instance.getUserId();
        if (dUser_id!= null) {
            sqlBuilder.items(ModelMlinkMatchResult.FI_USER_ID);
        }
        Integer dMlink_id = instance.getMlinkId();
        if (dMlink_id!= null) {
            sqlBuilder.items(ModelMlinkMatchResult.FI_MLINK_ID);
        }
        String dMobile = instance.getMobile();
        if (dMobile!= null) {
            sqlBuilder.items(ModelMlinkMatchResult.FI_MOBILE);
        }
        Integer dIs_related = instance.getIsRelated();
        if (dIs_related!= null) {
            sqlBuilder.items(ModelMlinkMatchResult.FI_IS_RELATED);
        }
        Integer dStu_id = instance.getStuId();
        if (dStu_id!= null) {
            sqlBuilder.items(ModelMlinkMatchResult.FI_STU_ID);
        }
        String dSystem = instance.getSystem();
        if (dSystem!= null) {
            sqlBuilder.items(ModelMlinkMatchResult.FI_SYSTEM);
        }
        String dBind_state = instance.getBindState();
        if (dBind_state!= null) {
            sqlBuilder.items(ModelMlinkMatchResult.FI_BIND_STATE);
        }
        Integer dCall_result = instance.getCallResult();
        if (dCall_result!= null) {
            sqlBuilder.items(ModelMlinkMatchResult.FI_CALL_RESULT);
        }
        String dReturn_message = instance.getReturnMessage();
        if (dReturn_message!= null) {
            sqlBuilder.items(ModelMlinkMatchResult.FI_RETURN_MESSAGE);
        }
        Integer dIs_bind = instance.getIsBind();
        if (dIs_bind!= null) {
            sqlBuilder.items(ModelMlinkMatchResult.FI_IS_BIND);
        }
        Date dCreate_time = instance.getCreateTime();
        if (dCreate_time!= null) {
            sqlBuilder.items(ModelMlinkMatchResult.FI_CREATE_TIME);
        }
        Integer dDelete_flag = instance.getDeleteFlag();
        if (dDelete_flag!= null) {
            sqlBuilder.items(ModelMlinkMatchResult.FI_DELETE_FLAG);
        }
        Date dUpdate_time = instance.getUpdateTime();
        if (dUpdate_time!= null) {
            sqlBuilder.items(ModelMlinkMatchResult.FI_UPDATE_TIME);
        }
        Map<String, Object> param = ModelMlinkMatchResult.MAP_OBJ_MAPPER.toCommonMap(instance);
        SimpleDbInterface dbInstance = data_store;
        String dbToUse = super.selectDb(assembler, sqlBuilder, param);
        if ((dbToUse!= null)&&dbMap.containsKey(dbToUse)) {
            dbInstance = dbMap.get(dbToUse);
        }
        return super.update(dbInstance, assembler, sqlBuilder, param);
    }

    public Integer updateById(ModelMlinkMatchResult instance) {
        return updateById(instance, null);
    }

    public Integer updateByIds(ModelMlinkMatchResult instance, Set<Integer> ids, DaoAssembler assembler) {
        SQLUpdate sqlBuilder = SQL.buildUpdateSql(ModelMlinkMatchResult.DTO_TABLE_NAME);
        assert(((ids!= null)&&(ids.size()> 0)));
        sqlBuilder.where(LogicalOpType.in, ModelMlinkMatchResult.FI_ID, "ids", ColumnDataType.intData);
        instance.setId(null);
        Integer dUser_id = instance.getUserId();
        if (dUser_id!= null) {
            sqlBuilder.items(ModelMlinkMatchResult.FI_USER_ID);
        }
        Integer dMlink_id = instance.getMlinkId();
        if (dMlink_id!= null) {
            sqlBuilder.items(ModelMlinkMatchResult.FI_MLINK_ID);
        }
        String dMobile = instance.getMobile();
        if (dMobile!= null) {
            sqlBuilder.items(ModelMlinkMatchResult.FI_MOBILE);
        }
        Integer dIs_related = instance.getIsRelated();
        if (dIs_related!= null) {
            sqlBuilder.items(ModelMlinkMatchResult.FI_IS_RELATED);
        }
        Integer dStu_id = instance.getStuId();
        if (dStu_id!= null) {
            sqlBuilder.items(ModelMlinkMatchResult.FI_STU_ID);
        }
        String dSystem = instance.getSystem();
        if (dSystem!= null) {
            sqlBuilder.items(ModelMlinkMatchResult.FI_SYSTEM);
        }
        String dBind_state = instance.getBindState();
        if (dBind_state!= null) {
            sqlBuilder.items(ModelMlinkMatchResult.FI_BIND_STATE);
        }
        Integer dCall_result = instance.getCallResult();
        if (dCall_result!= null) {
            sqlBuilder.items(ModelMlinkMatchResult.FI_CALL_RESULT);
        }
        String dReturn_message = instance.getReturnMessage();
        if (dReturn_message!= null) {
            sqlBuilder.items(ModelMlinkMatchResult.FI_RETURN_MESSAGE);
        }
        Integer dIs_bind = instance.getIsBind();
        if (dIs_bind!= null) {
            sqlBuilder.items(ModelMlinkMatchResult.FI_IS_BIND);
        }
        Date dCreate_time = instance.getCreateTime();
        if (dCreate_time!= null) {
            sqlBuilder.items(ModelMlinkMatchResult.FI_CREATE_TIME);
        }
        Integer dDelete_flag = instance.getDeleteFlag();
        if (dDelete_flag!= null) {
            sqlBuilder.items(ModelMlinkMatchResult.FI_DELETE_FLAG);
        }
        Date dUpdate_time = instance.getUpdateTime();
        if (dUpdate_time!= null) {
            sqlBuilder.items(ModelMlinkMatchResult.FI_UPDATE_TIME);
        }
        Map<String, Object> param = ModelMlinkMatchResult.MAP_OBJ_MAPPER.toCommonMap(instance);
        param.put("ids", ids);
        SimpleDbInterface dbInstance = data_store;
        String dbToUse = super.selectDb(assembler, sqlBuilder, param);
        if ((dbToUse!= null)&&dbMap.containsKey(dbToUse)) {
            dbInstance = dbMap.get(dbToUse);
        }
        return super.update(dbInstance, assembler, sqlBuilder, param);
    }

    public Integer updateByIds(ModelMlinkMatchResult instance, Set<Integer> ids) {
        return updateByIds(instance, ids, null);
    }

    public Integer delete(ModelMlinkMatchResult instance, Set<String> conditionField, DaoAssembler assembler) {
        SQLDelete sqlBuilder = SQL.buildDeleteSql(ModelMlinkMatchResult.DTO_TABLE_NAME);
        Integer dId = instance.getId();
        if (conditionField.contains(ModelMlinkMatchResult.FI_ID)) {
            assert((dId!= null));
            sqlBuilder.where(ModelMlinkMatchResult.FI_ID, ColumnDataType.intData);
        }
        Integer dUser_id = instance.getUserId();
        if (conditionField.contains(ModelMlinkMatchResult.FI_USER_ID)) {
            assert((dUser_id!= null));
            sqlBuilder.where(ModelMlinkMatchResult.FI_USER_ID, ColumnDataType.intData);
        }
        Integer dMlink_id = instance.getMlinkId();
        if (conditionField.contains(ModelMlinkMatchResult.FI_MLINK_ID)) {
            assert((dMlink_id!= null));
            sqlBuilder.where(ModelMlinkMatchResult.FI_MLINK_ID, ColumnDataType.intData);
        }
        String dMobile = instance.getMobile();
        if (conditionField.contains(ModelMlinkMatchResult.FI_MOBILE)) {
            assert((dMobile!= null));
            sqlBuilder.where(ModelMlinkMatchResult.FI_MOBILE, ColumnDataType.stringData);
        }
        Integer dIs_related = instance.getIsRelated();
        if (conditionField.contains(ModelMlinkMatchResult.FI_IS_RELATED)) {
            assert((dIs_related!= null));
            sqlBuilder.where(ModelMlinkMatchResult.FI_IS_RELATED, ColumnDataType.intData);
        }
        Integer dStu_id = instance.getStuId();
        if (conditionField.contains(ModelMlinkMatchResult.FI_STU_ID)) {
            assert((dStu_id!= null));
            sqlBuilder.where(ModelMlinkMatchResult.FI_STU_ID, ColumnDataType.intData);
        }
        String dSystem = instance.getSystem();
        if (conditionField.contains(ModelMlinkMatchResult.FI_SYSTEM)) {
            assert((dSystem!= null));
            sqlBuilder.where(ModelMlinkMatchResult.FI_SYSTEM, ColumnDataType.stringData);
        }
        String dBind_state = instance.getBindState();
        if (conditionField.contains(ModelMlinkMatchResult.FI_BIND_STATE)) {
            assert((dBind_state!= null));
            sqlBuilder.where(ModelMlinkMatchResult.FI_BIND_STATE, ColumnDataType.stringData);
        }
        Integer dCall_result = instance.getCallResult();
        if (conditionField.contains(ModelMlinkMatchResult.FI_CALL_RESULT)) {
            assert((dCall_result!= null));
            sqlBuilder.where(ModelMlinkMatchResult.FI_CALL_RESULT, ColumnDataType.intData);
        }
        String dReturn_message = instance.getReturnMessage();
        if (conditionField.contains(ModelMlinkMatchResult.FI_RETURN_MESSAGE)) {
            assert((dReturn_message!= null));
            sqlBuilder.where(ModelMlinkMatchResult.FI_RETURN_MESSAGE, ColumnDataType.stringData);
        }
        Integer dIs_bind = instance.getIsBind();
        if (conditionField.contains(ModelMlinkMatchResult.FI_IS_BIND)) {
            assert((dIs_bind!= null));
            sqlBuilder.where(ModelMlinkMatchResult.FI_IS_BIND, ColumnDataType.intData);
        }
        Date dCreate_time = instance.getCreateTime();
        if (conditionField.contains(ModelMlinkMatchResult.FI_CREATE_TIME)) {
            assert((dCreate_time!= null));
            sqlBuilder.where(ModelMlinkMatchResult.FI_CREATE_TIME, ColumnDataType.timeStampData);
        }
        Integer dDelete_flag = instance.getDeleteFlag();
        if (conditionField.contains(ModelMlinkMatchResult.FI_DELETE_FLAG)) {
            assert((dDelete_flag!= null));
            sqlBuilder.where(ModelMlinkMatchResult.FI_DELETE_FLAG, ColumnDataType.intData);
        }
        Date dUpdate_time = instance.getUpdateTime();
        if (conditionField.contains(ModelMlinkMatchResult.FI_UPDATE_TIME)) {
            assert((dUpdate_time!= null));
            sqlBuilder.where(ModelMlinkMatchResult.FI_UPDATE_TIME, ColumnDataType.timeStampData);
        }
        Map<String, Object> param = ModelMlinkMatchResult.MAP_OBJ_MAPPER.toCommonMap(instance);
        SimpleDbInterface dbInstance = data_store;
        String dbToUse = super.selectDb(assembler, sqlBuilder, param);
        if ((dbToUse!= null)&&dbMap.containsKey(dbToUse)) {
            dbInstance = dbMap.get(dbToUse);
        }
        return super.update(dbInstance, assembler, sqlBuilder, param);
    }

    public Integer delete(ModelMlinkMatchResult instance, Set<String> conditionField) {
        return delete(instance, conditionField, null);
    }

    public Integer deleteById(Integer id, DaoAssembler assembler) {
        SQLDelete sqlBuilder = SQL.buildDeleteSql(ModelMlinkMatchResult.DTO_TABLE_NAME);
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
        SQLDelete sqlBuilder = SQL.buildDeleteSql(ModelMlinkMatchResult.DTO_TABLE_NAME);
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
    public ModelMlinkMatchResult updateOrInsert(ModelMlinkMatchResult instance, Set<String> conditionField, AbstractMultipleDaoAssembler assembler) {
        if (assembler == null) {
            assembler = new BaseMultipleDaoAssembler();
        }
        ModelMlinkMatchResult checkInstance = new ModelMlinkMatchResult();
        if (conditionField.contains(ModelMlinkMatchResult.FI_ID)) {
            checkInstance.setId(instance.getId());
        }
        if (conditionField.contains(ModelMlinkMatchResult.FI_USER_ID)) {
            checkInstance.setUserId(instance.getUserId());
        }
        if (conditionField.contains(ModelMlinkMatchResult.FI_MLINK_ID)) {
            checkInstance.setMlinkId(instance.getMlinkId());
        }
        if (conditionField.contains(ModelMlinkMatchResult.FI_MOBILE)) {
            checkInstance.setMobile(instance.getMobile());
        }
        if (conditionField.contains(ModelMlinkMatchResult.FI_IS_RELATED)) {
            checkInstance.setIsRelated(instance.getIsRelated());
        }
        if (conditionField.contains(ModelMlinkMatchResult.FI_STU_ID)) {
            checkInstance.setStuId(instance.getStuId());
        }
        if (conditionField.contains(ModelMlinkMatchResult.FI_SYSTEM)) {
            checkInstance.setSystem(instance.getSystem());
        }
        if (conditionField.contains(ModelMlinkMatchResult.FI_BIND_STATE)) {
            checkInstance.setBindState(instance.getBindState());
        }
        if (conditionField.contains(ModelMlinkMatchResult.FI_CALL_RESULT)) {
            checkInstance.setCallResult(instance.getCallResult());
        }
        if (conditionField.contains(ModelMlinkMatchResult.FI_RETURN_MESSAGE)) {
            checkInstance.setReturnMessage(instance.getReturnMessage());
        }
        if (conditionField.contains(ModelMlinkMatchResult.FI_IS_BIND)) {
            checkInstance.setIsBind(instance.getIsBind());
        }
        if (conditionField.contains(ModelMlinkMatchResult.FI_CREATE_TIME)) {
            checkInstance.setCreateTime(instance.getCreateTime());
        }
        if (conditionField.contains(ModelMlinkMatchResult.FI_DELETE_FLAG)) {
            checkInstance.setDeleteFlag(instance.getDeleteFlag());
        }
        if (conditionField.contains(ModelMlinkMatchResult.FI_UPDATE_TIME)) {
            checkInstance.setUpdateTime(instance.getUpdateTime());
        }
        ModelMlinkMatchResult selected = getOneByCond(Collections.singleton(ModelMlinkMatchResult.FI_ID), assembler, checkInstance);
        assembler.increaseIndex();
        if (selected == null) {
            return insert(instance, assembler);
        } else {
            instance.setId(selected.getId());
            update(instance, Collections.singleton(ModelMlinkMatchResult.FI_ID), assembler);
            return instance;
        }
    }

    public ModelMlinkMatchResult updateOrInsert(ModelMlinkMatchResult instance, Set<String> conditionField) {
        return updateOrInsert(instance, conditionField, null);
    }

    @Transactional
    public ModelMlinkMatchResult insertIfNoExist(ModelMlinkMatchResult instance, Set<String> conditionField, AbstractMultipleDaoAssembler assembler) {
        if (assembler == null) {
            assembler = new BaseMultipleDaoAssembler();
        }
        ModelMlinkMatchResult checkInstance = new ModelMlinkMatchResult();
        if (conditionField.contains(ModelMlinkMatchResult.FI_ID)) {
            checkInstance.setId(instance.getId());
        }
        if (conditionField.contains(ModelMlinkMatchResult.FI_USER_ID)) {
            checkInstance.setUserId(instance.getUserId());
        }
        if (conditionField.contains(ModelMlinkMatchResult.FI_MLINK_ID)) {
            checkInstance.setMlinkId(instance.getMlinkId());
        }
        if (conditionField.contains(ModelMlinkMatchResult.FI_MOBILE)) {
            checkInstance.setMobile(instance.getMobile());
        }
        if (conditionField.contains(ModelMlinkMatchResult.FI_IS_RELATED)) {
            checkInstance.setIsRelated(instance.getIsRelated());
        }
        if (conditionField.contains(ModelMlinkMatchResult.FI_STU_ID)) {
            checkInstance.setStuId(instance.getStuId());
        }
        if (conditionField.contains(ModelMlinkMatchResult.FI_SYSTEM)) {
            checkInstance.setSystem(instance.getSystem());
        }
        if (conditionField.contains(ModelMlinkMatchResult.FI_BIND_STATE)) {
            checkInstance.setBindState(instance.getBindState());
        }
        if (conditionField.contains(ModelMlinkMatchResult.FI_CALL_RESULT)) {
            checkInstance.setCallResult(instance.getCallResult());
        }
        if (conditionField.contains(ModelMlinkMatchResult.FI_RETURN_MESSAGE)) {
            checkInstance.setReturnMessage(instance.getReturnMessage());
        }
        if (conditionField.contains(ModelMlinkMatchResult.FI_IS_BIND)) {
            checkInstance.setIsBind(instance.getIsBind());
        }
        if (conditionField.contains(ModelMlinkMatchResult.FI_CREATE_TIME)) {
            checkInstance.setCreateTime(instance.getCreateTime());
        }
        if (conditionField.contains(ModelMlinkMatchResult.FI_DELETE_FLAG)) {
            checkInstance.setDeleteFlag(instance.getDeleteFlag());
        }
        if (conditionField.contains(ModelMlinkMatchResult.FI_UPDATE_TIME)) {
            checkInstance.setUpdateTime(instance.getUpdateTime());
        }
        ModelMlinkMatchResult selected = getOneByCond(Collections.singleton(ModelMlinkMatchResult.FI_ID), assembler, checkInstance);
        assembler.increaseIndex();
        if (selected == null) {
            return insert(instance, assembler);
        } else {
            instance.setId(selected.getId());
            return instance;
        }
    }

    public ModelMlinkMatchResult insertIfNoExist(ModelMlinkMatchResult instance, Set<String> conditionField) {
        return insertIfNoExist(instance, conditionField, null);
    }

    public<TT> Map<TT, ModelMlinkMatchResult> buildMap(List<ModelMlinkMatchResult> list, String field) {
        Map<TT, ModelMlinkMatchResult> ret = CollectionHelper.newMap();
        if (list == null) {
            return ret;
        }
        for (ModelMlinkMatchResult item: list) {
            ret.put(ModelMlinkMatchResult.MAP_OBJ_MAPPER.<TT> getField(field, item), item);
        }
        return ret;
    }

    public<TT> Map<TT, List<ModelMlinkMatchResult>> buildListMap(List<ModelMlinkMatchResult> list, String field) {
        Map<TT, List<ModelMlinkMatchResult>> ret = CollectionHelper.newMap();
        if (list == null) {
            return ret;
        }
        for (ModelMlinkMatchResult item: list) {
            List<ModelMlinkMatchResult> itemList = ret.get(ModelMlinkMatchResult.MAP_OBJ_MAPPER.<TT> getField(field, item));
            if (itemList == null) {
                itemList = CollectionHelper.newList();
            }
            itemList.add(item);
            ret.put(ModelMlinkMatchResult.MAP_OBJ_MAPPER.<TT> getField(field, item), itemList);
        }
        return ret;
    }

    public<TT> List<TT> extractItemAsList(List<ModelMlinkMatchResult> list, String field) {
        List<TT> ret = CollectionHelper.newList();
        if ((list == null)||(list.size() == 0)) {
            return ret;
        }
        if (ModelMlinkMatchResult.FIELD_CLASS.containsKey(field)) {
            for (ModelMlinkMatchResult item: list) {
                ret.add(ModelMlinkMatchResult.MAP_OBJ_MAPPER.<TT> getField(field, item));
            }
        }
        return ret;
    }
}
