package string

class LeetCode_890 {

    /**
     * Solution - Normalize
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     *
     * Normalize a string to a standard pattern.
     *
     * @param words array of words
     * @param pattern pattern
     * @return list of words[i] that match pattern
    */
    fun findAndReplacePattern(words: Array<String>, pattern: String): List<String> {
        val result = mutableListOf<String>()
        val patternArray = normalize(pattern)

        for (word in words) {
            val normalizedWord = normalize(word)

            if (patternArray.contentEquals(normalizedWord)) {
                result.add(word)
            }
        }

        return result
    }

    private fun normalize(word: String): IntArray {
        val map = HashMap<Char, Int>()
        val normalizedArray = IntArray(word.length)

        for (i in word.indices) {
            map.putIfAbsent(word[i], map.size)
            normalizedArray[i] = map[word[i]]!!
        }

        return normalizedArray
    }
}

fun main() {
    val words = arrayOf("abc", "deq", "mee", "aqq", "dkd", "ccc")
    val pattern = "abb"
    println(LeetCode_890().findAndReplacePattern(words, pattern))
}
