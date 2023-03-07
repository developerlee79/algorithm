package search

class LeetCode_2187 {

    fun minimumTime(time: IntArray, totalTrips: Int): Long {
        var low: Long
        var min: Long

        time.minOf { it }.let { minOfTime ->
            low = minOfTime.toLong()
            min = minOfTime.toLong()
        }

        var high: Long = totalTrips * min

        while (low < high) {
            val mid = (high - low) / 2 + low

            if (isPossibleToTrip(mid, totalTrips, time)) {
                high = mid
            } else {
                low = mid + 1
            }
        }

        return low
    }

    private fun isPossibleToTrip(currentTime: Long, totalTrips: Int, time: IntArray): Boolean {
        var trips: Long = 0

        time.forEach {
            trips += currentTime / it
        }

        return trips >= totalTrips
    }
}

fun main() {
    // Input
    val time = intArrayOf(1, 2, 3)
    val totalTrips = 5
    // Output
    LeetCode_2187().minimumTime(
        time = time,
        totalTrips = totalTrips
    ).let {
        println(it)
        require(it == 3L)
    }
}
