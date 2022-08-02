package array

import java.util.PriorityQueue

class LeetCode_378 {

    /**
     * Solution - Priority Queue
     * Time Complexity : O(logN)
     * Space Complexity : O(N)
     *
     * Use priority queue to retain the order of the elements in the priority queue and returns the elements in the kth order.
     *
     * @param matrix matrix where each of the rows and columns is sorted in ascending order
     * @param k target integer
     * @return kth smallest element in the matrix
    */
    fun kthSmallest(matrix: Array<IntArray>, k: Int): Int {
        val queue = PriorityQueue<Int>()

        for (nums in matrix) {
            for (num in nums) {
                queue.add(num)
            }
        }

        for (i in 0 until k - 1) {
            queue.poll()
        }

        return queue.poll()
    }
}

fun main() {
    val matrix = arrayOf(
        intArrayOf(1, 5, 9),
        intArrayOf(10, 11, 13),
        intArrayOf(12, 13, 15)
    )
    val k = 8
    println(LeetCode_378().kthSmallest(matrix, k))
}
