package string

class LeetCode_1002 {

    fun commonChars(words: Array<String>): List<String> {
        val result = mutableListOf<String>()

        var ch = 'a'

        while (ch <= 'z') {
            var minCount = Int.MAX_VALUE

            for (word in words) {
                var count = 0

                for (c in word.toCharArray()) {
                    if (c == ch) {
                        count++
                    }
                }

                minCount = minOf(minCount.toDouble(), count.toDouble()).toInt()
            }


            for (i in 0 until minCount) {
                result.add(ch.toString())
            }

            ch++
        }

        return result
    }
}

fun main() {
    // Input
    val words = arrayOf("bella", "label", "roller")
    // Output
    LeetCode_1002().commonChars(words).run {
        println(this.joinToString())
        require(
            listOf("e", "l", "l") == this
        )
    }
}
