package array

class LeetCode_209 {

    fun minSubArrayLen(target: Int, nums: IntArray): Int {
        val n = nums.size

        var minLength = n

        var startIndex = 0
        var currentSum = 0

        for (i in 0 until n) {
            currentSum += nums[i]

            if (currentSum >= target) {
                while (startIndex < n && currentSum - nums[startIndex] >= target) {
                    currentSum -= nums[startIndex++]
                }
                minLength = minOf(minLength, i - startIndex + 1)
            }
        }

        if (minLength == n && currentSum < target) {
            return 0
        }

        return minLength
    }
}

fun main() {
    // Input
    val target = 7
    val nums = intArrayOf(2, 3, 1, 2, 4, 3)
    // Output
    LeetCode_209().minSubArrayLen(target, nums).run {
        println(this)
        require(2 == this)
    }
}
