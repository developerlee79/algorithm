package sort

import kotlin.math.max


class LeetCode_135 {

    /**
     * Solution - Greedy
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     *
     * Use greedy solution with two array to solve the problem.
     * There are 2 requirements to giving candies to children.
     *
     * 1. Every child must have at least one candy.
     * 2. Children with a higher rating get more candies than their neighbors.
     *
     * At first, initialize array which fill with 1. (Rule 1)
     * Then, iterate all array and add candy if index is bigger than previous. (Rule 2)
     * So far, the Candies array has only increased if the right child is ranked higher. Now calculate when the child on the left is higher.
     * Calculates by moving forward from the last element of the array.
     * Because we only considered the right element, the last element of the array is always a properly calculated value.
     * If the child on the left ranks higher, the number of candies that child will receive will be higher between the current number of candies (i.e., the number calculated considering only the right factor) and the right number (the number of candies that child lower neighbor has +1).
     * Returns the sum of all candies.
     *
     * @param ratings integer array which represent rating
     * @return minimum number of candies you need to have to distribute the candies to the children
     */
    fun candy(ratings: IntArray): Int {
        val len = ratings.size
        val candies = IntArray(len) { 1 }

        for (i in 1 until ratings.size) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1
            }
        }

        var sum = candies[len - 1]
        for (i in len - 2 downTo 0) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = max(candies[i], candies[i + 1] + 1)
            }
            sum += candies[i]
        }

        return sum
    }
}

fun main() {
    val ratings = intArrayOf(1, 3, 2, 2, 1)
    println(LeetCode_135().candy(ratings))
}