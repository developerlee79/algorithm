package two_pointers

class LeetCode_1768 {

    /**
     * Solution - Two Pointers
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     *
     * Classic two pointers
     *
     * @param word1 word
     * @param word2 word
     * @return merged string
    */
    fun mergeAlternately(word1: String, word2: String): String {
        val wordBuilder = StringBuilder()

        var i = 0
        while (i < word1.length && i < word2.length) {
            wordBuilder.append(word1[i])
            wordBuilder.append(word2[i++])
        }

        wordBuilder.append(
            if (word1.length < word2.length) {
                word2.substring(i)
            } else {
                word1.substring(i)
            }
        )

        return wordBuilder.toString()
    }
}

fun main() {
    val word1 = "ab"
    val word2 = "pqrs"
    println(LeetCode_1768().mergeAlternately(word1, word2))
}
