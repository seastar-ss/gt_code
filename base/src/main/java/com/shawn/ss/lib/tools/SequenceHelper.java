package com.shawn.ss.lib.tools;

import java.util.concurrent.atomic.AtomicInteger;

public class SequenceHelper {

    public static SequenceHelper newInstance(int max){
        return new SequenceHelper(max);
    }

    private final int MAX_WORKER ;
    final AtomicInteger sequencer;

    private SequenceHelper(int max) {
        this.MAX_WORKER = max;
        sequencer = new AtomicInteger(0);
    }

    public int getRound() {
        int i=sequencer.getAndIncrement();
        int count=0;
        if(i<MAX_WORKER){
            return i;
        }
        while(i>=MAX_WORKER && count<20) {
            final boolean b = sequencer.compareAndSet(i+1, 0);
            if(b){
                return sequencer.getAndIncrement();
            }else{
                i=sequencer.getAndIncrement();
            }
            if (i < MAX_WORKER) {
                return i;
            }
            ++count;
        }
        return 0;
    }

    public int getMax() {
        return MAX_WORKER;
    }
}
