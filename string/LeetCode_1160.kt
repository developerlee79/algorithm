package string

class LeetCode_1160 {

    /**
     * Solution - Alphabet Array
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     *
     * Count the characters in chars to wordCountArray and compare each word in words is good string
     *
     * @param words array of words
     * @param chars string which has to be formed by characters of words
     * @return sum of lengths of all good strings in words
     */
    fun countCharacters(words: Array<String>, chars: String): Int {
        val wordCountArray = IntArray(26)
        chars.forEach { c ->
            wordCountArray[c - 'a']++
        }

        var result = 0
        words.forEach loop@{ word ->
            val wordCount = wordCountArray.clone()
            word.forEach { c ->
                if (--wordCount[c - 'a'] < 0) {
                    return@loop
                }
            }
            result += word.length
        }

        return result
    }
}

fun main() {
    val words = arrayOf("cat", "bt", "hat", "tree")
    val chars = "atach"
    println(LeetCode_1160().countCharacters(words, chars))
}