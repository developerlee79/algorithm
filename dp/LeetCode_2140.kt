package dp

class LeetCode_2140 {

    fun mostPoints(questions: Array<IntArray>): Long {
        val dp = LongArray(questions.size)
        recursive(questions, dp, 0, 0)
        return dp[0]
    }

    private fun recursive(questions: Array<IntArray>, dp: LongArray, index: Int, currentPoint: Long): Long {
        if (index >= questions.size) {
            return currentPoint
        }

        if (dp[index] > 0) {
            return dp[index] + currentPoint
        }

        dp[index] = maxOf(
            recursive(questions, dp, index + questions[index][1] + 1, questions[index][0].toLong()),
            recursive(questions, dp, index + 1, 0)
        )

        return dp[index] + currentPoint
    }
}

fun main() {
    // Input
    val questions = arrayOf(
        intArrayOf(3, 2),
        intArrayOf(4, 3),
        intArrayOf(4, 4),
        intArrayOf(2, 5),
    )
    // Output
    LeetCode_2140().mostPoints(questions).run {
        println(this)
        require(5L == this)
    }
}
