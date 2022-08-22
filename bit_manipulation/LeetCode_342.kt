package bit_manipulation

class LeetCode_342 {

    /**
     * Solution - Bit Manipulation
     * Time Complexity : O(1)
     * Space Complexity : O(1)
     *
     * Use n and n-1 == 0 to determine if n is power of 2.
     * For power of 4, the binary format is 1 for only the first odd digit and 0 for the rest.
     * Determine all digits with and( 0x55 ) (0101 0101).
     *
     * @param n integer
     * @return true if it is a power of four. Otherwise, false.
     */
    fun isPowerOfFour(n: Int): Boolean {
        return n > 0 && n.and(n - 1) == 0 && n.and(0x55555555) != 0
    }
}

fun main() {
    val n = 16
    println(LeetCode_342().isPowerOfFour(n))
}
