/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shawn.ss.lib.tools;

import java.io.UnsupportedEncodingException;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Map;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

/**
 * @author ss
 */
public class EncryptHelper {

    public static final String STRING_ENCODING = "utf-8";
    private static final int DEFAULT_KEY_SIZE = 2048;

    public static final String DEFAULT_SALT="BgjDkdIsdfgwe2190gjDkdIV";

    public static enum EncryptMethod {

        /**
         *
         */
        DES3("desede", "desede/CBC/PKCS5Padding", 24, 8) {
            protected SecretKeyFactory keyFactory;
            {
                try {
                    keyFactory = SecretKeyFactory.getInstance(method);
                } catch (NoSuchAlgorithmException ex) {
                    Logger.getLogger(EncryptHelper.class.getName()).log(Level.SEVERE, null, ex);
                    throw new EncryptException.IllegalEncryptParam();
                }
            }

            @Override
            public Key getKey(byte[] pass) {
                try {
                    DESedeKeySpec spec = new DESedeKeySpec(pass);
                    return keyFactory.generateSecret(spec);
                } catch (InvalidKeyException ex) {
                    Logger.getLogger(EncryptHelper.class.getName()).log(Level.SEVERE, null, ex);
                    throw new EncryptException.IllegalEncryptParam();
                } catch (InvalidKeySpecException ex) {
                    Logger.getLogger(EncryptHelper.class.getName()).log(Level.SEVERE, null, ex);
                    throw new EncryptException.IllegalEncryptParam();
                }
            }
        },
        /**
         *
         */
        AES("AES", "AES/CBC/PKCS5Padding", 16, 16) {
            @Override
            public Key getKey(byte[] pass) {
                Key key = new SecretKeySpec(pass, method);
                return key;
            }
        },
        /**
         *
         */
        RSAPublic("RSA", "RSA", 0, 8) {
            protected KeyFactory keyFac;
            {
                try {
                    keyFac = KeyFactory.getInstance(method);
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                    throw new EncryptException.IllegalEncryptParam();
                }
            }

            @Override
            public Key getKey(byte[] pass) {
                X509EncodedKeySpec spec = new X509EncodedKeySpec(pass);
                try {
                    return keyFac.generatePublic(spec);
                } catch (InvalidKeySpecException e) {
                    e.printStackTrace();
                }
                throw new EncryptException.IllegalEncryptParam();
            }

            @Override
            public IvParameterSpec getIvParam(String keyIv) {
                return null;
            }
        },
        /**
         *
         */
        RSAPrivate("RSA", "RSA", 0, 8) {
            protected KeyFactory keyFac;
            {
                try {
                    keyFac = KeyFactory.getInstance(method);
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                    throw new EncryptException.IllegalEncryptParam();
                }
            }

            @Override
            public Key getKey(byte[] pass) {
                PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(pass);
                try {
                    return keyFac.generatePrivate(spec);
                } catch (InvalidKeySpecException e) {
                    e.printStackTrace();
                }
                throw new EncryptException.IllegalEncryptParam();
            }

            @Override
            public IvParameterSpec getIvParam(String keyIv) {
                return null;
            }
        };
        ;

        protected String method;
        private String specificMethod;
        protected int keyLength;
        protected int ivLength;

        private EncryptMethod(String method, String specificMethod, int keyLength, int ivLength) {
            this.method = method;
            this.specificMethod = specificMethod;
            this.keyLength = keyLength;
            this.ivLength = ivLength;

        }

        //        protected SecretKeyFactory keyFactory;
//        protected KeyFactory keyFac;
//        Cipher cipher;
        static Map<String, IvParameterSpec> ivStore = CollectionHelper.newMap();

        public Key getKey(String pass) {
            try {
                if (pass.length() < keyLength) {
                    throw new EncryptException.IllegalEncryptParam();
                } else if (pass.length() > keyLength) {
                    pass = pass.substring(0, keyLength);
                }
                return getKey(pass.getBytes(STRING_ENCODING));
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(EncryptHelper.class.getName()).log(Level.SEVERE, null, ex);
                throw new EncryptException.IllegalEncryptParam();
            }
        }

        public abstract Key getKey(byte[] pass);

        public IvParameterSpec getIvParam(String keyIv) {
            if (keyIv.length() < ivLength) {
                throw new EncryptException.IllegalEncryptParam();
            } else if (keyIv.length() > ivLength) {
                keyIv = keyIv.substring(0, ivLength);
            }
            IvParameterSpec ret = null;
            if (ivStore.containsKey(keyIv)) {
                ret = ivStore.get(keyIv);
            } else {
                try {
                    ret = new IvParameterSpec(keyIv.getBytes(STRING_ENCODING));
                    ivStore.put(keyIv, ret);
                } catch (UnsupportedEncodingException ex) {
                    Logger.getLogger(EncryptHelper.class.getName()).log(Level.SEVERE, null, ex);
                    throw new EncryptException.IllegalEncryptParam();
                }
            }
            return ret;
        }

        public Cipher getInitedCipher(boolean encrypt, byte[] pass, String keyIv) {
            Cipher cipher = null;
            try {

                cipher = Cipher.getInstance(specificMethod);
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(EncryptHelper.class.getName()).log(Level.SEVERE, null, ex);
                throw new EncryptException.IllegalEncryptParam();
            } catch (NoSuchPaddingException ex) {
                Logger.getLogger(EncryptHelper.class.getName()).log(Level.SEVERE, null, ex);
                throw new EncryptException.IllegalEncryptParam();
            }
            try {
                if (keyIv != null) {
                    final IvParameterSpec ivParam = getIvParam(keyIv);
//                    if(ivParam!=null) {
                        if (encrypt) {
                            cipher.init(Cipher.ENCRYPT_MODE, getKey(pass), ivParam);
                        } else {
                            cipher.init(Cipher.DECRYPT_MODE, getKey(pass), ivParam);
                        }
//                    }
                } else {
                    if (encrypt) {
                        cipher.init(Cipher.ENCRYPT_MODE, getKey(pass));
                    } else {
                        cipher.init(Cipher.DECRYPT_MODE, getKey(pass));
                    }
                }
            } catch (InvalidKeyException ex) {
                Logger.getLogger(EncryptHelper.class.getName()).log(Level.SEVERE, null, ex);
                throw new EncryptException.IllegalEncryptParam();
            } catch (InvalidAlgorithmParameterException ex) {
                Logger.getLogger(EncryptHelper.class.getName()).log(Level.SEVERE, null, ex);
                throw new EncryptException.IllegalEncryptParam();
            }
            return cipher;
        }

        public Cipher getInitedCipher(boolean encrypt, String pass, String keyIv) {
            Cipher cipher = null;
            try {

                cipher = Cipher.getInstance(specificMethod);
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(EncryptHelper.class.getName()).log(Level.SEVERE, null, ex);
                throw new EncryptException.IllegalEncryptParam();
            } catch (NoSuchPaddingException ex) {
                Logger.getLogger(EncryptHelper.class.getName()).log(Level.SEVERE, null, ex);
                throw new EncryptException.IllegalEncryptParam();
            }
            try {
                if (keyIv != null) {
                    if (encrypt) {
                        cipher.init(Cipher.ENCRYPT_MODE, getKey(pass), getIvParam(keyIv));
                    } else {
                        cipher.init(Cipher.DECRYPT_MODE, getKey(pass), getIvParam(keyIv));
                    }
                } else {
                    if (encrypt) {
                        cipher.init(Cipher.ENCRYPT_MODE, getKey(pass));
                    } else {
                        cipher.init(Cipher.DECRYPT_MODE, getKey(pass));
                    }
                }
            } catch (InvalidKeyException ex) {
                Logger.getLogger(EncryptHelper.class.getName()).log(Level.SEVERE, null, ex);
                throw new EncryptException.IllegalEncryptParam();
            } catch (InvalidAlgorithmParameterException ex) {
                Logger.getLogger(EncryptHelper.class.getName()).log(Level.SEVERE, null, ex);
                throw new EncryptException.IllegalEncryptParam();
            }
            return cipher;
        }

    }

    static final int a = (int) 'a';
    static final int z = (int) 'z';
    static final int aa = (int) 'A';
    static final int zz = (int) 'Z';
    static final int n0 = (int) '0';
    static final int n9 = (int) '9';
    static final int st = (int) '*';
    static final int se = (int) '@';

    public static String base64Encode(String s) {
        try {
            return Base64.encodeBase64String(s.getBytes(STRING_ENCODING));
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(EncryptHelper.class.getName()).log(Level.SEVERE, null, ex);
            throw new EncryptException.IllegalEncryptParam();
        }
    }

    //    public static String base64Decode(String s) {
//        try {
//            byte[] bs = Base64.decodeBase64(s);
//            return new String(bs, STRING_ENCODING);
//        } catch (UnsupportedEncodingException ex) {
//            Logger.getLogger(EncryptHelper.class.getName()).log(Level.SEVERE, null, ex);
//            throw new EncryptException.IllegalEncryptParam();
//        }
//    }
    public static String base64Encode(byte[] bs) {
        return Base64.encodeBase64String(bs);
    }

    public static byte[] base64Decode(String s) {
        return Base64.decodeBase64(s);
    }

    public static String randomKey(int n) {
        StringBuilder ret = new StringBuilder();
        Random ran = new Random();
        ran.setSeed(System.currentTimeMillis());
        ran.setSeed(ran.nextLong());
        int nn = n < 16 ? 16 : n;
        for (int i = 0; i < nn; ++i) {
            int method = (int) (Math.random() * 4);
            if (method == 0) {
                char ch = (char) Math.floor(ran.nextDouble() * (z - a) + a);
                ret.append(ch);
            } else if (method == 1) {
                char ch = (char) Math.floor(ran.nextDouble() * (zz - aa)
                        + aa);
                ret.append(ch);
            } else if (method == 2) {
                char ch = (char) Math.floor(ran.nextDouble() * (n9 - n0)
                        + n0);
                ret.append(ch);
            } else if (method == 3) {
                char ch = (char) Math.floor(ran.nextDouble() * (se - st)
                        + st);
                ret.append(ch);
            }
        }
        return new String(ret);
    }

    public static String randomPass(int n) {
        StringBuilder ret = new StringBuilder();
        Random ran = new Random();
        ran.setSeed(System.currentTimeMillis());
        ran.setSeed(ran.nextLong());
        for (int i = 0; i < n; ++i) {
            int method = (int) (Math.random() * 3);
            if (method == 0) {
                char ch = (char) Math.floor(ran.nextDouble() * (z - a) + a);
                ret.append(ch);
            } else if (method == 1) {
                char ch = (char) Math.floor(ran.nextDouble() * (zz - aa)
                        + aa);
                ret.append(ch);
            } else if (method == 2) {
                char ch = (char) Math.floor(ran.nextDouble() * (n9 - n0)
                        + n0);
                ret.append(ch);
            }
        }
        return new String(ret);
    }

    public static KeyPair generateKeyPairNative() throws NoSuchAlgorithmException {
        return generateKeyPairNative(DEFAULT_KEY_SIZE);
    }


    public static KeyPair generateKeyPairNative(int keySize) throws NoSuchAlgorithmException {
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
        Long l = Long.reverseBytes(System.currentTimeMillis());

        keyPairGen.initialize(keySize, new SecureRandom(NumberHelper.longToBytes(l)));
        KeyPair keyPair = keyPairGen.genKeyPair();
        // RSAPrivateKey prk = (RSAPrivateKey) keyPair.getPrivate();
        // RSAPublicKey pbk = (RSAPublicKey) keyPair.getPublic();
        // BigInteger e = pbk.getPublicExponent();
        // BigInteger n = pbk.getModulus();
        // BigInteger d = prk.getPrivateExponent();
        // System.out.println("e: "+e);
        // System.out.println("n: "+n);
        // System.out.println("d: "+d);
        return keyPair;
    }

    public static byte[][] generateKeyPair() throws NoSuchAlgorithmException {
        return generateKeyPair(DEFAULT_KEY_SIZE);
    }

    public static byte[][] generateKeyPair(int keySize) throws NoSuchAlgorithmException {
        byte[][] ret = new byte[2][];
        KeyPair keyPair = generateKeyPairNative();
        ret[0] = getPublicKeyByteNative(keyPair);
        ret[1] = getPrivateKeyByteNative(keyPair);
        return ret;
    }

    public static byte[] getPublicKeyByteNative(KeyPair pair) {
        if (pair == null) {
            throw new EncryptException.IllegalEncryptParam();
        }
        return pair.getPublic().getEncoded();
    }

    public static byte[] getPrivateKeyByteNative(KeyPair pair) {
        if (pair == null) {
            throw new EncryptException.IllegalEncryptParam();
        }
        return pair.getPrivate().getEncoded();
    }

    public static String encryptString(String content, String pass, EncryptMethod method) {
        return encryptString(content, pass, DEFAULT_SALT, method);
    }

    public static String encryptString(String content, byte[] pass, EncryptMethod method) {
        return encryptString(content, pass, DEFAULT_SALT, method);
    }

    public static byte[] encryptBytes(byte[] content, byte[] pass, String salt, EncryptMethod method) {
        try {
            Cipher initedCipher = method.getInitedCipher(true, pass, salt);
            byte[] encrypted = initedCipher.doFinal(content);
            return encrypted;
        } catch (IllegalBlockSizeException ex) {
            Logger.getLogger(EncryptHelper.class.getName()).log(Level.SEVERE, null, ex);
            throw new EncryptException.IllegalEncryptParam();
        } catch (BadPaddingException ex) {
            Logger.getLogger(EncryptHelper.class.getName()).log(Level.SEVERE, null, ex);
            throw new EncryptException.IllegalEncryptParam();
        } catch (Exception ex) {
            Logger.getLogger(EncryptHelper.class.getName()).log(Level.SEVERE, null, ex);
            throw new EncryptException.IllegalEncryptParam();
        }

    }

    public static String encryptString(String content, byte[] pass, String salt, EncryptMethod method) {
        try {
            Cipher initedCipher = method.getInitedCipher(true, pass, salt);
            byte[] encrypted = initedCipher.doFinal(content.getBytes(STRING_ENCODING));
            return base64Encode(encrypted);
        } catch (IllegalBlockSizeException ex) {
            Logger.getLogger(EncryptHelper.class.getName()).log(Level.SEVERE, null, ex);
            throw new EncryptException.IllegalEncryptParam();
        } catch (BadPaddingException ex) {
            Logger.getLogger(EncryptHelper.class.getName()).log(Level.SEVERE, null, ex);
            throw new EncryptException.IllegalEncryptParam();
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(EncryptHelper.class.getName()).log(Level.SEVERE, null, ex);
            throw new EncryptException.IllegalEncryptParam();
        }

    }

    public static String encryptString(String content, String pass, String salt, EncryptMethod method) {
        try {
            Cipher initedCipher = method.getInitedCipher(true, pass, salt);
            byte[] encrypted = initedCipher.doFinal(content.getBytes(STRING_ENCODING));
            return base64Encode(encrypted);
        } catch (IllegalBlockSizeException ex) {
            Logger.getLogger(EncryptHelper.class.getName()).log(Level.SEVERE, null, ex);
            throw new EncryptException.IllegalEncryptParam();
        } catch (BadPaddingException ex) {
            Logger.getLogger(EncryptHelper.class.getName()).log(Level.SEVERE, null, ex);
            throw new EncryptException.IllegalEncryptParam();
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(EncryptHelper.class.getName()).log(Level.SEVERE, null, ex);
            throw new EncryptException.IllegalEncryptParam();
        }

    }

    public static String decryptString(String content, byte[] pass, EncryptMethod method) {
        return decryptString(content, pass, DEFAULT_SALT, method);
    }

    public static String decryptString(String content, String pass, EncryptMethod method) {
        return decryptString(content, pass, DEFAULT_SALT, method);
    }

    public static byte[] decryptBytes(byte[] content, byte[] pass, String salt, EncryptMethod method) {
        try {
            byte[] decoded = content;
            Cipher initedCipher = method.getInitedCipher(false, pass, salt);
            byte[] decrypted = initedCipher.doFinal(decoded);
            return decrypted;
        } catch (IllegalBlockSizeException ex) {
            Logger.getLogger(EncryptHelper.class.getName()).log(Level.SEVERE, null, ex);
            throw new EncryptException.IllegalEncryptParam();
        } catch (BadPaddingException ex) {
            Logger.getLogger(EncryptHelper.class.getName()).log(Level.SEVERE, null, ex);
            throw new EncryptException.IllegalEncryptParam();
        } catch (Exception ex) {
            Logger.getLogger(EncryptHelper.class.getName()).log(Level.SEVERE, null, ex);
            throw new EncryptException.IllegalEncryptParam();
        }
    }

    public static String decryptString(String content, byte[] pass, String salt, EncryptMethod method) {
        try {
            byte[] decoded = base64Decode(content);
            Cipher initedCipher = method.getInitedCipher(false, pass, salt);
            byte[] decrypted = initedCipher.doFinal(decoded);
            return new String(decrypted, STRING_ENCODING);
        } catch (IllegalBlockSizeException ex) {
            Logger.getLogger(EncryptHelper.class.getName()).log(Level.SEVERE, null, ex);
            throw new EncryptException.IllegalEncryptParam();
        } catch (BadPaddingException ex) {
            Logger.getLogger(EncryptHelper.class.getName()).log(Level.SEVERE, null, ex);
            throw new EncryptException.IllegalEncryptParam();
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(EncryptHelper.class.getName()).log(Level.SEVERE, null, ex);
            throw new EncryptException.IllegalEncryptParam();
        }
    }

    public static String decryptString(String content, String pass, String salt, EncryptMethod method) {
        try {
            byte[] decoded = base64Decode(content);
            Cipher initedCipher = method.getInitedCipher(false, pass, salt);
            byte[] decrypted = initedCipher.doFinal(decoded);
            return new String(decrypted, STRING_ENCODING);
        } catch (IllegalBlockSizeException ex) {
            Logger.getLogger(EncryptHelper.class.getName()).log(Level.SEVERE, null, ex);
            throw new EncryptException.IllegalEncryptParam();
        } catch (BadPaddingException ex) {
            Logger.getLogger(EncryptHelper.class.getName()).log(Level.SEVERE, null, ex);
            throw new EncryptException.IllegalEncryptParam();
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(EncryptHelper.class.getName()).log(Level.SEVERE, null, ex);
            throw new EncryptException.IllegalEncryptParam();
        }
    }

    public static void main(String[] args) throws Exception {

        String text = "1234567890";
        String key = "bgydkd881234567890145796", iv = "BgyDkdIV";
        String entext = encryptString(text, key, iv, EncryptMethod.DES3);
//        L.w(entext);
        String decryptString = decryptString(entext, key, iv, EncryptMethod.DES3);
//        L.w(decryptString);
        key = "bgydkd88ssddd3wt";
        iv = "siikeisdf1233223";
        entext = encryptString(text, key, iv, EncryptMethod.AES);
//        L.w(entext);
        decryptString = decryptString(entext, key, iv, EncryptMethod.AES);
//        L.w(decryptString);

//        byte[] codedtext = des3EncodeCBC(key, iv, text.getBytes());
//        System.out.println(new BASE64Encoder().encode(codedtext));
//
//        byte[] des3DecodeCBC = des3DecodeCBC(key, iv, codedtext);
//
//        // this is a byte array, you'll just see a reference to an array
//        System.out.println(new String(des3DecodeCBC)); // This correctly shows "kyle boon"
    }

    public abstract static class EncryptException extends RuntimeException {

        public EncryptException(String msg) {
            super(msg);
        }

        public static class UrlIllegal extends EncryptException {

            public UrlIllegal() {
                super("url illegal");
            }
        }

        public static class NoWebsiteAccess extends EncryptException {

            public NoWebsiteAccess() {
                super("can't access website");
            }
        }

        public static class NoFileAccess extends EncryptException {

            public NoFileAccess() {
                super("can't read file");
            }
        }

        public static class FormatIllegal extends EncryptException {

            public FormatIllegal() {
                super("not illegal format");
            }
        }

        public static class NullPointer extends EncryptException {

            public NullPointer() {
                super("not allow null");
            }
        }

        public static class NotEnoughResource extends EncryptException {

            public NotEnoughResource() {
                super("not enough resouce");
            }
        }

        public static class IllegalEncryptParam extends EncryptException {

            public IllegalEncryptParam() {
                super("illegal parameter");
            }
        }


    }
}
