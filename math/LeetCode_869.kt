package math

class LeetCode_869 {

    /**
     * Solution - Counting
     * Time Complexity : O(1)
     * Space Complexity : O(1)
     *
     * @param n integer
     * @return Return true if and only if we can do this so that the resulting number is a power of two.
     */
    fun reorderedPowerOf2(n: Int): Boolean {
        if (n == 1) {
            return true
        }

        val digitCount: IntArray = countDigits(n)

        for (i in 0 until 29) {
            val powDigitCount: IntArray = countDigits(2 shl i)
            if (digitCount.contentEquals(powDigitCount)) {
                return true
            }
        }

        return false
    }

    private fun countDigits(n: Int): IntArray {
        val digitCount = IntArray(10)

        var num = n
        while (num > 0) {
            digitCount[num.mod(10)]++
            num /= 10
        }

        return digitCount
    }
}

fun main() {

}
