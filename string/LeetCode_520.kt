package string

class LeetCode_520 {

    fun detectCapitalUse(word: String): Boolean {
        if (word.length == 1) {
            return true
        }

        if (word.first().isUpperCase()) {
            val isCapital = word[1].isUpperCase()

            for (i in 2 until word.length) {
                if (word[i].isUpperCase() != isCapital) {
                    return false
                }
            }
        } else {
            for (i in 1 until word.length) {
                if (word[i].isUpperCase()) {
                    return false
                }
            }
        }

        return true
    }
}

fun main() {
    // Input
    val word = "USA"
    // Output
    LeetCode_520().detectCapitalUse(word).let {
        println(it)
        require(it)
    }
}
