package array

import java.util.PriorityQueue

class LeetCode_1167 {

    fun connectSticks(sticks: IntArray): Int {
        val stickQueue = PriorityQueue<Int>()

        sticks.forEach { stick ->
            stickQueue.add(stick)
        }

        var sumOfCost = 0

        while (stickQueue.size > 1) {
            val currentCost = stickQueue.poll() + stickQueue.poll()
            sumOfCost += currentCost
            stickQueue.add(currentCost)
        }

        return sumOfCost
    }
}

fun main() {
    // Input
    val sticks = intArrayOf(2, 4, 3)
    // Output
    LeetCode_1167().connectSticks(sticks).run {
        println(this)
        require(14 == this)
    }
}
