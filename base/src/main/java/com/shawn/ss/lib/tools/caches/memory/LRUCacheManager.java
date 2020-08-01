package com.shawn.ss.lib.tools.caches.memory;

//import com.shangde.constants.MemoryKeys;
//import com.shangde.utils.structure.LRUCache;
//import com.shangde.utils.structure.LRUCacheInterface;
import com.shawn.ss.lib.tools.CollectionHelper;
import com.shawn.ss.lib.tools.constants.MemoryKeys;
import com.shawn.ss.lib.tools.structure.LRUCache;
import com.shawn.ss.lib.tools.structure.LRUCacheInterface;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * Created by ss on 2017/12/3.
 */
class LRUCacheManager<K, V> extends AbstractMemoryCacheManager<K, V> {




    public static <KK, VV> MemoryCacheInterface<KK, VV> getCacheWithEvictHandler(MemoryKeys name, boolean expired, MemoryCacheInterface.CacheEntryEvictHandler<KK, VV> evictHandler) {
        if (caches.containsKey(name)) {
            MemoryCacheInterface cacheInterface = caches.get(name);
//            if (cacheInterface instanceof LRUCacheManager)
            return cacheInterface;
        }
//        else {
        LRUCacheManager<KK, VV> cache = new LRUCacheManager<KK, VV>(name.getCount(), name.getExpiredSpan(), expired);
        caches.put(name, cache);
        cache.setEvictHandler(evictHandler);
        return cache;
    }

    public static <KK, VV> MemoryCacheInterface<KK, VV> getCache(MemoryKeys name, boolean expired) {
        if (caches.containsKey(name)) {
            MemoryCacheInterface cacheInterface = caches.get(name);
//            if (cacheInterface instanceof LRUCacheManager)
            return cacheInterface;
        }
//        else {
        LRUCacheManager<KK, VV> cache = new LRUCacheManager<KK, VV>(name.getCount(), name.getExpiredSpan(), expired);
        caches.put(name, cache);
        return cache;
    }

    private final boolean expired;
    LRUCacheExt<K, V> cache;
    LRUCacheExpiredExt<K, V> expiredCache;
    CacheEntryEvictHandler<K, V> handler;


    private LRUExtCacheInterface<K, V> switchCache() {
        if (expired) {
            return expiredCache;
        } else {
            return cache;
        }
    }

    public CacheEntryEvictHandler<K, V> getEvictHandler() {
        return handler;
    }

    public void setEvictHandler(CacheEntryEvictHandler<K, V> handler) {
//        if(expired){
//            expiredCache.evictHandler=handler;
//        }
        LRUExtCacheInterface<K, V> cache = switchCache();
        this.handler = handler;
        cache.setEvictHandler(handler);
    }

    public LRUCacheManager(Integer count, Integer expiredSpan, boolean expired) {
        super(count, expiredSpan);
        this.expired = expired;
        if (expired) {
            expiredCache = new LRUCacheExpiredExt<K, V>(count);
        } else {
            cache = new LRUCacheExt<K, V>(count);
        }
    }

    @Override
    public V get(K key) {
        LRUExtCacheInterface<K, V> cache = switchCache();
        return cache.get(key);
    }

    @Override
    public V put(K key, V value, long expired) {
//
        V ret;
        if (value != null) {
            if (this.expired) {
                ret = expiredCache.put(key, value, expired);
            } else {
                ret = cache.put(key, value);
            }
        } else {
            LRUExtCacheInterface<K, V> cache = switchCache();
            ret = cache.remove(key);
        }
        return ret;
    }

    @Override
    public Map<K, V> getMulti(Collection<K> keys) {
        if(keys==null || keys.size()==0){
            return null;
        }
        LRUExtCacheInterface<K, V> cache = switchCache();
        Map<K,V> ret= CollectionHelper.newMap();
        for(K k:keys){
            ret.put(k,cache.get(k));
        }
        return ret;
    }

    @Override
    public boolean expiredAt(K key, long expiredAt) {
        if (expired && expiredCache != null) {
            return expiredCache.expiredAt(key, expiredAt);
        }
        return false;
    }

    @Override
    public long expired(K key) {
        if(expired){
            return expiredCache.getTTL(key);
        }
        return -1;
    }

    @Override
    public Set<K> allKeys() {
        return null;
    }

//    @Override
//    public V get(K key) {
//        if (expired) {
//            CachedEntry<V> entry = expiredCache.get(key);
//            if (entry != null) {
//                if (entry.expired > System.currentTimeMillis()) {
//                    return entry.obj;
//                } else {
//                    expiredCache.remove(key);
//                }
//            }
//            return null;
//        } else {
//            return cache.get(key);
//        }
//    }
//
//    @Override
//    public V put(K key, V value, long expired) {
//        V ret = null;
//        if (this.expired) {
//            CachedEntry<V> evictEntry = expiredCache.put(key, new CachedEntry<V>(value, expired + System.currentTimeMillis()));
//            if (evictEntry != null) {
//                ret = evictEntry.obj;
//            }
//        } else {
//            ret = cache.put(key, value);
//        }
//        return ret;
//    }
//
//    @Override
//    public boolean expiredAt(K key, long expiredAt) {
//        if (expired) {
//            if (expiredCache.containsKey(key)) {
//                CachedEntry<V> entry = expiredCache.get(key);
//                if (expiredAt > 0) {
//                    CachedEntry<V> evictEntry = expiredCache.put(key, new CachedEntry<V>(entry.obj, expiredAt));
//                    return evictEntry != null;
//                } else {
//                    CachedEntry<V> remove = expiredCache.remove(key);
//                    return remove != null;
//                }
//            }
//        }
//        return false;
//    }

//    public static class DefaultEvictHandler<K, V> implements CacheEntryEvictHandler<K, V> {
//
//        @Override
//        public void entryRemoved(boolean evicted, K key, V oldValue, V newValue) {
//            //nothing
//        }
//    }


    class LRUCacheExt<K, V> extends LRUCache<K, V> implements LRUExtCacheInterface<K, V> {
        CacheEntryEvictHandler<K, V> evictHandler;

        //        static CacheEntryEvictHandler<K,V> DEFAULT_EVICT_HANDLER
        public LRUCacheExt(int maxSize) {
            super(maxSize);
        }

        @Override
        protected void entryRemoved(boolean evicted, K key, V oldValue, V newValue) {
            if (evictHandler != null)
                evictHandler.entryRemoved(evicted, key, oldValue, newValue, null);
        }

        public CacheEntryEvictHandler<K, V> getEvictHandler() {
            return evictHandler;
        }

        public void setEvictHandler(CacheEntryEvictHandler<K, V> evictHandler) {
            this.evictHandler = evictHandler;
        }

//        @Override
//        public boolean containsKey(Object key) {
//            return false;
//        }
    }

    class LRUCacheExpiredExt<K, V> implements LRUExtCacheInterface<K, V> {
        LRUCacheExt<K, AbstractMemoryCacheManager.CachedEntry<V>> mainCache;
        CacheEntryEvictHandler<K, V> evictHandler;

        class CacheEvictHandlerAdaptor<K, V> implements CacheEntryEvictHandler<K, AbstractMemoryCacheManager.CachedEntry<V>> {
            CacheEntryEvictHandler<K, V> evictHandler;

            public CacheEvictHandlerAdaptor(CacheEntryEvictHandler<K, V> evictHandler) {
                this.evictHandler = evictHandler;
            }

            @Override
            public void entryRemoved(boolean evicted, K key, CachedEntry<V> oldValue, CachedEntry<V> newValue, Long oldExpiredAt) {
                V nv = newValue == null ? null : newValue.obj;
                if (oldValue == null) {
                    evictHandler.entryRemoved(evicted, key, null, nv, null);
                } else {
                    V ov = oldValue.obj;
                    Long expired = oldValue.expired;
                    evictHandler.entryRemoved(evicted, key, ov, nv, expired);
                }
            }
        }

        public LRUCacheExpiredExt(int maxSize) {
            mainCache = new LRUCacheExt<K, AbstractMemoryCacheManager.CachedEntry<V>>(maxSize);
        }


        public CacheEntryEvictHandler<K, V> getEvictHandler() {
            return evictHandler;
        }

        public void setEvictHandler(CacheEntryEvictHandler<K, V> evictHandler) {
            this.evictHandler = evictHandler;
            CacheEvictHandlerAdaptor<K, V> handlerAdaptor = new CacheEvictHandlerAdaptor<K,V>(evictHandler);
            mainCache.evictHandler = handlerAdaptor;
        }

        @Override
        public V get(K key) {
            CachedEntry<V> entry = mainCache.get(key);
            if (entry != null) {
                if (entry.expired > System.currentTimeMillis()) {
                    return entry.obj;
                } else {
                    mainCache.remove(key);
                }
            }
            return null;
        }

        public long getTTL(K key){
            CachedEntry<V> entry = mainCache.get(key);
            if (entry != null) {
                return entry.expired-System.currentTimeMillis();
            }
            return -1;
        }

        public V put(K key, V value, long expired) {
            V ret = null;
            CachedEntry<V> evictEntry = mainCache.put(key, new CachedEntry<V>(value, expired + System.currentTimeMillis()));
            if (evictEntry != null) {
                ret = evictEntry.obj;
            }
            return ret;
        }

        @Override
        public V put(K key, V value) {
            return put(key, value, defaultExpiredSpan);
        }

        @Override
        public V remove(K key) {
            CachedEntry<V> entry = mainCache.remove(key);
            return entry == null ? null : entry.obj;
        }

        @Override
        public Collection<V> values() {
            return null;
        }

        @Override
        public boolean containsKey(Object key) {
            return mainCache.containsKey(key);
        }

        @Override
        public void evictAll() {
            mainCache.evictAll();
        }

        @Override
        public int size() {
            return mainCache.size();
        }

        @Override
        public int maxSize() {
            return mainCache.maxSize();
        }

        @Override
        public int hitCount() {
            return mainCache.hitCount();
        }

        @Override
        public int missCount() {
            return mainCache.missCount();
        }

        @Override
        public int createCount() {
            return mainCache.createCount();
        }

        @Override
        public int putCount() {
            return mainCache.putCount();
        }

        @Override
        public int evictionCount() {
            return mainCache.evictionCount();
        }

        @Override
        public Map.Entry<K, V> getResentEntry() {
            return null;
        }

        public boolean expiredAt(K key, long expiredAt) {
            if (mainCache.containsKey(key)) {
                if(expiredAt>0) {
                    CachedEntry<V> cachedEntry = mainCache.get(key);
                    cachedEntry.expired = expiredAt;
                    mainCache.put(key, cachedEntry);
                    return true;
                }else{
                    mainCache.remove(key);
                    return true;
                }
            }
            return false;
        }
    }

    public static interface LRUExtCacheInterface<K, V> extends LRUCacheInterface<K, V> {
        public CacheEntryEvictHandler<K, V> getEvictHandler();

        public void setEvictHandler(CacheEntryEvictHandler<K, V> evictHandler);
    }
}
