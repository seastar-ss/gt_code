package com.shawn.ss.lib.tools.service_assemble.api.bak.api.model.column_and_param_expression;

import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model.CommonOpType;
import com.shawn.ss.lib.tools.service_assemble.api.bak.api.SQLUtils;
import com.shawn.ss.lib.tools.sql_code_gen.api.model.GenricExpression;
import com.shawn.ss.lib.tools.sql_code_gen.api.model.LogicalExpression;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.statement.HasMainTable;

/**
 * Created by ss on 2017/10/21.
 */
public class ConstantValueParamItem<T> extends ParamItem implements LogicalExpression {

    private T value;
//    private FieldDataTypeInterface dataType;

    public ConstantValueParamItem(String tableAlis, String columnItem, T value) {
        super(tableAlis, columnItem, SQLUtils.guessType(value));
        this.value = value;
//        this.dataType= SQLUtils.guessType(value);
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public Expression asLogicalExpression(HasMainTable sql) {
        return asLogicalExpression(CommonOpType.eq,sql);
    }

    @Override
    public Expression asLogicalExpression(CommonOpType opType, HasMainTable sql) {
        return super.asLogicalExpression(opType,sql);
    }

    @Override
    public Expression asExpression(HasMainTable sql) {
        return SQLUtils.getConstantExpressionFromParam(value);
    }

    @Override
    public GenricExpression joinExpression(GenricExpression other, CommonOpType type) {
        return super.joinExpression(other,type);
    }


//    public FieldDataTypeInterface getDataType() {
//        return dataType;
//    }
//
//    public void setDataType(FieldDataTypeInterface dataType) {
//        this.dataType = dataType;
//    }
}
