package com.shangde.ent_portal.logical.dto.enums;

import java.util.Map;
import com.shawn.ss.lib.tools.CollectionHelper;


/**
 * 表 deviceStatusEnum.device_status 相关枚举
 */
public enum EnumDeviceStatusType {

    /**
     * 初始化
     */
    inited((byte)0, "\u521d\u59cb\u5316"),

    /**
     * 就绪
     */
    ready((byte)1, "\u5c31\u7eea"),

    /**
     * 工作中
     */
    working((byte)2, "\u5de5\u4f5c\u4e2d"),

    /**
     * 暂停中
     */
    pausing((byte)3, "\u6682\u505c\u4e2d"),

    /**
     * 完成
     */
    finish((byte)4, "\u5b8c\u6210"),

    /**
     * 非联机状态
     */
    offline((byte)124, "\u975e\u8054\u673a\u72b6\u6001"),

    /**
     * 异常
     */
    exception((byte)125, "\u5f02\u5e38"),

    /**
     * 网络不可用
     */
    unavailable((byte)127, "\u7f51\u7edc\u4e0d\u53ef\u7528"),

    /**
     * 电量低
     */
    lowBattery((byte)126, "\u7535\u91cf\u4f4e");
    public final Byte val;
    public final String desc;
    private static Map<Byte, EnumDeviceStatusType> valuesMap;

    EnumDeviceStatusType(Byte v, String s) {
        val = v;
        desc = s;
    }

    public static EnumDeviceStatusType fromValue(Byte v) {
        if (valuesMap == null) {
            synchronized(com.shangde.ent_portal.logical.dto.enums.EnumDeviceStatusType.class)
            {
                if ((valuesMap == null)||(valuesMap.size() == 0)) {
                    valuesMap = CollectionHelper.newMap();
                    EnumDeviceStatusType[] values = EnumDeviceStatusType.values();
                    for (EnumDeviceStatusType venum: values) {
                        valuesMap.put(venum.val, venum);
                    }
                }
            }
        }
        return valuesMap.get(v);
    }
}
