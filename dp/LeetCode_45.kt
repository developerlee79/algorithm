package dp

class LeetCode_45 {

    fun jump(nums: IntArray): Int {
        return search(nums, 0, IntArray(nums.size))
    }

    private fun search(nums: IntArray, index: Int, dp: IntArray): Int {
        if (index >= nums.lastIndex) {
            return 0
        }

        if (dp[index] != 0) {
            return dp[index]
        }

        var minCount = 10000

        for (i in 1 .. nums[index]) {
            minCount = minOf(minCount, search(nums, index + i, dp) + 1)
        }

        dp[index] = minCount

        return dp[index]
    }

}

fun main() {
    // Input
    val nums = intArrayOf(2, 3, 1, 1, 4)
    // Output
    LeetCode_45().jump(nums).let {
        println(it)
        require(it == 2)
    }
}
