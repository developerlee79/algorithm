package math

class LeetCode_268 {

    fun missingNumber(nums: IntArray): Int {
        val n = nums.size
        return (n + 1) * n / 2 - nums.sum()
    }
}

fun main() {
    // Input
    val nums = intArrayOf(3, 0, 1)
    // Output
    LeetCode_268().missingNumber(nums).run {
        println(this)
        require(2 == this)
    }
}
