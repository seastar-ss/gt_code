package com.shawn.ss.lib.tools.service_assemble.api.bak.api.model.column_and_param_expression;

import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model.FieldDataTypeInterface;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model.CommonOpType;
import com.shawn.ss.lib.tools.sql_code_gen.api.model.GenricExpression;
import com.shawn.ss.lib.tools.sql_code_gen.api.model.LogicalExpression;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.JdbcNamedParameter;
import net.sf.jsqlparser.statement.HasMainTable;

/**
 * Created by ss on 2017/10/21.
 */
public class JDBCParamParamItem extends ParamItem implements LogicalExpression {
    String paramName;

    //        int valueType = PARAMETER_TYPE;

    public JDBCParamParamItem(String tableAlis, String columnItem, String paramName, FieldDataTypeInterface type) {
        super(tableAlis, columnItem, type);
        this.paramName = paramName;
        //            this.valueType = PARAMETER_TYPE;
    }


    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
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
        return new JdbcNamedParameter(paramName);
    }

    @Override
    public GenricExpression joinExpression(GenricExpression other, CommonOpType type) {
        return super.joinExpression(other,type);
    }
}
