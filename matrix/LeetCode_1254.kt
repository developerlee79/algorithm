package matrix

class LeetCode_1254 {

    /**
     * Solution - DFS
     * Time Complexity : O(N)
     * Space Complexity : O(1)
     *
     * Use dfs to solve the problem.
     * When the grid[x][y] is land, search all connected land.
     * If it reaches the end of matrix, it means it's not closed island - so returns false (not added result point).
     * If it reaches the sea, it means it can be a closed island - so return true.
     * If the search in all directions is true, increase the count because it is a closed island.
     *
     * @param grid 2D grid consists of 0s (land) and 1s (water)
     * @return number of *closed islands
     *   *closed island: island totally (all left, top, right, bottom) surrounded by 1s
     */
    fun closedIsland(grid: Array<IntArray>): Int {
        var count = 0
        for (i in grid.indices) {
            for (j in grid[i].indices) {
                if (grid[i][j] == 0 && dfs(grid, i, j)) {
                    count++
                }
            }
        }
        return count
    }

    private val direction = arrayOf(
        intArrayOf(-1, 0),
        intArrayOf(1, 0),
        intArrayOf(0, -1),
        intArrayOf(0, 1)
    )

    private fun dfs(grid: Array<IntArray>, x: Int, y: Int): Boolean {
        return if (x < 0 || y < 0 || x >= grid.size || y >= grid[x].size)
            false
        else if (grid[x][y] == 1)
            true
        else {
            grid[x][y] = 1
            var result = true
            for (dir in direction)
                result = result.and(dfs(grid, x + dir[0], y + dir[1]))
            result
        }
    }
}

fun main() {
    val grid = arrayOf(
        intArrayOf(1, 1, 1, 1, 1, 1, 1, 0),
        intArrayOf(1, 0, 0, 0, 0, 1, 1, 0),
        intArrayOf(1, 0, 1, 0, 1, 1, 1, 0),
        intArrayOf(1, 0, 0, 0, 0, 1, 0, 1),
        intArrayOf(1, 1, 1, 1, 1, 1, 1, 0)
    )
    println(LeetCode_1254().closedIsland(grid))
}
