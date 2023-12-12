package array

class LeetCode_1464 {

    fun maxProduct(nums: IntArray): Int {
        var maxValue = 0
        var secondMaxValue = 0

        for (num in nums) {
            if (num >= maxValue) {
                secondMaxValue = maxValue
                maxValue = num
            } else {
                secondMaxValue = maxOf(secondMaxValue, num)
            }
        }

        return (maxValue - 1) * (secondMaxValue - 1)
    }
}

fun main() {
    // Input
    val nums = intArrayOf(3, 4, 5, 2)
    // Output
    LeetCode_1464().maxProduct(nums).run {
        println(this)
        require(12 == this)
    }
}
