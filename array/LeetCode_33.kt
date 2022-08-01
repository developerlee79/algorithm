package array

class LeetCode_33 {

    /**
     * Solution - Binary Search
     * Time Complexity : O(logN)
     * Space Complexity : O(1)
     *
     * A given array can be divided into two arrays: the rotated array and the original ordered array.
     * But we don't know the boundaries, so we check which "side" the current pointer points to.
     * Implement binary search by comparing the values at both ends of the array with the median and target to see if there is a target within the interval.
     *
     * @param nums of this Function
     * @param target of this Function
     * @return Return Value Of This Function
    */
    fun search(nums: IntArray, target: Int): Int {
        if (nums.isEmpty()) {
            return -1
        }

        var left = 0
        var right = nums.size - 1

        while (left < right) {
            val middle = (left + right) / 2

            if (nums[middle] == target) {
                return middle
            } else if ((nums[middle] >= nums[0]) != (target >= nums[0])) {
                if (nums[0] <= target) {
                    right = middle
                } else {
                    left = middle + 1
                }
            } else {
                if (nums[middle] < target) {
                    left = middle + 1
                } else {
                    right = middle
                }
            }
        }

        return if (nums[left] == target) {
            left
        } else {
            -1
        }
    }
}

fun main() {
    val nums = intArrayOf(4, 5, 6, 7, 0, 1, 2)
    val target = 0
    println(LeetCode_33().search(nums, target))
}
