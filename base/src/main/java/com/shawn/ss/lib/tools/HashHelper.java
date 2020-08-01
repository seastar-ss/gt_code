package com.shawn.ss.lib.tools;

import com.shawn.ss.lib.tools.structure.ByteArrayPool;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by ss on 2017/9/26.
 */
public class HashHelper {

    public static enum HashMethod {

        sha1("SHA1"), sha512("SHA-256"), md5("MD5");
        final MessageDigest method;

        private HashMethod(String mn) {
            MessageDigest m = null;
            try {
                m = MessageDigest.getInstance(mn);
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(HashHelper.class.getName()).log(
                        Level.SEVERE, null, ex);
            } finally {
                method = m;
            }
        }
    }


    // 7c4a8d09ca3762af61e59520943dc26494f8941b
    // e10adc3949ba59abbe56e057f20f883e
    // 7c4a8d09ca3762af61e59520943dc26494f8941b
    // e10adc3949ba59abbe56e057f20f883e
    public static String getHashValue(String str) {
        return getHashValue(str, HashMethod.sha1);
    }

    public static String getHashValue(byte[] str, HashMethod sh1) {
        MessageDigest md = sh1.method;
        md.reset();
        md.update(str);
        final byte[] resultByte = md.digest();
        return StringHelper.encodeHex(resultByte);
    }

    public static String getHashValue(String str, HashMethod sh1) {

        return getHashValue(str.getBytes(), sh1);
    }


    // public static String asHex(byte[] b) {
    // StringBuffer buf = new StringBuffer();
    // for (int i = 0; i < b.length; i++) {
    // buf.append(Integer.toString((b[i] & 0xff) + 0x100, 16)
    // .substring(1));
    // }
    // String result = buf.toString();
    // return result;
    // }
    public static String getFileHashCode(String loc)
            throws FileNotFoundException, IOException {
        return getFileHashCode(loc, HashMethod.md5);
    }

    public static String getFileHashCode(String loc, HashMethod sh1)
            throws FileNotFoundException, IOException {
        MessageDigest md = sh1.method;
        FileInputStream fis = new FileInputStream(loc);
        ByteArrayPool arrayPool = ByteArrayPool.getInstance();
        byte[] dataBytes;
        dataBytes = arrayPool.getBuf(10240);
        try {
            int nread = 0;
            while ((nread = fis.read(dataBytes)) != -1) {
                md.update(dataBytes, 0, nread);
            }
            ;
            byte[] mdbytes = md.digest();
            // convert the byte to hex format
            // StringBuilder sb = new StringBuilder("");
            // for (int i = 0; i < mdbytes.length; i++) {
            // sb.append(Integer.toString((mdbytes[i] & 0xff) + 0x100,
            // 16).substring(1));
            // }
            return StringHelper.encodeHex(mdbytes);
        } finally {
            if (fis != null) {
                fis.close();
            }
            arrayPool.returnBuf(dataBytes);
        }
    }
}
