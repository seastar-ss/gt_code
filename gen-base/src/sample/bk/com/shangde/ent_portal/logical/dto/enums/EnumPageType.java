package com.shangde.ent_portal.logical.dto.enums;

import java.util.Map;
import com.shawn.ss.lib.tools.CollectionHelper;


/**
 * 表 wiki_page.pageType 相关枚举
 */
public enum EnumPageType {

    /**
     * 普通html
     */
    html((byte)0, "\u666e\u901ahtml"),

    /**
     * 文件
     */
    word((byte)1, "\u6587\u4ef6"),

    /**
     * excel文件
     */
    excel((byte)2, "excel\u6587\u4ef6"),

    /**
     * pdf文件
     */
    pdf((byte)3, "pdf\u6587\u4ef6"),

    /**
     * 外链
     */
    link((byte)4, "\u5916\u94fe"),

    /**
     * mp4等视频
     */
    video((byte)5, "mp4\u7b49\u89c6\u9891"),

    /**
     * mp3等音频
     */
    audio((byte)6, "mp3\u7b49\u97f3\u9891"),

    /**
     * zip等压缩文件
     */
    zip((byte)7, "zip\u7b49\u538b\u7f29\u6587\u4ef6"),

    /**
     * png_jpeg_gif图片文件
     */
    pic((byte)8, "png_jpeg_gif\u56fe\u7247\u6587\u4ef6"),

    /**
     * ppt文件
     */
    ppt((byte)9, "ppt\u6587\u4ef6");
    public final Byte val;
    public final String desc;
    private static Map<Byte, EnumPageType> valuesMap;

    EnumPageType(Byte v, String s) {
        val = v;
        desc = s;
    }

    public static EnumPageType fromValue(Byte v) {
        if (valuesMap == null) {
            synchronized(com.shangde.ent_portal.logical.dto.enums.EnumPageType.class)
            {
                if ((valuesMap == null)||(valuesMap.size() == 0)) {
                    valuesMap = CollectionHelper.newMap();
                    EnumPageType[] values = EnumPageType.values();
                    for (EnumPageType venum: values) {
                        valuesMap.put(venum.val, venum);
                    }
                }
            }
        }
        return valuesMap.get(v);
    }
}
