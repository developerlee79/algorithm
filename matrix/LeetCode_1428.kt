package matrix

class LeetCode_1428 {

    class BinaryMatrix(
        private val matrix: Array<IntArray>
    ) {

        private val dimensions = listOf(matrix.size, matrix[0].size)

        fun get(row: Int, col: Int): Int = matrix[row][col]

        fun dimensions(): List<Int> = dimensions

    }

    fun leftMostColumnWithOne(binaryMatrix: BinaryMatrix): Int {
        val dimensions = binaryMatrix.dimensions()

        var leftMostColumn = Integer.MAX_VALUE
        val colSize = dimensions[1] - 1

        for (i in 0 until dimensions[0]) {
            leftMostColumn = minOf(leftMostColumn, findLeftMost(binaryMatrix, i, minOf(leftMostColumn, colSize)))
        }

        return if (leftMostColumn == Integer.MAX_VALUE) -1 else leftMostColumn
    }

    private fun findLeftMost(binaryMatrix: BinaryMatrix, row: Int, lastCol: Int): Int {
        var left = 0
        var right = lastCol

        var leftMostIndex = Integer.MAX_VALUE

        while (left <= right) {
            val middle = (left + right) / 2
            val middleValue = binaryMatrix.get(row, middle)

            if (middleValue == 1) {
                leftMostIndex = minOf(leftMostIndex, middle)
                right = middle - 1
            } else {
                left = middle + 1
            }
        }

        return leftMostIndex
    }

}

fun main() {
    // Input
    val mat = arrayOf(
        intArrayOf(0, 0),
        intArrayOf(1, 1),
    )
    val binaryMatrix = LeetCode_1428.BinaryMatrix(mat)
    // Output
    LeetCode_1428().leftMostColumnWithOne(binaryMatrix).run {
        println(this)
        require(0 == this)
    }
}
