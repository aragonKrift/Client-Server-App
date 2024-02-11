import java.util.LinkedHashMap;
import java.util.Map;

public class FIFOCache<K, V> implements IAlgoCache<K, V>{
    private final int capacity;
    private final Map<K, V> cache;

    public FIFOCache(int capacity) {
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
            cache.remove(cache.keySet().iterator().next());
        }
        cache.put(key, value);
    }
}
