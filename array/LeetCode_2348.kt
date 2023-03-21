package array

class LeetCode_2348 {

    fun zeroFilledSubarray(nums: IntArray): Long {
        var numberOfZero = 0
        var subArrayCount: Long = 0

        nums.forEach {
            if (it == 0) {
                numberOfZero++
                subArrayCount += numberOfZero
            } else {
                numberOfZero = 0
            }
        }

        return subArrayCount
    }
}

fun main() {
    // Input
    val nums = intArrayOf(1, 3, 0, 0, 2, 0, 0, 4)
    // Output
    LeetCode_2348().zeroFilledSubarray(nums).let {
        println(it)
        require(it == 6L)
    }
}
