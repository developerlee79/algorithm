package math

class LeetCode_2038 {

    fun winnerOfGame(colors: String): Boolean {
        var countA = 0
        var countB = 0

        for (i in 1 until colors.length - 1) {
            if (colors[i] == 'A') {
                if (colors[i - 1] == 'A' && colors[i + 1] == 'A') {
                    countA++
                }
            } else {
                if (colors[i - 1] == 'B' && colors[i + 1] == 'B') {
                    countB++
                }
            }
        }

        return countA > countB
    }
}

fun main() {
    // Input
    val colors = "AAABABB"
    // Output
    LeetCode_2038().winnerOfGame(colors).run {
        println(this)
        require(this)
    }
}
