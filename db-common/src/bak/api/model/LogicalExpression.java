package com.shawn.ss.lib.tools.service_assemble.api.bak.api.model;

import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model.CommonOpType;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.statement.HasMainTable;

public interface LogicalExpression extends GenricExpression{

    Expression asLogicalExpression(HasMainTable sql);

    Expression asLogicalExpression(CommonOpType opType,HasMainTable sql);

}
