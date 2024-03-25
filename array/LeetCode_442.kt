package array

import kotlin.math.abs

class LeetCode_442 {

    fun findDuplicates(nums: IntArray): List<Int> {
        val duplicates = mutableListOf<Int>()

        for (i in nums.indices) {
            val numIndex = abs(nums[i]) - 1

            if (nums[numIndex] < 0) {
                duplicates.add(numIndex + 1)
            } else {
                nums[numIndex] = -nums[numIndex]
            }
        }

        return duplicates
    }
}

fun main() {
    // Input
    val nums = intArrayOf(4, 3, 2, 7, 8, 2, 3, 1)
    // Output
    LeetCode_442().findDuplicates(nums).run {
        println(this)
        require(
            listOf(2, 3) == this
        )
    }
}
