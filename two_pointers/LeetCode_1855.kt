package two_pointers

class LeetCode_1855 {

    fun maxDistance(nums1: IntArray, nums2: IntArray): Int {
        var maxInterval = 0

        nums1.forEachIndexed { index, num ->
            if (index !in nums2.indices) {
                return maxInterval
            }
            if (nums2[index] < num) {
                return@forEachIndexed
            }
            maxInterval = maxOf(maxInterval, findMaximumDistance(num, index, nums2))
        }

        return maxInterval
    }

    private fun findMaximumDistance(target: Int, targetIndex: Int, nums: IntArray): Int {
        var row = targetIndex
        var high = nums.lastIndex

        var maxDistance = 0

        while (row <= high) {
            val middle = (row + high) / 2

            if (target <= nums[middle]) {
                maxDistance = maxOf(maxDistance, middle - targetIndex)
                row = middle + 1
            } else {
                high = middle - 1
            }
        }

        return maxDistance
    }
}

fun main() {
    // Input
    val nums1 = intArrayOf(55, 30, 5, 4, 2)
    val nums2 = intArrayOf(100, 20, 10, 10, 5)
    // Output
    LeetCode_1855().maxDistance(nums1, nums2).let {
        println(it)
        require(it == 2)
    }
}
