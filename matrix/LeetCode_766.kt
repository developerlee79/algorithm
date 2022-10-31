package matrix

class LeetCode_766 {

    /**
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     *
     * Iterate top-left to bottom-right in every row with memorization array.
     *
     * @param matrix m x n matrix
     * @return return true if the matrix is Toeplitz. Otherwise, return false
    */
    fun isToeplitzMatrix(matrix: Array<IntArray>): Boolean {
        val visited = Array(matrix.size) { BooleanArray(matrix.first().size) }

        matrix.forEachIndexed matrix@{ i, ints ->
            matrix[i].forEachIndexed { j, num ->
                if (visited[i][j]) {
                    return@forEachIndexed
                }

                var k = i
                var l = j
                while (k < matrix.size && l < ints.size) {
                    if (num != matrix[k][l]) {
                        return false
                    }
                    visited[k][l] = true
                    k++
                    l++
                }
            }
        }

        return true
    }
}

fun main() {
    // Input
    val matrix = arrayOf(
        intArrayOf(1, 2, 3, 4),
        intArrayOf(5, 1, 2, 3),
        intArrayOf(9, 5, 1, 2),
    )
    // Output
    val result = LeetCode_766().isToeplitzMatrix(matrix)
    println(result)
    require(result)
}
