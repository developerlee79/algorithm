package sort

import java.util.PriorityQueue
import kotlin.math.max

class LeetCode_2054 {

    /**
     * Solution : Priority Queue
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     *
     * @param events 0-indexed 2D integer array where events[i] = [startTime, endTime, value]
     * @return Return this maximum sum of value which non-overlapping events
    */
    fun maxTwoEvents(events: Array<IntArray>): Int {
        events.sortBy { it[0] }

        val priorityQueue = PriorityQueue<IntArray> { x, y -> x[1] - y[1] }

        var maxEvent = 0
        var currentMaxEvent = 0

        for (event in events) {
            while (priorityQueue.isNotEmpty() && priorityQueue.peek()[1] < event[0]) {
                currentMaxEvent = max(currentMaxEvent, priorityQueue.poll()[2])
            }
            maxEvent = max(maxEvent, currentMaxEvent + event[2])
            priorityQueue.add(event)
        }

        return maxEvent
    }
}

fun main() {
    // Input
    val events = arrayOf(
        intArrayOf(1, 3, 2), intArrayOf(4, 5, 2), intArrayOf(1, 5, 5)
    )
    // Output
    val result = LeetCode_2054().maxTwoEvents(events)
    println(result)
    require(result == 5)
}
