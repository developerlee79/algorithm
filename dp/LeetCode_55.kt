package dp

class LeetCode_55 {

    /**
     * Solution - Dynamic Programming (Bottom-Up)
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     *
     * Store in the dp table to see if the last index can be reached from the current column and calculate from the last index to the first index.
     *
     * @param nums integer array
     * @return true if you can reach the last index, or false otherwise
     */
    fun canJump(nums: IntArray): Boolean {
        val size = nums.size
        val dp = BooleanArray(size)

        dp[size - 1] = true

        for (i in nums.size - 2 downTo 0) {
            var j = 0
            while (j <= nums[i] && i + j < size) {
                if (dp[i + j++]) {
                    dp[i] = true
                    break
                }
            }
        }

        return dp[0]
    }

    /**
     * Solution - Greedy
     * Time Complexity : O(N)
     * Space Complexity : O(1)
     *
     * Track of the smallest index that can "jump" to the last index
     *
     * @param nums integer array
     * @return true if you can reach the last index, or false otherwise
    */
    fun canJumpGreedy(nums: IntArray): Boolean {
        var longestIndex = nums.size - 1

        for (i in nums.size - 2 downTo 0) {
            if (nums[i] + i >= longestIndex) {
                longestIndex = i
            }
        }

        return longestIndex <= 0
    }
}

fun main() {
    val nums = intArrayOf(3, 2, 1, 0, 4)
    println(LeetCode_55().canJump(nums))
    println(LeetCode_55().canJumpGreedy(nums))
}
