package array

class LeetCode_1732 {

    fun largestAltitude(gain: IntArray): Int {
        var currentAltitude = 0
        var highestAltitude = 0

        gain.forEach {
            currentAltitude += it
            highestAltitude = maxOf(highestAltitude, currentAltitude)
        }

        return highestAltitude
    }
}

fun main() {
    // Input
    val gain = intArrayOf(-5, 1, 5, 0, -7)
    // Output
    LeetCode_1732().largestAltitude(gain).run {
        println(this)
        require(1 == this)
    }
}
