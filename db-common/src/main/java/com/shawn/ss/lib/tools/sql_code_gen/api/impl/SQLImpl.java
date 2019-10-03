package com.shawn.ss.lib.tools.sql_code_gen.api.impl;

import com.shawn.ss.lib.tools.CollectionHelper;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model.LogicalRelationshipType;
import com.shawn.ss.lib.tools.sql_code_gen.api.SQL;
import com.shawn.ss.lib.tools.sql_code_gen.api.SQLSelect;
import com.shawn.ss.lib.tools.sql_code_gen.api.expressions.Expr;
import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.expression.*;
import net.sf.jsqlparser.expression.operators.conditional.AndExpression;
import net.sf.jsqlparser.expression.operators.conditional.OrExpression;
import net.sf.jsqlparser.expression.operators.relational.EqualsTo;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.schema.Column;
import net.sf.jsqlparser.schema.Database;
import net.sf.jsqlparser.schema.Table;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.common.*;
import net.sf.jsqlparser.statement.delete.Delete;
import net.sf.jsqlparser.statement.insert.Insert;
import net.sf.jsqlparser.statement.select.*;
import net.sf.jsqlparser.statement.update.Update;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.List;

public abstract class SQLImpl<T extends SQL> {

    public static final String KEY_START="start",KEY_COUNT="count";

    public static <TT extends SQL> SQL<TT> parse(String sql) {
        try {
            Statement statement = null;
            try {
                statement = CCJSqlParserUtil.parse(sql);
            } catch (JSQLParserException e) {
                e.printStackTrace();
            }
            if(statement!=null) {
                if (statement instanceof Select) {
                    Select select = (Select) statement;
//                SelectBody body=null;
                    return (TT) new SQLSelectImpl((Select) statement);
                } else if ( statement instanceof Insert) {
                    return (TT) new SQLInsertImpl((Insert) statement);
                } else if ( statement instanceof Update) {
                    return (TT) new SQLUpdateImpl((Update) statement);
                } else if ( statement instanceof Delete) {
                    return (TT) new SQLDeleteImpl((Delete) statement);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    static final Logger L = LoggerFactory.getLogger(SQLImpl.class);

    protected final SQL.SqlType type;

    protected SQLImpl(SQL.SqlType type) {
        this.type = type;
    }

    protected abstract HasWhere getWhereHandler();

    protected abstract HasMainTable getMainTableHandler();

    protected abstract HasColumnExpression getColumnExpressionHandler();

    protected abstract HasLimit getLimitHandler();

    protected abstract HasOrderBy getOrderByHandler();

    protected Expression getExpressionFromString(String item) {
        Expression expression = null;
        try {
            expression = CCJSqlParserUtil.parseExpression(item, true);
        } catch (JSQLParserException e) {
            L.error("parse express [{}] has exception with msg {}, cause :{}", item, e.getMessage(), e.getCause());
            throw new IllegalArgumentException("expression [" + item + "] has errors");
        }
        return expression;
    }

    public T rawWhere(String where) {
        Expression expression = getExpressionFromString(where);
        if (expression != null) {
            HasWhere whereHandler = getWhereHandler();
            if (whereHandler != null)
                whereHandler.setWhere(expression);
        }
        return (T) this;
    }

    public T rawWhereItem(String expression) {
        return rawWhereItem(LogicalRelationshipType.and, expression);
    }

    public T rawWhereItem(LogicalRelationshipType type, String expression) {
        Expression expr = getExpressionFromString(expression);
        assembleWhere(type, expr);
        return (T) this;
    }

//    protected abstract Has getLimitHandler();

    public T itemWhere(String item) {
        return itemWhere(LogicalRelationshipType.and, null, null, item, item);
    }

    public T itemWhere(String item, String paramName) {
        return itemWhere(LogicalRelationshipType.and, null, null, item, paramName);
    }

    public T itemWhere(LogicalRelationshipType type, String item) {
        return itemWhere(type, null, null, item, item);
    }


    public T itemWhere(LogicalRelationshipType type, String item, String paramName) {
        return itemWhere(type, null, null, item, paramName);
    }

    public T itemWhere(LogicalRelationshipType type, String table, String item, String paramName) {
        return itemWhere(type, null, table, item, paramName);
    }

    public T itemWhere(LogicalRelationshipType type, String db, String table, String item, String paramName) {
        Expression e = buildColumnEqualToExp(db, table, item, paramName);
        assembleWhere(type, e);
        return (T) this;
    }


    public T itemCol(String item) {
        return itemCol(null, null, item, item);
    }


    public T itemCol(String item, String alias) {
        return itemCol(null, null, item, alias);
    }

    public T itemCol(String table, String item, String alias) {
        return itemCol(null, table, item, alias);
    }

    public T itemCol(String db, String table, String item, String alias) {
        String al = alias;
        if (al == null) {
            al = item;
        }
        Column column = buildColumn(db, table, item);

        HasColumnExpression columnExpression = getColumnExpressionHandler();
        if (columnExpression != null) {
            columnExpression.addColExpression(column, al);
        }
        return (T) this;
    }


    public T table(String table) {
        return table(null, table, table);
    }

    public T table(String db, String table) {
        return table(db, table, table);
    }

    public T table(String db, String table, String alias) {
        Table tb = buildTable(db, table);
        if (alias != null && type!= SQL.SqlType.insert) {
            tb.setAlias(new Alias(alias));
        }
        HasMainTable mainTable = getMainTableHandler();
        if (mainTable != null) {
            mainTable.setTable(tb);
        }
        return (T) this;
    }

//    public T table(String table, TableSplitStategy stategy) {
//        return table(null,table,stategy);
//    }
//
//    public T table(String db,String table, TableSplitStategy stategy) {
//
//        return (T)this;
//    }

    public T order(boolean asc, String item) {
        return order(asc, null, item);
    }

    public T order(boolean asc, String table, String item) {
        Column column = buildColumn(null, table, item);
        OrderByElement e = new OrderByElement();
        e.setAsc(asc);
        e.setExpression(column);

        addOrderExp(e);
        return (T) this;
    }


    public T rawOrder(boolean asc, String expression) {
        Expression expr = getExpressionFromString(expression);
        OrderByElement e = new OrderByElement();
        e.setAsc(asc);
        e.setExpression(expr);
        addOrderExp(e);
        return (T) this;
    }

    public T limit(boolean hasStart) {
        HasLimit limitHandler = getLimitHandler();
        if(limitHandler!=null){
            Limit limit=new Limit();
            if(hasStart){
                limit.setOffset(new JdbcNamedParameter(KEY_START));
            }
            limit.setOffset(new JdbcNamedParameter(KEY_COUNT));
            limitHandler.setLimit(limit);
        }
        return (T) this;
    }

    public T limit( Integer count) {
        return limit(null,count);
    }

    public T limit(Integer start, Integer count) {
        HasLimit limitHandler = getLimitHandler();
        if(limitHandler!=null) {
            Limit limit = new Limit();
            if(start!=null){
                limit.setOffset(new LongValue(start));
            }
            if(count!=null){
                limit.setRowCount(new LongValue(count));
                limitHandler.setLimit(limit);
            }
        }
        return (T) this;
    }

//    public T rawGroup(String expr) {
//        Expression expression = getExpressionFromString(expr);
//
//        return (T) this;
//    }
//
//    public T itemGroup(String item) {
//        return (T) this;
//    }
//
//    public T itemGroup(String... item) {
//        for(String i:item){
//            itemGroup(i);
//        }
//        return (T) this;
//    }

//    public abstract String getSql(String type) ;



    public List<String> tables() {
        HasMainTable tableHandler = getMainTableHandler();
        if(tableHandler!=null){
            Table table = tableHandler.getTable();
            if(table!=null){
                return Collections.singletonList(table.getFullyQualifiedName());
            }
        }
        return null;
    }

    public Expr wheres() {
        HasWhere whereHandler = getWhereHandler();
        if (whereHandler != null) {
            Expression where = whereHandler.getWhere();
            return new Expr(where);
        }
        return null;
    }

    public SQL.SqlType getType() {
        return type;
    }

    protected void addOrderExp(OrderByElement e) {
        HasOrderBy orderByHandler = getOrderByHandler();
        if (orderByHandler != null) {
            List<OrderByElement> orderByElements = orderByHandler.getOrderByElements();
            if (orderByElements == null) {
                orderByElements = CollectionHelper.newList();
            }
//            if (e instanceof OrderByElement)
                orderByElements.add(e);
            orderByHandler.setOrderByElements(orderByElements);
        }
    }

    protected Expression buildColumnEqualToExp(String db, String table, String item, String paramName) {
        Column n = buildColumn(db, table, item);
        EqualsTo e = new EqualsTo();
        e.setLeftExpression(n);
        e.setRightExpression(new JdbcNamedParameter(paramName));
        return e;
    }

    protected Column buildColumn(String db, String table, String item) {
        Table tb = buildTable(db, table);
        Column n = new Column();
        n.setColumnName(item);
        if (tb != null) {
            n.setTable(tb);
        }
        return n;
    }

    protected Expression buildWhere(LogicalRelationshipType type, Expression expr, Expression where) {
        Expression ret = null;
        if (type == LogicalRelationshipType.and) {
            ret = new AndExpression(where, expr);
        } else if (type == LogicalRelationshipType.or) {
            ret = new OrExpression(where, expr);
        }
        return ret;
    }

    protected void assembleWhere(LogicalRelationshipType type, Expression expr) {
        HasWhere whereHandler = getWhereHandler();
        if (whereHandler != null) {
            Expression where = whereHandler.getWhere();
            if (where == null) {
                where = expr;
            } else {
                where = buildWhere(type, expr, where);
            }
            whereHandler.setWhere(where);
        }
    }

    protected Table buildTable(String db, String table) {
        Table tb = null;
        if (table != null) {
            tb = new Table();
            tb.setName(table);
            if (db != null) {
                tb.setDatabase(new Database(db));
            }
        }
        return tb;
    }
}
