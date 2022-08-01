package dp

class LeeCode_376 {

    /**
     * Solution - Dynamic Programming
     * Time Complexity : O(N)
     * Space Complexity : O(1)
     *
     * Use Dp to solve the problem.
     * Upside means nums[i] > nums[i - 1]
     * Downside means nums[i] < nums[i - 1]
     * So, we can use pointer up & down to memory the longest wiggle subsequence.
     *
     * @param nums integer array
     * @return length of the longest *wiggle subsequence of nums
     *     * wiggle subsequence : sequence where the differences between successive numbers strictly alternate between positive and negative
     */
    fun wiggleMaxLength(nums: IntArray): Int {
        if (nums.isEmpty()) {
            return 0
        }

        var up = 1
        var down = 1

        for (i in 1 until nums.size) {
            if (nums[i] < nums[i - 1])
                down = up + 1
            else if (nums[i] > nums[i - 1])
                up = down + 1
        }

        return up.coerceAtLeast(down)
    }
}

fun main() {
    val nums = intArrayOf(1, 17, 5, 10, 13, 15, 5, 16, 8)
    println(LeeCode_376().wiggleMaxLength(nums))
}
