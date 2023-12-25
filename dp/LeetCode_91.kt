package dp

class LeetCode_91 {

    fun numDecodings(s: String): Int {
        val n = s.length

        if (n == 0) {
            return 0
        }

        val dp = IntArray(n + 1)
        dp[n] = 1

        for (i in n - 1 downTo 0) {
            if (s[i] == '0') {
                dp[i] = 0
            } else {
                dp[i] += dp[i + 1]

                if (i + 1 < n && s.substring(i, i + 2).toInt() <= 26) {
                    dp[i] += dp[i + 2]
                }
            }
        }

        return dp[0]
    }
}

fun main() {
    // Input
    val s = "12"
    // Output
    LeetCode_91().numDecodings(s).run {
        println(this)
        require(2 == this)
    }
}
