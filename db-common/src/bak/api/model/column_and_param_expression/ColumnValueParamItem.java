package com.shawn.ss.lib.tools.service_assemble.api.bak.api.model.column_and_param_expression;

import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model.FieldDataTypeInterface;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model.CommonOpType;
import com.shawn.ss.lib.tools.service_assemble.api.bak.api.SQLBuilderException;
import com.shawn.ss.lib.tools.service_assemble.api.bak.api.SQLUtils;
import com.shawn.ss.lib.tools.sql_code_gen.api.model.GenricExpression;
import com.shawn.ss.lib.tools.sql_code_gen.api.model.LogicalExpression;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.JdbcNamedParameter;
import net.sf.jsqlparser.schema.Column;
import net.sf.jsqlparser.statement.HasMainTable;

/**
 * Created by ss on 2017/10/21.
 */
public class ColumnValueParamItem extends ParamItem implements LogicalExpression {
    String valueColumn;
    String valueColumnTable;
    private final EnumValueType valueType;

    public static enum EnumValueType {
        column, constant, param
    }

    public ColumnValueParamItem(String tableAlis, String columnItem, String valueColumnTable, String valueColumn, FieldDataTypeInterface type) {
        super(tableAlis, columnItem, type);
        this.valueColumn = valueColumn;
        this.valueColumnTable = valueColumnTable;
        this.valueType = EnumValueType.column;
    }

    public ColumnValueParamItem(String tableAlis, String columnItem, String valueColumnTable, String valueColumn, FieldDataTypeInterface type, EnumValueType valueType) {
        super(tableAlis, columnItem, type);
        this.valueColumn = valueColumn;
        this.valueColumnTable = valueColumnTable;
        this.valueType = valueType;
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
        return asLogicalExpression(CommonOpType.eq, sql);
    }

    @Override
    public Expression asLogicalExpression(CommonOpType opType, HasMainTable sql) {
        return super.asLogicalExpression(opType, sql);
    }

    @Override
    public Expression asExpression(HasMainTable sql) {
        switch (valueType) {
            case column:
                return new Column(SQLUtils.getTableForAlias(sql, getValueColumnTable()), getValueColumn());
            case param:
                return new JdbcNamedParameter(valueColumn);
            case constant:
                return SQLUtils.getConstantExpressionFromParamItem(valueColumn, type);
            default:
                return new Column(SQLUtils.getTableForAlias(sql, getValueColumnTable()), getValueColumn());
        }
    }

    @Override
    public GenricExpression joinExpression(GenricExpression other, CommonOpType type) {
        throw SQLBuilderException.unsupportException();
    }
}
