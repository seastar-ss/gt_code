package com.shawn.ss.lib.tools.service_assemble.api.bak.api.model.column_expression;

import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model.CommonOpType;
import com.shawn.ss.lib.tools.service_assemble.api.bak.api.SQLUtils;
import com.shawn.ss.lib.tools.service_assemble.api.bak.api.model.GenricExpression;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.statement.HasMainTable;

/**
 * Created by ss on 2017/10/21.
 */
public class ConstantValueColumnItem<T> extends ColumnItem {
    //    String alias;
//    FieldDataTypeInterface sqlType;
    T value;
//    String tableAlis;
//    String columnItem;

    public ConstantValueColumnItem(T value) {
        super();
//        this.alias = alias;
        this.value = value;
        setType(SQLUtils.guessType(value));
    }


    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }


    @Override
    public Expression asExpression(HasMainTable sql) {
        return SQLUtils.getConstantExpressionFromParam(value);
    }

    @Override
    public GenricExpression joinExpression(GenricExpression other, CommonOpType type) {
        return super.joinExpression(other, type);
    }
}
