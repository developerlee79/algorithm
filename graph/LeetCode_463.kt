package graph

class LeetCode_463 {

    fun islandPerimeter(grid: Array<IntArray>): Int {
        val n = grid.lastIndex
        val m = grid[0].lastIndex

        var perimeter = 0

        for (i in grid.indices) {
            for (j in grid[i].indices) {
                if (grid[i][j] == 1) {
                    if (i == 0 || grid[i - 1][j] == 0) perimeter++;
                    if (j == 0 || grid[i][j - 1] == 0) perimeter++;
                    if (i == n || grid[i + 1][j] == 0) perimeter++;
                    if (j == m || grid[i][j + 1] == 0) perimeter++;
                }
            }
        }

        return perimeter
    }
}

fun main() {
    // Input
    val grid = arrayOf(
        intArrayOf(0, 1, 0, 0),
        intArrayOf(1, 1, 1, 0),
        intArrayOf(0, 1, 0, 0),
        intArrayOf(1, 1, 0, 0)
    )
    // Output
    LeetCode_463().islandPerimeter(grid).run {
        println(this)
        require(16 == this)
    }
}
