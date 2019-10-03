package com.shawn.ss.lib.tools.sql_code_gen.api.impl;

import com.shawn.ss.lib.tools.sql_code_gen.api.SQLDelete;
import net.sf.jsqlparser.statement.common.*;
import net.sf.jsqlparser.statement.delete.Delete;

public class SQLDeleteImpl extends SQLImpl<SQLDelete> implements SQLDelete{
    Delete delete;

    public SQLDeleteImpl() {
        super(SqlType.delete);
        delete=new Delete();
    }

    public SQLDeleteImpl(Delete statement) {
        super(SqlType.delete);
        delete=statement;
    }

    @Override
    protected HasWhere getWhereHandler() {
        return delete;
    }

    @Override
    protected HasMainTable getMainTableHandler() {
        return delete;
    }

    @Override
    protected HasColumnExpression getColumnExpressionHandler() {
        return delete;
}

    @Override
    protected HasLimit getLimitHandler() {
        return delete;
    }

    @Override
    protected HasOrderBy getOrderByHandler() {
        return delete;
    }

    @Override
    public String getSql(String type) {
        return delete.toString();
    }
}
