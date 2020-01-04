package com.shawn.ss.lib.tools.db.dto_base.model.json_result_wrapper;

import com.shawn.ss.lib.tools.db.dto_base.model.AbstractVoModel;

import java.util.List;

public class BaseResultListWrapper<T extends AbstractVoModel> extends BaseResultWrapper{
    List<T> resultMessage;
    Integer total;

    public List<T> getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(List<T> resultMessage) {
        this.resultMessage = resultMessage;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
