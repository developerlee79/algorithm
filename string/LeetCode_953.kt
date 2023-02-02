package string

class LeetCode_953 {

    fun isAlienSorted(words: Array<String>, order: String): Boolean {
        val alphabetMap = hashMapOf<Char, Int>()

        order.forEachIndexed { index, c ->
            alphabetMap[c] = index
        }

        for (i in 1 until words.size) {
            var j = 0

            val firstWord = words[i - 1]
            val secondWord = words[i]

            while (j in firstWord.indices && j in secondWord.indices) {
                if (alphabetMap[firstWord[j]]!! > alphabetMap[secondWord[j]]!!) {
                    return false
                } else if (alphabetMap[firstWord[j]]!! < alphabetMap[secondWord[j]]!!) {
                    break
                }
                j++
            }

            if (j == secondWord.length && firstWord.length > secondWord.length) {
                return false
            }
        }

        return true
    }
}

fun main() {
    // Input
    val words = arrayOf("hello", "leetcode")
    val order = "hlabcdefgijkmnopqrstuvwxyz"
    // Output
    LeetCode_953().isAlienSorted(words, order).let {
        println(it)
        require(it)
    }
}
