package string

class LeetCode_884 {

    fun uncommonFromSentences(s1: String, s2: String): Array<String> {
        val wordMap = hashMapOf<String, Int>()

        val splitWord = ("$s1 $s2").split(" ")

        splitWord.forEach { word ->
            wordMap.merge(word, 1) { a, b -> a + b }
        }

        val uncommonArray = mutableListOf<String>()

        wordMap.entries.forEach { entry ->
            if (entry.value == 1) {
                uncommonArray.add(entry.key)
            }
        }

        return uncommonArray.toTypedArray()
    }
}

fun main() {
    // Input
    val s1 = "this apple is sweet"
    val s2 = "this apple is sour"
    // Output
    LeetCode_884().uncommonFromSentences(s1, s2).run {
        println(this.joinToString())
        require(
            arrayOf("sweet", "sour").contentEquals(this)
        )
    }
}
