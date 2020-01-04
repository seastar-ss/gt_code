package com.shawn.ss.lib.tools.db.dto_base.model.json_result_wrapper;

import com.shawn.ss.lib.tools.db.dto_base.model.AbstractVoModel;

public class BaseResultDTOWrapper<T extends AbstractVoModel> extends BaseResultWrapper{
    T resultMessage;

    public T getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(T resultMessage) {
        this.resultMessage = resultMessage;
    }
}
