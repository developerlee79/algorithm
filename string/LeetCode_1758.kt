package string

class LeetCode_1758 {

    fun minOperations(s: String): Int {
        var flip = 1
        var withoutFlip = 0

        var isLastZero = s[0] == '0'

        for (i in 1 until s.length) {
            if (s[i] == '0') {
                if (isLastZero) {
                    withoutFlip++
                } else {
                    flip++
                }
            } else {
                if (isLastZero) {
                    flip++
                } else {
                    withoutFlip++
                }
            }

            isLastZero = !isLastZero
        }

        return minOf(flip, withoutFlip)
    }
}

fun main() {
    // Input
    val s = "0100"
    // Output
    LeetCode_1758().minOperations(s).run {
        println(this)
        require(1 == this)
    }
}
