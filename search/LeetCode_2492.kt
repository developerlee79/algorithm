package search

import java.util.LinkedList
import java.util.Queue

class LeetCode_2492 {

    private class City(
        val cityCode: Int
    ) {

        val connectedCities = hashMapOf<Int, Int>()

        fun connectCity(cityCode: Int, distance: Int) {
            connectedCities[cityCode] = distance
        }

    }

    fun minScore(n: Int, roads: Array<IntArray>): Int {
        val roadMap = hashMapOf<Int, City>()

        roads.forEach { road ->
            roadMap.computeIfAbsent(road[0]) { City(road[0]) }.connectCity(road[1], road[2])
            roadMap.computeIfAbsent(road[1]) { City(road[1]) }.connectCity(road[0], road[2])
        }

        val visited = hashSetOf<Int>()
        val roadQueue: Queue<Int> = LinkedList()
        roadQueue.add(1)

        var score = Integer.MAX_VALUE

        while (roadQueue.isNotEmpty()) {
            val currentCity = roadQueue.poll()

            roadMap[currentCity]!!.connectedCities.forEach {
                if (!visited.contains(it.key)) {
                    roadQueue.add(it.key)
                    visited.add(it.key)
                }
                score = minOf(score, it.value)
            }
        }

        return score
    }

}

fun main() {
    // Input
    val n = 4
    val roads = arrayOf(
        intArrayOf(1, 2, 9),
        intArrayOf(2, 3, 6),
        intArrayOf(2, 4, 5),
        intArrayOf(1, 4, 7),
    )
    // Output
    LeetCode_2492().minScore(n, roads).let {
        println(it)
        require(it == 5)
    }
}
