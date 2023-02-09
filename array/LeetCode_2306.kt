package array

class LeetCode_2306 {

    fun distinctNames(ideas: Array<String>): Long {
        val wordSet = Array<HashSet<Int>>(26) { hashSetOf() }

        ideas.forEach { idea ->
            wordSet[idea.first() - 'a'].add(idea.substring(1).hashCode())
        }

        var count = 0L

        repeat(26) { i ->
            for (j in i + 1 until 26) {
                var char1 = 0
                var char2 = 0

                wordSet[i].forEach { code ->
                    if (!wordSet[j].contains(code)) {
                        char1++
                    }
                }

                wordSet[j].forEach { code ->
                    if (!wordSet[i].contains(code)) {
                        char2++
                    }
                }

                count += char1 * char2
            }
        }

        return count * 2
    }
}

fun main() {
    // Input
    val ideas = arrayOf("coffee", "donuts", "time", "toffee")
    // Output
    LeetCode_2306().distinctNames(ideas).let {
        println(it)
        require(it == 6L)
    }
}
