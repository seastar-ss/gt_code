package com.shawn.ss.lib.tools.caches.memory;

//import com.shangde.constants.MemoryKeys;

import com.shawn.ss.lib.tools.constants.MemoryKeys;

public class MemoryCacheFactory {
    public static enum CacheType{
        FIXED_ENTRY_SIZE_EXPIRED_CACHE,LRU_CACHE,LRU_EXPIRED_CACHE
    }

    public static boolean hasCache(MemoryKeys name){
        return AbstractMemoryCacheManager.hasCache(name);
    }

    public static <K,V> MemoryCacheInterface<K,V> getCacheWithEvictHandler(MemoryKeys name, MemoryCacheInterface.CacheEntryEvictHandler<K,V> evictHandler) {
        MemoryCacheInterface<K, V> cache = LRUCacheManager.<K,V>getCacheWithEvictHandler(name, true,evictHandler);
        return cache;
    }

    public static <K,V> MemoryCacheInterface<K,V> getCache(MemoryKeys name) {
        return getCache(CacheType.LRU_EXPIRED_CACHE,name);
    }
    public static <K,V> MemoryCacheInterface<K,V> getCache(CacheType type, MemoryKeys name){
        switch (type){
            case LRU_CACHE:
                return LRUCacheManager.getCache(name,false);
//                break;
            case LRU_EXPIRED_CACHE:
                return LRUCacheManager.getCache(name,true);
//                break;
            case FIXED_ENTRY_SIZE_EXPIRED_CACHE:
                return FixedSizeExpiredMapCacheManager.<K,V>getCache(name);
        }
        return null;
    }

    public static void flushAllCache(){

    }
}
