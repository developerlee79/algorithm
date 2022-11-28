package array

import java.util.*

class LeetCode_907 {

    /**
     * Solution : Monotonic Stack
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     *
     * @param arr integer array
     * @return sum of min(b) where b ranges over every (contiguous) subarray of arr
    */
    fun sumSubarrayMins(arr: IntArray): Int {
        var minValue: Long = 0

        val stack = Stack<Int>()
        stack.push(-1)

        val module = 1e9.toLong() + 7

        for (i in 0 .. arr.size) {
            val currVal = if (i in arr.indices) arr[i] else 0

            while (stack.peek() != -1 && currVal < arr[stack.peek()]) {
                val index = stack.pop()

                val left = index - stack.peek()
                val right = i - index

                val add = (left * right * arr[index].toLong()) % module

                minValue += add
                minValue %= module
            }

            stack.push(i)
        }

        return minValue.toInt()
    }
}

fun main() {
    // Input
    val arr = intArrayOf(3, 1, 2, 4)
    // Output
    val result = LeetCode_907().sumSubarrayMins(arr)
    println(result)
    require(17 == result)
}
