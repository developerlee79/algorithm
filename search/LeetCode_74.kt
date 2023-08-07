package search

class LeetCode_74 {

    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        val n = matrix[0].size

        var low = 0
        var high = matrix.size * n - 1

        while (low <= high) {
            val middle = (low + high) / 2

            val currentValue = matrix[middle / n][middle % n]

            if (currentValue == target) {
                return true
            } else if (currentValue < target) {
                low = middle + 1
            } else {
                high = middle - 1
            }
        }

        return false
    }
}

fun main() {
    // Input
    val matrix = arrayOf(
        intArrayOf(1, 3, 5, 7),
        intArrayOf(10, 11, 16, 20),
        intArrayOf(23, 30, 34, 60)
    )
    val target = 3
    // Output
    LeetCode_74().searchMatrix(matrix, target).run {
        println(this)
        require(this)
    }
}
