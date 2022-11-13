package string

class LeetCode_151 {

    /**
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     *
     * @param s string
     * @return Return a string of the words in reverse order concatenated by a single space
     */
    fun reverseWords(s: String): String =
        s.split(" ").filterNot{it.isBlank()}.reversed().joinToString(" ")
}

fun main() {
    // Input
    val s = "the sky is blue"
    // Output
    val output = LeetCode_151().reverseWords(s)
    println(output)
    require(output == "blue is sky the")
}
