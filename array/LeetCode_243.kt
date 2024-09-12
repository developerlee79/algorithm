package array

class LeetCode_243 {

    fun shortestDistance(wordsDict: Array<String>, word1: String, word2: String): Int {
        var shortestDistance = Int.MAX_VALUE

        var lastLocation1 = -1
        var lastLocation2 = -1

        wordsDict.forEachIndexed { i, word ->
            if (word == word1) {
                if (lastLocation2 != -1) {
                    shortestDistance = minOf(shortestDistance, i - lastLocation2)
                }

                lastLocation1 = i
            } else if (word == word2) {
                if (lastLocation1 != -1) {
                    shortestDistance = minOf(shortestDistance, i - lastLocation1)
                }

                lastLocation2 = i
            }
        }

        return shortestDistance
    }
}

fun main() {
    // Input
    val wordsDict = arrayOf(
        "practice", "makes", "perfect", "coding", "makes"
    )
    val word1 = "coding"
    val word2 = "practice"
    // Output
    LeetCode_243().shortestDistance(wordsDict, word1, word2).run {
        println(this)
        require(3 == this)
    }
}
