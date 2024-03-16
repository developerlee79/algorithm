package array

class LeetCode_525 {

    fun findMaxLength(nums: IntArray): Int {
        val lengthMap = hashMapOf<Int, Int>()
        lengthMap[0] = -1

        var sum = 0
        var max = 0

        for (i in nums.indices) {
            sum += if (nums[i] == 0) -1 else 1

            if (!lengthMap.containsKey(sum)) {
                lengthMap[sum] = i
            }

            max = maxOf(max, i - lengthMap[sum]!!)

        }

        return max
    }
}

fun main() {
    // Input
    val nums = intArrayOf(0, 1)
    // Output
    LeetCode_525().findMaxLength(nums).run {
        println(this)
        require(2 == this)
    }
}
