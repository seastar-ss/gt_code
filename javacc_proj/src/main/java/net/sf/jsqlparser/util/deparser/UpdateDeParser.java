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
import net.sf.jsqlparser.expression.ExpressionVisitorAdapter;
import net.sf.jsqlparser.schema.Column;
import net.sf.jsqlparser.statement.select.*;
import net.sf.jsqlparser.statement.update.Update;
import net.sf.jsqlparser.util.SelectUtils;

import java.util.Iterator;

public class UpdateDeParser implements OrderByVisitor {

    protected StringBuilder buffer = new StringBuilder();
    private ExpressionVisitor expressionVisitor = new ExpressionVisitorAdapter();
    private SelectVisitor selectVisitor = new SelectVisitorAdapter();

    public UpdateDeParser() {
    }

    public UpdateDeParser(ExpressionVisitor expressionVisitor, SelectVisitor selectVisitor, StringBuilder buffer) {
        this.buffer = buffer;
        this.expressionVisitor = expressionVisitor;
        this.selectVisitor = selectVisitor;
    }

    public StringBuilder getBuffer() {
        return buffer;
    }

    public void setBuffer(StringBuilder buffer) {
        this.buffer = buffer;
    }

    public void deParse(Update update) {
        buffer.append("UPDATE ").append(SelectUtils.getStringList(update.getTables(), true, false)).
                append(" SET ");

        if (!update.isUseSelect()) {
            for (int i = 0; i < update.getColumns().size(); i++) {
                Column column = update.getColumns().get(i);
                column.accept(expressionVisitor);

                buffer.append(" = ");

                Expression expression = update.getExpressions().get(i);
                expression.accept(expressionVisitor);
                if (i < update.getColumns().size() - 1) {
                    buffer.append(", ");
                }
            }
        } else {
            if (update.isUseColumnsBrackets()) {
                buffer.append("(");
            }
            for (int i = 0; i < update.getColumns().size(); i++) {
                if (i != 0) {
                    buffer.append(", ");
                }
                Column column = update.getColumns().get(i);
                column.accept(expressionVisitor);
            }
            if (update.isUseColumnsBrackets()) {
                buffer.append(")");
            }
            buffer.append(" = ");
            buffer.append("(");
            Select select = update.getSelect();
            select.getSelectBody().accept(selectVisitor);
            buffer.append(")");
        }

        if (update.getFromItem() != null) {
            buffer.append(" FROM ").append(update.getFromItem());
            if (update.getJoins() != null) {
                for (Join join : update.getJoins()) {
                    if (join.isSimple()) {
                        buffer.append(", ").append(join);
                    } else {
                        buffer.append(" ").append(join);
                    }
                }
            }
        }

        if (update.getWhere() != null) {
            buffer.append(" WHERE ");
            update.getWhere().accept(expressionVisitor);
        }
        if (update.getOrderByElements() != null) {
            new OrderByDeParser(expressionVisitor, buffer).deParse(update.getOrderByElements());
        }
        if (update.getLimit() != null) {
            new LimitDeparser(buffer).deParse(update.getLimit());
        }

        if (update.isReturningAllColumns()) {
            buffer.append(" RETURNING *");
        } else if (update.getReturningExpressionList() != null) {
            buffer.append(" RETURNING ");
            for (Iterator<SelectExpressionItem> iter = update.getReturningExpressionList().
                    iterator(); iter.hasNext(); ) {
                buffer.append(iter.next().toString());
                if (iter.hasNext()) {
                    buffer.append(", ");
                }
            }
        }
    }

    public ExpressionVisitor getExpressionVisitor() {
        return expressionVisitor;
    }

    public void setExpressionVisitor(ExpressionVisitor visitor) {
        expressionVisitor = visitor;
    }

    @Override
    public void visit(OrderByElement orderBy) {
        orderBy.getExpression().accept(expressionVisitor);
        if (!orderBy.isAsc()) {
            buffer.append(" DESC");
        } else if (orderBy.isAscDescPresent()) {
            buffer.append(" ASC");
        }
        if (orderBy.getNullOrdering() != null) {
            buffer.append(' ');
            buffer.
                    append(orderBy.getNullOrdering() == OrderByElement.NullOrdering.NULLS_FIRST ? "NULLS FIRST" : "NULLS LAST");
        }
    }
}
