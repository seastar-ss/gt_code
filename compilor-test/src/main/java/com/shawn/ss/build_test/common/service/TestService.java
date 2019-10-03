package com.shawn.ss.build_test.common.service;

import com.shawn.ss.gen.api.interfaces.doc.EntryPoint;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 这里是测试service的评论
 */
@Service
@EntryPoint(scriptable = true)
public class TestService {


    /**
     * 这是一个测试方法
     * @param args 测试参数
     * @return
     */
    @EntryPoint(scriptable = false)
    public String testMethod(
            /**
             * 这里是第一个参数的评论
             */
            List<String> args
    ){
        return null;
    }
}
