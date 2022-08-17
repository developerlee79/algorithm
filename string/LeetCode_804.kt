package string

class LeetCode_804 {

    private val morseCode = arrayOf(
        ".-",
        "-...",
        "-.-.",
        "-..",
        ".",
        "..-.",
        "--.",
        "....",
        "..",
        ".---",
        "-.-",
        ".-..",
        "--",
        "-.",
        "---",
        ".--.",
        "--.-",
        ".-.",
        "...",
        "-",
        "..-",
        "...-",
        ".--",
        "-..-",
        "-.--",
        "--.."
    )

    /**
     * Solution - Set
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     *
     * Simple.
     *
     * @param words array of strings
     * @return number of different transformations among all words we have
     */
    fun uniqueMorseRepresentations(words: Array<String>): Int {
        val wordSet = mutableSetOf<String>()

        for (word in words) {
            val builder = StringBuilder()

            for (c in word) {
                builder.append(morseCode[c - 'a'])
            }

            wordSet.add(builder.toString())
        }

        return wordSet.size
    }
}

fun main() {
    val words = arrayOf("gin", "zen", "gig", "msg")
    println(LeetCode_804().uniqueMorseRepresentations(words))
}
