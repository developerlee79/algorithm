package string

class LeetCode_880 {

    fun decodeAtIndex(s: String, k: Int): String {
        var totalLength = 0L
        var k = k.toLong()
        var lastIndex = s.lastIndex

        for (i in s.indices) {
            val currentChar = s[i]

            if (currentChar.isDigit()) {
                totalLength *= currentChar.digitToInt()
            } else {
                totalLength++

                if (totalLength == k) {
                    return currentChar.toString()
                }
            }

            if (totalLength >= k) {
                lastIndex = i
                break
            }
        }

        for (i in (0 .. lastIndex).reversed()) {
            val currentChar = s[i]

            if (currentChar.isDigit()) {
                totalLength /= currentChar.digitToInt()
                k %= totalLength
            } else {
                if (k == 0L || k == totalLength) {
                    return currentChar.toString()
                }
                totalLength--
            }
        }

        return ""
    }
}

fun main() {
    // Input
    val s = "leet2code3"
    val k = 10
    // Output
    LeetCode_880().decodeAtIndex(s, k).run {
        println(this)
        require("o" == this)
    }
}
