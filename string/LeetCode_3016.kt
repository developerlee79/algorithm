package string

class LeetCode_3016 {

    fun minimumPushes(word: String): Int {
        val charMap = HashMap<Char, Int>(26)

        word.forEach {
            charMap.merge(it, 1) { a, b -> a + b }
        }

        var count = 0

        var i = 0
        var j = 1

        val sortedCharMap = charMap.entries.sortedBy { -it.value }

        sortedCharMap.forEach {
            count += it.value * j

            i++

            if (i == 8) {
                i = 0
                j++
            }
        }

        return count
    }
}

fun main() {
    // Input
    val word = "abcde"
    // Output
    LeetCode_3016().minimumPushes(word).run {
        println(this)
        require(5 == this)
    }
}
