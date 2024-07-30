package dp

class LeetCode_1653 {

    fun minimumDeletions(s: String): Int {
        val n = s.length

        val dp = IntArray(n + 1)

        var deleteCount = 0

        for (i in 1 .. n) {
            if (s[i - 1] == 'a') {
                dp[i] = minOf(dp[i - 1] + 1, deleteCount)
            } else {
                dp[i] = dp[i - 1]
                deleteCount++
            }
        }

        return dp[n]
    }
}

fun main() {
    // Input
    val s = "aababbab"
    // Output
    LeetCode_1653().minimumDeletions(s).run {
        println(this)
        require(2 == this)
    }
}
