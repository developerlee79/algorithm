package array

class LeetCode_57 {

    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
        val afterIntervals = mutableListOf<IntArray>()

        var index = 0
        var intervalStart = newInterval.first()
        var intervalEnd = newInterval.last()

        while (index < intervals.size && intervals[index].last() < intervalStart) {
            afterIntervals.add(intervals[index++])
        }

        while (index < intervals.size && intervals[index].first() <= intervalEnd) {
            intervalStart = intervalStart.coerceAtMost(intervals[index].first())
            intervalEnd = intervalEnd.coerceAtLeast(intervals[index].last())
            index++
        }

        afterIntervals.add(intArrayOf(intervalStart, intervalEnd))
        afterIntervals.addAll(intervals.copyOfRange(index, intervals.size))

        return afterIntervals.toTypedArray()
    }
}

fun main() {
    // Input
    val intervals = arrayOf(
        intArrayOf(1, 3),
        intArrayOf(6, 9),
    )
    val newInterval = intArrayOf(2, 5)
    // Output
    LeetCode_57().insert(intervals, newInterval).let {
        println(it.contentDeepToString())
        require(
            arrayOf(intArrayOf(1, 5), intArrayOf(6, 9)).contentDeepEquals(it)
        )
    }
}
