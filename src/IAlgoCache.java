public interface IAlgoCache<K, V> {
    //Retrieve a value from memory
    V get(K key);

    //Insert a value to memory
    void put(K key, V value);
}
