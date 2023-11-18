package array

class LeetCode_1838 {

    fun maxFrequency(nums: IntArray, k: Int): Int {
        nums.sort()

        val n = nums.size

        val differences = LongArray(n)
        val prefixSum = LongArray(n)

        for (i in 1 until n) {
            differences[i] = (nums[i] - nums[i - 1]).toLong()
            prefixSum[i] = prefixSum[i - 1] + differences[i]
        }

        var low = 1
        var high = n

        while (low < high) {
            val mid = (high - low + 1) / 2 + low

            if (frequency(nums, differences, prefixSum, mid, k)) {
                low = mid
            } else {
                high = mid - 1
            }
        }

        return low
    }

    private fun frequency(nums: IntArray, difference: LongArray, prefixSum: LongArray, frequency: Int, k: Int): Boolean {
        var appear = 0L

        for (i in 0 until frequency - 1) {
            appear += nums[frequency - 1] - nums[i]
        }

        var minAppear = appear

        for (i in frequency until nums.size) {
            appear -= prefixSum[i - 1] - prefixSum[i - frequency]
            appear += difference[i] * (frequency - 1)
            minAppear = minOf(minAppear, appear)
        }

        return minAppear <= k
    }

}

fun main() {
    // Input
    val nums = intArrayOf(1, 2, 4)
    val k = 5
    // Output
    LeetCode_1838().maxFrequency(nums, k).run {
        println(this)
        require(3 == this)
    }
}
