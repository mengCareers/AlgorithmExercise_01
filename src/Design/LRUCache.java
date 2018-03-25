/* 146.LRU Cache
get(key) 
- Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) 
- Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 * Thought Process:
map<key, val>
get(key) {
    if (map.containsKey(key)) {
        changeR(key);
        return map.get(key);
    }
    return -1;
}
put(key, value) {
    if (map.containsKey(key)) {
        changeR(key);
        map.put(key, val);
    }
    else {
        if (map.size() == capacity) {
            removeLeastR();
            changeR(key);
            map.put(key, val);
        }
    }
}
How to represent R? Doubly
 */
package Design;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author xinrong
 */
public class LRUCache {
    
    class MyLinkedHashMap<K, V> extends LinkedHashMap<K, V> {
        int cap;
        public MyLinkedHashMap(int cap) {
            super(16, 0.75f, true);
            this.cap = cap;
        }
        
        protected boolean removeEldestEntry(Map.Entry<K,V> eldest) {
            return size() > cap;
        }
        
    }

    Map<Integer, Integer> map;

    public LRUCache(int capacity) {
        map = new MyLinkedHashMap<Integer, Integer>(capacity);
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            return map.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        map.put(key, value);
    }
}
