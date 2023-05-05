package string

class LeetCode_1456 {

    private fun Char.isVowel(): Boolean =
        this == 'a' || this == 'e' || this == 'i' || this == 'o' || this == 'u'

    fun maxVowels(s: String, k: Int): Int {
        var currentScore = 0
        var isFirstVowel = s.first().isVowel()

        repeat(k) {
            if (s[it].isVowel()) {
                currentScore++
            }
        }

        var maxScore = currentScore

        for (i in k until s.length) {
            if (isFirstVowel) {
                currentScore--
            }

            isFirstVowel = s[i - k + 1].isVowel()

            if (s[i].isVowel()) {
                currentScore++
            }

            maxScore = maxOf(maxScore, currentScore)
        }

        return maxScore
    }
}

fun main() {
    // Input
    val s = "abciiidef"
    val k = 3
    // Output
    LeetCode_1456().maxVowels(s, k).run {
        println(this)
        require(3 == this)
    }
}
