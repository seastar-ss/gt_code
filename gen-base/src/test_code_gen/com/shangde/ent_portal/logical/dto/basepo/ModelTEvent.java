/**
 * don't modify , it is generate automatically, any modification will be lost after regeneration next time
 * 
 * @author shawn-ss's auto writer
 */
package com.shangde.ent_portal.logical.dto.basepo;

import java.util.Date;
import java.util.Map;
import java.util.Set;
import com.shangde.ent_portal.logical.dto.enums.EnumDeviceStatusType;
import com.shangde.ent_portal.logical.dto.enums.EnumEventHandlerType;
import com.shangde.ent_portal.logical.dto.enums.EnumEventStatus;
import com.shangde.ent_portal.logical.dto.enums.EnumTaskStatus;
import com.shawn.ss.lib.tools.CollectionHelper;
import com.shawn.ss.lib.tools.TypeConstantHelper;
import com.shawn.ss.lib.tools.db.api.interfaces.mappers.db.RedisMapMapper;
import com.shawn.ss.lib.tools.db.dto_base.model.AbstractBaseModel;
import com.shawn.ss.lib.tools.db.dto_base.model._APIObj;


/**
 * base DTO,represent for  :t_event
 */
public class ModelTEvent
    extends AbstractBaseModel
{
    Integer id;
    public final static String FI_ID = "id";
    Integer eventDevice;
    public final static String FI_EVENT_DEVICE = "event_device";
    /**
     * 事件类型
     */
    String eventName;
    public final static String FI_EVENT_NAME = "event_name";
    Date eventTime;
    public final static String FI_EVENT_TIME = "event_time";
    EnumEventStatus eventType;
    public final static String FI_EVENT_TYPE = "event_type";
    String eventMessage;
    public final static String FI_EVENT_MESSAGE = "event_message";
    Integer eventTaskId;
    public final static String FI_EVENT_TASK_ID = "event_task_id";
    String eventRemark;
    public final static String FI_EVENT_REMARK = "event_remark";
    Integer eventDeviceType;
    public final static String FI_EVENT_DEVICE_TYPE = "event_device_type";
    Byte eventDeviceAbility;
    public final static String FI_EVENT_DEVICE_ABILITY = "event_device_ability";
    Integer eventActionId;
    public final static String FI_EVENT_ACTION_ID = "event_action_id";
    Integer eventPathId;
    public final static String FI_EVENT_PATH_ID = "event_path_id";
    EnumTaskStatus eventMessageType;
    public final static String FI_EVENT_MESSAGE_TYPE = "event_message_type";
    Long eventGuid;
    public final static String FI_EVENT_GUID = "event_guid";
    String paramTestV1;
    public final static String FI_PARAM_TEST_V1 = "param_test_v1";
    Integer paramTestV2;
    public final static String FI_PARAM_TEST_V2 = "param_test_v2";
    EnumDeviceStatusType deviceStatus;
    public final static String FI_DEVICE_STATUS = "device_status";
    /**
     * 设备错误信息
     */
    String deviceErrorMessage;
    public final static String FI_DEVICE_ERROR_MESSAGE = "device_error_message";
    Integer deviceArixX;
    public final static String FI_DEVICE_ARIX_X = "device_arix_x";
    Integer deviceArixY;
    public final static String FI_DEVICE_ARIX_Y = "device_arix_y";
    Integer deviceArixZ;
    public final static String FI_DEVICE_ARIX_Z = "device_arix_z";
    /**
     * 设备是否载货
     */
    Integer deviceGoodsStatus;
    public final static String FI_DEVICE_GOODS_STATUS = "device_goods_status";
    EnumEventHandlerType eventHandler;
    public final static String FI_EVENT_HANDLER = "event_handler";
    public final static Map<String, Object> FIELD_CLASS = CollectionHelper.<String, Object> mapBuilder().put(ModelTEvent.FI_ID, Integer.class).put(ModelTEvent.FI_EVENT_DEVICE, Integer.class).put(ModelTEvent.FI_EVENT_NAME, String.class).put(ModelTEvent.FI_EVENT_TIME, Date.class).put(ModelTEvent.FI_EVENT_TYPE, EnumEventStatus.class).put(ModelTEvent.FI_EVENT_MESSAGE, String.class).put(ModelTEvent.FI_EVENT_TASK_ID, Integer.class).put(ModelTEvent.FI_EVENT_REMARK, String.class).put(ModelTEvent.FI_EVENT_DEVICE_TYPE, Integer.class).put(ModelTEvent.FI_EVENT_DEVICE_ABILITY, Byte.class).put(ModelTEvent.FI_EVENT_ACTION_ID, Integer.class).put(ModelTEvent.FI_EVENT_PATH_ID, Integer.class).put(ModelTEvent.FI_EVENT_MESSAGE_TYPE, EnumTaskStatus.class).put(ModelTEvent.FI_EVENT_GUID, Long.class).put(ModelTEvent.FI_PARAM_TEST_V1, String.class).put(ModelTEvent.FI_PARAM_TEST_V2, Integer.class).put(ModelTEvent.FI_DEVICE_STATUS, EnumDeviceStatusType.class).put(ModelTEvent.FI_DEVICE_ERROR_MESSAGE, String.class).put(ModelTEvent.FI_DEVICE_ARIX_X, Integer.class).put(ModelTEvent.FI_DEVICE_ARIX_Y, Integer.class).put(ModelTEvent.FI_DEVICE_ARIX_Z, Integer.class).put(ModelTEvent.FI_DEVICE_GOODS_STATUS, Integer.class).put(ModelTEvent.FI_EVENT_HANDLER, EnumEventHandlerType.class).getMap();
    public final static Integer FIELD_COUNT = 23;
    public final static String PRIMARY_KEY_NAME = "id";
    public final static String DTO_TABLE_NAME = "t_event";
    public final static String DTO_DB_NAME = "robot_control_system";

    public ModelTEvent() {
    }

    public Integer getId() {
        return id;
    }

    public ModelTEvent setId(Integer lId) {
        id = lId;
        return this;
    }

    public Integer getEventDevice() {
        return eventDevice;
    }

    public ModelTEvent setEventDevice(Integer lEventDevice) {
        eventDevice = lEventDevice;
        return this;
    }

    public String getEventName() {
        return eventName;
    }

    public ModelTEvent setEventName(String lEventName) {
        eventName = lEventName;
        return this;
    }

    public Date getEventTime() {
        return eventTime;
    }

    public ModelTEvent setEventTime(Date lEventTime) {
        eventTime = lEventTime;
        return this;
    }

    public EnumEventStatus getEventType() {
        return eventType;
    }

    public ModelTEvent setEventType(EnumEventStatus lEventType) {
        eventType = lEventType;
        return this;
    }

    public String getEventMessage() {
        return eventMessage;
    }

    public ModelTEvent setEventMessage(String lEventMessage) {
        eventMessage = lEventMessage;
        return this;
    }

    public Integer getEventTaskId() {
        return eventTaskId;
    }

    public ModelTEvent setEventTaskId(Integer lEventTaskId) {
        eventTaskId = lEventTaskId;
        return this;
    }

    public String getEventRemark() {
        return eventRemark;
    }

    public ModelTEvent setEventRemark(String lEventRemark) {
        eventRemark = lEventRemark;
        return this;
    }

    public Integer getEventDeviceType() {
        return eventDeviceType;
    }

    public ModelTEvent setEventDeviceType(Integer lEventDeviceType) {
        eventDeviceType = lEventDeviceType;
        return this;
    }

    public Byte getEventDeviceAbility() {
        return eventDeviceAbility;
    }

    public ModelTEvent setEventDeviceAbility(Byte lEventDeviceAbility) {
        eventDeviceAbility = lEventDeviceAbility;
        return this;
    }

    public Integer getEventActionId() {
        return eventActionId;
    }

    public ModelTEvent setEventActionId(Integer lEventActionId) {
        eventActionId = lEventActionId;
        return this;
    }

    public Integer getEventPathId() {
        return eventPathId;
    }

    public ModelTEvent setEventPathId(Integer lEventPathId) {
        eventPathId = lEventPathId;
        return this;
    }

    public EnumTaskStatus getEventMessageType() {
        return eventMessageType;
    }

    public ModelTEvent setEventMessageType(EnumTaskStatus lEventMessageType) {
        eventMessageType = lEventMessageType;
        return this;
    }

    public Long getEventGuid() {
        return eventGuid;
    }

    public ModelTEvent setEventGuid(Long lEventGuid) {
        eventGuid = lEventGuid;
        return this;
    }

    public String getParamTestV1() {
        return paramTestV1;
    }

    public ModelTEvent setParamTestV1(String lParamTestV1) {
        paramTestV1 = lParamTestV1;
        return this;
    }

    public Integer getParamTestV2() {
        return paramTestV2;
    }

    public ModelTEvent setParamTestV2(Integer lParamTestV2) {
        paramTestV2 = lParamTestV2;
        return this;
    }

    public EnumDeviceStatusType getDeviceStatus() {
        return deviceStatus;
    }

    public ModelTEvent setDeviceStatus(EnumDeviceStatusType lDeviceStatus) {
        deviceStatus = lDeviceStatus;
        return this;
    }

    public String getDeviceErrorMessage() {
        return deviceErrorMessage;
    }

    public ModelTEvent setDeviceErrorMessage(String lDeviceErrorMessage) {
        deviceErrorMessage = lDeviceErrorMessage;
        return this;
    }

    public Integer getDeviceArixX() {
        return deviceArixX;
    }

    public ModelTEvent setDeviceArixX(Integer lDeviceArixX) {
        deviceArixX = lDeviceArixX;
        return this;
    }

    public Integer getDeviceArixY() {
        return deviceArixY;
    }

    public ModelTEvent setDeviceArixY(Integer lDeviceArixY) {
        deviceArixY = lDeviceArixY;
        return this;
    }

    public Integer getDeviceArixZ() {
        return deviceArixZ;
    }

    public ModelTEvent setDeviceArixZ(Integer lDeviceArixZ) {
        deviceArixZ = lDeviceArixZ;
        return this;
    }

    public Integer getDeviceGoodsStatus() {
        return deviceGoodsStatus;
    }

    public ModelTEvent setDeviceGoodsStatus(Integer lDeviceGoodsStatus) {
        deviceGoodsStatus = lDeviceGoodsStatus;
        return this;
    }

    public EnumEventHandlerType getEventHandler() {
        return eventHandler;
    }

    public ModelTEvent setEventHandler(EnumEventHandlerType lEventHandler) {
        eventHandler = lEventHandler;
        return this;
    }

    @Override
    public Map<String, Object> getFieldConfig() {
        return FIELD_CLASS;
    }

    public boolean isEmpty() {
        if (!super.isEmpty()) {
            return false;
        }
        if (getId()!= null) {
            return false;
        }
        if (getEventDevice()!= null) {
            return false;
        }
        if (getEventName()!= null) {
            return false;
        }
        if (getEventTime()!= null) {
            return false;
        }
        if (getEventType()!= null) {
            return false;
        }
        if (getEventMessage()!= null) {
            return false;
        }
        if (getEventTaskId()!= null) {
            return false;
        }
        if (getEventRemark()!= null) {
            return false;
        }
        if (getEventDeviceType()!= null) {
            return false;
        }
        if (getEventDeviceAbility()!= null) {
            return false;
        }
        if (getEventActionId()!= null) {
            return false;
        }
        if (getEventPathId()!= null) {
            return false;
        }
        if (getEventMessageType()!= null) {
            return false;
        }
        if (getEventGuid()!= null) {
            return false;
        }
        if (getParamTestV1()!= null) {
            return false;
        }
        if (getParamTestV2()!= null) {
            return false;
        }
        if (getDeviceStatus()!= null) {
            return false;
        }
        if (getDeviceErrorMessage()!= null) {
            return false;
        }
        if (getDeviceArixX()!= null) {
            return false;
        }
        if (getDeviceArixY()!= null) {
            return false;
        }
        if (getDeviceArixZ()!= null) {
            return false;
        }
        if (getDeviceGoodsStatus()!= null) {
            return false;
        }
        if (getEventHandler()!= null) {
            return false;
        }
        return true;
    }

    public<FT extends _APIObj> FT getFeature(Class<FT> clazz) {
        return null;
    }

    public String toString() {
        StringBuilder ret = new StringBuilder();
        ret.append("{").append("id").append(":").append(id).append("}\n");
        ret.append("{").append("eventDevice").append(":").append(eventDevice).append("}\n");
        ret.append("{").append("eventName").append(":").append(eventName).append("}\n");
        ret.append("{").append("eventTime").append(":").append(eventTime).append("}\n");
        ret.append("{").append("eventType").append(":").append(eventType).append("}\n");
        ret.append("{").append("eventMessage").append(":").append(eventMessage).append("}\n");
        ret.append("{").append("eventTaskId").append(":").append(eventTaskId).append("}\n");
        ret.append("{").append("eventRemark").append(":").append(eventRemark).append("}\n");
        ret.append("{").append("eventDeviceType").append(":").append(eventDeviceType).append("}\n");
        ret.append("{").append("eventDeviceAbility").append(":").append(eventDeviceAbility).append("}\n");
        ret.append("{").append("eventActionId").append(":").append(eventActionId).append("}\n");
        ret.append("{").append("eventPathId").append(":").append(eventPathId).append("}\n");
        ret.append("{").append("eventMessageType").append(":").append(eventMessageType).append("}\n");
        ret.append("{").append("eventGuid").append(":").append(eventGuid).append("}\n");
        ret.append("{").append("paramTestV1").append(":").append(paramTestV1).append("}\n");
        ret.append("{").append("paramTestV2").append(":").append(paramTestV2).append("}\n");
        ret.append("{").append("deviceStatus").append(":").append(deviceStatus).append("}\n");
        ret.append("{").append("deviceErrorMessage").append(":").append(deviceErrorMessage).append("}\n");
        ret.append("{").append("deviceArixX").append(":").append(deviceArixX).append("}\n");
        ret.append("{").append("deviceArixY").append(":").append(deviceArixY).append("}\n");
        ret.append("{").append("deviceArixZ").append(":").append(deviceArixZ).append("}\n");
        ret.append("{").append("deviceGoodsStatus").append(":").append(deviceGoodsStatus).append("}\n");
        ret.append("{").append("eventHandler").append(":").append(eventHandler).append("}\n");
        return ret.toString();
    }

    public static class PojoMapperModelTEvent
        implements RedisMapMapper<ModelTEvent>
    {

        @Override
        public ModelTEvent fromMap(Map<byte[], byte[]> map) {
            ModelTEvent instance = new ModelTEvent();
            Set<Map.Entry<byte[], byte[]>> entries = map.entrySet();
            for (Map.Entry<byte[], byte[]> entry: entries) {
                String field = new String(entry.getKey());
                if (field.equals(ModelTEvent.FI_ID)) {
                    instance.setId(mapToFieldId(entry.getValue()));
                } else {
                    if (field.equals(ModelTEvent.FI_EVENT_DEVICE)) {
                        instance.setEventDevice(mapToFieldEventDevice(entry.getValue()));
                    } else {
                        if (field.equals(ModelTEvent.FI_EVENT_NAME)) {
                            instance.setEventName(mapToFieldEventName(entry.getValue()));
                        } else {
                            if (field.equals(ModelTEvent.FI_EVENT_TIME)) {
                                instance.setEventTime(mapToFieldEventTime(entry.getValue()));
                            } else {
                                if (field.equals(ModelTEvent.FI_EVENT_TYPE)) {
                                    instance.setEventType(mapToFieldEventType(entry.getValue()));
                                } else {
                                    if (field.equals(ModelTEvent.FI_EVENT_MESSAGE)) {
                                        instance.setEventMessage(mapToFieldEventMessage(entry.getValue()));
                                    } else {
                                        if (field.equals(ModelTEvent.FI_EVENT_TASK_ID)) {
                                            instance.setEventTaskId(mapToFieldEventTaskId(entry.getValue()));
                                        } else {
                                            if (field.equals(ModelTEvent.FI_EVENT_REMARK)) {
                                                instance.setEventRemark(mapToFieldEventRemark(entry.getValue()));
                                            } else {
                                                if (field.equals(ModelTEvent.FI_EVENT_DEVICE_TYPE)) {
                                                    instance.setEventDeviceType(mapToFieldEventDeviceType(entry.getValue()));
                                                } else {
                                                    if (field.equals(ModelTEvent.FI_EVENT_DEVICE_ABILITY)) {
                                                        instance.setEventDeviceAbility(mapToFieldEventDeviceAbility(entry.getValue()));
                                                    } else {
                                                        if (field.equals(ModelTEvent.FI_EVENT_ACTION_ID)) {
                                                            instance.setEventActionId(mapToFieldEventActionId(entry.getValue()));
                                                        } else {
                                                            if (field.equals(ModelTEvent.FI_EVENT_PATH_ID)) {
                                                                instance.setEventPathId(mapToFieldEventPathId(entry.getValue()));
                                                            } else {
                                                                if (field.equals(ModelTEvent.FI_EVENT_MESSAGE_TYPE)) {
                                                                    instance.setEventMessageType(mapToFieldEventMessageType(entry.getValue()));
                                                                } else {
                                                                    if (field.equals(ModelTEvent.FI_EVENT_GUID)) {
                                                                        instance.setEventGuid(mapToFieldEventGuid(entry.getValue()));
                                                                    } else {
                                                                        if (field.equals(ModelTEvent.FI_PARAM_TEST_V1)) {
                                                                            instance.setParamTestV1(mapToFieldParamTestV1(entry.getValue()));
                                                                        } else {
                                                                            if (field.equals(ModelTEvent.FI_PARAM_TEST_V2)) {
                                                                                instance.setParamTestV2(mapToFieldParamTestV2(entry.getValue()));
                                                                            } else {
                                                                                if (field.equals(ModelTEvent.FI_DEVICE_STATUS)) {
                                                                                    instance.setDeviceStatus(mapToFieldDeviceStatus(entry.getValue()));
                                                                                } else {
                                                                                    if (field.equals(ModelTEvent.FI_DEVICE_ERROR_MESSAGE)) {
                                                                                        instance.setDeviceErrorMessage(mapToFieldDeviceErrorMessage(entry.getValue()));
                                                                                    } else {
                                                                                        if (field.equals(ModelTEvent.FI_DEVICE_ARIX_X)) {
                                                                                            instance.setDeviceArixX(mapToFieldDeviceArixX(entry.getValue()));
                                                                                        } else {
                                                                                            if (field.equals(ModelTEvent.FI_DEVICE_ARIX_Y)) {
                                                                                                instance.setDeviceArixY(mapToFieldDeviceArixY(entry.getValue()));
                                                                                            } else {
                                                                                                if (field.equals(ModelTEvent.FI_DEVICE_ARIX_Z)) {
                                                                                                    instance.setDeviceArixZ(mapToFieldDeviceArixZ(entry.getValue()));
                                                                                                } else {
                                                                                                    if (field.equals(ModelTEvent.FI_DEVICE_GOODS_STATUS)) {
                                                                                                        instance.setDeviceGoodsStatus(mapToFieldDeviceGoodsStatus(entry.getValue()));
                                                                                                    } else {
                                                                                                        if (field.equals(ModelTEvent.FI_EVENT_HANDLER)) {
                                                                                                            instance.setEventHandler(mapToFieldEventHandler(entry.getValue()));
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return instance;
        }

        protected Integer mapToFieldId(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Integer.class);
        }

        protected Integer mapToFieldEventDevice(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Integer.class);
        }

        protected String mapToFieldEventName(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected Date mapToFieldEventTime(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Date.class);
        }

        protected EnumEventStatus mapToFieldEventType(byte[] bytes) {
            return EnumEventStatus.fromValue(TypeConstantHelper.toObject(bytes, Byte.class));
        }

        protected String mapToFieldEventMessage(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected Integer mapToFieldEventTaskId(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Integer.class);
        }

        protected String mapToFieldEventRemark(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected Integer mapToFieldEventDeviceType(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Integer.class);
        }

        protected Byte mapToFieldEventDeviceAbility(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Byte.class);
        }

        protected Integer mapToFieldEventActionId(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Integer.class);
        }

        protected Integer mapToFieldEventPathId(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Integer.class);
        }

        protected EnumTaskStatus mapToFieldEventMessageType(byte[] bytes) {
            return EnumTaskStatus.fromValue(TypeConstantHelper.toObject(bytes, Byte.class));
        }

        protected Long mapToFieldEventGuid(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Long.class);
        }

        protected String mapToFieldParamTestV1(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected Integer mapToFieldParamTestV2(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Integer.class);
        }

        protected EnumDeviceStatusType mapToFieldDeviceStatus(byte[] bytes) {
            return EnumDeviceStatusType.fromValue(TypeConstantHelper.toObject(bytes, Byte.class));
        }

        protected String mapToFieldDeviceErrorMessage(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected Integer mapToFieldDeviceArixX(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Integer.class);
        }

        protected Integer mapToFieldDeviceArixY(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Integer.class);
        }

        protected Integer mapToFieldDeviceArixZ(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Integer.class);
        }

        protected Integer mapToFieldDeviceGoodsStatus(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Integer.class);
        }

        protected EnumEventHandlerType mapToFieldEventHandler(byte[] bytes) {
            return EnumEventHandlerType.fromValue(TypeConstantHelper.toObject(bytes, Byte.class));
        }

        @Override
        public Map<byte[], byte[]> toMap(ModelTEvent instance) {
            Map<byte[], byte[]> ret = CollectionHelper.newMap();
            if (instance == null) {
                return ret;
            }
            byte[] valueId = mapFromFieldId(instance.getId());
            ret.put(ModelTEvent.FI_ID.getBytes(), valueId);
            byte[] valueEvent_device = mapFromFieldEventDevice(instance.getEventDevice());
            ret.put(ModelTEvent.FI_EVENT_DEVICE.getBytes(), valueEvent_device);
            byte[] valueEvent_name = mapFromFieldEventName(instance.getEventName());
            ret.put(ModelTEvent.FI_EVENT_NAME.getBytes(), valueEvent_name);
            byte[] valueEvent_time = mapFromFieldEventTime(instance.getEventTime());
            ret.put(ModelTEvent.FI_EVENT_TIME.getBytes(), valueEvent_time);
            byte[] valueEvent_type = mapFromFieldEventType(instance.getEventType());
            ret.put(ModelTEvent.FI_EVENT_TYPE.getBytes(), valueEvent_type);
            byte[] valueEvent_message = mapFromFieldEventMessage(instance.getEventMessage());
            ret.put(ModelTEvent.FI_EVENT_MESSAGE.getBytes(), valueEvent_message);
            byte[] valueEvent_task_id = mapFromFieldEventTaskId(instance.getEventTaskId());
            ret.put(ModelTEvent.FI_EVENT_TASK_ID.getBytes(), valueEvent_task_id);
            byte[] valueEvent_remark = mapFromFieldEventRemark(instance.getEventRemark());
            ret.put(ModelTEvent.FI_EVENT_REMARK.getBytes(), valueEvent_remark);
            byte[] valueEvent_device_type = mapFromFieldEventDeviceType(instance.getEventDeviceType());
            ret.put(ModelTEvent.FI_EVENT_DEVICE_TYPE.getBytes(), valueEvent_device_type);
            byte[] valueEvent_device_ability = mapFromFieldEventDeviceAbility(instance.getEventDeviceAbility());
            ret.put(ModelTEvent.FI_EVENT_DEVICE_ABILITY.getBytes(), valueEvent_device_ability);
            byte[] valueEvent_action_id = mapFromFieldEventActionId(instance.getEventActionId());
            ret.put(ModelTEvent.FI_EVENT_ACTION_ID.getBytes(), valueEvent_action_id);
            byte[] valueEvent_path_id = mapFromFieldEventPathId(instance.getEventPathId());
            ret.put(ModelTEvent.FI_EVENT_PATH_ID.getBytes(), valueEvent_path_id);
            byte[] valueEvent_message_type = mapFromFieldEventMessageType(instance.getEventMessageType());
            ret.put(ModelTEvent.FI_EVENT_MESSAGE_TYPE.getBytes(), valueEvent_message_type);
            byte[] valueEvent_guid = mapFromFieldEventGuid(instance.getEventGuid());
            ret.put(ModelTEvent.FI_EVENT_GUID.getBytes(), valueEvent_guid);
            byte[] valueParam_test_v1 = mapFromFieldParamTestV1(instance.getParamTestV1());
            ret.put(ModelTEvent.FI_PARAM_TEST_V1 .getBytes(), valueParam_test_v1);
            byte[] valueParam_test_v2 = mapFromFieldParamTestV2(instance.getParamTestV2());
            ret.put(ModelTEvent.FI_PARAM_TEST_V2 .getBytes(), valueParam_test_v2);
            byte[] valueDevice_status = mapFromFieldDeviceStatus(instance.getDeviceStatus());
            ret.put(ModelTEvent.FI_DEVICE_STATUS.getBytes(), valueDevice_status);
            byte[] valueDevice_error_message = mapFromFieldDeviceErrorMessage(instance.getDeviceErrorMessage());
            ret.put(ModelTEvent.FI_DEVICE_ERROR_MESSAGE.getBytes(), valueDevice_error_message);
            byte[] valueDevice_arix_x = mapFromFieldDeviceArixX(instance.getDeviceArixX());
            ret.put(ModelTEvent.FI_DEVICE_ARIX_X.getBytes(), valueDevice_arix_x);
            byte[] valueDevice_arix_y = mapFromFieldDeviceArixY(instance.getDeviceArixY());
            ret.put(ModelTEvent.FI_DEVICE_ARIX_Y.getBytes(), valueDevice_arix_y);
            byte[] valueDevice_arix_z = mapFromFieldDeviceArixZ(instance.getDeviceArixZ());
            ret.put(ModelTEvent.FI_DEVICE_ARIX_Z.getBytes(), valueDevice_arix_z);
            byte[] valueDevice_goods_status = mapFromFieldDeviceGoodsStatus(instance.getDeviceGoodsStatus());
            ret.put(ModelTEvent.FI_DEVICE_GOODS_STATUS.getBytes(), valueDevice_goods_status);
            byte[] valueEvent_handler = mapFromFieldEventHandler(instance.getEventHandler());
            ret.put(ModelTEvent.FI_EVENT_HANDLER.getBytes(), valueEvent_handler);
            return ret;
        }

        protected byte[] mapFromFieldId(Integer field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldEventDevice(Integer field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldEventName(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldEventTime(Date field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldEventType(EnumEventStatus field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field.val);
            return ret;
        }

        protected byte[] mapFromFieldEventMessage(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldEventTaskId(Integer field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldEventRemark(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldEventDeviceType(Integer field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldEventDeviceAbility(Byte field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldEventActionId(Integer field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldEventPathId(Integer field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldEventMessageType(EnumTaskStatus field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field.val);
            return ret;
        }

        protected byte[] mapFromFieldEventGuid(Long field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldParamTestV1(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldParamTestV2(Integer field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldDeviceStatus(EnumDeviceStatusType field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field.val);
            return ret;
        }

        protected byte[] mapFromFieldDeviceErrorMessage(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldDeviceArixX(Integer field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldDeviceArixY(Integer field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldDeviceArixZ(Integer field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldDeviceGoodsStatus(Integer field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldEventHandler(EnumEventHandlerType field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field.val);
            return ret;
        }

        @Override
        public Map<String, Object> toCommonMap(ModelTEvent instance) {
            Map<String, Object> ret = CollectionHelper.newMap();
            if (instance == null) {
                return ret;
            }
            Integer dId = instance.getId();
            if (dId!= null) {
                ret.put(ModelTEvent.FI_ID, dId);
            }
            Integer dEvent_device = instance.getEventDevice();
            if (dEvent_device!= null) {
                ret.put(ModelTEvent.FI_EVENT_DEVICE, dEvent_device);
            }
            String dEvent_name = instance.getEventName();
            if (dEvent_name!= null) {
                ret.put(ModelTEvent.FI_EVENT_NAME, dEvent_name);
            }
            Date dEvent_time = instance.getEventTime();
            if (dEvent_time!= null) {
                ret.put(ModelTEvent.FI_EVENT_TIME, dEvent_time);
            }
            EnumEventStatus dEvent_type = instance.getEventType();
            if (dEvent_type!= null) {
                ret.put(ModelTEvent.FI_EVENT_TYPE, dEvent_type.val);
            }
            String dEvent_message = instance.getEventMessage();
            if (dEvent_message!= null) {
                ret.put(ModelTEvent.FI_EVENT_MESSAGE, dEvent_message);
            }
            Integer dEvent_task_id = instance.getEventTaskId();
            if (dEvent_task_id!= null) {
                ret.put(ModelTEvent.FI_EVENT_TASK_ID, dEvent_task_id);
            }
            String dEvent_remark = instance.getEventRemark();
            if (dEvent_remark!= null) {
                ret.put(ModelTEvent.FI_EVENT_REMARK, dEvent_remark);
            }
            Integer dEvent_device_type = instance.getEventDeviceType();
            if (dEvent_device_type!= null) {
                ret.put(ModelTEvent.FI_EVENT_DEVICE_TYPE, dEvent_device_type);
            }
            Byte dEvent_device_ability = instance.getEventDeviceAbility();
            if (dEvent_device_ability!= null) {
                ret.put(ModelTEvent.FI_EVENT_DEVICE_ABILITY, dEvent_device_ability);
            }
            Integer dEvent_action_id = instance.getEventActionId();
            if (dEvent_action_id!= null) {
                ret.put(ModelTEvent.FI_EVENT_ACTION_ID, dEvent_action_id);
            }
            Integer dEvent_path_id = instance.getEventPathId();
            if (dEvent_path_id!= null) {
                ret.put(ModelTEvent.FI_EVENT_PATH_ID, dEvent_path_id);
            }
            EnumTaskStatus dEvent_message_type = instance.getEventMessageType();
            if (dEvent_message_type!= null) {
                ret.put(ModelTEvent.FI_EVENT_MESSAGE_TYPE, dEvent_message_type.val);
            }
            Long dEvent_guid = instance.getEventGuid();
            if (dEvent_guid!= null) {
                ret.put(ModelTEvent.FI_EVENT_GUID, dEvent_guid);
            }
            String dParam_test_v1 = instance.getParamTestV1();
            if (dParam_test_v1 != null) {
                ret.put(ModelTEvent.FI_PARAM_TEST_V1, dParam_test_v1);
            }
            Integer dParam_test_v2 = instance.getParamTestV2();
            if (dParam_test_v2 != null) {
                ret.put(ModelTEvent.FI_PARAM_TEST_V2, dParam_test_v2);
            }
            EnumDeviceStatusType dDevice_status = instance.getDeviceStatus();
            if (dDevice_status!= null) {
                ret.put(ModelTEvent.FI_DEVICE_STATUS, dDevice_status.val);
            }
            String dDevice_error_message = instance.getDeviceErrorMessage();
            if (dDevice_error_message!= null) {
                ret.put(ModelTEvent.FI_DEVICE_ERROR_MESSAGE, dDevice_error_message);
            }
            Integer dDevice_arix_x = instance.getDeviceArixX();
            if (dDevice_arix_x!= null) {
                ret.put(ModelTEvent.FI_DEVICE_ARIX_X, dDevice_arix_x);
            }
            Integer dDevice_arix_y = instance.getDeviceArixY();
            if (dDevice_arix_y!= null) {
                ret.put(ModelTEvent.FI_DEVICE_ARIX_Y, dDevice_arix_y);
            }
            Integer dDevice_arix_z = instance.getDeviceArixZ();
            if (dDevice_arix_z!= null) {
                ret.put(ModelTEvent.FI_DEVICE_ARIX_Z, dDevice_arix_z);
            }
            Integer dDevice_goods_status = instance.getDeviceGoodsStatus();
            if (dDevice_goods_status!= null) {
                ret.put(ModelTEvent.FI_DEVICE_GOODS_STATUS, dDevice_goods_status);
            }
            EnumEventHandlerType dEvent_handler = instance.getEventHandler();
            if (dEvent_handler!= null) {
                ret.put(ModelTEvent.FI_EVENT_HANDLER, dEvent_handler.val);
            }
            return ret;
        }

        @Override
        public ModelTEvent fromCommonMap(Map<String, Object> param) {
            ModelTEvent ret = new ModelTEvent();
            if (param == null) {
                return ret;
            }
            Object dId = param.get(ModelTEvent.FI_ID);
            if (dId!= null) {
                this.setField(ModelTEvent.FI_ID, ret, dId);
            }
            Object dEvent_device = param.get(ModelTEvent.FI_EVENT_DEVICE);
            if (dEvent_device!= null) {
                this.setField(ModelTEvent.FI_EVENT_DEVICE, ret, dEvent_device);
            }
            Object dEvent_name = param.get(ModelTEvent.FI_EVENT_NAME);
            if (dEvent_name!= null) {
                this.setField(ModelTEvent.FI_EVENT_NAME, ret, dEvent_name);
            }
            Object dEvent_time = param.get(ModelTEvent.FI_EVENT_TIME);
            if (dEvent_time!= null) {
                this.setField(ModelTEvent.FI_EVENT_TIME, ret, dEvent_time);
            }
            Object dEvent_type = param.get(ModelTEvent.FI_EVENT_TYPE);
            if (dEvent_type!= null) {
                this.setField(ModelTEvent.FI_EVENT_TYPE, ret, dEvent_type);
            }
            Object dEvent_message = param.get(ModelTEvent.FI_EVENT_MESSAGE);
            if (dEvent_message!= null) {
                this.setField(ModelTEvent.FI_EVENT_MESSAGE, ret, dEvent_message);
            }
            Object dEvent_task_id = param.get(ModelTEvent.FI_EVENT_TASK_ID);
            if (dEvent_task_id!= null) {
                this.setField(ModelTEvent.FI_EVENT_TASK_ID, ret, dEvent_task_id);
            }
            Object dEvent_remark = param.get(ModelTEvent.FI_EVENT_REMARK);
            if (dEvent_remark!= null) {
                this.setField(ModelTEvent.FI_EVENT_REMARK, ret, dEvent_remark);
            }
            Object dEvent_device_type = param.get(ModelTEvent.FI_EVENT_DEVICE_TYPE);
            if (dEvent_device_type!= null) {
                this.setField(ModelTEvent.FI_EVENT_DEVICE_TYPE, ret, dEvent_device_type);
            }
            Object dEvent_device_ability = param.get(ModelTEvent.FI_EVENT_DEVICE_ABILITY);
            if (dEvent_device_ability!= null) {
                this.setField(ModelTEvent.FI_EVENT_DEVICE_ABILITY, ret, dEvent_device_ability);
            }
            Object dEvent_action_id = param.get(ModelTEvent.FI_EVENT_ACTION_ID);
            if (dEvent_action_id!= null) {
                this.setField(ModelTEvent.FI_EVENT_ACTION_ID, ret, dEvent_action_id);
            }
            Object dEvent_path_id = param.get(ModelTEvent.FI_EVENT_PATH_ID);
            if (dEvent_path_id!= null) {
                this.setField(ModelTEvent.FI_EVENT_PATH_ID, ret, dEvent_path_id);
            }
            Object dEvent_message_type = param.get(ModelTEvent.FI_EVENT_MESSAGE_TYPE);
            if (dEvent_message_type!= null) {
                this.setField(ModelTEvent.FI_EVENT_MESSAGE_TYPE, ret, dEvent_message_type);
            }
            Object dEvent_guid = param.get(ModelTEvent.FI_EVENT_GUID);
            if (dEvent_guid!= null) {
                this.setField(ModelTEvent.FI_EVENT_GUID, ret, dEvent_guid);
            }
            Object dParam_test_v1 = param.get(ModelTEvent.FI_PARAM_TEST_V1);
            if (dParam_test_v1 != null) {
                this.setField(ModelTEvent.FI_PARAM_TEST_V1, ret, dParam_test_v1);
            }
            Object dParam_test_v2 = param.get(ModelTEvent.FI_PARAM_TEST_V2);
            if (dParam_test_v2 != null) {
                this.setField(ModelTEvent.FI_PARAM_TEST_V2, ret, dParam_test_v2);
            }
            Object dDevice_status = param.get(ModelTEvent.FI_DEVICE_STATUS);
            if (dDevice_status!= null) {
                this.setField(ModelTEvent.FI_DEVICE_STATUS, ret, dDevice_status);
            }
            Object dDevice_error_message = param.get(ModelTEvent.FI_DEVICE_ERROR_MESSAGE);
            if (dDevice_error_message!= null) {
                this.setField(ModelTEvent.FI_DEVICE_ERROR_MESSAGE, ret, dDevice_error_message);
            }
            Object dDevice_arix_x = param.get(ModelTEvent.FI_DEVICE_ARIX_X);
            if (dDevice_arix_x!= null) {
                this.setField(ModelTEvent.FI_DEVICE_ARIX_X, ret, dDevice_arix_x);
            }
            Object dDevice_arix_y = param.get(ModelTEvent.FI_DEVICE_ARIX_Y);
            if (dDevice_arix_y!= null) {
                this.setField(ModelTEvent.FI_DEVICE_ARIX_Y, ret, dDevice_arix_y);
            }
            Object dDevice_arix_z = param.get(ModelTEvent.FI_DEVICE_ARIX_Z);
            if (dDevice_arix_z!= null) {
                this.setField(ModelTEvent.FI_DEVICE_ARIX_Z, ret, dDevice_arix_z);
            }
            Object dDevice_goods_status = param.get(ModelTEvent.FI_DEVICE_GOODS_STATUS);
            if (dDevice_goods_status!= null) {
                this.setField(ModelTEvent.FI_DEVICE_GOODS_STATUS, ret, dDevice_goods_status);
            }
            Object dEvent_handler = param.get(ModelTEvent.FI_EVENT_HANDLER);
            if (dEvent_handler!= null) {
                this.setField(ModelTEvent.FI_EVENT_HANDLER, ret, dEvent_handler);
            }
            return ret;
        }

        protected Integer mapToFieldId(Object obj) {
            return ((Integer) obj);
        }

        protected Integer mapToFieldEventDevice(Object obj) {
            return ((Integer) obj);
        }

        protected String mapToFieldEventName(Object obj) {
            return ((String) obj);
        }

        protected Date mapToFieldEventTime(Object obj) {
            return ((Date) obj);
        }

        protected EnumEventStatus mapToFieldEventType(Object obj) {
            return EnumEventStatus.fromValue(((Byte) obj));
        }

        protected String mapToFieldEventMessage(Object obj) {
            return ((String) obj);
        }

        protected Integer mapToFieldEventTaskId(Object obj) {
            return ((Integer) obj);
        }

        protected String mapToFieldEventRemark(Object obj) {
            return ((String) obj);
        }

        protected Integer mapToFieldEventDeviceType(Object obj) {
            return ((Integer) obj);
        }

        protected Byte mapToFieldEventDeviceAbility(Object obj) {
            return ((Byte) obj);
        }

        protected Integer mapToFieldEventActionId(Object obj) {
            return ((Integer) obj);
        }

        protected Integer mapToFieldEventPathId(Object obj) {
            return ((Integer) obj);
        }

        protected EnumTaskStatus mapToFieldEventMessageType(Object obj) {
            return EnumTaskStatus.fromValue(((Byte) obj));
        }

        protected Long mapToFieldEventGuid(Object obj) {
            return ((Long) obj);
        }

        protected String mapToFieldParamTestV1(Object obj) {
            return ((String) obj);
        }

        protected Integer mapToFieldParamTestV2(Object obj) {
            return ((Integer) obj);
        }

        protected EnumDeviceStatusType mapToFieldDeviceStatus(Object obj) {
            return EnumDeviceStatusType.fromValue(((Byte) obj));
        }

        protected String mapToFieldDeviceErrorMessage(Object obj) {
            return ((String) obj);
        }

        protected Integer mapToFieldDeviceArixX(Object obj) {
            return ((Integer) obj);
        }

        protected Integer mapToFieldDeviceArixY(Object obj) {
            return ((Integer) obj);
        }

        protected Integer mapToFieldDeviceArixZ(Object obj) {
            return ((Integer) obj);
        }

        protected Integer mapToFieldDeviceGoodsStatus(Object obj) {
            return ((Integer) obj);
        }

        protected EnumEventHandlerType mapToFieldEventHandler(Object obj) {
            return EnumEventHandlerType.fromValue(((Byte) obj));
        }

        public<TT> TT getField(String field, ModelTEvent instance) {
            try {
                if (field.equals(ModelTEvent.FI_ID)) {
                    return ((TT) instance.getId());
                } else {
                    if (field.equals(ModelTEvent.FI_EVENT_DEVICE)) {
                        return ((TT) instance.getEventDevice());
                    } else {
                        if (field.equals(ModelTEvent.FI_EVENT_NAME)) {
                            return ((TT) instance.getEventName());
                        } else {
                            if (field.equals(ModelTEvent.FI_EVENT_TIME)) {
                                return ((TT) instance.getEventTime());
                            } else {
                                if (field.equals(ModelTEvent.FI_EVENT_TYPE)) {
                                    return ((TT) instance.getEventType());
                                } else {
                                    if (field.equals(ModelTEvent.FI_EVENT_MESSAGE)) {
                                        return ((TT) instance.getEventMessage());
                                    } else {
                                        if (field.equals(ModelTEvent.FI_EVENT_TASK_ID)) {
                                            return ((TT) instance.getEventTaskId());
                                        } else {
                                            if (field.equals(ModelTEvent.FI_EVENT_REMARK)) {
                                                return ((TT) instance.getEventRemark());
                                            } else {
                                                if (field.equals(ModelTEvent.FI_EVENT_DEVICE_TYPE)) {
                                                    return ((TT) instance.getEventDeviceType());
                                                } else {
                                                    if (field.equals(ModelTEvent.FI_EVENT_DEVICE_ABILITY)) {
                                                        return ((TT) instance.getEventDeviceAbility());
                                                    } else {
                                                        if (field.equals(ModelTEvent.FI_EVENT_ACTION_ID)) {
                                                            return ((TT) instance.getEventActionId());
                                                        } else {
                                                            if (field.equals(ModelTEvent.FI_EVENT_PATH_ID)) {
                                                                return ((TT) instance.getEventPathId());
                                                            } else {
                                                                if (field.equals(ModelTEvent.FI_EVENT_MESSAGE_TYPE)) {
                                                                    return ((TT) instance.getEventMessageType());
                                                                } else {
                                                                    if (field.equals(ModelTEvent.FI_EVENT_GUID)) {
                                                                        return ((TT) instance.getEventGuid());
                                                                    } else {
                                                                        if (field.equals(ModelTEvent.FI_PARAM_TEST_V1)) {
                                                                            return ((TT) instance.getParamTestV1());
                                                                        } else {
                                                                            if (field.equals(ModelTEvent.FI_PARAM_TEST_V2)) {
                                                                                return ((TT) instance.getParamTestV2());
                                                                            } else {
                                                                                if (field.equals(ModelTEvent.FI_DEVICE_STATUS)) {
                                                                                    return ((TT) instance.getDeviceStatus());
                                                                                } else {
                                                                                    if (field.equals(ModelTEvent.FI_DEVICE_ERROR_MESSAGE)) {
                                                                                        return ((TT) instance.getDeviceErrorMessage());
                                                                                    } else {
                                                                                        if (field.equals(ModelTEvent.FI_DEVICE_ARIX_X)) {
                                                                                            return ((TT) instance.getDeviceArixX());
                                                                                        } else {
                                                                                            if (field.equals(ModelTEvent.FI_DEVICE_ARIX_Y)) {
                                                                                                return ((TT) instance.getDeviceArixY());
                                                                                            } else {
                                                                                                if (field.equals(ModelTEvent.FI_DEVICE_ARIX_Z)) {
                                                                                                    return ((TT) instance.getDeviceArixZ());
                                                                                                } else {
                                                                                                    if (field.equals(ModelTEvent.FI_DEVICE_GOODS_STATUS)) {
                                                                                                        return ((TT) instance.getDeviceGoodsStatus());
                                                                                                    } else {
                                                                                                        if (field.equals(ModelTEvent.FI_EVENT_HANDLER)) {
                                                                                                            return ((TT) instance.getEventHandler());
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            } catch (final Exception ex) {
                ex.printStackTrace();
            }
            return null;
        }

        public<TT> void setField(String field, ModelTEvent instance, TT value) {
            if (field.equals(ModelTEvent.FI_ID)) {
                try {
                    instance.setId(mapToFieldId(value));
                } catch (final Exception ex) {
                    ex.printStackTrace();
                }
            } else {
                if (field.equals(ModelTEvent.FI_EVENT_DEVICE)) {
                    try {
                        instance.setEventDevice(mapToFieldEventDevice(value));
                    } catch (final Exception ex) {
                        ex.printStackTrace();
                    }
                } else {
                    if (field.equals(ModelTEvent.FI_EVENT_NAME)) {
                        try {
                            instance.setEventName(mapToFieldEventName(value));
                        } catch (final Exception ex) {
                            ex.printStackTrace();
                        }
                    } else {
                        if (field.equals(ModelTEvent.FI_EVENT_TIME)) {
                            try {
                                instance.setEventTime(mapToFieldEventTime(value));
                            } catch (final Exception ex) {
                                ex.printStackTrace();
                            }
                        } else {
                            if (field.equals(ModelTEvent.FI_EVENT_TYPE)) {
                                try {
                                    instance.setEventType(mapToFieldEventType(value));
                                } catch (final Exception ex) {
                                    ex.printStackTrace();
                                }
                            } else {
                                if (field.equals(ModelTEvent.FI_EVENT_MESSAGE)) {
                                    try {
                                        instance.setEventMessage(mapToFieldEventMessage(value));
                                    } catch (final Exception ex) {
                                        ex.printStackTrace();
                                    }
                                } else {
                                    if (field.equals(ModelTEvent.FI_EVENT_TASK_ID)) {
                                        try {
                                            instance.setEventTaskId(mapToFieldEventTaskId(value));
                                        } catch (final Exception ex) {
                                            ex.printStackTrace();
                                        }
                                    } else {
                                        if (field.equals(ModelTEvent.FI_EVENT_REMARK)) {
                                            try {
                                                instance.setEventRemark(mapToFieldEventRemark(value));
                                            } catch (final Exception ex) {
                                                ex.printStackTrace();
                                            }
                                        } else {
                                            if (field.equals(ModelTEvent.FI_EVENT_DEVICE_TYPE)) {
                                                try {
                                                    instance.setEventDeviceType(mapToFieldEventDeviceType(value));
                                                } catch (final Exception ex) {
                                                    ex.printStackTrace();
                                                }
                                            } else {
                                                if (field.equals(ModelTEvent.FI_EVENT_DEVICE_ABILITY)) {
                                                    try {
                                                        instance.setEventDeviceAbility(mapToFieldEventDeviceAbility(value));
                                                    } catch (final Exception ex) {
                                                        ex.printStackTrace();
                                                    }
                                                } else {
                                                    if (field.equals(ModelTEvent.FI_EVENT_ACTION_ID)) {
                                                        try {
                                                            instance.setEventActionId(mapToFieldEventActionId(value));
                                                        } catch (final Exception ex) {
                                                            ex.printStackTrace();
                                                        }
                                                    } else {
                                                        if (field.equals(ModelTEvent.FI_EVENT_PATH_ID)) {
                                                            try {
                                                                instance.setEventPathId(mapToFieldEventPathId(value));
                                                            } catch (final Exception ex) {
                                                                ex.printStackTrace();
                                                            }
                                                        } else {
                                                            if (field.equals(ModelTEvent.FI_EVENT_MESSAGE_TYPE)) {
                                                                try {
                                                                    instance.setEventMessageType(mapToFieldEventMessageType(value));
                                                                } catch (final Exception ex) {
                                                                    ex.printStackTrace();
                                                                }
                                                            } else {
                                                                if (field.equals(ModelTEvent.FI_EVENT_GUID)) {
                                                                    try {
                                                                        instance.setEventGuid(mapToFieldEventGuid(value));
                                                                    } catch (final Exception ex) {
                                                                        ex.printStackTrace();
                                                                    }
                                                                } else {
                                                                    if (field.equals(ModelTEvent.FI_PARAM_TEST_V1)) {
                                                                        try {
                                                                            instance.setParamTestV1(mapToFieldParamTestV1(value));
                                                                        } catch (final Exception ex) {
                                                                            ex.printStackTrace();
                                                                        }
                                                                    } else {
                                                                        if (field.equals(ModelTEvent.FI_PARAM_TEST_V2)) {
                                                                            try {
                                                                                instance.setParamTestV2(mapToFieldParamTestV2(value));
                                                                            } catch (final Exception ex) {
                                                                                ex.printStackTrace();
                                                                            }
                                                                        } else {
                                                                            if (field.equals(ModelTEvent.FI_DEVICE_STATUS)) {
                                                                                try {
                                                                                    instance.setDeviceStatus(mapToFieldDeviceStatus(value));
                                                                                } catch (final Exception ex) {
                                                                                    ex.printStackTrace();
                                                                                }
                                                                            } else {
                                                                                if (field.equals(ModelTEvent.FI_DEVICE_ERROR_MESSAGE)) {
                                                                                    try {
                                                                                        instance.setDeviceErrorMessage(mapToFieldDeviceErrorMessage(value));
                                                                                    } catch (final Exception ex) {
                                                                                        ex.printStackTrace();
                                                                                    }
                                                                                } else {
                                                                                    if (field.equals(ModelTEvent.FI_DEVICE_ARIX_X)) {
                                                                                        try {
                                                                                            instance.setDeviceArixX(mapToFieldDeviceArixX(value));
                                                                                        } catch (final Exception ex) {
                                                                                            ex.printStackTrace();
                                                                                        }
                                                                                    } else {
                                                                                        if (field.equals(ModelTEvent.FI_DEVICE_ARIX_Y)) {
                                                                                            try {
                                                                                                instance.setDeviceArixY(mapToFieldDeviceArixY(value));
                                                                                            } catch (final Exception ex) {
                                                                                                ex.printStackTrace();
                                                                                            }
                                                                                        } else {
                                                                                            if (field.equals(ModelTEvent.FI_DEVICE_ARIX_Z)) {
                                                                                                try {
                                                                                                    instance.setDeviceArixZ(mapToFieldDeviceArixZ(value));
                                                                                                } catch (final Exception ex) {
                                                                                                    ex.printStackTrace();
                                                                                                }
                                                                                            } else {
                                                                                                if (field.equals(ModelTEvent.FI_DEVICE_GOODS_STATUS)) {
                                                                                                    try {
                                                                                                        instance.setDeviceGoodsStatus(mapToFieldDeviceGoodsStatus(value));
                                                                                                    } catch (final Exception ex) {
                                                                                                        ex.printStackTrace();
                                                                                                    }
                                                                                                } else {
                                                                                                    if (field.equals(ModelTEvent.FI_EVENT_HANDLER)) {
                                                                                                        try {
                                                                                                            instance.setEventHandler(mapToFieldEventHandler(value));
                                                                                                        } catch (final Exception ex) {
                                                                                                            ex.printStackTrace();
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        public void setField(String field, ModelTEvent instance, byte[] value) {
            if (field.equals(ModelTEvent.FI_ID)) {
                instance.setId(mapToFieldId(value));
            } else {
                if (field.equals(ModelTEvent.FI_EVENT_DEVICE)) {
                    instance.setEventDevice(mapToFieldEventDevice(value));
                } else {
                    if (field.equals(ModelTEvent.FI_EVENT_NAME)) {
                        instance.setEventName(mapToFieldEventName(value));
                    } else {
                        if (field.equals(ModelTEvent.FI_EVENT_TIME)) {
                            instance.setEventTime(mapToFieldEventTime(value));
                        } else {
                            if (field.equals(ModelTEvent.FI_EVENT_TYPE)) {
                                instance.setEventType(mapToFieldEventType(value));
                            } else {
                                if (field.equals(ModelTEvent.FI_EVENT_MESSAGE)) {
                                    instance.setEventMessage(mapToFieldEventMessage(value));
                                } else {
                                    if (field.equals(ModelTEvent.FI_EVENT_TASK_ID)) {
                                        instance.setEventTaskId(mapToFieldEventTaskId(value));
                                    } else {
                                        if (field.equals(ModelTEvent.FI_EVENT_REMARK)) {
                                            instance.setEventRemark(mapToFieldEventRemark(value));
                                        } else {
                                            if (field.equals(ModelTEvent.FI_EVENT_DEVICE_TYPE)) {
                                                instance.setEventDeviceType(mapToFieldEventDeviceType(value));
                                            } else {
                                                if (field.equals(ModelTEvent.FI_EVENT_DEVICE_ABILITY)) {
                                                    instance.setEventDeviceAbility(mapToFieldEventDeviceAbility(value));
                                                } else {
                                                    if (field.equals(ModelTEvent.FI_EVENT_ACTION_ID)) {
                                                        instance.setEventActionId(mapToFieldEventActionId(value));
                                                    } else {
                                                        if (field.equals(ModelTEvent.FI_EVENT_PATH_ID)) {
                                                            instance.setEventPathId(mapToFieldEventPathId(value));
                                                        } else {
                                                            if (field.equals(ModelTEvent.FI_EVENT_MESSAGE_TYPE)) {
                                                                instance.setEventMessageType(mapToFieldEventMessageType(value));
                                                            } else {
                                                                if (field.equals(ModelTEvent.FI_EVENT_GUID)) {
                                                                    instance.setEventGuid(mapToFieldEventGuid(value));
                                                                } else {
                                                                    if (field.equals(ModelTEvent.FI_PARAM_TEST_V1)) {
                                                                        instance.setParamTestV1(mapToFieldParamTestV1(value));
                                                                    } else {
                                                                        if (field.equals(ModelTEvent.FI_PARAM_TEST_V2)) {
                                                                            instance.setParamTestV2(mapToFieldParamTestV2(value));
                                                                        } else {
                                                                            if (field.equals(ModelTEvent.FI_DEVICE_STATUS)) {
                                                                                instance.setDeviceStatus(mapToFieldDeviceStatus(value));
                                                                            } else {
                                                                                if (field.equals(ModelTEvent.FI_DEVICE_ERROR_MESSAGE)) {
                                                                                    instance.setDeviceErrorMessage(mapToFieldDeviceErrorMessage(value));
                                                                                } else {
                                                                                    if (field.equals(ModelTEvent.FI_DEVICE_ARIX_X)) {
                                                                                        instance.setDeviceArixX(mapToFieldDeviceArixX(value));
                                                                                    } else {
                                                                                        if (field.equals(ModelTEvent.FI_DEVICE_ARIX_Y)) {
                                                                                            instance.setDeviceArixY(mapToFieldDeviceArixY(value));
                                                                                        } else {
                                                                                            if (field.equals(ModelTEvent.FI_DEVICE_ARIX_Z)) {
                                                                                                instance.setDeviceArixZ(mapToFieldDeviceArixZ(value));
                                                                                            } else {
                                                                                                if (field.equals(ModelTEvent.FI_DEVICE_GOODS_STATUS)) {
                                                                                                    instance.setDeviceGoodsStatus(mapToFieldDeviceGoodsStatus(value));
                                                                                                } else {
                                                                                                    if (field.equals(ModelTEvent.FI_EVENT_HANDLER)) {
                                                                                                        instance.setEventHandler(mapToFieldEventHandler(value));
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
