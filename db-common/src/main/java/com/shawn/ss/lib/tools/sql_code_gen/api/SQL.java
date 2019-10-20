package com.shawn.ss.lib.tools.sql_code_gen.api;

import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model.ColumnDataType;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model.LogicalOpType;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model.LogicalRelationshipType;
//import com.shawn.ss.lib.tools.sql_code_gen.api.expressions.Expr;
import com.shawn.ss.lib.tools.sql_code_gen.api.expressions.Expr;
import com.shawn.ss.lib.tools.sql_code_gen.api.stategy.TableSplitStategy;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.schema.Table;

import java.util.List;

public interface SQL<T extends SQL> {

    public static enum SqlType {
        select, insert, update, delete
    }
//    T switchBody(int i);
//    T bodys();
    T rawWhere(String expression);

    T rawWhereItem(String expression);
    T rawWhereItem(LogicalRelationshipType type, String expression);

    T itemWhere(String item);
    T itemWhere(String item, ColumnDataType dataType);
    T itemWhere(LogicalRelationshipType type,String item, ColumnDataType dataType);
    T itemWhere(String item,String paramName, ColumnDataType dataType);
    T itemWhere(LogicalOpType opType,String item,String paramName, ColumnDataType dataType);
    T itemWhere(LogicalOpType opType,String table,String item,String paramName, ColumnDataType dataType);
    T itemWhere(LogicalOpType opType,String db,String table,String item,String paramName, ColumnDataType dataType);
    T itemWhere(LogicalRelationshipType type,String item,String paramName, ColumnDataType dataType);
    T itemWhere(LogicalRelationshipType type,String table,String item,String paramName, ColumnDataType dataType);
    T itemWhere(LogicalRelationshipType type,String db,String table,String item,String paramName, ColumnDataType dataType);
    T itemWhere(LogicalRelationshipType type, LogicalOpType opType,  String table, String item, String paramName, ColumnDataType dataType);
    T itemWhere(LogicalRelationshipType type, LogicalOpType opType, String db, String table, String item, String paramName, ColumnDataType dataType);

    T itemCol(String item);
    T itemCol(String item,String alias);
    T itemCol(String table,String item,String alias);
    T itemCol(String db,String table,String item,String alias);

    T table(String table);
    T table(String db,String table);
    T table(String db,String table,String alias);
//    T table(String table, TableSplitStategy stategy);
//    T table(String db,String table, TableSplitStategy stategy);

    T order(boolean asc,String item);
    T order(boolean asc,String table,String item);
    T rawOrder(boolean asc,String expression);

    T limit();
    T limit(boolean hasStart);
    T limit(Integer count);
    T limit(Integer start,Integer count);

    String getSql(String type);
//    SQL parse(String sql);
    List<String> tables();

    Expr wheres();

    SqlType getType();
}
