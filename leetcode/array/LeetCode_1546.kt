package array


class LeetCode_1546 {

    /**
     * Solution - Greedy
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     *
     * Use prefix map to solve the problem.
     * Find the subarray with target sum ending with i and calculate greedily and update index to i.
     * Save all the sums seen so far in hashmap with key = sum, value = end index of subarray with that sum.
     *
     * @param nums of this Function
     * @param target of this Function
     * @return Return Value Of This Function
    */
    fun maxNonOverlapping(nums: IntArray, target: Int): Int {
        val sumMap: MutableMap<Int, Int> = HashMap()
        sumMap[0] = -1

        var prefixSum = 0
        var index = -1

        var count = 0
        for (i in nums.indices) {
            prefixSum += nums[i]
            val remain = prefixSum - target
            if (sumMap.contains(remain) && sumMap[remain]!! >= index) {
                count++
                index = i
            }
            sumMap[prefixSum] = i
        }
        return count
    }
}

fun main() {
    val nums = intArrayOf(1, 1, 1, 1, 1)
    val target = 2
    println(LeetCode_1546().maxNonOverlapping(nums, target))
}
