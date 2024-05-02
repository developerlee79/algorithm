package array

import kotlin.math.abs

class LeetCode_2441 {

    fun findMaxK(nums: IntArray): Int {
        val numSet = HashSet<Int>()
        var maxPositive = -1

        nums.forEach { num ->
            if (numSet.contains(-num)) {
                maxPositive = maxOf(maxPositive, abs(num))
            }

            numSet.add(num)
        }

        return maxPositive
    }
}

fun main() {
    // Input
    val nums = intArrayOf(-1, 2, -3, 3)
    // Output
    LeetCode_2441().findMaxK(nums).run {
        println(this)
        require(3 == this)
    }
}
