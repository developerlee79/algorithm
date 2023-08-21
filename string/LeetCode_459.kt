package string

class LeetCode_459 {

    fun repeatedSubstringPattern(s: String): Boolean {
        val n = s.length

        for (i in 1..n / 2) {

            if (n % i == 0) {
                val patternBuilder = StringBuilder()
                val subPattern = s.substring(0, i)

                for (j in 0 until n / i) {
                    patternBuilder.append(subPattern)
                }

                if (patternBuilder.contentEquals(s)) {
                    return true
                }
            }
        }

        return false
    }
}

fun main() {
    // Input
    val s = "abcabcabcabc"
    // Output
    LeetCode_459().repeatedSubstringPattern(s).run {
        println(this)
        require(this)
    }
}
