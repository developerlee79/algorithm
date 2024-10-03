package array

class LeetCode_1590 {

    fun minSubarray(nums: IntArray, p: Int): Int {
        val n = nums.size

        var totalSum = 0L

        nums.forEach { num -> totalSum += num }

        val remainder = (totalSum % p).toInt()

        if (remainder == 0) {
            return 0
        }

        val prefixMod = hashMapOf<Int, Int>()
        prefixMod[0] = -1

        var prefixSum = 0L
        var minLength = n

        for (i in nums.indices) {
            prefixSum += nums[i]

            val currentMod = (prefixSum % p).toInt()
            val targetMod = (currentMod - remainder + p) % p

            if (prefixMod.containsKey(targetMod)) {
                minLength = minOf(minLength, i - prefixMod[targetMod]!!)
            }

            prefixMod[currentMod] = i
        }

        return if (minLength == n) -1 else minLength
    }
}

fun main() {
    // Input
    val nums = intArrayOf(3, 1, 4, 2)
    val p = 6
    // Output
    LeetCode_1590().minSubarray(nums, p).run {
        println(this)
        require(1 == this)
    }
}
