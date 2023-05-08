package matrix

class LeetCode_1572 {

    fun diagonalSum(mat: Array<IntArray>): Int {
        val n = mat.size
        var totalSum = 0

        for (i in mat.indices) {
            totalSum += mat[i][i]
            totalSum += mat[n - 1 - i][i]
        }

        return if (n % 2 == 0)
            totalSum
        else
            totalSum - mat[n / 2][n / 2]
    }
}

fun main() {
    // Input
    val mat = arrayOf(
        intArrayOf(1, 2, 3),
        intArrayOf(4, 5, 6),
        intArrayOf(7, 8, 9),
    )
    // Output
    LeetCode_1572().diagonalSum(mat).run {
        println(this)
        require(25 == this)
    }
}
