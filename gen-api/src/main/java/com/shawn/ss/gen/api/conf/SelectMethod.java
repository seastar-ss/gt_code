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


}
