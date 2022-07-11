package array

import kotlin.math.abs

class LeetCode_2006 {

    /**
     * Solution - Iteration
     * Time Complexity : O(N)
     * Space Complexity : O(1)
     *
     * Locate the K pair with a double repeat statement.
     * Since repeated nums[i] no longer need to be compared, we start with i + 1.
     *
     * @param nums integer array
     * @param k integer
     * @return number of pairs (i, j) where i < j such that nums[i] - nums[j] == k
     */
    fun countKDifference(nums: IntArray, k: Int): Int {
        var count = 0

        for (i in nums.indices) {
            for (j in i + 1 until nums.size) {
                if (abs(nums[i] - nums[j]) == k) {
                    count++
                }
            }
        }

        return count
    }
}

fun main() {
    val nums = intArrayOf(1, 2, 2, 1)
    val k = 1
    println(LeetCode_2006().countKDifference(nums, k))
}
