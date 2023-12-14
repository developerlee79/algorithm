package matrix

class LeetCode_2482 {

    fun onesMinusZeros(grid: Array<IntArray>): Array<IntArray> {
        val n = grid.size
        val m = grid[0].size

        val rowCounter = IntArray(n)
        val colCounter = IntArray(m)

        for (i in 0 until n) {
            for (j in 0 until m) {
                if (grid[i][j] == 1) {
                    rowCounter[i]++
                    colCounter[j]++
                } else {
                    rowCounter[i]--
                    colCounter[j]--
                }
            }
        }

        val diff = Array(n) { IntArray(m) }

        for (i in 0 until n) {
            for (j in 0 until m) {
                diff[i][j] = rowCounter[i] + colCounter[j]
            }
        }

        return diff
    }
}

fun main() {
    // Input
    val grid = arrayOf(
        intArrayOf(0, 1, 1),
        intArrayOf(1, 0, 1),
        intArrayOf(0, 0, 1),
    )
    // Output
    LeetCode_2482().onesMinusZeros(grid).run {
        println(this.contentDeepToString())
        require(
            arrayOf(
                intArrayOf(0, 0, 4),
                intArrayOf(0, 0, 4),
                intArrayOf(-2, -2, 2),
            ).contentDeepEquals(this)
        )
    }
}
