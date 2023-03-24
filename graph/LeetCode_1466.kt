package graph

import kotlin.math.absoluteValue

class LeetCode_1466 {

    fun minReorder(n: Int, connections: Array<IntArray>): Int {
        val connectMap = hashMapOf<Int, MutableList<Int>>()

        connections.forEach {
            connectMap.computeIfAbsent(it[0]) { mutableListOf() }.add(it[1])
            connectMap.computeIfAbsent(it[1]) { mutableListOf() }.add(-it[0])
        }

        return calculateCost(0, connectMap, BooleanArray(n))
    }

    private fun calculateCost(key: Int, connectionMap: HashMap<Int, MutableList<Int>>, connected: BooleanArray): Int {
        var count = 0

        connected[key] = true

        connectionMap[key]!!.forEach {
            if (!connected[it.absoluteValue]) {
                if (it > 0) {
                    count++
                }

                count += calculateCost(
                    it.absoluteValue,
                    connectionMap,
                    connected
                )
            }
        }

        return count
    }

}

fun main() {
    // Input
    val n = 6
    val connections = arrayOf(
        intArrayOf(0, 1),
        intArrayOf(1, 3),
        intArrayOf(2, 3),
        intArrayOf(4, 0),
        intArrayOf(4, 5)
    )
    // Output
    LeetCode_1466().minReorder(n, connections).let {
        println(it)
        require(it == 3)
    }
}
