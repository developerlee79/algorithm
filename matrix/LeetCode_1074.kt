package matrix

class LeetCode_1074 {

    /**
     * Solution - Prefix Sum
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     *
     * Use prefix sum to query sum of submatrix.
     *
     *
     * @param matrix matrix
     * @param target target integer
     * @return number of non-empty submatrices that sum to target
    */
    fun numSubmatrixSumTarget(matrix: Array<IntArray>, target: Int): Int {
        val prefixSum = Array(matrix.size + 1) { IntArray(matrix[0].size + 1) }

        var count = 0
        for (row in matrix.indices) {
            for (column in matrix[row].indices) {
                count += findTargetSum(matrix, prefixSum, target, row, column)
            }
        }

        return count
    }

    private fun findTargetSum(matrix: Array<IntArray>, prefixSum: Array<IntArray>, target: Int, row: Int, column: Int): Int {
        var count = 0

        prefixSum[row + 1][column + 1] = matrix[row][column] + prefixSum[row + 1][column] + prefixSum[row][column + 1] - prefixSum[row][column]

        for (x in 0 until row + 1) {
            for (y in 0 until column + 1) {
                if (prefixSum[row + 1][column + 1] - prefixSum[row + 1][y] - (prefixSum[x][column + 1] - prefixSum[x][y]) == target) {
                    count++
                }
            }
        }

        return count
    }
}

fun main() {
    val matrix = arrayOf(
        intArrayOf(0, 1, 0),
        intArrayOf(1, 1, 1),
        intArrayOf(0, 1, 0)
    )
    val target = 0
    println(LeetCode_1074().numSubmatrixSumTarget(matrix, target))
}
