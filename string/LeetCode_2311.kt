package string

class LeetCode_2311 {

    /**
     * Time Complexity : O(N)
     * Space Complexity : O(1)
     *
     * @param s binary string
     * @param k positive integer
     * @return length of the longest subsequence of s that makes up a binary number less than or equal to k
     */
    fun longestSubsequence(s: String, k: Int): Int {
        val binaryString = k.toString(2)

        if (s.length < binaryString.length) {
            return s.length
        }

        var num = 0
        repeat(s.length - binaryString.length) {i ->
            if (s[i] == '0') {
                num++
            }
        }

        return num + if (binaryString >= s.substring(s.length - binaryString.length, s.length)) {
            binaryString.length
        } else {
            binaryString.lastIndex
        }
    }
}

fun main() {
    // Input
    val s = "1001010"
    val k = 5
    // Output
    val result = LeetCode_2311().longestSubsequence(s, k)
    println(result)
    require(result == 5)
}
