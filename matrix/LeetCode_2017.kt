package matrix

import java.util.*
import kotlin.math.max
import kotlin.math.min

class LeetCode_2017 {

    /**
     * Solution - Prefix Sum
     * Time Complexity : O(N)
     * Space Complexity : O(1)
     *
     * Use Prefix & Suffix Sum to solve this problem.
     *
     * The Grid game has the following rules:
     * 1. Matrix is 2 x N size
     * 2. Both robots initially start at (0, 0) and want to reach (1, n - 1)
     * 3. Each robot may only move to the right or down
     *
     * So once down, the robot can only move to the right. Therefore, we can see that we can use Prefix Sum.
     * The optimal path for the second robot is the path that the first robot doesn't pass.
     * Obtain the smallest value of the total (grid[0][i - 1] + grid[0] + grid[1][i]) when descending from the current path.
     * This is because the smallest path is the path not selected by the first robot that selects the largest value.
     * It's gonna be like this:
     *
     * [1][1][1][2][2]
     * [2][2][1][1][1]
     *
     * @param grid 0-indexed 2D array grid of size 2 x n
     * @return the number of points collected by the second robot
    */
    fun gridGame(grid: Array<IntArray>): Long {
        var result = Long.MAX_VALUE
        var aboveSuffixSum = Arrays.stream(grid[0]).asLongStream().sum()
        var belowPrefixSum = 0L

        for (i in grid[0].indices) {
            if (i > 0) {
                belowPrefixSum += grid[1][i - 1]
            }
            aboveSuffixSum -= grid[0][i]
            result = min(result, max(aboveSuffixSum, belowPrefixSum))
        }

        return result
    }
}

fun main() {
    val grid = arrayOf(intArrayOf(1, 3, 1, 15), intArrayOf(1, 3, 3, 1))
    println(LeetCode_2017().gridGame(grid))
}
