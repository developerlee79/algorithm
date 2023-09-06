package string

class LeetCode_2194 {

    fun cellsInRange(s: String): List<String> {
        val cellList = mutableListOf<String>()

        var startCol = s[0]
        val endCol = s[3]

        val startRow = s[1].digitToInt()
        val endRow = s[4].digitToInt()

        while (startCol <= endCol) {
            for (i in startRow .. endRow) {
                cellList.add("${startCol}$i")
            }
            startCol++
        }

        return cellList
    }
}

fun main() {
    // Input
    val s = "K1:L2"
    // Output
    LeetCode_2194().cellsInRange(s).run {
        println(this)
        require(
            listOf("K1", "K2", "L1", "L2") == this
        )
    }
}
