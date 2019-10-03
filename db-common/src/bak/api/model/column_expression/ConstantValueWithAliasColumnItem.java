package com.shawn.ss.lib.tools.service_assemble.api.bak.api.model.column_expression;

import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model.CommonOpType;
import com.shawn.ss.lib.tools.service_assemble.api.bak.api.model.GenricExpression;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.statement.HasAlias;
import net.sf.jsqlparser.statement.HasMainTable;

/**
 * Created by ss on 2017/10/21.
 */
public class ConstantValueWithAliasColumnItem<T> extends ConstantValueColumnItem<T>  implements HasAlias {
    String alias;
//    FieldDataTypeInterface sqlType;
    T value;

//    String columnItem;

    public ConstantValueWithAliasColumnItem(String alias, T value) {
        super(value);
        this.alias = alias;
//        this.value = value;
//        setType(SQLUtils.guessType(value));
    }


    public String getAlias() {
        return alias;
    }

    public ConstantValueWithAliasColumnItem<T> setAlias(String alias) {
        this.alias = alias;
        return this;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
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
