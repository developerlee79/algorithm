package string

class LeetCode_2370 {

    fun longestIdealString(s: String, k: Int): Int {
        val charMap = IntArray(26)

        var longestLength = 0

        for (curChar in s) {
            val charIndex = curChar - 'a'

            var currentLongest = 0

            for (i in maxOf(0, charIndex - k) .. minOf(charIndex + k, 25)) {
                currentLongest = maxOf(currentLongest, charMap[i])
            }

            charMap[charIndex] = currentLongest + 1
            longestLength = maxOf(longestLength, charMap[charIndex])
        }

        return longestLength
    }
}

fun main() {
    // Input
    val s = "acfgbd"
    val k = 2
    // Output
    LeetCode_2370().longestIdealString(s, k).run {
        println(this)
        require(4 == this)
    }
}
