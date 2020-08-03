package com.shangde.ent_portal.logical.dto.enums;

import java.util.Map;
import com.shawn.ss.lib.tools.CollectionHelper;


/**
 * 表 eventTypeEnum.event_type 相关枚举
 */
public enum EnumEventStatus {

    /**
     * 设备命令事件
     */
    order((byte)0, "\u8bbe\u5907\u547d\u4ee4\u4e8b\u4ef6"),

    /**
     * 反馈设备事件
     */
    feedBackDeviceEvent((byte)1, "\u53cd\u9988\u8bbe\u5907\u4e8b\u4ef6"),

    /**
     * 反馈任务事件
     */
    feedBackTaskStatus((byte)2, "\u53cd\u9988\u4efb\u52a1\u4e8b\u4ef6"),

    /**
     * 反馈任务动作事件
     */
    feedBackTaskActionStatus((byte)3, "\u53cd\u9988\u4efb\u52a1\u52a8\u4f5c\u4e8b\u4ef6"),

    /**
     * 反馈任务路径事件
     */
    feedBackTaskPathStatus((byte)4, "\u53cd\u9988\u4efb\u52a1\u8def\u5f84\u4e8b\u4ef6"),

    /**
     * 反馈命令超时事件
     */
    feedBackOrderTimeout((byte)5, "\u53cd\u9988\u547d\u4ee4\u8d85\u65f6\u4e8b\u4ef6"),

    /**
     * 设备超时事件
     */
    deviceTimeout((byte)6, "\u8bbe\u5907\u8d85\u65f6\u4e8b\u4ef6"),

    /**
     * 任务动作超时事件
     */
    taskActionTimeout((byte)7, "\u4efb\u52a1\u52a8\u4f5c\u8d85\u65f6\u4e8b\u4ef6"),

    /**
     * 反馈设备运行状态
     */
    feedBackDeviceStatus((byte)8, "\u53cd\u9988\u8bbe\u5907\u8fd0\u884c\u72b6\u6001"),

    /**
     * 反馈设备超时状态
     */
    feedBackDeviceTimeout((byte)9, "\u53cd\u9988\u8bbe\u5907\u8d85\u65f6\u72b6\u6001"),

    /**
     * 反馈设备错误状态
     */
    feedBackDeviceError((byte)10, "\u53cd\u9988\u8bbe\u5907\u9519\u8bef\u72b6\u6001"),

    /**
     * 反馈系统事件
     */
    feedBackSysEvent((byte)10, "\u53cd\u9988\u7cfb\u7edf\u4e8b\u4ef6");
    public final Byte val;
    public final String desc;
    private static Map<Byte, EnumEventStatus> valuesMap;

    EnumEventStatus(Byte v, String s) {
        val = v;
        desc = s;
    }

    public static EnumEventStatus fromValue(Byte v) {
        if (valuesMap == null) {
            synchronized(com.shangde.ent_portal.logical.dto.enums.EnumEventStatus.class)
            {
                if ((valuesMap == null)||(valuesMap.size() == 0)) {
                    valuesMap = CollectionHelper.newMap();
                    EnumEventStatus[] values = EnumEventStatus.values();
                    for (EnumEventStatus venum: values) {
                        valuesMap.put(venum.val, venum);
                    }
                }
            }
        }
        return valuesMap.get(v);
    }
}
