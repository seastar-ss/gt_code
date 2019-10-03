package com.shawn.ss.lib.tools.sql_code_gen.api.impl;

import com.shawn.ss.lib.tools.CollectionHelper;
import com.shawn.ss.lib.tools.sql_code_gen.api.SQLInsert;
import net.sf.jsqlparser.expression.Alias;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.JdbcNamedParameter;
import net.sf.jsqlparser.expression.operators.relational.ExpressionList;
import net.sf.jsqlparser.expression.operators.relational.ItemsList;
import net.sf.jsqlparser.schema.Column;
import net.sf.jsqlparser.statement.common.*;
import net.sf.jsqlparser.statement.insert.Insert;

import java.util.List;

public class SQLInsertImpl extends SQLImpl<SQLInsert> implements SQLInsert {
    Insert insert;
    volatile  boolean batchHandled=false;
    private List<Expression> originExprList;

    public SQLInsertImpl() {
        super(SqlType.insert);
        insert = new Insert();
        originExprList=CollectionHelper.newList();
    }

    public SQLInsertImpl(Insert statement) {
        super(SqlType.insert);
        insert = statement;
        originExprList=CollectionHelper.newList();
        ItemsList itemsList = insert.getItemsList();
        List<Expression> exprList;
        if(itemsList==null){
            throw new IllegalArgumentException("insert contains no expressionlist ('values' part) ");
        }
        exprList = ((ExpressionList) itemsList).getExpressions();
        originExprList.addAll(exprList);
    }

    @Override
    public SQLInsert onDuplicateUpdateItem(String column, String expression) {
        if(column!=null) {
            List<Column> columns = insert.getDuplicateUpdateColumns();
            if (columns == null) {
                columns = CollectionHelper.newList();
            }
            List<Expression> expressionList = insert.getDuplicateUpdateExpressionList();
            if (expressionList == null) {
                expressionList = CollectionHelper.newList();
            }
            Expression expr = null;
            if (expression != null) {
                expr = getExpressionFromString(expression);
            } else {
                throw new IllegalArgumentException("onDuplicateUpdate need customer expression ");
            }
            columns.add(new Column(column));
            expressionList.add(expr);
            insert.setDuplicateUpdateColumns(columns);
            insert.setDuplicateUpdateExpressionList(expressionList);
        }
        return this;
    }

    @Override
    public SQLInsert modifyItem(String column, String expression) {

        return modifyItemImpl(column, expression);
    }

    @Override
    public SQLInsert modifyItem(String column) {
        return modifyItemImpl(column, null);
    }

    @Override
    public synchronized SQLInsert batchInsert(int batch) {

        if(batch<=1 || batch>5000){
            throw new IllegalArgumentException("insert batch size should be in range of 1 to 5000");
        }

        ItemsList itemsList = insert.getItemsList();
        if(itemsList==null){
            throw new IllegalStateException("insert with no insert item can't call batch method");
        }
        List<Expression> exprList=CollectionHelper.newList();
//        originExprList = ((ExpressionList) itemsList).getExpressions();
        if(CollectionHelper.isCollectionEmpty(originExprList)){
            throw new IllegalStateException("insert with no insert item can't call batch method");
        }

        for(int i=0;i<batch;++i){
            for(Expression item: originExprList){
                Expression newItem=item;
                if(item instanceof JdbcNamedParameter){
                    JdbcNamedParameter namedParameter = (JdbcNamedParameter) item;
                    newItem =new JdbcNamedParameter((namedParameter).getName()+"-"+i);
                }
                exprList.add(newItem);
            }
        }
        ((ExpressionList) itemsList).setExpressions(exprList);
        insert.setItemsList(itemsList);
        batchHandled=true;
        return this;
    }

    private SQLInsert modifyItemImpl(String column, String expression) {
        if(batchHandled){
            throw new IllegalStateException("insert can't change after call batchInsert");
        }
        if(column!=null) {
            insert.setUseValues(true);
            insert.setUseSet(false);
            Expression expr;
            if (expression != null) {
                expr = getExpressionFromString(expression);
            } else {
                expr = new JdbcNamedParameter(column);
            }
            List<Column> columns = insert.getColumns();
            if (columns == null) {
                columns = CollectionHelper.newList();
            }
            List<Expression> exprList;
            ItemsList itemsList = insert.getItemsList();
            if (itemsList == null) {
                itemsList = new ExpressionList();
                exprList = CollectionHelper.newList();
            } else {
                exprList = ((ExpressionList) itemsList).getExpressions();
            }
            columns.add(new Column(column));

            exprList.add(expr);
            originExprList.add(expr);
            ((ExpressionList) itemsList).setExpressions(exprList);
            insert.setColumns(columns);
            insert.setItemsList(itemsList);
        }
        return this;
    }

    @Override
    public SQLInsert removeAllModifyItem() {
        insert.removeAllColExpression();
        originExprList.clear();
        return this;
    }

    @Override
    public SQLInsert setIgnore(boolean ignore) {
        insert.setModifierIgnore(ignore);
        return this;
    }

    @Override
    protected HasWhere getWhereHandler() {
        return insert;
    }

    @Override
    protected HasMainTable getMainTableHandler() {
        return insert;
    }

    @Override
    protected HasColumnExpression getColumnExpressionHandler() {
        return insert;
    }

    @Override
    protected HasLimit getLimitHandler() {
        return insert;
    }

    @Override
    protected HasOrderBy getOrderByHandler() {
        return insert;
    }

    @Override
    public String getSql(String type) {
        return insert.toString();
    }
}
