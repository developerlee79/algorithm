package dp

class LeetCode_64 {

    fun minPathSum(grid: Array<IntArray>): Int {
        val width = grid[0].size
        val height = grid.size

        for (i in 0 until height) {
            for (j in 0 until width) {
                if (i == 0 && j != 0) {
                    grid[i][j] += grid[i][j - 1]
                } else if (j == 0 && i != 0) {
                    grid[i][j] += grid[i - 1][j]
                } else if (i != 0) {
                    grid[i][j] += minOf(grid[i - 1][j], grid[i][j - 1])
                }
            }
        }

        return grid[height - 1][width - 1]
    }
}

fun main() {
    val grid = arrayOf(
        intArrayOf(1, 3, 1),
        intArrayOf(1, 5, 1),
        intArrayOf(4, 2, 1),
    )
    LeetCode_64().minPathSum(grid).let {
        println(it)
        require(it == 7)
    }
}
