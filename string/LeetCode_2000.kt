package string

class LeetCode_2000 {

    fun reversePrefix(word: String, ch: Char): String {
        for (i in word.indices) {
            if (word[i] == ch) {
                return word.substring(0 .. i).reversed() + word.substring(i + 1)
            }
        }

        return word
    }
}

fun main() {
    // Input
    val word = "abcdefd"
    val ch = 'd'
    // Output
    LeetCode_2000().reversePrefix(word, ch).run {
        println(this)
        require("dcbaefd" == this)
    }
}
