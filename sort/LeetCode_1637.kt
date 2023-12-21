package sort

class LeetCode_1637 {

    fun maxWidthOfVerticalArea(points: Array<IntArray>): Int {
        points.sortBy { it[0] }

        var maxWidth = 0

        for (i in 1 until points.size) {
            if (points[i][0] == points[i - 1][0]) {
                continue
            }

            maxWidth = maxOf(maxWidth, points[i][0] - points[i - 1][0])
        }

        return maxWidth
    }
}

fun main() {
    // Input
    val points = arrayOf(
        intArrayOf(8, 7),
        intArrayOf(9, 9),
        intArrayOf(7, 4),
        intArrayOf(9, 7)
    )
    // Output
    LeetCode_1637().maxWidthOfVerticalArea(points).run {
        println(this)
        require(1 == this)
    }
}
