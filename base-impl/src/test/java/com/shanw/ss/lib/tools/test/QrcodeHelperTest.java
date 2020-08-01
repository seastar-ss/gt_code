package com.shanw.ss.lib.tools.test;

import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.shawn.ss.lib.tools.qr_code.QrCodeImageHelper;
import com.shawn.ss.lib.tools.qr_code.QRCodeParams;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by bkc on 2018/7/4.
 */
public class QrcodeHelperTest {

    static final Logger L = LoggerFactory.getLogger(QrcodeHelperTest.class.getSimpleName());

//    @Test
    public void testGenerateQRImage() {
        String outPath = "./" + System.currentTimeMillis() + ".jpg";

        String content = "http://www.baidu.com";

        String logoPath =
            "/Users/bkc/Desktop/WechatIMG517.jpeg";//http://172.16.117.226:801/original/20180621/1009615650977517568.jpg";
        QRCodeParams params = new QRCodeParams();
        params.setFilePath(outPath)
            .setHeight(430)
            .setWidth(430)
            .setLevel(ErrorCorrectionLevel.H)
            .setLogoPath(logoPath)
            .setMargin(1)
            .setContent(content);

        QrCodeImageHelper.generateQRImage(params);

    }

}
