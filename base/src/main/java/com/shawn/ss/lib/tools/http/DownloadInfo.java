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
public class DownloadInfo {

    public final String fileName;
    public final String resultHash;
    public final long fileSize;
    public final String exceptionMsg;
    public final NetResponseCode status;

    public DownloadInfo(String fileName, String resultHash, long fileSize, String exceptionMsg, NetResponseCode status) {
        this.fileName = fileName;
        this.resultHash = resultHash;
        this.fileSize = fileSize;
        this.exceptionMsg = exceptionMsg;
        this.status = status;
    }

}
