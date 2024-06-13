package sort

import kotlin.math.abs

class LeetCode_2037 {

    fun minMovesToSeat(seats: IntArray, students: IntArray): Int {
        seats.sort()
        students.sort()

        var count = 0

        for (i in seats.indices) {
            count += abs(seats[i] - students[i])
        }

        return count
    }
}

fun main() {
    // Input
    val seats = intArrayOf(3, 1, 5)
    val students = intArrayOf(2, 7, 4)
    // Output
    LeetCode_2037().minMovesToSeat(seats, students).run {
        println(this)
        require(4 == this)
    }
}
