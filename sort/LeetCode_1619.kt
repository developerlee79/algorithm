package sort

class LeetCode_1619 {

    fun trimMean(arr: IntArray): Double {
        arr.sort()

        val trimSize = arr.size / 10

        val startIndex = trimSize / 2
        val endIndex = arr.lastIndex - startIndex

        var mean = 0.00

        for (i in startIndex .. endIndex) {
            mean += arr[i]
        }

        return mean / (arr.size - trimSize)
    }
}

fun main() {
    // Input
    val arr = intArrayOf(1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3)
    // Output
    LeetCode_1619().trimMean(arr).run {
        println(this)
        require(2.00000 == this)
    }
}
