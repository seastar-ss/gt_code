package com.shangde.ent_portal.logical.dao.basedao;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map;
import java.util.Set;
import com.shangde.ent_portal.logical.contants.Constants;
import com.shangde.ent_portal.logical.dto.enums.EnumDeviceControlStatus;
import com.shangde.ent_portal.logical.dto.enums.EnumDeviceStatusType;
import com.shangde.ent_portal.logical.dto.enums.EnumYesOrNo;
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
import com.shangde.ent_portal.logical.dto.basepo.ModelTDevice;

@Repository("DAOTDevice")
@SuppressWarnings("unchecked")
public class DAOTDevice
    extends AbstractDao<com.shangde.ent_portal.logical.dto.basepo.ModelTDevice, Integer>
    implements DaoInterface<com.shangde.ent_portal.logical.dto.basepo.ModelTDevice, Integer> , InitializingBean
{
    public final static Logger logger = LoggerFactory.getLogger(DAOTDevice.class);

    public DAOTDevice() {
        super(com.shangde.ent_portal.logical.dto.basepo.ModelTDevice.class, Constants.T_DEVICE_RESULT_SET_OBJ_MAPPER);
    }

    @Override
    public void afterPropertiesSet()
        throws Exception
    {
    }

    protected void buildInClause(SQLSelect sqlBuilder, String inField, Map<String, Object> param, List indexes) {
        if (ModelTDevice.FIELD_CLASS.containsKey(inField)) {
            Object fieldClassObj = ModelTDevice.FIELD_CLASS.get(inField);
            super.buildRawInCluase(sqlBuilder, param, inField, fieldClassObj, indexes);
        } else {
            logger.error("field parameter error");
            throw new IllegalArgumentException(((("there is mistake with infield parameter, column "+ inField)+" not found in table ")+ com.shangde.ent_portal.logical.dto.basepo.ModelTDevice.DTO_TABLE_NAME));
        }
    }

    protected void buildConditionCluase(SQLSelect sqlBuilder, ModelTDevice instance, Map<String, Object> param) {
        Integer dId = instance.getId();
        if (dId!= null) {
            sqlBuilder.itemWhere(ModelTDevice.FI_ID, ColumnDataType.intData);
            param.put(ModelTDevice.FI_ID, dId);
        }
        EnumDeviceStatusType dDevice_status = instance.getDeviceStatus();
        if (dDevice_status!= null) {
            sqlBuilder.itemWhere(ModelTDevice.FI_DEVICE_STATUS, ColumnDataType.byteData);
            param.put(ModelTDevice.FI_DEVICE_STATUS, dDevice_status.val);
        }
        String dDevice_ip = instance.getDeviceIp();
        if (dDevice_ip!= null) {
            sqlBuilder.itemWhere(ModelTDevice.FI_DEVICE_IP, ColumnDataType.stringData);
            param.put(ModelTDevice.FI_DEVICE_IP, dDevice_ip);
        }
        Integer dDevice_proc = instance.getDeviceProc();
        if (dDevice_proc!= null) {
            sqlBuilder.itemWhere(ModelTDevice.FI_DEVICE_PROC, ColumnDataType.intData);
            param.put(ModelTDevice.FI_DEVICE_PROC, dDevice_proc);
        }
        String dDevice_name = instance.getDeviceName();
        if (dDevice_name!= null) {
            sqlBuilder.itemWhere(ModelTDevice.FI_DEVICE_NAME, ColumnDataType.stringData);
            param.put(ModelTDevice.FI_DEVICE_NAME, dDevice_name);
        }
        String dDevice_desp = instance.getDeviceDesp();
        if (dDevice_desp!= null) {
            sqlBuilder.itemWhere(ModelTDevice.FI_DEVICE_DESP, ColumnDataType.stringData);
            param.put(ModelTDevice.FI_DEVICE_DESP, dDevice_desp);
        }
        Date dDevice_create_time = instance.getDeviceCreateTime();
        if (dDevice_create_time!= null) {
            sqlBuilder.itemWhere(ModelTDevice.FI_DEVICE_CREATE_TIME, ColumnDataType.timeStampData);
            param.put(ModelTDevice.FI_DEVICE_CREATE_TIME, dDevice_create_time);
        }
        Date dDevice_update_time = instance.getDeviceUpdateTime();
        if (dDevice_update_time!= null) {
            sqlBuilder.itemWhere(ModelTDevice.FI_DEVICE_UPDATE_TIME, ColumnDataType.timeStampData);
            param.put(ModelTDevice.FI_DEVICE_UPDATE_TIME, dDevice_update_time);
        }
        Byte dDevice_delete_flag = instance.getDeviceDeleteFlag();
        if (dDevice_delete_flag!= null) {
            sqlBuilder.itemWhere(ModelTDevice.FI_DEVICE_DELETE_FLAG, ColumnDataType.byteData);
            param.put(ModelTDevice.FI_DEVICE_DELETE_FLAG, dDevice_delete_flag);
        }
        Integer dDevice_type = instance.getDeviceType();
        if (dDevice_type!= null) {
            sqlBuilder.itemWhere(ModelTDevice.FI_DEVICE_TYPE, ColumnDataType.intData);
            param.put(ModelTDevice.FI_DEVICE_TYPE, dDevice_type);
        }
        String dDevice_remark = instance.getDeviceRemark();
        if (dDevice_remark!= null) {
            sqlBuilder.itemWhere(ModelTDevice.FI_DEVICE_REMARK, ColumnDataType.stringData);
            param.put(ModelTDevice.FI_DEVICE_REMARK, dDevice_remark);
        }
        String dDevice_hardware_id = instance.getDeviceHardwareId();
        if (dDevice_hardware_id!= null) {
            sqlBuilder.itemWhere(ModelTDevice.FI_DEVICE_HARDWARE_ID, ColumnDataType.stringData);
            param.put(ModelTDevice.FI_DEVICE_HARDWARE_ID, dDevice_hardware_id);
        }
        String dDevice_last_order_param = instance.getDeviceLastOrderParam();
        if (dDevice_last_order_param!= null) {
            sqlBuilder.itemWhere(ModelTDevice.FI_DEVICE_LAST_ORDER_PARAM, ColumnDataType.stringData);
            param.put(ModelTDevice.FI_DEVICE_LAST_ORDER_PARAM, dDevice_last_order_param);
        }
        Date dDevice_last_check_time = instance.getDeviceLastCheckTime();
        if (dDevice_last_check_time!= null) {
            sqlBuilder.itemWhere(ModelTDevice.FI_DEVICE_LAST_CHECK_TIME, ColumnDataType.timeStampData);
            param.put(ModelTDevice.FI_DEVICE_LAST_CHECK_TIME, dDevice_last_check_time);
        }
        Integer dDevice_arix_x = instance.getDeviceArixX();
        if (dDevice_arix_x!= null) {
            sqlBuilder.itemWhere(ModelTDevice.FI_DEVICE_ARIX_X, ColumnDataType.intData);
            param.put(ModelTDevice.FI_DEVICE_ARIX_X, dDevice_arix_x);
        }
        Integer dDevice_arix_y = instance.getDeviceArixY();
        if (dDevice_arix_y!= null) {
            sqlBuilder.itemWhere(ModelTDevice.FI_DEVICE_ARIX_Y, ColumnDataType.intData);
            param.put(ModelTDevice.FI_DEVICE_ARIX_Y, dDevice_arix_y);
        }
        Integer dDevice_arix_z = instance.getDeviceArixZ();
        if (dDevice_arix_z!= null) {
            sqlBuilder.itemWhere(ModelTDevice.FI_DEVICE_ARIX_Z, ColumnDataType.intData);
            param.put(ModelTDevice.FI_DEVICE_ARIX_Z, dDevice_arix_z);
        }
        Date dDevice_last_ocupy_time = instance.getDeviceLastOcupyTime();
        if (dDevice_last_ocupy_time!= null) {
            sqlBuilder.itemWhere(ModelTDevice.FI_DEVICE_LAST_OCUPY_TIME, ColumnDataType.timeStampData);
            param.put(ModelTDevice.FI_DEVICE_LAST_OCUPY_TIME, dDevice_last_ocupy_time);
        }
        Date dDevice_last_release_time = instance.getDeviceLastReleaseTime();
        if (dDevice_last_release_time!= null) {
            sqlBuilder.itemWhere(ModelTDevice.FI_DEVICE_LAST_RELEASE_TIME, ColumnDataType.timeStampData);
            param.put(ModelTDevice.FI_DEVICE_LAST_RELEASE_TIME, dDevice_last_release_time);
        }
        Integer dDevice_task_id = instance.getDeviceTaskId();
        if (dDevice_task_id!= null) {
            sqlBuilder.itemWhere(ModelTDevice.FI_DEVICE_TASK_ID, ColumnDataType.intData);
            param.put(ModelTDevice.FI_DEVICE_TASK_ID, dDevice_task_id);
        }
        Integer dDevice_last_proc = instance.getDeviceLastProc();
        if (dDevice_last_proc!= null) {
            sqlBuilder.itemWhere(ModelTDevice.FI_DEVICE_LAST_PROC, ColumnDataType.intData);
            param.put(ModelTDevice.FI_DEVICE_LAST_PROC, dDevice_last_proc);
        }
        Integer dDevice_battery = instance.getDeviceBattery();
        if (dDevice_battery!= null) {
            sqlBuilder.itemWhere(ModelTDevice.FI_DEVICE_BATTERY, ColumnDataType.intData);
            param.put(ModelTDevice.FI_DEVICE_BATTERY, dDevice_battery);
        }
        Integer dDevice_goods_holder_num = instance.getDeviceGoodsHolderNum();
        if (dDevice_goods_holder_num!= null) {
            sqlBuilder.itemWhere(ModelTDevice.FI_DEVICE_GOODS_HOLDER_NUM, ColumnDataType.intData);
            param.put(ModelTDevice.FI_DEVICE_GOODS_HOLDER_NUM, dDevice_goods_holder_num);
        }
        Integer dDevice_group = instance.getDeviceGroup();
        if (dDevice_group!= null) {
            sqlBuilder.itemWhere(ModelTDevice.FI_DEVICE_GROUP, ColumnDataType.intData);
            param.put(ModelTDevice.FI_DEVICE_GROUP, dDevice_group);
        }
        Integer dDevice_attach_map_point = instance.getDeviceAttachMapPoint();
        if (dDevice_attach_map_point!= null) {
            sqlBuilder.itemWhere(ModelTDevice.FI_DEVICE_ATTACH_MAP_POINT, ColumnDataType.intData);
            param.put(ModelTDevice.FI_DEVICE_ATTACH_MAP_POINT, dDevice_attach_map_point);
        }
        Integer dDevice_index = instance.getDeviceIndex();
        if (dDevice_index!= null) {
            sqlBuilder.itemWhere(ModelTDevice.FI_DEVICE_INDEX, ColumnDataType.intData);
            param.put(ModelTDevice.FI_DEVICE_INDEX, dDevice_index);
        }
        EnumYesOrNo dDevice_handle_task = instance.getDeviceHandleTask();
        if (dDevice_handle_task!= null) {
            sqlBuilder.itemWhere(ModelTDevice.FI_DEVICE_HANDLE_TASK, ColumnDataType.byteData);
            param.put(ModelTDevice.FI_DEVICE_HANDLE_TASK, dDevice_handle_task.val);
        }
        EnumDeviceControlStatus dDevice_control_status = instance.getDeviceControlStatus();
        if (dDevice_control_status!= null) {
            sqlBuilder.itemWhere(ModelTDevice.FI_DEVICE_CONTROL_STATUS, ColumnDataType.byteData);
            param.put(ModelTDevice.FI_DEVICE_CONTROL_STATUS, dDevice_control_status.val);
        }
    }

    protected void buildSelectFieldCluase(SQLSelect sqlBuilder, Set<String> selectFields) {
        if (selectFields.contains(ModelTDevice.FI_ID)) {
            sqlBuilder.itemCol(ModelTDevice.FI_ID);
        }
        if (selectFields.contains(ModelTDevice.FI_DEVICE_STATUS)) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_STATUS);
        }
        if (selectFields.contains(ModelTDevice.FI_DEVICE_IP)) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_IP);
        }
        if (selectFields.contains(ModelTDevice.FI_DEVICE_PROC)) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_PROC);
        }
        if (selectFields.contains(ModelTDevice.FI_DEVICE_NAME)) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_NAME);
        }
        if (selectFields.contains(ModelTDevice.FI_DEVICE_DESP)) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_DESP);
        }
        if (selectFields.contains(ModelTDevice.FI_DEVICE_CREATE_TIME)) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_CREATE_TIME);
        }
        if (selectFields.contains(ModelTDevice.FI_DEVICE_UPDATE_TIME)) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_UPDATE_TIME);
        }
        if (selectFields.contains(ModelTDevice.FI_DEVICE_DELETE_FLAG)) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_DELETE_FLAG);
        }
        if (selectFields.contains(ModelTDevice.FI_DEVICE_TYPE)) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_TYPE);
        }
        if (selectFields.contains(ModelTDevice.FI_DEVICE_REMARK)) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_REMARK);
        }
        if (selectFields.contains(ModelTDevice.FI_DEVICE_HARDWARE_ID)) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_HARDWARE_ID);
        }
        if (selectFields.contains(ModelTDevice.FI_DEVICE_LAST_ORDER_PARAM)) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_LAST_ORDER_PARAM);
        }
        if (selectFields.contains(ModelTDevice.FI_DEVICE_LAST_CHECK_TIME)) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_LAST_CHECK_TIME);
        }
        if (selectFields.contains(ModelTDevice.FI_DEVICE_ARIX_X)) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_ARIX_X);
        }
        if (selectFields.contains(ModelTDevice.FI_DEVICE_ARIX_Y)) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_ARIX_Y);
        }
        if (selectFields.contains(ModelTDevice.FI_DEVICE_ARIX_Z)) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_ARIX_Z);
        }
        if (selectFields.contains(ModelTDevice.FI_DEVICE_LAST_OCUPY_TIME)) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_LAST_OCUPY_TIME);
        }
        if (selectFields.contains(ModelTDevice.FI_DEVICE_LAST_RELEASE_TIME)) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_LAST_RELEASE_TIME);
        }
        if (selectFields.contains(ModelTDevice.FI_DEVICE_TASK_ID)) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_TASK_ID);
        }
        if (selectFields.contains(ModelTDevice.FI_DEVICE_LAST_PROC)) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_LAST_PROC);
        }
        if (selectFields.contains(ModelTDevice.FI_DEVICE_BATTERY)) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_BATTERY);
        }
        if (selectFields.contains(ModelTDevice.FI_DEVICE_GOODS_HOLDER_NUM)) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_GOODS_HOLDER_NUM);
        }
        if (selectFields.contains(ModelTDevice.FI_DEVICE_GROUP)) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_GROUP);
        }
        if (selectFields.contains(ModelTDevice.FI_DEVICE_ATTACH_MAP_POINT)) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_ATTACH_MAP_POINT);
        }
        if (selectFields.contains(ModelTDevice.FI_DEVICE_INDEX)) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_INDEX);
        }
        if (selectFields.contains(ModelTDevice.FI_DEVICE_HANDLE_TASK)) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_HANDLE_TASK);
        }
        if (selectFields.contains(ModelTDevice.FI_DEVICE_CONTROL_STATUS)) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_CONTROL_STATUS);
        }
    }

    public List<ModelTDevice> get(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count) {
        if (selectFields == null) {
            selectFields = ModelTDevice.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelTDevice.DTO_TABLE_NAME);
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

    public List<ModelTDevice> get(Set<String> selectFields, Integer start, Integer count) {
        return get(selectFields, null, start, count);
    }

    public List<ModelTDevice> get(Integer start, Integer count) {
        return get(null, start, count);
    }

    public List<ModelTDevice> get() {
        return get(null, null);
    }

    public List<ModelTDevice> getById(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, List<Integer> id) {
        if (selectFields == null) {
            selectFields = ModelTDevice.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelTDevice.DTO_TABLE_NAME);
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
            sqlBuilder.itemWhere(LogicalRelationshipType.and, LogicalOpType.in, null, ModelTDevice.FI_ID, ModelTDevice.FI_ID, ColumnDataType.intData);
            param.put(ModelTDevice.FI_ID, id);
        }
        sqlBuilder.limit();
        return getResults(assembler, sqlBuilder, param);
    }

    public List<ModelTDevice> getById(Set<String> selectFields, Integer start, Integer count, List<Integer> id) {
        return getById(selectFields, null, start, count, id);
    }

    public List<ModelTDevice> getById(Integer start, Integer count, List<Integer> id) {
        return getById(null, start, count, id);
    }

    public List<ModelTDevice> getById(List<Integer> id) {
        return getById(null, null, id);
    }

    public List<ModelTDevice> getByIndex(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, String inField, List indexes) {
        if (selectFields == null) {
            selectFields = ModelTDevice.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelTDevice.DTO_TABLE_NAME);
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

    public List<ModelTDevice> getByIndex(Set<String> selectFields, Integer start, Integer count, String inField, List indexes) {
        return getByIndex(selectFields, null, start, count, inField, indexes);
    }

    public List<ModelTDevice> getByIndex(Integer start, Integer count, String inField, List indexes) {
        return getByIndex(null, start, count, inField, indexes);
    }

    public List<ModelTDevice> getByIndex(String inField, List indexes) {
        return getByIndex(null, null, inField, indexes);
    }

    public List<ModelTDevice> getByCond(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, ModelTDevice instance) {
        if (selectFields == null) {
            selectFields = ModelTDevice.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelTDevice.DTO_TABLE_NAME);
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

    public List<ModelTDevice> getByCond(Set<String> selectFields, Integer start, Integer count, ModelTDevice instance) {
        return getByCond(selectFields, null, start, count, instance);
    }

    public List<ModelTDevice> getByCond(Integer start, Integer count, ModelTDevice instance) {
        return getByCond(null, start, count, instance);
    }

    public List<ModelTDevice> getByCond(ModelTDevice instance) {
        return getByCond(null, null, instance);
    }

    public List<ModelTDevice> getByWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelTDevice.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelTDevice.DTO_TABLE_NAME);
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

    public List<ModelTDevice> getByWhere(Set<String> selectFields, Integer start, Integer count, Map<String, Object> extParam, Set<String> extCondition) {
        return getByWhere(selectFields, null, start, count, extParam, extCondition);
    }

    public List<ModelTDevice> getByWhere(Integer start, Integer count, Map<String, Object> extParam, Set<String> extCondition) {
        return getByWhere(null, start, count, extParam, extCondition);
    }

    public List<ModelTDevice> getByWhere(Map<String, Object> extParam, Set<String> extCondition) {
        return getByWhere(null, null, extParam, extCondition);
    }

    public List<ModelTDevice> getByCondAndIndex(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, ModelTDevice instance, String inField, List indexes) {
        if (selectFields == null) {
            selectFields = ModelTDevice.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelTDevice.DTO_TABLE_NAME);
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

    public List<ModelTDevice> getByCondAndIndex(Set<String> selectFields, Integer start, Integer count, ModelTDevice instance, String inField, List indexes) {
        return getByCondAndIndex(selectFields, null, start, count, instance, inField, indexes);
    }

    public List<ModelTDevice> getByCondAndIndex(Integer start, Integer count, ModelTDevice instance, String inField, List indexes) {
        return getByCondAndIndex(null, start, count, instance, inField, indexes);
    }

    public List<ModelTDevice> getByCondAndIndex(ModelTDevice instance, String inField, List indexes) {
        return getByCondAndIndex(null, null, instance, inField, indexes);
    }

    public List<ModelTDevice> getByIdAndWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, Integer id, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelTDevice.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelTDevice.DTO_TABLE_NAME);
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
            sqlBuilder.itemWhere(LogicalRelationshipType.and, LogicalOpType.in, null, ModelTDevice.FI_ID, ModelTDevice.FI_ID, ColumnDataType.intData);
            param.put(ModelTDevice.FI_ID, id);
        }
        sqlBuilder.limit();
        return getResults(assembler, sqlBuilder, param);
    }

    public List<ModelTDevice> getByIdAndWhere(Set<String> selectFields, Integer start, Integer count, Integer id, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIdAndWhere(selectFields, null, start, count, id, extParam, extCondition);
    }

    public List<ModelTDevice> getByIdAndWhere(Integer start, Integer count, Integer id, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIdAndWhere(null, start, count, id, extParam, extCondition);
    }

    public List<ModelTDevice> getByIdAndWhere(Integer id, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIdAndWhere(null, null, id, extParam, extCondition);
    }

    public List<ModelTDevice> getByIdAndCondAndWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, ModelTDevice instance, List<Integer> id, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelTDevice.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelTDevice.DTO_TABLE_NAME);
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
            sqlBuilder.itemWhere(LogicalRelationshipType.and, LogicalOpType.in, null, ModelTDevice.FI_ID, ModelTDevice.FI_ID, ColumnDataType.intData);
            param.put(ModelTDevice.FI_ID, id);
        }
        sqlBuilder.limit();
        return getResults(assembler, sqlBuilder, param);
    }

    public List<ModelTDevice> getByIdAndCondAndWhere(Set<String> selectFields, Integer start, Integer count, ModelTDevice instance, List<Integer> id, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIdAndCondAndWhere(selectFields, null, start, count, instance, id, extParam, extCondition);
    }

    public List<ModelTDevice> getByIdAndCondAndWhere(Integer start, Integer count, ModelTDevice instance, List<Integer> id, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIdAndCondAndWhere(null, start, count, instance, id, extParam, extCondition);
    }

    public List<ModelTDevice> getByIdAndCondAndWhere(ModelTDevice instance, List<Integer> id, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIdAndCondAndWhere(null, null, instance, id, extParam, extCondition);
    }

    public List<ModelTDevice> getByIndexAndWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelTDevice.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelTDevice.DTO_TABLE_NAME);
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

    public List<ModelTDevice> getByIndexAndWhere(Set<String> selectFields, Integer start, Integer count, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIndexAndWhere(selectFields, null, start, count, inField, indexes, extParam, extCondition);
    }

    public List<ModelTDevice> getByIndexAndWhere(Integer start, Integer count, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIndexAndWhere(null, start, count, inField, indexes, extParam, extCondition);
    }

    public List<ModelTDevice> getByIndexAndWhere(String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIndexAndWhere(null, null, inField, indexes, extParam, extCondition);
    }

    public List<ModelTDevice> getByCondAndWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, ModelTDevice instance, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelTDevice.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelTDevice.DTO_TABLE_NAME);
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

    public List<ModelTDevice> getByCondAndWhere(Set<String> selectFields, Integer start, Integer count, ModelTDevice instance, Map<String, Object> extParam, Set<String> extCondition) {
        return getByCondAndWhere(selectFields, null, start, count, instance, extParam, extCondition);
    }

    public List<ModelTDevice> getByCondAndWhere(Integer start, Integer count, ModelTDevice instance, Map<String, Object> extParam, Set<String> extCondition) {
        return getByCondAndWhere(null, start, count, instance, extParam, extCondition);
    }

    public List<ModelTDevice> getByCondAndWhere(ModelTDevice instance, Map<String, Object> extParam, Set<String> extCondition) {
        return getByCondAndWhere(null, null, instance, extParam, extCondition);
    }

    public List<ModelTDevice> getByCondAndIndexAndWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, ModelTDevice instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelTDevice.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelTDevice.DTO_TABLE_NAME);
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

    public List<ModelTDevice> getByCondAndIndexAndWhere(Set<String> selectFields, Integer start, Integer count, ModelTDevice instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        return getByCondAndIndexAndWhere(selectFields, null, start, count, instance, inField, indexes, extParam, extCondition);
    }

    public List<ModelTDevice> getByCondAndIndexAndWhere(Integer start, Integer count, ModelTDevice instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        return getByCondAndIndexAndWhere(null, start, count, instance, inField, indexes, extParam, extCondition);
    }

    public List<ModelTDevice> getByCondAndIndexAndWhere(ModelTDevice instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        return getByCondAndIndexAndWhere(null, null, instance, inField, indexes, extParam, extCondition);
    }

    public ModelTDevice getOneById(Set<String> selectFields, DaoAssembler assembler, Integer id) {
        if (selectFields == null) {
            selectFields = ModelTDevice.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelTDevice.DTO_TABLE_NAME);
        Integer start = 0;
        Integer count = 1;
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        buildSelectFieldCluase(sqlBuilder, selectFields);
        if (id!= null) {
            sqlBuilder.itemWhere(ModelTDevice.FI_ID, ColumnDataType.intData);
            param.put(ModelTDevice.FI_ID, id);
        }
        sqlBuilder.limit();
        return getResult(assembler, sqlBuilder, param);
    }

    public ModelTDevice getOneById(Set<String> selectFields, Integer id) {
        return getOneById(selectFields, null, id);
    }

    public ModelTDevice getOneById(Integer id) {
        return getOneById(null, id);
    }

    public ModelTDevice getOneByCond(Set<String> selectFields, DaoAssembler assembler, ModelTDevice instance) {
        if (selectFields == null) {
            selectFields = ModelTDevice.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelTDevice.DTO_TABLE_NAME);
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

    public ModelTDevice getOneByCond(Set<String> selectFields, ModelTDevice instance) {
        return getOneByCond(selectFields, null, instance);
    }

    public ModelTDevice getOneByCond(ModelTDevice instance) {
        return getOneByCond(null, instance);
    }

    public ModelTDevice getOneByWhere(Set<String> selectFields, DaoAssembler assembler, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelTDevice.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelTDevice.DTO_TABLE_NAME);
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

    public ModelTDevice getOneByWhere(Set<String> selectFields, Map<String, Object> extParam, Set<String> extCondition) {
        return getOneByWhere(selectFields, null, extParam, extCondition);
    }

    public ModelTDevice getOneByWhere(Map<String, Object> extParam, Set<String> extCondition) {
        return getOneByWhere(null, extParam, extCondition);
    }

    public ModelTDevice getOneByCondAndWhere(Set<String> selectFields, DaoAssembler assembler, ModelTDevice instance, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelTDevice.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelTDevice.DTO_TABLE_NAME);
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

    public ModelTDevice getOneByCondAndWhere(Set<String> selectFields, ModelTDevice instance, Map<String, Object> extParam, Set<String> extCondition) {
        return getOneByCondAndWhere(selectFields, null, instance, extParam, extCondition);
    }

    public ModelTDevice getOneByCondAndWhere(ModelTDevice instance, Map<String, Object> extParam, Set<String> extCondition) {
        return getOneByCondAndWhere(null, instance, extParam, extCondition);
    }

    public ModelTDevice getOneByIdAndCondAndWhere(Set<String> selectFields, DaoAssembler assembler, ModelTDevice instance, Integer id, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelTDevice.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelTDevice.DTO_TABLE_NAME);
        Integer start = 0;
        Integer count = 1;
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        super.buildRawWhere(sqlBuilder, param, extParam, extCondition);
        buildConditionCluase(sqlBuilder, instance, param);
        buildSelectFieldCluase(sqlBuilder, selectFields);
        if (id!= null) {
            sqlBuilder.itemWhere(ModelTDevice.FI_ID, ColumnDataType.intData);
            param.put(ModelTDevice.FI_ID, id);
        }
        sqlBuilder.limit();
        return getResult(assembler, sqlBuilder, param);
    }

    public ModelTDevice getOneByIdAndCondAndWhere(Set<String> selectFields, ModelTDevice instance, Integer id, Map<String, Object> extParam, Set<String> extCondition) {
        return getOneByIdAndCondAndWhere(selectFields, null, instance, id, extParam, extCondition);
    }

    public ModelTDevice getOneByIdAndCondAndWhere(ModelTDevice instance, Integer id, Map<String, Object> extParam, Set<String> extCondition) {
        return getOneByIdAndCondAndWhere(null, instance, id, extParam, extCondition);
    }

    public Long getCountByCond(DaoAssembler assembler, ModelTDevice instance) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelTDevice.DTO_TABLE_NAME);
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

    public Long getCountByCond(ModelTDevice instance) {
        return getCountByCond(null, instance);
    }

    public Long getCountByCondAndIndex(DaoAssembler assembler, ModelTDevice instance, String inField, List indexes) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelTDevice.DTO_TABLE_NAME);
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

    public Long getCountByCondAndIndex(ModelTDevice instance, String inField, List indexes) {
        return getCountByCondAndIndex(null, instance, inField, indexes);
    }

    public Long getCountByCondAndIndexAndWhere(DaoAssembler assembler, ModelTDevice instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelTDevice.DTO_TABLE_NAME);
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

    public Long getCountByCondAndIndexAndWhere(ModelTDevice instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        return getCountByCondAndIndexAndWhere(null, instance, inField, indexes, extParam, extCondition);
    }

    public<TT> TT getItemByIndex(DaoAssembler assembler, String inField, List indexes, Class<TT> tClass, String rawItem) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelTDevice.DTO_TABLE_NAME);
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
        sqlBuilder.table(ModelTDevice.DTO_TABLE_NAME);
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

    public<TT> TT getItemByCond(DaoAssembler assembler, ModelTDevice instance, Class<TT> tClass, String rawItem) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelTDevice.DTO_TABLE_NAME);
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

    public<TT extends Object> TT getItemByCond(ModelTDevice instance, Class<TT> tClass, String rawItem) {
        return getItemByCond(null, instance, tClass, rawItem);
    }

    public<TT> TT getItemByCondAndIndex(DaoAssembler assembler, ModelTDevice instance, String inField, List indexes, Class<TT> tClass, String rawItem) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelTDevice.DTO_TABLE_NAME);
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

    public<TT extends Object> TT getItemByCondAndIndex(ModelTDevice instance, String inField, List indexes, Class<TT> tClass, String rawItem) {
        return getItemByCondAndIndex(null, instance, inField, indexes, tClass, rawItem);
    }

    public<TT> TT getItemByCondAndIndexAndWhere(DaoAssembler assembler, ModelTDevice instance, String inField, List indexes, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelTDevice.DTO_TABLE_NAME);
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

    public<TT extends Object> TT getItemByCondAndIndexAndWhere(ModelTDevice instance, String inField, List indexes, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        return getItemByCondAndIndexAndWhere(null, instance, inField, indexes, tClass, rawItem, extParam, extCondition);
    }

    public<TT> List<TT> getItemListByIndex(DaoAssembler assembler, Integer start, Integer count, String inField, List indexes, Class<TT> tClass, String rawItem) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelTDevice.DTO_TABLE_NAME);
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

    public<TT> List<TT> getItemListByCond(DaoAssembler assembler, Integer start, Integer count, ModelTDevice instance, Class<TT> tClass, String rawItem) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelTDevice.DTO_TABLE_NAME);
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

    public<TT extends Object> List<TT> getItemListByCond(Integer start, Integer count, ModelTDevice instance, Class<TT> tClass, String rawItem) {
        return getItemListByCond(null, start, count, instance, tClass, rawItem);
    }

    public<TT extends Object> List<TT> getItemListByCond(ModelTDevice instance, Class<TT> tClass, String rawItem) {
        return getItemListByCond(null, null, instance, tClass, rawItem);
    }

    public<TT> List<TT> getItemListById(DaoAssembler assembler, Integer start, Integer count, Integer id, Class<TT> tClass, String rawItem) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelTDevice.DTO_TABLE_NAME);
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
            sqlBuilder.itemWhere(LogicalRelationshipType.and, LogicalOpType.in, null, ModelTDevice.FI_ID, ModelTDevice.FI_ID, ColumnDataType.intData);
            param.put(ModelTDevice.FI_ID, id);
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
        sqlBuilder.table(ModelTDevice.DTO_TABLE_NAME);
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
        sqlBuilder.table(ModelTDevice.DTO_TABLE_NAME);
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

    public<TT> List<TT> getItemListByCondAndWhere(DaoAssembler assembler, Integer start, Integer count, ModelTDevice instance, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelTDevice.DTO_TABLE_NAME);
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

    public<TT extends Object> List<TT> getItemListByCondAndWhere(Integer start, Integer count, ModelTDevice instance, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        return getItemListByCondAndWhere(null, start, count, instance, tClass, rawItem, extParam, extCondition);
    }

    public<TT extends Object> List<TT> getItemListByCondAndWhere(ModelTDevice instance, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        return getItemListByCondAndWhere(null, null, instance, tClass, rawItem, extParam, extCondition);
    }

    public<TT> List<TT> getItemListByCondAndIndex(DaoAssembler assembler, Integer start, Integer count, ModelTDevice instance, String inField, List indexes, Class<TT> tClass, String rawItem) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelTDevice.DTO_TABLE_NAME);
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

    public<TT extends Object> List<TT> getItemListByCondAndIndex(Integer start, Integer count, ModelTDevice instance, String inField, List indexes, Class<TT> tClass, String rawItem) {
        return getItemListByCondAndIndex(null, start, count, instance, inField, indexes, tClass, rawItem);
    }

    public<TT extends Object> List<TT> getItemListByCondAndIndex(ModelTDevice instance, String inField, List indexes, Class<TT> tClass, String rawItem) {
        return getItemListByCondAndIndex(null, null, instance, inField, indexes, tClass, rawItem);
    }

    public<TT> List<TT> getItemListByIdAndCondAndWhere(DaoAssembler assembler, Integer start, Integer count, ModelTDevice instance, List<Integer> id, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelTDevice.DTO_TABLE_NAME);
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
            sqlBuilder.itemWhere(LogicalRelationshipType.and, LogicalOpType.in, null, ModelTDevice.FI_ID, ModelTDevice.FI_ID, ColumnDataType.intData);
            param.put(ModelTDevice.FI_ID, id);
        }
        sqlBuilder.limit();
        return ((List<TT> ) getSingleResults(assembler, sqlBuilder, param, tClass));
    }

    public<TT extends Object> List<TT> getItemListByIdAndCondAndWhere(Integer start, Integer count, ModelTDevice instance, List<Integer> id, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        return getItemListByIdAndCondAndWhere(null, start, count, instance, id, tClass, rawItem, extParam, extCondition);
    }

    public<TT extends Object> List<TT> getItemListByIdAndCondAndWhere(ModelTDevice instance, List<Integer> id, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        return getItemListByIdAndCondAndWhere(null, null, instance, id, tClass, rawItem, extParam, extCondition);
    }

    public ModelTDevice insert(ModelTDevice instance, DaoAssembler assembler) {
        SQLInsert sqlBuilder = SQLBuilder.buildInsertSql();
        sqlBuilder.table(ModelTDevice.DTO_TABLE_NAME);
        Integer dId = instance.getId();
        if (dId!= null) {
            sqlBuilder.itemCol(ModelTDevice.FI_ID);
        }
        EnumDeviceStatusType dDevice_status = instance.getDeviceStatus();
        if (dDevice_status!= null) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_STATUS);
        }
        String dDevice_ip = instance.getDeviceIp();
        if (dDevice_ip!= null) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_IP);
        }
        Integer dDevice_proc = instance.getDeviceProc();
        if (dDevice_proc!= null) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_PROC);
        }
        String dDevice_name = instance.getDeviceName();
        if (dDevice_name!= null) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_NAME);
        }
        String dDevice_desp = instance.getDeviceDesp();
        if (dDevice_desp!= null) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_DESP);
        }
        Date dDevice_create_time = instance.getDeviceCreateTime();
        if (dDevice_create_time!= null) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_CREATE_TIME);
        }
        Date dDevice_update_time = instance.getDeviceUpdateTime();
        if (dDevice_update_time!= null) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_UPDATE_TIME);
        }
        Byte dDevice_delete_flag = instance.getDeviceDeleteFlag();
        if (dDevice_delete_flag!= null) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_DELETE_FLAG);
        }
        Integer dDevice_type = instance.getDeviceType();
        if (dDevice_type!= null) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_TYPE);
        }
        String dDevice_remark = instance.getDeviceRemark();
        if (dDevice_remark!= null) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_REMARK);
        }
        String dDevice_hardware_id = instance.getDeviceHardwareId();
        if (dDevice_hardware_id!= null) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_HARDWARE_ID);
        }
        String dDevice_last_order_param = instance.getDeviceLastOrderParam();
        if (dDevice_last_order_param!= null) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_LAST_ORDER_PARAM);
        }
        Date dDevice_last_check_time = instance.getDeviceLastCheckTime();
        if (dDevice_last_check_time!= null) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_LAST_CHECK_TIME);
        }
        Integer dDevice_arix_x = instance.getDeviceArixX();
        if (dDevice_arix_x!= null) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_ARIX_X);
        }
        Integer dDevice_arix_y = instance.getDeviceArixY();
        if (dDevice_arix_y!= null) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_ARIX_Y);
        }
        Integer dDevice_arix_z = instance.getDeviceArixZ();
        if (dDevice_arix_z!= null) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_ARIX_Z);
        }
        Date dDevice_last_ocupy_time = instance.getDeviceLastOcupyTime();
        if (dDevice_last_ocupy_time!= null) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_LAST_OCUPY_TIME);
        }
        Date dDevice_last_release_time = instance.getDeviceLastReleaseTime();
        if (dDevice_last_release_time!= null) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_LAST_RELEASE_TIME);
        }
        Integer dDevice_task_id = instance.getDeviceTaskId();
        if (dDevice_task_id!= null) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_TASK_ID);
        }
        Integer dDevice_last_proc = instance.getDeviceLastProc();
        if (dDevice_last_proc!= null) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_LAST_PROC);
        }
        Integer dDevice_battery = instance.getDeviceBattery();
        if (dDevice_battery!= null) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_BATTERY);
        }
        Integer dDevice_goods_holder_num = instance.getDeviceGoodsHolderNum();
        if (dDevice_goods_holder_num!= null) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_GOODS_HOLDER_NUM);
        }
        Integer dDevice_group = instance.getDeviceGroup();
        if (dDevice_group!= null) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_GROUP);
        }
        Integer dDevice_attach_map_point = instance.getDeviceAttachMapPoint();
        if (dDevice_attach_map_point!= null) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_ATTACH_MAP_POINT);
        }
        Integer dDevice_index = instance.getDeviceIndex();
        if (dDevice_index!= null) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_INDEX);
        }
        EnumYesOrNo dDevice_handle_task = instance.getDeviceHandleTask();
        if (dDevice_handle_task!= null) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_HANDLE_TASK);
        }
        EnumDeviceControlStatus dDevice_control_status = instance.getDeviceControlStatus();
        if (dDevice_control_status!= null) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_CONTROL_STATUS);
        }
        Map<String, Object> param = Constants.T_DEVICE_MAP_OBJ_MAPPER.toCommonMap(instance);
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

    public ModelTDevice insert(ModelTDevice instance) {
        return insert(instance, null);
    }

    public Integer insert(List<ModelTDevice> instances, Set<String> fields, DaoAssembler assembler) {
        if (fields == null) {
            fields = ModelTDevice.FIELD_CLASS.keySet();
        }
        SQLInsert sqlBuilder = SQLBuilder.buildInsertSql();
        sqlBuilder.table(ModelTDevice.DTO_TABLE_NAME);
        if (fields.contains(ModelTDevice.FI_ID)) {
            sqlBuilder.itemCol(ModelTDevice.FI_ID);
        }
        if (fields.contains(ModelTDevice.FI_DEVICE_STATUS)) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_STATUS);
        }
        if (fields.contains(ModelTDevice.FI_DEVICE_IP)) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_IP);
        }
        if (fields.contains(ModelTDevice.FI_DEVICE_PROC)) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_PROC);
        }
        if (fields.contains(ModelTDevice.FI_DEVICE_NAME)) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_NAME);
        }
        if (fields.contains(ModelTDevice.FI_DEVICE_DESP)) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_DESP);
        }
        if (fields.contains(ModelTDevice.FI_DEVICE_CREATE_TIME)) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_CREATE_TIME);
        }
        if (fields.contains(ModelTDevice.FI_DEVICE_UPDATE_TIME)) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_UPDATE_TIME);
        }
        if (fields.contains(ModelTDevice.FI_DEVICE_DELETE_FLAG)) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_DELETE_FLAG);
        }
        if (fields.contains(ModelTDevice.FI_DEVICE_TYPE)) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_TYPE);
        }
        if (fields.contains(ModelTDevice.FI_DEVICE_REMARK)) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_REMARK);
        }
        if (fields.contains(ModelTDevice.FI_DEVICE_HARDWARE_ID)) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_HARDWARE_ID);
        }
        if (fields.contains(ModelTDevice.FI_DEVICE_LAST_ORDER_PARAM)) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_LAST_ORDER_PARAM);
        }
        if (fields.contains(ModelTDevice.FI_DEVICE_LAST_CHECK_TIME)) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_LAST_CHECK_TIME);
        }
        if (fields.contains(ModelTDevice.FI_DEVICE_ARIX_X)) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_ARIX_X);
        }
        if (fields.contains(ModelTDevice.FI_DEVICE_ARIX_Y)) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_ARIX_Y);
        }
        if (fields.contains(ModelTDevice.FI_DEVICE_ARIX_Z)) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_ARIX_Z);
        }
        if (fields.contains(ModelTDevice.FI_DEVICE_LAST_OCUPY_TIME)) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_LAST_OCUPY_TIME);
        }
        if (fields.contains(ModelTDevice.FI_DEVICE_LAST_RELEASE_TIME)) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_LAST_RELEASE_TIME);
        }
        if (fields.contains(ModelTDevice.FI_DEVICE_TASK_ID)) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_TASK_ID);
        }
        if (fields.contains(ModelTDevice.FI_DEVICE_LAST_PROC)) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_LAST_PROC);
        }
        if (fields.contains(ModelTDevice.FI_DEVICE_BATTERY)) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_BATTERY);
        }
        if (fields.contains(ModelTDevice.FI_DEVICE_GOODS_HOLDER_NUM)) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_GOODS_HOLDER_NUM);
        }
        if (fields.contains(ModelTDevice.FI_DEVICE_GROUP)) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_GROUP);
        }
        if (fields.contains(ModelTDevice.FI_DEVICE_ATTACH_MAP_POINT)) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_ATTACH_MAP_POINT);
        }
        if (fields.contains(ModelTDevice.FI_DEVICE_INDEX)) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_INDEX);
        }
        if (fields.contains(ModelTDevice.FI_DEVICE_HANDLE_TASK)) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_HANDLE_TASK);
        }
        if (fields.contains(ModelTDevice.FI_DEVICE_CONTROL_STATUS)) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_CONTROL_STATUS);
        }
        List<Map<String, Object>> param = CollectionHelper.<Map<String,Object>> newList();
        for (ModelTDevice instance: instances) {
            Map<String, Object> paramMap = Constants.T_DEVICE_MAP_OBJ_MAPPER.toCommonMap(instance);
            param.add(paramMap);
        }
        return super.batchInsert(assembler, sqlBuilder, param);
    }

    public Integer insert(List<ModelTDevice> instances, Set<String> fields) {
        return insert(instances, fields, null);
    }

    public Integer insert(List<ModelTDevice> instances) {
        return insert(instances, null, null);
    }

    public Integer update(ModelTDevice instance, Set<String> conditionField, DaoAssembler assembler) {
        SQLUpdate sqlBuilder = SQLBuilder.buildUpdateSql();
        sqlBuilder.table(ModelTDevice.DTO_TABLE_NAME);
        Integer dId = instance.getId();
        if (conditionField.contains(ModelTDevice.FI_ID)) {
            throwExceptionIf((dId!= null));
            sqlBuilder.itemWhere(ModelTDevice.FI_ID, ColumnDataType.intData);
        } else {
            if (dId!= null) {
                sqlBuilder.itemCol(ModelTDevice.FI_ID);
            }
        }
        EnumDeviceStatusType dDevice_status = instance.getDeviceStatus();
        if (conditionField.contains(ModelTDevice.FI_DEVICE_STATUS)) {
            throwExceptionIf((dDevice_status!= null));
            sqlBuilder.itemWhere(ModelTDevice.FI_DEVICE_STATUS, ColumnDataType.byteData);
        } else {
            if (dDevice_status!= null) {
                sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_STATUS);
            }
        }
        String dDevice_ip = instance.getDeviceIp();
        if (conditionField.contains(ModelTDevice.FI_DEVICE_IP)) {
            throwExceptionIf((dDevice_ip!= null));
            sqlBuilder.itemWhere(ModelTDevice.FI_DEVICE_IP, ColumnDataType.stringData);
        } else {
            if (dDevice_ip!= null) {
                sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_IP);
            }
        }
        Integer dDevice_proc = instance.getDeviceProc();
        if (conditionField.contains(ModelTDevice.FI_DEVICE_PROC)) {
            throwExceptionIf((dDevice_proc!= null));
            sqlBuilder.itemWhere(ModelTDevice.FI_DEVICE_PROC, ColumnDataType.intData);
        } else {
            if (dDevice_proc!= null) {
                sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_PROC);
            }
        }
        String dDevice_name = instance.getDeviceName();
        if (conditionField.contains(ModelTDevice.FI_DEVICE_NAME)) {
            throwExceptionIf((dDevice_name!= null));
            sqlBuilder.itemWhere(ModelTDevice.FI_DEVICE_NAME, ColumnDataType.stringData);
        } else {
            if (dDevice_name!= null) {
                sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_NAME);
            }
        }
        String dDevice_desp = instance.getDeviceDesp();
        if (conditionField.contains(ModelTDevice.FI_DEVICE_DESP)) {
            throwExceptionIf((dDevice_desp!= null));
            sqlBuilder.itemWhere(ModelTDevice.FI_DEVICE_DESP, ColumnDataType.stringData);
        } else {
            if (dDevice_desp!= null) {
                sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_DESP);
            }
        }
        Date dDevice_create_time = instance.getDeviceCreateTime();
        if (conditionField.contains(ModelTDevice.FI_DEVICE_CREATE_TIME)) {
            throwExceptionIf((dDevice_create_time!= null));
            sqlBuilder.itemWhere(ModelTDevice.FI_DEVICE_CREATE_TIME, ColumnDataType.timeStampData);
        } else {
            if (dDevice_create_time!= null) {
                sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_CREATE_TIME);
            }
        }
        Date dDevice_update_time = instance.getDeviceUpdateTime();
        if (conditionField.contains(ModelTDevice.FI_DEVICE_UPDATE_TIME)) {
            throwExceptionIf((dDevice_update_time!= null));
            sqlBuilder.itemWhere(ModelTDevice.FI_DEVICE_UPDATE_TIME, ColumnDataType.timeStampData);
        } else {
            if (dDevice_update_time!= null) {
                sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_UPDATE_TIME);
            }
        }
        Byte dDevice_delete_flag = instance.getDeviceDeleteFlag();
        if (conditionField.contains(ModelTDevice.FI_DEVICE_DELETE_FLAG)) {
            throwExceptionIf((dDevice_delete_flag!= null));
            sqlBuilder.itemWhere(ModelTDevice.FI_DEVICE_DELETE_FLAG, ColumnDataType.byteData);
        } else {
            if (dDevice_delete_flag!= null) {
                sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_DELETE_FLAG);
            }
        }
        Integer dDevice_type = instance.getDeviceType();
        if (conditionField.contains(ModelTDevice.FI_DEVICE_TYPE)) {
            throwExceptionIf((dDevice_type!= null));
            sqlBuilder.itemWhere(ModelTDevice.FI_DEVICE_TYPE, ColumnDataType.intData);
        } else {
            if (dDevice_type!= null) {
                sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_TYPE);
            }
        }
        String dDevice_remark = instance.getDeviceRemark();
        if (conditionField.contains(ModelTDevice.FI_DEVICE_REMARK)) {
            throwExceptionIf((dDevice_remark!= null));
            sqlBuilder.itemWhere(ModelTDevice.FI_DEVICE_REMARK, ColumnDataType.stringData);
        } else {
            if (dDevice_remark!= null) {
                sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_REMARK);
            }
        }
        String dDevice_hardware_id = instance.getDeviceHardwareId();
        if (conditionField.contains(ModelTDevice.FI_DEVICE_HARDWARE_ID)) {
            throwExceptionIf((dDevice_hardware_id!= null));
            sqlBuilder.itemWhere(ModelTDevice.FI_DEVICE_HARDWARE_ID, ColumnDataType.stringData);
        } else {
            if (dDevice_hardware_id!= null) {
                sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_HARDWARE_ID);
            }
        }
        String dDevice_last_order_param = instance.getDeviceLastOrderParam();
        if (conditionField.contains(ModelTDevice.FI_DEVICE_LAST_ORDER_PARAM)) {
            throwExceptionIf((dDevice_last_order_param!= null));
            sqlBuilder.itemWhere(ModelTDevice.FI_DEVICE_LAST_ORDER_PARAM, ColumnDataType.stringData);
        } else {
            if (dDevice_last_order_param!= null) {
                sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_LAST_ORDER_PARAM);
            }
        }
        Date dDevice_last_check_time = instance.getDeviceLastCheckTime();
        if (conditionField.contains(ModelTDevice.FI_DEVICE_LAST_CHECK_TIME)) {
            throwExceptionIf((dDevice_last_check_time!= null));
            sqlBuilder.itemWhere(ModelTDevice.FI_DEVICE_LAST_CHECK_TIME, ColumnDataType.timeStampData);
        } else {
            if (dDevice_last_check_time!= null) {
                sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_LAST_CHECK_TIME);
            }
        }
        Integer dDevice_arix_x = instance.getDeviceArixX();
        if (conditionField.contains(ModelTDevice.FI_DEVICE_ARIX_X)) {
            throwExceptionIf((dDevice_arix_x!= null));
            sqlBuilder.itemWhere(ModelTDevice.FI_DEVICE_ARIX_X, ColumnDataType.intData);
        } else {
            if (dDevice_arix_x!= null) {
                sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_ARIX_X);
            }
        }
        Integer dDevice_arix_y = instance.getDeviceArixY();
        if (conditionField.contains(ModelTDevice.FI_DEVICE_ARIX_Y)) {
            throwExceptionIf((dDevice_arix_y!= null));
            sqlBuilder.itemWhere(ModelTDevice.FI_DEVICE_ARIX_Y, ColumnDataType.intData);
        } else {
            if (dDevice_arix_y!= null) {
                sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_ARIX_Y);
            }
        }
        Integer dDevice_arix_z = instance.getDeviceArixZ();
        if (conditionField.contains(ModelTDevice.FI_DEVICE_ARIX_Z)) {
            throwExceptionIf((dDevice_arix_z!= null));
            sqlBuilder.itemWhere(ModelTDevice.FI_DEVICE_ARIX_Z, ColumnDataType.intData);
        } else {
            if (dDevice_arix_z!= null) {
                sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_ARIX_Z);
            }
        }
        Date dDevice_last_ocupy_time = instance.getDeviceLastOcupyTime();
        if (conditionField.contains(ModelTDevice.FI_DEVICE_LAST_OCUPY_TIME)) {
            throwExceptionIf((dDevice_last_ocupy_time!= null));
            sqlBuilder.itemWhere(ModelTDevice.FI_DEVICE_LAST_OCUPY_TIME, ColumnDataType.timeStampData);
        } else {
            if (dDevice_last_ocupy_time!= null) {
                sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_LAST_OCUPY_TIME);
            }
        }
        Date dDevice_last_release_time = instance.getDeviceLastReleaseTime();
        if (conditionField.contains(ModelTDevice.FI_DEVICE_LAST_RELEASE_TIME)) {
            throwExceptionIf((dDevice_last_release_time!= null));
            sqlBuilder.itemWhere(ModelTDevice.FI_DEVICE_LAST_RELEASE_TIME, ColumnDataType.timeStampData);
        } else {
            if (dDevice_last_release_time!= null) {
                sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_LAST_RELEASE_TIME);
            }
        }
        Integer dDevice_task_id = instance.getDeviceTaskId();
        if (conditionField.contains(ModelTDevice.FI_DEVICE_TASK_ID)) {
            throwExceptionIf((dDevice_task_id!= null));
            sqlBuilder.itemWhere(ModelTDevice.FI_DEVICE_TASK_ID, ColumnDataType.intData);
        } else {
            if (dDevice_task_id!= null) {
                sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_TASK_ID);
            }
        }
        Integer dDevice_last_proc = instance.getDeviceLastProc();
        if (conditionField.contains(ModelTDevice.FI_DEVICE_LAST_PROC)) {
            throwExceptionIf((dDevice_last_proc!= null));
            sqlBuilder.itemWhere(ModelTDevice.FI_DEVICE_LAST_PROC, ColumnDataType.intData);
        } else {
            if (dDevice_last_proc!= null) {
                sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_LAST_PROC);
            }
        }
        Integer dDevice_battery = instance.getDeviceBattery();
        if (conditionField.contains(ModelTDevice.FI_DEVICE_BATTERY)) {
            throwExceptionIf((dDevice_battery!= null));
            sqlBuilder.itemWhere(ModelTDevice.FI_DEVICE_BATTERY, ColumnDataType.intData);
        } else {
            if (dDevice_battery!= null) {
                sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_BATTERY);
            }
        }
        Integer dDevice_goods_holder_num = instance.getDeviceGoodsHolderNum();
        if (conditionField.contains(ModelTDevice.FI_DEVICE_GOODS_HOLDER_NUM)) {
            throwExceptionIf((dDevice_goods_holder_num!= null));
            sqlBuilder.itemWhere(ModelTDevice.FI_DEVICE_GOODS_HOLDER_NUM, ColumnDataType.intData);
        } else {
            if (dDevice_goods_holder_num!= null) {
                sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_GOODS_HOLDER_NUM);
            }
        }
        Integer dDevice_group = instance.getDeviceGroup();
        if (conditionField.contains(ModelTDevice.FI_DEVICE_GROUP)) {
            throwExceptionIf((dDevice_group!= null));
            sqlBuilder.itemWhere(ModelTDevice.FI_DEVICE_GROUP, ColumnDataType.intData);
        } else {
            if (dDevice_group!= null) {
                sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_GROUP);
            }
        }
        Integer dDevice_attach_map_point = instance.getDeviceAttachMapPoint();
        if (conditionField.contains(ModelTDevice.FI_DEVICE_ATTACH_MAP_POINT)) {
            throwExceptionIf((dDevice_attach_map_point!= null));
            sqlBuilder.itemWhere(ModelTDevice.FI_DEVICE_ATTACH_MAP_POINT, ColumnDataType.intData);
        } else {
            if (dDevice_attach_map_point!= null) {
                sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_ATTACH_MAP_POINT);
            }
        }
        Integer dDevice_index = instance.getDeviceIndex();
        if (conditionField.contains(ModelTDevice.FI_DEVICE_INDEX)) {
            throwExceptionIf((dDevice_index!= null));
            sqlBuilder.itemWhere(ModelTDevice.FI_DEVICE_INDEX, ColumnDataType.intData);
        } else {
            if (dDevice_index!= null) {
                sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_INDEX);
            }
        }
        EnumYesOrNo dDevice_handle_task = instance.getDeviceHandleTask();
        if (conditionField.contains(ModelTDevice.FI_DEVICE_HANDLE_TASK)) {
            throwExceptionIf((dDevice_handle_task!= null));
            sqlBuilder.itemWhere(ModelTDevice.FI_DEVICE_HANDLE_TASK, ColumnDataType.byteData);
        } else {
            if (dDevice_handle_task!= null) {
                sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_HANDLE_TASK);
            }
        }
        EnumDeviceControlStatus dDevice_control_status = instance.getDeviceControlStatus();
        if (conditionField.contains(ModelTDevice.FI_DEVICE_CONTROL_STATUS)) {
            throwExceptionIf((dDevice_control_status!= null));
            sqlBuilder.itemWhere(ModelTDevice.FI_DEVICE_CONTROL_STATUS, ColumnDataType.byteData);
        } else {
            if (dDevice_control_status!= null) {
                sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_CONTROL_STATUS);
            }
        }
        Map<String, Object> param = Constants.T_DEVICE_MAP_OBJ_MAPPER.toCommonMap(instance);
        return super.update(assembler, sqlBuilder, param);
    }

    public Integer update(ModelTDevice instance, Set<String> conditionField) {
        return update(instance, conditionField, null);
    }

    public Integer updateById(ModelTDevice instance, DaoAssembler assembler) {
        SQLUpdate sqlBuilder = SQLBuilder.buildUpdateSql();
        sqlBuilder.table(ModelTDevice.DTO_TABLE_NAME);
        throwExceptionIf((instance.getId()!= null));
        sqlBuilder.itemWhere("__id", ColumnDataType.intData);
        Integer dId = instance.getId();
        if (dId!= null) {
            sqlBuilder.itemCol(ModelTDevice.FI_ID);
        }
        EnumDeviceStatusType dDevice_status = instance.getDeviceStatus();
        if (dDevice_status!= null) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_STATUS);
        }
        String dDevice_ip = instance.getDeviceIp();
        if (dDevice_ip!= null) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_IP);
        }
        Integer dDevice_proc = instance.getDeviceProc();
        if (dDevice_proc!= null) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_PROC);
        }
        String dDevice_name = instance.getDeviceName();
        if (dDevice_name!= null) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_NAME);
        }
        String dDevice_desp = instance.getDeviceDesp();
        if (dDevice_desp!= null) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_DESP);
        }
        Date dDevice_create_time = instance.getDeviceCreateTime();
        if (dDevice_create_time!= null) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_CREATE_TIME);
        }
        Date dDevice_update_time = instance.getDeviceUpdateTime();
        if (dDevice_update_time!= null) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_UPDATE_TIME);
        }
        Byte dDevice_delete_flag = instance.getDeviceDeleteFlag();
        if (dDevice_delete_flag!= null) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_DELETE_FLAG);
        }
        Integer dDevice_type = instance.getDeviceType();
        if (dDevice_type!= null) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_TYPE);
        }
        String dDevice_remark = instance.getDeviceRemark();
        if (dDevice_remark!= null) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_REMARK);
        }
        String dDevice_hardware_id = instance.getDeviceHardwareId();
        if (dDevice_hardware_id!= null) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_HARDWARE_ID);
        }
        String dDevice_last_order_param = instance.getDeviceLastOrderParam();
        if (dDevice_last_order_param!= null) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_LAST_ORDER_PARAM);
        }
        Date dDevice_last_check_time = instance.getDeviceLastCheckTime();
        if (dDevice_last_check_time!= null) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_LAST_CHECK_TIME);
        }
        Integer dDevice_arix_x = instance.getDeviceArixX();
        if (dDevice_arix_x!= null) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_ARIX_X);
        }
        Integer dDevice_arix_y = instance.getDeviceArixY();
        if (dDevice_arix_y!= null) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_ARIX_Y);
        }
        Integer dDevice_arix_z = instance.getDeviceArixZ();
        if (dDevice_arix_z!= null) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_ARIX_Z);
        }
        Date dDevice_last_ocupy_time = instance.getDeviceLastOcupyTime();
        if (dDevice_last_ocupy_time!= null) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_LAST_OCUPY_TIME);
        }
        Date dDevice_last_release_time = instance.getDeviceLastReleaseTime();
        if (dDevice_last_release_time!= null) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_LAST_RELEASE_TIME);
        }
        Integer dDevice_task_id = instance.getDeviceTaskId();
        if (dDevice_task_id!= null) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_TASK_ID);
        }
        Integer dDevice_last_proc = instance.getDeviceLastProc();
        if (dDevice_last_proc!= null) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_LAST_PROC);
        }
        Integer dDevice_battery = instance.getDeviceBattery();
        if (dDevice_battery!= null) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_BATTERY);
        }
        Integer dDevice_goods_holder_num = instance.getDeviceGoodsHolderNum();
        if (dDevice_goods_holder_num!= null) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_GOODS_HOLDER_NUM);
        }
        Integer dDevice_group = instance.getDeviceGroup();
        if (dDevice_group!= null) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_GROUP);
        }
        Integer dDevice_attach_map_point = instance.getDeviceAttachMapPoint();
        if (dDevice_attach_map_point!= null) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_ATTACH_MAP_POINT);
        }
        Integer dDevice_index = instance.getDeviceIndex();
        if (dDevice_index!= null) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_INDEX);
        }
        EnumYesOrNo dDevice_handle_task = instance.getDeviceHandleTask();
        if (dDevice_handle_task!= null) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_HANDLE_TASK);
        }
        EnumDeviceControlStatus dDevice_control_status = instance.getDeviceControlStatus();
        if (dDevice_control_status!= null) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_CONTROL_STATUS);
        }
        Map<String, Object> param;
        param = Constants.T_DEVICE_MAP_OBJ_MAPPER.toCommonMap(instance);
        param.put("__id", instance.getId());
        return super.update(assembler, sqlBuilder, param);
    }

    public Integer updateById(ModelTDevice instance) {
        return updateById(instance, null);
    }

    public Integer updateByIds(ModelTDevice instance, Set<Integer> ids, DaoAssembler assembler) {
        SQLUpdate sqlBuilder = SQLBuilder.buildUpdateSql();
        sqlBuilder.table(ModelTDevice.DTO_TABLE_NAME);
        throwExceptionIf(((ids!= null)&&(ids.size()> 0)));
        sqlBuilder.itemWhere(LogicalOpType.in, "__ids", "__ids", ColumnDataType.intData);
        Integer dId = instance.getId();
        instance.setId(null);
        EnumDeviceStatusType dDevice_status = instance.getDeviceStatus();
        if (dDevice_status!= null) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_STATUS);
        }
        String dDevice_ip = instance.getDeviceIp();
        if (dDevice_ip!= null) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_IP);
        }
        Integer dDevice_proc = instance.getDeviceProc();
        if (dDevice_proc!= null) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_PROC);
        }
        String dDevice_name = instance.getDeviceName();
        if (dDevice_name!= null) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_NAME);
        }
        String dDevice_desp = instance.getDeviceDesp();
        if (dDevice_desp!= null) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_DESP);
        }
        Date dDevice_create_time = instance.getDeviceCreateTime();
        if (dDevice_create_time!= null) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_CREATE_TIME);
        }
        Date dDevice_update_time = instance.getDeviceUpdateTime();
        if (dDevice_update_time!= null) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_UPDATE_TIME);
        }
        Byte dDevice_delete_flag = instance.getDeviceDeleteFlag();
        if (dDevice_delete_flag!= null) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_DELETE_FLAG);
        }
        Integer dDevice_type = instance.getDeviceType();
        if (dDevice_type!= null) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_TYPE);
        }
        String dDevice_remark = instance.getDeviceRemark();
        if (dDevice_remark!= null) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_REMARK);
        }
        String dDevice_hardware_id = instance.getDeviceHardwareId();
        if (dDevice_hardware_id!= null) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_HARDWARE_ID);
        }
        String dDevice_last_order_param = instance.getDeviceLastOrderParam();
        if (dDevice_last_order_param!= null) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_LAST_ORDER_PARAM);
        }
        Date dDevice_last_check_time = instance.getDeviceLastCheckTime();
        if (dDevice_last_check_time!= null) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_LAST_CHECK_TIME);
        }
        Integer dDevice_arix_x = instance.getDeviceArixX();
        if (dDevice_arix_x!= null) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_ARIX_X);
        }
        Integer dDevice_arix_y = instance.getDeviceArixY();
        if (dDevice_arix_y!= null) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_ARIX_Y);
        }
        Integer dDevice_arix_z = instance.getDeviceArixZ();
        if (dDevice_arix_z!= null) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_ARIX_Z);
        }
        Date dDevice_last_ocupy_time = instance.getDeviceLastOcupyTime();
        if (dDevice_last_ocupy_time!= null) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_LAST_OCUPY_TIME);
        }
        Date dDevice_last_release_time = instance.getDeviceLastReleaseTime();
        if (dDevice_last_release_time!= null) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_LAST_RELEASE_TIME);
        }
        Integer dDevice_task_id = instance.getDeviceTaskId();
        if (dDevice_task_id!= null) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_TASK_ID);
        }
        Integer dDevice_last_proc = instance.getDeviceLastProc();
        if (dDevice_last_proc!= null) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_LAST_PROC);
        }
        Integer dDevice_battery = instance.getDeviceBattery();
        if (dDevice_battery!= null) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_BATTERY);
        }
        Integer dDevice_goods_holder_num = instance.getDeviceGoodsHolderNum();
        if (dDevice_goods_holder_num!= null) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_GOODS_HOLDER_NUM);
        }
        Integer dDevice_group = instance.getDeviceGroup();
        if (dDevice_group!= null) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_GROUP);
        }
        Integer dDevice_attach_map_point = instance.getDeviceAttachMapPoint();
        if (dDevice_attach_map_point!= null) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_ATTACH_MAP_POINT);
        }
        Integer dDevice_index = instance.getDeviceIndex();
        if (dDevice_index!= null) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_INDEX);
        }
        EnumYesOrNo dDevice_handle_task = instance.getDeviceHandleTask();
        if (dDevice_handle_task!= null) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_HANDLE_TASK);
        }
        EnumDeviceControlStatus dDevice_control_status = instance.getDeviceControlStatus();
        if (dDevice_control_status!= null) {
            sqlBuilder.itemCol(ModelTDevice.FI_DEVICE_CONTROL_STATUS);
        }
        Map<String, Object> param;
        param = Constants.T_DEVICE_MAP_OBJ_MAPPER.toCommonMap(instance);
        param.put("__ids", ids);
        return super.update(assembler, sqlBuilder, param);
    }

    public Integer updateByIds(ModelTDevice instance, Set<Integer> ids) {
        return updateByIds(instance, ids, null);
    }

    public Integer deleteById(Integer id, DaoAssembler assembler) {
        SQLDelete sqlBuilder = SQLBuilder.buildDeleteSql();
        sqlBuilder.table(ModelTDevice.DTO_TABLE_NAME);
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
        sqlBuilder.table(ModelTDevice.DTO_TABLE_NAME);
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
    public ModelTDevice updateOrInsert(ModelTDevice instance, Set<String> conditionField, AbstractMultipleDaoAssembler assembler) {
        if (assembler == null) {
            assembler = new BaseMultipleDaoAssembler();
        }
        ModelTDevice checkInstance = new ModelTDevice();
        if (conditionField.contains(ModelTDevice.FI_ID)) {
            checkInstance.setId(instance.getId());
        }
        if (conditionField.contains(ModelTDevice.FI_DEVICE_STATUS)) {
            checkInstance.setDeviceStatus(instance.getDeviceStatus());
        }
        if (conditionField.contains(ModelTDevice.FI_DEVICE_IP)) {
            checkInstance.setDeviceIp(instance.getDeviceIp());
        }
        if (conditionField.contains(ModelTDevice.FI_DEVICE_PROC)) {
            checkInstance.setDeviceProc(instance.getDeviceProc());
        }
        if (conditionField.contains(ModelTDevice.FI_DEVICE_NAME)) {
            checkInstance.setDeviceName(instance.getDeviceName());
        }
        if (conditionField.contains(ModelTDevice.FI_DEVICE_DESP)) {
            checkInstance.setDeviceDesp(instance.getDeviceDesp());
        }
        if (conditionField.contains(ModelTDevice.FI_DEVICE_CREATE_TIME)) {
            checkInstance.setDeviceCreateTime(instance.getDeviceCreateTime());
        }
        if (conditionField.contains(ModelTDevice.FI_DEVICE_UPDATE_TIME)) {
            checkInstance.setDeviceUpdateTime(instance.getDeviceUpdateTime());
        }
        if (conditionField.contains(ModelTDevice.FI_DEVICE_DELETE_FLAG)) {
            checkInstance.setDeviceDeleteFlag(instance.getDeviceDeleteFlag());
        }
        if (conditionField.contains(ModelTDevice.FI_DEVICE_TYPE)) {
            checkInstance.setDeviceType(instance.getDeviceType());
        }
        if (conditionField.contains(ModelTDevice.FI_DEVICE_REMARK)) {
            checkInstance.setDeviceRemark(instance.getDeviceRemark());
        }
        if (conditionField.contains(ModelTDevice.FI_DEVICE_HARDWARE_ID)) {
            checkInstance.setDeviceHardwareId(instance.getDeviceHardwareId());
        }
        if (conditionField.contains(ModelTDevice.FI_DEVICE_LAST_ORDER_PARAM)) {
            checkInstance.setDeviceLastOrderParam(instance.getDeviceLastOrderParam());
        }
        if (conditionField.contains(ModelTDevice.FI_DEVICE_LAST_CHECK_TIME)) {
            checkInstance.setDeviceLastCheckTime(instance.getDeviceLastCheckTime());
        }
        if (conditionField.contains(ModelTDevice.FI_DEVICE_ARIX_X)) {
            checkInstance.setDeviceArixX(instance.getDeviceArixX());
        }
        if (conditionField.contains(ModelTDevice.FI_DEVICE_ARIX_Y)) {
            checkInstance.setDeviceArixY(instance.getDeviceArixY());
        }
        if (conditionField.contains(ModelTDevice.FI_DEVICE_ARIX_Z)) {
            checkInstance.setDeviceArixZ(instance.getDeviceArixZ());
        }
        if (conditionField.contains(ModelTDevice.FI_DEVICE_LAST_OCUPY_TIME)) {
            checkInstance.setDeviceLastOcupyTime(instance.getDeviceLastOcupyTime());
        }
        if (conditionField.contains(ModelTDevice.FI_DEVICE_LAST_RELEASE_TIME)) {
            checkInstance.setDeviceLastReleaseTime(instance.getDeviceLastReleaseTime());
        }
        if (conditionField.contains(ModelTDevice.FI_DEVICE_TASK_ID)) {
            checkInstance.setDeviceTaskId(instance.getDeviceTaskId());
        }
        if (conditionField.contains(ModelTDevice.FI_DEVICE_LAST_PROC)) {
            checkInstance.setDeviceLastProc(instance.getDeviceLastProc());
        }
        if (conditionField.contains(ModelTDevice.FI_DEVICE_BATTERY)) {
            checkInstance.setDeviceBattery(instance.getDeviceBattery());
        }
        if (conditionField.contains(ModelTDevice.FI_DEVICE_GOODS_HOLDER_NUM)) {
            checkInstance.setDeviceGoodsHolderNum(instance.getDeviceGoodsHolderNum());
        }
        if (conditionField.contains(ModelTDevice.FI_DEVICE_GROUP)) {
            checkInstance.setDeviceGroup(instance.getDeviceGroup());
        }
        if (conditionField.contains(ModelTDevice.FI_DEVICE_ATTACH_MAP_POINT)) {
            checkInstance.setDeviceAttachMapPoint(instance.getDeviceAttachMapPoint());
        }
        if (conditionField.contains(ModelTDevice.FI_DEVICE_INDEX)) {
            checkInstance.setDeviceIndex(instance.getDeviceIndex());
        }
        if (conditionField.contains(ModelTDevice.FI_DEVICE_HANDLE_TASK)) {
            checkInstance.setDeviceHandleTask(instance.getDeviceHandleTask());
        }
        if (conditionField.contains(ModelTDevice.FI_DEVICE_CONTROL_STATUS)) {
            checkInstance.setDeviceControlStatus(instance.getDeviceControlStatus());
        }
        ModelTDevice selected = getOneByCond(Collections.singleton(ModelTDevice.FI_ID), assembler, checkInstance);
        assembler.increaseIndex();
        if (selected == null) {
            return insert(instance, assembler);
        } else {
            instance.setId(selected.getId());
            update(instance, Collections.singleton(ModelTDevice.FI_ID), assembler);
            return instance;
        }
    }

    public ModelTDevice updateOrInsert(ModelTDevice instance, Set<String> conditionField) {
        return updateOrInsert(instance, conditionField, null);
    }

    @Transactional
    public ModelTDevice insertIfNoExist(ModelTDevice instance, Set<String> conditionField, AbstractMultipleDaoAssembler assembler) {
        if (assembler == null) {
            assembler = new BaseMultipleDaoAssembler();
        }
        ModelTDevice checkInstance = new ModelTDevice();
        if (conditionField.contains(ModelTDevice.FI_ID)) {
            checkInstance.setId(instance.getId());
        }
        if (conditionField.contains(ModelTDevice.FI_DEVICE_STATUS)) {
            checkInstance.setDeviceStatus(instance.getDeviceStatus());
        }
        if (conditionField.contains(ModelTDevice.FI_DEVICE_IP)) {
            checkInstance.setDeviceIp(instance.getDeviceIp());
        }
        if (conditionField.contains(ModelTDevice.FI_DEVICE_PROC)) {
            checkInstance.setDeviceProc(instance.getDeviceProc());
        }
        if (conditionField.contains(ModelTDevice.FI_DEVICE_NAME)) {
            checkInstance.setDeviceName(instance.getDeviceName());
        }
        if (conditionField.contains(ModelTDevice.FI_DEVICE_DESP)) {
            checkInstance.setDeviceDesp(instance.getDeviceDesp());
        }
        if (conditionField.contains(ModelTDevice.FI_DEVICE_CREATE_TIME)) {
            checkInstance.setDeviceCreateTime(instance.getDeviceCreateTime());
        }
        if (conditionField.contains(ModelTDevice.FI_DEVICE_UPDATE_TIME)) {
            checkInstance.setDeviceUpdateTime(instance.getDeviceUpdateTime());
        }
        if (conditionField.contains(ModelTDevice.FI_DEVICE_DELETE_FLAG)) {
            checkInstance.setDeviceDeleteFlag(instance.getDeviceDeleteFlag());
        }
        if (conditionField.contains(ModelTDevice.FI_DEVICE_TYPE)) {
            checkInstance.setDeviceType(instance.getDeviceType());
        }
        if (conditionField.contains(ModelTDevice.FI_DEVICE_REMARK)) {
            checkInstance.setDeviceRemark(instance.getDeviceRemark());
        }
        if (conditionField.contains(ModelTDevice.FI_DEVICE_HARDWARE_ID)) {
            checkInstance.setDeviceHardwareId(instance.getDeviceHardwareId());
        }
        if (conditionField.contains(ModelTDevice.FI_DEVICE_LAST_ORDER_PARAM)) {
            checkInstance.setDeviceLastOrderParam(instance.getDeviceLastOrderParam());
        }
        if (conditionField.contains(ModelTDevice.FI_DEVICE_LAST_CHECK_TIME)) {
            checkInstance.setDeviceLastCheckTime(instance.getDeviceLastCheckTime());
        }
        if (conditionField.contains(ModelTDevice.FI_DEVICE_ARIX_X)) {
            checkInstance.setDeviceArixX(instance.getDeviceArixX());
        }
        if (conditionField.contains(ModelTDevice.FI_DEVICE_ARIX_Y)) {
            checkInstance.setDeviceArixY(instance.getDeviceArixY());
        }
        if (conditionField.contains(ModelTDevice.FI_DEVICE_ARIX_Z)) {
            checkInstance.setDeviceArixZ(instance.getDeviceArixZ());
        }
        if (conditionField.contains(ModelTDevice.FI_DEVICE_LAST_OCUPY_TIME)) {
            checkInstance.setDeviceLastOcupyTime(instance.getDeviceLastOcupyTime());
        }
        if (conditionField.contains(ModelTDevice.FI_DEVICE_LAST_RELEASE_TIME)) {
            checkInstance.setDeviceLastReleaseTime(instance.getDeviceLastReleaseTime());
        }
        if (conditionField.contains(ModelTDevice.FI_DEVICE_TASK_ID)) {
            checkInstance.setDeviceTaskId(instance.getDeviceTaskId());
        }
        if (conditionField.contains(ModelTDevice.FI_DEVICE_LAST_PROC)) {
            checkInstance.setDeviceLastProc(instance.getDeviceLastProc());
        }
        if (conditionField.contains(ModelTDevice.FI_DEVICE_BATTERY)) {
            checkInstance.setDeviceBattery(instance.getDeviceBattery());
        }
        if (conditionField.contains(ModelTDevice.FI_DEVICE_GOODS_HOLDER_NUM)) {
            checkInstance.setDeviceGoodsHolderNum(instance.getDeviceGoodsHolderNum());
        }
        if (conditionField.contains(ModelTDevice.FI_DEVICE_GROUP)) {
            checkInstance.setDeviceGroup(instance.getDeviceGroup());
        }
        if (conditionField.contains(ModelTDevice.FI_DEVICE_ATTACH_MAP_POINT)) {
            checkInstance.setDeviceAttachMapPoint(instance.getDeviceAttachMapPoint());
        }
        if (conditionField.contains(ModelTDevice.FI_DEVICE_INDEX)) {
            checkInstance.setDeviceIndex(instance.getDeviceIndex());
        }
        if (conditionField.contains(ModelTDevice.FI_DEVICE_HANDLE_TASK)) {
            checkInstance.setDeviceHandleTask(instance.getDeviceHandleTask());
        }
        if (conditionField.contains(ModelTDevice.FI_DEVICE_CONTROL_STATUS)) {
            checkInstance.setDeviceControlStatus(instance.getDeviceControlStatus());
        }
        ModelTDevice selected = getOneByCond(Collections.singleton(ModelTDevice.FI_ID), assembler, checkInstance);
        assembler.increaseIndex();
        if (selected == null) {
            return insert(instance, assembler);
        } else {
            instance.setId(selected.getId());
            return instance;
        }
    }

    public ModelTDevice insertIfNoExist(ModelTDevice instance, Set<String> conditionField) {
        return insertIfNoExist(instance, conditionField, null);
    }

    public<TT> Map<TT, ModelTDevice> buildMap(List<ModelTDevice> list, String field) {
        Map<TT, ModelTDevice> ret = CollectionHelper.newMap();
        if (list == null) {
            return ret;
        }
        for (ModelTDevice item: list) {
            ret.put(Constants.T_DEVICE_MAP_OBJ_MAPPER.<TT> getField(field, item), item);
        }
        return ret;
    }

    public<TT> Map<TT, List<ModelTDevice>> buildListMap(List<ModelTDevice> list, String field) {
        Map<TT, List<ModelTDevice>> ret = CollectionHelper.newMap();
        if (list == null) {
            return ret;
        }
        for (ModelTDevice item: list) {
            List<ModelTDevice> itemList = ret.get(Constants.T_DEVICE_MAP_OBJ_MAPPER.<TT> getField(field, item));
            if (itemList == null) {
                itemList = CollectionHelper.newList();
            }
            itemList.add(item);
            ret.put(Constants.T_DEVICE_MAP_OBJ_MAPPER.<TT> getField(field, item), itemList);
        }
        return ret;
    }

    public<TT> List<TT> extractItemAsList(List<ModelTDevice> list, String field) {
        List<TT> ret = CollectionHelper.newList();
        if ((list == null)||(list.size() == 0)) {
            return ret;
        }
        if (ModelTDevice.FIELD_CLASS.containsKey(field)) {
            for (ModelTDevice item: list) {
                ret.add(Constants.T_DEVICE_MAP_OBJ_MAPPER.<TT> getField(field, item));
            }
        }
        return ret;
    }
}
