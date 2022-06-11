package array

import kotlin.math.max

class LeetCode_1658 {

    /**
     * Solution - Two Pointers
     * Time Complexity : O(N)
     * Space Complexity : O(1)
     *
     * Find number of aren't removed elements' to get minimum number of operations.
     * The number of elements to removed equals n - elements that aren't remove.
     * Therefore, to find the minimum number of elements to remove, we have to find maximum number of elements not removed.
     * So, our job is find maximum aren't removed subarray instead of prefix / suffix subarray to removed.
     * Using two pointers & sliding window to find aren't removed subarray.
     * Increment right until the current window sum is > sum - x
     * Update our maxLength if and only if our current window sum == sum - x
     * Repeat the above steps until we reach the end of the array.
     *
     * @param nums integer array
     * @param x integer
     * @return minimum number of operations to reduce x to exactly 0 if it is possible, otherwise -1
     */
    fun minOperations(nums: IntArray, x: Int): Int {
        val sumOfNums = nums.sum()

        var maxLength = -1
        var currentLength = 0
        var firstPointer = 0
        for (secondPointer in nums.indices) {
            currentLength += nums[secondPointer]

            while (firstPointer <= secondPointer && currentLength > sumOfNums - x) {
                currentLength -= nums[firstPointer++]
            }

            if (currentLength == sumOfNums - x) {
                maxLength = max(maxLength, secondPointer - firstPointer + 1)
            }
        }

        return if (maxLength == - 1) -1 else nums.size - maxLength
    }
}

fun main() {
    val nums = intArrayOf(1, 1, 4, 2, 3)
    val x = 5
    println(LeetCode_1658().minOperations(nums, x))
}