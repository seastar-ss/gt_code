package com.shawn.ss.lib.tools.service_assemble.api.bak.api.model.column_and_param_expression;

import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model.FieldDataTypeInterface;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model.CommonOpType;
import com.shawn.ss.lib.tools.sql_code_gen.api.model.FunctionItemInterface;
import com.shawn.ss.lib.tools.sql_code_gen.api.model.GenricExpression;
import com.shawn.ss.lib.tools.sql_code_gen.api.model.LogicalExpression;
import com.shawn.ss.lib.tools.sql_code_gen.api.model.column_expression.FunctionExpressionColumnItem;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.statement.HasMainTable;

import java.util.List;

/**
 * Created by ss on 2017/10/21.
 */
public class FunctionExpressionParamItem extends ParamItem implements  LogicalExpression {

    FunctionExpressionColumnItem func;

//    private String funcName;
//    private boolean all, distinct;
//    private List<ColumnItem> paramList;
//    private final CommonOpType functionType;
//    private final boolean common;
////    private Function function;
//
    public FunctionExpressionParamItem(String tableAlis, String columnItem, String funcName, FieldDataTypeInterface type) {
        super(tableAlis, columnItem, type);
        func=new FunctionExpressionColumnItem(funcName);
    }

    public FunctionExpressionParamItem(String tableAlis, String columnItem, CommonOpType funcName, FieldDataTypeInterface type) {
        super(tableAlis, columnItem, type);
        func=new FunctionExpressionColumnItem(funcName);
    }

    public List<GenricExpression> getParamList() {
        return func.getParamList();
    }

    public FunctionItemInterface setFuncName(String funcName) {
        return func.setFuncName(funcName);
    }

//    @Override
    public FunctionItemInterface addParam(String table, String column) {
        return func.addParam(table, column);
    }

    public boolean isDistinct() {
        return func.isDistinct();
    }

//    @Override
    public <T> FunctionItemInterface addParam(T value) {
        return func.addParam(value);
    }

//    @Override
    public boolean isCommon() {
        return func.isCommon();
    }

//    @Override
    public CommonOpType getFuncType() {
        return func.getFuncType();
    }

    public String getFuncName() {
        return func.getFuncName();
    }

    public int sizeOfParam() {
        return func.sizeOfParam();
    }

    public FunctionItemInterface addParam(GenricExpression paramItem) {
        return func.addParam(paramItem);
    }

    public FunctionItemInterface setAll(boolean all) {
        return func.setAll(all);
    }

    public boolean isAll() {
        return func.isAll();
    }

    public FunctionItemInterface setDistinct(boolean distinct) {
        return func.setDistinct(distinct);
    }

    //
//
//    public CommonOpType getFuncType() {
//        return functionType;
//    }
//
////    public void setFuncType(CommonOpType functionType) {
////        this.functionType = functionType;
////    }
//
//    public boolean isCommon() {
//        return common;
//    }
//
//    //    protected Function getExpression() {
////        return function;
////    }
////
////    protected void setExpression(Function func) {
////        this.function = func;
////    }
//
//    @Override
//    public List<ColumnItem> getParamList() {
//        return paramList;
//    }
//
//    @Override
//    public int sizeOfParam() {
//        return paramList == null ? 0 : paramList.size();
//    }
//
//    @Override
//    public FunctionItemInterface addParam(String table, String column) {
//        return addParam(new ColumnValueColumnItem(table, column));
//    }
//
//    @Override
//    public <T> FunctionItemInterface addParam(T value) {
//        return addParam(new ConstantValueColumnItem<T>(value));
//    }
//
//    @Override
//    public FunctionItemInterface addParam(ColumnItem paramItem) {
//        if (paramList == null) {
//            paramList = CollectionHelper.newList();
//        }
//        paramList.add(paramItem);
//        return this;
//    }
//
//    @Override
//    public boolean isAll() {
//        return all;
//    }
//
//    @Override
//    public FunctionItemInterface setAll(boolean all) {
//        this.all = all;
//        if (all) {
//            this.paramList = null;
//        }
//        return this;
//    }
//
//    @Override
//    public String getFuncName() {
//        return funcName;
//    }
//
//    @Override
//    public FunctionItemInterface setFuncName(String funcName) {
//        this.funcName = funcName;
//        return this;
//    }
//
//    @Override
//    public boolean isDistinct() {
//        return distinct;
//    }
//
//    @Override
//    public FunctionItemInterface setDistinct(boolean distinct) {
//        this.distinct = distinct;
//        if (distinct) {
//            setAll(false);
//        }
//        return this;
//    }

    @Override
    public Expression asLogicalExpression(HasMainTable sql) {
        return asLogicalExpression(CommonOpType.eq,sql);
    }

    @Override
    public Expression asLogicalExpression(CommonOpType opType, HasMainTable sql) {
        return super.asLogicalExpression(opType,sql);
    }

    @Override
    public Expression asExpression(HasMainTable sql) {
        return func.asExpression(sql);
    }

    @Override
    public GenricExpression joinExpression(GenricExpression other, CommonOpType type) {
        return super.joinExpression(other,type);
    }
}
