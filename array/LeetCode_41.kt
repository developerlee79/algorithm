package array

import kotlin.math.abs

class LeetCode_41 {

    fun firstMissingPositive(nums: IntArray): Int {
        val n = nums.size

        nums.forEachIndexed { i, num ->
            if (num <= 0 || num > n) {
                nums[i] = n + 1
            }
        }

        nums.forEach { num ->
            val absNum = abs(num) - 1

            if (absNum >= n) {
                return@forEach
            }

            if (nums[absNum] > 0) {
                nums[absNum] = -nums[absNum]
            }
        }

        repeat(n) {
            if (nums[it] >= 0) {
                return it + 1
            }
        }

        return n + 1
    }
}

fun main() {
    // Input
    val nums = intArrayOf(1, 2, 0)
    // Output
    LeetCode_41().firstMissingPositive(nums).run {
        println(this)
        require(3 == this)
    }
}
