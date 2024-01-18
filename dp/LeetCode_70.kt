package dp

class LeetCode_70 {

    fun climbStairs(n: Int): Int {
        if (n <= 3) {
            return n
        }

        val dp = IntArray(n + 1)
        dp[1] = 1
        dp[2] = 2
        dp[3] = 3

        for (i in 4 .. n) {
            dp[i] = dp[i - 1] + dp[i - 2]
        }

        return dp[n]
    }
}
