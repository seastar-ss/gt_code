package com.shawn.ss.lib.tools;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SequencerTest {
    static final Logger L = LoggerFactory.getLogger(SequencerTest.class.getSimpleName());
    @Test
    public void testSequencer(){
        final SequenceHelper seq=SequenceHelper.newInstance(5);
        for(int i=0;i<1000;++i){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int i=0;i<100;++i) {
                        final int round = seq.getRound();
                        L.info("get seq ： {}->{}",i,round);
                    }
                }
            }).start();
        }
    }

    @Test
    public void testSequencerSingleThread(){
        final SequenceHelper seq=SequenceHelper.newInstance(5);
        for(int i=0;i<100;++i) {
            final int round = seq.getRound();
            L.info("get seq ： {}->{}",i,round);
        }
    }
}
