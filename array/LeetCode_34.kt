package array

class LeetCode_34 {

    /**
     * Solution - Binary Search
     * Time Complexity : O(logN)
     * Space Complexity : O(1)
     *
     * Simple binary search.
     * Binary search until the target value is found.
     * Then, simply iterate until value == target.
     *
     * @param nums array of integers sorted in non-decreasing order
     * @param target integer
     * @return starting and ending position of a target
     */
    fun searchRange(nums: IntArray, target: Int): IntArray {
        if (nums.isEmpty()) {
            return intArrayOf(-1, -1)
        }

        var left = 0
        var right = nums.size - 1

        while (left <= right) {
            val middle = (right + left) / 2

            if (nums[middle] == target) {
                var middleLeft = middle
                while (middleLeft >= 0 && nums[middleLeft] == target) {
                    middleLeft--
                }

                var middleRight = middle
                while (middleRight < nums.size && nums[middleRight] == target) {
                    middleRight++
                }

                return intArrayOf(middleLeft + 1, middleRight - 1)
            } else if (nums[middle] > target) {
                right = middle - 1
            } else {
                left = middle + 1
            }
        }

        return intArrayOf(-1, -1)
    }
}

fun main() {
    val nums = intArrayOf(2, 2)
    val target = 3
    println(LeetCode_34().searchRange(nums, target).joinToString())
}
