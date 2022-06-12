package array

import kotlin.math.max

class LeetCode_1695 {

    /**
     * Solution - Two Pointers
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     *
     * Solve the question by two pointers technique.
     * The first pointer increase by nums indices and adds elements of the nums array to the set.
     * If there is a duplicate element in the set, we have to clear all elements until the duplicate element.
     * Because when duplicate elements occur, they are divided into two sub-arrays.
     * Update the score in every add / remove at Set to find the score of the largest subarray.
     *
     * @param nums array of positive integers
     * @return the maximum score (sum of subarray) you can get by erasing exactly one subarray (containing unique elements)
     */
    fun maximumUniqueSubarray(nums: IntArray): Int {
        val indexSet: MutableSet<Int> = mutableSetOf()

        var maxScore = 0
        var currentScore = 0

        var secondPointer = 0
        for (firstPointer in nums.indices) {
            while (!indexSet.add(nums[firstPointer])) {
                currentScore -= nums[secondPointer]
                indexSet.remove(nums[secondPointer++])
            }
            currentScore += nums[firstPointer]
            maxScore = max(maxScore, currentScore)
        }

        return maxScore
    }
}

fun main() {
    val nums = intArrayOf(4, 2, 4, 5, 6)
    println(LeetCode_1695().maximumUniqueSubarray(nums))
}
