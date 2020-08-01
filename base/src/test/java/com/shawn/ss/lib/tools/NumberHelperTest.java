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
public class NumberHelperTest {

    static final Logger L = LoggerFactory.getLogger(NumberHelperTest.class.getSimpleName());

    @Test
    public void testShift(){
        System.out.println(1<<6);
        System.out.println(1<<0);
        System.out.println(5<<-1);

    }

    @Test
    public void testLoopShift(){
        long i=(1L<<29)+(1L<<22);
        L.info("str:{}",Long.toHexString(i));
        while (i>0){
            L.info(" remain={}",((i & 0x3f)| (1<<6)));
            i=i>>6;
            L.info(" i={}",i);
        }
    }

    @Test
    public void testTmpNumber(){
        System.out.println(NumberHelper.fromCompact64Int("9T"));
    }

    @Test
    public void test64BitNumberToStrTransfer(){
        long[] ts={1024,64,7777,123456790,234567901,1245678901,63*64+62*64*64+12,Long.MAX_VALUE};
        for(int i=-256;i<256;++i){
            final String s = NumberHelper.toCompact64Int((long)i);
            L.info(" i={}",s);
            final long l = NumberHelper.fromCompact64Int(s);
            L.info(" l={}",l);
        }
        for ( long i : ts){
            final String s = NumberHelper.toCompact64Int(i);
            L.info(" i={}",s);
            final long l = NumberHelper.fromCompact64Int(s);
            L.info(" l={}",l);
        }
    }

    @Test
    public void testOpenId(){
        String[] openIds={
                "oL-NY5D-m1hv6Qn0HasufNfvxcXM",
                "oL-NY5ERbTrmK-ersQX9xxODqgiw",
                "oL-NY5EQX40A7kqyWyIGMxhA5_IY",
                "oYd4csz41fMiaHX0FhZDTGSpsQLU",
                "oYd4cs0lNhAN-l85-J7ZrRB0Vhrk",
                "oYd4cs8j-mYtGJZZigBqt1f5q5d8"
        };
        for(String openId:openIds) {
            final long l = NumberHelper.fromCompact64Int(openId.substring(0,6));
            final long l1 = NumberHelper.fromCompact64Int(openId.substring(7,12));
            final long l2 = NumberHelper.fromCompact64Int(openId.substring(13));
            System.out.println("openId :"+openId+" is ("+l+"),("+l1+"),("+l2+")");
        }
    }

    @Test
    public void testIsInt() {
        boolean flag = NumberHelper.isInt("1");
        assertTrue(flag);
        flag = NumberHelper.isInt("x");
        assertFalse(flag);
    }

    @Test
    public void testIsDouble() {
        boolean flag = NumberHelper.isDouble("1.12");
        assertTrue(flag);
        flag = NumberHelper.isDouble("x");
        assertFalse(flag);
        flag = NumberHelper.isDouble("123");
        assertFalse(flag);
    }

    @Test
    public void testIntToFixLengthStr() {
        String s=NumberHelper.intIoFixLengthStr(123,5);
        assertEquals(s,"00123");
        s=NumberHelper.intToFixLengthStr(1234567,10,' ');
        assertEquals(s,"   1234567");
    }

    @Test
    public void testGetNumberStr(){
        String s=NumberHelper.getNumberStr(123,false,5);
        assertEquals(s,"123.00000");
        s=NumberHelper.getNumberStr(1234567,true,2);
        assertEquals(s,"1,234,567.00");
    }

    @Test
    public void testIntByteTransfer(){
        int test=0xACEBABE;
        byte[] bytes = NumberHelper.intToBytes(test);
        String hex = StringHelper.encodeHex(bytes);
        L.info("int {} transfer to {}",test,hex);
        assertTrue(hex.contains("acebabe"));
        int toInt = NumberHelper.bytesToInt(bytes);
        assertEquals(toInt,test);
    }

    @Test
    public void testLongByteTransfer(){
        long test=0L;
        byte[] bytes = new byte[]{(byte)0x0A,(byte)0xCE,(byte)0xBA,(byte)0xBE,(byte)0x02,(byte)0xCA,(byte)0xFE,(byte)0x0};//NumberHelper.longToBytes(test);
        String hex = StringHelper.encodeHex(bytes);
        //assertTrue(hex.contains("acebabe"));
        //778765110835084800
        //778764011323457024
        long toLong = NumberHelper.bytesToLong(bytes);
        L.info("long {} transfer to {}",toLong,hex);
        assertEquals(toLong,778765110835084800L);
        //assertEquals(toLong,test);
    }
}
