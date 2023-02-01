package math

class LeetCode_1071 {

    fun gcdOfStrings(str1: String, str2: String): String {
        val len1 = str1.length
        val len2 = str2.length

        var n = minOf(len1, len2)

        while (n > 0) {
            if (len1 % n == 0 && len2 % n == 0) {
                val targetString1 = str1.substring(0 until n)
                val targetString2 = str2.substring(0 until n)

                if (isDividable(n, targetString2, str1) && isDividable(n, targetString1, str2)) {
                    return targetString1
                }
            }
            n--
        }

        return ""
    }

    private fun isDividable(divisor: Int, substring: String, target: String): Boolean {
        var i = 0

        while (i + divisor <= target.length) {
            if (substring != target.substring(i until i + divisor)) {
                return false
            }
            i += divisor
        }

        return true
    }
}

fun main() {
    // Input
    val str1 = "ABCABC"
    val str2 = "ABC"
    // Output
    LeetCode_1071().gcdOfStrings(str1, str2).let {
        println(it)
        require(it == "ABC")
    }
}
