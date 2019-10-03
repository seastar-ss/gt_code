/*-
 * #%L
 * JSQLParser library
 * %%
 * Copyright (C) 2004 - 2019 JSQLParser
 * %%
 * Dual licensed under GNU LGPL 2.1 or Apache License 2.0
 * #L%
 */
package net.sf.jsqlparser.statement.insert;

import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.JdbcNamedParameter;
import net.sf.jsqlparser.expression.operators.relational.ExpressionList;
import net.sf.jsqlparser.expression.operators.relational.ItemsList;
import net.sf.jsqlparser.schema.Column;
import net.sf.jsqlparser.schema.Table;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.StatementVisitor;
import net.sf.jsqlparser.statement.common.HasColumnExpression;
import net.sf.jsqlparser.statement.common.HasLimit;
import net.sf.jsqlparser.statement.common.HasOrderBy;
import net.sf.jsqlparser.statement.common.HasWhere;
import net.sf.jsqlparser.statement.select.Limit;
import net.sf.jsqlparser.statement.select.OrderByElement;
import net.sf.jsqlparser.statement.select.Select;
import net.sf.jsqlparser.statement.select.SelectExpressionItem;
import net.sf.jsqlparser.util.SelectUtils;

import java.util.ArrayList;
import java.util.List;

public class Insert implements Statement, net.sf.jsqlparser.statement.common.HasMainTable, HasLimit, HasOrderBy, HasWhere, HasColumnExpression {

    private Table table;
    private List<Column> columns;
    private ItemsList itemsList;
    private boolean useValues = true;
    private Select select;
    private boolean useSelectBrackets = true;
    private boolean useDuplicate = false;
    private List<Column> duplicateUpdateColumns;
    private List<Expression> duplicateUpdateExpressionList;
    private InsertModifierPriority modifierPriority = null;
    private boolean modifierIgnore = false;

    private boolean returningAllColumns = false;

    private List<SelectExpressionItem> returningExpressionList = null;

    private boolean useSet = false;
    private List<Column> setColumns;
    private List<Expression> setExpressionList;

    @Override
    public void accept(StatementVisitor statementVisitor) {
        statementVisitor.visit(this);
    }

    @Override
    public Table getTable() {
        return table;
    }

    @Override
    public void setTable(Table name) {
        table = name;
    }

    public List<Column> getColumns() {
        return columns;
    }

    public void setColumns(List<Column> list) {
        columns = list;
    }

    /**
     * Get the values (as VALUES (...) or SELECT)
     *
     * @return the values of the insert
     */
    public ItemsList getItemsList() {
        return itemsList;
    }

    public void setItemsList(ItemsList list) {
        itemsList = list;
    }

    public boolean isUseValues() {
        return useValues;
    }

    public void setUseValues(boolean useValues) {
        this.useValues = useValues;
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

    public Select getSelect() {
        return select;
    }

    public void setSelect(Select select) {
        this.select = select;
    }

    public boolean isUseSelectBrackets() {
        return useSelectBrackets;
    }

    public void setUseSelectBrackets(boolean useSelectBrackets) {
        this.useSelectBrackets = useSelectBrackets;
    }

    public boolean isUseDuplicate() {
        return useDuplicate;
    }

    public void setUseDuplicate(boolean useDuplicate) {
        this.useDuplicate = useDuplicate;
    }

    public List<Column> getDuplicateUpdateColumns() {
        return duplicateUpdateColumns;
    }

    public void setDuplicateUpdateColumns(List<Column> duplicateUpdateColumns) {
        this.duplicateUpdateColumns = duplicateUpdateColumns;
    }

    public List<Expression> getDuplicateUpdateExpressionList() {
        return duplicateUpdateExpressionList;
    }

    public void setDuplicateUpdateExpressionList(List<Expression> duplicateUpdateExpressionList) {
        this.duplicateUpdateExpressionList = duplicateUpdateExpressionList;
    }

    public InsertModifierPriority getModifierPriority() {
        return modifierPriority;
    }

    public void setModifierPriority(InsertModifierPriority modifierPriority) {
        this.modifierPriority = modifierPriority;
    }

    public boolean isModifierIgnore() {
        return modifierIgnore;
    }

    public void setModifierIgnore(boolean modifierIgnore) {
        this.modifierIgnore = modifierIgnore;
    }

    public void setUseSet(boolean useSet) {
        this.useSet = useSet;
    }

    public boolean isUseSet() {
        return useSet;
    }

    public void setSetColumns(List<Column> setColumns) {
        this.setColumns = setColumns;
    }

    public List<Column> getSetColumns() {
        return setColumns;
    }

    public void setSetExpressionList(List<Expression> setExpressionList) {
        this.setExpressionList = setExpressionList;
    }

    public List<Expression> getSetExpressionList() {
        return setExpressionList;
    }

    @Override
    public String toString() {
        StringBuilder sql = new StringBuilder();

        sql.append("INSERT ");
        if (modifierPriority != null) {
            sql.append(modifierPriority.name()).append(" ");
        }
        if (modifierIgnore) {
            sql.append("IGNORE ");
        }
        sql.append("INTO ");
        sql.append(table).append(" ");
        if (columns != null) {
            sql.append(SelectUtils.getStringList(columns, true, true)).append(" ");
        }

        if (useValues) {
            sql.append("VALUES ");
        }

        if (itemsList != null) {
            sql.append(itemsList);
        } else {
            if (useSelectBrackets) {
                sql.append("(");
            }
            if (select != null) {
                sql.append(select);
            }
            if (useSelectBrackets) {
                sql.append(")");
            }
        }

        if (useSet) {
            sql.append("SET ");
            for (int i = 0; i < getSetColumns().size(); i++) {
                if (i != 0) {
                    sql.append(", ");
                }
                sql.append(setColumns.get(i)).append(" = ");
                sql.append(setExpressionList.get(i));
            }
        }

        if (useDuplicate) {
            sql.append(" ON DUPLICATE KEY UPDATE ");
            for (int i = 0; i < getDuplicateUpdateColumns().size(); i++) {
                if (i != 0) {
                    sql.append(", ");
                }
                sql.append(duplicateUpdateColumns.get(i)).append(" = ");
                sql.append(duplicateUpdateExpressionList.get(i));
            }
        }

        if (isReturningAllColumns()) {
            sql.append(" RETURNING *");
        } else if (getReturningExpressionList() != null) {
            sql.append(" RETURNING ").append(SelectUtils.
                    getStringList(getReturningExpressionList(), true, false));
        }

        return sql.toString();
    }

    @Override
    public void setLimit(Limit limit) {

    }

    @Override
    public Limit getLimit() {
        return null;
    }

    @Override
    public List<OrderByElement> getOrderByElements() {
        return null;
    }

    @Override
    public void setOrderByElements(List<OrderByElement> orderByElements) {

    }

    @Override
    public Expression getWhere() {
        return null;
    }

    @Override
    public void setWhere(Expression where) {

    }

    @Override
    public boolean addColExpression(Table table, String column, String alias) {
        String al = alias;
        if (al == null) {
            al = column;
        }
        checkColumn();
        columns.add(new Column(table, column));
//        ExpressionList list;
        addParam(al);
        return true;
    }

    private void checkColumn() {
        if(columns==null){
            columns=new ArrayList<>();
        }

    }

    @Override
    public boolean addColExpression(Column column, String alias) {
        String al = alias;
        if (al == null) {
            al = column.getColumnName();
        }
        //selectItems.add(new SelectExpressionItem().setAlias(new Alias(alias)).setExpression(column));
        checkColumn();
        columns.add(column);
        addParam(al);

        return true;
    }

    private void addParam(String alias) {
        ExpressionList list;
        List<Expression> expressions=null;
        if (itemsList == null) {
            list = new ExpressionList();


            itemsList = list;
        } else {
            if (itemsList instanceof ExpressionList) {
                list = (ExpressionList) itemsList;
            } else {
                throw new IllegalArgumentException("this insert instance can't use this method");
            }
        }
        expressions = list.getExpressions();
        if(expressions==null){
            expressions=new ArrayList<>();
            list.setExpressions(expressions);
        }
        if (list != null) {
            list.add(new JdbcNamedParameter(alias));
        }
    }

    @Override
    public int removeAllColExpression() {
        int size = columns.size();
        columns.clear();
        ExpressionList list;
        if (itemsList instanceof ExpressionList) {
            list = (ExpressionList) itemsList;
            list.clear();
        } else {
            throw new IllegalArgumentException("this insert instance can't use this method");
        }
        return size;
    }
}
