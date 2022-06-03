package matrix

class LeetCode_304 {

    class NumMatrix(matrix: Array<IntArray>) {

        private val dp: Array<IntArray>

        init {
            for (i in matrix.indices) {
                for (j in 0 until matrix[0].size) {
                    val left = if (j == 0) 0 else matrix[i][j - 1]
                    val up = if (i == 0) 0 else matrix[i - 1][j]
                    val corner = if (i == 0 || j == 0) 0 else matrix[i - 1][j - 1]
                    matrix[i][j] += left + up - corner
                }
            }

            dp = matrix
        }

        /**
         * Solution - Memorization
         * Time Complexity : O(N)
         * Space Complexity : O(N)
         *
         * Memorization sum of near values of the matrix in the dp array when initialize a class to obtain the value quickly.
         *
         * @param row1
         * @param row2
         * @param col1
         * @param col2
         * @return Sum of the elements of matrix inside the rectangle defined by rows & cols
         */
        fun sumRegion(row1: Int, col1: Int, row2: Int, col2: Int): Int {
            val left = if (row1 > 0) dp[row1 - 1][col2] else 0
            val up = if (col1 > 0) dp[row2][col1 - 1] else 0
            val corner = if (row1 > 0 && col1 > 0) dp[row1 - 1][col1 - 1] else 0
            return dp[row2][col2] - left - up + corner
        }

    }
}

fun main() {
    val matrix = arrayOf(
        intArrayOf(3, 0, 1, 4, 2),
        intArrayOf(5, 6, 3, 2, 1),
        intArrayOf(1, 2, 0, 1, 5),
        intArrayOf(4, 1, 0, 1, 7),
        intArrayOf(1, 0, 3, 0, 5)
    )
    val numMatrix = LeetCode_304.NumMatrix(matrix)
    println(numMatrix.sumRegion(2, 1, 4, 3))
    println(numMatrix.sumRegion(1, 1, 2, 2))
}
