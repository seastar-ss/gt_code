package com.shawn.ss.lib.tools.service_assemble.api.bak.api.model.column_expression;

import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model.FieldDataTypeInterface;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model.CommonOpType;
import com.shawn.ss.lib.tools.service_assemble.api.bak.api.SQLUtils;
import com.shawn.ss.lib.tools.service_assemble.api.bak.api.model.GenricExpression;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.schema.Column;
import net.sf.jsqlparser.statement.HasMainTable;

/**
 * Created by ss on 2017/10/21.
 */
public class ColumnValueColumnItem extends ColumnItem{


    String tableAlis;
    String columnItem;

    public ColumnValueColumnItem(String tableAlis, String columnItem) {
        super();
        this.tableAlis = tableAlis;
        this.columnItem = columnItem;
    }

    public ColumnValueColumnItem(String tableAlis, String columnItem, FieldDataTypeInterface type) {
        super( type);
        this.tableAlis = tableAlis;
        this.columnItem = columnItem;
    }

    public String getTableAlis() {
        return tableAlis;
    }

    public void setTableAlis(String tableAlis) {
        this.tableAlis = tableAlis;
    }

    public String getColumnItem() {
        return columnItem;
    }

    public void setColumnItem(String columnItem) {
        this.columnItem = columnItem;
    }

    @Override
    public Expression asExpression(HasMainTable sql) {
        return new Column(SQLUtils.getTableForAlias(sql,this.getTableAlis()),this.getColumnItem());
    }

    @Override
    public GenricExpression joinExpression(GenricExpression other, CommonOpType type) {
        return super.joinExpression(other,type);
    }
}
