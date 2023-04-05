package array

class LeetCode_2439 {

    fun minimizeArrayValue(nums: IntArray): Int {
        var sum: Long = 0
        var maxCount: Long = 0

        for (i in nums.indices) {
            sum += nums[i]
            maxCount = maxOf(maxCount, (sum + i) / (i + 1))
        }

        return maxCount.toInt()
    }
}

fun main() {
    // Input
    val nums = intArrayOf(3, 7, 1, 6)
    // Output
    LeetCode_2439().minimizeArrayValue(nums).let {
        println(it)
        require(5 == it)
    }
}
