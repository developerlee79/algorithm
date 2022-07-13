package dp

import kotlin.math.min

class LeetCode_120 {

    /**
     * Solution - Dynamic Programming
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     *
     * Use the Bottom-Up method to obtain the optimal solution.
     * Since the given array is an equilateral triangle, we can calculate the large triangle by dividing it into small triangles of this:
     *
     *       arr[x - 1][y]
     *  arr[x][y] arr[x][y + 1]
     *
     * Initialize the DP array with the floor layer values, then find the optimal solution with the bottom-up method.
     * If we think about it in small triangles, we just have to compare the values of arr[x][y] and arr[x][y + 1].
     *
     * Example)
     *
     * [4, 1, 8, 3]
     * [7, 6, 10, X]
     * [9, 10, X, X]
     * [11, X, X, X]
     *
     * @param triangle triangle array
     * @return minimum path sum from top to bottom
     */
    fun minimumTotal(triangle: List<List<Int>>): Int {
        val depth = triangle.size
        val maxWidth = triangle.last().size

        val dp = IntArray(depth)

        for (i in 0 until depth) {
            dp[i] = triangle.last()[i]
        }

        for (i in maxWidth - 2 downTo 0) {
            for (j in triangle[i].indices) {
                dp[j] = min(dp[j], dp[j + 1]) + triangle[i][j]
            }
        }

        return dp[0]
    }

    /**
     * Solution - Recursive (Timeout)
     * Time Complexity : O(N^2)
     * Space Complexity : O(1)
     *
     * Recursively finds the minimum value.
     *
     * @param triangle triangle array
     * @return minimum path sum from top to bottom
     */
    private fun recursion(triangle: List<List<Int>>, depth: Int, index: Int, currentValue: Int): Int {
        if (depth >= triangle.size)
            return currentValue
        else if (depth == triangle.size - 1)
            return if (index < triangle[depth].size)
                currentValue + min(triangle[depth][index], triangle[depth][index + 1])
            else
                currentValue + triangle[depth][index]

        var min = Int.MAX_VALUE

        for (i in depth until triangle.size) {
            min = min(min, min(
                recursion(triangle, depth + 1, index, currentValue + triangle[depth][index]),
                recursion(triangle, depth + 1, index + 1, currentValue + triangle[depth][index + 1])
            ))
        }

        return min
    }
}

fun main() {
    val triangle = listOf(
        listOf(2),
        listOf(3, 4),
        listOf(6, 5, 7),
        listOf(4, 1, 8, 3)
    )
    println(LeetCode_120().minimumTotal(triangle))
}
