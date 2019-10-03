package com.shawn.ss.gen.api.conf;

public interface SelectMethod {
    String getMethodName();

    boolean isHasIdCondition();

    boolean isMultipleResult();

    boolean isSingleResult();

    boolean isCondition();

    boolean isIndex();

    boolean isHasRawItem();

    boolean isHasRawConditon();

    boolean isCount();

    boolean isDefaultMethod();

    public static String makeUpMethodName(SelectMethod method) {
        StringBuilder ret = new StringBuilder("get");
        if (!method.isCount()) {
            if (!method.isMultipleResult() && method.isSingleResult()) {
                ret.append("Item");
            } else if (!method.isMultipleResult() && !method.isSingleResult()) {
                ret.append("One");
            } else if (method.isMultipleResult() && method.isSingleResult()) {
                ret.append("ItemList");
            }
        } else {
//            if (!method.isSingleResult()) {
            ret.append("Count");
//            }
        }
        if (method.isHasIdCondition()) {
            ret.append(ret.indexOf("By") <= 0 ? "ById" : "AndId");
        }
        if (method.isCondition()) {
            ret.append(ret.indexOf("By") <= 0 ? "ByCond" : "AndCond");
        }
        if (method.isIndex() && !method.isHasIdCondition()) {
            ret.append(ret.indexOf("By") <= 0 ? "ByIndex" : "AndIndex");
        }
        if (method.isHasRawConditon()) {
            ret.append(ret.indexOf("By") <= 0 ? "ByWhere" : "AndWhere");
        }
        return ret.toString();
    }
}
