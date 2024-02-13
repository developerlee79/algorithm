package dp

import kotlin.math.pow

class LeetCode_276 {

    fun numWays(n: Int, k: Int): Int {
        if (n < 3) {
            return k.toDouble().pow(n).toInt()
        }

        var ways1 = k
        var ways2 = k * k
        var ways = 0

        for (i in 3 .. n) {
            val temp = ways1
            ways1 = ways2
            ways = (temp + ways2) * (k - 1)
            ways2 = ways
        }

        return ways
    }
}

fun main() {
    // Input
    val n = 3
    val k = 2
    // Output
    LeetCode_276().numWays(n, k).run {
        println(this)
        require(6 == this)
    }
}
