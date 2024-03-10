package array

class LeetCode_349 {

    fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
        val numSet = hashSetOf<Int>()

        nums2.sort()

        nums1.forEach { num ->
            if (isContains(nums2, num)) {
                numSet.add(num)
            }
        }

        return numSet.toIntArray()
    }

    private fun isContains(nums: IntArray, target: Int): Boolean {
        var low = 0
        var high = nums.lastIndex

        while (low <= high) {
            val mid = low + (high - low) / 2

            if (nums[mid] == target) {
                return true
            } else if (nums[mid] > target) {
                high = mid - 1
            } else {
                low = mid + 1
            }
        }

        return false
    }
}

fun main() {
    // Input
    val nums1 = intArrayOf(1, 2, 2, 1)
    val nums2 = intArrayOf(2, 2)
    // Output
    LeetCode_349().intersection(nums1, nums2).run {
        println(this.joinToString())
        require(
            intArrayOf(2).contentEquals(this)
        )
    }
}
