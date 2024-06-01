package string

class LeetCode_1404 {

    fun numSteps(s: String): Int {
        var count = 0
        var carry = 0

        for (i in s.lastIndex downTo 1) {
            val currentBinary = s[i].digitToInt() + carry

            if (currentBinary == 0) {
                carry = 0
                count++
            } else if (currentBinary == 2) {
                carry = 1
                count++
            } else {
                carry = 1
                count += 2
            }
        }

        if (carry == 1) {
            count++
        }

        return count
    }
}

fun main() {
    // Input
    val s = "1101"
    // Output
    LeetCode_1404().numSteps(s).run {
        println(this)
        require(6 == this)
    }
}
