package string

class LeetCode_1657 {

    fun closeStrings(word1: String, word2: String): Boolean {
        if (word1.length != word2.length) {
            return false
        }

        val frequency1 = constructFrequencyArray(word1)
        val frequency2 = constructFrequencyArray(word2)

        for (i in frequency1.indices) {
            if ((frequency1[i] == 0 || frequency2[i] == 0) && frequency1[i] != frequency2[i]) {
                return false
            }
        }

        frequency1.sort()
        frequency2.sort()

        for (i in frequency1.indices) {
            if (frequency1[i] != frequency2[i]) {
                return false
            }
        }

        return true
    }

    private fun constructFrequencyArray(target: String): IntArray {
        val frequency = IntArray(26)

        target.forEach {
            frequency[it - 'a']++
        }

        return frequency
    }
}

fun main() {
    // Input
    val word1 = "abc"
    val word2 = "bca"
    // Output
    LeetCode_1657().closeStrings(word1, word2).run {
        println(this)
        require(this)
    }
}
