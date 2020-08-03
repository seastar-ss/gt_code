package com.shangde.ent_portal.logical.dto.enums;

import java.util.Map;
import com.shawn.ss.lib.tools.CollectionHelper;


/**
 * 表 orgRoleEnum.org_role 相关枚举
 */
public enum EnumOrgUserRole {

    /**
     * 普通
     */
    common((byte)1, "\u666e\u901a"),

    /**
     * 管理者
     */
    manager((byte)2, "\u7ba1\u7406\u8005"),

    /**
     * 负责人
     */
    admin((byte)3, "\u8d1f\u8d23\u4eba");
    public final Byte val;
    public final String desc;
    private static Map<Byte, EnumOrgUserRole> valuesMap;

    EnumOrgUserRole(Byte v, String s) {
        val = v;
        desc = s;
    }

    public static EnumOrgUserRole fromValue(Byte v) {
        if (valuesMap == null) {
            synchronized(com.shangde.ent_portal.logical.dto.enums.EnumOrgUserRole.class)
            {
                if ((valuesMap == null)||(valuesMap.size() == 0)) {
                    valuesMap = CollectionHelper.newMap();
                    EnumOrgUserRole[] values = EnumOrgUserRole.values();
                    for (EnumOrgUserRole venum: values) {
                        valuesMap.put(venum.val, venum);
                    }
                }
            }
        }
        return valuesMap.get(v);
    }
}
