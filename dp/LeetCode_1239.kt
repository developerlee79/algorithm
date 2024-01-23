package dp

import kotlin.math.max

class LeetCode_1239 {

    private var maxLength = 0

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
    val arr = listOf("un", "iq", "ue")
    // Output
    LeetCode_1239().maxLength(arr).run {
        println(this)
        require(4 == this)
    }
}
