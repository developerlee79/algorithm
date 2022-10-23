package array

class LeetCode_645 {

    /**
     * Time Complexity : O(N)
     * Space Complexity : O(1)
     *
     * @param nums set of integers
     * @return return the number that occurs twice and the number that is missing and return them in the form of an array.
     */
    fun findErrorNums(nums: IntArray): IntArray {
        var i = 0
        while (i in nums.indices) {
            val currentValue = nums[i] - 1

            if (nums[i] != nums[currentValue]) {
                swap(i, currentValue, nums)
            } else {
                i++
            }
        }

        for (j in nums.indices) {
            if (nums[j] != j + 1) {
                return intArrayOf(nums[j], j + 1)
            }
        }

        return intArrayOf()
    }

    private fun swap(i: Int, j: Int, nums: IntArray) {
        val temp = nums[i]
        nums[i] = nums[j]
        nums[j] = temp
    }
}

fun main() {
    // Input
    val nums = intArrayOf(1, 2, 2, 4)
    // Output
    val result = LeetCode_645().findErrorNums(nums)
    println(result.joinToString())
    require(
        intArrayOf(2, 3).contentEquals(result)
    )
}
