package com.shawn.ss.lib.tools.service_assemble.api.bak.api;

import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model.FieldDataTypeInterface;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model.LogicalOpType;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model.LogicalRelationshipType;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.factory.Config;
import com.shawn.ss.lib.tools.sql_code_gen.api.model.*;
import com.shawn.ss.lib.tools.sql_code_gen.api.model.column_and_param_expression.ParamItem;
import com.shawn.ss.lib.tools.sql_code_gen.api.model.column_expression.ColumnItem;
import net.sf.jsqlparser.statement.*;
import net.sf.jsqlparser.statement.delete.Delete;

import java.util.Set;

/**
 * Created by ss on 2017/10/12.
 */
public class SQLDelete extends SQL<SQLDelete> {


    private final Delete delete;

    protected SQLDelete(Delete delete) {
        super(SqlType.delete);
        this.delete = delete;
        setMainTB(this.delete);
    }

    protected SQLDelete() {
        super(SqlType.delete);
        delete = new Delete();
    }

    @Override
    public HasWhereClause getWhereBase() {
        return delete;
    }

    @Override
    public HasOrderClause getOrderBase() {
        return delete;
    }

    @Override
    public HasLimitClause getLimitBase() {
        return delete;
    }

    @Override
    public HasMainTable getMainTableHandler() {
        return delete;
    }

    @Override
    public String getSql(Config.LibType type) {
        return delete.toString();
    }

//    @Override
//    public SQLDelete parseSql(String sql, Config.LibType unionRelations) {
//        return this;
//    }

    @Override
    protected SQLDelete items(ColumnItem... items) {
        return this;
    }

    @Override
    protected SQLDelete items(ParamItem... item) {
        return this;
    }

    @Override
    public SQLDelete where(String tableAlis, String item, String paramName, FieldDataTypeInterface dataType) {
        return super.where(tableAlis, item, paramName, dataType);
    }

    @Override
    public SQLDelete where(LogicalOpType logicalOpType, String item, String paramName, FieldDataTypeInterface dataType) {
        return super.where(logicalOpType, item, paramName, dataType);
    }

    @Override
    public SQLDelete where(String item, String paramName, FieldDataTypeInterface dataType) {
        return super.where(item, paramName, dataType);
    }

    @Override
    public SQLDelete where(String item, FieldDataTypeInterface dataType) {
        return super.where(item, dataType);
    }

    @Override
    public SQLDelete where(LogicalRelationshipType type, LogicalOpType logicalOpType, String tableAlis, String item, String paramName, FieldDataTypeInterface dataType) throws SQLBuilderException {
        return super.where(type, logicalOpType, tableAlis, item, paramName, dataType);
    }

    @Override
    public SQLDelete where(LogicalRelationshipType type, String tableAlis, String item, String paramName, FieldDataTypeInterface dataType) {
        return super.where(type, tableAlis, item, paramName, dataType);
    }

    @Override
    public SQLDelete where(LogicalRelationshipType type, String item, String paramName, FieldDataTypeInterface dataType) {
        return super.where(type, item, paramName, dataType);
    }

    @Override
    public SQLDelete where(LogicalRelationshipType type, String item, FieldDataTypeInterface dataType) {
        return super.where(type, item, dataType);
    }

    @Override
    public SQLDelete where(LogicalRelationshipType type, String tableAlis, String item, OperationType opType, SQLSelect subQuery) {
        return super.where(type, tableAlis, item, opType, subQuery);
    }

    @Override
    public SQLDelete where(ParamItem... item) {
        return super.where(item);
    }

    @Override
    public SQLDelete where(LogicalRelationshipType type, LogicalOpType logicalOpType, ParamItem... item) throws SQLBuilderException {
        return super.where(type, logicalOpType, item);
    }

    @Override
    public SQLDelete order(boolean asc, String... item) {
        return super.order(asc, item);
    }

    @Override
    public SQLDelete order(boolean asc, GenricExpression... item) {
        return super.order(asc, item);
    }

    @Override
    public SQLDelete setLimit(int start, int count) {
        return super.setLimit(start, count);
    }

    @Override
    public SQLDelete setLimit(int count) {
        return super.setLimit(count);
    }

    //    public SQLDelete items(String... item) {
//        return (SQLDelete) this;
//    }
//
//    public SQLDelete items(String item) {
//        return (SQLDelete) this;
//    }

    //    public SQLDelete mainTable(String table) {
//        return this;
//    }
//
//    public SQLDelete mainTable(String data_store, String table, String alias) {
//        return this;
//    }
    @Override
    public Set<String> getAllTable() {
        return SQLUtils.getSelectAllTable(delete);
    }

    @Override
    protected boolean removeItems(String item) {
        return false;
    }
}
