package dp

import kotlin.math.max

class LeetCode_718 {

    /**
     * Solution - Dynamic Programming
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     *
     * Use dp table to save last max-value
     *
     * @param nums1 integer array
     * @param nums2 integer array
     * @return return the maximum length of a subarray that appears in both arrays
    */
    fun findLength(nums1: IntArray, nums2: IntArray): Int {
        val dp = Array(nums1.size) { IntArray(nums2.size) }

        var maxLength = 0

        for (i in nums1.indices) {
            for (j in nums2.indices) {
                if (nums1[i] == nums2[j]) {
                    dp[i][j]++

                    if (i > 0 && j > 0) {
                        dp[i][j] += dp[i - 1][j - 1]
                    }
                }

                maxLength = max(maxLength, dp[i][j])
            }
        }

        return maxLength
    }
}

fun main() {
    val nums1 = intArrayOf(1, 2, 3, 2, 1)
    val nums2 = intArrayOf(3, 2, 1, 4, 7)

    val result = LeetCode_718().findLength(nums1, nums2)

    assert(result == 3)
    println(result)
}
