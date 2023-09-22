package string

class LeetCode_392 {

    fun isSubsequence(s: String, t: String): Boolean {
        var subsequenceIndex = 0

        val n = s.length

        for (i in t.indices) {
            if (subsequenceIndex == n) {
                break;
            }
            if (s[subsequenceIndex] == t[i]) {
                subsequenceIndex++
            }
        }

        return subsequenceIndex == n
    }
}

fun main() {
    // Input
    val s = "abc"
    val t = "ahbgdc"
    // Output
    LeetCode_392().isSubsequence(s, t).run {
        println(this)
        require(this)
    }
}
