package com.shawn.ss.lib.tools.service_assemble.api.bak.api.model.column_expression;

import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model.CommonOpType;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model.ColumnDataType;
import com.shawn.ss.lib.tools.service_assemble.api.bak.api.model.GenricExpression;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.schema.Column;
import net.sf.jsqlparser.statement.HasMainTable;

/**
 * Created by ss on 2017/10/21.
 */
public class ConstantReplaceStubColumnItem extends ColumnItem {
    //    String alias;
//    FieldDataTypeInterface sqlType;
    Integer value;
//    String tableAlis;
//    String columnItem;

    public ConstantReplaceStubColumnItem(Integer value) {
        super();
//        this.alias = alias;
        this.value = value;
        setType(ColumnDataType.intData);
    }


    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }


    @Override
    public Expression asExpression(HasMainTable sql) {
        return new Column(value+"="+value);
    }

    @Override
    public GenricExpression joinExpression(GenricExpression other, CommonOpType type) {
        return super.joinExpression(other, type);
    }
}
