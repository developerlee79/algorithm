package design;

import java.util.*;

public class LeetCode_146 {
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        System.out.println(lruCache.get(1));
        lruCache.put(3, 3);
        System.out.println(lruCache.get(2));
        lruCache.put(4, 4);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));
    }

    /**
     * Solution - LinkedHashMap
     * Time Complexity : Get : O(1), Put : O(1)
     *
     * The LRU algorithm is an algorithm that replaces the oldest referenced data to new data.
     * Use a map with linked list as a data structure to identify oldest referenced keys with the cost of O(1).
     * If get() any data, the value is excluded from the replacement because it is the recently referenced data.
     * Therefore, delete the value from the linked list and add a new value at end of linked list to set the priority back.
     * When put() new data, compare the size of the current link list to the maximum size you set, and if larger, delete the first value of the linked list (the oldest key to be referenced) and insert the new data.
     */
    private static class LRUCache {

        Map<Integer,Integer> cacheMap;

        final int CAPACITY;

        public LRUCache(int capacity) {
            CAPACITY = capacity;
            cacheMap = new LinkedHashMap<>(capacity);
        }

        public int get(int key) {
            if (cacheMap.containsKey(key)) {
                int value = cacheMap.get(key);
                cacheMap.remove(key);
                cacheMap.put(key, value);
                return value;
            }

            return -1;
        }

        public void put(int key, int value) {
            if (cacheMap.containsKey(key)) {
                cacheMap.remove(key);
            } else {
                if (cacheMap.size() == CAPACITY) {
                    cacheMap.remove(cacheMap.entrySet().iterator().next().getKey());
                }
            }

            cacheMap.put(key, value);
        }
    }
}
