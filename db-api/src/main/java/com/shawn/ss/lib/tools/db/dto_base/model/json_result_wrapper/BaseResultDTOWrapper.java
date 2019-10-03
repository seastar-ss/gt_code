package com.shawn.ss.lib.tools.db.dto_base.model.json_result_wrapper;

public class BaseResultDTOWrapper<T> extends BaseResultWrapper{
    T resultMessage;

    public T getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(T resultMessage) {
        this.resultMessage = resultMessage;
    }
}
