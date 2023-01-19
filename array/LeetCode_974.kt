package array

class LeetCode_974 {

    fun subArraysDivideByK(nums: IntArray, k: Int): Int {
        val prefixSumMap = hashMapOf<Int, Int>()
        prefixSumMap[0] = 1

        var countOfSubArray = 0
        var prefixSum = 0

        for (num in nums) {
            prefixSum = (prefixSum + num) % k

            if (prefixSum < 0) {
                prefixSum += k
            }

            countOfSubArray += prefixSumMap[prefixSum] ?: 0

            prefixSumMap.merge(prefixSum, 1) { a, b -> a + b }
        }

        return countOfSubArray
    }

}

fun main() {
    // Input
    val nums = intArrayOf(4, 5, 0, -2, -3, 1)
    val k = 5
    // Output
    LeetCode_974().subArraysDivideByK(nums, k).let {
        println(it)
        require(it == 7)
    }
}
