package string

class LeetCode_2486 {

    fun appendCharacters(s: String, t: String): Int {
        val n = s.length
        val m = t.length

        var i = 0
        var j = 0

        while (i < n && j < m) {
            if (s[i] == t[j]) {
                j++
            }

            i++
        }

        return m - j
    }
}

fun main() {
    // Input
    val s = "coaching"
    val t = "coding"
    // Output
    LeetCode_2486().appendCharacters(s, t).run {
        println(this)
        require(4 == this)
    }
}
