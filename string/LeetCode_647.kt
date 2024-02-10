package string

class LeetCode_647 {

    fun countSubstrings(s: String): Int {
        if (s.isEmpty()) {
            return 0
        }

        var result = 0
        val chars = s.toCharArray()

        for (i in chars.indices) {
            result += countPalindrome(chars, i, i)
            result += countPalindrome(chars, i, i + 1)
        }

        return result
    }

    private fun countPalindrome(chars: CharArray, index: Int, next: Int): Int {
        var index = index
        var next = next
        var count = 0

        while (index >= 0 && next < chars.size && chars[index--] == chars[next++]) {
            count++
        }

        return count
    }
}

fun main() {
    // Input
    val s = "abc"
    // Output
    LeetCode_647().countSubstrings(s).run {
        println(this)
        require(3 == this)
    }
}
