package string

class LeetCode_438 {

    fun findAnagrams(s: String, p: String): List<Int> {
        val anagrams = mutableListOf<Int>()

        val len = p.length

        if (s.isEmpty() || p.isEmpty() || s.length < len) {
            return anagrams
        }

        val chars = IntArray(26)

        p.forEach {
            chars[it - 'a']++
        }

        var start = 0
        var end = 0
        var diff = len
        var temp: Char

        while (end < len) {
            temp = s[end]

            chars[temp - 'a']--

            if (chars[temp - 'a'] >= 0) {
                diff--
            }
            end++
        }


        if (diff == 0) {
            anagrams.add(0)
        }

        while (end < s.length) {
            temp = s[start]

            if (chars[temp - 'a'] >= 0) {
                diff++
            }

            chars[temp - 'a']++

            start++

            temp = s[end]

            chars[temp - 'a']--

            if (chars[temp - 'a'] >= 0) {
                diff--
            }

            if (diff == 0) {
                anagrams.add(start)
            }

            end++
        }

        return anagrams
    }
}

fun main() {
    // Input
    val s = "cbaebabacd"
    val p = "abc"
    // Output
    LeetCode_438().findAnagrams(s, p).let {
        println(it)
        require(it == listOf(0, 6))
    }
}
