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

import net.sf.jsqlparser.expression.BinaryExpression;
import net.sf.jsqlparser.expression.ExpressionVisitor;

public class LikeExpression extends BinaryExpression {

    private boolean not = false;
    private String escape = null;
    private boolean caseInsensitive = false;

    public boolean isNot() {
        return not;
    }

    public LikeExpression setNot(boolean b) {
        not = b;
        return this;
    }

    @Override
    public void accept(ExpressionVisitor expressionVisitor) {
        expressionVisitor.visit(this);
    }

    @Override
    public String getStringExpression() {
        return caseInsensitive ? "ILIKE" : "LIKE";
    }

    @Override
    public String toString() {
        String retval = getLeftExpression() + " " + (not ? "NOT " : "") + getStringExpression() + " " + getRightExpression();
        if (escape != null) {
            retval += " ESCAPE " + "'" + escape + "'";
        }

        return retval;
    }

    public String getEscape() {
        return escape;
    }

    public LikeExpression setEscape(String escape) {
        this.escape = escape;
        return this;
    }

    public boolean isCaseInsensitive() {
        return caseInsensitive;
    }

    public LikeExpression setCaseInsensitive(boolean caseInsensitive) {
        this.caseInsensitive = caseInsensitive;
        return this;
    }
}
