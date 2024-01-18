package array

class LeetCode_1151 {

    fun minSwaps(data: IntArray): Int {
        val n = data.size

        val numberOfOne = IntArray(n)
        numberOfOne[0] = data[0]

        for (i in 1 until n) {
            numberOfOne[i] = data[i] + numberOfOne[i - 1]
        }

        val totalOne = numberOfOne[n - 1]

        if (totalOne == 0) {
            return 0
        }

        var i = totalOne - 1
        var minusOne = 0

        var minSwap = Integer.MAX_VALUE

        while (i < n) {
            minSwap = minOf(minSwap, totalOne - numberOfOne[i] + minusOne)

            if (data[i - totalOne + 1] == 1) {
                minusOne++
            }

            i++
        }

        return minSwap
    }
}
