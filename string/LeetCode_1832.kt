package string

class LeetCode_1832 {

    /**
     * Solution : Set
     * Time Complexity : O(1)
     * Space Complexity : O(N)
     *
     * If size of sentence set == 26 (number of alphabet), then sentence is pangram.
     *
     * @param sentence string sentence containing only lowercase English letters
     * @return return true if sentence is a pangram, or false otherwise
    */
    fun checkIfPangram(sentence: String): Boolean = sentence.toSet().size == 26
}

fun main() {
    // Input
    val sentence = "thequickbrownfoxjumpsoverthelazydog"
    // Output
    val result = LeetCode_1832().checkIfPangram(sentence)
    println(result)
    require(result)
}
