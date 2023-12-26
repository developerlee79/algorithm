package string

class LeetCode_159 {

    fun lengthOfLongestSubstringTwoDistinct(s: String): Int {
        var firstCharLength = 0
        var secondCharLength = -1

        var maxLength = 0
        var currentLength = 0

        for (i in s.indices) {
            if (s[i] == s[firstCharLength]) {
                firstCharLength = i
                currentLength++
                maxLength = maxOf(maxLength, currentLength)
            } else if (secondCharLength == -1 || s[i] == s[secondCharLength]) {
                secondCharLength = i
                currentLength++
                maxLength = maxOf(maxLength, currentLength)
            } else {
                currentLength = i - minOf(firstCharLength, secondCharLength)

                if (firstCharLength < secondCharLength) {
                    firstCharLength = i
                } else {
                    secondCharLength = i
                }
            }
        }

        return maxLength
    }
}

fun main() {
    // Input
    val s = "eceba"
    // Output
    LeetCode_159().lengthOfLongestSubstringTwoDistinct(s).run {
        println(this)
        require(3 == this)
    }
}
