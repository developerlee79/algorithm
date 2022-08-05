package math

class LeetCode_1025 {

    /**
     * Solution - Math
     * Time Complexity : O(1)
     * Space Complexity : O(1)
     *
     * If N is even, can win.
     * If N is odd, will lose.
     *
     * @param n number on the chalkboard
     * @return Return true if and only if Alice wins the game, assuming both players play optimally.
     */
    fun divisorGame(n: Int): Boolean {
        return n % 2 == 0
    }
}

fun main() {
    val n = 2
    println(LeetCode_1025().divisorGame(n))
}
