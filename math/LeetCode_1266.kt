package math

import kotlin.math.abs

class LeetCode_1266 {

    fun minTimeToVisitAllPoints(points: Array<IntArray>): Int {
        var visitTime = 0

        for (i in 0 until points.size - 1) {
            val xDiff = abs(points[i][0] - points[i + 1][0])
            val yDiff = abs(points[i][1] - points[i + 1][1])
            visitTime += maxOf(xDiff, yDiff)
        }

        return visitTime
    }
}

fun main() {
    // Input
    val points = arrayOf(
        intArrayOf(1, 1),
        intArrayOf(3, 4),
        intArrayOf(-1, 0)
    )
    // Output
    LeetCode_1266().minTimeToVisitAllPoints(points).run {
        println(this)
        require(7 == this)
    }
}
