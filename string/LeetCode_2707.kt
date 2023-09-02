package string

class LeetCode_2707 {

    fun minExtraChar(s: String, dictionary: Array<String>): Int {
        val n = s.length

        val dp = IntArray(n + 1) { n + 1 }
        dp[0] = 0

        val dictionarySet = dictionary.toHashSet()

        for (i in 1 .. n) {
            dp[i] = dp[i - 1] + 1

            for (j in 1..i) {
                if (dictionarySet.contains(s.substring(i - j, i))) {
                    dp[i] = minOf(dp[i], dp[i - j])
                }
            }
        }

        return dp[n]
    }
}

fun main() {
    // Input
    val s = "sayhelloworld"
    val dictionary = arrayOf(
        "hello", "world"
    )
    // Output
    LeetCode_2707().minExtraChar(s, dictionary).run {
        println(this)
        require(3 == this)
    }
}
