package com.shawn.ss.lib.tools;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Map;

/**
 * Created by ss on 2017/9/26.
 */
public class URLHelper {

    public static String ipToStr(byte[] ip) {
        if (ip.length == 4) {
            StringBuilder ipStr = new StringBuilder();
            for (int i = 0; i < 4; ++i) {
                ipStr.append(".").append((int) (ip[i] & 0x0ff));
            }
            if (ipStr.length() > 1) {
                ipStr.deleteCharAt(0);
            }
            return ipStr.toString();
        } else if (ip.length == 6) {

        }

        return null;
    }

    public static String encodeUrl(String s) {
        try {
            return URLEncoder.encode(s, "UTF-8");
        } catch (UnsupportedEncodingException e) {
//            L.e(e);
            e.printStackTrace();
        }
        return null;
    }

    public static String decodeUrl(String s) {
        try {
            return URLDecoder.decode(s, "UTF-8");
        } catch (UnsupportedEncodingException e) {
//            L.e(e);
            e.printStackTrace();
        }
        return null;
    }

    public static String encodeURLParameters(Map<String, Object> params,
                                             String paramsEncoding) {
        if (params == null || params.size() == 0) {
            return "";
        }
        StringBuilder encodedParams = new StringBuilder();
        try {
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                String k = entry.getKey();
                if (k != null && k.length() > 0) {
                    encodedParams.append(URLEncoder.encode(k, paramsEncoding));
                    encodedParams.append('=');
                    // L.x("network request param", entry);
                    Object v = entry.getValue();
                    // L.x("network request value", v);
                    String vv = URLEncoder.encode(v == null ? "" : v.toString(), paramsEncoding);
                    encodedParams.append(vv);
                    encodedParams.append('&');
                }
            }
            if (encodedParams.length() > 0) {
                encodedParams.deleteCharAt(encodedParams.length() - 1);
            }
            return encodedParams.toString();
        } catch (UnsupportedEncodingException uee) {
            throw new RuntimeException("Encoding not supported: " + paramsEncoding, uee);
        }
    }

}
