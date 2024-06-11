package string

class LeetCode_2083 {

    fun numberOfSubstrings(s: String): Long {
        val charCounter = LongArray(26)

        s.forEach { letter ->
            charCounter[letter - 'a']++
        }

        var count = 0L

        for (charCount in charCounter) {
            count += charCount * (charCount - 1) / 2
        }

        return count + s.length
    }
}

fun main() {
    // Input
    val s = "abcba"
    // Output
    LeetCode_2083().numberOfSubstrings(s).run {
        println(this)
        require(7L == this)
    }
}
