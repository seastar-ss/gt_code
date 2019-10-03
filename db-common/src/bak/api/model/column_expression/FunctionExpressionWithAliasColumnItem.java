package com.shawn.ss.lib.tools.service_assemble.api.bak.api.model.column_expression;

import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model.CommonOpType;
import com.shawn.ss.lib.tools.service_assemble.api.bak.api.model.GenricExpression;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.statement.HasAlias;
import net.sf.jsqlparser.statement.HasMainTable;

/**
 * Created by ss on 2017/10/21.
 */
public class FunctionExpressionWithAliasColumnItem extends FunctionExpressionColumnItem implements HasAlias {
    private String alias;

//    private Function function;

    public FunctionExpressionWithAliasColumnItem(String funcName, String alias) {
        super(funcName);
        this.alias = alias;
    }

    public FunctionExpressionWithAliasColumnItem(CommonOpType funcName, String alias) {
        super(funcName);
        this.alias = alias;
    }

    public String getAlias() {
        return alias;
    }

    public FunctionExpressionWithAliasColumnItem setAlias(String alias) {
        this.alias = alias;
        return this;
    }

//    @Override
//    public Expression asExpression(HasMainTable sql) {
//        return null;
//    }
//
//    @Override
//    public GenricExpression joinExpression(GenricExpression other, CommonOpType type) {
//        return null;
//    }

    //    protected Function getExpression() {
//        return function;
//    }
//
//    protected void setExpression(Function func) {
//        this.function = func;
//    }


}
