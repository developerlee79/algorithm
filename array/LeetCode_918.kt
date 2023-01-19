package array

class LeetCode_918 {

    private fun IntArray.kadaneMaxSum(): Int {
        if (this.isEmpty()) {
            return 0
        }

        var currentSum = this.first()
        var maxSum = this.first()

        for (i in 1 until this.size) {
            if (currentSum < 0) currentSum = 0
            currentSum += this[i]
            maxSum = maxOf(maxSum, currentSum)
        }

        return maxSum
    }

    fun maxSubarraySumCircular(nums: IntArray): Int {
        val nonCircledSum = nums.kadaneMaxSum()

        var sumOfNums = 0

        nums.forEachIndexed { index, num ->
            sumOfNums += num
            nums[index] = num.unaryMinus()
        }

        val circledSum = sumOfNums + nums.kadaneMaxSum()

        return if (circledSum == 0) {
            nonCircledSum
        } else {
            maxOf(nonCircledSum, circledSum)
        }
    }

}

fun main() {
    // Input
    val nums = intArrayOf(3, -2, 2, -3)
    // Output
    LeetCode_918().maxSubarraySumCircular(nums).let {
        println(it)
        require(it == 3)
    }
}
