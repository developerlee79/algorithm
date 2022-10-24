package backtracking

import kotlin.math.max

class LeetCode_1239 {

    private var maxLength = 0

    /**
     * Solution : Backtracking
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     *
     * @param arr array of strings
     * @return maximum possible length of string s which formed by the concatenation of a subsequence of arr that has unique characters
    */
    fun maxLength(arr: List<String>): Int {
        findMaxLength(arr, 0, "")
        return maxLength
    }

    private fun findMaxLength(arr: List<String>, index: Int, currentString: String) {
        maxLength = max(maxLength, currentString.length)

        for (i in index until arr.size) {
            if (!isUnique(currentString, arr[i])) {
                continue
            }
            findMaxLength(arr, i + 1, currentString + arr[i])
        }
    }

    private fun isUnique(currentString: String, nextString: String): Boolean {
        val uniqueArray = BooleanArray(26)

        nextString.forEach {
            if (uniqueArray[it - 'a'] || currentString.contains(it)) {
                return false
            }
            uniqueArray[it - 'a'] = true
        }

        return true
    }
}

fun main() {
    // Input
    val arr = listOf(
        "un", "iq", "ue"
    )
    // Output
    val result = LeetCode_1239().maxLength(arr)
    println(result)
    require(result == 4)
}
