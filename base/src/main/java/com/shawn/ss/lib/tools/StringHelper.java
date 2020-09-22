package com.shawn.ss.lib.tools;import org.springframework.util.StringUtils;import java.io.*;import java.lang.reflect.Field;import java.util.*;import java.util.regex.Matcher;import java.util.regex.Pattern;//import Parser;//import org.json.JSONException;//import org.json.JSONObject;public final class StringHelper {    public static final Pattern pattern = Pattern.compile("\\{([a-zA-Z0-9_\\-]+)\\}");    static DateTimeHelper.StyleDateFormat defualtDateFormat = DateTimeHelper.StyleDateFormat.STYLE_FULL_DATE_AND_FULL_TIME;    static char[] arrayEnclosingChar = {'[', ']'};    static char[] mapEnclosingChar = {'{', '}', ':'};    static char[] repeatObjectEnclosingChar = {'<', '>'};    static String defualtSplitter = ",";    public static void setDefualtDateFormat(DateTimeHelper.StyleDateFormat defualtDateFormat) {        StringHelper.defualtDateFormat = defualtDateFormat;    }    public static char[] getArrayEnclosingChar() {        return arrayEnclosingChar;    }    public static void setArrayEnclosingChar(char[] arrayEnclosingChar) {        if (arrayEnclosingChar == null || arrayEnclosingChar.length != 2) {            return;        }        StringHelper.arrayEnclosingChar = arrayEnclosingChar;    }    public static char[] getMapEnclosingChar() {        return mapEnclosingChar;    }    public static void setMapEnclosingChar(char[] mapEnclosingChar) {        if (mapEnclosingChar == null || mapEnclosingChar.length != 3) {            return;        }        StringHelper.mapEnclosingChar = mapEnclosingChar;    }    public static String getDefualtSplitter() {        return defualtSplitter;    }    public static void setDefualtSplitter(String defualtSplitter) {        StringHelper.defualtSplitter = defualtSplitter;    }    public static char[] getRepeatObjectEnclosingChar() {        return repeatObjectEnclosingChar;    }    public static void setRepeatObjectEnclosingChar(char[] repeatObjectEnclosingChar) {        if (repeatObjectEnclosingChar == null || repeatObjectEnclosingChar.length != 2) {            return;        }        StringHelper.repeatObjectEnclosingChar = repeatObjectEnclosingChar;    }    //    public static final DateTimeHelper dateHelper=DateTimeHelper.newInstance();    static final char[] byteToStr = new char[]{'0', '1', '2', '3', '4',            '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};    public static String repeat(String str, int i) {        StringBuilder ret = new StringBuilder();        for (int x = 0; x < i; ++x) {            ret.append(str);        }        return ret.toString();    }//    public static String base64EncodeObj(Object obj){//        if(obj ==null){//            return null;//        }//        String s = JsonHelper.toJson(obj);//        if(isEmpty(s)){//            return "";//        }//        byte[] bytes = Base64.encodeBase64(s.getBytes());//        return new String(bytes);//    }    public static class SizeHandler {        static final String[] unit = {"B", "KB", "MB", "GB", "TB", "PB"};        static final int D = 1024;        static final String NO_RESULT = "无法计算";        public static final String getSizeStr(final long size) {            // String ret = null;            int unitIndex = 0;            double mn = size;            while (mn > D) {                mn = mn / D;                // rn = mn % D;                ++unitIndex;            }            mn = Math.floor(mn * 10) / 10;            if (unitIndex > unit.length) {                return NO_RESULT;            }            return mn + unit[unitIndex];        }    }    private static boolean testIsObject(Object arg1) {        return arg1 != null && !arg1.getClass().isArray();    }    public static void assembleStr(Object s, StringBuilder ret, String splitter) {        assembleStr(s, ret, splitter, CollectionHelper.newSet());    }    private static void assembleStr(Object s, StringBuilder ret, String splitter, Set<Object> objStack) {        if (splitter == null) {            splitter = defualtSplitter;        }        if (s == null) {            ret.append("null");        } else {            Class<?> sClass = s.getClass();            if (sClass.isArray()) {                Class<?> componentType = sClass.getComponentType();                if (TypeConstantHelper.PRIMITIVE_CLASS.contains(componentType)) {//                    Arrays.deepToString()                    if (componentType == byte.class)                        concat(splitter, (byte[]) s, ret);                    else if (componentType == long.class)                        concat(splitter, (long[]) s, ret);                    else if (componentType == int.class)                        concat(splitter, (int[]) s, ret);                    else if (componentType == short.class)                        concat(splitter, (short[]) s, ret);                    else if (componentType == float.class)                        concat(splitter, (float[]) s, ret);                    else if (componentType == double.class)                        concat(splitter, (double[]) s, ret);                    else if (componentType == boolean.class)                        concat(splitter, (boolean[]) s, ret);                    else if (componentType == char.class)                        concat(splitter, (char[]) s, ret);                } else {                    Object[] ss = (Object[]) s;                    ret.append(arrayEnclosingChar[0]);                    objStack.add(s);                    int n = ss.length;                    for (int i = 0; i < n; ++i) {                        Object obj = ss[i];                        //ret.append(getString(obj)).append(splitter);                        assembleStr(obj, ret, splitter, objStack);                        if (i < n - 1)                            ret.append(splitter);                    }                    ret.append(arrayEnclosingChar[1]);                }            } else if (Collection.class.isAssignableFrom(sClass)) {                Collection c = (Collection) s;                int n = c.size(), i = 0;                ret.append(arrayEnclosingChar[0]);                objStack.add(s);                for (Object v : c) {//                    ret.append(getString(v)).append(splitter);                    assembleStr(v, ret, splitter, objStack);                    if (i < n - 1)                        ret.append(splitter);                    ++i;                }                ret.append(arrayEnclosingChar[1]);            } else if (Map.class.isAssignableFrom(sClass)) {                Map m = (Map) s;                Set<Map.Entry> set = m.entrySet();                ret.append(mapEnclosingChar[0]);                int n = m.size(), i = 0;                objStack.add(s);                for (Map.Entry e : set) {                    //ret.append(getString(e.getKey()));                    Object key = e.getKey();                    assembleStr(key, ret, splitter, objStack);                    ret.append(mapEnclosingChar[2]);                    Object value = e.getValue();                    assembleStr(value, ret, splitter, objStack);                    //ret.append(getString(e.getValue()));                    if (i < n - 1)                        ret.append(splitter);                    ++i;                }                ret.append(mapEnclosingChar[1]);            } else if (Date.class.isAssignableFrom(sClass)) {                Date d = (Date) s;                ret.append(DateTimeHelper.formatDateByFormatName(d, defualtDateFormat));            } else if (String.class == sClass || StringBuffer.class == sClass || StringBuilder.class == sClass ||                    CharSequence.class.isAssignableFrom(sClass)) {                ret.append(s.toString());            } else {                if (objStack.contains(s)) {                    ret.append(repeatObjectEnclosingChar[0]).append(s.getClass().getSimpleName()).append("@").append(s.hashCode()).append(repeatObjectEnclosingChar[1]);                } else {                    ret.append(getString(s));                }            }        }        objStack.remove(s);    }    public static String concat(Object arg1) {        StringBuilder ret = new StringBuilder();        {            assembleStr(arg1, ret, null);        }        return ret.toString();    }    public static String concat(Object arg1, Object arg2) {        StringBuilder ret = new StringBuilder();        {            assembleStr(arg1, ret, null);        }        {            assembleStr(arg2, ret, null);        }        return ret.toString();    }    public static String concat(Object arg1, Object arg2, Object arg3) {        StringBuilder ret = new StringBuilder();        {            assembleStr(arg1, ret, null);        }        {            assembleStr(arg2, ret, null);        }        {            assembleStr(arg3, ret, null);        }        return ret.toString();    }    public static String concat(Object... args) {        if (args == null) {            return "";        }        if (args.length > 0) {            StringBuilder ret = new StringBuilder();            for (Object s : args) {                if (s == null) {                    s = "null";                }                {                    assembleStr(s, ret, null);                }            }            return ret.toString();        } else {            return "";        }    }    public static String concat(String spliter, Object[] args) {        if (args == null) {            return "";        }        if (args.length > 0) {            StringBuilder ret = new StringBuilder();            int n = args.length, i = 0;            for (Object s : args) {                assembleStr(s, ret, spliter);                if (i < n - 1)                    ret.append(spliter);                ++i;//                if (s == null) {//                    s = "null";//                    ret.append(spliter).append(s.toString());//                } else if (!s.getClass().isArray()) {//                    ret.append(spliter).append(s.toString());//                } else {//                    Object[] ss = (Object[]) s;//                    ret.append("[");//                    for (Object obj : ss) {//                        ret.append(obj.toString()).append(",");//                    }//                    ret.append("]");//                }            }//            if (ret.length() > n) {//                ret.delete(0, n);//            }            return ret.toString();        } else {            return "";        }    }//    @SuppressWarnings("unchecked")//    public static String concat(String format, String spliter, List<Object> args) {//        int n = args.size();//        StringBuilder ret = new StringBuilder();//        if (n > 1) {//            int len = spliter.length();////            for (Object arg : args) {//                Object[] p;//                if (arg instanceof List) {//                    List<Object> l = (List<Object>) arg;//                    p = l.toArray();//                } else {//                    p = new Object[]{arg};//                }//                String s = String.format(format, p);//                ret.append(s).append(spliter);//            }//            if (ret.length() > len) {//                ret.delete(0, len);//            }//            return ret.toString();//        } else if (n == 1) {//            assembleStr(args.get(0),ret,spliter);//            return ret.toString();//        }//        return "";////    }    public static String concat(Map<?, ?> c) {        return concat(defualtSplitter, c);    }    public static String concat(String spliter, Map<?, ?> c) {        StringBuilder ret = new StringBuilder();        int n, i = 0;        if (c != null && (n = c.size()) > 0) {            Set<? extends Map.Entry<?, ?>> entries = c.entrySet();            for (Map.Entry<?, ?> x : entries) {                Object key = x.getKey();                assembleStr(key, ret, spliter);                ret.append(mapEnclosingChar[2]);                Object value = x.getValue();                assembleStr(value, ret, spliter);                if (i < n - 1) {                    ret.append(spliter);                }                ++i;//                ret.append(spliter).append(x.toString());            }//            if (ret.length() > n) {//                ret.delete(0, n);//            }        }        return ret.toString();    }    public static String concat(Collection<?> c) {        return concat(defualtSplitter, c);    }    public static String concat(String spliter, Collection<?> c) {        StringBuilder ret = new StringBuilder();        int n, i = 0;        if (c != null && (n = c.size()) > 0) {            for (Object x : c) {                assembleStr(x, ret, spliter);                if (i < n - 1) {                    ret.append(spliter);                }                ++i;//                ret.append(spliter).append(x.toString());            }//            if (ret.length() > n) {//                ret.delete(0, n);//            }        }        return ret.toString();    }    public static String concat(int[] args) {        return concat(defualtSplitter, args);    }    public static String concat(String spliter, int[] args) {        StringBuilder ret = new StringBuilder().append(arrayEnclosingChar[0]);        concat(spliter, args, ret);        ret.append(arrayEnclosingChar[1]);        return ret.toString();    }    public static String concat(long[] args) {        return concat(defualtSplitter, args);    }    public static String concat(String spliter, long[] args) {        StringBuilder ret = new StringBuilder().append(arrayEnclosingChar[0]);        concat(spliter, args, ret);        ret.append(arrayEnclosingChar[1]);        return ret.toString();    }    public static String concat(float[] args) {        return concat(defualtSplitter, args);    }    public static String concat(String spliter, float[] args) {        StringBuilder ret = new StringBuilder().append(arrayEnclosingChar[0]);        concat(spliter, args, ret);        ret.append(arrayEnclosingChar[1]);        return ret.toString();    }    public static String concat(double[] args) {        return concat(defualtSplitter, args);    }    public static String concat(String spliter, double[] args) {        StringBuilder ret = new StringBuilder().append(arrayEnclosingChar[0]);        concat(spliter, args, ret);        ret.append(arrayEnclosingChar[1]);        return ret.toString();    }    public static String concat(byte[] args) {        return concat(defualtSplitter, args);    }    public static String concat(String spliter, byte[] args) {        StringBuilder ret = new StringBuilder().append(arrayEnclosingChar[0]);        concat(spliter, args, ret);        ret.append(arrayEnclosingChar[1]);        return ret.toString();    }    public static String concat(boolean[] args) {        return concat(defualtSplitter, args);    }    public static String concat(String spliter, boolean[] args) {        StringBuilder ret = new StringBuilder().append(arrayEnclosingChar[0]);        concat(spliter, args, ret);        ret.append(arrayEnclosingChar[1]);        return ret.toString();    }    public static String concat(char[] args) {        return concat(defualtSplitter, args);    }    public static String concat(String spliter, char[] args) {        StringBuilder ret = new StringBuilder().append(arrayEnclosingChar[0]);        concat(spliter, args, ret);        ret.append(arrayEnclosingChar[1]);        return ret.toString();    }    static void concat(String spliter, byte[] args, StringBuilder ret) {        if (args == null) {        }        if (args.length > 1) {            //StringBuilder ret = new StringBuilder();            int n = args.length, i = 0;            for (byte s : args) {                ret.append(NumberHelper.byteToUnsignInt(s));                if (i < n - 1) ret.append(spliter);                ++i;            }        } else if (args.length == 1) {            ret.append(args[0]);        } else {        }    }    static void concat(String spliter, short[] args, StringBuilder ret) {        if (args == null) {        }        if (args.length > 1) {            //StringBuilder ret = new StringBuilder();            int n = args.length, i = 0;            for (long s : args) {                ret.append(s);                if (i < n - 1) ret.append(spliter);                ++i;            }        } else if (args.length == 1) {            ret.append(args[0]);        } else {        }    }    static void concat(String spliter, boolean[] args, StringBuilder ret) {        if (args == null) {        }        if (args.length > 1) {            //StringBuilder ret = new StringBuilder();            int n = args.length, i = 0;            for (boolean s : args) {                ret.append(s);                if (i < n - 1) ret.append(spliter);                ++i;            }        } else if (args.length == 1) {            ret.append(args[0]);        } else {        }    }    static void concat(String spliter, char[] args, StringBuilder ret) {        if (args == null) {        }        if (args.length > 1) {            //StringBuilder ret = new StringBuilder();            int n = args.length, i = 0;            for (char s : args) {                ret.append(s);                if (i < n - 1) ret.append(spliter);                ++i;            }        } else if (args.length == 1) {            ret.append(args[0]);        } else {        }    }    static void concat(String spliter, long[] args, StringBuilder ret) {        if (args == null) {        }        if (args.length > 1) {            //StringBuilder ret = new StringBuilder();            int n = args.length, i = 0;            for (long s : args) {                ret.append(s);                if (i < n - 1) ret.append(spliter);                ++i;            }        } else if (args.length == 1) {            ret.append(args[0]);        } else {        }    }    static void concat(String spliter, int[] args, StringBuilder ret) {        if (args == null) {        }        if (args.length > 1) {            //StringBuilder ret = new StringBuilder();            int n = args.length, i = 0;            for (long s : args) {                ret.append(s);                if (i < n - 1) ret.append(spliter);                ++i;            }        } else if (args.length == 1) {            ret.append(args[0]);        } else {        }    }    static void concat(String spliter, double[] args, StringBuilder ret) {        if (args == null) {        }        if (args.length > 1) {            //StringBuilder ret = new StringBuilder();            int n = args.length, i = 0;            for (double s : args) {                ret.append(s);                if (i < n - 1) ret.append(spliter);                ++i;            }        } else if (args.length == 1) {            ret.append(args[0]);        } else {        }    }    static void concat(String spliter, float[] args, StringBuilder ret) {        if (args == null) {        }        if (args.length > 1) {            //StringBuilder ret = new StringBuilder();            int n = args.length, i = 0;            for (float s : args) {                ret.append(s);                if (i < n - 1) ret.append(spliter);                ++i;            }        } else if (args.length == 1) {            ret.append(args[0]);        } else {        }    }    public static String compressStr(int length, String str){        if(str==null){            return null;        }        String compressString = "";        if(StringUtils.isEmpty(str)){            return str;        }        if(length > str.length() || length < 1){            return str;        }else {            compressString  = str.substring(0, length);        }        return compressString;    }    public static class Cn2py {        private static int BEGIN = 45217;        private static int END = 63486;        private static char[] chartable = {'啊', '芭', '擦', '搭', '蛾', '发', '噶',                '哈', '哈', '击', '喀', '垃', '妈', '拿', '哦', '啪', '期', '然', '撒',                '塌', '塌', '塌', '挖', '昔', '压', '匝',};        private static int[] table = new int[27];        private static char[] initialtable = {'a', 'b', 'c', 'd', 'e', 'f',                'g', 'h', 'h', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',                's', 't', 't', 't', 'w', 'x', 'y', 'z',};        static {            for (int i = 0; i < 26; i++) {                table[i] = gbValue(chartable[i]);            }            table[26] = END;        }        public static String cn2py(String SourceStr) {            SourceStr = SourceStr.replaceAll("[^A-Za-z\\d\\u4E00-\\u9FA5]", "");            String Result = "";            int StrLength = SourceStr.length();            int i;            try {                for (i = 0; i < StrLength; i++) {                    Result += Char2Initial(SourceStr.charAt(i));                }            } catch (Exception e) {                Result = "";            }            return Result;        }        public static String cn2pyf(String SourceStr) {            SourceStr = SourceStr.replaceAll("[^A-Za-z\\d\\u4E00-\\u9FA5]", "");            String Result = null;            try {                if (SourceStr.length() > 0) {                    Result = Char2Initial(SourceStr.charAt(0)) + "";                }            } catch (Exception e) {                Result = null;                ;            }            return Result;        }        private static char Char2Initial(char ch) {            if (ch >= 'a' && ch <= 'z') {                return (char) (ch - 'a' + 'A');            }            if (ch >= 'A' && ch <= 'Z') {                return ch;            }            int gb = gbValue(ch);            if ((gb < BEGIN) || (gb > END)) {                return ch;            }            int i;            for (i = 0; i < 26; i++) {                if ((gb >= table[i]) && (gb < table[i + 1])) {                    break;                }            }            if (gb == END) {                i = 25;            }            return initialtable[i];        }        private static int gbValue(char ch) {            String str = new String();            str += ch;            try {                byte[] bytes = str.getBytes("GB2312");                if (bytes.length < 2) {                    return 0;                }                return (bytes[0] << 8 & 0xff00) + (bytes[1] & 0xff);            } catch (Exception e) {                return 0;            }        }    }    public static String replaceStr(String target, Map<String, Object> param) {        String ret = target;        Set<Map.Entry<String, Object>> entries = param.entrySet();        for (Map.Entry<String, Object> entry : entries) {            Object value = entry.getValue();            ret = ret.replace(entry.getKey(), value == null ? "" : value.toString());        }        return ret;    }    public static String genStr(String prefix, String target,                                Map<String, Object> param) {        StringBuilder ret = new StringBuilder(prefix);        Matcher m = pattern.matcher(target);        int start = 0;        if (param != null) {            while (m.find(start)) {                String k = m.group(1);                if (param.containsKey(k)) {                    String kk = param.get(k).toString();                    // if (!kk.equals("___")) {                    ret.append(target.subSequence(start, m.start()));                    ret.append(kk);                    start = m.end();                    // }                } else {                    throw new IllegalArgumentException(StringHelper.concat("param ", k, " not set "));                }            }        }        if (start < target.length()) {            ret.append(target.substring(start));        }        return ret.toString();    }    public static String chopToSize(String str, int len) {//        int n = str.length();//        if (n > len && len > 1) {//            String s = str.substring(0, len - 1);//            return s + "...";//        }        return chopToSize(str, len, null);    }    public static String chopToSize(String str, int len, String appendix) {        appendix = (appendix == null ? "..." : appendix);        int n = str.length();        if (n > len && len > 1) {            String s = str.substring(0, len - 1);            return s + appendix;        }        return str;    }    public static Pattern clearAsciiPattern = Pattern.compile("[^\\p{InCJK_UNIFIED_IDEOGRAPHS}\\x20-\\x7f【】。，！、『』…～、？—“”：；·《》（）￥‘’]", Pattern.CASE_INSENSITIVE);//Pattern.compile("[^]+");    public static Pattern clearUnicodePattern = Pattern.compile("", Pattern.UNICODE_CASE | Pattern.CANON_EQ | Pattern.CASE_INSENSITIVE);    public static String clearUnprintableCodes(String text) {        String ret = clearAsciiPattern.matcher(text).replaceAll("");//        ret=clearUnicodePattern.matcher(ret).replaceAll(" ");        return ret;    }    public static int getStringSum(String src) {        int re = 0, limit = 2048, i = 0;        byte[] bs = src.getBytes();        for (byte b : bs) {            if (i++ < limit) {                re += b;            } else {                break;            }        }        return re;    }    public static boolean isEmpty(String s) {        return s == null || s.length() == 0;    }    public static String toString(Object obj) {        return (obj == null) ? null : obj.toString();    }    public static String exceptionToString(Throwable e) {        StringWriter msg = new StringWriter();        PrintWriter wr = new PrintWriter(msg);        e.printStackTrace(wr);        return msg.toString();    }    public static long getLong(Object get) {//        Object get = src.get(k);        if (get == null) {            return 0;        } else {            String s = get.toString();            if (NumberHelper.isInt(s))                return Long.parseLong(s);            else return 0;        }    }    public static double getDouble(Object get) {//        Object get = src.get(k);        if (get == null) {            return 0;        } else {            String s = get.toString();            if (NumberHelper.isDouble(s))            return Double.parseDouble(s);            else return 0;        }    }    public static int getInt(Object get) {//        Object get = src.get(k);        if (get == null) {            return 0;        } else {            String s = get.toString();            if (NumberHelper.isInt(s))                return Integer.parseInt(s);            else return 0;        }    }    public static String getString(Object get) {//        Object get = src.get(k);        if (get == null) {            return "";        } else {            return get.toString();        }    }    public static Date getDate(Object get) {//        Object get = src.get(k);        if (get == null) {            return null;        } else if (get instanceof String) {            return DateTimeHelper.getDate(get.toString());        } else if (get instanceof Date) {            return (Date) get;        }        return null;    }    public static String encodeHex(byte[] in) {        int n = in.length, k = n * 2;        int size = k >= 512 ? 512 : k;        char[] re = new char[size];        if (n > 0) {            StringBuilder sb = new StringBuilder();            int cur = 0;            for (int i = 0; i < n; ++i) {                int hc = (in[i] >> 4) & 0x0f;                int lc = in[i] & 0x0f;                re[cur] = byteToStr[hc];                re[cur + 1] = byteToStr[lc];                if (cur >= size) {                    sb.append(re, 0, cur);                    cur = 0;                    // Arrays.fill(re, val);                } else {                    cur += 2;                }            }            if (cur > 0) {                sb.append(re, 0, cur);            }            return sb.toString();        }        return "";    }    public static <T> String printObj(T o, Class<T> clz) {        if (o == null) {            return "null";        }        try {            StringBuilder re = new StringBuilder();            Field[] fs = clz.getDeclaredFields();            for (Field f : fs) {                try {                    f.setAccessible(true);                    Object v = f.get(o);                    re.append(f.getName()).append(mapEnclosingChar[2]);                    assembleStr(v, re, defualtSplitter);                } catch (Exception ex) {                    ex.printStackTrace();                }                re.append(" ; ");            }            return re.toString();        } catch (Exception ex) {            ex.printStackTrace();        }        return "";    }    public static void main(String[] args) {//        for (int i = 0; i < 30; ++i) {//            System.out.println(RandomStringHelper.randomName());//        }        String text = "我是测试abc123   ,.  ——【】。……";        byte[] bs = {0x00, -96};        String test = new String(bs);        text = test + text;        System.out.println("before:" + text);        text = clearUnprintableCodes(text);        System.out.println("after :" + text);    }}