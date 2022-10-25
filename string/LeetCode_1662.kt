package string

class LeetCode_1662 {

    /**
     * Time Complexity : O(N)
     * Space Complexity : O(1)
     *
     * Simple!
     *
     * @param word1 string array
     * @param word2 string array
     * @return return true if the two arrays represent the same string, and false otherwise.
     */
    fun arrayStringsAreEqual(word1: Array<String>, word2: Array<String>): Boolean =
        word1.joinToString("") == word2.joinToString("")
}

fun main() {
    // Input
    val word1 = arrayOf("ab", "c")
    val word2 = arrayOf("a", "bc")
    // Output
    val result = LeetCode_1662().arrayStringsAreEqual(word1, word2)
    println(result)
    require(result)
}
