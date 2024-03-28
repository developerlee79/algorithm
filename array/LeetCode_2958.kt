package array

class LeetCode_2958 {

    fun maxSubarrayLength(nums: IntArray, k: Int): Int {
        var maxLength = 0

        val lengthMap = hashMapOf<Int, Int>()
        var left = 0

        for (right in nums.indices) {
            lengthMap.merge(nums[right], 1) { a, b -> a + b }

            while (lengthMap[nums[right]]!! > k) {
                lengthMap.merge(nums[left++], -1) { a , b -> a + b }
            }

            maxLength = maxOf(maxLength, right - left + 1)
        }

        return maxLength
    }
}

fun main() {
    // Input
    val nums = intArrayOf(1, 2, 3, 1, 2, 3, 1, 2)
    val k = 2
    // Output
    LeetCode_2958().maxSubarrayLength(nums, k).run {
        println(this)
        require(6 == this)
    }
}
