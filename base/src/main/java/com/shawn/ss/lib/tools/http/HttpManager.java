/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shawn.ss.lib.tools.http;

import com.shawn.ss.lib.tools.structure.ByteArrayPool;
import com.shawn.ss.lib.tools.structure.LRUCache;
import com.shawn.ss.lib.tools.structure.PoolingByteArrayOutputStream;
//import org.apache.http.ssl.SSLContexts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import java.io.*;
import java.net.*;
import java.security.*;
import java.security.cert.CertificateException;
import java.util.Map;
import java.util.Set;


/**
 * @author ss
 */
public class HttpManager implements OHttpHelper {

    public static final Logger L= LoggerFactory.getLogger(HttpManager.class);

    public static LRUCache<String, SSLSocketFactory> sslFactories = new LRUCache<>(20);

    public HttpManager() {
    }

    public static OHttpHelper getHelper() {
        return new HttpManager();
    }

//    @Override
//    public void loadCertificate(String name, String certPos, String pass) {
//        if (name == null) {
//            throw new IllegalArgumentException("需要name参数");
//        }
//        if (sslFactories.get(name) != null) {
//            return;
//        }
//        try {
//            KeyStore keyStore = KeyStore.getInstance(CERT_FORMAT);
////            FileInputStream instream = new FileInputStream(new File(certPos));
//            InputStream stream = Thread.currentThread().getContextClassLoader().getResourceAsStream(certPos);
////            InputStream stream = HttpManager.class.getResourceAsStream(certPos);
//
//            try {
//                keyStore.load(stream, pass.toCharArray());
////                keyStore.load();
//            } finally {
//                if (stream != null)
//                    stream.close();
//            }
////            TrustManagerFactory tmf =
////                    TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
////            tmf.init(keyStore);
//
////            SSLContext ctx = SSLContext.getInstance("TLS");
////            ctx.init(null, tmf.getTrustManagers(), null);
//            // Trust own CA and all self-signed certs
//            SSLContext ctx = SSLContexts.custom()
//                    .loadKeyMaterial(keyStore, pass.toCharArray())
//                    .build();
//            // Allow TLSv1 protocol only
//            SSLSocketFactory socketFactory = ctx.getSocketFactory();
//            sslFactories.put(name, socketFactory);
//        } catch (FileNotFoundException ex) {
//            ex.printStackTrace();
//            throw new IllegalArgumentException("证书文件不存在");
//        } catch (IOException e) {
//            e.printStackTrace();
//            throw new IllegalArgumentException("读入文件异常");
//        } catch (CertificateException e) {
//            e.printStackTrace();
//            throw new IllegalArgumentException("证书异常");
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//            throw new IllegalArgumentException("不支持的算法");
//        } catch (KeyStoreException e) {
//            e.printStackTrace();
//            throw new IllegalArgumentException("证书无法解析");
//        } catch (KeyManagementException e) {
//            e.printStackTrace();
//            throw new IllegalArgumentException("证书管理器出错");
//        } catch (UnrecoverableKeyException e) {
//            e.printStackTrace();
//            throw new IllegalArgumentException("证书管理器出错---");
//        }
//    }
//
//    @Override
//    public int requestHttps(String sslFactoryName, GenericRequest<?> request) {
//        SSLSocketFactory factory = null;
//        if (sslFactoryName != null)
//            factory = sslFactories.get(sslFactoryName);
//        if (factory == null) {
//            L.info("未找到证书的配置");
//        }
//        InputStream in = null;
//        BufferedOutputStream out = null;
//        PoolingByteArrayOutputStream res = null;
//        try {
//            URL url = new URL(request.getUrl());
//            //System.out.println("request string:" + request);
////        URL url = new URL("http://10.18.103.105:8080/market/api");
//            HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
//
//            if (factory != null)
//                conn.setSSLSocketFactory(factory);
//            conn.setConnectTimeout(request.getTimeout());
//            conn.setReadTimeout(request.getReadTimeout());
//            conn.addRequestProperty("Content-Type", request.getContentType());
//            conn.addRequestProperty("User-Agent", request.getUserAgent());
////            conn.addRequestProperty("Connection","close");
//            Map<String, String> headers = request.getHeaders();
//            if (headers != null && headers.size() > 0) {
//                Set<Map.Entry<String, String>> entrySet = headers.entrySet();
//                for (Map.Entry<String, String> entry : entrySet) {
//                    conn.addRequestProperty(entry.getKey(), entry.getValue());
//                }
//            }
//            conn.setDoInput(true);
//            GenericRequest.Method method = request.getMethod();
//            conn.setRequestMethod(method.name());
//            if (method != GenericRequest.Method.GET) {
//                conn.setDoOutput(true);
//                out = new BufferedOutputStream(conn.getOutputStream());
//                byte[] body = request.getBody();
//                L.info("send", new String(body));
//                if (body != null) {
//                    out.write(body);
//                    out.flush();
//                }
//            }
//
////            int resCode = conn.getResponseCode();
//
//            res = new PoolingByteArrayOutputStream(102400);
//
////            if (resCode < 200 || resCode >= 400) {
////                in = conn.getErrorStream();
////            } else {
//            in = conn.getInputStream();
////            }
//            byte[] buf = new byte[1024];
//            int read = 0;
//            if (in != null) {
//                while ((read = in.read(buf)) >= 0) {
//                    res.write(buf, 0, read);
//                }
//                request.result = res.toByteArray();
//            }
//
//            request.resCode = NetResponseCode.toStatus(200);
//            return 1;
//        } catch (MalformedURLException ex) {
//            L.error("error:", ex);
//            request.resCode = NetResponseCode.illegal_url;
//            request.exceptionMsg = ex.getMessage();
//        } catch (IOException ex) {
//            L.error("error:", ex);
//            request.resCode = NetResponseCode.no_reponse;
//            request.exceptionMsg = ex.getMessage();
//        } finally {
//            if (out != null) {
//                try {
//                    out.close();
//                } catch (IOException ex) {
//                    L.error("l error:", ex);
//                }
//            }
//            if (in != null) {
//                try {
//                    in.close();
//                } catch (IOException ex) {
//                    L.error("l error:", ex);
//                }
//            }
//            if (res != null) {
//                try {
//                    res.close();
//                } catch (IOException ex) {
//                    L.error("l error:", ex);
//                }
//            }
//        }
//        return -1;
//    }

    @Override
    public int request(GenericRequest<?> request) {
        InputStream in = null;
        BufferedOutputStream out = null;
        PoolingByteArrayOutputStream res = null;
        try {
            URL url = new URL(request.getUrl());
            //System.out.println("request string:" + request);
//        URL url = new URL("http://10.18.103.105:8080/market/api");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(request.getTimeout());
            conn.setReadTimeout(request.getReadTimeout());
            conn.addRequestProperty("Content-Type", request.getContentType());
            conn.addRequestProperty("User-Agent", request.getUserAgent());
            Map<String, String> headers = request.getHeaders();
            if (headers != null && headers.size() > 0) {
                Set<Map.Entry<String, String>> entrySet = headers.entrySet();
                for (Map.Entry<String, String> entry : entrySet) {
                    conn.addRequestProperty(entry.getKey(), entry.getValue());
                }
            }
            conn.setDoInput(true);
            GenericRequest.Method method = request.getMethod();
            conn.setRequestMethod(method.name());
            if (method != GenericRequest.Method.GET) {
                conn.setDoOutput(true);
                out = new BufferedOutputStream(conn.getOutputStream());
                byte[] body = request.getBody();
                if (body != null) {
                    out.write(body);
                    out.flush();
                }
            }

            int resCode = conn.getResponseCode();
//            if(resCode<200 || resCode>210){
//                return
//            }

            res = new PoolingByteArrayOutputStream(102400);

            if (resCode < 200 || resCode >= 400) {
                in = conn.getErrorStream();
            } else {
                in = conn.getInputStream();
            }
            byte[] buf = new byte[1024];
            int read = 0;
            if (in != null) {
                while ((read = in.read(buf)) >= 0) {
                    res.write(buf, 0, read);
                }
                request.result = res.toByteArray();
            }

            request.resCode = NetResponseCode.toStatus(resCode);
            return 1;
        } catch (MalformedURLException ex) {
            L.error("error:", ex);
            request.resCode = NetResponseCode.illegal_url;
            request.exceptionMsg = ex.getMessage();
        } catch (IOException ex) {
            L.error("error:", ex);
            request.resCode = NetResponseCode.no_reponse;
            request.exceptionMsg = ex.getMessage();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException ex) {
                    L.error("l error:", ex);
                }
            }
            if (in != null) {
                try {
                    in.close();
                } catch (IOException ex) {
                    L.error("l error:", ex);
                }
            }
            if (res != null) {
                try {
                    res.close();
                } catch (IOException ex) {
                    L.error("l error:", ex);
                }
            }
        }
        return -1;
    }

    @Override
    public int download(GenericDownloadRequest request) {
        InputStream in = null;
        BufferedOutputStream out = null;
        BufferedOutputStream res = null;
        byte[] buf = ByteArrayPool.getInstance().getBuf(51200);
        try {
            URL url = new URL(request.getUrl());
            String protocol = url.getProtocol();
            //System.out.println("request string:" + request);
//        URL url = new URL("http://10.18.103.105:8080/market/api");
            URLConnection con = null;
            HttpURLConnection conn = null;
            try {
                if (!request.useProxy) {
                    con = url.openConnection();
                } else {
                    Proxy p = request.pickProxy();
                    con = url.openConnection(p);
                }
                if (protocol.equals("http")) {
                    conn = (HttpURLConnection) con;
                } else if (protocol.equals("https")) {
                    conn = (HttpsURLConnection) con;
                } else {
                    throw new IllegalArgumentException("not support");
                }
            } catch (IOException ex) {
                L.error("error:", ex);
                request.resCode = NetResponseCode.no_reponse;
                request.exceptionMsg = ex.getMessage();
                return -1;
            }

            conn.setConnectTimeout(request.getTimeout());
            conn.setReadTimeout(request.getReadTimeout());
            conn.addRequestProperty("Content-Type", request.getContentType());
            conn.addRequestProperty("User-Agent", request.getUserAgent());
            Map<String, String> headers = request.getHeaders();
            if (headers != null && headers.size() > 0) {
                Set<Map.Entry<String, String>> entrySet = headers.entrySet();
                for (Map.Entry<String, String> entry : entrySet) {
                    conn.addRequestProperty(entry.getKey(), entry.getValue());
                }
            }
            conn.setDoInput(true);
            GenericRequest.Method method = request.getMethod();
            try {
                conn.setRequestMethod(method.name());
            } catch (ProtocolException ex) {
                L.error("error:", ex);
                request.resCode = NetResponseCode.no_reponse;
                request.exceptionMsg = ex.getMessage();
                return -2;
            }

            if (method != GenericRequest.Method.GET) {
                try {
                    conn.setDoOutput(true);
                    out = new BufferedOutputStream(conn.getOutputStream());
                    byte[] body = request.getBody();
                    if (body != null) {
                        out.write(body);
                        out.flush();
                    }
                } catch (IOException ex) {
                    L.error("error:", ex);
                    request.resCode = NetResponseCode.no_reponse;
                    request.exceptionMsg = ex.getMessage();
                    return -3;
                }
            }

            int resCode;
            try {
                resCode = conn.getResponseCode();
            } catch (IOException ex) {
                L.error("error:", ex);
                request.resCode = NetResponseCode.no_reponse;
                request.exceptionMsg = ex.getMessage();
                return -4;
            }

            try {
                res = new BufferedOutputStream(new FileOutputStream(request.getFile()));
            } catch (FileNotFoundException ex) {
                L.error("error:", ex);
                request.resCode = NetResponseCode.unable_to_save;
                request.exceptionMsg = ex.getMessage();
                return -5;
            }

            if (resCode < 200 || resCode >= 400) {
                in = conn.getErrorStream();
            } else {
                try {
                    in = conn.getInputStream();
                } catch (IOException ex) {
                    L.error("error:", ex);
                    request.resCode = NetResponseCode.no_reponse;
                    request.exceptionMsg = ex.getMessage();
                    return -6;
                }
            }

            int read = 0;
            if (in != null) {
                try {
                    while ((read = in.read(buf)) >= 0) {
                        try {
                            res.write(buf, 0, read);
                        } catch (IOException ex) {
                            L.error("error:", ex);
                            request.resCode = NetResponseCode.unable_to_save;
                            request.exceptionMsg = ex.getMessage();
                            return -5;
                        }
                    }
                } catch (IOException ex) {
                    L.error("error:", ex);
                    request.resCode = NetResponseCode.no_reponse;
                    request.exceptionMsg = ex.getMessage();
                    return -7;
                }
//                request.result = res.toByteArray();
                try {
                    res.flush();
                } catch (IOException ex) {
                    L.error("error:", ex);
                    request.resCode = NetResponseCode.unable_to_save;
                    request.exceptionMsg = ex.getMessage();
                    return -5;
                }
            }
            request.resCode = NetResponseCode.toStatus(resCode);
            return 1;
        } catch (MalformedURLException ex) {
            L.error("error:", ex);
            request.resCode = NetResponseCode.illegal_url;
            request.exceptionMsg = ex.getMessage();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException ex) {
                    L.error("l error:", ex);
                }
            }
            if (in != null) {
                try {
                    in.close();
                } catch (IOException ex) {
                    L.error("l error:", ex);
                }
            }
            if (res != null) {
                try {
                    res.close();
                } catch (IOException ex) {
                    L.error("l error:", ex);
                }
            }
            if (buf != null) {
                ByteArrayPool.getInstance().returnBuf(buf);
            }
        }
        return -1;
    }

//    @Override
//    public int uploadMultipart(UploadRequest request) {
//        try {
//            new MultipartLoadTaskImpl(request).run();
//            return 1;
//        } catch (IOException e) {
//            e.printStackTrace();
//
//        }
//        return -1;
//    }


    static class Request extends GenericRequest<String> {

        public Request() {
            super(Method.GET);
        }

        @Override
        public String getUrl() {
            return "http://ex.bgy.com.cn/crmtest/weixintest/DaoKouDai/payNotifyUrl.aspx";
        }

        @Override
        public byte[] getBody() {
            return null;
        }

        @Override
        public String getResult() {
            return new String(super.result);
        }

    }

    public static void main(String[] args) {
        Request request = new Request();
        HttpManager.getHelper().request(request);
        L.info(request.getResult());
    }
}
