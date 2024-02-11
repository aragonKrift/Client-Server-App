import java.util.Map;
import java.util.LinkedHashMap;
public class LRUCache<K, V> implements IAlgoCache<K, V>{

    private final int capacity;
    private final Map<K, V> cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new LinkedHashMap<K, V>();
    }

    @Override
    public V get(K key) {
        return cache.getOrDefault(key, null);
    }

    @Override
    public void put(K key, V value) {
        if(cache.size() >= this.capacity) {
            cache.remove(cache.entrySet().iterator().next().getKey());
        }
        cache.put(key, value);
    }
}
