package com.shawn.ss.lib.tools.service_assemble.api.bak.api.model.column_expression;

import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model.FieldDataTypeInterface;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model.CommonOpType;
import com.shawn.ss.lib.tools.service_assemble.api.bak.api.model.GenricExpression;

/**
 * Created by ss on 2017/10/22.
 */
public abstract class ColumnItem implements GenricExpression {
    protected FieldDataTypeInterface type;

    public ColumnItem() {

    }

    public ColumnItem(FieldDataTypeInterface type) {
        this.type = type;
    }

    public FieldDataTypeInterface getType() {
        return type;
    }

    public void setType(FieldDataTypeInterface type) {
        this.type = type;
    }

    @Override
    public GenricExpression joinExpression(GenricExpression other, CommonOpType type) {
        return new FunctionExpressionColumnItem(type, this, other);
//        return null;
    }
}
