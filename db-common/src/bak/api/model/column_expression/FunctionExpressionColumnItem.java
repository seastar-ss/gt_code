package com.shawn.ss.lib.tools.service_assemble.api.bak.api.model.column_expression;

import com.shawn.ss.lib.tools.CollectionHelper;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model.CommonOpType;
import com.shawn.ss.lib.tools.service_assemble.api.bak.api.SQLUtils;
import com.shawn.ss.lib.tools.service_assemble.api.bak.api.model.FunctionItemInterface;
import com.shawn.ss.lib.tools.service_assemble.api.bak.api.model.GenricExpression;
import com.shawn.ss.lib.tools.service_assemble.api.bak.api.model.OperationType;
import net.sf.jsqlparser.expression.BinaryExpression;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.Function;
import net.sf.jsqlparser.expression.operators.relational.ExpressionList;
import net.sf.jsqlparser.schema.Column;
import net.sf.jsqlparser.statement.HasMainTable;

import java.util.List;

/**
 * Created by ss on 2017/10/21.
 */
public class FunctionExpressionColumnItem extends ColumnItem implements FunctionItemInterface {
    private String funcName;
    private boolean all, distinct;
    private List<GenricExpression> paramList;
    private final CommonOpType functionType;
    private final boolean common;
    private transient boolean paramEnough = false;
//    private Function function;

    public FunctionExpressionColumnItem(String funcName) {
        super();
        CommonOpType functionType = CommonOpType.getEnumByName(funcName);
        if (functionType == null) {
            this.funcName = funcName;
            common = false;
            this.functionType = null;
        } else {
            this.functionType = functionType;
            common = true;
        }
        all = true;
        distinct = false;
    }

    public FunctionExpressionColumnItem(CommonOpType funcName) {
        super();
        this.functionType = funcName;
        all = false;
        distinct = false;
        common = true;
    }

    protected FunctionExpressionColumnItem(CommonOpType funcName, GenricExpression left, GenricExpression right) {
        super();
        this.functionType = funcName;
        all = false;
        distinct = false;
        common = true;
        addParam(left);
        addParam(right);
        paramEnough = true;
    }

//    protected Function getExpression() {
//        return function;
//    }
//
//    protected void setExpression(Function func) {
//        this.function = func;
//    }

    public List<GenricExpression> getParamList() {
        return paramList;
    }

    public int sizeOfParam() {
        return paramList == null ? 0 : paramList.size();
    }

    @Override
    public FunctionItemInterface addParam(String table, String column) {
        return addParam(new ColumnValueColumnItem(table, column));
    }

    @Override
    public <T> FunctionItemInterface addParam(T value) {
        return addParam(new ConstantValueColumnItem<T>(value));
    }

//    public boolean addParam(String table,String column,String alias) {
//
//        return addParam(new ColumnValueParamItem());
//    }

    public FunctionItemInterface addParam(GenricExpression paramItem) {
        if (!paramEnough) {
            if (paramList == null) {
                paramList = CollectionHelper.newList();
            }
            paramList.add(paramItem);
        }
        return this;
    }

    public boolean isAll() {
        return all;
    }

    public FunctionItemInterface setAll(boolean all) {
        this.all = all;
        return this;
    }

    public String getFuncName() {
        return funcName;
    }

    public FunctionItemInterface setFuncName(String funcName) {
        this.funcName = funcName;
        return this;
    }

    public boolean isDistinct() {
        return distinct;
    }

    @Override
    public boolean isCommon() {
        return common;
    }

    @Override
    public CommonOpType getFuncType() {
        return functionType;
    }

    public FunctionItemInterface setDistinct(boolean distinct) {
        this.distinct = distinct;
        return this;
    }

    @Override
    public Expression asExpression(HasMainTable sql) {
        int size = paramList==null?0:paramList.size();
        if(common){
            OperationType type= SQLUtils.getExp(this.functionType);
            if(type!=null) {
                if (paramList != null && !paramList.isEmpty()) {
                    if (size == 1) {
                        return type.getExpression(sql, paramList.get(0));
                    }else if (size == 2) {
                        return type.getExpression(sql, paramList.get(0), paramList.get(1));
                    } else {
                        GenricExpression[] gs=new GenricExpression[size];
                        gs=paramList.toArray(gs);
                        return type.getExpression(sql,gs);
                    }
                }
            }
//            BinaryExpression binaryExpression = type.expressionType();
//            if(binaryExpression==null){
//
//            }else{
//
//            }
        }else {
            Function function = new Function();
            function.setAllColumns(all);
            function.setDistinct(distinct);
            function.setName(funcName);
            if (paramList != null && size > 0) {
                ExpressionList list = function.getParameters();
                List<Expression> expList;
                if (list == null) {
                    expList = CollectionHelper.newList();
                    list = new ExpressionList(expList);
                } else {
                    expList = list.getExpressions();
                }
                for (GenricExpression item : paramList) {
                    expList.add(item.asExpression(sql));
                }
                list.setExpressions(expList);
                function.setParameters(list);
            }
            return function;
        }
        return null;
    }

    @Override
    public GenricExpression joinExpression(GenricExpression other, CommonOpType type) {
        return super.joinExpression(other, type);
    }
}
