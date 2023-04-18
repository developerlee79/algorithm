package string

class LeetCode_1768 {

    fun mergeAlternately(word1: String, word2: String): String {
        val wordBuilder = StringBuilder()

        val shorterLength = minOf(word1.length, word2.length)

        repeat(shorterLength) {
            wordBuilder.append(word1[it])
            wordBuilder.append(word2[it])
        }

        wordBuilder.append(word1.substring(shorterLength))
        wordBuilder.append(word2.substring(shorterLength))

        return wordBuilder.toString()
    }
}

fun main() {
    // Input
    val word1 = "abc"
    val word2 = "pqr"
    // Output
    LeetCode_1768().mergeAlternately(word1, word2).let {
        println(it)
        require("apbqcr" == it)
    }
}
