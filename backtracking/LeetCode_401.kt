package backtracking

class LeetCode_401 {

    private val hourMap = arrayOf(
        intArrayOf(0),
        intArrayOf(1, 2, 4, 8),
        intArrayOf(3, 5, 6, 9, 10),
        intArrayOf(7, 11)
    )

    private val minutes = intArrayOf(0, 1, 2, 4, 8, 16, 32)

    fun readBinaryWatch(turnedOn: Int): List<String> {
        val possibleTimes = mutableListOf<String>()

        if (turnedOn !in 0 .. 8) {
            return possibleTimes
        }

        var hourCount = minOf(turnedOn, 3)
        var minuteCount = turnedOn - hourCount

        while (hourCount >= 0) {
            for (hour in hourMap[hourCount]) {
                addTimes(possibleTimes, hour, 0, minuteCount, 0)
            }

            hourCount--
            minuteCount++
        }

        return possibleTimes
    }

    private fun addTimes(possibleTimes: MutableList<String>, hour: Int, currentIndex: Int, n: Int, currentMin: Int) {
        val addedTime = currentMin + minutes[currentIndex]

        if (addedTime > 59) {
            return
        }

        if (n == 0) {
            possibleTimes.add("$hour:${(if (addedTime < 10) "0" else "") + addedTime}")
            return
        }

        for (i in currentIndex + 1 .. 6) {
            addTimes(possibleTimes, hour, i, n - 1, addedTime)
        }
    }

}

fun main() {
    // Input
    val turnedOn = 1
    // Output
    LeetCode_401().readBinaryWatch(turnedOn).run {
        println(this)
        require(
            listOf("0:01", "0:02", "0:04", "0:08", "0:16", "0:32", "1:00", "2:00", "4:00", "8:00").containsAll(this)
        )
    }
}
