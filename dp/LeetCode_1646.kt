package dp

import kotlin.math.max

class LeetCode_1646 {

    /**
     * Solution - Dynamic Programming
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     *
     * Generating array
     *
     * @param n integer
     * @return maximum integer in the array nums
     */
    fun getMaximumGenerated(n: Int): Int {
        if (n == 0) {
            return 0
        }

        val array = IntArray(n + 1)
        array[0] = 0
        array[1] = 1

        var max = 1

        for (i in 2 .. n) {
            array[i] = array[i / 2]

            if (i % 2 != 0) {
                array[i] += array[i / 2 + 1]
            }

            max = max(max, array[i])
        }

        return max
    }
}

fun main() {
    val n = 7
    println(LeetCode_1646().getMaximumGenerated(n))
}
