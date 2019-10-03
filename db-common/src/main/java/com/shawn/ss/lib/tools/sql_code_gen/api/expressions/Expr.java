package com.shawn.ss.lib.tools.sql_code_gen.api.expressions;

import net.sf.jsqlparser.expression.Expression;

public class Expr {
    final Expression expression;

    public Expr(Expression expression) {
        this.expression = expression;
    }

    public boolean isEmpty(){
        return expression==null;
    }
}
