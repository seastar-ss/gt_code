package com.shangde.ent_portal.logical.dto.basepo;

import java.util.Date;
import java.util.Map;
import java.util.Set;
import com.shangde.ent_portal.logical.dto.enums.EnumDeviceControlStatus;
import com.shangde.ent_portal.logical.dto.enums.EnumDeviceStatusType;
import com.shangde.ent_portal.logical.dto.enums.EnumYesOrNo;
import com.shawn.ss.lib.tools.CollectionHelper;
import com.shawn.ss.lib.tools.TypeConstantHelper;
import com.shawn.ss.lib.tools.db.api.interfaces.mappers.db.CommonMapMapper;

public class PojoMapMapperTDevice
    implements CommonMapMapper<ModelTDevice>
{

    @Override
    public ModelTDevice fromMap(Map<byte[], byte[]> map) {
        ModelTDevice instance = new ModelTDevice();
        Set<Map.Entry<byte[], byte[]>> entries = map.entrySet();
        for (Map.Entry<byte[], byte[]> entry: entries) {
            String field = new String(entry.getKey());
            if (field.equals(ModelTDevice.FI_ID)) {
                instance.setId(mapToFieldId(entry.getValue()));
            } else {
                if (field.equals(ModelTDevice.FI_DEVICE_STATUS)) {
                    instance.setDeviceStatus(mapToFieldDeviceStatus(entry.getValue()));
                } else {
                    if (field.equals(ModelTDevice.FI_DEVICE_IP)) {
                        instance.setDeviceIp(mapToFieldDeviceIp(entry.getValue()));
                    } else {
                        if (field.equals(ModelTDevice.FI_DEVICE_PROC)) {
                            instance.setDeviceProc(mapToFieldDeviceProc(entry.getValue()));
                        } else {
                            if (field.equals(ModelTDevice.FI_DEVICE_NAME)) {
                                instance.setDeviceName(mapToFieldDeviceName(entry.getValue()));
                            } else {
                                if (field.equals(ModelTDevice.FI_DEVICE_DESP)) {
                                    instance.setDeviceDesp(mapToFieldDeviceDesp(entry.getValue()));
                                } else {
                                    if (field.equals(ModelTDevice.FI_DEVICE_CREATE_TIME)) {
                                        instance.setDeviceCreateTime(mapToFieldDeviceCreateTime(entry.getValue()));
                                    } else {
                                        if (field.equals(ModelTDevice.FI_DEVICE_UPDATE_TIME)) {
                                            instance.setDeviceUpdateTime(mapToFieldDeviceUpdateTime(entry.getValue()));
                                        } else {
                                            if (field.equals(ModelTDevice.FI_DEVICE_DELETE_FLAG)) {
                                                instance.setDeviceDeleteFlag(mapToFieldDeviceDeleteFlag(entry.getValue()));
                                            } else {
                                                if (field.equals(ModelTDevice.FI_DEVICE_TYPE)) {
                                                    instance.setDeviceType(mapToFieldDeviceType(entry.getValue()));
                                                } else {
                                                    if (field.equals(ModelTDevice.FI_DEVICE_REMARK)) {
                                                        instance.setDeviceRemark(mapToFieldDeviceRemark(entry.getValue()));
                                                    } else {
                                                        if (field.equals(ModelTDevice.FI_DEVICE_HARDWARE_ID)) {
                                                            instance.setDeviceHardwareId(mapToFieldDeviceHardwareId(entry.getValue()));
                                                        } else {
                                                            if (field.equals(ModelTDevice.FI_DEVICE_LAST_ORDER_PARAM)) {
                                                                instance.setDeviceLastOrderParam(mapToFieldDeviceLastOrderParam(entry.getValue()));
                                                            } else {
                                                                if (field.equals(ModelTDevice.FI_DEVICE_LAST_CHECK_TIME)) {
                                                                    instance.setDeviceLastCheckTime(mapToFieldDeviceLastCheckTime(entry.getValue()));
                                                                } else {
                                                                    if (field.equals(ModelTDevice.FI_DEVICE_ARIX_X)) {
                                                                        instance.setDeviceArixX(mapToFieldDeviceArixX(entry.getValue()));
                                                                    } else {
                                                                        if (field.equals(ModelTDevice.FI_DEVICE_ARIX_Y)) {
                                                                            instance.setDeviceArixY(mapToFieldDeviceArixY(entry.getValue()));
                                                                        } else {
                                                                            if (field.equals(ModelTDevice.FI_DEVICE_ARIX_Z)) {
                                                                                instance.setDeviceArixZ(mapToFieldDeviceArixZ(entry.getValue()));
                                                                            } else {
                                                                                if (field.equals(ModelTDevice.FI_DEVICE_LAST_OCUPY_TIME)) {
                                                                                    instance.setDeviceLastOcupyTime(mapToFieldDeviceLastOcupyTime(entry.getValue()));
                                                                                } else {
                                                                                    if (field.equals(ModelTDevice.FI_DEVICE_LAST_RELEASE_TIME)) {
                                                                                        instance.setDeviceLastReleaseTime(mapToFieldDeviceLastReleaseTime(entry.getValue()));
                                                                                    } else {
                                                                                        if (field.equals(ModelTDevice.FI_DEVICE_TASK_ID)) {
                                                                                            instance.setDeviceTaskId(mapToFieldDeviceTaskId(entry.getValue()));
                                                                                        } else {
                                                                                            if (field.equals(ModelTDevice.FI_DEVICE_LAST_PROC)) {
                                                                                                instance.setDeviceLastProc(mapToFieldDeviceLastProc(entry.getValue()));
                                                                                            } else {
                                                                                                if (field.equals(ModelTDevice.FI_DEVICE_BATTERY)) {
                                                                                                    instance.setDeviceBattery(mapToFieldDeviceBattery(entry.getValue()));
                                                                                                } else {
                                                                                                    if (field.equals(ModelTDevice.FI_DEVICE_GOODS_HOLDER_NUM)) {
                                                                                                        instance.setDeviceGoodsHolderNum(mapToFieldDeviceGoodsHolderNum(entry.getValue()));
                                                                                                    } else {
                                                                                                        if (field.equals(ModelTDevice.FI_DEVICE_GROUP)) {
                                                                                                            instance.setDeviceGroup(mapToFieldDeviceGroup(entry.getValue()));
                                                                                                        } else {
                                                                                                            if (field.equals(ModelTDevice.FI_DEVICE_ATTACH_MAP_POINT)) {
                                                                                                                instance.setDeviceAttachMapPoint(mapToFieldDeviceAttachMapPoint(entry.getValue()));
                                                                                                            } else {
                                                                                                                if (field.equals(ModelTDevice.FI_DEVICE_INDEX)) {
                                                                                                                    instance.setDeviceIndex(mapToFieldDeviceIndex(entry.getValue()));
                                                                                                                } else {
                                                                                                                    if (field.equals(ModelTDevice.FI_DEVICE_HANDLE_TASK)) {
                                                                                                                        instance.setDeviceHandleTask(mapToFieldDeviceHandleTask(entry.getValue()));
                                                                                                                    } else {
                                                                                                                        if (field.equals(ModelTDevice.FI_DEVICE_CONTROL_STATUS)) {
                                                                                                                            instance.setDeviceControlStatus(mapToFieldDeviceControlStatus(entry.getValue()));
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
                }
            }
        }
        return instance;
    }

    protected Integer mapToFieldId(byte[] bytes) {
        return TypeConstantHelper.toObject(bytes, Integer.class);
    }

    protected EnumDeviceStatusType mapToFieldDeviceStatus(byte[] bytes) {
        return EnumDeviceStatusType.fromValue(TypeConstantHelper.toObject(bytes, Byte.class));
    }

    protected String mapToFieldDeviceIp(byte[] bytes) {
        return TypeConstantHelper.toObject(bytes, String.class);
    }

    protected Integer mapToFieldDeviceProc(byte[] bytes) {
        return TypeConstantHelper.toObject(bytes, Integer.class);
    }

    protected String mapToFieldDeviceName(byte[] bytes) {
        return TypeConstantHelper.toObject(bytes, String.class);
    }

    protected String mapToFieldDeviceDesp(byte[] bytes) {
        return TypeConstantHelper.toObject(bytes, String.class);
    }

    protected Date mapToFieldDeviceCreateTime(byte[] bytes) {
        return TypeConstantHelper.toObject(bytes, Date.class);
    }

    protected Date mapToFieldDeviceUpdateTime(byte[] bytes) {
        return TypeConstantHelper.toObject(bytes, Date.class);
    }

    protected Byte mapToFieldDeviceDeleteFlag(byte[] bytes) {
        return TypeConstantHelper.toObject(bytes, Byte.class);
    }

    protected Integer mapToFieldDeviceType(byte[] bytes) {
        return TypeConstantHelper.toObject(bytes, Integer.class);
    }

    protected String mapToFieldDeviceRemark(byte[] bytes) {
        return TypeConstantHelper.toObject(bytes, String.class);
    }

    protected String mapToFieldDeviceHardwareId(byte[] bytes) {
        return TypeConstantHelper.toObject(bytes, String.class);
    }

    protected String mapToFieldDeviceLastOrderParam(byte[] bytes) {
        return TypeConstantHelper.toObject(bytes, String.class);
    }

    protected Date mapToFieldDeviceLastCheckTime(byte[] bytes) {
        return TypeConstantHelper.toObject(bytes, Date.class);
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

    protected Date mapToFieldDeviceLastOcupyTime(byte[] bytes) {
        return TypeConstantHelper.toObject(bytes, Date.class);
    }

    protected Date mapToFieldDeviceLastReleaseTime(byte[] bytes) {
        return TypeConstantHelper.toObject(bytes, Date.class);
    }

    protected Integer mapToFieldDeviceTaskId(byte[] bytes) {
        return TypeConstantHelper.toObject(bytes, Integer.class);
    }

    protected Integer mapToFieldDeviceLastProc(byte[] bytes) {
        return TypeConstantHelper.toObject(bytes, Integer.class);
    }

    protected Integer mapToFieldDeviceBattery(byte[] bytes) {
        return TypeConstantHelper.toObject(bytes, Integer.class);
    }

    protected Integer mapToFieldDeviceGoodsHolderNum(byte[] bytes) {
        return TypeConstantHelper.toObject(bytes, Integer.class);
    }

    protected Integer mapToFieldDeviceGroup(byte[] bytes) {
        return TypeConstantHelper.toObject(bytes, Integer.class);
    }

    protected Integer mapToFieldDeviceAttachMapPoint(byte[] bytes) {
        return TypeConstantHelper.toObject(bytes, Integer.class);
    }

    protected Integer mapToFieldDeviceIndex(byte[] bytes) {
        return TypeConstantHelper.toObject(bytes, Integer.class);
    }

    protected EnumYesOrNo mapToFieldDeviceHandleTask(byte[] bytes) {
        return EnumYesOrNo.fromValue(TypeConstantHelper.toObject(bytes, Byte.class));
    }

    protected EnumDeviceControlStatus mapToFieldDeviceControlStatus(byte[] bytes) {
        return EnumDeviceControlStatus.fromValue(TypeConstantHelper.toObject(bytes, Byte.class));
    }

    @Override
    public Map<byte[], byte[]> toMap(ModelTDevice instance) {
        Map<byte[], byte[]> ret = CollectionHelper.newMap();
        if (instance == null) {
            return ret;
        }
        byte[] valueId = mapFromFieldId(instance.getId());
        ret.put(ModelTDevice.FI_ID.getBytes(), valueId);
        byte[] valueDevice_status = mapFromFieldDeviceStatus(instance.getDeviceStatus());
        ret.put(ModelTDevice.FI_DEVICE_STATUS.getBytes(), valueDevice_status);
        byte[] valueDevice_ip = mapFromFieldDeviceIp(instance.getDeviceIp());
        ret.put(ModelTDevice.FI_DEVICE_IP.getBytes(), valueDevice_ip);
        byte[] valueDevice_proc = mapFromFieldDeviceProc(instance.getDeviceProc());
        ret.put(ModelTDevice.FI_DEVICE_PROC.getBytes(), valueDevice_proc);
        byte[] valueDevice_name = mapFromFieldDeviceName(instance.getDeviceName());
        ret.put(ModelTDevice.FI_DEVICE_NAME.getBytes(), valueDevice_name);
        byte[] valueDevice_desp = mapFromFieldDeviceDesp(instance.getDeviceDesp());
        ret.put(ModelTDevice.FI_DEVICE_DESP.getBytes(), valueDevice_desp);
        byte[] valueDevice_create_time = mapFromFieldDeviceCreateTime(instance.getDeviceCreateTime());
        ret.put(ModelTDevice.FI_DEVICE_CREATE_TIME.getBytes(), valueDevice_create_time);
        byte[] valueDevice_update_time = mapFromFieldDeviceUpdateTime(instance.getDeviceUpdateTime());
        ret.put(ModelTDevice.FI_DEVICE_UPDATE_TIME.getBytes(), valueDevice_update_time);
        byte[] valueDevice_delete_flag = mapFromFieldDeviceDeleteFlag(instance.getDeviceDeleteFlag());
        ret.put(ModelTDevice.FI_DEVICE_DELETE_FLAG.getBytes(), valueDevice_delete_flag);
        byte[] valueDevice_type = mapFromFieldDeviceType(instance.getDeviceType());
        ret.put(ModelTDevice.FI_DEVICE_TYPE.getBytes(), valueDevice_type);
        byte[] valueDevice_remark = mapFromFieldDeviceRemark(instance.getDeviceRemark());
        ret.put(ModelTDevice.FI_DEVICE_REMARK.getBytes(), valueDevice_remark);
        byte[] valueDevice_hardware_id = mapFromFieldDeviceHardwareId(instance.getDeviceHardwareId());
        ret.put(ModelTDevice.FI_DEVICE_HARDWARE_ID.getBytes(), valueDevice_hardware_id);
        byte[] valueDevice_last_order_param = mapFromFieldDeviceLastOrderParam(instance.getDeviceLastOrderParam());
        ret.put(ModelTDevice.FI_DEVICE_LAST_ORDER_PARAM.getBytes(), valueDevice_last_order_param);
        byte[] valueDevice_last_check_time = mapFromFieldDeviceLastCheckTime(instance.getDeviceLastCheckTime());
        ret.put(ModelTDevice.FI_DEVICE_LAST_CHECK_TIME.getBytes(), valueDevice_last_check_time);
        byte[] valueDevice_arix_x = mapFromFieldDeviceArixX(instance.getDeviceArixX());
        ret.put(ModelTDevice.FI_DEVICE_ARIX_X.getBytes(), valueDevice_arix_x);
        byte[] valueDevice_arix_y = mapFromFieldDeviceArixY(instance.getDeviceArixY());
        ret.put(ModelTDevice.FI_DEVICE_ARIX_Y.getBytes(), valueDevice_arix_y);
        byte[] valueDevice_arix_z = mapFromFieldDeviceArixZ(instance.getDeviceArixZ());
        ret.put(ModelTDevice.FI_DEVICE_ARIX_Z.getBytes(), valueDevice_arix_z);
        byte[] valueDevice_last_ocupy_time = mapFromFieldDeviceLastOcupyTime(instance.getDeviceLastOcupyTime());
        ret.put(ModelTDevice.FI_DEVICE_LAST_OCUPY_TIME.getBytes(), valueDevice_last_ocupy_time);
        byte[] valueDevice_last_release_time = mapFromFieldDeviceLastReleaseTime(instance.getDeviceLastReleaseTime());
        ret.put(ModelTDevice.FI_DEVICE_LAST_RELEASE_TIME.getBytes(), valueDevice_last_release_time);
        byte[] valueDevice_task_id = mapFromFieldDeviceTaskId(instance.getDeviceTaskId());
        ret.put(ModelTDevice.FI_DEVICE_TASK_ID.getBytes(), valueDevice_task_id);
        byte[] valueDevice_last_proc = mapFromFieldDeviceLastProc(instance.getDeviceLastProc());
        ret.put(ModelTDevice.FI_DEVICE_LAST_PROC.getBytes(), valueDevice_last_proc);
        byte[] valueDevice_battery = mapFromFieldDeviceBattery(instance.getDeviceBattery());
        ret.put(ModelTDevice.FI_DEVICE_BATTERY.getBytes(), valueDevice_battery);
        byte[] valueDevice_goods_holder_num = mapFromFieldDeviceGoodsHolderNum(instance.getDeviceGoodsHolderNum());
        ret.put(ModelTDevice.FI_DEVICE_GOODS_HOLDER_NUM.getBytes(), valueDevice_goods_holder_num);
        byte[] valueDevice_group = mapFromFieldDeviceGroup(instance.getDeviceGroup());
        ret.put(ModelTDevice.FI_DEVICE_GROUP.getBytes(), valueDevice_group);
        byte[] valueDevice_attach_map_point = mapFromFieldDeviceAttachMapPoint(instance.getDeviceAttachMapPoint());
        ret.put(ModelTDevice.FI_DEVICE_ATTACH_MAP_POINT.getBytes(), valueDevice_attach_map_point);
        byte[] valueDevice_index = mapFromFieldDeviceIndex(instance.getDeviceIndex());
        ret.put(ModelTDevice.FI_DEVICE_INDEX.getBytes(), valueDevice_index);
        byte[] valueDevice_handle_task = mapFromFieldDeviceHandleTask(instance.getDeviceHandleTask());
        ret.put(ModelTDevice.FI_DEVICE_HANDLE_TASK.getBytes(), valueDevice_handle_task);
        byte[] valueDevice_control_status = mapFromFieldDeviceControlStatus(instance.getDeviceControlStatus());
        ret.put(ModelTDevice.FI_DEVICE_CONTROL_STATUS.getBytes(), valueDevice_control_status);
        return ret;
    }

    protected byte[] mapFromFieldId(Integer field) {
        byte[] ret = TypeConstantHelper.fromObjectBin(field);
        return ret;
    }

    protected byte[] mapFromFieldDeviceStatus(EnumDeviceStatusType field) {
        byte[] ret = TypeConstantHelper.fromObjectBin(field.val);
        return ret;
    }

    protected byte[] mapFromFieldDeviceIp(String field) {
        byte[] ret = TypeConstantHelper.fromObjectBin(field);
        return ret;
    }

    protected byte[] mapFromFieldDeviceProc(Integer field) {
        byte[] ret = TypeConstantHelper.fromObjectBin(field);
        return ret;
    }

    protected byte[] mapFromFieldDeviceName(String field) {
        byte[] ret = TypeConstantHelper.fromObjectBin(field);
        return ret;
    }

    protected byte[] mapFromFieldDeviceDesp(String field) {
        byte[] ret = TypeConstantHelper.fromObjectBin(field);
        return ret;
    }

    protected byte[] mapFromFieldDeviceCreateTime(Date field) {
        byte[] ret = TypeConstantHelper.fromObjectBin(field);
        return ret;
    }

    protected byte[] mapFromFieldDeviceUpdateTime(Date field) {
        byte[] ret = TypeConstantHelper.fromObjectBin(field);
        return ret;
    }

    protected byte[] mapFromFieldDeviceDeleteFlag(Byte field) {
        byte[] ret = TypeConstantHelper.fromObjectBin(field);
        return ret;
    }

    protected byte[] mapFromFieldDeviceType(Integer field) {
        byte[] ret = TypeConstantHelper.fromObjectBin(field);
        return ret;
    }

    protected byte[] mapFromFieldDeviceRemark(String field) {
        byte[] ret = TypeConstantHelper.fromObjectBin(field);
        return ret;
    }

    protected byte[] mapFromFieldDeviceHardwareId(String field) {
        byte[] ret = TypeConstantHelper.fromObjectBin(field);
        return ret;
    }

    protected byte[] mapFromFieldDeviceLastOrderParam(String field) {
        byte[] ret = TypeConstantHelper.fromObjectBin(field);
        return ret;
    }

    protected byte[] mapFromFieldDeviceLastCheckTime(Date field) {
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

    protected byte[] mapFromFieldDeviceLastOcupyTime(Date field) {
        byte[] ret = TypeConstantHelper.fromObjectBin(field);
        return ret;
    }

    protected byte[] mapFromFieldDeviceLastReleaseTime(Date field) {
        byte[] ret = TypeConstantHelper.fromObjectBin(field);
        return ret;
    }

    protected byte[] mapFromFieldDeviceTaskId(Integer field) {
        byte[] ret = TypeConstantHelper.fromObjectBin(field);
        return ret;
    }

    protected byte[] mapFromFieldDeviceLastProc(Integer field) {
        byte[] ret = TypeConstantHelper.fromObjectBin(field);
        return ret;
    }

    protected byte[] mapFromFieldDeviceBattery(Integer field) {
        byte[] ret = TypeConstantHelper.fromObjectBin(field);
        return ret;
    }

    protected byte[] mapFromFieldDeviceGoodsHolderNum(Integer field) {
        byte[] ret = TypeConstantHelper.fromObjectBin(field);
        return ret;
    }

    protected byte[] mapFromFieldDeviceGroup(Integer field) {
        byte[] ret = TypeConstantHelper.fromObjectBin(field);
        return ret;
    }

    protected byte[] mapFromFieldDeviceAttachMapPoint(Integer field) {
        byte[] ret = TypeConstantHelper.fromObjectBin(field);
        return ret;
    }

    protected byte[] mapFromFieldDeviceIndex(Integer field) {
        byte[] ret = TypeConstantHelper.fromObjectBin(field);
        return ret;
    }

    protected byte[] mapFromFieldDeviceHandleTask(EnumYesOrNo field) {
        byte[] ret = TypeConstantHelper.fromObjectBin(field.val);
        return ret;
    }

    protected byte[] mapFromFieldDeviceControlStatus(EnumDeviceControlStatus field) {
        byte[] ret = TypeConstantHelper.fromObjectBin(field.val);
        return ret;
    }

    @Override
    public Map<String, Object> toCommonMap(ModelTDevice instance) {
        Map<String, Object> ret = CollectionHelper.newMap();
        if (instance == null) {
            return ret;
        }
        Integer dId = instance.getId();
        if (dId!= null) {
            ret.put(ModelTDevice.FI_ID, dId);
        }
        EnumDeviceStatusType dDevice_status = instance.getDeviceStatus();
        if (dDevice_status!= null) {
            ret.put(ModelTDevice.FI_DEVICE_STATUS, dDevice_status.val);
        }
        String dDevice_ip = instance.getDeviceIp();
        if (dDevice_ip!= null) {
            ret.put(ModelTDevice.FI_DEVICE_IP, dDevice_ip);
        }
        Integer dDevice_proc = instance.getDeviceProc();
        if (dDevice_proc!= null) {
            ret.put(ModelTDevice.FI_DEVICE_PROC, dDevice_proc);
        }
        String dDevice_name = instance.getDeviceName();
        if (dDevice_name!= null) {
            ret.put(ModelTDevice.FI_DEVICE_NAME, dDevice_name);
        }
        String dDevice_desp = instance.getDeviceDesp();
        if (dDevice_desp!= null) {
            ret.put(ModelTDevice.FI_DEVICE_DESP, dDevice_desp);
        }
        Date dDevice_create_time = instance.getDeviceCreateTime();
        if (dDevice_create_time!= null) {
            ret.put(ModelTDevice.FI_DEVICE_CREATE_TIME, dDevice_create_time);
        }
        Date dDevice_update_time = instance.getDeviceUpdateTime();
        if (dDevice_update_time!= null) {
            ret.put(ModelTDevice.FI_DEVICE_UPDATE_TIME, dDevice_update_time);
        }
        Byte dDevice_delete_flag = instance.getDeviceDeleteFlag();
        if (dDevice_delete_flag!= null) {
            ret.put(ModelTDevice.FI_DEVICE_DELETE_FLAG, dDevice_delete_flag);
        }
        Integer dDevice_type = instance.getDeviceType();
        if (dDevice_type!= null) {
            ret.put(ModelTDevice.FI_DEVICE_TYPE, dDevice_type);
        }
        String dDevice_remark = instance.getDeviceRemark();
        if (dDevice_remark!= null) {
            ret.put(ModelTDevice.FI_DEVICE_REMARK, dDevice_remark);
        }
        String dDevice_hardware_id = instance.getDeviceHardwareId();
        if (dDevice_hardware_id!= null) {
            ret.put(ModelTDevice.FI_DEVICE_HARDWARE_ID, dDevice_hardware_id);
        }
        String dDevice_last_order_param = instance.getDeviceLastOrderParam();
        if (dDevice_last_order_param!= null) {
            ret.put(ModelTDevice.FI_DEVICE_LAST_ORDER_PARAM, dDevice_last_order_param);
        }
        Date dDevice_last_check_time = instance.getDeviceLastCheckTime();
        if (dDevice_last_check_time!= null) {
            ret.put(ModelTDevice.FI_DEVICE_LAST_CHECK_TIME, dDevice_last_check_time);
        }
        Integer dDevice_arix_x = instance.getDeviceArixX();
        if (dDevice_arix_x!= null) {
            ret.put(ModelTDevice.FI_DEVICE_ARIX_X, dDevice_arix_x);
        }
        Integer dDevice_arix_y = instance.getDeviceArixY();
        if (dDevice_arix_y!= null) {
            ret.put(ModelTDevice.FI_DEVICE_ARIX_Y, dDevice_arix_y);
        }
        Integer dDevice_arix_z = instance.getDeviceArixZ();
        if (dDevice_arix_z!= null) {
            ret.put(ModelTDevice.FI_DEVICE_ARIX_Z, dDevice_arix_z);
        }
        Date dDevice_last_ocupy_time = instance.getDeviceLastOcupyTime();
        if (dDevice_last_ocupy_time!= null) {
            ret.put(ModelTDevice.FI_DEVICE_LAST_OCUPY_TIME, dDevice_last_ocupy_time);
        }
        Date dDevice_last_release_time = instance.getDeviceLastReleaseTime();
        if (dDevice_last_release_time!= null) {
            ret.put(ModelTDevice.FI_DEVICE_LAST_RELEASE_TIME, dDevice_last_release_time);
        }
        Integer dDevice_task_id = instance.getDeviceTaskId();
        if (dDevice_task_id!= null) {
            ret.put(ModelTDevice.FI_DEVICE_TASK_ID, dDevice_task_id);
        }
        Integer dDevice_last_proc = instance.getDeviceLastProc();
        if (dDevice_last_proc!= null) {
            ret.put(ModelTDevice.FI_DEVICE_LAST_PROC, dDevice_last_proc);
        }
        Integer dDevice_battery = instance.getDeviceBattery();
        if (dDevice_battery!= null) {
            ret.put(ModelTDevice.FI_DEVICE_BATTERY, dDevice_battery);
        }
        Integer dDevice_goods_holder_num = instance.getDeviceGoodsHolderNum();
        if (dDevice_goods_holder_num!= null) {
            ret.put(ModelTDevice.FI_DEVICE_GOODS_HOLDER_NUM, dDevice_goods_holder_num);
        }
        Integer dDevice_group = instance.getDeviceGroup();
        if (dDevice_group!= null) {
            ret.put(ModelTDevice.FI_DEVICE_GROUP, dDevice_group);
        }
        Integer dDevice_attach_map_point = instance.getDeviceAttachMapPoint();
        if (dDevice_attach_map_point!= null) {
            ret.put(ModelTDevice.FI_DEVICE_ATTACH_MAP_POINT, dDevice_attach_map_point);
        }
        Integer dDevice_index = instance.getDeviceIndex();
        if (dDevice_index!= null) {
            ret.put(ModelTDevice.FI_DEVICE_INDEX, dDevice_index);
        }
        EnumYesOrNo dDevice_handle_task = instance.getDeviceHandleTask();
        if (dDevice_handle_task!= null) {
            ret.put(ModelTDevice.FI_DEVICE_HANDLE_TASK, dDevice_handle_task.val);
        }
        EnumDeviceControlStatus dDevice_control_status = instance.getDeviceControlStatus();
        if (dDevice_control_status!= null) {
            ret.put(ModelTDevice.FI_DEVICE_CONTROL_STATUS, dDevice_control_status.val);
        }
        return ret;
    }

    @Override
    public ModelTDevice fromCommonMap(Map<String, Object> param) {
        ModelTDevice ret = new ModelTDevice();
        if (param == null) {
            return ret;
        }
        Object dId = param.get(ModelTDevice.FI_ID);
        if (dId!= null) {
            this.setField(ModelTDevice.FI_ID, ret, dId);
        }
        Object dDevice_status = param.get(ModelTDevice.FI_DEVICE_STATUS);
        if (dDevice_status!= null) {
            this.setField(ModelTDevice.FI_DEVICE_STATUS, ret, dDevice_status);
        }
        Object dDevice_ip = param.get(ModelTDevice.FI_DEVICE_IP);
        if (dDevice_ip!= null) {
            this.setField(ModelTDevice.FI_DEVICE_IP, ret, dDevice_ip);
        }
        Object dDevice_proc = param.get(ModelTDevice.FI_DEVICE_PROC);
        if (dDevice_proc!= null) {
            this.setField(ModelTDevice.FI_DEVICE_PROC, ret, dDevice_proc);
        }
        Object dDevice_name = param.get(ModelTDevice.FI_DEVICE_NAME);
        if (dDevice_name!= null) {
            this.setField(ModelTDevice.FI_DEVICE_NAME, ret, dDevice_name);
        }
        Object dDevice_desp = param.get(ModelTDevice.FI_DEVICE_DESP);
        if (dDevice_desp!= null) {
            this.setField(ModelTDevice.FI_DEVICE_DESP, ret, dDevice_desp);
        }
        Object dDevice_create_time = param.get(ModelTDevice.FI_DEVICE_CREATE_TIME);
        if (dDevice_create_time!= null) {
            this.setField(ModelTDevice.FI_DEVICE_CREATE_TIME, ret, dDevice_create_time);
        }
        Object dDevice_update_time = param.get(ModelTDevice.FI_DEVICE_UPDATE_TIME);
        if (dDevice_update_time!= null) {
            this.setField(ModelTDevice.FI_DEVICE_UPDATE_TIME, ret, dDevice_update_time);
        }
        Object dDevice_delete_flag = param.get(ModelTDevice.FI_DEVICE_DELETE_FLAG);
        if (dDevice_delete_flag!= null) {
            this.setField(ModelTDevice.FI_DEVICE_DELETE_FLAG, ret, dDevice_delete_flag);
        }
        Object dDevice_type = param.get(ModelTDevice.FI_DEVICE_TYPE);
        if (dDevice_type!= null) {
            this.setField(ModelTDevice.FI_DEVICE_TYPE, ret, dDevice_type);
        }
        Object dDevice_remark = param.get(ModelTDevice.FI_DEVICE_REMARK);
        if (dDevice_remark!= null) {
            this.setField(ModelTDevice.FI_DEVICE_REMARK, ret, dDevice_remark);
        }
        Object dDevice_hardware_id = param.get(ModelTDevice.FI_DEVICE_HARDWARE_ID);
        if (dDevice_hardware_id!= null) {
            this.setField(ModelTDevice.FI_DEVICE_HARDWARE_ID, ret, dDevice_hardware_id);
        }
        Object dDevice_last_order_param = param.get(ModelTDevice.FI_DEVICE_LAST_ORDER_PARAM);
        if (dDevice_last_order_param!= null) {
            this.setField(ModelTDevice.FI_DEVICE_LAST_ORDER_PARAM, ret, dDevice_last_order_param);
        }
        Object dDevice_last_check_time = param.get(ModelTDevice.FI_DEVICE_LAST_CHECK_TIME);
        if (dDevice_last_check_time!= null) {
            this.setField(ModelTDevice.FI_DEVICE_LAST_CHECK_TIME, ret, dDevice_last_check_time);
        }
        Object dDevice_arix_x = param.get(ModelTDevice.FI_DEVICE_ARIX_X);
        if (dDevice_arix_x!= null) {
            this.setField(ModelTDevice.FI_DEVICE_ARIX_X, ret, dDevice_arix_x);
        }
        Object dDevice_arix_y = param.get(ModelTDevice.FI_DEVICE_ARIX_Y);
        if (dDevice_arix_y!= null) {
            this.setField(ModelTDevice.FI_DEVICE_ARIX_Y, ret, dDevice_arix_y);
        }
        Object dDevice_arix_z = param.get(ModelTDevice.FI_DEVICE_ARIX_Z);
        if (dDevice_arix_z!= null) {
            this.setField(ModelTDevice.FI_DEVICE_ARIX_Z, ret, dDevice_arix_z);
        }
        Object dDevice_last_ocupy_time = param.get(ModelTDevice.FI_DEVICE_LAST_OCUPY_TIME);
        if (dDevice_last_ocupy_time!= null) {
            this.setField(ModelTDevice.FI_DEVICE_LAST_OCUPY_TIME, ret, dDevice_last_ocupy_time);
        }
        Object dDevice_last_release_time = param.get(ModelTDevice.FI_DEVICE_LAST_RELEASE_TIME);
        if (dDevice_last_release_time!= null) {
            this.setField(ModelTDevice.FI_DEVICE_LAST_RELEASE_TIME, ret, dDevice_last_release_time);
        }
        Object dDevice_task_id = param.get(ModelTDevice.FI_DEVICE_TASK_ID);
        if (dDevice_task_id!= null) {
            this.setField(ModelTDevice.FI_DEVICE_TASK_ID, ret, dDevice_task_id);
        }
        Object dDevice_last_proc = param.get(ModelTDevice.FI_DEVICE_LAST_PROC);
        if (dDevice_last_proc!= null) {
            this.setField(ModelTDevice.FI_DEVICE_LAST_PROC, ret, dDevice_last_proc);
        }
        Object dDevice_battery = param.get(ModelTDevice.FI_DEVICE_BATTERY);
        if (dDevice_battery!= null) {
            this.setField(ModelTDevice.FI_DEVICE_BATTERY, ret, dDevice_battery);
        }
        Object dDevice_goods_holder_num = param.get(ModelTDevice.FI_DEVICE_GOODS_HOLDER_NUM);
        if (dDevice_goods_holder_num!= null) {
            this.setField(ModelTDevice.FI_DEVICE_GOODS_HOLDER_NUM, ret, dDevice_goods_holder_num);
        }
        Object dDevice_group = param.get(ModelTDevice.FI_DEVICE_GROUP);
        if (dDevice_group!= null) {
            this.setField(ModelTDevice.FI_DEVICE_GROUP, ret, dDevice_group);
        }
        Object dDevice_attach_map_point = param.get(ModelTDevice.FI_DEVICE_ATTACH_MAP_POINT);
        if (dDevice_attach_map_point!= null) {
            this.setField(ModelTDevice.FI_DEVICE_ATTACH_MAP_POINT, ret, dDevice_attach_map_point);
        }
        Object dDevice_index = param.get(ModelTDevice.FI_DEVICE_INDEX);
        if (dDevice_index!= null) {
            this.setField(ModelTDevice.FI_DEVICE_INDEX, ret, dDevice_index);
        }
        Object dDevice_handle_task = param.get(ModelTDevice.FI_DEVICE_HANDLE_TASK);
        if (dDevice_handle_task!= null) {
            this.setField(ModelTDevice.FI_DEVICE_HANDLE_TASK, ret, dDevice_handle_task);
        }
        Object dDevice_control_status = param.get(ModelTDevice.FI_DEVICE_CONTROL_STATUS);
        if (dDevice_control_status!= null) {
            this.setField(ModelTDevice.FI_DEVICE_CONTROL_STATUS, ret, dDevice_control_status);
        }
        return ret;
    }

    protected Integer mapToFieldId(Object obj) {
        return ((Integer) obj);
    }

    protected EnumDeviceStatusType mapToFieldDeviceStatus(Object obj) {
        return EnumDeviceStatusType.fromValue(((Byte) obj));
    }

    protected String mapToFieldDeviceIp(Object obj) {
        return ((String) obj);
    }

    protected Integer mapToFieldDeviceProc(Object obj) {
        return ((Integer) obj);
    }

    protected String mapToFieldDeviceName(Object obj) {
        return ((String) obj);
    }

    protected String mapToFieldDeviceDesp(Object obj) {
        return ((String) obj);
    }

    protected Date mapToFieldDeviceCreateTime(Object obj) {
        return ((Date) obj);
    }

    protected Date mapToFieldDeviceUpdateTime(Object obj) {
        return ((Date) obj);
    }

    protected Byte mapToFieldDeviceDeleteFlag(Object obj) {
        return ((Byte) obj);
    }

    protected Integer mapToFieldDeviceType(Object obj) {
        return ((Integer) obj);
    }

    protected String mapToFieldDeviceRemark(Object obj) {
        return ((String) obj);
    }

    protected String mapToFieldDeviceHardwareId(Object obj) {
        return ((String) obj);
    }

    protected String mapToFieldDeviceLastOrderParam(Object obj) {
        return ((String) obj);
    }

    protected Date mapToFieldDeviceLastCheckTime(Object obj) {
        return ((Date) obj);
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

    protected Date mapToFieldDeviceLastOcupyTime(Object obj) {
        return ((Date) obj);
    }

    protected Date mapToFieldDeviceLastReleaseTime(Object obj) {
        return ((Date) obj);
    }

    protected Integer mapToFieldDeviceTaskId(Object obj) {
        return ((Integer) obj);
    }

    protected Integer mapToFieldDeviceLastProc(Object obj) {
        return ((Integer) obj);
    }

    protected Integer mapToFieldDeviceBattery(Object obj) {
        return ((Integer) obj);
    }

    protected Integer mapToFieldDeviceGoodsHolderNum(Object obj) {
        return ((Integer) obj);
    }

    protected Integer mapToFieldDeviceGroup(Object obj) {
        return ((Integer) obj);
    }

    protected Integer mapToFieldDeviceAttachMapPoint(Object obj) {
        return ((Integer) obj);
    }

    protected Integer mapToFieldDeviceIndex(Object obj) {
        return ((Integer) obj);
    }

    protected EnumYesOrNo mapToFieldDeviceHandleTask(Object obj) {
        return EnumYesOrNo.fromValue(((Byte) obj));
    }

    protected EnumDeviceControlStatus mapToFieldDeviceControlStatus(Object obj) {
        return EnumDeviceControlStatus.fromValue(((Byte) obj));
    }

    public<TT> TT getField(String field, ModelTDevice instance) {
        try {
            if (field.equals(ModelTDevice.FI_ID)) {
                return ((TT) instance.getId());
            } else {
                if (field.equals(ModelTDevice.FI_DEVICE_STATUS)) {
                    return ((TT) instance.getDeviceStatus());
                } else {
                    if (field.equals(ModelTDevice.FI_DEVICE_IP)) {
                        return ((TT) instance.getDeviceIp());
                    } else {
                        if (field.equals(ModelTDevice.FI_DEVICE_PROC)) {
                            return ((TT) instance.getDeviceProc());
                        } else {
                            if (field.equals(ModelTDevice.FI_DEVICE_NAME)) {
                                return ((TT) instance.getDeviceName());
                            } else {
                                if (field.equals(ModelTDevice.FI_DEVICE_DESP)) {
                                    return ((TT) instance.getDeviceDesp());
                                } else {
                                    if (field.equals(ModelTDevice.FI_DEVICE_CREATE_TIME)) {
                                        return ((TT) instance.getDeviceCreateTime());
                                    } else {
                                        if (field.equals(ModelTDevice.FI_DEVICE_UPDATE_TIME)) {
                                            return ((TT) instance.getDeviceUpdateTime());
                                        } else {
                                            if (field.equals(ModelTDevice.FI_DEVICE_DELETE_FLAG)) {
                                                return ((TT) instance.getDeviceDeleteFlag());
                                            } else {
                                                if (field.equals(ModelTDevice.FI_DEVICE_TYPE)) {
                                                    return ((TT) instance.getDeviceType());
                                                } else {
                                                    if (field.equals(ModelTDevice.FI_DEVICE_REMARK)) {
                                                        return ((TT) instance.getDeviceRemark());
                                                    } else {
                                                        if (field.equals(ModelTDevice.FI_DEVICE_HARDWARE_ID)) {
                                                            return ((TT) instance.getDeviceHardwareId());
                                                        } else {
                                                            if (field.equals(ModelTDevice.FI_DEVICE_LAST_ORDER_PARAM)) {
                                                                return ((TT) instance.getDeviceLastOrderParam());
                                                            } else {
                                                                if (field.equals(ModelTDevice.FI_DEVICE_LAST_CHECK_TIME)) {
                                                                    return ((TT) instance.getDeviceLastCheckTime());
                                                                } else {
                                                                    if (field.equals(ModelTDevice.FI_DEVICE_ARIX_X)) {
                                                                        return ((TT) instance.getDeviceArixX());
                                                                    } else {
                                                                        if (field.equals(ModelTDevice.FI_DEVICE_ARIX_Y)) {
                                                                            return ((TT) instance.getDeviceArixY());
                                                                        } else {
                                                                            if (field.equals(ModelTDevice.FI_DEVICE_ARIX_Z)) {
                                                                                return ((TT) instance.getDeviceArixZ());
                                                                            } else {
                                                                                if (field.equals(ModelTDevice.FI_DEVICE_LAST_OCUPY_TIME)) {
                                                                                    return ((TT) instance.getDeviceLastOcupyTime());
                                                                                } else {
                                                                                    if (field.equals(ModelTDevice.FI_DEVICE_LAST_RELEASE_TIME)) {
                                                                                        return ((TT) instance.getDeviceLastReleaseTime());
                                                                                    } else {
                                                                                        if (field.equals(ModelTDevice.FI_DEVICE_TASK_ID)) {
                                                                                            return ((TT) instance.getDeviceTaskId());
                                                                                        } else {
                                                                                            if (field.equals(ModelTDevice.FI_DEVICE_LAST_PROC)) {
                                                                                                return ((TT) instance.getDeviceLastProc());
                                                                                            } else {
                                                                                                if (field.equals(ModelTDevice.FI_DEVICE_BATTERY)) {
                                                                                                    return ((TT) instance.getDeviceBattery());
                                                                                                } else {
                                                                                                    if (field.equals(ModelTDevice.FI_DEVICE_GOODS_HOLDER_NUM)) {
                                                                                                        return ((TT) instance.getDeviceGoodsHolderNum());
                                                                                                    } else {
                                                                                                        if (field.equals(ModelTDevice.FI_DEVICE_GROUP)) {
                                                                                                            return ((TT) instance.getDeviceGroup());
                                                                                                        } else {
                                                                                                            if (field.equals(ModelTDevice.FI_DEVICE_ATTACH_MAP_POINT)) {
                                                                                                                return ((TT) instance.getDeviceAttachMapPoint());
                                                                                                            } else {
                                                                                                                if (field.equals(ModelTDevice.FI_DEVICE_INDEX)) {
                                                                                                                    return ((TT) instance.getDeviceIndex());
                                                                                                                } else {
                                                                                                                    if (field.equals(ModelTDevice.FI_DEVICE_HANDLE_TASK)) {
                                                                                                                        return ((TT) instance.getDeviceHandleTask());
                                                                                                                    } else {
                                                                                                                        if (field.equals(ModelTDevice.FI_DEVICE_CONTROL_STATUS)) {
                                                                                                                            return ((TT) instance.getDeviceControlStatus());
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
                }
            }
        } catch (final Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public<TT> void setField(String field, ModelTDevice instance, TT value) {
        if (field.equals(ModelTDevice.FI_ID)) {
            try {
                instance.setId(mapToFieldId(value));
            } catch (final Exception ex) {
                ex.printStackTrace();
            }
        } else {
            if (field.equals(ModelTDevice.FI_DEVICE_STATUS)) {
                try {
                    instance.setDeviceStatus(mapToFieldDeviceStatus(value));
                } catch (final Exception ex) {
                    ex.printStackTrace();
                }
            } else {
                if (field.equals(ModelTDevice.FI_DEVICE_IP)) {
                    try {
                        instance.setDeviceIp(mapToFieldDeviceIp(value));
                    } catch (final Exception ex) {
                        ex.printStackTrace();
                    }
                } else {
                    if (field.equals(ModelTDevice.FI_DEVICE_PROC)) {
                        try {
                            instance.setDeviceProc(mapToFieldDeviceProc(value));
                        } catch (final Exception ex) {
                            ex.printStackTrace();
                        }
                    } else {
                        if (field.equals(ModelTDevice.FI_DEVICE_NAME)) {
                            try {
                                instance.setDeviceName(mapToFieldDeviceName(value));
                            } catch (final Exception ex) {
                                ex.printStackTrace();
                            }
                        } else {
                            if (field.equals(ModelTDevice.FI_DEVICE_DESP)) {
                                try {
                                    instance.setDeviceDesp(mapToFieldDeviceDesp(value));
                                } catch (final Exception ex) {
                                    ex.printStackTrace();
                                }
                            } else {
                                if (field.equals(ModelTDevice.FI_DEVICE_CREATE_TIME)) {
                                    try {
                                        instance.setDeviceCreateTime(mapToFieldDeviceCreateTime(value));
                                    } catch (final Exception ex) {
                                        ex.printStackTrace();
                                    }
                                } else {
                                    if (field.equals(ModelTDevice.FI_DEVICE_UPDATE_TIME)) {
                                        try {
                                            instance.setDeviceUpdateTime(mapToFieldDeviceUpdateTime(value));
                                        } catch (final Exception ex) {
                                            ex.printStackTrace();
                                        }
                                    } else {
                                        if (field.equals(ModelTDevice.FI_DEVICE_DELETE_FLAG)) {
                                            try {
                                                instance.setDeviceDeleteFlag(mapToFieldDeviceDeleteFlag(value));
                                            } catch (final Exception ex) {
                                                ex.printStackTrace();
                                            }
                                        } else {
                                            if (field.equals(ModelTDevice.FI_DEVICE_TYPE)) {
                                                try {
                                                    instance.setDeviceType(mapToFieldDeviceType(value));
                                                } catch (final Exception ex) {
                                                    ex.printStackTrace();
                                                }
                                            } else {
                                                if (field.equals(ModelTDevice.FI_DEVICE_REMARK)) {
                                                    try {
                                                        instance.setDeviceRemark(mapToFieldDeviceRemark(value));
                                                    } catch (final Exception ex) {
                                                        ex.printStackTrace();
                                                    }
                                                } else {
                                                    if (field.equals(ModelTDevice.FI_DEVICE_HARDWARE_ID)) {
                                                        try {
                                                            instance.setDeviceHardwareId(mapToFieldDeviceHardwareId(value));
                                                        } catch (final Exception ex) {
                                                            ex.printStackTrace();
                                                        }
                                                    } else {
                                                        if (field.equals(ModelTDevice.FI_DEVICE_LAST_ORDER_PARAM)) {
                                                            try {
                                                                instance.setDeviceLastOrderParam(mapToFieldDeviceLastOrderParam(value));
                                                            } catch (final Exception ex) {
                                                                ex.printStackTrace();
                                                            }
                                                        } else {
                                                            if (field.equals(ModelTDevice.FI_DEVICE_LAST_CHECK_TIME)) {
                                                                try {
                                                                    instance.setDeviceLastCheckTime(mapToFieldDeviceLastCheckTime(value));
                                                                } catch (final Exception ex) {
                                                                    ex.printStackTrace();
                                                                }
                                                            } else {
                                                                if (field.equals(ModelTDevice.FI_DEVICE_ARIX_X)) {
                                                                    try {
                                                                        instance.setDeviceArixX(mapToFieldDeviceArixX(value));
                                                                    } catch (final Exception ex) {
                                                                        ex.printStackTrace();
                                                                    }
                                                                } else {
                                                                    if (field.equals(ModelTDevice.FI_DEVICE_ARIX_Y)) {
                                                                        try {
                                                                            instance.setDeviceArixY(mapToFieldDeviceArixY(value));
                                                                        } catch (final Exception ex) {
                                                                            ex.printStackTrace();
                                                                        }
                                                                    } else {
                                                                        if (field.equals(ModelTDevice.FI_DEVICE_ARIX_Z)) {
                                                                            try {
                                                                                instance.setDeviceArixZ(mapToFieldDeviceArixZ(value));
                                                                            } catch (final Exception ex) {
                                                                                ex.printStackTrace();
                                                                            }
                                                                        } else {
                                                                            if (field.equals(ModelTDevice.FI_DEVICE_LAST_OCUPY_TIME)) {
                                                                                try {
                                                                                    instance.setDeviceLastOcupyTime(mapToFieldDeviceLastOcupyTime(value));
                                                                                } catch (final Exception ex) {
                                                                                    ex.printStackTrace();
                                                                                }
                                                                            } else {
                                                                                if (field.equals(ModelTDevice.FI_DEVICE_LAST_RELEASE_TIME)) {
                                                                                    try {
                                                                                        instance.setDeviceLastReleaseTime(mapToFieldDeviceLastReleaseTime(value));
                                                                                    } catch (final Exception ex) {
                                                                                        ex.printStackTrace();
                                                                                    }
                                                                                } else {
                                                                                    if (field.equals(ModelTDevice.FI_DEVICE_TASK_ID)) {
                                                                                        try {
                                                                                            instance.setDeviceTaskId(mapToFieldDeviceTaskId(value));
                                                                                        } catch (final Exception ex) {
                                                                                            ex.printStackTrace();
                                                                                        }
                                                                                    } else {
                                                                                        if (field.equals(ModelTDevice.FI_DEVICE_LAST_PROC)) {
                                                                                            try {
                                                                                                instance.setDeviceLastProc(mapToFieldDeviceLastProc(value));
                                                                                            } catch (final Exception ex) {
                                                                                                ex.printStackTrace();
                                                                                            }
                                                                                        } else {
                                                                                            if (field.equals(ModelTDevice.FI_DEVICE_BATTERY)) {
                                                                                                try {
                                                                                                    instance.setDeviceBattery(mapToFieldDeviceBattery(value));
                                                                                                } catch (final Exception ex) {
                                                                                                    ex.printStackTrace();
                                                                                                }
                                                                                            } else {
                                                                                                if (field.equals(ModelTDevice.FI_DEVICE_GOODS_HOLDER_NUM)) {
                                                                                                    try {
                                                                                                        instance.setDeviceGoodsHolderNum(mapToFieldDeviceGoodsHolderNum(value));
                                                                                                    } catch (final Exception ex) {
                                                                                                        ex.printStackTrace();
                                                                                                    }
                                                                                                } else {
                                                                                                    if (field.equals(ModelTDevice.FI_DEVICE_GROUP)) {
                                                                                                        try {
                                                                                                            instance.setDeviceGroup(mapToFieldDeviceGroup(value));
                                                                                                        } catch (final Exception ex) {
                                                                                                            ex.printStackTrace();
                                                                                                        }
                                                                                                    } else {
                                                                                                        if (field.equals(ModelTDevice.FI_DEVICE_ATTACH_MAP_POINT)) {
                                                                                                            try {
                                                                                                                instance.setDeviceAttachMapPoint(mapToFieldDeviceAttachMapPoint(value));
                                                                                                            } catch (final Exception ex) {
                                                                                                                ex.printStackTrace();
                                                                                                            }
                                                                                                        } else {
                                                                                                            if (field.equals(ModelTDevice.FI_DEVICE_INDEX)) {
                                                                                                                try {
                                                                                                                    instance.setDeviceIndex(mapToFieldDeviceIndex(value));
                                                                                                                } catch (final Exception ex) {
                                                                                                                    ex.printStackTrace();
                                                                                                                }
                                                                                                            } else {
                                                                                                                if (field.equals(ModelTDevice.FI_DEVICE_HANDLE_TASK)) {
                                                                                                                    try {
                                                                                                                        instance.setDeviceHandleTask(mapToFieldDeviceHandleTask(value));
                                                                                                                    } catch (final Exception ex) {
                                                                                                                        ex.printStackTrace();
                                                                                                                    }
                                                                                                                } else {
                                                                                                                    if (field.equals(ModelTDevice.FI_DEVICE_CONTROL_STATUS)) {
                                                                                                                        try {
                                                                                                                            instance.setDeviceControlStatus(mapToFieldDeviceControlStatus(value));
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
                    }
                }
            }
        }
    }

    public void setField(String field, ModelTDevice instance, byte[] value) {
        if (field.equals(ModelTDevice.FI_ID)) {
            instance.setId(mapToFieldId(value));
        } else {
            if (field.equals(ModelTDevice.FI_DEVICE_STATUS)) {
                instance.setDeviceStatus(mapToFieldDeviceStatus(value));
            } else {
                if (field.equals(ModelTDevice.FI_DEVICE_IP)) {
                    instance.setDeviceIp(mapToFieldDeviceIp(value));
                } else {
                    if (field.equals(ModelTDevice.FI_DEVICE_PROC)) {
                        instance.setDeviceProc(mapToFieldDeviceProc(value));
                    } else {
                        if (field.equals(ModelTDevice.FI_DEVICE_NAME)) {
                            instance.setDeviceName(mapToFieldDeviceName(value));
                        } else {
                            if (field.equals(ModelTDevice.FI_DEVICE_DESP)) {
                                instance.setDeviceDesp(mapToFieldDeviceDesp(value));
                            } else {
                                if (field.equals(ModelTDevice.FI_DEVICE_CREATE_TIME)) {
                                    instance.setDeviceCreateTime(mapToFieldDeviceCreateTime(value));
                                } else {
                                    if (field.equals(ModelTDevice.FI_DEVICE_UPDATE_TIME)) {
                                        instance.setDeviceUpdateTime(mapToFieldDeviceUpdateTime(value));
                                    } else {
                                        if (field.equals(ModelTDevice.FI_DEVICE_DELETE_FLAG)) {
                                            instance.setDeviceDeleteFlag(mapToFieldDeviceDeleteFlag(value));
                                        } else {
                                            if (field.equals(ModelTDevice.FI_DEVICE_TYPE)) {
                                                instance.setDeviceType(mapToFieldDeviceType(value));
                                            } else {
                                                if (field.equals(ModelTDevice.FI_DEVICE_REMARK)) {
                                                    instance.setDeviceRemark(mapToFieldDeviceRemark(value));
                                                } else {
                                                    if (field.equals(ModelTDevice.FI_DEVICE_HARDWARE_ID)) {
                                                        instance.setDeviceHardwareId(mapToFieldDeviceHardwareId(value));
                                                    } else {
                                                        if (field.equals(ModelTDevice.FI_DEVICE_LAST_ORDER_PARAM)) {
                                                            instance.setDeviceLastOrderParam(mapToFieldDeviceLastOrderParam(value));
                                                        } else {
                                                            if (field.equals(ModelTDevice.FI_DEVICE_LAST_CHECK_TIME)) {
                                                                instance.setDeviceLastCheckTime(mapToFieldDeviceLastCheckTime(value));
                                                            } else {
                                                                if (field.equals(ModelTDevice.FI_DEVICE_ARIX_X)) {
                                                                    instance.setDeviceArixX(mapToFieldDeviceArixX(value));
                                                                } else {
                                                                    if (field.equals(ModelTDevice.FI_DEVICE_ARIX_Y)) {
                                                                        instance.setDeviceArixY(mapToFieldDeviceArixY(value));
                                                                    } else {
                                                                        if (field.equals(ModelTDevice.FI_DEVICE_ARIX_Z)) {
                                                                            instance.setDeviceArixZ(mapToFieldDeviceArixZ(value));
                                                                        } else {
                                                                            if (field.equals(ModelTDevice.FI_DEVICE_LAST_OCUPY_TIME)) {
                                                                                instance.setDeviceLastOcupyTime(mapToFieldDeviceLastOcupyTime(value));
                                                                            } else {
                                                                                if (field.equals(ModelTDevice.FI_DEVICE_LAST_RELEASE_TIME)) {
                                                                                    instance.setDeviceLastReleaseTime(mapToFieldDeviceLastReleaseTime(value));
                                                                                } else {
                                                                                    if (field.equals(ModelTDevice.FI_DEVICE_TASK_ID)) {
                                                                                        instance.setDeviceTaskId(mapToFieldDeviceTaskId(value));
                                                                                    } else {
                                                                                        if (field.equals(ModelTDevice.FI_DEVICE_LAST_PROC)) {
                                                                                            instance.setDeviceLastProc(mapToFieldDeviceLastProc(value));
                                                                                        } else {
                                                                                            if (field.equals(ModelTDevice.FI_DEVICE_BATTERY)) {
                                                                                                instance.setDeviceBattery(mapToFieldDeviceBattery(value));
                                                                                            } else {
                                                                                                if (field.equals(ModelTDevice.FI_DEVICE_GOODS_HOLDER_NUM)) {
                                                                                                    instance.setDeviceGoodsHolderNum(mapToFieldDeviceGoodsHolderNum(value));
                                                                                                } else {
                                                                                                    if (field.equals(ModelTDevice.FI_DEVICE_GROUP)) {
                                                                                                        instance.setDeviceGroup(mapToFieldDeviceGroup(value));
                                                                                                    } else {
                                                                                                        if (field.equals(ModelTDevice.FI_DEVICE_ATTACH_MAP_POINT)) {
                                                                                                            instance.setDeviceAttachMapPoint(mapToFieldDeviceAttachMapPoint(value));
                                                                                                        } else {
                                                                                                            if (field.equals(ModelTDevice.FI_DEVICE_INDEX)) {
                                                                                                                instance.setDeviceIndex(mapToFieldDeviceIndex(value));
                                                                                                            } else {
                                                                                                                if (field.equals(ModelTDevice.FI_DEVICE_HANDLE_TASK)) {
                                                                                                                    instance.setDeviceHandleTask(mapToFieldDeviceHandleTask(value));
                                                                                                                } else {
                                                                                                                    if (field.equals(ModelTDevice.FI_DEVICE_CONTROL_STATUS)) {
                                                                                                                        instance.setDeviceControlStatus(mapToFieldDeviceControlStatus(value));
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
            }
        }
    }
}
