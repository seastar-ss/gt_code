/*-
 * #%L
 * JSQLParser library
 * %%
 * Copyright (C) 2004 - 2019 JSQLParser
 * %%
 * Dual licensed under GNU LGPL 2.1 or Apache License 2.0
 * #L%
 */
package net.sf.jsqlparser.expression.operators.relational;

import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.ExpressionVisitor;
import net.sf.jsqlparser.parser.ASTNodeAccessImpl;

public class InExpression extends ASTNodeAccessImpl implements Expression, SupportsOldOracleJoinSyntax {

    private Expression leftExpression;
    private ItemsList leftItemsList;
    private ItemsList rightItemsList;
    private boolean not = false;

    private int oldOracleJoinSyntax = NO_ORACLE_JOIN;

    public InExpression() {
    }

    public InExpression(Expression leftExpression, ItemsList itemsList) {
        setLeftExpression(leftExpression);
        setRightItemsList(itemsList);
    }

    @Override
    public void setOldOracleJoinSyntax(int oldOracleJoinSyntax) {
        this.oldOracleJoinSyntax = oldOracleJoinSyntax;
        if (oldOracleJoinSyntax < 0 || oldOracleJoinSyntax > 1) {
            throw new IllegalArgumentException("unexpected join type for oracle found with IN (type=" + oldOracleJoinSyntax + ")");
        }
//        return this;
    }

    @Override
    public int getOldOracleJoinSyntax() {
        return oldOracleJoinSyntax;
    }

    public ItemsList getRightItemsList() {
        return rightItemsList;
    }

    public Expression getLeftExpression() {
        return leftExpression;
    }

    public final InExpression setRightItemsList(ItemsList list) {
        rightItemsList = list;
        return this;
    }

    public final InExpression setLeftExpression(Expression expression) {
        leftExpression = expression;
        return this;
    }

    public boolean isNot() {
        return not;
    }

    public InExpression setNot(boolean b) {
        not = b;
        return this;
    }

    public ItemsList getLeftItemsList() {
        return leftItemsList;
    }

    public InExpression setLeftItemsList(ItemsList leftItemsList) {
        this.leftItemsList = leftItemsList;
        return this;
    }

    @Override
    public void accept(ExpressionVisitor expressionVisitor) {
        expressionVisitor.visit(this);
//        return this;
    }

    private String getLeftExpressionString() {
        return leftExpression + (oldOracleJoinSyntax == ORACLE_JOIN_RIGHT ? "(+)" : "");
    }

    @Override
    public String toString() {
        return (leftExpression == null ? leftItemsList : getLeftExpressionString()) + " " + (not ? "NOT " : "") + "IN " + rightItemsList + "";
    }

    @Override
    public int getOraclePriorPosition() {
        return SupportsOldOracleJoinSyntax.NO_ORACLE_PRIOR;
    }

    @Override
    public void setOraclePriorPosition(int priorPosition) {
        if (priorPosition != SupportsOldOracleJoinSyntax.NO_ORACLE_PRIOR) {
            throw new IllegalArgumentException("unexpected prior for oracle found");
        }
    }
}
