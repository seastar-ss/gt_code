/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shawn.ss.lib.tools;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
//import java.util.logging.Level;
//import java.util.logging.Logger;
import java.util.regex.Pattern;

/**
 * @author ss
 */
public class DateTimeHelper {

    //    public static final String SHORT_TIME_FORMAT = "HH:mm";
//    public static final String LONG_TIME_FORMAT = "HH:mm:ss";
//    public static final String SHORT_DATE_FORMAT = "MM/dd";
//    public static final String LONG_DATE_FORMAT = "yyyy-MM-dd";
//    public static final String SHORT_DATE_SHORT_TIME_FORMAT = "MM/dd HH:mm";
    public static final String DEFUALT_STYLE_LONG_DATE_LONG_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final StyleDateFormat DEFUALT_FORMAT = StyleDateFormat.STYLE_FULL_DATE_AND_FULL_TIME;
    //    public static final String LONG_DATE_SHORT_TIME_FORMAT = "yyyy-MM-dd HH:mm";
//    public static final String DATA_FORMAT = "yyyy-MM-dd HH:mm:ss SSS";
    public static final long[] SPANS = {1000, 60, 60, 24, 30, 12, 100};
    public static final String[] SPAN_TAGS = {"毫秒", "秒", "分钟", "小时", "天",
            "月", "年", "世纪"};
    public static final int[] COMMON_FIELDS = {Calendar.YEAR,
            Calendar.MONTH, Calendar.DAY_OF_MONTH, Calendar.HOUR_OF_DAY,
            Calendar.MINUTE, Calendar.SECOND, Calendar.MILLISECOND};
    private static final int POOL_COUNT = 30;
    private static final AtomicInteger COUNTER = new AtomicInteger();
    static final DateTimeHelper[] helpers = new DateTimeHelper[POOL_COUNT];

    static final Map<Integer, Integer> FIELD_NEXT_MAP = new HashMap<Integer, Integer>() {
        {
            this.put(Calendar.YEAR, Calendar.MONTH);
            this.put(Calendar.MONTH, Calendar.DAY_OF_MONTH);
            this.put(Calendar.DATE, Calendar.HOUR_OF_DAY);
            this.put(Calendar.WEEK_OF_YEAR, Calendar.DAY_OF_WEEK);
        }
    };
    public static final long SPAN_HOUR = 3600 * 1000;
    public static final long SPAN_DAY = SPAN_HOUR * 24;
    //    static final Random random = new Random(System.currentTimeMillis());

    public static DateTimeHelper newInstance() {
        int x = COUNTER.incrementAndGet();
        if (x >= POOL_COUNT) {
            x = 0;
            COUNTER.set(0);
        }
        if (helpers[x] != null) {
            return helpers[x];
        } else {
            synchronized (DateTimeHelper.class) {
                if (helpers[x] == null) {
                    helpers[x] = new DateTimeHelper();
                }
            }
            return helpers[x];
        }
    }

//    static EnumMap<StyleDateFormat, Pattern> maps;
//    static EnumMap<StyleDateFormat, SimpleDateFormat> formats;
//    static SimpleDateFormat format;

    public static final String REGEX_YEAR_PATTERN = "((?:(?:19)|(?:20))[0-9]{2})";
    public static final String REGEX_DAY_PATTERN = "((?:[0-2]?[0-9])|(?:3[0-1]))";
    public static final String REGEX_MONTH_PATTERN = "((?:0?[1-9])|(?:1[0-2]))";
    public static final String REGEX_HOUR_PATTERN = "((?:[0-1]?[0-9])|(?:2[0-3]))";
    public static final String REGEX_MINITE_PATTERN = "((?:[0-5]?[0-9]))";
    public static final String REGEX_SECOND_PATTERN = "((?:[0-5]?[0-9]))";
    public static final String REGEX_MILLI_SECOND_PATTERN = "(?:[0-9]{3})";
    public static final String REGEX_GMT_PATTERN = "(?:(GMT)|(UTC)|(PDT)|(CST))";
    public static final String REGEX_ENG_MONTH_PATTERN = "(?:(Jan)|(Feb)|(Mar)|(Apr)|(May)|(Jun)|(Jul)|(Aug)|(Sep)|(Oct)|(Nov)|(Dec))";
    //Pattern p=Pattern.compile("(?:(Jan)|(Feb)|(Apr)|(May)|(Jun)|(Jul)|(Aug)|(Sep)|(Oct)|(Nov)|(Dec))",Pattern.CASE_INSENSITIVE);
    //"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep","Oct", "Nov", "Dec"
    public static final String REGEX_ENG_WEEK_DAY_PATTERN = "(?:(Sun)|(Mon)|(Tue)|(Wed)|(Thu)|(Fri)|(Sat))";
    //Sun,Mon,Tue,Wed,Thu,Fri,Sat

//    String pattern;
//    String matchPattern;
//    Pattern p;
//    String sample;
//    String name;

//    public DateTimePatterns(String pattern,String matchPattern){
//
//        this.p= Pattern.compile(matchPattern);
//        this.format= new SimpleDateFormat(pattern);
//    }


//    public static final String STYLE_FULL_DATE = "STYLE_FULL_DATE";
//    public static final String STYLE_FULL_DATE_IN_CHINESE = "STYLE_FULL_DATE_IN_CHINESE";
//    public static final String STYLE_FULL_DATE_AND_FULL_TIME = "STYLE_FULL_DATE_AND_FULL_TIME";
//    public static final String STYLE_FULL_DATE_AND_FULL_TIME_IN_CHINESE = "STYLE_FULL_DATE_AND_FULL_TIME_IN_CHINESE";
//    public static final String STYLE_FULL_DATE_AND_FULL_TIME_WITH_MSECONDS = "STYLE_FULL_DATE_AND_FULL_TIME_WITH_MSECONDS";
//    public static final String STYLE_FULL_DATE_NO_SPLITER = "STYLE_FULL_DATE_NO_SPLITER";
//    public static final String STYLE_FULL_DATE_AND_TIME_NO_SPLITER = "STYLE_FULL_DATE_AND_TIME_NO_SPLITER";
//    public static final String STYLE_FULL_DATE_AND_TIME_SPECIAL_IN_ENGLISH = "STYLE_FULL_DATE_AND_TIME_SPECIAL_IN_ENGLISH";
//    public static final String STYLE_FULL_DATE_IN_ENGLISH = "STYLE_FULL_DATE_IN_ENGLISH";
//    public static final String STYLE_FULL_DATE_WITH_TIME_COMMON_IN_ENGLISH = "STYLE_FULL_DATE_WITH_TIME_COMMON_IN_ENGLISH";

    public static enum StyleDateFormat {
        STYLE_FULL_DATE(Locale.SIMPLIFIED_CHINESE, "yyyy-MM-dd",  REGEX_YEAR_PATTERN + "-" + REGEX_MONTH_PATTERN + "-" + REGEX_DAY_PATTERN ),
        STYLE_FULL_DATE_AND_FULL_TIME(Locale.SIMPLIFIED_CHINESE, "yyyy-MM-dd HH:mm:ss",  REGEX_YEAR_PATTERN + "-" + REGEX_MONTH_PATTERN + "-" + REGEX_DAY_PATTERN + "\\s+" + REGEX_HOUR_PATTERN + ":" + REGEX_MINITE_PATTERN + ":" + REGEX_SECOND_PATTERN ),
        STYLE_FULL_DATE_AND_FULL_TIME_WITH_MSECONDS(Locale.SIMPLIFIED_CHINESE, "yyyy-MM-dd HH:mm:ss.SSS",  REGEX_YEAR_PATTERN + "-" + REGEX_MONTH_PATTERN + "-" + REGEX_DAY_PATTERN + "\\s+" + REGEX_HOUR_PATTERN + ":" + REGEX_MINITE_PATTERN + ":" + REGEX_SECOND_PATTERN + "\\." + REGEX_MILLI_SECOND_PATTERN ),
        STYLE_FULL_DATE_IN_CHINESE(Locale.SIMPLIFIED_CHINESE, "yyyy年M月d日",   REGEX_YEAR_PATTERN + "年" + REGEX_MONTH_PATTERN + "月" + REGEX_DAY_PATTERN + "日"  ),
        STYLE_FULL_DATE_AND_FULL_TIME_IN_CHINESE(Locale.SIMPLIFIED_CHINESE, "yyyy年M月d日H时m分s秒",   REGEX_YEAR_PATTERN + "年" + REGEX_MONTH_PATTERN + "月" + REGEX_DAY_PATTERN + "日" + REGEX_HOUR_PATTERN + "时" + REGEX_MINITE_PATTERN + "分" + REGEX_SECOND_PATTERN + "秒"  ),
        STYLE_FULL_DATE_IN_ENGLISH(Locale.ENGLISH, "dd/MM/yyyy",   REGEX_DAY_PATTERN + "/" + REGEX_MONTH_PATTERN + "/" + REGEX_YEAR_PATTERN  ),
        STYLE_FULL_DATE_AND_TIME_IN_ENGLISH(Locale.ENGLISH, "dd/MM/yyyy HH:mm:ss",   REGEX_DAY_PATTERN + "/" + REGEX_MONTH_PATTERN + "/" + REGEX_YEAR_PATTERN + "\\s+" + REGEX_HOUR_PATTERN + ":" + REGEX_MINITE_PATTERN + ":" + REGEX_SECOND_PATTERN  ),
        STYLE_FULL_DATE_DOT_SPLITED_IN_ENGLISH(Locale.ENGLISH, "dd.MM.yyyy",   REGEX_DAY_PATTERN + "\\." + REGEX_MONTH_PATTERN + "\\." + REGEX_YEAR_PATTERN  ),
        STYLE_FULL_DATE_DOT_SPLITED(Locale.SIMPLIFIED_CHINESE, "yyyy.MM.dd", "^"  + "\\." + REGEX_YEAR_PATTERN+ REGEX_MONTH_PATTERN + "\\."  + REGEX_DAY_PATTERN ),
        STYLE_FULL_DATE_NO_SPLITER(Locale.SIMPLIFIED_CHINESE, "yyyyMMdd",   REGEX_YEAR_PATTERN + REGEX_MONTH_PATTERN + REGEX_DAY_PATTERN  ),
        STYLE_FULL_DATE_AND_TIME_NO_SPLITER(Locale.SIMPLIFIED_CHINESE, "yyyyMMddHHmmss",   REGEX_YEAR_PATTERN + REGEX_MONTH_PATTERN + REGEX_DAY_PATTERN + REGEX_HOUR_PATTERN + REGEX_MINITE_PATTERN + REGEX_SECOND_PATTERN  ),
        STYLE_FULL_DATE_AND_TIME_WITH_MSEC_NO_SPLITER(Locale.SIMPLIFIED_CHINESE, "yyyyMMddHHmmssSSS",   REGEX_YEAR_PATTERN + REGEX_MONTH_PATTERN + REGEX_DAY_PATTERN + REGEX_HOUR_PATTERN + REGEX_MINITE_PATTERN + REGEX_SECOND_PATTERN + REGEX_MILLI_SECOND_PATTERN  ),
        STYLE_FULL_DATE_WITH_TIME_COMMON_IN_ENGLISH(Locale.ENGLISH, "EEE MMM dd HH:mm:ss z yyyy",   REGEX_ENG_WEEK_DAY_PATTERN + "\\s*" + REGEX_ENG_MONTH_PATTERN + "\\s*" + REGEX_DAY_PATTERN + "\\s*" + REGEX_HOUR_PATTERN + ":" + REGEX_MINITE_PATTERN + ":" + REGEX_SECOND_PATTERN + "\\s*" + REGEX_GMT_PATTERN + "\\s*" + REGEX_YEAR_PATTERN  ),
        STYLE_FULL_DATE_AND_TIME_SPECIAL_IN_ENGLISH(Locale.ENGLISH, "EEE, dd MMM yyyy HH:mm:ss z",   REGEX_ENG_WEEK_DAY_PATTERN + ",\\s*" + REGEX_DAY_PATTERN + "\\s*" + REGEX_ENG_MONTH_PATTERN + "\\s*" + REGEX_YEAR_PATTERN + "\\s*" + REGEX_HOUR_PATTERN + ":" + REGEX_MINITE_PATTERN + ":" + REGEX_SECOND_PATTERN + "\\s*" + REGEX_GMT_PATTERN  );

        final String format;
        final String patternStr;
        final Locale locale;
        final ThreadLocal<SimpleDateFormat> formatter;
        final Pattern pattern;

        StyleDateFormat(Locale l, String format, String pattern) {
            this.format = format;
            this.patternStr = pattern;
            this.locale = l;
            this.pattern=Pattern.compile(patternStr, Pattern.CASE_INSENSITIVE);
//            this.formatter=new SimpleDateFormat(format, locale);
            formatter = new ThreadLocal<SimpleDateFormat>();
        }

        public String getFormat() {
            return format;
        }

        public String getPattern() {
            return patternStr;
        }

        public Locale getLocale() {
            return locale;
        }

        public SimpleDateFormat getFormatter() {
            SimpleDateFormat format = formatter.get();
            if(format==null) {
                format=new SimpleDateFormat(this.format, locale);
                formatter.set(format);
            }
            return format;
        }
    }

    static {
        //        Pattern.compile("^([0-9]{3}) ([0-9]{3}) ((?:[0-2]?[0-9])|(?:3[0-1])) ((?:0?[1-9])|(?:1[0-9])):((?:0?[1-9])|(?:1[0-9])):((?:0?[1-9])|(?:1[0-9])) ([0-9]{1}) ((?:(?:19)|(?:20))[0-9]{2})$");
//            format=new
//        maps = new EnumMap<StyleDateFormat, Pattern>(StyleDateFormat.class);
//        formats = new EnumMap<StyleDateFormat, SimpleDateFormat>(StyleDateFormat.class);
        ;
//        format=new SimpleDateFormat();

        //String str1 = StringHelper.concat("^", REGEX_YEAR_PATTERN, "-", REGEX_MONTH_PATTERN, "-", REGEX_DAY_PATTERN, "$");
//        DateTimePatterns pt1=new DateTimePatterns("yyyy-MM-dd",str1);
//        StyleDateFormat[] values = StyleDateFormat.values();
//        for (StyleDateFormat f : values) {
//            maps.put(f, Pattern.compile(f.getPattern(), Pattern.CASE_INSENSITIVE));
//            formats.put(f, new SimpleDateFormat(f.getFormat(), f.getLocale()));
//        }
    }


    public static Date getDate(final String s) {
        Date ret = null;
        if (s == null || s.trim().length() == 0) {
            System.out.println("S:    输入的字符串为空");
            return null;
        } else {
            ret = testAndParse(s, DEFUALT_FORMAT);
            if (ret == null) {
//            Set<Map.Entry<StyleDateFormat, Pattern>> entries = maps.entrySet();
                StyleDateFormat[] formatses = StyleDateFormat.values();
                for (StyleDateFormat key : formatses) {
                    //StyleDateFormat key = entry.getKey();
                    if (key != DEFUALT_FORMAT) {
//                    Pattern pattern = entry.getValue();
//                L.w("matching :",pattern.toString());
                        ret = testAndParse(s, key);
                        if (ret != null) {
                            break;
                        }
                    }
                }
            }
        }
        return ret;
    }

    private static Date testAndParse(String s, StyleDateFormat key) {
        Date ret = null;
        Pattern pattern = key.pattern;
        if (pattern.matcher(s).matches()) {
            try {
                SimpleDateFormat dateFormat = key.getFormatter();
                ret = dateFormat.parse(s);
                //break;
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return ret;
    }

    public static Date getDateByFormatName(final String s, StyleDateFormat style) {
        if (style == null) {
            style = DEFUALT_FORMAT;
        }
        SimpleDateFormat dateFormat = style.getFormatter();
        try {
            return dateFormat.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String formatDate(final Date d) {
        return formatDateByFormatName(d, null);
    }

    public static String formatDateByFormatName(final Date d, StyleDateFormat style) {
        if (style == null) {
            style = DEFUALT_FORMAT;
        }
        SimpleDateFormat dateFormat = style.getFormatter();
        return dateFormat.format(d);
    }

    protected static DateFormat getFormatByFormatName(StyleDateFormat style) {
        if (style == null) return null;
        SimpleDateFormat format = style.getFormatter();
        return format;
    }

    public static String getFormatStrByFormatName(StyleDateFormat style) {
        return ((SimpleDateFormat) getFormatByFormatName(style)).toPattern();
    }

    public static long getSpan(Date from, Date to) {
        if (from == null) {
            from = new Date();
        }
        if (to == null) {
            throw new IllegalArgumentException("到达时间信息为空");
        }
        long span = to.getTime() - from.getTime();
        return span;
    }

    public static int getDaySpan(Date from, Date to) {
        long span = getSpan(from, to);
        int ret = (int) Math.floor(span / SPAN_DAY);
        return ret;
    }

    public static int getHourSpan(Date from, Date to) {
        long span = getSpan(from, to);
        int ret = (int) Math.floor(span / SPAN_HOUR);
        return ret;
    }

    public static String getTimeSpanStringFromNow(Date date) {
        return getTimeSpanString(date, null, false);
    }

    public static String getTimeSpanString(Date dateFrom, Date dateTo,
                                           boolean accurate) {
        if (dateFrom == null) {
            dateFrom = new Date();
        } else if (dateTo == null) {
            dateTo = new Date();
        }
        long span = dateTo.getTime() - dateFrom.getTime();
        String tag = span < 0 ? "后" : "前";
        span = Math.abs(span);
        int index = 0;
        long timeLeap = 0, leap, remain;
        StringBuilder ret = new StringBuilder();
        String spanStr;
        do {
            leap = SPANS[index];
            timeLeap = span / leap;
            remain = span % leap;
            spanStr = remain + SPAN_TAGS[index];
            ret.insert(0, spanStr);
            ++index;
            span = timeLeap;
            // System.out.println(span + " ");
        } while (timeLeap > 0);

        return accurate ? ret.append(tag).toString() : spanStr + tag;
    }

    public final SimpleDateFormat formatter;//= new SimpleDateFormat(DEFUALT_STYLE_LONG_DATE_LONG_TIME_FORMAT, Locale.SIMPLIFIED_CHINESE);

    public final Calendar calendar;

    private DateTimeHelper() {
        calendar = Calendar.getInstance();
        formatter = new SimpleDateFormat(
                DEFUALT_STYLE_LONG_DATE_LONG_TIME_FORMAT, Locale.SIMPLIFIED_CHINESE);
    }

    public String getCurrentDateTimeString(String format) {
        setFormat(format);
        return formatter.format(new Date(System.currentTimeMillis()));
    }

    public String getDateTimeString(String format, Date date) {
        setFormat(format);
        return formatter.format(date);
    }


    public Date parseDate(String date, String format) {
        if (date == null || date.trim().length() == 0) {
            return null;
        }
        setFormat(format);
        try {
            return formatter.parse(date);
        } catch (ParseException ex) {
            ex.printStackTrace();
//            Logger.getLogger(StringHelper.class.getName()).log(
//                    Level.SEVERE, null, ex);
            return null;
        }
    }

    public List<Integer> parseDateToInt(String date, String format,
                                        int[] fields) {
        setFormat(format);
        if (fields == null) {
            fields = COMMON_FIELDS;
        }
        ArrayList<Integer> ret = new ArrayList<Integer>(10);
        try {
            Date d = formatter.parse(date);
            calendar.setTime(d);
            for (int fi : fields) {
                ret.add(calendar.get(fi));
            }

        } catch (ParseException ex) {
            ex.printStackTrace();
//            Logger.getLogger(StringHelper.class.getName()).log(
//                    Level.SEVERE, null, ex);
        }
        return ret;
    }

    public List<Integer> parseDateToInt(Date d,
                                        int[] fields) {
//        setFormat(format);
        if (fields == null) {
            fields = COMMON_FIELDS;
        }
        ArrayList<Integer> ret = new ArrayList<Integer>(10);
        try {
//            Date d = formatter.parse(date);
            calendar.setTime(d);
            for (int fi : fields) {
                ret.add(calendar.get(fi));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
//            Logger.getLogger(StringHelper.class.getName()).log(
//                    Level.SEVERE, null, ex);
        }
        return ret;
    }

    public Date getNextMonth(Date cur) {
        calendar.setTime(cur);
        calendar.add(Calendar.MONTH, 1);
        return calendar.getTime();
    }

    public Date getNextMonth(Date cur, int lastOrFirstDay) {
        calendar.setTime(cur);
        calendar.add(Calendar.MONTH, 1);
        if (lastOrFirstDay == -1) {

            int maximum = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
            calendar.set(Calendar.DAY_OF_MONTH, maximum);
        } else if (lastOrFirstDay == 1) {
            int min = calendar.getActualMinimum(Calendar.DAY_OF_MONTH);
            calendar.set(Calendar.DAY_OF_MONTH, min);
        }
        return calendar.getTime();
    }

    public Date getNextNSpan(Date cur, int lastOrFirstDay, int count, int field) {
        calendar.setTime(cur);
        calendar.add(field, count);
        if (FIELD_NEXT_MAP.containsKey(field)) {
            Integer fs = FIELD_NEXT_MAP.get(field);
            if (lastOrFirstDay == -1) {

                int maximum = calendar.getActualMaximum(fs);
                calendar.set(fs, maximum);
            } else if (lastOrFirstDay == 1) {
                int min = calendar.getActualMinimum(fs);
                calendar.set(fs, min);
            }
        }
        return calendar.getTime();
    }

    public String calculateDateStringFormNow(String format,
                                             int span, int field) {
        return calculateDateString(new Date(), format, span, field);
    }

    public String calculateDateString(Date from, String format,
                                      int span, int field) {
        setFormat(format);
        calendar.setTime(from);
        calendar.add(field, span);
        return formatter.format(calendar.getTime());
    }

    public Date getDateFromInts(int[] params, int[] fields) {
        if (fields == null) {
            fields = COMMON_FIELDS;
        }
        calendar.clear();
        if (params.length == fields.length) {
            for (int i = 0, n = fields.length; i < n; ++i) {
                calendar.set(fields[i], params[i]);
            }
        }
        return calendar.getTime();
    }

    private void setFormat(String format) {
        if (format != null) {
            formatter.applyPattern(format);
        } else {
            formatter.applyPattern(DEFUALT_STYLE_LONG_DATE_LONG_TIME_FORMAT);
        }
    }

    private Date modTime(int level, Date d) {
        List<Integer> fs = parseDateToInt(d, null);
        calendar.clear();
        for (int i = 0, n = COMMON_FIELDS.length; i < n; ++i) {
            if (i < level) {
                calendar.set(COMMON_FIELDS[i], fs.get(i));
            } else {
                calendar.set(COMMON_FIELDS[i], 0);
            }
        }
        return calendar.getTime();
    }

    public Date getHourStart(Date d) {
        return modTime(4, d);
    }

    public Date getHourStart(String date, String format) {
        Date d = parseDate(date, format);
        return modTime(4, d);
    }

    public Date getDayStart(Date d) {
        return modTime(3, d);
    }

    public Date getDayStart(String date, String format) {
        Date d = parseDate(date, format);
        return modTime(3, d);
    }

    public Date getMonthStart(Date d) {
        return modTime(2, d);
    }

    public Date getMonthStart(String date, String format) {
        Date d = parseDate(date, format);
        return modTime(2, d);
    }

    public Date getYearStart(Date d) {
        return modTime(1, d);
    }

    public Date getYearStart(String date, String format) {
        Date d = parseDate(date, format);
        return modTime(1, d);
    }

    public Date getOffsetDate(int dayOffest) {
        calendar.setTime(new Date());
        calendar.add(Calendar.DATE, dayOffest);
        return calendar.getTime();
    }

    public Date getOffsetDate(Date date, int dayOffest) {
        calendar.setTime(date);
        calendar.add(Calendar.DATE, dayOffest);
        return calendar.getTime();
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("DateTimePatterns{");
        sb.append(StyleDateFormat.values().length).append("\t");
        sb.append(calendar.getTime()).append("\t");
        sb.append(formatter.toPattern());
        sb.append('}');
        return sb.toString();
    }

    public static void main(String[] args) {

        //Pattern p = Pattern.compile("^\\s*((?:(?:19)|(?:20))[0-9]{2})\\s*():((?:0?[1-9])|(?:1[0-9])):((?:0?[1-9])|(?:1[0-9]))");
        Date date = getDate("Mon, 16 May 2016 07:30:20 GMT");
        System.out.println(date);

        date = getDate("2016-11-11 07:30:20");
        System.out.println(date);

        date = getDate("2016年1月3日");
        System.out.println(date);

        date = getDate("2016-03-09");
        System.out.println(date);
    }
}
