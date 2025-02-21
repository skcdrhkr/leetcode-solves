package hashmaps;

public class CustomHashMap {
}

class MyHashMap<K, V> {
    private int capacity;
    private Entry<K, V>[] map;

    public MyHashMap() {
        this.capacity = 16;
        map = (Entry<K, V>[]) new Object[capacity];
    }

}

class Entry<K, V> {
    K key;
    V value;
    Entry<K, V> prev, next;

    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
    }
}
