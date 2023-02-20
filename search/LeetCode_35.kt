package search

class LeetCode_35 {

    fun searchInsert(nums: IntArray, target: Int): Int {
        var low = 0
        var high = nums.lastIndex

        while (low <= high) {
            val middle = (low + high) / 2

            if (nums[middle] == target) {
                return middle
            } else if (nums[middle] > target) {
                high = middle - 1
            } else {
                low = middle + 1
            }
        }

        return low
    }
}

fun main() {
    // Input
    val nums = intArrayOf(1, 3, 5, 6)
    val target = 5
    // Output
    LeetCode_35().searchInsert(nums, target).let {
        println(it)
        require(it == 2)
    }
}
