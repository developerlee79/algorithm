package string

class LeetCode_409 {

    /**
     * Solution - Set
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     *
     * @param s string
     * @return length of the longest palindrome that can be built with those letters
    */
    fun longestPalindrome(s: String): Int {
        val set = hashSetOf<Char>()

        for (c in s) {
            if (set.contains(c)) {
                set.remove(c)
            } else {
                set.add(c)
            }
        }

        return s.length - set.size + if (set.isNotEmpty()) 1 else 0
    }
}

fun main() {
    val s = "abccccdd"
    println(LeetCode_409().longestPalindrome(s))
}
