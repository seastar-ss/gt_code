package com.shawn.ss.lib.tools.caches.memory;

//import com.shangde.constants.MemoryKeys;
import com.shawn.ss.lib.tools.CollectionHelper;
import com.shawn.ss.lib.tools.constants.MemoryKeys;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

class FixedSizeExpiredMapCacheManager<K, V> extends AbstractMemoryCacheManager<K, V> {


    public static <K, V> MemoryCacheInterface<K, V> getCache(MemoryKeys name) {
        if (caches.containsKey(name)) {
            MemoryCacheInterface cacheInterface = caches.get(name);
            if (cacheInterface instanceof FixedSizeExpiredMapCacheManager)
                return (FixedSizeExpiredMapCacheManager)cacheInterface;

        }
//        else {
        MemoryCacheInterface<K, V> cache = new FixedSizeExpiredMapCacheManager<K, V>(name.getCount(), name.getExpiredSpan());
        caches.put(name, cache);
        return cache;
//        }
    }

    protected ConcurrentHashMap<K, CachedEntry<V>> cache;

    private FixedSizeExpiredMapCacheManager(int count, int expiredSpan) {
        super(count, expiredSpan);
        if (count <= 0 || expiredSpan <= 0) {
            throw new IllegalArgumentException("both count and span need to be positive number");
        }
        cache = new ConcurrentHashMap<K, CachedEntry<V>>(count * 3 / 4);
    }

    @Override
    public V get(K key) {
        if (cache.containsKey(key)) {
            CachedEntry<V> entry = cache.get(key);
            if (entry.expired < System.currentTimeMillis()) {
                cache.remove(key);
            } else {
                return entry.obj;
            }
        }
        return null;
    }

    @Override
    public V put(K key, V value, long expired) {
        V ret = null;
        if (cache.size() < maxEntry) {
            CachedEntry<V> evictEntry = cache.put(key, new CachedEntry<V>(value, expired + System.currentTimeMillis()));
            if (evictEntry != null) {
                ret = evictEntry.obj;
            }
        } else {
            if (cache.containsKey(key)) {
                CachedEntry<V> evictEntry = cache.put(key, new CachedEntry<V>(value, expired + System.currentTimeMillis()));
                ret = evictEntry.obj;
            }
        }
        return ret;
    }

    @Override
    public Map<K,V> getMulti(Collection<K> keys) {
        if(keys==null || keys.size()==0){
            return null;
        }
        Map<K,V> ret= CollectionHelper.newMap();
        for(K k:keys){
            ret.put(k,get(k));
        }
        return ret;
    }

//    @Override
//    public V put(K key, V value) {
//        return put(key, value, defaultExpiredSpan);
//    }

    @Override
    public boolean expiredAt(K key, long expiredAt) {
        if (cache.containsKey(key)) {
            CachedEntry<V> entry = cache.get(key);
            if (expiredAt > 0) {
                CachedEntry<V> evictEntry = cache.put(key, new CachedEntry<V>(entry.obj, expiredAt));
                return evictEntry != null;
            } else {
                CachedEntry<V> remove = cache.remove(key);
                return remove != null;
            }
        }
        return false;
    }

    @Override
    public long expired(K key) {
        CachedEntry<V> cachedEntry = cache.get(key);
        return cachedEntry.expired- System.currentTimeMillis();
    }

    @Override
    public Set<K> allKeys() {
        return cache.keySet();
    }


}
