package matrix

class LeetCode_1727 {

    fun largestSubmatrix(matrix: Array<IntArray>): Int {
        val n = matrix.size
        val m = matrix[0].size

        for (i in 1 until n) {
            for (j in 0 until m) {
                if (matrix[i][j] == 1) {
                    matrix[i][j] += matrix[i - 1][j]
                }
            }
        }

        var subMatrixSize = 0

        for (i in 0 until n) {
            matrix[i].sort()

            for (j in 0 until m) {
                subMatrixSize = maxOf(subMatrixSize, matrix[i][j] * (m - j))
            }
        }

        return subMatrixSize
    }
}

fun main() {
    // Input
    val matrix = arrayOf(
        intArrayOf(0, 0, 1),
        intArrayOf(1, 1, 1),
        intArrayOf(1, 0, 1)
    )
    // Output
    LeetCode_1727().largestSubmatrix(matrix).run {
        println(this)
        require(4 == this)
    }
}
