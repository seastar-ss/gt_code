package com.shawn.ss.lib.tools.constants;

import com.shawn.ss.lib.tools.StringHelper;

import java.util.UUID;

public class MemoryKeys {
//    LESSON_TEACHER_CACHE(10000,3600000),
//    TEST_LOCAL_CACHE(1024,3600000),
//    ;

    protected final String uuid;
    protected final Integer count;
    protected final Integer expiredSpan;

    public MemoryKeys(int count, int expiredSpan) {
        this.count = count;
        this.expiredSpan=expiredSpan;
        uuid = UUID.randomUUID().toString();
    }

    public Integer getCount() {
        return count;
    }

    public Integer getExpiredSpan() {
        return expiredSpan;
    }

    public String name(){
        return StringHelper.concat(uuid,"-",this.hashCode());
    }

}
