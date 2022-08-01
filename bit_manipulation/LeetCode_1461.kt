package bit_manipulation

class LeetCode_1461 {

    /**
     * Solution - Sliding window
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     *
     * Using sliding window which size k to search every possible binary codes in string s.
     * Initializes boolean array bitCodes with k^2 size for representing all binary codes of k lengths.
     * The index of the Bool array is the value when the sub-binary string is converted to decimal.
     * (Example of k = 2 : [0, 0] = 0, [0, 1] = 1, [1, 0] = 2, [1, 1] = 3)
     * Each iteration switches the string in the sliding window to decimal integer and check binaryCodes[numOfBinary].
     * After the iteration, check the unchecked values in the bool array to valid s contains all binary codes of size k.
     *
     * @param s binary string
     * @param k length of binary substring
     * @return is every binary code of length k is a substring of s
     */
    fun hasAllCodes(s: String, k: Int): Boolean {
        val binaryCodes = BooleanArray(k * k)

        for (i in 0..s.length - k) {
            var numOfBinary = 0
            for (j in i until i + k) {
                numOfBinary = numOfBinary * 2 + (s[j] - '0')
            }
            binaryCodes[numOfBinary] = true
        }

        return false !in binaryCodes
    }
}

fun main() {
    val leetcode = LeetCode_1461()
    val s = "0110"
    val k = 1
    println(leetcode.hasAllCodes(s, k))
}