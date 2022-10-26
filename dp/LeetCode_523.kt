package dp

class LeetCode_523 {

    /**
     * Solution : Prefix Sum with Set
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     *
     * @param nums integer array
     * @param k integer
     * @return return true if nums has a continuous subarray of size at least two whose elements sum up to a multiple of k, or false otherwise
    */
    fun checkSubarraySum(nums: IntArray, k: Int): Boolean {
        val sumSet = hashSetOf<Int>()

        var currentSum = 0
        var prevSum = 0

        nums.forEach {
            currentSum = (currentSum + it) % k

            if (sumSet.contains(currentSum)) {
                return true
            }

            sumSet.add(prevSum)
            prevSum = currentSum
        }

        return false
    }

    /**
     * Solution : Dynamic Programming
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     *
     * currentSum = dp[i - 1][j + 1] - nums[i - 1]
     *
     * @param nums integer array
     * @param k integer
     * @return return true if nums has a continuous subarray of size at least two whose elements sum up to a multiple of k, or false otherwise
    */
    fun checkSubarraySumDP(nums: IntArray, k: Int): Boolean {
        val size = nums.size

        val dp = Array(size) { IntArray(size) }

        dp[0][0] = nums[0]
        for (i in 1 until size) {
            dp[0][i] = dp[0][i - 1] + nums[i]

            if (dp[0][i] % k == 0) {
                return true
            }
        }

        for (i in 1 until size - 1) {
            for (j in size - i - 1 downTo 1) {
                val currentSum = dp[i - 1][j + 1] - nums[i - 1]

                if (currentSum % k == 0) {
                    return true
                }

                dp[i][j] = currentSum
            }
        }

        return false
    }
}

fun main() {
    // Input
    val nums = intArrayOf(23, 2, 4, 6, 7)
    val k = 6
    // Output
    val result = LeetCode_523().checkSubarraySum(nums, k)
    println(result)
    require(result)
}
