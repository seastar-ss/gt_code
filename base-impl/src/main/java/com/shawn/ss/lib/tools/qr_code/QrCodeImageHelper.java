package com.shawn.ss.lib.tools.qr_code;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import org.apache.commons.imaging.ImageFormats;
import org.apache.commons.imaging.ImageWriteException;
import org.apache.commons.imaging.Imaging;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Hashtable;

public class QrCodeImageHelper {
    static final Logger log = LoggerFactory.getLogger(QrCodeImageHelper.class.getSimpleName());


    private static int width = 300;//二维码宽度
    private static int height = 300;//二维码高度
    private static int onColor = 0xFF000000;//前景色
    private static int offColor = 0xFFFFFFFF;//背景色
    private static int margin = 1;//白边大小，取值范围0~4
    private static ErrorCorrectionLevel level = ErrorCorrectionLevel.L;//二维码容错率

    /**
     * 生成二维码
     *
     * @param params QRCodeParams属性：txt、fileName、filePath不得为空；
     * @throws
     */
    public static void generateQRImage(QRCodeParams params) {
        if (params == null
            || params.getFilePath() == null
            || params.getContent() == null) {

            return;
        }

        try {
            initData(params);

            String imgPath = params.getFilePath();
            String content = params.getContent();
            log.info("generate qrCode for {} in {}",params.getContent(),params.getFilePath());

            if (params.getLogoPath() != null && !"".equals(params.getLogoPath().trim())) {
                generateQRImageWithLogo(params, content, imgPath);
            } else {
                generateQRImage(params, content, imgPath);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 生成二维码 1
     *
     * @param txt     //二维码内容
     * @param imgPath //二维码保存物理路径
     */
    public static void generateQRImage(QRCodeParams params, String txt, String imgPath) {

        File imageFile = new File(imgPath);

        Hashtable<EncodeHintType, Object> hints = new Hashtable<EncodeHintType, Object>();
        // 指定纠错等级
        hints.put(EncodeHintType.ERROR_CORRECTION, params.getLevel());
        // 指定编码格式
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        hints.put(EncodeHintType.MARGIN, params.getMargin());   //设置白边
        try {
            if(!imageFile.exists() && !imageFile.createNewFile()){
                throw new IllegalStateException("file "+imageFile.getAbsolutePath() +" are not accessible");
            }
            MatrixToImageConfig config = new MatrixToImageConfig(params.getOnColor(), params.getOffColor());
            BitMatrix bitMatrix = new MultiFormatWriter()
                .encode(txt, BarcodeFormat.QR_CODE, params.getWidth(), params.getHeight(), hints);
            //        	bitMatrix = deleteWhite(bitMatrix);
            MatrixToImageWriter.writeToFile(bitMatrix, "png", imageFile, config);
            if(!imageFile.exists()){
                throw new IllegalStateException("file "+imageFile.getAbsolutePath() +" are not accessible");
            }
        }catch (WriterException e) {
            log.error("生成二维码失败",e);
        } catch (IOException e) {
            log.error("生成二维码失败",e);
        }
    }

    /**
     * 生成带logo的二维码图片 2
     *
     * @param txt     //二维码内容
     * @param imgPath //二维码保存绝对物理路径
     * @throws Exception
     */
    public static void generateQRImageWithLogo(QRCodeParams param, String txt, String imgPath)
        throws Exception {

        Hashtable<EncodeHintType, Object> hints = new Hashtable<EncodeHintType, Object>();
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
        hints.put(EncodeHintType.ERROR_CORRECTION, param.getLevel());
        hints.put(EncodeHintType.MARGIN, param.getMargin());  //设置白边
        BitMatrix bitMatrix =
            new MultiFormatWriter().encode(txt, BarcodeFormat.QR_CODE, param.getWidth(), param.getHeight(), hints);
        File qrcodeFile = new File(imgPath);
        writeToFile(bitMatrix, qrcodeFile, param.getLogoPath(), param);
    }

    /**
     * @param matrix   二维码矩阵相关
     * @param file     二维码图片文件
     * @param logoPath logo路径
     * @throws IOException
     */
    public static void writeToFile(BitMatrix matrix, File file, String logoPath, QRCodeParams param)
        throws IOException {
        BufferedImage image = toBufferedImage(matrix, param);
        Graphics2D gs = image.createGraphics();

        int ratioWidth = image.getWidth() * 2 / 10;
        int ratioHeight = image.getHeight() * 2 / 10;
        //载入logo
        ImageIcon imgIcon = null;
        if (!logoPath.startsWith("http:")) {
            imgIcon = new ImageIcon(logoPath);
        } else {
            java.net.URL where = new URL(logoPath);
            imgIcon = new ImageIcon(where);

        }
        //得到Image对象。
        Image img = imgIcon.getImage();
        int logoWidth = img.getWidth(null) > ratioWidth ? ratioWidth : img.getWidth(null);
        int logoHeight = img.getHeight(null) > ratioHeight ? ratioHeight : img.getHeight(null);


        int x = (image.getWidth() - logoWidth) / 2;
        int y = (image.getHeight() - logoHeight) / 2;

        gs.drawImage(img, x, y, logoWidth, logoHeight, null);
        /*gs.setColor(Color.black);
        gs.setBackground(Color.WHITE);*/

        BasicStroke stroke = new BasicStroke(5, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
        gs.setStroke(stroke);// 设置笔画对象
        //指定弧度的圆角矩形
        RoundRectangle2D.Float round = new RoundRectangle2D.Float(x, y, x / 2, y / 2, 20, 20);
        gs.setColor(Color.white);
        gs.draw(round);// 绘制圆弧矩形

        //设置logo 有一道灰色边框
        BasicStroke stroke2 = new BasicStroke(1, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
        gs.setStroke(stroke2);// 设置笔画对象
        RoundRectangle2D.Float round2 = new RoundRectangle2D.Float(x + 2, y + 2, x / 2 - 4, y / 2 - 4, 20, 20);
        gs.setColor(new Color(128, 128, 128));
        gs.draw(round2);// 绘制圆弧矩形

        gs.dispose();
        img.flush();
        FileOutputStream tem = new FileOutputStream(file);
        try {
            Imaging.writeImage(image, tem, ImageFormats.PNG, null);
        } catch (ImageWriteException e) {
            e.printStackTrace();
        }
    }

    public static BufferedImage toBufferedImage(BitMatrix matrix, QRCodeParams param) {
        int width = matrix.getWidth();
        int height = matrix.getHeight();
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                image.setRGB(x, y, matrix.get(x, y) ? param.getOnColor() : param.getOffColor());
            }
        }
        return image;
    }

    public static BitMatrix deleteWhite(BitMatrix matrix) {
        int[] rec = matrix.getEnclosingRectangle();
        int resWidth = rec[2] + 1;
        int resHeight = rec[3] + 1;

        BitMatrix resMatrix = new BitMatrix(resWidth, resHeight);
        resMatrix.clear();
        for (int i = 0; i < resWidth; i++) {
            for (int j = 0; j < resHeight; j++) {
                if (matrix.get(i + rec[0], j + rec[1]))
                    resMatrix.set(i, j);
            }
        }
        return resMatrix;
    }

    private static void initData(QRCodeParams params) {
        if (params.getWidth() == null) {
            params.setWidth(width);
        }
        if (params.getHeight() == null) {
            params.setHeight(height);
        }
        if (params.getOnColor() == null) {
            params.setOnColor(onColor);
        }
        if (params.getOffColor() == null) {
            params.setOffColor(offColor);
        }
        if (params.getLevel() == null) {
            params.setLevel(level);
        }
        if (params.getMargin() == null) {
            params.setMargin(margin);
        }

    }

}
