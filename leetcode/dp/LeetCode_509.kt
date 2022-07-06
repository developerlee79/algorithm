package dp

class LeetCode_509 {

    private val dp = IntArray(31)

    /**
     * Solution - Dynamic Programming
     * Time Complexity : O(N)
     * Space Complexity : O(1)
     *
     * Classic dp problem.
     *
     * @param n
     * @return Fibonacci(n)
     */
    fun fib(n: Int): Int {
        return if (n < 2)
            n
        else if (dp[n] != 0)
            dp[n]
        else {
            dp[n] = fib(n - 1) + fib(n - 2)
            dp[n]
        }
    }
}

fun main() {
    val n = 2
    println(LeetCode_509().fib(n))
}
