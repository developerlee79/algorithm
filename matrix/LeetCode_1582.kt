package matrix

class LeetCode_1582 {

    fun numSpecial(mat: Array<IntArray>): Int {
        var specialCount = 0

        val n = mat.size
        val m = mat[0].size

        val rowCounter = IntArray(n)
        val colCounter = IntArray(m)

        for (i in 0 until n) {
            var added = 0

            for (j in 0 until m) {
                if (mat[i][j] == 1) {
                    added++
                    colCounter[j]++
                }
            }

            rowCounter[i] = added
        }

        for (i in 0 until n) {
            for (j in 0 until m) {
                if (mat[i][j] == 1 && rowCounter[i] == 1 && colCounter[j] == 1) {
                    specialCount++
                }
            }
        }

        return specialCount
    }
}

fun main() {
    // Input
    val mat = arrayOf(
        intArrayOf(1, 0, 0),
        intArrayOf(0, 0, 1),
        intArrayOf(1, 0, 0),
    )
    // Output
    LeetCode_1582().numSpecial(mat).run {
        println(this)
        require(1 == this)
    }
}
