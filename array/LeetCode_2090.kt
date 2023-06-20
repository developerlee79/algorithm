package array

class LeetCode_2090 {

    fun getAverages(nums: IntArray, k: Int): IntArray {
        val n = nums.size
        val averageArray = IntArray(n)

        var prefixSum: Long = 0

        repeat (n) {
            averageArray[it] = -1
            prefixSum += nums[it].toLong()

            if (it >= 2 * k) {
                averageArray[it - k] = (prefixSum / (2 * k + 1)).toInt()
                prefixSum -= nums[it - 2 * k].toLong()
            }
        }

        return averageArray
    }

}

fun main() {
    // Input
    val nums = intArrayOf(7, 4, 3, 9, 1, 8, 5, 2, 6)
    val k = 3
    // Output
    LeetCode_2090().getAverages(nums, k).run {
        println(this.joinToString())
        require(
            intArrayOf(-1, -1, -1, 5, 4, 4, -1, -1, -1).contentEquals(this)
        )
    }
}
