package math

class LeetCode_326 {

    /**
     * Solution - Recursive
     * Time Complexity : O(logN)
     * Space Complexity : O(1)
     *
     * Simple recursive.
     *
     * @param n integer
     * @return true if it is a power of three. Otherwise, return false.
    */
    fun isPowerOfThree(n: Int): Boolean {
        return if (n == 0) {
            false
        } else if (n == 1) {
            true
        } else if (n % 3 != 0) {
            false
        } else {
            isPowerOfThree(n / 3)
        }
    }
}

fun main() {
    val n = 27
    println(LeetCode_326().isPowerOfThree(n))
}
