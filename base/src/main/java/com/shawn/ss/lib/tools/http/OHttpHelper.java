/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shawn.ss.lib.tools.http;


/**
 *
 * @author ss
 */
public interface OHttpHelper {

//    public static final String CERT_FORMAT="JKS";
    public static final String CERT_FORMAT="PKCS12";


    public int request(GenericRequest<?> request);

//    void loadCertificate(String name, String certPos, String pass);

//    public int requestHttps(String sslFactoryName, GenericRequest<?> request);

    public int download(GenericDownloadRequest request);

//    public int uploadMultipart(UploadRequest request);
}
