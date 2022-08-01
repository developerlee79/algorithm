package array

import java.util.*
import kotlin.math.min


class LeetCode_373 {

    /**
     * Solution - Priority Queue
     * Time Complexity : O(NlogK)
     * Space Complexity : O(N)
     *
     * Use Priority Queue to solve the problem.
     * Find the smallest k pairs by adding all pairs of nums1 and nums2[0] in the priority queue.
     * It then adds the value of the priority queue to the result pair list until the priority queue is empty or the result list is complete.
     * If the list of results is not complete, add a new pair to the priority list so that you can find the smallest value in the next iteration.
     *
     * @param nums1 integer array sorted in ascending order
     * @param nums2 integer array sorted in ascending order
     * @param k number of result pair
     * @return K pairs with the smallest sums
     */
    fun kSmallestPairs(nums1: IntArray, nums2: IntArray, k: Int): List<List<Int>> {
        val queue = PriorityQueue (k) { a: List<Int>, b: List<Int> ->
            a[0] + a[1] - b[0] - b[1]
        }

        for (i in 0 until min(nums1.size, k)) {
            queue.add(listOf(nums1[i], nums2[0], 0))
        }

        val resultList: MutableList<List<Int>> = mutableListOf()

        for (i in 0 until k) {
            if (queue.isEmpty()) {
                break
            }

            val biggerPair = queue.poll()
            resultList.add(listOf(biggerPair[0], biggerPair[1]))

            val biggerPairCount = biggerPair[2]
            if (biggerPairCount < nums2.size - 1) {
                queue.add(listOf(biggerPair[0], nums2[biggerPairCount + 1], biggerPairCount + 1))
            }
        }

        return resultList
    }
}

fun main() {
    val leetCode = LeetCode_373()
    val nums1 = intArrayOf(1, 1, 2)
    val nums2 = intArrayOf(1, 2, 3)
    val k = 2
    println(leetCode.kSmallestPairs(nums1, nums2, k).joinToString())
}