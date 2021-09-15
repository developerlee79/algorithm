package Algorithm.structure.set.hashset;

import Algorithm.structure.set.Set;

import java.util.Arrays;

public class HashSet<E> implements Set<E> {

    private final static int DEFAULT_CAPACITY = 1 << 4;

    private final static float LOAD_FACTOR = 0.75f;

    Node<E>[] table;
    private int size;

    @SuppressWarnings("unchecked")
    public HashSet() {
        table = (Node<E>[]) new Node[DEFAULT_CAPACITY];
        size = 0;
    }

    private static int hash(Object key) {
        int hash;
        if (key == null)
            return 0;
        else
            return Math.abs(hash = key.hashCode()) ^ (hash >>> 16);
    }

    @Override
    public boolean add(E e) {
        return add(hash(e), e) == null;
    }

    private E add(int hash, E key) {
        int idx = hash % table.length;

        if (table[idx] == null) {
            table[idx] = new Node<E>(hash, key, null);
        } else {
            Node<E> temp = table[idx];
            Node<E> prev = null;

            while (temp != null) {
                if ((temp.hash == hash) && (temp.key == key || temp.key.equals(key))) {
                    return key;
                }
                prev = temp;
                temp = temp.next;
            }

            prev.next = new Node<E>(hash, key, null);
        }
        size++;

        if (size >= LOAD_FACTOR * table.length) {
            resize();
        }

        return null;
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        int newCapacity = table.length * 2;
        final Node<E>[] newTable = (Node<E>[]) new Node[newCapacity];

        for (int i = 0; i < table.length; i++) {
            Node<E> value = table[i];

            if (value == null) {
                continue;
            }

            table[i] = null;

            Node<E> nextNode;

            while (value != null) {
                int idx = value.hash % newCapacity;

                if (newTable[idx] != null) {
                    Node<E> tail = newTable[idx];

                    while (tail.next != null) {
                        tail = tail.next;
                    }

                    nextNode = value.next;
                    value.next = null;
                    tail.next = value;
                } else {
                    nextNode = value.next;
                    value.next = null;
                    newTable[idx] = value;
                }

                value = nextNode;
            }
        }
        table = null;
        table = newTable;
    }

    @Override
    public boolean remove(Object o) {
        return remove(hash(o), o) != null;
    }

    private Object remove(int hash, Object key) {

        int idx = hash % table.length;

        Node<E> node = table[idx];
        Node<E> removedNode = null;
        Node<E> prev = null;

        if (node == null) {
            return null;
        }

        while (node != null) {
            if (node.hash == hash && (node.key == key || node.key.equals(key))) {
                removedNode = node;

                if (prev == null)
                    table[idx] = node.next;
                else
                    prev.next = node.next;

                node = null;
                size--;
                break;
            }
            prev = node;
            node = node.next;
        }

        return removedNode;
    }

    @Override
    public boolean contains(Object o) {
        int idx = hash(o) % table.length;
        Node<E> temp = table[idx];

        while (temp != null) {
            if (o == temp.key || (temp.key.equals(o))) {
                return true;
            }
            temp = temp.next;
        }

        return false;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        if (table != null && size > 0) {
            Arrays.fill(table, null);
            size = 0;
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof HashSet)) {
            return false;
        }

        HashSet<E> oSet;

        try {
            oSet = (HashSet<E>) o;

            if (oSet.size() != size) {
                return false;
            }

            for (int i = 0; i < oSet.table.length; i++) {
                Node<E> oTable = oSet.table[i];

                while (oTable != null) {
                    if (!contains(oTable)) {
                        return false;
                    }
                    oTable = oTable.next;
                }
            }
        } catch (ClassCastException e) {
            return false;
        }
        return true;
    }
}
