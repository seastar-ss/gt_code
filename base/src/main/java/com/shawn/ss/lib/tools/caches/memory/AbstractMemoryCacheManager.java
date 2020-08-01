package com.shawn.ss.lib.tools.caches.memory;

//import com.shangde.constants.MemoryKeys;

import com.shawn.ss.lib.tools.constants.MemoryKeys;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by ss on 2017/12/3.
 */
abstract class AbstractMemoryCacheManager<K,V> implements MemoryCacheInterface<K, V> {
    protected static final ConcurrentHashMap<MemoryKeys, MemoryCacheInterface> caches;
    protected int maxEntry;
    protected long defaultExpiredSpan;


    static {
        caches = new ConcurrentHashMap<MemoryKeys, MemoryCacheInterface>(50);
    }

    public static boolean hasCache(MemoryKeys name){
        return caches.containsKey(name);
    }

    AbstractMemoryCacheManager(int count, int expiredSpan) {
        this.maxEntry = count;
        this.defaultExpiredSpan = expiredSpan;
    }

    @Override
    public V put(K key, V value) {
        return put(key,value,defaultExpiredSpan);
    }

    public static class CachedEntry<V> {
        V obj;
        long expired;

        public CachedEntry(V obj, long expired) {
            this.obj = obj;
            this.expired = expired;
        }
    }
}
