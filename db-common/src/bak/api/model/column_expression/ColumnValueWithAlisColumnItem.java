package com.shawn.ss.lib.tools.service_assemble.api.bak.api.model.column_expression;

import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model.CommonOpType;
import com.shawn.ss.lib.tools.service_assemble.api.bak.api.model.GenricExpression;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.statement.HasAlias;
import net.sf.jsqlparser.statement.HasMainTable;

/**
 * Created by ss on 2017/10/21.
 */
public class ColumnValueWithAlisColumnItem extends ColumnValueColumnItem implements HasAlias{

    String itemAlis;
//    String tableAlis;
//    String columnItem;

    public ColumnValueWithAlisColumnItem(String tableAlis, String columnItem, String itemAlis) {
        super(tableAlis,columnItem);
//        this.tableAlis = tableAlis;
//        this.columnItem = columnItem;
        this.itemAlis = itemAlis;
    }



    public String getAlias() {
        return itemAlis;
    }

    public ColumnValueWithAlisColumnItem setAlias(String itemAlis) {
        this.itemAlis = itemAlis;
        return this;
    }

//    @Override
//    public Expression asExpression(HasMainTable sql) {
//        return null;
//    }
//
//    @Override
//    public GenricExpression joinExpression(GenricExpression other, CommonOpType type) {
//        return null;
//    }

}
