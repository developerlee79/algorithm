package two_pointers

class LeetCode_948 {

    fun bagOfTokensScore(tokens: IntArray, power: Int): Int {
        tokens.sort()

        var s = 0
        var l = 0

        var maxi = 0

        var power = power
        var r = tokens.size - 1

        while (l <= r) {
            if (power >= tokens[l]) {
                power -= tokens[l]
                s++
                l++
                maxi = maxOf(maxi.toDouble(), s.toDouble()).toInt()
            } else if (s > 0) {
                power += tokens[r]
                s--
                r--
            } else {
                break
            }
        }

        return maxi
    }
}

fun main() {
    // Input
    val tokens = intArrayOf(100)
    val power = 50
    // Output
    LeetCode_948().bagOfTokensScore(tokens, power).run {
        println(this)
        require(0 == this)
    }
}
