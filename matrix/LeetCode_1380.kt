package matrix

class LeetCode_1380 {

    fun luckyNumbers (matrix: Array<IntArray>): List<Int> {
        val n = matrix.size
        val m = matrix[0].size

        val rowMin = IntArray(n) { Int.MAX_VALUE }
        val colMax = IntArray(m)

        for (i in matrix.indices) {
            for (j in matrix[i].indices) {
                rowMin[i] = minOf(rowMin[i], matrix[i][j])
                colMax[j] = maxOf(colMax[j], matrix[i][j])
            }
        }

        val luckyNumberList = mutableListOf<Int>()

        for (i in matrix.indices) {
            for (j in matrix[i].indices) {
                if (rowMin[i] == colMax[j]) {
                    luckyNumberList.add(matrix[i][j])
                }
            }
        }

        return luckyNumberList
    }
}

fun main() {
    // Input
    val matrix = arrayOf(
        intArrayOf(3, 7, 8),
        intArrayOf(9, 11, 13),
        intArrayOf(15, 16, 17)
    )
    // Output
    LeetCode_1380().luckyNumbers(matrix).run {
        println(this)
        require(
            listOf(15) == this
        )
    }
}
