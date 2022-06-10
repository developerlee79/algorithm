package array

class LeetCode_2155 {

    /**
     * Solution - Prefix Sum Array
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     *
     * Solve the problem with prefix sum array.
     * Initialize result array with value (index) 0. (because there's always 0 index in first place)
     * So loop has to be started from index 1.
     * Use two int value to represent max score and current score.
     * The current score refers to the score in the left array. (cause 0 index already means that only the right array exists)
     * If nums[i - 1] == 0, it means that the score in the left array has increased - so increase the current score.
     * If nums[i - 1] == 1, it means that the score in the right array has increased - so decrease the current score.
     * And compare max score with current score.
     * If current score is bigger than max, it means there's no bigger score in result array - so initialize result array with current index.
     * If current score is equal to the max score, it means current score is one of the highest score - so add current index in result array.
     *
     * @param nums 0-indexed binary array
     * @return all distinct indices that have the highest possible division score
     */
    fun maxScoreIndices(nums: IntArray): List<Int> {
        var resultList: MutableList<Int> = mutableListOf(0)
        var maxScore = 0
        var currentScore = 0

        for (i in 1..nums.size) {
            currentScore = if (nums[i - 1] == 0) currentScore + 1 else currentScore - 1

            if (currentScore > maxScore) {
                maxScore = currentScore
                resultList = mutableListOf(i)
            } else if (currentScore == maxScore) {
                resultList.add(i)
            }
        }

        return resultList
    }
}

fun main() {
    val nums = intArrayOf(1, 1)
    println(LeetCode_2155().maxScoreIndices(nums).joinToString())
}
