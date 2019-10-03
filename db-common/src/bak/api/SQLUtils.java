package com.shawn.ss.lib.tools.service_assemble.api.bak.api;

import com.shawn.ss.lib.tools.CollectionHelper;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model.*;
import com.shawn.ss.lib.tools.sql_code_gen.api.model.*;
import com.shawn.ss.lib.tools.sql_code_gen.api.model.column_and_param_expression.ParamItem;
import com.shawn.ss.lib.tools.sql_code_gen.api.model.column_expression.ColumnItem;
import net.sf.jsqlparser.expression.*;
import net.sf.jsqlparser.expression.operators.conditional.AndExpression;
import net.sf.jsqlparser.expression.operators.conditional.OrExpression;
import net.sf.jsqlparser.expression.operators.relational.ExpressionList;
import net.sf.jsqlparser.schema.Table;
import net.sf.jsqlparser.statement.HasMainTable;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.delete.Delete;
import net.sf.jsqlparser.statement.insert.Insert;
import net.sf.jsqlparser.statement.select.*;
import net.sf.jsqlparser.statement.update.Update;
import net.sf.jsqlparser.util.TablesNamesFinder;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by ss on 2017/10/21.
 */
public class SQLUtils {
    static Expression getFuncExpressionFromColumnItem(HasMainTable sql, FunctionItemInterface item) {
//        if(!item.isCommon()) {
//            return getFuncExpressionFromColumnItem(sql, item.getFuncName(), item.isAll(), item.isDistinct(), item.getParamList());
//        } else{
//            return getSpecialFuncExpression(sql,item.getFuncType(),item.isAll(),item.isDistinct(),item.getParamList());
//        }
        return null;
    }

    static Expression getSpecialFuncExpression(HasMainTable sql, CommonOpType funcType, boolean all, boolean distinct, List<ColumnItem> paramList) {
        Expression ret = null;
        int i = funcType.getVariableCount();
        if (paramList != null && paramList.size() == i) {

            switch (funcType) {
                case or:
//                    ret=new OrExpression()
                case and:
                case mod:
                case not:
                case xor:
                case plus:
                case minus:
                case devide:
                case multiply:
            }
        }
        return ret;
    }

    static Expression getFuncExpressionFromColumnItem(HasMainTable sql, String funcName, boolean all, boolean distinct, List<ColumnItem> paramList) {
        Function function = new Function();
        function.setAllColumns(all);
        function.setDistinct(distinct);
        function.setName(funcName);
        if (paramList != null && paramList.size() > 0) {
            ExpressionList list = function.getParameters();
            List<Expression> expList;
            if (list == null) {
                expList = CollectionHelper.newList();
                list = new ExpressionList(expList);
            } else {
                expList = list.getExpressions();
            }
            for (ColumnItem item : paramList) {
//                if (item instanceof ColumnValueColumnItem) {
//                    ColumnValueColumnItem it = (ColumnValueColumnItem) item;
//                    expList.add(new Column(getTableForAlias(sql, it.getTableAlis()), it.getColumnItem()));
//                } else if (item instanceof ConstantValueColumnItem) {
//                    ConstantValueColumnItem it = (ConstantValueColumnItem) item;
//                    expList.add(getConstantExpressionFromParamItem(it.getValue(), it.getType()));
//                } else if (item instanceof FunctionExpressionColumnItem) {
//                    FunctionExpressionColumnItem it = (FunctionExpressionColumnItem) item;
//                    expList.add(getFuncExpressionFromColumnItem(sql, it));
//                }
            }
            list.setExpressions(expList);
            function.setParameters(list);
        }
        return function;
    }

    public static <T> Expression getConstantExpressionFromParam(T value) {
        if (value == null) return null;
        FieldDataTypeInterface columnDataType = guessType(value);
        if (columnDataType != null) {
            return getConstantExpressionFromParamItem(value, columnDataType);
        }
        return null;
    }

    public static <T> Expression getConstantExpressionFromParamItem(T value, FieldDataTypeInterface dt) {
        if (value == null) return null;
        ColumnDataType dataType;

        if(dt instanceof ColumnDataType){
            dataType = (ColumnDataType)dt;
        }else {
            throw new IllegalArgumentException("wrong type for gen expression,should be enum fieldDataType");
        }
        switch (dataType) {
            case shortData:
            case intData:
            case longData:
            case byteData:
                return new LongValue(value.toString());
            case dateData:
                return new DateValue(value.toString());
            case stringData:
                return new StringValue(value.toString());
            case decimalData:
            case doubleData:
            case floatData:
                return new DoubleValue(value.toString());
        }
        return null;
    }

    public static Table getTableForAlias(HasMainTable sql, String alias) {
//        Table table=null;
//        String tableAlis = params.getTableAlis();
//        if (tableAlis != null) {
//            table = new Table(tableAlis);
//        } else {
//            if (sql != null)
//                table = sql.getTable();
//        }
//        return table;
        if (alias == null) {
            return sql == null ? null : sql.getTable();
        } else {
            return new Table(alias);
        }
    }

    public String genConditionPartStr(HasMainTable sql, Expression first, LogicalRelationshipType type, CommonOpType commonOps, ParamItem... params) {
        Expression expression = genConditionPart(sql, first, type, commonOps, params);
        return expression.toString();
    }

    static Expression genConditionPart(HasMainTable sql, Expression first, LogicalRelationshipType type, CommonOpType commonOps, ParamItem... params) {
//        HasWhereClause body = new NoodExpression();
        Expression current = null;
        if (params == null || params.length == 0) {
            return null;
        }
        current = first;
        for (ParamItem item : params) {
//            Table table = null;
//            String tableAlis = item.getTableAlis();
//            if (tableAlis != null) {
//
//                table = new Table(tableAlis);
////                tableAlis=mainTable.tbAlis;
////                if(tableAlis==null){
////                    throw new SQLBuilderException("应先设置主数据表");
////                }
//            } else {
//                if (mainTable != null) {
//                    table = mainTable.tb;
//                } else {
//                    throw new SQLBuilderException("应先设置主数据表");
//                }
//            }
//            if(item instanceof JDBCParamParamItem) {
//                JDBCParamParamItem it=(JDBCParamParamItem)item;
            Expression jexpr = item.asLogicalExpression(commonOps, sql);
            if (current == null) {
                current = jexpr;
            } else {
                if (type == LogicalRelationshipType.and) {
                    current = new AndExpression(current, jexpr);
                } else if (type == LogicalRelationshipType.or) {
                    current = new OrExpression(current, jexpr);
                }
            }
        }
//                body.setWhere(current);
//        }
//        Expression where = body.getWhere();
        return current;
//        return "";
    }


    public static FieldDataTypeInterface guessType(Object value) {
        if (value == null) {
            throw new SQLBuilderException("should not be null");
        }
        Class<?> contentType = value.getClass();
        if (contentType.equals(Integer.class) || contentType.equals(int.class)) {
            return ColumnDataType.intData;
        } else if (contentType.equals(Long.class) || contentType.equals(long.class)) {
            return ColumnDataType.longData;
        } else if (contentType.equals(Byte.class) || contentType.equals(byte.class)) {
            return ColumnDataType.byteData;
        } else if (contentType.equals(Character.class) || contentType.equals(char.class)) {
            return ColumnDataType.intData;
        } else if (contentType.equals(Boolean.class) || contentType.equals(boolean.class)) {
            return ColumnDataType.byteData;
        } else if (contentType.equals(Double.class) || contentType.equals(double.class)) {
            return ColumnDataType.doubleData;
        } else if (contentType.equals(Float.class) || contentType.equals(float.class)) {
            return ColumnDataType.floatData;
        } else if (contentType.equals(Short.class) || contentType.equals(short.class)) {
            return ColumnDataType.shortData;
        } else if (contentType.equals(String.class)) {
            return ColumnDataType.stringData;
        } else if (contentType.equals(Date.class)) {
            return ColumnDataType.dateData;
        } else {
            return ColumnDataType.stringData;
        }
    }

    public static CommonOpType getExp(LogicalOpType logicalOpType) {
        if (logicalOpType == null) {
            return CommonOpType.eq;
        }
        switch (logicalOpType) {
            case eq:
                return CommonOpType.eq;
            case neq:
                return CommonOpType.neq;
            case gt:
                return CommonOpType.gt;
            case gtEq:
                return CommonOpType.gtEq;
            case lt:
                return CommonOpType.lt;
            case ltEq:
                return CommonOpType.ltEq;
            case in:
                return CommonOpType.in;
            case notIn:
                return CommonOpType.notIn;
            case isNull:
                return CommonOpType.isNull;
            case notNull:
                return CommonOpType.notNull;
            case like:
                return CommonOpType.like;
            case notLike:
                return CommonOpType.notLike;
        }
        return null;
    }


    public static OperationType getExp(CommonOpType logicalOpType) {
        if (logicalOpType == null) {
            return OperationType.eq;
        }
        switch (logicalOpType) {
            case eq:
                return OperationType.eq;
            case neq:
                return OperationType.neq;
            case gt:
                return OperationType.gt;
            case gtEq:
                return OperationType.gteq;
            case lt:
                return OperationType.lt;
            case ltEq:
                return OperationType.lteq;
            case in:
                return OperationType.in;
            case notIn:
                return OperationType.notIn;
            case isNull:
                return OperationType.isNull;
            case notNull:
                return OperationType.isNotNull;
            case like:
                return OperationType.like;
            case notLike:
                return OperationType.notLike;
            case plus:
                return OperationType.plus;
            case minus:
                return OperationType.minus;
            case multiply:
                return OperationType.multiply;
            case devide:
                return OperationType.devide;
            case mod:
                return OperationType.mod;
            case xor:
                return OperationType.xor;
            case and:
                return OperationType.and;
            case or:
                return OperationType.or;
            case not:
                return OperationType.no;
        }
        return null;
    }

    static SetOperation getUnionExpression(UnionRelationshipType unionDistinct) {
        UnionOp ret = new UnionOp();
        ret.setAll(unionDistinct.equals(UnionRelationshipType.unionAll));
        ret.setDistinct(unionDistinct.equals(UnionRelationshipType.unionDistinct));
        return ret;
    }

    static List<SQLSelect> getSelectListFromBody(List<SelectBody> selects) {
        List<SQLSelect> ret = CollectionHelper.newList(selects.size());
        for (SelectBody body : selects) {
            if (body instanceof PlainSelect) {
                ret.add(new SQLSelect(body));
            } else if (body instanceof SetOperationList) {
                ret.add(new SQLMultipleSelect((SetOperationList) body));
            }
        }
        return ret;
    }

    public static Set<String> getSelectAllTable(Statement statement) {
        if (statement == null) {
            return null;
        }
        Set<String> ret = CollectionHelper.newSet();
//        getSelectAllTable(select.getSelectBody(), ret);
        TablesNamesFinder finder = new TablesNamesFinder();
        List<String> tableList = null;
        if (statement instanceof Select)
            tableList = finder.getTableList((Select) statement);
        else if (statement instanceof Insert)
            tableList = finder.getTableList((Insert) statement);
        else if (statement instanceof Update)
            tableList = finder.getTableList((Update) statement);
        else if (statement instanceof Delete)
            tableList = finder.getTableList((Delete) statement);
        if (tableList != null)
            ret.addAll(tableList);
        return ret;
    }

//    private static void getSelectAllTable(SelectBody body, Set<String> ret) {
//        if (body instanceof PlainSelect) {
//            PlainSelect select = (PlainSelect) body;
//            ExpressionVisitor visitor
//
//        } else if (body instanceof SetOperationList) {
//            SetOperationList selelect = (SetOperationList) body;
//
//
//        }
//    }

//     static List<UnionRelationshipType> getUnionTypeFromOp(List<SetOperation> operations) {
//        return null;
//    }
}
