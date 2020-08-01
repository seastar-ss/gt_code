package com.shawn.ss.lib.tools;

import okhttp3.*;
import okhttp3.Authenticator;
import okhttp3.EventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.http.*;
import org.springframework.http.MediaType;
import org.springframework.http.client.*;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.ResourceHttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.http.converter.support.AllEncompassingFormHttpMessageConverter;
import org.springframework.http.converter.xml.SourceHttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import javax.xml.transform.Source;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.*;
import java.nio.charset.Charset;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public class HttpHelper implements InitializingBean {
    public static final Logger L = LoggerFactory.getLogger(HttpHelper.class);

    public static final int DEFAULT_CONNECTION_TIME_OUT = 7;
    public static final int DEFAULT_READ_TIME_OUT = 3;
    public static final int DEFAULT_WRITE_TIME_OUT = 5;
    public static final String DEFUALT_HEADER_VALUE_USER_AGENT = "api-ss-defaultClient-v1/" + System.getProperty("os.name");


    public static final String KEY_DEFAULT_CLIENT = "defaultClient";
    public static final String HEADER_NAME_USER_AGENT = "User-Agent";
    public static final String HEADER_NAME_CONTENT_TYPE = "Content-Type";
    public static final String HEADER_NAME_CONTENT_ENCODING = "Content-Encoding";
    public static final String HEADER_NAME_SERVER = "Server";
    public static final String HEADER_NAME_SET_COOKIES = "Set-Cookie";
    public static final String HEADER_NAME_COOKIES = "Cookie";
    public static final String HEADER_NAME_AUTH = "Auth";
    public static final String CHARACTER_SET = " ;charset=UTF-8";
    DefaultfCookieJar cookieJar;


//    static Map<String, OkHttpClient> clients = CollectionHelper.newMap();


    public String getForString(String url) throws RestClientException {
        return requestForObject(HttpMethod.GET, String.class, url, null,
                null,
                false, null);
    }

    public String getForString(String url, Map<String, Object> urlVariables) throws RestClientException {
        return requestForObject(HttpMethod.GET, String.class, url, null,
                null,
                false, urlVariables);
    }

//    public  <T> T getForObject(String url, Class<T> responseType, Object... urlVariables) throws RestClientException {
//        return template.getForObject(url, responseType, urlVariables);
//    }

    public <T> T getForObject(String url, Map<String, Object> urlVariables, Class<T> responseType) throws RestClientException {
        return requestForObject(HttpMethod.GET, responseType, url, null,
                null,
                false, urlVariables);
    }
//
//    public  <T> T getForObject(URI url, Class<T> responseType) throws RestClientException {
//        return template.getForObject(url, responseType);
//    }

//    public  <T> ResponseEntity<T> getForEntity(String url, Class<T> responseType, Object... urlVariables) throws RestClientException {
//        return template.getForEntity(url, responseType, urlVariables);
//    }
//
//    public  <T> ResponseEntity<T> getForEntity(String url, Class<T> responseType, Map<String, ?> urlVariables) throws RestClientException {
//        return template.getForEntity(url, responseType, urlVariables);
//    }

//    public  <T> ResponseEntity<T> getForEntity(URI url, Class<T> responseType) throws RestClientException {
//        return template.getForEntity(url, responseType);
//    }

//    public  <T> T postForObject(String url, Object request, Class<T> responseType, Object... uriVariables) throws RestClientException {
//        return template.postForObject(url, request, responseType, uriVariables);
//    }

//    public  <T> T postForObject(String url, Object request, Class<T> responseType, Map<String, ?> uriVariables) throws RestClientException {
//        return template.postForObject(url, request, responseType, uriVariables);
//    }
//
//    public  <T> T postForObject(URI url, Object request, Class<T> responseType) throws RestClientException {
//        return template.postForObject(url, request, responseType);
//    }

//    public  <T> ResponseEntity<T> postForEntity(String url, Object request, Class<T> responseType, Object... uriVariables) throws RestClientException {
//        return template.postForEntity(url, request, responseType, uriVariables);
//    }

//    public  <T> ResponseEntity<T> postForEntity(String url, Object request, Class<T> responseType, Map<String, ?> uriVariables) throws RestClientException {
//        return template.postForEntity(url, request, responseType, uriVariables);
//    }

//    public  <T> ResponseEntity<T> postForEntity(URI url, Object request, Class<T> responseType) throws RestClientException {
//        return template.postForEntity(url, request, responseType);
//    }

//    public  String postForString(URI url, Object request) throws RestClientException {
//        return template.postForObject(url, request, String.class);
//    }
//
//    public String postForString(String url,HttpEntity<?> requestEntity) throws RestClientException {
//        final ResponseEntity<String> exchange = template.exchange(url, HttpMethod.POST, requestEntity, String.class);
//        if(exchange.getStatusCode().is2xxSuccessful() ){
//            return exchange.getBody();
//        }else{
//            return null;
//        }
//    }

    //    public String postForString(String url,Map<String,Object> content){
//        return postForString(url,content,null,false);
//    }

    public <T> T postJsonForObject(String url, Object content, Map<String, String> headers, Class<T> targetClass) {
        if (!headers.containsKey(HEADER_NAME_CONTENT_TYPE)) {
            headers.put(HEADER_NAME_CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE + CHARACTER_SET);
        }
        return requestForObject(HttpMethod.POST, targetClass, url, content,
                headers,
                false, null);
    }

    //
    public <T> T postJsonForObject(String url, Object content, Class<T> targetClass) {
        return requestForObject(HttpMethod.POST, targetClass, url, content,
                Collections.singletonMap(HEADER_NAME_CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE + CHARACTER_SET),
                false, null);
    }

    public <T> T postForObject(String url, Map<String, Object> content, Class<T> targetClass) {
        return postForObject(url, content, null, targetClass);
    }

    public <T> T postForObject(String url, Map<String, Object> content, Map<String, String> headers, Class<T> targetClass) {
        return postForObject(url, content, headers, false, targetClass);
    }

    public <T> T postForObject(String url, Map<String, Object> content, Map<String, String> headers, boolean useMultipart, Class<T> targetClass) {
        return requestForObject(HttpMethod.POST, targetClass, url, content, headers, useMultipart, null);
    }

    public String postJsonForString(String url, Object content, Map<String, String> headers) {
        if (!headers.containsKey(HEADER_NAME_CONTENT_TYPE)) {
            headers.put(HEADER_NAME_CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE + CHARACTER_SET);
        }
        return requestForObject(HttpMethod.POST, String.class, url, content,
                headers,
                false, null);
    }

    //
    public String postJsonForString(String url, Object content) {
        return requestForObject(HttpMethod.POST, String.class, url, content,
                Collections.singletonMap(HEADER_NAME_CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE + CHARACTER_SET),
                false, null);
    }

    public String postForString(String url, Map<String, Object> content) {
        return postForString(url, content, null);
    }

    public String postForString(String url, Map<String, Object> content, Map<String, String> headers) {
        return postForString(url, content, headers, false);
    }

    public String postForString(String url, Map<String, Object> content, Map<String, String> headers, boolean useMultipart) {
        return requestForObject(HttpMethod.POST, String.class, url, content, headers, useMultipart, null);
    }

    public <T> T requestForObject(
            HttpMethod httpMethod,
            Class<T> tClass,
            String url,
            Object content,
            Map<String, String> headerMap,
//            RequestPattern requestPattern,
            boolean useMultipart,
            Map<String, Object> urlParam
    ) throws RestClientException {
        HttpHeaders headers = new HttpHeaders();
        if (headerMap == null || !headerMap.containsKey(HEADER_NAME_CONTENT_TYPE)) {
            if (useMultipart)

                headers.add(HEADER_NAME_CONTENT_TYPE, MediaType.MULTIPART_FORM_DATA_VALUE + CHARACTER_SET);
            else
                headers.add(HEADER_NAME_CONTENT_TYPE, MediaType.APPLICATION_FORM_URLENCODED_VALUE + CHARACTER_SET);
        }
        if (headerMap != null) {
            headers.setAll(headerMap);
        }

        HttpEntity<?> entity = null;
        if (content instanceof Map) {
            Map map = (Map) content;
            MultiValueMap<String, Object> bodyMap = new LinkedMultiValueMap<>();
            final Set<Map.Entry> set = map.entrySet();
            for (Map.Entry en : set) {
                String key = StringHelper.getString(en.getKey());
                final Object vobj = en.getValue();
                if (vobj != null) {
                    if (vobj instanceof List) {
                        final List list = (List) vobj;
                        List vals = CollectionHelper.newList(list.size());
                        for (Object o : list) {
                            if (o != null) {
                                vals.add(o.toString());
                            }
                        }
                        bodyMap.put(key, vals);
                    } else {
                        bodyMap.put(key, Collections.<Object>singletonList(vobj.toString()));
                    }
                }
            }
            entity = new HttpEntity<>(bodyMap, headers);
        } else {
            entity = new HttpEntity<>(content, headers);
        }
        if (urlParam == null) {
            urlParam = Collections.emptyMap();
        }
        final ResponseEntity<T> exchange = this.exchange(url, httpMethod, entity, tClass, urlParam);
        if (exchange.getStatusCode().is2xxSuccessful()) {
            return exchange.getBody();
        } else {
            return null;
        }
    }

    public HttpConfig getHttpConfig() {
        return httpConfig;
    }

    public OkHttpClient getDefaultClient() {
        if (defaultClient == null) {
            synchronized (HttpHelper.class) {
                buildClient(null);
            }
        }
        return defaultClient;
    }

    //    public  <T> ResponseEntity<T> exchange(String url, HttpMethod method, HttpEntity<?> requestEntity, Class<T> responseType, Object... uriVariables) throws RestClientException {
//        return template.exchange(url, method, requestEntity, responseType, uriVariables);
//    }

    public <T> ResponseEntity<T> exchange(String url, HttpMethod method, HttpEntity<?> requestEntity, Class<T> responseType, Map<String, ?> uriVariables) throws RestClientException {
        return template.exchange(url, method, requestEntity, responseType, uriVariables);
    }

    public <T> ResponseEntity<T> exchange(URI url, HttpMethod method, HttpEntity<?> requestEntity, Class<T> responseType) throws RestClientException {
        return template.exchange(url, method, requestEntity, responseType);
    }

    public <T> ResponseEntity<T> exchange(RequestEntity<?> requestEntity, Class<T> responseType) throws RestClientException {
        return template.exchange(requestEntity, responseType);
    }

    public RestTemplate getTemplate() {
        return template;
    }

    public HttpHelper setTemplate(RestTemplate template) {
        this.template = template;
        return this;
    }

    volatile OkHttpClient defaultClient;
    volatile RestTemplate template;
    volatile HttpConfig httpConfig;

    public synchronized void init(HttpConfig config) {
//        final OkHttpClient okHttpClient = buildClient(HttpConfig.defaultConfig());
        if (config != null) {
            httpConfig = config;
        }
        if (httpConfig == null) {
            httpConfig = HttpConfig.defaultConfig();
        }
        defaultClient = buildClient(httpConfig);
        template = buildTemplate(defaultClient, httpConfig);
    }

    RestTemplate buildTemplate(OkHttpClient defaultClient, final HttpConfig httpConfig) {

        final List<HttpMessageConverter<?>> messageConverters = CollectionHelper.newList(10);
        messageConverters.add(new ByteArrayHttpMessageConverter());
        messageConverters.add(new StringHttpMessageConverter(Charset.forName("UTF-8")));
        messageConverters.add(new ResourceHttpMessageConverter());
        messageConverters.add(new SourceHttpMessageConverter<Source>());
        messageConverters.add(new AllEncompassingFormHttpMessageConverter());
        GsonHttpMessageConverter converter = new GsonHttpMessageConverter();
        converter.setGson(GsonJsonHelperImpl.getGson());
        messageConverters.add(converter);
        RestTemplate template = new RestTemplate(messageConverters);

        final BufferingClientHttpRequestFactory factory =
                new BufferingClientHttpRequestFactory(
                        new ClientFactory(defaultClient)
                );
        template.setRequestFactory(factory);
        final List<ClientHttpRequestInterceptor> interceptors = template.getInterceptors();
        interceptors.add(new DefaultClientHttpRequestInterceptor(httpConfig));
        template.setInterceptors(interceptors);
        return template;
    }

    OkHttpClient buildClient(final HttpConfig httpConfig) {
        cookieJar = new DefaultfCookieJar();
        final OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .cookieJar(cookieJar)
                .followRedirects(httpConfig.isFollowRedirect())
                .followSslRedirects(httpConfig.isFollowRedirect())
                .connectTimeout(httpConfig.getConnectionTimeout(), TimeUnit.SECONDS)
                .readTimeout(httpConfig.getReadTimeout(), TimeUnit.SECONDS)
                .writeTimeout(httpConfig.getWriteTimeout(), TimeUnit.SECONDS)
                .addNetworkInterceptor(new LogInterceptor(httpConfig))
                .eventListenerFactory(new EventListener.Factory() {

                    public EventListener create(Call call) {
                        return new DefaultEventListener(call, httpConfig);
                    }
                })
//                .authenticator(httpConfig.)
                .dns(new DefaultDns(httpConfig));
        List<Interceptor> interceptors = httpConfig.getFirstInterceptors();
        if (interceptors != null && interceptors.size() > 0) {
            for (Interceptor inc : interceptors) {
                builder.addInterceptor(inc);
            }
        }
        interceptors = httpConfig.getLastInterceptors();
        if (interceptors != null && interceptors.size() > 0) {
            for (Interceptor inc : interceptors) {
                builder.addNetworkInterceptor(inc);
            }
        }
        final OkHttpClient build = builder
                .build();
        interceptors = builder.interceptors();
        interceptors.addAll(builder.networkInterceptors());
        if (interceptors.size() > 0) {
            for (Interceptor inc : interceptors) {
                if (inc != null) {
                    L.info("http helper have interceptor:{}", inc);
                    if (inc instanceof AbstractAuthInterceptor) {
                        final AbstractAuthInterceptor inc1 = (AbstractAuthInterceptor) inc;
                        inc1.setClient(build);
                    }
                }
            }
        }

        return build;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        init(null);
    }


//    public static String get(String url) {
//        final Call call = defaultClient.newCall(
//                new Request.Builder()
//                        .url(url)
//                        .get()
//                        .build()
//        );
//        try {
//            final Response response = call.execute();
//            if (response.isSuccessful()) {
//                final String string = response.body().string();
//                return string;
//            } else {
//                final int code = response.code();
//                L.error("get response of " + code + " for request of " + url);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

//    public static void newClient(String name, HttpConfig config) {
//        clients.put(name, buildClient(config));
//    }
//
//    public static void newClient(String name, OkHttpClient client) {
//        clients.put(name, client);
//    }

    public static class DefaultfCookieJar implements CookieJar {
        Map<String, List<Cookie>> cookies;

        public DefaultfCookieJar() {
            cookies = new ConcurrentHashMap<>();
        }

        public String makeKey(HttpUrl httpUrl) {
            final String host = httpUrl.host();
            final int port = httpUrl.port();
//            final String path = httpUrl.encodedPath();
            return StringHelper.concat(host, port);
        }

        @Override
        public void saveFromResponse(HttpUrl httpUrl, List<Cookie> list) {
            String key = makeKey(httpUrl);
            List<Cookie> cs;
            if (cookies.containsKey(key)) {
                cs = this.cookies.get(key);
                cs.addAll(list);
            } else {
                cs = new ArrayList<>(list);
            }
            this.cookies.put(key, cs);
        }


        @Override
        public List<Cookie> loadForRequest(HttpUrl httpUrl) {
            List<Cookie> cookies = this.cookies.get(makeKey(httpUrl));
            if (cookies == null)
                cookies = Collections.emptyList();
            return cookies;
        }

        public List<Cookie> getCookie(String key) {
            return cookies.get(key);
        }
    }


    public List<Cookie> getCookieForHost(String host) {
        return cookieJar.getCookie(host);
    }

    public boolean hasCookieForHost(String host, String cookieKey) {
        if (cookieKey != null) {
            final List<Cookie> cookie = cookieJar.getCookie(host);
            if (cookie != null && cookie.size() > 0) {
                for (Cookie c : cookie) {
                    if (cookieKey.equals(c.name())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static class DefaultEventListener extends EventListener {

        final String url;
        final long start;
        final long id;
        static final AtomicLong seq = new AtomicLong(0);

        public DefaultEventListener(Call call, HttpConfig httpConfig) {
            final Request request = call.request();
            url = request.url().toString();
            start = System.currentTimeMillis();
            id = seq.getAndIncrement();
            if (seq.get() > (Long.MAX_VALUE - 5)) {
                seq.set(0);
            }
            L.info("request:{} start for id {}", request.url().toString(), id);
        }

        @Override
        public void callStart(Call call) {
            super.callStart(call);
            L.trace("request {} start ", id);
        }

        @Override
        public void dnsStart(Call call, String domainName) {
            super.dnsStart(call, domainName);
            L.trace("request {} dns start ", id);
        }

        @Override
        public void dnsEnd(Call call, String domainName, List<InetAddress> inetAddressList) {
            super.dnsEnd(call, domainName, inetAddressList);
            L.info("request {} dns end  get result: {}", id, inetAddressList);
        }

        @Override
        public void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
            super.connectStart(call, inetSocketAddress, proxy);
            L.info("request {} connect start {}", id, inetSocketAddress);
        }

        @Override
        public void secureConnectStart(Call call) {
            super.secureConnectStart(call);
            L.trace("request {} secure connect start ", id);
        }

        @Override
        public void secureConnectEnd(Call call, Handshake handshake) {
            super.secureConnectEnd(call, handshake);
            L.trace("request {} secure connect end ", id);
        }

        @Override
        public void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
            super.connectEnd(call, inetSocketAddress, proxy, protocol);
            L.trace("request {} connect end ", id);
        }

        @Override
        public void connectFailed(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol, IOException ioe) {
            super.connectFailed(call, inetSocketAddress, proxy, protocol, ioe);
            L.error("request {}  connect fail {}", id, ioe.getMessage());
        }

        @Override
        public void connectionAcquired(Call call, Connection connection) {
            super.connectionAcquired(call, connection);
            L.trace("request {}  connection acquired ", id);
        }

        @Override
        public void connectionReleased(Call call, Connection connection) {
            super.connectionReleased(call, connection);
            L.trace("request {}  connection released ", id);
        }

        @Override
        public void requestHeadersStart(Call call) {
            super.requestHeadersStart(call);
            L.trace("request {} request  header start ", id);
        }

        @Override
        public void requestHeadersEnd(Call call, Request request) {
            super.requestHeadersEnd(call, request);
            L.trace("request {} request  header end ", id);
        }

        @Override
        public void requestBodyStart(Call call) {
            super.requestBodyStart(call);
            L.trace("request {}  request body start ", id);
        }

        @Override
        public void requestBodyEnd(Call call, long byteCount) {
            super.requestBodyEnd(call, byteCount);
            L.info("request {} request  body end {} sent", id, byteCount);
        }

        @Override
        public void responseHeadersStart(Call call) {
            super.responseHeadersStart(call);
            L.trace("request {} response  header start ", id);
        }

        @Override
        public void responseHeadersEnd(Call call, Response response) {
            super.responseHeadersEnd(call, response);
            L.trace("request  {} response  header end ", id);
        }

        @Override
        public void responseBodyStart(Call call) {
            super.responseBodyStart(call);
            L.trace("request {} response  body start ", id);
        }

        @Override
        public void responseBodyEnd(Call call, long byteCount) {
            super.responseBodyEnd(call, byteCount);
            L.trace("request {} response  body end ", id);
        }

        @Override
        public void callEnd(Call call) {
            super.callEnd(call);
            L.info("request {} finished in {}", id, (System.currentTimeMillis() - start));
        }

        @Override
        public void callFailed(Call call, IOException ioe) {
            super.callFailed(call, ioe);
            L.error("request {} failed :{}", id, ioe.getMessage());
        }
    }

    private static class LogInterceptor implements Interceptor {
        private HttpConfig httpConfig;
        final Set<String> needLoggingHeader;

        public LogInterceptor(HttpConfig httpConfig) {
            this.httpConfig = httpConfig;
            needLoggingHeader = httpConfig.getNeedLoggingHeader();
        }

        @Override
        public Response intercept(Interceptor.Chain chain) throws IOException {
            Request request = chain.request();
            //request = request.newBuilder().addHeader(HEADER_NAME_USER_AGENT, httpConfig.getUserAgent()).build();

//            long t1 = System.nanoTime();
            L.info(String.format("Sending request %s on %s ,send body: %b %n %s ",
                    request, chain.connection(), request.body(), getKeyHeader(request)));

            Response response = chain.proceed(request);

//            long t2 = System.nanoTime();
            L.info(String.format("Received response for %s for %d %n %s",
                    response.request().url(), response.code(), getKeyHeader(response)));

            return response;
        }

        private String getKeyHeader(Response response) {
            if (needLoggingHeader != null && needLoggingHeader.size() != 0) {
                StringBuilder ret = new StringBuilder();
                for (String header : needLoggingHeader) {
                    final String headerValue = response.header(header);
                    if (headerValue != null) {
                        ret.append("resp\t").append(header).append("->").append(headerValue).append(";\n");
                    }
                }
                return ret.toString();
            }
            return null;
        }

        private String getKeyHeader(Request request) {
            if (needLoggingHeader != null && needLoggingHeader.size() != 0) {
                StringBuilder ret = new StringBuilder();
                for (String header : needLoggingHeader) {
                    final String headerValue = request.header(header);
                    if (headerValue != null) {
                        ret.append("req\t").append(header).append("->").append(headerValue).append(";\n");
                    }
                }
                return ret.toString();
            }
            return null;
        }
    }

    private static class DefaultDns implements Dns {

        private HttpConfig httpConfig;
        final Map<String, byte[]> dnsEntries;

        public DefaultDns(HttpConfig httpConfig) {
            this.httpConfig = httpConfig;
            dnsEntries = httpConfig.getDnsEntries();
        }

        public List<InetAddress> lookup(String hostname) throws UnknownHostException {
            if (dnsEntries.containsKey(hostname)) {
                final byte[] ipAddr = dnsEntries.get(hostname);
                if (ipAddr != null && (ipAddr.length == 4 || ipAddr.length == 6)) {
                    final InetAddress address = InetAddress.getByAddress(ipAddr);
                    return Collections.singletonList(address);
                }
            }
            return Dns.SYSTEM.lookup(hostname);
        }
    }

    public static final class HttpConfig {
        String userAgent;
        int connectionTimeout;
        int readTimeout;
        int writeTimeout;
        boolean logInput;
        boolean logOutput;
        boolean followRedirect;
        Set<String> needLoggingHeader;
        Map<String, byte[]> dnsEntries;
        List<Interceptor> firstInterceptors;
        List<Interceptor> lastInterceptors;
        Authenticator authenticator;

        public HttpConfig() {
            needLoggingHeader = CollectionHelper.newSet();
            dnsEntries = CollectionHelper.newMap();
            firstInterceptors = CollectionHelper.newList(10);
            lastInterceptors = CollectionHelper.newList(10);
        }

        public String getUserAgent() {
            return userAgent;
        }

        public HttpConfig setUserAgent(String userAgent) {
            this.userAgent = userAgent;
            return this;
        }

        public int getConnectionTimeout() {
            return connectionTimeout;
        }

        public HttpConfig setConnectionTimeout(int connectionTimeout) {
            this.connectionTimeout = connectionTimeout;
            return this;
        }

        public int getReadTimeout() {
            return readTimeout;
        }

        public HttpConfig setReadTimeout(int readTimeout) {
            this.readTimeout = readTimeout;
            return this;
        }

        public int getWriteTimeout() {
            return writeTimeout;
        }

        public HttpConfig setWriteTimeout(int writeTimeout) {
            this.writeTimeout = writeTimeout;
            return this;
        }

        public Set<String> getNeedLoggingHeader() {
            return needLoggingHeader;
        }

        public HttpConfig setNeedLoggingHeader(Set<String> needLoggingHeader) {
            this.needLoggingHeader = needLoggingHeader;
            return this;
        }

        public Map<String, byte[]> getDnsEntries() {
            return dnsEntries;
        }

        public HttpConfig setDnsEntries(Map<String, byte[]> dnsEntries) {
            this.dnsEntries = dnsEntries;
            return this;
        }

        public int sizeOfDnsEntry() {
            return dnsEntries.size();
        }

        public byte[] getDnsEntry(Object key) {
            return dnsEntries.get(key);
        }

        public byte[] putDnsEntry(String key, byte[] value) {
            return dnsEntries.put(key, value);
        }

        public int sizeOfNLHeader() {
            return needLoggingHeader.size();
        }

        public boolean containsNLHeader(Object o) {
            return needLoggingHeader.contains(o);
        }

        public boolean addNLHeader(String s) {
            return needLoggingHeader.add(s);
        }

        public boolean isLogInput() {
            return logInput;
        }

        public HttpConfig setLogInput(boolean logInput) {
            this.logInput = logInput;
            return this;
        }

        public boolean isLogOutput() {
            return logOutput;
        }

        public HttpConfig setLogOutput(boolean logOutput) {
            this.logOutput = logOutput;
            return this;
        }

        public List<Interceptor> getFirstInterceptors() {
            return firstInterceptors;
        }

//        public HttpConfig setFirstInterceptors(List<Interceptor> firstInterceptors) {
//            this.firstInterceptors = firstInterceptors;
//            return this;
//        }

        public int sizeOfInterceptor(boolean first) {
            return first ? firstInterceptors.size() : lastInterceptors.size();
        }

        public HttpConfig addInterceptor(Interceptor interceptor, boolean first) {
            checkInterceptor(interceptor, first);
            if (first) {
                firstInterceptors.add(interceptor);
            } else {
                lastInterceptors.add(interceptor);
            }
            return this;
        }

        private void checkInterceptor(Interceptor interceptor, boolean first) {
            if (!first && interceptor instanceof AbstractAuthInterceptor) {
                throw new IllegalStateException("auth interceptor need to be action first , using addInterceptor(interceptor,true) instead");
            }
        }

        public boolean isFollowRedirect() {
            return followRedirect;
        }

        public HttpConfig setFollowRedirect(boolean followRedirect) {
            this.followRedirect = followRedirect;
            return this;
        }

        public Authenticator getAuthenticator() {
            return authenticator;
        }

        public HttpConfig setAuthenticator(Authenticator authenticator) {
            this.authenticator = authenticator;
            return this;
        }

        public List<Interceptor> getLastInterceptors() {
            return lastInterceptors;
        }

//        public HttpConfig setLastInterceptors(List<Interceptor> lastInterceptors) {
//            this.lastInterceptors = lastInterceptors;
//            return this;
//        }

        public static HttpConfig defaultConfig() {
            return new HttpConfig()
                    .setConnectionTimeout(DEFAULT_CONNECTION_TIME_OUT)
                    .setReadTimeout(DEFAULT_READ_TIME_OUT)
                    .setWriteTimeout(DEFAULT_WRITE_TIME_OUT)
                    .setLogInput(true)
                    .setLogOutput(true)
                    .setNeedLoggingHeader(CollectionHelper.<String>setBuilder()
                            .add(HEADER_NAME_CONTENT_TYPE)
                            .add(HEADER_NAME_CONTENT_ENCODING)
                            .add(HEADER_NAME_SERVER)
                            .add(HEADER_NAME_SET_COOKIES)
                            .add(HEADER_NAME_COOKIES)
                            .add(HEADER_NAME_AUTH)
                            .getSet())
                    .setUserAgent(DEFUALT_HEADER_VALUE_USER_AGENT);
        }
    }

    private static class ClientFactory extends OkHttp3ClientHttpRequestFactory {
        public ClientFactory(OkHttpClient defaultClient) {
            super(defaultClient);
        }

        @Override
        public ClientHttpRequest createRequest(URI uri, HttpMethod httpMethod) {
            final ClientHttpRequest request = super.createRequest(uri, httpMethod);
            return request;
        }

        @Override
        public AsyncClientHttpRequest createAsyncRequest(URI uri, HttpMethod httpMethod) {
            final AsyncClientHttpRequest asyncRequest = super.createAsyncRequest(uri, httpMethod);
            return asyncRequest;
        }
    }

    private static class DefaultClientHttpRequestInterceptor implements ClientHttpRequestInterceptor {
        private static final int MAX_BYTE_LOGGED = 20480;
        private final HttpConfig httpConfig;

        public DefaultClientHttpRequestInterceptor(HttpConfig httpConfig) {
            this.httpConfig = httpConfig;
        }

        @Override
        public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
            final HttpHeaders headers = request.getHeaders();
            final MediaType contentType = headers.getContentType();
//            if(contentType.)

            L.info("request {} send type {}", request.getURI(), contentType);
            headers.setContentType(contentType);
            headers.add(HEADER_NAME_USER_AGENT, httpConfig.getUserAgent());

//            request.getHeaders().add(HEADER_NAME_CONTENT_ENCODING, httpConfig.getUserAgent());
            if (httpConfig.isLogInput()) {
                int n = (body.length > MAX_BYTE_LOGGED) ? MAX_BYTE_LOGGED : body.length;
                L.info("request {} send \n {}", request.getURI(), new String(body, 0, n, "UTF-8"));
            }
            final ClientHttpResponse execute = execution.execute(request, body);
            if (httpConfig.isLogOutput()) {
                final BufferedInputStream stream = new BufferedInputStream(execute.getBody());
                int read;
                StringBuilder bodyMsg = new StringBuilder();
                byte[] buffer = new byte[10240];
                int total = 0;
                while ((read = stream.read(buffer)) > 0 && total < MAX_BYTE_LOGGED) {
                    bodyMsg.append(new String(buffer, 0, read, "UTF-8"));
                    total += read;
                }
                L.info("request {} recive \n {}", request.getURI(), bodyMsg);
            }
            return execute;
        }
    }

    private enum RequestPattern {
        common, json, multipart, jsonInDataField
    }


//    public static void main(String[] args) {
////        final String s = get("http://www.sunlands.com");
////        L.debug(s.substring(0,100));
//        L.debug("p:{}",System.getProperties());
//    }


}
