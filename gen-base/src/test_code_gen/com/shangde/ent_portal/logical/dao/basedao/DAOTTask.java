package com.shangde.ent_portal.logical.dao.basedao;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map;
import java.util.Set;
import com.shangde.ent_portal.logical.contants.Constants;
import com.shangde.ent_portal.logical.dto.enums.EnumTaskStatus;
import com.shangde.ent_portal.logical.dto.enums.EnumTaskType;
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
import com.shangde.ent_portal.logical.dto.basepo.ModelTTask;

@Repository("DAOTTask")
@SuppressWarnings("unchecked")
public class DAOTTask
    extends AbstractDao<com.shangde.ent_portal.logical.dto.basepo.ModelTTask, Integer>
    implements DaoInterface<com.shangde.ent_portal.logical.dto.basepo.ModelTTask, Integer> , InitializingBean
{
    public final static Logger logger = LoggerFactory.getLogger(DAOTTask.class);

    public DAOTTask() {
        super(com.shangde.ent_portal.logical.dto.basepo.ModelTTask.class, Constants.T_TASK_RESULT_SET_OBJ_MAPPER);
    }

    @Override
    public void afterPropertiesSet()
        throws Exception
    {
    }

    protected void buildInClause(SQLSelect sqlBuilder, String inField, Map<String, Object> param, List indexes) {
        if (ModelTTask.FIELD_CLASS.containsKey(inField)) {
            Object fieldClassObj = ModelTTask.FIELD_CLASS.get(inField);
            super.buildRawInCluase(sqlBuilder, param, inField, fieldClassObj, indexes);
        } else {
            logger.error("field parameter error");
            throw new IllegalArgumentException(((("there is mistake with infield parameter, column "+ inField)+" not found in table ")+ com.shangde.ent_portal.logical.dto.basepo.ModelTTask.DTO_TABLE_NAME));
        }
    }

    protected void buildConditionCluase(SQLSelect sqlBuilder, ModelTTask instance, Map<String, Object> param) {
        Integer dId = instance.getId();
        if (dId!= null) {
            sqlBuilder.itemWhere(ModelTTask.FI_ID, ColumnDataType.intData);
            param.put(ModelTTask.FI_ID, dId);
        }
        Date dTask_create_time = instance.getTaskCreateTime();
        if (dTask_create_time!= null) {
            sqlBuilder.itemWhere(ModelTTask.FI_TASK_CREATE_TIME, ColumnDataType.timeStampData);
            param.put(ModelTTask.FI_TASK_CREATE_TIME, dTask_create_time);
        }
        Date dTask_expected_start_time = instance.getTaskExpectedStartTime();
        if (dTask_expected_start_time!= null) {
            sqlBuilder.itemWhere(ModelTTask.FI_TASK_EXPECTED_START_TIME, ColumnDataType.timeStampData);
            param.put(ModelTTask.FI_TASK_EXPECTED_START_TIME, dTask_expected_start_time);
        }
        Date dTask_start_time = instance.getTaskStartTime();
        if (dTask_start_time!= null) {
            sqlBuilder.itemWhere(ModelTTask.FI_TASK_START_TIME, ColumnDataType.timeStampData);
            param.put(ModelTTask.FI_TASK_START_TIME, dTask_start_time);
        }
        Date dTask_finish_time = instance.getTaskFinishTime();
        if (dTask_finish_time!= null) {
            sqlBuilder.itemWhere(ModelTTask.FI_TASK_FINISH_TIME, ColumnDataType.timeStampData);
            param.put(ModelTTask.FI_TASK_FINISH_TIME, dTask_finish_time);
        }
        String dTask_remark = instance.getTaskRemark();
        if (dTask_remark!= null) {
            sqlBuilder.itemWhere(ModelTTask.FI_TASK_REMARK, ColumnDataType.stringData);
            param.put(ModelTTask.FI_TASK_REMARK, dTask_remark);
        }
        Integer dTask_order_id = instance.getTaskOrderId();
        if (dTask_order_id!= null) {
            sqlBuilder.itemWhere(ModelTTask.FI_TASK_ORDER_ID, ColumnDataType.intData);
            param.put(ModelTTask.FI_TASK_ORDER_ID, dTask_order_id);
        }
        String dTask_param = instance.getTaskParam();
        if (dTask_param!= null) {
            sqlBuilder.itemWhere(ModelTTask.FI_TASK_PARAM, ColumnDataType.stringData);
            param.put(ModelTTask.FI_TASK_PARAM, dTask_param);
        }
        EnumTaskStatus dTask_status = instance.getTaskStatus();
        if (dTask_status!= null) {
            sqlBuilder.itemWhere(ModelTTask.FI_TASK_STATUS, ColumnDataType.byteData);
            param.put(ModelTTask.FI_TASK_STATUS, dTask_status.val);
        }
        Short dTask_total_path = instance.getTaskTotalPath();
        if (dTask_total_path!= null) {
            sqlBuilder.itemWhere(ModelTTask.FI_TASK_TOTAL_PATH, ColumnDataType.shortData);
            param.put(ModelTTask.FI_TASK_TOTAL_PATH, dTask_total_path);
        }
        Integer dTask_current_path_id = instance.getTaskCurrentPathId();
        if (dTask_current_path_id!= null) {
            sqlBuilder.itemWhere(ModelTTask.FI_TASK_CURRENT_PATH_ID, ColumnDataType.intData);
            param.put(ModelTTask.FI_TASK_CURRENT_PATH_ID, dTask_current_path_id);
        }
        Short dTask_current_path_index = instance.getTaskCurrentPathIndex();
        if (dTask_current_path_index!= null) {
            sqlBuilder.itemWhere(ModelTTask.FI_TASK_CURRENT_PATH_INDEX, ColumnDataType.shortData);
            param.put(ModelTTask.FI_TASK_CURRENT_PATH_INDEX, dTask_current_path_index);
        }
        Integer dArix_x = instance.getArixX();
        if (dArix_x!= null) {
            sqlBuilder.itemWhere(ModelTTask.FI_ARIX_X, ColumnDataType.intData);
            param.put(ModelTTask.FI_ARIX_X, dArix_x);
        }
        Integer dArix_y = instance.getArixY();
        if (dArix_y!= null) {
            sqlBuilder.itemWhere(ModelTTask.FI_ARIX_Y, ColumnDataType.intData);
            param.put(ModelTTask.FI_ARIX_Y, dArix_y);
        }
        Integer dArix_z = instance.getArixZ();
        if (dArix_z!= null) {
            sqlBuilder.itemWhere(ModelTTask.FI_ARIX_Z, ColumnDataType.intData);
            param.put(ModelTTask.FI_ARIX_Z, dArix_z);
        }
        Integer dPoint_index = instance.getPointIndex();
        if (dPoint_index!= null) {
            sqlBuilder.itemWhere(ModelTTask.FI_POINT_INDEX, ColumnDataType.intData);
            param.put(ModelTTask.FI_POINT_INDEX, dPoint_index);
        }
        String dGoods_id = instance.getGoodsId();
        if (dGoods_id!= null) {
            sqlBuilder.itemWhere(ModelTTask.FI_GOODS_ID, ColumnDataType.stringData);
            param.put(ModelTTask.FI_GOODS_ID, dGoods_id);
        }
        String dGoods_info = instance.getGoodsInfo();
        if (dGoods_info!= null) {
            sqlBuilder.itemWhere(ModelTTask.FI_GOODS_INFO, ColumnDataType.stringData);
            param.put(ModelTTask.FI_GOODS_INFO, dGoods_info);
        }
        String dGoods_name = instance.getGoodsName();
        if (dGoods_name!= null) {
            sqlBuilder.itemWhere(ModelTTask.FI_GOODS_NAME, ColumnDataType.stringData);
            param.put(ModelTTask.FI_GOODS_NAME, dGoods_name);
        }
        Integer dGoods_weight = instance.getGoodsWeight();
        if (dGoods_weight!= null) {
            sqlBuilder.itemWhere(ModelTTask.FI_GOODS_WEIGHT, ColumnDataType.intData);
            param.put(ModelTTask.FI_GOODS_WEIGHT, dGoods_weight);
        }
        Integer dOrigin_arix_x = instance.getOriginArixX();
        if (dOrigin_arix_x!= null) {
            sqlBuilder.itemWhere(ModelTTask.FI_ORIGIN_ARIX_X, ColumnDataType.intData);
            param.put(ModelTTask.FI_ORIGIN_ARIX_X, dOrigin_arix_x);
        }
        Integer dOrigin_arix_y = instance.getOriginArixY();
        if (dOrigin_arix_y!= null) {
            sqlBuilder.itemWhere(ModelTTask.FI_ORIGIN_ARIX_Y, ColumnDataType.intData);
            param.put(ModelTTask.FI_ORIGIN_ARIX_Y, dOrigin_arix_y);
        }
        Integer dOrigin_arix_z = instance.getOriginArixZ();
        if (dOrigin_arix_z!= null) {
            sqlBuilder.itemWhere(ModelTTask.FI_ORIGIN_ARIX_Z, ColumnDataType.intData);
            param.put(ModelTTask.FI_ORIGIN_ARIX_Z, dOrigin_arix_z);
        }
        Integer dOrigin_point_index = instance.getOriginPointIndex();
        if (dOrigin_point_index!= null) {
            sqlBuilder.itemWhere(ModelTTask.FI_ORIGIN_POINT_INDEX, ColumnDataType.intData);
            param.put(ModelTTask.FI_ORIGIN_POINT_INDEX, dOrigin_point_index);
        }
        Integer dTask_depends_on = instance.getTaskDependsOn();
        if (dTask_depends_on!= null) {
            sqlBuilder.itemWhere(ModelTTask.FI_TASK_DEPENDS_ON, ColumnDataType.intData);
            param.put(ModelTTask.FI_TASK_DEPENDS_ON, dTask_depends_on);
        }
        Integer dTask_parent_id = instance.getTaskParentId();
        if (dTask_parent_id!= null) {
            sqlBuilder.itemWhere(ModelTTask.FI_TASK_PARENT_ID, ColumnDataType.intData);
            param.put(ModelTTask.FI_TASK_PARENT_ID, dTask_parent_id);
        }
        Integer dTask_group_id = instance.getTaskGroupId();
        if (dTask_group_id!= null) {
            sqlBuilder.itemWhere(ModelTTask.FI_TASK_GROUP_ID, ColumnDataType.intData);
            param.put(ModelTTask.FI_TASK_GROUP_ID, dTask_group_id);
        }
        EnumTaskType dTask_type = instance.getTaskType();
        if (dTask_type!= null) {
            sqlBuilder.itemWhere(ModelTTask.FI_TASK_TYPE, ColumnDataType.byteData);
            param.put(ModelTTask.FI_TASK_TYPE, dTask_type.val);
        }
        Integer dTask_appointed_device = instance.getTaskAppointedDevice();
        if (dTask_appointed_device!= null) {
            sqlBuilder.itemWhere(ModelTTask.FI_TASK_APPOINTED_DEVICE, ColumnDataType.intData);
            param.put(ModelTTask.FI_TASK_APPOINTED_DEVICE, dTask_appointed_device);
        }
        Integer dTask_priority = instance.getTaskPriority();
        if (dTask_priority!= null) {
            sqlBuilder.itemWhere(ModelTTask.FI_TASK_PRIORITY, ColumnDataType.intData);
            param.put(ModelTTask.FI_TASK_PRIORITY, dTask_priority);
        }
        Integer dRetry_times = instance.getRetryTimes();
        if (dRetry_times!= null) {
            sqlBuilder.itemWhere(ModelTTask.FI_RETRY_TIMES, ColumnDataType.intData);
            param.put(ModelTTask.FI_RETRY_TIMES, dRetry_times);
        }
        Integer dCurrent_arix_x = instance.getCurrentArixX();
        if (dCurrent_arix_x!= null) {
            sqlBuilder.itemWhere(ModelTTask.FI_CURRENT_ARIX_X, ColumnDataType.intData);
            param.put(ModelTTask.FI_CURRENT_ARIX_X, dCurrent_arix_x);
        }
        Integer dCurrent_arix_y = instance.getCurrentArixY();
        if (dCurrent_arix_y!= null) {
            sqlBuilder.itemWhere(ModelTTask.FI_CURRENT_ARIX_Y, ColumnDataType.intData);
            param.put(ModelTTask.FI_CURRENT_ARIX_Y, dCurrent_arix_y);
        }
        Integer dCurrent_arix_z = instance.getCurrentArixZ();
        if (dCurrent_arix_z!= null) {
            sqlBuilder.itemWhere(ModelTTask.FI_CURRENT_ARIX_Z, ColumnDataType.intData);
            param.put(ModelTTask.FI_CURRENT_ARIX_Z, dCurrent_arix_z);
        }
        Integer dCurrent_point_index = instance.getCurrentPointIndex();
        if (dCurrent_point_index!= null) {
            sqlBuilder.itemWhere(ModelTTask.FI_CURRENT_POINT_INDEX, ColumnDataType.intData);
            param.put(ModelTTask.FI_CURRENT_POINT_INDEX, dCurrent_point_index);
        }
        Integer dCurrent_waiting_device = instance.getCurrentWaitingDevice();
        if (dCurrent_waiting_device!= null) {
            sqlBuilder.itemWhere(ModelTTask.FI_CURRENT_WAITING_DEVICE, ColumnDataType.intData);
            param.put(ModelTTask.FI_CURRENT_WAITING_DEVICE, dCurrent_waiting_device);
        }
    }

    protected void buildSelectFieldCluase(SQLSelect sqlBuilder, Set<String> selectFields) {
        if (selectFields.contains(ModelTTask.FI_ID)) {
            sqlBuilder.itemCol(ModelTTask.FI_ID);
        }
        if (selectFields.contains(ModelTTask.FI_TASK_CREATE_TIME)) {
            sqlBuilder.itemCol(ModelTTask.FI_TASK_CREATE_TIME);
        }
        if (selectFields.contains(ModelTTask.FI_TASK_EXPECTED_START_TIME)) {
            sqlBuilder.itemCol(ModelTTask.FI_TASK_EXPECTED_START_TIME);
        }
        if (selectFields.contains(ModelTTask.FI_TASK_START_TIME)) {
            sqlBuilder.itemCol(ModelTTask.FI_TASK_START_TIME);
        }
        if (selectFields.contains(ModelTTask.FI_TASK_FINISH_TIME)) {
            sqlBuilder.itemCol(ModelTTask.FI_TASK_FINISH_TIME);
        }
        if (selectFields.contains(ModelTTask.FI_TASK_REMARK)) {
            sqlBuilder.itemCol(ModelTTask.FI_TASK_REMARK);
        }
        if (selectFields.contains(ModelTTask.FI_TASK_ORDER_ID)) {
            sqlBuilder.itemCol(ModelTTask.FI_TASK_ORDER_ID);
        }
        if (selectFields.contains(ModelTTask.FI_TASK_PARAM)) {
            sqlBuilder.itemCol(ModelTTask.FI_TASK_PARAM);
        }
        if (selectFields.contains(ModelTTask.FI_TASK_STATUS)) {
            sqlBuilder.itemCol(ModelTTask.FI_TASK_STATUS);
        }
        if (selectFields.contains(ModelTTask.FI_TASK_TOTAL_PATH)) {
            sqlBuilder.itemCol(ModelTTask.FI_TASK_TOTAL_PATH);
        }
        if (selectFields.contains(ModelTTask.FI_TASK_CURRENT_PATH_ID)) {
            sqlBuilder.itemCol(ModelTTask.FI_TASK_CURRENT_PATH_ID);
        }
        if (selectFields.contains(ModelTTask.FI_TASK_CURRENT_PATH_INDEX)) {
            sqlBuilder.itemCol(ModelTTask.FI_TASK_CURRENT_PATH_INDEX);
        }
        if (selectFields.contains(ModelTTask.FI_ARIX_X)) {
            sqlBuilder.itemCol(ModelTTask.FI_ARIX_X);
        }
        if (selectFields.contains(ModelTTask.FI_ARIX_Y)) {
            sqlBuilder.itemCol(ModelTTask.FI_ARIX_Y);
        }
        if (selectFields.contains(ModelTTask.FI_ARIX_Z)) {
            sqlBuilder.itemCol(ModelTTask.FI_ARIX_Z);
        }
        if (selectFields.contains(ModelTTask.FI_POINT_INDEX)) {
            sqlBuilder.itemCol(ModelTTask.FI_POINT_INDEX);
        }
        if (selectFields.contains(ModelTTask.FI_GOODS_ID)) {
            sqlBuilder.itemCol(ModelTTask.FI_GOODS_ID);
        }
        if (selectFields.contains(ModelTTask.FI_GOODS_INFO)) {
            sqlBuilder.itemCol(ModelTTask.FI_GOODS_INFO);
        }
        if (selectFields.contains(ModelTTask.FI_GOODS_NAME)) {
            sqlBuilder.itemCol(ModelTTask.FI_GOODS_NAME);
        }
        if (selectFields.contains(ModelTTask.FI_GOODS_WEIGHT)) {
            sqlBuilder.itemCol(ModelTTask.FI_GOODS_WEIGHT);
        }
        if (selectFields.contains(ModelTTask.FI_ORIGIN_ARIX_X)) {
            sqlBuilder.itemCol(ModelTTask.FI_ORIGIN_ARIX_X);
        }
        if (selectFields.contains(ModelTTask.FI_ORIGIN_ARIX_Y)) {
            sqlBuilder.itemCol(ModelTTask.FI_ORIGIN_ARIX_Y);
        }
        if (selectFields.contains(ModelTTask.FI_ORIGIN_ARIX_Z)) {
            sqlBuilder.itemCol(ModelTTask.FI_ORIGIN_ARIX_Z);
        }
        if (selectFields.contains(ModelTTask.FI_ORIGIN_POINT_INDEX)) {
            sqlBuilder.itemCol(ModelTTask.FI_ORIGIN_POINT_INDEX);
        }
        if (selectFields.contains(ModelTTask.FI_TASK_DEPENDS_ON)) {
            sqlBuilder.itemCol(ModelTTask.FI_TASK_DEPENDS_ON);
        }
        if (selectFields.contains(ModelTTask.FI_TASK_PARENT_ID)) {
            sqlBuilder.itemCol(ModelTTask.FI_TASK_PARENT_ID);
        }
        if (selectFields.contains(ModelTTask.FI_TASK_GROUP_ID)) {
            sqlBuilder.itemCol(ModelTTask.FI_TASK_GROUP_ID);
        }
        if (selectFields.contains(ModelTTask.FI_TASK_TYPE)) {
            sqlBuilder.itemCol(ModelTTask.FI_TASK_TYPE);
        }
        if (selectFields.contains(ModelTTask.FI_TASK_APPOINTED_DEVICE)) {
            sqlBuilder.itemCol(ModelTTask.FI_TASK_APPOINTED_DEVICE);
        }
        if (selectFields.contains(ModelTTask.FI_TASK_PRIORITY)) {
            sqlBuilder.itemCol(ModelTTask.FI_TASK_PRIORITY);
        }
        if (selectFields.contains(ModelTTask.FI_RETRY_TIMES)) {
            sqlBuilder.itemCol(ModelTTask.FI_RETRY_TIMES);
        }
        if (selectFields.contains(ModelTTask.FI_CURRENT_ARIX_X)) {
            sqlBuilder.itemCol(ModelTTask.FI_CURRENT_ARIX_X);
        }
        if (selectFields.contains(ModelTTask.FI_CURRENT_ARIX_Y)) {
            sqlBuilder.itemCol(ModelTTask.FI_CURRENT_ARIX_Y);
        }
        if (selectFields.contains(ModelTTask.FI_CURRENT_ARIX_Z)) {
            sqlBuilder.itemCol(ModelTTask.FI_CURRENT_ARIX_Z);
        }
        if (selectFields.contains(ModelTTask.FI_CURRENT_POINT_INDEX)) {
            sqlBuilder.itemCol(ModelTTask.FI_CURRENT_POINT_INDEX);
        }
        if (selectFields.contains(ModelTTask.FI_CURRENT_WAITING_DEVICE)) {
            sqlBuilder.itemCol(ModelTTask.FI_CURRENT_WAITING_DEVICE);
        }
    }

    public List<ModelTTask> get(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count) {
        if (selectFields == null) {
            selectFields = ModelTTask.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelTTask.DTO_TABLE_NAME);
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

    public List<ModelTTask> get(Set<String> selectFields, Integer start, Integer count) {
        return get(selectFields, null, start, count);
    }

    public List<ModelTTask> get(Integer start, Integer count) {
        return get(null, start, count);
    }

    public List<ModelTTask> get() {
        return get(null, null);
    }

    public List<ModelTTask> getById(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, List<Integer> id) {
        if (selectFields == null) {
            selectFields = ModelTTask.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelTTask.DTO_TABLE_NAME);
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
            sqlBuilder.itemWhere(LogicalRelationshipType.and, LogicalOpType.in, null, ModelTTask.FI_ID, ModelTTask.FI_ID, ColumnDataType.intData);
            param.put(ModelTTask.FI_ID, id);
        }
        sqlBuilder.limit();
        return getResults(assembler, sqlBuilder, param);
    }

    public List<ModelTTask> getById(Set<String> selectFields, Integer start, Integer count, List<Integer> id) {
        return getById(selectFields, null, start, count, id);
    }

    public List<ModelTTask> getById(Integer start, Integer count, List<Integer> id) {
        return getById(null, start, count, id);
    }

    public List<ModelTTask> getById(List<Integer> id) {
        return getById(null, null, id);
    }

    public List<ModelTTask> getByIndex(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, String inField, List indexes) {
        if (selectFields == null) {
            selectFields = ModelTTask.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelTTask.DTO_TABLE_NAME);
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

    public List<ModelTTask> getByIndex(Set<String> selectFields, Integer start, Integer count, String inField, List indexes) {
        return getByIndex(selectFields, null, start, count, inField, indexes);
    }

    public List<ModelTTask> getByIndex(Integer start, Integer count, String inField, List indexes) {
        return getByIndex(null, start, count, inField, indexes);
    }

    public List<ModelTTask> getByIndex(String inField, List indexes) {
        return getByIndex(null, null, inField, indexes);
    }

    public List<ModelTTask> getByCond(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, ModelTTask instance) {
        if (selectFields == null) {
            selectFields = ModelTTask.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelTTask.DTO_TABLE_NAME);
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

    public List<ModelTTask> getByCond(Set<String> selectFields, Integer start, Integer count, ModelTTask instance) {
        return getByCond(selectFields, null, start, count, instance);
    }

    public List<ModelTTask> getByCond(Integer start, Integer count, ModelTTask instance) {
        return getByCond(null, start, count, instance);
    }

    public List<ModelTTask> getByCond(ModelTTask instance) {
        return getByCond(null, null, instance);
    }

    public List<ModelTTask> getByWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelTTask.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelTTask.DTO_TABLE_NAME);
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

    public List<ModelTTask> getByWhere(Set<String> selectFields, Integer start, Integer count, Map<String, Object> extParam, Set<String> extCondition) {
        return getByWhere(selectFields, null, start, count, extParam, extCondition);
    }

    public List<ModelTTask> getByWhere(Integer start, Integer count, Map<String, Object> extParam, Set<String> extCondition) {
        return getByWhere(null, start, count, extParam, extCondition);
    }

    public List<ModelTTask> getByWhere(Map<String, Object> extParam, Set<String> extCondition) {
        return getByWhere(null, null, extParam, extCondition);
    }

    public List<ModelTTask> getByCondAndIndex(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, ModelTTask instance, String inField, List indexes) {
        if (selectFields == null) {
            selectFields = ModelTTask.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelTTask.DTO_TABLE_NAME);
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

    public List<ModelTTask> getByCondAndIndex(Set<String> selectFields, Integer start, Integer count, ModelTTask instance, String inField, List indexes) {
        return getByCondAndIndex(selectFields, null, start, count, instance, inField, indexes);
    }

    public List<ModelTTask> getByCondAndIndex(Integer start, Integer count, ModelTTask instance, String inField, List indexes) {
        return getByCondAndIndex(null, start, count, instance, inField, indexes);
    }

    public List<ModelTTask> getByCondAndIndex(ModelTTask instance, String inField, List indexes) {
        return getByCondAndIndex(null, null, instance, inField, indexes);
    }

    public List<ModelTTask> getByIdAndWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, Integer id, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelTTask.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelTTask.DTO_TABLE_NAME);
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
            sqlBuilder.itemWhere(LogicalRelationshipType.and, LogicalOpType.in, null, ModelTTask.FI_ID, ModelTTask.FI_ID, ColumnDataType.intData);
            param.put(ModelTTask.FI_ID, id);
        }
        sqlBuilder.limit();
        return getResults(assembler, sqlBuilder, param);
    }

    public List<ModelTTask> getByIdAndWhere(Set<String> selectFields, Integer start, Integer count, Integer id, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIdAndWhere(selectFields, null, start, count, id, extParam, extCondition);
    }

    public List<ModelTTask> getByIdAndWhere(Integer start, Integer count, Integer id, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIdAndWhere(null, start, count, id, extParam, extCondition);
    }

    public List<ModelTTask> getByIdAndWhere(Integer id, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIdAndWhere(null, null, id, extParam, extCondition);
    }

    public List<ModelTTask> getByIdAndCondAndWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, ModelTTask instance, List<Integer> id, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelTTask.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelTTask.DTO_TABLE_NAME);
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
            sqlBuilder.itemWhere(LogicalRelationshipType.and, LogicalOpType.in, null, ModelTTask.FI_ID, ModelTTask.FI_ID, ColumnDataType.intData);
            param.put(ModelTTask.FI_ID, id);
        }
        sqlBuilder.limit();
        return getResults(assembler, sqlBuilder, param);
    }

    public List<ModelTTask> getByIdAndCondAndWhere(Set<String> selectFields, Integer start, Integer count, ModelTTask instance, List<Integer> id, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIdAndCondAndWhere(selectFields, null, start, count, instance, id, extParam, extCondition);
    }

    public List<ModelTTask> getByIdAndCondAndWhere(Integer start, Integer count, ModelTTask instance, List<Integer> id, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIdAndCondAndWhere(null, start, count, instance, id, extParam, extCondition);
    }

    public List<ModelTTask> getByIdAndCondAndWhere(ModelTTask instance, List<Integer> id, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIdAndCondAndWhere(null, null, instance, id, extParam, extCondition);
    }

    public List<ModelTTask> getByIndexAndWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelTTask.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelTTask.DTO_TABLE_NAME);
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

    public List<ModelTTask> getByIndexAndWhere(Set<String> selectFields, Integer start, Integer count, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIndexAndWhere(selectFields, null, start, count, inField, indexes, extParam, extCondition);
    }

    public List<ModelTTask> getByIndexAndWhere(Integer start, Integer count, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIndexAndWhere(null, start, count, inField, indexes, extParam, extCondition);
    }

    public List<ModelTTask> getByIndexAndWhere(String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIndexAndWhere(null, null, inField, indexes, extParam, extCondition);
    }

    public List<ModelTTask> getByCondAndWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, ModelTTask instance, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelTTask.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelTTask.DTO_TABLE_NAME);
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

    public List<ModelTTask> getByCondAndWhere(Set<String> selectFields, Integer start, Integer count, ModelTTask instance, Map<String, Object> extParam, Set<String> extCondition) {
        return getByCondAndWhere(selectFields, null, start, count, instance, extParam, extCondition);
    }

    public List<ModelTTask> getByCondAndWhere(Integer start, Integer count, ModelTTask instance, Map<String, Object> extParam, Set<String> extCondition) {
        return getByCondAndWhere(null, start, count, instance, extParam, extCondition);
    }

    public List<ModelTTask> getByCondAndWhere(ModelTTask instance, Map<String, Object> extParam, Set<String> extCondition) {
        return getByCondAndWhere(null, null, instance, extParam, extCondition);
    }

    public List<ModelTTask> getByCondAndIndexAndWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, ModelTTask instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelTTask.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelTTask.DTO_TABLE_NAME);
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

    public List<ModelTTask> getByCondAndIndexAndWhere(Set<String> selectFields, Integer start, Integer count, ModelTTask instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        return getByCondAndIndexAndWhere(selectFields, null, start, count, instance, inField, indexes, extParam, extCondition);
    }

    public List<ModelTTask> getByCondAndIndexAndWhere(Integer start, Integer count, ModelTTask instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        return getByCondAndIndexAndWhere(null, start, count, instance, inField, indexes, extParam, extCondition);
    }

    public List<ModelTTask> getByCondAndIndexAndWhere(ModelTTask instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        return getByCondAndIndexAndWhere(null, null, instance, inField, indexes, extParam, extCondition);
    }

    public ModelTTask getOneById(Set<String> selectFields, DaoAssembler assembler, Integer id) {
        if (selectFields == null) {
            selectFields = ModelTTask.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelTTask.DTO_TABLE_NAME);
        Integer start = 0;
        Integer count = 1;
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        buildSelectFieldCluase(sqlBuilder, selectFields);
        if (id!= null) {
            sqlBuilder.itemWhere(ModelTTask.FI_ID, ColumnDataType.intData);
            param.put(ModelTTask.FI_ID, id);
        }
        sqlBuilder.limit();
        return getResult(assembler, sqlBuilder, param);
    }

    public ModelTTask getOneById(Set<String> selectFields, Integer id) {
        return getOneById(selectFields, null, id);
    }

    public ModelTTask getOneById(Integer id) {
        return getOneById(null, id);
    }

    public ModelTTask getOneByCond(Set<String> selectFields, DaoAssembler assembler, ModelTTask instance) {
        if (selectFields == null) {
            selectFields = ModelTTask.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelTTask.DTO_TABLE_NAME);
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

    public ModelTTask getOneByCond(Set<String> selectFields, ModelTTask instance) {
        return getOneByCond(selectFields, null, instance);
    }

    public ModelTTask getOneByCond(ModelTTask instance) {
        return getOneByCond(null, instance);
    }

    public ModelTTask getOneByWhere(Set<String> selectFields, DaoAssembler assembler, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelTTask.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelTTask.DTO_TABLE_NAME);
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

    public ModelTTask getOneByWhere(Set<String> selectFields, Map<String, Object> extParam, Set<String> extCondition) {
        return getOneByWhere(selectFields, null, extParam, extCondition);
    }

    public ModelTTask getOneByWhere(Map<String, Object> extParam, Set<String> extCondition) {
        return getOneByWhere(null, extParam, extCondition);
    }

    public ModelTTask getOneByCondAndWhere(Set<String> selectFields, DaoAssembler assembler, ModelTTask instance, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelTTask.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelTTask.DTO_TABLE_NAME);
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

    public ModelTTask getOneByCondAndWhere(Set<String> selectFields, ModelTTask instance, Map<String, Object> extParam, Set<String> extCondition) {
        return getOneByCondAndWhere(selectFields, null, instance, extParam, extCondition);
    }

    public ModelTTask getOneByCondAndWhere(ModelTTask instance, Map<String, Object> extParam, Set<String> extCondition) {
        return getOneByCondAndWhere(null, instance, extParam, extCondition);
    }

    public ModelTTask getOneByIdAndCondAndWhere(Set<String> selectFields, DaoAssembler assembler, ModelTTask instance, Integer id, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelTTask.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelTTask.DTO_TABLE_NAME);
        Integer start = 0;
        Integer count = 1;
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        super.buildRawWhere(sqlBuilder, param, extParam, extCondition);
        buildConditionCluase(sqlBuilder, instance, param);
        buildSelectFieldCluase(sqlBuilder, selectFields);
        if (id!= null) {
            sqlBuilder.itemWhere(ModelTTask.FI_ID, ColumnDataType.intData);
            param.put(ModelTTask.FI_ID, id);
        }
        sqlBuilder.limit();
        return getResult(assembler, sqlBuilder, param);
    }

    public ModelTTask getOneByIdAndCondAndWhere(Set<String> selectFields, ModelTTask instance, Integer id, Map<String, Object> extParam, Set<String> extCondition) {
        return getOneByIdAndCondAndWhere(selectFields, null, instance, id, extParam, extCondition);
    }

    public ModelTTask getOneByIdAndCondAndWhere(ModelTTask instance, Integer id, Map<String, Object> extParam, Set<String> extCondition) {
        return getOneByIdAndCondAndWhere(null, instance, id, extParam, extCondition);
    }

    public Long getCountByCond(DaoAssembler assembler, ModelTTask instance) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelTTask.DTO_TABLE_NAME);
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

    public Long getCountByCond(ModelTTask instance) {
        return getCountByCond(null, instance);
    }

    public Long getCountByCondAndIndex(DaoAssembler assembler, ModelTTask instance, String inField, List indexes) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelTTask.DTO_TABLE_NAME);
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

    public Long getCountByCondAndIndex(ModelTTask instance, String inField, List indexes) {
        return getCountByCondAndIndex(null, instance, inField, indexes);
    }

    public Long getCountByCondAndIndexAndWhere(DaoAssembler assembler, ModelTTask instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelTTask.DTO_TABLE_NAME);
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

    public Long getCountByCondAndIndexAndWhere(ModelTTask instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        return getCountByCondAndIndexAndWhere(null, instance, inField, indexes, extParam, extCondition);
    }

    public<TT> TT getItemByIndex(DaoAssembler assembler, String inField, List indexes, Class<TT> tClass, String rawItem) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelTTask.DTO_TABLE_NAME);
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
        sqlBuilder.table(ModelTTask.DTO_TABLE_NAME);
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

    public<TT> TT getItemByCond(DaoAssembler assembler, ModelTTask instance, Class<TT> tClass, String rawItem) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelTTask.DTO_TABLE_NAME);
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

    public<TT extends Object> TT getItemByCond(ModelTTask instance, Class<TT> tClass, String rawItem) {
        return getItemByCond(null, instance, tClass, rawItem);
    }

    public<TT> TT getItemByCondAndIndex(DaoAssembler assembler, ModelTTask instance, String inField, List indexes, Class<TT> tClass, String rawItem) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelTTask.DTO_TABLE_NAME);
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

    public<TT extends Object> TT getItemByCondAndIndex(ModelTTask instance, String inField, List indexes, Class<TT> tClass, String rawItem) {
        return getItemByCondAndIndex(null, instance, inField, indexes, tClass, rawItem);
    }

    public<TT> TT getItemByCondAndIndexAndWhere(DaoAssembler assembler, ModelTTask instance, String inField, List indexes, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelTTask.DTO_TABLE_NAME);
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

    public<TT extends Object> TT getItemByCondAndIndexAndWhere(ModelTTask instance, String inField, List indexes, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        return getItemByCondAndIndexAndWhere(null, instance, inField, indexes, tClass, rawItem, extParam, extCondition);
    }

    public<TT> List<TT> getItemListByIndex(DaoAssembler assembler, Integer start, Integer count, String inField, List indexes, Class<TT> tClass, String rawItem) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelTTask.DTO_TABLE_NAME);
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

    public<TT> List<TT> getItemListByCond(DaoAssembler assembler, Integer start, Integer count, ModelTTask instance, Class<TT> tClass, String rawItem) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelTTask.DTO_TABLE_NAME);
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

    public<TT extends Object> List<TT> getItemListByCond(Integer start, Integer count, ModelTTask instance, Class<TT> tClass, String rawItem) {
        return getItemListByCond(null, start, count, instance, tClass, rawItem);
    }

    public<TT extends Object> List<TT> getItemListByCond(ModelTTask instance, Class<TT> tClass, String rawItem) {
        return getItemListByCond(null, null, instance, tClass, rawItem);
    }

    public<TT> List<TT> getItemListById(DaoAssembler assembler, Integer start, Integer count, Integer id, Class<TT> tClass, String rawItem) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelTTask.DTO_TABLE_NAME);
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
            sqlBuilder.itemWhere(LogicalRelationshipType.and, LogicalOpType.in, null, ModelTTask.FI_ID, ModelTTask.FI_ID, ColumnDataType.intData);
            param.put(ModelTTask.FI_ID, id);
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
        sqlBuilder.table(ModelTTask.DTO_TABLE_NAME);
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
        sqlBuilder.table(ModelTTask.DTO_TABLE_NAME);
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

    public<TT> List<TT> getItemListByCondAndWhere(DaoAssembler assembler, Integer start, Integer count, ModelTTask instance, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelTTask.DTO_TABLE_NAME);
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

    public<TT extends Object> List<TT> getItemListByCondAndWhere(Integer start, Integer count, ModelTTask instance, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        return getItemListByCondAndWhere(null, start, count, instance, tClass, rawItem, extParam, extCondition);
    }

    public<TT extends Object> List<TT> getItemListByCondAndWhere(ModelTTask instance, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        return getItemListByCondAndWhere(null, null, instance, tClass, rawItem, extParam, extCondition);
    }

    public<TT> List<TT> getItemListByCondAndIndex(DaoAssembler assembler, Integer start, Integer count, ModelTTask instance, String inField, List indexes, Class<TT> tClass, String rawItem) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelTTask.DTO_TABLE_NAME);
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

    public<TT extends Object> List<TT> getItemListByCondAndIndex(Integer start, Integer count, ModelTTask instance, String inField, List indexes, Class<TT> tClass, String rawItem) {
        return getItemListByCondAndIndex(null, start, count, instance, inField, indexes, tClass, rawItem);
    }

    public<TT extends Object> List<TT> getItemListByCondAndIndex(ModelTTask instance, String inField, List indexes, Class<TT> tClass, String rawItem) {
        return getItemListByCondAndIndex(null, null, instance, inField, indexes, tClass, rawItem);
    }

    public<TT> List<TT> getItemListByIdAndCondAndWhere(DaoAssembler assembler, Integer start, Integer count, ModelTTask instance, List<Integer> id, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelTTask.DTO_TABLE_NAME);
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
            sqlBuilder.itemWhere(LogicalRelationshipType.and, LogicalOpType.in, null, ModelTTask.FI_ID, ModelTTask.FI_ID, ColumnDataType.intData);
            param.put(ModelTTask.FI_ID, id);
        }
        sqlBuilder.limit();
        return ((List<TT> ) getSingleResults(assembler, sqlBuilder, param, tClass));
    }

    public<TT extends Object> List<TT> getItemListByIdAndCondAndWhere(Integer start, Integer count, ModelTTask instance, List<Integer> id, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        return getItemListByIdAndCondAndWhere(null, start, count, instance, id, tClass, rawItem, extParam, extCondition);
    }

    public<TT extends Object> List<TT> getItemListByIdAndCondAndWhere(ModelTTask instance, List<Integer> id, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        return getItemListByIdAndCondAndWhere(null, null, instance, id, tClass, rawItem, extParam, extCondition);
    }

    public ModelTTask insert(ModelTTask instance, DaoAssembler assembler) {
        SQLInsert sqlBuilder = SQLBuilder.buildInsertSql();
        sqlBuilder.table(ModelTTask.DTO_TABLE_NAME);
        Integer dId = instance.getId();
        if (dId!= null) {
            sqlBuilder.itemCol(ModelTTask.FI_ID);
        }
        Date dTask_create_time = instance.getTaskCreateTime();
        if (dTask_create_time!= null) {
            sqlBuilder.itemCol(ModelTTask.FI_TASK_CREATE_TIME);
        }
        Date dTask_expected_start_time = instance.getTaskExpectedStartTime();
        if (dTask_expected_start_time!= null) {
            sqlBuilder.itemCol(ModelTTask.FI_TASK_EXPECTED_START_TIME);
        }
        Date dTask_start_time = instance.getTaskStartTime();
        if (dTask_start_time!= null) {
            sqlBuilder.itemCol(ModelTTask.FI_TASK_START_TIME);
        }
        Date dTask_finish_time = instance.getTaskFinishTime();
        if (dTask_finish_time!= null) {
            sqlBuilder.itemCol(ModelTTask.FI_TASK_FINISH_TIME);
        }
        String dTask_remark = instance.getTaskRemark();
        if (dTask_remark!= null) {
            sqlBuilder.itemCol(ModelTTask.FI_TASK_REMARK);
        }
        Integer dTask_order_id = instance.getTaskOrderId();
        if (dTask_order_id!= null) {
            sqlBuilder.itemCol(ModelTTask.FI_TASK_ORDER_ID);
        }
        String dTask_param = instance.getTaskParam();
        if (dTask_param!= null) {
            sqlBuilder.itemCol(ModelTTask.FI_TASK_PARAM);
        }
        EnumTaskStatus dTask_status = instance.getTaskStatus();
        if (dTask_status!= null) {
            sqlBuilder.itemCol(ModelTTask.FI_TASK_STATUS);
        }
        Short dTask_total_path = instance.getTaskTotalPath();
        if (dTask_total_path!= null) {
            sqlBuilder.itemCol(ModelTTask.FI_TASK_TOTAL_PATH);
        }
        Integer dTask_current_path_id = instance.getTaskCurrentPathId();
        if (dTask_current_path_id!= null) {
            sqlBuilder.itemCol(ModelTTask.FI_TASK_CURRENT_PATH_ID);
        }
        Short dTask_current_path_index = instance.getTaskCurrentPathIndex();
        if (dTask_current_path_index!= null) {
            sqlBuilder.itemCol(ModelTTask.FI_TASK_CURRENT_PATH_INDEX);
        }
        Integer dArix_x = instance.getArixX();
        if (dArix_x!= null) {
            sqlBuilder.itemCol(ModelTTask.FI_ARIX_X);
        }
        Integer dArix_y = instance.getArixY();
        if (dArix_y!= null) {
            sqlBuilder.itemCol(ModelTTask.FI_ARIX_Y);
        }
        Integer dArix_z = instance.getArixZ();
        if (dArix_z!= null) {
            sqlBuilder.itemCol(ModelTTask.FI_ARIX_Z);
        }
        Integer dPoint_index = instance.getPointIndex();
        if (dPoint_index!= null) {
            sqlBuilder.itemCol(ModelTTask.FI_POINT_INDEX);
        }
        String dGoods_id = instance.getGoodsId();
        if (dGoods_id!= null) {
            sqlBuilder.itemCol(ModelTTask.FI_GOODS_ID);
        }
        String dGoods_info = instance.getGoodsInfo();
        if (dGoods_info!= null) {
            sqlBuilder.itemCol(ModelTTask.FI_GOODS_INFO);
        }
        String dGoods_name = instance.getGoodsName();
        if (dGoods_name!= null) {
            sqlBuilder.itemCol(ModelTTask.FI_GOODS_NAME);
        }
        Integer dGoods_weight = instance.getGoodsWeight();
        if (dGoods_weight!= null) {
            sqlBuilder.itemCol(ModelTTask.FI_GOODS_WEIGHT);
        }
        Integer dOrigin_arix_x = instance.getOriginArixX();
        if (dOrigin_arix_x!= null) {
            sqlBuilder.itemCol(ModelTTask.FI_ORIGIN_ARIX_X);
        }
        Integer dOrigin_arix_y = instance.getOriginArixY();
        if (dOrigin_arix_y!= null) {
            sqlBuilder.itemCol(ModelTTask.FI_ORIGIN_ARIX_Y);
        }
        Integer dOrigin_arix_z = instance.getOriginArixZ();
        if (dOrigin_arix_z!= null) {
            sqlBuilder.itemCol(ModelTTask.FI_ORIGIN_ARIX_Z);
        }
        Integer dOrigin_point_index = instance.getOriginPointIndex();
        if (dOrigin_point_index!= null) {
            sqlBuilder.itemCol(ModelTTask.FI_ORIGIN_POINT_INDEX);
        }
        Integer dTask_depends_on = instance.getTaskDependsOn();
        if (dTask_depends_on!= null) {
            sqlBuilder.itemCol(ModelTTask.FI_TASK_DEPENDS_ON);
        }
        Integer dTask_parent_id = instance.getTaskParentId();
        if (dTask_parent_id!= null) {
            sqlBuilder.itemCol(ModelTTask.FI_TASK_PARENT_ID);
        }
        Integer dTask_group_id = instance.getTaskGroupId();
        if (dTask_group_id!= null) {
            sqlBuilder.itemCol(ModelTTask.FI_TASK_GROUP_ID);
        }
        EnumTaskType dTask_type = instance.getTaskType();
        if (dTask_type!= null) {
            sqlBuilder.itemCol(ModelTTask.FI_TASK_TYPE);
        }
        Integer dTask_appointed_device = instance.getTaskAppointedDevice();
        if (dTask_appointed_device!= null) {
            sqlBuilder.itemCol(ModelTTask.FI_TASK_APPOINTED_DEVICE);
        }
        Integer dTask_priority = instance.getTaskPriority();
        if (dTask_priority!= null) {
            sqlBuilder.itemCol(ModelTTask.FI_TASK_PRIORITY);
        }
        Integer dRetry_times = instance.getRetryTimes();
        if (dRetry_times!= null) {
            sqlBuilder.itemCol(ModelTTask.FI_RETRY_TIMES);
        }
        Integer dCurrent_arix_x = instance.getCurrentArixX();
        if (dCurrent_arix_x!= null) {
            sqlBuilder.itemCol(ModelTTask.FI_CURRENT_ARIX_X);
        }
        Integer dCurrent_arix_y = instance.getCurrentArixY();
        if (dCurrent_arix_y!= null) {
            sqlBuilder.itemCol(ModelTTask.FI_CURRENT_ARIX_Y);
        }
        Integer dCurrent_arix_z = instance.getCurrentArixZ();
        if (dCurrent_arix_z!= null) {
            sqlBuilder.itemCol(ModelTTask.FI_CURRENT_ARIX_Z);
        }
        Integer dCurrent_point_index = instance.getCurrentPointIndex();
        if (dCurrent_point_index!= null) {
            sqlBuilder.itemCol(ModelTTask.FI_CURRENT_POINT_INDEX);
        }
        Integer dCurrent_waiting_device = instance.getCurrentWaitingDevice();
        if (dCurrent_waiting_device!= null) {
            sqlBuilder.itemCol(ModelTTask.FI_CURRENT_WAITING_DEVICE);
        }
        Map<String, Object> param = Constants.T_TASK_MAP_OBJ_MAPPER.toCommonMap(instance);
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

    public ModelTTask insert(ModelTTask instance) {
        return insert(instance, null);
    }

    public Integer insert(List<ModelTTask> instances, Set<String> fields, DaoAssembler assembler) {
        if (fields == null) {
            fields = ModelTTask.FIELD_CLASS.keySet();
        }
        SQLInsert sqlBuilder = SQLBuilder.buildInsertSql();
        sqlBuilder.table(ModelTTask.DTO_TABLE_NAME);
        if (fields.contains(ModelTTask.FI_ID)) {
            sqlBuilder.itemCol(ModelTTask.FI_ID);
        }
        if (fields.contains(ModelTTask.FI_TASK_CREATE_TIME)) {
            sqlBuilder.itemCol(ModelTTask.FI_TASK_CREATE_TIME);
        }
        if (fields.contains(ModelTTask.FI_TASK_EXPECTED_START_TIME)) {
            sqlBuilder.itemCol(ModelTTask.FI_TASK_EXPECTED_START_TIME);
        }
        if (fields.contains(ModelTTask.FI_TASK_START_TIME)) {
            sqlBuilder.itemCol(ModelTTask.FI_TASK_START_TIME);
        }
        if (fields.contains(ModelTTask.FI_TASK_FINISH_TIME)) {
            sqlBuilder.itemCol(ModelTTask.FI_TASK_FINISH_TIME);
        }
        if (fields.contains(ModelTTask.FI_TASK_REMARK)) {
            sqlBuilder.itemCol(ModelTTask.FI_TASK_REMARK);
        }
        if (fields.contains(ModelTTask.FI_TASK_ORDER_ID)) {
            sqlBuilder.itemCol(ModelTTask.FI_TASK_ORDER_ID);
        }
        if (fields.contains(ModelTTask.FI_TASK_PARAM)) {
            sqlBuilder.itemCol(ModelTTask.FI_TASK_PARAM);
        }
        if (fields.contains(ModelTTask.FI_TASK_STATUS)) {
            sqlBuilder.itemCol(ModelTTask.FI_TASK_STATUS);
        }
        if (fields.contains(ModelTTask.FI_TASK_TOTAL_PATH)) {
            sqlBuilder.itemCol(ModelTTask.FI_TASK_TOTAL_PATH);
        }
        if (fields.contains(ModelTTask.FI_TASK_CURRENT_PATH_ID)) {
            sqlBuilder.itemCol(ModelTTask.FI_TASK_CURRENT_PATH_ID);
        }
        if (fields.contains(ModelTTask.FI_TASK_CURRENT_PATH_INDEX)) {
            sqlBuilder.itemCol(ModelTTask.FI_TASK_CURRENT_PATH_INDEX);
        }
        if (fields.contains(ModelTTask.FI_ARIX_X)) {
            sqlBuilder.itemCol(ModelTTask.FI_ARIX_X);
        }
        if (fields.contains(ModelTTask.FI_ARIX_Y)) {
            sqlBuilder.itemCol(ModelTTask.FI_ARIX_Y);
        }
        if (fields.contains(ModelTTask.FI_ARIX_Z)) {
            sqlBuilder.itemCol(ModelTTask.FI_ARIX_Z);
        }
        if (fields.contains(ModelTTask.FI_POINT_INDEX)) {
            sqlBuilder.itemCol(ModelTTask.FI_POINT_INDEX);
        }
        if (fields.contains(ModelTTask.FI_GOODS_ID)) {
            sqlBuilder.itemCol(ModelTTask.FI_GOODS_ID);
        }
        if (fields.contains(ModelTTask.FI_GOODS_INFO)) {
            sqlBuilder.itemCol(ModelTTask.FI_GOODS_INFO);
        }
        if (fields.contains(ModelTTask.FI_GOODS_NAME)) {
            sqlBuilder.itemCol(ModelTTask.FI_GOODS_NAME);
        }
        if (fields.contains(ModelTTask.FI_GOODS_WEIGHT)) {
            sqlBuilder.itemCol(ModelTTask.FI_GOODS_WEIGHT);
        }
        if (fields.contains(ModelTTask.FI_ORIGIN_ARIX_X)) {
            sqlBuilder.itemCol(ModelTTask.FI_ORIGIN_ARIX_X);
        }
        if (fields.contains(ModelTTask.FI_ORIGIN_ARIX_Y)) {
            sqlBuilder.itemCol(ModelTTask.FI_ORIGIN_ARIX_Y);
        }
        if (fields.contains(ModelTTask.FI_ORIGIN_ARIX_Z)) {
            sqlBuilder.itemCol(ModelTTask.FI_ORIGIN_ARIX_Z);
        }
        if (fields.contains(ModelTTask.FI_ORIGIN_POINT_INDEX)) {
            sqlBuilder.itemCol(ModelTTask.FI_ORIGIN_POINT_INDEX);
        }
        if (fields.contains(ModelTTask.FI_TASK_DEPENDS_ON)) {
            sqlBuilder.itemCol(ModelTTask.FI_TASK_DEPENDS_ON);
        }
        if (fields.contains(ModelTTask.FI_TASK_PARENT_ID)) {
            sqlBuilder.itemCol(ModelTTask.FI_TASK_PARENT_ID);
        }
        if (fields.contains(ModelTTask.FI_TASK_GROUP_ID)) {
            sqlBuilder.itemCol(ModelTTask.FI_TASK_GROUP_ID);
        }
        if (fields.contains(ModelTTask.FI_TASK_TYPE)) {
            sqlBuilder.itemCol(ModelTTask.FI_TASK_TYPE);
        }
        if (fields.contains(ModelTTask.FI_TASK_APPOINTED_DEVICE)) {
            sqlBuilder.itemCol(ModelTTask.FI_TASK_APPOINTED_DEVICE);
        }
        if (fields.contains(ModelTTask.FI_TASK_PRIORITY)) {
            sqlBuilder.itemCol(ModelTTask.FI_TASK_PRIORITY);
        }
        if (fields.contains(ModelTTask.FI_RETRY_TIMES)) {
            sqlBuilder.itemCol(ModelTTask.FI_RETRY_TIMES);
        }
        if (fields.contains(ModelTTask.FI_CURRENT_ARIX_X)) {
            sqlBuilder.itemCol(ModelTTask.FI_CURRENT_ARIX_X);
        }
        if (fields.contains(ModelTTask.FI_CURRENT_ARIX_Y)) {
            sqlBuilder.itemCol(ModelTTask.FI_CURRENT_ARIX_Y);
        }
        if (fields.contains(ModelTTask.FI_CURRENT_ARIX_Z)) {
            sqlBuilder.itemCol(ModelTTask.FI_CURRENT_ARIX_Z);
        }
        if (fields.contains(ModelTTask.FI_CURRENT_POINT_INDEX)) {
            sqlBuilder.itemCol(ModelTTask.FI_CURRENT_POINT_INDEX);
        }
        if (fields.contains(ModelTTask.FI_CURRENT_WAITING_DEVICE)) {
            sqlBuilder.itemCol(ModelTTask.FI_CURRENT_WAITING_DEVICE);
        }
        List<Map<String, Object>> param = CollectionHelper.<Map<String,Object>> newList();
        for (ModelTTask instance: instances) {
            Map<String, Object> paramMap = Constants.T_TASK_MAP_OBJ_MAPPER.toCommonMap(instance);
            param.add(paramMap);
        }
        return super.batchInsert(assembler, sqlBuilder, param);
    }

    public Integer insert(List<ModelTTask> instances, Set<String> fields) {
        return insert(instances, fields, null);
    }

    public Integer insert(List<ModelTTask> instances) {
        return insert(instances, null, null);
    }

    public Integer update(ModelTTask instance, Set<String> conditionField, DaoAssembler assembler) {
        SQLUpdate sqlBuilder = SQLBuilder.buildUpdateSql();
        sqlBuilder.table(ModelTTask.DTO_TABLE_NAME);
        Integer dId = instance.getId();
        if (conditionField.contains(ModelTTask.FI_ID)) {
            throwExceptionIf((dId!= null));
            sqlBuilder.itemWhere(ModelTTask.FI_ID, ColumnDataType.intData);
        } else {
            if (dId!= null) {
                sqlBuilder.itemCol(ModelTTask.FI_ID);
            }
        }
        Date dTask_create_time = instance.getTaskCreateTime();
        if (conditionField.contains(ModelTTask.FI_TASK_CREATE_TIME)) {
            throwExceptionIf((dTask_create_time!= null));
            sqlBuilder.itemWhere(ModelTTask.FI_TASK_CREATE_TIME, ColumnDataType.timeStampData);
        } else {
            if (dTask_create_time!= null) {
                sqlBuilder.itemCol(ModelTTask.FI_TASK_CREATE_TIME);
            }
        }
        Date dTask_expected_start_time = instance.getTaskExpectedStartTime();
        if (conditionField.contains(ModelTTask.FI_TASK_EXPECTED_START_TIME)) {
            throwExceptionIf((dTask_expected_start_time!= null));
            sqlBuilder.itemWhere(ModelTTask.FI_TASK_EXPECTED_START_TIME, ColumnDataType.timeStampData);
        } else {
            if (dTask_expected_start_time!= null) {
                sqlBuilder.itemCol(ModelTTask.FI_TASK_EXPECTED_START_TIME);
            }
        }
        Date dTask_start_time = instance.getTaskStartTime();
        if (conditionField.contains(ModelTTask.FI_TASK_START_TIME)) {
            throwExceptionIf((dTask_start_time!= null));
            sqlBuilder.itemWhere(ModelTTask.FI_TASK_START_TIME, ColumnDataType.timeStampData);
        } else {
            if (dTask_start_time!= null) {
                sqlBuilder.itemCol(ModelTTask.FI_TASK_START_TIME);
            }
        }
        Date dTask_finish_time = instance.getTaskFinishTime();
        if (conditionField.contains(ModelTTask.FI_TASK_FINISH_TIME)) {
            throwExceptionIf((dTask_finish_time!= null));
            sqlBuilder.itemWhere(ModelTTask.FI_TASK_FINISH_TIME, ColumnDataType.timeStampData);
        } else {
            if (dTask_finish_time!= null) {
                sqlBuilder.itemCol(ModelTTask.FI_TASK_FINISH_TIME);
            }
        }
        String dTask_remark = instance.getTaskRemark();
        if (conditionField.contains(ModelTTask.FI_TASK_REMARK)) {
            throwExceptionIf((dTask_remark!= null));
            sqlBuilder.itemWhere(ModelTTask.FI_TASK_REMARK, ColumnDataType.stringData);
        } else {
            if (dTask_remark!= null) {
                sqlBuilder.itemCol(ModelTTask.FI_TASK_REMARK);
            }
        }
        Integer dTask_order_id = instance.getTaskOrderId();
        if (conditionField.contains(ModelTTask.FI_TASK_ORDER_ID)) {
            throwExceptionIf((dTask_order_id!= null));
            sqlBuilder.itemWhere(ModelTTask.FI_TASK_ORDER_ID, ColumnDataType.intData);
        } else {
            if (dTask_order_id!= null) {
                sqlBuilder.itemCol(ModelTTask.FI_TASK_ORDER_ID);
            }
        }
        String dTask_param = instance.getTaskParam();
        if (conditionField.contains(ModelTTask.FI_TASK_PARAM)) {
            throwExceptionIf((dTask_param!= null));
            sqlBuilder.itemWhere(ModelTTask.FI_TASK_PARAM, ColumnDataType.stringData);
        } else {
            if (dTask_param!= null) {
                sqlBuilder.itemCol(ModelTTask.FI_TASK_PARAM);
            }
        }
        EnumTaskStatus dTask_status = instance.getTaskStatus();
        if (conditionField.contains(ModelTTask.FI_TASK_STATUS)) {
            throwExceptionIf((dTask_status!= null));
            sqlBuilder.itemWhere(ModelTTask.FI_TASK_STATUS, ColumnDataType.byteData);
        } else {
            if (dTask_status!= null) {
                sqlBuilder.itemCol(ModelTTask.FI_TASK_STATUS);
            }
        }
        Short dTask_total_path = instance.getTaskTotalPath();
        if (conditionField.contains(ModelTTask.FI_TASK_TOTAL_PATH)) {
            throwExceptionIf((dTask_total_path!= null));
            sqlBuilder.itemWhere(ModelTTask.FI_TASK_TOTAL_PATH, ColumnDataType.shortData);
        } else {
            if (dTask_total_path!= null) {
                sqlBuilder.itemCol(ModelTTask.FI_TASK_TOTAL_PATH);
            }
        }
        Integer dTask_current_path_id = instance.getTaskCurrentPathId();
        if (conditionField.contains(ModelTTask.FI_TASK_CURRENT_PATH_ID)) {
            throwExceptionIf((dTask_current_path_id!= null));
            sqlBuilder.itemWhere(ModelTTask.FI_TASK_CURRENT_PATH_ID, ColumnDataType.intData);
        } else {
            if (dTask_current_path_id!= null) {
                sqlBuilder.itemCol(ModelTTask.FI_TASK_CURRENT_PATH_ID);
            }
        }
        Short dTask_current_path_index = instance.getTaskCurrentPathIndex();
        if (conditionField.contains(ModelTTask.FI_TASK_CURRENT_PATH_INDEX)) {
            throwExceptionIf((dTask_current_path_index!= null));
            sqlBuilder.itemWhere(ModelTTask.FI_TASK_CURRENT_PATH_INDEX, ColumnDataType.shortData);
        } else {
            if (dTask_current_path_index!= null) {
                sqlBuilder.itemCol(ModelTTask.FI_TASK_CURRENT_PATH_INDEX);
            }
        }
        Integer dArix_x = instance.getArixX();
        if (conditionField.contains(ModelTTask.FI_ARIX_X)) {
            throwExceptionIf((dArix_x!= null));
            sqlBuilder.itemWhere(ModelTTask.FI_ARIX_X, ColumnDataType.intData);
        } else {
            if (dArix_x!= null) {
                sqlBuilder.itemCol(ModelTTask.FI_ARIX_X);
            }
        }
        Integer dArix_y = instance.getArixY();
        if (conditionField.contains(ModelTTask.FI_ARIX_Y)) {
            throwExceptionIf((dArix_y!= null));
            sqlBuilder.itemWhere(ModelTTask.FI_ARIX_Y, ColumnDataType.intData);
        } else {
            if (dArix_y!= null) {
                sqlBuilder.itemCol(ModelTTask.FI_ARIX_Y);
            }
        }
        Integer dArix_z = instance.getArixZ();
        if (conditionField.contains(ModelTTask.FI_ARIX_Z)) {
            throwExceptionIf((dArix_z!= null));
            sqlBuilder.itemWhere(ModelTTask.FI_ARIX_Z, ColumnDataType.intData);
        } else {
            if (dArix_z!= null) {
                sqlBuilder.itemCol(ModelTTask.FI_ARIX_Z);
            }
        }
        Integer dPoint_index = instance.getPointIndex();
        if (conditionField.contains(ModelTTask.FI_POINT_INDEX)) {
            throwExceptionIf((dPoint_index!= null));
            sqlBuilder.itemWhere(ModelTTask.FI_POINT_INDEX, ColumnDataType.intData);
        } else {
            if (dPoint_index!= null) {
                sqlBuilder.itemCol(ModelTTask.FI_POINT_INDEX);
            }
        }
        String dGoods_id = instance.getGoodsId();
        if (conditionField.contains(ModelTTask.FI_GOODS_ID)) {
            throwExceptionIf((dGoods_id!= null));
            sqlBuilder.itemWhere(ModelTTask.FI_GOODS_ID, ColumnDataType.stringData);
        } else {
            if (dGoods_id!= null) {
                sqlBuilder.itemCol(ModelTTask.FI_GOODS_ID);
            }
        }
        String dGoods_info = instance.getGoodsInfo();
        if (conditionField.contains(ModelTTask.FI_GOODS_INFO)) {
            throwExceptionIf((dGoods_info!= null));
            sqlBuilder.itemWhere(ModelTTask.FI_GOODS_INFO, ColumnDataType.stringData);
        } else {
            if (dGoods_info!= null) {
                sqlBuilder.itemCol(ModelTTask.FI_GOODS_INFO);
            }
        }
        String dGoods_name = instance.getGoodsName();
        if (conditionField.contains(ModelTTask.FI_GOODS_NAME)) {
            throwExceptionIf((dGoods_name!= null));
            sqlBuilder.itemWhere(ModelTTask.FI_GOODS_NAME, ColumnDataType.stringData);
        } else {
            if (dGoods_name!= null) {
                sqlBuilder.itemCol(ModelTTask.FI_GOODS_NAME);
            }
        }
        Integer dGoods_weight = instance.getGoodsWeight();
        if (conditionField.contains(ModelTTask.FI_GOODS_WEIGHT)) {
            throwExceptionIf((dGoods_weight!= null));
            sqlBuilder.itemWhere(ModelTTask.FI_GOODS_WEIGHT, ColumnDataType.intData);
        } else {
            if (dGoods_weight!= null) {
                sqlBuilder.itemCol(ModelTTask.FI_GOODS_WEIGHT);
            }
        }
        Integer dOrigin_arix_x = instance.getOriginArixX();
        if (conditionField.contains(ModelTTask.FI_ORIGIN_ARIX_X)) {
            throwExceptionIf((dOrigin_arix_x!= null));
            sqlBuilder.itemWhere(ModelTTask.FI_ORIGIN_ARIX_X, ColumnDataType.intData);
        } else {
            if (dOrigin_arix_x!= null) {
                sqlBuilder.itemCol(ModelTTask.FI_ORIGIN_ARIX_X);
            }
        }
        Integer dOrigin_arix_y = instance.getOriginArixY();
        if (conditionField.contains(ModelTTask.FI_ORIGIN_ARIX_Y)) {
            throwExceptionIf((dOrigin_arix_y!= null));
            sqlBuilder.itemWhere(ModelTTask.FI_ORIGIN_ARIX_Y, ColumnDataType.intData);
        } else {
            if (dOrigin_arix_y!= null) {
                sqlBuilder.itemCol(ModelTTask.FI_ORIGIN_ARIX_Y);
            }
        }
        Integer dOrigin_arix_z = instance.getOriginArixZ();
        if (conditionField.contains(ModelTTask.FI_ORIGIN_ARIX_Z)) {
            throwExceptionIf((dOrigin_arix_z!= null));
            sqlBuilder.itemWhere(ModelTTask.FI_ORIGIN_ARIX_Z, ColumnDataType.intData);
        } else {
            if (dOrigin_arix_z!= null) {
                sqlBuilder.itemCol(ModelTTask.FI_ORIGIN_ARIX_Z);
            }
        }
        Integer dOrigin_point_index = instance.getOriginPointIndex();
        if (conditionField.contains(ModelTTask.FI_ORIGIN_POINT_INDEX)) {
            throwExceptionIf((dOrigin_point_index!= null));
            sqlBuilder.itemWhere(ModelTTask.FI_ORIGIN_POINT_INDEX, ColumnDataType.intData);
        } else {
            if (dOrigin_point_index!= null) {
                sqlBuilder.itemCol(ModelTTask.FI_ORIGIN_POINT_INDEX);
            }
        }
        Integer dTask_depends_on = instance.getTaskDependsOn();
        if (conditionField.contains(ModelTTask.FI_TASK_DEPENDS_ON)) {
            throwExceptionIf((dTask_depends_on!= null));
            sqlBuilder.itemWhere(ModelTTask.FI_TASK_DEPENDS_ON, ColumnDataType.intData);
        } else {
            if (dTask_depends_on!= null) {
                sqlBuilder.itemCol(ModelTTask.FI_TASK_DEPENDS_ON);
            }
        }
        Integer dTask_parent_id = instance.getTaskParentId();
        if (conditionField.contains(ModelTTask.FI_TASK_PARENT_ID)) {
            throwExceptionIf((dTask_parent_id!= null));
            sqlBuilder.itemWhere(ModelTTask.FI_TASK_PARENT_ID, ColumnDataType.intData);
        } else {
            if (dTask_parent_id!= null) {
                sqlBuilder.itemCol(ModelTTask.FI_TASK_PARENT_ID);
            }
        }
        Integer dTask_group_id = instance.getTaskGroupId();
        if (conditionField.contains(ModelTTask.FI_TASK_GROUP_ID)) {
            throwExceptionIf((dTask_group_id!= null));
            sqlBuilder.itemWhere(ModelTTask.FI_TASK_GROUP_ID, ColumnDataType.intData);
        } else {
            if (dTask_group_id!= null) {
                sqlBuilder.itemCol(ModelTTask.FI_TASK_GROUP_ID);
            }
        }
        EnumTaskType dTask_type = instance.getTaskType();
        if (conditionField.contains(ModelTTask.FI_TASK_TYPE)) {
            throwExceptionIf((dTask_type!= null));
            sqlBuilder.itemWhere(ModelTTask.FI_TASK_TYPE, ColumnDataType.byteData);
        } else {
            if (dTask_type!= null) {
                sqlBuilder.itemCol(ModelTTask.FI_TASK_TYPE);
            }
        }
        Integer dTask_appointed_device = instance.getTaskAppointedDevice();
        if (conditionField.contains(ModelTTask.FI_TASK_APPOINTED_DEVICE)) {
            throwExceptionIf((dTask_appointed_device!= null));
            sqlBuilder.itemWhere(ModelTTask.FI_TASK_APPOINTED_DEVICE, ColumnDataType.intData);
        } else {
            if (dTask_appointed_device!= null) {
                sqlBuilder.itemCol(ModelTTask.FI_TASK_APPOINTED_DEVICE);
            }
        }
        Integer dTask_priority = instance.getTaskPriority();
        if (conditionField.contains(ModelTTask.FI_TASK_PRIORITY)) {
            throwExceptionIf((dTask_priority!= null));
            sqlBuilder.itemWhere(ModelTTask.FI_TASK_PRIORITY, ColumnDataType.intData);
        } else {
            if (dTask_priority!= null) {
                sqlBuilder.itemCol(ModelTTask.FI_TASK_PRIORITY);
            }
        }
        Integer dRetry_times = instance.getRetryTimes();
        if (conditionField.contains(ModelTTask.FI_RETRY_TIMES)) {
            throwExceptionIf((dRetry_times!= null));
            sqlBuilder.itemWhere(ModelTTask.FI_RETRY_TIMES, ColumnDataType.intData);
        } else {
            if (dRetry_times!= null) {
                sqlBuilder.itemCol(ModelTTask.FI_RETRY_TIMES);
            }
        }
        Integer dCurrent_arix_x = instance.getCurrentArixX();
        if (conditionField.contains(ModelTTask.FI_CURRENT_ARIX_X)) {
            throwExceptionIf((dCurrent_arix_x!= null));
            sqlBuilder.itemWhere(ModelTTask.FI_CURRENT_ARIX_X, ColumnDataType.intData);
        } else {
            if (dCurrent_arix_x!= null) {
                sqlBuilder.itemCol(ModelTTask.FI_CURRENT_ARIX_X);
            }
        }
        Integer dCurrent_arix_y = instance.getCurrentArixY();
        if (conditionField.contains(ModelTTask.FI_CURRENT_ARIX_Y)) {
            throwExceptionIf((dCurrent_arix_y!= null));
            sqlBuilder.itemWhere(ModelTTask.FI_CURRENT_ARIX_Y, ColumnDataType.intData);
        } else {
            if (dCurrent_arix_y!= null) {
                sqlBuilder.itemCol(ModelTTask.FI_CURRENT_ARIX_Y);
            }
        }
        Integer dCurrent_arix_z = instance.getCurrentArixZ();
        if (conditionField.contains(ModelTTask.FI_CURRENT_ARIX_Z)) {
            throwExceptionIf((dCurrent_arix_z!= null));
            sqlBuilder.itemWhere(ModelTTask.FI_CURRENT_ARIX_Z, ColumnDataType.intData);
        } else {
            if (dCurrent_arix_z!= null) {
                sqlBuilder.itemCol(ModelTTask.FI_CURRENT_ARIX_Z);
            }
        }
        Integer dCurrent_point_index = instance.getCurrentPointIndex();
        if (conditionField.contains(ModelTTask.FI_CURRENT_POINT_INDEX)) {
            throwExceptionIf((dCurrent_point_index!= null));
            sqlBuilder.itemWhere(ModelTTask.FI_CURRENT_POINT_INDEX, ColumnDataType.intData);
        } else {
            if (dCurrent_point_index!= null) {
                sqlBuilder.itemCol(ModelTTask.FI_CURRENT_POINT_INDEX);
            }
        }
        Integer dCurrent_waiting_device = instance.getCurrentWaitingDevice();
        if (conditionField.contains(ModelTTask.FI_CURRENT_WAITING_DEVICE)) {
            throwExceptionIf((dCurrent_waiting_device!= null));
            sqlBuilder.itemWhere(ModelTTask.FI_CURRENT_WAITING_DEVICE, ColumnDataType.intData);
        } else {
            if (dCurrent_waiting_device!= null) {
                sqlBuilder.itemCol(ModelTTask.FI_CURRENT_WAITING_DEVICE);
            }
        }
        Map<String, Object> param = Constants.T_TASK_MAP_OBJ_MAPPER.toCommonMap(instance);
        return super.update(assembler, sqlBuilder, param);
    }

    public Integer update(ModelTTask instance, Set<String> conditionField) {
        return update(instance, conditionField, null);
    }

    public Integer updateById(ModelTTask instance, DaoAssembler assembler) {
        SQLUpdate sqlBuilder = SQLBuilder.buildUpdateSql();
        sqlBuilder.table(ModelTTask.DTO_TABLE_NAME);
        throwExceptionIf((instance.getId()!= null));
        sqlBuilder.itemWhere("__id", ColumnDataType.intData);
        Integer dId = instance.getId();
        if (dId!= null) {
            sqlBuilder.itemCol(ModelTTask.FI_ID);
        }
        Date dTask_create_time = instance.getTaskCreateTime();
        if (dTask_create_time!= null) {
            sqlBuilder.itemCol(ModelTTask.FI_TASK_CREATE_TIME);
        }
        Date dTask_expected_start_time = instance.getTaskExpectedStartTime();
        if (dTask_expected_start_time!= null) {
            sqlBuilder.itemCol(ModelTTask.FI_TASK_EXPECTED_START_TIME);
        }
        Date dTask_start_time = instance.getTaskStartTime();
        if (dTask_start_time!= null) {
            sqlBuilder.itemCol(ModelTTask.FI_TASK_START_TIME);
        }
        Date dTask_finish_time = instance.getTaskFinishTime();
        if (dTask_finish_time!= null) {
            sqlBuilder.itemCol(ModelTTask.FI_TASK_FINISH_TIME);
        }
        String dTask_remark = instance.getTaskRemark();
        if (dTask_remark!= null) {
            sqlBuilder.itemCol(ModelTTask.FI_TASK_REMARK);
        }
        Integer dTask_order_id = instance.getTaskOrderId();
        if (dTask_order_id!= null) {
            sqlBuilder.itemCol(ModelTTask.FI_TASK_ORDER_ID);
        }
        String dTask_param = instance.getTaskParam();
        if (dTask_param!= null) {
            sqlBuilder.itemCol(ModelTTask.FI_TASK_PARAM);
        }
        EnumTaskStatus dTask_status = instance.getTaskStatus();
        if (dTask_status!= null) {
            sqlBuilder.itemCol(ModelTTask.FI_TASK_STATUS);
        }
        Short dTask_total_path = instance.getTaskTotalPath();
        if (dTask_total_path!= null) {
            sqlBuilder.itemCol(ModelTTask.FI_TASK_TOTAL_PATH);
        }
        Integer dTask_current_path_id = instance.getTaskCurrentPathId();
        if (dTask_current_path_id!= null) {
            sqlBuilder.itemCol(ModelTTask.FI_TASK_CURRENT_PATH_ID);
        }
        Short dTask_current_path_index = instance.getTaskCurrentPathIndex();
        if (dTask_current_path_index!= null) {
            sqlBuilder.itemCol(ModelTTask.FI_TASK_CURRENT_PATH_INDEX);
        }
        Integer dArix_x = instance.getArixX();
        if (dArix_x!= null) {
            sqlBuilder.itemCol(ModelTTask.FI_ARIX_X);
        }
        Integer dArix_y = instance.getArixY();
        if (dArix_y!= null) {
            sqlBuilder.itemCol(ModelTTask.FI_ARIX_Y);
        }
        Integer dArix_z = instance.getArixZ();
        if (dArix_z!= null) {
            sqlBuilder.itemCol(ModelTTask.FI_ARIX_Z);
        }
        Integer dPoint_index = instance.getPointIndex();
        if (dPoint_index!= null) {
            sqlBuilder.itemCol(ModelTTask.FI_POINT_INDEX);
        }
        String dGoods_id = instance.getGoodsId();
        if (dGoods_id!= null) {
            sqlBuilder.itemCol(ModelTTask.FI_GOODS_ID);
        }
        String dGoods_info = instance.getGoodsInfo();
        if (dGoods_info!= null) {
            sqlBuilder.itemCol(ModelTTask.FI_GOODS_INFO);
        }
        String dGoods_name = instance.getGoodsName();
        if (dGoods_name!= null) {
            sqlBuilder.itemCol(ModelTTask.FI_GOODS_NAME);
        }
        Integer dGoods_weight = instance.getGoodsWeight();
        if (dGoods_weight!= null) {
            sqlBuilder.itemCol(ModelTTask.FI_GOODS_WEIGHT);
        }
        Integer dOrigin_arix_x = instance.getOriginArixX();
        if (dOrigin_arix_x!= null) {
            sqlBuilder.itemCol(ModelTTask.FI_ORIGIN_ARIX_X);
        }
        Integer dOrigin_arix_y = instance.getOriginArixY();
        if (dOrigin_arix_y!= null) {
            sqlBuilder.itemCol(ModelTTask.FI_ORIGIN_ARIX_Y);
        }
        Integer dOrigin_arix_z = instance.getOriginArixZ();
        if (dOrigin_arix_z!= null) {
            sqlBuilder.itemCol(ModelTTask.FI_ORIGIN_ARIX_Z);
        }
        Integer dOrigin_point_index = instance.getOriginPointIndex();
        if (dOrigin_point_index!= null) {
            sqlBuilder.itemCol(ModelTTask.FI_ORIGIN_POINT_INDEX);
        }
        Integer dTask_depends_on = instance.getTaskDependsOn();
        if (dTask_depends_on!= null) {
            sqlBuilder.itemCol(ModelTTask.FI_TASK_DEPENDS_ON);
        }
        Integer dTask_parent_id = instance.getTaskParentId();
        if (dTask_parent_id!= null) {
            sqlBuilder.itemCol(ModelTTask.FI_TASK_PARENT_ID);
        }
        Integer dTask_group_id = instance.getTaskGroupId();
        if (dTask_group_id!= null) {
            sqlBuilder.itemCol(ModelTTask.FI_TASK_GROUP_ID);
        }
        EnumTaskType dTask_type = instance.getTaskType();
        if (dTask_type!= null) {
            sqlBuilder.itemCol(ModelTTask.FI_TASK_TYPE);
        }
        Integer dTask_appointed_device = instance.getTaskAppointedDevice();
        if (dTask_appointed_device!= null) {
            sqlBuilder.itemCol(ModelTTask.FI_TASK_APPOINTED_DEVICE);
        }
        Integer dTask_priority = instance.getTaskPriority();
        if (dTask_priority!= null) {
            sqlBuilder.itemCol(ModelTTask.FI_TASK_PRIORITY);
        }
        Integer dRetry_times = instance.getRetryTimes();
        if (dRetry_times!= null) {
            sqlBuilder.itemCol(ModelTTask.FI_RETRY_TIMES);
        }
        Integer dCurrent_arix_x = instance.getCurrentArixX();
        if (dCurrent_arix_x!= null) {
            sqlBuilder.itemCol(ModelTTask.FI_CURRENT_ARIX_X);
        }
        Integer dCurrent_arix_y = instance.getCurrentArixY();
        if (dCurrent_arix_y!= null) {
            sqlBuilder.itemCol(ModelTTask.FI_CURRENT_ARIX_Y);
        }
        Integer dCurrent_arix_z = instance.getCurrentArixZ();
        if (dCurrent_arix_z!= null) {
            sqlBuilder.itemCol(ModelTTask.FI_CURRENT_ARIX_Z);
        }
        Integer dCurrent_point_index = instance.getCurrentPointIndex();
        if (dCurrent_point_index!= null) {
            sqlBuilder.itemCol(ModelTTask.FI_CURRENT_POINT_INDEX);
        }
        Integer dCurrent_waiting_device = instance.getCurrentWaitingDevice();
        if (dCurrent_waiting_device!= null) {
            sqlBuilder.itemCol(ModelTTask.FI_CURRENT_WAITING_DEVICE);
        }
        Map<String, Object> param;
        param = Constants.T_TASK_MAP_OBJ_MAPPER.toCommonMap(instance);
        param.put("__id", instance.getId());
        return super.update(assembler, sqlBuilder, param);
    }

    public Integer updateById(ModelTTask instance) {
        return updateById(instance, null);
    }

    public Integer updateByIds(ModelTTask instance, Set<Integer> ids, DaoAssembler assembler) {
        SQLUpdate sqlBuilder = SQLBuilder.buildUpdateSql();
        sqlBuilder.table(ModelTTask.DTO_TABLE_NAME);
        throwExceptionIf(((ids!= null)&&(ids.size()> 0)));
        sqlBuilder.itemWhere(LogicalOpType.in, "__ids", "__ids", ColumnDataType.intData);
        Integer dId = instance.getId();
        instance.setId(null);
        Date dTask_create_time = instance.getTaskCreateTime();
        if (dTask_create_time!= null) {
            sqlBuilder.itemCol(ModelTTask.FI_TASK_CREATE_TIME);
        }
        Date dTask_expected_start_time = instance.getTaskExpectedStartTime();
        if (dTask_expected_start_time!= null) {
            sqlBuilder.itemCol(ModelTTask.FI_TASK_EXPECTED_START_TIME);
        }
        Date dTask_start_time = instance.getTaskStartTime();
        if (dTask_start_time!= null) {
            sqlBuilder.itemCol(ModelTTask.FI_TASK_START_TIME);
        }
        Date dTask_finish_time = instance.getTaskFinishTime();
        if (dTask_finish_time!= null) {
            sqlBuilder.itemCol(ModelTTask.FI_TASK_FINISH_TIME);
        }
        String dTask_remark = instance.getTaskRemark();
        if (dTask_remark!= null) {
            sqlBuilder.itemCol(ModelTTask.FI_TASK_REMARK);
        }
        Integer dTask_order_id = instance.getTaskOrderId();
        if (dTask_order_id!= null) {
            sqlBuilder.itemCol(ModelTTask.FI_TASK_ORDER_ID);
        }
        String dTask_param = instance.getTaskParam();
        if (dTask_param!= null) {
            sqlBuilder.itemCol(ModelTTask.FI_TASK_PARAM);
        }
        EnumTaskStatus dTask_status = instance.getTaskStatus();
        if (dTask_status!= null) {
            sqlBuilder.itemCol(ModelTTask.FI_TASK_STATUS);
        }
        Short dTask_total_path = instance.getTaskTotalPath();
        if (dTask_total_path!= null) {
            sqlBuilder.itemCol(ModelTTask.FI_TASK_TOTAL_PATH);
        }
        Integer dTask_current_path_id = instance.getTaskCurrentPathId();
        if (dTask_current_path_id!= null) {
            sqlBuilder.itemCol(ModelTTask.FI_TASK_CURRENT_PATH_ID);
        }
        Short dTask_current_path_index = instance.getTaskCurrentPathIndex();
        if (dTask_current_path_index!= null) {
            sqlBuilder.itemCol(ModelTTask.FI_TASK_CURRENT_PATH_INDEX);
        }
        Integer dArix_x = instance.getArixX();
        if (dArix_x!= null) {
            sqlBuilder.itemCol(ModelTTask.FI_ARIX_X);
        }
        Integer dArix_y = instance.getArixY();
        if (dArix_y!= null) {
            sqlBuilder.itemCol(ModelTTask.FI_ARIX_Y);
        }
        Integer dArix_z = instance.getArixZ();
        if (dArix_z!= null) {
            sqlBuilder.itemCol(ModelTTask.FI_ARIX_Z);
        }
        Integer dPoint_index = instance.getPointIndex();
        if (dPoint_index!= null) {
            sqlBuilder.itemCol(ModelTTask.FI_POINT_INDEX);
        }
        String dGoods_id = instance.getGoodsId();
        if (dGoods_id!= null) {
            sqlBuilder.itemCol(ModelTTask.FI_GOODS_ID);
        }
        String dGoods_info = instance.getGoodsInfo();
        if (dGoods_info!= null) {
            sqlBuilder.itemCol(ModelTTask.FI_GOODS_INFO);
        }
        String dGoods_name = instance.getGoodsName();
        if (dGoods_name!= null) {
            sqlBuilder.itemCol(ModelTTask.FI_GOODS_NAME);
        }
        Integer dGoods_weight = instance.getGoodsWeight();
        if (dGoods_weight!= null) {
            sqlBuilder.itemCol(ModelTTask.FI_GOODS_WEIGHT);
        }
        Integer dOrigin_arix_x = instance.getOriginArixX();
        if (dOrigin_arix_x!= null) {
            sqlBuilder.itemCol(ModelTTask.FI_ORIGIN_ARIX_X);
        }
        Integer dOrigin_arix_y = instance.getOriginArixY();
        if (dOrigin_arix_y!= null) {
            sqlBuilder.itemCol(ModelTTask.FI_ORIGIN_ARIX_Y);
        }
        Integer dOrigin_arix_z = instance.getOriginArixZ();
        if (dOrigin_arix_z!= null) {
            sqlBuilder.itemCol(ModelTTask.FI_ORIGIN_ARIX_Z);
        }
        Integer dOrigin_point_index = instance.getOriginPointIndex();
        if (dOrigin_point_index!= null) {
            sqlBuilder.itemCol(ModelTTask.FI_ORIGIN_POINT_INDEX);
        }
        Integer dTask_depends_on = instance.getTaskDependsOn();
        if (dTask_depends_on!= null) {
            sqlBuilder.itemCol(ModelTTask.FI_TASK_DEPENDS_ON);
        }
        Integer dTask_parent_id = instance.getTaskParentId();
        if (dTask_parent_id!= null) {
            sqlBuilder.itemCol(ModelTTask.FI_TASK_PARENT_ID);
        }
        Integer dTask_group_id = instance.getTaskGroupId();
        if (dTask_group_id!= null) {
            sqlBuilder.itemCol(ModelTTask.FI_TASK_GROUP_ID);
        }
        EnumTaskType dTask_type = instance.getTaskType();
        if (dTask_type!= null) {
            sqlBuilder.itemCol(ModelTTask.FI_TASK_TYPE);
        }
        Integer dTask_appointed_device = instance.getTaskAppointedDevice();
        if (dTask_appointed_device!= null) {
            sqlBuilder.itemCol(ModelTTask.FI_TASK_APPOINTED_DEVICE);
        }
        Integer dTask_priority = instance.getTaskPriority();
        if (dTask_priority!= null) {
            sqlBuilder.itemCol(ModelTTask.FI_TASK_PRIORITY);
        }
        Integer dRetry_times = instance.getRetryTimes();
        if (dRetry_times!= null) {
            sqlBuilder.itemCol(ModelTTask.FI_RETRY_TIMES);
        }
        Integer dCurrent_arix_x = instance.getCurrentArixX();
        if (dCurrent_arix_x!= null) {
            sqlBuilder.itemCol(ModelTTask.FI_CURRENT_ARIX_X);
        }
        Integer dCurrent_arix_y = instance.getCurrentArixY();
        if (dCurrent_arix_y!= null) {
            sqlBuilder.itemCol(ModelTTask.FI_CURRENT_ARIX_Y);
        }
        Integer dCurrent_arix_z = instance.getCurrentArixZ();
        if (dCurrent_arix_z!= null) {
            sqlBuilder.itemCol(ModelTTask.FI_CURRENT_ARIX_Z);
        }
        Integer dCurrent_point_index = instance.getCurrentPointIndex();
        if (dCurrent_point_index!= null) {
            sqlBuilder.itemCol(ModelTTask.FI_CURRENT_POINT_INDEX);
        }
        Integer dCurrent_waiting_device = instance.getCurrentWaitingDevice();
        if (dCurrent_waiting_device!= null) {
            sqlBuilder.itemCol(ModelTTask.FI_CURRENT_WAITING_DEVICE);
        }
        Map<String, Object> param;
        param = Constants.T_TASK_MAP_OBJ_MAPPER.toCommonMap(instance);
        param.put("__ids", ids);
        return super.update(assembler, sqlBuilder, param);
    }

    public Integer updateByIds(ModelTTask instance, Set<Integer> ids) {
        return updateByIds(instance, ids, null);
    }

    public Integer deleteById(Integer id, DaoAssembler assembler) {
        SQLDelete sqlBuilder = SQLBuilder.buildDeleteSql();
        sqlBuilder.table(ModelTTask.DTO_TABLE_NAME);
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
        sqlBuilder.table(ModelTTask.DTO_TABLE_NAME);
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
    public ModelTTask updateOrInsert(ModelTTask instance, Set<String> conditionField, AbstractMultipleDaoAssembler assembler) {
        if (assembler == null) {
            assembler = new BaseMultipleDaoAssembler();
        }
        ModelTTask checkInstance = new ModelTTask();
        if (conditionField.contains(ModelTTask.FI_ID)) {
            checkInstance.setId(instance.getId());
        }
        if (conditionField.contains(ModelTTask.FI_TASK_CREATE_TIME)) {
            checkInstance.setTaskCreateTime(instance.getTaskCreateTime());
        }
        if (conditionField.contains(ModelTTask.FI_TASK_EXPECTED_START_TIME)) {
            checkInstance.setTaskExpectedStartTime(instance.getTaskExpectedStartTime());
        }
        if (conditionField.contains(ModelTTask.FI_TASK_START_TIME)) {
            checkInstance.setTaskStartTime(instance.getTaskStartTime());
        }
        if (conditionField.contains(ModelTTask.FI_TASK_FINISH_TIME)) {
            checkInstance.setTaskFinishTime(instance.getTaskFinishTime());
        }
        if (conditionField.contains(ModelTTask.FI_TASK_REMARK)) {
            checkInstance.setTaskRemark(instance.getTaskRemark());
        }
        if (conditionField.contains(ModelTTask.FI_TASK_ORDER_ID)) {
            checkInstance.setTaskOrderId(instance.getTaskOrderId());
        }
        if (conditionField.contains(ModelTTask.FI_TASK_PARAM)) {
            checkInstance.setTaskParam(instance.getTaskParam());
        }
        if (conditionField.contains(ModelTTask.FI_TASK_STATUS)) {
            checkInstance.setTaskStatus(instance.getTaskStatus());
        }
        if (conditionField.contains(ModelTTask.FI_TASK_TOTAL_PATH)) {
            checkInstance.setTaskTotalPath(instance.getTaskTotalPath());
        }
        if (conditionField.contains(ModelTTask.FI_TASK_CURRENT_PATH_ID)) {
            checkInstance.setTaskCurrentPathId(instance.getTaskCurrentPathId());
        }
        if (conditionField.contains(ModelTTask.FI_TASK_CURRENT_PATH_INDEX)) {
            checkInstance.setTaskCurrentPathIndex(instance.getTaskCurrentPathIndex());
        }
        if (conditionField.contains(ModelTTask.FI_ARIX_X)) {
            checkInstance.setArixX(instance.getArixX());
        }
        if (conditionField.contains(ModelTTask.FI_ARIX_Y)) {
            checkInstance.setArixY(instance.getArixY());
        }
        if (conditionField.contains(ModelTTask.FI_ARIX_Z)) {
            checkInstance.setArixZ(instance.getArixZ());
        }
        if (conditionField.contains(ModelTTask.FI_POINT_INDEX)) {
            checkInstance.setPointIndex(instance.getPointIndex());
        }
        if (conditionField.contains(ModelTTask.FI_GOODS_ID)) {
            checkInstance.setGoodsId(instance.getGoodsId());
        }
        if (conditionField.contains(ModelTTask.FI_GOODS_INFO)) {
            checkInstance.setGoodsInfo(instance.getGoodsInfo());
        }
        if (conditionField.contains(ModelTTask.FI_GOODS_NAME)) {
            checkInstance.setGoodsName(instance.getGoodsName());
        }
        if (conditionField.contains(ModelTTask.FI_GOODS_WEIGHT)) {
            checkInstance.setGoodsWeight(instance.getGoodsWeight());
        }
        if (conditionField.contains(ModelTTask.FI_ORIGIN_ARIX_X)) {
            checkInstance.setOriginArixX(instance.getOriginArixX());
        }
        if (conditionField.contains(ModelTTask.FI_ORIGIN_ARIX_Y)) {
            checkInstance.setOriginArixY(instance.getOriginArixY());
        }
        if (conditionField.contains(ModelTTask.FI_ORIGIN_ARIX_Z)) {
            checkInstance.setOriginArixZ(instance.getOriginArixZ());
        }
        if (conditionField.contains(ModelTTask.FI_ORIGIN_POINT_INDEX)) {
            checkInstance.setOriginPointIndex(instance.getOriginPointIndex());
        }
        if (conditionField.contains(ModelTTask.FI_TASK_DEPENDS_ON)) {
            checkInstance.setTaskDependsOn(instance.getTaskDependsOn());
        }
        if (conditionField.contains(ModelTTask.FI_TASK_PARENT_ID)) {
            checkInstance.setTaskParentId(instance.getTaskParentId());
        }
        if (conditionField.contains(ModelTTask.FI_TASK_GROUP_ID)) {
            checkInstance.setTaskGroupId(instance.getTaskGroupId());
        }
        if (conditionField.contains(ModelTTask.FI_TASK_TYPE)) {
            checkInstance.setTaskType(instance.getTaskType());
        }
        if (conditionField.contains(ModelTTask.FI_TASK_APPOINTED_DEVICE)) {
            checkInstance.setTaskAppointedDevice(instance.getTaskAppointedDevice());
        }
        if (conditionField.contains(ModelTTask.FI_TASK_PRIORITY)) {
            checkInstance.setTaskPriority(instance.getTaskPriority());
        }
        if (conditionField.contains(ModelTTask.FI_RETRY_TIMES)) {
            checkInstance.setRetryTimes(instance.getRetryTimes());
        }
        if (conditionField.contains(ModelTTask.FI_CURRENT_ARIX_X)) {
            checkInstance.setCurrentArixX(instance.getCurrentArixX());
        }
        if (conditionField.contains(ModelTTask.FI_CURRENT_ARIX_Y)) {
            checkInstance.setCurrentArixY(instance.getCurrentArixY());
        }
        if (conditionField.contains(ModelTTask.FI_CURRENT_ARIX_Z)) {
            checkInstance.setCurrentArixZ(instance.getCurrentArixZ());
        }
        if (conditionField.contains(ModelTTask.FI_CURRENT_POINT_INDEX)) {
            checkInstance.setCurrentPointIndex(instance.getCurrentPointIndex());
        }
        if (conditionField.contains(ModelTTask.FI_CURRENT_WAITING_DEVICE)) {
            checkInstance.setCurrentWaitingDevice(instance.getCurrentWaitingDevice());
        }
        ModelTTask selected = getOneByCond(Collections.singleton(ModelTTask.FI_ID), assembler, checkInstance);
        assembler.increaseIndex();
        if (selected == null) {
            return insert(instance, assembler);
        } else {
            instance.setId(selected.getId());
            update(instance, Collections.singleton(ModelTTask.FI_ID), assembler);
            return instance;
        }
    }

    public ModelTTask updateOrInsert(ModelTTask instance, Set<String> conditionField) {
        return updateOrInsert(instance, conditionField, null);
    }

    @Transactional
    public ModelTTask insertIfNoExist(ModelTTask instance, Set<String> conditionField, AbstractMultipleDaoAssembler assembler) {
        if (assembler == null) {
            assembler = new BaseMultipleDaoAssembler();
        }
        ModelTTask checkInstance = new ModelTTask();
        if (conditionField.contains(ModelTTask.FI_ID)) {
            checkInstance.setId(instance.getId());
        }
        if (conditionField.contains(ModelTTask.FI_TASK_CREATE_TIME)) {
            checkInstance.setTaskCreateTime(instance.getTaskCreateTime());
        }
        if (conditionField.contains(ModelTTask.FI_TASK_EXPECTED_START_TIME)) {
            checkInstance.setTaskExpectedStartTime(instance.getTaskExpectedStartTime());
        }
        if (conditionField.contains(ModelTTask.FI_TASK_START_TIME)) {
            checkInstance.setTaskStartTime(instance.getTaskStartTime());
        }
        if (conditionField.contains(ModelTTask.FI_TASK_FINISH_TIME)) {
            checkInstance.setTaskFinishTime(instance.getTaskFinishTime());
        }
        if (conditionField.contains(ModelTTask.FI_TASK_REMARK)) {
            checkInstance.setTaskRemark(instance.getTaskRemark());
        }
        if (conditionField.contains(ModelTTask.FI_TASK_ORDER_ID)) {
            checkInstance.setTaskOrderId(instance.getTaskOrderId());
        }
        if (conditionField.contains(ModelTTask.FI_TASK_PARAM)) {
            checkInstance.setTaskParam(instance.getTaskParam());
        }
        if (conditionField.contains(ModelTTask.FI_TASK_STATUS)) {
            checkInstance.setTaskStatus(instance.getTaskStatus());
        }
        if (conditionField.contains(ModelTTask.FI_TASK_TOTAL_PATH)) {
            checkInstance.setTaskTotalPath(instance.getTaskTotalPath());
        }
        if (conditionField.contains(ModelTTask.FI_TASK_CURRENT_PATH_ID)) {
            checkInstance.setTaskCurrentPathId(instance.getTaskCurrentPathId());
        }
        if (conditionField.contains(ModelTTask.FI_TASK_CURRENT_PATH_INDEX)) {
            checkInstance.setTaskCurrentPathIndex(instance.getTaskCurrentPathIndex());
        }
        if (conditionField.contains(ModelTTask.FI_ARIX_X)) {
            checkInstance.setArixX(instance.getArixX());
        }
        if (conditionField.contains(ModelTTask.FI_ARIX_Y)) {
            checkInstance.setArixY(instance.getArixY());
        }
        if (conditionField.contains(ModelTTask.FI_ARIX_Z)) {
            checkInstance.setArixZ(instance.getArixZ());
        }
        if (conditionField.contains(ModelTTask.FI_POINT_INDEX)) {
            checkInstance.setPointIndex(instance.getPointIndex());
        }
        if (conditionField.contains(ModelTTask.FI_GOODS_ID)) {
            checkInstance.setGoodsId(instance.getGoodsId());
        }
        if (conditionField.contains(ModelTTask.FI_GOODS_INFO)) {
            checkInstance.setGoodsInfo(instance.getGoodsInfo());
        }
        if (conditionField.contains(ModelTTask.FI_GOODS_NAME)) {
            checkInstance.setGoodsName(instance.getGoodsName());
        }
        if (conditionField.contains(ModelTTask.FI_GOODS_WEIGHT)) {
            checkInstance.setGoodsWeight(instance.getGoodsWeight());
        }
        if (conditionField.contains(ModelTTask.FI_ORIGIN_ARIX_X)) {
            checkInstance.setOriginArixX(instance.getOriginArixX());
        }
        if (conditionField.contains(ModelTTask.FI_ORIGIN_ARIX_Y)) {
            checkInstance.setOriginArixY(instance.getOriginArixY());
        }
        if (conditionField.contains(ModelTTask.FI_ORIGIN_ARIX_Z)) {
            checkInstance.setOriginArixZ(instance.getOriginArixZ());
        }
        if (conditionField.contains(ModelTTask.FI_ORIGIN_POINT_INDEX)) {
            checkInstance.setOriginPointIndex(instance.getOriginPointIndex());
        }
        if (conditionField.contains(ModelTTask.FI_TASK_DEPENDS_ON)) {
            checkInstance.setTaskDependsOn(instance.getTaskDependsOn());
        }
        if (conditionField.contains(ModelTTask.FI_TASK_PARENT_ID)) {
            checkInstance.setTaskParentId(instance.getTaskParentId());
        }
        if (conditionField.contains(ModelTTask.FI_TASK_GROUP_ID)) {
            checkInstance.setTaskGroupId(instance.getTaskGroupId());
        }
        if (conditionField.contains(ModelTTask.FI_TASK_TYPE)) {
            checkInstance.setTaskType(instance.getTaskType());
        }
        if (conditionField.contains(ModelTTask.FI_TASK_APPOINTED_DEVICE)) {
            checkInstance.setTaskAppointedDevice(instance.getTaskAppointedDevice());
        }
        if (conditionField.contains(ModelTTask.FI_TASK_PRIORITY)) {
            checkInstance.setTaskPriority(instance.getTaskPriority());
        }
        if (conditionField.contains(ModelTTask.FI_RETRY_TIMES)) {
            checkInstance.setRetryTimes(instance.getRetryTimes());
        }
        if (conditionField.contains(ModelTTask.FI_CURRENT_ARIX_X)) {
            checkInstance.setCurrentArixX(instance.getCurrentArixX());
        }
        if (conditionField.contains(ModelTTask.FI_CURRENT_ARIX_Y)) {
            checkInstance.setCurrentArixY(instance.getCurrentArixY());
        }
        if (conditionField.contains(ModelTTask.FI_CURRENT_ARIX_Z)) {
            checkInstance.setCurrentArixZ(instance.getCurrentArixZ());
        }
        if (conditionField.contains(ModelTTask.FI_CURRENT_POINT_INDEX)) {
            checkInstance.setCurrentPointIndex(instance.getCurrentPointIndex());
        }
        if (conditionField.contains(ModelTTask.FI_CURRENT_WAITING_DEVICE)) {
            checkInstance.setCurrentWaitingDevice(instance.getCurrentWaitingDevice());
        }
        ModelTTask selected = getOneByCond(Collections.singleton(ModelTTask.FI_ID), assembler, checkInstance);
        assembler.increaseIndex();
        if (selected == null) {
            return insert(instance, assembler);
        } else {
            instance.setId(selected.getId());
            return instance;
        }
    }

    public ModelTTask insertIfNoExist(ModelTTask instance, Set<String> conditionField) {
        return insertIfNoExist(instance, conditionField, null);
    }

    public<TT> Map<TT, ModelTTask> buildMap(List<ModelTTask> list, String field) {
        Map<TT, ModelTTask> ret = CollectionHelper.newMap();
        if (list == null) {
            return ret;
        }
        for (ModelTTask item: list) {
            ret.put(Constants.T_TASK_MAP_OBJ_MAPPER.<TT> getField(field, item), item);
        }
        return ret;
    }

    public<TT> Map<TT, List<ModelTTask>> buildListMap(List<ModelTTask> list, String field) {
        Map<TT, List<ModelTTask>> ret = CollectionHelper.newMap();
        if (list == null) {
            return ret;
        }
        for (ModelTTask item: list) {
            List<ModelTTask> itemList = ret.get(Constants.T_TASK_MAP_OBJ_MAPPER.<TT> getField(field, item));
            if (itemList == null) {
                itemList = CollectionHelper.newList();
            }
            itemList.add(item);
            ret.put(Constants.T_TASK_MAP_OBJ_MAPPER.<TT> getField(field, item), itemList);
        }
        return ret;
    }

    public<TT> List<TT> extractItemAsList(List<ModelTTask> list, String field) {
        List<TT> ret = CollectionHelper.newList();
        if ((list == null)||(list.size() == 0)) {
            return ret;
        }
        if (ModelTTask.FIELD_CLASS.containsKey(field)) {
            for (ModelTTask item: list) {
                ret.add(Constants.T_TASK_MAP_OBJ_MAPPER.<TT> getField(field, item));
            }
        }
        return ret;
    }
}
