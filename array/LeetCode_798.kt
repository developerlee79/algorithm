package array

class LeetCode_798 {

    /**
     * Solution - Memorization
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     *
     * Memory all index which bigger or equal than num in array at just Kth rotation.
     * Largest index row = (index + 1) % len
     * Row in which index == number = (index + len - num) % len
     *
     *
     * @param nums integer array
     * @return the rotation index k that corresponds to the highest score we can achieve if we rotated nums by it
     */
    fun bestRotation(nums: IntArray): Int {
        val length = nums.size
        val scores = IntArray(length)

        for (i in scores.indices) {
            scores[(i + 1) % length]++
            scores[(i - (nums[i] - 1) + length) % length]--

            if (i >= nums[i]) {
                scores[0]++
            }
        }

        var maxScore = scores[0]
        var result = 0
        for (i in 1 until length) {
            scores[i] += scores[i - 1]

            if (scores[i] > maxScore) {
                maxScore = scores[i]
                result = i
            }
        }

        return result
    }
}

fun main() {
    val nums = intArrayOf(2, 3, 1, 4, 0)
    println(LeetCode_798().bestRotation(nums))
}
