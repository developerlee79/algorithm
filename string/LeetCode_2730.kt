package string

class LeetCode_2730 {

    fun longestSemiRepetitiveSubstring(s: String): Int {
        val n = s.length

        var maxLength = 0

        var i = 1
        var startIndex = 0
        var lastPairIndex = 0

        while (i < n) {
            if (s[i] == s[i - 1]) {
                startIndex = lastPairIndex
                lastPairIndex = i
            }

            maxLength = maxOf(maxLength, i + 1 - startIndex)
            i++
        }

        return if (maxLength == 0) n else maxLength
    }
}