package dp

class LeetCode_746 {

    fun minCostClimbingStairs(cost: IntArray): Int {
        val n = cost.size

        var firstStair = cost[0]
        var secondStair = cost[1]

        for (i in 2 until n) {
            val current = cost[i] + minOf(firstStair, secondStair)
            firstStair = secondStair
            secondStair = current
        }

        return minOf(firstStair, secondStair)
    }
}

fun main() {
    val cost = intArrayOf(10, 15, 20)
    LeetCode_746().minCostClimbingStairs(cost).run {
        println(this)
        require(15 == this)
    }
}
