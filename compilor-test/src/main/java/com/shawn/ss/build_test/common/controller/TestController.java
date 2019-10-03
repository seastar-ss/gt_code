package com.shawn.ss.build_test.common.controller;

import com.shawn.ss.build_test.common.service.TestService;
import com.shawn.ss.gen.api.interfaces.doc.EntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

/**
 * controller注释
 */
@Controller
@EntryPoint(ignore = true)
public class TestController {

    public static class TestClassType{
        /**
         * 这是key
         */
        String key;
        /**
         * 这是value
         */
        Integer value;

        public String getKey() {
            return key;
        }
        /**
         * 这是key
         */
        public TestClassType setKey(String key) {
            this.key = key;
            return this;
        }
        /**
         * 这是value
         */
        public Integer getValue() {
            return value;
        }

        public TestClassType setValue(Integer value) {
            this.value = value;
            return this;
        }
    }

    public static class TestClassParam{
        String key;
        Integer value;
        /**
         * 这是type
         */
        TestClassType type;

        public String getKey() {
            return key;
        }

        public TestClassParam setKey(String key) {
            this.key = key;
            return this;
        }

        public Integer getValue() {
            return value;
        }

        public TestClassParam setValue(Integer value) {
            this.value = value;
            return this;
        }

        public TestClassType getType() {
            return type;
        }
        /**
         * 这是type
         */
        public TestClassParam setType(TestClassType type) {
            this.type = type;
            return this;
        }
    }
    /**
     * service引用哈
     */
    @Autowired
    TestService service;
    /**
     * 这个是入口方法
     * @param args
     * @return
     */
    @RequestMapping("")
    public List<TestClassType> getInfo(List<String> args,Map<String,TestClassParam> params){
        return null;
    }
}
