package com.shawn.ss.lib.tools.img;

import com.shawn.ss.lib.tools.FileHelper;
import org.apache.commons.imaging.ImageFormats;
import org.apache.commons.imaging.ImageReadException;
import org.apache.commons.imaging.ImageWriteException;
import org.apache.commons.imaging.Imaging;
import org.springframework.util.StringUtils;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ImageHelper {

    private static final String JPEG_FILE_APPENDIX = "jpg";


    public static class MergedPics {
        String position;
        int left;
        int top;
        int distHeight;
        int distWidth;
        int alpha;
        File picFile;
        byte[] data;

        public MergedPics() {
            left = 0;
            top = 0;
            alpha = 0xff;
        }

        public int getAlpha() {
            return alpha;
        }

        public MergedPics setAlpha(int alpha) {
            this.alpha = alpha;
            return this;
        }

        public String getPosition() {
            return position;
        }

        public MergedPics setPosition(String position) {
            this.position = position;
            picFile = FileHelper.checkFileExist(position);
            return this;
        }

        public int getLeft() {
            return left;
        }

        public MergedPics setLeft(int left) {
            this.left = left;
            return this;
        }

        public int getTop() {
            return top;
        }

        public MergedPics setTop(int top) {
            this.top = top;
            return this;
        }

        public int getDistHeight() {
            return distHeight;
        }

        public MergedPics setDistHeight(int distHeight) {
            this.distHeight = distHeight;
            return this;
        }

        public int getDistWidth() {
            return distWidth;
        }

        public MergedPics setDistWidth(int distWidth) {
            this.distWidth = distWidth;
            return this;
        }

        public byte[] getData() {
            return data;
        }

        public MergedPics setData(byte[] data) {
            this.data = data;
            return this;
        }
    }


    public static class ImgGenException extends Exception {
        public ImgGenException(String message) {
            super(message);
        }

        public ImgGenException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    public static void mergePics(String backgroundPic, List<MergedPics> pics, String outputPos) throws ImgGenException {
        final File file = FileHelper.checkFileExist(backgroundPic);
        try {
            if (file == null) {
                throw new ImgGenException("pic file not exist");
            }
            BufferedImage image = ImageIO.read(file);
            final int height = image.getHeight();
            final int width = image.getWidth();
            if (height == 0 || width == 0) {
                throw new ImgGenException("图片" + backgroundPic + "尺寸不正确");
            }
            Graphics2D gh = (Graphics2D) image.getGraphics();
            for (MergedPics pic : pics) {
                BufferedImage clip;
                if (pic.picFile == null && (pic.data == null || pic.data.length == 0)) {
                    throw new ImgGenException("图片" + pic.getPosition() + "不存在");
                } else {
                    if (pic.picFile != null) {
                        clip = ImageIO.read(pic.picFile);
                    } else {
                        clip = ImageIO.read(new ByteArrayInputStream(pic.data));
                    }
                }
                final int distHeight = pic.getDistHeight();
                final int distWidth = pic.getDistWidth();
                final int clipHeight = distHeight > 0 ? distHeight : clip.getHeight();
                final int clipWidth = distWidth > 0 ? distWidth : clip.getWidth();
                final int clipLeft = pic.getLeft();
                final int clipTop = pic.getTop();
                if (clipTop > height || clipLeft > width) {
                    throw new ImgGenException("图片" + pic.getPosition() + "无法再背景图画出，请检查参数");
                } else {
                    gh.drawImage(clip, clipLeft, clipTop, clipWidth, clipHeight, new ImageObserver() {
                        @Override
                        public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
                            return false;
                        }
                    });
                }
            }
            File output = FileHelper.checkFileExist(outputPos);
            if (output == null) {
                output = FileHelper.mkFile(outputPos);
            }
            try {
                ImageIO.write(image, JPEG_FILE_APPENDIX, output);
            } catch (IOException e) {
                e.printStackTrace();
                throw new ImgGenException("写入图片发生IO错误", e);
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new ImgGenException("生成图片发生IO错误", e);
        }
        //        return "";
    }

    public static void mergePicsMiddle(ImagePositionEnum position, String bigImg, String smallImg, int[] smallImgWidthAndHeight, String outPath) {
        if (StringUtils.isEmpty(bigImg)) {
            return;
        }
        List<WaterMarkImage> imageList = null;
        if (!StringUtils.isEmpty(smallImg)) {
            imageList = new ArrayList<>();
            int xy[] = getPositionForSmallIImg(position, bigImg, smallImg, smallImgWidthAndHeight);
            WaterMarkImage image = new WaterMarkImage();
            image.setImageUrl(smallImg).setX(xy[0]).setY(xy[1]).setWidth(smallImgWidthAndHeight[0])
                .setHeight(smallImgWidthAndHeight[1]);
            imageList.add(image);
        }
        try {
            ImageHelper.mergePicsTextAndLine(bigImg, imageList, null, null, outPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int[] getPositionForSmallIImg(ImagePositionEnum position, String bigImgPath, String smallImgPath,
        int[] smallImgWidthAndHeight) {
        int[] xy = new int[2];

        int[] bigImgWidthAndHeight = getImageHeightAndWidth(bigImgPath);
        int bigImgWidth = bigImgWidthAndHeight[0];
        int bigImgHeight = bigImgWidthAndHeight[1];

        int smallImageWidth;
        int smallImageHeight;
        if (null == smallImgWidthAndHeight
            || smallImgWidthAndHeight[0] == 0
            || smallImgWidthAndHeight[1] == 0) {
            int[] wh = getImageHeightAndWidth(smallImgPath);
            smallImageWidth = wh[0];
            smallImageHeight = wh[1];
        } else {
            smallImageWidth = smallImgWidthAndHeight[0];
            smallImageHeight = smallImgWidthAndHeight[1];
        }

        int defaultDistance = 10;
        int halfBigWidth = bigImgWidth / 2;
        int halfBigHeight = bigImgHeight / 2;
        int halfSmallWidth = smallImageWidth / 2;
        int halfSmallHeight = smallImageHeight / 2;
        int x = 0;
        int y = 0;
        if (position.getKey().equals("middle")) {
            x = halfBigWidth - halfSmallWidth;
            y = halfBigHeight - halfSmallHeight;

        } else if (position.getKey().equals("top")) {
            x = halfBigWidth - halfSmallWidth;
            y = defaultDistance;

        } else if (position.getKey().equals("bottom")) {
            x = halfBigWidth - halfSmallWidth;
            y = bigImgHeight - smallImageHeight - defaultDistance;

        } else if (position.getKey().equals("left")) {
            x = defaultDistance;
            y = halfBigHeight - halfSmallHeight;

        } else if (position.getKey().equals("right")) {
            x = bigImgWidth - smallImageHeight - defaultDistance;
            y = halfBigHeight - halfSmallHeight;

        } else if (position.getKey().equals("leftTop")) {
            x = defaultDistance;
            y = defaultDistance;

        } else if (position.getKey().equals("leftBottom")) {
            x = defaultDistance;
            y = bigImgHeight - smallImageHeight - defaultDistance;

        } else if (position.getKey().equals("rightTop")) {
            x = bigImgWidth - smallImageWidth - defaultDistance;
            y = defaultDistance;

        } else if (position.getKey().equals("rightBottom")) {
            x = bigImgWidth - smallImageWidth - defaultDistance;
            y = bigImgHeight - smallImageHeight - defaultDistance;
        } else {
            x = halfBigWidth - halfSmallWidth;
            y = halfBigHeight - halfSmallHeight;
        }

        xy[0] = x;
        xy[1] = y;
        return xy;
    }



    public static void mergePicsTextAndLine(
        String bigImgPath, List<WaterMarkImage> imageList,
        List<WaterMarkContent> contentList, List<WaterMarkStrokeLine> strokeLines, String outPathWithFileName)
        throws IOException {

        if (StringUtils.isEmpty(bigImgPath)) {
            return;
        }

        File temFile = null;
        //主图片的路径
        InputStream is = null;//new FileInputStream(bigImgPath);

        if (!bigImgPath.startsWith("http:")) {
            temFile = new File(bigImgPath);
            if (!temFile.isFile() || !temFile.exists() || !temFile.canRead()) {
                return;
            }
            is = new FileInputStream(temFile);
        } else {
            URLConnection conn = null;
            URL imgUrl = new URL(bigImgPath);
            conn = imgUrl.openConnection();

            temFile = new File(new Date().getTime() + ".jpg");
            FileOutputStream tem = new FileOutputStream(temFile);
            try {
                BufferedImage image = Imaging.getBufferedImage(conn.getInputStream());
                try {
                    Imaging.writeImage(image, tem, ImageFormats.PNG, null);
                } catch (ImageWriteException e) {
                    e.printStackTrace();
                }
            } catch (ImageReadException e) {
                e.printStackTrace();
            }
            is = new FileInputStream(temFile);
        }
        //解码当前JPEG数据流，返回BufferedImage对象
        BufferedImage buffImg = null;
        try {
            buffImg = Imaging.getBufferedImage(is);
        } catch (ImageReadException e) {
            e.printStackTrace();
        }
        //得到画笔对象
        Graphics2D g = (Graphics2D) buffImg.getGraphics();

        if (null != strokeLines && strokeLines.size() > 0) {
            for (WaterMarkStrokeLine strokeLine : strokeLines) {
                Stroke stroke = strokeLine.getStroke();
                Color color = strokeLine.getColor();
                int x1 = strokeLine.getX1();
                int x2 = strokeLine.getX2();
                int y1 = strokeLine.getY1();
                int y2 = strokeLine.getY2();
                g.setStroke(stroke);
                g.setColor(color);
                g.drawLine(x1, y1, x2, y2);
            }
        }

        //小图片的路径
        if (null != imageList && imageList.size() > 0) {
            for (WaterMarkImage image : imageList) {
                String smallImgPath = image.getImageUrl();
                int smallImgX = image.getX();
                int smallImgY = image.getY();

                int width = image.getWidth();
                int height = image.getHeight();

                //如果没传，取图片原始尺寸
                if (0 == width || 0 == height) {
                    int[] originalxy = getImageHeightAndWidth(smallImgPath);
                    width = originalxy[0];
                    height = originalxy[1];
                }

                ImageIcon imgIcon = null;
                if (!smallImgPath.startsWith("http:")) {
                    imgIcon = new ImageIcon(smallImgPath);
                } else {
                    java.net.URL where = new URL(smallImgPath);
                    imgIcon = new ImageIcon(where);

                }
                //得到Image对象。
                Image img = imgIcon.getImage();
                //将小图片绘到大图片上,smallImgX,smallImgY .表示你的小图片在大图片上的位置。
                g.drawImage(img, smallImgX, smallImgY, width, height, null);
            }

        }

        //最后一个参数用来设置字体的大小
        if (contentList != null && contentList.size() > 0) {
            for (WaterMarkContent content : contentList) {
                //设置颜色。
                g.setColor(content.getColor());
                g.setFont(content.getFont());
                g.drawString(content.getContent(), content.getX(), content.getY()); //表示这段文字在图片上的位置(cx,cy) .第一个是你设置的内容。
            }

        }

        g.dispose();
        OutputStream os = new FileOutputStream(outPathWithFileName);
        try {
            Imaging.writeImage(buffImg, os, ImageFormats.PNG, null);
        } catch (ImageWriteException e) {
            e.printStackTrace();
        }
//        if (null != temFile) {
//            temFile.delete();
//        }
        is.close();
        os.close();
    }

    /**
     * 获取图片的宽X高数据
     *
     * @param imgPath
     * @return width X height
     * @throws IOException
     */
    public static int[] getImageHeightAndWidth(String imgPath) {
        InputStream is = null;

        File temFile = null;
        int width = 0;
        int height = 0;
        try {
            if (!imgPath.startsWith("http:")) {
                temFile = new File(imgPath);
                if (!temFile.isFile() || !temFile.exists() || !temFile.canRead()) {
                    return null;
                }
                is = new FileInputStream(temFile);
            } else {
                URLConnection conn = null;
                URL imgUrl = new URL(imgPath);
                conn = imgUrl.openConnection();

                temFile = new File(new Date().getTime() + ".jpg");
                FileOutputStream tem = new FileOutputStream(temFile);
                //BufferedImage image = ImageIO.read(conn.getInputStream());
                //ImageIO.write(image, "jpg", tem);

                BufferedImage image = null;
                try {
                    image = Imaging.getBufferedImage(conn.getInputStream());
                } catch (ImageReadException e) {
                    e.printStackTrace();
                }
                try {
                    Imaging.writeImage(image, tem, ImageFormats.PNG, null);
                } catch (ImageWriteException e) {
                    e.printStackTrace();
                }
                is = new FileInputStream(temFile);
            }
            BufferedImage buffImg = null;
            try {
                buffImg = Imaging.getBufferedImage(is);
            } catch (ImageReadException e) {
                e.printStackTrace();
            }

            width = buffImg.getWidth();
            height = buffImg.getHeight();

//            if (null != temFile) {
//                temFile.delete();
//            }

            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        int[] xy = {width, height};
        return xy;
    }


}
