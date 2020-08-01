package com.shawn.ss.lib.tools;

import java.io.*;
import java.math.BigInteger;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by ss on 2015/10/15.
 */
public class CustomizedRSAHandler {

    static final int radix = 16;
    static final int KEY_SIZE = 2048;
    public static final int MAX_SIZE = 128;
    public static final int PUBLIC_KEY = 0;
    public static final int PRIVATE_KEY = 1;
    public static final int BUFFER_SIZE = 20480;
    public static final byte[] spliter;
    public static final String SIGN_INFO = "------ rsa special implementation v1;";
    public static final String SIGN_KEY_ID = "identifier";
    public static final String SIGN_FORMAT = SIGN_KEY_ID + ":{identifier};sign by:{name};time:{date};hash:{hash};";
    public static final String DEFAULT_NAME = "shawn.ss.lib";
    public static final String DEFUALT_ENCODING = "utf-8";
    public static final String PRIVATE_KEY_DEFAULT_NAME_APPENDIX="private.ppk";
    public static final String PUBLIC_KEY_DEFAULT_NAME_APPENDIX="public.ppk";

    static {
        long i = 778765110835084800L;
        spliter = NumberHelper.longToBytes(i);
    }

    public static void saveKey(KeyPair pair, String base) throws IOException {
        saveKey(pair, base, DEFAULT_NAME);
    }

    public static void saveKey(KeyPair pair, String base, String name)
            throws FileNotFoundException, IOException {
        FileOutputStream f1 = null, f2 = null;
        String timeString = DateTimeHelper.newInstance().getCurrentDateTimeString(DateTimeHelper.DEFUALT_STYLE_LONG_DATE_LONG_TIME_FORMAT);


        RSAPrivateKey privateKey = (RSAPrivateKey) pair.getPrivate();
        RSAPublicKey publicKey = (RSAPublicKey) pair.getPublic();
        BigInteger n, e, d;
        // Save Pirvate Key
        e = privateKey.getPrivateExponent();
        n = privateKey.getModulus();
        d = publicKey.getPublicExponent();

        String hashStr = HashHelper.getHashValue(StringHelper.concat(d.toString(radix), ";", e.toString(radix), ";", n.toString(radix)), HashHelper.HashMethod.sha1);
        String pubHashStr = HashHelper.getHashValue(StringHelper.concat(d.toString(radix), ";", n.toString(radix)), HashHelper.HashMethod.sha1);
        String priHashStr = HashHelper.getHashValue(StringHelper.concat(e.toString(radix), ";", n.toString(radix)), HashHelper.HashMethod.sha1);
//            String pubHash=StringHelper.HashHandler.getHashValue(d.toByteArray(), StringHelper.HashHandler.HashMethod.sha1);
//            String priHash=StringHelper.HashHandler
        String signaturePublic = StringHelper.genStr(SIGN_INFO, SIGN_FORMAT,
                CollectionHelper.<String, Object>mapBuilder().put("name", name).put("date", timeString).put("hash", hashStr).put("identifier", pubHashStr).getMap());
        String signaturePrivate = StringHelper.genStr(SIGN_INFO, SIGN_FORMAT,
                CollectionHelper.<String, Object>mapBuilder().put("name", name).put("date", timeString).put("hash", hashStr).put("identifier", priHashStr).getMap());

        String pubSig = encrypt(signaturePublic, MAX_SIZE, new BigInteger[]{e, n});
        String priSig = encrypt(signaturePrivate, MAX_SIZE, new BigInteger[]{d, n});
        try {
            f1 = new FileOutputStream(base +PRIVATE_KEY_DEFAULT_NAME_APPENDIX );
            f1.write(e.toByteArray());
            f1.write(spliter);
            f1.write(n.toByteArray());
            f1.write(spliter);
            f1.write(priSig.getBytes());
            f1.flush();
            // Save Public Key
            f2 = new FileOutputStream(base + PUBLIC_KEY_DEFAULT_NAME_APPENDIX);
            f2.write(d.toByteArray());
            f2.write(spliter);
            f2.write(n.toByteArray());
            f2.write(spliter);
            f2.write(pubSig.getBytes());
            f2.flush();
        } finally {
            if (f1 != null) {
                f1.close();
            }
            if (f2 != null) {
                f2.close();
            }
        }
//        ObjectOutputStream b2 = new ObjectOutputStream(f2);
//        b2.writeObject(publicKey);
    }

    public static BigInteger[] getParam(String file) throws IOException {
        List<BigInteger> ret = CollectionHelper.newList();
        BigInteger n = null;
        FileInputStream ins = new FileInputStream(file);
        byte[] b = new byte[BUFFER_SIZE];
        int read = 0;
        List<Byte> bs = CollectionHelper.newList();
//        byte[] bz=new byte[7];
        int zindex = 0;
        int ct = 0;
        while ((read = ins.read(b)) > 0) {
            int x = 0;
            while (x < read) {
                if (x + spliter.length < read) {
                    byte[] range = Arrays.copyOfRange(b, x, x + spliter.length);
                    if (Arrays.equals(range, spliter)) {
                        x = x + spliter.length;
                    }
                }
//                byte bi = b[x];
//                if (bi != 0) {
//                    for (int i = 0; i < zindex; ++i) {
//                        bs.add((byte) 0);
//                    }
//                    zindex = 0;
//                    bs.add(bi);
//                } else {
//                    ++zindex;
//                    if (zindex >= spliter.length) {
//                        if (ret.size() < 2) {
//                            n = bytesToBigInteger(bs);
//                            ret.add(n);
//                            bs.clear();
//                            zindex = 0;
//                        }
//                    }
//                }
            }
        }
        if (bs.size() > 0) {
            validate(ret, bs);
        }
//        if (type == PUBLIC_KEY) {
//            RSAPublicKey pbk = (RSAPublicKey) b.readObject();
//            e = pbk.getPublicExponent();
//            n = pbk.getModulus();
//        } else {
//            RSAPrivateKey prk = (RSAPrivateKey) b.readObject();
//            e = prk.getPrivateExponent();
//            n = prk.getModulus();
//        }
        BigInteger[] r = new BigInteger[ret.size()];
        return ret.toArray(r);
    }

    private static void validate(List<BigInteger> ret, List<Byte> bs) {
        String text = bytesToString(bs);
        if (ret.size() == 2) {
            try {
                BigInteger[] params = {ret.get(0), ret.get(1)};
                String sig = decrypt(text, params);

                if (sig.startsWith(SIGN_INFO)) {
                    String[] strings = sig.split(";");
                    for (String s : strings) {
                        if (s.startsWith(SIGN_KEY_ID)) {
                            String ss = s.replace(SIGN_KEY_ID, "").replace(":", "").replace(" ", "");
                            String hash = HashHelper.getHashValue(StringHelper.concat(params[0].toString(radix), ";", params[1].toString(radix)), HashHelper.HashMethod.sha1);
                            if (ss.equals(hash))
                                return;
                        }
                    }
                }
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        throw new IllegalArgumentException("rsa key not illegal");
    }

    final static String bytesToString(List<Byte> bs) {
        return new String(bytesToByteArray(bs));
    }

    final static byte[] bytesToByteArray(List<Byte> bs) {
        byte[] bss = new byte[bs.size()];
        for (int ii = 0; ii < bss.length; ++ii) {
            bss[ii] = bs.get(ii);
        }
        return bss;
    }

    final static BigInteger bytesToBigInteger(List<Byte> bs) {
//        byte[] bss = new byte[bs.size()];
//        for (int ii = 0; ii < bss.length; ++ii) {
//            bss[ii] = bs.get(ii);
//        }
//                        bss=bs.toArray(bss);
        return new BigInteger(bytesToByteArray(bs));
    }

    public static BigInteger[] getParam(String file, int type)
            throws FileNotFoundException, IOException,
            ClassNotFoundException {
        BigInteger n, e;
        FileInputStream f = new FileInputStream(file);
        ObjectInputStream b = new ObjectInputStream(f);
        if (type == PUBLIC_KEY) {
            RSAPublicKey pbk = (RSAPublicKey) b.readObject();
            e = pbk.getPublicExponent();
            n = pbk.getModulus();
        } else {
            RSAPrivateKey prk = (RSAPrivateKey) b.readObject();
            e = prk.getPrivateExponent();
            n = prk.getModulus();
        }
        b.close();
        return new BigInteger[]{e, n};
    }

    public static BigInteger encrypt(BigInteger input, BigInteger[] e) {

        return input.modPow(e[0], e[1]);
    }

    public static String encrypt(String msg, BigInteger[] e)
            throws UnsupportedEncodingException {

        byte ptext[] = msg.getBytes(DEFUALT_ENCODING);
        BigInteger m = new BigInteger(ptext);
        BigInteger c = m.modPow(e[0], e[1]);

        String cs = c.toString(radix);
        return cs;
    }

    /*
     * Key: m =
     * 13382700397842331480471697762887048077099067117069331445189511358810041876510447630394306695085604701032772158108023321937321071224962312860472321488393699073560145458985648439392974470988622824846017170155100783204105744470948919469506905134346753420325758285521759950170160314720922867916049648921031942913
     * e = 65537 d =
     * 13278762248361858667807704992981353469911624524906304609881189933025610008784677182496619860048929650407542424850825344140563568970457135369192885267059293141637871179523098592874898947776220735531286795691997223167224246881856056954599175982380721938036043547500477094560383188473499174712586543478311098193
     */
    public static String decrypt(String ctext, BigInteger d[], boolean simple)
            throws UnsupportedEncodingException {
        if(simple) {
            BigInteger c = new BigInteger(ctext, radix);

            BigInteger m = c.modPow(d[0], d[1]);

            byte[] mt = m.toByteArray();

            return new String(mt, DEFUALT_ENCODING);
        }else{
            return decrypt(ctext,d);
        }
    }



//    public static byte[] longToByte(Long src) {
//        byte[] ret = new byte[10];
//        int i = 0;
//        while (src > 255) {
//            byte b = (byte) (src % 255);
//            ret[i++] = b;
//            src = src / 255;
//        }
////        byte[] bytes = "sdfasdkfksaflas".getBytes();
//
//        return ret;
//    }

    public static String encrypt(String signStr, int n,
                                 BigInteger[] param) throws UnsupportedEncodingException {
        String remain = signStr;
        StringBuilder sign = new StringBuilder();
        do {
            if (n < remain.length()) {
                String cur = remain.substring(0, n);
                // System.out.println(cur);
                sign.append(encrypt(cur, param)).append(";");
                remain = remain.substring(n);
            } else {

            }
        } while ((remain.length() > n));
        sign.append(encrypt(remain, param)).append(";");
        return sign.toString();
    }

    public static String decrypt(String str, BigInteger[] param)
            throws UnsupportedEncodingException {
        StringBuilder ret = new StringBuilder();
        Scanner sc = new Scanner(str);
        sc.useDelimiter(";");
        while (sc.hasNext()) {
            ret.append(decrypt(sc.next(), param, true));
        }
        return ret.toString();
    }

    public static void main(String[] args) {
        Long l = Long.reverseBytes(System.currentTimeMillis());
        byte[] b = NumberHelper.longToBytes(l);
        String s = StringHelper.concat(b);
        System.out.println(s);
    }
}
