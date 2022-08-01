package array;

import java.util.Objects;

public class leetcode_706 {
    public static void main(String[] args) {
        MyHashMap hashMap = new MyHashMap();
        hashMap.put(1, 1);
        hashMap.put(2, 2);
        System.out.println(hashMap.get(1));
        System.out.println(hashMap.get(3));
        hashMap.put(2, 1);
        System.out.println(hashMap.get(2));
        hashMap.remove(2);
        System.out.println(hashMap.get(2));
    }

    // Solution - Linked List
    // Time Complexity : O(?)
    // Space Complexity : O(?)
    static class MyHashMap {

        ListNode[] hashMapArr;

        final int initSize = 19997;
        int maxSize = 12582917;

        public MyHashMap() {
            hashMapArr = new ListNode[initSize];
        }

        public MyHashMap(int size) {
            hashMapArr = new ListNode[size];
        }

        public void put(int key, int value) {
            remove(hashCode(key));
            hashMapArr[hashCode(key)] = new ListNode(key, value, hashMapArr[hashCode(key)]);
        }

        public int get(int key) {
            ListNode node = hashMapArr[hashCode(key)];
            for (; node != null; node = node.next)
                if (node.key == key)
                    return node.value;
            return -1;
        }

        public void remove(int key) {
            int hash = hashCode(key);
            ListNode node = hashMapArr[hash];
            if (node == null) return;
            if (node.key == key) hashMapArr[hash] = node.next;
            else for (; node.next != null; node = node.next)
                if (node.next.key == key) {
                    node.next = node.next.next;
                    return;
                }
        }

        protected int hashCode(int key) {
            return (int) ((long) key * maxSize % initSize);
        }

        static class ListNode {
            final int key;
            int value;
            ListNode next;

            public ListNode(int key, int value, ListNode next) {
                this.key = key;
                this.value = value;
                this.next = next;
            }

            public int getKey() {
                return key;
            }

            public int getValue() {
                return value;
            }

            public ListNode getNext() {
                return next;
            }
        }
    }
}
