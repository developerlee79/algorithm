package matrix

class LeetCode_1020 {

    fun numEnclaves(grid: Array<IntArray>): Int {
        var count = 0
        val visited = Array(grid.size) { BooleanArray(grid[0].size) }

        for (x in grid.indices) {
            for (y in grid[x].indices) {
                if (grid[x][y] == 1) {
                    temp = 0

                    if (!isConnected(grid, x, y, visited)) {
                        count += temp
                    }
                }
            }
        }

        return count
    }

    private var temp = 0

    private fun isConnected(grid: Array<IntArray>, x: Int, y: Int, visited: Array<BooleanArray>): Boolean {
        if (x !in grid.indices || y !in grid[x].indices) {
            return true
        }

        if (visited[x][y] || grid[x][y] == 0) {
            return false
        }

        visited[x][y] = true

        temp++

        if (x == grid.lastIndex || y == grid[x].lastIndex) {
            return true
        }

        val top = isConnected(grid, x - 1, y, visited)
        val bottom = isConnected(grid, x + 1, y, visited)
        val left = isConnected(grid, x, y - 1, visited)
        val right = isConnected(grid, x, y + 1, visited)

        return top || bottom || left || right
    }
}

fun main() {
    // Input
    val grid = arrayOf(
        intArrayOf(0, 0, 0, 0),
        intArrayOf(1, 0, 1, 0),
        intArrayOf(0, 1, 1, 0),
        intArrayOf(0, 0, 0, 0)
    )
    // Output
    LeetCode_1020().numEnclaves(grid).let {
        println(it)
        require(3 == it)
    }
}
