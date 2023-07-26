package search

import kotlin.math.ceil

class LeetCode_1870 {

    fun minSpeedOnTime(dist: IntArray, hour: Double): Int {
        val n = dist.size

        var minSpeed = 1
        var maxSpeed = 10000000

        var currentSpeed = -1

        while (minSpeed <= maxSpeed) {
            val mid = (maxSpeed + minSpeed) / 2

            var sum = 0.0

            for (i in 0 until n - 1) {
                sum += ceil(dist[i].toDouble() / mid)
            }

            sum += dist[n - 1].toDouble() / mid

            if (sum > hour) {
                minSpeed = mid + 1
            } else {
                currentSpeed = mid
                maxSpeed = mid - 1
            }
        }

        return currentSpeed
    }
}

fun main() {
    // Input
    val dist = intArrayOf(1, 3, 2)
    val hour = 6.00
    // Output
    LeetCode_1870().minSpeedOnTime(dist, hour).run {
        println(this)
        require(1 == this)
    }
}
