package com.shawn.ss.lib.tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

//import com.cs.ss.lib.rabbitmq.rpc.InvokeException;
//import com.cs.ss.lib.rabbitmq.rpc.model.CallerInfo;

/**
 * Created by ss on 2016/6/28.
 */
public class TypeConstantHelper {

    public static class TypeException extends RuntimeException {
        public TypeException(String msg) {
            super(msg);
        }

        public static TypeException newException(String msg) {
            return new TypeException(msg);
        }
    }

    public static final SimpleDateFormat DEFAULT_DATE_PARSER = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy", Locale.ENGLISH);
    public static final Set<String> IGNORE_METHOD_NAME;

    public static final Set<Class<?>> PRIMITIVE_CLASS;
    public static final Set<Class<?>> PRIMITIVE_BOX_CLASS;
    public static final Set<Class<?>> BASIC_DATA_CLASS;
    public static final Set<String> BASIC_DATA_CLASS_NAMES;
    public static final Set<String> PRIMITIVE_CLASS_NAMES;
    public static final Set<String> COLLECTION_CLASS_NAMES;
    public static final Set<String> MAP_CLASS_NAMES;
    // protected static final Set<Class> COMMON_CLASS;
    // protected static final Set<Class> DATA_CLASS;
    public static final Set<Class<?>> NUMBER_CLASS;
    public static final Map<Class<?>, Class<?>> BOXES_CLASS;

    static {
        IGNORE_METHOD_NAME = new HashSet<String>();
        PRIMITIVE_CLASS = new HashSet<Class<?>>();
        PRIMITIVE_BOX_CLASS=new HashSet<Class<?>>();
        BASIC_DATA_CLASS = new HashSet<Class<?>>();
        NUMBER_CLASS = new HashSet<Class<?>>();
        PRIMITIVE_CLASS_NAMES = new HashSet<String>();
        BASIC_DATA_CLASS_NAMES = new HashSet<String>();
        COLLECTION_CLASS_NAMES = new HashSet<String>();
        MAP_CLASS_NAMES = new HashSet<>();

        Class<?>[] pc = {int.class, long.class, short.class, float.class,
                double.class, byte.class, boolean.class, char.class,
        };
        String[] pcName = {int.class.getName(), long.class.getName(), short.class.getName(), float.class.getName(),
                double.class.getName(), byte.class.getName(), boolean.class.getName(), char.class.getName(),
                Integer.class.getName(), Long.class.getName(), Short.class.getName(), Float.class.getName(), Byte.class.getName(),
                Double.class.getName(), String.class.getName(), Boolean.class.getName(), Character.class.getName()};
        String[] collectionClasses = {
                java.util.List.class.getName(), java.util.ArrayList.class.getName(), java.util.LinkedList.class.getName(),
                java.util.Set.class.getName(), java.util.HashSet.class.getName(), java.util.TreeSet.class.getName(),
                java.util.Collection.class.getName(), java.util.LinkedHashSet.class.getName(),
        };
        String[] mapClasses = {java.util.Map.class.getName(), java.util.HashMap.class.getName(), java.util.TreeMap.class.getName(),
                java.util.LinkedHashMap.class.getName(),};
        COLLECTION_CLASS_NAMES.addAll(Arrays.asList(collectionClasses));
        MAP_CLASS_NAMES.addAll(Arrays.asList(mapClasses));
        List<String> pcNameList = Arrays.asList(pcName);


        List<Class<?>> clist = Arrays.asList(pc);
        String[] commonMethod = new String[]{"wait", "notify", "notifyAll",
                "clone", "getClass", "toString", "equals", "hashCode"};
        List<String> slist = Arrays.asList(commonMethod);
        NUMBER_CLASS.addAll(clist);
        PRIMITIVE_CLASS_NAMES.addAll(pcNameList);
        PRIMITIVE_CLASS.addAll(clist);
//        BASIC_DATA_CLASS_NAMES.addAll(clist);
        BASIC_DATA_CLASS_NAMES.addAll(pcNameList);
//        BASIC_DATA_CLASS.addAll(PRIMITIVE_CLASS);
        BASIC_DATA_CLASS.add(String.class);
        BASIC_DATA_CLASS.add(Date.class);
        BASIC_DATA_CLASS_NAMES.add(String.class.getName());
        BASIC_DATA_CLASS_NAMES.add(Date.class.getName());
//        PRIMITIVE_CLASS.add(String.class);
//        PRIMITIVE_CLASS.add(Date.class);
        IGNORE_METHOD_NAME.addAll(slist);
        BOXES_CLASS = CollectionHelper.newMap();
        BOXES_CLASS.put(int.class, Integer.class);
        BOXES_CLASS.put(byte.class, Byte.class);
        BOXES_CLASS.put(short.class, Short.class);
        BOXES_CLASS.put(long.class, Long.class);
        BOXES_CLASS.put(float.class, Float.class);
        BOXES_CLASS.put(double.class, Double.class);
        BOXES_CLASS.put(boolean.class, Boolean.class);
        BOXES_CLASS.put(char.class, Character.class);
        Map<Class<?>, Class<?>> revertMap = CollectionHelper.revertMap(BOXES_CLASS);
        BOXES_CLASS.putAll(revertMap);
        BASIC_DATA_CLASS.addAll(BOXES_CLASS.keySet());
        PRIMITIVE_BOX_CLASS.addAll(BOXES_CLASS.values());

        BASIC_DATA_CLASS.add(java.sql.Timestamp.class);
        BASIC_DATA_CLASS_NAMES.add(java.sql.Timestamp.class.getName());
    }

//    public static Object uppackPrType(byte[] content, String contentType) {
//        return null;
//    }

//    public static <T> T castType(String content, String contentType) {
//        return (T) uppackPrType(content, contentType);
//    }

    public static <T> T toObject(byte[] content, Class<T> tClass) {
        if(content==null || tClass==null){
            return null;
        }
        try {
            if (BASIC_DATA_CLASS.contains(tClass)) {
                return (T) uppackPrType(content, tClass);
            } else {
                String str = new String(content);
                return (T) JSONHelper.fromJson(str, tClass);
//            return (T) StringHelper.
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw TypeException.newException(content + " can't be cast obj " + tClass.getName() + ":" + ex.getMessage());
        }
//        return null;
    }

    public static <T> T getObject(String content, Class<T> tClass) {
        if(content==null || tClass==null){
            return null;
        }
        try {
            if (BASIC_DATA_CLASS.contains(tClass)) {
                return (T) uppackPrType(content, tClass.getName());
            } else {

                return (T) JSONHelper.fromJson(content, tClass);
//            return (T) StringHelper.
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw TypeException.newException(content + " can't be cast obj " + tClass.getName() + ":" + ex.getMessage());
        }
//        return null;
    }

    public static <T> byte[] fromObjectBin(T obj) {
        if (obj == null) {
            return null;
        }
        Class<?> tClass = obj.getClass();
        try {
            if (BASIC_DATA_CLASS.contains(tClass)) {
                return packPrType(obj,tClass);
            } else {
                String json=JSONHelper.toJson(obj);
                return json.getBytes();
//            return (T) StringHelper.
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw TypeException.newException(obj + " with type " + tClass.getName() + "can't be transfer to string :" + ex.getMessage());
        }
    }

    public static <T> String fromObject(T obj) {
        if (obj == null) {
            return null;
        }
        Class<?> tClass = obj.getClass();
        try {
            if (BASIC_DATA_CLASS.contains(tClass)) {
                if(tClass.equals(Date.class)){
//                    DateTimeHelper intance=DateTimeHelper.newInstance();
//                    intance.(DateTimeHelper.DEFUALT_STYLE_LONG_DATE_LONG_TIME_FORMAT,obj.toString());
                    return DateTimeHelper.formatDate((Date) obj);
                }else
                    return obj.toString();
            } else {
                return JSONHelper.toJson(obj);
//            return (T) StringHelper.
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw TypeException.newException(obj + " with type " + tClass.getName() + "can't be transfer to string :" + ex.getMessage());
        }
    }

    public static byte[] packPrType(Object content, Class contentType) {
//        String content = arg.getContent();
//        String contentType = arg.getContentType();
//        java.lang.Character c;
//        Date d;
//        Long l=1l;
//        content=content.trim();
        if (content == null || contentType==null) {
            return null;
        }
        if (contentType.equals(int.class) || contentType.equals(Integer.class) ) {
            return NumberHelper.intToBytes((int)content);
        } else if (contentType.equals(Long.class) || contentType.equals(long.class)) {
            return NumberHelper.longToBytes((long)content);
        } else if ( contentType.equals(Byte.class) || contentType.equals(byte.class)) {
            return new byte[]{(byte)content};
        } else if ( contentType.equals(Character.class) || contentType.equals(char.class)) {
//            if (content.length > 0)
            Character c = (Character) content;
            return c.toString().getBytes();
        } else if ( contentType.equals(Boolean.class) || contentType.equals(boolean.class)) {
            Boolean b = (Boolean) content;
            return new byte[]{(byte)(b?1:0)};
        } else if ( contentType.equals(Double.class) || contentType.equals(double.class)) {
            return NumberHelper.doubleToByte((double)content);
        } else if ( contentType.equals(Float.class) || contentType.equals(float.class)) {
            return NumberHelper.doubleToByte((double)content);
        } else if ( contentType.equals(Short.class) || contentType.equals(short.class)) {
            return NumberHelper.intToBytes((int)content);
        } else if (contentType.equals(String.class) || CharSequence.class.isAssignableFrom(contentType)) {
            return content.toString().getBytes();
        } else if(Number.class.isAssignableFrom(contentType)){
            return NumberHelper.doubleToByte(((Number)content).doubleValue());
        } else if (contentType.equals(Date.class) || Date.class.isAssignableFrom(contentType)) {
            Date d=(Date)content;
            long time = d.getTime();
            return NumberHelper.longToBytes(time);
        }
        return null;
    }

    public static Object uppackPrType(byte[] content, Class contentType) {
//        String content = arg.getContent();
//        String contentType = arg.getContentType();
//        java.lang.Character c;
//        Date d;
//        Long l=1l;
//        content=content.trim();
        if (content == null || content.length == 0) {
            return null;
        }
        if (contentType.equals(int.class) || contentType.equals(Integer.class)) {
            return NumberHelper.bytesToInt(content);
        } else if (contentType.equals(Long.class) || contentType.equals(long.class)) {
            return NumberHelper.bytesToLong(content);
        } else if (contentType.equals(Byte.class) || contentType.equals(byte.class)) {
            return content[0];
        } else if ( contentType.equals(Character.class) || contentType.equals(char.class)) {
//            if (content.length > 0)
            return content[0];
        } else if (contentType.equals(Boolean.class) || contentType.equals(boolean.class)) {
            return content[0]==1;
        } else if (contentType.equals(Double.class) || contentType.equals(double.class)) {
            return NumberHelper.byteToDouble(content);
        } else if (contentType.equals(Float.class) || contentType.equals(float.class)) {
            return NumberHelper.byteToDouble(content);
        } else if (contentType.equals(Short.class) || contentType.equals(short.class)) {
            return NumberHelper.bytesToInt(content);
        } else if (contentType.equals(String.class) || CharSequence.class.equals(contentType)) {
            return new String(content);
        } else if (contentType.equals(Date.class)) {
            long l = NumberHelper.bytesToLong(content);
            return new Date(l);
        }
        return null;
    }

    public static Object uppackPrType(String content, String contentType) {
//        String content = arg.getContent();
//        String contentType = arg.getContentType();
//        java.lang.Character c;
//        Date d;
//        Long l=1l;
//        content=content.trim();
        if (content == null || content.trim().length() == 0) {
            return null;
        }
        if (contentType.equals("I") || contentType.equals("java.lang.Integer") || contentType.equals("int")) {
            return Integer.parseInt(content);
        } else if (contentType.equals("J") || contentType.equals("java.lang.Long") || contentType.equals("long")) {
            return Long.parseLong(content);
        } else if (contentType.equals("B") || contentType.equals("java.lang.Byte") || contentType.equals("byte")) {
            return Byte.parseByte(content);
        } else if (contentType.equals("C") || contentType.equals("java.lang.Character") || contentType.equals("char")) {
            if (content.length() > 0)
                return content.charAt(0);
        } else if (contentType.equals("Z") || contentType.equals("java.lang.Boolean") || contentType.equals("boolean")) {
            return Boolean.parseBoolean(content);
        } else if (contentType.equals("D") || contentType.equals("java.lang.Double") || contentType.equals("double")) {
            return Double.parseDouble(content);
        } else if (contentType.equals("F") || contentType.equals("java.lang.Float") || contentType.equals("float")) {
            return Float.parseFloat(content);
        } else if (contentType.equals("S") || contentType.equals("java.lang.Short") || contentType.equals("short")) {
            return Short.parseShort(content);
        } else if (contentType.equals("java.lang.String")) {
            return content;
        } else if (contentType.equals("java.util.Date")) {
            try {
                return DateTimeHelper.getDate(content);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }


    public static Object testAndUppackPrimitiveType(String content, String contentType) {
//        String content = arg.getContent();
//        String contentType = arg.getContentType();
//        java.lang.Character c;
//        Date d;
//        Long l=1l;
//        content=content.trim();

        if (contentType.equals("I") || contentType.equals("java.lang.Integer") || contentType.equals("int")) {
            if(content==null){
                content="0";
            }
            return Integer.parseInt(content);
        } else if (contentType.equals("J") || contentType.equals("java.lang.Long") || contentType.equals("long")) {
            if(content==null){
                content="0";
            }
            return Long.parseLong(content);
        } else if (contentType.equals("B") || contentType.equals("java.lang.Byte") || contentType.equals("byte")) {
            if(content==null){
                content="0";
            }
            return Byte.parseByte(content);
        } else if (contentType.equals("C") || contentType.equals("java.lang.Character") || contentType.equals("char")) {
            if(content==null){
                content="0";
            }
            if (content.length() > 0)
                return content.charAt(0);
        } else if (contentType.equals("Z") || contentType.equals("java.lang.Boolean") || contentType.equals("boolean")) {
            if(content==null){
                content="false";
            }
            return Boolean.parseBoolean(content);
        } else if (contentType.equals("D") || contentType.equals("java.lang.Double") || contentType.equals("double")) {
            if(content==null){
                content="0.0";
            }
            return Double.parseDouble(content);
        } else if (contentType.equals("F") || contentType.equals("java.lang.Float") || contentType.equals("float")) {
            if(content==null){
                content="0.0";
            }
            return Float.parseFloat(content);
        } else if (contentType.equals("S") || contentType.equals("java.lang.Short") || contentType.equals("short")) {
            if(content==null){
                content="0";
            }
            return Short.parseShort(content);
        } else if (contentType.equals("java.lang.String")) {
            if(content==null){
                content="";
            }
            return content;
        } else if (contentType.equals("java.util.Date")) {
            if(content==null){
                return new Date();
            }
            try {
                return DateTimeHelper.getDate(content);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

//    public static <T> T[] castToArray(Object obj,Class<T> clazz) {
//
//    }

//    public static String toString(Object content) {
////        String content = arg.getContent();
////        String contentType = arg.getContentType();
////        java.lang.Character c;
////        Date d;
//        if (content == null) {
//            return null;
//        }
//        Class<?> contentType=content.getClass();
//        try {
//            if (contentType.equals(Integer.class) || contentType.equals(int.class)) {
//                String cont = content.toString();
//                return Integer.parseInt(cont);
//            } else if (contentType.equals(Long.class) || contentType.equals(long.class)) {
//                String cont = content.toString();
//                return Long.parseLong(cont);
//            } else if (contentType.equals(Byte.class) || contentType.equals(byte.class)) {
//                String cont = content.toString();
//                return Byte.parseByte(cont);
//            } else if (contentType.equals(Character.class) || contentType.equals(char.class)) {
//                String cont = content.toString();
//                return cont.charAt(0);
//            } else if (contentType.equals(Boolean.class) || contentType.equals(boolean.class)) {
//                String cont = content.toString();
//                return Boolean.parseBoolean(cont);
//            } else if (contentType.equals(Double.class) || contentType.equals(double.class)) {
//                String cont = content.toString();
//                return Double.parseDouble(cont);
//            } else if (contentType.equals(Float.class) || contentType.equals(float.class)) {
//                String cont = content.toString();
//                return Float.parseFloat(cont);
//            } else if (contentType.equals(Short.class) || contentType.equals(short.class)) {
//                String cont = content.toString();
//                return Short.parseShort(cont);
//            } else if (contentType.equals(String.class)) {
//                return content;
//            } else if (contentType.equals(Date.class)) {
//                String cont = content.toString();
//                try {
//                    return DEFAULT_DATE_PARSER.parse(cont);
//                } catch (ParseException e) {
//                    e.printStackTrace();
//                    throw TypeException.newException("data format not acceptable");
//                }
//            } else {
//                return contentType.cast(content);
//            }
//        } catch (NumberFormatException ex) {
//            throw TypeException.newException("number format not acceptable");
//        } catch (ClassCastException ex) {
//            throw TypeException.newException("object can't cast to  acceptable type");
//        }
////        return null;
//    }

    public static Object testAndPackPrimitiveType(Object content, Class<?> contentType) {
//        String content = arg.getContent();
//        String contentType = arg.getContentType();
//        java.lang.Character c;
//        Date d;
//        if (content == null) {
//            return content;
//        }
        try {
            if (contentType.equals(Integer.class) || contentType.equals(int.class)) {
                String cont = (content==null?content.toString():"0");
                return Integer.parseInt(cont);
            } else if (contentType.equals(Long.class) || contentType.equals(long.class)) {
                String cont = (content==null?content.toString():"0");
                return Long.parseLong(cont);
            } else if (contentType.equals(Byte.class) || contentType.equals(byte.class)) {
                String cont = (content==null?content.toString():"0");
                return Byte.parseByte(cont);
            } else if (contentType.equals(Character.class) || contentType.equals(char.class)) {
                String cont = (content==null?content.toString():"0");
                return cont.charAt(0);
            } else if (contentType.equals(Boolean.class) || contentType.equals(boolean.class)) {
                String cont =(content==null?content.toString():"false");
                return Boolean.parseBoolean(cont);
            } else if (contentType.equals(Double.class) || contentType.equals(double.class)) {
                String cont = (content==null?content.toString():"0.0");
                return Double.parseDouble(cont);
            } else if (contentType.equals(Float.class) || contentType.equals(float.class)) {
                String cont =(content==null?content.toString():"0.0");
                return Float.parseFloat(cont);
            } else if (contentType.equals(Short.class) || contentType.equals(short.class)) {
                String cont = (content==null?content.toString():"0");
                return Short.parseShort(cont);
            } else if (contentType.equals(String.class)) {
                return content;
            } else if (contentType.equals(Date.class)) {
                String cont = content.toString();
                try {
                    return DateTimeHelper.getDate(cont);
                } catch (Exception e) {
                    e.printStackTrace();
                    throw TypeException.newException("data format not acceptable");
                }
            } else {
                return contentType.cast(content);
            }
        } catch (NumberFormatException ex) {
            throw TypeException.newException("number format not acceptable");
        } catch (ClassCastException ex) {
            throw TypeException.newException("object can't cast to  acceptable type");
        }
//        return null;
    }

    public static Object testPackPrType(Object content, Class<?> contentType) {
//        String content = arg.getContent();
//        String contentType = arg.getContentType();
//        java.lang.Character c;
//        Date d;
        if (content == null) {
            return content;
        }
        try {
            if (contentType.equals(Integer.class) || contentType.equals(int.class)) {
                String cont = content.toString();
                return Integer.parseInt(cont);
            } else if (contentType.equals(Long.class) || contentType.equals(long.class)) {
                String cont = content.toString();
                return Long.parseLong(cont);
            } else if (contentType.equals(Byte.class) || contentType.equals(byte.class)) {
                String cont = content.toString();
                return Byte.parseByte(cont);
            } else if (contentType.equals(Character.class) || contentType.equals(char.class)) {
                String cont = content.toString();
                return cont.charAt(0);
            } else if (contentType.equals(Boolean.class) || contentType.equals(boolean.class)) {
                String cont = content.toString();
                return Boolean.parseBoolean(cont);
            } else if (contentType.equals(Double.class) || contentType.equals(double.class)) {
                String cont = content.toString();
                return Double.parseDouble(cont);
            } else if (contentType.equals(Float.class) || contentType.equals(float.class)) {
                String cont = content.toString();
                return Float.parseFloat(cont);
            } else if (contentType.equals(Short.class) || contentType.equals(short.class)) {
                String cont = content.toString();
                return Short.parseShort(cont);
            } else if (contentType.equals(String.class)) {
                return content;
            } else if (contentType.equals(Date.class)) {
                String cont = content.toString();
                try {
                    return DateTimeHelper.getDate(cont);
                } catch (Exception e) {
                    e.printStackTrace();
                    throw TypeException.newException("data format not acceptable");
                }
            } else {
                return contentType.cast(content);
            }
        } catch (NumberFormatException ex) {
            throw TypeException.newException("number format not acceptable");
        } catch (ClassCastException ex) {
            throw TypeException.newException("object can't cast to  acceptable type");
        }
//        return null;
    }


    public static boolean boxable(Class<?> type, Class<?> argCls) {
        Class<?> aClass = BOXES_CLASS.get(type);
        return aClass == null ? false : aClass.equals(argCls);
    }

    /**
     * Created by ss on 2016/10/6.
     */
    public static enum PrimitiveTypes {
        INT(Integer.class, "int"), STR(String.class, "String"), LONG(Long.class, "long"), DOUBLE(Double.class, "double"),
        DATE(Date.class, "Date"), BOOLEAN(Boolean.class, "boolean"), CHAR(Character.class, "char");
        private static volatile Map<String, PrimitiveTypes> map;
        private final Class<?> clazz;
        private final String shortName;

        PrimitiveTypes(Class<?> clazz, String shortName) {
            this.clazz = clazz;
            this.shortName = shortName;
        }

        public Class<?> getClazz() {
            return clazz;
        }

        public String getShortName() {
            return shortName;
        }

        public String getTransferedName() {
            String n = this.name();
            return CodeStyleTransformHelper.upperFirstCase(n.toLowerCase());
        }

        public static PrimitiveTypes getByShortName(String shortName) {
            if (map == null) {
                synchronized (PrimitiveTypes.class) {
                    if (map == null) {
                        map = new HashMap<>();
                        PrimitiveTypes[] values = PrimitiveTypes.values();
                        for (PrimitiveTypes value : values) {
                            map.put(value.getShortName(), value);
                        }
                    }
                }
            }
            return map.get(shortName);
        }
    }
}
