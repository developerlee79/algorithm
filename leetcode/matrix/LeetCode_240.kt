package matrix

class LeetCode_240 {

    /**
     * Solution - Binary Search
     * Time Complexity : O(logN)
     * Space Complexity : O(1)
     *
     * Simply binary search.
     *
     * @param matrix m x n integer matrix
     * @param target integer
     * @return is target exists in matrix
    */
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        var i = 0
        var j = matrix[0].size - 1
        while (i < matrix.size && j >= 0) {
            if (matrix[i][j] == target) {
                return true
            } else if (matrix[i][j] < target) {
                i++
            } else {
                j--
            }
        }
        return false
    }
}

fun main() {
    val matrix = arrayOf(
        intArrayOf(1, 4, 7, 11, 15),
        intArrayOf(2, 5, 8, 12, 19),
        intArrayOf(3, 6, 9, 16, 22),
        intArrayOf(10, 13, 14, 17, 24),
        intArrayOf(18, 21, 23, 26, 30)
    )
    val target = 5
    println(LeetCode_240().searchMatrix(matrix, target))
}
