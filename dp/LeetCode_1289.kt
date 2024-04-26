package dp

class LeetCode_1289 {

    fun minFallingPathSum(grid: Array<IntArray>): Int {
        val n = grid.size

        val dp = Array(n) { IntArray(n) { -1 } }

        for (i in 0 until n) {
            dp[0][i] = grid[0][i]
        }

        for (i in 1 until n) {
            for (j in 0 until n) {
                var currentMin = Integer.MAX_VALUE

                for (k in 0 until n) {
                    if (j != k) {
                        currentMin = minOf(currentMin, grid[i][j] + dp[i - 1][k])
                    }
                }

                dp[i][j] = currentMin
            }
        }

        return dp.last().minOf { it }
    }
}

fun main() {
    // Input
    val grid = arrayOf(
        intArrayOf(1, 2, 3),
        intArrayOf(4, 5, 6),
        intArrayOf(7, 8, 9)
    )
    // Output
    LeetCode_1289().minFallingPathSum(grid).run {
        println(this)
        require(13 == this)
    }
}
