package matrix

class LeetCode_867 {

    /**
     * Solution - Brute force
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     *
     * Transpose of a matrix is just vice-versa of ordinary matrix.
     * So... Just flip it.
     *
     * @param matrix 2D integer array
     * @return transpose of matrix
     */
    fun transpose(matrix: Array<IntArray>): Array<IntArray> {
        val transposedMatrix = Array(matrix[0].size) { IntArray(matrix.size) }

        for (i in matrix.indices) {
            for (j in 0 until matrix[i].size) {
                transposedMatrix[j][i] = matrix[i][j]
            }
        }

        return transposedMatrix
    }
}

fun main() {
    val leetcode = LeetCode_867()
    val matrix = arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6))
    println(leetcode.transpose(matrix).contentDeepToString())
}