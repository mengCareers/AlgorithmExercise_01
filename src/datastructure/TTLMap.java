/*
Run a thread that will take a lock on map and remove expired elements from the map at regular intervals.
 + Remove the key while calling get(): If the key is expired, remove it from the map otherwise return it's value.
   Calling get() while calling clearExpired() in keySet() and values() and entrySet()
 * GET:
Collections
    unmodifiableSet(Set<? extends T> s)               Returns an unmodifiable view of the specified set.
    unmodifiableCollection(Collection<? extends T> c) Returns an unmodifiable view of the specified collection.
 * 
 */
package datastructure;

import java.util.Collection;
import static java.util.Collections.unmodifiableCollection;
import static java.util.Collections.unmodifiableSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author xinrong
 */
public class TTLMap<K, V> implements Map<K, V> {

    public final long TTL;
    private final HashMap<K, V> store = new HashMap<>();
    private final HashMap<K, Long> timestamps = new HashMap<>();

    public TTLMap(TimeUnit ttlUnit, long ttlValue) {
        TTL = ttlUnit.toNanos(ttlValue);
    }

    @Override
    public int size() {
        return store.size();
    }

    @Override
    public boolean isEmpty() {
        return store.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return store.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return store.containsValue(value);
    }

    @Override
    public V get(Object key) {
        V v = store.get(key);
        if (v != null && expired(key, v)) {
            store.remove(key);
            timestamps.remove(key);
            return null;
        } else {
            return v;
        }
    }

    private boolean expired(Object k, V v) {
        return System.nanoTime() - timestamps.get(k) > TTL;
    }

    @Override
    public V put(K key, V value) {
        timestamps.put(key, System.nanoTime());
        return store.put(key, value);
    }

    @Override
    public V remove(Object key) {
        timestamps.remove(key);
        return store.remove(key);
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        for (Map.Entry<? extends K, ? extends V> e : m.entrySet()) {
            put(e.getKey(), e.getValue());
        }
    }

    @Override
    public void clear() {
        timestamps.clear();
        store.clear();
    }

    @Override
    public Set<K> keySet() {
        clearExpired();
        return unmodifiableSet(store.keySet());
    }

    @Override
    public Collection<V> values() {
        clearExpired();
        return unmodifiableCollection(store.values());
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        clearExpired();
        return unmodifiableSet(store.entrySet());
    }

    private void clearExpired() {
        for (K k : store.keySet()) {
            get(k);
        }
    }
}
