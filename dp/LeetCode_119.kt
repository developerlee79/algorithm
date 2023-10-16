package dp

class LeetCode_119 {

    fun getRow(rowIndex: Int): List<Int> {
        val rowList = mutableListOf<List<Int>>()

        repeat(rowIndex + 1) {
            rowList.add(getLine(it))
        }

        return rowList[rowIndex]
    }

    private fun getLine(rowIndex: Int): List<Int> {
        val rows = mutableListOf(1)

        for (i in 1 .. rowIndex) {
            for (j in i - 1 downTo 1) {
                rows[j] = rows[j] + rows[j - 1]
            }
            rows.add(1)
        }

        return rows
    }

}

fun main() {
    // Input
    val rowIndex = 3
    // Output
    LeetCode_119().getRow(rowIndex).run {
        println(this)
        require(
            listOf(1, 3, 3, 1) == this
        )
    }
}
