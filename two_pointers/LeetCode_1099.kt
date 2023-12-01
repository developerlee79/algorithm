package two_pointers

class LeetCode_1099 {

    fun twoSumLessThanK(nums: IntArray, k: Int): Int {
        nums.sort()

        var maxValue = -1

        var i = 0
        var j = nums.lastIndex

        while (i < j) {
            val sum = nums[i] + nums[j]

            if (sum >= k) {
                j--
            } else {
                maxValue = maxOf(maxValue, sum)
                i++
            }
        }

        return maxValue
    }
}

fun main() {
    // Input
    val nums = intArrayOf(34, 23, 1, 24, 75, 33, 54, 8)
    val k = 60
    // Output
    LeetCode_1099().twoSumLessThanK(nums, k).run {
        println(this)
        require(58 == this)
    }
}
