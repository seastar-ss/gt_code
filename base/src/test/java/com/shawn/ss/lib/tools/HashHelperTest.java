package com.shawn.ss.lib.tools;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by ss on 2017/10/8.
 */
public class HashHelperTest {

    @Test
    public void testGetHash(){
        String hashValue = HashHelper.getHashValue("123456", HashHelper.HashMethod.sha1);
        assertEquals(hashValue, "7c4a8d09ca3762af61e59520943dc26494f8941b");

        hashValue = HashHelper.getHashValue("123456", HashHelper.HashMethod.sha512);
        assertEquals(hashValue, "8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92");

        hashValue = HashHelper.getHashValue("123456", HashHelper.HashMethod.md5);
        assertEquals(hashValue, "e10adc3949ba59abbe56e057f20f883e");

        hashValue = HashHelper.getHashValue("123456");
        assertEquals(hashValue, "7c4a8d09ca3762af61e59520943dc26494f8941b");
    }
}
