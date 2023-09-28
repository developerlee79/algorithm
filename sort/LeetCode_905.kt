package sort

class LeetCode_905 {

    fun sortArrayByParity(nums: IntArray): IntArray {
        var i = 0

        val sortedArray = IntArray(nums.size)

        for (num in nums) {
            if (num % 2 == 0) {
                sortedArray[i++] = num
            }
        }

        for (num in nums) {
            if (num % 2 != 0) {
                sortedArray[i++] = num
            }
        }

        return sortedArray
    }
}

fun main() {
    // Input
    val nums = intArrayOf(3, 1, 2, 4)
    // Output
    LeetCode_905().sortArrayByParity(nums).run {
        println(this.joinToString())
        require(
            intArrayOf(2, 4, 3, 1).contentEquals(this)
        )
    }
}
