package string

class LeetCode_340 {

    fun lengthOfLongestSubstringKDistinct(s: String, k: Int): Int {
        val n = s.length

        var firstIndex = 0
        var secondIndex = 0

        var longestLength = 0
        val charSet = hashMapOf<Char, Int>()

        while (secondIndex < n) {
            charSet.merge(s[secondIndex++], 1) { a, b -> a + b }

            while (firstIndex < n && charSet.size > k) {
                if (charSet.merge(s[firstIndex], -1) { a, b -> a + b } == 0) {
                    charSet.remove(s[firstIndex])
                }
                firstIndex++
            }

            longestLength = maxOf(longestLength, secondIndex - firstIndex)
        }

        return longestLength
    }
}

fun main() {
    // Input
    val s = "eceba"
    val k = 2
    // Output
    LeetCode_340().lengthOfLongestSubstringKDistinct(s, k).run {
        println(this)
        require(3 == this)
    }
}
