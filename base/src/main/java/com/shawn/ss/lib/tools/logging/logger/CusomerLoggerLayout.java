package com.shawn.ss.lib.tools.logging.logger;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.LayoutBase;

public class CusomerLoggerLayout extends LayoutBase<ILoggingEvent> {
    static final int STARTER_LEN=3;
    static final String DEFAULT_DATE_FORMAT="MMdd-HH:mm:ss.SS";
    static final String LINE_SEP="\r\n";
//    static final String[] LEVEL_PRINT={};
    static final String[] CHAR_SPAN={
            " ",
            "  ",
            "   ",
            "    ",
            "     ",
            "      ",
            "       ",
            "        ",
            "         ",
            "          ",
            "           ",
            "            ",
            "             ",
            "              ",
            "               ",
            "                ",
            "                 ",
            "                  ",
            "                   ",
    };
    String format=DEFAULT_DATE_FORMAT;
    int tolerance=5;
    volatile CachingDateFormatter dateFormatter;//=new CachingDateFormatter(format,tolerance);

    String prefix = null;
    boolean printThreadName = true;

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public void setPrintThreadName(boolean printThreadName) {
        this.printThreadName = printThreadName;
    }

    public void setDateFormat(String format) {
        this.format=format;
//        dateFormatter=new CachingDateFormatter(format,tolerance);
    }

    public void setTolerance(int tolerance) {
        this.tolerance=tolerance;
//        dateFormatter=new CachingDateFormatter(format,tolerance);
    }

    public String doLayout(ILoggingEvent event) {
        if(dateFormatter==null){
            synchronized (CusomerLoggerLayout.class){
                dateFormatter=new CachingDateFormatter(format,tolerance);
            }
        }
        StringBuffer sbuf = new StringBuffer(256);
        if (prefix != null && !prefix.equals("")) {
            sbuf.append(prefix + ": ");
        }
        sbuf.append(dateFormatter.format(event.getTimeStamp()));
        sbuf.append("\t[");
        sbuf.append(event.getLevel().toString().substring(0,2));
        if (printThreadName) {
            sbuf.append(" ");
            sbuf.append(formatToLen(event.getThreadName(),15));
            sbuf.append("\t");
        } else {
            sbuf.append("\t");
        }
        sbuf.append(formatToLen(event.getLoggerName(),50));
        sbuf.append("]-|\t");
        sbuf.append(event.getFormattedMessage());
        sbuf.append(LINE_SEP);
        return sbuf.toString();
    }

    private String formatToLen(String loggerName, int i) {
        i=i+STARTER_LEN;
        final int n = loggerName.length();
        if(n >i){
            loggerName=loggerName.substring(0,STARTER_LEN).concat("...").concat(loggerName.substring(n-(i-STARTER_LEN)));
        }else if(n<i){
            int span=i-n;
            if(span>=CHAR_SPAN.length){
                span=CHAR_SPAN.length-1;
            }
            loggerName=loggerName+CHAR_SPAN[span];
        }
        return loggerName;
    }
}
