package com.shawn.ss.lib.tools.db.impl.data_source;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by ss on 2016/3/9.
 */
public class RoundRobinSchedule implements ResourceSchedule {
    AtomicInteger seq;
    protected final int size;
    public static final int MAX_SIZE = 65536;

    public RoundRobinSchedule(int size) {

        if (size < 1) {
            throw new IllegalArgumentException("not enough resource");
        }
//        this.size = size;
        seq = new AtomicInteger(0);
        this.size = size;
    }

//    @Override
    public int getRound() {
        if(size==1){
            return 0;
        }
        try {
            int ret = seq.getAndIncrement();
            return ret % size;
        } finally {
            if (seq.get() > MAX_SIZE) {
                seq.set(0);
            }
        }
    }
}
