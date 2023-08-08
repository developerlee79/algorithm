package search

class LeetCode_33 {

    fun search(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.lastIndex

        while (left <= right) {
            val middle = (left + right) / 2
            val currentValue = nums[middle]

            if (currentValue == target) {
                return middle
            } else if (currentValue >= nums[left]) {
                if (target in nums[left] until currentValue) {
                    right = middle - 1
                } else {
                    left = middle + 1
                }
            } else {
                if (target in currentValue + 1  .. nums[right]) {
                    left = middle + 1
                } else {
                    right = middle - 1
                }
            }
        }

        return -1
    }
}

fun main() {
    // Input
    val nums = intArrayOf(4, 5, 6, 7, 0, 1, 2)
    val target = 0
    // Output
    LeetCode_33().search(nums, target).run {
        println(this)
        require(4 == this)
    }
}
