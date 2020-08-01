package com.shawn.ss.lib.tools.caches.memory;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public interface MemoryCacheInterface<T, V> {
    V get(T key);

    V put(T key, V value, long expired);

    V put(T key, V value);

    Map<T,V> getMulti(Collection<T> keys);

    boolean expiredAt(T key, long expiredAt);

    long expired(T key);

    Set<T> allKeys();

    public static interface CacheEntryEvictHandler<K, V> {
        void entryRemoved(boolean evicted, K key, V oldValue, V newValue, Long oldExpiredAt);
    }
}
