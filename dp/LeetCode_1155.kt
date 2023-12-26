package dp

class LeetCode_1155 {

    fun numRollsToTarget(n: Int, k: Int, target: Int): Int {
        val dp = Array(target + 1) { LongArray(n + 1) { -1 } }
        return findTarget(n, k, target, dp).toInt()
    }

    private fun findTarget(n: Int, k: Int, target: Int, dp: Array<LongArray>): Long {
        if (n == 1) {
            return if (target in 1..k) 1 else 0
        }

        if (dp[target][n] != -1L) {
            return dp[target][n]
        }

        var wayToGetSum = 0L
        val nextRoll = n - 1

        for (i in 1..minOf(k, target)) {
            wayToGetSum += findTarget(nextRoll, k, target - i, dp) % 1000000007
        }

        dp[target][n] = wayToGetSum % 1000000007
        return dp[target][n]
    }

}

fun main() {
    // Input
    val n = 1
    val k = 6
    val target = 3
    // Output
    LeetCode_1155().numRollsToTarget(n, k, target).run {
        println(this)
        require(1 == this)
    }
}
