package string

class LeetCode_2734 {

    fun smallestString(s: String): String {
        val n = s.length

        val replacedString = StringBuilder()

        var i = 0

        while (i < n && s[i] == 'a') {
            replacedString.append(s[i++])
        }

        if (i == n) {
            replacedString.deleteAt(n - 1)
            replacedString.append('z')
        }

        while (i < n && s[i] != 'a') {
            replacedString.append(s[i++] - 1)
        }

        replacedString.append(s.substring(i until n))

        return replacedString.toString()
    }
}

fun main() {
    // Input
    val s = "cbabc"
    // Output
    LeetCode_2734().smallestString(s).run {
        println(this)
        require("baabc" == this)
    }
}
