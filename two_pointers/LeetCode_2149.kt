package two_pointers

class LeetCode_2149 {

    private fun Int.isPositive() = this >= 0

    fun rearrangeArray(nums: IntArray): IntArray {
        val n = nums.size

        val resultArray = IntArray(n)

        var positiveIndex = 0
        var negativeIndex = 1

        nums.forEach { num ->
            if (num.isPositive()) {
                resultArray[positiveIndex] = num
                positiveIndex += 2
            } else {
                resultArray[negativeIndex] = num
                negativeIndex += 2
            }
        }

        return resultArray
    }
}

fun main() {
    // Input
    val nums = intArrayOf(3, 1, -2, -5, 2, -4)
    // Output
    LeetCode_2149().rearrangeArray(nums).run {
        println(this)
        require(
            intArrayOf(3, -2, 1, -5, 2, -4).contentEquals(this)
        )
    }
}
