package array

class LeetCode_930 {

    fun numSubarraysWithSum(nums: IntArray, goal: Int): Int {
        val prefixMap = mutableMapOf<Int, Int>()
        prefixMap[0] = 1

        var count = 0
        var prefix = 0

        nums.forEach { num ->
            prefix += num
            count += prefixMap[prefix - goal] ?: 0
            prefixMap[prefix] = (prefixMap[prefix] ?: 0) + 1
        }

        return count
    }
}

fun main() {
    // Input
    val nums = intArrayOf(1, 0, 1, 0, 1)
    val goal = 2
    // Output
    LeetCode_930().numSubarraysWithSum(nums, goal).run {
        println(this)
        require(4 == this)
    }
}
