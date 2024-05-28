package string

import kotlin.math.abs

class LeetCode_1208 {

    fun equalSubstring(s: String, t: String, maxCost: Int): Int {
        val n = s.length

        var start = 0
        var currentCost = 0
        var maxLength = 0

        for (end in 0 until n) {
            currentCost += abs(s[end].code - t[end].code)

            while (currentCost > maxCost) {
                currentCost -= abs(s[start].code - t[start].code)
                start++
            }

            maxLength = maxOf(maxLength, end - start + 1)
        }

        return maxLength
    }
}

fun main() {
    // Input
    val s = "abcd"
    val t = "bcdf"
    val maxCost = 3
    // Output
    LeetCode_1208().equalSubstring(s, t, maxCost).run {
        println(this)
        require(3 == this)
    }
}
