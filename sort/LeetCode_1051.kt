package sort

class LeetCode_1051 {

    fun heightChecker(heights: IntArray): Int {
        val sortedHeights = heights.sortedArray()

        var count = 0

        for (i in heights.indices) {
            if (heights[i] != sortedHeights[i]) {
                count++
            }
        }

        return count
    }
}

fun main() {
    // Input
    val heights = intArrayOf(1, 1, 4, 2, 1, 3)
    // Output
    LeetCode_1051().heightChecker(heights).run {
        println(this)
        require(3 == this)
    }
}
