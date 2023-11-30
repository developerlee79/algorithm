package bit_manipulation

import kotlin.math.abs

class LeetCode_1611 {

    fun minimumOneBitOperations(n: Int): Int {
        var n = n

        var power = 1
        var operations = 0
        var isMinus = true

        while (n > 0) {
            if (n.and(1) == 1) {
                val total = 1.shl(power) - 1
                operations += total * if (isMinus) -1 else 1
                isMinus = !isMinus
            }

            n = n.shr(1)
            power++
        }

        return abs(operations)
    }
}

fun main() {
    // Input
    val n = 3
    // Output
    LeetCode_1611().minimumOneBitOperations(n).run {
        println(this)
        require(2 == this)
    }
}
