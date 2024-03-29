package array

class LeetCode_2962 {

    fun countSubarrays(nums: IntArray, k: Int): Long {
        val n = nums.size

        val maxValue = nums.maxOf { it }

        var totalCount = 0L

        var i = 0
        var j = 0
        var count = 0

        while (j < n) {
            if (nums[j] == maxValue) {
                count++
            }

            if (count >= k) {
                while (count >= k) {
                    totalCount += n - j

                    if (nums[i] == maxValue) {
                        count--
                    }

                    i++
                }
            }

            j++
        }

        return totalCount
    }
}

fun main() {
    // Input
    val nums = intArrayOf(1, 3, 2, 3, 3)
    val k = 2
    // Output
    LeetCode_2962().countSubarrays(nums, k).run {
        println(this)
        require(6L == this)
    }
}
