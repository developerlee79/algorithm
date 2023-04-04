package string

class LeetCode_2405 {

    fun partitionString(s: String): Int {
        var count = 0

        var i = 0
        while (i in s.indices) {
            val charSet = BooleanArray(26)

            while (i in s.indices && !charSet[s[i] - 'a']) {
                charSet[s[i] - 'a'] = true
                i++
            }

            count++
        }

        return count
    }
}

fun main() {
    // Input
    val s = "abacaba"
    // Output
    LeetCode_2405().partitionString(s).let {
        println(it)
        require(4 == it)
    }
}
