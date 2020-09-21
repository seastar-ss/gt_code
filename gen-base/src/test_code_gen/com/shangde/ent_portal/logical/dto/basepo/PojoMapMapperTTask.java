package com.shangde.ent_portal.logical.dto.basepo;

import java.util.Date;
import java.util.Map;
import java.util.Set;
import com.shangde.ent_portal.logical.dto.enums.EnumTaskStatus;
import com.shangde.ent_portal.logical.dto.enums.EnumTaskType;
import com.shawn.ss.lib.tools.CollectionHelper;
import com.shawn.ss.lib.tools.TypeConstantHelper;
import com.shawn.ss.lib.tools.db.api.interfaces.mappers.db.CommonMapMapper;

public class PojoMapMapperTTask
    implements CommonMapMapper<ModelTTask>
{

    @Override
    public ModelTTask fromMap(Map<byte[], byte[]> map) {
        ModelTTask instance = new ModelTTask();
        Set<Map.Entry<byte[], byte[]>> entries = map.entrySet();
        for (Map.Entry<byte[], byte[]> entry: entries) {
            String field = new String(entry.getKey());
            if (field.equals(ModelTTask.FI_ID)) {
                instance.setId(mapToFieldId(entry.getValue()));
            } else {
                if (field.equals(ModelTTask.FI_TASK_CREATE_TIME)) {
                    instance.setTaskCreateTime(mapToFieldTaskCreateTime(entry.getValue()));
                } else {
                    if (field.equals(ModelTTask.FI_TASK_EXPECTED_START_TIME)) {
                        instance.setTaskExpectedStartTime(mapToFieldTaskExpectedStartTime(entry.getValue()));
                    } else {
                        if (field.equals(ModelTTask.FI_TASK_START_TIME)) {
                            instance.setTaskStartTime(mapToFieldTaskStartTime(entry.getValue()));
                        } else {
                            if (field.equals(ModelTTask.FI_TASK_FINISH_TIME)) {
                                instance.setTaskFinishTime(mapToFieldTaskFinishTime(entry.getValue()));
                            } else {
                                if (field.equals(ModelTTask.FI_TASK_REMARK)) {
                                    instance.setTaskRemark(mapToFieldTaskRemark(entry.getValue()));
                                } else {
                                    if (field.equals(ModelTTask.FI_TASK_ORDER_ID)) {
                                        instance.setTaskOrderId(mapToFieldTaskOrderId(entry.getValue()));
                                    } else {
                                        if (field.equals(ModelTTask.FI_TASK_PARAM)) {
                                            instance.setTaskParam(mapToFieldTaskParam(entry.getValue()));
                                        } else {
                                            if (field.equals(ModelTTask.FI_TASK_STATUS)) {
                                                instance.setTaskStatus(mapToFieldTaskStatus(entry.getValue()));
                                            } else {
                                                if (field.equals(ModelTTask.FI_TASK_TOTAL_PATH)) {
                                                    instance.setTaskTotalPath(mapToFieldTaskTotalPath(entry.getValue()));
                                                } else {
                                                    if (field.equals(ModelTTask.FI_TASK_CURRENT_PATH_ID)) {
                                                        instance.setTaskCurrentPathId(mapToFieldTaskCurrentPathId(entry.getValue()));
                                                    } else {
                                                        if (field.equals(ModelTTask.FI_TASK_CURRENT_PATH_INDEX)) {
                                                            instance.setTaskCurrentPathIndex(mapToFieldTaskCurrentPathIndex(entry.getValue()));
                                                        } else {
                                                            if (field.equals(ModelTTask.FI_ARIX_X)) {
                                                                instance.setArixX(mapToFieldArixX(entry.getValue()));
                                                            } else {
                                                                if (field.equals(ModelTTask.FI_ARIX_Y)) {
                                                                    instance.setArixY(mapToFieldArixY(entry.getValue()));
                                                                } else {
                                                                    if (field.equals(ModelTTask.FI_ARIX_Z)) {
                                                                        instance.setArixZ(mapToFieldArixZ(entry.getValue()));
                                                                    } else {
                                                                        if (field.equals(ModelTTask.FI_POINT_INDEX)) {
                                                                            instance.setPointIndex(mapToFieldPointIndex(entry.getValue()));
                                                                        } else {
                                                                            if (field.equals(ModelTTask.FI_GOODS_ID)) {
                                                                                instance.setGoodsId(mapToFieldGoodsId(entry.getValue()));
                                                                            } else {
                                                                                if (field.equals(ModelTTask.FI_GOODS_INFO)) {
                                                                                    instance.setGoodsInfo(mapToFieldGoodsInfo(entry.getValue()));
                                                                                } else {
                                                                                    if (field.equals(ModelTTask.FI_GOODS_NAME)) {
                                                                                        instance.setGoodsName(mapToFieldGoodsName(entry.getValue()));
                                                                                    } else {
                                                                                        if (field.equals(ModelTTask.FI_GOODS_WEIGHT)) {
                                                                                            instance.setGoodsWeight(mapToFieldGoodsWeight(entry.getValue()));
                                                                                        } else {
                                                                                            if (field.equals(ModelTTask.FI_ORIGIN_ARIX_X)) {
                                                                                                instance.setOriginArixX(mapToFieldOriginArixX(entry.getValue()));
                                                                                            } else {
                                                                                                if (field.equals(ModelTTask.FI_ORIGIN_ARIX_Y)) {
                                                                                                    instance.setOriginArixY(mapToFieldOriginArixY(entry.getValue()));
                                                                                                } else {
                                                                                                    if (field.equals(ModelTTask.FI_ORIGIN_ARIX_Z)) {
                                                                                                        instance.setOriginArixZ(mapToFieldOriginArixZ(entry.getValue()));
                                                                                                    } else {
                                                                                                        if (field.equals(ModelTTask.FI_ORIGIN_POINT_INDEX)) {
                                                                                                            instance.setOriginPointIndex(mapToFieldOriginPointIndex(entry.getValue()));
                                                                                                        } else {
                                                                                                            if (field.equals(ModelTTask.FI_TASK_DEPENDS_ON)) {
                                                                                                                instance.setTaskDependsOn(mapToFieldTaskDependsOn(entry.getValue()));
                                                                                                            } else {
                                                                                                                if (field.equals(ModelTTask.FI_TASK_PARENT_ID)) {
                                                                                                                    instance.setTaskParentId(mapToFieldTaskParentId(entry.getValue()));
                                                                                                                } else {
                                                                                                                    if (field.equals(ModelTTask.FI_TASK_GROUP_ID)) {
                                                                                                                        instance.setTaskGroupId(mapToFieldTaskGroupId(entry.getValue()));
                                                                                                                    } else {
                                                                                                                        if (field.equals(ModelTTask.FI_TASK_TYPE)) {
                                                                                                                            instance.setTaskType(mapToFieldTaskType(entry.getValue()));
                                                                                                                        } else {
                                                                                                                            if (field.equals(ModelTTask.FI_TASK_APPOINTED_DEVICE)) {
                                                                                                                                instance.setTaskAppointedDevice(mapToFieldTaskAppointedDevice(entry.getValue()));
                                                                                                                            } else {
                                                                                                                                if (field.equals(ModelTTask.FI_TASK_PRIORITY)) {
                                                                                                                                    instance.setTaskPriority(mapToFieldTaskPriority(entry.getValue()));
                                                                                                                                } else {
                                                                                                                                    if (field.equals(ModelTTask.FI_RETRY_TIMES)) {
                                                                                                                                        instance.setRetryTimes(mapToFieldRetryTimes(entry.getValue()));
                                                                                                                                    } else {
                                                                                                                                        if (field.equals(ModelTTask.FI_CURRENT_ARIX_X)) {
                                                                                                                                            instance.setCurrentArixX(mapToFieldCurrentArixX(entry.getValue()));
                                                                                                                                        } else {
                                                                                                                                            if (field.equals(ModelTTask.FI_CURRENT_ARIX_Y)) {
                                                                                                                                                instance.setCurrentArixY(mapToFieldCurrentArixY(entry.getValue()));
                                                                                                                                            } else {
                                                                                                                                                if (field.equals(ModelTTask.FI_CURRENT_ARIX_Z)) {
                                                                                                                                                    instance.setCurrentArixZ(mapToFieldCurrentArixZ(entry.getValue()));
                                                                                                                                                } else {
                                                                                                                                                    if (field.equals(ModelTTask.FI_CURRENT_POINT_INDEX)) {
                                                                                                                                                        instance.setCurrentPointIndex(mapToFieldCurrentPointIndex(entry.getValue()));
                                                                                                                                                    } else {
                                                                                                                                                        if (field.equals(ModelTTask.FI_CURRENT_WAITING_DEVICE)) {
                                                                                                                                                            instance.setCurrentWaitingDevice(mapToFieldCurrentWaitingDevice(entry.getValue()));
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

    protected Date mapToFieldTaskCreateTime(byte[] bytes) {
        return TypeConstantHelper.toObject(bytes, Date.class);
    }

    protected Date mapToFieldTaskExpectedStartTime(byte[] bytes) {
        return TypeConstantHelper.toObject(bytes, Date.class);
    }

    protected Date mapToFieldTaskStartTime(byte[] bytes) {
        return TypeConstantHelper.toObject(bytes, Date.class);
    }

    protected Date mapToFieldTaskFinishTime(byte[] bytes) {
        return TypeConstantHelper.toObject(bytes, Date.class);
    }

    protected String mapToFieldTaskRemark(byte[] bytes) {
        return TypeConstantHelper.toObject(bytes, String.class);
    }

    protected Integer mapToFieldTaskOrderId(byte[] bytes) {
        return TypeConstantHelper.toObject(bytes, Integer.class);
    }

    protected String mapToFieldTaskParam(byte[] bytes) {
        return TypeConstantHelper.toObject(bytes, String.class);
    }

    protected EnumTaskStatus mapToFieldTaskStatus(byte[] bytes) {
        return EnumTaskStatus.fromValue(TypeConstantHelper.toObject(bytes, Byte.class));
    }

    protected Short mapToFieldTaskTotalPath(byte[] bytes) {
        return TypeConstantHelper.toObject(bytes, Short.class);
    }

    protected Integer mapToFieldTaskCurrentPathId(byte[] bytes) {
        return TypeConstantHelper.toObject(bytes, Integer.class);
    }

    protected Short mapToFieldTaskCurrentPathIndex(byte[] bytes) {
        return TypeConstantHelper.toObject(bytes, Short.class);
    }

    protected Integer mapToFieldArixX(byte[] bytes) {
        return TypeConstantHelper.toObject(bytes, Integer.class);
    }

    protected Integer mapToFieldArixY(byte[] bytes) {
        return TypeConstantHelper.toObject(bytes, Integer.class);
    }

    protected Integer mapToFieldArixZ(byte[] bytes) {
        return TypeConstantHelper.toObject(bytes, Integer.class);
    }

    protected Integer mapToFieldPointIndex(byte[] bytes) {
        return TypeConstantHelper.toObject(bytes, Integer.class);
    }

    protected String mapToFieldGoodsId(byte[] bytes) {
        return TypeConstantHelper.toObject(bytes, String.class);
    }

    protected String mapToFieldGoodsInfo(byte[] bytes) {
        return TypeConstantHelper.toObject(bytes, String.class);
    }

    protected String mapToFieldGoodsName(byte[] bytes) {
        return TypeConstantHelper.toObject(bytes, String.class);
    }

    protected Integer mapToFieldGoodsWeight(byte[] bytes) {
        return TypeConstantHelper.toObject(bytes, Integer.class);
    }

    protected Integer mapToFieldOriginArixX(byte[] bytes) {
        return TypeConstantHelper.toObject(bytes, Integer.class);
    }

    protected Integer mapToFieldOriginArixY(byte[] bytes) {
        return TypeConstantHelper.toObject(bytes, Integer.class);
    }

    protected Integer mapToFieldOriginArixZ(byte[] bytes) {
        return TypeConstantHelper.toObject(bytes, Integer.class);
    }

    protected Integer mapToFieldOriginPointIndex(byte[] bytes) {
        return TypeConstantHelper.toObject(bytes, Integer.class);
    }

    protected Integer mapToFieldTaskDependsOn(byte[] bytes) {
        return TypeConstantHelper.toObject(bytes, Integer.class);
    }

    protected Integer mapToFieldTaskParentId(byte[] bytes) {
        return TypeConstantHelper.toObject(bytes, Integer.class);
    }

    protected Integer mapToFieldTaskGroupId(byte[] bytes) {
        return TypeConstantHelper.toObject(bytes, Integer.class);
    }

    protected EnumTaskType mapToFieldTaskType(byte[] bytes) {
        return EnumTaskType.fromValue(TypeConstantHelper.toObject(bytes, Byte.class));
    }

    protected Integer mapToFieldTaskAppointedDevice(byte[] bytes) {
        return TypeConstantHelper.toObject(bytes, Integer.class);
    }

    protected Integer mapToFieldTaskPriority(byte[] bytes) {
        return TypeConstantHelper.toObject(bytes, Integer.class);
    }

    protected Integer mapToFieldRetryTimes(byte[] bytes) {
        return TypeConstantHelper.toObject(bytes, Integer.class);
    }

    protected Integer mapToFieldCurrentArixX(byte[] bytes) {
        return TypeConstantHelper.toObject(bytes, Integer.class);
    }

    protected Integer mapToFieldCurrentArixY(byte[] bytes) {
        return TypeConstantHelper.toObject(bytes, Integer.class);
    }

    protected Integer mapToFieldCurrentArixZ(byte[] bytes) {
        return TypeConstantHelper.toObject(bytes, Integer.class);
    }

    protected Integer mapToFieldCurrentPointIndex(byte[] bytes) {
        return TypeConstantHelper.toObject(bytes, Integer.class);
    }

    protected Integer mapToFieldCurrentWaitingDevice(byte[] bytes) {
        return TypeConstantHelper.toObject(bytes, Integer.class);
    }

    @Override
    public Map<byte[], byte[]> toMap(ModelTTask instance) {
        Map<byte[], byte[]> ret = CollectionHelper.newMap();
        if (instance == null) {
            return ret;
        }
        byte[] valueId = mapFromFieldId(instance.getId());
        ret.put(ModelTTask.FI_ID.getBytes(), valueId);
        byte[] valueTask_create_time = mapFromFieldTaskCreateTime(instance.getTaskCreateTime());
        ret.put(ModelTTask.FI_TASK_CREATE_TIME.getBytes(), valueTask_create_time);
        byte[] valueTask_expected_start_time = mapFromFieldTaskExpectedStartTime(instance.getTaskExpectedStartTime());
        ret.put(ModelTTask.FI_TASK_EXPECTED_START_TIME.getBytes(), valueTask_expected_start_time);
        byte[] valueTask_start_time = mapFromFieldTaskStartTime(instance.getTaskStartTime());
        ret.put(ModelTTask.FI_TASK_START_TIME.getBytes(), valueTask_start_time);
        byte[] valueTask_finish_time = mapFromFieldTaskFinishTime(instance.getTaskFinishTime());
        ret.put(ModelTTask.FI_TASK_FINISH_TIME.getBytes(), valueTask_finish_time);
        byte[] valueTask_remark = mapFromFieldTaskRemark(instance.getTaskRemark());
        ret.put(ModelTTask.FI_TASK_REMARK.getBytes(), valueTask_remark);
        byte[] valueTask_order_id = mapFromFieldTaskOrderId(instance.getTaskOrderId());
        ret.put(ModelTTask.FI_TASK_ORDER_ID.getBytes(), valueTask_order_id);
        byte[] valueTask_param = mapFromFieldTaskParam(instance.getTaskParam());
        ret.put(ModelTTask.FI_TASK_PARAM.getBytes(), valueTask_param);
        byte[] valueTask_status = mapFromFieldTaskStatus(instance.getTaskStatus());
        ret.put(ModelTTask.FI_TASK_STATUS.getBytes(), valueTask_status);
        byte[] valueTask_total_path = mapFromFieldTaskTotalPath(instance.getTaskTotalPath());
        ret.put(ModelTTask.FI_TASK_TOTAL_PATH.getBytes(), valueTask_total_path);
        byte[] valueTask_current_path_id = mapFromFieldTaskCurrentPathId(instance.getTaskCurrentPathId());
        ret.put(ModelTTask.FI_TASK_CURRENT_PATH_ID.getBytes(), valueTask_current_path_id);
        byte[] valueTask_current_path_index = mapFromFieldTaskCurrentPathIndex(instance.getTaskCurrentPathIndex());
        ret.put(ModelTTask.FI_TASK_CURRENT_PATH_INDEX.getBytes(), valueTask_current_path_index);
        byte[] valueArix_x = mapFromFieldArixX(instance.getArixX());
        ret.put(ModelTTask.FI_ARIX_X.getBytes(), valueArix_x);
        byte[] valueArix_y = mapFromFieldArixY(instance.getArixY());
        ret.put(ModelTTask.FI_ARIX_Y.getBytes(), valueArix_y);
        byte[] valueArix_z = mapFromFieldArixZ(instance.getArixZ());
        ret.put(ModelTTask.FI_ARIX_Z.getBytes(), valueArix_z);
        byte[] valuePoint_index = mapFromFieldPointIndex(instance.getPointIndex());
        ret.put(ModelTTask.FI_POINT_INDEX.getBytes(), valuePoint_index);
        byte[] valueGoods_id = mapFromFieldGoodsId(instance.getGoodsId());
        ret.put(ModelTTask.FI_GOODS_ID.getBytes(), valueGoods_id);
        byte[] valueGoods_info = mapFromFieldGoodsInfo(instance.getGoodsInfo());
        ret.put(ModelTTask.FI_GOODS_INFO.getBytes(), valueGoods_info);
        byte[] valueGoods_name = mapFromFieldGoodsName(instance.getGoodsName());
        ret.put(ModelTTask.FI_GOODS_NAME.getBytes(), valueGoods_name);
        byte[] valueGoods_weight = mapFromFieldGoodsWeight(instance.getGoodsWeight());
        ret.put(ModelTTask.FI_GOODS_WEIGHT.getBytes(), valueGoods_weight);
        byte[] valueOrigin_arix_x = mapFromFieldOriginArixX(instance.getOriginArixX());
        ret.put(ModelTTask.FI_ORIGIN_ARIX_X.getBytes(), valueOrigin_arix_x);
        byte[] valueOrigin_arix_y = mapFromFieldOriginArixY(instance.getOriginArixY());
        ret.put(ModelTTask.FI_ORIGIN_ARIX_Y.getBytes(), valueOrigin_arix_y);
        byte[] valueOrigin_arix_z = mapFromFieldOriginArixZ(instance.getOriginArixZ());
        ret.put(ModelTTask.FI_ORIGIN_ARIX_Z.getBytes(), valueOrigin_arix_z);
        byte[] valueOrigin_point_index = mapFromFieldOriginPointIndex(instance.getOriginPointIndex());
        ret.put(ModelTTask.FI_ORIGIN_POINT_INDEX.getBytes(), valueOrigin_point_index);
        byte[] valueTask_depends_on = mapFromFieldTaskDependsOn(instance.getTaskDependsOn());
        ret.put(ModelTTask.FI_TASK_DEPENDS_ON.getBytes(), valueTask_depends_on);
        byte[] valueTask_parent_id = mapFromFieldTaskParentId(instance.getTaskParentId());
        ret.put(ModelTTask.FI_TASK_PARENT_ID.getBytes(), valueTask_parent_id);
        byte[] valueTask_group_id = mapFromFieldTaskGroupId(instance.getTaskGroupId());
        ret.put(ModelTTask.FI_TASK_GROUP_ID.getBytes(), valueTask_group_id);
        byte[] valueTask_type = mapFromFieldTaskType(instance.getTaskType());
        ret.put(ModelTTask.FI_TASK_TYPE.getBytes(), valueTask_type);
        byte[] valueTask_appointed_device = mapFromFieldTaskAppointedDevice(instance.getTaskAppointedDevice());
        ret.put(ModelTTask.FI_TASK_APPOINTED_DEVICE.getBytes(), valueTask_appointed_device);
        byte[] valueTask_priority = mapFromFieldTaskPriority(instance.getTaskPriority());
        ret.put(ModelTTask.FI_TASK_PRIORITY.getBytes(), valueTask_priority);
        byte[] valueRetry_times = mapFromFieldRetryTimes(instance.getRetryTimes());
        ret.put(ModelTTask.FI_RETRY_TIMES.getBytes(), valueRetry_times);
        byte[] valueCurrent_arix_x = mapFromFieldCurrentArixX(instance.getCurrentArixX());
        ret.put(ModelTTask.FI_CURRENT_ARIX_X.getBytes(), valueCurrent_arix_x);
        byte[] valueCurrent_arix_y = mapFromFieldCurrentArixY(instance.getCurrentArixY());
        ret.put(ModelTTask.FI_CURRENT_ARIX_Y.getBytes(), valueCurrent_arix_y);
        byte[] valueCurrent_arix_z = mapFromFieldCurrentArixZ(instance.getCurrentArixZ());
        ret.put(ModelTTask.FI_CURRENT_ARIX_Z.getBytes(), valueCurrent_arix_z);
        byte[] valueCurrent_point_index = mapFromFieldCurrentPointIndex(instance.getCurrentPointIndex());
        ret.put(ModelTTask.FI_CURRENT_POINT_INDEX.getBytes(), valueCurrent_point_index);
        byte[] valueCurrent_waiting_device = mapFromFieldCurrentWaitingDevice(instance.getCurrentWaitingDevice());
        ret.put(ModelTTask.FI_CURRENT_WAITING_DEVICE.getBytes(), valueCurrent_waiting_device);
        return ret;
    }

    protected byte[] mapFromFieldId(Integer field) {
        byte[] ret = TypeConstantHelper.fromObjectBin(field);
        return ret;
    }

    protected byte[] mapFromFieldTaskCreateTime(Date field) {
        byte[] ret = TypeConstantHelper.fromObjectBin(field);
        return ret;
    }

    protected byte[] mapFromFieldTaskExpectedStartTime(Date field) {
        byte[] ret = TypeConstantHelper.fromObjectBin(field);
        return ret;
    }

    protected byte[] mapFromFieldTaskStartTime(Date field) {
        byte[] ret = TypeConstantHelper.fromObjectBin(field);
        return ret;
    }

    protected byte[] mapFromFieldTaskFinishTime(Date field) {
        byte[] ret = TypeConstantHelper.fromObjectBin(field);
        return ret;
    }

    protected byte[] mapFromFieldTaskRemark(String field) {
        byte[] ret = TypeConstantHelper.fromObjectBin(field);
        return ret;
    }

    protected byte[] mapFromFieldTaskOrderId(Integer field) {
        byte[] ret = TypeConstantHelper.fromObjectBin(field);
        return ret;
    }

    protected byte[] mapFromFieldTaskParam(String field) {
        byte[] ret = TypeConstantHelper.fromObjectBin(field);
        return ret;
    }

    protected byte[] mapFromFieldTaskStatus(EnumTaskStatus field) {
        byte[] ret = TypeConstantHelper.fromObjectBin(field.val);
        return ret;
    }

    protected byte[] mapFromFieldTaskTotalPath(Short field) {
        byte[] ret = TypeConstantHelper.fromObjectBin(field);
        return ret;
    }

    protected byte[] mapFromFieldTaskCurrentPathId(Integer field) {
        byte[] ret = TypeConstantHelper.fromObjectBin(field);
        return ret;
    }

    protected byte[] mapFromFieldTaskCurrentPathIndex(Short field) {
        byte[] ret = TypeConstantHelper.fromObjectBin(field);
        return ret;
    }

    protected byte[] mapFromFieldArixX(Integer field) {
        byte[] ret = TypeConstantHelper.fromObjectBin(field);
        return ret;
    }

    protected byte[] mapFromFieldArixY(Integer field) {
        byte[] ret = TypeConstantHelper.fromObjectBin(field);
        return ret;
    }

    protected byte[] mapFromFieldArixZ(Integer field) {
        byte[] ret = TypeConstantHelper.fromObjectBin(field);
        return ret;
    }

    protected byte[] mapFromFieldPointIndex(Integer field) {
        byte[] ret = TypeConstantHelper.fromObjectBin(field);
        return ret;
    }

    protected byte[] mapFromFieldGoodsId(String field) {
        byte[] ret = TypeConstantHelper.fromObjectBin(field);
        return ret;
    }

    protected byte[] mapFromFieldGoodsInfo(String field) {
        byte[] ret = TypeConstantHelper.fromObjectBin(field);
        return ret;
    }

    protected byte[] mapFromFieldGoodsName(String field) {
        byte[] ret = TypeConstantHelper.fromObjectBin(field);
        return ret;
    }

    protected byte[] mapFromFieldGoodsWeight(Integer field) {
        byte[] ret = TypeConstantHelper.fromObjectBin(field);
        return ret;
    }

    protected byte[] mapFromFieldOriginArixX(Integer field) {
        byte[] ret = TypeConstantHelper.fromObjectBin(field);
        return ret;
    }

    protected byte[] mapFromFieldOriginArixY(Integer field) {
        byte[] ret = TypeConstantHelper.fromObjectBin(field);
        return ret;
    }

    protected byte[] mapFromFieldOriginArixZ(Integer field) {
        byte[] ret = TypeConstantHelper.fromObjectBin(field);
        return ret;
    }

    protected byte[] mapFromFieldOriginPointIndex(Integer field) {
        byte[] ret = TypeConstantHelper.fromObjectBin(field);
        return ret;
    }

    protected byte[] mapFromFieldTaskDependsOn(Integer field) {
        byte[] ret = TypeConstantHelper.fromObjectBin(field);
        return ret;
    }

    protected byte[] mapFromFieldTaskParentId(Integer field) {
        byte[] ret = TypeConstantHelper.fromObjectBin(field);
        return ret;
    }

    protected byte[] mapFromFieldTaskGroupId(Integer field) {
        byte[] ret = TypeConstantHelper.fromObjectBin(field);
        return ret;
    }

    protected byte[] mapFromFieldTaskType(EnumTaskType field) {
        byte[] ret = TypeConstantHelper.fromObjectBin(field.val);
        return ret;
    }

    protected byte[] mapFromFieldTaskAppointedDevice(Integer field) {
        byte[] ret = TypeConstantHelper.fromObjectBin(field);
        return ret;
    }

    protected byte[] mapFromFieldTaskPriority(Integer field) {
        byte[] ret = TypeConstantHelper.fromObjectBin(field);
        return ret;
    }

    protected byte[] mapFromFieldRetryTimes(Integer field) {
        byte[] ret = TypeConstantHelper.fromObjectBin(field);
        return ret;
    }

    protected byte[] mapFromFieldCurrentArixX(Integer field) {
        byte[] ret = TypeConstantHelper.fromObjectBin(field);
        return ret;
    }

    protected byte[] mapFromFieldCurrentArixY(Integer field) {
        byte[] ret = TypeConstantHelper.fromObjectBin(field);
        return ret;
    }

    protected byte[] mapFromFieldCurrentArixZ(Integer field) {
        byte[] ret = TypeConstantHelper.fromObjectBin(field);
        return ret;
    }

    protected byte[] mapFromFieldCurrentPointIndex(Integer field) {
        byte[] ret = TypeConstantHelper.fromObjectBin(field);
        return ret;
    }

    protected byte[] mapFromFieldCurrentWaitingDevice(Integer field) {
        byte[] ret = TypeConstantHelper.fromObjectBin(field);
        return ret;
    }

    @Override
    public Map<String, Object> toCommonMap(ModelTTask instance) {
        Map<String, Object> ret = CollectionHelper.newMap();
        if (instance == null) {
            return ret;
        }
        Integer dId = instance.getId();
        if (dId!= null) {
            ret.put(ModelTTask.FI_ID, dId);
        }
        Date dTask_create_time = instance.getTaskCreateTime();
        if (dTask_create_time!= null) {
            ret.put(ModelTTask.FI_TASK_CREATE_TIME, dTask_create_time);
        }
        Date dTask_expected_start_time = instance.getTaskExpectedStartTime();
        if (dTask_expected_start_time!= null) {
            ret.put(ModelTTask.FI_TASK_EXPECTED_START_TIME, dTask_expected_start_time);
        }
        Date dTask_start_time = instance.getTaskStartTime();
        if (dTask_start_time!= null) {
            ret.put(ModelTTask.FI_TASK_START_TIME, dTask_start_time);
        }
        Date dTask_finish_time = instance.getTaskFinishTime();
        if (dTask_finish_time!= null) {
            ret.put(ModelTTask.FI_TASK_FINISH_TIME, dTask_finish_time);
        }
        String dTask_remark = instance.getTaskRemark();
        if (dTask_remark!= null) {
            ret.put(ModelTTask.FI_TASK_REMARK, dTask_remark);
        }
        Integer dTask_order_id = instance.getTaskOrderId();
        if (dTask_order_id!= null) {
            ret.put(ModelTTask.FI_TASK_ORDER_ID, dTask_order_id);
        }
        String dTask_param = instance.getTaskParam();
        if (dTask_param!= null) {
            ret.put(ModelTTask.FI_TASK_PARAM, dTask_param);
        }
        EnumTaskStatus dTask_status = instance.getTaskStatus();
        if (dTask_status!= null) {
            ret.put(ModelTTask.FI_TASK_STATUS, dTask_status.val);
        }
        Short dTask_total_path = instance.getTaskTotalPath();
        if (dTask_total_path!= null) {
            ret.put(ModelTTask.FI_TASK_TOTAL_PATH, dTask_total_path);
        }
        Integer dTask_current_path_id = instance.getTaskCurrentPathId();
        if (dTask_current_path_id!= null) {
            ret.put(ModelTTask.FI_TASK_CURRENT_PATH_ID, dTask_current_path_id);
        }
        Short dTask_current_path_index = instance.getTaskCurrentPathIndex();
        if (dTask_current_path_index!= null) {
            ret.put(ModelTTask.FI_TASK_CURRENT_PATH_INDEX, dTask_current_path_index);
        }
        Integer dArix_x = instance.getArixX();
        if (dArix_x!= null) {
            ret.put(ModelTTask.FI_ARIX_X, dArix_x);
        }
        Integer dArix_y = instance.getArixY();
        if (dArix_y!= null) {
            ret.put(ModelTTask.FI_ARIX_Y, dArix_y);
        }
        Integer dArix_z = instance.getArixZ();
        if (dArix_z!= null) {
            ret.put(ModelTTask.FI_ARIX_Z, dArix_z);
        }
        Integer dPoint_index = instance.getPointIndex();
        if (dPoint_index!= null) {
            ret.put(ModelTTask.FI_POINT_INDEX, dPoint_index);
        }
        String dGoods_id = instance.getGoodsId();
        if (dGoods_id!= null) {
            ret.put(ModelTTask.FI_GOODS_ID, dGoods_id);
        }
        String dGoods_info = instance.getGoodsInfo();
        if (dGoods_info!= null) {
            ret.put(ModelTTask.FI_GOODS_INFO, dGoods_info);
        }
        String dGoods_name = instance.getGoodsName();
        if (dGoods_name!= null) {
            ret.put(ModelTTask.FI_GOODS_NAME, dGoods_name);
        }
        Integer dGoods_weight = instance.getGoodsWeight();
        if (dGoods_weight!= null) {
            ret.put(ModelTTask.FI_GOODS_WEIGHT, dGoods_weight);
        }
        Integer dOrigin_arix_x = instance.getOriginArixX();
        if (dOrigin_arix_x!= null) {
            ret.put(ModelTTask.FI_ORIGIN_ARIX_X, dOrigin_arix_x);
        }
        Integer dOrigin_arix_y = instance.getOriginArixY();
        if (dOrigin_arix_y!= null) {
            ret.put(ModelTTask.FI_ORIGIN_ARIX_Y, dOrigin_arix_y);
        }
        Integer dOrigin_arix_z = instance.getOriginArixZ();
        if (dOrigin_arix_z!= null) {
            ret.put(ModelTTask.FI_ORIGIN_ARIX_Z, dOrigin_arix_z);
        }
        Integer dOrigin_point_index = instance.getOriginPointIndex();
        if (dOrigin_point_index!= null) {
            ret.put(ModelTTask.FI_ORIGIN_POINT_INDEX, dOrigin_point_index);
        }
        Integer dTask_depends_on = instance.getTaskDependsOn();
        if (dTask_depends_on!= null) {
            ret.put(ModelTTask.FI_TASK_DEPENDS_ON, dTask_depends_on);
        }
        Integer dTask_parent_id = instance.getTaskParentId();
        if (dTask_parent_id!= null) {
            ret.put(ModelTTask.FI_TASK_PARENT_ID, dTask_parent_id);
        }
        Integer dTask_group_id = instance.getTaskGroupId();
        if (dTask_group_id!= null) {
            ret.put(ModelTTask.FI_TASK_GROUP_ID, dTask_group_id);
        }
        EnumTaskType dTask_type = instance.getTaskType();
        if (dTask_type!= null) {
            ret.put(ModelTTask.FI_TASK_TYPE, dTask_type.val);
        }
        Integer dTask_appointed_device = instance.getTaskAppointedDevice();
        if (dTask_appointed_device!= null) {
            ret.put(ModelTTask.FI_TASK_APPOINTED_DEVICE, dTask_appointed_device);
        }
        Integer dTask_priority = instance.getTaskPriority();
        if (dTask_priority!= null) {
            ret.put(ModelTTask.FI_TASK_PRIORITY, dTask_priority);
        }
        Integer dRetry_times = instance.getRetryTimes();
        if (dRetry_times!= null) {
            ret.put(ModelTTask.FI_RETRY_TIMES, dRetry_times);
        }
        Integer dCurrent_arix_x = instance.getCurrentArixX();
        if (dCurrent_arix_x!= null) {
            ret.put(ModelTTask.FI_CURRENT_ARIX_X, dCurrent_arix_x);
        }
        Integer dCurrent_arix_y = instance.getCurrentArixY();
        if (dCurrent_arix_y!= null) {
            ret.put(ModelTTask.FI_CURRENT_ARIX_Y, dCurrent_arix_y);
        }
        Integer dCurrent_arix_z = instance.getCurrentArixZ();
        if (dCurrent_arix_z!= null) {
            ret.put(ModelTTask.FI_CURRENT_ARIX_Z, dCurrent_arix_z);
        }
        Integer dCurrent_point_index = instance.getCurrentPointIndex();
        if (dCurrent_point_index!= null) {
            ret.put(ModelTTask.FI_CURRENT_POINT_INDEX, dCurrent_point_index);
        }
        Integer dCurrent_waiting_device = instance.getCurrentWaitingDevice();
        if (dCurrent_waiting_device!= null) {
            ret.put(ModelTTask.FI_CURRENT_WAITING_DEVICE, dCurrent_waiting_device);
        }
        return ret;
    }

    @Override
    public ModelTTask fromCommonMap(Map<String, Object> param) {
        ModelTTask ret = new ModelTTask();
        if (param == null) {
            return ret;
        }
        Object dId = param.get(ModelTTask.FI_ID);
        if (dId!= null) {
            this.setField(ModelTTask.FI_ID, ret, dId);
        }
        Object dTask_create_time = param.get(ModelTTask.FI_TASK_CREATE_TIME);
        if (dTask_create_time!= null) {
            this.setField(ModelTTask.FI_TASK_CREATE_TIME, ret, dTask_create_time);
        }
        Object dTask_expected_start_time = param.get(ModelTTask.FI_TASK_EXPECTED_START_TIME);
        if (dTask_expected_start_time!= null) {
            this.setField(ModelTTask.FI_TASK_EXPECTED_START_TIME, ret, dTask_expected_start_time);
        }
        Object dTask_start_time = param.get(ModelTTask.FI_TASK_START_TIME);
        if (dTask_start_time!= null) {
            this.setField(ModelTTask.FI_TASK_START_TIME, ret, dTask_start_time);
        }
        Object dTask_finish_time = param.get(ModelTTask.FI_TASK_FINISH_TIME);
        if (dTask_finish_time!= null) {
            this.setField(ModelTTask.FI_TASK_FINISH_TIME, ret, dTask_finish_time);
        }
        Object dTask_remark = param.get(ModelTTask.FI_TASK_REMARK);
        if (dTask_remark!= null) {
            this.setField(ModelTTask.FI_TASK_REMARK, ret, dTask_remark);
        }
        Object dTask_order_id = param.get(ModelTTask.FI_TASK_ORDER_ID);
        if (dTask_order_id!= null) {
            this.setField(ModelTTask.FI_TASK_ORDER_ID, ret, dTask_order_id);
        }
        Object dTask_param = param.get(ModelTTask.FI_TASK_PARAM);
        if (dTask_param!= null) {
            this.setField(ModelTTask.FI_TASK_PARAM, ret, dTask_param);
        }
        Object dTask_status = param.get(ModelTTask.FI_TASK_STATUS);
        if (dTask_status!= null) {
            this.setField(ModelTTask.FI_TASK_STATUS, ret, dTask_status);
        }
        Object dTask_total_path = param.get(ModelTTask.FI_TASK_TOTAL_PATH);
        if (dTask_total_path!= null) {
            this.setField(ModelTTask.FI_TASK_TOTAL_PATH, ret, dTask_total_path);
        }
        Object dTask_current_path_id = param.get(ModelTTask.FI_TASK_CURRENT_PATH_ID);
        if (dTask_current_path_id!= null) {
            this.setField(ModelTTask.FI_TASK_CURRENT_PATH_ID, ret, dTask_current_path_id);
        }
        Object dTask_current_path_index = param.get(ModelTTask.FI_TASK_CURRENT_PATH_INDEX);
        if (dTask_current_path_index!= null) {
            this.setField(ModelTTask.FI_TASK_CURRENT_PATH_INDEX, ret, dTask_current_path_index);
        }
        Object dArix_x = param.get(ModelTTask.FI_ARIX_X);
        if (dArix_x!= null) {
            this.setField(ModelTTask.FI_ARIX_X, ret, dArix_x);
        }
        Object dArix_y = param.get(ModelTTask.FI_ARIX_Y);
        if (dArix_y!= null) {
            this.setField(ModelTTask.FI_ARIX_Y, ret, dArix_y);
        }
        Object dArix_z = param.get(ModelTTask.FI_ARIX_Z);
        if (dArix_z!= null) {
            this.setField(ModelTTask.FI_ARIX_Z, ret, dArix_z);
        }
        Object dPoint_index = param.get(ModelTTask.FI_POINT_INDEX);
        if (dPoint_index!= null) {
            this.setField(ModelTTask.FI_POINT_INDEX, ret, dPoint_index);
        }
        Object dGoods_id = param.get(ModelTTask.FI_GOODS_ID);
        if (dGoods_id!= null) {
            this.setField(ModelTTask.FI_GOODS_ID, ret, dGoods_id);
        }
        Object dGoods_info = param.get(ModelTTask.FI_GOODS_INFO);
        if (dGoods_info!= null) {
            this.setField(ModelTTask.FI_GOODS_INFO, ret, dGoods_info);
        }
        Object dGoods_name = param.get(ModelTTask.FI_GOODS_NAME);
        if (dGoods_name!= null) {
            this.setField(ModelTTask.FI_GOODS_NAME, ret, dGoods_name);
        }
        Object dGoods_weight = param.get(ModelTTask.FI_GOODS_WEIGHT);
        if (dGoods_weight!= null) {
            this.setField(ModelTTask.FI_GOODS_WEIGHT, ret, dGoods_weight);
        }
        Object dOrigin_arix_x = param.get(ModelTTask.FI_ORIGIN_ARIX_X);
        if (dOrigin_arix_x!= null) {
            this.setField(ModelTTask.FI_ORIGIN_ARIX_X, ret, dOrigin_arix_x);
        }
        Object dOrigin_arix_y = param.get(ModelTTask.FI_ORIGIN_ARIX_Y);
        if (dOrigin_arix_y!= null) {
            this.setField(ModelTTask.FI_ORIGIN_ARIX_Y, ret, dOrigin_arix_y);
        }
        Object dOrigin_arix_z = param.get(ModelTTask.FI_ORIGIN_ARIX_Z);
        if (dOrigin_arix_z!= null) {
            this.setField(ModelTTask.FI_ORIGIN_ARIX_Z, ret, dOrigin_arix_z);
        }
        Object dOrigin_point_index = param.get(ModelTTask.FI_ORIGIN_POINT_INDEX);
        if (dOrigin_point_index!= null) {
            this.setField(ModelTTask.FI_ORIGIN_POINT_INDEX, ret, dOrigin_point_index);
        }
        Object dTask_depends_on = param.get(ModelTTask.FI_TASK_DEPENDS_ON);
        if (dTask_depends_on!= null) {
            this.setField(ModelTTask.FI_TASK_DEPENDS_ON, ret, dTask_depends_on);
        }
        Object dTask_parent_id = param.get(ModelTTask.FI_TASK_PARENT_ID);
        if (dTask_parent_id!= null) {
            this.setField(ModelTTask.FI_TASK_PARENT_ID, ret, dTask_parent_id);
        }
        Object dTask_group_id = param.get(ModelTTask.FI_TASK_GROUP_ID);
        if (dTask_group_id!= null) {
            this.setField(ModelTTask.FI_TASK_GROUP_ID, ret, dTask_group_id);
        }
        Object dTask_type = param.get(ModelTTask.FI_TASK_TYPE);
        if (dTask_type!= null) {
            this.setField(ModelTTask.FI_TASK_TYPE, ret, dTask_type);
        }
        Object dTask_appointed_device = param.get(ModelTTask.FI_TASK_APPOINTED_DEVICE);
        if (dTask_appointed_device!= null) {
            this.setField(ModelTTask.FI_TASK_APPOINTED_DEVICE, ret, dTask_appointed_device);
        }
        Object dTask_priority = param.get(ModelTTask.FI_TASK_PRIORITY);
        if (dTask_priority!= null) {
            this.setField(ModelTTask.FI_TASK_PRIORITY, ret, dTask_priority);
        }
        Object dRetry_times = param.get(ModelTTask.FI_RETRY_TIMES);
        if (dRetry_times!= null) {
            this.setField(ModelTTask.FI_RETRY_TIMES, ret, dRetry_times);
        }
        Object dCurrent_arix_x = param.get(ModelTTask.FI_CURRENT_ARIX_X);
        if (dCurrent_arix_x!= null) {
            this.setField(ModelTTask.FI_CURRENT_ARIX_X, ret, dCurrent_arix_x);
        }
        Object dCurrent_arix_y = param.get(ModelTTask.FI_CURRENT_ARIX_Y);
        if (dCurrent_arix_y!= null) {
            this.setField(ModelTTask.FI_CURRENT_ARIX_Y, ret, dCurrent_arix_y);
        }
        Object dCurrent_arix_z = param.get(ModelTTask.FI_CURRENT_ARIX_Z);
        if (dCurrent_arix_z!= null) {
            this.setField(ModelTTask.FI_CURRENT_ARIX_Z, ret, dCurrent_arix_z);
        }
        Object dCurrent_point_index = param.get(ModelTTask.FI_CURRENT_POINT_INDEX);
        if (dCurrent_point_index!= null) {
            this.setField(ModelTTask.FI_CURRENT_POINT_INDEX, ret, dCurrent_point_index);
        }
        Object dCurrent_waiting_device = param.get(ModelTTask.FI_CURRENT_WAITING_DEVICE);
        if (dCurrent_waiting_device!= null) {
            this.setField(ModelTTask.FI_CURRENT_WAITING_DEVICE, ret, dCurrent_waiting_device);
        }
        return ret;
    }

    protected Integer mapToFieldId(Object obj) {
        return ((Integer) obj);
    }

    protected Date mapToFieldTaskCreateTime(Object obj) {
        return ((Date) obj);
    }

    protected Date mapToFieldTaskExpectedStartTime(Object obj) {
        return ((Date) obj);
    }

    protected Date mapToFieldTaskStartTime(Object obj) {
        return ((Date) obj);
    }

    protected Date mapToFieldTaskFinishTime(Object obj) {
        return ((Date) obj);
    }

    protected String mapToFieldTaskRemark(Object obj) {
        return ((String) obj);
    }

    protected Integer mapToFieldTaskOrderId(Object obj) {
        return ((Integer) obj);
    }

    protected String mapToFieldTaskParam(Object obj) {
        return ((String) obj);
    }

    protected EnumTaskStatus mapToFieldTaskStatus(Object obj) {
        return EnumTaskStatus.fromValue(((Byte) obj));
    }

    protected Short mapToFieldTaskTotalPath(Object obj) {
        return ((Short) obj);
    }

    protected Integer mapToFieldTaskCurrentPathId(Object obj) {
        return ((Integer) obj);
    }

    protected Short mapToFieldTaskCurrentPathIndex(Object obj) {
        return ((Short) obj);
    }

    protected Integer mapToFieldArixX(Object obj) {
        return ((Integer) obj);
    }

    protected Integer mapToFieldArixY(Object obj) {
        return ((Integer) obj);
    }

    protected Integer mapToFieldArixZ(Object obj) {
        return ((Integer) obj);
    }

    protected Integer mapToFieldPointIndex(Object obj) {
        return ((Integer) obj);
    }

    protected String mapToFieldGoodsId(Object obj) {
        return ((String) obj);
    }

    protected String mapToFieldGoodsInfo(Object obj) {
        return ((String) obj);
    }

    protected String mapToFieldGoodsName(Object obj) {
        return ((String) obj);
    }

    protected Integer mapToFieldGoodsWeight(Object obj) {
        return ((Integer) obj);
    }

    protected Integer mapToFieldOriginArixX(Object obj) {
        return ((Integer) obj);
    }

    protected Integer mapToFieldOriginArixY(Object obj) {
        return ((Integer) obj);
    }

    protected Integer mapToFieldOriginArixZ(Object obj) {
        return ((Integer) obj);
    }

    protected Integer mapToFieldOriginPointIndex(Object obj) {
        return ((Integer) obj);
    }

    protected Integer mapToFieldTaskDependsOn(Object obj) {
        return ((Integer) obj);
    }

    protected Integer mapToFieldTaskParentId(Object obj) {
        return ((Integer) obj);
    }

    protected Integer mapToFieldTaskGroupId(Object obj) {
        return ((Integer) obj);
    }

    protected EnumTaskType mapToFieldTaskType(Object obj) {
        return EnumTaskType.fromValue(((Byte) obj));
    }

    protected Integer mapToFieldTaskAppointedDevice(Object obj) {
        return ((Integer) obj);
    }

    protected Integer mapToFieldTaskPriority(Object obj) {
        return ((Integer) obj);
    }

    protected Integer mapToFieldRetryTimes(Object obj) {
        return ((Integer) obj);
    }

    protected Integer mapToFieldCurrentArixX(Object obj) {
        return ((Integer) obj);
    }

    protected Integer mapToFieldCurrentArixY(Object obj) {
        return ((Integer) obj);
    }

    protected Integer mapToFieldCurrentArixZ(Object obj) {
        return ((Integer) obj);
    }

    protected Integer mapToFieldCurrentPointIndex(Object obj) {
        return ((Integer) obj);
    }

    protected Integer mapToFieldCurrentWaitingDevice(Object obj) {
        return ((Integer) obj);
    }

    public<TT> TT getField(String field, ModelTTask instance) {
        try {
            if (field.equals(ModelTTask.FI_ID)) {
                return ((TT) instance.getId());
            } else {
                if (field.equals(ModelTTask.FI_TASK_CREATE_TIME)) {
                    return ((TT) instance.getTaskCreateTime());
                } else {
                    if (field.equals(ModelTTask.FI_TASK_EXPECTED_START_TIME)) {
                        return ((TT) instance.getTaskExpectedStartTime());
                    } else {
                        if (field.equals(ModelTTask.FI_TASK_START_TIME)) {
                            return ((TT) instance.getTaskStartTime());
                        } else {
                            if (field.equals(ModelTTask.FI_TASK_FINISH_TIME)) {
                                return ((TT) instance.getTaskFinishTime());
                            } else {
                                if (field.equals(ModelTTask.FI_TASK_REMARK)) {
                                    return ((TT) instance.getTaskRemark());
                                } else {
                                    if (field.equals(ModelTTask.FI_TASK_ORDER_ID)) {
                                        return ((TT) instance.getTaskOrderId());
                                    } else {
                                        if (field.equals(ModelTTask.FI_TASK_PARAM)) {
                                            return ((TT) instance.getTaskParam());
                                        } else {
                                            if (field.equals(ModelTTask.FI_TASK_STATUS)) {
                                                return ((TT) instance.getTaskStatus());
                                            } else {
                                                if (field.equals(ModelTTask.FI_TASK_TOTAL_PATH)) {
                                                    return ((TT) instance.getTaskTotalPath());
                                                } else {
                                                    if (field.equals(ModelTTask.FI_TASK_CURRENT_PATH_ID)) {
                                                        return ((TT) instance.getTaskCurrentPathId());
                                                    } else {
                                                        if (field.equals(ModelTTask.FI_TASK_CURRENT_PATH_INDEX)) {
                                                            return ((TT) instance.getTaskCurrentPathIndex());
                                                        } else {
                                                            if (field.equals(ModelTTask.FI_ARIX_X)) {
                                                                return ((TT) instance.getArixX());
                                                            } else {
                                                                if (field.equals(ModelTTask.FI_ARIX_Y)) {
                                                                    return ((TT) instance.getArixY());
                                                                } else {
                                                                    if (field.equals(ModelTTask.FI_ARIX_Z)) {
                                                                        return ((TT) instance.getArixZ());
                                                                    } else {
                                                                        if (field.equals(ModelTTask.FI_POINT_INDEX)) {
                                                                            return ((TT) instance.getPointIndex());
                                                                        } else {
                                                                            if (field.equals(ModelTTask.FI_GOODS_ID)) {
                                                                                return ((TT) instance.getGoodsId());
                                                                            } else {
                                                                                if (field.equals(ModelTTask.FI_GOODS_INFO)) {
                                                                                    return ((TT) instance.getGoodsInfo());
                                                                                } else {
                                                                                    if (field.equals(ModelTTask.FI_GOODS_NAME)) {
                                                                                        return ((TT) instance.getGoodsName());
                                                                                    } else {
                                                                                        if (field.equals(ModelTTask.FI_GOODS_WEIGHT)) {
                                                                                            return ((TT) instance.getGoodsWeight());
                                                                                        } else {
                                                                                            if (field.equals(ModelTTask.FI_ORIGIN_ARIX_X)) {
                                                                                                return ((TT) instance.getOriginArixX());
                                                                                            } else {
                                                                                                if (field.equals(ModelTTask.FI_ORIGIN_ARIX_Y)) {
                                                                                                    return ((TT) instance.getOriginArixY());
                                                                                                } else {
                                                                                                    if (field.equals(ModelTTask.FI_ORIGIN_ARIX_Z)) {
                                                                                                        return ((TT) instance.getOriginArixZ());
                                                                                                    } else {
                                                                                                        if (field.equals(ModelTTask.FI_ORIGIN_POINT_INDEX)) {
                                                                                                            return ((TT) instance.getOriginPointIndex());
                                                                                                        } else {
                                                                                                            if (field.equals(ModelTTask.FI_TASK_DEPENDS_ON)) {
                                                                                                                return ((TT) instance.getTaskDependsOn());
                                                                                                            } else {
                                                                                                                if (field.equals(ModelTTask.FI_TASK_PARENT_ID)) {
                                                                                                                    return ((TT) instance.getTaskParentId());
                                                                                                                } else {
                                                                                                                    if (field.equals(ModelTTask.FI_TASK_GROUP_ID)) {
                                                                                                                        return ((TT) instance.getTaskGroupId());
                                                                                                                    } else {
                                                                                                                        if (field.equals(ModelTTask.FI_TASK_TYPE)) {
                                                                                                                            return ((TT) instance.getTaskType());
                                                                                                                        } else {
                                                                                                                            if (field.equals(ModelTTask.FI_TASK_APPOINTED_DEVICE)) {
                                                                                                                                return ((TT) instance.getTaskAppointedDevice());
                                                                                                                            } else {
                                                                                                                                if (field.equals(ModelTTask.FI_TASK_PRIORITY)) {
                                                                                                                                    return ((TT) instance.getTaskPriority());
                                                                                                                                } else {
                                                                                                                                    if (field.equals(ModelTTask.FI_RETRY_TIMES)) {
                                                                                                                                        return ((TT) instance.getRetryTimes());
                                                                                                                                    } else {
                                                                                                                                        if (field.equals(ModelTTask.FI_CURRENT_ARIX_X)) {
                                                                                                                                            return ((TT) instance.getCurrentArixX());
                                                                                                                                        } else {
                                                                                                                                            if (field.equals(ModelTTask.FI_CURRENT_ARIX_Y)) {
                                                                                                                                                return ((TT) instance.getCurrentArixY());
                                                                                                                                            } else {
                                                                                                                                                if (field.equals(ModelTTask.FI_CURRENT_ARIX_Z)) {
                                                                                                                                                    return ((TT) instance.getCurrentArixZ());
                                                                                                                                                } else {
                                                                                                                                                    if (field.equals(ModelTTask.FI_CURRENT_POINT_INDEX)) {
                                                                                                                                                        return ((TT) instance.getCurrentPointIndex());
                                                                                                                                                    } else {
                                                                                                                                                        if (field.equals(ModelTTask.FI_CURRENT_WAITING_DEVICE)) {
                                                                                                                                                            return ((TT) instance.getCurrentWaitingDevice());
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

    public<TT> void setField(String field, ModelTTask instance, TT value) {
        if (field.equals(ModelTTask.FI_ID)) {
            try {
                instance.setId(mapToFieldId(value));
            } catch (final Exception ex) {
                ex.printStackTrace();
            }
        } else {
            if (field.equals(ModelTTask.FI_TASK_CREATE_TIME)) {
                try {
                    instance.setTaskCreateTime(mapToFieldTaskCreateTime(value));
                } catch (final Exception ex) {
                    ex.printStackTrace();
                }
            } else {
                if (field.equals(ModelTTask.FI_TASK_EXPECTED_START_TIME)) {
                    try {
                        instance.setTaskExpectedStartTime(mapToFieldTaskExpectedStartTime(value));
                    } catch (final Exception ex) {
                        ex.printStackTrace();
                    }
                } else {
                    if (field.equals(ModelTTask.FI_TASK_START_TIME)) {
                        try {
                            instance.setTaskStartTime(mapToFieldTaskStartTime(value));
                        } catch (final Exception ex) {
                            ex.printStackTrace();
                        }
                    } else {
                        if (field.equals(ModelTTask.FI_TASK_FINISH_TIME)) {
                            try {
                                instance.setTaskFinishTime(mapToFieldTaskFinishTime(value));
                            } catch (final Exception ex) {
                                ex.printStackTrace();
                            }
                        } else {
                            if (field.equals(ModelTTask.FI_TASK_REMARK)) {
                                try {
                                    instance.setTaskRemark(mapToFieldTaskRemark(value));
                                } catch (final Exception ex) {
                                    ex.printStackTrace();
                                }
                            } else {
                                if (field.equals(ModelTTask.FI_TASK_ORDER_ID)) {
                                    try {
                                        instance.setTaskOrderId(mapToFieldTaskOrderId(value));
                                    } catch (final Exception ex) {
                                        ex.printStackTrace();
                                    }
                                } else {
                                    if (field.equals(ModelTTask.FI_TASK_PARAM)) {
                                        try {
                                            instance.setTaskParam(mapToFieldTaskParam(value));
                                        } catch (final Exception ex) {
                                            ex.printStackTrace();
                                        }
                                    } else {
                                        if (field.equals(ModelTTask.FI_TASK_STATUS)) {
                                            try {
                                                instance.setTaskStatus(mapToFieldTaskStatus(value));
                                            } catch (final Exception ex) {
                                                ex.printStackTrace();
                                            }
                                        } else {
                                            if (field.equals(ModelTTask.FI_TASK_TOTAL_PATH)) {
                                                try {
                                                    instance.setTaskTotalPath(mapToFieldTaskTotalPath(value));
                                                } catch (final Exception ex) {
                                                    ex.printStackTrace();
                                                }
                                            } else {
                                                if (field.equals(ModelTTask.FI_TASK_CURRENT_PATH_ID)) {
                                                    try {
                                                        instance.setTaskCurrentPathId(mapToFieldTaskCurrentPathId(value));
                                                    } catch (final Exception ex) {
                                                        ex.printStackTrace();
                                                    }
                                                } else {
                                                    if (field.equals(ModelTTask.FI_TASK_CURRENT_PATH_INDEX)) {
                                                        try {
                                                            instance.setTaskCurrentPathIndex(mapToFieldTaskCurrentPathIndex(value));
                                                        } catch (final Exception ex) {
                                                            ex.printStackTrace();
                                                        }
                                                    } else {
                                                        if (field.equals(ModelTTask.FI_ARIX_X)) {
                                                            try {
                                                                instance.setArixX(mapToFieldArixX(value));
                                                            } catch (final Exception ex) {
                                                                ex.printStackTrace();
                                                            }
                                                        } else {
                                                            if (field.equals(ModelTTask.FI_ARIX_Y)) {
                                                                try {
                                                                    instance.setArixY(mapToFieldArixY(value));
                                                                } catch (final Exception ex) {
                                                                    ex.printStackTrace();
                                                                }
                                                            } else {
                                                                if (field.equals(ModelTTask.FI_ARIX_Z)) {
                                                                    try {
                                                                        instance.setArixZ(mapToFieldArixZ(value));
                                                                    } catch (final Exception ex) {
                                                                        ex.printStackTrace();
                                                                    }
                                                                } else {
                                                                    if (field.equals(ModelTTask.FI_POINT_INDEX)) {
                                                                        try {
                                                                            instance.setPointIndex(mapToFieldPointIndex(value));
                                                                        } catch (final Exception ex) {
                                                                            ex.printStackTrace();
                                                                        }
                                                                    } else {
                                                                        if (field.equals(ModelTTask.FI_GOODS_ID)) {
                                                                            try {
                                                                                instance.setGoodsId(mapToFieldGoodsId(value));
                                                                            } catch (final Exception ex) {
                                                                                ex.printStackTrace();
                                                                            }
                                                                        } else {
                                                                            if (field.equals(ModelTTask.FI_GOODS_INFO)) {
                                                                                try {
                                                                                    instance.setGoodsInfo(mapToFieldGoodsInfo(value));
                                                                                } catch (final Exception ex) {
                                                                                    ex.printStackTrace();
                                                                                }
                                                                            } else {
                                                                                if (field.equals(ModelTTask.FI_GOODS_NAME)) {
                                                                                    try {
                                                                                        instance.setGoodsName(mapToFieldGoodsName(value));
                                                                                    } catch (final Exception ex) {
                                                                                        ex.printStackTrace();
                                                                                    }
                                                                                } else {
                                                                                    if (field.equals(ModelTTask.FI_GOODS_WEIGHT)) {
                                                                                        try {
                                                                                            instance.setGoodsWeight(mapToFieldGoodsWeight(value));
                                                                                        } catch (final Exception ex) {
                                                                                            ex.printStackTrace();
                                                                                        }
                                                                                    } else {
                                                                                        if (field.equals(ModelTTask.FI_ORIGIN_ARIX_X)) {
                                                                                            try {
                                                                                                instance.setOriginArixX(mapToFieldOriginArixX(value));
                                                                                            } catch (final Exception ex) {
                                                                                                ex.printStackTrace();
                                                                                            }
                                                                                        } else {
                                                                                            if (field.equals(ModelTTask.FI_ORIGIN_ARIX_Y)) {
                                                                                                try {
                                                                                                    instance.setOriginArixY(mapToFieldOriginArixY(value));
                                                                                                } catch (final Exception ex) {
                                                                                                    ex.printStackTrace();
                                                                                                }
                                                                                            } else {
                                                                                                if (field.equals(ModelTTask.FI_ORIGIN_ARIX_Z)) {
                                                                                                    try {
                                                                                                        instance.setOriginArixZ(mapToFieldOriginArixZ(value));
                                                                                                    } catch (final Exception ex) {
                                                                                                        ex.printStackTrace();
                                                                                                    }
                                                                                                } else {
                                                                                                    if (field.equals(ModelTTask.FI_ORIGIN_POINT_INDEX)) {
                                                                                                        try {
                                                                                                            instance.setOriginPointIndex(mapToFieldOriginPointIndex(value));
                                                                                                        } catch (final Exception ex) {
                                                                                                            ex.printStackTrace();
                                                                                                        }
                                                                                                    } else {
                                                                                                        if (field.equals(ModelTTask.FI_TASK_DEPENDS_ON)) {
                                                                                                            try {
                                                                                                                instance.setTaskDependsOn(mapToFieldTaskDependsOn(value));
                                                                                                            } catch (final Exception ex) {
                                                                                                                ex.printStackTrace();
                                                                                                            }
                                                                                                        } else {
                                                                                                            if (field.equals(ModelTTask.FI_TASK_PARENT_ID)) {
                                                                                                                try {
                                                                                                                    instance.setTaskParentId(mapToFieldTaskParentId(value));
                                                                                                                } catch (final Exception ex) {
                                                                                                                    ex.printStackTrace();
                                                                                                                }
                                                                                                            } else {
                                                                                                                if (field.equals(ModelTTask.FI_TASK_GROUP_ID)) {
                                                                                                                    try {
                                                                                                                        instance.setTaskGroupId(mapToFieldTaskGroupId(value));
                                                                                                                    } catch (final Exception ex) {
                                                                                                                        ex.printStackTrace();
                                                                                                                    }
                                                                                                                } else {
                                                                                                                    if (field.equals(ModelTTask.FI_TASK_TYPE)) {
                                                                                                                        try {
                                                                                                                            instance.setTaskType(mapToFieldTaskType(value));
                                                                                                                        } catch (final Exception ex) {
                                                                                                                            ex.printStackTrace();
                                                                                                                        }
                                                                                                                    } else {
                                                                                                                        if (field.equals(ModelTTask.FI_TASK_APPOINTED_DEVICE)) {
                                                                                                                            try {
                                                                                                                                instance.setTaskAppointedDevice(mapToFieldTaskAppointedDevice(value));
                                                                                                                            } catch (final Exception ex) {
                                                                                                                                ex.printStackTrace();
                                                                                                                            }
                                                                                                                        } else {
                                                                                                                            if (field.equals(ModelTTask.FI_TASK_PRIORITY)) {
                                                                                                                                try {
                                                                                                                                    instance.setTaskPriority(mapToFieldTaskPriority(value));
                                                                                                                                } catch (final Exception ex) {
                                                                                                                                    ex.printStackTrace();
                                                                                                                                }
                                                                                                                            } else {
                                                                                                                                if (field.equals(ModelTTask.FI_RETRY_TIMES)) {
                                                                                                                                    try {
                                                                                                                                        instance.setRetryTimes(mapToFieldRetryTimes(value));
                                                                                                                                    } catch (final Exception ex) {
                                                                                                                                        ex.printStackTrace();
                                                                                                                                    }
                                                                                                                                } else {
                                                                                                                                    if (field.equals(ModelTTask.FI_CURRENT_ARIX_X)) {
                                                                                                                                        try {
                                                                                                                                            instance.setCurrentArixX(mapToFieldCurrentArixX(value));
                                                                                                                                        } catch (final Exception ex) {
                                                                                                                                            ex.printStackTrace();
                                                                                                                                        }
                                                                                                                                    } else {
                                                                                                                                        if (field.equals(ModelTTask.FI_CURRENT_ARIX_Y)) {
                                                                                                                                            try {
                                                                                                                                                instance.setCurrentArixY(mapToFieldCurrentArixY(value));
                                                                                                                                            } catch (final Exception ex) {
                                                                                                                                                ex.printStackTrace();
                                                                                                                                            }
                                                                                                                                        } else {
                                                                                                                                            if (field.equals(ModelTTask.FI_CURRENT_ARIX_Z)) {
                                                                                                                                                try {
                                                                                                                                                    instance.setCurrentArixZ(mapToFieldCurrentArixZ(value));
                                                                                                                                                } catch (final Exception ex) {
                                                                                                                                                    ex.printStackTrace();
                                                                                                                                                }
                                                                                                                                            } else {
                                                                                                                                                if (field.equals(ModelTTask.FI_CURRENT_POINT_INDEX)) {
                                                                                                                                                    try {
                                                                                                                                                        instance.setCurrentPointIndex(mapToFieldCurrentPointIndex(value));
                                                                                                                                                    } catch (final Exception ex) {
                                                                                                                                                        ex.printStackTrace();
                                                                                                                                                    }
                                                                                                                                                } else {
                                                                                                                                                    if (field.equals(ModelTTask.FI_CURRENT_WAITING_DEVICE)) {
                                                                                                                                                        try {
                                                                                                                                                            instance.setCurrentWaitingDevice(mapToFieldCurrentWaitingDevice(value));
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
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void setField(String field, ModelTTask instance, byte[] value) {
        if (field.equals(ModelTTask.FI_ID)) {
            instance.setId(mapToFieldId(value));
        } else {
            if (field.equals(ModelTTask.FI_TASK_CREATE_TIME)) {
                instance.setTaskCreateTime(mapToFieldTaskCreateTime(value));
            } else {
                if (field.equals(ModelTTask.FI_TASK_EXPECTED_START_TIME)) {
                    instance.setTaskExpectedStartTime(mapToFieldTaskExpectedStartTime(value));
                } else {
                    if (field.equals(ModelTTask.FI_TASK_START_TIME)) {
                        instance.setTaskStartTime(mapToFieldTaskStartTime(value));
                    } else {
                        if (field.equals(ModelTTask.FI_TASK_FINISH_TIME)) {
                            instance.setTaskFinishTime(mapToFieldTaskFinishTime(value));
                        } else {
                            if (field.equals(ModelTTask.FI_TASK_REMARK)) {
                                instance.setTaskRemark(mapToFieldTaskRemark(value));
                            } else {
                                if (field.equals(ModelTTask.FI_TASK_ORDER_ID)) {
                                    instance.setTaskOrderId(mapToFieldTaskOrderId(value));
                                } else {
                                    if (field.equals(ModelTTask.FI_TASK_PARAM)) {
                                        instance.setTaskParam(mapToFieldTaskParam(value));
                                    } else {
                                        if (field.equals(ModelTTask.FI_TASK_STATUS)) {
                                            instance.setTaskStatus(mapToFieldTaskStatus(value));
                                        } else {
                                            if (field.equals(ModelTTask.FI_TASK_TOTAL_PATH)) {
                                                instance.setTaskTotalPath(mapToFieldTaskTotalPath(value));
                                            } else {
                                                if (field.equals(ModelTTask.FI_TASK_CURRENT_PATH_ID)) {
                                                    instance.setTaskCurrentPathId(mapToFieldTaskCurrentPathId(value));
                                                } else {
                                                    if (field.equals(ModelTTask.FI_TASK_CURRENT_PATH_INDEX)) {
                                                        instance.setTaskCurrentPathIndex(mapToFieldTaskCurrentPathIndex(value));
                                                    } else {
                                                        if (field.equals(ModelTTask.FI_ARIX_X)) {
                                                            instance.setArixX(mapToFieldArixX(value));
                                                        } else {
                                                            if (field.equals(ModelTTask.FI_ARIX_Y)) {
                                                                instance.setArixY(mapToFieldArixY(value));
                                                            } else {
                                                                if (field.equals(ModelTTask.FI_ARIX_Z)) {
                                                                    instance.setArixZ(mapToFieldArixZ(value));
                                                                } else {
                                                                    if (field.equals(ModelTTask.FI_POINT_INDEX)) {
                                                                        instance.setPointIndex(mapToFieldPointIndex(value));
                                                                    } else {
                                                                        if (field.equals(ModelTTask.FI_GOODS_ID)) {
                                                                            instance.setGoodsId(mapToFieldGoodsId(value));
                                                                        } else {
                                                                            if (field.equals(ModelTTask.FI_GOODS_INFO)) {
                                                                                instance.setGoodsInfo(mapToFieldGoodsInfo(value));
                                                                            } else {
                                                                                if (field.equals(ModelTTask.FI_GOODS_NAME)) {
                                                                                    instance.setGoodsName(mapToFieldGoodsName(value));
                                                                                } else {
                                                                                    if (field.equals(ModelTTask.FI_GOODS_WEIGHT)) {
                                                                                        instance.setGoodsWeight(mapToFieldGoodsWeight(value));
                                                                                    } else {
                                                                                        if (field.equals(ModelTTask.FI_ORIGIN_ARIX_X)) {
                                                                                            instance.setOriginArixX(mapToFieldOriginArixX(value));
                                                                                        } else {
                                                                                            if (field.equals(ModelTTask.FI_ORIGIN_ARIX_Y)) {
                                                                                                instance.setOriginArixY(mapToFieldOriginArixY(value));
                                                                                            } else {
                                                                                                if (field.equals(ModelTTask.FI_ORIGIN_ARIX_Z)) {
                                                                                                    instance.setOriginArixZ(mapToFieldOriginArixZ(value));
                                                                                                } else {
                                                                                                    if (field.equals(ModelTTask.FI_ORIGIN_POINT_INDEX)) {
                                                                                                        instance.setOriginPointIndex(mapToFieldOriginPointIndex(value));
                                                                                                    } else {
                                                                                                        if (field.equals(ModelTTask.FI_TASK_DEPENDS_ON)) {
                                                                                                            instance.setTaskDependsOn(mapToFieldTaskDependsOn(value));
                                                                                                        } else {
                                                                                                            if (field.equals(ModelTTask.FI_TASK_PARENT_ID)) {
                                                                                                                instance.setTaskParentId(mapToFieldTaskParentId(value));
                                                                                                            } else {
                                                                                                                if (field.equals(ModelTTask.FI_TASK_GROUP_ID)) {
                                                                                                                    instance.setTaskGroupId(mapToFieldTaskGroupId(value));
                                                                                                                } else {
                                                                                                                    if (field.equals(ModelTTask.FI_TASK_TYPE)) {
                                                                                                                        instance.setTaskType(mapToFieldTaskType(value));
                                                                                                                    } else {
                                                                                                                        if (field.equals(ModelTTask.FI_TASK_APPOINTED_DEVICE)) {
                                                                                                                            instance.setTaskAppointedDevice(mapToFieldTaskAppointedDevice(value));
                                                                                                                        } else {
                                                                                                                            if (field.equals(ModelTTask.FI_TASK_PRIORITY)) {
                                                                                                                                instance.setTaskPriority(mapToFieldTaskPriority(value));
                                                                                                                            } else {
                                                                                                                                if (field.equals(ModelTTask.FI_RETRY_TIMES)) {
                                                                                                                                    instance.setRetryTimes(mapToFieldRetryTimes(value));
                                                                                                                                } else {
                                                                                                                                    if (field.equals(ModelTTask.FI_CURRENT_ARIX_X)) {
                                                                                                                                        instance.setCurrentArixX(mapToFieldCurrentArixX(value));
                                                                                                                                    } else {
                                                                                                                                        if (field.equals(ModelTTask.FI_CURRENT_ARIX_Y)) {
                                                                                                                                            instance.setCurrentArixY(mapToFieldCurrentArixY(value));
                                                                                                                                        } else {
                                                                                                                                            if (field.equals(ModelTTask.FI_CURRENT_ARIX_Z)) {
                                                                                                                                                instance.setCurrentArixZ(mapToFieldCurrentArixZ(value));
                                                                                                                                            } else {
                                                                                                                                                if (field.equals(ModelTTask.FI_CURRENT_POINT_INDEX)) {
                                                                                                                                                    instance.setCurrentPointIndex(mapToFieldCurrentPointIndex(value));
                                                                                                                                                } else {
                                                                                                                                                    if (field.equals(ModelTTask.FI_CURRENT_WAITING_DEVICE)) {
                                                                                                                                                        instance.setCurrentWaitingDevice(mapToFieldCurrentWaitingDevice(value));
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
                            }
                        }
                    }
                }
            }
        }
    }
}
