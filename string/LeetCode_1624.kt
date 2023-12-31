package string

class LeetCode_1624 {

    fun maxLengthBetweenEqualCharacters(s: String): Int {
        val indexOfChars = IntArray(26) { -1 }

        var maxLength = -1

        for (i in s.indices) {
            if (indexOfChars[s[i] - 'a'] == -1) {
                indexOfChars[s[i] - 'a'] = i
            } else {
                maxLength = maxOf(maxLength, i - indexOfChars[s[i] - 'a'] - 1)
            }
        }

        return maxLength
    }
}

fun main() {
    // Input
    val s = "aa"
    // Output
    LeetCode_1624().maxLengthBetweenEqualCharacters(s).run {
        println(this)
        require(0 == this)
    }
}
