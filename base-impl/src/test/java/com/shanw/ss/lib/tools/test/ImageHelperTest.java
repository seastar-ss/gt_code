package com.shanw.ss.lib.tools.test;

//import org.apache.commons.net.imap.IMAPClient;

import com.shawn.ss.lib.tools.CollectionHelper;
import com.shawn.ss.lib.tools.DateTimeHelper;
import com.shawn.ss.lib.tools.FileHelper;
import com.shawn.ss.lib.tools.img.ImagePositionEnum;

import com.shawn.ss.lib.tools.img.ImageHelper;
import com.shawn.ss.lib.tools.img.WaterMarkContent;
import com.shawn.ss.lib.tools.img.WaterMarkImage;
import com.shawn.ss.lib.tools.img.WaterMarkStrokeLine;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

/**
 * Created by ss on 2017/10/3.
 */
public class ImageHelperTest {

    static final Logger L = LoggerFactory.getLogger(ImageHelperTest.class.getSimpleName());
    protected final String BASE_URL = "./src/test/sharePics";

//    @Test
    public void testMergePics() {
        try {
            ImageHelper.mergePics(
                    "C:\\projects\\newWorkSpace\\base-foundation-libs\\base\\src\\test\\sharePics\\1053233282144174080.jpg",
                    CollectionHelper.<ImageHelper.MergedPics>listBuilder()
                            .add(new ImageHelper.MergedPics()
                                    .setPosition("C:\\projects\\codes\\base_code_new\\maven\\base\\src\\test\\clip1.png")
                                    .setLeft(50)
                                    .setTop(50)
                                    .setDistHeight(120)
                                    .setDistWidth(80)
                            )
                            .getList(),
                    "C:\\projects\\codes\\base_code_new\\maven\\base\\src\\test\\output.png"
            );
        } catch (ImageHelper.ImgGenException e) {
            e.printStackTrace();
        }
    }

    DateTimeHelper timeHelper = DateTimeHelper.newInstance();

//    @Test
    public void testGenpics() {
        String bigImg = "C:\\projects\\newWorkSpace\\base-foundation-libs\\base\\src\\test\\sharePics\\1053233282144174080.jpg";

        String outPath = "./" + timeHelper.getCurrentDateTimeString(DateTimeHelper.StyleDateFormat.STYLE_FULL_DATE_AND_TIME_NO_SPLITER.getFormat()) + ".jpg";

        try {
            ImageHelper.mergePicsTextAndLine(
                    bigImg,
                    CollectionHelper.<WaterMarkImage>listBuilder()
                            .add(new WaterMarkImage()
                                    .setX(85).setY(313).setWidth(80).setHeight(28)
                                    .setImageUrl("C:\\projects\\newWorkSpace\\sharePics\\month\\2x\\1.png"))
                            .add(new WaterMarkImage()
                                    .setX(475).setY(595).setWidth(32).setHeight(40)
                                    .setImageUrl("C:\\projects\\newWorkSpace\\sharePics\\completeNumber\\2x\\1@2x.png"))
                            .add(new WaterMarkImage()
                                    .setX(575).setY(595).setWidth(32).setHeight(40)
                                    .setImageUrl("C:\\projects\\newWorkSpace\\sharePics\\completeNumber\\2x\\1@2x.png"))
                            .add(new WaterMarkImage()
                                    .setX(140).setY(585).setWidth(156).setHeight(54)
                                    .setImageUrl("C:\\projects\\newWorkSpace\\sharePics\\record\\2x\\1.png"))
                            .add(new WaterMarkImage()
                                    .setX(155).setY(425).setWidth(50).setHeight(50)
                                    .setImageUrl("C:\\projects\\newWorkSpace\\sharePics\\date\\2x\\1.png"))
                            .add(new WaterMarkImage()
                                    .setX(225).setY(425).setWidth(50).setHeight(50)
                                    .setImageUrl("C:\\projects\\newWorkSpace\\sharePics\\date\\2x\\1C.png"))
                            .getList(),
                    null,
                    null,
                    outPath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        final File file = FileHelper.checkFileExist(outPath);
        if (file == null) {
            throw new IllegalStateException("生成图片未知错误");
        }
    }


//    @Test
    public void testWaterMark2() {
        //
        String bigImg = "http://172.16.117.226:801/original/20180621/1009615650977517568.jpg";

        String outPath = "./" + System.currentTimeMillis() + ".jpg";
        waterMarkForSignin(bigImg, "5", "09", "ONE DAY 2018/MAY", "2000", outPath);

        final File file = FileHelper.checkFileExist(outPath);
        if (file == null) {
            throw new IllegalStateException("生成图片未知错误");
        }
    }

    void waterMarkForSignin(String bigImg, String month, String day, String yearMonthEng,
                            String studyDays, String outPath) {

        if (StringUtils.isEmpty(bigImg)) {
            return;
        }

        String text1 = month + "/";
        String text2 = day;
        String text3 = yearMonthEng;

        String text5 = studyDays;
        int l = text5.length();
        int x = l * 4;
        String text6 = "我在尚德学习";
        for (int i = 0; i < x; i++) {
            text6 += " ";
        }
        text6 += "天";

        String smallImg =
                "http://static.sunlands.com/user_center_test/2018-06-22/1530152039792.jpg";//"/Users/bkc/Desktop/bkc.jpg";


        Color mycolor = Color.white;//new Color(0, 0, 255);
        try {
            java.util.List<WaterMarkContent> contentList = new ArrayList<>();

            WaterMarkContent content1 = new WaterMarkContent();
            Font f = new Font("宋体", Font.PLAIN, 40);

            content1.setColor(mycolor).setContent(text1).setFont(f).setX(28).setY(187);

            WaterMarkContent content2 = new WaterMarkContent();
            Font f1 = new Font("宋体", Font.PLAIN, 80);
            content2.setColor(mycolor).setContent(text2).setFont(f1).setX(85).setY(200);

            WaterMarkContent content3 = new WaterMarkContent();
            content3.setColor(mycolor).setContent(text3).setFont(f).setX(28).setY(245);

            WaterMarkContent content5 = new WaterMarkContent();
            Font f2 = new Font("宋体", Font.PLAIN, 80);
            content5.setColor(mycolor).setContent(text5).setFont(f2).setX(410 + (3 - l) * 44).setY(761);

            WaterMarkContent content6 = new WaterMarkContent();
            content6.setColor(mycolor).setContent(text6).setFont(f).setX(165 + (3 - l) * 44).setY(758);

            contentList =
                    CollectionHelper.<WaterMarkContent>listBuilder().add(content1).add(content2).add(content3).add(content5)
                            .add(content6).getList();

            java.util.List<WaterMarkImage> imageList = new ArrayList<>();
            WaterMarkImage image = new WaterMarkImage();
            image.setImageUrl(smallImg).setX(622).setY(681).setWidth(95).setHeight(95);
            imageList.add(image);

            List<WaterMarkStrokeLine> strokeLines = new ArrayList<>();

            WaterMarkStrokeLine line = new WaterMarkStrokeLine();

            // 指定绘制线的宽度(多粗)
            Stroke bs = new BasicStroke(2, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{4, 4}, 0);
            line.setColor(Color.WHITE).setStroke(bs).setX1(24).setY1(659).setX2(723).setY2(659);

            WaterMarkStrokeLine line2 = new WaterMarkStrokeLine();
            // 指定绘制线的宽度(多粗)
            Stroke bs2 = new BasicStroke(4, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{4, 4}, 0);

            line2.setColor(Color.RED).setStroke(bs2).setX1(24).setY1(666).setX2(723).setY2(666);


            strokeLines.add(line);
            strokeLines.add(line2);
            ImageHelper.mergePicsTextAndLine(bigImg, imageList, contentList, strokeLines, outPath);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

//    @Test
    public void testMegrPicsPositionMiddle() {

        String bigImg = "http://172.16.117.226:801/original/20180621/1009615650977517568.jpg";
        String smallImg =
                "http://static.sunlands.com/user_center_test/2018-06-22/1530152039792.jpg";
        String outPath = "./" + System.currentTimeMillis() + ".jpg";
        int[] smallXy = {95, 95};
        ImageHelper.mergePicsMiddle(ImagePositionEnum.BOTTOM, bigImg, smallImg, smallXy, outPath);
        final File file = FileHelper.checkFileExist(outPath);
        if (file == null) {
            throw new IllegalStateException("生成图片未知错误");
        }
    }

//    @Test
    public void testEnvironmentSupportFonts() {
        GraphicsEnvironment g = GraphicsEnvironment
                .getLocalGraphicsEnvironment();
        String fontName[] = g.getAvailableFontFamilyNames();

        for (int i = 0; i < fontName.length; i++) {
            System.out.println(fontName[i]);
        }
    }

    @Test
    public void trestSize() {

    }

    /**
     * 获取对应字体的文字的高度
     *
     * @param g2d
     * @param font
     * @return
     * @throws
     * @parm
     */
    public double getFontHeight(Graphics2D g2d, Font font) {
        // 设置大字体
        FontRenderContext context = g2d.getFontRenderContext();
        // 获取字体的像素范围对象
        Rectangle2D stringBounds = font.getStringBounds("w", context);
        double fontWidth = stringBounds.getWidth();
        return fontWidth;
    }

    /**
     * 获取对应的文字所占有的长度
     *
     * @param g2d
     * @param font
     * @return
     * @throws
     * @parm
     */
    public double getFontSize(Graphics2D g2d, Font font, String text) {
        // 设置大字体
        FontRenderContext context = g2d.getFontRenderContext();
        // 获取字体的像素范围对象
        Rectangle2D stringBounds = font.getStringBounds(text, context);
        double fontWidth = stringBounds.getWidth();
        return fontWidth;
    }


    public List<WaterMarkImage> getWaterMarkImage(Integer x,Integer y,Integer width,Integer height,String url){
        CollectionHelper.ListBuilder<WaterMarkImage> waterMarkImageListBuilder = CollectionHelper.<WaterMarkImage>listBuilder();

        List<WaterMarkImage> list = waterMarkImageListBuilder.add(new WaterMarkImage()
                .setX(x).setY(y).setWidth(width).setHeight(height)
                .setImageUrl(url)).getList();
        return list;
    }

    public void shareMechod(String imgUrl, String subject,
                            Integer month, List<Map<String, Integer>> weekFlag,
                            Integer completeNumber, Integer onlineCount,
                            Integer onlineTime, Integer realNumber) {

        String bigImg = BASE_URL + "/share.png";
        String outPath = "./" + timeHelper.getCurrentDateTimeString(DateTimeHelper.StyleDateFormat.STYLE_FULL_DATE_AND_TIME_NO_SPLITER.getFormat()) + ".jpg";

        CollectionHelper.ListBuilder<WaterMarkImage> waterMarkImageListBuilder = CollectionHelper.<WaterMarkImage>listBuilder();

        waterMarkImageListBuilder.add().getList();

        List<WaterMarkImage> list = CollectionHelper.<WaterMarkImage>listBuilder()
                //头像
                .add(new WaterMarkImage()
                        .setX(180).setY(60).setWidth(70).setHeight(70)
                        .setImageUrl(imgUrl))
                //几月
                .add(new WaterMarkImage()
                        .setX(85).setY(313).setWidth(78).setHeight(25)
                        .setImageUrl(BASE_URL + "/month/" + month + ".png"))
                //最后三个出勤率
                .add(new WaterMarkImage()
                        .setX(135).setY(740).setWidth(50).setHeight(60)
                        .setImageUrl(BASE_URL + "/onlineCountNumber/" + onlineCount + "@2x.png"))
                .add(new WaterMarkImage()
                        .setX(335).setY(740).setWidth(50).setHeight(60)
                        .setImageUrl(BASE_URL + "/onlineTimeNumber/" + onlineTime + "@2x.png"))
                .add(new WaterMarkImage()
                        .setX(545).setY(740).setWidth(50).setHeight(60)
                        .setImageUrl(BASE_URL + "/realNumber/" + realNumber + "@2x.png"))
                .getList();

        int count = 0;
        //七天
        for (Map<String, Integer> map : weekFlag) {
            Integer date = map.get("date");
            Integer flag = map.get("flag");
            String dayUrl = "";
            if (flag == 0) {
                dayUrl = BASE_URL + "/date/" + date + ".png";
            } else {
                dayUrl = BASE_URL + "/date/" + date + "c.png";
            }
            List<WaterMarkImage> img =getWaterMarkImage(150 + 65 * count,410,65,65,dayUrl);
            list.addAll(img);
            count++;
        }


        int percentPass = completeNumber.intValue() / 20;
        if (percentPass == 0 || percentPass == 1) {
            List<WaterMarkImage> img =getWaterMarkImage(145,580,160,60,BASE_URL + "/record/1.png");
            list.addAll(img);
        } else {
            int x = 135;
            if (percentPass == 5) {
                x = 145;
            }
            List<WaterMarkImage> img =getWaterMarkImage(x,580,160,60,BASE_URL + "/record/" + percentPass + ".png");
            list.addAll(img);
        }


        if (completeNumber < 10) {
            List<WaterMarkImage> img =getWaterMarkImage(490,585,40,52,BASE_URL + "/completeNumber/" + completeNumber + "@2x.png");
            list.addAll(img);
        } else {
            int shi = completeNumber / 10;
            int ge = completeNumber % 10;
            List<WaterMarkImage> shiImg =getWaterMarkImage(470,585,40,52,BASE_URL + "/completeNumber/" + shi + "@2x.png");
            list.addAll(shiImg);

            List<WaterMarkImage> geImg =getWaterMarkImage(505,585,40,52,BASE_URL + "/completeNumber/" + ge + "@2x.png");
            list.addAll(geImg);
        }


        //上面一行学科文字
        int l = subject.length();
        Font f = new Font("宋体", Font.PLAIN, 28);
        Color mycolor = Color.white;

        WaterMarkContent subjectContent = new WaterMarkContent();
        subjectContent.setColor(mycolor).setContent(subject).setFont(f).setX(265).setY(110);

        java.util.List<WaterMarkContent> contentList = CollectionHelper.<WaterMarkContent>listBuilder().add(subjectContent).getList();

        try {
            ImageHelper.mergePicsTextAndLine(
                    bigImg,
                    list,
                    contentList,
                    null,
                    outPath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        final File file = FileHelper.checkFileExist(outPath);
        if (file == null) {
            throw new IllegalStateException("生成图片未知错误");
        }
    }


    //根据日期以及出勤率计算生成图片所需map   numberList为本周出勤天list
    public List<Map<String, Integer>> weekFlag(Date date, List<Integer> numberList) {
        List<Integer> week = week(date);
        List<Map<String, Integer>> mapList = new ArrayList<Map<String, Integer>>();
        for (Integer dayNumber : week) {
            Map<String, Integer> map = new HashMap<String, Integer>();
            map.put("date", dayNumber);
            if (numberList.contains(dayNumber)) {
                map.put("flag", 1);
            } else {
                map.put("flag", 0);
            }
            mapList.add(map);
        }

        return mapList;
    }

    //根据日期获取当前周
    public List<Integer> week(Date date) {
        try {

            List<Integer> list = new ArrayList<Integer>();
            SimpleDateFormat simdf = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat simdf2 = new SimpleDateFormat("dd");
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            // 判断要计算的日期是否是周日，如果是则减一天计算周六的，否则会出问题，计算到下一周去了
            int dayWeek = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天
            if (1 == dayWeek) {
                cal.add(Calendar.DAY_OF_MONTH, -1);
            }
            // 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一
            cal.setFirstDayOfWeek(Calendar.MONDAY);
            // 获得当前日期是一个星期的第几天
            int day = cal.get(Calendar.DAY_OF_WEEK);
            // 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值

            //周一
            cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);
            String imptime1 = simdf.format(cal.getTime());
            Date parse = simdf.parse(imptime1);
            String week1 = simdf2.format(cal.getTime());
            list.add(Integer.parseInt(week1));
            cal.setTime(parse);

            //周二
            cal.add(Calendar.DATE, 1);
            String imptime2 = simdf.format(cal.getTime());
            String week2 = simdf2.format(cal.getTime());
            list.add(Integer.parseInt(week2));
            cal.setTime(parse);

            //周三
            cal.add(Calendar.DATE, 2);
            String imptime3 = simdf.format(cal.getTime());
            String week3 = simdf2.format(cal.getTime());
            list.add(Integer.parseInt(week3));
            cal.setTime(parse);

            //周四
            cal.add(Calendar.DATE, 3);
            String imptime4 = simdf.format(cal.getTime());
            String week4 = simdf2.format(cal.getTime());
            list.add(Integer.parseInt(week4));
            cal.setTime(parse);

            //周五
            cal.add(Calendar.DATE, 4);
            String imptime5 = simdf.format(cal.getTime());
            String week5 = simdf2.format(cal.getTime());
            list.add(Integer.parseInt(week5));
            cal.setTime(parse);

            //周六
            cal.add(Calendar.DATE, 5);
            String imptime6 = simdf.format(cal.getTime());
            String week6 = simdf2.format(cal.getTime());
            list.add(Integer.parseInt(week6));
            cal.setTime(parse);

            //周日
            cal.add(Calendar.DATE, 6);
            String imptime7 = simdf.format(cal.getTime());
            String week7 = simdf2.format(cal.getTime());
            list.add(Integer.parseInt(week7));

            return list;
        } catch (Exception e) {
            return null;
        }
    }



//    @Test
    public void testShare() {
        String imgUrl = "http://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIkDZw6ic2bMAed8dMC2Q8oyoicgYZTaIgk8NfkHuqhmnoRxKEPh8gQLBo67Dg3Vc9dMHH2BCwTY2pw/132";

        //本周16号，18号出勤
        List<Integer> dayList = new ArrayList<Integer>();
        dayList.add(16);
        dayList.add(18);

        List<Map<String, Integer>> maps = weekFlag(new Date(), dayList);


        shareMechod(imgUrl, "计算机信息管理本科", 3, maps, 57, 7, 8, 9);
//        shareImg(imgUrl,"",8);
    }


}
