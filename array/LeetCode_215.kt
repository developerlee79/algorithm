package array

import java.util.PriorityQueue

class LeetCode_215 {

    /**
     * Solution - Priority Queue
     * Time Complexity : O(NlogN)
     * Space Complexity : O(N)
     *
     * Use k size priority queue to solve the problem.
     *
     * @param nums integer array
     * @param k
     * @return kth largest element in nums
    */
    fun findKthLargest(nums: IntArray, k: Int): Int {
        val priorityQueue = PriorityQueue<Int>()

        for (num in nums) {
            priorityQueue.add(num)
            if (priorityQueue.size > k) {
                priorityQueue.poll()
            }
        }

        return priorityQueue.poll()
    }
}

fun main() {
    val nums = intArrayOf(3, 2, 1, 5, 6, 4)
    val k = 2
    println(LeetCode_215().findKthLargest(nums, k))
}
