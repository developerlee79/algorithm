package dp

class LeetCode_63 {

    /**
     * Solution - Dynamic Programming (Bottom-Up)
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     *
     * The robot can only advance in a fixed direction (right and down), the problem can be solved by storing the maximum path from the destination to the corresponding position in the DP table, one by one.
     *
     * @param obstacleGrid m x n integer array
     * @return number of possible unique paths that the robot can take to reach the bottom-right corner
    */
    fun uniquePathsWithObstacles(obstacleGrid: Array<IntArray>): Int {
        val width = obstacleGrid[0].size
        val height = obstacleGrid.size

        if (obstacleGrid[obstacleGrid.lastIndex][width - 1] == 1) {
            return 0
        }

        val dp = Array(height) { IntArray(width) }
        dp[dp.lastIndex][width - 1] = 1

        for (i in obstacleGrid.indices.reversed()) {
            for (j in obstacleGrid[i].indices.reversed()) {
                if (obstacleGrid[i][j] == 1) {
                    continue
                }
                if (j + 1 < width) {
                    dp[i][j] = dp[i][j].plus(dp[i][j + 1])
                }
                if (i + 1 < height) {
                    dp[i][j] = dp[i][j].plus(dp[i + 1][j])
                }
            }
        }

        return dp[0][0]
    }
}

fun main() {
    val obstacleGrid = arrayOf(
        intArrayOf(0, 0, 0),
        intArrayOf(0, 1, 0),
        intArrayOf(0, 0, 0)
    )
    println(LeetCode_63().uniquePathsWithObstacles(obstacleGrid))
}
