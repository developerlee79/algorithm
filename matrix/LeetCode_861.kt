package matrix

class LeetCode_861 {

    fun matrixScore(grid: Array<IntArray>): Int {
        val n = grid.size
        val m = grid[0].size

        var score = (1 shl m - 1) * n

        for (j in 1 until m) {
            val rowScore = 1 shl m - 1 - j
            var colCount = 0

            for (i in 0 until n) {
                if (grid[i][j] == grid[i][0]) {
                    colCount++
                }
            }

            score += maxOf(colCount, (n - colCount)) * rowScore
        }

        return score
    }
}

fun main() {
    // Input
    val grid = arrayOf(
        intArrayOf(0, 0, 1, 1),
        intArrayOf(1, 0, 1, 0),
        intArrayOf(1, 1, 0, 0)
    )
    // Output
    LeetCode_861().matrixScore(grid).run {
        println(this)
        require(39 == this)
    }
}
