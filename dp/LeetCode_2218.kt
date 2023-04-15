package dp

class LeetCode_2218 {

    fun maxValueOfCoins(piles: List<List<Int>>, k: Int): Int {
        val dp = Array(piles.size + 1) { IntArray(k + 1) }

        for (i in piles.lastIndex downTo 0) {
            for (kIndex in k downTo 1) {
                var currentValue = 0
                var maxValue = dp[i + 1][kIndex]

                for (j in 0 until minOf(kIndex, piles[i].size)) {
                    currentValue += piles[i][j]
                    maxValue = maxOf(maxValue, currentValue + dp[i + 1][kIndex - (j + 1)])
                }

                dp[i][kIndex] = maxValue
            }
        }

        return dp[0][k]
    }

}

fun main() {
    // Input
    val piles = listOf(
        listOf(1, 100, 3),
        listOf(7, 8, 9)
    )
    val k = 2
    // Output
    LeetCode_2218().maxValueOfCoins(piles, k).let {
        println(it)
        require(101 == it)
    }
}
