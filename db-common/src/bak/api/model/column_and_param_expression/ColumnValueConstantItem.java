package com.shawn.ss.lib.tools.service_assemble.api.bak.api.model.column_and_param_expression;

import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model.FieldDataTypeInterface;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model.CommonOpType;
import com.shawn.ss.lib.tools.service_assemble.api.bak.api.SQLBuilderException;
import com.shawn.ss.lib.tools.sql_code_gen.api.model.GenricExpression;
import com.shawn.ss.lib.tools.sql_code_gen.api.model.LogicalExpression;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.JdbcNamedParameter;
import net.sf.jsqlparser.statement.HasMainTable;

/**
 * Created by ss on 2017/10/21.
 */
public class ColumnValueConstantItem<T> extends ColumnValueParamItem implements LogicalExpression{
//    String valueColumn;
//    String valueColumnTable;

    public ColumnValueConstantItem(String tableAlis, String columnItem, String valueColumnParam, FieldDataTypeInterface type) {
        super(tableAlis, columnItem,null,valueColumnParam, type);

    }

    public String getValueColumn() {
        return valueColumn;
    }

    public void setValueColumn(String valueColumn) {
        this.valueColumn = valueColumn;
    }

    public String getValueColumnTable() {
        return valueColumnTable;
    }

    public void setValueColumnTable(String valueColumnTable) {
        this.valueColumnTable = valueColumnTable;
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
        return new JdbcNamedParameter(valueColumn);
    }

    @Override
    public GenricExpression joinExpression(GenricExpression other, CommonOpType type) {
        throw SQLBuilderException.unsupportException();
    }
}
