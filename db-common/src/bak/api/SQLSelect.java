package com.shawn.ss.lib.tools.service_assemble.api.bak.api;

import com.shawn.ss.lib.tools.CollectionHelper;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model.FieldDataTypeInterface;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model.CommonOpType;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model.LogicalOpType;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model.LogicalRelationshipType;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.factory.Config;
import com.shawn.ss.lib.tools.sql_code_gen.api.model.*;
import com.shawn.ss.lib.tools.sql_code_gen.api.model.column_and_param_expression.*;
import com.shawn.ss.lib.tools.sql_code_gen.api.model.column_expression.*;
import net.sf.jsqlparser.expression.Alias;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.schema.Column;
import net.sf.jsqlparser.schema.Table;
import net.sf.jsqlparser.statement.*;
import net.sf.jsqlparser.statement.select.*;

import java.util.List;
import java.util.Set;

public class SQLSelect<T extends SQLSelect> extends SQL<T> {

//    public static final NamedCommonEntry.NamedCommonEntryBuilder<String,String> itemBuilder=NamedCommonEntry.<String,String>newBuilder("field","alis");
//    public static final NamedCommonEntry.NamedCommonEntryBuilder<String,String> orderItemBuilder=NamedCommonEntry.<String,String>newBuilder("tableAlis","field"),
//            groupItemBuilder=orderItemBuilder;
//    public static final NamedTripleEntry.NamedTripleEntryBuilder<String,String,String> itemTBuilder=
//            NamedTripleEntry.<String,String,String>newBuilder("tableAlis","field","alis");
//    public static final NamedTripleEntry.NamedTripleEntryBuilder<String,String,String> joinTableBuilder=mainTableBuilder;

    Select select;
    SelectBody body;

//    SqlHelper whereHelper;


    protected SQLSelect(Select select) {
        super(SqlType.select);
        this.select = select;
        SelectBody selectBody = this.select.getSelectBody();
        if (selectBody instanceof PlainSelect) {
            this.body = selectBody;
            setMainTB(this.body);
        } else {
//            throw SQLBuilderException.newNotImplementException();
        }
    }

    protected SQLSelect() {
        super(SqlType.select);
        init();
//        whereHelper = new SqlHelper(this);
    }

    protected SQLSelect(SelectBody body) {
        super(SqlType.select);
        if (body instanceof PlainSelect) {
            select = new Select();
            select.setSelectBody(body);
            this.body = body;
        } else if (body instanceof SetOperationList) {

        }
    }

    protected void init() {
        select = new Select();
        body = new PlainSelect();
        select.setSelectBody(body);
    }

    @Override
    protected HasWhereClause getWhereBase() {
//        Expression where = body.getWhere();
//        if(where==null){
//            where=new NoodExpression();
//        }
        return body;
    }

    @Override
    public HasOrderClause getOrderBase() {
        return body;
    }

    @Override
    public HasLimitClause getLimitBase() {
        return body;
    }

    @Override
    public HasMainTable getMainTableHandler() {
        return body;
    }

    @Override
    public String getSql(Config.LibType type) {
        String sql = select.toString();
        if (replacement.size() > 0) {
            sql = doReplacement(sql, replacement);
        }
        return sql;
    }

//    @Override
//    public SQLSelect parseSql(String sql, Config.LibType unionRelations) {
//        return this;
//    }


    @Override
    public T rawItem(String item) {
        return (T) super.rawItem(item);
    }

    @Override
    public T items(ColumnItem... items) {
        PlainSelect body = (PlainSelect) this.body;
        if (items != null && items.length > 0) {
            List<SelectItem> selectItems = body.getSelectItems();
            if (selectItems == null) {
                selectItems = CollectionHelper.newList();
            }
            for (ColumnItem item : items) {
                Expression expression = item.asExpression(this);
                SelectExpressionItem expr = new SelectExpressionItem(expression);
                if (item instanceof HasAlias) {
                    String itemAlis = ((HasAlias) item).getAlias();
                    expr.setAlias(new Alias(itemAlis));
                }
                selectItems.add(expr);
//                if (item instanceof ColumnValueColumnItem) {
//                    ColumnValueColumnItem it = (ColumnValueColumnItem) item;
//                    Table tb = SQLUtils.getTableForAlias(this, it.getTableAlis());
//                    Column c = new Column(tb, it.getColumnItem());
//                    SelectExpressionItem expr = new SelectExpressionItem(c);
//                    if (it instanceof ColumnValueWithAlisColumnItem) {
//                        String itemAlis = ((ColumnValueWithAlisColumnItem) it).getAlias();
//                        expr.setAlias(new Alias(itemAlis));
//                    }
//                    selectItems.add(expr);
//                } else if (item instanceof ConstantValueColumnItem) {
//                    ConstantValueColumnItem it = (ConstantValueColumnItem) item;
//                    Expression expression = SQLUtils.getConstantExpressionFromParam(it.getValue());
//                    SelectExpressionItem expr = new SelectExpressionItem(expression);
//                    if (it instanceof ConstantValueWithAliasColumnItem) {
//                        String alias = ((ConstantValueWithAliasColumnItem) it).getAlias();
//                        expr.setAlias(new Alias(alias));
//                    }
//                    selectItems.add(expr);
//                } else if (item instanceof FunctionExpressionColumnItem) {
//                    FunctionExpressionColumnItem it = (FunctionExpressionColumnItem) item;
//                    Expression expression = SQLUtils.getFuncExpressionFromColumnItem(this, it);
//                    SelectExpressionItem expr = new SelectExpressionItem(expression);
//                    if (it instanceof FunctionExpressionWithAliasColumnItem) {
//                        String alias = ((FunctionExpressionWithAliasColumnItem) it).getAlias();
//                        expr.setAlias(new Alias(alias));
//                    }
//                    selectItems.add(expr);
//                }
            }
            body.setSelectItems(selectItems);
        }
        return (T) this;
    }

    @Override
    protected T items(ParamItem... items) {
        return (T) this;
    }

    @Override
    public T where(String tableAlis, String item, String paramName, FieldDataTypeInterface dataType) {
        return (T) super.where(tableAlis, item, paramName, dataType);
    }

    @Override
    public T where(LogicalOpType logicalOpType, String item, String paramName, FieldDataTypeInterface dataType) {
        return (T) super.where(logicalOpType, item, paramName, dataType);
    }

    @Override
    public T where(String item, String paramName, FieldDataTypeInterface dataType) {
        return (T) super.where(item, paramName, dataType);
    }

    @Override
    public T where(String item, FieldDataTypeInterface dataType) {
        return (T) super.where(item, dataType);
    }

    @Override
    public T where(LogicalRelationshipType type, LogicalOpType logicalOpType, String tableAlis, String item, String paramName, FieldDataTypeInterface dataType) throws SQLBuilderException {
        return (T) super.where(type, logicalOpType, tableAlis, item, paramName, dataType);
    }

    @Override
    public T where(LogicalRelationshipType type, String tableAlis, String item, String paramName, FieldDataTypeInterface dataType) {
        return (T) super.where(type, tableAlis, item, paramName, dataType);
    }

    @Override
    public T where(LogicalRelationshipType type, String item, String paramName, FieldDataTypeInterface dataType) {
        return (T) super.where(type, item, paramName, dataType);
    }

    @Override
    public T where(LogicalRelationshipType type, String item, FieldDataTypeInterface dataType) {
        return (T) super.where(type, item, dataType);
    }

    @Override
    public T where(LogicalRelationshipType type, String tableAlis, String item, OperationType opType, SQLSelect subQuery) {
        return (T) super.where(type, tableAlis, item, opType, subQuery);
    }

    @Override
    public T where(ParamItem... item) {
        return (T) super.where(item);
    }

    @Override
    public T where(LogicalRelationshipType type, LogicalOpType logicalOpType, ParamItem... item) throws SQLBuilderException {
        return (T) super.where(type, logicalOpType, item);
    }

    @Override
    public T rawWhere(String where) {
        return (T) super.rawWhere(where);
    }

    @Override
    public T order(boolean asc, String... item) {
        return (T) super.order(asc, item);
    }

    @Override
    public T order(boolean asc, GenricExpression... item) {
        return (T) super.order(asc, item);
    }

    @Override
    public T setLimit(int start, int count) {
        return (T) super.setLimit(start, count);
    }

    @Override
    public T setLimit(int count) {
        return (T) super.setLimit(count);
    }

    @Override
    public <V> T constantItems(String item, V value) {
        return (T) super.constantItems(item, value);
    }

    @Override
    public <V> T constantItems(String table, String item, V value) {
        return (T) super.constantItems(table, item, value);
    }

    @Override
    public T funcItems(String item, String funcName) {
        return (T) super.funcItems(item, funcName);
    }

    @Override
    public T items(String... item) {
        return (T) super.items(item);
    }

    @Override
    public T items(FieldDataTypeInterface type, String... item) {
        return (T) super.items(type, item);
    }

    @Override
    public T items(String item, FieldDataTypeInterface dataType) {
        return (T) super.items(item, dataType);
    }

    //    public SQLSelect items(ColumnValueWithAlisColumnItem... item) {
//        for (ColumnValueWithAlisColumnItem it : item) {
//            items(it.getTableAlis(), it.getColumnItem(), it.getAlis());
//        }
//        return this;
//    }

//    public SQLSelect items(String item, String alias) {
//        return items(null, item, alias, null);
//    }
//
//    public SQLSelect items(String tableName, String item, String alias, FieldDataTypeInterface sqlType) {
//        List<SelectItem> selectItems = body.getSelectItems();
//        if (selectItems == null) {
//            selectItems = CollectionHelper.newList();
//        }
//        Table tb = SQLUtils.getTableForAlias(this, tableName);
////        if (tableName == null) {
////            tb = getTable();
////        }else{
////            tb=new Table(tableName);
////        }
//        SelectExpressionItem expressionItem = new SelectExpressionItem(new Column(tb, item));
//        expressionItem.setAlias(new Alias(alias));
//        selectItems.add(expressionItem);
//        body.setSelectItems(selectItems);
//        return this;
//    }

    public T items(SQLSelect item, String alias) {
        return (T) this;
    }

//    public SQLSelect items(String... item) {
//        for (String it : item) {
//            items(null, it, it, null);
//        }
//        return this;
//    }
//
//    public SQLSelect items(FieldDataTypeInterface sqlType, String... item) {
//        for (String it : item) {
//            items(null, it, it, sqlType);
//        }
//        return this;
//    }
//
//    public SQLSelect items(String item) {
//        items(null, item, item, null);
//        return this;
//    }
//
//    public SQLSelect functionItem(String funcName, String alias) {
//        List<SelectItem> selectItems = body.getSelectItems();
//        if (selectItems == null) {
//            selectItems = CollectionHelper.newList();
//        }
//        Expression paramItem = SQLUtils.getFuncExpressionFromColumnItem(this, new FunctionExpressionColumnItem(funcName));
//        SelectExpressionItem expressionItem = new SelectExpressionItem(paramItem);
//        expressionItem.setAlias(new Alias(alias));
//        selectItems.add(expressionItem);
//        return this;
//    }
//
//    public SQLSelect functionItem(FunctionExpressionWithAliasColumnItem item) {
//        List<SelectItem> selectItems = body.getSelectItems();
//        if (selectItems == null) {
//            selectItems = CollectionHelper.newList();
//        }
//        Expression paramItem = SQLUtils.getFuncExpressionFromColumnItem(this, item);
//        SelectExpressionItem expressionItem = new SelectExpressionItem(paramItem);
//        expressionItem.setAlias(new Alias(item.getAlias()));
//        selectItems.add(expressionItem);
//        return this;
//    }
//
//    public <T> SQLSelect contantItem(ConstantValueWithAliasColumnItem<T> item) {
//        List<SelectItem> selectItems = body.getSelectItems();
//        if (selectItems == null) {
//            selectItems = CollectionHelper.newList();
//        }
//        Expression paramItem = SQLUtils.getConstantExpressionFromParamItem(item.getValue(), item.getType());
//        SelectExpressionItem expressionItem = new SelectExpressionItem(paramItem);
//        expressionItem.setAlias(new Alias(item.getAlias()));
//        selectItems.add(expressionItem);
//        return this;
//    }
//
//    public <T> SQLSelect contantItem(T value, String alias) {
//        contantItem(new ConstantValueWithAliasColumnItem<T>(alias, value));
//        return this;
//    }

//    public SQLSelect items(NamedCommonEntry.NamedCommonEntryListBuilder<String,String> itemListBuilder){
//        return this;
//    }
//
//    public SQLSelect items(NamedTripleEntry.NamedTripleEntryListBuilder<String,String,String> itemListBuilder){
//        return this;
//    }

    public T mainTable(SQLSelect sql, String tableAlis) {
//        body.setFromItem();
        return (T) this;
    }

    public T joinTable(SQLSelect sql, String tableAlis) {


        return (T) this;
    }

    public T joinTable(boolean inner, String db, String table, String alias) {
        PlainSelect body = (PlainSelect) this.body;
        List<Join> joinList = body.getJoins();
        if (joinList == null) {
            joinList = CollectionHelper.newList();
        }
        Join j = new Join();
        Table tb;
        j.setInner(inner);
        j.setLeft(!inner);
        j.setSimple(true);
        if (db == null) {
            db = mainTable.tbDb;
        }
        if (db == null) {
            tb = new Table(table);
        } else {
            tb = new Table(db, table);
        }
        tb.setAlias(new Alias(alias));
        j.setRightItem(tb);
        joinList.add(j);
        body.setJoins(joinList);
        return (T) this;
    }

    public T joinTable(String table, String alias) {
        joinTable(true, null, table, alias);
        return (T) this;
    }

    public T joinTable(String table) {
        joinTable(true, null, table, table);
        return (T) this;
    }

    public T joinTable(String db, String table, String alias) {
        joinTable(true, db, table, alias);
        return (T) this;
    }

    public T joinTableWithCondition(String table, ColumnValueParamItem condition) {
        joinTableWithCondition(true, null, table, table, condition);
        return (T) this;
    }

    public T joinTableWithCondition(String table, ColumnValueParamItem... condition) {
        joinTableWithCondition(true, null, table, table, condition);
        return (T) this;
    }

    public T joinTableWithCondition(boolean inner, String db, String table, String alias, ColumnValueParamItem... conditions) {
        PlainSelect body = (PlainSelect) this.body;
        List<Join> joinList = body.getJoins();
        if (joinList == null) {
            joinList = CollectionHelper.newList();
        }
        Join j = new Join();
        Table tb;
        j.setInner(inner);
        j.setLeft(!inner);
//        j.setSimple(true);
        if (db == null) {
            db = mainTable.tbDb;
        }
        if (db == null) {
            tb = new Table(table);
        } else {
            tb = new Table(db, table);
        }
        tb.setAlias(new Alias(alias));
        j.setRightItem(tb);
        Expression onExpression = j.getOnExpression();
//        int i=0,n=conditions.length;
//        ColumnValueParamItem[] items=new ColumnValueParamItem[n];
//        while(i<n) {
//            items[i]=new ColumnValueParamItem(conditions);
//        }
        onExpression = SQLUtils.genConditionPart(this, onExpression, LogicalRelationshipType.and, CommonOpType.eq, conditions);
        j.setOnExpression(onExpression);
        j.setSimple(false);
        joinList.add(j);
        body.setJoins(joinList);
        return (T) this;
    }

    public T group(String item) {
        group(item, null);
        return (T) this;
    }

    public T group(String item, String tableAlias) {
        PlainSelect body = (PlainSelect) this.body;
        List<Expression> expressions = body.getGroupByColumnReferences();
        if (expressions == null) {
            expressions = CollectionHelper.newList();
        }
        Table tb = SQLUtils.getTableForAlias(this, tableAlias);
//        if (tableAlias == null) {
//            tb = getTable();
//        } else {
//            tb = new Table(tableAlias);
//        }
        expressions.add(new Column(tb, item));
        body.setGroupByColumnReferences(expressions);
        return (T) this;
    }

    public T havingEqCondition(String item, String tableAlias, String param, FieldDataTypeInterface type) {
        havingCondition(LogicalRelationshipType.and, LogicalOpType.eq, item, tableAlias, param, type);
        return (T) this;
    }

    public T havingCondition(LogicalRelationshipType type, LogicalOpType logicalOpType, String item, String tableAlias, String param, FieldDataTypeInterface cType) {
        havingCondition(type, logicalOpType, new JDBCParamParamItem(tableAlias, item, param, cType));
        return (T) this;
    }

    public <V> T havingConstantCondition(LogicalRelationshipType type, LogicalOpType logicalOpType, String item, String tableAlias, V value) {
        havingCondition(type, logicalOpType, new ConstantValueParamItem<V>(tableAlias, item, value));
        return (T) this;
    }

    public T having(SExpr expr) {
        return (T) this;
    }

//    public SQLSelect where(SExpr expr)

    public T havingCondition(LogicalRelationshipType type, LogicalOpType logicalOpType, ParamItem... conditionCols) {
        PlainSelect body = (PlainSelect) this.body;
        Expression expression = body.getHaving();
        CommonOpType genExpressionType = SQLUtils.getExp(logicalOpType);
        if (genExpressionType == null) {
            throw SQLBuilderException.newIllegalBuildParamException();
        }
        Expression part = SQLUtils.genConditionPart(this, expression, type, genExpressionType, conditionCols);
        body.setHaving(part);
        return (T) this;
    }

    public T rawHavingCondition(LogicalRelationshipType type, String item) {
        PlainSelect body = (PlainSelect) this.body;
        Expression expression = body.getHaving();

        int i = seq.getAndIncrement();
        havingCondition(type,LogicalOpType.eq,new ConstantReplaceStubParamItem<>(i));
        replacement.put(i,item);
//        CommonOpType genExpressionType = SQLUtils.getExp(logicalOpType);
//        if (genExpressionType == null) {
//            throw SQLBuilderException.newIllegalBuildParamException();
//        }
//        Expression part = SQLUtils.genConditionPart(this, expression, type, genExpressionType, conditionCols);
//        body.setHaving(part);
        return (T) this;
    }

    public T rawHavingCondition( String item) {
        return rawHavingCondition(LogicalRelationshipType.and,item);
    }

    public T setCalFoundRows() {
        PlainSelect body = (PlainSelect) this.body;
        body.setHasCalFoundRowsKeyWord(true);
        return (T) this;
    }

    public T setDistinct() {
        PlainSelect body = (PlainSelect) this.body;
        body.setHasDistinctKeyWord(true);
        return (T) this;
    }

    @Override
    public T setLimit() {
        return super.setLimit();
    }

    @Override
    public Set<String> getAllTable() {
        return SQLUtils.getSelectAllTable(select);
    }

    @Override
    public boolean removeItems(String itemStr) {
        if (itemStr == null) return false;
        boolean ret = false;
        PlainSelect body = (PlainSelect) this.body;

        List<SelectItem> columns = body.getSelectItems();
//        List<Column> columns = select.getColumns();
        List<SelectItem> newColumns = CollectionHelper.newList();
        if (columns != null && columns.size() > 0) {
            for (SelectItem c : columns) {
                if ((c != null) && (c instanceof SelectExpressionItem)) {
                    SelectExpressionItem item = ((SelectExpressionItem) c);
                    boolean flag = false;
                    Alias alias = item.getAlias();
                    if (alias != null) {
//                        String itemAlis = ((HasAlias) item).getAlias();
                        flag = (itemStr).equals(alias.getName());
                    } else {
                        Expression expression = item.getExpression();
                        if (expression instanceof Column){
                            Column col=((Column) expression);
                            flag=itemStr.equals(col.getColumnName());
                        }
                    }
                    if (flag) {
                        ret = true;
                    } else {
                        newColumns.add(c);
                    }
                }
            }
            body.setSelectItems(newColumns);
        }

        return ret;
    }
}

