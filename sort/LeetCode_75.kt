package sort

class LeetCode_75 {

    fun sortColors(nums: IntArray) {
        val n = nums.size

        var low = 0
        var middle = 0
        var high = n - 1

        while (middle <= high) {
            if (nums[middle] == 0) {
                swap(nums, low, middle)
                low++
                middle++
            } else if (nums[middle] == 1) {
                middle++
            } else {
                swap(nums, middle, high)
                high--
            }
        }
    }

    private fun swap(nums: IntArray, i: Int, j: Int) {
        val temp = nums[i]
        nums[i] = nums[j]
        nums[j] = temp
    }
}

fun main() {
    // Input
    val nums = intArrayOf(2, 0, 2, 1, 1, 0)
    // Output
    LeetCode_75().sortColors(nums)
    require(intArrayOf(0, 0, 1, 1, 2, 2).contentEquals(nums))
}
