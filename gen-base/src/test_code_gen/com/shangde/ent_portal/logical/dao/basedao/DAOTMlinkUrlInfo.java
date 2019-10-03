package com.shangde.ent_portal.logical.dao.basedao;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map;
import java.util.Set;
import com.shangde.ent_portal.logical.dto.basepo.ModelTMlinkUrlInfo.ResultSetMapperModelTMlinkUrlInfo;
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
import com.shangde.ent_portal.logical.dto.basepo.ModelTMlinkUrlInfo;

@Repository("DAOTMlinkUrlInfo")
@SuppressWarnings("unchecked")
public class DAOTMlinkUrlInfo
    extends AbstractDao<com.shangde.ent_portal.logical.dto.basepo.ModelTMlinkUrlInfo, Integer>
    implements DaoInterface<com.shangde.ent_portal.logical.dto.basepo.ModelTMlinkUrlInfo, Integer> , InitializingBean
{
    public final static Logger logger = LoggerFactory.getLogger(DAOTMlinkUrlInfo.class);
    @Autowired(required = true)
    @Qualifier("ent_portal_slave")
    protected SimpleDbInterface data_store;
    protected final static Map<String, SimpleDbInterface> dbMap = CollectionHelper.newMap();
    public final static String dbOfEntPortalSlave = "ent_portal_slave";
    @Autowired(required = true)
    @Qualifier("ent_portal_slave")
    protected SimpleDbInterface data_storeEntPortalSlave;

    public DAOTMlinkUrlInfo() {
        super(com.shangde.ent_portal.logical.dto.basepo.ModelTMlinkUrlInfo.class);
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

    protected List<ModelTMlinkUrlInfo> getResults(DaoAssembler assembler, SQL<SQLSelect> sqlBuilder, Map<String, Object> param) {
        int status = 0;
        if (assembler!= null) {
            status = assembler.assembleSql(sqlBuilder, param, ModelTMlinkUrlInfo.class);
        }
        SimpleDbInterface dbInstance = data_store;
        String dbToUse = super.selectDb(assembler, sqlBuilder, param);
        if ((dbToUse!= null)&&dbMap.containsKey(dbToUse)) {
            dbInstance = dbMap.get(dbToUse);
        }
        if (status == 0) {
            ResultSetMapperModelTMlinkUrlInfo<ModelTMlinkUrlInfo> rsMapper = ModelTMlinkUrlInfo.RESULT_SET_OBJ_MAPPER;
            if (assembler!= null) {
                ResultSetMapperModelTMlinkUrlInfo<ModelTMlinkUrlInfo> rsMapperTmp = ((ResultSetMapperModelTMlinkUrlInfo<ModelTMlinkUrlInfo> ) assembler.<ModelTMlinkUrlInfo> assembleResultSetMapper(param, ModelTMlinkUrlInfo.class));
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

    protected ModelTMlinkUrlInfo getResult(DaoAssembler assembler, SQL<SQLSelect> sqlBuilder, Map<String, Object> param) {
        int status = 0;
        if (assembler!= null) {
            status = assembler.assembleSql(sqlBuilder, param, ModelTMlinkUrlInfo.class);
        }
        SimpleDbInterface dbInstance = data_store;
        String dbToUse = super.selectDb(assembler, sqlBuilder, param);
        if ((dbToUse!= null)&&dbMap.containsKey(dbToUse)) {
            dbInstance = dbMap.get(dbToUse);
        }
        if (status == 0) {
            ResultSetMapperModelTMlinkUrlInfo<ModelTMlinkUrlInfo> rsMapper = ModelTMlinkUrlInfo.RESULT_SET_OBJ_MAPPER;
            if (assembler!= null) {
                ResultSetMapperModelTMlinkUrlInfo<ModelTMlinkUrlInfo> rsMapperTmp = ((ResultSetMapperModelTMlinkUrlInfo<ModelTMlinkUrlInfo> ) assembler.<ModelTMlinkUrlInfo> assembleResultSetMapper(param, ModelTMlinkUrlInfo.class));
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
        if (ModelTMlinkUrlInfo.FIELD_CLASS.containsKey(inField)) {
            Object fieldClassObj = ModelTMlinkUrlInfo.FIELD_CLASS.get(inField);
            super.buildRawInCluase(sqlBuilder, param, inField, fieldClassObj, indexes);
        } else {
            logger.error("field parameter error");
            throw new IllegalArgumentException(((("there is mistake with infield parameter, column "+ inField)+" not found in table ")+ com.shangde.ent_portal.logical.dto.basepo.ModelTMlinkUrlInfo.DTO_TABLE_NAME));
        }
    }

    protected void buildConditionCluase(SQLSelect<SQLSelect> sqlBuilder, ModelTMlinkUrlInfo instance, Map<String, Object> param) {
        Integer dId = instance.getId();
        if (dId!= null) {
            sqlBuilder.where(ModelTMlinkUrlInfo.FI_ID, ColumnDataType.intData);
            param.put(ModelTMlinkUrlInfo.FI_ID, dId);
        }
        String dSite_id = instance.getSiteId();
        if (dSite_id!= null) {
            sqlBuilder.where(ModelTMlinkUrlInfo.FI_SITE_ID, ColumnDataType.stringData);
            param.put(ModelTMlinkUrlInfo.FI_SITE_ID, dSite_id);
        }
        String dConfig_user = instance.getConfigUser();
        if (dConfig_user!= null) {
            sqlBuilder.where(ModelTMlinkUrlInfo.FI_CONFIG_USER, ColumnDataType.stringData);
            param.put(ModelTMlinkUrlInfo.FI_CONFIG_USER, dConfig_user);
        }
        String dScene = instance.getScene();
        if (dScene!= null) {
            sqlBuilder.where(ModelTMlinkUrlInfo.FI_SCENE, ColumnDataType.stringData);
            param.put(ModelTMlinkUrlInfo.FI_SCENE, dScene);
        }
        String dDivision = instance.getDivision();
        if (dDivision!= null) {
            sqlBuilder.where(ModelTMlinkUrlInfo.FI_DIVISION, ColumnDataType.stringData);
            param.put(ModelTMlinkUrlInfo.FI_DIVISION, dDivision);
        }
        String dLegion = instance.getLegion();
        if (dLegion!= null) {
            sqlBuilder.where(ModelTMlinkUrlInfo.FI_LEGION, ColumnDataType.stringData);
            param.put(ModelTMlinkUrlInfo.FI_LEGION, dLegion);
        }
        String dChannel = instance.getChannel();
        if (dChannel!= null) {
            sqlBuilder.where(ModelTMlinkUrlInfo.FI_CHANNEL, ColumnDataType.stringData);
            param.put(ModelTMlinkUrlInfo.FI_CHANNEL, dChannel);
        }
        String dActivity_name = instance.getActivityName();
        if (dActivity_name!= null) {
            sqlBuilder.where(ModelTMlinkUrlInfo.FI_ACTIVITY_NAME, ColumnDataType.stringData);
            param.put(ModelTMlinkUrlInfo.FI_ACTIVITY_NAME, dActivity_name);
        }
        String dPlan_id = instance.getPlanId();
        if (dPlan_id!= null) {
            sqlBuilder.where(ModelTMlinkUrlInfo.FI_PLAN_ID, ColumnDataType.stringData);
            param.put(ModelTMlinkUrlInfo.FI_PLAN_ID, dPlan_id);
        }
        String dReserve_param1 = instance.getReserveParam1();
        if (dReserve_param1 != null) {
            sqlBuilder.where(ModelTMlinkUrlInfo.FI_RESERVE_PARAM1, ColumnDataType.stringData);
            param.put(ModelTMlinkUrlInfo.FI_RESERVE_PARAM1, dReserve_param1);
        }
        String dReserve_param2 = instance.getReserveParam2();
        if (dReserve_param2 != null) {
            sqlBuilder.where(ModelTMlinkUrlInfo.FI_RESERVE_PARAM2, ColumnDataType.stringData);
            param.put(ModelTMlinkUrlInfo.FI_RESERVE_PARAM2, dReserve_param2);
        }
        String dReserve_param3 = instance.getReserveParam3();
        if (dReserve_param3 != null) {
            sqlBuilder.where(ModelTMlinkUrlInfo.FI_RESERVE_PARAM3, ColumnDataType.stringData);
            param.put(ModelTMlinkUrlInfo.FI_RESERVE_PARAM3, dReserve_param3);
        }
        String dReserve_param4 = instance.getReserveParam4();
        if (dReserve_param4 != null) {
            sqlBuilder.where(ModelTMlinkUrlInfo.FI_RESERVE_PARAM4, ColumnDataType.stringData);
            param.put(ModelTMlinkUrlInfo.FI_RESERVE_PARAM4, dReserve_param4);
        }
        String dReserve_param5 = instance.getReserveParam5();
        if (dReserve_param5 != null) {
            sqlBuilder.where(ModelTMlinkUrlInfo.FI_RESERVE_PARAM5, ColumnDataType.stringData);
            param.put(ModelTMlinkUrlInfo.FI_RESERVE_PARAM5, dReserve_param5);
        }
        String dReserve_param6 = instance.getReserveParam6();
        if (dReserve_param6 != null) {
            sqlBuilder.where(ModelTMlinkUrlInfo.FI_RESERVE_PARAM6, ColumnDataType.stringData);
            param.put(ModelTMlinkUrlInfo.FI_RESERVE_PARAM6, dReserve_param6);
        }
        String dPage_detail = instance.getPageDetail();
        if (dPage_detail!= null) {
            sqlBuilder.where(ModelTMlinkUrlInfo.FI_PAGE_DETAIL, ColumnDataType.stringData);
            param.put(ModelTMlinkUrlInfo.FI_PAGE_DETAIL, dPage_detail);
        }
        String dVideo_type = instance.getVideoType();
        if (dVideo_type!= null) {
            sqlBuilder.where(ModelTMlinkUrlInfo.FI_VIDEO_TYPE, ColumnDataType.stringData);
            param.put(ModelTMlinkUrlInfo.FI_VIDEO_TYPE, dVideo_type);
        }
        String dParam = instance.getParam();
        if (dParam!= null) {
            sqlBuilder.where(ModelTMlinkUrlInfo.FI_PARAM, ColumnDataType.stringData);
            param.put(ModelTMlinkUrlInfo.FI_PARAM, dParam);
        }
        String dVideo_url = instance.getVideoUrl();
        if (dVideo_url!= null) {
            sqlBuilder.where(ModelTMlinkUrlInfo.FI_VIDEO_URL, ColumnDataType.stringData);
            param.put(ModelTMlinkUrlInfo.FI_VIDEO_URL, dVideo_url);
        }
        Date dUpdate_time = instance.getUpdateTime();
        if (dUpdate_time!= null) {
            sqlBuilder.where(ModelTMlinkUrlInfo.FI_UPDATE_TIME, ColumnDataType.timeStampData);
            param.put(ModelTMlinkUrlInfo.FI_UPDATE_TIME, dUpdate_time);
        }
        Date dCreate_time = instance.getCreateTime();
        if (dCreate_time!= null) {
            sqlBuilder.where(ModelTMlinkUrlInfo.FI_CREATE_TIME, ColumnDataType.timeStampData);
            param.put(ModelTMlinkUrlInfo.FI_CREATE_TIME, dCreate_time);
        }
        Integer dSite_flag = instance.getSiteFlag();
        if (dSite_flag!= null) {
            sqlBuilder.where(ModelTMlinkUrlInfo.FI_SITE_FLAG, ColumnDataType.intData);
            param.put(ModelTMlinkUrlInfo.FI_SITE_FLAG, dSite_flag);
        }
        String dSystem = instance.getSystem();
        if (dSystem!= null) {
            sqlBuilder.where(ModelTMlinkUrlInfo.FI_SYSTEM, ColumnDataType.stringData);
            param.put(ModelTMlinkUrlInfo.FI_SYSTEM, dSystem);
        }
        Integer dDelete_flag = instance.getDeleteFlag();
        if (dDelete_flag!= null) {
            sqlBuilder.where(ModelTMlinkUrlInfo.FI_DELETE_FLAG, ColumnDataType.intData);
            param.put(ModelTMlinkUrlInfo.FI_DELETE_FLAG, dDelete_flag);
        }
        String dEncrypted_params = instance.getEncryptedParams();
        if (dEncrypted_params!= null) {
            sqlBuilder.where(ModelTMlinkUrlInfo.FI_ENCRYPTED_PARAMS, ColumnDataType.stringData);
            param.put(ModelTMlinkUrlInfo.FI_ENCRYPTED_PARAMS, dEncrypted_params);
        }
        String dUnique_identifier = instance.getUniqueIdentifier();
        if (dUnique_identifier!= null) {
            sqlBuilder.where(ModelTMlinkUrlInfo.FI_UNIQUE_IDENTIFIER, ColumnDataType.stringData);
            param.put(ModelTMlinkUrlInfo.FI_UNIQUE_IDENTIFIER, dUnique_identifier);
        }
    }

    protected void buildSelectFieldCluase(SQLSelect<SQLSelect> sqlBuilder, Set<String> selectFields) {
        if (selectFields.contains(ModelTMlinkUrlInfo.FI_ID)) {
            sqlBuilder.items(ModelTMlinkUrlInfo.FI_ID);
        }
        if (selectFields.contains(ModelTMlinkUrlInfo.FI_SITE_ID)) {
            sqlBuilder.items(ModelTMlinkUrlInfo.FI_SITE_ID);
        }
        if (selectFields.contains(ModelTMlinkUrlInfo.FI_CONFIG_USER)) {
            sqlBuilder.items(ModelTMlinkUrlInfo.FI_CONFIG_USER);
        }
        if (selectFields.contains(ModelTMlinkUrlInfo.FI_SCENE)) {
            sqlBuilder.items(ModelTMlinkUrlInfo.FI_SCENE);
        }
        if (selectFields.contains(ModelTMlinkUrlInfo.FI_DIVISION)) {
            sqlBuilder.items(ModelTMlinkUrlInfo.FI_DIVISION);
        }
        if (selectFields.contains(ModelTMlinkUrlInfo.FI_LEGION)) {
            sqlBuilder.items(ModelTMlinkUrlInfo.FI_LEGION);
        }
        if (selectFields.contains(ModelTMlinkUrlInfo.FI_CHANNEL)) {
            sqlBuilder.items(ModelTMlinkUrlInfo.FI_CHANNEL);
        }
        if (selectFields.contains(ModelTMlinkUrlInfo.FI_ACTIVITY_NAME)) {
            sqlBuilder.items(ModelTMlinkUrlInfo.FI_ACTIVITY_NAME);
        }
        if (selectFields.contains(ModelTMlinkUrlInfo.FI_PLAN_ID)) {
            sqlBuilder.items(ModelTMlinkUrlInfo.FI_PLAN_ID);
        }
        if (selectFields.contains(ModelTMlinkUrlInfo.FI_RESERVE_PARAM1)) {
            sqlBuilder.items(ModelTMlinkUrlInfo.FI_RESERVE_PARAM1);
        }
        if (selectFields.contains(ModelTMlinkUrlInfo.FI_RESERVE_PARAM2)) {
            sqlBuilder.items(ModelTMlinkUrlInfo.FI_RESERVE_PARAM2);
        }
        if (selectFields.contains(ModelTMlinkUrlInfo.FI_RESERVE_PARAM3)) {
            sqlBuilder.items(ModelTMlinkUrlInfo.FI_RESERVE_PARAM3);
        }
        if (selectFields.contains(ModelTMlinkUrlInfo.FI_RESERVE_PARAM4)) {
            sqlBuilder.items(ModelTMlinkUrlInfo.FI_RESERVE_PARAM4);
        }
        if (selectFields.contains(ModelTMlinkUrlInfo.FI_RESERVE_PARAM5)) {
            sqlBuilder.items(ModelTMlinkUrlInfo.FI_RESERVE_PARAM5);
        }
        if (selectFields.contains(ModelTMlinkUrlInfo.FI_RESERVE_PARAM6)) {
            sqlBuilder.items(ModelTMlinkUrlInfo.FI_RESERVE_PARAM6);
        }
        if (selectFields.contains(ModelTMlinkUrlInfo.FI_PAGE_DETAIL)) {
            sqlBuilder.items(ModelTMlinkUrlInfo.FI_PAGE_DETAIL);
        }
        if (selectFields.contains(ModelTMlinkUrlInfo.FI_VIDEO_TYPE)) {
            sqlBuilder.items(ModelTMlinkUrlInfo.FI_VIDEO_TYPE);
        }
        if (selectFields.contains(ModelTMlinkUrlInfo.FI_PARAM)) {
            sqlBuilder.items(ModelTMlinkUrlInfo.FI_PARAM);
        }
        if (selectFields.contains(ModelTMlinkUrlInfo.FI_VIDEO_URL)) {
            sqlBuilder.items(ModelTMlinkUrlInfo.FI_VIDEO_URL);
        }
        if (selectFields.contains(ModelTMlinkUrlInfo.FI_UPDATE_TIME)) {
            sqlBuilder.items(ModelTMlinkUrlInfo.FI_UPDATE_TIME);
        }
        if (selectFields.contains(ModelTMlinkUrlInfo.FI_CREATE_TIME)) {
            sqlBuilder.items(ModelTMlinkUrlInfo.FI_CREATE_TIME);
        }
        if (selectFields.contains(ModelTMlinkUrlInfo.FI_SITE_FLAG)) {
            sqlBuilder.items(ModelTMlinkUrlInfo.FI_SITE_FLAG);
        }
        if (selectFields.contains(ModelTMlinkUrlInfo.FI_SYSTEM)) {
            sqlBuilder.items(ModelTMlinkUrlInfo.FI_SYSTEM);
        }
        if (selectFields.contains(ModelTMlinkUrlInfo.FI_DELETE_FLAG)) {
            sqlBuilder.items(ModelTMlinkUrlInfo.FI_DELETE_FLAG);
        }
        if (selectFields.contains(ModelTMlinkUrlInfo.FI_ENCRYPTED_PARAMS)) {
            sqlBuilder.items(ModelTMlinkUrlInfo.FI_ENCRYPTED_PARAMS);
        }
        if (selectFields.contains(ModelTMlinkUrlInfo.FI_UNIQUE_IDENTIFIER)) {
            sqlBuilder.items(ModelTMlinkUrlInfo.FI_UNIQUE_IDENTIFIER);
        }
    }

    public List<ModelTMlinkUrlInfo> get(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count) {
        if (selectFields == null) {
            selectFields = ModelTMlinkUrlInfo.FIELD_CLASS.keySet();
        }
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelTMlinkUrlInfo.DTO_TABLE_NAME);
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

    public List<ModelTMlinkUrlInfo> get(Set<String> selectFields, Integer start, Integer count) {
        return get(selectFields, null, start, count);
    }

    public List<ModelTMlinkUrlInfo> get(Integer start, Integer count) {
        return get(null, start, count);
    }

    public List<ModelTMlinkUrlInfo> get() {
        return get(null, null);
    }

    public List<ModelTMlinkUrlInfo> getById(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, List<Integer> id) {
        if (selectFields == null) {
            selectFields = ModelTMlinkUrlInfo.FIELD_CLASS.keySet();
        }
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelTMlinkUrlInfo.DTO_TABLE_NAME);
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
            sqlBuilder.where(LogicalRelationshipType.and, LogicalOpType.in, null, ModelTMlinkUrlInfo.FI_ID, ModelTMlinkUrlInfo.FI_ID, ColumnDataType.intData);
        }
        sqlBuilder.setLimit();
        return getResults(assembler, sqlBuilder, param);
    }

    public List<ModelTMlinkUrlInfo> getById(Set<String> selectFields, Integer start, Integer count, List<Integer> id) {
        return getById(selectFields, null, start, count, id);
    }

    public List<ModelTMlinkUrlInfo> getById(Integer start, Integer count, List<Integer> id) {
        return getById(null, start, count, id);
    }

    public List<ModelTMlinkUrlInfo> getById(List<Integer> id) {
        return getById(null, null, id);
    }

    public List<ModelTMlinkUrlInfo> getByIndex(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, String inField, List indexes) {
        if (selectFields == null) {
            selectFields = ModelTMlinkUrlInfo.FIELD_CLASS.keySet();
        }
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelTMlinkUrlInfo.DTO_TABLE_NAME);
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

    public List<ModelTMlinkUrlInfo> getByIndex(Set<String> selectFields, Integer start, Integer count, String inField, List indexes) {
        return getByIndex(selectFields, null, start, count, inField, indexes);
    }

    public List<ModelTMlinkUrlInfo> getByIndex(Integer start, Integer count, String inField, List indexes) {
        return getByIndex(null, start, count, inField, indexes);
    }

    public List<ModelTMlinkUrlInfo> getByIndex(String inField, List indexes) {
        return getByIndex(null, null, inField, indexes);
    }

    public List<ModelTMlinkUrlInfo> getByCond(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, ModelTMlinkUrlInfo instance) {
        if (selectFields == null) {
            selectFields = ModelTMlinkUrlInfo.FIELD_CLASS.keySet();
        }
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelTMlinkUrlInfo.DTO_TABLE_NAME);
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

    public List<ModelTMlinkUrlInfo> getByCond(Set<String> selectFields, Integer start, Integer count, ModelTMlinkUrlInfo instance) {
        return getByCond(selectFields, null, start, count, instance);
    }

    public List<ModelTMlinkUrlInfo> getByCond(Integer start, Integer count, ModelTMlinkUrlInfo instance) {
        return getByCond(null, start, count, instance);
    }

    public List<ModelTMlinkUrlInfo> getByCond(ModelTMlinkUrlInfo instance) {
        return getByCond(null, null, instance);
    }

    public List<ModelTMlinkUrlInfo> getByWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelTMlinkUrlInfo.FIELD_CLASS.keySet();
        }
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelTMlinkUrlInfo.DTO_TABLE_NAME);
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

    public List<ModelTMlinkUrlInfo> getByWhere(Set<String> selectFields, Integer start, Integer count, Map<String, Object> extParam, Set<String> extCondition) {
        return getByWhere(selectFields, null, start, count, extParam, extCondition);
    }

    public List<ModelTMlinkUrlInfo> getByWhere(Integer start, Integer count, Map<String, Object> extParam, Set<String> extCondition) {
        return getByWhere(null, start, count, extParam, extCondition);
    }

    public List<ModelTMlinkUrlInfo> getByWhere(Map<String, Object> extParam, Set<String> extCondition) {
        return getByWhere(null, null, extParam, extCondition);
    }

    public List<ModelTMlinkUrlInfo> getByCondAndIndex(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, ModelTMlinkUrlInfo instance, String inField, List indexes) {
        if (selectFields == null) {
            selectFields = ModelTMlinkUrlInfo.FIELD_CLASS.keySet();
        }
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelTMlinkUrlInfo.DTO_TABLE_NAME);
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

    public List<ModelTMlinkUrlInfo> getByCondAndIndex(Set<String> selectFields, Integer start, Integer count, ModelTMlinkUrlInfo instance, String inField, List indexes) {
        return getByCondAndIndex(selectFields, null, start, count, instance, inField, indexes);
    }

    public List<ModelTMlinkUrlInfo> getByCondAndIndex(Integer start, Integer count, ModelTMlinkUrlInfo instance, String inField, List indexes) {
        return getByCondAndIndex(null, start, count, instance, inField, indexes);
    }

    public List<ModelTMlinkUrlInfo> getByCondAndIndex(ModelTMlinkUrlInfo instance, String inField, List indexes) {
        return getByCondAndIndex(null, null, instance, inField, indexes);
    }

    public List<ModelTMlinkUrlInfo> getByIdAndWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, Integer id, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelTMlinkUrlInfo.FIELD_CLASS.keySet();
        }
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelTMlinkUrlInfo.DTO_TABLE_NAME);
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
            sqlBuilder.where(LogicalRelationshipType.and, LogicalOpType.in, null, ModelTMlinkUrlInfo.FI_ID, ModelTMlinkUrlInfo.FI_ID, ColumnDataType.intData);
        }
        sqlBuilder.setLimit();
        return getResults(assembler, sqlBuilder, param);
    }

    public List<ModelTMlinkUrlInfo> getByIdAndWhere(Set<String> selectFields, Integer start, Integer count, Integer id, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIdAndWhere(selectFields, null, start, count, id, extParam, extCondition);
    }

    public List<ModelTMlinkUrlInfo> getByIdAndWhere(Integer start, Integer count, Integer id, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIdAndWhere(null, start, count, id, extParam, extCondition);
    }

    public List<ModelTMlinkUrlInfo> getByIdAndWhere(Integer id, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIdAndWhere(null, null, id, extParam, extCondition);
    }

    public List<ModelTMlinkUrlInfo> getByIdAndCondAndWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, ModelTMlinkUrlInfo instance, List<Integer> id, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelTMlinkUrlInfo.FIELD_CLASS.keySet();
        }
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelTMlinkUrlInfo.DTO_TABLE_NAME);
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
            sqlBuilder.where(LogicalRelationshipType.and, LogicalOpType.in, null, ModelTMlinkUrlInfo.FI_ID, ModelTMlinkUrlInfo.FI_ID, ColumnDataType.intData);
        }
        sqlBuilder.setLimit();
        return getResults(assembler, sqlBuilder, param);
    }

    public List<ModelTMlinkUrlInfo> getByIdAndCondAndWhere(Set<String> selectFields, Integer start, Integer count, ModelTMlinkUrlInfo instance, List<Integer> id, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIdAndCondAndWhere(selectFields, null, start, count, instance, id, extParam, extCondition);
    }

    public List<ModelTMlinkUrlInfo> getByIdAndCondAndWhere(Integer start, Integer count, ModelTMlinkUrlInfo instance, List<Integer> id, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIdAndCondAndWhere(null, start, count, instance, id, extParam, extCondition);
    }

    public List<ModelTMlinkUrlInfo> getByIdAndCondAndWhere(ModelTMlinkUrlInfo instance, List<Integer> id, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIdAndCondAndWhere(null, null, instance, id, extParam, extCondition);
    }

    public List<ModelTMlinkUrlInfo> getByIndexAndWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelTMlinkUrlInfo.FIELD_CLASS.keySet();
        }
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelTMlinkUrlInfo.DTO_TABLE_NAME);
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

    public List<ModelTMlinkUrlInfo> getByIndexAndWhere(Set<String> selectFields, Integer start, Integer count, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIndexAndWhere(selectFields, null, start, count, inField, indexes, extParam, extCondition);
    }

    public List<ModelTMlinkUrlInfo> getByIndexAndWhere(Integer start, Integer count, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIndexAndWhere(null, start, count, inField, indexes, extParam, extCondition);
    }

    public List<ModelTMlinkUrlInfo> getByIndexAndWhere(String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIndexAndWhere(null, null, inField, indexes, extParam, extCondition);
    }

    public List<ModelTMlinkUrlInfo> getByCondAndWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, ModelTMlinkUrlInfo instance, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelTMlinkUrlInfo.FIELD_CLASS.keySet();
        }
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelTMlinkUrlInfo.DTO_TABLE_NAME);
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

    public List<ModelTMlinkUrlInfo> getByCondAndWhere(Set<String> selectFields, Integer start, Integer count, ModelTMlinkUrlInfo instance, Map<String, Object> extParam, Set<String> extCondition) {
        return getByCondAndWhere(selectFields, null, start, count, instance, extParam, extCondition);
    }

    public List<ModelTMlinkUrlInfo> getByCondAndWhere(Integer start, Integer count, ModelTMlinkUrlInfo instance, Map<String, Object> extParam, Set<String> extCondition) {
        return getByCondAndWhere(null, start, count, instance, extParam, extCondition);
    }

    public List<ModelTMlinkUrlInfo> getByCondAndWhere(ModelTMlinkUrlInfo instance, Map<String, Object> extParam, Set<String> extCondition) {
        return getByCondAndWhere(null, null, instance, extParam, extCondition);
    }

    public List<ModelTMlinkUrlInfo> getByCondAndIndexAndWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, ModelTMlinkUrlInfo instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelTMlinkUrlInfo.FIELD_CLASS.keySet();
        }
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelTMlinkUrlInfo.DTO_TABLE_NAME);
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

    public List<ModelTMlinkUrlInfo> getByCondAndIndexAndWhere(Set<String> selectFields, Integer start, Integer count, ModelTMlinkUrlInfo instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        return getByCondAndIndexAndWhere(selectFields, null, start, count, instance, inField, indexes, extParam, extCondition);
    }

    public List<ModelTMlinkUrlInfo> getByCondAndIndexAndWhere(Integer start, Integer count, ModelTMlinkUrlInfo instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        return getByCondAndIndexAndWhere(null, start, count, instance, inField, indexes, extParam, extCondition);
    }

    public List<ModelTMlinkUrlInfo> getByCondAndIndexAndWhere(ModelTMlinkUrlInfo instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        return getByCondAndIndexAndWhere(null, null, instance, inField, indexes, extParam, extCondition);
    }

    public ModelTMlinkUrlInfo getOneById(Set<String> selectFields, DaoAssembler assembler, Integer id) {
        if (selectFields == null) {
            selectFields = ModelTMlinkUrlInfo.FIELD_CLASS.keySet();
        }
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelTMlinkUrlInfo.DTO_TABLE_NAME);
        Integer start = 0;
        Integer count = 1;
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        buildSelectFieldCluase(sqlBuilder, selectFields);
        if (id!= null) {
            sqlBuilder.where(ModelTMlinkUrlInfo.FI_ID, ColumnDataType.intData);
        }
        sqlBuilder.setLimit();
        return getResult(assembler, sqlBuilder, param);
    }

    public ModelTMlinkUrlInfo getOneById(Set<String> selectFields, Integer id) {
        return getOneById(selectFields, null, id);
    }

    public ModelTMlinkUrlInfo getOneById(Integer id) {
        return getOneById(null, id);
    }

    public ModelTMlinkUrlInfo getOneByCond(Set<String> selectFields, DaoAssembler assembler, ModelTMlinkUrlInfo instance) {
        if (selectFields == null) {
            selectFields = ModelTMlinkUrlInfo.FIELD_CLASS.keySet();
        }
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelTMlinkUrlInfo.DTO_TABLE_NAME);
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

    public ModelTMlinkUrlInfo getOneByCond(Set<String> selectFields, ModelTMlinkUrlInfo instance) {
        return getOneByCond(selectFields, null, instance);
    }

    public ModelTMlinkUrlInfo getOneByCond(ModelTMlinkUrlInfo instance) {
        return getOneByCond(null, instance);
    }

    public ModelTMlinkUrlInfo getOneByWhere(Set<String> selectFields, DaoAssembler assembler, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelTMlinkUrlInfo.FIELD_CLASS.keySet();
        }
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelTMlinkUrlInfo.DTO_TABLE_NAME);
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

    public ModelTMlinkUrlInfo getOneByWhere(Set<String> selectFields, Map<String, Object> extParam, Set<String> extCondition) {
        return getOneByWhere(selectFields, null, extParam, extCondition);
    }

    public ModelTMlinkUrlInfo getOneByWhere(Map<String, Object> extParam, Set<String> extCondition) {
        return getOneByWhere(null, extParam, extCondition);
    }

    public ModelTMlinkUrlInfo getOneByCondAndWhere(Set<String> selectFields, DaoAssembler assembler, ModelTMlinkUrlInfo instance, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelTMlinkUrlInfo.FIELD_CLASS.keySet();
        }
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelTMlinkUrlInfo.DTO_TABLE_NAME);
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

    public ModelTMlinkUrlInfo getOneByCondAndWhere(Set<String> selectFields, ModelTMlinkUrlInfo instance, Map<String, Object> extParam, Set<String> extCondition) {
        return getOneByCondAndWhere(selectFields, null, instance, extParam, extCondition);
    }

    public ModelTMlinkUrlInfo getOneByCondAndWhere(ModelTMlinkUrlInfo instance, Map<String, Object> extParam, Set<String> extCondition) {
        return getOneByCondAndWhere(null, instance, extParam, extCondition);
    }

    public ModelTMlinkUrlInfo getOneByIdAndCondAndWhere(Set<String> selectFields, DaoAssembler assembler, ModelTMlinkUrlInfo instance, Integer id, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelTMlinkUrlInfo.FIELD_CLASS.keySet();
        }
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelTMlinkUrlInfo.DTO_TABLE_NAME);
        Integer start = 0;
        Integer count = 1;
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        super.buildRawWhere(sqlBuilder, param, extParam, extCondition);
        buildConditionCluase(sqlBuilder, instance, param);
        buildSelectFieldCluase(sqlBuilder, selectFields);
        if (id!= null) {
            sqlBuilder.where(ModelTMlinkUrlInfo.FI_ID, ColumnDataType.intData);
        }
        sqlBuilder.setLimit();
        return getResult(assembler, sqlBuilder, param);
    }

    public ModelTMlinkUrlInfo getOneByIdAndCondAndWhere(Set<String> selectFields, ModelTMlinkUrlInfo instance, Integer id, Map<String, Object> extParam, Set<String> extCondition) {
        return getOneByIdAndCondAndWhere(selectFields, null, instance, id, extParam, extCondition);
    }

    public ModelTMlinkUrlInfo getOneByIdAndCondAndWhere(ModelTMlinkUrlInfo instance, Integer id, Map<String, Object> extParam, Set<String> extCondition) {
        return getOneByIdAndCondAndWhere(null, instance, id, extParam, extCondition);
    }

    public Long getCountByCond(DaoAssembler assembler, ModelTMlinkUrlInfo instance) {
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelTMlinkUrlInfo.DTO_TABLE_NAME);
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

    public Long getCountByCond(ModelTMlinkUrlInfo instance) {
        return getCountByCond(null, instance);
    }

    public Long getCountByCondAndIndex(DaoAssembler assembler, ModelTMlinkUrlInfo instance, String inField, List indexes) {
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelTMlinkUrlInfo.DTO_TABLE_NAME);
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

    public Long getCountByCondAndIndex(ModelTMlinkUrlInfo instance, String inField, List indexes) {
        return getCountByCondAndIndex(null, instance, inField, indexes);
    }

    public Long getCountByCondAndIndexAndWhere(DaoAssembler assembler, ModelTMlinkUrlInfo instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelTMlinkUrlInfo.DTO_TABLE_NAME);
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

    public Long getCountByCondAndIndexAndWhere(ModelTMlinkUrlInfo instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        return getCountByCondAndIndexAndWhere(null, instance, inField, indexes, extParam, extCondition);
    }

    public<TT> TT getItemByIndex(DaoAssembler assembler, String inField, List indexes, Class<TT> tClass, String rawItem) {
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelTMlinkUrlInfo.DTO_TABLE_NAME);
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
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelTMlinkUrlInfo.DTO_TABLE_NAME);
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

    public<TT> TT getItemByCond(DaoAssembler assembler, ModelTMlinkUrlInfo instance, Class<TT> tClass, String rawItem) {
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelTMlinkUrlInfo.DTO_TABLE_NAME);
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

    public<TT extends Object> TT getItemByCond(ModelTMlinkUrlInfo instance, Class<TT> tClass, String rawItem) {
        return getItemByCond(null, instance, tClass, rawItem);
    }

    public<TT> TT getItemByCondAndIndex(DaoAssembler assembler, ModelTMlinkUrlInfo instance, String inField, List indexes, Class<TT> tClass, String rawItem) {
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelTMlinkUrlInfo.DTO_TABLE_NAME);
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

    public<TT extends Object> TT getItemByCondAndIndex(ModelTMlinkUrlInfo instance, String inField, List indexes, Class<TT> tClass, String rawItem) {
        return getItemByCondAndIndex(null, instance, inField, indexes, tClass, rawItem);
    }

    public<TT> TT getItemByCondAndIndexAndWhere(DaoAssembler assembler, ModelTMlinkUrlInfo instance, String inField, List indexes, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelTMlinkUrlInfo.DTO_TABLE_NAME);
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

    public<TT extends Object> TT getItemByCondAndIndexAndWhere(ModelTMlinkUrlInfo instance, String inField, List indexes, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        return getItemByCondAndIndexAndWhere(null, instance, inField, indexes, tClass, rawItem, extParam, extCondition);
    }

    public<TT> List<TT> getItemListByIndex(DaoAssembler assembler, Integer start, Integer count, String inField, List indexes, Class<TT> tClass, String rawItem) {
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelTMlinkUrlInfo.DTO_TABLE_NAME);
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

    public<TT> List<TT> getItemListByCond(DaoAssembler assembler, Integer start, Integer count, ModelTMlinkUrlInfo instance, Class<TT> tClass, String rawItem) {
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelTMlinkUrlInfo.DTO_TABLE_NAME);
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

    public<TT extends Object> List<TT> getItemListByCond(Integer start, Integer count, ModelTMlinkUrlInfo instance, Class<TT> tClass, String rawItem) {
        return getItemListByCond(null, start, count, instance, tClass, rawItem);
    }

    public<TT extends Object> List<TT> getItemListByCond(ModelTMlinkUrlInfo instance, Class<TT> tClass, String rawItem) {
        return getItemListByCond(null, null, instance, tClass, rawItem);
    }

    public<TT> List<TT> getItemListById(DaoAssembler assembler, Integer start, Integer count, Integer id, Class<TT> tClass, String rawItem) {
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelTMlinkUrlInfo.DTO_TABLE_NAME);
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
            sqlBuilder.where(LogicalRelationshipType.and, LogicalOpType.in, null, ModelTMlinkUrlInfo.FI_ID, ModelTMlinkUrlInfo.FI_ID, ColumnDataType.intData);
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
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelTMlinkUrlInfo.DTO_TABLE_NAME);
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
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelTMlinkUrlInfo.DTO_TABLE_NAME);
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

    public<TT> List<TT> getItemListByCondAndWhere(DaoAssembler assembler, Integer start, Integer count, ModelTMlinkUrlInfo instance, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelTMlinkUrlInfo.DTO_TABLE_NAME);
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

    public<TT extends Object> List<TT> getItemListByCondAndWhere(Integer start, Integer count, ModelTMlinkUrlInfo instance, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        return getItemListByCondAndWhere(null, start, count, instance, tClass, rawItem, extParam, extCondition);
    }

    public<TT extends Object> List<TT> getItemListByCondAndWhere(ModelTMlinkUrlInfo instance, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        return getItemListByCondAndWhere(null, null, instance, tClass, rawItem, extParam, extCondition);
    }

    public<TT> List<TT> getItemListByCondAndIndex(DaoAssembler assembler, Integer start, Integer count, ModelTMlinkUrlInfo instance, String inField, List indexes, Class<TT> tClass, String rawItem) {
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelTMlinkUrlInfo.DTO_TABLE_NAME);
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

    public<TT extends Object> List<TT> getItemListByCondAndIndex(Integer start, Integer count, ModelTMlinkUrlInfo instance, String inField, List indexes, Class<TT> tClass, String rawItem) {
        return getItemListByCondAndIndex(null, start, count, instance, inField, indexes, tClass, rawItem);
    }

    public<TT extends Object> List<TT> getItemListByCondAndIndex(ModelTMlinkUrlInfo instance, String inField, List indexes, Class<TT> tClass, String rawItem) {
        return getItemListByCondAndIndex(null, null, instance, inField, indexes, tClass, rawItem);
    }

    public<TT> List<TT> getItemListByIdAndCondAndWhere(DaoAssembler assembler, Integer start, Integer count, ModelTMlinkUrlInfo instance, List<Integer> id, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelTMlinkUrlInfo.DTO_TABLE_NAME);
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
            sqlBuilder.where(LogicalRelationshipType.and, LogicalOpType.in, null, ModelTMlinkUrlInfo.FI_ID, ModelTMlinkUrlInfo.FI_ID, ColumnDataType.intData);
        }
        sqlBuilder.setLimit();
        return ((List<TT> ) getSingleResults(assembler, sqlBuilder, param, tClass));
    }

    public<TT extends Object> List<TT> getItemListByIdAndCondAndWhere(Integer start, Integer count, ModelTMlinkUrlInfo instance, List<Integer> id, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        return getItemListByIdAndCondAndWhere(null, start, count, instance, id, tClass, rawItem, extParam, extCondition);
    }

    public<TT extends Object> List<TT> getItemListByIdAndCondAndWhere(ModelTMlinkUrlInfo instance, List<Integer> id, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        return getItemListByIdAndCondAndWhere(null, null, instance, id, tClass, rawItem, extParam, extCondition);
    }

    public ModelTMlinkUrlInfo insert(ModelTMlinkUrlInfo instance, DaoAssembler assembler) {
        SQLInsert sqlBuilder = SQL.buildInsertSql(ModelTMlinkUrlInfo.DTO_TABLE_NAME);
        Integer dId = instance.getId();
        if (dId!= null) {
            sqlBuilder.items(ModelTMlinkUrlInfo.FI_ID);
        }
        String dSite_id = instance.getSiteId();
        if (dSite_id!= null) {
            sqlBuilder.items(ModelTMlinkUrlInfo.FI_SITE_ID);
        }
        String dConfig_user = instance.getConfigUser();
        if (dConfig_user!= null) {
            sqlBuilder.items(ModelTMlinkUrlInfo.FI_CONFIG_USER);
        }
        String dScene = instance.getScene();
        if (dScene!= null) {
            sqlBuilder.items(ModelTMlinkUrlInfo.FI_SCENE);
        }
        String dDivision = instance.getDivision();
        if (dDivision!= null) {
            sqlBuilder.items(ModelTMlinkUrlInfo.FI_DIVISION);
        }
        String dLegion = instance.getLegion();
        if (dLegion!= null) {
            sqlBuilder.items(ModelTMlinkUrlInfo.FI_LEGION);
        }
        String dChannel = instance.getChannel();
        if (dChannel!= null) {
            sqlBuilder.items(ModelTMlinkUrlInfo.FI_CHANNEL);
        }
        String dActivity_name = instance.getActivityName();
        if (dActivity_name!= null) {
            sqlBuilder.items(ModelTMlinkUrlInfo.FI_ACTIVITY_NAME);
        }
        String dPlan_id = instance.getPlanId();
        if (dPlan_id!= null) {
            sqlBuilder.items(ModelTMlinkUrlInfo.FI_PLAN_ID);
        }
        String dReserve_param1 = instance.getReserveParam1();
        if (dReserve_param1 != null) {
            sqlBuilder.items(ModelTMlinkUrlInfo.FI_RESERVE_PARAM1);
        }
        String dReserve_param2 = instance.getReserveParam2();
        if (dReserve_param2 != null) {
            sqlBuilder.items(ModelTMlinkUrlInfo.FI_RESERVE_PARAM2);
        }
        String dReserve_param3 = instance.getReserveParam3();
        if (dReserve_param3 != null) {
            sqlBuilder.items(ModelTMlinkUrlInfo.FI_RESERVE_PARAM3);
        }
        String dReserve_param4 = instance.getReserveParam4();
        if (dReserve_param4 != null) {
            sqlBuilder.items(ModelTMlinkUrlInfo.FI_RESERVE_PARAM4);
        }
        String dReserve_param5 = instance.getReserveParam5();
        if (dReserve_param5 != null) {
            sqlBuilder.items(ModelTMlinkUrlInfo.FI_RESERVE_PARAM5);
        }
        String dReserve_param6 = instance.getReserveParam6();
        if (dReserve_param6 != null) {
            sqlBuilder.items(ModelTMlinkUrlInfo.FI_RESERVE_PARAM6);
        }
        String dPage_detail = instance.getPageDetail();
        if (dPage_detail!= null) {
            sqlBuilder.items(ModelTMlinkUrlInfo.FI_PAGE_DETAIL);
        }
        String dVideo_type = instance.getVideoType();
        if (dVideo_type!= null) {
            sqlBuilder.items(ModelTMlinkUrlInfo.FI_VIDEO_TYPE);
        }
        String dParam = instance.getParam();
        if (dParam!= null) {
            sqlBuilder.items(ModelTMlinkUrlInfo.FI_PARAM);
        }
        String dVideo_url = instance.getVideoUrl();
        if (dVideo_url!= null) {
            sqlBuilder.items(ModelTMlinkUrlInfo.FI_VIDEO_URL);
        }
        Date dUpdate_time = instance.getUpdateTime();
        if (dUpdate_time!= null) {
            sqlBuilder.items(ModelTMlinkUrlInfo.FI_UPDATE_TIME);
        }
        Date dCreate_time = instance.getCreateTime();
        if (dCreate_time!= null) {
            sqlBuilder.items(ModelTMlinkUrlInfo.FI_CREATE_TIME);
        }
        Integer dSite_flag = instance.getSiteFlag();
        if (dSite_flag!= null) {
            sqlBuilder.items(ModelTMlinkUrlInfo.FI_SITE_FLAG);
        }
        String dSystem = instance.getSystem();
        if (dSystem!= null) {
            sqlBuilder.items(ModelTMlinkUrlInfo.FI_SYSTEM);
        }
        Integer dDelete_flag = instance.getDeleteFlag();
        if (dDelete_flag!= null) {
            sqlBuilder.items(ModelTMlinkUrlInfo.FI_DELETE_FLAG);
        }
        String dEncrypted_params = instance.getEncryptedParams();
        if (dEncrypted_params!= null) {
            sqlBuilder.items(ModelTMlinkUrlInfo.FI_ENCRYPTED_PARAMS);
        }
        String dUnique_identifier = instance.getUniqueIdentifier();
        if (dUnique_identifier!= null) {
            sqlBuilder.items(ModelTMlinkUrlInfo.FI_UNIQUE_IDENTIFIER);
        }
        Map<String, Object> param = ModelTMlinkUrlInfo.MAP_OBJ_MAPPER.toCommonMap(instance);
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

    public ModelTMlinkUrlInfo insert(ModelTMlinkUrlInfo instance) {
        return insert(instance, null);
    }

    public Integer insert(List<ModelTMlinkUrlInfo> instances, Set<String> fields, DaoAssembler assembler) {
        if (fields == null) {
            fields = ModelTMlinkUrlInfo.FIELD_CLASS.keySet();
        }
        SQLInsert sqlBuilder = SQL.buildInsertSql(ModelTMlinkUrlInfo.DTO_TABLE_NAME);
        if (fields.contains(ModelTMlinkUrlInfo.FI_ID)) {
            sqlBuilder.items(ModelTMlinkUrlInfo.FI_ID);
        }
        if (fields.contains(ModelTMlinkUrlInfo.FI_SITE_ID)) {
            sqlBuilder.items(ModelTMlinkUrlInfo.FI_SITE_ID);
        }
        if (fields.contains(ModelTMlinkUrlInfo.FI_CONFIG_USER)) {
            sqlBuilder.items(ModelTMlinkUrlInfo.FI_CONFIG_USER);
        }
        if (fields.contains(ModelTMlinkUrlInfo.FI_SCENE)) {
            sqlBuilder.items(ModelTMlinkUrlInfo.FI_SCENE);
        }
        if (fields.contains(ModelTMlinkUrlInfo.FI_DIVISION)) {
            sqlBuilder.items(ModelTMlinkUrlInfo.FI_DIVISION);
        }
        if (fields.contains(ModelTMlinkUrlInfo.FI_LEGION)) {
            sqlBuilder.items(ModelTMlinkUrlInfo.FI_LEGION);
        }
        if (fields.contains(ModelTMlinkUrlInfo.FI_CHANNEL)) {
            sqlBuilder.items(ModelTMlinkUrlInfo.FI_CHANNEL);
        }
        if (fields.contains(ModelTMlinkUrlInfo.FI_ACTIVITY_NAME)) {
            sqlBuilder.items(ModelTMlinkUrlInfo.FI_ACTIVITY_NAME);
        }
        if (fields.contains(ModelTMlinkUrlInfo.FI_PLAN_ID)) {
            sqlBuilder.items(ModelTMlinkUrlInfo.FI_PLAN_ID);
        }
        if (fields.contains(ModelTMlinkUrlInfo.FI_RESERVE_PARAM1)) {
            sqlBuilder.items(ModelTMlinkUrlInfo.FI_RESERVE_PARAM1);
        }
        if (fields.contains(ModelTMlinkUrlInfo.FI_RESERVE_PARAM2)) {
            sqlBuilder.items(ModelTMlinkUrlInfo.FI_RESERVE_PARAM2);
        }
        if (fields.contains(ModelTMlinkUrlInfo.FI_RESERVE_PARAM3)) {
            sqlBuilder.items(ModelTMlinkUrlInfo.FI_RESERVE_PARAM3);
        }
        if (fields.contains(ModelTMlinkUrlInfo.FI_RESERVE_PARAM4)) {
            sqlBuilder.items(ModelTMlinkUrlInfo.FI_RESERVE_PARAM4);
        }
        if (fields.contains(ModelTMlinkUrlInfo.FI_RESERVE_PARAM5)) {
            sqlBuilder.items(ModelTMlinkUrlInfo.FI_RESERVE_PARAM5);
        }
        if (fields.contains(ModelTMlinkUrlInfo.FI_RESERVE_PARAM6)) {
            sqlBuilder.items(ModelTMlinkUrlInfo.FI_RESERVE_PARAM6);
        }
        if (fields.contains(ModelTMlinkUrlInfo.FI_PAGE_DETAIL)) {
            sqlBuilder.items(ModelTMlinkUrlInfo.FI_PAGE_DETAIL);
        }
        if (fields.contains(ModelTMlinkUrlInfo.FI_VIDEO_TYPE)) {
            sqlBuilder.items(ModelTMlinkUrlInfo.FI_VIDEO_TYPE);
        }
        if (fields.contains(ModelTMlinkUrlInfo.FI_PARAM)) {
            sqlBuilder.items(ModelTMlinkUrlInfo.FI_PARAM);
        }
        if (fields.contains(ModelTMlinkUrlInfo.FI_VIDEO_URL)) {
            sqlBuilder.items(ModelTMlinkUrlInfo.FI_VIDEO_URL);
        }
        if (fields.contains(ModelTMlinkUrlInfo.FI_UPDATE_TIME)) {
            sqlBuilder.items(ModelTMlinkUrlInfo.FI_UPDATE_TIME);
        }
        if (fields.contains(ModelTMlinkUrlInfo.FI_CREATE_TIME)) {
            sqlBuilder.items(ModelTMlinkUrlInfo.FI_CREATE_TIME);
        }
        if (fields.contains(ModelTMlinkUrlInfo.FI_SITE_FLAG)) {
            sqlBuilder.items(ModelTMlinkUrlInfo.FI_SITE_FLAG);
        }
        if (fields.contains(ModelTMlinkUrlInfo.FI_SYSTEM)) {
            sqlBuilder.items(ModelTMlinkUrlInfo.FI_SYSTEM);
        }
        if (fields.contains(ModelTMlinkUrlInfo.FI_DELETE_FLAG)) {
            sqlBuilder.items(ModelTMlinkUrlInfo.FI_DELETE_FLAG);
        }
        if (fields.contains(ModelTMlinkUrlInfo.FI_ENCRYPTED_PARAMS)) {
            sqlBuilder.items(ModelTMlinkUrlInfo.FI_ENCRYPTED_PARAMS);
        }
        if (fields.contains(ModelTMlinkUrlInfo.FI_UNIQUE_IDENTIFIER)) {
            sqlBuilder.items(ModelTMlinkUrlInfo.FI_UNIQUE_IDENTIFIER);
        }
        List<Map<String, Object>> param = CollectionHelper.<Map<String,Object>> newList();
        for (ModelTMlinkUrlInfo instance: instances) {
            Map<String, Object> paramMap = ModelTMlinkUrlInfo.MAP_OBJ_MAPPER.toCommonMap(instance);
            param.add(paramMap);
        }
        SimpleDbInterface dbInstance = data_store;
        String dbToUse = super.selectDb(assembler, sqlBuilder, param);
        if ((dbToUse!= null)&&dbMap.containsKey(dbToUse)) {
            dbInstance = dbMap.get(dbToUse);
        }
        return super.batchInsert(dbInstance, assembler, sqlBuilder, param);
    }

    public Integer insert(List<ModelTMlinkUrlInfo> instances, Set<String> fields) {
        return insert(instances, fields, null);
    }

    public Integer insert(List<ModelTMlinkUrlInfo> instances) {
        return insert(instances, null, null);
    }

    public Integer update(ModelTMlinkUrlInfo instance, Set<String> conditionField, DaoAssembler assembler) {
        SQLUpdate sqlBuilder = SQL.buildUpdateSql(ModelTMlinkUrlInfo.DTO_TABLE_NAME);
        Integer dId = instance.getId();
        if (conditionField.contains(ModelTMlinkUrlInfo.FI_ID)) {
            assert((dId!= null));
            sqlBuilder.where(ModelTMlinkUrlInfo.FI_ID, ColumnDataType.intData);
        } else {
            if (dId!= null) {
                sqlBuilder.items(ModelTMlinkUrlInfo.FI_ID);
            }
        }
        String dSite_id = instance.getSiteId();
        if (conditionField.contains(ModelTMlinkUrlInfo.FI_SITE_ID)) {
            assert((dSite_id!= null));
            sqlBuilder.where(ModelTMlinkUrlInfo.FI_SITE_ID, ColumnDataType.stringData);
        } else {
            if (dSite_id!= null) {
                sqlBuilder.items(ModelTMlinkUrlInfo.FI_SITE_ID);
            }
        }
        String dConfig_user = instance.getConfigUser();
        if (conditionField.contains(ModelTMlinkUrlInfo.FI_CONFIG_USER)) {
            assert((dConfig_user!= null));
            sqlBuilder.where(ModelTMlinkUrlInfo.FI_CONFIG_USER, ColumnDataType.stringData);
        } else {
            if (dConfig_user!= null) {
                sqlBuilder.items(ModelTMlinkUrlInfo.FI_CONFIG_USER);
            }
        }
        String dScene = instance.getScene();
        if (conditionField.contains(ModelTMlinkUrlInfo.FI_SCENE)) {
            assert((dScene!= null));
            sqlBuilder.where(ModelTMlinkUrlInfo.FI_SCENE, ColumnDataType.stringData);
        } else {
            if (dScene!= null) {
                sqlBuilder.items(ModelTMlinkUrlInfo.FI_SCENE);
            }
        }
        String dDivision = instance.getDivision();
        if (conditionField.contains(ModelTMlinkUrlInfo.FI_DIVISION)) {
            assert((dDivision!= null));
            sqlBuilder.where(ModelTMlinkUrlInfo.FI_DIVISION, ColumnDataType.stringData);
        } else {
            if (dDivision!= null) {
                sqlBuilder.items(ModelTMlinkUrlInfo.FI_DIVISION);
            }
        }
        String dLegion = instance.getLegion();
        if (conditionField.contains(ModelTMlinkUrlInfo.FI_LEGION)) {
            assert((dLegion!= null));
            sqlBuilder.where(ModelTMlinkUrlInfo.FI_LEGION, ColumnDataType.stringData);
        } else {
            if (dLegion!= null) {
                sqlBuilder.items(ModelTMlinkUrlInfo.FI_LEGION);
            }
        }
        String dChannel = instance.getChannel();
        if (conditionField.contains(ModelTMlinkUrlInfo.FI_CHANNEL)) {
            assert((dChannel!= null));
            sqlBuilder.where(ModelTMlinkUrlInfo.FI_CHANNEL, ColumnDataType.stringData);
        } else {
            if (dChannel!= null) {
                sqlBuilder.items(ModelTMlinkUrlInfo.FI_CHANNEL);
            }
        }
        String dActivity_name = instance.getActivityName();
        if (conditionField.contains(ModelTMlinkUrlInfo.FI_ACTIVITY_NAME)) {
            assert((dActivity_name!= null));
            sqlBuilder.where(ModelTMlinkUrlInfo.FI_ACTIVITY_NAME, ColumnDataType.stringData);
        } else {
            if (dActivity_name!= null) {
                sqlBuilder.items(ModelTMlinkUrlInfo.FI_ACTIVITY_NAME);
            }
        }
        String dPlan_id = instance.getPlanId();
        if (conditionField.contains(ModelTMlinkUrlInfo.FI_PLAN_ID)) {
            assert((dPlan_id!= null));
            sqlBuilder.where(ModelTMlinkUrlInfo.FI_PLAN_ID, ColumnDataType.stringData);
        } else {
            if (dPlan_id!= null) {
                sqlBuilder.items(ModelTMlinkUrlInfo.FI_PLAN_ID);
            }
        }
        String dReserve_param1 = instance.getReserveParam1();
        if (conditionField.contains(ModelTMlinkUrlInfo.FI_RESERVE_PARAM1)) {
            assert((dReserve_param1 != null));
            sqlBuilder.where(ModelTMlinkUrlInfo.FI_RESERVE_PARAM1, ColumnDataType.stringData);
        } else {
            if (dReserve_param1 != null) {
                sqlBuilder.items(ModelTMlinkUrlInfo.FI_RESERVE_PARAM1);
            }
        }
        String dReserve_param2 = instance.getReserveParam2();
        if (conditionField.contains(ModelTMlinkUrlInfo.FI_RESERVE_PARAM2)) {
            assert((dReserve_param2 != null));
            sqlBuilder.where(ModelTMlinkUrlInfo.FI_RESERVE_PARAM2, ColumnDataType.stringData);
        } else {
            if (dReserve_param2 != null) {
                sqlBuilder.items(ModelTMlinkUrlInfo.FI_RESERVE_PARAM2);
            }
        }
        String dReserve_param3 = instance.getReserveParam3();
        if (conditionField.contains(ModelTMlinkUrlInfo.FI_RESERVE_PARAM3)) {
            assert((dReserve_param3 != null));
            sqlBuilder.where(ModelTMlinkUrlInfo.FI_RESERVE_PARAM3, ColumnDataType.stringData);
        } else {
            if (dReserve_param3 != null) {
                sqlBuilder.items(ModelTMlinkUrlInfo.FI_RESERVE_PARAM3);
            }
        }
        String dReserve_param4 = instance.getReserveParam4();
        if (conditionField.contains(ModelTMlinkUrlInfo.FI_RESERVE_PARAM4)) {
            assert((dReserve_param4 != null));
            sqlBuilder.where(ModelTMlinkUrlInfo.FI_RESERVE_PARAM4, ColumnDataType.stringData);
        } else {
            if (dReserve_param4 != null) {
                sqlBuilder.items(ModelTMlinkUrlInfo.FI_RESERVE_PARAM4);
            }
        }
        String dReserve_param5 = instance.getReserveParam5();
        if (conditionField.contains(ModelTMlinkUrlInfo.FI_RESERVE_PARAM5)) {
            assert((dReserve_param5 != null));
            sqlBuilder.where(ModelTMlinkUrlInfo.FI_RESERVE_PARAM5, ColumnDataType.stringData);
        } else {
            if (dReserve_param5 != null) {
                sqlBuilder.items(ModelTMlinkUrlInfo.FI_RESERVE_PARAM5);
            }
        }
        String dReserve_param6 = instance.getReserveParam6();
        if (conditionField.contains(ModelTMlinkUrlInfo.FI_RESERVE_PARAM6)) {
            assert((dReserve_param6 != null));
            sqlBuilder.where(ModelTMlinkUrlInfo.FI_RESERVE_PARAM6, ColumnDataType.stringData);
        } else {
            if (dReserve_param6 != null) {
                sqlBuilder.items(ModelTMlinkUrlInfo.FI_RESERVE_PARAM6);
            }
        }
        String dPage_detail = instance.getPageDetail();
        if (conditionField.contains(ModelTMlinkUrlInfo.FI_PAGE_DETAIL)) {
            assert((dPage_detail!= null));
            sqlBuilder.where(ModelTMlinkUrlInfo.FI_PAGE_DETAIL, ColumnDataType.stringData);
        } else {
            if (dPage_detail!= null) {
                sqlBuilder.items(ModelTMlinkUrlInfo.FI_PAGE_DETAIL);
            }
        }
        String dVideo_type = instance.getVideoType();
        if (conditionField.contains(ModelTMlinkUrlInfo.FI_VIDEO_TYPE)) {
            assert((dVideo_type!= null));
            sqlBuilder.where(ModelTMlinkUrlInfo.FI_VIDEO_TYPE, ColumnDataType.stringData);
        } else {
            if (dVideo_type!= null) {
                sqlBuilder.items(ModelTMlinkUrlInfo.FI_VIDEO_TYPE);
            }
        }
        String dParam = instance.getParam();
        if (conditionField.contains(ModelTMlinkUrlInfo.FI_PARAM)) {
            assert((dParam!= null));
            sqlBuilder.where(ModelTMlinkUrlInfo.FI_PARAM, ColumnDataType.stringData);
        } else {
            if (dParam!= null) {
                sqlBuilder.items(ModelTMlinkUrlInfo.FI_PARAM);
            }
        }
        String dVideo_url = instance.getVideoUrl();
        if (conditionField.contains(ModelTMlinkUrlInfo.FI_VIDEO_URL)) {
            assert((dVideo_url!= null));
            sqlBuilder.where(ModelTMlinkUrlInfo.FI_VIDEO_URL, ColumnDataType.stringData);
        } else {
            if (dVideo_url!= null) {
                sqlBuilder.items(ModelTMlinkUrlInfo.FI_VIDEO_URL);
            }
        }
        Date dUpdate_time = instance.getUpdateTime();
        if (conditionField.contains(ModelTMlinkUrlInfo.FI_UPDATE_TIME)) {
            assert((dUpdate_time!= null));
            sqlBuilder.where(ModelTMlinkUrlInfo.FI_UPDATE_TIME, ColumnDataType.timeStampData);
        } else {
            if (dUpdate_time!= null) {
                sqlBuilder.items(ModelTMlinkUrlInfo.FI_UPDATE_TIME);
            }
        }
        Date dCreate_time = instance.getCreateTime();
        if (conditionField.contains(ModelTMlinkUrlInfo.FI_CREATE_TIME)) {
            assert((dCreate_time!= null));
            sqlBuilder.where(ModelTMlinkUrlInfo.FI_CREATE_TIME, ColumnDataType.timeStampData);
        } else {
            if (dCreate_time!= null) {
                sqlBuilder.items(ModelTMlinkUrlInfo.FI_CREATE_TIME);
            }
        }
        Integer dSite_flag = instance.getSiteFlag();
        if (conditionField.contains(ModelTMlinkUrlInfo.FI_SITE_FLAG)) {
            assert((dSite_flag!= null));
            sqlBuilder.where(ModelTMlinkUrlInfo.FI_SITE_FLAG, ColumnDataType.intData);
        } else {
            if (dSite_flag!= null) {
                sqlBuilder.items(ModelTMlinkUrlInfo.FI_SITE_FLAG);
            }
        }
        String dSystem = instance.getSystem();
        if (conditionField.contains(ModelTMlinkUrlInfo.FI_SYSTEM)) {
            assert((dSystem!= null));
            sqlBuilder.where(ModelTMlinkUrlInfo.FI_SYSTEM, ColumnDataType.stringData);
        } else {
            if (dSystem!= null) {
                sqlBuilder.items(ModelTMlinkUrlInfo.FI_SYSTEM);
            }
        }
        Integer dDelete_flag = instance.getDeleteFlag();
        if (conditionField.contains(ModelTMlinkUrlInfo.FI_DELETE_FLAG)) {
            assert((dDelete_flag!= null));
            sqlBuilder.where(ModelTMlinkUrlInfo.FI_DELETE_FLAG, ColumnDataType.intData);
        } else {
            if (dDelete_flag!= null) {
                sqlBuilder.items(ModelTMlinkUrlInfo.FI_DELETE_FLAG);
            }
        }
        String dEncrypted_params = instance.getEncryptedParams();
        if (conditionField.contains(ModelTMlinkUrlInfo.FI_ENCRYPTED_PARAMS)) {
            assert((dEncrypted_params!= null));
            sqlBuilder.where(ModelTMlinkUrlInfo.FI_ENCRYPTED_PARAMS, ColumnDataType.stringData);
        } else {
            if (dEncrypted_params!= null) {
                sqlBuilder.items(ModelTMlinkUrlInfo.FI_ENCRYPTED_PARAMS);
            }
        }
        String dUnique_identifier = instance.getUniqueIdentifier();
        if (conditionField.contains(ModelTMlinkUrlInfo.FI_UNIQUE_IDENTIFIER)) {
            assert((dUnique_identifier!= null));
            sqlBuilder.where(ModelTMlinkUrlInfo.FI_UNIQUE_IDENTIFIER, ColumnDataType.stringData);
        } else {
            if (dUnique_identifier!= null) {
                sqlBuilder.items(ModelTMlinkUrlInfo.FI_UNIQUE_IDENTIFIER);
            }
        }
        Map<String, Object> param = ModelTMlinkUrlInfo.MAP_OBJ_MAPPER.toCommonMap(instance);
        SimpleDbInterface dbInstance = data_store;
        String dbToUse = super.selectDb(assembler, sqlBuilder, param);
        if ((dbToUse!= null)&&dbMap.containsKey(dbToUse)) {
            dbInstance = dbMap.get(dbToUse);
        }
        return super.update(dbInstance, assembler, sqlBuilder, param);
    }

    public Integer update(ModelTMlinkUrlInfo instance, Set<String> conditionField) {
        return update(instance, conditionField, null);
    }

    public Integer updateById(ModelTMlinkUrlInfo instance, DaoAssembler assembler) {
        SQLUpdate sqlBuilder = SQL.buildUpdateSql(ModelTMlinkUrlInfo.DTO_TABLE_NAME);
        assert((instance.getId()!= null));
        Integer dId = instance.getId();
        if (dId!= null) {
            sqlBuilder.where(ModelTMlinkUrlInfo.FI_ID, ColumnDataType.intData);
        }
        String dSite_id = instance.getSiteId();
        if (dSite_id!= null) {
            sqlBuilder.items(ModelTMlinkUrlInfo.FI_SITE_ID);
        }
        String dConfig_user = instance.getConfigUser();
        if (dConfig_user!= null) {
            sqlBuilder.items(ModelTMlinkUrlInfo.FI_CONFIG_USER);
        }
        String dScene = instance.getScene();
        if (dScene!= null) {
            sqlBuilder.items(ModelTMlinkUrlInfo.FI_SCENE);
        }
        String dDivision = instance.getDivision();
        if (dDivision!= null) {
            sqlBuilder.items(ModelTMlinkUrlInfo.FI_DIVISION);
        }
        String dLegion = instance.getLegion();
        if (dLegion!= null) {
            sqlBuilder.items(ModelTMlinkUrlInfo.FI_LEGION);
        }
        String dChannel = instance.getChannel();
        if (dChannel!= null) {
            sqlBuilder.items(ModelTMlinkUrlInfo.FI_CHANNEL);
        }
        String dActivity_name = instance.getActivityName();
        if (dActivity_name!= null) {
            sqlBuilder.items(ModelTMlinkUrlInfo.FI_ACTIVITY_NAME);
        }
        String dPlan_id = instance.getPlanId();
        if (dPlan_id!= null) {
            sqlBuilder.items(ModelTMlinkUrlInfo.FI_PLAN_ID);
        }
        String dReserve_param1 = instance.getReserveParam1();
        if (dReserve_param1 != null) {
            sqlBuilder.items(ModelTMlinkUrlInfo.FI_RESERVE_PARAM1);
        }
        String dReserve_param2 = instance.getReserveParam2();
        if (dReserve_param2 != null) {
            sqlBuilder.items(ModelTMlinkUrlInfo.FI_RESERVE_PARAM2);
        }
        String dReserve_param3 = instance.getReserveParam3();
        if (dReserve_param3 != null) {
            sqlBuilder.items(ModelTMlinkUrlInfo.FI_RESERVE_PARAM3);
        }
        String dReserve_param4 = instance.getReserveParam4();
        if (dReserve_param4 != null) {
            sqlBuilder.items(ModelTMlinkUrlInfo.FI_RESERVE_PARAM4);
        }
        String dReserve_param5 = instance.getReserveParam5();
        if (dReserve_param5 != null) {
            sqlBuilder.items(ModelTMlinkUrlInfo.FI_RESERVE_PARAM5);
        }
        String dReserve_param6 = instance.getReserveParam6();
        if (dReserve_param6 != null) {
            sqlBuilder.items(ModelTMlinkUrlInfo.FI_RESERVE_PARAM6);
        }
        String dPage_detail = instance.getPageDetail();
        if (dPage_detail!= null) {
            sqlBuilder.items(ModelTMlinkUrlInfo.FI_PAGE_DETAIL);
        }
        String dVideo_type = instance.getVideoType();
        if (dVideo_type!= null) {
            sqlBuilder.items(ModelTMlinkUrlInfo.FI_VIDEO_TYPE);
        }
        String dParam = instance.getParam();
        if (dParam!= null) {
            sqlBuilder.items(ModelTMlinkUrlInfo.FI_PARAM);
        }
        String dVideo_url = instance.getVideoUrl();
        if (dVideo_url!= null) {
            sqlBuilder.items(ModelTMlinkUrlInfo.FI_VIDEO_URL);
        }
        Date dUpdate_time = instance.getUpdateTime();
        if (dUpdate_time!= null) {
            sqlBuilder.items(ModelTMlinkUrlInfo.FI_UPDATE_TIME);
        }
        Date dCreate_time = instance.getCreateTime();
        if (dCreate_time!= null) {
            sqlBuilder.items(ModelTMlinkUrlInfo.FI_CREATE_TIME);
        }
        Integer dSite_flag = instance.getSiteFlag();
        if (dSite_flag!= null) {
            sqlBuilder.items(ModelTMlinkUrlInfo.FI_SITE_FLAG);
        }
        String dSystem = instance.getSystem();
        if (dSystem!= null) {
            sqlBuilder.items(ModelTMlinkUrlInfo.FI_SYSTEM);
        }
        Integer dDelete_flag = instance.getDeleteFlag();
        if (dDelete_flag!= null) {
            sqlBuilder.items(ModelTMlinkUrlInfo.FI_DELETE_FLAG);
        }
        String dEncrypted_params = instance.getEncryptedParams();
        if (dEncrypted_params!= null) {
            sqlBuilder.items(ModelTMlinkUrlInfo.FI_ENCRYPTED_PARAMS);
        }
        String dUnique_identifier = instance.getUniqueIdentifier();
        if (dUnique_identifier!= null) {
            sqlBuilder.items(ModelTMlinkUrlInfo.FI_UNIQUE_IDENTIFIER);
        }
        Map<String, Object> param = ModelTMlinkUrlInfo.MAP_OBJ_MAPPER.toCommonMap(instance);
        SimpleDbInterface dbInstance = data_store;
        String dbToUse = super.selectDb(assembler, sqlBuilder, param);
        if ((dbToUse!= null)&&dbMap.containsKey(dbToUse)) {
            dbInstance = dbMap.get(dbToUse);
        }
        return super.update(dbInstance, assembler, sqlBuilder, param);
    }

    public Integer updateById(ModelTMlinkUrlInfo instance) {
        return updateById(instance, null);
    }

    public Integer updateByIds(ModelTMlinkUrlInfo instance, Set<Integer> ids, DaoAssembler assembler) {
        SQLUpdate sqlBuilder = SQL.buildUpdateSql(ModelTMlinkUrlInfo.DTO_TABLE_NAME);
        assert(((ids!= null)&&(ids.size()> 0)));
        sqlBuilder.where(LogicalOpType.in, ModelTMlinkUrlInfo.FI_ID, "ids", ColumnDataType.intData);
        instance.setId(null);
        String dSite_id = instance.getSiteId();
        if (dSite_id!= null) {
            sqlBuilder.items(ModelTMlinkUrlInfo.FI_SITE_ID);
        }
        String dConfig_user = instance.getConfigUser();
        if (dConfig_user!= null) {
            sqlBuilder.items(ModelTMlinkUrlInfo.FI_CONFIG_USER);
        }
        String dScene = instance.getScene();
        if (dScene!= null) {
            sqlBuilder.items(ModelTMlinkUrlInfo.FI_SCENE);
        }
        String dDivision = instance.getDivision();
        if (dDivision!= null) {
            sqlBuilder.items(ModelTMlinkUrlInfo.FI_DIVISION);
        }
        String dLegion = instance.getLegion();
        if (dLegion!= null) {
            sqlBuilder.items(ModelTMlinkUrlInfo.FI_LEGION);
        }
        String dChannel = instance.getChannel();
        if (dChannel!= null) {
            sqlBuilder.items(ModelTMlinkUrlInfo.FI_CHANNEL);
        }
        String dActivity_name = instance.getActivityName();
        if (dActivity_name!= null) {
            sqlBuilder.items(ModelTMlinkUrlInfo.FI_ACTIVITY_NAME);
        }
        String dPlan_id = instance.getPlanId();
        if (dPlan_id!= null) {
            sqlBuilder.items(ModelTMlinkUrlInfo.FI_PLAN_ID);
        }
        String dReserve_param1 = instance.getReserveParam1();
        if (dReserve_param1 != null) {
            sqlBuilder.items(ModelTMlinkUrlInfo.FI_RESERVE_PARAM1);
        }
        String dReserve_param2 = instance.getReserveParam2();
        if (dReserve_param2 != null) {
            sqlBuilder.items(ModelTMlinkUrlInfo.FI_RESERVE_PARAM2);
        }
        String dReserve_param3 = instance.getReserveParam3();
        if (dReserve_param3 != null) {
            sqlBuilder.items(ModelTMlinkUrlInfo.FI_RESERVE_PARAM3);
        }
        String dReserve_param4 = instance.getReserveParam4();
        if (dReserve_param4 != null) {
            sqlBuilder.items(ModelTMlinkUrlInfo.FI_RESERVE_PARAM4);
        }
        String dReserve_param5 = instance.getReserveParam5();
        if (dReserve_param5 != null) {
            sqlBuilder.items(ModelTMlinkUrlInfo.FI_RESERVE_PARAM5);
        }
        String dReserve_param6 = instance.getReserveParam6();
        if (dReserve_param6 != null) {
            sqlBuilder.items(ModelTMlinkUrlInfo.FI_RESERVE_PARAM6);
        }
        String dPage_detail = instance.getPageDetail();
        if (dPage_detail!= null) {
            sqlBuilder.items(ModelTMlinkUrlInfo.FI_PAGE_DETAIL);
        }
        String dVideo_type = instance.getVideoType();
        if (dVideo_type!= null) {
            sqlBuilder.items(ModelTMlinkUrlInfo.FI_VIDEO_TYPE);
        }
        String dParam = instance.getParam();
        if (dParam!= null) {
            sqlBuilder.items(ModelTMlinkUrlInfo.FI_PARAM);
        }
        String dVideo_url = instance.getVideoUrl();
        if (dVideo_url!= null) {
            sqlBuilder.items(ModelTMlinkUrlInfo.FI_VIDEO_URL);
        }
        Date dUpdate_time = instance.getUpdateTime();
        if (dUpdate_time!= null) {
            sqlBuilder.items(ModelTMlinkUrlInfo.FI_UPDATE_TIME);
        }
        Date dCreate_time = instance.getCreateTime();
        if (dCreate_time!= null) {
            sqlBuilder.items(ModelTMlinkUrlInfo.FI_CREATE_TIME);
        }
        Integer dSite_flag = instance.getSiteFlag();
        if (dSite_flag!= null) {
            sqlBuilder.items(ModelTMlinkUrlInfo.FI_SITE_FLAG);
        }
        String dSystem = instance.getSystem();
        if (dSystem!= null) {
            sqlBuilder.items(ModelTMlinkUrlInfo.FI_SYSTEM);
        }
        Integer dDelete_flag = instance.getDeleteFlag();
        if (dDelete_flag!= null) {
            sqlBuilder.items(ModelTMlinkUrlInfo.FI_DELETE_FLAG);
        }
        String dEncrypted_params = instance.getEncryptedParams();
        if (dEncrypted_params!= null) {
            sqlBuilder.items(ModelTMlinkUrlInfo.FI_ENCRYPTED_PARAMS);
        }
        String dUnique_identifier = instance.getUniqueIdentifier();
        if (dUnique_identifier!= null) {
            sqlBuilder.items(ModelTMlinkUrlInfo.FI_UNIQUE_IDENTIFIER);
        }
        Map<String, Object> param = ModelTMlinkUrlInfo.MAP_OBJ_MAPPER.toCommonMap(instance);
        param.put("ids", ids);
        SimpleDbInterface dbInstance = data_store;
        String dbToUse = super.selectDb(assembler, sqlBuilder, param);
        if ((dbToUse!= null)&&dbMap.containsKey(dbToUse)) {
            dbInstance = dbMap.get(dbToUse);
        }
        return super.update(dbInstance, assembler, sqlBuilder, param);
    }

    public Integer updateByIds(ModelTMlinkUrlInfo instance, Set<Integer> ids) {
        return updateByIds(instance, ids, null);
    }

    public Integer delete(ModelTMlinkUrlInfo instance, Set<String> conditionField, DaoAssembler assembler) {
        SQLDelete sqlBuilder = SQL.buildDeleteSql(ModelTMlinkUrlInfo.DTO_TABLE_NAME);
        Integer dId = instance.getId();
        if (conditionField.contains(ModelTMlinkUrlInfo.FI_ID)) {
            assert((dId!= null));
            sqlBuilder.where(ModelTMlinkUrlInfo.FI_ID, ColumnDataType.intData);
        }
        String dSite_id = instance.getSiteId();
        if (conditionField.contains(ModelTMlinkUrlInfo.FI_SITE_ID)) {
            assert((dSite_id!= null));
            sqlBuilder.where(ModelTMlinkUrlInfo.FI_SITE_ID, ColumnDataType.stringData);
        }
        String dConfig_user = instance.getConfigUser();
        if (conditionField.contains(ModelTMlinkUrlInfo.FI_CONFIG_USER)) {
            assert((dConfig_user!= null));
            sqlBuilder.where(ModelTMlinkUrlInfo.FI_CONFIG_USER, ColumnDataType.stringData);
        }
        String dScene = instance.getScene();
        if (conditionField.contains(ModelTMlinkUrlInfo.FI_SCENE)) {
            assert((dScene!= null));
            sqlBuilder.where(ModelTMlinkUrlInfo.FI_SCENE, ColumnDataType.stringData);
        }
        String dDivision = instance.getDivision();
        if (conditionField.contains(ModelTMlinkUrlInfo.FI_DIVISION)) {
            assert((dDivision!= null));
            sqlBuilder.where(ModelTMlinkUrlInfo.FI_DIVISION, ColumnDataType.stringData);
        }
        String dLegion = instance.getLegion();
        if (conditionField.contains(ModelTMlinkUrlInfo.FI_LEGION)) {
            assert((dLegion!= null));
            sqlBuilder.where(ModelTMlinkUrlInfo.FI_LEGION, ColumnDataType.stringData);
        }
        String dChannel = instance.getChannel();
        if (conditionField.contains(ModelTMlinkUrlInfo.FI_CHANNEL)) {
            assert((dChannel!= null));
            sqlBuilder.where(ModelTMlinkUrlInfo.FI_CHANNEL, ColumnDataType.stringData);
        }
        String dActivity_name = instance.getActivityName();
        if (conditionField.contains(ModelTMlinkUrlInfo.FI_ACTIVITY_NAME)) {
            assert((dActivity_name!= null));
            sqlBuilder.where(ModelTMlinkUrlInfo.FI_ACTIVITY_NAME, ColumnDataType.stringData);
        }
        String dPlan_id = instance.getPlanId();
        if (conditionField.contains(ModelTMlinkUrlInfo.FI_PLAN_ID)) {
            assert((dPlan_id!= null));
            sqlBuilder.where(ModelTMlinkUrlInfo.FI_PLAN_ID, ColumnDataType.stringData);
        }
        String dReserve_param1 = instance.getReserveParam1();
        if (conditionField.contains(ModelTMlinkUrlInfo.FI_RESERVE_PARAM1)) {
            assert((dReserve_param1 != null));
            sqlBuilder.where(ModelTMlinkUrlInfo.FI_RESERVE_PARAM1, ColumnDataType.stringData);
        }
        String dReserve_param2 = instance.getReserveParam2();
        if (conditionField.contains(ModelTMlinkUrlInfo.FI_RESERVE_PARAM2)) {
            assert((dReserve_param2 != null));
            sqlBuilder.where(ModelTMlinkUrlInfo.FI_RESERVE_PARAM2, ColumnDataType.stringData);
        }
        String dReserve_param3 = instance.getReserveParam3();
        if (conditionField.contains(ModelTMlinkUrlInfo.FI_RESERVE_PARAM3)) {
            assert((dReserve_param3 != null));
            sqlBuilder.where(ModelTMlinkUrlInfo.FI_RESERVE_PARAM3, ColumnDataType.stringData);
        }
        String dReserve_param4 = instance.getReserveParam4();
        if (conditionField.contains(ModelTMlinkUrlInfo.FI_RESERVE_PARAM4)) {
            assert((dReserve_param4 != null));
            sqlBuilder.where(ModelTMlinkUrlInfo.FI_RESERVE_PARAM4, ColumnDataType.stringData);
        }
        String dReserve_param5 = instance.getReserveParam5();
        if (conditionField.contains(ModelTMlinkUrlInfo.FI_RESERVE_PARAM5)) {
            assert((dReserve_param5 != null));
            sqlBuilder.where(ModelTMlinkUrlInfo.FI_RESERVE_PARAM5, ColumnDataType.stringData);
        }
        String dReserve_param6 = instance.getReserveParam6();
        if (conditionField.contains(ModelTMlinkUrlInfo.FI_RESERVE_PARAM6)) {
            assert((dReserve_param6 != null));
            sqlBuilder.where(ModelTMlinkUrlInfo.FI_RESERVE_PARAM6, ColumnDataType.stringData);
        }
        String dPage_detail = instance.getPageDetail();
        if (conditionField.contains(ModelTMlinkUrlInfo.FI_PAGE_DETAIL)) {
            assert((dPage_detail!= null));
            sqlBuilder.where(ModelTMlinkUrlInfo.FI_PAGE_DETAIL, ColumnDataType.stringData);
        }
        String dVideo_type = instance.getVideoType();
        if (conditionField.contains(ModelTMlinkUrlInfo.FI_VIDEO_TYPE)) {
            assert((dVideo_type!= null));
            sqlBuilder.where(ModelTMlinkUrlInfo.FI_VIDEO_TYPE, ColumnDataType.stringData);
        }
        String dParam = instance.getParam();
        if (conditionField.contains(ModelTMlinkUrlInfo.FI_PARAM)) {
            assert((dParam!= null));
            sqlBuilder.where(ModelTMlinkUrlInfo.FI_PARAM, ColumnDataType.stringData);
        }
        String dVideo_url = instance.getVideoUrl();
        if (conditionField.contains(ModelTMlinkUrlInfo.FI_VIDEO_URL)) {
            assert((dVideo_url!= null));
            sqlBuilder.where(ModelTMlinkUrlInfo.FI_VIDEO_URL, ColumnDataType.stringData);
        }
        Date dUpdate_time = instance.getUpdateTime();
        if (conditionField.contains(ModelTMlinkUrlInfo.FI_UPDATE_TIME)) {
            assert((dUpdate_time!= null));
            sqlBuilder.where(ModelTMlinkUrlInfo.FI_UPDATE_TIME, ColumnDataType.timeStampData);
        }
        Date dCreate_time = instance.getCreateTime();
        if (conditionField.contains(ModelTMlinkUrlInfo.FI_CREATE_TIME)) {
            assert((dCreate_time!= null));
            sqlBuilder.where(ModelTMlinkUrlInfo.FI_CREATE_TIME, ColumnDataType.timeStampData);
        }
        Integer dSite_flag = instance.getSiteFlag();
        if (conditionField.contains(ModelTMlinkUrlInfo.FI_SITE_FLAG)) {
            assert((dSite_flag!= null));
            sqlBuilder.where(ModelTMlinkUrlInfo.FI_SITE_FLAG, ColumnDataType.intData);
        }
        String dSystem = instance.getSystem();
        if (conditionField.contains(ModelTMlinkUrlInfo.FI_SYSTEM)) {
            assert((dSystem!= null));
            sqlBuilder.where(ModelTMlinkUrlInfo.FI_SYSTEM, ColumnDataType.stringData);
        }
        Integer dDelete_flag = instance.getDeleteFlag();
        if (conditionField.contains(ModelTMlinkUrlInfo.FI_DELETE_FLAG)) {
            assert((dDelete_flag!= null));
            sqlBuilder.where(ModelTMlinkUrlInfo.FI_DELETE_FLAG, ColumnDataType.intData);
        }
        String dEncrypted_params = instance.getEncryptedParams();
        if (conditionField.contains(ModelTMlinkUrlInfo.FI_ENCRYPTED_PARAMS)) {
            assert((dEncrypted_params!= null));
            sqlBuilder.where(ModelTMlinkUrlInfo.FI_ENCRYPTED_PARAMS, ColumnDataType.stringData);
        }
        String dUnique_identifier = instance.getUniqueIdentifier();
        if (conditionField.contains(ModelTMlinkUrlInfo.FI_UNIQUE_IDENTIFIER)) {
            assert((dUnique_identifier!= null));
            sqlBuilder.where(ModelTMlinkUrlInfo.FI_UNIQUE_IDENTIFIER, ColumnDataType.stringData);
        }
        Map<String, Object> param = ModelTMlinkUrlInfo.MAP_OBJ_MAPPER.toCommonMap(instance);
        SimpleDbInterface dbInstance = data_store;
        String dbToUse = super.selectDb(assembler, sqlBuilder, param);
        if ((dbToUse!= null)&&dbMap.containsKey(dbToUse)) {
            dbInstance = dbMap.get(dbToUse);
        }
        return super.update(dbInstance, assembler, sqlBuilder, param);
    }

    public Integer delete(ModelTMlinkUrlInfo instance, Set<String> conditionField) {
        return delete(instance, conditionField, null);
    }

    public Integer deleteById(Integer id, DaoAssembler assembler) {
        SQLDelete sqlBuilder = SQL.buildDeleteSql(ModelTMlinkUrlInfo.DTO_TABLE_NAME);
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
        SQLDelete sqlBuilder = SQL.buildDeleteSql(ModelTMlinkUrlInfo.DTO_TABLE_NAME);
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
    public ModelTMlinkUrlInfo updateOrInsert(ModelTMlinkUrlInfo instance, Set<String> conditionField, AbstractMultipleDaoAssembler assembler) {
        if (assembler == null) {
            assembler = new BaseMultipleDaoAssembler();
        }
        ModelTMlinkUrlInfo checkInstance = new ModelTMlinkUrlInfo();
        if (conditionField.contains(ModelTMlinkUrlInfo.FI_ID)) {
            checkInstance.setId(instance.getId());
        }
        if (conditionField.contains(ModelTMlinkUrlInfo.FI_SITE_ID)) {
            checkInstance.setSiteId(instance.getSiteId());
        }
        if (conditionField.contains(ModelTMlinkUrlInfo.FI_CONFIG_USER)) {
            checkInstance.setConfigUser(instance.getConfigUser());
        }
        if (conditionField.contains(ModelTMlinkUrlInfo.FI_SCENE)) {
            checkInstance.setScene(instance.getScene());
        }
        if (conditionField.contains(ModelTMlinkUrlInfo.FI_DIVISION)) {
            checkInstance.setDivision(instance.getDivision());
        }
        if (conditionField.contains(ModelTMlinkUrlInfo.FI_LEGION)) {
            checkInstance.setLegion(instance.getLegion());
        }
        if (conditionField.contains(ModelTMlinkUrlInfo.FI_CHANNEL)) {
            checkInstance.setChannel(instance.getChannel());
        }
        if (conditionField.contains(ModelTMlinkUrlInfo.FI_ACTIVITY_NAME)) {
            checkInstance.setActivityName(instance.getActivityName());
        }
        if (conditionField.contains(ModelTMlinkUrlInfo.FI_PLAN_ID)) {
            checkInstance.setPlanId(instance.getPlanId());
        }
        if (conditionField.contains(ModelTMlinkUrlInfo.FI_RESERVE_PARAM1)) {
            checkInstance.setReserveParam1(instance.getReserveParam1());
        }
        if (conditionField.contains(ModelTMlinkUrlInfo.FI_RESERVE_PARAM2)) {
            checkInstance.setReserveParam2(instance.getReserveParam2());
        }
        if (conditionField.contains(ModelTMlinkUrlInfo.FI_RESERVE_PARAM3)) {
            checkInstance.setReserveParam3(instance.getReserveParam3());
        }
        if (conditionField.contains(ModelTMlinkUrlInfo.FI_RESERVE_PARAM4)) {
            checkInstance.setReserveParam4(instance.getReserveParam4());
        }
        if (conditionField.contains(ModelTMlinkUrlInfo.FI_RESERVE_PARAM5)) {
            checkInstance.setReserveParam5(instance.getReserveParam5());
        }
        if (conditionField.contains(ModelTMlinkUrlInfo.FI_RESERVE_PARAM6)) {
            checkInstance.setReserveParam6(instance.getReserveParam6());
        }
        if (conditionField.contains(ModelTMlinkUrlInfo.FI_PAGE_DETAIL)) {
            checkInstance.setPageDetail(instance.getPageDetail());
        }
        if (conditionField.contains(ModelTMlinkUrlInfo.FI_VIDEO_TYPE)) {
            checkInstance.setVideoType(instance.getVideoType());
        }
        if (conditionField.contains(ModelTMlinkUrlInfo.FI_PARAM)) {
            checkInstance.setParam(instance.getParam());
        }
        if (conditionField.contains(ModelTMlinkUrlInfo.FI_VIDEO_URL)) {
            checkInstance.setVideoUrl(instance.getVideoUrl());
        }
        if (conditionField.contains(ModelTMlinkUrlInfo.FI_UPDATE_TIME)) {
            checkInstance.setUpdateTime(instance.getUpdateTime());
        }
        if (conditionField.contains(ModelTMlinkUrlInfo.FI_CREATE_TIME)) {
            checkInstance.setCreateTime(instance.getCreateTime());
        }
        if (conditionField.contains(ModelTMlinkUrlInfo.FI_SITE_FLAG)) {
            checkInstance.setSiteFlag(instance.getSiteFlag());
        }
        if (conditionField.contains(ModelTMlinkUrlInfo.FI_SYSTEM)) {
            checkInstance.setSystem(instance.getSystem());
        }
        if (conditionField.contains(ModelTMlinkUrlInfo.FI_DELETE_FLAG)) {
            checkInstance.setDeleteFlag(instance.getDeleteFlag());
        }
        if (conditionField.contains(ModelTMlinkUrlInfo.FI_ENCRYPTED_PARAMS)) {
            checkInstance.setEncryptedParams(instance.getEncryptedParams());
        }
        if (conditionField.contains(ModelTMlinkUrlInfo.FI_UNIQUE_IDENTIFIER)) {
            checkInstance.setUniqueIdentifier(instance.getUniqueIdentifier());
        }
        ModelTMlinkUrlInfo selected = getOneByCond(Collections.singleton(ModelTMlinkUrlInfo.FI_ID), assembler, checkInstance);
        assembler.increaseIndex();
        if (selected == null) {
            return insert(instance, assembler);
        } else {
            instance.setId(selected.getId());
            update(instance, Collections.singleton(ModelTMlinkUrlInfo.FI_ID), assembler);
            return instance;
        }
    }

    public ModelTMlinkUrlInfo updateOrInsert(ModelTMlinkUrlInfo instance, Set<String> conditionField) {
        return updateOrInsert(instance, conditionField, null);
    }

    @Transactional
    public ModelTMlinkUrlInfo insertIfNoExist(ModelTMlinkUrlInfo instance, Set<String> conditionField, AbstractMultipleDaoAssembler assembler) {
        if (assembler == null) {
            assembler = new BaseMultipleDaoAssembler();
        }
        ModelTMlinkUrlInfo checkInstance = new ModelTMlinkUrlInfo();
        if (conditionField.contains(ModelTMlinkUrlInfo.FI_ID)) {
            checkInstance.setId(instance.getId());
        }
        if (conditionField.contains(ModelTMlinkUrlInfo.FI_SITE_ID)) {
            checkInstance.setSiteId(instance.getSiteId());
        }
        if (conditionField.contains(ModelTMlinkUrlInfo.FI_CONFIG_USER)) {
            checkInstance.setConfigUser(instance.getConfigUser());
        }
        if (conditionField.contains(ModelTMlinkUrlInfo.FI_SCENE)) {
            checkInstance.setScene(instance.getScene());
        }
        if (conditionField.contains(ModelTMlinkUrlInfo.FI_DIVISION)) {
            checkInstance.setDivision(instance.getDivision());
        }
        if (conditionField.contains(ModelTMlinkUrlInfo.FI_LEGION)) {
            checkInstance.setLegion(instance.getLegion());
        }
        if (conditionField.contains(ModelTMlinkUrlInfo.FI_CHANNEL)) {
            checkInstance.setChannel(instance.getChannel());
        }
        if (conditionField.contains(ModelTMlinkUrlInfo.FI_ACTIVITY_NAME)) {
            checkInstance.setActivityName(instance.getActivityName());
        }
        if (conditionField.contains(ModelTMlinkUrlInfo.FI_PLAN_ID)) {
            checkInstance.setPlanId(instance.getPlanId());
        }
        if (conditionField.contains(ModelTMlinkUrlInfo.FI_RESERVE_PARAM1)) {
            checkInstance.setReserveParam1(instance.getReserveParam1());
        }
        if (conditionField.contains(ModelTMlinkUrlInfo.FI_RESERVE_PARAM2)) {
            checkInstance.setReserveParam2(instance.getReserveParam2());
        }
        if (conditionField.contains(ModelTMlinkUrlInfo.FI_RESERVE_PARAM3)) {
            checkInstance.setReserveParam3(instance.getReserveParam3());
        }
        if (conditionField.contains(ModelTMlinkUrlInfo.FI_RESERVE_PARAM4)) {
            checkInstance.setReserveParam4(instance.getReserveParam4());
        }
        if (conditionField.contains(ModelTMlinkUrlInfo.FI_RESERVE_PARAM5)) {
            checkInstance.setReserveParam5(instance.getReserveParam5());
        }
        if (conditionField.contains(ModelTMlinkUrlInfo.FI_RESERVE_PARAM6)) {
            checkInstance.setReserveParam6(instance.getReserveParam6());
        }
        if (conditionField.contains(ModelTMlinkUrlInfo.FI_PAGE_DETAIL)) {
            checkInstance.setPageDetail(instance.getPageDetail());
        }
        if (conditionField.contains(ModelTMlinkUrlInfo.FI_VIDEO_TYPE)) {
            checkInstance.setVideoType(instance.getVideoType());
        }
        if (conditionField.contains(ModelTMlinkUrlInfo.FI_PARAM)) {
            checkInstance.setParam(instance.getParam());
        }
        if (conditionField.contains(ModelTMlinkUrlInfo.FI_VIDEO_URL)) {
            checkInstance.setVideoUrl(instance.getVideoUrl());
        }
        if (conditionField.contains(ModelTMlinkUrlInfo.FI_UPDATE_TIME)) {
            checkInstance.setUpdateTime(instance.getUpdateTime());
        }
        if (conditionField.contains(ModelTMlinkUrlInfo.FI_CREATE_TIME)) {
            checkInstance.setCreateTime(instance.getCreateTime());
        }
        if (conditionField.contains(ModelTMlinkUrlInfo.FI_SITE_FLAG)) {
            checkInstance.setSiteFlag(instance.getSiteFlag());
        }
        if (conditionField.contains(ModelTMlinkUrlInfo.FI_SYSTEM)) {
            checkInstance.setSystem(instance.getSystem());
        }
        if (conditionField.contains(ModelTMlinkUrlInfo.FI_DELETE_FLAG)) {
            checkInstance.setDeleteFlag(instance.getDeleteFlag());
        }
        if (conditionField.contains(ModelTMlinkUrlInfo.FI_ENCRYPTED_PARAMS)) {
            checkInstance.setEncryptedParams(instance.getEncryptedParams());
        }
        if (conditionField.contains(ModelTMlinkUrlInfo.FI_UNIQUE_IDENTIFIER)) {
            checkInstance.setUniqueIdentifier(instance.getUniqueIdentifier());
        }
        ModelTMlinkUrlInfo selected = getOneByCond(Collections.singleton(ModelTMlinkUrlInfo.FI_ID), assembler, checkInstance);
        assembler.increaseIndex();
        if (selected == null) {
            return insert(instance, assembler);
        } else {
            instance.setId(selected.getId());
            return instance;
        }
    }

    public ModelTMlinkUrlInfo insertIfNoExist(ModelTMlinkUrlInfo instance, Set<String> conditionField) {
        return insertIfNoExist(instance, conditionField, null);
    }

    public<TT> Map<TT, ModelTMlinkUrlInfo> buildMap(List<ModelTMlinkUrlInfo> list, String field) {
        Map<TT, ModelTMlinkUrlInfo> ret = CollectionHelper.newMap();
        if (list == null) {
            return ret;
        }
        for (ModelTMlinkUrlInfo item: list) {
            ret.put(ModelTMlinkUrlInfo.MAP_OBJ_MAPPER.<TT> getField(field, item), item);
        }
        return ret;
    }

    public<TT> Map<TT, List<ModelTMlinkUrlInfo>> buildListMap(List<ModelTMlinkUrlInfo> list, String field) {
        Map<TT, List<ModelTMlinkUrlInfo>> ret = CollectionHelper.newMap();
        if (list == null) {
            return ret;
        }
        for (ModelTMlinkUrlInfo item: list) {
            List<ModelTMlinkUrlInfo> itemList = ret.get(ModelTMlinkUrlInfo.MAP_OBJ_MAPPER.<TT> getField(field, item));
            if (itemList == null) {
                itemList = CollectionHelper.newList();
            }
            itemList.add(item);
            ret.put(ModelTMlinkUrlInfo.MAP_OBJ_MAPPER.<TT> getField(field, item), itemList);
        }
        return ret;
    }

    public<TT> List<TT> extractItemAsList(List<ModelTMlinkUrlInfo> list, String field) {
        List<TT> ret = CollectionHelper.newList();
        if ((list == null)||(list.size() == 0)) {
            return ret;
        }
        if (ModelTMlinkUrlInfo.FIELD_CLASS.containsKey(field)) {
            for (ModelTMlinkUrlInfo item: list) {
                ret.add(ModelTMlinkUrlInfo.MAP_OBJ_MAPPER.<TT> getField(field, item));
            }
        }
        return ret;
    }
}
