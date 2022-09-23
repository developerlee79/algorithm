package bit_manipulation

class LeetCode_1680 {

    /**
     * Problem : Concatenation of Consecutive Binary Numbers (1680)
     * Time Complexity : O(N)
     * Space Complexity : O(1)
     *
     * When i increases, the binary digits of the result value has to be shift left by binary digits of i and add i to result.
     * Compare the length of binary digits of i - 1 with i to calculate the binary digits of result value has to be shift left.
     *
     * @param n integer
     * @return return the decimal value of the binary string formed by concatenating the binary representations of 1 to n in order, mod 10^9 + 7
    */
    fun concatenatedBinary(n: Int): Int {
        val mod = 1000000007

        var binary: Long = 0
        var binaryDigit = 0
        for (i in 1..n) {
            if (i.and(i - 1) == 0) {
                binaryDigit++
            }
            binary = (binary.shl(binaryDigit) + i) % mod
        }

        return binary.toInt()
    }
}

fun main() {
    // Input
    val n = 12
    // Output
    val result = LeetCode_1680().concatenatedBinary(n)
    assert(505379714 == result)
    println(result)
}
