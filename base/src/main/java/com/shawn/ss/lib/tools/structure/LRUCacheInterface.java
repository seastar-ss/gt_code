package com.shawn.ss.lib.tools.structure;

import java.util.Collection;
import java.util.Map;

public interface LRUCacheInterface<K, V> {
    V get(K key);

    V put(K key, V value);

    V remove(K key);

    Collection<V> values();

    boolean containsKey(Object key);

    void evictAll();

    int size();

    int maxSize();

    int hitCount();

    int missCount();

    int createCount();

    int putCount();

    int evictionCount();

    Map.Entry<K, V> getResentEntry();
}
