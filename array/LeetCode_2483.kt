package array

class LeetCode_2483 {

    fun bestClosingTime(customers: String): Int {
        val n = customers.length

        val prefixSumArray = IntArray(n + 1)

        var i = n - 1

        while (i >= 0) {
            prefixSumArray[i] = prefixSumArray[i + 1] + if (customers[i] == 'Y') 1 else 0
            i--
        }

        var minIndex = 0
        var minValue = prefixSumArray[0]

        var openPenalty = 0

        for (index in 1 until n + 1) {
            if (customers[index - 1] == 'N') {
                openPenalty++
            }

            val sumOfPenalty = prefixSumArray[index] + openPenalty

            if (sumOfPenalty < minValue) {
                minIndex = index
                minValue = sumOfPenalty
            }
        }

        return minIndex
    }
}

fun main() {
    // Input
    val customers = "YYNY"
    // Output
    LeetCode_2483().bestClosingTime(customers).run {
        println(this)
        require(2 == this)
    }
}
