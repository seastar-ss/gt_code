package com.shawn.ss.lib.tools.sql_code_gen.api;

import com.shawn.ss.lib.tools.sql_code_gen.api.expressions.Expr;
//import net.sf.jsqlparser.expression.Expression;

import java.util.List;
import java.util.Map;

public interface SQLSelect extends SQL<SQLSelect> {
    SQLSelect rawSelectItem(String item, String alias);

    SQLSelect rawHaving(String item);

    SQLSelect rawGroup(String item);

    SQLSelect itemGroup(String item);

//    SQLSelect itemGroup(String... item);

    Map<String,Expr> selectItems();

    SQLSelect switchBody(int i);

    List<SQLSelect> bodies();

    SQLSelect body(SQLSelect body);

    SQLSelect join(String table, boolean inner, String condition);

    SQLSelect joinByCol(String table, boolean inner, String thisCol, String otherCol, String extCondition);

    SQLSelect join(SQLSelect body, boolean inner, String condition);

    SQLSelect joinByCol(SQLSelect body, boolean inner, String thisCol, String otherCol, String extCondition);

    int removeAllSelectItem();

}
