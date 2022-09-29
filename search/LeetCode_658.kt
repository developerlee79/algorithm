package search

import kotlin.math.abs

class LeetCode_658 {

    /**
     * Solution : Binary Search
     * Time Complexity : O(N)
     * Space Complexity : O(1)
     *
     * Start with 0 <-> arr.lastIndex size window.
     * Until window.size == k, compare each edge and reduce bigger edge.
     *
     * @param arr sorted integer array
     * @param k integer representing length of return array
     * @param x target integer
     * @return return the k closest integers to x in the array
    */
    fun findClosestElements(arr: IntArray, k: Int, x: Int): List<Int> {
        if (arr.size == k) {
            return arr.toList()
        } else if (arr.first() >= x) {
            return arr.take(k)
        } else if (arr.last() <= x) {
            return arr.takeLast(k)
        }

        var leftIndex = 0
        var rightIndex = arr.lastIndex

        while (rightIndex - leftIndex >= k) {
            if (abs(arr[leftIndex] - x) > abs(arr[rightIndex] - x)) {
                leftIndex++
            } else {
                rightIndex--
            }
        }

        return arr.copyOfRange(leftIndex, rightIndex + 1).toList()
    }
}

fun main() {
    // given
    val arr = intArrayOf(1, 2, 3, 4, 5)
    val k = 4
    val x = 3
    // when
    val result = LeetCode_658().findClosestElements(arr, k, x)
    // then
    println(result)
    assert(listOf(1, 2, 3, 4) == result)
}
