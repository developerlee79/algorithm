package string


class LeetCode_820 {

    /**
     * Solution - Set
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     *
     * Use two set to save the words.
     * Add all words in set and make all common prefix.
     * If set2 already use it, we can remove it.
     * Return sum of every element + set2.size (encoding)
     *
     * @param words array of words
     * @return the length of the shortest reference string s possible of any valid encoding of words
     */
    fun minimumLengthEncoding(words: Array<String>): Int {
        val set1 = HashSet<String>()
        val set2 = HashSet<String>()

        for (word in words) {
            set1.add(word)
            set2.add(word)
        }

        for (word in set1) {
            for (i in word.indices) {
                set2.remove(word.substring(i + 1))
            }
        }

        return set2.stream().mapToInt(String::length).sum() + set2.size
    }
}

fun main() {
    val words = arrayOf("time", "me", "bell")
    println(LeetCode_820().minimumLengthEncoding(words))
}
