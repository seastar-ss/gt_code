package com.shangde.ent_portal.logical.dto.enums;

import java.util.Map;
import com.shawn.ss.lib.tools.CollectionHelper;


/**
 * 表 wiki_structure_info_key_item.itemValueType 相关枚举
 */
public enum EnumItemValueType {

    /**
     * 单行文本
     */
    input((byte)0, "\u5355\u884c\u6587\u672c"),

    /**
     * 多行文本
     */
    text((byte)1, "\u591a\u884c\u6587\u672c"),

    /**
     * 选择值
     */
    select((byte)2, "\u9009\u62e9\u503c"),

    /**
     * 文件上传
     */
    file((byte)3, "\u6587\u4ef6\u4e0a\u4f20");
    public final Byte val;
    public final String desc;
    private static Map<Byte, EnumItemValueType> valuesMap;

    EnumItemValueType(Byte v, String s) {
        val = v;
        desc = s;
    }

    public static EnumItemValueType fromValue(Byte v) {
        if (valuesMap == null) {
            synchronized(com.shangde.ent_portal.logical.dto.enums.EnumItemValueType.class)
            {
                if ((valuesMap == null)||(valuesMap.size() == 0)) {
                    valuesMap = CollectionHelper.newMap();
                    EnumItemValueType[] values = EnumItemValueType.values();
                    for (EnumItemValueType venum: values) {
                        valuesMap.put(venum.val, venum);
                    }
                }
            }
        }
        return valuesMap.get(v);
    }
}
