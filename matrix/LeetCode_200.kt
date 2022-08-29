package matrix

class LeetCode_200 {

    /**
     * Solution - Depth-First Search
     * Time Complexity : O(N)
     * Space Complexity : O(1)
     *
     * Find the number of islands by conducting a depth-first search in all directions.
     *
     * @param grid m x n 2D binary grid
     * @return number of islands
     */
    fun numIslands(grid: Array<CharArray>): Int {
        var count = 0

        for (x in grid.indices) {
            for (y in grid[x].indices) {
                if (grid[x][y] == '0') {
                    continue
                }
                search(grid, x, y)
                count++
            }
        }

        return count
    }

    private fun search(grid: Array<CharArray>, x: Int, y: Int) {
        if (isOutOfArray(grid, x, y) || grid[x][y] == '0') {
            return
        } else {
            grid[x][y] = '0'
            search(grid, x + 1, y)
            search(grid, x - 1, y)
            search(grid, x, y + 1)
            search(grid, x, y - 1)
        }
    }

    private fun isOutOfArray(grid: Array<CharArray>, x: Int, y: Int): Boolean {
        return x >= grid.size || y >= grid[0].size || x < 0 || y < 0
    }
}

fun main() {
    val grid = arrayOf(
        charArrayOf('1', '1', '1', '1', '0'),
        charArrayOf('1', '1', '0', '1', '0'),
        charArrayOf('1', '1', '0', '0', '0'),
        charArrayOf('0', '0', '0', '0', '0')
    )
    println(LeetCode_200().numIslands(grid))
}
