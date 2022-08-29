package math

import kotlin.math.min

class LeetCode_279 {

    /**
     * Solution - Dynamic Programming
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     *
     * @param n integer
     * @return return the least number of perfect square numbers that sum to n
    */
    fun numSquares(n: Int): Int {
        val dp = IntArray(n + 1) { Integer.MAX_VALUE }
        dp[0] = 0

        for (i in 1..n) {
            var min = Integer.MAX_VALUE

            var j = 1
            while (i - j * j >= 0) {
                min = min(min, dp[i - j * j] + 1)
                j++
            }

            dp[i] = min
        }

        return dp[n]
    }
}

fun main() {
    val n = 43
    val result = LeetCode_279().numSquares(n)
    println(result)
    assert(result == 3)
}
