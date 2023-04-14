package string

class LeetCode_5 {

    fun longestPalindrome(s: String): String {
        val n = s.length

        var startIndex = 0
        var endIndex = 1

        for (i in 0 until n) {
            var right = i

            while (right < n && s[i] == s[right]) {
                right++
            }

            var left = i - 1

            while (left >= 0 && right < n && s[left] == s[right]) {
                left--
                right++
            }

            val lengthOfPalindrome = right - left - 1

            if (lengthOfPalindrome > endIndex) {
                startIndex = left + 1
                endIndex = lengthOfPalindrome
            }
        }

        return s.substring(startIndex, startIndex + endIndex)
    }
}

fun main() {
    // Input
    val s = "babad"
    // Output
    LeetCode_5().longestPalindrome(s).let {
        println(it)
        require("bab" == it)
    }
}
