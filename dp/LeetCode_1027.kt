package dp

class LeetCode_1027 {

    fun longestArithSeqLength(nums: IntArray): Int {
        val dp = Array<HashMap<Int, Int>>(nums.size) { hashMapOf() }

        var maxLength = 0

        for (i in 1 until nums.size) {
            repeat(i) { j ->
                val different = nums[i] - nums[j]
                dp[i][different] = (dp[j][different] ?: 1) + 1
                maxLength = maxLength.coerceAtLeast(dp[i][different]!!)
            }
        }

        return maxLength
    }
}

fun main() {
    // Input
    val nums = intArrayOf(3, 6, 9, 12)
    // Output
    LeetCode_1027().longestArithSeqLength(nums).let {
        println(it)
        require(it == 4)
    }
}
