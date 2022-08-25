package math

class LeetCode_96 {

    /**
     * Solution - Dynamic Programming (Cartesian product)
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     *
     * I'm not 100% understanding now.
     * Check out this explanation with intuition & formula.
     * https://leetcode.com/problems/unique-binary-search-trees/discuss/31666/DP-Solution-in-6-lines-with-explanation.-F(i-n)-G(i-1)-*-G(n-i)
     *
     * @param n integer
     * @return number of structurally unique binary search trees which has exactly n nodes of unique values from 1 to n
    */
    fun numTrees(n: Int): Int {
        val dp = IntArray(n + 1)
        dp[0] = 1
        dp[1] = 1

        for (i in 2..n) {
            for (j in 1..i) {
                dp[i] += dp[j - 1] * dp[i - j]
            }
        }

        return dp.last()
    }
}

fun main() {
    val n = 3
    println(LeetCode_96().numTrees(n))
}
