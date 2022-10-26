package dp

class LeetCode_931 {

    /**
     * Solution : Prefix Sum
     * Time Complexity : O(logN)
     * Space Complexity : O(N)
     *
     * Solve the problem with prefix sum memorization array.
     * dp[i][j] = min of dp[i + 1][j - 1, j, j + 1] + matrix[i][j]
     *
     * @param matrix n x n array of integers
     * @return return the minimum sum of any falling path through matrix
    */
    fun minFallingPathSum(matrix: Array<IntArray>): Int {
        val dp = Array(matrix.size) { IntArray(matrix[0].size) }

        matrix.last().forEachIndexed { index, num ->
            dp[dp.lastIndex][index] = num
        }

        for (i in matrix.lastIndex - 1 downTo 0) {
            for (j in matrix[i].indices) {
                dp[i][j] = findMin(dp[i + 1], j) + matrix[i][j]
            }
        }

        return dp.first().minOf { it }
    }

    private fun findMin(dp: IntArray, index: Int): Int =
        if (index - 1 >= 0 && index + 1 < dp.size) {
            minOf(
                dp[index],
                dp[index - 1],
                dp[index + 1]
            )
        } else if (index - 1 >= 0) {
            minOf(
                dp[index],
                dp[index - 1]
            )
        } else {
            minOf(
                dp[index],
                dp[1]
            )
        }
}

fun main() {
    // Input
    val matrix = arrayOf(
        intArrayOf(2, 1, 3),
        intArrayOf(6, 5, 4),
        intArrayOf(7, 8, 9),
    )
    // Output
    val result = LeetCode_931().minFallingPathSum(matrix)
    println(result)
    require(result == 13)
}
