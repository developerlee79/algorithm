package array

import java.util.*


class LeetCode_300 {

    /**
     * Solution - Binary Search
     * Time Complexity : O(logN)
     * Space Complexity : O(N)
     *
     * @param nums integer array
     * @return length of the longest strictly increasing subsequence
    */
    fun lengthOfLIS(nums: IntArray): Int {
        val list = mutableListOf<Int>()

        for (num in nums) {
            var pile = Collections.binarySearch(list, num)

            if (pile < 0) {
                pile = pile.inv()
            }

            if (pile == list.size) {
                list.add(num)
            } else {
                list[pile] = num
            }
        }

        return list.size
    }
}

fun main() {
    val nums = intArrayOf(10, 9, 2, 5, 3, 7, 101, 18)
    println(LeetCode_300().lengthOfLIS(nums))
}
