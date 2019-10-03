/*-
 * #%L
 * JSQLParser library
 * %%
 * Copyright (C) 2004 - 2019 JSQLParser
 * %%
 * Dual licensed under GNU LGPL 2.1 or Apache License 2.0
 * #L%
 */
package net.sf.jsqlparser.statement.update;

import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.JdbcNamedParameter;
import net.sf.jsqlparser.schema.Column;
import net.sf.jsqlparser.schema.Table;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.StatementVisitor;
import net.sf.jsqlparser.statement.common.HasColumnExpression;
import net.sf.jsqlparser.statement.common.HasMainTable;
import net.sf.jsqlparser.statement.common.HasOrderBy;
import net.sf.jsqlparser.statement.common.HasWhere;
import net.sf.jsqlparser.statement.select.*;
import net.sf.jsqlparser.util.SelectUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Update implements Statement, HasWhere, HasMainTable, net.sf.jsqlparser.statement.common.HasLimit, HasOrderBy, HasColumnExpression {

    private List<Table> tables;
    private Expression where;
    private List<Column> columns;
    private List<Expression> expressions;
    private FromItem fromItem;
    private List<Join> joins;
    private Select select;
    private boolean useColumnsBrackets = true;
    private boolean useSelect = false;
    private List<OrderByElement> orderByElements;
    private Limit limit;
    private boolean returningAllColumns = false;
    private List<SelectExpressionItem> returningExpressionList = null;

    @Override
    public void accept(StatementVisitor statementVisitor) {
        statementVisitor.visit(this);
    }

    public List<Table> getTables() {
        return tables;
    }

    public Expression getWhere() {
        return where;
    }

    public void setTables(List<Table> list) {
        tables = list;
    }

    public void setWhere(Expression expression) {
        where = expression;
    }

    public List<Column> getColumns() {
        return columns;
    }

    public List<Expression> getExpressions() {
        return expressions;
    }

    public void setColumns(List<Column> list) {
        columns = list;
    }

    public void setExpressions(List<Expression> list) {
        expressions = list;
    }

    public FromItem getFromItem() {
        return fromItem;
    }

    public void setFromItem(FromItem fromItem) {
        this.fromItem = fromItem;
    }

    public List<Join> getJoins() {
        return joins;
    }

    public void setJoins(List<Join> joins) {
        this.joins = joins;
    }

    public Select getSelect() {
        return select;
    }

    public void setSelect(Select select) {
        this.select = select;
    }

    public boolean isUseColumnsBrackets() {
        return useColumnsBrackets;
    }

    public void setUseColumnsBrackets(boolean useColumnsBrackets) {
        this.useColumnsBrackets = useColumnsBrackets;
    }

    public boolean isUseSelect() {
        return useSelect;
    }

    public void setUseSelect(boolean useSelect) {
        this.useSelect = useSelect;
    }

    public void setOrderByElements(List<OrderByElement> orderByElements) {
        this.orderByElements = orderByElements;
    }

    @Override
    public void setLimit(Limit limit) {
        this.limit = limit;
    }

    public List<OrderByElement> getOrderByElements() {
        return orderByElements;
    }

    @Override
    public Limit getLimit() {
        return limit;
    }

    public boolean isReturningAllColumns() {
        return returningAllColumns;
    }

    public void setReturningAllColumns(boolean returningAllColumns) {
        this.returningAllColumns = returningAllColumns;
    }

    public List<SelectExpressionItem> getReturningExpressionList() {
        return returningExpressionList;
    }

    public void setReturningExpressionList(List<SelectExpressionItem> returningExpressionList) {
        this.returningExpressionList = returningExpressionList;
    }

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder("UPDATE ");
        b.append(SelectUtils.getStringList(getTables(), true, false)).append(" SET ");

        if (!useSelect) {
            for (int i = 0; i < getColumns().size(); i++) {
                if (i != 0) {
                    b.append(", ");
                }
                b.append(columns.get(i)).append(" = ");
                b.append(expressions.get(i));
            }
        } else {
            if (useColumnsBrackets) {
                b.append("(");
            }
            for (int i = 0; i < getColumns().size(); i++) {
                if (i != 0) {
                    b.append(", ");
                }
                b.append(columns.get(i));
            }
            if (useColumnsBrackets) {
                b.append(")");
            }
            b.append(" = ");
            b.append("(").append(select).append(")");
        }

        if (fromItem != null) {
            b.append(" FROM ").append(fromItem);
            if (joins != null) {
                for (Join join : joins) {
                    if (join.isSimple()) {
                        b.append(", ").append(join);
                    } else {
                        b.append(" ").append(join);
                    }
                }
            }
        }

        if (where != null) {
            b.append(" WHERE ");
            b.append(where);
        }
        if (orderByElements != null) {
            b.append(PlainSelect.orderByToString(orderByElements));
        }
        if (limit != null) {
            b.append(limit);
        }

        if (isReturningAllColumns()) {
            b.append(" RETURNING *");
        } else if (getReturningExpressionList() != null) {
            b.append(" RETURNING ").append(SelectUtils.
                    getStringList(getReturningExpressionList(), true, false));
        }

        return b.toString();
    }

    @Override
    public Table getTable() {
        if (tables != null && tables.size() == 1) {
            return tables.get(0);
        }
        return null;
    }

    @Override
    public void setTable(Table name) {
        setTables(Collections.singletonList(name));
    }

    @Override
    public boolean addColExpression(Table table, String column, String alias) {
        String al = alias;
        if (al == null) {
            al = column;
        }
        checkColumn();
        columns.add(new Column(table, column));
        expressions.add(new JdbcNamedParameter(al));
        return true;
    }

    private void checkColumn() {
        if(columns==null){
            columns=new ArrayList<>();
        }
        if(expressions==null){
            expressions=new ArrayList<>();
        }
    }

    @Override
    public boolean addColExpression(Column column, String alias) {
        String al = alias;
        if (al == null) {
            al = column.getColumnName();
        }
        checkColumn();
        //selectItems.add(new SelectExpressionItem().setAlias(new Alias(alias)).setExpression(column));
        columns.add(column);
        expressions.add(new JdbcNamedParameter(al));
        return true;
    }

    @Override
    public int removeAllColExpression() {
        int size = 0;
        if (columns != null) {

            size = columns.size();
            columns.clear();
        }
        if (expressions != null)
            expressions.clear();
        return size;
    }
}
