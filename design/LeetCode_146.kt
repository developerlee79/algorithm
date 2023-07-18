package design

import java.util.LinkedHashMap

class LeetCode_146 {

    class LRUCache(
        private val capacity: Int
    ) {

        private val cacheMap = LinkedHashMap<Int, Int>(capacity)

        fun get(key: Int): Int {
            if (cacheMap.containsKey(key)) {
                val value = cacheMap[key]!!
                cacheMap.remove(key)
                cacheMap[key] = value
                return value
            }

            return -1
        }

        fun put(key: Int, value: Int) {
            if (cacheMap.containsKey(key)) {
                cacheMap.remove(key)
            } else if (cacheMap.size == capacity) {
                cacheMap.remove(cacheMap.entries.iterator().next().key)
            }

            cacheMap[key] = value
        }
    }
}

fun main() {
    // Input
    val cache = LeetCode_146.LRUCache(2)
    // Output
    cache.put(1, 1)
    cache.put(2, 2)
    require(1 == cache.get(1))
    cache.put(3, 3)
    require(-1 == cache.get(2))
    cache.put(4, 4)
    require(-1 == cache.get(1))
    require(3 == cache.get(3))
    require(4 == cache.get(4))
}
