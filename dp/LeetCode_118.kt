package dp

class LeetCode_118 {

    fun generate(numRows: Int): List<List<Int>> {
        val pascalTriangle = mutableListOf<List<Int>>()

        repeat(numRows) {
            val currentLayer = mutableListOf(1)

            for (i in 1 until it + 1) {
                if (i < it) {
                    currentLayer.add(pascalTriangle[it - 1][i - 1] + pascalTriangle[it - 1][i])
                } else {
                    currentLayer.add(pascalTriangle[it - 1][i - 1])
                }
            }

            pascalTriangle.add(currentLayer)
        }

        return pascalTriangle
    }
}

fun main() {
    // Input
    val numRows = 5
    // Output
    LeetCode_118().generate(numRows).run {
        println(this)
        require(
            listOf(
                listOf(1),
                listOf(1, 1),
                listOf(1, 2, 1),
                listOf(1, 3, 3, 1),
                listOf(1, 4, 6, 4, 1)
            ) == this
        )
    }
}
