package math

class LeetCode_650 {

    /**
     * Solution : Dynamic Programming
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     *
     * @param n integer
     * @return Return Value Of This Function
    */
    fun minSteps(n: Int): Int {
        val dp = IntArray(n + 1)

        (2..n).forEach {
            dp[it] = it

            for (i in it - 1 downTo 1) {
                if (it % i == 0) {
                    dp[it] = dp[i] + (it / i)
                    break
                }
            }
        }

        return dp[n]
    }
}

fun main() {
    // Input
    val n = 3
    // Output
    val result = LeetCode_650().minSteps(n)
    println(result)
    require(result == 3)
}
