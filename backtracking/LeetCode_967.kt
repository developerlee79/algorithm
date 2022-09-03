package backtracking

import kotlin.math.abs

class LeetCode_967 {

    /**
     * Solution - Backtracking
     * Time Complexity : O(logN)
     * Space Complexity : O(N)
     *
     * @param n non-negative integers
     * @param k non-negative integers
     * @return list of numbers such that the absolute difference between every two consecutive digits is k
     */
    fun numsSameConsecDiff(n: Int, k: Int): IntArray {
        val result = mutableListOf<Int>()
        backtracking(n, k, 0, result)
        return result.toIntArray()
    }

    private fun backtracking(n: Int, k: Int, value: Int, result: MutableList<Int>) {
        if (n == 0) {
            result.add(value)
            return
        }

        for (i in 0 .. 9) {
            if (value == 0 && i != 0) {
                backtracking(n - 1, k, i, result)
            }

            val lastNum = abs(value.rem(10) - i)
            if (value != 0 && lastNum == k) {
                backtracking(n - 1, k, value.times(10) + i, result)
            }
        }
    }
}

fun main() {
    val n = 2
    val k = 1
    println(LeetCode_967().numsSameConsecDiff(n, k).joinToString())
}
