package two_pointers

class LeetCode_1750 {

    fun minimumLength(s: String): Int {
        var prefixIndex = 0
        var suffixIndex = s.lastIndex

        while (prefixIndex < suffixIndex) {
            if (s[prefixIndex] != s[suffixIndex]) {
                break
            }

            val currentChar = s[prefixIndex]

            while (prefixIndex <= suffixIndex && currentChar == s[prefixIndex]) {
                prefixIndex++
            }

            if (prefixIndex == suffixIndex) {
                return 0
            }

            while (prefixIndex < suffixIndex && currentChar == s[suffixIndex]) {
                suffixIndex--
            }
        }

        return suffixIndex - prefixIndex + 1
    }
}

fun main() {
    // Input
    val s = "ca"
    // Output
    LeetCode_1750().minimumLength(s).run {
        println(this)
        require(2 == this)
    }
}
