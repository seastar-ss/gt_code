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
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import org.junit.*;

import static org.junit.Assert.fail;

/**
 * @author toben
 */
public class SignedExpressionTest {

    public SignedExpressionTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getSign method, of class SignedExpression.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testGetSign() throws JSQLParserException {
        new SignedExpression('*', CCJSqlParserUtil.parseExpression("a"));
        fail("must not work");
    }
}
