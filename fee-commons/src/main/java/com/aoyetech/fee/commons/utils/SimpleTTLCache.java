package com.aoyetech.fee.commons.utils;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * 一个带TTL的简单Cache
 * 
 * @author <a href=mailto://wq163@163.com>jenwang</a>
 * @since 2012-12-20 上午11:18:52
 **/

public class SimpleTTLCache<E> {
    private ConcurrentMap<String, CacheEntry<E>> cache;

    private long                                 cacheTTL;

    private static class CacheEntry<E> {
        public final long timestamp;
        public final E    value;


        public CacheEntry(final E value, final long timestamp) {
            this.timestamp = timestamp;
            this.value = value;
        }

    }


    public SimpleTTLCache() {
        this(Constants.CLIENT_POLLING_INTERVAL_TIME * 1000L);
    }


    public SimpleTTLCache(final long cacheTTL) {
        this.cache = new ConcurrentHashMap<String, CacheEntry<E>>();
        this.cacheTTL = cacheTTL;
    }


    public void put(final String key, final E e) {
        if ((key == null) || (e == null)) {
            return;
        }
        final CacheEntry<E> entry = new CacheEntry<E>(e, System.currentTimeMillis() + this.cacheTTL);
        this.cache.put(key, entry);
    }


    public E get(final String key) {
        E result = null;
        final CacheEntry<E> entry = this.cache.get(key);
        if (entry != null) {
            if (entry.timestamp > System.currentTimeMillis()) {
                result = entry.value;
            }
        }

        return result;
    }


    public E forceGet(final String key) {
        final CacheEntry<E> entry = this.cache.get(key);
        return entry != null ? entry.value : null;
    }
}
