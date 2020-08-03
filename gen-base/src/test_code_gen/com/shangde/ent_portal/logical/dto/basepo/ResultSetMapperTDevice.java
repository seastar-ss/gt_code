package com.shangde.ent_portal.logical.dto.basepo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;
import com.shangde.ent_portal.logical.dto.enums.EnumDeviceControlStatus;
import com.shangde.ent_portal.logical.dto.enums.EnumDeviceStatusType;
import com.shangde.ent_portal.logical.dto.enums.EnumYesOrNo;
import com.shawn.ss.lib.tools.db.api.interfaces.mappers.db.DbResultSetMapper;
import com.shawn.ss.lib.tools.db.impl.mapper.BaseDbMapper;

public class ResultSetMapperTDevice<T extends ModelTDevice>
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
        return ((T) new ModelTDevice());
    }

    @Override
    public T mapRow(T instance, ResultSet rs, int rowNum, Set<String> columnNames)
        throws SQLException
    {
        mapFieldId(rs, columnNames, instance);
        mapFieldDevice_status(rs, columnNames, instance);
        mapFieldDevice_ip(rs, columnNames, instance);
        mapFieldDevice_proc(rs, columnNames, instance);
        mapFieldDevice_name(rs, columnNames, instance);
        mapFieldDevice_desp(rs, columnNames, instance);
        mapFieldDevice_create_time(rs, columnNames, instance);
        mapFieldDevice_update_time(rs, columnNames, instance);
        mapFieldDevice_delete_flag(rs, columnNames, instance);
        mapFieldDevice_type(rs, columnNames, instance);
        mapFieldDevice_remark(rs, columnNames, instance);
        mapFieldDevice_hardware_id(rs, columnNames, instance);
        mapFieldDevice_last_order_param(rs, columnNames, instance);
        mapFieldDevice_last_check_time(rs, columnNames, instance);
        mapFieldDevice_arix_x(rs, columnNames, instance);
        mapFieldDevice_arix_y(rs, columnNames, instance);
        mapFieldDevice_arix_z(rs, columnNames, instance);
        mapFieldDevice_last_ocupy_time(rs, columnNames, instance);
        mapFieldDevice_last_release_time(rs, columnNames, instance);
        mapFieldDevice_task_id(rs, columnNames, instance);
        mapFieldDevice_last_proc(rs, columnNames, instance);
        mapFieldDevice_battery(rs, columnNames, instance);
        mapFieldDevice_goods_holder_num(rs, columnNames, instance);
        mapFieldDevice_group(rs, columnNames, instance);
        mapFieldDevice_attach_map_point(rs, columnNames, instance);
        mapFieldDevice_index(rs, columnNames, instance);
        mapFieldDevice_handle_task(rs, columnNames, instance);
        mapFieldDevice_control_status(rs, columnNames, instance);
        instance.setIndex(rowNum);
        return instance;
    }

    protected void mapFieldId(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelTDevice.FI_ID)) {
            instance.setId(rs.getInt(ModelTDevice.FI_ID));
        }
    }

    protected void mapFieldDevice_status(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelTDevice.FI_DEVICE_STATUS)) {
            instance.setDeviceStatus(EnumDeviceStatusType.fromValue(rs.getByte(ModelTDevice.FI_DEVICE_STATUS)));
        }
    }

    protected void mapFieldDevice_ip(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelTDevice.FI_DEVICE_IP)) {
            instance.setDeviceIp(rs.getString(ModelTDevice.FI_DEVICE_IP));
        }
    }

    protected void mapFieldDevice_proc(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelTDevice.FI_DEVICE_PROC)) {
            instance.setDeviceProc(rs.getInt(ModelTDevice.FI_DEVICE_PROC));
        }
    }

    protected void mapFieldDevice_name(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelTDevice.FI_DEVICE_NAME)) {
            instance.setDeviceName(rs.getString(ModelTDevice.FI_DEVICE_NAME));
        }
    }

    protected void mapFieldDevice_desp(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelTDevice.FI_DEVICE_DESP)) {
            instance.setDeviceDesp(rs.getString(ModelTDevice.FI_DEVICE_DESP));
        }
    }

    protected void mapFieldDevice_create_time(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelTDevice.FI_DEVICE_CREATE_TIME)) {
            instance.setDeviceCreateTime(rs.getTimestamp(ModelTDevice.FI_DEVICE_CREATE_TIME));
        }
    }

    protected void mapFieldDevice_update_time(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelTDevice.FI_DEVICE_UPDATE_TIME)) {
            instance.setDeviceUpdateTime(rs.getTimestamp(ModelTDevice.FI_DEVICE_UPDATE_TIME));
        }
    }

    protected void mapFieldDevice_delete_flag(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelTDevice.FI_DEVICE_DELETE_FLAG)) {
            instance.setDeviceDeleteFlag(rs.getByte(ModelTDevice.FI_DEVICE_DELETE_FLAG));
        }
    }

    protected void mapFieldDevice_type(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelTDevice.FI_DEVICE_TYPE)) {
            instance.setDeviceType(rs.getInt(ModelTDevice.FI_DEVICE_TYPE));
        }
    }

    protected void mapFieldDevice_remark(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelTDevice.FI_DEVICE_REMARK)) {
            instance.setDeviceRemark(rs.getString(ModelTDevice.FI_DEVICE_REMARK));
        }
    }

    protected void mapFieldDevice_hardware_id(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelTDevice.FI_DEVICE_HARDWARE_ID)) {
            instance.setDeviceHardwareId(rs.getString(ModelTDevice.FI_DEVICE_HARDWARE_ID));
        }
    }

    protected void mapFieldDevice_last_order_param(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelTDevice.FI_DEVICE_LAST_ORDER_PARAM)) {
            instance.setDeviceLastOrderParam(rs.getString(ModelTDevice.FI_DEVICE_LAST_ORDER_PARAM));
        }
    }

    protected void mapFieldDevice_last_check_time(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelTDevice.FI_DEVICE_LAST_CHECK_TIME)) {
            instance.setDeviceLastCheckTime(rs.getTimestamp(ModelTDevice.FI_DEVICE_LAST_CHECK_TIME));
        }
    }

    protected void mapFieldDevice_arix_x(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelTDevice.FI_DEVICE_ARIX_X)) {
            instance.setDeviceArixX(rs.getInt(ModelTDevice.FI_DEVICE_ARIX_X));
        }
    }

    protected void mapFieldDevice_arix_y(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelTDevice.FI_DEVICE_ARIX_Y)) {
            instance.setDeviceArixY(rs.getInt(ModelTDevice.FI_DEVICE_ARIX_Y));
        }
    }

    protected void mapFieldDevice_arix_z(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelTDevice.FI_DEVICE_ARIX_Z)) {
            instance.setDeviceArixZ(rs.getInt(ModelTDevice.FI_DEVICE_ARIX_Z));
        }
    }

    protected void mapFieldDevice_last_ocupy_time(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelTDevice.FI_DEVICE_LAST_OCUPY_TIME)) {
            instance.setDeviceLastOcupyTime(rs.getTimestamp(ModelTDevice.FI_DEVICE_LAST_OCUPY_TIME));
        }
    }

    protected void mapFieldDevice_last_release_time(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelTDevice.FI_DEVICE_LAST_RELEASE_TIME)) {
            instance.setDeviceLastReleaseTime(rs.getTimestamp(ModelTDevice.FI_DEVICE_LAST_RELEASE_TIME));
        }
    }

    protected void mapFieldDevice_task_id(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelTDevice.FI_DEVICE_TASK_ID)) {
            instance.setDeviceTaskId(rs.getInt(ModelTDevice.FI_DEVICE_TASK_ID));
        }
    }

    protected void mapFieldDevice_last_proc(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelTDevice.FI_DEVICE_LAST_PROC)) {
            instance.setDeviceLastProc(rs.getInt(ModelTDevice.FI_DEVICE_LAST_PROC));
        }
    }

    protected void mapFieldDevice_battery(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelTDevice.FI_DEVICE_BATTERY)) {
            instance.setDeviceBattery(rs.getInt(ModelTDevice.FI_DEVICE_BATTERY));
        }
    }

    protected void mapFieldDevice_goods_holder_num(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelTDevice.FI_DEVICE_GOODS_HOLDER_NUM)) {
            instance.setDeviceGoodsHolderNum(rs.getInt(ModelTDevice.FI_DEVICE_GOODS_HOLDER_NUM));
        }
    }

    protected void mapFieldDevice_group(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelTDevice.FI_DEVICE_GROUP)) {
            instance.setDeviceGroup(rs.getInt(ModelTDevice.FI_DEVICE_GROUP));
        }
    }

    protected void mapFieldDevice_attach_map_point(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelTDevice.FI_DEVICE_ATTACH_MAP_POINT)) {
            instance.setDeviceAttachMapPoint(rs.getInt(ModelTDevice.FI_DEVICE_ATTACH_MAP_POINT));
        }
    }

    protected void mapFieldDevice_index(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelTDevice.FI_DEVICE_INDEX)) {
            instance.setDeviceIndex(rs.getInt(ModelTDevice.FI_DEVICE_INDEX));
        }
    }

    protected void mapFieldDevice_handle_task(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelTDevice.FI_DEVICE_HANDLE_TASK)) {
            instance.setDeviceHandleTask(EnumYesOrNo.fromValue(rs.getByte(ModelTDevice.FI_DEVICE_HANDLE_TASK)));
        }
    }

    protected void mapFieldDevice_control_status(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelTDevice.FI_DEVICE_CONTROL_STATUS)) {
            instance.setDeviceControlStatus(EnumDeviceControlStatus.fromValue(rs.getByte(ModelTDevice.FI_DEVICE_CONTROL_STATUS)));
        }
    }
}
