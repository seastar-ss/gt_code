package com.shawn.ss.lib.tools;

//import org.apache.commons.net.imap.IMAPClient;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by ss on 2017/10/3.
 */
public class DateTimeHelperTest {
    static final Logger L = LoggerFactory.getLogger(DateTimeHelperTest.class.getSimpleName());

    public static final DateTimeHelper.StyleDateFormat[] styles = {
            DateTimeHelper.StyleDateFormat.STYLE_FULL_DATE_AND_TIME_SPECIAL_IN_ENGLISH,
            DateTimeHelper.StyleDateFormat.STYLE_FULL_DATE_AND_FULL_TIME,
            DateTimeHelper.StyleDateFormat.STYLE_FULL_DATE_IN_CHINESE,
            DateTimeHelper.StyleDateFormat.STYLE_FULL_DATE,
            DateTimeHelper.StyleDateFormat.STYLE_FULL_DATE_WITH_TIME_COMMON_IN_ENGLISH,
            DateTimeHelper.StyleDateFormat.STYLE_FULL_DATE_IN_ENGLISH,
            DateTimeHelper.StyleDateFormat.STYLE_FULL_DATE_AND_FULL_TIME_WITH_MSECONDS,
            DateTimeHelper.StyleDateFormat.STYLE_FULL_DATE_AND_FULL_TIME_IN_CHINESE,
    };
    public static final String[] dateStr = {"Tue, 16 May 2017 07:30:20 GMT", "2017-11-11 07:30:20", "2017年1月3日",
            "2017-03-09", "Wed May 17 15:30:20 CST 2017", "09/10/2017", "2017-11-11 07:30:20.333", "2017年1月3日7时12分22秒"};
    public static final long[] dateTimeStamp = {1494919820000L, 1510356620000L, 1483372800000L, 1488988800000L,
            1495006220000L, 1507478400000L, 1510356620333L, 1483398742000L};

    static final Map<Integer, Map<Integer, Integer>> values = CollectionHelper.<Integer, Map<Integer, Integer>>mapBuilder()
            .put(0,
                    CollectionHelper.<Integer, Integer>mapBuilder()
                            .put(Calendar.DAY_OF_WEEK, 3)
                            .put(Calendar.DATE, 16)
                            .put(Calendar.MONTH, 4)
                            .put(Calendar.YEAR, 2017)
                            .put(Calendar.HOUR_OF_DAY, 15)
                            .put(Calendar.MINUTE, 30)
                            .put(Calendar.SECOND, 20)
                            .getMap())
            .put(1,
                    CollectionHelper.<Integer, Integer>mapBuilder()
//                            .put(Calendar.DAY_OF_WEEK,2)
                            .put(Calendar.DATE, 11)
                            .put(Calendar.MONTH, 10)
                            .put(Calendar.YEAR, 2017)
                            .put(Calendar.HOUR_OF_DAY, 7)
                            .put(Calendar.MINUTE, 30)
                            .put(Calendar.SECOND, 20)
                            .getMap())
            .put(2,
                    CollectionHelper.<Integer, Integer>mapBuilder()
//                            .put(Calendar.DAY_OF_WEEK,2)
                            .put(Calendar.DATE, 3)
                            .put(Calendar.MONTH, 0)
                            .put(Calendar.YEAR, 2017)
//                            .put(Calendar.HOUR_OF_DAY,15)
//                            .put(Calendar.MINUTE,30)
//                            .put(Calendar.SECOND,20)
                            .getMap())
            .put(3,
                    CollectionHelper.<Integer, Integer>mapBuilder()
//                            .put(Calendar.DAY_OF_WEEK,2)
                            .put(Calendar.DATE, 9)
                            .put(Calendar.MONTH, 2)
                            .put(Calendar.YEAR, 2017)
//                            .put(Calendar.HOUR_OF_DAY,15)
//                            .put(Calendar.MINUTE,30)
//                            .put(Calendar.SECOND,20)
                            .getMap())
            .put(4,
                    CollectionHelper.<Integer, Integer>mapBuilder()
                            .put(Calendar.DAY_OF_WEEK, 4)
                            .put(Calendar.DATE, 17)
                            .put(Calendar.MONTH, 4)
                            .put(Calendar.YEAR, 2017)
                            .put(Calendar.HOUR_OF_DAY, 15)
                            .put(Calendar.MINUTE, 30)
                            .put(Calendar.SECOND, 20)
                            .getMap())
            .put(5,
                    CollectionHelper.<Integer, Integer>mapBuilder()
//                            .put(Calendar.DAY_OF_WEEK,2)
                            .put(Calendar.DATE, 9)
                            .put(Calendar.MONTH, 9)
                            .put(Calendar.YEAR, 2017)
//                            .put(Calendar.HOUR_OF_DAY,15)
//                            .put(Calendar.MINUTE,30)
//                            .put(Calendar.SECOND,20)
                            .getMap())
            //"2017-11-11 07:30:20.333"
            .put(6,
                    CollectionHelper.<Integer, Integer>mapBuilder()
//                            .put(Calendar.DAY_OF_WEEK,2)
                            .put(Calendar.DATE, 11)
                            .put(Calendar.MONTH, 10)
                            .put(Calendar.YEAR, 2017)
                            .put(Calendar.HOUR_OF_DAY, 7)
                            .put(Calendar.MINUTE, 30)
                            .put(Calendar.SECOND, 20)
                            .put(Calendar.MILLISECOND, 333)
//                            .put(Calendar.HOUR_OF_DAY,15)
//                            .put(Calendar.MINUTE,30)
//                            .put(Calendar.SECOND,20)
                            .getMap())
            //2017年1月3日7时12分22秒
            .put(7,
                    CollectionHelper.<Integer, Integer>mapBuilder()
//                            .put(Calendar.DAY_OF_WEEK,2)
                            .put(Calendar.DATE, 3)
                            .put(Calendar.MONTH, 0)
                            .put(Calendar.YEAR, 2017)
                            .put(Calendar.HOUR_OF_DAY, 7)
                            .put(Calendar.MINUTE, 12)
                            .put(Calendar.SECOND, 22)
//                            .put(Calendar.MILLISECOND,333)
                            .getMap())
            .getMap();

    @Test
    public void testGetDate() {
        Calendar c = Calendar.getInstance();
        int n = dateStr.length;
        for (int i = 0; i < n; ++i) {
            L.info("test date is {}", dateStr[i]);
            Date date = DateTimeHelper.getDate(dateStr[i]);
            assertNotNull(date);
            L.info("test date timestamp is {}", date.getTime());
//            System.out.println(date.getTime());
            c.setTime(date);
            Map<Integer, Integer> map = values.get(i);
            Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
            for (Map.Entry<Integer, Integer> entry : entries) {
                assertEquals(dateStr[i] + "not correct", c.get(entry.getKey()), entry.getValue().intValue());
            }
            assertEquals(date.getTime(), dateTimeStamp[i]);
        }
//        assertEquals(c.get(Calendar.DAY_OF_WEEK), 2);
//        assertEquals(c.get(Calendar.DATE), 16);
//        assertEquals(c.get(Calendar.MONTH), 4);
//        assertEquals(c.get(Calendar.YEAR), 2016);
//        assertEquals(c.get(Calendar.HOUR_OF_DAY), 7 + 8);
//        assertEquals(c.get(Calendar.MINUTE), 30);
//        assertEquals(c.get(Calendar.SECOND), 20);
//
//
//
    }

    @Test
    public void testGetDateNull() {
        Date date = DateTimeHelper.getDate(null);
        assertNull(date);
        date = DateTimeHelper.getDate("");
        assertNull(date);
        date = DateTimeHelper.getDate("2017");
        assertNull(date);
    }

    @Test
    public void testFormatDateByFormatName() {
        for (int i = 0; i < dateStr.length; ++i) {
            L.info("test date is {}", dateStr[i]);
            Date date = new Date(dateTimeStamp[i]);
            L.info("date info is {}", date);
            String s = DateTimeHelper.formatDateByFormatName(date, styles[i]);
            L.info("date is {}", s);
            if (i != 0) {
                assertEquals(s, dateStr[i]);
            }
        }
    }

    @Test
    public void testTimeSpan() {
        Date date = DateTimeHelper.getDate("2017-05-05 12:00:00");
        Date toDate = DateTimeHelper.getDate("2017-05-06 12:00:00");
        int span = DateTimeHelper.getDaySpan(date, toDate);
        L.info("from {} to {} is {} days", DateTimeHelper.formatDate(date), DateTimeHelper.formatDate(toDate), span);
        assertEquals(span,1);
        date = DateTimeHelper.getDate("2017-05-05 12:00:00");
        toDate = DateTimeHelper.getDate("2017-05-06 12:00:00");
        span = DateTimeHelper.getHourSpan(date, toDate);
        L.info("from {} to {} is {} hours", DateTimeHelper.formatDate(date), DateTimeHelper.formatDate(toDate), span);
        assertEquals(span,24);
        date = DateTimeHelper.getDate("2017-05-08 12:00:00");
        toDate = DateTimeHelper.getDate("2017-05-06 12:00:00");
        span = DateTimeHelper.getDaySpan(date, toDate);
        L.info("from {} to {} is {} days", DateTimeHelper.formatDate(date), DateTimeHelper.formatDate(toDate), span);
        assertEquals(span,-2);

        date = DateTimeHelper.getDate("2017-05-18 12:00:00");
        toDate = DateTimeHelper.getDate("2017-05-06 12:00:00");
        span = DateTimeHelper.getDaySpan(date, toDate);
        L.info("from {} to {} is {} days", DateTimeHelper.formatDate(date), DateTimeHelper.formatDate(toDate), span);
        assertEquals(span,-12);

        date = DateTimeHelper.getDate("2017-05-08 12:00:00");
        toDate = DateTimeHelper.getDate("2017-05-06 12:00:00");
        span = DateTimeHelper.getHourSpan(date, toDate);
        L.info("from {} to {} is {} hours", DateTimeHelper.formatDate(date), DateTimeHelper.formatDate(toDate), span);
        assertEquals(span,-48);

//        assertEquals(span,24);
    }

    @Test
    public void testDateStr(){
        Date date = DateTimeHelper.getDate("2017-05-05 12:00:00");
        Date toDate = DateTimeHelper.getDate("2017-05-06 12:00:00");
        String str = DateTimeHelper.getTimeSpanString(date, toDate,false);
        L.info(" {}  is {} compare with  {}  ", DateTimeHelper.formatDate(date),str ,DateTimeHelper.formatDate(toDate));
        assertEquals("1天前",str);

        date = DateTimeHelper.getDate("2017-05-18 12:00:00");
        toDate = DateTimeHelper.getDate("2017-05-06 12:00:00");
        str = DateTimeHelper.getTimeSpanString(date, toDate,false);
        L.info(" {}  is {} compare with  {}  ", DateTimeHelper.formatDate(date),str ,DateTimeHelper.formatDate(toDate));
        assertEquals("12天后",str);

        date = DateTimeHelper.getDate("2017-05-01 12:30:15");
        toDate = DateTimeHelper.getDate("2017-05-06 12:00:00");
        str = DateTimeHelper.getTimeSpanString(date, toDate,true);
        L.info(" {}  is {} compare with  {}  ", DateTimeHelper.formatDate(date),str ,DateTimeHelper.formatDate(toDate));
        assertEquals("4天23小时29分钟45秒0毫秒前",str);

        date = DateTimeHelper.getDate("2017-05-26 12:10:10.330");
        toDate = DateTimeHelper.getDate("2017-05-18 12:30:15.234");
        str = DateTimeHelper.getTimeSpanString(date, toDate,true);
        L.info(" {}  is {} compare with  {}  ", DateTimeHelper.formatDate(date),str ,DateTimeHelper.formatDate(toDate));
        assertEquals("7天23小时39分钟55秒96毫秒后",str);
    }
}
