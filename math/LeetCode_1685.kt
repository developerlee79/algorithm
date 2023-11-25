package math

class LeetCode_1685 {

    fun getSumAbsoluteDifferences(nums: IntArray): IntArray {
        val n = nums.size

        val prefixSum = getPrefixSum(nums)
        val suffixSum = getSuffixSum(nums)

        val differences = IntArray(n)

        for (i in nums.indices) {
            val prefix = nums[i] * i - prefixSum[i]
            val suffix = suffixSum[i] - nums[i] * (n - i - 1)
            differences[i] = prefix + suffix
        }

        return differences
    }

    private fun getPrefixSum(nums: IntArray): IntArray {
        val prefixSum = IntArray(nums.size)

        var sum = 0
        for (i in prefixSum.indices) {
            prefixSum[i] = sum
            sum += nums[i]
        }

        return prefixSum
    }

    private fun getSuffixSum(nums: IntArray): IntArray {
        val suffixSum = IntArray(nums.size)

        var sum = 0
        for (i in suffixSum.indices.reversed()) {
            suffixSum[i] = sum
            sum += nums[i]
        }

        return suffixSum
    }

}

fun main() {
    // Input
    val nums = intArrayOf(2, 3, 5)
    // Output
    LeetCode_1685().getSumAbsoluteDifferences(nums).run {
        println(this.joinToString())
        require(
            intArrayOf(4, 3, 5).contentEquals(this)
        )
    }
}
