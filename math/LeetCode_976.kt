package math

class LeetCode_976 {

    /**
     * Time Complexity : O(NlogN)
     * Space Complexity : O(1)
     *
     * Use the properties of a triangle (the length of one side cannot be greater than or equal to the sum of the lengths of the other two sides).
     *
     * @param nums integer array
     * @return return the largest perimeter of a triangle with a non-zero area, formed from three of these lengths
    */
    fun largestPerimeter(nums: IntArray): Int {
        nums.sortDescending()
        val limit = nums.size - 2

        nums.forEachIndexed { index, _ ->
            if (index >= limit) {
                return@forEachIndexed
            }

            if (nums[index] < nums[index + 1] + nums[index + 2]) {
                return nums[index] + nums[index + 1] + nums[index + 2]
            }
        }

        return 0
    }
}

fun main() {
    // Input
    val nums = intArrayOf(1, 2, 1)
    // Output
    val result = LeetCode_976().largestPerimeter(nums)
    require(result == 0)
    println(result)
}
