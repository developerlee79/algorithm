package matrix

class LeetCode_1351 {

    fun countNegatives(grid: Array<IntArray>): Int {
        var lastIndex = 0
        var count = 0

        for (i in grid.indices.reversed()) {
            for (j in lastIndex until grid[i].size) {
                if (grid[i][j] < 0) {
                    count += grid[i].size - j
                    break
                }
                lastIndex = j + 1
            }
        }

        return count
    }
}

fun main() {
    // Input
    val grid = arrayOf(
        intArrayOf(4, 3, 2, -1),
        intArrayOf(3, 2, 1, -1),
        intArrayOf(1, 1, -1, -2),
        intArrayOf(-1, -1, -2, -3),
    )
    // Output
    LeetCode_1351().countNegatives(grid).run {
        println(this)
        require(8 == this)
    }
}
