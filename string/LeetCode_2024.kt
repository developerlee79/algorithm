package string

class LeetCode_2024 {

    fun maxConsecutiveAnswers(answerKey: String, k: Int): Int {
        val charFrequencyMap = HashMap<Char, Int>()
        var maxFrequency = 0

        var index = 0

        for (i in answerKey.indices) {
            val answer = answerKey[i]
            charFrequencyMap.merge(answer, 1) { a, b -> a + b }
            maxFrequency = maxOf(maxFrequency, charFrequencyMap[answer]!!)

            if (i - index + 1 > maxFrequency + k) {
                charFrequencyMap.merge(answerKey[index], 1) { a, b -> a - b }
                index++
            }
        }

        return answerKey.length - index
    }
}

fun main() {
    // Input
    val answerKey = "TTFF"
    val k = 2
    // Output
    LeetCode_2024().maxConsecutiveAnswers(answerKey, k).run {
        println(this)
        require(4 == this)
    }
}
