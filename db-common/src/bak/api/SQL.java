package com.shawn.ss.lib.tools.service_assemble.api.bak.api;

import com.shawn.ss.lib.tools.CollectionHelper;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model.*;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.factory.Config;
import com.shawn.ss.lib.tools.sql_code_gen.api.model.GenricExpression;
import com.shawn.ss.lib.tools.sql_code_gen.api.model.OperationType;
import com.shawn.ss.lib.tools.sql_code_gen.api.model.column_and_param_expression.*;
import com.shawn.ss.lib.tools.sql_code_gen.api.model.column_expression.*;
import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.expression.Alias;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.schema.Database;
import net.sf.jsqlparser.schema.Table;
import net.sf.jsqlparser.statement.*;
import net.sf.jsqlparser.statement.delete.Delete;
import net.sf.jsqlparser.statement.insert.Insert;
import net.sf.jsqlparser.statement.select.*;
import net.sf.jsqlparser.statement.update.Update;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class SQL<T extends SQL> implements HasMainTable {


//    public static class JoinColumn {
//        String leftTableAlis;
//        String leftTableColumn;
//        String rightTableAlis;
//        String rightTableColumn;
//        FieldDataTypeInterface columnType;
//
//        public JoinColumn(String leftTableAlis, String leftTableColumn, String rightTableAlis, String rightTableColumn) {
//            this.leftTableAlis = leftTableAlis;
//            this.leftTableColumn = leftTableColumn;
//            this.rightTableAlis = rightTableAlis;
//            this.rightTableColumn = rightTableColumn;
//        }
//
//        public JoinColumn(String leftTableAlis, String leftTableColumn, String rightTableAlis, String rightTableColumn, FieldDataTypeInterface columnType) {
//            this.leftTableAlis = leftTableAlis;
//            this.leftTableColumn = leftTableColumn;
//            this.rightTableAlis = rightTableAlis;
//            this.rightTableColumn = rightTableColumn;
//            this.columnType = columnType;
//        }
//
//        public String getLeftTableAlis() {
//            return leftTableAlis;
//        }
//
//        public void setLeftTableAlis(String leftTableAlis) {
//            this.leftTableAlis = leftTableAlis;
//        }
//
//        public String getLeftTableColumn() {
//            return leftTableColumn;
//        }
//
//        public void setLeftTableColumn(String leftTableColumn) {
//            this.leftTableColumn = leftTableColumn;
//        }
//
//        public String getRightTableAlis() {
//            return rightTableAlis;
//        }
//
//        public void setRightTableAlis(String rightTableAlis) {
//            this.rightTableAlis = rightTableAlis;
//        }
//
//        public String getRightTableColumn() {
//            return rightTableColumn;
//        }
//
//        public void setRightTableColumn(String rightTableColumn) {
//            this.rightTableColumn = rightTableColumn;
//        }
//
//        public FieldDataTypeInterface getColumnType() {
//            return columnType;
//        }
//
//        public void setColumnType(FieldDataTypeInterface columnType) {
//            this.columnType = columnType;
//        }
//    }

//    protected static class WhereGroup {
//        LogicalRelationshipType unionRelations;
//        OperationType commonOps;
//        List<ParamItem> items;
//        ParamItem item;
//
//        public WhereGroup(LogicalRelationshipType unionRelations, OperationType commonOps, List<ParamItem> items) {
//            this.unionRelations = unionRelations;
//            this.commonOps = commonOps;
//            this.items = items;
//        }
//
//        public WhereGroup(LogicalRelationshipType unionRelations, OperationType commonOps, ParamItem item) {
//            this.unionRelations = unionRelations;
//            this.commonOps = commonOps;
//            this.item = item;
//        }
//    }

    public static enum SqlType {
        select, insert, update, delete
    }

    AtomicInteger seq=new AtomicInteger(0);

    public static String doReplacement(String sql,Map<Integer,String> values){
        if (values != null && values.size() != 0 && sql != null) {
            Set<Map.Entry<Integer, String>> entries = values.entrySet();
            for (Map.Entry<Integer, String> entry : entries) {
                Integer key = entry.getKey();
                String value = entry.getValue();
                Pattern p = Pattern.compile(key + "\\s*=\\s*" + key);
                Matcher matcher = p.matcher(sql);
                if (matcher.find() && value != null) {
                    int start = matcher.start();
                    int end = matcher.end();
                    sql = sql.substring(0, start) + value + sql.substring(end);
                }
            }
        }
        return sql;
    }

    Map<Integer,String> replacement=CollectionHelper.newMap();

    public static SQLSelect buildSelectSql(String table) {
        return new SQLSelect<SQLSelect>().mainTable(table);
    }

    public static SQLInsert buildInsertSql(String table) {
        return new SQLInsert().mainTable(table);
    }

    public static SQLUpdate buildUpdateSql(String table) {
        return new SQLUpdate().mainTable(table);
    }

    public static SQLDelete buildDeleteSql(String table) {
        return new SQLDelete().mainTable(table);
    }

    public static SQLSelect buildSelectSql(String db, String table, String alias) {
        return new SQLSelect<SQLSelect>().mainTable(db, table, alias);
    }

    public static SQLInsert buildInsertSql(String db, String table, String alias) {
        return new SQLInsert().mainTable(db, table, alias);
    }

    public static SQLUpdate buildUpdateSql(String db, String table, String alias) {
        return new SQLUpdate().mainTable(db, table, alias);
    }

    public static SQLDelete buildDeleteSql(String db, String table, String alias) {
        return new SQLDelete().mainTable(db, table, alias);
    }

    public static SQLMultipleSelect buildComplexSelectSql(String table1, String table2) {
        return buildComplexSelectSql(null, table1, table1, null, table2, table2);//new SQLMultipleSelect().chooseSelect(0).mainTable(table1).chooseSelect(1).mainTable(table2);
    }

    public static SQLMultipleSelect buildComplexSelectSql(String db1, String table1, String alias1, String db2, String table2, String alias2) {
        SQLSelect select1 = buildSelectSql(db1, table1, alias1);
        SQLSelect select2 = buildSelectSql(db2, table2, alias2);
        List<SQLSelect> selects = CollectionHelper.newList(select1, select2);
        List<UnionRelationshipType> relationship = CollectionHelper.newList();
        relationship.add(UnionRelationshipType.unionDistinct);
        return new SQLMultipleSelect(selects, relationship);//new SQLMultipleSelect().chooseSelect(0).mainTable(db1,table1,alias1).chooseSelect(1).mainTable(db2,table2,alias2);
    }

    public static SQLMultipleSelect buildComplexSelectSql(List<SQLSelect> selects) {
        return SQL.buildComplexSelectSql(selects, UnionRelationshipType.unionDistinct);
    }

    public static SQLMultipleSelect buildComplexSelectSql(List<SQLSelect> selects, UnionRelationshipType relationship) {
        if (selects != null) {
            List<UnionRelationshipType> list = CollectionHelper.getListFilledWithElement(relationship, selects.size() - 1);
            return buildComplexSelectSql(selects, list);
        } else {
            return null;
        }
    }

    public static SQLMultipleSelect buildComplexSelectSql(List<SQLSelect> selects, List<UnionRelationshipType> relationship) {
        return new SQLMultipleSelect(selects, relationship);
    }

    //    protected List<WhereGroup> whereGroupList;
    protected SQLTB mainTable;

    public void setTable(String table,String db,String alias) {
//        Database database = table.getDatabase();
        String name = table;
//        String db = db;
//        Alias alias = table.getAlias();
        String al = alias;
//        mainTable = new SQLTB(name, al, db, table);
        mainTable(db,name,al);
    }


    public void setTable(String table) {
//        Database database = table.getDatabase();
        String name = table;
//        String db = database == null ? null : database.getDatabaseName();
//        Alias alias = table.getAlias();
        String al;
        if(this.mainTable==null) {
            al = table;
        }else {
            al = this.mainTable.tbAlis;
        }
//        mainTable = new SQLTB(name, al, db, table);
        mainTable(null,name,al);
    }

    @Override
    public void setTable(Table table) {
        Database database = table.getDatabase();
        String name = table.getName();
        String db = database == null ? null : database.getDatabaseName();
        Alias alias = table.getAlias();
        String al = alias == null ? name : alias.getName();
//        mainTable = new SQLTB(name, al, db, table);
        mainTable(name,db,al);
    }

    //    protected List<ColumnValueColumnItem> orderAsc, OrderDesc;

//    public static final NamedTripleEntry.NamedTripleEntryBuilder<String, String, String>
//            conditionPartParamBuilder = NamedTripleEntry.newBuilder("tableName", "fieldName", "value");
//    public static final NamedTripleEntry.NamedTripleEntryBuilder<String, String, String> mainTableBuilder =
//            NamedTripleEntry.<String, String, String>newBuilder("data_store", "table", "tableAlis");

    protected final SqlType sqlType;

    protected abstract HasWhereClause getWhereBase();

    protected abstract HasOrderClause getOrderBase();

    protected abstract HasLimitClause getLimitBase();

    protected abstract HasMainTable getMainTableHandler();

    public abstract String getSql(Config.LibType type);

    public SqlType getSqlType() {
        return sqlType;
    }

    public static Set<String> getAllRelatedTable(String sql, Config.LibType type){
        SQL parsedSql = parseSql(sql, type);
        if(parsedSql!=null){
            return parsedSql.getAllTable();
        }
        return null;
    }

    public static Set<String> getSelectItems(String sql, Config.LibType type){
        Statement statement = null;
        try {
            statement = CCJSqlParserUtil.parse(sql);
            if(statement instanceof Select){
                Set<String> ret=CollectionHelper.newSortedSet();
                Select sl=((Select) statement);
                SelectBody selectBody = sl.getSelectBody();
                getSelectItemsInternal(selectBody,ret);
            }
        } catch (JSQLParserException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static void getSelectItemsInternal(SelectBody selectBody, Set<String> ret) {
        if (selectBody instanceof PlainSelect) {
            PlainSelect s=(PlainSelect)selectBody;
            List<SelectItem> selectItems = s.getSelectItems();
            addSelectItems(selectItems,ret);
        } else if (selectBody instanceof SetOperationList) {
            SetOperationList s=(SetOperationList)selectBody;
            List<SelectBody> selects = s.getSelects();
            for(SelectBody body:selects){
                getSelectItemsInternal(body,ret);
            }
        }
    }

    private static void addSelectItems(List<SelectItem> selectItems, Set<String> ret) {
        for(SelectItem item:selectItems){
            ret.add(item.toString());
        }
    }

    public static <TT extends SQL> TT parseSql(String sql, Config.LibType type) {
//        CCJSqlParser parser = new CCJSqlParser(new StringReader(sql));
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
                    SelectBody selectBody = select.getSelectBody();
                    if (selectBody instanceof PlainSelect) {
                        return (TT) new SQLSelect(select);
                    } else if (selectBody instanceof SetOperationList) {
                        return (TT) new SQLMultipleSelect(select);
                    }
                    return (TT) new SQLSelect((Select) statement);
                } else if ( statement instanceof Insert) {
                    return (TT) new SQLInsert((Insert) statement);
                } else if ( statement instanceof Update) {
                    return (TT) new SQLUpdate((Update) statement);
                } else if ( statement instanceof Delete) {
                    return (TT) new SQLDelete((Delete) statement);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    protected SQL(SqlType type) {
        this.sqlType = type;
        switch (type) {
            case delete:
                break;
            case insert:
                break;
            case update:
                break;
            case select:
//                select = new Select();
                break;
        }
    }

    protected final void setMainTB(HasMainTable cluase) {
        Table table = cluase.getTable();
        setTable(table);
    }

    //    @Override
    public Table getTable() {
        Table table = null;
        if (mainTable != null) {
            table = mainTable.tb;
        } else {
//            throw new SQLBuilderException("应先设置主数据表");
        }
        return table;
    }

//    @Override
//    public void setTable(Table name) {
//        throw new SQLBuilderException("此接口无任何效果，请勿调用");
//    }

    //    static class SqlHelper {
//
//        private SQL sql;
//
//        public SqlHelper(SQL sql) {
//            this.sql = sql;
//        }

    protected T mainTable(String table) {
        //clear main table
        HasMainTable mainTableHandler = getMainTableHandler();
//        if(table==null && ( sqlType==SqlType.select)){
//            mainTableHandler.setTable(null);
//        }else {
        Table tb = new Table(table);
        tb.setAlias(new Alias(table));
        this.mainTable = new SQLTB(table, table, null, tb);

        mainTableHandler.setTable(tb);
//        }
        return (T) this;
    }

    protected T mainTable(String db, String table, String alias) {
        Table tb = new Table(db, table);
        tb.setAlias(new Alias(alias));
        this.mainTable = new SQLTB(table, alias, db, tb);
        getMainTableHandler().setTable(tb);
        return (T) this;
    }

    protected T where(String tableAlis, String item, String paramName, FieldDataTypeInterface dataType) {
        return where(LogicalRelationshipType.and, LogicalOpType.eq, tableAlis, item, paramName, dataType);
//        return (T) this;
    }

    protected T where(LogicalOpType logicalOpType, String item, String paramName, FieldDataTypeInterface dataType) {
        return where(LogicalRelationshipType.and, logicalOpType, null, item, paramName, dataType);
//        return (T) this;
    }

    protected T where(String item, String paramName, FieldDataTypeInterface dataType) {
        return where(LogicalRelationshipType.and, LogicalOpType.eq, null, item, paramName, dataType);
//        return (T) this;
    }

    protected T where(String item, FieldDataTypeInterface dataType) {
        return where(LogicalRelationshipType.and, LogicalOpType.eq, null, item, item, dataType);
//        return (T) this;
    }

    protected T where(LogicalRelationshipType type, LogicalOpType logicalOpType, String tableAlis, String item, String paramName, FieldDataTypeInterface dataType) throws SQLBuilderException {
//        Expression base = getWhereBase();
//        if (base == null) {
//            throw SQLBuilderException.newIllegalBuildPartException();
//        }
        CommonOpType genExpressionType = SQLUtils.getExp(logicalOpType);
        if (genExpressionType == null) {
            throw SQLBuilderException.newIllegalBuildParamException();
        }
//        if (whereGroupList == null) {
//            whereGroupList = CollectionHelper.newList();
//        }
        ParamItem itemAndParam = new JDBCParamParamItem(tableAlis, item, paramName, dataType);
//        whereGroupList.add(new WhereGroup(unionRelations, genExpressionType,
//                itemAndParam));
        HasWhereClause whereBase = getWhereBase();
        if (whereBase == null) {
            throw SQLBuilderException.newIllegalBuildPartException();
        }
        Expression where = whereBase.getWhere();
//        getExp(logicalOpType);
        Expression expression = SQLUtils.genConditionPart(this, where, type, genExpressionType, itemAndParam);
        whereBase.setWhere(expression);
        return (T) this;

    }

    protected T where(LogicalRelationshipType type, String tableAlis, String item, String paramName, FieldDataTypeInterface dataType) {
        return where(type, LogicalOpType.eq, tableAlis, item, paramName, dataType);
    }

    protected T where(LogicalRelationshipType type, String item, String paramName, FieldDataTypeInterface dataType) {
        return where(type, LogicalOpType.eq, null, item, paramName, dataType);
//        return where(sqlType);
    }

    protected T where(LogicalRelationshipType type, String item, FieldDataTypeInterface dataType) {
        return where(type, LogicalOpType.eq, null, item, item, dataType);
    }


    protected T where(LogicalRelationshipType type, String tableAlis, String item, OperationType opType, SQLSelect subQuery) {
        return (T) this;
    }

    protected T where(ParamItem... item) {
        return where(LogicalRelationshipType.and, LogicalOpType.eq, item);
    }

    protected T where(LogicalRelationshipType type, LogicalOpType logicalOpType, ParamItem... item) throws SQLBuilderException {
        CommonOpType genExpressionType = SQLUtils.getExp(logicalOpType);
        if (genExpressionType == null) {
            throw SQLBuilderException.newIllegalBuildParamException();
        }
//        if (whereGroupList == null) {
//            whereGroupList = CollectionHelper.newList();
//        }
//        whereGroupList.add(new WhereGroup(unionRelations, genExpressionType,
//                Arrays.asList(item)));
        HasWhereClause whereBase = getWhereBase();
        Expression where = whereBase.getWhere();
//        getExp(logicalOpType);
        Expression expression = SQLUtils.genConditionPart(this, where, type, genExpressionType, item);
        whereBase.setWhere(expression);
        return (T) this;
    }

    protected T rawWhere(String where){
        int i = seq.getAndIncrement();
        where(new ConstantReplaceStubParamItem<>(i));
        replacement.put(i,where);
        return (T)this;
    }

    protected T rawItem(String item){
        int i = seq.getAndIncrement();
        items(new ConstantReplaceStubColumnItem(i));
        replacement.put(i,item);
        return (T)this;
    }

    protected T order(boolean asc, GenricExpression... items) {
        HasOrderClause orderBase = getOrderBase();

        List<OrderByElement> els = orderBase.getOrderByElements();
        if (els == null)
            els = CollectionHelper.newList();
        for (GenricExpression it : items) {
            OrderByElement el = new OrderByElement();
            el.setAsc(asc);
//            String tableAlis = it.getTableAlis();
//            Table table = SQLUtils.getTableForAlias(this, tableAlis);
//            if (tableAlis != null) {
//                table = new Table(tableAlis);
////                tableAlis=mainTable.tbAlis;
////                if(tableAlis==null){
////                    throw new SQLBuilderException("应先设置主数据表");
////                }
//            } else {
//
//            }
            el.setExpression(it.asExpression(this));
            els.add(el);
        }
        if (orderBase == null) {
            throw SQLBuilderException.newIllegalBuildPartException();
        }
        orderBase.setOrderByElements(els);
        return (T) this;
    }

    protected T order(boolean asc, String... item) {
        ColumnValueColumnItem[] items = new ColumnValueColumnItem[item.length];
        for (int i = 0; i < item.length; ++i) {
            String s = item[i];
            items[i] = new ColumnValueColumnItem(null, s);
        }
        return order(asc, items);
    }

//    protected T order(boolean asc, ColumnValueColumnItem... item) {
//        order(asc,(GenricExpression[]) item);
//        return (T) this;
//    }

    protected T setLimit() {
        HasLimitClause limitBase = getLimitBase();
        if (limitBase == null) {
            throw SQLBuilderException.newIllegalBuildPartException();
        }
        limitBase.setLimit(new Limit().setOffsetJdbcParameter(true).setRowCountJdbcParameter(true));
        return (T) this;
    }

    protected T setLimit(int start, int count) {
        HasLimitClause limitBase = getLimitBase();
        if (limitBase == null) {
            throw SQLBuilderException.newIllegalBuildPartException();
        }
        limitBase.setLimit(new Limit().setRowCount(count).setOffset(start));
        return (T) this;
    }

    protected T setLimit(int count) {
        return setLimit(0, count);
    }

    protected abstract T items(ColumnItem... items);

    protected abstract T items(ParamItem... items);

    protected <V> T constantItems(String item, V value) {
        items(new ConstantValueParamItem<V>(null, item, value));
        return (T) this;
    }

    protected <V> T constantItems(String table, String item, V value) {
        if (sqlType == SqlType.select) {
            items(new ConstantValueWithAliasColumnItem<V>(item, value));
        } else if (sqlType == SqlType.insert || sqlType == SqlType.update) {
            items(new ConstantValueParamItem<V>(table, item, value));
        }
        return (T) this;
    }

    protected T funcItems(String item, String funcName) {
        if (sqlType == SqlType.select) {
            FunctionExpressionWithAliasColumnItem paramItem = new FunctionExpressionWithAliasColumnItem(funcName, item);
            paramItem.setAll(true);
            items(paramItem);
        } else if (sqlType == SqlType.insert || sqlType == SqlType.update) {
            FunctionExpressionParamItem paramItem = new FunctionExpressionParamItem(null, item, funcName, null);
            paramItem.setAll(false);
            items(paramItem);
        }
        return (T) this;
    }

    protected T items(String... item) {
        items(null, item);
        return (T) this;
    }

    protected T items(FieldDataTypeInterface type, String... item) {
        if (item != null && item.length > 0) {
            if (sqlType == SqlType.select) {
                ColumnValueWithAlisColumnItem[] paramItems = new ColumnValueWithAlisColumnItem[item.length];
                int i = 0;
                for (String s : item) {
                    paramItems[i++] = new ColumnValueWithAlisColumnItem(null, s, s);
                }
                items(paramItems);
            } else if (sqlType == SqlType.insert || sqlType == SqlType.update) {
                ParamItem[] paramItems = new ParamItem[item.length];
                int i = 0;
                for (String s : item) {
                    paramItems[i++] = new JDBCParamParamItem(null, s, s, type);
                }
                items(paramItems);
            }
        }
        return (T) this;
    }


    protected T items(String item, FieldDataTypeInterface dataType) {
        if (sqlType == SqlType.select) {
            items(new ColumnValueWithAlisColumnItem(null, item, item));
        } else if (sqlType == SqlType.insert || sqlType == SqlType.update) {
            items(new JDBCParamParamItem(null, item, item, dataType));
        }
        return (T) this;
    }

    public T where(SExpr expr) {
        return (T) this;
    }

    public abstract Set<String> getAllTable();

    protected abstract boolean removeItems(String item);
//    {
//        if (this.mainTable != null)
//            return Collections.singleton(this.mainTable.tb.getFullyQualifiedName());
//        else return null;
//    }

//    }

//    public <T extends SQL> T whereAnd(String tableAlis,String item,String paramName,FieldDataTypeInterface sqlType){
//        return (T)this;
//    }
//
//    public <T extends SQL> T whereAnd(String item,String paramName,FieldDataTypeInterface sqlType){
//        return whereAnd(null,item,paramName,sqlType);
//    }
//
//    public <T extends SQL> T whereAnd(String item,FieldDataTypeInterface sqlType){
//        return whereAnd(null,item,null, sqlType);
//    }
//
//
//    public <T extends SQL> T whereOr(String tableAlis,String item,String paramName,FieldDataTypeInterface sqlType){
//        return (T)this;
//    }
//
//    public <T extends SQL> T whereOr(String item,String paramName,FieldDataTypeInterface sqlType){
//        return whereOr(null,item,paramName,sqlType);
//    }
//
//    public <T extends SQL> T whereOr(String item,FieldDataTypeInterface sqlType){
//        return whereOr(null,item,null,sqlType);
//    }
//
//
//    public <T extends SQL> T where(ParamItem ... item){
//        return where(LogicalRelationshipType.and,OperationType.eq,item);
//    }
//
//    public <T extends SQL> T where( LogicalRelationshipType sqlType, OperationType commonOps,ParamItem ... item){
//        return (T)this;
//    }

}
