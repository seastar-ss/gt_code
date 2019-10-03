/*-
 * #%L
 * JSQLParser library
 * %%
 * Copyright (C) 2004 - 2019 JSQLParser
 * %%
 * Dual licensed under GNU LGPL 2.1 or Apache License 2.0
 * #L%
 */
package net.sf.jsqlparser.expression;

import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.expression.operators.arithmetic.BitwiseAnd;
import net.sf.jsqlparser.expression.operators.arithmetic.Concat;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * @author tw
 */
public class ExpressionPrecedenceTest {

    @Test
    public void testGetSign() throws JSQLParserException {
        Expression expr = CCJSqlParserUtil.parseExpression("1&2||3");
        assertTrue(expr instanceof Concat);
        assertTrue(((Concat) expr).getLeftExpression() instanceof BitwiseAnd);
        assertTrue(((Concat) expr).getRightExpression() instanceof LongValue);
    }


    @Test
    public void testJavaFunc() throws JSQLParserException {
        Expression expr = CCJSqlParserUtil.parseExpression("${test(t1:1)}");
        System.out.println(expr);
    }

    @Test
    public void testGetExprList() throws JSQLParserException {
        Expression expr = CCJSqlParserUtil.parseExpression("item1,item2,item3");
        System.out.println(expr);
    }
}
