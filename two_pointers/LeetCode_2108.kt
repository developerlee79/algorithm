package two_pointers

class LeetCode_2108 {

    fun firstPalindrome(words: Array<String>): String {
        words.forEach { word ->
            if (isPalindrome(word)) {
                return word
            }
        }

        return ""
    }

    private fun isPalindrome(word: String): Boolean {
        var i = 0
        var j = word.lastIndex

        while (i <= j) {
            if (word[i++] != word[j--]) {
                return false
            }
        }

        return true
    }
}

fun main() {
    // Input
    val words = arrayOf("abc", "car", "ada", "racecar", "cool")
    // Output
    LeetCode_2108().firstPalindrome(words).run {
        println(this)
        require("ada" == this)
    }
}
