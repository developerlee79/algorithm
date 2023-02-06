package dp

class LeetCode_1387 {

    fun getKth(lo: Int, hi: Int, k: Int): Int {
        val powers = hashMapOf<Int, Int>()
        powers[1] = 0

        val results = mutableListOf<Pair<Int, Int>>()

        for (i in lo .. hi) {
            findPower(i, powers)
            results.add(Pair(i, powers[i]!!))
        }

        return results.sortedBy { it.second }[k - 1].first
    }

    private fun findPower(n: Int, dp: HashMap<Int, Int>): Int {
        if (!dp.containsKey(n)) {
            dp[n] = findPower(
                if (n % 2 == 0) {
                    n / 2
                } else {
                    n * 3 + 1
                }, dp
            )
        }

        return dp[n]!! + 1
    }
}

fun main() {
    // Input
    val lo = 12
    val hi = 15
    val k = 2
    // Output
    LeetCode_1387().getKth(lo, hi, k).let {
        println(it)
        require(it == 13)
    }
}
