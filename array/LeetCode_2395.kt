package array

class LeetCode_2395 {

    fun findSubarrays(nums: IntArray): Boolean {
        val sumSet = hashSetOf<Int>()

        for (i in 0 until nums.lastIndex) {
            if (!sumSet.add(nums[i] + nums[i + 1])) {
                return true
            }
        }

        return false
    }
}

fun main() {
    // Input
    val nums = intArrayOf(4, 2, 4)
    // Output
    LeetCode_2395().findSubarrays(nums).let {
        println(it)
        require(it)
    }
}
