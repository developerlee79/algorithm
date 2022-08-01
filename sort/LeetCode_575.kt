package sort

import kotlin.math.min

class LeetCode_575 {

    /**
     * Solution - Just.. Compare?
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     *
     * easy peasy!
     *
     * @param candyType integer array what representing type of candies
     * @return maximum number of different types of candies alice can eat if she only eats n / 2 of them
    */
    fun distributeCandies(candyType: IntArray): Int {
        return min(candyType.size / 2, candyType.toSet().size)
    }
}

fun main() {
    val candyType = intArrayOf(1, 1, 2, 2, 3, 3)
    println(LeetCode_575().distributeCandies(candyType))
}
