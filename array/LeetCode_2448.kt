package array

import kotlin.math.abs


class LeetCode_2448 {

    fun minCost(nums: IntArray, cost: IntArray): Long {
        val n = nums.size

        val data = Array(n) { IntArray(2) }

        for (i in 0 until n) {
            data[i] = intArrayOf(nums[i], cost[i])
        }

        data.sortBy { a: IntArray -> a[0] }

        var maxCost = Int.MIN_VALUE

        val prefixArray = LongArray(n + 1)

        var currentIndex = 0

        for (i in 0 until n) {
            prefixArray[i + 1] = prefixArray[i] + data[i][1]
            if (data[i][1] > maxCost) {
                currentIndex = i
                maxCost = data[i][1]
            }
        }

        val sum = prefixArray[prefixArray.size - 1]

        var lastIdx = -1

        while (lastIdx != currentIndex) {
            lastIdx = currentIndex

            if (prefixArray[currentIndex + 1] < sum - prefixArray[currentIndex + 1]) {
                currentIndex++
            } else if (prefixArray[currentIndex] > sum - prefixArray[currentIndex]) {
                currentIndex--
            }
        }

        var minimumValue = 0L

        for (i in 0 until n) {
            minimumValue += 1L * abs(nums[i] - data[currentIndex][0]) * cost[i]
        }

        return minimumValue
    }
}

fun main() {
    // Input
    val nums = intArrayOf(1, 3, 5, 2)
    val cost = intArrayOf(2, 3, 1, 14)
    // Output
    LeetCode_2448().minCost(nums, cost).run {
        println(this)
        require(8L == this)
    }
}
