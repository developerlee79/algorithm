package sort

import kotlin.math.abs

class LeetCode_1630 {

    fun checkArithmeticSubarrays(nums: IntArray, l: IntArray, r: IntArray): List<Boolean> {
        val checkList = mutableListOf<Boolean>()

        for (i in l.indices) {
            val targetArray = nums.sliceArray(l[i]..r[i])
            targetArray.sort()

            val diff = abs(targetArray[0] - targetArray[1])
            var isArithmetical = true

            for (j in 1 until targetArray.lastIndex) {
                if (abs(targetArray[j] - targetArray[j + 1]) != diff) {
                    isArithmetical = false
                    break
                }
            }

            checkList.add(isArithmetical)
        }

        return checkList
    }
}

fun main() {
    // Input
    val nums = intArrayOf(4, 6, 5, 9, 3, 7)
    val l = intArrayOf(0, 0, 2)
    val r = intArrayOf(2, 3, 5)
    // Output
    LeetCode_1630().checkArithmeticSubarrays(nums, l, r).run {
        println(this)
        require(
            listOf(true, false, true) == this
        )
    }
}
