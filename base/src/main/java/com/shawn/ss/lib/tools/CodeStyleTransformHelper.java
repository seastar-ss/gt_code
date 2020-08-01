package com.shawn.ss.lib.tools;

import java.util.Scanner;

/**
 * Created by ss on 2017/10/3.
 */
public class CodeStyleTransformHelper {

    static final int SPAN_BETWEEN_CASE='A'-'a';

    public static String lowerFirstCase(String str) {
        if (str != null) {
            if (str.length() > 1) {
                String first = str.substring(0, 1).toLowerCase();
                return first + str.substring(1);
            } else {
                return str.toLowerCase();
            }
        }
        return null;
    }

    public static String upperFirstCase(String str) {
        if (str != null) {
            if (str.length() > 1) {
                String first = str.substring(0, 1).toUpperCase();
                return first + str.substring(1);
            } else {
                return str.toUpperCase();
            }
        }
        return null;
    }

    public static String underlineSplittedStyleToHumpStyle(String fd) {
        String[] ss = fd.split("_");
        int n = ss.length;
        if (n > 0) {
            StringBuilder ret = new StringBuilder();
            for (int i = 0; i < n; ++i) {
                String s = ss[i];
                if (i != 0) {
                    ret.append(upperFirstCase(s));
                } else {
                    ret.append(lowerFirstCase(s));
                }
            }
            return ret.toString();
        } else {
            return lowerFirstCase(fd);
        }
    }

    public static String humpStyleToUnderlineSplittedStyle(String s) {
//        Scanner scanner=new Scanner(s);
        StringBuilder ret = new StringBuilder();
        int i = 0, n = s.length();
        while (i < n) {
            char c = s.charAt(i);
            if(i>0 && c>='A' && c<='Z'){
                ret.append("_").append((char)(c-SPAN_BETWEEN_CASE));
            }else {
                ret.append(c);
            }
            ++i;
        }
        return ret.toString();
    }

    public static String anonymousString(String real, String str) {
        StringBuilder ret = new StringBuilder();
        if (real.length() > 1) {
            ret.append(real.substring(0, 1)).append(StringHelper.repeat(str, real.length() - 1));
            return ret.toString();
        } else {
            return real;
        }
    }

}
