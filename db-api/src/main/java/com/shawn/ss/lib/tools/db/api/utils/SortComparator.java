package com.shawn.ss.lib.tools.db.api.utils;

import com.shawn.ss.lib.tools.CollectionHelper;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class SortComparator<Tt, T> implements Comparator<T> {
    final Map<Tt, Integer> sortMap;
    private final Function<T, Tt> function;

    public SortComparator(List<Tt> ids, Function<T, Tt> function) {
        if (CollectionHelper.isCollectionEmpty(ids)) {
            throw new IllegalArgumentException("ids should not be empty");
        }
        sortMap = CollectionHelper.newMap();
        for (int i = 0, n = ids.size(); i < n; ++i) {
            sortMap.put(ids.get(i), i);
        }
        this.function = function;
    }

    @Override
    public int compare(T o1, T o2) {
        if (o1 == null || o2 == null) {
            throw new IllegalStateException("this comparator can't compare null values");
        }
        final Tt id1 = function.apply(o1);
        final Tt id2 = function.apply(o2);
        final Integer key1 = sortMap.getOrDefault(id1, Integer.MAX_VALUE);
        final Integer key2 = sortMap.getOrDefault(id2, Integer.MAX_VALUE);
        return key1.compareTo(key2);
    }
}
