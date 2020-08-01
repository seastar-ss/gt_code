/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shawn.ss.lib.tools;

import java.util.BitSet;
import java.util.regex.Pattern;

/**
 * @author ss
 */
public class NumberHelper {

    public static long LONG_HIGH_BIT_MUL = 4294967296L;

    static final Pattern INT_FORMAT = Pattern.compile("[+\\-]?\\d+");
    static final Pattern FLOAT_FORMAT = Pattern.compile("[+\\-]?\\d+\\.\\d+");


//    public static final String FORMAT_SPLIT_DOUBLE="%,1.[x]f";
//    public static final String FORMAT_DOUBLE="%1.[x]f";
//    public static final String FORMAT_SPLIT_INT="%,[x]d";
//    public static final String FORMAT_INT="%[x]d";


    public static double byteToDouble(byte[] bs) {
        long l = bytesToLong(bs);
        return Double.longBitsToDouble(l);
    }

    public static byte[] doubleToByte(Double b) {
        long l = Double.doubleToLongBits(b);
        return longToBytes(l);
    }

    public static long bytesToLong(byte[] bs) {
        if (bs.length == 8) {
            long highBit = ((((((long) bs[0]) & 0xff) << 24) & 0xff000000) + (((((int) bs[1]) & 0xff) << 16) & 0x00ff0000) + (((((int) bs[2]) & 0xff) << 8) & 0x0000ff00) + (((int) (bs[3])) & 0xff));
            long lowBit = ((((((long) bs[4]) & 0xff) << 24) & 0xff000000) + (((((int) bs[5]) & 0xff) << 16) & 0x00ff0000) + (((((int) bs[6]) & 0xff) << 8) & 0x0000ff00) + ((((int) bs[7]) & 0xff)));
            long i = highBit
                    * LONG_HIGH_BIT_MUL
                    + lowBit;
            return i;
        }
        throw new IllegalArgumentException("need eight bytes");
    }

    public static byte[] longToBytes(Long i) {
        byte[] ret = new byte[8];
        ret[0] = (byte) ((i >> 56) & 0x0ff);
        ret[1] = (byte) ((i >> 48) & 0x0ff);
        ret[2] = (byte) ((i >> 40) & 0x0ff);
        ret[3] = (byte) ((i >> 32) & 0x0ff);
        ret[4] = (byte) ((i >> 24) & 0x0ff);
        ret[5] = (byte) ((i >> 16) & 0x0ff);
        ret[6] = (byte) ((i >> 8) & 0x0ff);
        ret[7] = (byte) (i & 0x0ff);
        return ret;
    }

    public static int bytesToInt(byte[] bs) {
        if (bs.length == 4) {
            int i = (((((int) bs[0]) & 0xff) << 24) & 0xff000000)
                    | (((((int) bs[1]) & 0xff) << 16) & 0x00ff0000)
                    | (((((int) bs[2]) & 0xff) << 8) & 0x0000ff00)
                    | (((((int) bs[3]) & 0xff)) & 0x000000ff);
            return i;
        }
        throw new IllegalArgumentException("need four bytes");
    }

    public static byte[] intToBytes(Integer i) {
        byte[] ret = new byte[4];
        ret[0] = (byte) ((i >> 24) & 0x0ff);
        ret[1] = (byte) ((i >> 16) & 0x0ff);
        ret[2] = (byte) ((i >> 8) & 0x0ff);
        ret[3] = (byte) (i & 0x0ff);
        return ret;
    }

//    public static long bitSetToLong(BitSet bs) {
//        if(bs!=null) {
//            return bs.toLongArray()[0];
//        }
//        return -1;
//    }
//
//    public static boolean longToBitSet(Long i, BitSet bs, boolean clear) {
//        BitSet set=new BitSet()
//        boolean ret = false;
//        if (i != null && bs != null) {
//            if (clear)
//                bs.clear();
//            int k = 0;
//            while (i != 0) {
//                long t = i % 2;
//                if (t == 1) {
//                    bs.set(k);
//                    ret=true;
//                }
//                ++k;
//                i = i >> 1;
//            }
////            return true;
//        }
//
//        return ret;
//    }

    public static String intIoFixLengthStr(int i, int len) {
        return intToFixLengthStr(i, len, '0');
    }

    public static String intToFixLengthStr(int i, int len, char prefix) {

        String s = String.valueOf(i);
        int length = s.length();
        if (length > len) {
            throw new IllegalArgumentException("数值长度超过指定的字符长度");
        } else {
            StringBuilder ret = new StringBuilder();
            for (int x = 0, n = len - length; x < n; ++x) {
                ret.append(prefix);
            }
            ret.append(s);
            return ret.toString();
        }
    }

    public static boolean isInt(String s) {
        return INT_FORMAT.matcher(s).matches();
    }

    public static boolean isDouble(String s) {
        return FLOAT_FORMAT.matcher(s).matches();
    }

    public static boolean isNum(String s) {
        return isInt(s) || isDouble(s);
    }

    public static String getNumberStr(Number n, boolean split, int precision) {
        if (precision > 0) {
            double v = n.doubleValue();
            String format = split ? "%,1." + precision + "f" : "%1." + precision + "f";
            return String.format(format, v);
        } else {
            long l = n.longValue();
            String format = split ? "%,d" : "%d";
            return String.format(format, l);
        }
    }

    public static int byteToUnsignInt(byte b) {
        return ((int) b) & 0xff;
    }

    public static void main(String[] args) {
        int x = 0xff112233;
        byte[] bs = intToBytes(x);

        int y = bytesToInt(bs);

    }

    public static int longToInt(long l) {
        if (l < Integer.MIN_VALUE || l > Integer.MAX_VALUE) {
            throw new IllegalArgumentException
                    (l + " cannot be cast to int without changing its value.");
        }
        return (int) l;
    }

    final static int FIX_64BIT = 6;
    final static int FIX_64BIT_REIDX = 1 << FIX_64BIT;

    public static String toCompact64Int(Long i) {
        if (i == null || i == 0) {
            return "0";
        }
        StringBuilder ret = new StringBuilder();
        long remain;
        long num = i;
        boolean positive = true;
//        boolean flag=true;
//        int index=0;
//oYd4csxOqu3jRsNL1r1IKpd3e3Go
        if (num < 0) {
            positive = false;
            num = -num;
        }
        while (num != 0) {

            remain = num % FIX_64BIT_REIDX;

            ret.append(fromInt(remain));
            num = num >> FIX_64BIT;
        }
        return (positive ? "" : "~").concat(ret.reverse().toString());
    }

    public static long fromCompact64Int(String compactInt) {
        long ret = 0;

        int i = 0;
        boolean positive = !compactInt.startsWith("~");
        if (!positive) {
            compactInt = compactInt.replace("~", "");
        }
        final char[] chars = compactInt.toCharArray();
        int n = compactInt.length() - 1;
        for (char c : chars) {
            final long num = toInt(c);
            if (num > 0) {
                ret += num * (1L << (FIX_64BIT * (n - i)));
            }
            ++i;
        }
        return positive ? ret : -ret;
    }

    private static char fromInt(long i) {
        if (i >= 0 && i < 10) {
            return (char) (48 + i);
        } else if (i >= 10 && i < 36) {
            return (char) (97 + i - 10);
        } else if (i >= 36 && i < 62) {
            return (char) (65 + i - 36);
        } else if (i == 62) {
            return '-';
        } else if (i == 63) {
            return '_';
        }
        throw new IllegalStateException("64 FIX_64BIT only can represent 0-63");
    }

    private static long toInt(char c) {
        if (c >= 48 && c <= 57) {
            return (int) (c - 48);
        } else if (c >= 97 && c <= 122) {
            return (int) (c - 97 + 10);
        } else if (c >= 65 && c <= 90) {
            return (int) (c - 65 + 36);
        } else if (c == '-') {
            return 62;
        } else if (c == '_') {
            return 63;
        }
        throw new IllegalStateException("64 FIX_64BIT only can represent [0-9a-zA-Z\\-_]");
    }

}
