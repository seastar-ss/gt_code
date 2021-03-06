/*-
 * #%L
 * JSQLParser library
 * %%
 * Copyright (C) 2004 - 2019 JSQLParser
 * %%
 * Dual licensed under GNU LGPL 2.1 or Apache License 2.0
 * #L%
 */
package net.sf.jsqlparser.util.deparser;

import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.ExpressionVisitor;
import net.sf.jsqlparser.expression.operators.relational.ExpressionList;
import net.sf.jsqlparser.statement.select.GroupByElement;

import java.util.Iterator;

public class GroupByDeParser {

    protected StringBuilder buffer;
    private ExpressionVisitor expressionVisitor;

    GroupByDeParser() {
    }

    public GroupByDeParser(ExpressionVisitor expressionVisitor, StringBuilder buffer) {
        this.expressionVisitor = expressionVisitor;
        this.buffer = buffer;
    }

    public void deParse(GroupByElement groupBy) {
        buffer.append("GROUP BY ");
        for (Iterator<Expression> iter = groupBy.getGroupByExpressions().iterator(); iter.hasNext(); ) {
            iter.next().accept(expressionVisitor);
            if (iter.hasNext()) {
                buffer.append(", ");
            }
        }
        if (groupBy.getGroupingSets().size() > 0) {
            buffer.append("GROUPING SETS (");
            boolean first = true;
            for (Object o : groupBy.getGroupingSets()) {
                if (first) {
                    first = false;
                } else {
                    buffer.append(", ");
                }
                if (o instanceof Expression) {
                    buffer.append(o.toString());
                } else if (o instanceof ExpressionList) {
                    ExpressionList list = (ExpressionList) o;
                    buffer.append(list.getExpressions() == null ? "()" : list.toString());
                }
            }
            buffer.append(")");
        }
    }

    void setExpressionVisitor(ExpressionVisitor expressionVisitor) {
        this.expressionVisitor = expressionVisitor;
    }

    void setBuffer(StringBuilder buffer) {
        this.buffer = buffer;
    }
}
