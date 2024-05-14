package backtracking

class LeetCode_1219 {

    private val directions = arrayOf(
        intArrayOf(0, 1),
        intArrayOf(0, -1),
        intArrayOf(1, 0),
        intArrayOf(-1, 0)
    )

    fun getMaximumGold(grid: Array<IntArray>): Int {
        val n = grid.size
        val m = grid[0].size

        var maximumGold = 0

        for (i in grid.indices) {
            for (j in grid[i].indices) {
                if (grid[i][j] == 0) {
                    continue
                }

                val visited = Array(n){ BooleanArray(m) }
                maximumGold = maxOf(maximumGold, miningGold(grid, visited, i, j))
            }
        }

        return maximumGold
    }

    private fun miningGold(grid: Array<IntArray>, visited: Array<BooleanArray>, x: Int, y: Int): Int {
        if (x !in grid.indices || y !in grid[x].indices || visited[x][y] || grid[x][y] == 0) {
            return 0
        }

        visited[x][y] = true

        var maxGold = 0

        directions.forEach { direction ->
            maxGold = maxOf(maxGold, miningGold(grid, visited, x + direction[0], y + direction[1]))
        }

        visited[x][y] = false

        return grid[x][y] + maxGold
    }
}

fun main() {
    // Input
    val grid = arrayOf(
        intArrayOf(0, 6, 0),
        intArrayOf(5, 8, 7),
        intArrayOf(0, 9, 0)
    )
    // Output
    LeetCode_1219().getMaximumGold(grid).run {
        println(this)
        require(24 == this)
    }
}
