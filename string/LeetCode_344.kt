package string

class LeetCode_344 {

    fun reverseString(s: CharArray): Unit {
        val n = s.size

        for (i in 0 until n / 2) {
            swap(s, i, n - i - 1)
        }
    }

    private fun swap(s: CharArray, i: Int, j: Int) {
        val tmp = s[i]
        s[i] = s[j]
        s[j] = tmp
    }
}

fun main() {
    // Input
    val s = charArrayOf('h', 'e', 'l', 'l', 'o')
    // Output
    LeetCode_344().reverseString(s).run {
        println(s.joinToString())
        require(
            charArrayOf('o', 'l', 'l', 'e', 'h').contentEquals(s)
        )
    }
}
