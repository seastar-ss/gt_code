package com.shawn.ss.lib.tools.structure;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K, V> implements LRUCacheInterface<K, V> {

	private final LinkedHashMap<K, V> map;

	/** Size of this cache in units. Not necessarily the number of elements. */
	private int size;
	private int maxSize;
	private volatile K resenctKey;
	private int putCount;
	private int createCount;
	private int evictionCount;
	private int hitCount;
	private int missCount;


	public LRUCache(int maxSize) {
		if (maxSize <= 0) {
			throw new IllegalArgumentException("maxSize <= 0");
		}
		this.maxSize = maxSize;
		this.map = new LinkedHashMap<K, V>(0, 0.75f, true);
	}


	@Override
	public V get(K key) {
		if (key == null) {
			throw new NullPointerException("key == null");
		}

		V mapValue;
		synchronized (this) {
			mapValue = map.get(key);
			if (mapValue != null) {
				hitCount++;
				return mapValue;
			}
			missCount++;
		}



		V createdValue = create(key);
		if (createdValue == null) {
			return null;
		}

		synchronized (this) {
			createCount++;
			mapValue = map.put(key, createdValue);

			if (mapValue != null) {
				// There was a conflict so undo that last put
				map.put(key, mapValue);
			} else {
				size += safeSizeOf(key, createdValue);
			}
		}

		if (mapValue != null) {
			entryRemoved(false, key, createdValue, mapValue);
			return mapValue;
		} else {
			trimToSize(maxSize);
			return createdValue;
		}
	}


	@Override
	public V put(K key, V value) {
		if (key == null || value == null) {
			throw new NullPointerException("key == null || value == null");
		}

		V previous;
		synchronized (this) {
			putCount++;
			size += safeSizeOf(key, value);
			previous = map.put(key, value);
			if (previous != null) {
				size -= safeSizeOf(key, previous);
			}
		}

		if (previous != null) {
			entryRemoved(false, key, previous, value);
		}

		trimToSize(maxSize);
		resenctKey = key;
		return previous;
	}


	private void trimToSize(int maxSize) {
		while (true) {
			K key;
			V value;
			synchronized (this) {
				if (size < 0 || (map.isEmpty() && size != 0)) {
					throw new IllegalStateException(getClass().getName()
							+ ".sizeOf() is reporting inconsistent results!");
				}

				if (size <= maxSize || map.isEmpty()) {
					break;
				}

				Map.Entry<K, V> toEvict = map.entrySet().iterator().next();
				key = toEvict.getKey();
				value = toEvict.getValue();
				map.remove(key);
				size -= safeSizeOf(key, value);
				evictionCount++;
			}

			entryRemoved(true, key, value, null);
		}
	}


	@Override
	public final V remove(K key) {
		if (key == null) {
			throw new NullPointerException("key == null");
		}

		V previous;
		synchronized (this) {
			previous = map.remove(key);
			if (previous != null) {
				size -= safeSizeOf(key, previous);
			}
		}

		if (previous != null) {
			entryRemoved(false, key, previous, null);
		}

		return previous;
	}

	@Override
	public Collection<V> values() {
		return map.values();
	}

	protected void entryRemoved(boolean evicted, K key, V oldValue, V newValue) {
	}


	protected V create(K key) {
		return null;
	}

	private int safeSizeOf(K key, V value) {
		int result = sizeOf(key, value);
		if (result < 0) {
			throw new IllegalStateException("Negative size: " + key + "="
					+ value);
		}
		return result;
	}

	@Override
	public boolean containsKey(Object key) {
		return map.containsKey(key);
	}

	protected int sizeOf(K key, V value) {
		return 1;
	}

	/**
	 * Clear the cache, calling {@link #entryRemoved} on each removed entry.
	 */
	@Override
	public final void evictAll() {
		trimToSize(-1); // -1 will evict 0-sized elements
	}


	@Override
	public synchronized final int size() {
		return size;
	}


	@Override
	public synchronized final int maxSize() {
		return maxSize;
	}


	@Override
	public synchronized final int hitCount() {
		return hitCount;
	}


	@Override
	public synchronized final int missCount() {
		return missCount;
	}


	@Override
	public synchronized final int createCount() {
		return createCount;
	}


	@Override
	public synchronized final int putCount() {
		return putCount;
	}


	@Override
	public synchronized final int evictionCount() {
		return evictionCount;
	}


	public synchronized final Map<K, V> snapshot() {
		return new LinkedHashMap<K, V>(map);
	}

	@Override
	public synchronized final String toString() {
		int accesses = hitCount + missCount;
		int hitPercent = accesses != 0 ? (100 * hitCount / accesses) : 0;
		return String.format(
				"LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", maxSize,
				hitCount, missCount, hitPercent);
	}

	@Override
	public Map.Entry<K, V> getResentEntry() {
		return new CommonEntry<K, V>(resenctKey, this.map.get(resenctKey));
	}
}
