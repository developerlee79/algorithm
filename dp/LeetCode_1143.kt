package dp

class LeetCode_1143 {

    fun longestCommonSubsequence(text1: String, text2: String): Int {
        val n = text1.length
        val m = text2.length

        val dp = Array(n + 1) { IntArray(m + 1) }

        for (i in 1 .. n) {
            for (j in 1 .. m) {
                if (text1[i - 1] == text2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1
                } else {
                    dp[i][j] = maxOf(dp[i - 1][j], dp[i][j - 1])
                }
            }
        }

        return dp[n][m]
    }
}

fun main() {
    // Input
    val text1 = "abcde"
    val text2 = "ace"
    // Output
    LeetCode_1143().longestCommonSubsequence(text1, text2).run {
        println(this)
        require(3 == this)
    }
}
