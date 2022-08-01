package dp

class LeetCode_97 {

    /**
     * Solution - Dynamic Programming
     * Time Complexity : O(MN)
     * Space Complexity : O(MN)
     *
     * Use s1 x s2 dp table to solve the problem.
     * This problem is to verify that the characters placed in any order match the original string.
     * Therefore, if the string matches, s3[i] will have either s1 or s2 unconditionally, followed by the beginning (0, 0) and the end (s3.size, s3.size) of the two-dimensional dp array.
     * If i is 0, make sure that s2 matches because it is in the first row. (s1 is a row)
     * If j is 0, check that s1 matches because it is in the first column. (s2 is a column)
     * If both are greater than or equal to 1, check both s1 and s2.
     * Returns the end of the array to verify that the string matches (the path continues to the end).
     *
     * @param s1 string
     * @param s2 string
     * @param s3 string likely formed by interleaving of s1 and s2
     * @return is s3 is formed by interleaving of s1 and s2
    */
    fun isInterleave(s1: String, s2: String, s3: String): Boolean {
        val len1 = s1.length
        val len2 = s2.length
        val len3 = s3.length

        if (len3 != len1 + len2)
            return false
        else if (len1 == 0)
            return s2 == s3
        else if (len2 == 0)
            return s1 == s3

        val dp = Array(len1 + 1) { BooleanArray(len2 + 1) }

        for (i in 0..len1) {
            for (j in 0..len2) {
                if (i == 0 && j == 0)
                    dp[0][0] = true
                else if (i == 0)
                    dp[0][j] = (s2[j - 1] == s3[j - 1]) && dp[0][j - 1]
                else if (j == 0)
                    dp[i][0] = (s1[i - 1] == s3[i - 1]) && dp[i - 1][0]
                else {
                    val c = s3[i + j - 1]
                    dp[i][j] = (s1[i - 1] == c && dp[i - 1][j]) || (s2[j - 1] == c && dp[i][j - 1])
                }
            }
        }

        return dp[len1][len2]
    }
}

fun main() {
    val s1 = "aabcc"
    val s2 = "dbbca"
    val s3 = "aadbbcbcac"
    println(LeetCode_97().isInterleave(s1, s2, s3))
}
