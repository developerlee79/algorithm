package dp

class LeetCode_256 {

    fun minCost(costs: Array<IntArray>): Int {
        for (i in 1 until costs.size) {
            costs[i][0] += minOf(costs[i - 1][1], costs[i - 1][2])
            costs[i][1] += minOf(costs[i - 1][0], costs[i - 1][2])
            costs[i][2] += minOf(costs[i - 1][0], costs[i - 1][1])
        }

        return costs.last().minOf { it }
    }
}

fun main() {
    // Input
    val costs = arrayOf(
        intArrayOf(17, 2, 17),
        intArrayOf(16, 16, 5),
        intArrayOf(14, 3, 19)
    )
    // Output
    LeetCode_256().minCost(costs).run {
        println(this)
        require(10 == this)
    }
}
