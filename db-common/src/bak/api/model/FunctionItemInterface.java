package com.shawn.ss.lib.tools.service_assemble.api.bak.api.model;

import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model.CommonOpType;
import com.shawn.ss.lib.tools.sql_code_gen.api.model.column_expression.ColumnItem;

import java.util.List;

/**
 * Created by ss on 2017/10/22.
 */
public interface FunctionItemInterface {
    List<GenricExpression> getParamList();

    int sizeOfParam();

    FunctionItemInterface addParam(String table, String column);

    <T> FunctionItemInterface addParam(T value);

    FunctionItemInterface addParam(GenricExpression paramItem);

    boolean isAll();

    FunctionItemInterface setAll(boolean all);

    String getFuncName();

    FunctionItemInterface setFuncName(String funcName);

    boolean isDistinct();

    boolean isCommon();

    CommonOpType getFuncType();

    FunctionItemInterface setDistinct(boolean distinct);
}
