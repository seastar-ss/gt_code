package com.shangde.ent_portal.logical.dto.enums;

import java.util.Map;
import com.shawn.ss.lib.tools.CollectionHelper;


/**
 * 表 wiki_structure_info_key_item.itemType 相关枚举
 */
public enum EnumItemType {

    /**
     * 正常
     */
    common((byte)0, "\u6b63\u5e38"),

    /**
     * 主键
     */
    primary((byte)1, "\u4e3b\u952e"),

    /**
     * 唯一标识
     */
    unique((byte)2, "\u552f\u4e00\u6807\u8bc6");
    public final Byte val;
    public final String desc;
    private static Map<Byte, EnumItemType> valuesMap;

    EnumItemType(Byte v, String s) {
        val = v;
        desc = s;
    }

    public static EnumItemType fromValue(Byte v) {
        if (valuesMap == null) {
            synchronized(com.shangde.ent_portal.logical.dto.enums.EnumItemType.class)
            {
                if ((valuesMap == null)||(valuesMap.size() == 0)) {
                    valuesMap = CollectionHelper.newMap();
                    EnumItemType[] values = EnumItemType.values();
                    for (EnumItemType venum: values) {
                        valuesMap.put(venum.val, venum);
                    }
                }
            }
        }
        return valuesMap.get(v);
    }
}
