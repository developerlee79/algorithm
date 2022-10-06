package design

import java.util.TreeMap

class LeetCode_981 {

    /**
     * Solution : TreeMap
     * Time Complexity : O(logN)
     * Space Complexity : O(N)
     *
     * Find the nearest time with the treemap data structure.
     */
    class TimeMap {

        private val timeMap = mutableMapOf<String, TreeMap<Int, String>>()

        fun set(key: String, value: String, timestamp: Int) {
            timeMap.putIfAbsent(key, TreeMap())
            timeMap[key]!![timestamp] = value
        }

        fun get(key: String, timestamp: Int): String =
            timeMap[key]?.let {
                return if (it.containsKey(timestamp))
                    it[timestamp]!!
                else if (it.firstKey() > timestamp)
                    ""
                else if (it.lastKey() < timestamp)
                    it[it.lastKey()]!!
                else
                    it[it.floorKey(timestamp)]!!
            } ?: ""
    }
}

fun main() {
    // Input
    val timeMap = LeetCode_981.TimeMap()
    val resultList = mutableListOf<String>()
    timeMap.set("foo", "bar", 1)
    resultList.add(timeMap.get("foo", 1))
    resultList.add(timeMap.get("foo", 3))
    timeMap.set("foo", "bar2", 4)
    resultList.add(timeMap.get("foo", 4))
    resultList.add(timeMap.get("foo", 5))
    // Output
    for (result in resultList) {
        println(result)
    }
}
