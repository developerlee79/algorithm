package two_pointers


class LeetCode_1885 {

    fun countPairs(nums1: IntArray, nums2: IntArray): Long {
        val n = nums1.size

        val diff = IntArray(n)

        for (i in nums1.indices) {
            diff[i] = nums1[i] - nums2[i]
        }

        diff.sort()

        var count: Long = 0

        var low = 0
        var high = n - 1

        while (low < high) {
            val sum = diff[low] + diff[high]

            if (sum > 0) {
                count += high - low
                high--
            } else {
                low++
            }
        }

        return count
    }
}

fun main() {
    // Input
    val nums1 = intArrayOf(2, 1, 2, 1)
    val nums2 = intArrayOf(1, 2, 1, 2)
    // Output
    LeetCode_1885().countPairs(nums1, nums2).run {
        println(this)
        require(1L == this)
    }
}
