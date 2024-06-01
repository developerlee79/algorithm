package string

import kotlin.math.abs

class LeetCode_3110 {

    fun scoreOfString(s: String): Int {
        val n = s.length
        var score = 0

        for (i in 0 until n - 1) {
            score += abs(s[i].code - s[i + 1].code)
        }

        return score
    }
}

fun main() {
    // Input
    val s = "hello"
    // Output
    LeetCode_3110().scoreOfString(s).run {
        println(this)
        require(13 == this)
    }
}
