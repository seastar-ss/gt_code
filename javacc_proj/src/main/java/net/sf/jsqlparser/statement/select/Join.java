/*-
 * #%L
 * JSQLParser library
 * %%
 * Copyright (C) 2004 - 2019 JSQLParser
 * %%
 * Dual licensed under GNU LGPL 2.1 or Apache License 2.0
 * #L%
 */
package net.sf.jsqlparser.statement.select;

import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.parser.ASTNodeAccessImpl;
import net.sf.jsqlparser.schema.Column;

import java.util.List;

public class Join extends ASTNodeAccessImpl {

    private boolean outer = false;
    private boolean right = false;
    private boolean left = false;
    private boolean natural = false;
    private boolean full = false;
    private boolean inner = false;
    private boolean simple = false;
    private boolean cross = false;
    private boolean semi = false;
    private FromItem rightItem;
    private Expression onExpression;
    private List<Column> usingColumns;
    private KSQLJoinWindow joinWindow;

    public boolean isSimple() {
        return simple;
    }

    public void setSimple(boolean b) {
        simple = b;
    }

    public boolean isInner() {
        return inner;
    }

    public void setInner(boolean b) {
        inner = b;
    }

    /**
     * Whether is a "OUTER" join
     *
     * @return true if is a "OUTER" join
     */
    public boolean isOuter() {
        return outer;
    }

    public void setOuter(boolean b) {
        outer = b;
    }

    /**
     * Whether is a "SEMI" join
     *
     * @return true if is a "SEMI" join
     */
    public boolean isSemi() {
        return semi;
    }

    public void setSemi(boolean b) {
        semi = b;
    }

    /**
     * Whether is a "LEFT" join
     *
     * @return true if is a "LEFT" join
     */
    public boolean isLeft() {
        return left;
    }

    public void setLeft(boolean b) {
        left = b;
    }

    /**
     * Whether is a "RIGHT" join
     *
     * @return true if is a "RIGHT" join
     */
    public boolean isRight() {
        return right;
    }

    public void setRight(boolean b) {
        right = b;
    }

    /**
     * Whether is a "NATURAL" join
     *
     * @return true if is a "NATURAL" join
     */
    public boolean isNatural() {
        return natural;
    }

    public void setNatural(boolean b) {
        natural = b;
    }

    /**
     * Whether is a "FULL" join
     *
     * @return true if is a "FULL" join
     */
    public boolean isFull() {
        return full;
    }

    public void setFull(boolean b) {
        full = b;
    }

    public boolean isCross() {
        return cross;
    }

    public void setCross(boolean cross) {
        this.cross = cross;
    }

    /**
     * Returns the right item of the join
     */
    public FromItem getRightItem() {
        return rightItem;
    }

    public void setRightItem(FromItem item) {
        rightItem = item;
    }

    /**
     * Returns the "ON" expression (if any)
     */
    public Expression getOnExpression() {
        return onExpression;
    }

    public void setOnExpression(Expression expression) {
        onExpression = expression;
    }

    /**
     * Returns the "USING" list of {@link net.sf.jsqlparser.schema.Column}s (if any)
     */
    public List<Column> getUsingColumns() {
        return usingColumns;
    }

    public void setUsingColumns(List<Column> list) {
        usingColumns = list;
    }


    public boolean isWindowJoin() {
        return joinWindow != null;
    }

    /**
     * Return the "WITHIN" join window (if any)
     */
    public KSQLJoinWindow getJoinWindow() {
        return joinWindow;
    }

    public void setJoinWindow(KSQLJoinWindow joinWindow) {
        this.joinWindow = joinWindow;
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();
        if (isSimple() && isOuter()) {
            ret.append("OUTER ").append(rightItem);
        } else if (isSimple()) {
            ret.append(rightItem);
        } else {
//            String type = "";

            if (isRight()) {
                ret.append("RIGHT ");
            } else if (isNatural()) {
                ret.append("NATURAL ");
            } else if (isFull()) {
                ret.append("FULL ");
            } else if (isLeft()) {
                ret.append("LEFT ");
            } else if (isCross()) {
                ret.append("CROSS ");
            }

            if (isOuter()) {
                ret.append("OUTER ");
            } else if (isInner()) {
                ret.append("INNER ");
            } else if (isSemi()) {
                ret.append("SEMI ");
            }

            ret
                    .append("JOIN ")
                    .append(rightItem)
                    .append((joinWindow != null) ? " WITHIN " + joinWindow : "")
                    .append((onExpression != null) ? " ON " + onExpression : "")
                    .append(PlainSelect.getFormatedList(usingColumns, "USING", true, true))
                    .toString();
        }
        return ret.toString();
    }
}
