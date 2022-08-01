package matrix

import kotlin.math.max

class LeetCode_695 {

    /**
     * Solution - DFS
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     *
     * Use dfs to find maximum island.
     *
     * @param grid binary matrix
     * @return maximum area of an island in grid
     */
    fun maxAreaOfIsland(grid: Array<IntArray>): Int {
        var maxArea = 0
        for (row in grid.indices) {
            for (col in grid[row].indices) {
                if (grid[row][col] == 1) {
                    maxArea = max(maxArea, dfs(grid, row, col))
                }
            }
        }
        return maxArea
    }

    private fun dfs(grid: Array<IntArray>, row: Int, col: Int): Int {
        return if (isUnReachableColumn(grid, row, col)) {
            0
        } else {
            grid[row][col] = 0
            dfs(grid, row + 1, col) + dfs(grid, row - 1, col) + dfs(grid, row, col - 1) + dfs(grid, row, col + 1) + 1
        }
    }

    private fun isUnReachableColumn(grid: Array<IntArray>, row: Int, col: Int): Boolean {
        return (row < 0 || col < 0 || row >= grid.size || col >= grid[row].size || grid[row][col] == 0)
    }
}

fun main() {
    val grid = arrayOf(
        intArrayOf(0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0),
        intArrayOf(0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0),
        intArrayOf(0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0),
        intArrayOf(0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0),
        intArrayOf(0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0),
        intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0),
        intArrayOf(0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0),
        intArrayOf(0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0)
    )
    val area = LeetCode_695().maxAreaOfIsland(grid)
    println(area)
    assert(area == 6)
}
