package com.shawn.ss.lib.tools.service_assemble.api.bak.api.model.column_expression;

import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model.FieldDataTypeInterface;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model.CommonOpType;
import com.shawn.ss.lib.tools.service_assemble.api.bak.api.model.GenricExpression;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.JdbcNamedParameter;
import net.sf.jsqlparser.statement.HasMainTable;

/**
 * Created by ss on 2017/10/21.
 */
public class ParamValueColumnItem extends ColumnItem {


    private String paramName;

    public ParamValueColumnItem(String paramName) {
        super();

        this.paramName = paramName;
    }

    public ParamValueColumnItem(String tableAlis, String columnItem, FieldDataTypeInterface type) {
        super(type);
        this.paramName = paramName;
    }


    @Override
    public Expression asExpression(HasMainTable sql) {
        return new JdbcNamedParameter(paramName);
    }

    @Override
    public GenricExpression joinExpression(GenricExpression other, CommonOpType type) {
        return super.joinExpression(other, type);
    }
}
