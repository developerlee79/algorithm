package bit_manipulation

class LeetCode_2505 {

    fun subsequenceSumOr(nums: IntArray): Long {
        var currentSum = nums[0].toLong()
        var sumOfORSequence = nums[0].toLong()

        for (i in 1 until nums.size) {
            val currentValue = nums[i].toLong()
            currentSum += currentValue
            sumOfORSequence = sumOfORSequence.or(currentValue).or(currentSum)
        }

        return sumOfORSequence
    }
}

fun main() {
    // Input
    val nums = intArrayOf(2, 1, 0, 3)
    // Output
    LeetCode_2505().subsequenceSumOr(nums).run {
        println(this)
        require(7L == this)
    }
}
