package dp

class LeetCode_983 {

    fun mincostTickets(days: IntArray, costs: IntArray): Int {
        val daySet = days.toHashSet()
        val dp = IntArray(30)

        for (i in days.first() .. days.last()) {
            if (daySet.contains(i)) {
                dp[i % 30] = minOf(
                    dp[(i - 1) % 30] + costs[0],
                    dp[maxOf(0, i - 7) % 30] + costs[1],
                    dp[maxOf(0, i - 30) % 30] + costs[2]
                )
            } else {
                dp[i % 30] = dp[(i - 1) % 30]
            }
        }

        return dp[days.last() % 30]
    }

}

fun main() {
    // Input
    val days = intArrayOf(1, 4, 6, 7, 8, 20)
    val costs = intArrayOf(2, 7, 15)
    // Output
    LeetCode_983().mincostTickets(days, costs).let {
        println(it)
        require(it == 11)
    }
}
