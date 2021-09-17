package Algorithm.structure.map.HashMap;

import Algorithm.structure.map.Map;

import java.util.LinkedList;

public class HashMap<E, V> implements Map<E, V> {

    class Node<E, V> {
        final E key;
        V value;
        Node<E, V> next;

        public Node(E key, V value, Node<E, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public E getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public Node<E, V> getNext() {
            return next;
        }
    }

    private Node<E, V>[] nodeList;
    private static final int INITIAL_CAPACITY = 1 << 4;

    private int size = 0;

    public HashMap() {
        this(INITIAL_CAPACITY);
    }

    public HashMap(int capacity) {
        this.nodeList = new Node[capacity];
    }

    @Override
    public void put(E k, E o) {
        Node<E, E> node = new Node<E, E>(k, o, null);
//
//        int bucket = getHash(k) % getBucketSize();
//
//        Node<E, V> existing = buckets[bucket];
//        if (existing == null) {
//            buckets[bucket] = node;
//            size++;
//        } else {
//            // compare the keys see if key already exists
//            while (existing.next != null) {
//                if (existing.key.equals(key)) {
//                    existing.value = value;
//                    return;
//                }
//                existing = existing.next;
//            }
//
//            if (existing.key.equals(key)) {
//                existing.value = value;
//            } else {
//                existing.next = node;
//                size++;
//            }
//        }
    }

    @Override
    public Object get(Object obj) {
        return null;
    }

    @Override
    public void remove(Object obj) {

    }

    @Override
    public int size() {
        return 1;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
