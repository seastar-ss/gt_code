package com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model;

import com.shawn.ss.lib.tools.CollectionHelper;

import java.util.Map;

public enum CommonOpType {
    plus(2, false), minus(2, false), multiply(2, false), devide(2, false), mod(2, false), not(1, false), and(2, false), or(2, false), xor(2, false),
    eq(2, true), neq(2, true), in(-1, true), notIn(-1, true), gt(2, true), gtEq(2, true), lt(2, true), ltEq(2, true), isNull(1, true), notNull(1, true), like(2, true), notLike(2, true);
    static volatile Map<String, CommonOpType> types;
    final int variableCount;
    final boolean isLogical;

    CommonOpType(int count, boolean isLogical) {
        this.variableCount = count;
        this.isLogical = isLogical;
    }

    public int getVariableCount() {
        return variableCount;
    }

    public boolean isLogical() {
        return isLogical;
    }

    public static CommonOpType getEnumByName(String name) {
        if (types == null) {
            synchronized (CommonOpType.class) {
                if (types == null) {
                    types = CollectionHelper.newSortedMap();
                    CommonOpType[] values = CommonOpType.values();
                    for (CommonOpType value : values) {
                        types.put(value.name(), value);
                    }
                }
            }
        }
        return types.get(name);
    }
}
