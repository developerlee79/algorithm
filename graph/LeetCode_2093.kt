package graph

import java.util.PriorityQueue

class LeetCode_2093 {

    private data class Location(
        val city: Int,
        val cost: Int,
        val discounts: Int
    )

    fun minimumCost(n: Int, highways: Array<IntArray>, discounts: Int): Int {
        val cityMap = constructCityMap(highways)

        if (!cityMap.containsKey(n - 1)) {
            return -1
        }

        val roadQueue = PriorityQueue<Location>(compareBy { it.cost })
        roadQueue.add(Location(0, 0, discounts))

        val shortestPath = Array(n) { IntArray(discounts + 1) { Int.MAX_VALUE } }
        shortestPath[0][0] = 0

        while (roadQueue.isNotEmpty()) {
            val (city, cost, discount) = roadQueue.poll()

            if (shortestPath[city][discount] < cost) {
                continue
            }

            if (city == n - 1) {
                return cost
            }

            cityMap[city]?.forEach {
                val (nextCity, nextCost) = it

                if (cost + nextCost < shortestPath[nextCity][discount]) {
                    shortestPath[nextCity][discount] = cost + nextCost
                    roadQueue.add(Location(nextCity, cost + nextCost, discount))
                }

                if (discount > 0 && cost + nextCost / 2 < shortestPath[nextCity][discount - 1]) {
                    shortestPath[nextCity][discount - 1] = cost + nextCost / 2
                    roadQueue.add(Location(nextCity, cost + nextCost / 2, discount - 1))
                }
            }
        }

        return -1
    }

    private fun constructCityMap(highways: Array<IntArray>): HashMap<Int, MutableList<Pair<Int, Int>>> {
        val cityMap = hashMapOf<Int, MutableList<Pair<Int, Int>>>()

        highways.forEach { highway ->
            cityMap.computeIfAbsent(highway[0]) { mutableListOf() }.add(Pair(highway[1], highway[2]))
            cityMap.computeIfAbsent(highway[1]) { mutableListOf() }.add(Pair(highway[0], highway[2]))
        }

        return cityMap
    }
}

fun main() {
    // Input
    val n = 5
    val highways = arrayOf(
        intArrayOf(0, 1, 4),
        intArrayOf(2, 1, 3),
        intArrayOf(1, 4, 11),
        intArrayOf(3, 2, 3),
        intArrayOf(3, 4, 2)
    )
    val discounts = 1
    // Output
    LeetCode_2093().minimumCost(n, highways, discounts).run {
        println(this)
        require(9 == this)
    }
}
