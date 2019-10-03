package com.shangde.ent_portal.logical.dto.enums;

import java.util.Map;
import com.shawn.ss.lib.tools.CollectionHelper;


/**
 * 表 wiki_index.indexStatus 相关枚举
 */
public enum EnumIndexStatus {

    /**
     * 正常
     */
    normal((byte)0, "\u6b63\u5e38"),

    /**
     * 星标
     */
    start((byte)1, "\u661f\u6807"),

    /**
     * 删除的
     */
    deleted((byte)-1, "\u5220\u9664\u7684");
    public final Byte val;
    public final String desc;
    private static Map<Byte, EnumIndexStatus> valuesMap;

    EnumIndexStatus(Byte v, String s) {
        val = v;
        desc = s;
    }

    public static EnumIndexStatus fromValue(Byte v) {
        if (valuesMap == null) {
            synchronized(com.shangde.ent_portal.logical.dto.enums.EnumIndexStatus.class)
            {
                if ((valuesMap == null)||(valuesMap.size() == 0)) {
                    valuesMap = CollectionHelper.newMap();
                    EnumIndexStatus[] values = EnumIndexStatus.values();
                    for (EnumIndexStatus venum: values) {
                        valuesMap.put(venum.val, venum);
                    }
                }
            }
        }
        return valuesMap.get(v);
    }
}
