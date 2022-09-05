package dp

import kotlin.math.min

class LeetCode_712 {

    /**
     * Solution - Dynamic Programming
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     *
     * @param s1 string
     * @param s2 string
     * @return lowest ASCII sum of deleted characters to make two strings equal
    */
    fun minimumDeleteSum(s1: String, s2: String): Int {
        val n = s1.length
        val m = s2.length

        val dp = Array(n + 1) { IntArray(m + 1) }

        for (i in 1 .. n) {
            dp[i][0] = dp[i - 1][0] + s1[i - 1].digitToInt()
        }

        for (i in 1 .. m) {
            dp[0][i] = dp[0][i - 1] + s2[i - 1].digitToInt()
        }

        for (i in 1 .. n) {
            for (j in 1 .. m) {
                val s1Value = s1[i - 1].digitToInt()
                val s2Value = s2[j - 1].digitToInt()

                dp[i][j] = if (s1Value == s2Value) {
                    dp[i - 1][j - 1]
                } else {
                    min(dp[i - 1][j] + s1Value, dp[i][j - 1] + s2Value)
                }
            }
        }

        return dp[n][m]
    }
}

fun main() {
    val s1 = "sea"
    val s2 = "eat"
    println(LeetCode_712().minimumDeleteSum(s1, s2))
}
