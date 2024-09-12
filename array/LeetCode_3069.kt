package array

import java.util.Stack

class LeetCode_3069 {

    fun resultArray(nums: IntArray): IntArray {
        val n = nums.size

        val firstStack = Stack<Int>()
        val secondStack = Stack<Int>()

        firstStack.add(nums[0])
        secondStack.add(nums[1])

        for (i in 2 until n) {
            if (firstStack.peek() > secondStack.peek()) {
                firstStack.add(nums[i])
            } else {
                secondStack.add(nums[i])
            }
        }

        val distributedArray = IntArray(n)
        var i = n - 1

        while (secondStack.isNotEmpty()) {
            distributedArray[i--] = secondStack.pop()
        }

        while (firstStack.isNotEmpty()) {
            distributedArray[i--] = firstStack.pop()
        }

        return distributedArray
    }
}

fun main() {
    // Input
    val nums = intArrayOf(2, 1, 3)
    // Output
    LeetCode_3069().resultArray(nums).run {
        println(this.joinToString())
        require(
            intArrayOf(2, 3, 1).contentEquals(this)
        )
    }
}
