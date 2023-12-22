package string

class LeetCode_1422 {

    fun maxScore(s: String): Int {
        var one = 0

        for (binary in s) {
            if (binary == '1') {
                one++
            }
        }

        var maxScore = 0

        var currentZero = 0
        var currentOne = 0

        for (i in 0 until s.length - 1) {
            if (s[i] == '0') {
                currentZero++
            } else {
                currentOne++
            }

            maxScore = maxOf(maxScore, currentZero + one - currentOne)
        }

        return maxScore
    }
}

fun main() {
    // Input
    val s = "011101"
    // Output
    LeetCode_1422().maxScore(s).run {
        println(this)
        require(5 == this)
    }
}
