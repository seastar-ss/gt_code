package com.shanw.ss.lib.tools.test;

import java.util.Date;

public class BaseResultWrapper //extends AbstractBaseModel
{
    Integer flag =1;
    String message ="success";
    Date current=new Date();
    String data;

    public BaseResultWrapper() {
    }

//    @Override
//    public Map<String, Object> getFieldConfig() {
//        return null;
//    }

    public BaseResultWrapper(Integer rs, String errMsg) {
        this.flag = rs;
        this.message = errMsg;
    }

    public Integer getFlag() {
        return flag;
    }

    public BaseResultWrapper setFlag(Integer flag) {
        this.flag = flag;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public BaseResultWrapper setMessage(String message) {
        this.message = message;
        return this;
    }

    public Date getCurrent() {
        return current;
    }

    public BaseResultWrapper setCurrent(Date current) {
        this.current = current;
        return this;
    }

    public String getData() {
        return data;
    }

    public BaseResultWrapper setData(String data) {
        this.data = data;
        return this;
    }
}
