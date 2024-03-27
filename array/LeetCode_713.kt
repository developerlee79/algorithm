package array

class LeetCode_713 {

    fun numSubarrayProductLessThanK(nums: IntArray, k: Int): Int {
        val n = nums.size

        var count = 0

        var i = 0
        var j = 0

        var currentValue = 1

        while (j < n) {
            currentValue *= nums[j++]

            while (i < j && currentValue >= k) {
                currentValue /= nums[i++]
            }

            count += j - i
        }

        return count
    }
}

fun main() {
    // Input
    val nums = intArrayOf(10, 5, 2, 6)
    val k = 100
    // Output
    LeetCode_713().numSubarrayProductLessThanK(nums, k).run {
        println(this)
        require(8 == this)
    }
}
