package matrix

class LeetCode_59 {

    fun generateMatrix(n: Int): Array<IntArray> {
        val resultMatrix = Array(n) { IntArray(n) }

        var counter = 1

        var startIndex = 0
        var endIndex = n - 1

        while (startIndex <= endIndex) {
            for (i in startIndex until endIndex) {
                resultMatrix[startIndex][i] = counter++
            }

            for (i in startIndex until endIndex) {
                resultMatrix[i][endIndex] = counter++
            }

            for (i in (startIndex .. endIndex).reversed()) {
                resultMatrix[endIndex][i] = counter++
            }

            for (i in (startIndex + 1 until endIndex).reversed()) {
                resultMatrix[i][startIndex] = counter++
            }

            startIndex++
            endIndex--
        }

        return resultMatrix
    }
}

fun main() {
    // Input
    val n = 3
    // Output
    LeetCode_59().generateMatrix(n).run {
        println(this.contentDeepToString())
        require(
            arrayOf(
                arrayOf(1, 2, 3),
                arrayOf(8, 9, 4),
                arrayOf(7, 6, 5)
            ).contentEquals(this)
        )
    }
}
