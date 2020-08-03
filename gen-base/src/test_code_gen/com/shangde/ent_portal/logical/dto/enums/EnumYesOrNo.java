package com.shangde.ent_portal.logical.dto.enums;

import java.util.Map;
import com.shawn.ss.lib.tools.CollectionHelper;


/**
 * 表 isUserDefaultOrgEnum.is_user_default_org 相关枚举
 */
public enum EnumYesOrNo {

    /**
     * 否
     */
    no((byte)0, "\u5426"),

    /**
     * 是
     */
    yes((byte)1, "\u662f"),

    /**
     * 未定
     */
    unknown((byte)2, "\u672a\u5b9a");
    public final Byte val;
    public final String desc;
    private static Map<Byte, EnumYesOrNo> valuesMap;

    EnumYesOrNo(Byte v, String s) {
        val = v;
        desc = s;
    }

    public static EnumYesOrNo fromValue(Byte v) {
        if (valuesMap == null) {
            synchronized(com.shangde.ent_portal.logical.dto.enums.EnumYesOrNo.class)
            {
                if ((valuesMap == null)||(valuesMap.size() == 0)) {
                    valuesMap = CollectionHelper.newMap();
                    EnumYesOrNo[] values = EnumYesOrNo.values();
                    for (EnumYesOrNo venum: values) {
                        valuesMap.put(venum.val, venum);
                    }
                }
            }
        }
        return valuesMap.get(v);
    }
}
