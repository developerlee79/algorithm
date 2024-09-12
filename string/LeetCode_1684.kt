package string

class LeetCode_1684 {

    fun countConsistentStrings(allowed: String, words: Array<String>): Int {
        var count = 0

        val alphabetArray = IntArray(26)

        allowed.forEach {
            alphabetArray[it - 'a']++
        }

        words.forEach { word ->
            count++

            for (char in word) {
                if (alphabetArray[char - 'a'] == 0) {
                    count--
                    break
                }
            }
        }

        return count
    }
}

fun main() {
    // Input
    val allowed = "ab"
    val words = arrayOf("ad", "bd", "aaab", "baa", "badab")
    // Output
    LeetCode_1684().countConsistentStrings(allowed, words).run {
        println(this)
        require(2 == this)
    }
}
