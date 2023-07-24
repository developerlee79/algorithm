package math

import kotlin.math.abs

class LeetCode_55 {

    fun myPow(x: Double, n: Int): Double {
        val num = if (n < 0) 1 / x else x

        var power = abs(n.toLong())

        var product = num

        var res = 1.0

        while (power > 0) {
            if (power % 2 == 1L) {
                res *= product
            }
            power /= 2
            product *= product
        }

        return res
    }
}

fun main() {
    // Input
    val x = 2.00000
    val n = 10
    // Output
    LeetCode_55().myPow(x, n).run {
        println(this)
        require(1024.00000 == this)
    }
}
