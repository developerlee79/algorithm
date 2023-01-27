package search

class LeetCode_472 {

    fun findAllConcatenatedWordsInADict(words: Array<String>): List<String> {
        val concatenatedWords = mutableListOf<String>()
        val wordSet = hashSetOf<String>()

        words.sortedArrayWith(compareBy { it.length }).forEach { word ->
            if (isConcatenatedWord(word, wordSet, 0)) {
                concatenatedWords.add(word)
            }
            wordSet.add(word)
        }

        return concatenatedWords
    }

    private fun isConcatenatedWord(word: String, wordSet: HashSet<String>, index: Int): Boolean {
        if (index !in word.indices) {
            return true
        }

        for (i in index + 1 .. word.length) {
            if (wordSet.contains(word.subSequence(index, i)) && isConcatenatedWord(word, wordSet, i)) {
                return true
            }
        }

        return false
    }
}

fun main() {
    // Input
    val words = arrayOf(
        "cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat"
    )
    // Output
    LeetCode_472().findAllConcatenatedWordsInADict(words).let {
        println(it)
        require(
            listOf("catsdogcats", "dogcatsdog", "ratcatdogcat").containsAll(it)
        )
    }
}
