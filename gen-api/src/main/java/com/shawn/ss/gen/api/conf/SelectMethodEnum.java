package com.shawn.ss.gen.api.conf;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public enum SelectMethodEnum implements SelectMethod,Comparable<SelectMethodEnum> {
    // hasIdCondition,  isMultipleResult,  isSingleResult,  isCondition,  isIndex,  hasRawItem,  hasRawConditon,  isCount
    getAll
            (false, true, false, false, false, false, false, false,true),
    getByIds
            (true, true, false, false, true, false, false, false,true),
    getByIndex
            (false, true, false, false, true, false, false, false,true),
    getByCondition
            (false, true, false, true, false, false, false, false,true),
    getByRawCondition
            (false, true, false, false, false, false, true, false,false),
    getByIndexAndCondition
            (false, true, false, true, true, false, false, false,false),
    getByIdAndRawConditon
            (true, true, false, false, false, false, true, false,false),
    getByIdAndIndexAndConditonAndRawCondition
            (true, true, false, true, true, false, true, false,true),
    getByIndexAndRawCondition
            (false, true, false, false, true, false, true, false,false),
    getByConditionAndRawCondition
            (false, true, false, true, false, false, true, false,false),
    getByIndexAndConditionAndRawCondition
            (false, true, false, true, true, false, true, false,true),
    getOneById
            (true, false, false, false, false, false, false, false,true),
    getOneByCondtion
            (false, false, false, true, false, false, false, false,true),
    getOneByRawCondition
            (false, false, false, false, false, false, true, false,false),
    getOneByConditionAndRawCondition
            (false, false, false, true, false, false, true, false,false),
    getOneByIdAndByConditionAndByRawCondition
            (true, false, false, true, false, false, true, false,true),
    getCountByCondition
            (false, false, false, true, false, false, false, true,false),
    getCountByIndexAndCondition
            (false, false, false, true, true, false, false, true,false),
    getCountByIndexAndConditionAndRawCondition
            (false, false, false, true, true, false, true, true,false),
    getRawItemByIndex
            (false, false, true, false, true, true, false, false,true),
    // hasIdCondition,  isMultipleResult,  isSingleResult,  isCondition,  isIndex,  hasRawItem,  hasRawConditon,  isCount
    getRawItemByRawCondition
            (false, false, true, false, false, true, true, false,true),
    getRawItemByCondition
            (false, false, true, true, false, true, false, false,true),
    getRawItemByIndexAndConditon
            (false, false, true, true, true, true, false, false,false),
    getRawItemByIndexAndConditionAndRawCondition
            (false, false, true, true, true, true, true, false,true),
    // hasIdCondition,  isMultipleResult,  isSingleResult,  isCondition,  isIndex,  hasRawItem,  hasRawConditon,  isCount
    getRawItemListByIndex
            (false, true, true, false, true, true, false, false,true),
    getRawItemListByCondition
            (false, true, true, true, false, true, false, false,true),
    getRawItemListByIds
            (true, true, true, false, false, true, false, false,true),
    getRawItemListByRawCondition
            (false, true, true, false, false, true, true, false,true),
    getRawItemListByIndexAndByRawCondition
            (false, true, true, false, true, true, true, false,false),
    getRawItemListByConditionAndByRawCondition
            (false, true, true, true, false, true, true, false,false),
    getRawItemListByIndexAndCondition
            (false, true, true, true, true, true, false, false,false),
    getRawItemListByIndexAndConditionAndRawCondition
            (true, true, true, true, true, true, true, false,true),
    ;
    private static volatile Map<String,SelectMethod> allMethod;
//    private static volatile Set<String> allMethodName;

    private final String methodName;
    private boolean hasIdCondition;
    private boolean isMultipleResult;
    private boolean isSingleResult;
    private boolean isCondition;
    private boolean isIndex;
    private boolean hasRawItem;
    private boolean hasRawConditon;
    private boolean isCount;
    private boolean defaultMethod;

    SelectMethodEnum(
            boolean hasIdCondition,
            boolean isMultipleResult,
            boolean isSingleResult,
            boolean isCondition,
            boolean isIndex,
            boolean hasRawItem,
            boolean hasRawConditon,
            boolean isCount,
            boolean shouldHave
    ) {

        this.hasIdCondition = hasIdCondition;
        this.isMultipleResult = isMultipleResult;
        this.isSingleResult = isSingleResult;
        this.isCondition = isCondition;
        this.isIndex = isIndex;
        this.hasRawItem = hasRawItem;
        this.hasRawConditon = hasRawConditon;
        this.isCount = isCount;
        this.methodName = SelectMethod.makeUpMethodName(this);
        this.defaultMethod =shouldHave;
    }


    public boolean isDefaultMethod() {
        return defaultMethod;
    }

    public SelectMethodEnum setDefaultMethod(boolean defaultMethod) {
        this.defaultMethod = defaultMethod;
        return this;
    }

    @Override
    public String getMethodName() {
        return methodName;
    }

    @Override
    public boolean isHasIdCondition() {
        return hasIdCondition;
    }

    @Override
    public boolean isMultipleResult() {
        return isMultipleResult;
    }

    @Override
    public boolean isSingleResult() {
        return isSingleResult;
    }

    @Override
    public boolean isCondition() {
        return isCondition;
    }

    @Override
    public boolean isIndex() {
        return isIndex;
    }

    @Override
    public boolean isHasRawItem() {
        return hasRawItem;
    }

    @Override
    public boolean isHasRawConditon() {
        return hasRawConditon;
    }

    @Override
    public boolean isCount() {
        return isCount;
    }

    public static Map<String,SelectMethod> getAllSelectMethod() {
        if (allMethod == null) {
            initMethod();
        }
        return allMethod;
    }

    public static Map<String,SelectMethod> getNacessarySelectMethod() {
        if (allMethod == null) {
            initMethod();
        }
        Map<String,SelectMethod> ret=new TreeMap<>();
        for(Map.Entry<String,SelectMethod> entry:allMethod.entrySet()){
            SelectMethod value = entry.getValue();
            if(value.isDefaultMethod())
            ret.put(value.getMethodName(),value);
        }
        return ret;
//        return allMethod;
    }

    private static void initMethod() {
        synchronized (SelectMethod.class) {
            SelectMethod[] values = values();
            allMethod = new TreeMap<>();
            for(SelectMethod v:values){
                String methodName = v.getMethodName();
                allMethod.put(methodName,v);
            }
//                Collections.addAll(allMethod, values);
        }
    }

    public static Set<String> getAllSupportedMethod() {
        if (allMethod == null) {
            initMethod();
        }
        return allMethod.keySet();
    }


//        @Override
//        public int compareTo(SelectMethodEnum o) {
//            return methodName.compareTo(o.getMethodName());
//        }
}
