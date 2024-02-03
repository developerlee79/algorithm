package array

class LeetCode_1043 {

    fun maxSumAfterPartitioning(arr: IntArray, k: Int): Int {
        val n = arr.size
        val dp = IntArray(n + 1)

        for (i in arr.indices) {
            var currentMax = 0
            var maximumSum = 0

            val windowStart = maxOf(0, i - k + 1)

            for (j in i downTo windowStart) {
                currentMax = maxOf(currentMax, arr[j])
                maximumSum = maxOf(maximumSum, currentMax * (i - j + 1) + dp[j])
            }

            dp[i + 1] = maximumSum
        }

        return dp.last()
    }
}

fun main() {
    // Input
    val arr = intArrayOf(1, 15, 7, 9, 2, 5, 10)
    val k = 3
    // Output
    LeetCode_1043().maxSumAfterPartitioning(arr, k).run {
        println(this)
        require(84 == this)
    }
}
