package com.shangde.ent_portal.logical.dto.enums;

import java.util.Map;
import com.shawn.ss.lib.tools.CollectionHelper;


/**
 * 表 areaTypeEnum.area_type 相关枚举
 */
public enum EnumAreaType {

    /**
     * 通道
     */
    route((byte)0, "\u901a\u9053"),

    /**
     * 仓位
     */
    store((byte)1, "\u4ed3\u4f4d"),

    /**
     * 功能区
     */
    functional((byte)2, "\u529f\u80fd\u533a"),

    /**
     * 逻辑区域
     */
    logicalArea((byte)3, "\u903b\u8f91\u533a\u57df");
    public final Byte val;
    public final String desc;
    private static Map<Byte, EnumAreaType> valuesMap;

    EnumAreaType(Byte v, String s) {
        val = v;
        desc = s;
    }

    public static EnumAreaType fromValue(Byte v) {
        if (valuesMap == null) {
            synchronized(com.shangde.ent_portal.logical.dto.enums.EnumAreaType.class)
            {
                if ((valuesMap == null)||(valuesMap.size() == 0)) {
                    valuesMap = CollectionHelper.newMap();
                    EnumAreaType[] values = EnumAreaType.values();
                    for (EnumAreaType venum: values) {
                        valuesMap.put(venum.val, venum);
                    }
                }
            }
        }
        return valuesMap.get(v);
    }
}
