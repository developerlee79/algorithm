package matrix

class LeetCode_2373 {

    private val directions = arrayOf(
        intArrayOf(-1, -1),
        intArrayOf(-1, 0),
        intArrayOf(-1, 1),
        intArrayOf(0, -1),
        intArrayOf(0, 1),
        intArrayOf(1, -1),
        intArrayOf(1, 0),
        intArrayOf(1, 1)
    )

    private fun Array<IntArray>.maxAdjacent(i: Int, j: Int): Int {
        var maxValue = this[i][j]

        directions.forEach { direction ->
            maxValue = maxOf(maxValue, this[i + direction[0]][j + direction[1]])
        }

        return maxValue
    }

    fun largestLocal(grid: Array<IntArray>): Array<IntArray> {
        val matrixSize = grid.size - 2

        val maxLocalMatrix = Array(matrixSize) { IntArray(matrixSize) }
        val matrixRange = 0 until matrixSize

        for (i in matrixRange) {
            for (j in matrixRange) {
                maxLocalMatrix[i][j] = grid.maxAdjacent(i + 1, j + 1)
            }
        }

        return maxLocalMatrix
    }
}

fun main() {
    // Input
    val grid = arrayOf(
        intArrayOf(9, 9, 8, 1),
        intArrayOf(5, 6, 2, 6),
        intArrayOf(8, 2, 6, 4),
        intArrayOf(6, 2, 2, 2)
    )
    // Output
    LeetCode_2373().largestLocal(grid).run {
        println(this.contentDeepToString())
        require(
            arrayOf(
                intArrayOf(9, 9),
                intArrayOf(8, 6),
            ).contentDeepEquals(this)
        )
    }
}
