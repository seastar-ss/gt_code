package com.shawn.ss.lib.tools.sql_code_gen.api.impl;

import com.shawn.ss.lib.tools.CollectionHelper;
import com.shawn.ss.lib.tools.sql_code_gen.api.SQLSelect;
import com.shawn.ss.lib.tools.sql_code_gen.api.expressions.Expr;
import net.sf.jsqlparser.expression.Alias;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.operators.conditional.AndExpression;
import net.sf.jsqlparser.expression.operators.relational.EqualsTo;
import net.sf.jsqlparser.schema.Column;
import net.sf.jsqlparser.schema.Table;
import net.sf.jsqlparser.statement.common.*;
import net.sf.jsqlparser.statement.select.*;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class SQLSelectImpl extends SQLImpl<SQLSelect> implements SQLSelect {
    Select select;
    SelectBody mainBody;
    PlainSelect operatableBody;

    AtomicInteger seq;

    public SQLSelectImpl() {
        super(SqlType.select);
        select = new Select();
        PlainSelect body = new PlainSelect();
        select.setSelectBody(body);
        mainBody = body;
        operatableBody = body;
        seq = new AtomicInteger(0);
    }

    public SQLSelectImpl(Select statement) {
        super(SqlType.select);

        select = statement;
        mainBody = select.getSelectBody();
        if (mainBody instanceof PlainSelect) {
            operatableBody = (PlainSelect) mainBody;
        } else if (mainBody instanceof SetOperationList) {
            SetOperationList body = (SetOperationList) this.mainBody;
            List<SelectBody> selects = body.getSelects();
            if(!CollectionHelper.isCollectionEmpty(selects)){
                //TODO : tree-structure travel
            }
        }

        seq = new AtomicInteger(0);
    }

    @Override
    public SQLSelect rawSelectItem(String item, String alias) {
        if (item != null) {
            Expression expression = getExpressionFromString(item);
            SelectExpressionItem it = new SelectExpressionItem();
            it.setExpression(expression);
            if (alias != null) {
                it.setAlias(new Alias(alias));
            }
            operatableBody.addSelectItems(it);
        }
//        operatableBody.get
        return this;
    }

    @Override
    public SQLSelect rawSelectItem(String item) {
        return rawSelectItem(item,"__item__"+seq.getAndIncrement());
    }

    @Override
    public SQLSelect rawHaving(String item) {
        if (item != null) {
            Expression expression = getExpressionFromString(item);
            operatableBody.setHaving(expression);
        }
        return this;
    }

    @Override
    public SQLSelect rawGroup(String item) {
        GroupByElement groupBy = operatableBody.getGroupBy();
        groupBy.addGroupByExpression(getExpressionFromString(item));
        operatableBody.setGroupByElement(groupBy);
        return this;
    }

    @Override
    public SQLSelect itemGroup(String item) {
        GroupByElement groupBy = operatableBody.getGroupBy();
        groupBy.addGroupByExpression(new Column(item));
        operatableBody.setGroupByElement(groupBy);
        return this;
    }

    @Override
    public Map<String, Expr> selectItems() {
        Map<String, Expr> ret = CollectionHelper.newMap();
        List<SelectItem> selectItems = operatableBody.getSelectItems();
        if (!CollectionHelper.isCollectionEmpty(selectItems)) {
            for (int i = 0, n = selectItems.size(); i < n; ++i) {
                SelectItem selectItem = selectItems.get(i);
                if (selectItem instanceof SelectExpressionItem) {
                    SelectExpressionItem item = (SelectExpressionItem) selectItem;
                    Alias alias = item.getAlias();
                    String name = alias == null ? String.valueOf(i) : alias.getName();
                    ret.put(name, new Expr(item.getExpression()));
                } else {
                    ret.put(String.valueOf(i), new Expr((AllColumns) selectItem));
                }
            }
        }
        return ret;
    }

    @Override
    public SQLSelect switchBody(int i) {
        throw new UnsupportedOperationException("not implemented");
    }

    @Override
    public List<SQLSelect> bodies() {
        throw new UnsupportedOperationException("not implemented");
    }

    @Override
    public SQLSelect body(SQLSelect body) {
        return this;
    }

    private List<Join> getJoin() {
        List<Join> joins = operatableBody.getJoins();
        if (joins == null) {
            joins = CollectionHelper.newList();
        }
        return joins;
    }

    @Override
    public SQLSelect join(String table, boolean inner, String condition) {
        joinExprImpl(null, table, inner, null, null, condition);
        return this;
    }

    @Override
    public SQLSelect joinByCol(String table, boolean inner, String thisCol, String otherCol, String extCondition) {
        joinExprImpl(null, table, inner, thisCol, otherCol, extCondition);
        return this;
    }

    @Override
    public SQLSelect join(SQLSelect body, boolean inner, String condition) {
        joinExprImpl(body, null, inner, null, null, condition);
        return this;
    }

    @Override
    public SQLSelect joinByCol(SQLSelect body, boolean inner, String thisCol, String otherCol, String extCondition) {
        joinExprImpl(body, null, inner, thisCol, otherCol, extCondition);
        return this;
    }


    private SQLSelect joinExprImpl(SQLSelect sqlSelect, String table, boolean inner, String thisCol, String otherCol, String extCondition) {
        List<Join> joins = getJoin();
        Table joinTable = null;
        FromItem item = null;
        if (sqlSelect == null && table != null) {
            joinTable = new Table(table);
            item = joinTable;
        } else if (sqlSelect instanceof SQLSelectImpl) {
            SubSelect subSelect = new SubSelect();
            subSelect.setSelectBody(((SQLSelectImpl) sqlSelect).mainBody);
            String name = table == null ? "t".concat(String.valueOf(joins.size())) : table;
            subSelect.setAlias(new Alias(name));
            item = subSelect;
        }
        Join j = new Join();
        if (inner)
            j.setInner(true);
        else
            j.setLeft(true);
        Expression expr;

        EqualsTo equalsTo = null;
        Expression expression = null;
        if (thisCol != null && otherCol != null) {
            equalsTo = new EqualsTo();
            equalsTo.setRightExpression(new Column(joinTable, otherCol));
            equalsTo.setLeftExpression(new Column(thisCol));
        }
        if (extCondition != null) {
            expression = getExpressionFromString(extCondition);
        }
        if (equalsTo != null && expression != null) {
            expr = new AndExpression(equalsTo, expression);
        } else if (equalsTo != null) {
            expr = equalsTo;
        } else if (expression != null) {
            expr = expression;
        } else {
            throw new IllegalStateException("join condition need to be provided");
        }
        j.setOnExpression(expr);
        j.setRightItem(item);
        joins.add(j);
        operatableBody.setJoins(joins);
        return this;
    }


    @Override
    public int removeAllSelectItem() {
        return ((HasColumnExpression) mainBody).removeAllColExpression();
    }

//    @Override
//    public int removeAllSelectItem() {
//        return 0;
//    }

    @Override
    protected HasWhere getWhereHandler() {
        return (HasWhere) mainBody;
    }

    @Override
    protected HasMainTable getMainTableHandler() {
        return (HasMainTable) mainBody;
    }

    @Override
    protected HasColumnExpression getColumnExpressionHandler() {
        return (HasColumnExpression) mainBody;
    }

    @Override
    protected HasLimit getLimitHandler() {
        return (HasLimit) mainBody;
    }

    @Override
    protected HasOrderBy getOrderByHandler() {
        return (HasOrderBy) mainBody;
    }

    @Override
    public String getSql(String type) {
        return select.toString();
    }
}
