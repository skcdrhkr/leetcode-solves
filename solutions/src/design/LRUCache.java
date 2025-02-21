package design;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    public static void main(String[] args) {
        LRU<String, Integer> lru = new LRU<>(3);

        lru.put("Apple", 2);
        lru.put("Banana", 4);
        System.out.println(lru.get("Banana"));
        System.out.println(lru.get("Dog"));
        lru.put("Apple", 5);
        lru.put("Cat", 10);
        System.out.println(lru.get("Apple"));

        lru.put("Dog", 12);
        lru.put("Elephant", 99);
        System.out.println(lru.get("Banana"));

    }
}

class LRU<K, V> {
    private Map<K, Node<K, V>> cache;
    private Node<K, V> head, tail;
    private int capacity;

    public LRU(int capacity) {
        this.cache = new HashMap<>();
        this.capacity = capacity;
    }

    // [1] -> 2 -> 3
    // 1 -> [2]
    // [1]
    // 1 -> [2] -> 3
    public V get(K key) {
        Node<K, V> node = cache.get(key);
        if (node == null) {
            return null;
        }
        if (head != node) {
            removeFromCurrentPosition(node);
            addNodeToHead(node);
        }
        return node.value;
    }

    // _
    // 1 -> [2]
    // [1] -> 2
    // [] -> 1 -> 2
    public void put(K key, V value) {
        Node<K, V> node = cache.get(key);
        if (node != null) {
            node.value = value;
            if (head != node) {
                removeFromCurrentPosition(node);
                addNodeToHead(node);
            }
        } else {
            node = new Node<>(key, value);
            cache.put(key, node);
            addNodeToHead(node);

            if (tail == null) {
                tail = node;
            }

            if (cache.size() > capacity) {
                removeLastNode();
            }
        }
    }

    public int size() {
        return cache.size();
    }

    private void addNodeToHead(Node<K, V> node) {
        node.next = head;
        if (head != null) {
            head.prev = node;
        }
        head = node;
    }

    private void removeFromCurrentPosition(Node<K, V> node) {
        Node<K, V> next = node.next;
        Node<K, V> prev = node.prev;
        prev.next = next;
        if (next != null) {
            next.prev = prev;
        } else {
            tail = prev;
        }
        node.next = null;
        node.prev = null;
    }

    private void removeLastNode() {
        Node<K, V> last = tail;
        Node<K, V> secondLast = last.prev;
        if (secondLast == null) {
            head = null;
        } else {
            secondLast.next = null;
        }
        tail.prev = null;
        tail = secondLast;
        cache.remove(last.key);
    }
}

class Node<K, V> {

    public K key;
    public V value;
    public Node<K, V> prev;
    public Node<K, V> next;

    public Node(K key, V value) {
        this.key = key;
        this.value = value;
    }

}
