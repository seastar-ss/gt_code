/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shawn.ss.lib.tools.http;



import com.shawn.ss.lib.tools.FileHelper;
import com.shawn.ss.lib.tools.HashHelper;

import java.io.File;
import java.io.IOException;
import java.net.Proxy;
import java.util.logging.Level;
import java.util.logging.Logger;

//import com.sun.javafx.collections.MappingChange;

/**
 *
 * @author ss
 */
public abstract class GenericDownloadRequest extends GenericRequest<DownloadInfo> {

    String fileName;
    File file;

    Agent agent;
    boolean useProxy;

    public GenericDownloadRequest() {
        super(Method.GET);
    }

    public GenericDownloadRequest(String fileName) {
        super(Method.GET);
        this.fileName = fileName;
        init();
    }

    public GenericDownloadRequest(Method m, String fileName) {
        super(m);
        this.fileName = fileName;
        init();
    }

//    public GenericDownloadRequest(Method m, Map<String, String> fileEntry, Map<String, String> valueEntry) {
//        super(m);
//
//    }

    //    @Override
//    public String getContentType() {
//        return "application/octet-stream";
//    }
    public void setAgentType(Agent agent) {
        this.agent = agent;
    }

    @Override
    public String getUserAgent() {
        return agent.getUAString();
    }

    @Override
    public abstract byte[] getBody();

    @Override
    public DownloadInfo getResult() {
        try {
            String fileHashCode = HashHelper.getFileHashCode(fileName);
            long size = file.length();
            return new DownloadInfo(fileName, fileHashCode, size, exceptionMsg, super.resCode);
        } catch (IOException ex) {
            Logger.getLogger(GenericDownloadRequest.class.getName()).log(Level.SEVERE, null, ex);
//            throw new CommonException.NoFileAccess();
        }
        return null;
    }

    protected final void init() {
        this.agent = Agent.mobile;
        useProxy = false;
        if (this.fileName == null) {
            throw new  IllegalStateException("文件名为空");
        }
        try {
            file = FileHelper.mkFile(this.fileName);
        } catch (IOException ex) {
            Logger.getLogger(GenericDownloadRequest.class.getName()).log(Level.SEVERE, null, ex);
            throw new IllegalStateException("请求出错，io异常");
        }
    }

    public File getFile() {
        return file;
    }

    public boolean isUseProxy() {
        return useProxy;
    }

    Proxy pickProxy() {
        return null;
    }


//    public Map<String, String> getValueEntry() {
//        return valueEntry;
//    }
//
//    public void setValueEntry(Map<String, String> valueEntry) {
//        this.valueEntry = valueEntry;
//    }
//
//    public Map<String, String> getFileEntry() {
//        return fileEntry;
//    }
//
//    public void setFileEntry(Map<String, String> fileEntry) {
//        this.fileEntry = fileEntry;
//    }
}
