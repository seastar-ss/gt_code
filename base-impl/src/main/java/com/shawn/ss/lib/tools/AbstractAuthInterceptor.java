package com.shawn.ss.lib.tools;

import okhttp3.*;
import okhttp3.internal.connection.RouteException;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.http.HttpMethod;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.http.UnrepeatableRequestBody;
import okhttp3.internal.http2.ConnectionShutdownException;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.HttpRetryException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;

import static java.net.HttpURLConnection.*;
import static java.net.HttpURLConnection.HTTP_CLIENT_TIMEOUT;
import static java.net.HttpURLConnection.HTTP_UNAVAILABLE;
import static okhttp3.internal.Util.closeQuietly;
import static okhttp3.internal.http.StatusLine.HTTP_PERM_REDIRECT;
import static okhttp3.internal.http.StatusLine.HTTP_TEMP_REDIRECT;

public abstract class AbstractAuthInterceptor implements Interceptor {
    /**
     * How many redirects and auth challenges should we attempt? Chrome follows 21 redirects; Firefox,
     * curl, and wget follow 20; Safari follows 16; and HTTP/1.0 recommends 5.
     */
    private static final int MAX_RETRY_TIME = 2;

    private volatile OkHttpClient client;
    private final boolean forWebSocket;
    private volatile StreamAllocation streamAllocation;
    private Object callStackTrace;
    private volatile boolean canceled;

    public AbstractAuthInterceptor( boolean forWebSocket) {
//        this.client = client;
        this.forWebSocket = forWebSocket;
    }

    public synchronized AbstractAuthInterceptor setClient(OkHttpClient client) {
        this.client = client;
        return this;
    }

    /**
     * Immediately closes the socket connection if it's currently held. Use this to interrupt an
     * in-flight request from any thread. It's the caller's responsibility to close the request body
     * and response body streams; otherwise resources may be leaked.
     * <p>
     * <p>This method is safe to be called concurrently, but provides limited guarantees. If a
     * transport layer connection has been established (such as a HTTP/2 stream) that is terminated.
     * Otherwise if a socket connection is being established, that is terminated.
     */
    public void cancel() {
        canceled = true;
        StreamAllocation streamAllocation = this.streamAllocation;
        if (streamAllocation != null) streamAllocation.cancel();
    }

    public boolean isCanceled() {
        return canceled;
    }

    public void setCallStackTrace(Object callStackTrace) {
        this.callStackTrace = callStackTrace;
    }

    public StreamAllocation streamAllocation() {
        return streamAllocation;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        if(isRequestIgnored(chain)){
            return  chain.proceed(chain.request());
        }
        if (!testAuthed(chain) ) {
            obtainAuth(chain, true);
        }
        Request request = chain.request();
        RealInterceptorChain realChain = (RealInterceptorChain) chain;
        Call call = realChain.call();
        EventListener eventListener = realChain.eventListener();

        StreamAllocation streamAllocation = new StreamAllocation(client.connectionPool(),
                createAddress(request.url()), call, eventListener, callStackTrace);
        this.streamAllocation = streamAllocation;

        int followUpCount = 0;
        Response priorResponse = null;
        while (true) {
            if (canceled) {
                streamAllocation.release();
                throw new IOException("Canceled");
            }

            Response response;
            boolean releaseConnection = true;
            try {
                response = realChain.proceed(request, streamAllocation, realChain.httpStream(), streamAllocation.connection());
                releaseConnection = false;
            } catch (RouteException e) {
                // The attempt to connect via a route failed. The request will not have been sent.
                if (!recover(e.getLastConnectException(), streamAllocation, false, request)) {
                    throw e.getFirstConnectException();
                }
                releaseConnection = false;
                continue;
            } catch (IOException e) {
                // An attempt to communicate with a server failed. The request may have been sent.
                boolean requestSendStarted = !(e instanceof ConnectionShutdownException);
                if (!recover(e, streamAllocation, requestSendStarted, request)) throw e;
                releaseConnection = false;
                continue;
            } finally {
                // We're throwing an unchecked exception. Release any resources.
                if (releaseConnection) {
                    streamAllocation.streamFailed(null);
                    streamAllocation.release();
                }
            }

            if (testValidResponse(response)) {
//                streamAllocation.release();
//                streamAllocation = new StreamAllocation(client.connectionPool(),
//                        createAddress(request.url()), call, eventListener, callStackTrace);
//                this.streamAllocation = streamAllocation;
                return response;
            } else {
                obtainAuth(chain, false);

            }
            // Attach the prior response if it exists. Such responses never have a body.
//            if (priorResponse != null) {
//                response = response.newBuilder()
//                        .priorResponse(priorResponse.newBuilder()
//                                .body(null)
//                                .build())
//                        .build();
//            }

//            Request followUp;
            try {
//                followUp = rebuildRequest(response, streamAllocation.route());

//                priorResponse=response.newBuilder().build();
//            if (followUp == null) {
//                if (!forWebSocket) {
//                    streamAllocation.release();
//                }
//                return response;
//            }

                closeQuietly(response.body());

                if (++followUpCount > MAX_RETRY_TIME) {
                    streamAllocation.release();
                    throw new ProtocolException("Too many retries : " + followUpCount);
                }

                if (request.body() instanceof UnrepeatableRequestBody) {
                    streamAllocation.release();
                    throw new HttpRetryException("Cannot retry streamed HTTP body", response.code());
                }
                request = request.newBuilder().build();

                streamAllocation = new StreamAllocation(client.connectionPool(),
                        createAddress(request.url()), call, eventListener, callStackTrace);
                this.streamAllocation = streamAllocation;

//            if (!sameConnection(response, followUp.url())) {
//                streamAllocation.release();
//                streamAllocation = new StreamAllocation(client.connectionPool(),
//                        createAddress(followUp.url()), call, eventListener, callStackTrace);
//                this.streamAllocation = streamAllocation;
//            } else if (streamAllocation.codec() != null) {
//                throw new IllegalStateException("Closing the body of " + response
//                        + " didn't close its backing stream. Bad interceptor?");
//            }

//            request = followUp;
//            priorResponse = response;
            } catch (Exception e) {
                streamAllocation.release();
                throw e;
            }
        }
    }

    protected abstract boolean isRequestIgnored(Chain chain);

    protected abstract boolean testValidResponse(Response response);

    protected abstract void obtainAuth(Chain chain, boolean first);

    protected abstract boolean testAuthed(Chain chain);

    private Address createAddress(HttpUrl url) {
        SSLSocketFactory sslSocketFactory = null;
        HostnameVerifier hostnameVerifier = null;
        CertificatePinner certificatePinner = null;
        if (url.isHttps()) {
            sslSocketFactory = client.sslSocketFactory();
            hostnameVerifier = client.hostnameVerifier();
            certificatePinner = client.certificatePinner();
        }

        return new Address(url.host(), url.port(), client.dns(), client.socketFactory(),
                sslSocketFactory, hostnameVerifier, certificatePinner, client.proxyAuthenticator(),
                client.proxy(), client.protocols(), client.connectionSpecs(), client.proxySelector());
    }

    /**
     * Report and attempt to recover from a failure to communicate with a server. Returns true if
     * {@code e} is recoverable, or false if the failure is permanent. Requests with a body can only
     * be recovered if the body is buffered or if the failure occurred before the request has been
     * sent.
     */
    private boolean recover(IOException e, StreamAllocation streamAllocation,
                            boolean requestSendStarted, Request userRequest) {
        streamAllocation.streamFailed(e);

        // The application layer has forbidden retries.
        if (!client.retryOnConnectionFailure()) return false;

        // We can't send the request body again.
        if (requestSendStarted && userRequest.body() instanceof UnrepeatableRequestBody) return false;

        // This exception is fatal.
        if (!isRecoverable(e, requestSendStarted)) return false;

        // No more routes to attempt.
        if (!streamAllocation.hasMoreRoutes()) return false;

        // For failure recovery, use the same route selector with a new connection.
        return true;
    }

    private boolean isRecoverable(IOException e, boolean requestSendStarted) {
        // If there was a protocol problem, don't recover.
        if (e instanceof ProtocolException) {
            return false;
        }

        // If there was an interruption don't recover, but if there was a timeout connecting to a route
        // we should try the next route (if there is one).
        if (e instanceof InterruptedIOException) {
            return e instanceof SocketTimeoutException && !requestSendStarted;
        }

        // Look for known client-side or negotiation errors that are unlikely to be fixed by trying
        // again with a different route.
        if (e instanceof SSLHandshakeException) {
            // If the problem was a CertificateException from the X509TrustManager,
            // do not retry.
            if (e.getCause() instanceof CertificateException) {
                return false;
            }
        }
        if (e instanceof SSLPeerUnverifiedException) {
            // e.g. a certificate pinning error.
            return false;
        }

        // An example of one we might want to retry with a different route is a problem connecting to a
        // proxy and would manifest as a standard IOException. Unless it is one we know we should not
        // retry, we return true and try a new route.
        return true;
    }


}
