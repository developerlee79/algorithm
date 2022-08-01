package matrix

class LeetCode_2022 {

    /**
     * Solution - Iteration
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     *
     * Simple iteration
     *
     * @param original 0-indexed 1-dimensional (1D) integer array
     * @param m width
     * @param n length
     * @return m x n 2D array constructed according to the above procedure, or an empty 2D array if it is impossible
    */
    fun construct2DArray(original: IntArray, m: Int, n: Int): Array<IntArray> {
        if (original.size != m * n) {
            return arrayOf()
        } else if (m == 1) {
            return arrayOf(original.clone())
        }

        val resultArray = Array(m) { IntArray(n) }
        var count = 0
        for (i in 0 until m) {
            for (j in 0 until n) {
                resultArray[i][j] = original[count++]
            }
        }

        return resultArray
    }
}

fun main() {
    val original = intArrayOf(1, 2, 3, 4)
    val m = 2
    val n = 2
    println(LeetCode_2022().construct2DArray(original, m, n).contentDeepToString())
}
