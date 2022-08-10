package array

class LeetCode_219 {

    /**
     * Solution - Sliding Window
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     *
     * Use K size sliding window to solve the problem.
     * abs(i , j) must be smaller than k.
     * So, when i > k, we have to remove smaller index from k.
     * Because when i > k, abs(i - j) always bigger than k.
     *
     * @param nums integer array
     * @param k integer
     * @return return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k
    */
    fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
        val set = HashSet<Int>()

        for (i in nums.indices) {
            if (i > k) {
                set.remove(nums[i - k - 1])
            }
            if (!set.add(nums[i])) {
                return true
            }
        }

        return false
    }
}

fun main() {
    val nums = intArrayOf(1, 2, 3, 1)
    val k = 3
    println(LeetCode_219().containsNearbyDuplicate(nums, k))
}
