package matrix

class LeetCode_867 {

    fun transpose(matrix: Array<IntArray>): Array<IntArray> {
        val transposedMatrix = Array(matrix[0].size) { IntArray(matrix.size) }

        for (i in matrix.indices) {
            for (j in matrix[i].indices) {
                transposedMatrix[j][i] = matrix[i][j]
            }
        }

        return transposedMatrix
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
    LeetCode_867().transpose(matrix).run {
        println(this.contentDeepToString())
        require(
            arrayOf(
                intArrayOf(1, 4, 7),
                intArrayOf(2, 5, 8),
                intArrayOf(3, 6, 9)
            ).contentDeepEquals(this)
        )
    }
}
