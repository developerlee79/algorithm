package math

import kotlin.math.floor
import kotlin.math.sqrt

class LeetCode_633 {

    fun judgeSquareSum(c: Int): Boolean {
        var a = floor(sqrt(c.toDouble())).toInt()

        if (a * a == c) {
            return true
        }

        var b = 1

        while (a >= b) {
            val squareSum = power(a) + power(b)

            if (squareSum == c.toLong()) {
                return true
            } else if (squareSum < c.toLong()) {
                b++
            } else {
                a--
            }
        }

        return false
    }

    private fun power(x: Int) = (x * x).toLong()
}

fun main() {
    // Input
    val c = 5
    // Output
    LeetCode_633().judgeSquareSum(c).run {
        println(this)
        require(this)
    }
}
