package com.shawn.ss.lib.tools.db.dto_base.model.json_result_wrapper;

import com.shawn.ss.lib.tools.db.dto_base.model.AbstractBaseModel;

import java.util.Date;
import java.util.Map;

public class BaseResultWrapper {
    Integer rs;
    String errMsg;
    Date current=new Date();

    public BaseResultWrapper() {
    }

//    @Override
//    public Map<String, Object> getFieldConfig() {
//        return null;
//    }

    public BaseResultWrapper(Integer rs, String errMsg) {
        this.rs = rs;
        this.errMsg = errMsg;
    }

    public Integer getRs() {
        return rs;
    }

    public BaseResultWrapper setRs(Integer rs) {
        this.rs = rs;
        return this;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public BaseResultWrapper setErrMsg(String errMsg) {
        this.errMsg = errMsg;
        return this;
    }

    public Date getCurrent() {
        return current;
    }

    public BaseResultWrapper setCurrent(Date current) {
        this.current = current;
        return this;
    }
}
