package com.shawn.ss.lib.tools;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by ss on 2017/10/3.
 */
public class CodeStyleTransformTest {
    @Test
    public void testTransformerLowerFirstCase(){
        String lFirstCase = CodeStyleTransformHelper.lowerFirstCase("TestLowerFirstCase");
        assertEquals(lFirstCase,"testLowerFirstCase");
    }

    @Test
    public void testTransformerUpperFirstCase(){
        String lFirstCase = CodeStyleTransformHelper.upperFirstCase("testLowerFirstCase");
        assertEquals(lFirstCase,"TestLowerFirstCase");
    }

    @Test
    public void testStyleTransferU2H(){
        String testStr = CodeStyleTransformHelper.underlineSplittedStyleToHumpStyle("test_style_transfer");
        assertEquals(testStr,"testStyleTransfer");
    }

    @Test
    public void testStyleTransferH2U(){
        String testStr=CodeStyleTransformHelper.humpStyleToUnderlineSplittedStyle("testStyleTransfer");
        assertEquals(testStr,"test_style_transfer");
    }

//    @Test
//    public void testCharTransfer(){
//        int a='A'-'a';
//        char g='g';
//        char G= (char) ('g'+a);
//        System.out.println(g+" "+G);
//    }
}
