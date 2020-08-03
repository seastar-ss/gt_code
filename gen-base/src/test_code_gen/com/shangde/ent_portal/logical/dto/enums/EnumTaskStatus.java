package com.shangde.ent_portal.logical.dto.enums;

import java.util.Map;
import com.shawn.ss.lib.tools.CollectionHelper;


/**
 * 表 taskStatusEnum.task_status 相关枚举
 */
public enum EnumTaskStatus {

    /**
     * 等待
     */
    waiting((byte)0, "\u7b49\u5f85"),

    /**
     * 完成
     */
    finish((byte)1, "\u5b8c\u6210"),

    /**
     * 运作中
     */
    running((byte)2, "\u8fd0\u4f5c\u4e2d"),

    /**
     * 异常
     */
    exception((byte)3, "\u5f02\u5e38"),

    /**
     * 取消
     */
    cancel((byte)4, "\u53d6\u6d88"),

    /**
     * 已安排
     */
    scheduled((byte)5, "\u5df2\u5b89\u6392"),

    /**
     * 超时
     */
    timeout((byte)6, "\u8d85\u65f6");
    public final Byte val;
    public final String desc;
    private static Map<Byte, EnumTaskStatus> valuesMap;

    EnumTaskStatus(Byte v, String s) {
        val = v;
        desc = s;
    }

    public static EnumTaskStatus fromValue(Byte v) {
        if (valuesMap == null) {
            synchronized(com.shangde.ent_portal.logical.dto.enums.EnumTaskStatus.class)
            {
                if ((valuesMap == null)||(valuesMap.size() == 0)) {
                    valuesMap = CollectionHelper.newMap();
                    EnumTaskStatus[] values = EnumTaskStatus.values();
                    for (EnumTaskStatus venum: values) {
                        valuesMap.put(venum.val, venum);
                    }
                }
            }
        }
        return valuesMap.get(v);
    }
}
