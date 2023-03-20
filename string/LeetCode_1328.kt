package string

class LeetCode_1328 {

    fun breakPalindrome(palindrome: String): String {
        if (palindrome.length < 2) {
            return ""
        }

        repeat (palindrome.length / 2) {
            if (palindrome[it] > 'a') {
                return palindrome.substring(0, it) + 'a' + palindrome.substring(it + 1, palindrome.length)
            }
        }

        return palindrome.substring(0, palindrome.lastIndex) + 'b'
    }
}

fun main() {
    // Input
    val palindrome = "abccba"
    // Output
    LeetCode_1328().breakPalindrome(palindrome).let {
        println(it)
        require(it == "aaccba")
    }
}
