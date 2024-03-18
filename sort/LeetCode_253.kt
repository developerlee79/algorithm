package sort

import java.util.PriorityQueue

class LeetCode_253 {

    fun minMeetingRooms(intervals: Array<IntArray>): Int {
        intervals.sortBy { arr -> arr[0] }

        val meetingRoomQueue = PriorityQueue<Int>()

        intervals.forEach { interval ->
            if (meetingRoomQueue.isEmpty() || meetingRoomQueue.peek() > interval[0]) {
                meetingRoomQueue.add(interval[0] - 1)
            }

            meetingRoomQueue.poll()
            meetingRoomQueue.add(interval[1])
        }

        return meetingRoomQueue.size
    }
}

fun main() {
    // Input
    val intervals = arrayOf(
        intArrayOf(0, 30),
        intArrayOf(5, 10),
        intArrayOf(15, 20),
    )
    // Output
    LeetCode_253().minMeetingRooms(intervals).run {
        println(this)
        require(2 == this)
    }
}
