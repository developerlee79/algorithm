package array

import java.util.PriorityQueue

class LeetCode_2462 {

    fun totalCost(costs: IntArray, k: Int, candidates: Int): Long {
        var total = 0L

        val leftPriorityQueue = PriorityQueue<Int>()
        val rightPriorityQueue = PriorityQueue<Int>()

        var i = 0
        var j = costs.lastIndex

        repeat(k) {
            while (leftPriorityQueue.size < candidates && i <= j)
                leftPriorityQueue.add(costs[i++])
            while (rightPriorityQueue.size < candidates && i <= j)
                rightPriorityQueue.add(costs[j--])

            if (leftPriorityQueue.isNotEmpty() && rightPriorityQueue.isNotEmpty()) {
                val left = leftPriorityQueue.peek()
                val right = rightPriorityQueue.peek()

                total += if (left <= right) {
                    leftPriorityQueue.poll()
                } else {
                    rightPriorityQueue.poll()
                }
            } else if (leftPriorityQueue.isNotEmpty()) {
                total += leftPriorityQueue.poll()
            } else {
                total += rightPriorityQueue.poll()
            }
        }

        return total
    }
}

fun main() {
    // Input
    val costs = intArrayOf(17, 12, 10, 2, 7, 2, 11, 20, 8)
    val k = 3
    val candidates = 4
    // Output
    LeetCode_2462().totalCost(costs, k, candidates).run {
        println(this)
        require(11L == this)
    }
}
