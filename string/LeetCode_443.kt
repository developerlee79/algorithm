package string

class LeetCode_443 {

    fun compress(chars: CharArray): Int {
        var count = 0

        var i = 0

        while (i in chars.indices) {
            val j = i

            while (i + 1 < chars.size && chars[i] == chars[i + 1]) {
                i++
            }

            chars[count++] = chars[i]

            if (j != i) {
                for (ch in (i + 1 - j).toString()) {
                    chars[count++] = ch
                }
            }

            i++
        }

        return count
    }
}

fun main() {
    // Input
    val chars = charArrayOf('a', 'a', 'b', 'b', 'c', 'c', 'c')
    // Output
    LeetCode_443().compress(chars).let {
        println(it)
        require(it == 6)
        println(chars.joinToString())
        require(
            charArrayOf('a', '2', 'b', '2', 'c', '3', 'c').contentEquals(chars)
        )
    }
}
