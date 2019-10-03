/*-
 * #%L
 * JSQLParser library
 * %%
 * Copyright (C) 2004 - 2019 JSQLParser
 * %%
 * Dual licensed under GNU LGPL 2.1 or Apache License 2.0
 * #L%
 */
package net.sf.jsqlparser.statement.select;

import net.sf.jsqlparser.expression.Alias;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.OracleHierarchicalExpression;
import net.sf.jsqlparser.expression.OracleHint;
import net.sf.jsqlparser.parser.ASTNodeAccessImpl;
import net.sf.jsqlparser.schema.Column;
import net.sf.jsqlparser.schema.Table;
import net.sf.jsqlparser.statement.common.HasColumnExpression;
import net.sf.jsqlparser.statement.common.HasLimit;
import net.sf.jsqlparser.statement.common.HasMainTable;
import net.sf.jsqlparser.statement.common.HasWhere;
import net.sf.jsqlparser.util.SelectUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class PlainSelect extends ASTNodeAccessImpl implements SelectBody, HasWhere, HasMainTable, HasLimit,
        net.sf.jsqlparser.statement.common.HasOrderBy, HasColumnExpression {

    private Distinct distinct = null;
    private List<SelectItem> selectItems;
    private List<Table> intoTables;
    private FromItem fromItem;
    private List<Join> joins;
    private Expression where;
    private GroupByElement groupBy;
    private List<OrderByElement> orderByElements;
    private Expression having;
    private Limit limit;
    private Offset offset;
    private Fetch fetch;
    private OptimizeFor optimizeFor;
    private Skip skip;
    private First first;
    private Top top;
    private OracleHierarchicalExpression oracleHierarchical = null;
    private OracleHint oracleHint = null;
    private boolean oracleSiblings = false;
    private boolean forUpdate = false;
    private Table forUpdateTable = null;
    private boolean useBrackets = false;
    private Wait wait;
    private boolean mySqlSqlCalcFoundRows = false;
    private boolean sqlNoCacheFlag = false;
    private String forXmlPath;
    private KSQLWindow ksqlWindow = null;

    public boolean isUseBrackets() {
        return useBrackets;
    }

    public void setUseBrackets(boolean useBrackets) {
        this.useBrackets = useBrackets;
    }

    public FromItem getFromItem() {
        return fromItem;
    }

    public List<Table> getIntoTables() {
        return intoTables;
    }

    public List<SelectItem> getSelectItems() {
        return selectItems;
    }

    @Override
    public Expression getWhere() {
        return where;
    }

    public void setFromItem(FromItem item) {
        fromItem = item;
    }

    public void setIntoTables(List<Table> intoTables) {
        this.intoTables = intoTables;
    }

    public void setSelectItems(List<SelectItem> list) {
        selectItems = list;
    }

    public void addSelectItems(SelectItem... items) {
        if (selectItems == null) {
            selectItems = new ArrayList<SelectItem>();
        }
        Collections.addAll(selectItems, items);
    }

    @Override
    public void setWhere(Expression where) {
        this.where = where;
    }

    /**
     * The list of {@link Join}s
     *
     * @return the list of {@link Join}s
     */
    public List<Join> getJoins() {
        return joins;
    }

    public void setJoins(List<Join> list) {
        joins = list;
    }

    @Override
    public void accept(SelectVisitor selectVisitor) {
        selectVisitor.visit(this);
    }

    @Override
    public List<OrderByElement> getOrderByElements() {
        return orderByElements;
    }

    @Override
    public void setOrderByElements(List<OrderByElement> orderByElements) {
        this.orderByElements = orderByElements;
    }

    public Limit getLimit() {
        return limit;
    }

    public void setLimit(Limit limit) {
        this.limit = limit;
    }

    public Offset getOffset() {
        return offset;
    }

    public void setOffset(Offset offset) {
        this.offset = offset;
    }

    public Fetch getFetch() {
        return fetch;
    }

    public void setFetch(Fetch fetch) {
        this.fetch = fetch;
    }

    public OptimizeFor getOptimizeFor() {
        return optimizeFor;
    }

    public void setOptimizeFor(OptimizeFor optimizeFor) {
        this.optimizeFor = optimizeFor;
    }

    public Top getTop() {
        return top;
    }

    public void setTop(Top top) {
        this.top = top;
    }

    public Skip getSkip() {
        return skip;
    }

    public void setSkip(Skip skip) {
        this.skip = skip;
    }

    public First getFirst() {
        return first;
    }

    public void setFirst(First first) {
        this.first = first;
    }

    public Distinct getDistinct() {
        return distinct;
    }

    public void setDistinct(Distinct distinct) {
        this.distinct = distinct;
    }

    public Expression getHaving() {
        return having;
    }

    public void setHaving(Expression expression) {
        having = expression;
    }

    /**
     * A list of {@link Expression}s of the GROUP BY clause. It is null in case there is no GROUP BY
     * clause
     *
     * @return a list of {@link Expression}s
     */
    public GroupByElement getGroupBy() {
        return this.groupBy;
    }

    public void setGroupByElement(GroupByElement groupBy) {
        this.groupBy = groupBy;
    }

    public void addGroupByColumnReference(Expression expr) {
        if (groupBy == null) {
            groupBy = new GroupByElement();
        }
        groupBy.addGroupByExpression(expr);
    }

    public OracleHierarchicalExpression getOracleHierarchical() {
        return oracleHierarchical;
    }

    public void setOracleHierarchical(OracleHierarchicalExpression oracleHierarchical) {
        this.oracleHierarchical = oracleHierarchical;
    }

    public boolean isOracleSiblings() {
        return oracleSiblings;
    }

    public void setOracleSiblings(boolean oracleSiblings) {
        this.oracleSiblings = oracleSiblings;
    }

    public boolean isForUpdate() {
        return forUpdate;
    }

    public void setForUpdate(boolean forUpdate) {
        this.forUpdate = forUpdate;
    }

    public Table getForUpdateTable() {
        return forUpdateTable;
    }

    public void setForUpdateTable(Table forUpdateTable) {
        this.forUpdateTable = forUpdateTable;
    }

    public OracleHint getOracleHint() {
        return oracleHint;
    }

    public void setOracleHint(OracleHint oracleHint) {
        this.oracleHint = oracleHint;
    }

    /**
     * Sets the {@link Wait} for this SELECT
     *
     * @param wait the {@link Wait} for this SELECT
     */
    public void setWait(final Wait wait) {
        this.wait = wait;
    }

    /**
     * Returns the value of the {@link Wait} set for this SELECT
     *
     * @return the value of the {@link Wait} set for this SELECT
     */
    public Wait getWait() {
        return wait;
    }

    public String getForXmlPath() {
        return forXmlPath;
    }

    public void setForXmlPath(String forXmlPath) {
        this.forXmlPath = forXmlPath;
    }

    public KSQLWindow getKsqlWindow() {
        return ksqlWindow;
    }

    public void setKsqlWindow(KSQLWindow ksqlWindow) {
        this.ksqlWindow = ksqlWindow;
    }

    @Override
    public String toString() {
        StringBuilder sql = new StringBuilder();
        if (useBrackets) {
            sql.append("(");
        }
        sql.append("SELECT ");

        if (oracleHint != null) {
            sql.append(oracleHint).append(" ");
        }

        if (skip != null) {
            sql.append(skip).append(" ");
        }

        if (first != null) {
            sql.append(first).append(" ");
        }

        if (distinct != null) {
            sql.append(distinct).append(" ");
        }
        if (top != null) {
            sql.append(top).append(" ");
        }
        if (sqlNoCacheFlag) {
            sql.append("SQL_NO_CACHE").append(" ");
        }
        if (mySqlSqlCalcFoundRows) {
            sql.append("SQL_CALC_FOUND_ROWS").append(" ");
        }
        sql.append(getStringList(selectItems));

        if (intoTables != null) {
            sql.append(" INTO ");
            for (Iterator<Table> iter = intoTables.iterator(); iter.hasNext(); ) {
                sql.append(iter.next().toString());
                if (iter.hasNext()) {
                    sql.append(", ");
                }
            }
        }

        if (fromItem != null) {
            sql.append(" FROM ").append(fromItem);
            if (joins != null) {
                Iterator<Join> it = joins.iterator();
                while (it.hasNext()) {
                    Join join = it.next();
                    if (join.isSimple()) {
                        sql.append(", ").append(join);
                    } else {
                        sql.append(" ").append(join);
                    }
                }
            }

            if (ksqlWindow != null) {
                sql.append(" WINDOW ").append(ksqlWindow.toString());
            }
            if (where != null) {
                sql.append(" WHERE ").append(where);
            }
            if (oracleHierarchical != null) {
                sql.append(oracleHierarchical.toString());
            }
            if (groupBy != null) {
                sql.append(" ").append(groupBy.toString());
            }
            if (having != null) {
                sql.append(" HAVING ").append(having);
            }
            sql.append(orderByToString(oracleSiblings, orderByElements));
            if (limit != null) {
                sql.append(limit);
            }
            if (offset != null) {
                sql.append(offset);
            }
            if (fetch != null) {
                sql.append(fetch);
            }
            if (isForUpdate()) {
                sql.append(" FOR UPDATE");

                if (forUpdateTable != null) {
                    sql.append(" OF ").append(forUpdateTable);
                }

                if (wait != null) {
                    // Wait's toString will do the formatting for us
                    sql.append(wait);
                }
            }
            if (optimizeFor != null) {
                sql.append(optimizeFor);
            }
        } else {
            //without from
            if (where != null) {
                sql.append(" WHERE ").append(where);
            }
        }
        if (forXmlPath != null) {
            sql.append(" FOR XML PATH(").append(forXmlPath).append(")");
        }
        if (useBrackets) {
            sql.append(")");
        }
        return sql.toString();
    }

    public static String orderByToString(List<OrderByElement> orderByElements) {
        return orderByToString(false, orderByElements);
    }

    public static String orderByToString(boolean oracleSiblings, List<OrderByElement> orderByElements) {
        return getFormatedList(orderByElements, oracleSiblings ? "ORDER SIBLINGS BY" : "ORDER BY");
    }

    public static String getFormatedList(List<?> list, String expression) {
        return getFormatedList(list, expression, true, false);
    }

    public static String getFormatedList(List<?> list, String expression, boolean useComma, boolean useBrackets) {
        String sql = SelectUtils.getStringList(list, useComma, useBrackets);

        if (sql.length() > 0) {
            if (expression.length() > 0) {
                sql = " " + expression + " " + sql;
            } else {
                sql = " " + sql;
            }
        }

        return sql;
    }

    /**
     * List the toString out put of the objects in the List comma separated. If the List is null or
     * empty an empty string is returned.
     * <p>
     * The same as getStringList(list, true, false)
     *
     * @param list list of objects with toString methods
     * @return comma separated list of the elements in the list
     * @see SelectUtils#getStringList(List, boolean, boolean)
     */
    public static String getStringList(List<?> list) {
        return SelectUtils.getStringList(list, true, false);
    }

    public void setMySqlSqlCalcFoundRows(boolean mySqlCalcFoundRows) {
        this.mySqlSqlCalcFoundRows = mySqlCalcFoundRows;
    }

    public void setMySqlSqlNoCache(boolean sqlNoCacheFlagSet) {
        this.sqlNoCacheFlag = sqlNoCacheFlagSet;
    }

    public boolean getMySqlSqlCalcFoundRows() {
        return this.mySqlSqlCalcFoundRows;
    }

    public boolean getMySqlSqlNoCache() {
        return this.sqlNoCacheFlag;
    }

    @Override
    public Table getTable() {
        if (fromItem instanceof Table) {
            return (Table) fromItem;
        }
        return null;
    }

    @Override
    public void setTable(Table name) {
        setFromItem(name);
    }

    @Override
    public boolean addColExpression(Table table, String column, String alias) {
        String al=alias;
        if (al == null) {
            al = column;
        }
        selectItems.add(new SelectExpressionItem().setAlias(new Alias(al)).setExpression(new Column(table, column)));
        return true;
    }

    @Override
    public boolean addColExpression(Column column, String alias) {
        String al=alias;

        if (al == null) {
            al = column.getColumnName();
        }
        //selectItems.add(new SelectExpressionItem().setAlias(new Alias(al)).setExpression(column));
        addSelectItems(new SelectExpressionItem().setAlias(new Alias(al)).setExpression(column));
        return true;
    }

    @Override
    public int removeAllColExpression() {
        int size = selectItems.size();
        selectItems.clear();
        return size;
    }
}
