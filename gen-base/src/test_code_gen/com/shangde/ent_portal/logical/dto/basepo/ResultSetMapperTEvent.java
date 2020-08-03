package com.shangde.ent_portal.logical.dto.basepo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;
import com.shangde.ent_portal.logical.dto.enums.EnumDeviceStatusType;
import com.shangde.ent_portal.logical.dto.enums.EnumEventHandlerType;
import com.shangde.ent_portal.logical.dto.enums.EnumEventStatus;
import com.shangde.ent_portal.logical.dto.enums.EnumTaskStatus;
import com.shawn.ss.lib.tools.db.api.interfaces.mappers.db.DbResultSetMapper;
import com.shawn.ss.lib.tools.db.impl.mapper.BaseDbMapper;

public class ResultSetMapperTEvent<T extends ModelTEvent>
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
        return ((T) new ModelTEvent());
    }

    @Override
    public T mapRow(T instance, ResultSet rs, int rowNum, Set<String> columnNames)
        throws SQLException
    {
        mapFieldId(rs, columnNames, instance);
        mapFieldEvent_device(rs, columnNames, instance);
        mapFieldEvent_name(rs, columnNames, instance);
        mapFieldEvent_time(rs, columnNames, instance);
        mapFieldEvent_type(rs, columnNames, instance);
        mapFieldEvent_message(rs, columnNames, instance);
        mapFieldEvent_task_id(rs, columnNames, instance);
        mapFieldEvent_remark(rs, columnNames, instance);
        mapFieldEvent_device_type(rs, columnNames, instance);
        mapFieldEvent_device_ability(rs, columnNames, instance);
        mapFieldEvent_action_id(rs, columnNames, instance);
        mapFieldEvent_path_id(rs, columnNames, instance);
        mapFieldEvent_message_type(rs, columnNames, instance);
        mapFieldEvent_guid(rs, columnNames, instance);
        mapFieldParam_test_v1(rs, columnNames, instance);
        mapFieldParam_test_v2(rs, columnNames, instance);
        mapFieldDevice_status(rs, columnNames, instance);
        mapFieldDevice_error_message(rs, columnNames, instance);
        mapFieldDevice_arix_x(rs, columnNames, instance);
        mapFieldDevice_arix_y(rs, columnNames, instance);
        mapFieldDevice_arix_z(rs, columnNames, instance);
        mapFieldDevice_goods_status(rs, columnNames, instance);
        mapFieldEvent_handler(rs, columnNames, instance);
        instance.setIndex(rowNum);
        return instance;
    }

    protected void mapFieldId(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelTEvent.FI_ID)) {
            instance.setId(rs.getInt(ModelTEvent.FI_ID));
        }
    }

    protected void mapFieldEvent_device(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelTEvent.FI_EVENT_DEVICE)) {
            instance.setEventDevice(rs.getInt(ModelTEvent.FI_EVENT_DEVICE));
        }
    }

    protected void mapFieldEvent_name(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelTEvent.FI_EVENT_NAME)) {
            instance.setEventName(rs.getString(ModelTEvent.FI_EVENT_NAME));
        }
    }

    protected void mapFieldEvent_time(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelTEvent.FI_EVENT_TIME)) {
            instance.setEventTime(rs.getTimestamp(ModelTEvent.FI_EVENT_TIME));
        }
    }

    protected void mapFieldEvent_type(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelTEvent.FI_EVENT_TYPE)) {
            instance.setEventType(EnumEventStatus.fromValue(rs.getByte(ModelTEvent.FI_EVENT_TYPE)));
        }
    }

    protected void mapFieldEvent_message(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelTEvent.FI_EVENT_MESSAGE)) {
            instance.setEventMessage(rs.getString(ModelTEvent.FI_EVENT_MESSAGE));
        }
    }

    protected void mapFieldEvent_task_id(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelTEvent.FI_EVENT_TASK_ID)) {
            instance.setEventTaskId(rs.getInt(ModelTEvent.FI_EVENT_TASK_ID));
        }
    }

    protected void mapFieldEvent_remark(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelTEvent.FI_EVENT_REMARK)) {
            instance.setEventRemark(rs.getString(ModelTEvent.FI_EVENT_REMARK));
        }
    }

    protected void mapFieldEvent_device_type(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelTEvent.FI_EVENT_DEVICE_TYPE)) {
            instance.setEventDeviceType(rs.getInt(ModelTEvent.FI_EVENT_DEVICE_TYPE));
        }
    }

    protected void mapFieldEvent_device_ability(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelTEvent.FI_EVENT_DEVICE_ABILITY)) {
            instance.setEventDeviceAbility(rs.getByte(ModelTEvent.FI_EVENT_DEVICE_ABILITY));
        }
    }

    protected void mapFieldEvent_action_id(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelTEvent.FI_EVENT_ACTION_ID)) {
            instance.setEventActionId(rs.getInt(ModelTEvent.FI_EVENT_ACTION_ID));
        }
    }

    protected void mapFieldEvent_path_id(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelTEvent.FI_EVENT_PATH_ID)) {
            instance.setEventPathId(rs.getInt(ModelTEvent.FI_EVENT_PATH_ID));
        }
    }

    protected void mapFieldEvent_message_type(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelTEvent.FI_EVENT_MESSAGE_TYPE)) {
            instance.setEventMessageType(EnumTaskStatus.fromValue(rs.getByte(ModelTEvent.FI_EVENT_MESSAGE_TYPE)));
        }
    }

    protected void mapFieldEvent_guid(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelTEvent.FI_EVENT_GUID)) {
            instance.setEventGuid(rs.getLong(ModelTEvent.FI_EVENT_GUID));
        }
    }

    protected void mapFieldParam_test_v1(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelTEvent.FI_PARAM_TEST_V1)) {
            instance.setParamTestV1(rs.getString(ModelTEvent.FI_PARAM_TEST_V1));
        }
    }

    protected void mapFieldParam_test_v2(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelTEvent.FI_PARAM_TEST_V2)) {
            instance.setParamTestV2(rs.getInt(ModelTEvent.FI_PARAM_TEST_V2));
        }
    }

    protected void mapFieldDevice_status(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelTEvent.FI_DEVICE_STATUS)) {
            instance.setDeviceStatus(EnumDeviceStatusType.fromValue(rs.getByte(ModelTEvent.FI_DEVICE_STATUS)));
        }
    }

    protected void mapFieldDevice_error_message(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelTEvent.FI_DEVICE_ERROR_MESSAGE)) {
            instance.setDeviceErrorMessage(rs.getString(ModelTEvent.FI_DEVICE_ERROR_MESSAGE));
        }
    }

    protected void mapFieldDevice_arix_x(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelTEvent.FI_DEVICE_ARIX_X)) {
            instance.setDeviceArixX(rs.getInt(ModelTEvent.FI_DEVICE_ARIX_X));
        }
    }

    protected void mapFieldDevice_arix_y(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelTEvent.FI_DEVICE_ARIX_Y)) {
            instance.setDeviceArixY(rs.getInt(ModelTEvent.FI_DEVICE_ARIX_Y));
        }
    }

    protected void mapFieldDevice_arix_z(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelTEvent.FI_DEVICE_ARIX_Z)) {
            instance.setDeviceArixZ(rs.getInt(ModelTEvent.FI_DEVICE_ARIX_Z));
        }
    }

    protected void mapFieldDevice_goods_status(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelTEvent.FI_DEVICE_GOODS_STATUS)) {
            instance.setDeviceGoodsStatus(rs.getInt(ModelTEvent.FI_DEVICE_GOODS_STATUS));
        }
    }

    protected void mapFieldEvent_handler(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelTEvent.FI_EVENT_HANDLER)) {
            instance.setEventHandler(EnumEventHandlerType.fromValue(rs.getByte(ModelTEvent.FI_EVENT_HANDLER)));
        }
    }
}
