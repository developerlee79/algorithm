package dp

class LeetCode_1140 {

    fun stoneGameII(piles: IntArray): Int {
        val n = piles.size

        val dp = Array(n) { IntArray(n) }
        val prefix = IntArray(n)
        prefix[prefix.lastIndex] = piles.last()

        for (i in (0 until n - 1).reversed()) {
            prefix[i] = piles[i] + prefix[i + 1]
        }

        return findOptimal(piles, 0, 1, dp, prefix)
    }

    private fun findOptimal(piles: IntArray, index: Int, m: Int, dp: Array<IntArray>, prefix: IntArray): Int {
        if (index !in piles.indices) {
            return 0
        }

        if (m * 2 >= piles.size - index) {
            return prefix[index]
        }

        if (dp[index][m] > 0) {
            return dp[index][m]
        }

        var maxScore = 0

        for (i in 1 .. (m * 2)) {
            val currentMax = prefix[index] - findOptimal(piles, index + i, maxOf(m, i), dp, prefix)
            maxScore = maxOf(maxScore, currentMax)
        }

        dp[index][m] = maxScore

        return maxScore
    }
}

fun main() {
    // Input
    val piles = intArrayOf(2, 7, 9, 4, 4)
    // Output
    LeetCode_1140().stoneGameII(piles).run {
        println(this)
        require(10 == this)
    }
}
