package com.shawn.ss.lib.tools;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ss on 2016/10/3.
 */
public class ParamHelper {
    static Pattern p = Pattern.compile("([a-zA-Z_0-9\\-]+)=([a-zA-Z_0-9\\-]+)");
    public static final Set<String> OBJECT_METHOD = TypeConstantHelper.IGNORE_METHOD_NAME;
//            new HashSet() {
//        {
//            this.add("getClass");
//            this.add("hashCode");
//            this.add("equals");
//            this.add("toString");
//            this.add("notify");
//            this.add("notifyAll");
//            this.add("wait");
//        }
//    };

    public static Map<String, String> getParamMapping(Pattern p, String args) {
        return getParamMapping(p, new String[]{args});
    }

    public static Map<String, String> getParamMapping(String args) {
        return getParamMapping(p, new String[]{args});
    }

    public static Map<String, String> getParamMapping(Pattern p, String[] args) {
        Map<String, String> ret = CollectionHelper.newMap();
        for (String s : args) {
            Matcher matcher = p.matcher(s);
            if (matcher.matches()) {
                String key = matcher.group(1);
                String value = matcher.group(2);
                ret.put(key, value);
            }
        }
        return ret;
    }

    public static Map<String, String> getParamMapping(String[] args) {
        return getParamMapping(p, args);
    }

    public static List<String> extractAllPattern(Pattern p, String s, int groupIndex) {
        List<String> ret = CollectionHelper.newList();
        Matcher matcher = p.matcher(s);
        int start = 0;
        while (matcher.find(start)) {
            String s1 = matcher.group(groupIndex);
            ret.add(s1);
            start = matcher.end();
        }
        return ret;
    }

    public static Map<String, String> extractAllPattern(Pattern p, String s, int keyGroupIndex, int valueGroupIndex) {
        Map<String, String> ret = CollectionHelper.newMap();
        Matcher matcher = p.matcher(s);
        int start = 0;
        while (matcher.find(start)) {
            String s1 = matcher.group(keyGroupIndex);
            String s2 = matcher.group(valueGroupIndex);
            if (s1 != null && s2 != null)
                ret.put(s1, s2);
            start = matcher.end();
        }
        return ret;
    }


}
