package sort

class LeetCode_922 {

    fun sortArrayByParityII(nums: IntArray): IntArray {
        val sortedArray = IntArray(nums.size)

        var evenIndex = 0
        var oddIndex = 1

        for (i in nums.indices) {
            if (nums[i] % 2 == 0) {
                sortedArray[evenIndex] = nums[i]
                evenIndex += 2
            } else {
                sortedArray[oddIndex] = nums[i]
                oddIndex += 2
            }
        }

        return sortedArray
    }
}

fun main() {
    // Input
    val nums = intArrayOf(4, 2, 5, 7)
    // Output
    LeetCode_922().sortArrayByParityII(nums).run {
        println(this.joinToString())
        require(
            intArrayOf(4, 5, 2, 7).contentEquals(this)
        )
    }
}
