package com.shanw.ss.lib.tools.test;


import com.shawn.ss.lib.tools.*;
import okhttp3.*;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class HttpHelperTest {
    public static final Logger L = LoggerFactory.getLogger(HttpHelperTest.class);
    HttpHelper httpHelper = new HttpHelper();

    public void forCode() throws Exception {
//        final ServerSocket socket = new ServerSocket(8090);
//        final Socket s = socket.accept();
//        Socket ss=new Socket();
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                int read;
//                try {
//                    InputStream inputStream = s.getInputStream();
//                    byte[] buf = new byte[10240];
//                    while ((read=inputStream.read(buf))>0){
//                        System.out.println(new String(buf,0,read));
//                    }
//                } catch (Exception ex) {
//
//                }
//            }
//        }).start();
    }

    @Before
    public void setup() {
        try {
            httpHelper.afterPropertiesSet();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCommonGetRequest() {
//        HttpHelper httpHelper=new HttpHelper();
        final String s = httpHelper.getForString("http://www.sunlands.com");
        L.debug(s.substring(0, 100));
    }

    @Test
    public void testBuildSpecialRequest() {
        httpHelper.init(HttpHelper.HttpConfig.defaultConfig()
                .addInterceptor(new KnBaseInterceptor(httpHelper),true));
        httpHelper.postForString("http://knbase.shangdejigou.cn/wiki-parent/svbk/doc/get",
                CollectionHelper.<String, Object>mapBuilder()
                        .put("parent", "1")
                        .getMap());
//        for(String s:StringContainers.list) {
//            final String index = httpHelper.postForString("http://knbase.shangdejigou.cn/wiki-parent/svbk/common/evictCache",
//                    CollectionHelper.<String, Object>mapBuilder()
//                            .put("index", s)
//                            .getMap());
//            System.out.println("\n*********"+index+"********\n");
//        }
    }

    @Test
    public void testCommonPostRequest() {
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
//        MultiValueMap<String, Object> bodyMap = new LinkedMultiValueMap<>();
//        bodyMap.add("data","");
//        final HttpEntity<MultiValueMap<String, Object>> entity = new HttpEntity<>(
//                bodyMap,
//                headers
//        );
        final String forString = httpHelper.postForString(
                "http://social.sunlands.com/community/weixin/getWxTokenAndTicket",
                Collections.<String, Object>singletonMap("data", ""), null, true
        );
        L.debug(forString);
    }

//    @Test
    public void obtainToken() {
        final long currentTimeMillis = System.currentTimeMillis();
        String account = "shisheng";
        String channel = "Sv-Community";
        String secret = "secret_djsmhfrkohpi28";
        String needSign = StringHelper.concat(
                "account=", account,
                "&channel=", channel,
                "&timestamp=", currentTimeMillis,
                "&", secret
        );
        final String sign = HashHelper.getHashValue(needSign, HashHelper.HashMethod.md5);
        final BaseResultWrapper post = httpHelper.postForObject(
                "http://knbase.shangdejigou.cn/wiki-parent/svbk/common/getToken",
                CollectionHelper.<String, Object>mapBuilder()
                        .put("account", account)
                        .put("channel", channel)
                        .put("timestamp", currentTimeMillis)
                        .put("sign", sign)
                        .getMap(), BaseResultWrapper.class
        );
        L.info("get result:", post);
        final String tokenResult = httpHelper.getForString(
                "http://knbase.shangdejigou.cn/wiki-parent/svbk/common/init?userToken=" + post.getData());
        L.info("get result2:", tokenResult);
        final String result = httpHelper.getForString("http://knbase.shangdejigou.cn/wiki-parent/svbk/doc/get");
        L.info("get result3:{}", result);
    }



    private static class KnBaseInterceptor extends AbstractAuthInterceptor implements Interceptor {
        public static final int MAX_RETRY_TIME = 3;
        //        private volatile String token;
        private HttpHelper httpHelper;
        private static Set<String> unAuthUrl;

        static {
            unAuthUrl = CollectionHelper.<String>setBuilder()
                    .add("/wiki-parent/svbk/common/init")
                    .add("/wiki-parent/svbk/common/getToken")
                    .getSet();
        }


        public KnBaseInterceptor(HttpHelper httpHelper) {
            super(false);
            this.httpHelper = httpHelper;
        }

//        public KnBaseInterceptor(OkHttpClient client, boolean forWebSocket) {
//            super(client, forWebSocket);
//        }

//        @Override
//        public Response intercept(Chain chain) throws IOException {
////            boolean requestHasFailedflag=false;
//            Request request = chain.request();
//            if (!testAuth(request)) {
//                synchronized (this) {
//                    obtainToken();
//                }
//            }
//            int count = 0;
//            Response response = null;
//            while (count < MAX_RETRY_TIME) {
//                appendAuthInfo(request);
//                response = chain.proceed(request);
//                if (!testResponseValid(response)) {
//                    count++;
//                    synchronized (this) {
//                        invalidAuth();
//                        obtainToken();
//                        request = request.newBuilder().build();
//                    }
//                } else {
//                    break;
//                }
//            }
//            return response;
//        }

        @Override
        protected boolean isRequestIgnored(Chain chain) {
            final HttpUrl url = chain.request().url();
            return unAuthUrl.contains(url.encodedPath());
        }

        @Override
        protected boolean testValidResponse(Response response) {
            return response != null &&
                    response.networkResponse() != null &&
                    200==response.networkResponse().code()  ;
        }

        @Override
        protected void obtainAuth(Chain chain, boolean first) {
            obtainToken();
        }

        @Override
        protected boolean testAuthed(Chain chain) {
            final Request request = chain.request();
            return
                    httpHelper.hasCookieForHost("knbase.shangdejigou.cn80", "_CS_USER_TAGS") ||
                            unAuthUrl.contains(request.url().toString());
        }

//        private void invalidAuth() {
//
//        }

//        private boolean testResponseValid(Response response) {
//            return response == null ||
//                    response.networkResponse() == null ||
//                    response.networkResponse().code() != 200;
//        }
//
//        private void appendAuthInfo(Request request) {
//
//        }
//
//        private boolean testAuth(Request request) {
//            return
//                    httpHelper.hasCookieForHost("knbase.shangdejigou.cn80", "_CS_USER_TAGS") ||
//                            unAuthUrl.contains(request.url().toString());
//        }

        public void obtainToken() {
            final long currentTimeMillis = System.currentTimeMillis();
            String account = "shisheng";
            String channel = "Sv-Community";
            String secret = "secret_djsmhfrkohpi28";
            String needSign = StringHelper.concat(
                    "account=", account,
                    "&channel=", channel,
                    "&timestamp=", currentTimeMillis,
                    "&", secret
            );
            final String sign = HashHelper.getHashValue(needSign, HashHelper.HashMethod.md5);
            final BaseResultWrapper post = httpHelper.postForObject(
                    "http://knbase.shangdejigou.cn/wiki-parent/svbk/common/getToken",
                    CollectionHelper.<String, Object>mapBuilder()
                            .put("account", account)
                            .put("channel", channel)
                            .put("timestamp", currentTimeMillis)
                            .put("sign", sign)
                            .getMap(), BaseResultWrapper.class
            );
            L.info("get result:{}", post);
            final String tokenResult = httpHelper.getForString(
                    "http://knbase.shangdejigou.cn/wiki-parent/svbk/common/init?userToken=" + post.getData());
            L.info("get result2:{}", tokenResult);
//            final String result = httpHelper.getForString("http://knbase.shangdejigou.cn/wiki-parent/svbk/doc/get");
//            L.info("get result3:{}", result);
        }
    }
}
