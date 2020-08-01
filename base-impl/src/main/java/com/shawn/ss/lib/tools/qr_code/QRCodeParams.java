package com.shawn.ss.lib.tools.qr_code;

import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class QRCodeParams {
    private String content;                //二维码内容
    private String qrCodeUrl;          //二维码网络路径
    private String filePath;           //二维码生成物理路径
    private String logoPath;           //logo图片
    private Integer width = 300;           //二维码宽度
    private Integer height = 300;          //二维码高度
    private Integer onColor = 0xFF000000;  //前景色
    private Integer offColor = 0xFFFFFFFF; //背景色
    private Integer margin = 1;            //白边大小，取值范围0~4
    private ErrorCorrectionLevel level = ErrorCorrectionLevel.L;  //二维码容错率


    public String getContent() {
        return content;
    }

    public QRCodeParams setContent(String content) {
        this.content = content;
        return this;
    }

    public String getQrCodeUrl() {
        return qrCodeUrl;
    }

    public QRCodeParams setQrCodeUrl(String qrCodeUrl) {
        this.qrCodeUrl = qrCodeUrl;
        return this;
    }

    public String getFilePath() {
        return filePath;
    }

    public QRCodeParams setFilePath(String filePath) {
        this.filePath = filePath;
        return this;
    }


    public String getLogoPath() {
        return logoPath;
    }

    public QRCodeParams setLogoPath(String logoPath) {
        this.logoPath = logoPath;
        return this;
    }

    public Integer getWidth() {
        return width;
    }

    public QRCodeParams setWidth(Integer width) {
        this.width = width;
        return this;
    }

    public Integer getHeight() {
        return height;
    }

    public QRCodeParams setHeight(Integer height) {
        this.height = height;
        return this;
    }

    public Integer getOnColor() {
        return onColor;
    }

    public QRCodeParams setOnColor(Integer onColor) {
        this.onColor = onColor;
        return this;
    }

    public Integer getOffColor() {
        return offColor;
    }

    public QRCodeParams setOffColor(Integer offColor) {
        this.offColor = offColor;
        return this;
    }

    public Integer getMargin() {
        return margin;
    }

    public QRCodeParams setMargin(Integer margin) {
        this.margin = margin;
        return this;
    }

    public ErrorCorrectionLevel getLevel() {
        return level;
    }

    public QRCodeParams setLevel(ErrorCorrectionLevel level) {
        this.level = level;
        return this;
    }
}
