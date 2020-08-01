package com.shawn.ss.lib.tools;

//import com.google.common.annotations.VisibleForTesting;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.omg.CORBA.Object;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by ss on 2017/10/2.
 */

public class StringHelperTest {

    static final Logger L = LoggerFactory.getLogger(NumberHelperTest.class.getSimpleName());

    public static final String genStrTestTemplate = "test str gen by pattern:{pattern} will be replaced with pp," +
            "{value} will be replaced with tt, " +
            "{{pattern}} is the value of pattern , " +
            "{{value}} is the value of value and {repeat},{repeat},{repeat},{repeat} replace is more efficient";

    public static final String chopStrTestStr1 = "abcd我是测试字符串123", chopStrTestStr2 = "abcd3";

    public static final String concatFormatTestStr = "%s is a String place holder ,\n" +
            "and %d is a decimal number place holder," +
            "and %x is a hex number place holder, and %5d is a fixed length number place holder, and %2.2f is a float place holder ";

    @Test
    public void testRepeat() {
        String str = StringHelper.repeat("ab", 10);
        assertEquals("重复字符串不正确", str, "abababababababababab");
    }

    @Test
    public void testReplace() {
        String str = StringHelper.replaceStr("a=:b,s=:s,:hh",
                CollectionHelper.<String, Object>mapBuilder()
                        .put(":b", "test1")
                        .put(":s", "test2")
                        .put(":hh", "test3")
                        .getMap());
        assertEquals("替换测试未通过，替换之后不相等", str, "a=test1,s=test2,test3");
    }

    @Test
    public void testGenStrNormal() {
        String str = StringHelper.genStr("--\n", genStrTestTemplate,
                CollectionHelper.<String, Object>mapBuilder()
                        .put("pattern", "pp")
                        .put("value", "tt")
                        .put("repeat", "repeat replace")
                        .getMap());

        assertEquals("替换测试未通过，替换之后不相等", str, "--\ntest str gen by pattern:pp will be replaced with pp,tt will be replaced with tt, {pp} is the value of pattern , {tt} is the value of value and repeat replace,repeat replace,repeat replace,repeat replace replace is more efficient");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGenStrException() {
        String str = StringHelper.genStr("", genStrTestTemplate, CollectionHelper.<String, Object>newEmptyMap());
    }

    @Test
    public void testChopStr() {
        int n = chopStrTestStr1.length();
        String chopToSize1 = StringHelper.chopToSize(chopStrTestStr1, n);
        assertEquals("测试未通过,截取尾部后不正确", chopToSize1, chopStrTestStr1);

        String chopToSize2 = StringHelper.chopToSize(chopStrTestStr1, n - 3);
        assertEquals("测试未通过,截取尾部后不正确", chopToSize2, chopStrTestStr1.substring(0, n - 4) + "...");

        String chopToSize3 = StringHelper.chopToSize(chopStrTestStr2, n);
        assertEquals("测试未通过,截取尾部后不正确", chopToSize3, chopStrTestStr2);

        String chopToSize4 = StringHelper.chopToSize(chopStrTestStr1, n - 3, "_");
        assertEquals("测试未通过,截取尾部后不正确", chopToSize4, chopStrTestStr1.substring(0, n - 4) + "_");
    }

    @Test
    public void testCleanUnprintableCodes() {
        String otext = "我是测试abc123   ,.  ……（——【】。……《》<>、-——！）“：；as·b”’--‘";
        byte[] bs = {0x00, -96, -97, 0x11};
        String test = new String(bs);
        String text = test + otext + test + otext.substring(5);
        L.info("before:" + text);
        text = StringHelper.clearUnprintableCodes(text);
        L.info("after :" + text);
        assertEquals("字符串清理不正确", text, otext + otext.substring(5));
    }

    @Test
    public void testIsEmpty() {
        boolean empty = StringHelper.isEmpty(null);
        assertTrue(empty);
        boolean alsoEmpty = StringHelper.isEmpty("");
        assertTrue(alsoEmpty);
        boolean notEmpty = StringHelper.isEmpty(" ");
        assertFalse(notEmpty);
    }

    @Test
    public void testConcat() {

        String str0 = StringHelper.concat("abc", "bcd");
        assertEquals("字符串连接不正确", str0, "abcbcd");

        String str1 = StringHelper.concat("a", "b", "c", "d", "我是测试", new Integer[]{1, 5, 6, 8});
        System.out.println(str1);
        assertEquals("字符串连接不正确", str1, "abcd我是测试[1,5,6,8]");
//        System.out.println(str1);
        L.info("concated string is {}", str1);
        Date date = new Date(1507015277121L);

        String str2 = StringHelper.concat(CollectionHelper.listBuilder(false)
                .add(1).add(2).add("as").add(date).add(1.2).add(10029849932L).add("我来测试")
                .getList());
//        System.out.println(str2+" -- "+date.getTime());
        L.info("concated string is {}", str2);
        assertEquals("字符串连接不正确", str2, "1,2,as,2017-10-03 15:21:17,1.2,10029849932,我来测试");

        String str3 = StringHelper.concat("||", new Object[]{"abc", "sd", 1, 5, 1.3f, date, 1234567890123L, "我要测试", new Object[]{"xxx", 1.2234, Math.PI}});
//        System.out.println(str3);
        L.info("concated string is {}", str3);
        assertEquals("字符串连接不正确", str3, "abc||sd||1||5||1.3||2017-10-03 15:21:17||1234567890123||我要测试||[xxx||1.2234||3.141592653589793]");
        List<Object> list = CollectionHelper.listBuilder()
                .add(CollectionHelper.listBuilder(false).add("这是字符串123").add(2).add(2).add(3).add(1.2).add(10029849932L).add("我来测试").getList())
                .add(CollectionHelper.listBuilder(false).add("这是字符串124").add(3).add(3).add(4).add(21.12).add(20029849932L).add("我来测试2").getList())
                .getList();
        String str4 = StringHelper.concat("\n\t", list);
        //System.out.println(str4);
        L.info("concated string is {}", str4);
        assertEquals("字符串连接不正确", str4, "[这是字符串123\n" +
                "\t2\n" +
                "\t2\n" +
                "\t3\n" +
                "\t1.2\n" +
                "\t10029849932\n" +
                "\t我来测试]\n" +
                "\t[这是字符串124\n" +
                "\t3\n" +
                "\t3\n" +
                "\t4\n" +
                "\t21.12\n" +
                "\t20029849932\n" +
                "\t我来测试2]");

        String str5 = StringHelper.concat("//", CollectionHelper.mapBuilder()
                .put("test", 1)
                .put(new Date(10000000000L), "date test")
                .put("map test", CollectionHelper.mapBuilder().getMap())
                .put("map test2", CollectionHelper.mapBuilder()
                        .put("a", "b").put(1L, 3)
                        .put("byte test", new byte[]{(byte) 0xf, (byte) 0xff, (byte) 0xfb, (byte) 0xfc, (byte) 0x11, (byte) 0x23, (byte) 0})
                        .put("double test", new double[]{1.2, 3.3, Math.PI, Math.E})
                        .put("boolean test", new boolean[]{true, false, false, true, true})
                        .getMap())
                .getMap());
//        System.out.println(str3);
        L.info("concated string is {}", str5);
        assertEquals("字符串连接不正确", str5, "test:1//1970-04-27 01:46:40:date test//map test:{}//map test2:{a:b//1:3//byte test:15//255//251//252//17//35//0//double test:1.2//3.3//3.141592653589793//2.718281828459045//boolean test:true//false//false//true//true}");

        String str = StringHelper.concat("\n", System.getProperties());
        L.info("concat system properties is \n {}", str);
    }

    @Test
    public void testEncodeHex() {
        byte[] bs = {(byte) 0xf, (byte) 0xff, (byte) 0xfb, (byte) 0xfc, (byte) 0x11, (byte) 0x23, (byte) 0};
        String hex = StringHelper.encodeHex(bs);
        L.info(StringHelper.concat(bs, " to string is ", hex));
        assertTrue(hex.equalsIgnoreCase("0ffffbfc112300"));
    }

    static class ObjTest {
        String a;
        int b;
        Date c;
        long d;
        List<String> e;
        boolean f;

        public ObjTest(String a, int b, Date c, long d, List<String> e, boolean f) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
            this.e = e;
            this.f = f;
        }
    }

    @Test
    public void testGetObjInfo() {
        ObjTest test = new ObjTest("test1", 2, new Date(1494919820000L), 1494919820000L,
                CollectionHelper.<String>listBuilder().add("a", "b", "我是测试").getList(), false);
        String obj = StringHelper.printObj(test, ObjTest.class);
        L.info("print obj for {} , result: {}", test, obj);
        assertEquals("a:test1 ; b:2 ; c:2017-05-16 15:30:20 ; d:1494919820000 ; e:[a,b,我是测试] ; f:false ; ", obj);
    }

}
