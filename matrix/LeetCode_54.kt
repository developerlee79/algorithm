package matrix

class LeetCode_54 {

    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        val resultList = mutableListOf<Int>()

        var xStart = 0
        var xEnd = matrix.lastIndex

        var yStart = 0
        var yEnd = matrix[0].lastIndex

        while (xStart <= xEnd && yStart <= yEnd) {
            for (i in yStart .. yEnd) {
                resultList.add(matrix[xStart][i])
            }

            xStart++

            for (i in xStart .. xEnd) {
                resultList.add(matrix[i][yEnd])
            }

            yEnd--

            if (xStart <= xEnd) {
                for (i in (yStart .. yEnd).reversed()) {
                    resultList.add(matrix[xEnd][i])
                }
            }

            xEnd--

            if (yStart <= yEnd) {
                for (i in (xStart .. xEnd).reversed()) {
                    resultList.add(matrix[i][yStart])
                }
            }

            yStart++
        }

        return resultList
    }
}

fun main() {
    // Input
    val matrix = arrayOf(
        intArrayOf(1, 2, 3),
        intArrayOf(4, 5, 6),
        intArrayOf(7, 8, 9),
    )
    // Output
    LeetCode_54().spiralOrder(matrix).run {
        println(this)
        require(this == listOf(1, 2, 3, 6, 9, 8, 7, 4, 5))
    }
}
