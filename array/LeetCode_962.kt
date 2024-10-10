package array

import java.util.Stack

class LeetCode_962 {

    fun maxWidthRamp(nums: IntArray): Int {
        val n = nums.size
        val stack = Stack<Int>()

        nums.forEachIndexed { i, num ->
            if (stack.isEmpty() || nums[stack.peek()] > num) {
                stack.push(i)
            }
        }

        var maxWidth = 0

        for (i in nums.indices.reversed()) {
            while (stack.isNotEmpty() && nums[stack.peek()] <= nums[i]) {
                maxWidth = maxOf(maxWidth, i - stack.pop())
            }
        }

        return maxWidth
    }
}

fun main() {
    // Input
    val nums = intArrayOf(6, 0, 8, 2, 1, 5)
    // Output
    LeetCode_962().maxWidthRamp(nums).run {
        println(this)
        require(4 == this)
    }
}
