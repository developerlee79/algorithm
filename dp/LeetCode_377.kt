package dp

class LeetCode_377 {

    /**
     * Solution - Dynamic Programming
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     *
     * Bottom-Up DP
     *
     * @param nums array of distinct integers
     * @param target target integer
     * @return number of possible combinations that add up to target
    */
    fun combinationSum4(nums: IntArray, target: Int): Int {
        val dp = IntArray(target + 1) { -1 }
        dp[0] = 1
        return recursive(nums, target, dp)
    }

    private fun recursive(nums: IntArray, target: Int, dp: IntArray): Int {
        if (dp[target] != -1) {
            return dp[target]
        }

        var sum = 0

        for (num in nums) {
            if (target >= num) {
                sum += recursive(nums, target - num, dp)
            }
        }

        dp[target] = sum
        return sum
    }
}

fun main() {
    val nums = intArrayOf(1, 2, 3)
    val target = 4
    println(LeetCode_377().combinationSum4(nums, target))
}
