package array

class LeetCode_334 {

    /**
     * Time Complexity : O(N)
     * Space Complexity : O(1)
     *
     * @param nums integer array
     * @return return true if there exists a triple of indices (i, j, k) such that i < j < k and nums[i] < nums[j] < nums[k]
    */
    fun increasingTriplet(nums: IntArray): Boolean {
        var i = Integer.MAX_VALUE
        var j = Integer.MAX_VALUE

        nums.forEach {
            if (it <= i) i = it
            else if (it <= j) j = it
            else return true
        }

        return false
    }
}

fun main() {
    // Input
    val nums = intArrayOf(2, 1, 5, 2, 0, 4, 3, 8)
    // Output
    val result = LeetCode_334().increasingTriplet(nums)
    require(result)
    println(result)
}
