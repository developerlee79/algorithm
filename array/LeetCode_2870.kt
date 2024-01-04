package array

import kotlin.math.ceil

class LeetCode_2870 {

    fun minOperations(nums: IntArray): Int {
        val frequencyMap = HashMap<Int, Int>()

        nums.forEach {
            frequencyMap.merge(it, 1) { a, b -> a + b }
        }

        var operations = 0

        frequencyMap.values.forEach {
            if (it == 1) {
                return -1
            }

            operations += ceil(it / 3.0).toInt()
        }

        return operations
    }
}

fun main() {
    // Input
    val nums = intArrayOf(2, 3, 3, 2, 2, 4, 2, 3, 4)
    // Output
    LeetCode_2870().minOperations(nums).run {
        println(this)
        require(4 == this)
    }
}
