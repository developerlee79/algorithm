package array

class LeetCode_1480 {
    /**
     * Solution - Memorization
     * Time Complexity : O(N)
     * Space Complexity : O(1)
     *
     * Use the values in the preceding in array to calculate the runningSum.
     *
     * @param nums integer array
     * @return running sum of nums (ex. nums[0] + nums[1]..)
     */
    fun runningSum(nums: IntArray): IntArray {
        for (i in 1 until nums.size) {
            nums[i] = nums[i] + nums[i - 1]
        }

        return nums
    }
}

fun main() {
    val nums = intArrayOf(1, 2, 3, 4)
    val leetcode = LeetCode_1480()
    println(leetcode.runningSum(nums).joinToString())
}