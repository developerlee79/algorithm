package array

import kotlin.math.max

class LeetCode_2342 {

    private fun Int.sumOfDigit() =
        toString().sumOf { it.digitToInt() }

    fun maximumSum(nums: IntArray): Int {
        var maximum = -1

        val numMap = hashMapOf<Int, Int>()

        nums.forEach {
            val sumOfDigit = it.sumOfDigit()

            if (numMap.containsKey(sumOfDigit)) {
                maximum = max(maximum, numMap[sumOfDigit]!! + it)

                if (numMap[sumOfDigit]!! < it) {
                    numMap[sumOfDigit] = it
                }
            } else {
                numMap[sumOfDigit] = it
            }
        }

        return maximum
    }
}

fun main() {
    // Input
    val nums = intArrayOf(383,77,97,261,102,344,150,130,55,337,401,498,21,5)
    // Output
    val result = LeetCode_2342().maximumSum(nums)
    println(result)
    require(result == 54)
}
