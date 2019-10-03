package com.shawn.ss.lib.tools.service_assemble.api.bak.api.model;

import com.shawn.ss.lib.tools.CollectionHelper;
import com.shawn.ss.lib.tools.service_assemble.api.bak.api.SQL;
import com.shawn.ss.lib.tools.service_assemble.api.bak.api.SQLBuilderException;
import com.shawn.ss.lib.tools.service_assemble.api.bak.api.SQLUtils;
import com.shawn.ss.lib.tools.sql_code_gen.api.model.column_and_param_expression.*;
import net.sf.jsqlparser.expression.*;
import net.sf.jsqlparser.expression.operators.arithmetic.*;
import net.sf.jsqlparser.expression.operators.conditional.AndExpression;
import net.sf.jsqlparser.expression.operators.conditional.OrExpression;
import net.sf.jsqlparser.expression.operators.relational.*;
import net.sf.jsqlparser.schema.Column;
import net.sf.jsqlparser.schema.Table;
import net.sf.jsqlparser.statement.HasMainTable;

import java.util.Arrays;
import java.util.List;

/**
 * Created by ss on 16/4/24.
 */
public enum OperationType {
    plus(" + ") {
        @Override
        public BinaryExpression expressionType() {
            return new Addition();
        }
    }, minus(" - ") {
        @Override
        public BinaryExpression expressionType() {
            return new Subtraction();
        }
    }, multiply(" * ") {
        @Override
        public BinaryExpression expressionType() {
            return new Multiplication();
        }
    }, devide(" / ") {
        @Override
        public BinaryExpression expressionType() {
            return new Division();
        }
    }, mod(" % ") {
        @Override
        public BinaryExpression expressionType() {
            return new Modulo();
        }
    }, or(" || ") {
        @Override
        public BinaryExpression expressionType() {
            return new OrExpression();
        }

    }, and(" && ") {
        @Override
        public BinaryExpression expressionType() {
            return new AndExpression();
        }

    }, xor(" xor ") {
        @Override
        public BinaryExpression expressionType() {
            return new BitwiseXor();
        }

    }, no(" not ") {
        @Override
        public BinaryExpression expressionType() {
            return null;
        }

        @Override
        public Expression getExpression(HasMainTable sql, GenricExpression lExpr, GenricExpression rExpr) {
            throw SQLBuilderException.unsupportException();
        }

        @Override
        public Expression getExpression(HasMainTable sql, GenricExpression exprs) {
//             isnull = new IsNullExpression();
//            isnull.setLeftExpression(exprs.asExpression(sql));
//            isnull.setNot(not);
//            return isnull;
            throw SQLBuilderException.unsupportException();
        }

        @Override
        public Expression getExpression(HasMainTable sql, GenricExpression... exprs) {
            throw SQLBuilderException.unsupportException();
        }
    }, eq("=") {
        @Override
        public BinaryExpression expressionType() {
            return new EqualsTo();
        }
    }, neq("!=", true) {
        @Override
        public BinaryExpression expressionType() {
            return new EqualsTo();
        }


    }, lt("<") {
        @Override
        public BinaryExpression expressionType() {
            return new MinorThan();
        }


    }, gt(">") {
        @Override
        public BinaryExpression expressionType() {
            return new GreaterThan();
        }


    }, gteq(">=") {
        @Override
        public BinaryExpression expressionType() {
            return new GreaterThanEquals();
        }


    }, lteq("<=") {
        @Override
        public BinaryExpression expressionType() {
            return new MinorThanEquals();
        }


    }, like("like") {
        @Override
        public BinaryExpression expressionType() {
            return new LikeExpression();
        }

        public Expression getExpression(HasMainTable sql, GenricExpression lExpr, GenricExpression rExpr) {
            LikeExpression ret = new LikeExpression();
            ret.setLeftExpression(lExpr.asExpression(sql));
            Function func = new Function();
            func.setName("concat");
            ExpressionList list = new ExpressionList(Arrays.<Expression>asList(new StringValue("'%'"), rExpr.asExpression(sql), new StringValue("'%'")));
            func.setParameters(list);
            ret.setRightExpression(func);
//            ret.setNot(not);
            return ret;
        }

        public Expression getExpression( Expression lExpr, Expression rExpr) {
            LikeExpression ret = new LikeExpression();
            ret.setLeftExpression(lExpr);
            Function func = new Function();
            func.setName("concat");
            ExpressionList list = new ExpressionList(Arrays.<Expression>asList(new StringValue("'%'"), rExpr, new StringValue("'%'")));
            func.setParameters(list);
            ret.setRightExpression(func);
//            ret.setNot(not);
            return ret;
        }
    }, notLike("not like", true) {
        @Override
        public BinaryExpression expressionType() {
            return new LikeExpression();
        }

        public Expression getExpression( Expression lExpr, Expression rExpr) {
            final LikeExpression expression = (LikeExpression) like.getExpression( lExpr, rExpr);
            expression.setNot(not);
            return expression;
        }

        public Expression getExpression(HasMainTable sql, GenricExpression lExpr, GenricExpression rExpr) {
            final LikeExpression expression = (LikeExpression) like.getExpression(sql, lExpr, rExpr);
            expression.setNot(not);
            return expression;
        }

    }, in("in") {
        @Override
        public BinaryExpression expressionType() {
            return null;
        }

        public Expression getExpression(HasMainTable sql, GenricExpression lExpr, GenricExpression rExpr) {
            InExpression in = new InExpression();

            in.setLeftExpression(lExpr.asExpression(sql));
            List<Expression> lists = CollectionHelper.newList(rExpr.asExpression(sql));
            ExpressionList items = new ExpressionList(lists);
            in.setRightItemsList(items);
            in.setNot(not);
            return in;
        }

        @Override
        public Expression getExpression(HasMainTable sql, GenricExpression exprs) {
            throw SQLBuilderException.unsupportException();
        }

        @Override
        public Expression getExpression(HasMainTable sql, GenricExpression... exprs) {
            if (exprs.length >= 2) {
                if (exprs[0] != null) {
                    InExpression in = new InExpression();
                    in.setLeftExpression(exprs[0].asExpression(sql));
                    List<Expression> lists = CollectionHelper.newList(exprs.length - 1);
                    for (int i = 1; i < exprs.length; ++i) {
                        GenricExpression exp = exprs[i];
                        lists.add(exp.asExpression(sql));
                    }
                    ExpressionList items = new ExpressionList(lists);
                    in.setRightItemsList(items);
                    in.setNot(not);
                    return in;
                }
            }
//            else{
            return null;
//            }
        }

        @Override
        public Expression getExpression(Expression expr, Expression[] exprs) {
            InExpression in = new InExpression();
            in.setLeftExpression(expr);
            List<Expression> expressions = Arrays.asList(exprs);
            ExpressionList list=new ExpressionList();
            list.setExpressions(expressions);
            in.setRightItemsList(list);
//            in.setNot(not);
            return in;
        }
    }, notIn("not in", true) {
        @Override
        public BinaryExpression expressionType() {
            return null;
        }

        //        @Override
        public Expression getExpression(HasMainTable sql, GenricExpression lExpr, GenricExpression rExpr) {
            final InExpression expression = (InExpression) in.getExpression(sql, lExpr, rExpr);
            expression.setNot(not);
            return expression;
        }

        @Override
        public Expression getExpression(HasMainTable sql, GenricExpression exprs) {
            throw SQLBuilderException.unsupportException();
        }

        @Override
        public Expression getExpression(HasMainTable sql, GenricExpression... exprs) {
            InExpression expression = (InExpression) in.getExpression(sql, exprs);
            expression.setNot(not);
            return expression;
//            }
        }

        @Override
        public Expression getExpression(Expression expr, Expression[] exprs) {
            InExpression expression = (InExpression) in.getExpression(expr, exprs);
            expression.setNot(not);
            return expression;
        }
    }, isNull("is null") {
        @Override
        public BinaryExpression expressionType() {
            return null;
        }

        //        @Override
        public Expression getExpression(HasMainTable sql, GenricExpression lExpr, GenricExpression rExpr) {
            throw SQLBuilderException.unsupportException();
        }

        @Override
        public Expression getExpression(HasMainTable sql, GenricExpression exprs) {
            IsNullExpression isnull = new IsNullExpression();
            isnull.setLeftExpression(exprs.asExpression(sql));
            isnull.setNot(not);
            return isnull;
        }

        @Override
        public Expression getExpression(HasMainTable sql, GenricExpression... exprs) {
            throw SQLBuilderException.unsupportException();
        }

        @Override
        public Expression getExpression(Expression left) {
            IsNullExpression isnull = new IsNullExpression();
            isnull.setLeftExpression(left);
            isnull.setNot(not);
            return isnull;
//            return super.getExpression(left);
        }
    }, isNotNull("is not null", true) {
        @Override
        public BinaryExpression expressionType() {
            return null;
        }

        @Override
        public Expression getExpression(HasMainTable sql, GenricExpression lExpr, GenricExpression rExpr) {
            throw SQLBuilderException.unsupportException();
        }

        @Override
        public Expression getExpression(HasMainTable sql, GenricExpression exprs) {
            IsNullExpression isnull = new IsNullExpression();
            isnull.setLeftExpression(exprs.asExpression(sql));
            isnull.setNot(not);
            return isnull;
        }

        @Override
        public Expression getExpression(HasMainTable sql, GenricExpression... exprs) {
            throw SQLBuilderException.unsupportException();
        }

        @Override
        public Expression getExpression(Expression left) {
            IsNullExpression isnull = new IsNullExpression();
            isnull.setLeftExpression(left);
            isnull.setNot(not);
            return isnull;
//            return super.getExpression(left);
        }

        //        @Override
//        public Expression getExpression(String param, Table table) {
//            IsNullExpression isnull = new IsNullExpression();
//            isnull.setLeftExpression(new Column(table, param));
//            isnull.setNot(true);
//            return isnull;
//        }


//        @Override
//        public Expression getExpression(HasMainTable sql, ParamItem params) {
//            IsNullExpression isNullExpression = buildIsNull(sql, params);
//            if (isNullExpression == null) {
//                return null;
//            }
//            isNullExpression.setNot(true);
//            return isNullExpression;
//        }
    };
    public final String symbol;
    public final boolean not;

    OperationType(String symbol) {
        this(symbol, false);
    }

    OperationType(String symbol, boolean not) {
        this.symbol = symbol;
        this.not = not;
    }

    public abstract BinaryExpression expressionType();

    protected static Table getTable(HasMainTable sql, ParamItem params) {
        return SQLUtils.getTableForAlias(sql, params.getTableAlis());
    }

    protected static IsNullExpression buildIsNull(HasMainTable sql, ParamItem params) {
        if (params == null) return null;
        Table table = getTable(sql, params);
        IsNullExpression isnull = new IsNullExpression();
        isnull.setLeftExpression(new Column(table, params.getColumnItem()));
        return isnull;
    }

    protected static LikeExpression buildLike(HasMainTable sql, ParamItem params) {
        if (params == null) return null;
        Table table = getTable(sql, params);
        if (params instanceof JDBCParamParamItem) {
            JDBCParamParamItem prm = (JDBCParamParamItem) params;
            LikeExpression ret = new LikeExpression();
            ret.setLeftExpression(new Column(table, prm.getColumnItem()));
            Function func = new Function();
            func.setName("concat");
            ExpressionList list = new ExpressionList(Arrays.<Expression>asList(new JdbcNamedParameter(prm.getParamName()), new StringValue("'%'")));
            func.setParameters(list);
            ret.setRightExpression(func);
            return ret;
        }
        return null;
    }

    protected static InExpression buildIn(HasMainTable sql, ParamItem params) {
        if (params == null) return null;
        Table table = getTable(sql, params);
        if (params instanceof JDBCParamParamItem) {
            JDBCParamParamItem prm = (JDBCParamParamItem) params;
            InExpression in = new InExpression();
            in.setLeftExpression(new Column(table, prm.getColumnItem()));
            List<Expression> lists = CollectionHelper.newList((Expression) (new JdbcNamedParameter(prm.getParamName())));
            ExpressionList items = new ExpressionList(lists);
            in.setRightItemsList(items);
            return in;
        }
        return null;
    }

//    public Expression getExpression(String param, Table table) {
//        BinaryExpression binaryExpression = this.expressionType();
//        if (binaryExpression != null) {
//            binaryExpression.setLeftExpression(new Column(table, param));
//            binaryExpression.setRightExpression(new JdbcNamedParameter(param));
//            if (not) {
//                binaryExpression.setNot();
//            }
//            return binaryExpression;
//        }
//        return null;
//    }

    public Expression getExpression(HasMainTable sql, GenricExpression lExpr, GenricExpression rExpr) {
        return getExpression(lExpr.asExpression(sql), rExpr.asExpression(sql));
    }

    public Expression getExpression(HasMainTable sql, GenricExpression exprs) {
        throw SQLBuilderException.unsupportException();
    }

    public Expression getExpression(HasMainTable sql, GenricExpression... exprs) {
        throw SQLBuilderException.unsupportException();
    }

//    public Expression getExpression(HasMainTable sql, ParamItem params) {
//        if (params == null) return null;
//        BinaryExpression binaryExpression = this.expressionType();
//        if (binaryExpression != null) {
////            Table table = getTable(sql, params);
////            if (params instanceof JDBCParamParamItem) {
////                JDBCParamParamItem prm = (JDBCParamParamItem) params;
////                binaryExpression.setLeftExpression(new Column(table, prm.getColumnItem()));
////                binaryExpression.setRightExpression(new JdbcNamedParameter(prm.getParamName()));
////            } else if (params instanceof ColumnValueParamItem) {
////                Table right;
////                ColumnValueParamItem prm = (ColumnValueParamItem) params;
////                String valueColumnTable = prm.getValueColumnTable();
////                if (valueColumnTable == null) {
////                    right = table;
////                } else {
////                    right = new Table(valueColumnTable);
////                }
////                binaryExpression.setLeftExpression(new Column(table, prm.getColumnItem()));
////                binaryExpression.setRightExpression(new Column(right, prm.getValueColumn()));
////            } else if (params instanceof ConstantValueParamItem) {
////                ConstantValueParamItem prm = (ConstantValueParamItem) params;
////                Expression expression = SQLUtils.getConstantExpressionFromParamItem(prm.getValue(), prm.getType());
////                binaryExpression.setLeftExpression(new Column(table, prm.getColumnItem()));
////                binaryExpression.setRightExpression(expression);
////            } else if (params instanceof FunctionExpressionParamItem) {
////                FunctionExpressionParamItem prm = (FunctionExpressionParamItem) params;
////                Expression expression = SQLUtils.getFuncExpressionFromColumnItem(sql, prm);
////                binaryExpression.setLeftExpression(new Column(table, prm.getColumnItem()));
////                binaryExpression.setRightExpression(expression);
////            }
//////            binaryExpression.setLeftExpression(new Column(table, column));
//////            binaryExpression.setRightExpression(new JdbcNamedParameter(param));
////            if (not) {
////                binaryExpression.setNot();
////            }
//            return binaryExpression;
//        }
//        return null;
//    }

    //    public Expression getExpression(String param, String column, Table table) {
//        BinaryExpression binaryExpression = this.expressionType();
//        if (binaryExpression != null) {
//            binaryExpression.setLeftExpression(new Column(table, column));
//            binaryExpression.setRightExpression(new JdbcNamedParameter(param));
//            if (not) {
//                binaryExpression.setNot();
//            }
//            return binaryExpression;
//        }
//        return null;
//    }
//
    public Expression getExpression(Expression expr,Expression[] exprs) {
        throw SQLBuilderException.unsupportException();
    }

    public Expression getExpression(Expression left) {
        throw SQLBuilderException.unsupportException();
    }

    public Expression getExpression(Expression left, Expression right) {
        BinaryExpression binaryExpression = this.expressionType();
        if (binaryExpression != null) {
            binaryExpression.setLeftExpression(left);
            binaryExpression.setRightExpression(right);
            if (not) {
                binaryExpression.setNot();
            }
            return binaryExpression;
        } else {
            throw SQLBuilderException.unsupportException();
        }
        //return null;
    }
}
