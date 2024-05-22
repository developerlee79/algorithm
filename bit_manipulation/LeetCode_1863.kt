package bit_manipulation

class LeetCode_1863 {

    fun subsetXORSum(nums: IntArray): Int {
        return getSubSetXOR(nums, 0, 0)
    }

    private fun getSubSetXOR(nums: IntArray, index: Int, currentValue: Int): Int {
        if (index == nums.size) {
            return currentValue
        }

        val xorSubSet = getSubSetXOR(nums, index + 1, currentValue xor nums[index])
        val subSet = getSubSetXOR(nums, index + 1, currentValue)

        return xorSubSet + subSet
    }
}

fun main() {
    // Input
    val nums = intArrayOf(1, 3)
    // Output
    LeetCode_1863().subsetXORSum(nums).run {
        println(this)
        require(6 == this)
    }
}
