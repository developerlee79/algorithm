package sort

class LeetCode_452 {

    fun findMinArrowShots(points: Array<IntArray>): Int {
        points.sortBy { it.last() }

        var totalArrow = 1

        var currentRange = points.first().last()

        for (i in 1 until points.size) {
            if (currentRange >= points[i].first()) {
                continue
            }
            totalArrow++
            currentRange = points[i].last()
        }

        return totalArrow
    }
}

fun main() {
    // Input
    val points = arrayOf(
        intArrayOf(10, 16),
        intArrayOf(2, 8),
        intArrayOf(1, 6),
        intArrayOf(7, 12),
    )
    // Output
    LeetCode_452().findMinArrowShots(points).let {
        println(it)
        require(it == 2)
    }
}
