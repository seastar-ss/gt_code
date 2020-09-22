package com.shawn.ss.build_test.common.sample;

import com.shangde.ent_portal.logical.dto.basepo.ModelTEvent;

public class TestClassExcange {
    public static class TestBase<T extends ModelTEvent> {
        TestBase(Class<T> tClass) {

        }
    }

    public static class Test<T extends ModelTEventExt> extends TestBase<T> {

        Test() {
            super((Class<T>) ModelTEventExt.class);
        }
    }

    public static void main(String[] args) {
        Test<ModelTEventExt> test = new Test<>();
        System.out.println(test);
    }
}
