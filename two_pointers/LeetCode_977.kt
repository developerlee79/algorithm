package two_pointers

import kotlin.math.abs

class LeetCode_977 {

    fun sortedSquares(nums: IntArray): IntArray {
        val result = IntArray(nums.size)

        var i = 0
        var j = nums.lastIndex

        while (i <= j) {
            result[j - i] = square(if (abs(nums[i]) > abs(nums[j])) nums[i++] else nums[j--]);
        }

        return result
    }

    private fun square(target: Int) = target * target
}

fun main() {
    // Input
    val nums = intArrayOf(-4, -1, 0, 3, 10)
    // Output
    LeetCode_977().sortedSquares(nums).run {
        println(this.joinToString())
        require(
            intArrayOf(0, 1, 9, 16, 100).contentEquals(this)
        )
    }
}
