package sort

class LeetCode_665 {

    /**
     * Solution - Greedy
     * Time Complexity : O(N)
     * Space Complexity : O(1)
     *
     * In this problem, we can use the Greedy algorithm because this problem requires only one mismatch to find.
     * If arr[i - 1] is greater than arr[i], it means an array that decreases.
     * Since the array up to i was an increasing array with at least two elements, we can choose between i - 2 and i - 1, i.e., one of the two elements just before i and change it to an increasing array.
     * If arr[i - 2] <= i, then arr[i - 2] <= arr[i] < arr[i - 1], so change arr[i - 1] to arr[i] to set increasing array.
     * If arr[i - 2] > i, then arr[i] < arr[i - 2] < arr[i - 1], so change arr[i] to arr[i - 1] to set increasing array.
     * You can make changes only once, so return false the next time you meet a decreasing array.
     *
     * @param nums integer array
     * @return is it could become non-decreasing by modifying at most one element
     */
    fun checkPossibility(nums: IntArray): Boolean {
        var isModified = false

        for (i in 1 until nums.size) {
            if (nums[i - 1] > nums[i]) {
                if (isModified) {
                    return false
                }

                isModified = true

                if (i == 1 || nums[i - 2] <= nums[i]) {
                    nums[i - 1] = nums[i]
                } else {
                    nums[i] = nums[i - 1]
                }
            }
        }

        return true
    }
}

fun main() {
    val nums = intArrayOf(4, 2, 3)
    println(LeetCode_665().checkPossibility(nums))
}
