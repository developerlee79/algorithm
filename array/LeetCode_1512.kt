package array

class LeetCode_1512 {

    fun numIdenticalPairs(nums: IntArray): Int {
        var count = 0

        for (i in nums.indices) {
            for (j in i + 1 until nums.size) {
                if (nums[i] == nums[j]) {
                    count++
                }
            }
        }

        return count
    }
}

fun main() {
    // Input
    val nums = intArrayOf(1, 2, 3, 1, 1, 3)
    // Output
    LeetCode_1512().numIdenticalPairs(nums).run {
        println(this)
        require(4 == this)
    }
}
