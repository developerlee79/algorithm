package sort

import kotlin.math.abs


class LeetCode_462 {

    /**
     * Solution -
     * Time Complexity : O(NlogN)
     * Space Complexity : O(1)
     *
     * Find minimum move with median of array.
     * For the least movement, it is most efficient to start with the center value of the array.
     * Finds the number that must be added to make all numbers central based on the median.
     *
     * @param nums integer array
     * @return minimum number of moves required to make all array elements equal
    */
    fun minMoves2(nums: IntArray): Int {
        nums.sort()
        val mid = nums[nums.size / 2]

        var count = 0
        for (num in nums) {
            count += abs(mid - num)
        }
        return count
    }
}

fun main() {
    val nums = intArrayOf(1, 2, 9, 10)
    println(LeetCode_462().minMoves2(nums))
}
