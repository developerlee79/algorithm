package math

class LeetCode_1814 {

    fun countNicePairs(nums: IntArray): Int {
        val reverseMap = HashMap<Int, Int>()
        var nicePair = 0

        for (i in nums.indices) {
            val reversedNum = nums[i] - findReversed(nums[i])

            if (reverseMap.containsKey(reversedNum)) {
                val currentCount = reverseMap[reversedNum]!!
                nicePair = (nicePair + currentCount) % 1000000007
            }

            reverseMap.merge(reversedNum, 1) { a, b -> a + b }
        }

        return nicePair
    }

    private fun findReversed(target: Int): Int {
        var reversedInt = 0

        var target = target

        while (target > 0) {
            reversedInt = reversedInt * 10 + target % 10
            target /= 10
        }

        return reversedInt
    }
}

fun main() {
    // Input
    val nums = intArrayOf(42, 11, 1, 97)
    // Output
    LeetCode_1814().countNicePairs(nums).run {
        println(this)
        require(2 == this)
    }
}
