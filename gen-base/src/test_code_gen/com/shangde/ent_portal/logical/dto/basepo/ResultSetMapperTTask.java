package com.shangde.ent_portal.logical.dto.basepo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;
import com.shangde.ent_portal.logical.dto.enums.EnumTaskStatus;
import com.shangde.ent_portal.logical.dto.enums.EnumTaskType;
import com.shawn.ss.lib.tools.db.api.interfaces.mappers.db.DbResultSetMapper;
import com.shawn.ss.lib.tools.db.impl.mapper.BaseDbMapper;

public class ResultSetMapperTTask<T extends ModelTTask>
    extends BaseDbMapper<T>
    implements DbResultSetMapper<T>
{

    @Override
    public T mapRow(ResultSet rs, int rowNum, Set<String> columnNames)
        throws SQLException
    {
        T instance = buildInstance();
        return mapRow(instance, rs, rowNum, columnNames);
    }

    protected T buildInstance() {
        return ((T) new ModelTTask());
    }

    @Override
    public T mapRow(T instance, ResultSet rs, int rowNum, Set<String> columnNames)
        throws SQLException
    {
        mapFieldId(rs, columnNames, instance);
        mapFieldTask_create_time(rs, columnNames, instance);
        mapFieldTask_expected_start_time(rs, columnNames, instance);
        mapFieldTask_start_time(rs, columnNames, instance);
        mapFieldTask_finish_time(rs, columnNames, instance);
        mapFieldTask_remark(rs, columnNames, instance);
        mapFieldTask_order_id(rs, columnNames, instance);
        mapFieldTask_param(rs, columnNames, instance);
        mapFieldTask_status(rs, columnNames, instance);
        mapFieldTask_total_path(rs, columnNames, instance);
        mapFieldTask_current_path_id(rs, columnNames, instance);
        mapFieldTask_current_path_index(rs, columnNames, instance);
        mapFieldArix_x(rs, columnNames, instance);
        mapFieldArix_y(rs, columnNames, instance);
        mapFieldArix_z(rs, columnNames, instance);
        mapFieldPoint_index(rs, columnNames, instance);
        mapFieldGoods_id(rs, columnNames, instance);
        mapFieldGoods_info(rs, columnNames, instance);
        mapFieldGoods_name(rs, columnNames, instance);
        mapFieldGoods_weight(rs, columnNames, instance);
        mapFieldOrigin_arix_x(rs, columnNames, instance);
        mapFieldOrigin_arix_y(rs, columnNames, instance);
        mapFieldOrigin_arix_z(rs, columnNames, instance);
        mapFieldOrigin_point_index(rs, columnNames, instance);
        mapFieldTask_depends_on(rs, columnNames, instance);
        mapFieldTask_parent_id(rs, columnNames, instance);
        mapFieldTask_group_id(rs, columnNames, instance);
        mapFieldTask_type(rs, columnNames, instance);
        mapFieldTask_appointed_device(rs, columnNames, instance);
        mapFieldTask_priority(rs, columnNames, instance);
        mapFieldRetry_times(rs, columnNames, instance);
        mapFieldCurrent_arix_x(rs, columnNames, instance);
        mapFieldCurrent_arix_y(rs, columnNames, instance);
        mapFieldCurrent_arix_z(rs, columnNames, instance);
        mapFieldCurrent_point_index(rs, columnNames, instance);
        mapFieldCurrent_waiting_device(rs, columnNames, instance);
        instance.setIndex(rowNum);
        return instance;
    }

    protected void mapFieldId(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelTTask.FI_ID)) {
            instance.setId(rs.getInt(ModelTTask.FI_ID));
        }
    }

    protected void mapFieldTask_create_time(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelTTask.FI_TASK_CREATE_TIME)) {
            instance.setTaskCreateTime(rs.getTimestamp(ModelTTask.FI_TASK_CREATE_TIME));
        }
    }

    protected void mapFieldTask_expected_start_time(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelTTask.FI_TASK_EXPECTED_START_TIME)) {
            instance.setTaskExpectedStartTime(rs.getTimestamp(ModelTTask.FI_TASK_EXPECTED_START_TIME));
        }
    }

    protected void mapFieldTask_start_time(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelTTask.FI_TASK_START_TIME)) {
            instance.setTaskStartTime(rs.getTimestamp(ModelTTask.FI_TASK_START_TIME));
        }
    }

    protected void mapFieldTask_finish_time(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelTTask.FI_TASK_FINISH_TIME)) {
            instance.setTaskFinishTime(rs.getTimestamp(ModelTTask.FI_TASK_FINISH_TIME));
        }
    }

    protected void mapFieldTask_remark(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelTTask.FI_TASK_REMARK)) {
            instance.setTaskRemark(rs.getString(ModelTTask.FI_TASK_REMARK));
        }
    }

    protected void mapFieldTask_order_id(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelTTask.FI_TASK_ORDER_ID)) {
            instance.setTaskOrderId(rs.getInt(ModelTTask.FI_TASK_ORDER_ID));
        }
    }

    protected void mapFieldTask_param(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelTTask.FI_TASK_PARAM)) {
            instance.setTaskParam(rs.getString(ModelTTask.FI_TASK_PARAM));
        }
    }

    protected void mapFieldTask_status(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelTTask.FI_TASK_STATUS)) {
            instance.setTaskStatus(EnumTaskStatus.fromValue(rs.getByte(ModelTTask.FI_TASK_STATUS)));
        }
    }

    protected void mapFieldTask_total_path(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelTTask.FI_TASK_TOTAL_PATH)) {
            instance.setTaskTotalPath(rs.getShort(ModelTTask.FI_TASK_TOTAL_PATH));
        }
    }

    protected void mapFieldTask_current_path_id(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelTTask.FI_TASK_CURRENT_PATH_ID)) {
            instance.setTaskCurrentPathId(rs.getInt(ModelTTask.FI_TASK_CURRENT_PATH_ID));
        }
    }

    protected void mapFieldTask_current_path_index(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelTTask.FI_TASK_CURRENT_PATH_INDEX)) {
            instance.setTaskCurrentPathIndex(rs.getShort(ModelTTask.FI_TASK_CURRENT_PATH_INDEX));
        }
    }

    protected void mapFieldArix_x(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelTTask.FI_ARIX_X)) {
            instance.setArixX(rs.getInt(ModelTTask.FI_ARIX_X));
        }
    }

    protected void mapFieldArix_y(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelTTask.FI_ARIX_Y)) {
            instance.setArixY(rs.getInt(ModelTTask.FI_ARIX_Y));
        }
    }

    protected void mapFieldArix_z(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelTTask.FI_ARIX_Z)) {
            instance.setArixZ(rs.getInt(ModelTTask.FI_ARIX_Z));
        }
    }

    protected void mapFieldPoint_index(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelTTask.FI_POINT_INDEX)) {
            instance.setPointIndex(rs.getInt(ModelTTask.FI_POINT_INDEX));
        }
    }

    protected void mapFieldGoods_id(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelTTask.FI_GOODS_ID)) {
            instance.setGoodsId(rs.getString(ModelTTask.FI_GOODS_ID));
        }
    }

    protected void mapFieldGoods_info(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelTTask.FI_GOODS_INFO)) {
            instance.setGoodsInfo(rs.getString(ModelTTask.FI_GOODS_INFO));
        }
    }

    protected void mapFieldGoods_name(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelTTask.FI_GOODS_NAME)) {
            instance.setGoodsName(rs.getString(ModelTTask.FI_GOODS_NAME));
        }
    }

    protected void mapFieldGoods_weight(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelTTask.FI_GOODS_WEIGHT)) {
            instance.setGoodsWeight(rs.getInt(ModelTTask.FI_GOODS_WEIGHT));
        }
    }

    protected void mapFieldOrigin_arix_x(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelTTask.FI_ORIGIN_ARIX_X)) {
            instance.setOriginArixX(rs.getInt(ModelTTask.FI_ORIGIN_ARIX_X));
        }
    }

    protected void mapFieldOrigin_arix_y(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelTTask.FI_ORIGIN_ARIX_Y)) {
            instance.setOriginArixY(rs.getInt(ModelTTask.FI_ORIGIN_ARIX_Y));
        }
    }

    protected void mapFieldOrigin_arix_z(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelTTask.FI_ORIGIN_ARIX_Z)) {
            instance.setOriginArixZ(rs.getInt(ModelTTask.FI_ORIGIN_ARIX_Z));
        }
    }

    protected void mapFieldOrigin_point_index(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelTTask.FI_ORIGIN_POINT_INDEX)) {
            instance.setOriginPointIndex(rs.getInt(ModelTTask.FI_ORIGIN_POINT_INDEX));
        }
    }

    protected void mapFieldTask_depends_on(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelTTask.FI_TASK_DEPENDS_ON)) {
            instance.setTaskDependsOn(rs.getInt(ModelTTask.FI_TASK_DEPENDS_ON));
        }
    }

    protected void mapFieldTask_parent_id(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelTTask.FI_TASK_PARENT_ID)) {
            instance.setTaskParentId(rs.getInt(ModelTTask.FI_TASK_PARENT_ID));
        }
    }

    protected void mapFieldTask_group_id(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelTTask.FI_TASK_GROUP_ID)) {
            instance.setTaskGroupId(rs.getInt(ModelTTask.FI_TASK_GROUP_ID));
        }
    }

    protected void mapFieldTask_type(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelTTask.FI_TASK_TYPE)) {
            instance.setTaskType(EnumTaskType.fromValue(rs.getByte(ModelTTask.FI_TASK_TYPE)));
        }
    }

    protected void mapFieldTask_appointed_device(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelTTask.FI_TASK_APPOINTED_DEVICE)) {
            instance.setTaskAppointedDevice(rs.getInt(ModelTTask.FI_TASK_APPOINTED_DEVICE));
        }
    }

    protected void mapFieldTask_priority(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelTTask.FI_TASK_PRIORITY)) {
            instance.setTaskPriority(rs.getInt(ModelTTask.FI_TASK_PRIORITY));
        }
    }

    protected void mapFieldRetry_times(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelTTask.FI_RETRY_TIMES)) {
            instance.setRetryTimes(rs.getInt(ModelTTask.FI_RETRY_TIMES));
        }
    }

    protected void mapFieldCurrent_arix_x(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelTTask.FI_CURRENT_ARIX_X)) {
            instance.setCurrentArixX(rs.getInt(ModelTTask.FI_CURRENT_ARIX_X));
        }
    }

    protected void mapFieldCurrent_arix_y(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelTTask.FI_CURRENT_ARIX_Y)) {
            instance.setCurrentArixY(rs.getInt(ModelTTask.FI_CURRENT_ARIX_Y));
        }
    }

    protected void mapFieldCurrent_arix_z(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelTTask.FI_CURRENT_ARIX_Z)) {
            instance.setCurrentArixZ(rs.getInt(ModelTTask.FI_CURRENT_ARIX_Z));
        }
    }

    protected void mapFieldCurrent_point_index(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelTTask.FI_CURRENT_POINT_INDEX)) {
            instance.setCurrentPointIndex(rs.getInt(ModelTTask.FI_CURRENT_POINT_INDEX));
        }
    }

    protected void mapFieldCurrent_waiting_device(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelTTask.FI_CURRENT_WAITING_DEVICE)) {
            instance.setCurrentWaitingDevice(rs.getInt(ModelTTask.FI_CURRENT_WAITING_DEVICE));
        }
    }
}
