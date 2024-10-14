package array

import java.util.PriorityQueue
import kotlin.math.ceil

class LeetCode_2530 {

    fun maxKelements(nums: IntArray, k: Int): Long {
        var maximumScore = 0L

        val priorityQueue = PriorityQueue<Int>(reverseOrder())

        nums.forEach { priorityQueue.add(it) }

        repeat(k) {
            val currentScore = priorityQueue.poll()
            maximumScore += currentScore
            priorityQueue.add(ceil(currentScore / 3.00).toInt())
        }

        return maximumScore
    }
}

fun main() {
    // Input
    val nums = intArrayOf(10, 10, 10, 10, 10)
    val k = 5
    // Output
    LeetCode_2530().maxKelements(nums, k).run {
        println(this)
        require(50L == this)
    }
}
