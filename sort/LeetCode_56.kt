package sort

class LeetCode_56 {

    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        intervals.sortBy { it[0] }

        var lastLow = intervals[0][0]
        var lastHigh = intervals[0][1]
        val resultArray = mutableListOf<IntArray>()

        for (i in 1 until intervals.size) {
            val currentLow = intervals[i][0]
            val currentHigh = intervals[i][1]

            if (currentLow <= lastHigh) {
                lastHigh = maxOf(lastHigh, currentHigh)
            } else {
                resultArray.add(intArrayOf(lastLow, lastHigh))
                lastLow = currentLow
                lastHigh = currentHigh
            }
        }

        resultArray.add(intArrayOf(lastLow, lastHigh))

        return resultArray.toTypedArray()
    }
}

fun main() {
    // Input
    val intervals = arrayOf(
        intArrayOf(1, 3),
        intArrayOf(2, 6),
        intArrayOf(8, 10),
        intArrayOf(15, 18)
    )
    // Output
    LeetCode_56().merge(intervals).run {
        println(this.contentDeepToString())
        require(
            arrayOf(
                intArrayOf(1, 6),
                intArrayOf(8, 10),
                intArrayOf(15, 18)
            ).contentDeepEquals(this)
        )
    }
}
