package com.shawn.ss.lib.tools.logger;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class CachingDateFormatter {
    long lastTimestamp = -1L;
    String cachedStr = null;
    final SimpleDateFormat sdf;
    private int tolerance;

    public CachingDateFormatter(String pattern,int tolerance) {
        this.tolerance=tolerance;
        this.sdf = new SimpleDateFormat(pattern);
    }

    public final String format(long now) {
        synchronized(this) {
            if (lastTimestamp<0 || now - this.lastTimestamp>tolerance) {
                this.lastTimestamp = now;
                this.cachedStr = this.sdf.format(new Date(now));
            }

            return this.cachedStr;
        }
    }

    public void setTimeZone(TimeZone tz) {
        this.sdf.setTimeZone(tz);
    }
}
