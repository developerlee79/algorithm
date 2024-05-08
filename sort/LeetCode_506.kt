package sort

class LeetCode_506 {

    private val ranks = arrayOf(
        "Gold Medal",
        "Silver Medal",
        "Bronze Medal"
    )

    fun findRelativeRanks(score: IntArray): Array<String> {
        val scoreList = mutableListOf<Pair<Int, Int>>()

        score.forEachIndexed { i, sc ->
            scoreList.add(Pair(sc, i))
        }

        scoreList.sortByDescending { it.first }

        val rankList = Array(score.size) { "" }
        val namedRankSize = ranks.size

        for (i in scoreList.indices) {
            val rankIndex = scoreList[i].second

            if (i < namedRankSize) {
                rankList[rankIndex] = ranks[i]
            } else {
                rankList[rankIndex] = (i + 1).toString()
            }
        }

        return rankList
    }
}

fun main() {
    // Input
    val score = intArrayOf(5, 4, 3, 2, 1)
    // Output
    LeetCode_506().findRelativeRanks(score).run {
        println(this.joinToString())
        require(
            arrayOf("Gold Medal", "Silver Medal", "Bronze Medal", "4", "5").contentEquals(this)
        )
    }
}
