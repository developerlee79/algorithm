package matrix

class LeetCode_48 {

    fun rotate(matrix: Array<IntArray>) {
        val n = matrix.size

        val maxDepth = n / 2

        for (depth in 0 until maxDepth) {
            val maxIndex = (n - depth) - 1

            for (i in 0 until maxIndex - depth) {
                val currentY = depth + i
                swap(matrix, depth, currentY, currentY, maxIndex)
                swap(matrix, depth, currentY, maxIndex, maxIndex - i)
                swap(matrix, depth, currentY, maxIndex - i, depth)
            }
        }
    }

    private fun swap(matrix: Array<IntArray>, x1: Int, y1: Int, x2: Int, y2: Int) {
        val temp = matrix[x1][y1]
        matrix[x1][y1] = matrix[x2][y2]
        matrix[x2][y2] = temp
    }

}

fun main() {
    // Input
    val matrix = arrayOf(
        intArrayOf(1, 2, 3),
        intArrayOf(4, 5, 6),
        intArrayOf(7, 8, 9)
    )
    // Output
    LeetCode_48().rotate(matrix)

    matrix.run {
        println(matrix.contentDeepToString())
        require(
            arrayOf(
                intArrayOf(7, 4, 1),
                intArrayOf(8, 5, 2),
                intArrayOf(9, 6, 3)
            ).contentDeepEquals(this)
        )
    }
}
