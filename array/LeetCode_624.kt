package array

import kotlin.math.abs

class LeetCode_624 {

    fun maxDistance(arrays: List<List<Int>>): Int {
        var min = arrays[0].first()
        var max = arrays[0].last()

        var maxDiff = 0

        for (i in 1 until arrays.size) {
            val currentMin = arrays[i].first()
            val currentMax = arrays[i].last()

            maxDiff = maxOf(
                maxDiff, abs(max - currentMin), abs(min - currentMax)
            )

            if (currentMin <= min) {
                min = currentMin
            }

            if (currentMax >= max) {
                max = currentMax
            }
        }

        return maxDiff
    }
}

fun main() {
    // Input
    val arrays = listOf(
        listOf(1, 2, 3),
        listOf(4, 5),
        listOf(1, 2, 3)
    )
    // Output
    LeetCode_624().maxDistance(arrays).run {
        println(this)
        require(4 == this)
    }
}
