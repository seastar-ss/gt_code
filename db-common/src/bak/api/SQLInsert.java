package com.shawn.ss.lib.tools.service_assemble.api.bak.api;

import com.shawn.ss.lib.tools.CollectionHelper;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model.FieldDataTypeInterface;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.factory.Config;
import com.shawn.ss.lib.tools.sql_code_gen.api.model.column_and_param_expression.JDBCParamParamItem;
import com.shawn.ss.lib.tools.sql_code_gen.api.model.column_and_param_expression.ParamItem;
import com.shawn.ss.lib.tools.sql_code_gen.api.model.column_expression.ColumnItem;
import com.shawn.ss.lib.tools.sql_code_gen.api.model.column_expression.ColumnValueColumnItem;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.operators.relational.ExpressionList;
import net.sf.jsqlparser.expression.operators.relational.ItemsList;
import net.sf.jsqlparser.schema.Column;
import net.sf.jsqlparser.schema.Database;
import net.sf.jsqlparser.schema.Table;
import net.sf.jsqlparser.statement.HasLimitClause;
import net.sf.jsqlparser.statement.HasMainTable;
import net.sf.jsqlparser.statement.HasOrderClause;
import net.sf.jsqlparser.statement.HasWhereClause;
import net.sf.jsqlparser.statement.insert.Insert;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;

/**
 * Created by ss on 2017/10/12.
 */
public class SQLInsert extends SQL<SQLInsert> {


    private final Insert insert;

    protected SQLInsert(Insert insert) {
        super(SqlType.insert);
        this.insert = insert;

        setMainTB(this.insert);
    }

    protected SQLInsert() {
        super(SqlType.insert);
        insert = new Insert();
        insert.setUseValues(true);
    }

    @Override
    protected HasWhereClause getWhereBase() {
        return null;
    }

    @Override
    protected HasOrderClause getOrderBase() {
        return null;
    }

    @Override
    protected HasLimitClause getLimitBase() {
        return null;
    }

    @Override
    public HasMainTable getMainTableHandler() {
        return insert;
    }

    @Override
    public String getSql(Config.LibType type) {
        String sql = insert.toString();
        if (replacement.size() > 0) {
            sql = doReplacement(sql, replacement);
        }
        return sql;

    }

    @Override
    public void setTable(String table, String db, String alias) {
        super.setTable(table, db, alias);
    }

    @Override
    public void setTable(String table) {
        super.setTable(table);
    }

    @Override
    public SQLInsert rawItem(String item) {
        return super.rawItem(item);
    }

    //    @Override
//    public SQLInsert parseSql(String sql, Config.LibType unionRelations) {
//        return this;
//    }

    @Override
    protected SQLInsert items(ColumnItem... items) {
        return this;
    }

    public SQLInsert items(ParamItem... item) {
        boolean useValues = insert.isUseValues();
        insert.setUseValues(true);
        if (item != null && item.length > 0) {
            if (!useValues) {
                //从insert select 切换到 insert values，清空所有记录的items
                insert.setColumns(null);
                insert.setItemsList(null);
            }
            List<Column> columns = insert.getColumns();
            List<Expression> exprList;
            if (columns == null) {
                columns = CollectionHelper.newList();
            }
            ItemsList itemsList = insert.getItemsList();
            if (itemsList == null) {
                itemsList = new ExpressionList();
                exprList = CollectionHelper.newList();

            } else {
                exprList = ((ExpressionList) itemsList).getExpressions();
            }
            for (ParamItem it : item) {
//                Table tb = SQLUtils.getTableForAlias(this, it.getTableAlis());
                columns.add(it.getColumnExpression(this));
                exprList.add(it.asExpression(this));
//                if (it instanceof JDBCParamParamItem) {
//                    JDBCParamParamItem it1 = (JDBCParamParamItem) it;
//                    exprList.add(new JdbcNamedParameter(it1.getParamName()));
//                } else if (it instanceof ConstantValueParamItem) {
//                    ConstantValueParamItem it1 = (ConstantValueParamItem) it;
//                    exprList.add(SQLUtils.getConstantExpressionFromParam(it1.getValue()));
//                } else if (it instanceof FunctionExpressionParamItem) {
//                    FunctionExpressionParamItem it1 = (FunctionExpressionParamItem) it;
////                    exprList.add(SQLUtils.getFuncExpressionFromColumnItem(this, it1));
//                }
            }
            ((ExpressionList) itemsList).setExpressions(exprList);
            insert.setColumns(columns);
            insert.setItemsList(itemsList);
        }
        return this;
    }

    public SQLInsert items(SQLSelect select, ColumnValueColumnItem... item) {
        boolean useValues = insert.isUseValues();
        insert.setUseValues(false);
        insert.setSelect(select.select);
        if (item != null && item.length > 0) {
            if (useValues) {
                //从insert values 切换到  insert select，清空所有记录的items
                insert.setColumns(null);
                insert.setItemsList(null);
            }
            List<Column> columns = insert.getColumns();
            if (columns == null) {
                columns = CollectionHelper.newList();
            }
            for (ColumnValueColumnItem it : item) {
//                Table tb=SQLUtils.getTableForAlias(this,it.getTableAlis());
                final Column column = (Column) it.asExpression(this);

                columns.add(column);
            }

            insert.setColumns(columns);
        }
        return this;
    }

    public SQLInsert items(String column, String valueParam, FieldDataTypeInterface type) {
        items(new JDBCParamParamItem(null, column, valueParam, type));
        return this;
    }

    public SQLInsert items(String tableAlis, String item, String paramName, FieldDataTypeInterface dataType) {
        items(new JDBCParamParamItem(null, item, paramName, dataType));
        return this;
    }

    @Override
    public <V> SQLInsert constantItems(String item, V value) {
        return super.constantItems(item, value);
    }

    @Override
    public <V> SQLInsert constantItems(String table, String item, V value) {
        return super.constantItems(table, item, value);
    }

    @Override
    public SQLInsert funcItems(String item, String funcName) {
        return super.funcItems(item, funcName);
    }

    @Override
    public SQLInsert items(String... item) {
        return super.items(item);
    }

    @Override
    public SQLInsert items(FieldDataTypeInterface type, String... item) {
        return super.items(type, item);
    }

    @Override
    public SQLInsert items(String item, FieldDataTypeInterface dataType) {
        return super.items(item, dataType);
    }

    //    public <T> SQLInsert constantItems(  String item,T value){
//        items(new ConstantValueParamItem<T>(null,item,value));
//        return this;
//    }


//    public SQLInsert functionItems( String item,String funcName){
//        FunctionExpressionParamItem paramItem = new FunctionExpressionParamItem(null, item, funcName, null);
//        paramItem.setAll(false);
//        items(paramItem);
//        return this;
//    }

//    public SQLInsert items(String ... items){
//        items(null,items);
//        return this;
//    }
//
//    public SQLInsert items(FieldDataTypeInterface sqlType,String ... items){
//        if (items != null && items.length > 0) {
//            ParamItem[] paramItems = new ParamItem[items.length];
//            int i = 0;
//            for (String s : items) {
//                paramItems[i++] = new JDBCParamParamItem(null, s, s, sqlType);
//            }
//            items(paramItems);
//        }
//        return this;
//    }

    @Autowired
    protected SQLInsert mainTable(String table) {
        //clear main table
        HasMainTable mainTableHandler = getMainTableHandler();
//        if(table==null && ( sqlType==SqlType.select)){
//            mainTableHandler.setTable(null);
//        }else {
        Table tb = new Table(table);
//        tb.setAlias(new Alias(table));
        this.mainTable = new SQLTB(table, null, null, tb);

        mainTableHandler.setTable(tb);
//        }
        return this;
    }

    @Override
    public void setTable(Table table) {
        Database database = table.getDatabase();
        String name = table.getName();
        String db = database == null ? null : database.getDatabaseName();
//        Alias alias = table.getAlias();
//        String al = alias == null ? name : alias.getName();
        mainTable = new SQLTB(name, null, db, table);
    }

    public SQLInsert batch(int count) {
        return this;
    }

    public SQLInsert onDuplicateUpdate(ParamItem... update) {
//        update.mainTable(null);
//        insert.setOnDuplicatUpdate(update.update);
        return this;
    }

//    public SQLInsert items(ParamItem item){
//        return this;
//    }

//    public SQLInsert mainTable(String table) {
//        return this;
//    }
//
//    public SQLInsert mainTable(String data_store, String table, String alias) {
//        return this;
//    }


    @Override
    public Set<String> getAllTable() {
        return SQLUtils.getSelectAllTable(insert);
    }

    @Override
    public boolean removeItems(String item) {
        if(item==null) return false;
        List<Column> columns = insert.getColumns();
        List<Column> newColumns=CollectionHelper.newList();
        boolean ret=false;
        if(columns!=null && columns.size()>0) {
            for (Column c : columns) {
                if(c!=null && c.getColumnName()!=null){
                    if(c.getColumnName().equals(item)){
                        ret=true;
                    }else{
                        newColumns.add(c);
                    }
                }
            }
            insert.setColumns(newColumns);
        }

        return ret;
    }
}
