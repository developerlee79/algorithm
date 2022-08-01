package sort


class LeetCode_561 {

    /**
     * Solution - Sort
     * Time Complexity : O(NlogN)
     * Space Complexity : O(1)
     *
     * The point of this problem is that you have to bundle the smallest values together, and the largest values together.
     * Sort it out and it's simple.
     *
     * @param nums integer array of 2n integers
     * @return *maximized sum
     *     *maximized : group integers into n pairs (a1, b1), (a2, b2)... sum of min(ai, bi) for all i
    */
    fun arrayPairSum(nums: IntArray): Int {
        nums.sort()
        var count = 0
        for (i in nums.indices step 2) {
            count += nums[i]
        }
        return count
    }
}

fun main() {
    val nums = intArrayOf(1, 4, 3, 2)
    println(LeetCode_561().arrayPairSum(nums))
}
