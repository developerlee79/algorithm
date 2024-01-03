package dp

class LeetCode_486 {

    fun predictTheWinner(nums: IntArray): Boolean {
        return findWinner(0, 0, nums, 0, nums.lastIndex, true)
    }

    private fun findWinner(score1: Int, score2: Int, nums: IntArray, start: Int, end: Int, isPlayerOne: Boolean): Boolean {
        if (start > end) {
            return score1 >= score2
        }

        return if (isPlayerOne) {
            findWinner(score1 + nums[start], score2, nums, start + 1, end, false) ||
            findWinner(score1 + nums[end], score2, nums, start, end - 1, false)
        } else {
            findWinner(score1, score2 + nums[start], nums, start + 1, end, true) &&
            findWinner(score1, score2 + nums[end], nums, start, end - 1, true)
        }
    }
}

fun main() {
    // Input
    val nums = intArrayOf(1, 5, 2)
    // Output
    LeetCode_486().predictTheWinner(nums).run {
        println(this)
        require(!this)
    }
}
