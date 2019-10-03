package com.shawn.ss.lib.tools.service_assemble.api.bak.api;

import com.shawn.ss.lib.tools.CollectionHelper;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model.FieldDataTypeInterface;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model.LogicalOpType;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model.LogicalRelationshipType;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.factory.Config;
import com.shawn.ss.lib.tools.sql_code_gen.api.model.*;
import com.shawn.ss.lib.tools.sql_code_gen.api.model.column_and_param_expression.*;
import com.shawn.ss.lib.tools.sql_code_gen.api.model.column_expression.ColumnItem;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.schema.Column;
import net.sf.jsqlparser.statement.*;
import net.sf.jsqlparser.statement.update.Update;

import java.util.List;
import java.util.Set;

/**
 * Created by ss on 2017/10/12.
 */
public class SQLUpdate extends SQL<SQLUpdate> {


    final Update update;

    protected SQLUpdate( Update update) {
        super(SqlType.update);
        this.update = update;
        setMainTB(this.update);
    }

    protected SQLUpdate() {
        super(SqlType.update);
        update = new Update();
        update.setUseSelect(false);
    }

    @Override
    public HasWhereClause getWhereBase() {
        return update;
    }

    @Override
    public HasOrderClause getOrderBase() {
        return update;
    }

    @Override
    public HasLimitClause getLimitBase() {
        return update;
    }

    @Override
    public HasMainTable getMainTableHandler() {
        return update;
    }

    @Override
    public SQLUpdate rawItem(String item) {
        int i = seq.getAndIncrement();
        items(new ConstantReplaceStubParamItem<Integer>(i));
        replacement.put(i,item);
        return this;
    }

    @Override
    public String getSql(Config.LibType type) {
        String sql = update.toString();
        if(replacement.size()>0){
            sql=doReplacement(sql,replacement);
        }
        return sql;
    }

//    @Override
//    public SQLUpdate parseSql(String sql, Config.LibType unionRelations) {
//        return this;
//    }

    @Override
    protected SQLUpdate items(ColumnItem... items) {
        return this;
    }

    //    public SQLUpdate mainTable(String table) {
//        return this;
//    }
//
//    public SQLUpdate mainTable(String data_store, String table, String alias) {
//        return this;
//    }
    //
    public SQLUpdate items(ParamItem... items) {
        if (items != null && items.length > 0) {
            List<Column> columns = update.getColumns();
            if (columns == null) {
                columns = CollectionHelper.newList();
            }
            List<Expression> expressions = update.getExpressions();
            if (expressions == null) {
                expressions = CollectionHelper.newList();
            }
            for (ParamItem item : items) {
                columns.add( item.getColumnExpression(this));
                expressions.add(item.asExpression(this));
//                Table tb = SQLUtils.getTableForAlias(this, item.getTableAlis());
//                columns.add(new Column(tb, item.getColumnItem()));
//                if (item instanceof JDBCParamParamItem) {
//                    JDBCParamParamItem it = (JDBCParamParamItem) item;
//                    expressions.add(new JdbcNamedParameter((it.getParamName())));
//                } else if (item instanceof FunctionExpressionParamItem) {
//                    FunctionExpressionParamItem it = (FunctionExpressionParamItem) item;
//                    expressions.add(it.asExpression(this));
//                } else if (item instanceof ConstantValueParamItem) {
//                    ConstantValueParamItem it = (ConstantValueParamItem) item;
//                    expressions.add(SQLUtils.getConstantExpressionFromParam(it.getValue()));
//                }
            }
            update.setColumns(columns);
            update.setExpressions(expressions);
        }
        return this;
    }

    public SQLUpdate items(String column, String valueParam, FieldDataTypeInterface type) {
        items(new JDBCParamParamItem(null, column, valueParam, type));
        return this;
    }

    public SQLUpdate items(String tableAlis, String item, String paramName, FieldDataTypeInterface dataType){
        items(new JDBCParamParamItem(tableAlis,item,paramName,dataType));
        return this;
    }

    @Override
    public SQLUpdate where(String tableAlis, String item, String paramName, FieldDataTypeInterface dataType) {
        return super.where(tableAlis, item, paramName, dataType);
    }

    @Override
    public SQLUpdate where(LogicalOpType logicalOpType, String item, String paramName, FieldDataTypeInterface dataType) {
        return super.where(logicalOpType, item, paramName, dataType);
    }

    @Override
    public SQLUpdate where(String item, String paramName, FieldDataTypeInterface dataType) {
        return super.where(item, paramName, dataType);
    }

    @Override
    public SQLUpdate where(String item, FieldDataTypeInterface dataType) {
        return super.where(item, dataType);
    }

    @Override
    public SQLUpdate where(LogicalRelationshipType type, LogicalOpType logicalOpType, String tableAlis, String item, String paramName, FieldDataTypeInterface dataType) throws SQLBuilderException {
        return super.where(type, logicalOpType, tableAlis, item, paramName, dataType);
    }

    @Override
    public SQLUpdate where(LogicalRelationshipType type, String tableAlis, String item, String paramName, FieldDataTypeInterface dataType) {
        return super.where(type, tableAlis, item, paramName, dataType);
    }

    @Override
    public SQLUpdate where(LogicalRelationshipType type, String item, String paramName, FieldDataTypeInterface dataType) {
        return super.where(type, item, paramName, dataType);
    }

    @Override
    public SQLUpdate where(LogicalRelationshipType type, String item, FieldDataTypeInterface dataType) {
        return super.where(type, item, dataType);
    }

    @Override
    public SQLUpdate where(LogicalRelationshipType type, String tableAlis, String item, OperationType opType, SQLSelect subQuery) {
        return super.where(type, tableAlis, item, opType, subQuery);
    }

    @Override
    public SQLUpdate where(ParamItem... item) {
        return super.where(item);
    }

    @Override
    public SQLUpdate where(LogicalRelationshipType type, LogicalOpType logicalOpType, ParamItem... item) throws SQLBuilderException {
        return super.where(type, logicalOpType, item);
    }

    @Override
    public SQLUpdate order(boolean asc, String... item) {
        return super.order(asc, item);
    }

    @Override
    public SQLUpdate order(boolean asc, GenricExpression... item) {
        return super.order(asc, item);
    }

    @Override
    public SQLUpdate setLimit(int start, int count) {
        return super.setLimit(start, count);
    }

    @Override
    public SQLUpdate setLimit(int count) {
        return super.setLimit(count);
    }

    @Override
    public <V> SQLUpdate constantItems(String item, V value) {
        return super.constantItems(item, value);
    }

    @Override
    public <V> SQLUpdate constantItems(String table, String item, V value) {
        return super.constantItems(table, item, value);
    }

    @Override
    public SQLUpdate funcItems(String item, String funcName) {
        return super.funcItems(item, funcName);
    }

    @Override
    public SQLUpdate items(String... item) {
        return super.items(item);
    }

    @Override
    public SQLUpdate items(FieldDataTypeInterface type, String... item) {
        return super.items(type, item);
    }

    @Override
    public SQLUpdate items(String item, FieldDataTypeInterface dataType) {
        return super.items(item, dataType);
    }

    @Override
    public Set<String> getAllTable() {
        return SQLUtils.getSelectAllTable(update);
    }

    @Override
    protected boolean removeItems(String item) {
        return false;
    }
}
