package array

class LeetCode_238 {

    fun productExceptSelf(nums: IntArray): IntArray {
        val n = nums.size

        var leftProduct = 1
        var rightProduct = 1

        val result = IntArray(n) { 1 }

        var i = 1
        var j = n - 2

        while (i < n) {
            leftProduct *= nums[i - 1]
            rightProduct *= nums[j + 1]
            result[i] *= leftProduct
            result[j] *= rightProduct
            i++
            j--
        }

        return result
    }
}

fun main() {
    // Input
    val nums = intArrayOf(1, 2, 3, 4)
    // Output
    LeetCode_238().productExceptSelf(nums).run {
        println(this)
        require(
            intArrayOf(24, 12, 8, 6).contentEquals(this)
        )
    }
}
