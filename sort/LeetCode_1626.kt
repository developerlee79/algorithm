package sort

import java.util.PriorityQueue

class LeetCode_1626 {

    private class Player(
        val age: Int,
        val score: Int
    ) : Comparable<Player> {

        override fun compareTo(other: Player) =
            if (age == other.age)
                other.score - score
            else
                other.age - age
    }

    fun bestTeamScore(scores: IntArray, ages: IntArray): Int {
        val playerList = mutableListOf<Player>()

        repeat(scores.size) {
            playerList.add(
                Player(
                    age = ages[it],
                    score = scores[it]
                )
            )
        }

        playerList.sort()

        val dp = IntArray(scores.size)
        var bestScore = 0

        for (i in scores.indices) {
            val currentPlayer = playerList[i]

            dp[i] = currentPlayer.score

            for (j in 0 until i) {
                if (playerList[j].score >= currentPlayer.score) {
                    dp[i] = maxOf(dp[i], dp[j] + currentPlayer.score)
                }
            }

            bestScore = maxOf(bestScore, dp[i])
        }

        return bestScore
    }
}

fun main() {
    // Input
    val scores = intArrayOf(1, 3, 5, 10, 15)
    val ages = intArrayOf(1, 2, 3, 4, 5)
    // Output
    LeetCode_1626().bestTeamScore(scores, ages).let {
        println(it)
        require(it == 34)
    }
}
