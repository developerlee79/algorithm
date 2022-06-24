package array

import java.util.PriorityQueue

class LeetCode_1354 {

    /**
     * Solution - Priority Queue
     * Time Complexity : O(NlogN)
     * Space Complexity : O(N)
     *
     * Use priority queue to solve this problem.
     *
     * @param target integer array
     * @return is possible to construct the target array from given array
    */
    fun isPossible(target: IntArray): Boolean {
        val priorityQueue = PriorityQueue<Int>(reverseOrder())
        var sum = 0

        for (num in target) {
            priorityQueue.add(num)
            sum += num
        }

        while (priorityQueue.peek() != 1) {
            val currentValue = priorityQueue.poll()
            if (sum - currentValue == 1) {
                return true
            }

            val mod = currentValue % (sum - currentValue)
            sum -= currentValue + mod

            if (mod == 0 or currentValue)
                return false
            else
                priorityQueue.add(mod)
        }

        return true
    }
}

fun main() {
    val target = intArrayOf(9, 3, 5)
    println(LeetCode_1354().isPossible(target))
}
