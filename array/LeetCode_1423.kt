package array

import kotlin.math.max

class LeetCode_1423 {

    /**
     * Solution - Sliding Window
     * Time Complexity : O(N)
     * Space Complexity : O(1)
     *
     * @param cardPoints integer array
     * @param k integer
     * @return maximum score you can obtain
    */
    fun maxScore(cardPoints: IntArray, k: Int): Int {
        val n = cardPoints.size
        var sum = 0

        for (i in 0 until k) {
            sum += cardPoints[i]
        }

        var max = sum
        for (i in 0 until k) {
            sum = sum - cardPoints[k - i - 1] + cardPoints[n - i - 1]
            max = max(max, sum)
        }

        return max
    }
}

fun main() {
    val cardPoints = intArrayOf(1, 2, 3, 4, 5, 6, 1)
    val k = 3
    println(LeetCode_1423().maxScore(cardPoints, k))
}
