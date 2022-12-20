package math

class LeetCode_781 {

    fun numRabbits(answers: IntArray): Int {
        val colorMap = hashMapOf<Int, Int>()

        var numberOfRabbits = 0
        answers.forEach {
            if (it == 0) {
                numberOfRabbits++
                return@forEach
            }

            colorMap.merge(it, 1) { a, b -> a + b }

            if (colorMap[it] == it + 1) {
                numberOfRabbits += it + 1
                colorMap.remove(it)
            }
        }

        return numberOfRabbits + colorMap.keys.sumOf { it + 1 }
    }
}

fun main() {
    // Input
    val answers = intArrayOf(1, 1, 2)
    // Output
    LeetCode_781().numRabbits(answers).let {
        println(it)
        require(5 == it)
    }
}
