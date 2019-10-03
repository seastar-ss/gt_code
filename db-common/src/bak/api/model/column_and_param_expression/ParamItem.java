package com.shawn.ss.lib.tools.service_assemble.api.bak.api.model.column_and_param_expression;

import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model.FieldDataTypeInterface;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model.CommonOpType;
import com.shawn.ss.lib.tools.service_assemble.api.bak.api.SQLUtils;
import com.shawn.ss.lib.tools.sql_code_gen.api.model.LogicalExpression;
import com.shawn.ss.lib.tools.sql_code_gen.api.model.OperationType;
import com.shawn.ss.lib.tools.sql_code_gen.api.model.column_expression.ColumnValueColumnItem;

import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.schema.Column;
import net.sf.jsqlparser.statement.HasMainTable;

/**
 * Created by ss on 2017/10/21.
 */
public abstract class ParamItem extends ColumnValueColumnItem implements LogicalExpression {

    //        public static final int FUNCTION_TYPE = 5, CONSTANT_FLOAT_NUM_TYPE = 4, CONSTANT_INT_NUM_TYPE = 3, CONSTANT_STR_TYPE = 2, PARAMETER_TYPE = 0, COLUMN_TYPE = 1;
//    String tableAlis;
//    String columnItem;
//    FieldDataTypeInterface type;


    public ParamItem(String tableAlis, String columnItem, FieldDataTypeInterface type) {
        super(tableAlis, columnItem, type);
//        setTableAlis(tableAlis);
//        setType(type);
//        setColumnItem(columnItem);
    }

    public Column getColumnExpression(HasMainTable sql) {
        return new Column(SQLUtils.getTableForAlias(sql, this.getTableAlis()), this.getColumnItem());
    }

    @Override
    public Expression asLogicalExpression(CommonOpType opType, HasMainTable sql) {
        Column columnExpression = this.getColumnExpression(sql);
        Expression expression = this.asExpression(sql);
        OperationType exp = SQLUtils.getExp(opType);

        if (exp == null) {
            return null;
        }
        if (exp == OperationType.isNull || exp == OperationType.isNotNull) {
            return exp.getExpression(columnExpression);
        } else if (exp == OperationType.in || exp == OperationType.notIn) {
            return exp.getExpression(columnExpression, new Expression[]{expression});
        } else {
            return exp.getExpression(columnExpression, expression);
        }

    }

//    public String getTableAlis() {
//        return tableAlis;
//    }
//
//    public void setTableAlis(String tableAlis) {
//        this.tableAlis = tableAlis;
//    }
//
//    public String getColumnItem() {
//        return columnItem;
//    }
//
//    public void setColumnItem(String columnItem) {
//        this.columnItem = columnItem;
//    }
//
//    public FieldDataTypeInterface getType() {
//        return type;
//    }
//
//    public void setType(FieldDataTypeInterface type) {
//        this.type = type;
//    }
}
