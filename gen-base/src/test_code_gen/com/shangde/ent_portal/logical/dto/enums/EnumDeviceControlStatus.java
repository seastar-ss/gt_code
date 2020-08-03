package com.shangde.ent_portal.logical.dto.enums;

import java.util.Map;
import com.shawn.ss.lib.tools.CollectionHelper;


/**
 * 表 deviceControlStatusEnum.device_control_status 相关枚举
 */
public enum EnumDeviceControlStatus {

    /**
     * 系统自动控制
     */
    systemAuto((byte)0, "\u7cfb\u7edf\u81ea\u52a8\u63a7\u5236"),

    /**
     * 系统手动控制
     */
    systemManual((byte)1, "\u7cfb\u7edf\u624b\u52a8\u63a7\u5236"),

    /**
     * 非系统控制
     */
    systemNoControll((byte)2, "\u975e\u7cfb\u7edf\u63a7\u5236"),

    /**
     * 纯手动
     */
    manual((byte)3, "\u7eaf\u624b\u52a8");
    public final Byte val;
    public final String desc;
    private static Map<Byte, EnumDeviceControlStatus> valuesMap;

    EnumDeviceControlStatus(Byte v, String s) {
        val = v;
        desc = s;
    }

    public static EnumDeviceControlStatus fromValue(Byte v) {
        if (valuesMap == null) {
            synchronized(com.shangde.ent_portal.logical.dto.enums.EnumDeviceControlStatus.class)
            {
                if ((valuesMap == null)||(valuesMap.size() == 0)) {
                    valuesMap = CollectionHelper.newMap();
                    EnumDeviceControlStatus[] values = EnumDeviceControlStatus.values();
                    for (EnumDeviceControlStatus venum: values) {
                        valuesMap.put(venum.val, venum);
                    }
                }
            }
        }
        return valuesMap.get(v);
    }
}
