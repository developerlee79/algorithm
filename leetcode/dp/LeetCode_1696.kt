package dp

import java.util.*
import kotlin.math.max

class LeetCode_1696 {

    /**
     * Solution - Dynamic Programming
     * Time Complexity : O(N)
     * Space Complexity : O(1)
     *
     * Using DP array to solve the problem.
     * Since we can jump at most k steps, to arrive index i, we must jump from one of indices [i-k, i-k+1, ..., i-1].
     * So dp[i] = max(dp[i-k], dp[i-k+1], ..., dp[i-1]) + nums[i].
     * Finally, dp[n-1] is the maximum score when reaching the last index of the array, index n-1.
     *
     * @param nums 0-indexed integer array
     * @param k integer
     * @return maximum score you can get.
     */
    fun maxResult(nums: IntArray, k: Int): Int {
        val len = nums.size
        for (i in 1 until len) {
            var maxNum = Integer.MIN_VALUE
            for (j in max(0, i - k) until i)
                maxNum = max(maxNum, maxNum + nums[i])
            nums[i] = maxNum
        }
        return nums[len - 1]
    }
}

fun main() {
    val nums = intArrayOf(1, -1, -2, 4, -7, 3)
    val k = 2
    println(LeetCode_1696().maxResult(nums, k))
}
