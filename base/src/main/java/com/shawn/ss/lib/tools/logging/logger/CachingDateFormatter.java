package com.shawn.ss.lib.tools.logging.logger;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicLong;

public class CachingDateFormatter {
    final AtomicLong lastTimestamp = new AtomicLong(-1L);
    volatile String cachedStr = null;
    final SimpleDateFormat sdf;
    private final int tolerance;

    public CachingDateFormatter(String pattern, int tolerance) {
        this.tolerance = tolerance;
        this.sdf = new SimpleDateFormat(pattern);
    }

    public final String format(long now) {
        if (lastTimestamp.get() < 0 || now - this.lastTimestamp.get() > tolerance) {
            synchronized (this) {
                this.lastTimestamp.set(now);
                this.cachedStr = this.sdf.format(new Date(now));
            }
        }
        return this.cachedStr;
    }

    public void setTimeZone(TimeZone tz) {
        this.sdf.setTimeZone(tz);
    }
}
