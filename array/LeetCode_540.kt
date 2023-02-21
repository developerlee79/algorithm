package array

class LeetCode_540 {

    fun singleNonDuplicate(nums: IntArray): Int {
        var i = 0

        while (i + 1 < nums.size) {
            if (nums[i] != nums[i + 1]) {
                return nums[i]
            }
            i += 2
        }

        return nums.last()
    }
}

fun main() {
    // Input
    val nums = intArrayOf(1, 1, 2, 3, 3, 4, 4, 8, 8)
    // Output
    LeetCode_540().singleNonDuplicate(nums).let {
        println(it)
        require(it == 2)
    }
}
