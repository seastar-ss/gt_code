package com.shangde.ent_portal.logical.dto.enums;

import java.util.Map;
import com.shawn.ss.lib.tools.CollectionHelper;


/**
 * 表 meterialProductTypeEnum.meterial_product_type 相关枚举
 */
public enum EnumMaterialProductType {

    /**
     * 原料
     */
    material((byte)0, "\u539f\u6599"),

    /**
     * 半成品
     */
    internalProduct((byte)1, "\u534a\u6210\u54c1"),

    /**
     * 成品
     */
    product((byte)2, "\u6210\u54c1"),

    /**
     * 废品
     */
    waste((byte)3, "\u5e9f\u54c1"),

    /**
     * 设备
     */
    device((byte)4, "\u8bbe\u5907");
    public final Byte val;
    public final String desc;
    private static Map<Byte, EnumMaterialProductType> valuesMap;

    EnumMaterialProductType(Byte v, String s) {
        val = v;
        desc = s;
    }

    public static EnumMaterialProductType fromValue(Byte v) {
        if (valuesMap == null) {
            synchronized(com.shangde.ent_portal.logical.dto.enums.EnumMaterialProductType.class)
            {
                if ((valuesMap == null)||(valuesMap.size() == 0)) {
                    valuesMap = CollectionHelper.newMap();
                    EnumMaterialProductType[] values = EnumMaterialProductType.values();
                    for (EnumMaterialProductType venum: values) {
                        valuesMap.put(venum.val, venum);
                    }
                }
            }
        }
        return valuesMap.get(v);
    }
}
