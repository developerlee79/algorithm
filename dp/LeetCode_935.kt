package dp

class LeetCode_935 {

    private val dials = arrayOf(
        intArrayOf(4, 6),
        intArrayOf(6, 8),
        intArrayOf(7, 9),
        intArrayOf(4, 8),
        intArrayOf(0, 3, 9),
        intArrayOf(),
        intArrayOf(0, 1, 7),
        intArrayOf(2, 6),
        intArrayOf(1, 3),
        intArrayOf(2, 4)
    )

    fun knightDialer(n: Int): Int {
        val dp = Array(n) { IntArray(10) }
        dp[0].fill(1)

        for (i in 1 until n) {
            for (j in 0 until 10) {
                dials[j].forEach { dial ->
                    dp[i][j] = (dp[i][j] + dp[i - 1][dial]) % 1000000007
                }
            }
        }

        var count = 0

        for (num in dp[n - 1]) {
            count = (count + num) % 1000000007
        }

        return count
    }
}

fun main() {
    // Input
    val n = 1
    // Output
    LeetCode_935().knightDialer(n).run {
        println(this)
        require(10 == this)
    }
}
