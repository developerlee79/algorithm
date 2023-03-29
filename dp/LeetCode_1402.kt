package dp

class LeetCode_1402 {

    fun maxSatisfaction(satisfaction: IntArray): Int {
        satisfaction.sort()

        val n = satisfaction.size
        val dp = IntArray(n)
        var maxHappiness = 0
        var k = 1

        for (i in satisfaction.indices) {
            maxHappiness += satisfaction[i] * k++

            for (j in i until n) {
                dp[i] += satisfaction[j]
            }
        }

        var maxCount = maxOf(0, maxHappiness)

        for (element in dp) {
            maxHappiness -= element
            maxCount = maxOf(maxCount, maxHappiness)
        }

        return maxCount
    }
}

fun main() {
    // Input
    val satisfaction = intArrayOf(-1, 8, 0, 5, -9)
    // Output
    LeetCode_1402().maxSatisfaction(satisfaction).let {
        println(it)
        require(it == 14)
    }
}
