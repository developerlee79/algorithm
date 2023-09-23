package dp

class LeetCode_1048 {

    private fun String.exceptIndex(index: Int): String {
        val stringBuilder = StringBuilder()

        for (i in this.indices) {
            if (i == index) {
                continue
            }
            stringBuilder.append(this[i])
        }

        return stringBuilder.toString()
    }

    fun longestStrChain(words: Array<String>): Int {
        words.sortBy { it.length }

        var chainSize = 0

        val chainMap = hashMapOf<String, Int>()

        words.forEach { word ->
            var lastChain = 0

            repeat(word.length) {
                val exceptedWord = word.exceptIndex(it)

                if (chainMap.containsKey(exceptedWord)) {
                    lastChain = maxOf(lastChain, chainMap[exceptedWord]!!)
                }
            }

            chainMap[word] = 1 + lastChain

            chainSize = maxOf(chainSize, chainMap[word]!!)
        }

        return chainSize
    }
}

fun main() {
    // Input
    val words = arrayOf("a", "b", "ba", "bca", "bda", "bdca")
    // Output
    LeetCode_1048().longestStrChain(words).run {
        println(this)
        require(4 == this)
    }
}
