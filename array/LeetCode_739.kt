package array

import java.util.Stack

class LeetCode_739 {

    fun dailyTemperatures(temperatures: IntArray): IntArray {
        val n = temperatures.size

        val answer = IntArray(n)

        val stack = Stack<Int>()
        stack.add(0)

        for (i in 1 until n) {
            val todayTemperature = temperatures[i]

            while (stack.isNotEmpty() && temperatures[stack.peek()] < todayTemperature) {
                val day = stack.pop()
                answer[day] = i - day
            }

            stack.add(i)
        }

        return answer
    }
}

fun main() {
    // Input
    val temperatures = intArrayOf(73, 74, 75, 71, 69, 72, 76, 73)
    // Output
    LeetCode_739().dailyTemperatures(temperatures).run {
        println(this.joinToString())
        require(
            intArrayOf(1, 1, 4, 2, 1, 1, 0, 0).contentEquals(this)
        )
    }
}
