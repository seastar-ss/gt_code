package com.shangde.ent_portal.logical.dto.enums;

import java.util.Map;
import com.shawn.ss.lib.tools.CollectionHelper;


/**
 * 表 eventHandlerEnum.event_handler 相关枚举
 */
public enum EnumEventHandlerType {

    /**
     * 无处理
     */
    noHandler((byte)0, "\u65e0\u5904\u7406"),

    /**
     * 任务处理器
     */
    taskHandler((byte)1, "\u4efb\u52a1\u5904\u7406\u5668"),

    /**
     * 执行器处理器
     */
    executorHandler((byte)2, "\u6267\u884c\u5668\u5904\u7406\u5668");
    public final Byte val;
    public final String desc;
    private static Map<Byte, EnumEventHandlerType> valuesMap;

    EnumEventHandlerType(Byte v, String s) {
        val = v;
        desc = s;
    }

    public static EnumEventHandlerType fromValue(Byte v) {
        if (valuesMap == null) {
            synchronized(com.shangde.ent_portal.logical.dto.enums.EnumEventHandlerType.class)
            {
                if ((valuesMap == null)||(valuesMap.size() == 0)) {
                    valuesMap = CollectionHelper.newMap();
                    EnumEventHandlerType[] values = EnumEventHandlerType.values();
                    for (EnumEventHandlerType venum: values) {
                        valuesMap.put(venum.val, venum);
                    }
                }
            }
        }
        return valuesMap.get(v);
    }
}
