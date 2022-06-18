package design

class LeetCode_745 {

    /**
     * Solution - Brute-force
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     *
     * Add all combinations in word map with separator '|'
     *
     * @param words array of words in the dictionary
    */
    class WordFilter(words: Array<String>) {

        private val wordMap: MutableMap<String, Int> = mutableMapOf()

        init {
            val n = words.size

            for (i in 0 until n) {
                val word = words[i]
                val wordSize = word.length

                for (j in 1..wordSize) {
                    val p = word.substring(0, j)

                    for (k in 0 until wordSize) {
                        wordMap[p + "|" + word.substring(k, wordSize)] = i + 1
                    }
                }
            }
        }

        /**
         * Solution - Hash Map
         * Time Complexity : O(1)
         * Space Complexity : O(1)
         *
         * Find the prefix and suffix in the registered map when initialized.
         *
         * @param prefix
         * @param suffix
         * @return there is more than one valid index, return the largest of them
         */
        fun f(prefix: String, suffix: String): Int {
            return wordMap["$prefix|$suffix"]?.minus(1) ?: -1
        }
    }

}

fun main() {
    val words = arrayOf("Apple")
    val prefix = "a"
    val suffix = "e"

    val wordFilter = LeetCode_745.WordFilter(words)
    println(wordFilter.f(prefix, suffix))
}
