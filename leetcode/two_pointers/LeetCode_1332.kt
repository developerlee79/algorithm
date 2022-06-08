package two_pointers

class LeetCode_1332 {

    /**
     * Solution - Remove Subsequences
     * Time Complexity : O(N)
     * Space Complexity : O(1)
     *
     * There's only two letters 'a' and 'b'.
     * So there is only 3 situation of this problem.
     * 1. String length 0 => return 0
     * 2. Palindrome String => return 1
     * 3. Remove every 'a' and every 'b' => return 2
     * Check its palindrome and if not, return 2 (case 3). is it, return 1.
     *
     * @param s string what consisting only of letters 'a' and 'b'
     * @return minimum number of steps (remove one palindromic subsequence) to make the given string empty
     */
    fun removePalindromeSub(s: String): Int {
        if (s.isEmpty()) return 0

        for (i in 0..s.length / 2)
            if (s[i] != s[s.length - i - 1])
                return 2

        return 1
    }
}

fun main() {
    val s = "abb"
    println(LeetCode_1332().removePalindromeSub(s))
}
