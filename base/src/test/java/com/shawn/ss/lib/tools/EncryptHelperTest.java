package com.shawn.ss.lib.tools;

//import org.apache.commons.net.imap.IMAPClient;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;

import static org.junit.Assert.*;

/**
 * Created by ss on 2017/10/3.
 */
public class EncryptHelperTest {

    static final Logger L = LoggerFactory.getLogger(EncryptHelperTest.class.getSimpleName());

    final String[] texts={"1234","1234567890我是测试abc!@#","~!@##$%^&*()_+|=-{}[]';l<>?,./`1234567890qwertyuiopasdfghjklzxcvbnm中文字符、！~·@#￥%……%……&*（）——+【】{}《》，。？、：；‘“”’",
            "这是一段长文本文本\n" +
            "1234567890我是测试abc!@#1234567890我是测试abc!@#1234567890我是测试abc!@#1234567890" +
            "我是测试abc!@#1234567890我是测试abc!@#1234567890我是测试abc!@#1234567890" +
            "我是测试abc!@#1234567890我是测试abc!@#1234567890我是测试abc!@#"};

    @Test
    public void testEncryptDES3() {
        for(String text:texts) {
//        String text = "1234567890我是测试abc!@#";
            String key = "bgydkd881234567890145796", iv = "BgyDkdIV";
            String entext = EncryptHelper.encryptString(text, key, iv, EncryptHelper.EncryptMethod.DES3);
            L.info("{} encrypt to {}",text,entext);
            String decryptString = EncryptHelper.decryptString(entext, key, iv, EncryptHelper.EncryptMethod.DES3);
//        L.w(decryptString);
            assertEquals(decryptString, text);
        }
    }

//    @Test
    public void testEncryptDES3Exchage() {
        for(String text:texts) {
//        String text = "1234567890我是测试abc!@#";
            String key = "bgydkd88ssddd3wt", iv = null;
            String key2 = "bgydkd88677dd3w0", iv2 = null;
            String entext = EncryptHelper.encryptString(text, key, iv, EncryptHelper.EncryptMethod.AES);
            L.info("{} encrypt to {}",text,entext);
            entext = EncryptHelper.encryptString(entext, key2, iv2, EncryptHelper.EncryptMethod.AES);
            L.info("{} encrypt to {}",text,entext);
            String decryptString = EncryptHelper.decryptString(entext, key2, iv2, EncryptHelper.EncryptMethod.AES);
            L.info("{} decrypt to {}",entext,decryptString);
            decryptString = EncryptHelper.decryptString(decryptString, key, iv, EncryptHelper.EncryptMethod.AES);
            L.info("{} decrypt to {}",entext,decryptString);
//        L.w(decryptString);
            assertEquals(decryptString, text);
        }
    }

    @Test
    public void testEncryptAES() {
        for(String text:texts) {
            String key = "bgydkd88ssddd3wt", iv = "siikeisdf1233223";
            String entext = EncryptHelper.encryptString(text, key, iv, EncryptHelper.EncryptMethod.AES);
            L.info("{} encrypt to {}",text,entext);
//        L.w(entext);
            String decryptString = EncryptHelper.decryptString(entext, key, iv, EncryptHelper.EncryptMethod.AES);
//        L.w(decryptString);
            assertEquals(decryptString, text);

            entext = EncryptHelper.encryptString(text, key,  EncryptHelper.EncryptMethod.AES);
            L.info("{} encrypt to {}",text,entext);
//        L.w(entext);
            decryptString = EncryptHelper.decryptString(entext, key,  EncryptHelper.EncryptMethod.AES);
//        L.w(decryptString);
            assertEquals(decryptString, text);
        }

    }

//    @Test
    public void testEncryptRSAExchage() {
        byte[][] bytes=new byte[0][0];
        try {
            bytes = EncryptHelper.generateKeyPair();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        byte[][] bytes2=new byte[0][0];
        try {
            bytes2 = EncryptHelper.generateKeyPair();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        L.info(StringHelper.concat("key parameter is \n",bytes[0]," \n",bytes[1]));
//        for(String text:texts) {
        String text=texts[0];
            if(text.getBytes().length>240){
                L.info("date :{} \n too long to encrypt by RSA",text);
            }else {
                // String key = "bgydkd88ssddd3wt", iv = "siikeisdf1233223";
                byte[] enBytes = EncryptHelper.encryptBytes(text.getBytes(), bytes[0],null, EncryptHelper.EncryptMethod.RSAPublic);
                L.info("{} encrypt to {}", text, enBytes.length);

                enBytes = EncryptHelper.encryptBytes(enBytes, bytes2[0],null, EncryptHelper.EncryptMethod.RSAPublic);
                L.info("{} encrypt to {}", text, enBytes.length);

                byte[] decryptString = EncryptHelper.decryptBytes(enBytes, bytes[1],null, EncryptHelper.EncryptMethod.RSAPrivate);
                L.info("{} encrypt to {}", enBytes.length, decryptString);

                decryptString = EncryptHelper.decryptBytes(decryptString, bytes2[1],null, EncryptHelper.EncryptMethod.RSAPrivate);
                L.info("{} encrypt to {}", enBytes.length, new String(decryptString));

                assertEquals(decryptString, text);

//                entext = EncryptHelper.encryptString(text, bytes[1], EncryptHelper.EncryptMethod.RSAPrivate);
//                L.info("{} encrypt to {}", text, entext);
//
//                decryptString = EncryptHelper.decryptString(entext, bytes[0], EncryptHelper.EncryptMethod.RSAPublic);
//
//                assertEquals(decryptString, text);
            }
//        }

    }

    @Test
    public void testEncryptRSA() {
        byte[][] bytes=new byte[0][0];
        try {
            bytes = EncryptHelper.generateKeyPair();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        L.info(StringHelper.concat("key parameter is \n",bytes[0]," \n",bytes[1]));
        for(String text:texts) {
            if(text.getBytes().length>240){
                L.info("date :{} \n too long to encrypt by RSA",text);
            }else {
                // String key = "bgydkd88ssddd3wt", iv = "siikeisdf1233223";
                String entext = EncryptHelper.encryptString(text, bytes[0], EncryptHelper.EncryptMethod.RSAPublic);
                L.info("{} encrypt to {}", text, entext);

                String decryptString = EncryptHelper.decryptString(entext, bytes[1], EncryptHelper.EncryptMethod.RSAPrivate);

                assertEquals(decryptString, text);

                entext = EncryptHelper.encryptString(text, bytes[1], EncryptHelper.EncryptMethod.RSAPrivate);
                L.info("{} encrypt to {}", text, entext);

                decryptString = EncryptHelper.decryptString(entext, bytes[0], EncryptHelper.EncryptMethod.RSAPublic);

                assertEquals(decryptString, text);
            }
        }

    }

    @Test
    public void testRandomKey(){
        for(int i=0;i<24;++i) {
            String randomKey = EncryptHelper.randomKey(24+i);
            assertNotNull(randomKey);
            assertEquals(randomKey.length(), 24+i);
            String anotherRandomKey = EncryptHelper.randomKey(24+i);
            assertNotEquals(anotherRandomKey, randomKey);
            L.info("two random key : {} , {} ", randomKey, anotherRandomKey);
        }
    }

    @Test
    public void testRandomPass(){
        for(int i=0;i<24;++i) {
            String randomKey = EncryptHelper.randomPass(24+i);
            assertNotNull(randomKey);
            assertEquals(randomKey.length(), 24+i);
            String anotherRandomKey = EncryptHelper.randomPass(24+i);
            assertNotEquals(anotherRandomKey, randomKey);
            L.info("two random key : {} , {} ", randomKey, anotherRandomKey);
        }
    }


}
