package com.shawn.ss.lib.tools.service_assemble.api.bak.api.model;

import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model.CommonOpType;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.statement.HasMainTable;

public interface GenricExpression {

    Expression asExpression(HasMainTable sql);

    GenricExpression joinExpression(GenricExpression other, CommonOpType type);
}
