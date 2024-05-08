package graph

import java.util.PriorityQueue

class LeetCode_2473 {

    private data class Travel(
        val location: Int,
        val totalCost: Long
    )

    fun minCost(n: Int, roads: Array<IntArray>, appleCost: IntArray, k: Int): LongArray {
        val minCostArray = LongArray(n)
        val roadMap = constructRoadMap(roads)

        for (i in 1..n) {
            minCostArray[i - 1] = findMinCost(i, roadMap, appleCost, k)
        }

        return minCostArray
    }

    private fun constructRoadMap(roads: Array<IntArray>): HashMap<Int, MutableList<Pair<Int, Int>>> {
        val cityMap = HashMap<Int, MutableList<Pair<Int, Int>>>()

        roads.forEach { road ->
            cityMap.computeIfAbsent(road[0]) { mutableListOf() }.add(Pair(road[1], road[2]))
            cityMap.computeIfAbsent(road[1]) { mutableListOf() }.add(Pair(road[0], road[2]))
        }

        return cityMap
    }

    private fun findMinCost(
        startPoint: Int,
        roadMap: HashMap<Int, MutableList<Pair<Int, Int>>>,
        appleCost: IntArray,
        k: Int
    ): Long {
        val costQueue = PriorityQueue<Travel> { tr1, tr2 -> tr1.totalCost.minus(tr2.totalCost).toInt() }
        costQueue.add(Travel(startPoint, 0))

        val visited = BooleanArray(appleCost.size + 1)

        var minCost = Long.MAX_VALUE

        while (costQueue.isNotEmpty()) {
            val (currentLocation, currentTotalCost) = costQueue.poll()

            visited[currentLocation] = true

            minCost = minOf(minCost, currentTotalCost + (currentTotalCost * k) + appleCost[currentLocation - 1])

            roadMap[currentLocation]?.forEach { (nextCity, cost) ->
                if (visited[nextCity]) {
                    return@forEach
                }

                costQueue.add(Travel(nextCity, currentTotalCost + cost))
            }
        }

        return minCost
    }
}

fun main() {
    // Input
    val n = 4
    val roads = arrayOf(
        intArrayOf(1, 2, 4),
        intArrayOf(2, 3, 2),
        intArrayOf(2, 4, 5),
        intArrayOf(3, 4, 1),
        intArrayOf(1, 3, 4)
    )
    val appleCost = intArrayOf(56, 42, 102, 301)
    val k = 2
    // Output
    LeetCode_2473().minCost(n, roads, appleCost, k).run {
        println(this.joinToString())
        require(
            longArrayOf(54, 42, 48, 51).contentEquals(this)
        )
    }
}
