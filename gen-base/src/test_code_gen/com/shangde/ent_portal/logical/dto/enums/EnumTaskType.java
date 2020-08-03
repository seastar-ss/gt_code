package com.shangde.ent_portal.logical.dto.enums;

import java.util.Map;
import com.shawn.ss.lib.tools.CollectionHelper;


/**
 * 表 taskTypeEnum.task_type 相关枚举
 */
public enum EnumTaskType {

    /**
     * 入库
     */
    input((byte)0, "\u5165\u5e93"),

    /**
     * 出库
     */
    output((byte)1, "\u51fa\u5e93"),

    /**
     * 移位
     */
    move((byte)2, "\u79fb\u4f4d"),

    /**
     * 拣选
     */
    exchange((byte)3, "\u62e3\u9009"),

    /**
     * 盘点
     */
    check((byte)4, "\u76d8\u70b9"),

    /**
     * 异常处理
     */
    exceptionHandle((byte)61, "\u5f02\u5e38\u5904\u7406"),

    /**
     * 设备移动
     */
    deviceMove((byte)101, "\u8bbe\u5907\u79fb\u52a8"),

    /**
     * 设备充电
     */
    deviceCharge((byte)102, "\u8bbe\u5907\u5145\u7535"),

    /**
     * 设备维护
     */
    deviceMaintain((byte)103, "\u8bbe\u5907\u7ef4\u62a4");
    public final Byte val;
    public final String desc;
    private static Map<Byte, EnumTaskType> valuesMap;

    EnumTaskType(Byte v, String s) {
        val = v;
        desc = s;
    }

    public static EnumTaskType fromValue(Byte v) {
        if (valuesMap == null) {
            synchronized(com.shangde.ent_portal.logical.dto.enums.EnumTaskType.class)
            {
                if ((valuesMap == null)||(valuesMap.size() == 0)) {
                    valuesMap = CollectionHelper.newMap();
                    EnumTaskType[] values = EnumTaskType.values();
                    for (EnumTaskType venum: values) {
                        valuesMap.put(venum.val, venum);
                    }
                }
            }
        }
        return valuesMap.get(v);
    }
}
