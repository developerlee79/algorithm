package string

import kotlin.math.max

class LeetCode_583 {

    /**
     * Solution - Dynamic Programming
     * Time Complexity : O(M * N)
     * Space Complexity : O(M * N)
     *
     * Use LCS (Longest Common Subsequence) to find the largest common sequence and subtract this count from s1.len + s2.len.
     * Because everything except LCS is a char that needs to be removed from the words.
     * Use the two-dimensional array of word 1 x word 2 to memory previous LCS.
     * If the substring of word1 and the substring of word2 are the same, it means that it is part of the LCS, so remember the value previous step (j) + 1.
     * If different, choose the bigger one in previous step in the column or the previous step in the row.
     * Because if there is a value in either of them, it means that it can be a substring that follows.
     * The table below provides an easy explanation.
     *
     * |   | s | e | a |
     * | e | 0 | 1 | 1 |
     * | a | 0 | 1 | 2 |
     * | t | 0 | 1 | 2 |
     *
     * @param word1
     * @param word2
     * @return minimum number of steps* required to make word1 and word2 the same.
     *         * step : delete exactly one character in either string
     */
    fun minDistance(word1: String, word2: String): Int {
        val m: Int = word1.length
        val n: Int = word2.length
        val dp = Array(m + 1) { IntArray(n + 1) }

        for (i in 1..m) {
            for (j in 1..n) {
                dp[i][j] =
                    if (word1[i - 1] == word2[j - 1])
                        dp[i - 1][j - 1] + 1
                    else
                        max(dp[i - 1][j], dp[i][j - 1])
            }
        }

        return (m + n) - (2 * dp[m][n])
    }
}

fun main() {
    val word1 = "sea"
    val word2 = "eat"
    println(LeetCode_583().minDistance(word1, word2))
}
