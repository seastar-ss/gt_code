package com.shangde.ent_portal.logical.dao.basedao;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map;
import java.util.Set;
import com.shangde.ent_portal.logical.contants.Constants;
import com.shangde.ent_portal.logical.dto.enums.EnumDeviceStatusType;
import com.shangde.ent_portal.logical.dto.enums.EnumEventHandlerType;
import com.shangde.ent_portal.logical.dto.enums.EnumEventStatus;
import com.shangde.ent_portal.logical.dto.enums.EnumTaskStatus;
import com.shawn.ss.lib.tools.CollectionHelper;
import com.shawn.ss.lib.tools.TypeConstantHelper;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model.ColumnDataType;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model.LogicalOpType;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model.LogicalRelationshipType;
import com.shawn.ss.lib.tools.db.dto_base.model.AbstractBaseModel;
import com.shawn.ss.lib.tools.db.impl.dao.AbstractDao;
import com.shawn.ss.lib.tools.db.impl.dao.DaoInterface;
import com.shawn.ss.lib.tools.service_assemble.AbstractMultipleDaoAssembler;
import com.shawn.ss.lib.tools.service_assemble.BaseMultipleDaoAssembler;
import com.shawn.ss.lib.tools.service_assemble.DaoAssembler;
import com.shawn.ss.lib.tools.sql_code_gen.api.SQLBuilder;
import com.shawn.ss.lib.tools.sql_code_gen.api.SQLDelete;
import com.shawn.ss.lib.tools.sql_code_gen.api.SQLInsert;
import com.shawn.ss.lib.tools.sql_code_gen.api.SQLSelect;
import com.shawn.ss.lib.tools.sql_code_gen.api.SQLUpdate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.shangde.ent_portal.logical.dto.basepo.ModelTEvent;

@Repository("DAOTEvent")
@SuppressWarnings("unchecked")
public class DAOTEvent
    extends AbstractDao<com.shangde.ent_portal.logical.dto.basepo.ModelTEvent, Integer>
    implements DaoInterface<com.shangde.ent_portal.logical.dto.basepo.ModelTEvent, Integer> , InitializingBean
{
    public final static Logger logger = LoggerFactory.getLogger(DAOTEvent.class);

    public DAOTEvent() {
        super(com.shangde.ent_portal.logical.dto.basepo.ModelTEvent.class, Constants.T_EVENT_RESULT_SET_OBJ_MAPPER);
    }

    @Override
    public void afterPropertiesSet()
        throws Exception
    {
    }

    protected void buildInClause(SQLSelect sqlBuilder, String inField, Map<String, Object> param, List indexes) {
        if (ModelTEvent.FIELD_CLASS.containsKey(inField)) {
            Object fieldClassObj = ModelTEvent.FIELD_CLASS.get(inField);
            super.buildRawInCluase(sqlBuilder, param, inField, fieldClassObj, indexes);
        } else {
            logger.error("field parameter error");
            throw new IllegalArgumentException(((("there is mistake with infield parameter, column "+ inField)+" not found in table ")+ com.shangde.ent_portal.logical.dto.basepo.ModelTEvent.DTO_TABLE_NAME));
        }
    }

    protected void buildConditionCluase(SQLSelect sqlBuilder, ModelTEvent instance, Map<String, Object> param) {
        Integer dId = instance.getId();
        if (dId!= null) {
            sqlBuilder.itemWhere(ModelTEvent.FI_ID, ColumnDataType.intData);
            param.put(ModelTEvent.FI_ID, dId);
        }
        Integer dEvent_device = instance.getEventDevice();
        if (dEvent_device!= null) {
            sqlBuilder.itemWhere(ModelTEvent.FI_EVENT_DEVICE, ColumnDataType.intData);
            param.put(ModelTEvent.FI_EVENT_DEVICE, dEvent_device);
        }
        String dEvent_name = instance.getEventName();
        if (dEvent_name!= null) {
            sqlBuilder.itemWhere(ModelTEvent.FI_EVENT_NAME, ColumnDataType.stringData);
            param.put(ModelTEvent.FI_EVENT_NAME, dEvent_name);
        }
        Date dEvent_time = instance.getEventTime();
        if (dEvent_time!= null) {
            sqlBuilder.itemWhere(ModelTEvent.FI_EVENT_TIME, ColumnDataType.timeStampData);
            param.put(ModelTEvent.FI_EVENT_TIME, dEvent_time);
        }
        EnumEventStatus dEvent_type = instance.getEventType();
        if (dEvent_type!= null) {
            sqlBuilder.itemWhere(ModelTEvent.FI_EVENT_TYPE, ColumnDataType.byteData);
            param.put(ModelTEvent.FI_EVENT_TYPE, dEvent_type.val);
        }
        String dEvent_message = instance.getEventMessage();
        if (dEvent_message!= null) {
            sqlBuilder.itemWhere(ModelTEvent.FI_EVENT_MESSAGE, ColumnDataType.stringData);
            param.put(ModelTEvent.FI_EVENT_MESSAGE, dEvent_message);
        }
        Integer dEvent_task_id = instance.getEventTaskId();
        if (dEvent_task_id!= null) {
            sqlBuilder.itemWhere(ModelTEvent.FI_EVENT_TASK_ID, ColumnDataType.intData);
            param.put(ModelTEvent.FI_EVENT_TASK_ID, dEvent_task_id);
        }
        String dEvent_remark = instance.getEventRemark();
        if (dEvent_remark!= null) {
            sqlBuilder.itemWhere(ModelTEvent.FI_EVENT_REMARK, ColumnDataType.stringData);
            param.put(ModelTEvent.FI_EVENT_REMARK, dEvent_remark);
        }
        Integer dEvent_device_type = instance.getEventDeviceType();
        if (dEvent_device_type!= null) {
            sqlBuilder.itemWhere(ModelTEvent.FI_EVENT_DEVICE_TYPE, ColumnDataType.intData);
            param.put(ModelTEvent.FI_EVENT_DEVICE_TYPE, dEvent_device_type);
        }
        Byte dEvent_device_ability = instance.getEventDeviceAbility();
        if (dEvent_device_ability!= null) {
            sqlBuilder.itemWhere(ModelTEvent.FI_EVENT_DEVICE_ABILITY, ColumnDataType.byteData);
            param.put(ModelTEvent.FI_EVENT_DEVICE_ABILITY, dEvent_device_ability);
        }
        Integer dEvent_action_id = instance.getEventActionId();
        if (dEvent_action_id!= null) {
            sqlBuilder.itemWhere(ModelTEvent.FI_EVENT_ACTION_ID, ColumnDataType.intData);
            param.put(ModelTEvent.FI_EVENT_ACTION_ID, dEvent_action_id);
        }
        Integer dEvent_path_id = instance.getEventPathId();
        if (dEvent_path_id!= null) {
            sqlBuilder.itemWhere(ModelTEvent.FI_EVENT_PATH_ID, ColumnDataType.intData);
            param.put(ModelTEvent.FI_EVENT_PATH_ID, dEvent_path_id);
        }
        EnumTaskStatus dEvent_message_type = instance.getEventMessageType();
        if (dEvent_message_type!= null) {
            sqlBuilder.itemWhere(ModelTEvent.FI_EVENT_MESSAGE_TYPE, ColumnDataType.byteData);
            param.put(ModelTEvent.FI_EVENT_MESSAGE_TYPE, dEvent_message_type.val);
        }
        Long dEvent_guid = instance.getEventGuid();
        if (dEvent_guid!= null) {
            sqlBuilder.itemWhere(ModelTEvent.FI_EVENT_GUID, ColumnDataType.longData);
            param.put(ModelTEvent.FI_EVENT_GUID, dEvent_guid);
        }
        String dParam_test_v1 = instance.getParamTestV1();
        if (dParam_test_v1 != null) {
            sqlBuilder.itemWhere(ModelTEvent.FI_PARAM_TEST_V1, ColumnDataType.stringData);
            param.put(ModelTEvent.FI_PARAM_TEST_V1, dParam_test_v1);
        }
        Integer dParam_test_v2 = instance.getParamTestV2();
        if (dParam_test_v2 != null) {
            sqlBuilder.itemWhere(ModelTEvent.FI_PARAM_TEST_V2, ColumnDataType.intData);
            param.put(ModelTEvent.FI_PARAM_TEST_V2, dParam_test_v2);
        }
        EnumDeviceStatusType dDevice_status = instance.getDeviceStatus();
        if (dDevice_status!= null) {
            sqlBuilder.itemWhere(ModelTEvent.FI_DEVICE_STATUS, ColumnDataType.byteData);
            param.put(ModelTEvent.FI_DEVICE_STATUS, dDevice_status.val);
        }
        String dDevice_error_message = instance.getDeviceErrorMessage();
        if (dDevice_error_message!= null) {
            sqlBuilder.itemWhere(ModelTEvent.FI_DEVICE_ERROR_MESSAGE, ColumnDataType.stringData);
            param.put(ModelTEvent.FI_DEVICE_ERROR_MESSAGE, dDevice_error_message);
        }
        Integer dDevice_arix_x = instance.getDeviceArixX();
        if (dDevice_arix_x!= null) {
            sqlBuilder.itemWhere(ModelTEvent.FI_DEVICE_ARIX_X, ColumnDataType.intData);
            param.put(ModelTEvent.FI_DEVICE_ARIX_X, dDevice_arix_x);
        }
        Integer dDevice_arix_y = instance.getDeviceArixY();
        if (dDevice_arix_y!= null) {
            sqlBuilder.itemWhere(ModelTEvent.FI_DEVICE_ARIX_Y, ColumnDataType.intData);
            param.put(ModelTEvent.FI_DEVICE_ARIX_Y, dDevice_arix_y);
        }
        Integer dDevice_arix_z = instance.getDeviceArixZ();
        if (dDevice_arix_z!= null) {
            sqlBuilder.itemWhere(ModelTEvent.FI_DEVICE_ARIX_Z, ColumnDataType.intData);
            param.put(ModelTEvent.FI_DEVICE_ARIX_Z, dDevice_arix_z);
        }
        Integer dDevice_goods_status = instance.getDeviceGoodsStatus();
        if (dDevice_goods_status!= null) {
            sqlBuilder.itemWhere(ModelTEvent.FI_DEVICE_GOODS_STATUS, ColumnDataType.intData);
            param.put(ModelTEvent.FI_DEVICE_GOODS_STATUS, dDevice_goods_status);
        }
        EnumEventHandlerType dEvent_handler = instance.getEventHandler();
        if (dEvent_handler!= null) {
            sqlBuilder.itemWhere(ModelTEvent.FI_EVENT_HANDLER, ColumnDataType.byteData);
            param.put(ModelTEvent.FI_EVENT_HANDLER, dEvent_handler.val);
        }
    }

    protected void buildSelectFieldCluase(SQLSelect sqlBuilder, Set<String> selectFields) {
        if (selectFields.contains(ModelTEvent.FI_ID)) {
            sqlBuilder.itemCol(ModelTEvent.FI_ID);
        }
        if (selectFields.contains(ModelTEvent.FI_EVENT_DEVICE)) {
            sqlBuilder.itemCol(ModelTEvent.FI_EVENT_DEVICE);
        }
        if (selectFields.contains(ModelTEvent.FI_EVENT_NAME)) {
            sqlBuilder.itemCol(ModelTEvent.FI_EVENT_NAME);
        }
        if (selectFields.contains(ModelTEvent.FI_EVENT_TIME)) {
            sqlBuilder.itemCol(ModelTEvent.FI_EVENT_TIME);
        }
        if (selectFields.contains(ModelTEvent.FI_EVENT_TYPE)) {
            sqlBuilder.itemCol(ModelTEvent.FI_EVENT_TYPE);
        }
        if (selectFields.contains(ModelTEvent.FI_EVENT_MESSAGE)) {
            sqlBuilder.itemCol(ModelTEvent.FI_EVENT_MESSAGE);
        }
        if (selectFields.contains(ModelTEvent.FI_EVENT_TASK_ID)) {
            sqlBuilder.itemCol(ModelTEvent.FI_EVENT_TASK_ID);
        }
        if (selectFields.contains(ModelTEvent.FI_EVENT_REMARK)) {
            sqlBuilder.itemCol(ModelTEvent.FI_EVENT_REMARK);
        }
        if (selectFields.contains(ModelTEvent.FI_EVENT_DEVICE_TYPE)) {
            sqlBuilder.itemCol(ModelTEvent.FI_EVENT_DEVICE_TYPE);
        }
        if (selectFields.contains(ModelTEvent.FI_EVENT_DEVICE_ABILITY)) {
            sqlBuilder.itemCol(ModelTEvent.FI_EVENT_DEVICE_ABILITY);
        }
        if (selectFields.contains(ModelTEvent.FI_EVENT_ACTION_ID)) {
            sqlBuilder.itemCol(ModelTEvent.FI_EVENT_ACTION_ID);
        }
        if (selectFields.contains(ModelTEvent.FI_EVENT_PATH_ID)) {
            sqlBuilder.itemCol(ModelTEvent.FI_EVENT_PATH_ID);
        }
        if (selectFields.contains(ModelTEvent.FI_EVENT_MESSAGE_TYPE)) {
            sqlBuilder.itemCol(ModelTEvent.FI_EVENT_MESSAGE_TYPE);
        }
        if (selectFields.contains(ModelTEvent.FI_EVENT_GUID)) {
            sqlBuilder.itemCol(ModelTEvent.FI_EVENT_GUID);
        }
        if (selectFields.contains(ModelTEvent.FI_PARAM_TEST_V1)) {
            sqlBuilder.itemCol(ModelTEvent.FI_PARAM_TEST_V1);
        }
        if (selectFields.contains(ModelTEvent.FI_PARAM_TEST_V2)) {
            sqlBuilder.itemCol(ModelTEvent.FI_PARAM_TEST_V2);
        }
        if (selectFields.contains(ModelTEvent.FI_DEVICE_STATUS)) {
            sqlBuilder.itemCol(ModelTEvent.FI_DEVICE_STATUS);
        }
        if (selectFields.contains(ModelTEvent.FI_DEVICE_ERROR_MESSAGE)) {
            sqlBuilder.itemCol(ModelTEvent.FI_DEVICE_ERROR_MESSAGE);
        }
        if (selectFields.contains(ModelTEvent.FI_DEVICE_ARIX_X)) {
            sqlBuilder.itemCol(ModelTEvent.FI_DEVICE_ARIX_X);
        }
        if (selectFields.contains(ModelTEvent.FI_DEVICE_ARIX_Y)) {
            sqlBuilder.itemCol(ModelTEvent.FI_DEVICE_ARIX_Y);
        }
        if (selectFields.contains(ModelTEvent.FI_DEVICE_ARIX_Z)) {
            sqlBuilder.itemCol(ModelTEvent.FI_DEVICE_ARIX_Z);
        }
        if (selectFields.contains(ModelTEvent.FI_DEVICE_GOODS_STATUS)) {
            sqlBuilder.itemCol(ModelTEvent.FI_DEVICE_GOODS_STATUS);
        }
        if (selectFields.contains(ModelTEvent.FI_EVENT_HANDLER)) {
            sqlBuilder.itemCol(ModelTEvent.FI_EVENT_HANDLER);
        }
    }

    public List<ModelTEvent> get(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count) {
        if (selectFields == null) {
            selectFields = ModelTEvent.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelTEvent.DTO_TABLE_NAME);
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

    public List<ModelTEvent> get(Set<String> selectFields, Integer start, Integer count) {
        return get(selectFields, null, start, count);
    }

    public List<ModelTEvent> get(Integer start, Integer count) {
        return get(null, start, count);
    }

    public List<ModelTEvent> get() {
        return get(null, null);
    }

    public List<ModelTEvent> getById(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, List<Integer> id) {
        if (selectFields == null) {
            selectFields = ModelTEvent.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelTEvent.DTO_TABLE_NAME);
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
            sqlBuilder.itemWhere(LogicalRelationshipType.and, LogicalOpType.in, null, ModelTEvent.FI_ID, ModelTEvent.FI_ID, ColumnDataType.intData);
            param.put(ModelTEvent.FI_ID, id);
        }
        sqlBuilder.limit();
        return getResults(assembler, sqlBuilder, param);
    }

    public List<ModelTEvent> getById(Set<String> selectFields, Integer start, Integer count, List<Integer> id) {
        return getById(selectFields, null, start, count, id);
    }

    public List<ModelTEvent> getById(Integer start, Integer count, List<Integer> id) {
        return getById(null, start, count, id);
    }

    public List<ModelTEvent> getById(List<Integer> id) {
        return getById(null, null, id);
    }

    public List<ModelTEvent> getByIndex(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, String inField, List indexes) {
        if (selectFields == null) {
            selectFields = ModelTEvent.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelTEvent.DTO_TABLE_NAME);
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

    public List<ModelTEvent> getByIndex(Set<String> selectFields, Integer start, Integer count, String inField, List indexes) {
        return getByIndex(selectFields, null, start, count, inField, indexes);
    }

    public List<ModelTEvent> getByIndex(Integer start, Integer count, String inField, List indexes) {
        return getByIndex(null, start, count, inField, indexes);
    }

    public List<ModelTEvent> getByIndex(String inField, List indexes) {
        return getByIndex(null, null, inField, indexes);
    }

    public List<ModelTEvent> getByCond(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, ModelTEvent instance) {
        if (selectFields == null) {
            selectFields = ModelTEvent.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelTEvent.DTO_TABLE_NAME);
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

    public List<ModelTEvent> getByCond(Set<String> selectFields, Integer start, Integer count, ModelTEvent instance) {
        return getByCond(selectFields, null, start, count, instance);
    }

    public List<ModelTEvent> getByCond(Integer start, Integer count, ModelTEvent instance) {
        return getByCond(null, start, count, instance);
    }

    public List<ModelTEvent> getByCond(ModelTEvent instance) {
        return getByCond(null, null, instance);
    }

    public List<ModelTEvent> getByWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelTEvent.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelTEvent.DTO_TABLE_NAME);
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

    public List<ModelTEvent> getByWhere(Set<String> selectFields, Integer start, Integer count, Map<String, Object> extParam, Set<String> extCondition) {
        return getByWhere(selectFields, null, start, count, extParam, extCondition);
    }

    public List<ModelTEvent> getByWhere(Integer start, Integer count, Map<String, Object> extParam, Set<String> extCondition) {
        return getByWhere(null, start, count, extParam, extCondition);
    }

    public List<ModelTEvent> getByWhere(Map<String, Object> extParam, Set<String> extCondition) {
        return getByWhere(null, null, extParam, extCondition);
    }

    public List<ModelTEvent> getByCondAndIndex(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, ModelTEvent instance, String inField, List indexes) {
        if (selectFields == null) {
            selectFields = ModelTEvent.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelTEvent.DTO_TABLE_NAME);
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

    public List<ModelTEvent> getByCondAndIndex(Set<String> selectFields, Integer start, Integer count, ModelTEvent instance, String inField, List indexes) {
        return getByCondAndIndex(selectFields, null, start, count, instance, inField, indexes);
    }

    public List<ModelTEvent> getByCondAndIndex(Integer start, Integer count, ModelTEvent instance, String inField, List indexes) {
        return getByCondAndIndex(null, start, count, instance, inField, indexes);
    }

    public List<ModelTEvent> getByCondAndIndex(ModelTEvent instance, String inField, List indexes) {
        return getByCondAndIndex(null, null, instance, inField, indexes);
    }

    public List<ModelTEvent> getByIdAndWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, Integer id, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelTEvent.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelTEvent.DTO_TABLE_NAME);
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
            sqlBuilder.itemWhere(LogicalRelationshipType.and, LogicalOpType.in, null, ModelTEvent.FI_ID, ModelTEvent.FI_ID, ColumnDataType.intData);
            param.put(ModelTEvent.FI_ID, id);
        }
        sqlBuilder.limit();
        return getResults(assembler, sqlBuilder, param);
    }

    public List<ModelTEvent> getByIdAndWhere(Set<String> selectFields, Integer start, Integer count, Integer id, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIdAndWhere(selectFields, null, start, count, id, extParam, extCondition);
    }

    public List<ModelTEvent> getByIdAndWhere(Integer start, Integer count, Integer id, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIdAndWhere(null, start, count, id, extParam, extCondition);
    }

    public List<ModelTEvent> getByIdAndWhere(Integer id, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIdAndWhere(null, null, id, extParam, extCondition);
    }

    public List<ModelTEvent> getByIdAndCondAndWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, ModelTEvent instance, List<Integer> id, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelTEvent.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelTEvent.DTO_TABLE_NAME);
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
            sqlBuilder.itemWhere(LogicalRelationshipType.and, LogicalOpType.in, null, ModelTEvent.FI_ID, ModelTEvent.FI_ID, ColumnDataType.intData);
            param.put(ModelTEvent.FI_ID, id);
        }
        sqlBuilder.limit();
        return getResults(assembler, sqlBuilder, param);
    }

    public List<ModelTEvent> getByIdAndCondAndWhere(Set<String> selectFields, Integer start, Integer count, ModelTEvent instance, List<Integer> id, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIdAndCondAndWhere(selectFields, null, start, count, instance, id, extParam, extCondition);
    }

    public List<ModelTEvent> getByIdAndCondAndWhere(Integer start, Integer count, ModelTEvent instance, List<Integer> id, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIdAndCondAndWhere(null, start, count, instance, id, extParam, extCondition);
    }

    public List<ModelTEvent> getByIdAndCondAndWhere(ModelTEvent instance, List<Integer> id, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIdAndCondAndWhere(null, null, instance, id, extParam, extCondition);
    }

    public List<ModelTEvent> getByIndexAndWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelTEvent.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelTEvent.DTO_TABLE_NAME);
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

    public List<ModelTEvent> getByIndexAndWhere(Set<String> selectFields, Integer start, Integer count, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIndexAndWhere(selectFields, null, start, count, inField, indexes, extParam, extCondition);
    }

    public List<ModelTEvent> getByIndexAndWhere(Integer start, Integer count, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIndexAndWhere(null, start, count, inField, indexes, extParam, extCondition);
    }

    public List<ModelTEvent> getByIndexAndWhere(String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIndexAndWhere(null, null, inField, indexes, extParam, extCondition);
    }

    public List<ModelTEvent> getByCondAndWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, ModelTEvent instance, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelTEvent.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelTEvent.DTO_TABLE_NAME);
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

    public List<ModelTEvent> getByCondAndWhere(Set<String> selectFields, Integer start, Integer count, ModelTEvent instance, Map<String, Object> extParam, Set<String> extCondition) {
        return getByCondAndWhere(selectFields, null, start, count, instance, extParam, extCondition);
    }

    public List<ModelTEvent> getByCondAndWhere(Integer start, Integer count, ModelTEvent instance, Map<String, Object> extParam, Set<String> extCondition) {
        return getByCondAndWhere(null, start, count, instance, extParam, extCondition);
    }

    public List<ModelTEvent> getByCondAndWhere(ModelTEvent instance, Map<String, Object> extParam, Set<String> extCondition) {
        return getByCondAndWhere(null, null, instance, extParam, extCondition);
    }

    public List<ModelTEvent> getByCondAndIndexAndWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, ModelTEvent instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelTEvent.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelTEvent.DTO_TABLE_NAME);
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

    public List<ModelTEvent> getByCondAndIndexAndWhere(Set<String> selectFields, Integer start, Integer count, ModelTEvent instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        return getByCondAndIndexAndWhere(selectFields, null, start, count, instance, inField, indexes, extParam, extCondition);
    }

    public List<ModelTEvent> getByCondAndIndexAndWhere(Integer start, Integer count, ModelTEvent instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        return getByCondAndIndexAndWhere(null, start, count, instance, inField, indexes, extParam, extCondition);
    }

    public List<ModelTEvent> getByCondAndIndexAndWhere(ModelTEvent instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        return getByCondAndIndexAndWhere(null, null, instance, inField, indexes, extParam, extCondition);
    }

    public ModelTEvent getOneById(Set<String> selectFields, DaoAssembler assembler, Integer id) {
        if (selectFields == null) {
            selectFields = ModelTEvent.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelTEvent.DTO_TABLE_NAME);
        Integer start = 0;
        Integer count = 1;
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        buildSelectFieldCluase(sqlBuilder, selectFields);
        if (id!= null) {
            sqlBuilder.itemWhere(ModelTEvent.FI_ID, ColumnDataType.intData);
            param.put(ModelTEvent.FI_ID, id);
        }
        sqlBuilder.limit();
        return getResult(assembler, sqlBuilder, param);
    }

    public ModelTEvent getOneById(Set<String> selectFields, Integer id) {
        return getOneById(selectFields, null, id);
    }

    public ModelTEvent getOneById(Integer id) {
        return getOneById(null, id);
    }

    public ModelTEvent getOneByCond(Set<String> selectFields, DaoAssembler assembler, ModelTEvent instance) {
        if (selectFields == null) {
            selectFields = ModelTEvent.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelTEvent.DTO_TABLE_NAME);
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

    public ModelTEvent getOneByCond(Set<String> selectFields, ModelTEvent instance) {
        return getOneByCond(selectFields, null, instance);
    }

    public ModelTEvent getOneByCond(ModelTEvent instance) {
        return getOneByCond(null, instance);
    }

    public ModelTEvent getOneByWhere(Set<String> selectFields, DaoAssembler assembler, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelTEvent.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelTEvent.DTO_TABLE_NAME);
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

    public ModelTEvent getOneByWhere(Set<String> selectFields, Map<String, Object> extParam, Set<String> extCondition) {
        return getOneByWhere(selectFields, null, extParam, extCondition);
    }

    public ModelTEvent getOneByWhere(Map<String, Object> extParam, Set<String> extCondition) {
        return getOneByWhere(null, extParam, extCondition);
    }

    public ModelTEvent getOneByCondAndWhere(Set<String> selectFields, DaoAssembler assembler, ModelTEvent instance, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelTEvent.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelTEvent.DTO_TABLE_NAME);
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

    public ModelTEvent getOneByCondAndWhere(Set<String> selectFields, ModelTEvent instance, Map<String, Object> extParam, Set<String> extCondition) {
        return getOneByCondAndWhere(selectFields, null, instance, extParam, extCondition);
    }

    public ModelTEvent getOneByCondAndWhere(ModelTEvent instance, Map<String, Object> extParam, Set<String> extCondition) {
        return getOneByCondAndWhere(null, instance, extParam, extCondition);
    }

    public ModelTEvent getOneByIdAndCondAndWhere(Set<String> selectFields, DaoAssembler assembler, ModelTEvent instance, Integer id, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelTEvent.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelTEvent.DTO_TABLE_NAME);
        Integer start = 0;
        Integer count = 1;
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        super.buildRawWhere(sqlBuilder, param, extParam, extCondition);
        buildConditionCluase(sqlBuilder, instance, param);
        buildSelectFieldCluase(sqlBuilder, selectFields);
        if (id!= null) {
            sqlBuilder.itemWhere(ModelTEvent.FI_ID, ColumnDataType.intData);
            param.put(ModelTEvent.FI_ID, id);
        }
        sqlBuilder.limit();
        return getResult(assembler, sqlBuilder, param);
    }

    public ModelTEvent getOneByIdAndCondAndWhere(Set<String> selectFields, ModelTEvent instance, Integer id, Map<String, Object> extParam, Set<String> extCondition) {
        return getOneByIdAndCondAndWhere(selectFields, null, instance, id, extParam, extCondition);
    }

    public ModelTEvent getOneByIdAndCondAndWhere(ModelTEvent instance, Integer id, Map<String, Object> extParam, Set<String> extCondition) {
        return getOneByIdAndCondAndWhere(null, instance, id, extParam, extCondition);
    }

    public Long getCountByCond(DaoAssembler assembler, ModelTEvent instance) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelTEvent.DTO_TABLE_NAME);
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

    public Long getCountByCond(ModelTEvent instance) {
        return getCountByCond(null, instance);
    }

    public Long getCountByCondAndIndex(DaoAssembler assembler, ModelTEvent instance, String inField, List indexes) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelTEvent.DTO_TABLE_NAME);
        Integer start = 0;
        Integer count = 1;
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        sqlBuilder.rawSelectItem("count(*)", "count");
        buildConditionCluase(sqlBuilder, instance, param);
        buildInClause(sqlBuilder, inField, param, indexes);
        sqlBuilder.limit();
        return getSingleResult(assembler, sqlBuilder, param, Long.class);
    }

    public Long getCountByCondAndIndex(ModelTEvent instance, String inField, List indexes) {
        return getCountByCondAndIndex(null, instance, inField, indexes);
    }

    public Long getCountByCondAndIndexAndWhere(DaoAssembler assembler, ModelTEvent instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelTEvent.DTO_TABLE_NAME);
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

    public Long getCountByCondAndIndexAndWhere(ModelTEvent instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        return getCountByCondAndIndexAndWhere(null, instance, inField, indexes, extParam, extCondition);
    }

    public<TT> TT getItemByIndex(DaoAssembler assembler, String inField, List indexes, Class<TT> tClass, String rawItem) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelTEvent.DTO_TABLE_NAME);
        Integer start = 0;
        Integer count = 1;
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        throwExceptionIf((tClass!= null));
        throwExceptionIf(((rawItem!= null)&&(rawItem.length()> 0)));
        sqlBuilder.rawSelectItem(rawItem);
        buildInClause(sqlBuilder, inField, param, indexes);
        sqlBuilder.limit();
        return ((TT) getSingleResult(assembler, sqlBuilder, param, tClass));
    }

    public<TT extends Object> TT getItemByIndex(String inField, List indexes, Class<TT> tClass, String rawItem) {
        return getItemByIndex(null, inField, indexes, tClass, rawItem);
    }

    public<TT> TT getItemByWhere(DaoAssembler assembler, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelTEvent.DTO_TABLE_NAME);
        Integer start = 0;
        Integer count = 1;
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        super.buildRawWhere(sqlBuilder, param, extParam, extCondition);
        throwExceptionIf((tClass!= null));
        throwExceptionIf(((rawItem!= null)&&(rawItem.length()> 0)));
        sqlBuilder.rawSelectItem(rawItem);
        sqlBuilder.limit();
        return ((TT) getSingleResult(assembler, sqlBuilder, param, tClass));
    }

    public<TT extends Object> TT getItemByWhere(Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        return getItemByWhere(null, tClass, rawItem, extParam, extCondition);
    }

    public<TT> TT getItemByCond(DaoAssembler assembler, ModelTEvent instance, Class<TT> tClass, String rawItem) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelTEvent.DTO_TABLE_NAME);
        Integer start = 0;
        Integer count = 1;
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        throwExceptionIf((tClass!= null));
        throwExceptionIf(((rawItem!= null)&&(rawItem.length()> 0)));
        sqlBuilder.rawSelectItem(rawItem);
        buildConditionCluase(sqlBuilder, instance, param);
        sqlBuilder.limit();
        return ((TT) getSingleResult(assembler, sqlBuilder, param, tClass));
    }

    public<TT extends Object> TT getItemByCond(ModelTEvent instance, Class<TT> tClass, String rawItem) {
        return getItemByCond(null, instance, tClass, rawItem);
    }

    public<TT> TT getItemByCondAndIndex(DaoAssembler assembler, ModelTEvent instance, String inField, List indexes, Class<TT> tClass, String rawItem) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelTEvent.DTO_TABLE_NAME);
        Integer start = 0;
        Integer count = 1;
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        throwExceptionIf((tClass!= null));
        throwExceptionIf(((rawItem!= null)&&(rawItem.length()> 0)));
        sqlBuilder.rawSelectItem(rawItem);
        buildConditionCluase(sqlBuilder, instance, param);
        buildInClause(sqlBuilder, inField, param, indexes);
        sqlBuilder.limit();
        return ((TT) getSingleResult(assembler, sqlBuilder, param, tClass));
    }

    public<TT extends Object> TT getItemByCondAndIndex(ModelTEvent instance, String inField, List indexes, Class<TT> tClass, String rawItem) {
        return getItemByCondAndIndex(null, instance, inField, indexes, tClass, rawItem);
    }

    public<TT> TT getItemByCondAndIndexAndWhere(DaoAssembler assembler, ModelTEvent instance, String inField, List indexes, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelTEvent.DTO_TABLE_NAME);
        Integer start = 0;
        Integer count = 1;
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        super.buildRawWhere(sqlBuilder, param, extParam, extCondition);
        throwExceptionIf((tClass!= null));
        throwExceptionIf(((rawItem!= null)&&(rawItem.length()> 0)));
        sqlBuilder.rawSelectItem(rawItem);
        buildConditionCluase(sqlBuilder, instance, param);
        buildInClause(sqlBuilder, inField, param, indexes);
        sqlBuilder.limit();
        return ((TT) getSingleResult(assembler, sqlBuilder, param, tClass));
    }

    public<TT extends Object> TT getItemByCondAndIndexAndWhere(ModelTEvent instance, String inField, List indexes, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        return getItemByCondAndIndexAndWhere(null, instance, inField, indexes, tClass, rawItem, extParam, extCondition);
    }

    public<TT> List<TT> getItemListByIndex(DaoAssembler assembler, Integer start, Integer count, String inField, List indexes, Class<TT> tClass, String rawItem) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelTEvent.DTO_TABLE_NAME);
        if (start == null) {
            start = AbstractBaseModel.DEFAULT_START;
        }
        if (count == null) {
            count = AbstractBaseModel.DEFUALT_COUNT;
        }
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        throwExceptionIf((tClass!= null));
        throwExceptionIf(((rawItem!= null)&&(rawItem.length()> 0)));
        sqlBuilder.rawSelectItem(rawItem);
        buildInClause(sqlBuilder, inField, param, indexes);
        sqlBuilder.limit();
        return ((List<TT> ) getSingleResults(assembler, sqlBuilder, param, tClass));
    }

    public<TT extends Object> List<TT> getItemListByIndex(Integer start, Integer count, String inField, List indexes, Class<TT> tClass, String rawItem) {
        return getItemListByIndex(null, start, count, inField, indexes, tClass, rawItem);
    }

    public<TT extends Object> List<TT> getItemListByIndex(String inField, List indexes, Class<TT> tClass, String rawItem) {
        return getItemListByIndex(null, null, inField, indexes, tClass, rawItem);
    }

    public<TT> List<TT> getItemListByCond(DaoAssembler assembler, Integer start, Integer count, ModelTEvent instance, Class<TT> tClass, String rawItem) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelTEvent.DTO_TABLE_NAME);
        if (start == null) {
            start = AbstractBaseModel.DEFAULT_START;
        }
        if (count == null) {
            count = AbstractBaseModel.DEFUALT_COUNT;
        }
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        throwExceptionIf((tClass!= null));
        throwExceptionIf(((rawItem!= null)&&(rawItem.length()> 0)));
        sqlBuilder.rawSelectItem(rawItem);
        buildConditionCluase(sqlBuilder, instance, param);
        sqlBuilder.limit();
        return ((List<TT> ) getSingleResults(assembler, sqlBuilder, param, tClass));
    }

    public<TT extends Object> List<TT> getItemListByCond(Integer start, Integer count, ModelTEvent instance, Class<TT> tClass, String rawItem) {
        return getItemListByCond(null, start, count, instance, tClass, rawItem);
    }

    public<TT extends Object> List<TT> getItemListByCond(ModelTEvent instance, Class<TT> tClass, String rawItem) {
        return getItemListByCond(null, null, instance, tClass, rawItem);
    }

    public<TT> List<TT> getItemListById(DaoAssembler assembler, Integer start, Integer count, Integer id, Class<TT> tClass, String rawItem) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelTEvent.DTO_TABLE_NAME);
        if (start == null) {
            start = AbstractBaseModel.DEFAULT_START;
        }
        if (count == null) {
            count = AbstractBaseModel.DEFUALT_COUNT;
        }
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        throwExceptionIf((tClass!= null));
        throwExceptionIf(((rawItem!= null)&&(rawItem.length()> 0)));
        sqlBuilder.rawSelectItem(rawItem);
        if (id!= null) {
            sqlBuilder.itemWhere(LogicalRelationshipType.and, LogicalOpType.in, null, ModelTEvent.FI_ID, ModelTEvent.FI_ID, ColumnDataType.intData);
            param.put(ModelTEvent.FI_ID, id);
        }
        sqlBuilder.limit();
        return ((List<TT> ) getSingleResults(assembler, sqlBuilder, param, tClass));
    }

    public<TT extends Object> List<TT> getItemListById(Integer start, Integer count, Integer id, Class<TT> tClass, String rawItem) {
        return getItemListById(null, start, count, id, tClass, rawItem);
    }

    public<TT extends Object> List<TT> getItemListById(Integer id, Class<TT> tClass, String rawItem) {
        return getItemListById(null, null, id, tClass, rawItem);
    }

    public<TT> List<TT> getItemListByWhere(DaoAssembler assembler, Integer start, Integer count, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelTEvent.DTO_TABLE_NAME);
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
        throwExceptionIf((tClass!= null));
        throwExceptionIf(((rawItem!= null)&&(rawItem.length()> 0)));
        sqlBuilder.rawSelectItem(rawItem);
        sqlBuilder.limit();
        return ((List<TT> ) getSingleResults(assembler, sqlBuilder, param, tClass));
    }

    public<TT extends Object> List<TT> getItemListByWhere(Integer start, Integer count, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        return getItemListByWhere(null, start, count, tClass, rawItem, extParam, extCondition);
    }

    public<TT extends Object> List<TT> getItemListByWhere(Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        return getItemListByWhere(null, null, tClass, rawItem, extParam, extCondition);
    }

    public<TT> List<TT> getItemListByIndexAndWhere(DaoAssembler assembler, Integer start, Integer count, String inField, List indexes, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelTEvent.DTO_TABLE_NAME);
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
        throwExceptionIf((tClass!= null));
        throwExceptionIf(((rawItem!= null)&&(rawItem.length()> 0)));
        sqlBuilder.rawSelectItem(rawItem);
        buildInClause(sqlBuilder, inField, param, indexes);
        sqlBuilder.limit();
        return ((List<TT> ) getSingleResults(assembler, sqlBuilder, param, tClass));
    }

    public<TT extends Object> List<TT> getItemListByIndexAndWhere(Integer start, Integer count, String inField, List indexes, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        return getItemListByIndexAndWhere(null, start, count, inField, indexes, tClass, rawItem, extParam, extCondition);
    }

    public<TT extends Object> List<TT> getItemListByIndexAndWhere(String inField, List indexes, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        return getItemListByIndexAndWhere(null, null, inField, indexes, tClass, rawItem, extParam, extCondition);
    }

    public<TT> List<TT> getItemListByCondAndWhere(DaoAssembler assembler, Integer start, Integer count, ModelTEvent instance, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelTEvent.DTO_TABLE_NAME);
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
        throwExceptionIf((tClass!= null));
        throwExceptionIf(((rawItem!= null)&&(rawItem.length()> 0)));
        sqlBuilder.rawSelectItem(rawItem);
        buildConditionCluase(sqlBuilder, instance, param);
        sqlBuilder.limit();
        return ((List<TT> ) getSingleResults(assembler, sqlBuilder, param, tClass));
    }

    public<TT extends Object> List<TT> getItemListByCondAndWhere(Integer start, Integer count, ModelTEvent instance, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        return getItemListByCondAndWhere(null, start, count, instance, tClass, rawItem, extParam, extCondition);
    }

    public<TT extends Object> List<TT> getItemListByCondAndWhere(ModelTEvent instance, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        return getItemListByCondAndWhere(null, null, instance, tClass, rawItem, extParam, extCondition);
    }

    public<TT> List<TT> getItemListByCondAndIndex(DaoAssembler assembler, Integer start, Integer count, ModelTEvent instance, String inField, List indexes, Class<TT> tClass, String rawItem) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelTEvent.DTO_TABLE_NAME);
        if (start == null) {
            start = AbstractBaseModel.DEFAULT_START;
        }
        if (count == null) {
            count = AbstractBaseModel.DEFUALT_COUNT;
        }
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        throwExceptionIf((tClass!= null));
        throwExceptionIf(((rawItem!= null)&&(rawItem.length()> 0)));
        sqlBuilder.rawSelectItem(rawItem);
        buildConditionCluase(sqlBuilder, instance, param);
        buildInClause(sqlBuilder, inField, param, indexes);
        sqlBuilder.limit();
        return ((List<TT> ) getSingleResults(assembler, sqlBuilder, param, tClass));
    }

    public<TT extends Object> List<TT> getItemListByCondAndIndex(Integer start, Integer count, ModelTEvent instance, String inField, List indexes, Class<TT> tClass, String rawItem) {
        return getItemListByCondAndIndex(null, start, count, instance, inField, indexes, tClass, rawItem);
    }

    public<TT extends Object> List<TT> getItemListByCondAndIndex(ModelTEvent instance, String inField, List indexes, Class<TT> tClass, String rawItem) {
        return getItemListByCondAndIndex(null, null, instance, inField, indexes, tClass, rawItem);
    }

    public<TT> List<TT> getItemListByIdAndCondAndWhere(DaoAssembler assembler, Integer start, Integer count, ModelTEvent instance, List<Integer> id, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelTEvent.DTO_TABLE_NAME);
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
        throwExceptionIf((tClass!= null));
        throwExceptionIf(((rawItem!= null)&&(rawItem.length()> 0)));
        sqlBuilder.rawSelectItem(rawItem);
        buildConditionCluase(sqlBuilder, instance, param);
        if (id!= null) {
            sqlBuilder.itemWhere(LogicalRelationshipType.and, LogicalOpType.in, null, ModelTEvent.FI_ID, ModelTEvent.FI_ID, ColumnDataType.intData);
            param.put(ModelTEvent.FI_ID, id);
        }
        sqlBuilder.limit();
        return ((List<TT> ) getSingleResults(assembler, sqlBuilder, param, tClass));
    }

    public<TT extends Object> List<TT> getItemListByIdAndCondAndWhere(Integer start, Integer count, ModelTEvent instance, List<Integer> id, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        return getItemListByIdAndCondAndWhere(null, start, count, instance, id, tClass, rawItem, extParam, extCondition);
    }

    public<TT extends Object> List<TT> getItemListByIdAndCondAndWhere(ModelTEvent instance, List<Integer> id, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        return getItemListByIdAndCondAndWhere(null, null, instance, id, tClass, rawItem, extParam, extCondition);
    }

    public ModelTEvent insert(ModelTEvent instance, DaoAssembler assembler) {
        SQLInsert sqlBuilder = SQLBuilder.buildInsertSql();
        sqlBuilder.table(ModelTEvent.DTO_TABLE_NAME);
        Integer dId = instance.getId();
        if (dId!= null) {
            sqlBuilder.itemCol(ModelTEvent.FI_ID);
        }
        Integer dEvent_device = instance.getEventDevice();
        if (dEvent_device!= null) {
            sqlBuilder.itemCol(ModelTEvent.FI_EVENT_DEVICE);
        }
        String dEvent_name = instance.getEventName();
        if (dEvent_name!= null) {
            sqlBuilder.itemCol(ModelTEvent.FI_EVENT_NAME);
        }
        Date dEvent_time = instance.getEventTime();
        if (dEvent_time!= null) {
            sqlBuilder.itemCol(ModelTEvent.FI_EVENT_TIME);
        }
        EnumEventStatus dEvent_type = instance.getEventType();
        if (dEvent_type!= null) {
            sqlBuilder.itemCol(ModelTEvent.FI_EVENT_TYPE);
        }
        String dEvent_message = instance.getEventMessage();
        if (dEvent_message!= null) {
            sqlBuilder.itemCol(ModelTEvent.FI_EVENT_MESSAGE);
        }
        Integer dEvent_task_id = instance.getEventTaskId();
        if (dEvent_task_id!= null) {
            sqlBuilder.itemCol(ModelTEvent.FI_EVENT_TASK_ID);
        }
        String dEvent_remark = instance.getEventRemark();
        if (dEvent_remark!= null) {
            sqlBuilder.itemCol(ModelTEvent.FI_EVENT_REMARK);
        }
        Integer dEvent_device_type = instance.getEventDeviceType();
        if (dEvent_device_type!= null) {
            sqlBuilder.itemCol(ModelTEvent.FI_EVENT_DEVICE_TYPE);
        }
        Byte dEvent_device_ability = instance.getEventDeviceAbility();
        if (dEvent_device_ability!= null) {
            sqlBuilder.itemCol(ModelTEvent.FI_EVENT_DEVICE_ABILITY);
        }
        Integer dEvent_action_id = instance.getEventActionId();
        if (dEvent_action_id!= null) {
            sqlBuilder.itemCol(ModelTEvent.FI_EVENT_ACTION_ID);
        }
        Integer dEvent_path_id = instance.getEventPathId();
        if (dEvent_path_id!= null) {
            sqlBuilder.itemCol(ModelTEvent.FI_EVENT_PATH_ID);
        }
        EnumTaskStatus dEvent_message_type = instance.getEventMessageType();
        if (dEvent_message_type!= null) {
            sqlBuilder.itemCol(ModelTEvent.FI_EVENT_MESSAGE_TYPE);
        }
        Long dEvent_guid = instance.getEventGuid();
        if (dEvent_guid!= null) {
            sqlBuilder.itemCol(ModelTEvent.FI_EVENT_GUID);
        }
        String dParam_test_v1 = instance.getParamTestV1();
        if (dParam_test_v1 != null) {
            sqlBuilder.itemCol(ModelTEvent.FI_PARAM_TEST_V1);
        }
        Integer dParam_test_v2 = instance.getParamTestV2();
        if (dParam_test_v2 != null) {
            sqlBuilder.itemCol(ModelTEvent.FI_PARAM_TEST_V2);
        }
        EnumDeviceStatusType dDevice_status = instance.getDeviceStatus();
        if (dDevice_status!= null) {
            sqlBuilder.itemCol(ModelTEvent.FI_DEVICE_STATUS);
        }
        String dDevice_error_message = instance.getDeviceErrorMessage();
        if (dDevice_error_message!= null) {
            sqlBuilder.itemCol(ModelTEvent.FI_DEVICE_ERROR_MESSAGE);
        }
        Integer dDevice_arix_x = instance.getDeviceArixX();
        if (dDevice_arix_x!= null) {
            sqlBuilder.itemCol(ModelTEvent.FI_DEVICE_ARIX_X);
        }
        Integer dDevice_arix_y = instance.getDeviceArixY();
        if (dDevice_arix_y!= null) {
            sqlBuilder.itemCol(ModelTEvent.FI_DEVICE_ARIX_Y);
        }
        Integer dDevice_arix_z = instance.getDeviceArixZ();
        if (dDevice_arix_z!= null) {
            sqlBuilder.itemCol(ModelTEvent.FI_DEVICE_ARIX_Z);
        }
        Integer dDevice_goods_status = instance.getDeviceGoodsStatus();
        if (dDevice_goods_status!= null) {
            sqlBuilder.itemCol(ModelTEvent.FI_DEVICE_GOODS_STATUS);
        }
        EnumEventHandlerType dEvent_handler = instance.getEventHandler();
        if (dEvent_handler!= null) {
            sqlBuilder.itemCol(ModelTEvent.FI_EVENT_HANDLER);
        }
        Map<String, Object> param = Constants.T_EVENT_MAP_OBJ_MAPPER.toCommonMap(instance);
        Long ret = super.insert(assembler, sqlBuilder, param);
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

    public ModelTEvent insert(ModelTEvent instance) {
        return insert(instance, null);
    }

    public Integer insert(List<ModelTEvent> instances, Set<String> fields, DaoAssembler assembler) {
        if (fields == null) {
            fields = ModelTEvent.FIELD_CLASS.keySet();
        }
        SQLInsert sqlBuilder = SQLBuilder.buildInsertSql();
        sqlBuilder.table(ModelTEvent.DTO_TABLE_NAME);
        if (fields.contains(ModelTEvent.FI_ID)) {
            sqlBuilder.itemCol(ModelTEvent.FI_ID);
        }
        if (fields.contains(ModelTEvent.FI_EVENT_DEVICE)) {
            sqlBuilder.itemCol(ModelTEvent.FI_EVENT_DEVICE);
        }
        if (fields.contains(ModelTEvent.FI_EVENT_NAME)) {
            sqlBuilder.itemCol(ModelTEvent.FI_EVENT_NAME);
        }
        if (fields.contains(ModelTEvent.FI_EVENT_TIME)) {
            sqlBuilder.itemCol(ModelTEvent.FI_EVENT_TIME);
        }
        if (fields.contains(ModelTEvent.FI_EVENT_TYPE)) {
            sqlBuilder.itemCol(ModelTEvent.FI_EVENT_TYPE);
        }
        if (fields.contains(ModelTEvent.FI_EVENT_MESSAGE)) {
            sqlBuilder.itemCol(ModelTEvent.FI_EVENT_MESSAGE);
        }
        if (fields.contains(ModelTEvent.FI_EVENT_TASK_ID)) {
            sqlBuilder.itemCol(ModelTEvent.FI_EVENT_TASK_ID);
        }
        if (fields.contains(ModelTEvent.FI_EVENT_REMARK)) {
            sqlBuilder.itemCol(ModelTEvent.FI_EVENT_REMARK);
        }
        if (fields.contains(ModelTEvent.FI_EVENT_DEVICE_TYPE)) {
            sqlBuilder.itemCol(ModelTEvent.FI_EVENT_DEVICE_TYPE);
        }
        if (fields.contains(ModelTEvent.FI_EVENT_DEVICE_ABILITY)) {
            sqlBuilder.itemCol(ModelTEvent.FI_EVENT_DEVICE_ABILITY);
        }
        if (fields.contains(ModelTEvent.FI_EVENT_ACTION_ID)) {
            sqlBuilder.itemCol(ModelTEvent.FI_EVENT_ACTION_ID);
        }
        if (fields.contains(ModelTEvent.FI_EVENT_PATH_ID)) {
            sqlBuilder.itemCol(ModelTEvent.FI_EVENT_PATH_ID);
        }
        if (fields.contains(ModelTEvent.FI_EVENT_MESSAGE_TYPE)) {
            sqlBuilder.itemCol(ModelTEvent.FI_EVENT_MESSAGE_TYPE);
        }
        if (fields.contains(ModelTEvent.FI_EVENT_GUID)) {
            sqlBuilder.itemCol(ModelTEvent.FI_EVENT_GUID);
        }
        if (fields.contains(ModelTEvent.FI_PARAM_TEST_V1)) {
            sqlBuilder.itemCol(ModelTEvent.FI_PARAM_TEST_V1);
        }
        if (fields.contains(ModelTEvent.FI_PARAM_TEST_V2)) {
            sqlBuilder.itemCol(ModelTEvent.FI_PARAM_TEST_V2);
        }
        if (fields.contains(ModelTEvent.FI_DEVICE_STATUS)) {
            sqlBuilder.itemCol(ModelTEvent.FI_DEVICE_STATUS);
        }
        if (fields.contains(ModelTEvent.FI_DEVICE_ERROR_MESSAGE)) {
            sqlBuilder.itemCol(ModelTEvent.FI_DEVICE_ERROR_MESSAGE);
        }
        if (fields.contains(ModelTEvent.FI_DEVICE_ARIX_X)) {
            sqlBuilder.itemCol(ModelTEvent.FI_DEVICE_ARIX_X);
        }
        if (fields.contains(ModelTEvent.FI_DEVICE_ARIX_Y)) {
            sqlBuilder.itemCol(ModelTEvent.FI_DEVICE_ARIX_Y);
        }
        if (fields.contains(ModelTEvent.FI_DEVICE_ARIX_Z)) {
            sqlBuilder.itemCol(ModelTEvent.FI_DEVICE_ARIX_Z);
        }
        if (fields.contains(ModelTEvent.FI_DEVICE_GOODS_STATUS)) {
            sqlBuilder.itemCol(ModelTEvent.FI_DEVICE_GOODS_STATUS);
        }
        if (fields.contains(ModelTEvent.FI_EVENT_HANDLER)) {
            sqlBuilder.itemCol(ModelTEvent.FI_EVENT_HANDLER);
        }
        List<Map<String, Object>> param = CollectionHelper.<Map<String,Object>> newList();
        for (ModelTEvent instance: instances) {
            Map<String, Object> paramMap = Constants.T_EVENT_MAP_OBJ_MAPPER.toCommonMap(instance);
            param.add(paramMap);
        }
        return super.batchInsert(assembler, sqlBuilder, param);
    }

    public Integer insert(List<ModelTEvent> instances, Set<String> fields) {
        return insert(instances, fields, null);
    }

    public Integer insert(List<ModelTEvent> instances) {
        return insert(instances, null, null);
    }

    public Integer update(ModelTEvent instance, Set<String> conditionField, DaoAssembler assembler) {
        SQLUpdate sqlBuilder = SQLBuilder.buildUpdateSql();
        sqlBuilder.table(ModelTEvent.DTO_TABLE_NAME);
        Integer dId = instance.getId();
        if (conditionField.contains(ModelTEvent.FI_ID)) {
            throwExceptionIf((dId!= null));
            sqlBuilder.itemWhere(ModelTEvent.FI_ID, ColumnDataType.intData);
        } else {
            if (dId!= null) {
                sqlBuilder.itemCol(ModelTEvent.FI_ID);
            }
        }
        Integer dEvent_device = instance.getEventDevice();
        if (conditionField.contains(ModelTEvent.FI_EVENT_DEVICE)) {
            throwExceptionIf((dEvent_device!= null));
            sqlBuilder.itemWhere(ModelTEvent.FI_EVENT_DEVICE, ColumnDataType.intData);
        } else {
            if (dEvent_device!= null) {
                sqlBuilder.itemCol(ModelTEvent.FI_EVENT_DEVICE);
            }
        }
        String dEvent_name = instance.getEventName();
        if (conditionField.contains(ModelTEvent.FI_EVENT_NAME)) {
            throwExceptionIf((dEvent_name!= null));
            sqlBuilder.itemWhere(ModelTEvent.FI_EVENT_NAME, ColumnDataType.stringData);
        } else {
            if (dEvent_name!= null) {
                sqlBuilder.itemCol(ModelTEvent.FI_EVENT_NAME);
            }
        }
        Date dEvent_time = instance.getEventTime();
        if (conditionField.contains(ModelTEvent.FI_EVENT_TIME)) {
            throwExceptionIf((dEvent_time!= null));
            sqlBuilder.itemWhere(ModelTEvent.FI_EVENT_TIME, ColumnDataType.timeStampData);
        } else {
            if (dEvent_time!= null) {
                sqlBuilder.itemCol(ModelTEvent.FI_EVENT_TIME);
            }
        }
        EnumEventStatus dEvent_type = instance.getEventType();
        if (conditionField.contains(ModelTEvent.FI_EVENT_TYPE)) {
            throwExceptionIf((dEvent_type!= null));
            sqlBuilder.itemWhere(ModelTEvent.FI_EVENT_TYPE, ColumnDataType.byteData);
        } else {
            if (dEvent_type!= null) {
                sqlBuilder.itemCol(ModelTEvent.FI_EVENT_TYPE);
            }
        }
        String dEvent_message = instance.getEventMessage();
        if (conditionField.contains(ModelTEvent.FI_EVENT_MESSAGE)) {
            throwExceptionIf((dEvent_message!= null));
            sqlBuilder.itemWhere(ModelTEvent.FI_EVENT_MESSAGE, ColumnDataType.stringData);
        } else {
            if (dEvent_message!= null) {
                sqlBuilder.itemCol(ModelTEvent.FI_EVENT_MESSAGE);
            }
        }
        Integer dEvent_task_id = instance.getEventTaskId();
        if (conditionField.contains(ModelTEvent.FI_EVENT_TASK_ID)) {
            throwExceptionIf((dEvent_task_id!= null));
            sqlBuilder.itemWhere(ModelTEvent.FI_EVENT_TASK_ID, ColumnDataType.intData);
        } else {
            if (dEvent_task_id!= null) {
                sqlBuilder.itemCol(ModelTEvent.FI_EVENT_TASK_ID);
            }
        }
        String dEvent_remark = instance.getEventRemark();
        if (conditionField.contains(ModelTEvent.FI_EVENT_REMARK)) {
            throwExceptionIf((dEvent_remark!= null));
            sqlBuilder.itemWhere(ModelTEvent.FI_EVENT_REMARK, ColumnDataType.stringData);
        } else {
            if (dEvent_remark!= null) {
                sqlBuilder.itemCol(ModelTEvent.FI_EVENT_REMARK);
            }
        }
        Integer dEvent_device_type = instance.getEventDeviceType();
        if (conditionField.contains(ModelTEvent.FI_EVENT_DEVICE_TYPE)) {
            throwExceptionIf((dEvent_device_type!= null));
            sqlBuilder.itemWhere(ModelTEvent.FI_EVENT_DEVICE_TYPE, ColumnDataType.intData);
        } else {
            if (dEvent_device_type!= null) {
                sqlBuilder.itemCol(ModelTEvent.FI_EVENT_DEVICE_TYPE);
            }
        }
        Byte dEvent_device_ability = instance.getEventDeviceAbility();
        if (conditionField.contains(ModelTEvent.FI_EVENT_DEVICE_ABILITY)) {
            throwExceptionIf((dEvent_device_ability!= null));
            sqlBuilder.itemWhere(ModelTEvent.FI_EVENT_DEVICE_ABILITY, ColumnDataType.byteData);
        } else {
            if (dEvent_device_ability!= null) {
                sqlBuilder.itemCol(ModelTEvent.FI_EVENT_DEVICE_ABILITY);
            }
        }
        Integer dEvent_action_id = instance.getEventActionId();
        if (conditionField.contains(ModelTEvent.FI_EVENT_ACTION_ID)) {
            throwExceptionIf((dEvent_action_id!= null));
            sqlBuilder.itemWhere(ModelTEvent.FI_EVENT_ACTION_ID, ColumnDataType.intData);
        } else {
            if (dEvent_action_id!= null) {
                sqlBuilder.itemCol(ModelTEvent.FI_EVENT_ACTION_ID);
            }
        }
        Integer dEvent_path_id = instance.getEventPathId();
        if (conditionField.contains(ModelTEvent.FI_EVENT_PATH_ID)) {
            throwExceptionIf((dEvent_path_id!= null));
            sqlBuilder.itemWhere(ModelTEvent.FI_EVENT_PATH_ID, ColumnDataType.intData);
        } else {
            if (dEvent_path_id!= null) {
                sqlBuilder.itemCol(ModelTEvent.FI_EVENT_PATH_ID);
            }
        }
        EnumTaskStatus dEvent_message_type = instance.getEventMessageType();
        if (conditionField.contains(ModelTEvent.FI_EVENT_MESSAGE_TYPE)) {
            throwExceptionIf((dEvent_message_type!= null));
            sqlBuilder.itemWhere(ModelTEvent.FI_EVENT_MESSAGE_TYPE, ColumnDataType.byteData);
        } else {
            if (dEvent_message_type!= null) {
                sqlBuilder.itemCol(ModelTEvent.FI_EVENT_MESSAGE_TYPE);
            }
        }
        Long dEvent_guid = instance.getEventGuid();
        if (conditionField.contains(ModelTEvent.FI_EVENT_GUID)) {
            throwExceptionIf((dEvent_guid!= null));
            sqlBuilder.itemWhere(ModelTEvent.FI_EVENT_GUID, ColumnDataType.longData);
        } else {
            if (dEvent_guid!= null) {
                sqlBuilder.itemCol(ModelTEvent.FI_EVENT_GUID);
            }
        }
        String dParam_test_v1 = instance.getParamTestV1();
        if (conditionField.contains(ModelTEvent.FI_PARAM_TEST_V1)) {
            throwExceptionIf((dParam_test_v1 != null));
            sqlBuilder.itemWhere(ModelTEvent.FI_PARAM_TEST_V1, ColumnDataType.stringData);
        } else {
            if (dParam_test_v1 != null) {
                sqlBuilder.itemCol(ModelTEvent.FI_PARAM_TEST_V1);
            }
        }
        Integer dParam_test_v2 = instance.getParamTestV2();
        if (conditionField.contains(ModelTEvent.FI_PARAM_TEST_V2)) {
            throwExceptionIf((dParam_test_v2 != null));
            sqlBuilder.itemWhere(ModelTEvent.FI_PARAM_TEST_V2, ColumnDataType.intData);
        } else {
            if (dParam_test_v2 != null) {
                sqlBuilder.itemCol(ModelTEvent.FI_PARAM_TEST_V2);
            }
        }
        EnumDeviceStatusType dDevice_status = instance.getDeviceStatus();
        if (conditionField.contains(ModelTEvent.FI_DEVICE_STATUS)) {
            throwExceptionIf((dDevice_status!= null));
            sqlBuilder.itemWhere(ModelTEvent.FI_DEVICE_STATUS, ColumnDataType.byteData);
        } else {
            if (dDevice_status!= null) {
                sqlBuilder.itemCol(ModelTEvent.FI_DEVICE_STATUS);
            }
        }
        String dDevice_error_message = instance.getDeviceErrorMessage();
        if (conditionField.contains(ModelTEvent.FI_DEVICE_ERROR_MESSAGE)) {
            throwExceptionIf((dDevice_error_message!= null));
            sqlBuilder.itemWhere(ModelTEvent.FI_DEVICE_ERROR_MESSAGE, ColumnDataType.stringData);
        } else {
            if (dDevice_error_message!= null) {
                sqlBuilder.itemCol(ModelTEvent.FI_DEVICE_ERROR_MESSAGE);
            }
        }
        Integer dDevice_arix_x = instance.getDeviceArixX();
        if (conditionField.contains(ModelTEvent.FI_DEVICE_ARIX_X)) {
            throwExceptionIf((dDevice_arix_x!= null));
            sqlBuilder.itemWhere(ModelTEvent.FI_DEVICE_ARIX_X, ColumnDataType.intData);
        } else {
            if (dDevice_arix_x!= null) {
                sqlBuilder.itemCol(ModelTEvent.FI_DEVICE_ARIX_X);
            }
        }
        Integer dDevice_arix_y = instance.getDeviceArixY();
        if (conditionField.contains(ModelTEvent.FI_DEVICE_ARIX_Y)) {
            throwExceptionIf((dDevice_arix_y!= null));
            sqlBuilder.itemWhere(ModelTEvent.FI_DEVICE_ARIX_Y, ColumnDataType.intData);
        } else {
            if (dDevice_arix_y!= null) {
                sqlBuilder.itemCol(ModelTEvent.FI_DEVICE_ARIX_Y);
            }
        }
        Integer dDevice_arix_z = instance.getDeviceArixZ();
        if (conditionField.contains(ModelTEvent.FI_DEVICE_ARIX_Z)) {
            throwExceptionIf((dDevice_arix_z!= null));
            sqlBuilder.itemWhere(ModelTEvent.FI_DEVICE_ARIX_Z, ColumnDataType.intData);
        } else {
            if (dDevice_arix_z!= null) {
                sqlBuilder.itemCol(ModelTEvent.FI_DEVICE_ARIX_Z);
            }
        }
        Integer dDevice_goods_status = instance.getDeviceGoodsStatus();
        if (conditionField.contains(ModelTEvent.FI_DEVICE_GOODS_STATUS)) {
            throwExceptionIf((dDevice_goods_status!= null));
            sqlBuilder.itemWhere(ModelTEvent.FI_DEVICE_GOODS_STATUS, ColumnDataType.intData);
        } else {
            if (dDevice_goods_status!= null) {
                sqlBuilder.itemCol(ModelTEvent.FI_DEVICE_GOODS_STATUS);
            }
        }
        EnumEventHandlerType dEvent_handler = instance.getEventHandler();
        if (conditionField.contains(ModelTEvent.FI_EVENT_HANDLER)) {
            throwExceptionIf((dEvent_handler!= null));
            sqlBuilder.itemWhere(ModelTEvent.FI_EVENT_HANDLER, ColumnDataType.byteData);
        } else {
            if (dEvent_handler!= null) {
                sqlBuilder.itemCol(ModelTEvent.FI_EVENT_HANDLER);
            }
        }
        Map<String, Object> param = Constants.T_EVENT_MAP_OBJ_MAPPER.toCommonMap(instance);
        return super.update(assembler, sqlBuilder, param);
    }

    public Integer update(ModelTEvent instance, Set<String> conditionField) {
        return update(instance, conditionField, null);
    }

    public Integer updateById(ModelTEvent instance, DaoAssembler assembler) {
        SQLUpdate sqlBuilder = SQLBuilder.buildUpdateSql();
        sqlBuilder.table(ModelTEvent.DTO_TABLE_NAME);
        throwExceptionIf((instance.getId()!= null));
        sqlBuilder.itemWhere("__id", ColumnDataType.intData);
        Integer dId = instance.getId();
        if (dId!= null) {
            sqlBuilder.itemCol(ModelTEvent.FI_ID);
        }
        Integer dEvent_device = instance.getEventDevice();
        if (dEvent_device!= null) {
            sqlBuilder.itemCol(ModelTEvent.FI_EVENT_DEVICE);
        }
        String dEvent_name = instance.getEventName();
        if (dEvent_name!= null) {
            sqlBuilder.itemCol(ModelTEvent.FI_EVENT_NAME);
        }
        Date dEvent_time = instance.getEventTime();
        if (dEvent_time!= null) {
            sqlBuilder.itemCol(ModelTEvent.FI_EVENT_TIME);
        }
        EnumEventStatus dEvent_type = instance.getEventType();
        if (dEvent_type!= null) {
            sqlBuilder.itemCol(ModelTEvent.FI_EVENT_TYPE);
        }
        String dEvent_message = instance.getEventMessage();
        if (dEvent_message!= null) {
            sqlBuilder.itemCol(ModelTEvent.FI_EVENT_MESSAGE);
        }
        Integer dEvent_task_id = instance.getEventTaskId();
        if (dEvent_task_id!= null) {
            sqlBuilder.itemCol(ModelTEvent.FI_EVENT_TASK_ID);
        }
        String dEvent_remark = instance.getEventRemark();
        if (dEvent_remark!= null) {
            sqlBuilder.itemCol(ModelTEvent.FI_EVENT_REMARK);
        }
        Integer dEvent_device_type = instance.getEventDeviceType();
        if (dEvent_device_type!= null) {
            sqlBuilder.itemCol(ModelTEvent.FI_EVENT_DEVICE_TYPE);
        }
        Byte dEvent_device_ability = instance.getEventDeviceAbility();
        if (dEvent_device_ability!= null) {
            sqlBuilder.itemCol(ModelTEvent.FI_EVENT_DEVICE_ABILITY);
        }
        Integer dEvent_action_id = instance.getEventActionId();
        if (dEvent_action_id!= null) {
            sqlBuilder.itemCol(ModelTEvent.FI_EVENT_ACTION_ID);
        }
        Integer dEvent_path_id = instance.getEventPathId();
        if (dEvent_path_id!= null) {
            sqlBuilder.itemCol(ModelTEvent.FI_EVENT_PATH_ID);
        }
        EnumTaskStatus dEvent_message_type = instance.getEventMessageType();
        if (dEvent_message_type!= null) {
            sqlBuilder.itemCol(ModelTEvent.FI_EVENT_MESSAGE_TYPE);
        }
        Long dEvent_guid = instance.getEventGuid();
        if (dEvent_guid!= null) {
            sqlBuilder.itemCol(ModelTEvent.FI_EVENT_GUID);
        }
        String dParam_test_v1 = instance.getParamTestV1();
        if (dParam_test_v1 != null) {
            sqlBuilder.itemCol(ModelTEvent.FI_PARAM_TEST_V1);
        }
        Integer dParam_test_v2 = instance.getParamTestV2();
        if (dParam_test_v2 != null) {
            sqlBuilder.itemCol(ModelTEvent.FI_PARAM_TEST_V2);
        }
        EnumDeviceStatusType dDevice_status = instance.getDeviceStatus();
        if (dDevice_status!= null) {
            sqlBuilder.itemCol(ModelTEvent.FI_DEVICE_STATUS);
        }
        String dDevice_error_message = instance.getDeviceErrorMessage();
        if (dDevice_error_message!= null) {
            sqlBuilder.itemCol(ModelTEvent.FI_DEVICE_ERROR_MESSAGE);
        }
        Integer dDevice_arix_x = instance.getDeviceArixX();
        if (dDevice_arix_x!= null) {
            sqlBuilder.itemCol(ModelTEvent.FI_DEVICE_ARIX_X);
        }
        Integer dDevice_arix_y = instance.getDeviceArixY();
        if (dDevice_arix_y!= null) {
            sqlBuilder.itemCol(ModelTEvent.FI_DEVICE_ARIX_Y);
        }
        Integer dDevice_arix_z = instance.getDeviceArixZ();
        if (dDevice_arix_z!= null) {
            sqlBuilder.itemCol(ModelTEvent.FI_DEVICE_ARIX_Z);
        }
        Integer dDevice_goods_status = instance.getDeviceGoodsStatus();
        if (dDevice_goods_status!= null) {
            sqlBuilder.itemCol(ModelTEvent.FI_DEVICE_GOODS_STATUS);
        }
        EnumEventHandlerType dEvent_handler = instance.getEventHandler();
        if (dEvent_handler!= null) {
            sqlBuilder.itemCol(ModelTEvent.FI_EVENT_HANDLER);
        }
        Map<String, Object> param;
        param = Constants.T_EVENT_MAP_OBJ_MAPPER.toCommonMap(instance);
        param.put("__id", instance.getId());
        return super.update(assembler, sqlBuilder, param);
    }

    public Integer updateById(ModelTEvent instance) {
        return updateById(instance, null);
    }

    public Integer updateByIds(ModelTEvent instance, Set<Integer> ids, DaoAssembler assembler) {
        SQLUpdate sqlBuilder = SQLBuilder.buildUpdateSql();
        sqlBuilder.table(ModelTEvent.DTO_TABLE_NAME);
        throwExceptionIf(((ids!= null)&&(ids.size()> 0)));
        sqlBuilder.itemWhere(LogicalOpType.in, "__ids", "__ids", ColumnDataType.intData);
        Integer dId = instance.getId();
        instance.setId(null);
        Integer dEvent_device = instance.getEventDevice();
        if (dEvent_device!= null) {
            sqlBuilder.itemCol(ModelTEvent.FI_EVENT_DEVICE);
        }
        String dEvent_name = instance.getEventName();
        if (dEvent_name!= null) {
            sqlBuilder.itemCol(ModelTEvent.FI_EVENT_NAME);
        }
        Date dEvent_time = instance.getEventTime();
        if (dEvent_time!= null) {
            sqlBuilder.itemCol(ModelTEvent.FI_EVENT_TIME);
        }
        EnumEventStatus dEvent_type = instance.getEventType();
        if (dEvent_type!= null) {
            sqlBuilder.itemCol(ModelTEvent.FI_EVENT_TYPE);
        }
        String dEvent_message = instance.getEventMessage();
        if (dEvent_message!= null) {
            sqlBuilder.itemCol(ModelTEvent.FI_EVENT_MESSAGE);
        }
        Integer dEvent_task_id = instance.getEventTaskId();
        if (dEvent_task_id!= null) {
            sqlBuilder.itemCol(ModelTEvent.FI_EVENT_TASK_ID);
        }
        String dEvent_remark = instance.getEventRemark();
        if (dEvent_remark!= null) {
            sqlBuilder.itemCol(ModelTEvent.FI_EVENT_REMARK);
        }
        Integer dEvent_device_type = instance.getEventDeviceType();
        if (dEvent_device_type!= null) {
            sqlBuilder.itemCol(ModelTEvent.FI_EVENT_DEVICE_TYPE);
        }
        Byte dEvent_device_ability = instance.getEventDeviceAbility();
        if (dEvent_device_ability!= null) {
            sqlBuilder.itemCol(ModelTEvent.FI_EVENT_DEVICE_ABILITY);
        }
        Integer dEvent_action_id = instance.getEventActionId();
        if (dEvent_action_id!= null) {
            sqlBuilder.itemCol(ModelTEvent.FI_EVENT_ACTION_ID);
        }
        Integer dEvent_path_id = instance.getEventPathId();
        if (dEvent_path_id!= null) {
            sqlBuilder.itemCol(ModelTEvent.FI_EVENT_PATH_ID);
        }
        EnumTaskStatus dEvent_message_type = instance.getEventMessageType();
        if (dEvent_message_type!= null) {
            sqlBuilder.itemCol(ModelTEvent.FI_EVENT_MESSAGE_TYPE);
        }
        Long dEvent_guid = instance.getEventGuid();
        if (dEvent_guid!= null) {
            sqlBuilder.itemCol(ModelTEvent.FI_EVENT_GUID);
        }
        String dParam_test_v1 = instance.getParamTestV1();
        if (dParam_test_v1 != null) {
            sqlBuilder.itemCol(ModelTEvent.FI_PARAM_TEST_V1);
        }
        Integer dParam_test_v2 = instance.getParamTestV2();
        if (dParam_test_v2 != null) {
            sqlBuilder.itemCol(ModelTEvent.FI_PARAM_TEST_V2);
        }
        EnumDeviceStatusType dDevice_status = instance.getDeviceStatus();
        if (dDevice_status!= null) {
            sqlBuilder.itemCol(ModelTEvent.FI_DEVICE_STATUS);
        }
        String dDevice_error_message = instance.getDeviceErrorMessage();
        if (dDevice_error_message!= null) {
            sqlBuilder.itemCol(ModelTEvent.FI_DEVICE_ERROR_MESSAGE);
        }
        Integer dDevice_arix_x = instance.getDeviceArixX();
        if (dDevice_arix_x!= null) {
            sqlBuilder.itemCol(ModelTEvent.FI_DEVICE_ARIX_X);
        }
        Integer dDevice_arix_y = instance.getDeviceArixY();
        if (dDevice_arix_y!= null) {
            sqlBuilder.itemCol(ModelTEvent.FI_DEVICE_ARIX_Y);
        }
        Integer dDevice_arix_z = instance.getDeviceArixZ();
        if (dDevice_arix_z!= null) {
            sqlBuilder.itemCol(ModelTEvent.FI_DEVICE_ARIX_Z);
        }
        Integer dDevice_goods_status = instance.getDeviceGoodsStatus();
        if (dDevice_goods_status!= null) {
            sqlBuilder.itemCol(ModelTEvent.FI_DEVICE_GOODS_STATUS);
        }
        EnumEventHandlerType dEvent_handler = instance.getEventHandler();
        if (dEvent_handler!= null) {
            sqlBuilder.itemCol(ModelTEvent.FI_EVENT_HANDLER);
        }
        Map<String, Object> param;
        param = Constants.T_EVENT_MAP_OBJ_MAPPER.toCommonMap(instance);
        param.put("__ids", ids);
        return super.update(assembler, sqlBuilder, param);
    }

    public Integer updateByIds(ModelTEvent instance, Set<Integer> ids) {
        return updateByIds(instance, ids, null);
    }

    public Integer deleteById(Integer id, DaoAssembler assembler) {
        SQLDelete sqlBuilder = SQLBuilder.buildDeleteSql();
        sqlBuilder.table(ModelTEvent.DTO_TABLE_NAME);
        throwExceptionIf((id!= null));
        sqlBuilder.itemWhere("__id", ColumnDataType.intData);
        Map<String, Object> param;
        param = Collections.singletonMap("__id", id);
        return super.update(assembler, sqlBuilder, param);
    }

    public Integer deleteById(Integer id) {
        return deleteById(id, null);
    }

    public Integer deleteByIds(Set<Integer> ids, DaoAssembler assembler) {
        SQLDelete sqlBuilder = SQLBuilder.buildDeleteSql();
        sqlBuilder.table(ModelTEvent.DTO_TABLE_NAME);
        throwExceptionIf(((ids!= null)&&(ids.size()> 0)));
        sqlBuilder.itemWhere(LogicalOpType.in, "__ids", "__ids", ColumnDataType.intData);
        Map<String, Object> param;
        param = Collections.singletonMap("__ids", ids);
        return super.update(assembler, sqlBuilder, param);
    }

    public Integer deleteByIds(Set<Integer> ids) {
        return deleteByIds(ids, null);
    }

    @Transactional
    public ModelTEvent updateOrInsert(ModelTEvent instance, Set<String> conditionField, AbstractMultipleDaoAssembler assembler) {
        if (assembler == null) {
            assembler = new BaseMultipleDaoAssembler();
        }
        ModelTEvent checkInstance = new ModelTEvent();
        if (conditionField.contains(ModelTEvent.FI_ID)) {
            checkInstance.setId(instance.getId());
        }
        if (conditionField.contains(ModelTEvent.FI_EVENT_DEVICE)) {
            checkInstance.setEventDevice(instance.getEventDevice());
        }
        if (conditionField.contains(ModelTEvent.FI_EVENT_NAME)) {
            checkInstance.setEventName(instance.getEventName());
        }
        if (conditionField.contains(ModelTEvent.FI_EVENT_TIME)) {
            checkInstance.setEventTime(instance.getEventTime());
        }
        if (conditionField.contains(ModelTEvent.FI_EVENT_TYPE)) {
            checkInstance.setEventType(instance.getEventType());
        }
        if (conditionField.contains(ModelTEvent.FI_EVENT_MESSAGE)) {
            checkInstance.setEventMessage(instance.getEventMessage());
        }
        if (conditionField.contains(ModelTEvent.FI_EVENT_TASK_ID)) {
            checkInstance.setEventTaskId(instance.getEventTaskId());
        }
        if (conditionField.contains(ModelTEvent.FI_EVENT_REMARK)) {
            checkInstance.setEventRemark(instance.getEventRemark());
        }
        if (conditionField.contains(ModelTEvent.FI_EVENT_DEVICE_TYPE)) {
            checkInstance.setEventDeviceType(instance.getEventDeviceType());
        }
        if (conditionField.contains(ModelTEvent.FI_EVENT_DEVICE_ABILITY)) {
            checkInstance.setEventDeviceAbility(instance.getEventDeviceAbility());
        }
        if (conditionField.contains(ModelTEvent.FI_EVENT_ACTION_ID)) {
            checkInstance.setEventActionId(instance.getEventActionId());
        }
        if (conditionField.contains(ModelTEvent.FI_EVENT_PATH_ID)) {
            checkInstance.setEventPathId(instance.getEventPathId());
        }
        if (conditionField.contains(ModelTEvent.FI_EVENT_MESSAGE_TYPE)) {
            checkInstance.setEventMessageType(instance.getEventMessageType());
        }
        if (conditionField.contains(ModelTEvent.FI_EVENT_GUID)) {
            checkInstance.setEventGuid(instance.getEventGuid());
        }
        if (conditionField.contains(ModelTEvent.FI_PARAM_TEST_V1)) {
            checkInstance.setParamTestV1(instance.getParamTestV1());
        }
        if (conditionField.contains(ModelTEvent.FI_PARAM_TEST_V2)) {
            checkInstance.setParamTestV2(instance.getParamTestV2());
        }
        if (conditionField.contains(ModelTEvent.FI_DEVICE_STATUS)) {
            checkInstance.setDeviceStatus(instance.getDeviceStatus());
        }
        if (conditionField.contains(ModelTEvent.FI_DEVICE_ERROR_MESSAGE)) {
            checkInstance.setDeviceErrorMessage(instance.getDeviceErrorMessage());
        }
        if (conditionField.contains(ModelTEvent.FI_DEVICE_ARIX_X)) {
            checkInstance.setDeviceArixX(instance.getDeviceArixX());
        }
        if (conditionField.contains(ModelTEvent.FI_DEVICE_ARIX_Y)) {
            checkInstance.setDeviceArixY(instance.getDeviceArixY());
        }
        if (conditionField.contains(ModelTEvent.FI_DEVICE_ARIX_Z)) {
            checkInstance.setDeviceArixZ(instance.getDeviceArixZ());
        }
        if (conditionField.contains(ModelTEvent.FI_DEVICE_GOODS_STATUS)) {
            checkInstance.setDeviceGoodsStatus(instance.getDeviceGoodsStatus());
        }
        if (conditionField.contains(ModelTEvent.FI_EVENT_HANDLER)) {
            checkInstance.setEventHandler(instance.getEventHandler());
        }
        ModelTEvent selected = getOneByCond(Collections.singleton(ModelTEvent.FI_ID), assembler, checkInstance);
        assembler.increaseIndex();
        if (selected == null) {
            return insert(instance, assembler);
        } else {
            instance.setId(selected.getId());
            update(instance, Collections.singleton(ModelTEvent.FI_ID), assembler);
            return instance;
        }
    }

    public ModelTEvent updateOrInsert(ModelTEvent instance, Set<String> conditionField) {
        return updateOrInsert(instance, conditionField, null);
    }

    @Transactional
    public ModelTEvent insertIfNoExist(ModelTEvent instance, Set<String> conditionField, AbstractMultipleDaoAssembler assembler) {
        if (assembler == null) {
            assembler = new BaseMultipleDaoAssembler();
        }
        ModelTEvent checkInstance = new ModelTEvent();
        if (conditionField.contains(ModelTEvent.FI_ID)) {
            checkInstance.setId(instance.getId());
        }
        if (conditionField.contains(ModelTEvent.FI_EVENT_DEVICE)) {
            checkInstance.setEventDevice(instance.getEventDevice());
        }
        if (conditionField.contains(ModelTEvent.FI_EVENT_NAME)) {
            checkInstance.setEventName(instance.getEventName());
        }
        if (conditionField.contains(ModelTEvent.FI_EVENT_TIME)) {
            checkInstance.setEventTime(instance.getEventTime());
        }
        if (conditionField.contains(ModelTEvent.FI_EVENT_TYPE)) {
            checkInstance.setEventType(instance.getEventType());
        }
        if (conditionField.contains(ModelTEvent.FI_EVENT_MESSAGE)) {
            checkInstance.setEventMessage(instance.getEventMessage());
        }
        if (conditionField.contains(ModelTEvent.FI_EVENT_TASK_ID)) {
            checkInstance.setEventTaskId(instance.getEventTaskId());
        }
        if (conditionField.contains(ModelTEvent.FI_EVENT_REMARK)) {
            checkInstance.setEventRemark(instance.getEventRemark());
        }
        if (conditionField.contains(ModelTEvent.FI_EVENT_DEVICE_TYPE)) {
            checkInstance.setEventDeviceType(instance.getEventDeviceType());
        }
        if (conditionField.contains(ModelTEvent.FI_EVENT_DEVICE_ABILITY)) {
            checkInstance.setEventDeviceAbility(instance.getEventDeviceAbility());
        }
        if (conditionField.contains(ModelTEvent.FI_EVENT_ACTION_ID)) {
            checkInstance.setEventActionId(instance.getEventActionId());
        }
        if (conditionField.contains(ModelTEvent.FI_EVENT_PATH_ID)) {
            checkInstance.setEventPathId(instance.getEventPathId());
        }
        if (conditionField.contains(ModelTEvent.FI_EVENT_MESSAGE_TYPE)) {
            checkInstance.setEventMessageType(instance.getEventMessageType());
        }
        if (conditionField.contains(ModelTEvent.FI_EVENT_GUID)) {
            checkInstance.setEventGuid(instance.getEventGuid());
        }
        if (conditionField.contains(ModelTEvent.FI_PARAM_TEST_V1)) {
            checkInstance.setParamTestV1(instance.getParamTestV1());
        }
        if (conditionField.contains(ModelTEvent.FI_PARAM_TEST_V2)) {
            checkInstance.setParamTestV2(instance.getParamTestV2());
        }
        if (conditionField.contains(ModelTEvent.FI_DEVICE_STATUS)) {
            checkInstance.setDeviceStatus(instance.getDeviceStatus());
        }
        if (conditionField.contains(ModelTEvent.FI_DEVICE_ERROR_MESSAGE)) {
            checkInstance.setDeviceErrorMessage(instance.getDeviceErrorMessage());
        }
        if (conditionField.contains(ModelTEvent.FI_DEVICE_ARIX_X)) {
            checkInstance.setDeviceArixX(instance.getDeviceArixX());
        }
        if (conditionField.contains(ModelTEvent.FI_DEVICE_ARIX_Y)) {
            checkInstance.setDeviceArixY(instance.getDeviceArixY());
        }
        if (conditionField.contains(ModelTEvent.FI_DEVICE_ARIX_Z)) {
            checkInstance.setDeviceArixZ(instance.getDeviceArixZ());
        }
        if (conditionField.contains(ModelTEvent.FI_DEVICE_GOODS_STATUS)) {
            checkInstance.setDeviceGoodsStatus(instance.getDeviceGoodsStatus());
        }
        if (conditionField.contains(ModelTEvent.FI_EVENT_HANDLER)) {
            checkInstance.setEventHandler(instance.getEventHandler());
        }
        ModelTEvent selected = getOneByCond(Collections.singleton(ModelTEvent.FI_ID), assembler, checkInstance);
        assembler.increaseIndex();
        if (selected == null) {
            return insert(instance, assembler);
        } else {
            instance.setId(selected.getId());
            return instance;
        }
    }

    public ModelTEvent insertIfNoExist(ModelTEvent instance, Set<String> conditionField) {
        return insertIfNoExist(instance, conditionField, null);
    }

    public<TT> Map<TT, ModelTEvent> buildMap(List<ModelTEvent> list, String field) {
        Map<TT, ModelTEvent> ret = CollectionHelper.newMap();
        if (list == null) {
            return ret;
        }
        for (ModelTEvent item: list) {
            ret.put(Constants.T_EVENT_MAP_OBJ_MAPPER.<TT> getField(field, item), item);
        }
        return ret;
    }

    public<TT> Map<TT, List<ModelTEvent>> buildListMap(List<ModelTEvent> list, String field) {
        Map<TT, List<ModelTEvent>> ret = CollectionHelper.newMap();
        if (list == null) {
            return ret;
        }
        for (ModelTEvent item: list) {
            List<ModelTEvent> itemList = ret.get(Constants.T_EVENT_MAP_OBJ_MAPPER.<TT> getField(field, item));
            if (itemList == null) {
                itemList = CollectionHelper.newList();
            }
            itemList.add(item);
            ret.put(Constants.T_EVENT_MAP_OBJ_MAPPER.<TT> getField(field, item), itemList);
        }
        return ret;
    }

    public<TT> List<TT> extractItemAsList(List<ModelTEvent> list, String field) {
        List<TT> ret = CollectionHelper.newList();
        if ((list == null)||(list.size() == 0)) {
            return ret;
        }
        if (ModelTEvent.FIELD_CLASS.containsKey(field)) {
            for (ModelTEvent item: list) {
                ret.add(Constants.T_EVENT_MAP_OBJ_MAPPER.<TT> getField(field, item));
            }
        }
        return ret;
    }
}
