package net.sf.jsqlparser.expression;

import net.sf.jsqlparser.parser.ASTNodeAccessImpl;

import java.util.List;

public class JdbcJavaFuncArgs extends ASTNodeAccessImpl implements Expression  {

    String varName;
    String varDefaultValue;
    List<String> listVarDefaultValue;
    boolean isList;
    String classType;

    public String getVarName() {
        return varName;
    }

    public JdbcJavaFuncArgs setVarName(String varName) {
        this.varName = varName;
        return this;
    }

    public String getVarDefaultValue() {
        return varDefaultValue;
    }

    public JdbcJavaFuncArgs setVarDefaultValue(String varDefaultValue) {
        this.varDefaultValue = varDefaultValue;
        return this;
    }

    public boolean isList() {
        return isList;
    }

    public JdbcJavaFuncArgs setList(boolean list) {
        isList = list;
        return this;
    }

    public String getClassType() {
        return classType;
    }

    public JdbcJavaFuncArgs setClassType(String classType) {
        this.classType = classType;
        return this;
    }

    public List<String> getListVarDefaultValue() {
        return listVarDefaultValue;
    }

    public JdbcJavaFuncArgs setListVarDefaultValue(List<String> listVarDefaultValue) {
        this.listVarDefaultValue = listVarDefaultValue;
        return this;
    }

    @Override
    public void accept(ExpressionVisitor expressionVisitor) {

    }



    public String toSqlString() {
        return
                (classType==null?"":classType+".")+varName  +
                ":" + (!isList?("\""+varDefaultValue +"\"") :
                         getListStr(listVarDefaultValue))
                 ;
    }

    @Override
    public String toString() {
        return "/*args "+toSqlString()+"*/" ;
    }

    private String getListStr(List<String> listVarDefaultValue) {
        StringBuilder ret=new StringBuilder().append('[');
        if(listVarDefaultValue!=null && listVarDefaultValue.size()>0){
            for(String s:listVarDefaultValue)
                ret.append('"').append(s).append('"');
        }
        ret.append(']');
        return ret.toString();
    }
}
