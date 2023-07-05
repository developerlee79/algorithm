package dp

class LeetCode_1493 {

    fun longestSubarray(nums: IntArray): Int {
        val n = nums.size

        var i = 0

        while (i < n && nums[i] == 0) {
            i++
        }

        var maxLength = 0
        var lastSize = 0

        while (i < n) {
            var currentSize = 0

            while (i < n && nums[i] == 1) {
                currentSize++
                i++
            }

            maxLength = maxOf(maxLength, lastSize + currentSize)

            if (i + 1 < n && nums[i + 1] == 0) {
                lastSize = 0

                while (i < n && nums[i] == 0) {
                    i++
                }
            } else {
                lastSize = currentSize
                i++
            }
        }

        return minOf(maxLength, n - 1)
    }
}

fun main() {
    // Input
    val nums = intArrayOf(1, 1, 0, 1)
    // Output
    LeetCode_1493().longestSubarray(nums).run {
        println(this)
        require(3 == this)
    }
}
