package bit_manipulation

import kotlin.math.pow

class LeetCode_476 {

    fun findComplement(num: Int): Int {
        var result = 0
        var i = 0

        var num = num

        while (num != 0) {
            val temp = num and 1

            if (temp == 0) {
                result += 2.00.pow(i).toInt()
            }

            num = num shr 1
            i++
        }

        return result
    }
}

fun main() {
    // Input
    val num = 5
    // Output
    LeetCode_476().findComplement(num).run {
        println(this)
        require(2 == this)
    }
}
