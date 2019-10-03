package com.shawn.ss.lib.tools.sql_code_gen.api.impl;

import com.shawn.ss.lib.tools.CollectionHelper;
import com.shawn.ss.lib.tools.sql_code_gen.api.SQLUpdate;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.JdbcNamedParameter;
import net.sf.jsqlparser.schema.Column;
import net.sf.jsqlparser.statement.common.*;
import net.sf.jsqlparser.statement.update.Update;

import java.util.List;

public class SQLUpdateImpl extends SQLImpl<SQLUpdate> implements SQLUpdate{

    Update update;

    public SQLUpdateImpl() {
        super(SqlType.update);
        update=new Update();
    }

    public SQLUpdateImpl(Update statement) {
        super(SqlType.update);
        update=statement;
    }

    @Override
    public SQLUpdate modifyItem(String column, String expression) {
        if(column!=null) {
            List<Column> columns = update.getColumns();
            if (columns == null) {
                columns = CollectionHelper.newList();
            }
            List<Expression> expressionList = update.getExpressions();
            if (expressionList == null) {
                expressionList = CollectionHelper.newList();
            }
            Expression expr = null;
            if (expression != null) {
                expr = getExpressionFromString(expression);
            } else {
                expr = new JdbcNamedParameter(column);
            }
            columns.add(new Column(column));
            expressionList.add(expr);
            update.setColumns(columns);
            update.setExpressions(expressionList);
        }
        return this;
    }

    @Override
    public SQLUpdate modifyItem(String column) {
        return modifyItem(column,null);
    }

    @Override
    public SQLUpdate removeAllModifyItem() {
        update.removeAllColExpression();
        return this;
    }

    @Override
    protected HasWhere getWhereHandler() {
        return update;
    }

    @Override
    protected HasMainTable getMainTableHandler() {
        return update;
    }

    @Override
    protected HasColumnExpression getColumnExpressionHandler() {
        return update;
    }

    @Override
    protected HasLimit getLimitHandler() {
        return update;
    }

    @Override
    protected HasOrderBy getOrderByHandler() {
        return update;
    }

    @Override
    public String getSql(String type) {
        return update.toString();
    }

//    @Override
//    public SQLUpdate rawWhereItem(LogicalRelationshipType type, String expression) {
//        return null;
//    }
//
//    @Override
//    public SQLUpdate itemWhere(LogicalRelationshipType type, String item) {
//        return null;
//    }
//
//    @Override
//    public SQLUpdate itemWhere(LogicalRelationshipType type, String item, String paramName) {
//        return null;
//    }
//
//    @Override
//    public SQLUpdate itemCol(String table, String item, String alias) {
//        return null;
//    }
//
//    @Override
//    public SQLUpdate table(String table, TableSplitStategy stategy) {
//        return null;
//    }
//
//    @Override
//    public SQLUpdate rawOrder(boolean asc, String expression) {
//        return null;
//    }
//
//    @Override
//    public SQLUpdate limit(Integer start, Integer count) {
//        return null;
//    }
}
