package graph

class LeetCode_2050 {

    fun minimumTime(n: Int, relations: Array<IntArray>, time: IntArray): Int {
        val relationMap = HashMap<Int, MutableList<Int>>()

        relations.forEach {
            relationMap.computeIfAbsent(it[1]) { mutableListOf() }.add(it[0])
        }

        val dp = IntArray(n)
        var totalTime = 0

        repeat(n) {
            totalTime = maxOf(totalTime, findTotalTime(relationMap, it + 1, time, dp))
        }

        return totalTime
    }

    private fun findTotalTime(relationMap: HashMap<Int, MutableList<Int>>, target: Int, time: IntArray, dp: IntArray): Int {
        if (dp[target - 1] != 0) {
            return dp[target - 1]
        }

        var maxTotal = 0

        relationMap[target]?.forEach {
            maxTotal = maxOf(maxTotal, findTotalTime(relationMap, it, time, dp))
        }

        dp[target - 1] = maxTotal + time[target - 1]

        return dp[target - 1]
    }

}

fun main() {
    // Input
    val n = 7
    val relations = arrayOf(
        intArrayOf(1, 7),
        intArrayOf(1, 4),
        intArrayOf(1, 3),
        intArrayOf(2, 3),
        intArrayOf(4, 3),
        intArrayOf(5, 3),
        intArrayOf(7, 3),
        intArrayOf(7, 6),
    )
    val time = intArrayOf(6, 5, 1, 8, 2, 9, 4)
    // Output
    LeetCode_2050().minimumTime(n, relations, time).run {
        println(this)
        require(19 == this)
    }
}
